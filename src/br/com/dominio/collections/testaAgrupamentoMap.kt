package br.com.dominio.collections

fun testaAgrupamentoMap() {
    val pedidos: List<Pedido> = listOf(
        Pedido(1, 20.0),
        Pedido(2, 60.0),
        Pedido(3, 30.0),
        Pedido(4, 70.0),
    )
    println(pedidos)

    val pedidosMapeados = pedidos.associateBy { pedido ->
        pedido.numero //Faz associação entre o numero do pedido e o pedido completo
    }
    println(pedidosMapeados)
    println(pedidosMapeados[1])

    val pedidosFreteGratis = pedidos.associateWith { pedido ->
        pedido.valor > 50.0
    }
    println(pedidosFreteGratis) //verifica se a condição é verdadeira ou falsa
    println(pedidosFreteGratis[Pedido(numero = 1, valor = 20.0)]) //verifica se a condição é verdadeira ou falsa

    val pedidosFreteGratisAgrupados: Map<Boolean, List<Pedido>> =
        pedidos.groupBy { pedido: Pedido -> //separa os pedidos em "true" e "false"
            pedido.valor > 50.0
        }
    println(pedidosFreteGratisAgrupados)
    println(pedidosFreteGratisAgrupados[false]) // pega somente os pedidos "false"

    val nomes: List<String> = listOf( //criando uma agenda
        "Alex",
        "Fran",
        "Luiz",
        "Ana",
        "Filipe",
        "Maria",
        "Mario",
        "Gisele"
    )
    val agenda: Map<Char, List<String>> = nomes.groupBy { nome -> //Agrupa valores associando a uma chave "key"
        nome.first() //separa pela primeira letra do nome
    }
    println(agenda)
    println(agenda['L']) // áspas simples para busca
}

data class Pedido(val numero: Int, val valor: Double)



