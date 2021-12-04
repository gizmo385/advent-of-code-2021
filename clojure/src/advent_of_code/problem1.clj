(ns advent-of-code.problem1
  (:require [clojure.string :as s])
  (:gen-class))

(defn -main
  [& args]
  (let [part1 (->> "../inputs/problem1.txt"
                   slurp
                   s/split-lines
                   (map #(Integer/parseInt %))
                   (partition 2 1)
                   (map (fn [[l r]] (if (> r l) 1 0)))
                   (apply +))])
  (printf
    "The answer is: %d\n"
    (->> "../inputs/problem1.txt"
         slurp
         s/split-lines
         (map #(Integer/parseInt %))
         (partition 2 1)
         (map (fn [[l r]] (if (> r l) 1 0)))
         (apply +))))
