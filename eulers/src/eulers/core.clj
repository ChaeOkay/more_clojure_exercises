(ns eulers.core
  (:require [clojure.string :as str]))

(def alphabet
  "Returns a LazySeq of char letters a to z."
  (let [a (int \a)
        z (inc (int\z))]
    (map char (range a z))))

(def names
  "Returns an ISeq of alphabetically sorted names."
  (->> "doc/names.txt"
       slurp
       (re-seq #"\w+")
       sort))

(defn name-letters [name]
  "Returns a StringSeq containing lower case chars in a name."
  (seq (str/lower-case name)))

(defn index-plus-one [item collection]
  "Adds one to the index of a given item within a collection."
  (+ 1 (.indexOf collection item)))

(defn name-weight [name]
  "Returns a Long representing the sum of each weighted char letter in a name."
  (loop [letters (name-letters name)
         acc 0]
    (if (empty? letters)
      acc
      (recur (rest letters) (+ acc (index-plus-one (first letters) alphabet))))))

(defn name-score [name]
  "Returns a Long that is the name index multiplied by its weight."
  (* (index-plus-one name name-list) (name-weight name)))

(def total-score
  "Returns the sum of all name-scores."
  (loop [names' names
         acc 0]
    (if (empty? names')
      acc
      (recur (rest names') (+ acc (name-score (first names')))))))
