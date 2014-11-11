;; 8-Queens solver
;; see) http://newral.info/publics/index/79
;;      colum No.14 - No.19

(def board-size 8)

(defn on-board? [[row col]]
  (and (>= row 1) (<= row board-size) (>= col 1) (<= col board-size)))

(defn unique-row? [[row _] queens]
  (every?  #(not= row (first %)) queens))

(defn unique-col? [[_ col] queens]
  (every?  #(not= col (second %)) queens))

(defn unique-up? [[row col] queens]
  (every?  #(not= (+ row col) (+ (first %) (second %))) queens))

(defn unique-down? [[row col] queens]
  (every?  #(not= (- row col) (- (first %) (second %))) queens))

(defn valid-queen? [pos queens]
  (and (unique-row? pos queens)
       (unique-col? pos queens)
       (unique-up? pos queens)
       (unique-down? pos queens)))

(defn check-col [[row col :as pos] queens]
  (if (not (on-board? pos)) nil
      (if (valid-queen? pos queens)
        (cons pos queens)
        (recur (list row (inc col)) queens))))

(defn check-row [[row col :as pos] queens]
  (if (not (on-board? pos)) queens
      (let [newqueens (check-col pos queens)]
        (if newqueens
          (recur (list (inc row) 1) newqueens)
          (let [[row col] (first queens)]
            (recur (list row (inc col)) (rest queens)))))))

(defn goal? [queens]
  (= board-size (count queens)))

(defn answer []
  (reverse 
   (loop [[row col :as startpos] '(1 1)]
     (if (not (on-board? startpos)) nil
         (let [queens (check-row startpos nil)]
           (if (goal? queens) queens
               (recur (list 1 (inc col)))))))))
