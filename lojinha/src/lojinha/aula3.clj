(ns lojinha.aula3
  (:require [lojinha.db :as l.db]))

;(println (l.db/todos-os-pedidos))

;(println (group-by :usuario (l.db/todos-os-pedidos)))

(defn minha-funcao-de-agrupamento
  [elemento]
  (println "elemento" elemento)
  (:usuario elemento))

;(println (group-by minha-funcao-de-agrupamento (l.db/todos-os-pedidos)))

;(println (vals (group-by :usuario (l.db/todos-os-pedidos))))

;(println (count (vals (group-by minha-funcao-de-agrupamento (l.db/todos-os-pedidos)))))

;(println (map count (vals (group-by minha-funcao-de-agrupamento (l.db/todos-os-pedidos)))))

; usando o thread last
; (->> (l.db/todos-os-pedidos)
;     (group-by :usuario)
;     vals
;     (map count)
;     println)

;retorna só count de pedidos
(defn conta-total-por-usuario
  [[usuario, pedidos]]
  (count pedidos))

;retorna id do usuario e count do pedido
(defn conta-total-por-usuario
  [[usuario, pedidos]]
  [usuario (count pedidos)])

;retorna um map com key e value
(defn conta-total-por-usuario
  [[usuario, pedidos]]
  {:usuario-id       usuario,
   :total-de-pedidos (count pedidos)})


; define um total de pedidos
(println "PEDIDOS")

(defn total-do-item
  [[_ detalhes]]
  (* (get detalhes :quantidade 0) (get detalhes :preco-unitario 0)))

(defn total-do-pedido
  [pedido]
  (->> pedido
       (map total-do-item)
       (reduce +)))

(defn total-dos-pedidos
  [pedidos]
  (->> pedidos
       (map :itens)
       (map total-do-pedido)
       (reduce +)))

(defn quantidade-de-pedidos-e-gasto-total-por-usuario
  [[usuario, pedidos]]
  {:usuario-id       usuario
   :total-de-pedidos (count pedidos)
   :preco-total      (total-dos-pedidos pedidos)})

(->> (l.db/todos-os-pedidos)
     (group-by :usuario)
     (map quantidade-de-pedidos-e-gasto-total-por-usuario)
     println)