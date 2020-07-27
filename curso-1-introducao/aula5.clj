(ns projeto_estoque_alura.aula5)

; definindo um hashMap
(def estoque { "Mochila" 10, "Camiseta" 5 })
(println estoque)

; count com hashMap
(println "temos" (count estoque) "elementos")

; mostrando só as chaves do hashMap
(println "Chaves são:" (keys estoque))
; mostrando só os valores do hashMap
(println "Valores são:" (vals estoque))

;keyword :mochila é a maneira correta de criar um hashMap
(def estoque { :mochila 10, :camiseta 5 })
(println estoque)

;add ou sobrescreve novo valor no hoshmap
(println (assoc estoque :cadeira 3))
(println (assoc estoque :mochila 1))

; usando o update e o inc no hashMap
(println (update estoque :mochila inc))

(defn tira-1 [valor] (println "tirando um de" valor) (- valor 1))
(println (update estoque :mochila tira-1))

; usando funcao com lambda
(println (update estoque :mochila #(- % 3)))

; remove elemento do hashMap
(println (dissoc estoque :mochila))

(println "original" estoque)

(println "\n\n\n\n\n\n\n")
; ---------------------
; Aula 5.1

(def pedido { :mochila { :quantidade 2, :preco 80 }
             :camiseta { :quantidade 3, :preco 40 }})

(println pedido)

;redefinindo o pedido e add mais um valor
(def pedido (assoc pedido :chaveiro {:quantidade 1, :preco 10}))
;acessando a chave mochila - maneira feia não usar pq retorna erro
(println (pedido :mochila))

;acessando a chave mochila com o get - usado mais nem tanto
(println (get pedido :mochila))
;acessando um valor que nao existe e retorna nil
(println (get pedido :caidera))
;acessando um valor que nao existe e retorna {}
(println (get pedido :caidera {}))

;maneira mais usada para acessar dados
;outra forma de acessar um valor é usando a chave como funcao
(println (:mochila pedido))
;nao existe e tb retorna nil
(println (:cadeira pedido))
;acessando um valor que nao existe e retorna {} usando a chave como funcao
(println (:cadeira pedido {}))
;retorna a quantidade da mochila do pedido
(println (:quantidade (:mochila pedido)))
;adiciona 1 na quantidade da mochila do pedido
(println "usando o update-in" (update-in pedido [:mochila :quantidade] inc))

; usando THREADING para acessas os dados **analogia do fio usa o resultado da funcao anterior
;essa é a maneira mais usada
(println (-> pedido
             :mochila
             :quantidade))
;outra maneira de chamar funcoes encadeadas junto com o println
; ele pega o resultado do pedido passa para mochila e esse resultado passa para quantidade
; e oresultado passa para o println
(-> pedido
    :mochila
    :quantidade
    println)

(println "\n\n\n")
(println "original" pedido)






























