package ua.vvarlan.circlecitest


import org.springframework.boot.test.context.SpringBootTest
import spock.lang.Specification

@SpringBootTest
class CircleciTestApplicationTests extends Specification {

    def 'context loads'() {
        when:
        1 == 1
        then:
        1 == 1
    }

}
