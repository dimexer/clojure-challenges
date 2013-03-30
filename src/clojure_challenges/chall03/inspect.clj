(defn one-arg-func?
  [f]
  (some #(= (count %) 1) (:arglists (meta f))))

(defn pos-for-each?
  [func args]
  (println (class args))
  (every? pos? (map func args)))

(defn pos-one-arg-func?
  [f vals]
  (and (one-arg-func? f) (pos-for-each? (deref f) vals) ))

(defn inspect
  [ns]
  (let [interest (for [[x y] (ns-map ns)
                       :when (:interesting (meta y))] y)]
    (let [interest-derrefed (map deref interest)
          integrs (filter integer? interest-derrefed)
          funcs (filter #(fn? (deref %)) interest)]
    {:integers (set integrs)
     :strings (set (filter string? interest-derrefed))
     :vectors (set (filter vector? interest-derrefed))
     :funcs (set (map #(:name (meta %)) funcs))
     :positive (set (map #(:name (meta %)) (filter #(pos-one-arg-func? % integrs) funcs)))})))

(def ^:interesting answer 42)
(defn ^:interesting foo [x] (inc x))
(defn ^:interesting foo2 [x y] (+ x y))
(def bar 43)
(def ^:interesting vvec [1 2 3 4 5])
(def a 10)

(print (inspect *ns*))