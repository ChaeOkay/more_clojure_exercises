(ns eulers.core-test
  (:require [eulers.core :as core]
            [midje.sweet :refer :all]))

(fact "The letter 'c' has a weight of 3"
  (core/letter-weight \c) => 3)

(fact "The name 'COLIN' has weight of 53"
  (let [name "COLIN"]
    (core/name-weight name) => 53))

(fact "About name-list"
  (fact "The list has 5163 items"
    (count core/name-list) => 5163)
  (fact "The list is alphabetized and only contains chars"
    (nth core/name-list 937) => "COLIN"))

(fact "The index of COLIN is 938"
      (+ 1 (.indexOf core/name-list "COLIN")) => 938)

(fact "The score of the 938th name, COLIN, is 49714"
      (core/name-score "COLIN") => 49714)

(fact "The total score is 871198282"
  core/total-score => 871198282)
