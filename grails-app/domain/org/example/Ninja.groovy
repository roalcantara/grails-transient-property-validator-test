package org.example

class Ninja {

    String name
    String sensei

    static transients = ['name']

    static constraints = {
        name nullable:false, bindable:true, validator: { val, obj, errors ->
            obj.log.error "[VALIDATING] 'name': $val, $obj FIRED!", new Exception()
        }
        sensei nullable:false, bindable:true, validator:{ val, obj, errors ->
            obj.log.error "[VALIDATING] 'sensei': $val, $obj FIRED!", new Exception()
        }
    }
}
