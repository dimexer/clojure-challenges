(defn histogram [xs]
  (let [occurs (group-by identity xs)]
    (vec (for [x (range 0 (+ (apply max xs) 1))]
      (if (nil? (occurs x)) 0 (count (occurs x)))))))
