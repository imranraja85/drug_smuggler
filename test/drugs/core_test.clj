(ns drugs.core-test
  (:require [clojure.test :refer :all]
            [drugs.core :refer :all]))

(deftest string_converts_to_integer
  (testing "Covert a string to an integer"
    (is (instance? Integer (to_integer "400")))))

(deftest read-file-extracts-max-weight-and-records
  (let[[max-weight] (read-file "data.txt")]
    (is (= max-weight 400))      
    (is (= (count dolls) 22))
    (is (= (:name (first dolls)) "luke"))
    (is (= (:weight (first dolls)) 9))
    (is (= (:value (first dolls)) 150))
  )
)

(deftest read-file-extracts-max-weight-and-records
  (let[[max-weight] (read-file "test/drugs/test_data.txt")]
    (is (= max-weight 100))      
    (is (= (count dolls) 3))
    (is (= (:name (first dolls)) "luke"))
    (is (= (:weight (first dolls)) 9))
    (is (= (:value (first dolls)) 150))
  )
)

(deftest package-drugs-computation
  (let[[max-weight] (read-file "test/drugs/test_data.txt")
       [value selected-dolls] (package-drugs max-weight dolls)]
    (is (= (count selected-dolls) 2))
    (is (= (:name (first selected-dolls)) "luke"))
    (is (= (:weight (first selected-dolls)) 9))
    (is (= (:value (first selected-dolls)) 150))
    (is (= (:name (last selected-dolls)) "anthony"))
    (is (= (:weight (last selected-dolls)) 13))
    (is (= (:value (last selected-dolls)) 35))
  )
)

(deftest package-drugs-computation-small-maximum-weight
  (let[[max-weight] (read-file "test/drugs/test_data_2.txt")
       [value selected-dolls] (package-drugs max-weight dolls)]
    (is (= (count selected-dolls) 0))
  )
)
