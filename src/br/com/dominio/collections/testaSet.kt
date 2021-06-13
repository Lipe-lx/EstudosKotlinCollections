package br.com.dominio.collections

fun testaSet() {

    val assistiramCursoKotlin: Set<String> = setOf("Alex", "Fran", "Luiz", "Maria")
    val assistiramCursoAndroid: Set<String> = setOf("Alex", "Luiz", "Paulo")
//    val assistiramAmbos: Set<String> = assistiramCursoKotlin + assistiramCursoAndroid //Set pega um conjunto e evita as repetições
    val assistiramAmbos = mutableSetOf<String>()
    assistiramAmbos.addAll(assistiramCursoAndroid)
    assistiramAmbos.addAll(assistiramCursoKotlin)
    assistiramAmbos.add("Ana")
    assistiramAmbos.add("Ana") //mesmo adicionando "Ana" duas vezes ele só ira pegar uma

    println(assistiramAmbos)

    println(assistiramCursoKotlin + assistiramCursoAndroid)
    println(assistiramCursoKotlin union assistiramCursoAndroid)

    println(assistiramCursoKotlin - assistiramCursoAndroid)
    println(assistiramCursoKotlin subtract assistiramCursoAndroid)

    println(assistiramCursoKotlin intersect assistiramCursoAndroid) //existe nos dois conjuntos

    val assistiramList = assistiramAmbos.toMutableList()
    assistiramList.add("Luiz")
    println(assistiramList)
    println(assistiramList.toSet()) //converte a lista em set e não repete mais os elementos
}
