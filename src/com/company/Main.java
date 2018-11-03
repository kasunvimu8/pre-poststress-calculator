package com.company;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Scanner;
public class Main {

   static int numberOfPoints;
   static double  psf,area,ix,iy,ec,as;
   static  final double es =196;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        UserInputs inp = new UserInputs( sc);

        numberOfPoints = inp.numberOfPoints;
        psf =inp.psf;
        area=inp.area;
        ix =inp.ix;
        iy =inp.iy;
        ec =inp.ec;
        as =inp.as;

        HashMap<Integer, Point> hmap = new HashMap<Integer, Point>();
            for(int i =1 ;i<= numberOfPoints;i++) {
                Scanner scPoints = new Scanner(System.in);

                   if(i==0){
                       System.out.println("Enter points like this x,y in milimeters");
                       System.out.println("Enetr points  "+ i );
                   }
                   else {
                       System.out.println("Enetr points  "+ i);

                   }

                String s = scPoints.nextLine();
                String[] parts = s.split(",");
                Point newPoint =new Point(Double.parseDouble(parts[0]),Double.parseDouble(parts[1]));

                hmap.put(i, newPoint);
            }

        PostTension(hmap);

    }


    public static void PostTension(HashMap<Integer, Point> hmap ) {

        double posttension=0;
        double p = psf / numberOfPoints;
        double TotalStressLossInConcret=0;
        DecimalFormat df = new DecimalFormat("#.###");

        for(int i=1 ;i<=numberOfPoints;i++) {
            posttension =0;
            Point val1=hmap.get(i);
            double xk =val1.getX();
            double yk = val1.getY();

            for (int j = i + 1; j <= numberOfPoints; j++) {
                Point val2=hmap.get(j);
                double xl =val2.getX();
                double yl = val2.getY();

                double p1=  (1 / area);
                double p2 =(yl * yk) / ix ;
                double p3 = (xl * xk) / iy;


                posttension += p * (p1 +p2 +p3 );

            }

            TotalStressLossInConcret += posttension;
            System.out.println("post tension value for point " + i + " in mega pascals : "+df.format(posttension));
        }

        System.out.println("Total Stress In Concreat: "+ df.format(TotalStressLossInConcret));

        System.out.println("Total steel loss:"+df.format(TotalStressLossInConcret* (es/ec)));

        System.out.println("Pre stress loss in steal:" +df.format(as*TotalStressLossInConcret* (es/ec)));

        System.out.println("pre stree loss percentage: "+df.format(((as * TotalStressLossInConcret * (es/ec))/psf)*100 )+"%" );
    }


}
