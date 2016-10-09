(ns eulers.core
  (:require [clojure.string :as str]))

(defn name_collection [name]
  "returns a sequence of lower case chars in a name"
  (seq (str/lower-case name)))

(def alphabet
  "range of letters a to z"
  (let [a (int \a)
        z (inc (int\z))]
    (map char (range a z))))

(defn letter_weight [letter]
  "It returns the index + 1 of a letter in the alphabet"
  (+ 1 (.indexOf alphabet letter)))

(defn name_weight [name]
  "Returns the total value of each letter in a name"
  (loop [letters (name_collection name)
         acc 0]
    (if (empty? letters)
      acc
      (recur (rest letters) (+ acc (letter_weight (first letters)))))))
