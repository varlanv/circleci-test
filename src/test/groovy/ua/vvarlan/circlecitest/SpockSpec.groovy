package ua.vvarlan.circlecitest

import spock.lang.Specification

class SpockSpec extends Specification {

    def '123'() {
        'hello world'()

        expect:
        1 == 1
    }

    void '1234'() {
        expect:
        1 == 1
    }

    private void 'hello world'() {

        println('hello world')
    }
}
