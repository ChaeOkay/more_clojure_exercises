(ns eulers.core
  (:require [clojure.string :as str]))

(defn name-collection [name]
  "Returns a StringSeq containing lower case chars in a name."
  (seq (str/lower-case name)))

(def alphabet
  "Returns a LazySeq of char letters a to z."
  (let [a (int \a)
        z (inc (int\z))]
    (map char (range a z))))

(defn letter-weight [letter]
  "Returns a Long representing the index + 1 of the given char in the alphabet."
  (+ 1 (.indexOf alphabet letter)))

(defn name-weight [name]
  "Returns a Long representing the sum of each weighted char letter in a name."
  (loop [letters (name-collection name)
         acc 0]
    (if (empty? letters)
      acc
      (recur (rest letters) (+ acc (letter-weight (first letters)))))))

(def load-names
  "Returns a String containing context of names.txt."
  (slurp "doc/names.txt"))

(def name-list
  "Returns an ISeq of alphabetically sorted names."
  (-> (re-seq #"\w+" load-names)
      sort))

(defn name-score [name]
  (* (+ 1 (.indexOf name-list name)) (name-weight name)))

(def total-score
  (loop [names name-list
         acc 0]
    (if (empty? names)
      acc
      (recur (rest names) (+ acc (name-score (first names)))))))
