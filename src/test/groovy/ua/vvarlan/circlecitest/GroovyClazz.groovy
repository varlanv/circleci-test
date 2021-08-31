package ua.vvarlan.circlecitest

import groovy.transform.CompileStatic

@CompileStatic
class GroovyClazz {

    public static void main(String[] args) {
        Runnable runnableLambda = () -> {
            println 1
        }

        Runnable runnableClosure = {
            println(2)
        }

        Closure<Void> runnableClosure2 = {
            println(3)
        }

        runnableLambda()
        runnableClosure()
        runnableClosure2()
    }
}
