(ns com.tankthink.views
  (:use [com.tankthink.postutils]
        [hiccup core page]
        [joodo.views :only (render-template)]
        [clojure.string :as string :refer [split]]))


(defn index-page 
  "Render the index page."
  []
  (html5
    [:head
      [:title "Tank Think"]
      (include-css "/css/style.css")]
    [:body
      [:header 
      [:h1 "Tank Think"]
      [:aside "You can view this site's " 
        [:a {:href "https://github.com/Tankanow/tank-think" } "src on Github"]]]
      [:section
        [:header
          [:h1 "Blog Posts"]]
          (for [current-post-filename (blog-post-filenames-orderby-recent)]
           (list [:p 
                   [:a {:href (post-link current-post-filename)}
                     (post-name current-post-filename)]]))]]))
