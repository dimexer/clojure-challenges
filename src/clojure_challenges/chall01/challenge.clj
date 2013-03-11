(defn histogram [xs]
  (let [occurs (group-by identity xs)]
    (vec (for [x (range 0 (+ (last xs) 1))]
      (if (nil? (occurs x)) 0 (count (occurs x)))))))

;(println (histogram [0 0 0 1 1 3 3]))
;(println "-----------------")
;(println (histogram [0]))
;(println "-----------------")
;(println (histogram [0 0 0 0 0 0 10 10 10 10]))