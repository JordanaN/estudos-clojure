;imprime uma funcao
(println "Bem Vindo")

;funcao de soma
(+ 13 + 3)

;define um vetor
(def estoque ["Mochila", "Camiseta"])
(estoque 0) ; Mochila
(count estoque) ; 2
(conj estoque "cadeira") ;adiciona cadeira no final do vetor mas nao altera o vetor original

;retorna o tipo do valor
(class 90.0)
java.lang.Double
(class 90N)
clojure.lang.BigInt
(class 90M)
java.math.BigDecimal
;Clojure, se o tipo de seu dado é Long ou Double ele automaticamente é passado para BigInt e BigDecimal

(defn imprime-mensagem []
  (println "------------------------")
  (println "Bem vindo(a) ao estoque!"))


(defn aplica-desconto ;define a funcao
  "retorna o valor descontado que é 90% do valor bruto" ;descricao da funcao
  [valor-bruto] ;parametro passado na funcao
  (* valor-bruto 0.9)) ; acao da funcao

(aplica-desconto 100)


(defn valor-descontado
  "Retorna o valor com descontado de 10%"
  [valor-bruto]
  (* valor-bruto (- 1 0.10)))


(defn valor-descontado
  "Retorna o valor com descontado de 10%"
  [valor-bruto]
  (def desconto 0.10) ; define um simbolo global
  (* valor-bruto (- 1 desconto)))


(defn valor-descontado
  "Retorna o valor com descontado de 10%"
  [valor-bruto]
  (let [desconto 0.10]
    (println "calculando desconto" desconto)
    (* valor-bruto (- 1 desconto)))) ; boa pratica é fechar todos os parenteses na ultima linha na ultima instrucao

(defn valor-descontado
  "Retorna o valor com descontado de 10%"
  [valor-bruto]
  (let [desconto (/ 10 100)]
    (println "calculando desconto" desconto)
    (* valor-bruto (- 1 desconto))))

;let pode definir varias coisas pois ele recebe um array com varios parametros
(defn valor-descontado
  "Retorna o valor com descontado de 10%"
  [valor-bruto]
  (let [taxa-de-desconto (/ 10 100) desconto (* valor-bruto taxa-de-desconto)]
    (println "calculando desconto" desconto)
    (- valor-bruto desconto)))


;if em clojure é uma forma e não uma função
(if (> 500 100)
  (println "maior")
  (println "menor ou igual")) ;else do IF

(if (> 50 100)
  (println "maior")
  (println "menor ou igual"))

;nil(Nulo) é considerado false dentro do if.

(defn valor-descontado
  "Retorna o valor com descontado de 10% se o valor bruto for maior que 100"
  [valor-bruto]
  (if (> valor-bruto 100)
    (let [taxa-de-desconto (/ 10 100) desconto (* valor-bruto taxa-de-desconto)]
      (println "calculando desconto" desconto)
      (- valor-bruto desconto)))
      (println "valor é menor que 100")); else

(valor-descontado 100)
