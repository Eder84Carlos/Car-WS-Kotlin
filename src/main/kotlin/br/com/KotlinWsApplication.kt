package br.com

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
open class KotlinWsApplication

fun main(args: Array<String>) {
	runApplication<KotlinWsApplication>(*args)
}
