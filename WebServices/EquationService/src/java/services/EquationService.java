/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package services;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import solvers.QuadraticSolver;

/**
 *
 * @author Lando Tanghe
 */
@WebService(serviceName = "EquationService")
public class EquationService {

    /**
     * This is a sample web service operation
     */
    @WebMethod(operationName = "hello")
    public String hello(@WebParam(name = "name") String txt) {
        return "Hello " + txt + " !";
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "solveQuadratic")
    public double[] solveQuadratic(@WebParam(name = "a") double a, @WebParam(name = "b") double b, @WebParam(name = "c") double c) {
        return new QuadraticSolver().solve(a,b,c);
    }
    
    
}
