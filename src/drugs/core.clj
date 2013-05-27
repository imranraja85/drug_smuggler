(ns drugs.core
  (:require clojure.java.io)
  (:gen-class))

(defn to_integer
  "Converts a string to an integer"
  [string]
  (Integer. (re-find  #"\d+" string ))
)

(defn extract_dolls [name]
  "Extracts and formats doll data into a vector of hashmaps"
  (let [[doll_name weight value] (clojure.string/split name #"\s+")]
    (def dolls (conj dolls {:name doll_name :weight (to_integer weight) :value (to_integer value)}))
  )
)

(defn read-file [filename]
  "Reads a file and extracts the maximum weight and doll records"
  (with-open [fr (clojure.java.io/reader filename)]
    (let [[first-line & other-lines] (doall(line-seq fr))]
      (def dolls [])
      (doall(map extract_dolls other-lines))
      [(to_integer first-line)]
    )
  )
)

(defn package-drugs [weight-limit dolls]
  (cond
    (zero? (count dolls))
    [0 dolls]
    :else
    (let [current-doll (first dolls)
          rest-of-dolls (rest dolls)]
      (cond
        (> (:weight current-doll) weight-limit)
        (package-drugs weight-limit rest-of-dolls)
        :else
        (let [take-doll-weight (package-drugs (- weight-limit (:weight current-doll)) rest-of-dolls)
              take [(+ (:value current-doll) (first take-doll-weight)) (conj (last take-doll-weight) current-doll)]
              dont-take (package-drugs weight-limit rest-of-dolls)]
          (max-key first take dont-take)
        )
      )
    )
  )
)

(defn print-row
  [doll]
  (println "")
  (print (format "%-10s" (:name doll)))
  (print (format "%5d"   (:weight doll)))
  (print (format "%5d"   (:value doll)))
)

(defn print-results 
  [resulting-dolls]
  (println "packed dolls:\n\n")
  (println "name      weight value")
  (doall(map print-row resulting-dolls))
)

(defn -main
  [& args]
  (let [filename (first args)
        [max-weight] (read-file filename)]
       (print-results(last (package-drugs max-weight dolls)))
  )
)
