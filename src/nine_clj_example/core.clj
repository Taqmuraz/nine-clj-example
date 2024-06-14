(ns nine-clj-example.core
  (:gen-class)
  (:require
    [nine-clj.core :as nine]
  )
)

(defn -main [& args]
  (nine/-main args)
)
