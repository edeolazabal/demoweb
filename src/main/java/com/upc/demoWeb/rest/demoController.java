package com.upc.demoWeb.rest;

import org.springframework.web.bind.annotation.*;
@CrossOrigin("http://localhost:4200/")
@RestController
@RequestMapping("/prueba")
public class demoController {
    
    @GetMapping("/siglas")
    public String nombreCorto() {
        return "UPC";
    }

    @GetMapping("/descripcion")
    public String nombreExtendido() {
        return "Universidad Peruana de Ciencias Aplicadas";
    }

    @GetMapping("/descripcion/{dato}")
    public String nombreLargo(@RequestParam String dato) {
        return "Universidad Peruana de Ciencias Aplicadas" + " - " + dato;
    }
    @PostMapping("/nombre")
    public String nombreAsignado(@RequestParam String dato,@RequestParam String dato2) {
        return "UPC - " + dato + " - " + dato2;
    }
    @PostMapping("/operacion")
    public String operacion(@RequestParam Number dato, @RequestParam Number dato2, @RequestParam String oper) {
        double dRespuesta = 0.0;
        switch (oper) {
            case "+":
                dRespuesta = dato.doubleValue() + dato2.doubleValue();
                break;
            case "-":
                dRespuesta = dato.doubleValue() - dato2.doubleValue();
                break;
            case "*":
                dRespuesta = dato.doubleValue() * dato2.doubleValue();
                break;
            case "/":
                dRespuesta = dato.doubleValue() / dato2.doubleValue();
                break;
        }
        return "El resultado es: " + String.format("%.2f", dRespuesta);
    }
    @PostMapping("/calculadora")
    public String calculadora(@RequestParam Number dato, @RequestParam Number dato2){
    double resultadoSuma = dato.doubleValue() + dato2.doubleValue();
    double resultadoResta = dato.doubleValue() - dato2.doubleValue();
    double resultadoMultiplicacion = dato.doubleValue() * dato2.doubleValue();
    double resultadoDivision = dato.doubleValue() / dato2.doubleValue();
    String resultado = "Suma: " + resultadoSuma + " " + "Resta: " + resultadoResta + " " + "Multiplicación: " + resultadoMultiplicacion + " " + "División: " + resultadoDivision+ " ";
        return resultado;
    }

    @PostMapping("/calculadora2")
    public double calculadora2(@RequestParam double numero1,@RequestParam String operador,@RequestParam double numero2){
        double resultado=0;
        switch(operador){
           case "+":
                resultado=numero1+numero2;
                break;
            case "*":
                resultado=numero1*numero2;
                break;
            case "-":
                resultado=numero1-numero2;
                break;
            case "/":
                resultado=numero1/numero2;
                break;
        }
        return resultado;

    }

}
