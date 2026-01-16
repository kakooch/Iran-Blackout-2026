package ir.nasim;

import com.google.protobuf.B;

/* loaded from: classes9.dex */
public enum RT3 implements B.c {
    SatisfactionRate_UNKOWN(0),
    SatisfactionRate_VERY_BAD(1),
    SatisfactionRate_BAD(2),
    SatisfactionRate_NORMAL(3),
    SatisfactionRate_GOOD(4),
    SatisfactionRate_GREAT(5),
    UNRECOGNIZED(-1);

    private static final B.d i = new B.d() { // from class: ir.nasim.RT3.a
        @Override // com.google.protobuf.B.d
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public RT3 a(int i2) {
            return RT3.j(i2);
        }
    };
    private final int a;

    RT3(int i2) {
        this.a = i2;
    }

    public static RT3 j(int i2) {
        if (i2 == 0) {
            return SatisfactionRate_UNKOWN;
        }
        if (i2 == 1) {
            return SatisfactionRate_VERY_BAD;
        }
        if (i2 == 2) {
            return SatisfactionRate_BAD;
        }
        if (i2 == 3) {
            return SatisfactionRate_NORMAL;
        }
        if (i2 == 4) {
            return SatisfactionRate_GOOD;
        }
        if (i2 != 5) {
            return null;
        }
        return SatisfactionRate_GREAT;
    }

    @Override // com.google.protobuf.B.c
    public final int getNumber() {
        if (this != UNRECOGNIZED) {
            return this.a;
        }
        throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
    }
}
