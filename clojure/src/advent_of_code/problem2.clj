(ns advent-of-code.problem2
  (:require [clojure.string :as s])
  (:gen-class))

(defn file->commands
  [f]
  (->> "../inputs/problem2-part1.txt"
       slurp
       s/split-lines
       (map (fn [cmd]
              (let [[dir delta] (s/split cmd #"\s+")]
                [dir (Integer/parseInt delta)])))))

(defn -main
  [& args]
  (let [commands (file->commands "../inputs/problem2-part1.txt")
        part1 (->> commands
                   (reduce
                     (fn [[position depth] [cmd delta]]
                       (condp = cmd
                         "forward" [(+ position delta) depth]
                         "down" [position (+ depth delta)]
                         "up" [position (- depth delta)]))
                     [0 0])
                   (apply *))
        part2 (->> commands
                   (reduce
                     (fn [[position depth aim] [cmd delta]]
                       (condp = cmd
                         "forward" [(+ position delta) (+ depth (* aim delta)) aim]
                         "down" [position depth (+ aim delta)]
                         "up" [position depth (- aim delta)]))
                     [0 0 0])
                   (take 2)
                   (apply *))]
    (printf "Part 1: %d\nPart2: %d\n" part1 part2)))
