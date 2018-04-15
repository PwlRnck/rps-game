package com.kodilla.rps;

public class Evaluate {

    public int result(String resultA, String resultB) {
        if (resultA.equals(FunctionKeys.SCISSORS.keyFunction()) && resultB.equals(FunctionKeys.PAPER.keyFunction()))
            return 1;
        if (resultA.equals(FunctionKeys.PAPER.keyFunction()) && resultB.equals(FunctionKeys.STONE.keyFunction()))
            return 1;
        if (resultA.equals(FunctionKeys.STONE.keyFunction()) && resultB.equals(FunctionKeys.SCISSORS.keyFunction()))
            return 1;
        return 0;
    }

}
