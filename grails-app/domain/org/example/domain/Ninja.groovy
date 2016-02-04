package org.example.domain

class Ninja {

    String name
    String sensei

    String village

    def ninjaService

    static transients = ['name', 'ninjaService']

    static constraints = {
        name nullable:false, bindable:true, validator: { val, obj, errors ->
            obj.log.error "[VALIDATING] 'name': $val, $obj FIRED!", new Exception()
            errors.rejectValue 'name', 'should.not.be.fired!', [].toArray(), null
        }
        sensei nullable:false, bindable:true, validator:{ val, obj, errors ->
            obj.log.error "[VALIDATING] 'sensei': $val, $obj FIRED!", new Exception()
        }
        village nullable:true, validator:{ val, obj, errors ->
            obj.ninjaService?.validate(obj)
        }
    }
}
