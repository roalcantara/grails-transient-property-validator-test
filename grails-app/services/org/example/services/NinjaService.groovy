package org.example.services

import org.example.domain.Ninja

class NinjaService {

    boolean validate(Ninja ninja) {
        ninja?.validate()
    }
}
