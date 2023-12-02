(ns day01-1 
  (:require [clojure.string :as str]))

(defn getInput []
  (str/split-lines (slurp "data/day01.txt")))

(defn getCalibration [s]
  (def matches (re-seq #"\d" s))
  (Integer/parseInt (str (first matches) (last matches))))

(apply + (map getCalibration (getInput)))