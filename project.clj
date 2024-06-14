(defproject nine-clj-example "0.1.0-SNAPSHOT"
  :description "nine-clj library use example"
  :url "https://github.com/Taqmuraz/nine-clj-example"
  :license { :name "MIT License" :url "https://opensource.org/licenses/MIT" }
  :dependencies
  [
    [org.clojars.taqmuraz/nine-clj "0.1"]
    [org.clojure/clojure "1.10.0"]
  ]
  :main ^:skip-aot nine-clj-example.core
  :target-path "target/%s"
  :profiles {:uberjar {:aot :all}}
)