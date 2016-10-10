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

(def load_names
  "Returns a String containing context of names.txt."
  (slurp "/Users/chae/chae/more_clojure_exercises/eulers/src/eulers/names.txt"))

(def name_list
  "Returns an ISeq of alphabetically sorted names."
  (-> (re-seq #"\w+" load_names)
      sort))

(defn name_score [name]
  (* (+ 1 (.indexOf name_list name)) (name_weight name)))

(def total_score
  (loop [names name_list
         acc 0]
    (if (empty? names)
      acc
      (recur (rest names) (+ acc (name_score (first names)))))))
