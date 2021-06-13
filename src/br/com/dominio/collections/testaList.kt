package br.com.dominio.collections

fun testaList() {

    val assistiramCursoKotlin = listOf("Alex", "Fran", "Luiz", "Maria")
    val assistiramCursoAndroid = listOf("Alex", "Luiz", "Paulo")
    val assistiramAmbos = assistiramCursoAndroid + assistiramCursoKotlin
    println(assistiramAmbos.distinct()) //.distinct todos os elementos da lista sem repetição
}
