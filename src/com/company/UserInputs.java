package com.company;
import java.util.Scanner;

public class UserInputs {


    int numberOfPoints,i=1;
    double psf,area,ix,iy,ec,as;

    public  UserInputs (Scanner sc){

        for(int i=1;i<=7;i++) {

            if (i == 1) {
                System.out.println("Enter the number of points that you have:");
                this.numberOfPoints = Integer.parseInt(sc.nextLine());
            } else if (i == 2) {
                System.out.println("Enter the pre stress force in mega pascal:");
                this.psf = Double.parseDouble(sc.nextLine());
            } else if (i == 3) {
                System.out.println("Enter the Area of the cross section:");
                this.area = Double.parseDouble(sc.nextLine());
            } else if (i == 4) {
                System.out.println("Enter the second moment of area respect to x axix:");
                this.ix = Double.parseDouble(sc.nextLine());
            } else if (i == 5) {
                System.out.println("Enter the second moment of area respect to y axix:");
                this.iy = Double.parseDouble(sc.nextLine());
            }
            else if(i==6){
                System.out.println("Enter the Young modulus of concreat :");
                this.ec =Double.parseDouble(sc.nextLine());
            }
            else if (i==7){
                System.out.println("Enter the Steel area:");
                this.as=Double.parseDouble(sc.nextLine());
            }



        }


    }



}
