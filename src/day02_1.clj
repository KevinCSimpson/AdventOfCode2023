(ns day02-1 
  (:require [clojure.string :as str]))

(defrecord cube-set [red green blue])

(defrecord game [id cube-sets])

(defn get-input []
  (str/split-lines (slurp "data/day02.txt")))

(defn get-cube-count-by-color [s color]
  (let [cube-by-color-regex (re-pattern (str ".*(?:^|, )(\\d+) " color "(?:$|,).*")) 
        mats (re-matches cube-by-color-regex s)] 
    (if (nil? mats) 0 (parse-long (nth mats 1)))))

(defn get-cube-set [s]
  (cube-set. (get-cube-count-by-color s "red") (get-cube-count-by-color s "green") (get-cube-count-by-color s "blue")))

(defn get-cube-sets [s]
  (map get-cube-set (str/split s #"; ")))

(defn get-game [s]
  (let [game-regex #"^Game (\d+): (.*)$" 
        mats (re-matches game-regex s)] 
    (game. (parse-long (nth mats 1)) (get-cube-sets (nth mats 2)))))

(defn valid-set? [cs]
  (and 
   (<= (:red cs) 12) 
   (<= (:green cs) 13)
   (<= (:blue cs) 14)))

(defn valid-game? [g]
  (every? valid-set? (:cube-sets g)))

(defn valid-games [gs]
  (remove #(not (valid-game? %)) gs))

(defn solve []
  (apply + (map #(:id %) (valid-games (map get-game (get-input))))))

(solve)