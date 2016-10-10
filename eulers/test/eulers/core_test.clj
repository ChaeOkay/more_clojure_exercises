(ns eulers.core-test
  (:require [eulers.core :as core]
            [midje.sweet :refer :all]))

(fact "The letter 'c' has a weight of 3"
  (core/letter_weight \c) => 3)

(fact "The name 'COLIN' has weight of 53"
  (let [name "COLIN"]
    (core/name_weight name) => 53))

(fact "About name_list"
  (fact "The list has 5163 items"
    (count core/name_list) => 5163)
  (fact "The list is alphabetized and only contains chars"
    (nth core/name_list 937) => "COLIN"))

(fact "The accumulated score of the 938th name, COLIN, is 49714"
      (core/name_score "COLIN") => 49714)

(fact "index of colin is 938"
      (+ 1 (.indexOf core/name_list "COLIN")) => 938)

(fact "the total score is 871198282"
  core/total_score => 871198282)
