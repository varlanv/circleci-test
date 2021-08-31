package ua.vvarlan.circlecitest

import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureTestEntityManager
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ActiveProfiles
import org.springframework.transaction.annotation.Transactional
import spock.lang.Specification

@Transactional
@AutoConfigureTestEntityManager
@SpringBootTest(classes = ItConfig)
@ActiveProfiles(['local', 'integration_test'])
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class BaseSpec extends Specification {
}
