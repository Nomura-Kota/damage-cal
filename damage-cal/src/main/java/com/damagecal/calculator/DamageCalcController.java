package com.damagecal.calculator;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://damage-cal.com")
public class DamageCalcController {

    @PostMapping("/calculate")
    public ResponseEntity<CalculationResult> calculateDamage(@RequestBody DamageRequest request) {
        int result = calculateDamage(request.getHealth(), request.getAttack());
        CalculationResult calculationResult = new CalculationResult(result);
        return ResponseEntity.ok(calculationResult);
    }
    
    private int calculateDamage(int health, int attack) {
        return health - attack;
    }
}

