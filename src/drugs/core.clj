;;(use 'clojure.java.io)
(require '[clojure.java.io :as io])
(ns drugs.core
  (:gen-class))

(defn to_integer
  "Converts a string to an integer"
  [string]
  (Integer. (re-find  #"\d+" string )))

(defn -extract_dolls [name]
  "Extracts and formats doll data into a vector of hashmaps"
  (let [[doll_name weight value] (clojure.string/split name #"\s+")]
    (def dolls (conj dolls {:name doll_name :weight weight :value value}))
  ))

(defn -readfile [temp]
  "Reads in a file"
  (with-open [fr (io/reader "data.txt")]
    (let [[first-line & other-lines] (doall(line-seq fr))]
      (def max-weight (to_integer first-line))
      (def raw-doll-data other-lines)
      ;(println other-lines)
   )))
  
(defn -main
  [& args]
  (-readfile "data.txt")
  (def dolls [])
  (let [doll_data (map -extract_dolls raw-doll-data)]
    (println doll_data))
 
)
