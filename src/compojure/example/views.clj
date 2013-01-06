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
            [:h1 "2013-01-05: First Post"]]
          [:section.intro
            [:p "This is my new website.  It's funny to think that the old atankanow.com (I'm sure you 
            can find it somewhere in Google's cache) was an aesthetically busier site with images and
            links across the top and side, comprising lots of bad php code and html; my new
            and improved site is lacking in content and code.  I like to think that it is 
            " [:em "pragmatically barren"]"."]]
          [:section.body
            [:p "I realized recently that it was time to update my site to accurately reflect my current
            interests.  Oddly enough, as I go back and navigate my site, it's not too bad - just that I had 
            no interest in web programming at the time and now I am zealous about the web.  Furthermore,
            I wanted to encorporate learning Clojure into my site, which is why this site is built on "
              [:a {:href "https://github.com/ring-clojure/ring"} "Ring"] ", "
              [:a {:href "https://github.com/weavejester/compojure"} "Compojure"] " and "
              [:a {:href "https://github.com/weavejester/hiccup"} "Hiccup"] " and deployed to "
              [:a {:href "https://www.heroku.com"} "Heroku"] "."]]]]]))
