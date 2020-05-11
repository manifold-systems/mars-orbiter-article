package com.example;

import manifold.science.measures.*;

import static java.lang.System.out;
import static manifold.science.util.UnitConstants.*;

public class SampleCode {
    public static void main(String[] args) {
        unitExpressions();
        operatorOverloading();
        equalityAndRelationalExpressions();
        unitConverstionEtc();
    }

    private static void unitExpressions() {
        MarsOrbiter orbiter = new MarsOrbiter();

        // Use Newton seconds
        orbiter.performManeuver(222.41108075988 N s);
        // Use pound seconds
        orbiter.performManeuver(50 lbf s);
    }

    private static void operatorOverloading() {
        Momentum momentum;
        momentum = 50 lbf s;
        momentum = 5 lbf * 10 s;
        momentum = 22.241108075988 N * 10 s;
        Force force = momentum / 10 s;
    }

    private static void equalityAndRelationalExpressions() {
        out.println(50 lbf s == 222.41108075988 N s); // true
        out.println(50 lbf s > 222 N s); // true
    }

    private static void unitConverstionEtc() {
        Momentum momentum = 222.41108075988 N s;
        Time duration = 10 s;
        Force force = momentum / duration;
        out.println("$duration burn at $force");
        out.println("$duration burn at ${force.to(lbf)}");
    }

    static class MarsOrbiter {
        public void performManeuver(Momentum momentum) {
            out.println(momentum.to(N s));
        }
    }

}
