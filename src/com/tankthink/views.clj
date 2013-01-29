(ns com.tankthink.views
  (:use [hiccup core page]
        [joodo.views :only (render-template)]
        [clojure.string :as string :refer [split]]))

(def ^{:private true} current-path
  (. (java.io.File. ".") getCanonicalPath))

(def ^:dynamic blog-post-directory
    (clojure.java.io/file (str current-path "/src/com/tankthink/view/blog/post/date")))

(defn- post-parts 
  "doc-string"
  [post-file-name]
  (string/split post-file-name #"(\.)|(_)"))

(defn- post-link
  ""
  [post-file-name]
  (str "blog/date/" (first (post-parts post-file-name))))

(defn- post-name
  ""
  [post-file-name]
  (str (first (post-parts post-file-name))))

(defn- blog-post-filenames 
  "doc-string"
  []  
  (map 
    #(.getName %)
    (remove
        #(.isDirectory %)
        (file-seq blog-post-directory))))

(defn- blog-post-filenames-orderby-recent
  ""
  []
  (reverse (blog-post-filenames)))

(defn- blog-post-exists? [post-route]
    (some #(= % (str post-route ".hiccup")) (blog-post-filenames)))

;; Public Methods

(defn find-blog-post [date]
  (if (blog-post-exists? date)
      (render-template (str  "/blog/post/date/" date) :template-root "com/tankthink/view")
      (html5
        [:body
         [:p "Not Found"]])))

(defn index-page []
  (html5
    [:head
      [:title "Tank Think"]
      (include-css "/css/style.css")]
    [:body
      [:header 
      [:h1 "Tank Think"]]
      [:section
        [:header
          [:h1 "Blog Posts"]]
          (for [current-post-filename (blog-post-filenames-orderby-recent)]
           (list [:p 
                   [:a {:href (post-link current-post-filename)}
                     (post-name current-post-filename)]]))]]))
