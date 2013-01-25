(ns compojure.example.views
  (:use [hiccup core page]
        [joodo.views :only (render-template)]))

(def ^{:private true} current-path
  (. (java.io.File. ".") getCanonicalPath))

(def ^:dynamic blog-post-directory
    (clojure.java.io/file (str current-path "/src/compojure/example/view/")))

(defn blog-post-filenames 
  "doc-string"
  []  
  (map 
    #(.getName %)
    (remove
        #(.isDirectory %)
        (file-seq blog-post-directory))))

(defn- test-thunk []
  (println (blog-post-filenames)))

(defn- blog-post-exists? [post-route]
    (some #(= % (str post-route ".hiccup")) (blog-post-filenames)))

(defn find-blog-post [date]
  (if (blog-post-exists? date)
      (render-template date :template-root "compojure/example/view")
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
          (for [current-post-filename (blog-post-filenames)]
           (list [:p current-post-filename]))
        ]]))
