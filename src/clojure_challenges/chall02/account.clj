(defn make-account [] (atom 0 :validator integer?))

(defn balance [acc] (deref acc))

(defn deposit [acc amt] (swap! acc + amt) acc)

(defn withdraw [acc amt] (swap! acc - amt) acc)

;(println (-> (make-account) (deposit 10) (withdraw 6) balance))
;(println (-> (make-account) (deposit 10) (withdraw 0.5) balance))