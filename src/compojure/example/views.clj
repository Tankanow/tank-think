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
            [:h1 "2013-01-06: Quick Nightcap"]]
          [:section.body
            [:p "I recently finished reading "
              [:a {:href "http://www.amazon.com/Moonwalking-Einstein-Science-Remembering-Everything/dp/0143120530/ref=sr_1_1?ie=UTF8&qid=1357522465&sr=8-1&keywords=moonwalking+with+einstein"} "Moonwalking with Einstein"] 
              ".  It is a fascinating overview into the power of the mind and memory.  I also came 
              across a neat "
              [:a {:href "https://sivers.org/srs"} "post"] 
              " today regarding memorizing new programming languages.  I hope to
              combine the powers of these two approaches into something more as I learn Clojure."]]]
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
