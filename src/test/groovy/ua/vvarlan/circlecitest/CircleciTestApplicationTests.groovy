package ua.vvarlan.circlecitest

import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.annotation.Rollback
import spock.lang.Specification

@SpringBootTest
class CircleciTestApplicationTests extends Specification {

    TestEntityManager testEntityManager

    @Rollback(false)
    def 'context loads'() {
        when:
        testEntityManager.flush()
        1 == 1
        then:
        1 == 1
    }
}
