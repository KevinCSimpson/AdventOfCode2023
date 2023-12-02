(ns day01-2 
  (:require [clojure.string :as str]))

(defn get-input []
  (str/split-lines (slurp "data/day01.txt")))

(defn string-to-digit [s]
  (case s
    "one" "1"
    "two" "2"
    "three" "3"
    "four" "4"
    "five" "5"
    "six" "6"
    "seven" "7"
    "eight" "8"
    "nine" "9"
    s))

(defn find-digit [s fir]
  (def pat (re-pattern (str "^.*"
                            (if fir "?" "")
                            "(one|two|three|four|five|six|seven|eight|nine|\\d).*"
                            (if (not fir) "?" "")
                            "$")))
  (def mat (re-matcher pat s)) 
  (string-to-digit(nth (re-find mat) 1)))

(defn get-calibration [s]
  (Integer/parseInt (str (find-digit s true) (find-digit s false))))

(apply + (map get-calibration (get-input)))