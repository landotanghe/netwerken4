/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package solvers;

/**
 *
 * @author Lando Tanghe
 */
public class QuadraticSolver {
    public double[] solve(double a,double b,double c){
        double D = b*b - 4* a* c;
        if(D<0){
            return new double[0];
        }else{
            if(D==0){
                return new double[]{-b/(2*a)};
            }else{
                double d=Math.sqrt(D);
                return new double[]{(-b+d)/(2*a),(-b-d)/(2*a)};
            }
        }
    }
}
