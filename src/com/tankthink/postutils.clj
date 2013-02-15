(ns com.tankthink.postutils
  (:use [hiccup core page]
        [joodo.views :only (render-template)]
        [clojure.string :as string :refer [split]]))

(def ^{:private true} current-path
  (. (java.io.File. ".") getCanonicalPath))

(def ^:dynamic blog-post-directory
    (clojure.java.io/file (str current-path "/src/com/tankthink/view/blog/post/date")))

(defn post-parts 
  "Return a list of the parts of the given post name split by .|_"
  [post-file-name]
  (string/split post-file-name #"(\.)|(_)"))

(defn post-link
  "Return the relative link to the given post"
  [post-file-name]
  (str "blog/date/" (first (post-parts post-file-name))))

(defn post-name
  "Return the post name from the given post filename"
  [post-file-name]
  (str (first (post-parts post-file-name))))

(defn- blog-post-filenames 
  "Return a list of all of the posts in the blog-post-directory"
  []  
  (map 
    #(.getName %)
    (remove
        #(.isDirectory %)
        (file-seq blog-post-directory))))

(defn blog-post-filenames-orderby-recent
  "Return a list of the blog posts in the blog-post-directory ordered by recency"
  []
  (sort-by
    #(Integer/parseInt (first (post-parts %)))
    >
    (blog-post-filenames)))

(defn- blog-post-exists? 
	"Return true if the given post exists; false otherwise"
	[post-route]
    (some #(= % (str post-route ".hiccup")) (blog-post-filenames)))


(defn find-blog-post 
  "Render the given blog post if it exists"
  [date]
  (if (blog-post-exists? date)
      (render-template (str  "/blog/post/date/" date) :template-root "com/tankthink/view")
      (html5
        [:body
         [:p "Not Found"]])))