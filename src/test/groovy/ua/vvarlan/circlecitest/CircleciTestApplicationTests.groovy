package ua.vvarlan.circlecitest

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager

class CircleciTestApplicationTests extends BaseSpec {

    @Autowired
    TestEntityManager testEntityManager

    def 'context loads'() {
        when:
        testEntityManager.flush()
        1 == 1

        then:
        1 == 1
    }
}
