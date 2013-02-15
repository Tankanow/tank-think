(ns com.tankthink.postutilsspec
	(:use midje.sweet
		  com.tankthink.postutils)
  )

(fact 
	(blog-post-filenames-orderby-recent) 
	=> 
	'("20130203.hiccup" "20130126.hiccup" 
      "20130125.hiccup" "20130121.hiccup" 
      "20130106.hiccup" "20130105.hiccup"))

(fact
	(post-parts "20130101.hiccup")
	=>
	'("20130101" "hiccup"))


(fact
	(post-link "20130101.hiccup")
	=>
	"blog/date/20130101")


(fact
	(post-name "foobar.hiccup")
	=>
	"foobar")