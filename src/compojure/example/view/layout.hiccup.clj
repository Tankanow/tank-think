(doctype :html5)
[:html
 [:head
  [:meta {:http-equiv "Content-Type" :content "text/html" :charset "iso-8859-1"}]
  [:title "jooblog"]
  (include-css "/css/style.css")
  (include-js "/javascript/jooblog.js")]
 [:body
  (eval (:template-body joodo.views/*view-context*))
]]
