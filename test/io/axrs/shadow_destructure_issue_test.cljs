(ns io.axrs.shadow-destructure-issue-test
  (:require
    [cljs.test :refer-macros [deftest testing is]]))

(deftest destructure-test
  (let [f (fn [& [a b]]
            (prn a b)
            a)]
    (is (nil? (f nil)))
    (is (= 1 (f 1)))
    (is (= 1 (f 1 2))))
  (let []))
(cljs.test/run-tests)
