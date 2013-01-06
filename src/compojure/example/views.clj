(ns compojure.example.views
  (:use [hiccup core page]))

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
        [:article
          [:header
            [:h1 "Post 1"]]
          [:p "This is my first post"]]]]
      ))
