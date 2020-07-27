(ns projeto_estoque_alura.aula3)

(defn valor-descontado
  "Retorna o valor com descontado de 10% se o valor bruto for maior que 100"
  [valor-bruto]
  (if (> valor-bruto 100)
    (let [taxa-de-desconto (/ 10 100) desconto (* valor-bruto taxa-de-desconto)]
      (- valor-bruto desconto))
    valor-bruto))

;PREDICATE retorna true/false
(defn aplicar-desconto?
  [valor-bruto]
  (if (> valor-bruto 100)
    true
    false))

;segunda versao
(defn aplicar-desconto?
  [valor-bruto]
  (if (> valor-bruto 100)
    true))

;terceira versao
(defn aplicar-desconto?
  [valor-bruto]
  (when (> valor-bruto 100)
    true))

;quarta versao
(defn aplicar-desconto?
  [valor-bruto]
  (> valor-bruto 100))

(defn valor-descontado
  "Retorna o valor com descontado de 10% se o valor bruto for maior que 100"
  [valor-bruto]
  (if (aplicar-desconto? valor-bruto)
    (let [taxa-de-desconto (/ 10 100) desconto (* valor-bruto taxa-de-desconto)]
      (- valor-bruto desconto)))
  valor-bruto)

;------------------------------------------

(defn mais-caro-que-100?
  [valor-bruto]
  (> valor-bruto 100))

;outras maneiras com sintaxe sugar de definir a funcao
(def mais-caro-que-100? (fn [valor-bruto] (> valor-bruto 100)))
(def mais-caro-que-100? #(> % 100))

(defn valor-descontado
  "Retorna o valor com descontado de 10% se deve aplicar desconto"
  [aplica? valor-bruto]
  (if (aplica? valor-bruto)
    (let [taxa-de-desconto (/ 10 100) desconto (* valor-bruto taxa-de-desconto)]
      (- valor-bruto desconto))
    valor-bruto))

;HIGHER ORDER FUNCTIONS e IMUTABILIDADE
;(println "Funcao como parametro")
;(println (valor-descontado mais-caro-que-100? 1000))
;(println (valor-descontado mais-caro-que-100? 100))

;(println "Funcao anonima como parametro")
;(println (valor-descontado (fn [valor-bruto] (> valor-bruto 100)) 1000))
;(println (valor-descontado (fn [valor-bruto] (> valor-bruto 100)) 100))

(println "Funcao anonima como parametro com sintaxe sugar")
; vc pode passar uma funcao anonima e sem parametros nomeados e ai o % ou %1 significa 1 parametro
; tb pode ser chamado como uma funcao lambda
(println (valor-descontado #(> % 100) 1000))
(println (valor-descontado mais-caro-que-100? 100))

;Funções são "coisas" é a maneira informal de dizer que aqui
;em Clojure funções são tratadas como algo muito importante são "first class citizens"

