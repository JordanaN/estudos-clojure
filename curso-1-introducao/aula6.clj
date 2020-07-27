(ns projeto_estoque_alura.aula6)

(def pedido {:mochila  {:quantidade 2, :preco 80}
             :camiseta {:quantidade 3, :preco 40}})

(defn imprime-e-15 [valor]
  (println "valor" (class valor) valor)
  15)
;
;(defn imprime-e-15 [chave valor]
;  (println chave "e" valor)
;  15)
;

; desestruturando um vetor
(defn imprime-e-15 [[chave valor]]
  (println chave "<e>" valor)
  15)

(defn imprime-e-15 [[chave valor]]
  valor)
; map chama cada elemento do vetor sempre com chave e valor e ai que a desestruturacao funciona
(println (map imprime-e-15 pedido))

;pegando o total de produtos e multiplicando pelo preco
(defn preco-dos-produtos [[chave valor]]
  (* (:quantidade valor) (:preco valor)))

; aqui temos um map que retorna um valor total para cada produto
(println (map preco-dos-produtos pedido))
; usando o reduce eu retorna a soma dos 2 totais dos produtos
(println (reduce + (map preco-dos-produtos pedido)))

;como a chave nao esta sendo usanda podemos usar o _ (igual no ruby)
(defn preco-dos-produtos [[_ valor]]
  (* (:quantidade valor) (:preco valor)))

(println (map preco-dos-produtos pedido))
(println (reduce + (map preco-dos-produtos pedido)))

;colocando o reduce + map em uma funcao a parte
(defn total-do-pedido [pedido]
  (reduce + (map preco-dos-produtos pedido)))

(println (total-do-pedido pedido))

; trabalhando com THREAD LAST
; ele passa o argumento da funcao por ultimo
; reduce soma de pedido
(defn total-do-pedido
  [pedido]
  (->> pedido
       (map preco-dos-produtos)
       (reduce +)))

(println (total-do-pedido pedido))

; melhorando tirando o destruction
(defn preco-total-dos-produto [produto]
  (* (:quantidade produto) (:preco produto)))

(defn total-do-pedido
  [pedido]
  (->> pedido ; pega o pedido
       vals ; pega os valores do de cada item do pedido
       (map preco-total-dos-produto) ; chama a funcao com o map
       (reduce +))) ; soma tudo no final com reduce

(println (total-do-pedido pedido))

;-------------------
; AULA 6.1


(def pedido {:mochila  {:quantidade 2, :preco 80}
             :camiseta {:quantidade 3, :preco 40}
             :chaveiro {:quantidade 1}})
; primeira abordagem
(defn gratuito?
  [[_, item]]
  (<= (get item :preco 0) 0))

(println "filtrando" (filter gratuito? pedido))

;segunda abordagem
(defn gratuito?
  [item]
  (<= (get item :preco 0) 0))

(println "filtrando" (filter (fn [[chave item]] (gratuito? item)) pedido))

;terceira abordagem
(defn gratuito?
  [item]
  (<= (get item :preco 0) 0))
; second devolve o 2 elemento que é o item
(println "filtrando" (filter #(gratuito? (second %)) pedido))

;usando o not negacao
(defn pago?
  [item]
  (not (gratuito? item)))

(println (pago? {:preco 50}))
(println (pago? {:preco 0}))

;usando composicao em outra abordagem
(println ((comp not gratuito?) {:preco 50}))
(def pago? (comp not gratuito?))

(println (pago? {:preco 50}))
(println (pago? {:preco 0}))



(def clientes [
               {:nome         "Guilherme"
                :certificados ["Clojure" "Java" "Machine Learning"]}
               {:nome         "Paulo"
                :certificados ["Java" "Ciência da Computação"]}
               {:nome         "Daniela"
                :certificados ["Arquitetura" "Gastronomia"]}])
(println (->> clientes
              (map :certificados)
              (map count)
              (reduce +)))
















