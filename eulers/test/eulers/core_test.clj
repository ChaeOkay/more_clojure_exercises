(ns eulers.core-test
  (:require [eulers.core :as core]
            [midje.sweet :refer :all]))

(fact "the letter a has a weight of 1"
  (core/letter_weight \a) => 1)

(fact "example name 'COLIN' has a weight of 53"
  (let [name "COLIN"]
    (core/name_weight name) => 53))
