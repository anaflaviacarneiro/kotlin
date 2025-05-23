package com.seuapp.tests

import io.restassured.RestAssured
import io.kotest.core.spec.style.StringSpec
import io.kotest.core.spec.IsolationMode

abstract class BaseRestTest : StringSpec() {
    init {
        isolationMode = IsolationMode.InstancePerTest

        beforeTest {
            RestAssured.baseURI = "http://localhost"
            RestAssured.port = 8080
        }
    }
}