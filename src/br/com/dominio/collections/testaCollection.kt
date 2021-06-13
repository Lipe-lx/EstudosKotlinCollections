package br.com.dominio.collections

fun testaCopia() {
    val banco = BancoDeNomes()
    val nomesSalvos: Collection<String> = banco.nomes

    banco.salva("Rodrigo")
    banco.salva("Luiz")

    println(banco.nomes)
    println(nomesSalvos)
}

//Quem erda de quem? Iterable - Collection - List e Set - MutableLis e MutableSet
class BancoDeNomes {

    val nomes: Collection<String> get() = dados.toList() //.toList impossibilita de fazer casting - faz com que a lista original não seja modificada criando assim uma copia com as alterações

    fun salva(nome: String){ //metodo criado para adicionar nomes na lista
        dados.add(nome)
    }

    companion object {
        private val dados = mutableListOf<String>() //private para encapsular os dados
    }

}

fun testaColecao() {
    val nomes: Collection<String> = listOf(
        "Luiz",
        "Filipe",
        "Alex",
        "Fran",
        "Ana"
    )
    for (nome in nomes) {
        println(nome)
    }
    println(nomes)
    println("Tem o nome Luiz? ${nomes.contains("Luiz")}")
    println("Tamano da coleção: ${nomes.size}")
}