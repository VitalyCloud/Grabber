package com;

public class Lambda {
    public static void main(String[] args) {
        Operation operation = new Operation() {
            @Override
            public double getResult(double v1, double v2) {
                return v1 + v2;
            }
        };
        System.out.println(operation.getResult(1,2));

        Operation lambda = (v1, v2) -> v1+v2;
        System.out.println(lambda.getResult(1,2));
    }
}


interface Operation {
    double getResult(double v1, double v2);
}
