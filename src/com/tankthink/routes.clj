(ns com.tankthink.routes
  (:use compojure.core
        com.tankthink.views
        [hiccup.middleware :only (wrap-base-url)])
  (:require [compojure.route :as route]
            [compojure.handler :as handler]
            [compojure.response :as response]))

(defn get-blog-post [date]
  (or (find-blog-post date)
      (route/not-found "Blog post not found")))

(defroutes main-routes
  (GET "/" [] (index-page))
  (GET "/blog/date/:date" [date] (get-blog-post date))
  (route/resources "/")
  (route/not-found "Page not found"))


(def app
  (-> (handler/site main-routes)
      (wrap-base-url)))
