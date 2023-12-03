(ns day01-1 
  (:require [clojure.string :as str]))

(defn get-input []
  (str/split-lines (slurp "data/day01.txt")))

(defn get-calibration [s]
  (let [matches (re-seq #"\d" s)] 
    (parse-long (str (first matches) (last matches)))))

(apply + (map get-calibration (get-input)))