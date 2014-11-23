/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package testequationservice;

import java.util.List;

/**
 *
 * @author Lando Tanghe
 */
public class TestEquationService {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        List<Double> solveQuadratic = solveQuadratic(1, -5, 6);
        for(double d:solveQuadratic){
            System.out.println(d);
        }
    }

    private static java.util.List<java.lang.Double> solveQuadratic(double a, double b, double c) {
        services.EquationService_Service service = new services.EquationService_Service();
        services.EquationService port = service.getEquationServicePort();
        return port.solveQuadratic(a, b, c);
    }
    
}
