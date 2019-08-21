(ns {{root-ns}}.foo
  (:require
     [cljs-bean.core :refer [bean ->clj ->js]]))

(defn {{name}} [req res]
  (println "Function invoked with request:" (str (->clj req)))
  (.send res (str "Hello World!")))

(def exports #js {:{{name}} {{name}}})
