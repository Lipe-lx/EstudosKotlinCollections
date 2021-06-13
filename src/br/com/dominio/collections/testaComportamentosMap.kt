package br.com.dominio.collections

fun testaMap(pedidos: MutableMap<Int, Double>) {
    println(pedidos)
    val pedido = pedidos[3]
    pedido?.let { //tratamento dos valores nulos
        println("Pedido: $it")
    }
    for (p: Map.Entry<Int, Double> in pedidos) { // : Map.Entry<Int, Double foi explicitado para didatica - valor fica implicito precisando declarar somente (pedido in pedidos)
        println("Número do pedido: ${p.key} | Valor do pedido: ${p.value}")
    }
    pedidos[4] = 70.0 //Adição de parametros no mapa [4]key = 70.0 value
    println(pedidos)
    pedidos.put(5, 80.0) //Outra forma de adição de parametros
    println(pedidos)
    pedidos[1] = 100.0 //Modificação de parametros
    println(pedidos)
    pedidos.putIfAbsent(6, 200.0) //Adiciona somente se não tiver igual aos parametros
    println(pedidos)
    pedidos.putIfAbsent(
        6,
        300.0
    ) //Como já existe a chave 6 com valor 200.0, dessa maneira não é modificado o novo parametro
    println(pedidos)

    pedidos.remove(6) //Remove os parametros
    println(pedidos)
    pedidos.remove(3, 100.0) //Remove os parametros somente se for igual - neste caso nao faz nada
    println(pedidos)
    pedidos.remove(3, 50.0) //Remove os parametros somente se for igual - neste caso remove o 3
    println(pedidos)

//    val pedidos = mapOf( //Podemos usar o "Pair(Key,Value)" ou o modo reduzito "key to value"
//        Pair(1, 20.0),
//        Pair(2, 34.0),
//        3 to 50.0
//    )
//    println(pedidos)
//    val pedido = pedidos[3]
//    pedido?.let { //tratamento dos valores nulos
//        println("Pedido: $it")
//    }
//    for (pedido: Map.Entry<Int, Double> in pedidos) { // : Map.Entry<Int, Double foi explicitado para didatica - valor fica implicito precisando declarar somente (pedido in pedidos)
//        println("Número do pedido: ${pedido.key} | Valor do pedido: ${pedido.value}")
//    }
}

fun tetaComportamentosMap() {
    val pedidos = mutableMapOf( //Podemos usar o "Pair(Key,Value)" ou o modo reduzito "key to value"
        Pair(1, 20.0),
        Pair(2, 64.0),
        3 to 50.0,
        4 to 100.0,
        5 to 150.0,
        6 to 80.00,
        7 to 100.0
    )
    val valorPedido =
        pedidos.getValue(4) //Maneira de pegar um valor e se a chave não existe ele lança uma exceção, podendo assim ter chaves nulas
    println(valorPedido)

    val mensagem =
        pedidos.getOrElse(5) { //Pega o elemento indicado pela key, caso não tenha retorna oque está dentro do bloco
            "Não tem o pedido"
        }
    println(mensagem)

    val retornaDefault =
        pedidos.getOrDefault(0, -1) //Pega o elemento indicado pela key, caso não tenha retorna o valor -1
    println(retornaDefault)

    for (numero in pedidos.keys) {
        println("Numero pedido: $numero")
    }
    for (valor in pedidos.values) {
        println("Valor do pedido: $valor")
    }
//FILTROS
    val pedidosFiltrados = pedidos.filter { (numero, valor) ->
        numero % 2 == 0 && valor > 50.0
    }
    println(pedidosFiltrados)

    val pedidosAcima = pedidos.filterValues { valor ->
        valor > 50.0
    }
    println(pedidosAcima)

    val pedidosPares = pedidos.filterKeys { numero ->
        numero % 2 == 0
    }
    println(pedidosPares)

    val adicaoPedidos = pedidos + mapOf(
        7 to 90.0,
        8 to 20.0
    ) //Adiciona novos elementos criando um novo mapa sem interferir no original //declaração do mapOf é opcional
    println(adicaoPedidos)
    println(pedidos) // Impressão do mapa original

    val retiraPedidos =
        pedidos - listOf(6, 5) //Retira elementos atraves de suas keys criando um novo mapa sem interferir no original
    println(retiraPedidos)
    println(pedidos) // Impressão do mapa original

    pedidos.putAll(
        listOf(
            7 to 90.0,
            8 to 20.0
        )
    ) //Adiciona novos elementos no original ou sobreescreve caso ele já exista
    println(pedidos)
    pedidos += listOf(
        7 to 90.0,
        8 to 30.0
    ) // += é a melhor pratica do .putAll - Observe que como o 8 ja existe ele irá sobrescrever
    println(pedidos)

    pedidos.keys.remove(1)
    println(pedidos)

    pedidos.values.remove(50.0)
    println(pedidos)

    pedidos.values.remove(100.0) //Como existem dois valores 100.0 ele remove sempre o primeiro valor que encontrar
    println(pedidos)

    pedidos -= 6
    println(pedidos)
}