/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication1;
import java.util.Scanner;
/**
 *
 * @author binkaw
 */
public class JavaApplication1 {
    public static Scanner in=new Scanner(System.in);
    
    public static double[][] triangularMatrix(int X, int Y){
        double[][] triMa= new double[X][Y];
        
            for(int x = 0; x < X; x +=1 ){
                 triMa[x][x] = 1;
              }
             return triMa;
        }
       
    

    public static void printArr(double[][] matrix){
        for(int y = 0; y < matrix.length; y += 1){
            for(int x = 0; x < matrix[y].length;x += 1){
                System.out.print(String.format(" %9.2f",matrix[y][x]));
            }
            System.out.println();
        }
    }
    public static double[][] inverseMatrix(double [][] matrix){
                
        double[][] augMatrix = triangularMatrix(matrix.length,matrix[0].length);
        
        int Y = matrix.length;
        int X = matrix[0].length;
        
         for(int y = 0; y < Y; y += 1){
             
            for(int x = 0; x < X; x +=1 ){
               
                for(int tmp = 0; tmp < X; tmp += 1){
                    
                        matrix[y][x] /= matrix[y][y];
                        augMatrix[y][x] /= matrix[y][y];
                        
                }
                
                
            }
         }        
        
        
        return matrix;
    }    
    public static double[][] multipyMatrix(double [][] matrixA, double[][] matrixB) throws IllegalArgumentException{
        double[][] C = new double[matrixA.length][matrixB.length];
        int Y = matrixA.length;
        int X = matrixB[0].length;
        // get C matrix element
        if (Y != X){
            throw new IllegalArgumentException("Złe wielkośći tablic");
        }
        for(int y = 0; y < Y; y += 1 ){
            for(int x = 0; x <X; x += 1){
                // compute C matrix element
                for(int temp = 0; temp < X ; temp += 1){
                   C[y][x] += matrixA[0 + temp][y] * matrixB[x][0 + temp] ;
                }
                
            }
        }
        return C;
    }
    public static double[][] readMatrix(String name){
        
        
        int Y = 0;
        int X = 0;
        try{
            System.out.print("Podaj ilość wierszy macierzy: " + name);
            System.out.flush();
            Y = in.nextInt();
            
            if( Y < 0) {
                throw new Exception("ilość wierszy nie moze byc mniejsza od 0");
            }
            System.out.print("Podaj ilość kolumn macierzy: "  + name);
            System.out.flush();
            X = in.nextInt();
            
            if( X < 0) {
                throw new Exception("ilość kolumn nie moze byc mniejsza od 0");
            }
            
            
        } catch(Exception e) {
           System.out.print(e);         
        }
        
        double[][] matrix = new double[X][Y];
        
         for(int y = 0; y < Y; y += 1){
             System.out.println(String.format("podaj wartosci dla kolumny %2d", y));    
             for(int x = 0; x < X; x += 1){
                 matrix[x][y] = in.nextDouble();
             }
              System.out.println();
         }
        return matrix;
    }
    public static void main(String[] args) {
         double[][] A = readMatrix("A");
         double[][] B = inverseMatrix(A);
                       
         System.out.println("Macierz 1: ");
         printArr(A);
         System.out.println("Macierz 2: ");
         printArr(B);
         double[][] wyn = null;
         try{
            wyn = multipyMatrix(A, B);
            System.out.println("Mnorzenie macierzy A * B: ");
            printArr(wyn);
         }
         catch(IllegalArgumentException e){
             System.out.println(e);
         }
        

         
         }
         
    }


