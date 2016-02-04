package org.example

import grails.test.mixin.*
import org.junit.*

@TestFor(Ninja)
class NinjaTests {

    void testSomething() {

        def instance = new Ninja()
        instance.name = 'Naruto'
        instance.sensei = 'Kakashi'

        assert instance.validate(['sensei'])
    }
}
