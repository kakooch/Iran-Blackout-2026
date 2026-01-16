package ir.nasim;

import com.google.protobuf.B;

/* loaded from: classes9.dex */
public enum P04 implements B.c {
    CallSatisfactionRate_UNKOWN(0),
    CallSatisfactionRate_VERY_BAD(1),
    CallSatisfactionRate_BAD(2),
    CallSatisfactionRate_NORMAL(3),
    CallSatisfactionRate_GOOD(4),
    CallSatisfactionRate_GREAT(5),
    UNRECOGNIZED(-1);

    private static final B.d i = new B.d() { // from class: ir.nasim.P04.a
        @Override // com.google.protobuf.B.d
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public P04 a(int i2) {
            return P04.j(i2);
        }
    };
    private final int a;

    P04(int i2) {
        this.a = i2;
    }

    public static P04 j(int i2) {
        if (i2 == 0) {
            return CallSatisfactionRate_UNKOWN;
        }
        if (i2 == 1) {
            return CallSatisfactionRate_VERY_BAD;
        }
        if (i2 == 2) {
            return CallSatisfactionRate_BAD;
        }
        if (i2 == 3) {
            return CallSatisfactionRate_NORMAL;
        }
        if (i2 == 4) {
            return CallSatisfactionRate_GOOD;
        }
        if (i2 != 5) {
            return null;
        }
        return CallSatisfactionRate_GREAT;
    }

    @Override // com.google.protobuf.B.c
    public final int getNumber() {
        if (this != UNRECOGNIZED) {
            return this.a;
        }
        throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
    }
}
