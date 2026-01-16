package com.google.zxing.common.reedsolomon;

import org.linphone.mediastream.Factory;

/* loaded from: classes.dex */
public final class GenericGF {
    public static final GenericGF AZTEC_DATA_6;
    public static final GenericGF AZTEC_DATA_8;
    public static final GenericGF AZTEC_PARAM;
    public static final GenericGF DATA_MATRIX_FIELD_256;
    public static final GenericGF MAXICODE_FIELD_64;
    public static final GenericGF QR_CODE_FIELD_256;
    private final int[] expTable;
    private final int generatorBase;
    private final int[] logTable;
    private final GenericGFPoly one;
    private final int primitive;
    private final int size;
    private final GenericGFPoly zero;
    public static final GenericGF AZTEC_DATA_12 = new GenericGF(4201, Factory.DEVICE_HAS_CRAPPY_AAUDIO, 1);
    public static final GenericGF AZTEC_DATA_10 = new GenericGF(1033, Factory.DEVICE_MCH264ENC_NO_PIX_FMT_CONV, 1);

    static int addOrSubtract(int a, int b) {
        return a ^ b;
    }

    static {
        GenericGF genericGF = new GenericGF(67, 64, 1);
        AZTEC_DATA_6 = genericGF;
        AZTEC_PARAM = new GenericGF(19, 16, 1);
        QR_CODE_FIELD_256 = new GenericGF(285, Factory.DEVICE_HAS_CRAPPY_OPENSLES, 0);
        GenericGF genericGF2 = new GenericGF(301, Factory.DEVICE_HAS_CRAPPY_OPENSLES, 1);
        DATA_MATRIX_FIELD_256 = genericGF2;
        AZTEC_DATA_8 = genericGF2;
        MAXICODE_FIELD_64 = genericGF;
    }

    public GenericGF(int primitive, int size, int b) {
        this.primitive = primitive;
        this.size = size;
        this.generatorBase = b;
        this.expTable = new int[size];
        this.logTable = new int[size];
        int i = 1;
        for (int i2 = 0; i2 < size; i2++) {
            this.expTable[i2] = i;
            i *= 2;
            if (i >= size) {
                i = (i ^ primitive) & (size - 1);
            }
        }
        for (int i3 = 0; i3 < size - 1; i3++) {
            this.logTable[this.expTable[i3]] = i3;
        }
        this.zero = new GenericGFPoly(this, new int[]{0});
        this.one = new GenericGFPoly(this, new int[]{1});
    }

    GenericGFPoly getZero() {
        return this.zero;
    }

    GenericGFPoly getOne() {
        return this.one;
    }

    GenericGFPoly buildMonomial(int degree, int coefficient) {
        if (degree < 0) {
            throw new IllegalArgumentException();
        }
        if (coefficient == 0) {
            return this.zero;
        }
        int[] iArr = new int[degree + 1];
        iArr[0] = coefficient;
        return new GenericGFPoly(this, iArr);
    }

    int exp(int a) {
        return this.expTable[a];
    }

    int log(int a) {
        if (a == 0) {
            throw new IllegalArgumentException();
        }
        return this.logTable[a];
    }

    int inverse(int a) {
        if (a == 0) {
            throw new ArithmeticException();
        }
        return this.expTable[(this.size - this.logTable[a]) - 1];
    }

    int multiply(int a, int b) {
        if (a == 0 || b == 0) {
            return 0;
        }
        int[] iArr = this.expTable;
        int[] iArr2 = this.logTable;
        return iArr[(iArr2[a] + iArr2[b]) % (this.size - 1)];
    }

    public int getSize() {
        return this.size;
    }

    public int getGeneratorBase() {
        return this.generatorBase;
    }

    public String toString() {
        return "GF(0x" + Integer.toHexString(this.primitive) + ',' + this.size + ')';
    }
}
