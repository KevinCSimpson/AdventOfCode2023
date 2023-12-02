(ns day01-1 
  (:require [clojure.string :as str]))

(defn get-input []
  (str/split-lines (slurp "data/day01.txt")))

(defn get-calibration [s]
  (def matches (re-seq #"\d" s))
  (Integer/parseInt (str (first matches) (last matches))))

(apply + (map get-calibration (get-input)))