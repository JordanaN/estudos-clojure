(ns projeto_estoque_alura.aula4)

(def precos [30, 700, 1000])

(println (precos 0))
(println (get precos 2))
; o get ajuda a não estourar uma exception ao buscar um valor no array
(println "valor padrao nil" (get precos 17))
(println "valor padrao 0" (get precos 17 0))

; adiciona o 5 no final do vetor  porém ele retorna um novo vetor com o 5 e precos segue imutavel
(println (conj precos 5))
(println precos)

; inc soma um no valor e update junto com o inc atualiza  um elemento do vetor
(println (inc 5))
; incrementa 1 na posicao 0 do vetor
(println (update precos 0 inc))
; decrementa 1 na posicao 1 do vetor
(println (update precos 1 dec))
(println precos)

; fazendo uma funcao de soma
(defn soma-1 [valor] (println "somando mais 1") (+ valor 1))
(println (update precos 0 soma-1))

; CODIGO DA AULA 3

(defn aplicar-desconto?
  [valor-bruto]
  (> valor-bruto 100))

(defn valor-descontado
  "Retorna o valor com descontado de 10% se o valor bruto for maior que 100"
  [valor-bruto]
  (if (aplicar-desconto? valor-bruto)
    (let [taxa-de-desconto (/ 10 100) desconto (* valor-bruto taxa-de-desconto)]
      (- valor-bruto desconto))
    valor-bruto))

; mapeia os valores de preco e aplica o valor descontado
(println "map" (map valor-descontado precos))

; cria um vetor de 0 - 9
(println (range 10))
; seleciona em um vetor de 0-9 os valores pares
(println (filter even? (range 10)))

(println "vetor" precos)
; filter aplica uma funcao para cada elemento do vetor e diminui a sequencia
(println "filter" (filter aplicar-desconto? precos))
; map pega um vetor e aplica uma funcao para cada elemento e retorna uma nova sequencia
(println "map apos filter" (map valor-descontado (filter aplicar-desconto? precos)))

;reduce reduz todos os valor a uma funcao no caso a soma, somou todos os valores
(println "vetor" precos)
(println "reduce" (reduce + precos))

; vendo como o reduce funciona
(defn minha-soma
  [valor1, valor2]
  (println "somando" valor1 valor2)
  (+ valor1 valor2))
(println (reduce minha-soma precos))
(println (reduce minha-soma (range 10)))
; nao chama a funcao minha-soma pq só tem um elemento no vetor o 15
(println (reduce minha-soma [15]))
; nesse caso eu quero que ele comece em 0 e ai ele chama a funcao mesmo com um só elemento no vetor
(println (reduce minha-soma 0 [15]))







