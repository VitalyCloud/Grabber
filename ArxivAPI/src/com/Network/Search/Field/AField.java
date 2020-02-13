package com.Network.Search.Field;

public abstract class AField {

    public enum BoolFlag {
        AND,
        OR,
        ANDNOT
    }

    private Field.BoolFlag boolFlag;

    public AField() {
        boolFlag = BoolFlag.OR;
    }
    public AField(BoolFlag flag) { boolFlag = flag; }

    public void setBoolFlag(BoolFlag flag) {
        boolFlag = flag;
    }
    public BoolFlag getBoolFlag() {
        return boolFlag;
    }

    public abstract String getBody();
}

