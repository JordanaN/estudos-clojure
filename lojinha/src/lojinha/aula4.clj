(ns lojinha.aula4
  (:require [lojinha.db :as l.db]
            [lojinha.logic :as l.logic]))

(println (l.db/todos-os-pedidos))

(let [pedidos (l.db/todos-os-pedidos),
      resumo (l.logic/resumo-por-usuario pedidos)]
  (println "Resumo" resumo)
  (println "Ordenado" (sort-by :preco-total resumo))
  (println "Reverse" (reverse (sort-by :preco-total resumo)))
  (println "Ordenado por ID" (sort-by :usuario-id resumo))
  ;update-in, assoc-in
  (println (get-in pedidos [0 :itens, :mochila, :quantidade])))

(defn resumo-por-usuario-ordenado [pedidos]
  (->> pedidos
       l.logic/resumo-por-usuario
       (sort-by :preco-total)
       reverse))

(let [pedidos (l.db/todos-os-pedidos),
      resumo (resumo-por-usuario-ordenado pedidos)]
  (println "Resumo" resumo)
  (println "Primeiro" (first resumo))
  (println "Segundo" (second resumo))
  (println "Resto" (rest resumo))
  (println "Total" (count resumo))
  (println "Class" (class resumo))
  (println "nth 1" (nth resumo 1))
  (println "get 1" (get resumo 1)) ;devolve nil pq nao tem um vetor e sim uma lista
  (println "Take" (take 2 resumo)))

(defn top-2 [resumo]
  (take 2 resumo))

(let [pedidos (l.db/todos-os-pedidos),
      resumo (resumo-por-usuario-ordenado pedidos)]
  (println "> 500 =>" (filter #(> (:preco-total %) 500) resumo))
  (println "> 500 filter, empty, not =>" (not (empty? (filter #(> (:preco-total %) 500) resumo))))
  (println "> 500 some =>" (some #(> (:preco-total %) 500) resumo))
  )