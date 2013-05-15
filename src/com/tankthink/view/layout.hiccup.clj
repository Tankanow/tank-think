(doctype :html5)
[:html
 [:head
  [:meta {:http-equiv "Content-Type" :content "text/html" :charset "iso-8859-1"}]
  [:title "Tank Thinks ..."]
  (include-css "/css/style.css")]
 [:body
  (eval (:template-body joodo.views/*view-context*))
]]
