(defproject compojure-example "0.1.0"
  :description "Example Compojure project"
  :dependencies [[org.clojure/clojure "1.4.0"]
                 [compojure "1.1.1"]
                 [hiccup "1.0.0"]
                 [joodo "1.0.0" :excludes [hiccup]]]
  :plugins [[lein-ring "0.7.1"]]

  :min-lein-version "2.0.0"

  :ring {:handler compojure.example.routes/app})
