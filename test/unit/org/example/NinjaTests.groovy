package org.example

import grails.test.mixin.*
import org.junit.*

@TestFor(Ninja)
class NinjaTests {

    void testSomething() {
        def instance = new Ninja(name:'Naruto', sensei:'Kakashi')
        instance.validate(['sensei'])
        assert instance.hasErrors()
    }
}
