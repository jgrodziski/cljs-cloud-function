(ns clj.new.cljs-cloud-function
  (:require [clj.new.templates :refer [renderer project-name name-to-path ->files
                                       multi-segment sanitize-ns]]))

(def render (renderer "cljs-cloud-function"))

(defn cljs-cloud-function
  "Generate project targeting Google Cloud Function service (no Java, so we use the NodeJS runtime)"
  [name]
  (let [data {:name (project-name name)
              :sanitized (name-to-path name)
              :root-ns (multi-segment (sanitize-ns name))}]
    (println "Generating fresh 'clj new' cljs-cloud-function project.")
    (->files data
             ["deps.edn" (render "deps.edn" data)]
             ["package.json" (render "package.json" data)]
             ["shadow-cljs.edn" (render "shadow-cljs.edn" data)]
             ["README.md" (render "README.md" data)]
             ["build.sh" (render "build.sh" data) :executable true]
             ["deploy.sh" (render "deploy.sh" data) :executable true]
             ["src/{{sanitized}}/foo.cljs" (render "foo.cljs" data)])))
