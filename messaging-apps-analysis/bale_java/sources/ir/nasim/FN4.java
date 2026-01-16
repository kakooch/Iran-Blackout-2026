package ir.nasim;

import com.google.crypto.tink.shaded.protobuf.AbstractC2360w;

/* loaded from: classes3.dex */
public enum FN4 implements AbstractC2360w.a {
    UNKNOWN_PREFIX(0),
    TINK(1),
    LEGACY(2),
    RAW(3),
    CRUNCHY(4),
    UNRECOGNIZED(-1);

    private static final AbstractC2360w.b h = new AbstractC2360w.b() { // from class: ir.nasim.FN4.a
    };
    private final int a;

    FN4(int i2) {
        this.a = i2;
    }

    public static FN4 a(int i2) {
        if (i2 == 0) {
            return UNKNOWN_PREFIX;
        }
        if (i2 == 1) {
            return TINK;
        }
        if (i2 == 2) {
            return LEGACY;
        }
        if (i2 == 3) {
            return RAW;
        }
        if (i2 != 4) {
            return null;
        }
        return CRUNCHY;
    }

    public final int getNumber() {
        if (this != UNRECOGNIZED) {
            return this.a;
        }
        throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
    }
}
