(ns clojure-challenges.chall01.sample-test
  (:use clojure.test))

(load-file "src/clojure_challenges/chall01/histogram.clj")

(deftest sample-test
  (testing "histogram"
      (is (= [1 2 3] (histogram [0 1 1 2 2 2])))
      (is (= [1] (histogram [0])))
      (is (= [4 0 0 2] (histogram [0 0 0 0 3 3])))
      (is (= [0 1 1 1] (histogram [1 2 3])))
      (is (= [0 1 1 1] (histogram [3 1 2])))
      (is (= (vec (repeat 1000001 1)) (histogram (range 0 1000001))))))

(run-tests)
