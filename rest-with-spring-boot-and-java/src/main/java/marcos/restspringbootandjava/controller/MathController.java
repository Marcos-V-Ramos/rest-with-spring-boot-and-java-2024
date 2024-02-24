package marcos.restspringbootandjava.controller;

import marcos.restspringbootandjava.exception.UnsupportedMathOperationException;
import marcos.restspringbootandjava.math.SimpleMath;
import marcos.restspringbootandjava.util.NumericMethods;
import org.springframework.web.bind.annotation.*;
import java.util.concurrent.atomic.AtomicLong;

@RestController
public class MathController {
    private final AtomicLong counter = new AtomicLong();
    private SimpleMath math = new SimpleMath();

    @GetMapping(value = "/sum/{numberOne}/{numberTwo}")
    // @GetMapping("/sum/{numberOne}/{numberTwo}")
    public Double addition(@PathVariable(value = "numberOne") String numberOne,
                           @PathVariable(value = "numberTwo") String numberTwo) throws Exception {

        if (!NumericMethods.isNumeric(numberOne) || !NumericMethods.isNumeric(numberTwo)) {
            throw new UnsupportedMathOperationException("Please, set a numeric value!");
        }
        return math.addition(NumericMethods.convertToDouble(numberOne), NumericMethods.convertToDouble(numberTwo));
    }

    @GetMapping("/div/{numberOne}/{numberTwo}")
    public Double division(@PathVariable(value = "numberOne") String numberOne,
                           @PathVariable(value = "numberTwo") String numberTwo) {
        if (!NumericMethods.isNumeric(numberOne) || !NumericMethods.isNumeric(numberTwo)) {
            throw new UnsupportedMathOperationException("Please, set a numeric value!");
        }
        if (numberTwo.equals("0")) {
            return 0D;
        }
        return math.division(NumericMethods.convertToDouble(numberOne), NumericMethods.convertToDouble(numberTwo));
    }

    @GetMapping("/sub/{numberOne}/{numberTwo}")
    private Double subtraction(@PathVariable(value = "numberOne") String numberOne,
                               @PathVariable(value = "numberTwo") String numberTwo) {
        if (!NumericMethods.isNumeric(numberOne) || !NumericMethods.isNumeric(numberTwo)) {
            throw new UnsupportedMathOperationException("Please, set a numeric value!");
        }
        return math.subtraction(NumericMethods.convertToDouble(numberOne), NumericMethods.convertToDouble(numberTwo));
    }

    @GetMapping("/mult/{numberOne}/{numberTwo}")
    private Double multiplication(@PathVariable(value = "numberOne") String numberOne,
                                  @PathVariable(value = "numberTwo") String numberTwo) {
        if (!NumericMethods.isNumeric(numberOne) || !NumericMethods.isNumeric(numberTwo)) {
            throw new UnsupportedMathOperationException("Please, set a numeric value!");
        }
        return math.multiplication(NumericMethods.convertToDouble(numberOne), NumericMethods.convertToDouble(numberTwo));
    }

    @GetMapping("/sqrt/{numberOne}")
    private Double squareRoot(@PathVariable(value = "number") String number) {
        if (!NumericMethods.isNumeric(number)) {
            throw new UnsupportedMathOperationException("Please, set a numeric value!");
        }
        return math.squareRoot(NumericMethods.convertToDouble(number));
    }

    @GetMapping("/mean/{numberOne}/{numberTwo}")
    private Double mean(@PathVariable(value = "numberOne") String numberOne, @PathVariable(value = "numberTwo") String numberTwo) {
        if (!NumericMethods.isNumeric(numberOne) || !NumericMethods.isNumeric(numberTwo)) {
            throw new UnsupportedMathOperationException("Please, set a numeric value!");
        }
        return math.mean(NumericMethods.convertToDouble(numberOne), NumericMethods.convertToDouble(numberTwo));
    }
}