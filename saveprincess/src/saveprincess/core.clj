(ns saveprincess.core)

(defn grid-position-of
  [c coll]
  (let [indexed (map-indexed vector coll)
        [y row] (first (filter (fn [[idx v]] (some #(= % c) v)) indexed))
        indexed-row (map-indexed vector row)
        [x _] (first (filter (fn [[idx v]] (= c v)) indexed-row))]
    [x y]))

(defn displayPathtoPrincess [m grid]
  (let [[px py] (grid-position-of \p grid)
        [bx by] (grid-position-of \m grid)
        [dx dy] [(- px bx) (- py by)]
        [mx my] [(if (pos? dx) "RIGHT" "LEFT") (if (pos? dy) "DOWN" "UP")]]
     (println 
       (clojure.string/join 
         "\n" 
         (concat 
           (repeat (Math/abs dx) mx) 
           (repeat (Math/abs dy) my))))))
      
(defn main []
  (let [m (Integer/parseInt (read-line))
        grid (doall (take m (map #(seq (.toCharArray %)) (repeatedly #(read-line)))))]
    (displayPathtoPrincess m grid)))


(println "Foo")








