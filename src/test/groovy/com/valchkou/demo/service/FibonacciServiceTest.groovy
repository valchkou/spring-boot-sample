package com.valchkou.demo.service

import spock.lang.Specification
import spock.lang.Unroll

class FibonacciServiceTest extends Specification {

    @Unroll
    def "Calculate N-th Number Of Fibonaccy Sequence"() {
        given:
        FibonacciService target = new FibonacciService()
        when:
        long ret = target.calcNthNumber(nth, mode)
        then:
        ret == result
        where:
        caseNum | nth | mode                                  | result
        1       | 2   | FibonacciService.CalcMode.ITERATIONAL | 1
        2       | 2   | FibonacciService.CalcMode.RECURSIVE   | 1
        3       | 2   | FibonacciService.CalcMode.SCIENTIFIC  | 1
        4       | 10  | FibonacciService.CalcMode.ITERATIONAL | 55
        5       | 10  | FibonacciService.CalcMode.RECURSIVE   | 55
        6       | 10  | FibonacciService.CalcMode.SCIENTIFIC  | 55
        7       | 3   | FibonacciService.CalcMode.ITERATIONAL | 2

    }
}
