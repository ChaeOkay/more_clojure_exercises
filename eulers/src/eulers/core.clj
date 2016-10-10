(ns eulers.core
  (:require [clojure.string :as str]))

(defn name_collection [name]
  "Returns a StringSeq containing lower case chars in a name."
  (seq (str/lower-case name)))

(def alphabet
  "Returns a LazySeq of char letters a to z."
  (let [a (int \a)
        z (inc (int\z))]
    (map char (range a z))))

(defn letter_weight [letter]
  "Returns a Long representing the index + 1 of the given char in the alphabet."
  (+ 1 (.indexOf alphabet letter)))

(defn name_weight [name]
  "Returns a Long representing the sum of each weighted char letter in a name."
  (loop [letters (name_collection name)
         acc 0]
    (if (empty? letters)
      acc
      (recur (rest letters) (+ acc (letter_weight (first letters)))))))

(def names
  "Returns a String containing context of names.txt."
  (slurp "/Users/chae/chae/more_clojure_exercises/eulers/src/eulers/names.txt")
)

(def name_list
  "Returns a vector of names separated by commas."
  (str/split names #","))
