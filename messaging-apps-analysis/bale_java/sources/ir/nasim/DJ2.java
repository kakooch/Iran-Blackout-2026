package ir.nasim;

import com.google.protobuf.B;

/* loaded from: classes9.dex */
public enum DJ2 implements B.c {
    CURRENCY_UNSPECIFIED(0),
    IRR(1),
    IRT(2),
    UNRECOGNIZED(-1);

    private static final B.d f = new B.d() { // from class: ir.nasim.DJ2.a
        @Override // com.google.protobuf.B.d
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public DJ2 a(int i) {
            return DJ2.j(i);
        }
    };
    private final int a;

    DJ2(int i) {
        this.a = i;
    }

    public static DJ2 j(int i) {
        if (i == 0) {
            return CURRENCY_UNSPECIFIED;
        }
        if (i == 1) {
            return IRR;
        }
        if (i != 2) {
            return null;
        }
        return IRT;
    }

    @Override // com.google.protobuf.B.c
    public final int getNumber() {
        if (this != UNRECOGNIZED) {
            return this.a;
        }
        throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
    }
}
