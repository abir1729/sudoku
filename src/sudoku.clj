(ns sudoku
  (:require [clojure.set :as set]))


(def board identity)


(def sudoku-board
  (board [[5 3 0 0 7 0 0 0 0]
          [6 0 0 1 9 5 0 0 0]
          [0 9 8 0 0 0 0 6 0]
          [8 0 0 0 6 0 0 0 3]
          [4 0 0 8 0 3 0 0 1]
          [7 0 0 0 2 0 0 0 6]
          [0 6 0 0 0 0 2 8 0]
          [0 0 0 4 1 9 0 0 5]
          [0 0 0 0 8 0 0 7 9]]))

(def solved-board
  (board [[5 3 4 6 7 8 9 1 2]
          [6 7 2 1 9 5 3 4 8]
          [1 9 8 3 4 2 5 6 7]
          [8 5 9 7 6 1 4 2 3]
          [4 2 6 8 5 3 7 9 1]
          [7 1 3 9 2 4 8 5 6]
          [9 6 1 5 3 7 2 8 4]
          [2 8 7 4 1 9 6 3 5]
          [3 4 5 2 8 6 1 7 9]]))

(def all-values (set (range 1 10)))

(defn value-at [board coord]
  (let [[x y] coord]
    (get-in board [x y])))

;(value-at sudoku-board [2 2])
;(value-at sudoku-board [0 1]) ;=> 3
;(value-at sudoku-board [0 0]) ;=> 5

(defn has-value? [board coord]
  (let [val (value-at board coord)]
    (not (zero? val))))

;(has-value? sudoku-board [0 0]) ;=> true
;(has-value? sudoku-board [0 2]) ;=> false

(defn row-values [board coord]
  (let [[x y] coord]
    (set (get board x))))

;(row-values sudoku-board [0 2]) ;=> #{0 5 3 7}
;(row-values sudoku-board [3 2]) ;=> #{0 8 6 3}

(defn col-values [board coord]
  (let [[x y] coord]
    (set (reduce (fn [coll row]
              (conj coll (get row y)))
            []
            board))))

;(col-values sudoku-board [0 2]) ;=> #{0 8}
;(col-values sudoku-board [4 8]) ;=> #{3 1 6 0 5 9}

(defn coord-pairs [coords]
    (for [row coords
          col coords]
      [row col]))

;(coord-pairs [0 1])   ;=> [[0 0] [0 1]
                      ;    [1 0] [1 1]]

;(coord-pairs [0 1 2]) ;=> [[0 0] [0 1] [0 2]
                      ;    [1 0] [1 1] [1 2]
                      ;    [2 0] [2 1] [2 2]]
;(mod 5 3)

(defn top-left [coord]
  (let [[x y] coord
        top (* 3 (int (/ x 3)))
        left (* 3 (int (/ y 3)))]
    [top left]))

;(top-left [8 8])
;(conj #{1} 1)

(defn block-coordinates [top-left]
  (let [[x y] top-left
        right (+ 2 y)
        bottom (+ 2 x)]
    (for [x (range x (inc bottom))
          y (range y (inc right))]
      [x y])))

;(block-coordinates [6 6])

(defn block-values-from-top-left [board top-left]
  (let [block-coords (block-coordinates top-left)]
    (reduce (fn [vals coords]
              (let [[x y] coords]
                (conj vals (get-in board [x y]))))
            #{}
            block-coords)))

(defn block-values [board coord]
  (block-values-from-top-left board (top-left coord)))

;(block-values sudoku-board [0 2]) ;=> #{0 5 3 6 8 9}
;(block-values sudoku-board [4 5]) ;=> #{0 6 8 3 2}

(defn valid-values-for [board coord]
  nil)

(defn filled? [board]
  nil)

(defn rows [board]
  nil)

(defn valid-rows? [board]
  nil)

(defn cols [board]
  nil)

(defn valid-cols? [board]
  nil)

(defn blocks [board]
  nil)

(defn valid-blocks? [board]
  nil)

(defn valid-solution? [board]
  nil)

(defn set-value-at [board coord new-value]
  nil)

(defn find-empty-point [board]
  nil)

(defn solve [board]
  nil)
