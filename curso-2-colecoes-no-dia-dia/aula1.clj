(ns lojinha.aula1)

(map println ["daniele", "guilherme", "carlos", "paulo", "lucia", "ana"])

(println (first ["daniele", "guilherme", "carlos", "paulo", "lucia", "ana"]))
(println (rest ["daniele", "guilherme", "carlos", "paulo", "lucia", "ana"]))
(println (rest [])) ; () sequencia
(println (next ["daniele", "guilherme", "carlos", "paulo", "lucia", "ana"]))
(println (next [])) ; nil
(println (seq [])) ; nil
(println (seq [1,2,3,4])) ; sequencia (1,2,3,4)

(println "\n\n\n\n Meu Mapa")
; ficou em loop infinito
(defn meu-mapa
  [funcao sequencia]
  (let [primeiro (first sequencia)]
    (funcao primeiro)
    (meu-mapa funcao (rest sequencia))))

;(meu-mapa println ["daniele", "guilherme", "carlos", "paulo", "lucia", "ana"])

;(println "\n\n\n\n Meu Mapa com false")

(defn meu-mapa
  [funcao sequencia]
  (let [primeiro (first sequencia)]
    (if primeiro
      (do (funcao primeiro)
          (meu-mapa funcao (rest sequencia))))
    ))

(println "\n\n\n\n Meu Mapa com nil")
; criando um map com recursao
(defn meu-mapa
  [funcao sequencia]
  (let [primeiro (first sequencia)]
    (if (not (nil? primeiro))
      (do
        (funcao primeiro)
          (meu-mapa funcao (rest sequencia))))))

(meu-mapa println ["daniele", "guilherme", "carlos", "paulo", "lucia", "ana"])
(meu-mapa println ["daniele", false, "carlos", "paulo", "lucia", "ana"])
(meu-mapa println [])
(meu-mapa println nil)
;(meu-mapa println (range 100000)) estoura a memoria

; TAIL RECURSION - recusao de calda
(defn meu-mapa
  [funcao sequencia]
  (let [primeiro (first sequencia)]
    (if (not (nil? primeiro))
      (do
        (funcao primeiro)
        (recur funcao (rest sequencia))))))
(meu-mapa println (range 100000))

; avisando o clojure que é uma recursao por debaixo dos panos
; ele transforma em um laço
; ele tem que ser a ultima funcao chamada