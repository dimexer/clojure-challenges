(defn histogram [xs]
  (let [occurs (group-by identity xs)]
    (vec (for [x (range 0 (inc (apply max xs)))]
      (count (occurs x []))))))
