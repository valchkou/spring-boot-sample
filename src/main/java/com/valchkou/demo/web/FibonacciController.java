package com.valchkou.demo.web;


import com.valchkou.demo.model.FibonacciResult;
import com.valchkou.demo.service.FibonacciService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Api(value = "Fibonacci Calculator")
@RestController
@RequestMapping("/api/fibonacci")
public class FibonacciController {

    @Autowired
    FibonacciService fibonacciService;

    @ApiOperation(value = "Calculate Fibonaccy N-th number")
    @RequestMapping(value = "{nth}", method = RequestMethod.GET)
    @ResponseBody FibonacciResult calcN(@PathVariable int nth) {
        return fibonacciService.calcNthNumber(nth,FibonacciService.CalcMode.SCIENTIFIC);
    }

    @ApiOperation(value = "Calculate Fibonaccy N-th number")
    @RequestMapping(value = "{nth}/{mode}", method = RequestMethod.GET)
    @ResponseBody FibonacciResult calcN(@PathVariable int nth,
                            @ApiParam(value = "Calc Mode", required = true, allowableValues = "ITERATIONAL, RECURSIVE, SCIENTIFIC")
                            @PathVariable(required = true) FibonacciService.CalcMode mode) {
        return fibonacciService.calcNthNumber(nth, mode);
    }
}
