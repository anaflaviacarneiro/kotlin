package com.seuapp.tests.rotaValida

import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue
import com.seuapp.tests.BaseRestTest
import com.seuapp.tests.model.ValidaRequest
import com.seuapp.tests.model.ValidaResponse
import io.kotest.matchers.shouldBe
import io.restassured.RestAssured

class RegraNomeValidoTest : BaseRestTest() {

    private val mapper = jacksonObjectMapper()

    init {
        "Validação do nome - RegraNomeValido com modelo de request e response" {
            val request = ValidaRequest(nome = "", cpf = "12345678909")

            val response = RestAssured.given()
                .contentType("application/json")
                .body(mapper.writeValueAsString(request))
                .post("/valida")
                .then()
                .extract()

            val parsed = mapper.readValue<ValidaResponse>(response.body().asString())
            response.statusCode() shouldBe 400
            parsed.mensagem shouldBe "Nome não pode ser vazio"
            parsed.codigo shouldBe 1001
        }
    }
}