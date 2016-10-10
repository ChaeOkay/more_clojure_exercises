(ns eulers.core-test
  (:require [eulers.core :as core]
            [midje.sweet :refer :all]))

(fact "The letter 'a' has a weight of 1"
  (core/letter_weight \a) => 1)

(fact "The name 'COLIN' has weight of 53"
  (let [name "COLIN"]
    (core/name_weight name) => 53))

(fact "About name_list"
  (fact "The list has 5163 items"
    (count core/name_list) => 5163)
  (fact "A name contains only chars"
    (first core/name_list) => "MARY"))
