package org.example

import grails.test.mixin.*
import org.junit.*

@TestFor(Ninja)
class NinjaTests {

    void testSomething() {
        def instance = new Ninja(name: 'Naruto',
                               sensei: 'Kakashi')

        assert !instance.validate(['sensei'])
    }
}
