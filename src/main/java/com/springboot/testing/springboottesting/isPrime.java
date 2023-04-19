package com.springboot.testing.springboottesting;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/isPrime")
public class isPrime {

    @GetMapping("")
    public String showForm() {
        return "<html><body><form method='post'><label>Enter a number:</label><input type='number' name='number'><button type='submit'>Check</button></form></body></html>";
    }

    @PostMapping("")
    public String checkPrime1(@RequestParam("number") int number) {
        boolean isPrime = checkPrime(number);
        String result = isPrime ? "is Prime: " + number + " true" : "is Prime: " + number + " false";
        return "<html><body><h1>" + result + "</h1><form method='get' action='/isPrime'><button type='submit'>Try Again</button></form></body></html>";
    }

    private boolean checkPrime(int val) {
        if (val == 2) return true;
        if (val < 2) return false;
        if (val % 2 == 0) return false;
        int sqrt = (int) Math.sqrt(val);
        for (int i = 3; i <= sqrt; i += 2) {
            if (val % i == 0) {
                return false;
            }
        }
        return true;
    }
}