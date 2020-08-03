(ns lojinha.aula5
  (:require [lojinha.db :as l.db]
            [lojinha.logic :as l.logic]))

(defn gastou-bastante? [info-do-usuario]
  (> (:preco-total info-do-usuario) 500))

(let [pedidos (l.db/todos-os-pedidos),
      resumo (l.logic/resumo-por-usuario pedidos)]
  (println "Keep" (keep gastou-bastante? resumo))
  (println "Filter" (filter gastou-bastante? resumo)))

(println "\n\nTentando entender dentro do keep e do filter")

(defn gastou-bastante? [info-do-usuario]
  (println "gastou-bastante?" (:usuario-id info-do-usuario))
  (> (:preco-total info-do-usuario) 500))

(let [pedidos (l.db/todos-os-pedidos),
      resumo (l.logic/resumo-por-usuario pedidos)]
  (println "Keep" (keep gastou-bastante? resumo)))

(println "\n\nValos isolar")

;LAZY
(println (range 10))
(println (take 2(range 1000000000000)))
; a sequencia não é "gulosa" (eager) é lazy "preguisçoso
(let [sequencia (range 1000000)]
  (println (take 2 sequencia))
  (println (take 2 sequencia)));imutabilidade a sequencia é a mesma

(defn filtro1 [x]
  (println "filtro1 =>" x)
  x)

;(println (map filtro1 (range 10)))

(defn filtro2 [x]
  (println "filtro2 =>" x)
  x)

;(println (map filtro2 (map filtro1 (range 10))))

(->> (range 10)
     (map filtro1)
     (map filtro2)
     println)

; CHUNKS de 32 (vai gerando blocos de 32 em 32)
(->> (range 50)
     (map filtro1)
     (map filtro2)
     println)

;com o mapv ele gera os 50 para o filtro 1 e depois 50 para o filtro 2
(->> (range 50)
     (mapv filtro1)
     (mapv filtro2)
     println)

;CHUNKS
(->> [1 3 4 5 6 7 2 8 9 0 4 5 6 3 2 1 8 9 0 1 2 3 4 0 7 8 9 7 6 5 4 3 1 1 6]
     (map filtro1)
     (map filtro2)
     println)

; com a lista ligada foi 100% lazy nesse cenário
(->> '(1 3 4 5 6 7 2 8 9 0 4 5 6 3 2 1 8 9 0 1 2 3 4 0 7 8 9 7 6 5 4 3 1 1 6)
     (map filtro1)
     (map filtro2)
     println)

