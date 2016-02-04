package org.example.domain

import grails.test.mixin.Mock
import spock.lang.Specification
import grails.test.mixin.TestFor

import org.example.services.NinjaService

@TestFor(Ninja)
class NinjaSpec extends Specification {

    def "Should not fire the name's custom validator twice"() {
        given:
            def instance = new Ninja(name: 'Naruto',
                                   sensei: 'Kakashi')
        when:
            instance.validate(['sensei'])
        then:
            instance.errors['name'] == null
    }

    def 'Should succeed at validating the village via mock'() {
        given:
            def instance = new Ninja(village: 'Leaf')
            instance.ninjaService = Mock(NinjaService)
        when:
            instance.validate(['village'])
        then:
            1 * instance.ninjaService.validate(instance) >> { final Ninja ninja ->
                ninja.errors.rejectValue 'village', 'should.be.an.error', [].toArray(), null
                ninja.log.debug "[NINJA SERVICE MOCK] (VALIDATING) 'village' FIRED! ninja.errors['village']?.code: '${ninja.errors['village']?.code}'"
            }
        and:
            instance.errors['village']?.code == 'should.be.an.error'
    }
}
