package ir.nasim;

import com.google.protobuf.B;

/* loaded from: classes9.dex */
public enum PJ2 implements B.c {
    WEIGHT_UNIT_UNSPECIFIED(0),
    MG(1),
    UNRECOGNIZED(-1);

    private static final B.d e = new B.d() { // from class: ir.nasim.PJ2.a
        @Override // com.google.protobuf.B.d
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public PJ2 a(int i) {
            return PJ2.j(i);
        }
    };
    private final int a;

    PJ2(int i) {
        this.a = i;
    }

    public static PJ2 j(int i) {
        if (i == 0) {
            return WEIGHT_UNIT_UNSPECIFIED;
        }
        if (i != 1) {
            return null;
        }
        return MG;
    }

    @Override // com.google.protobuf.B.c
    public final int getNumber() {
        if (this != UNRECOGNIZED) {
            return this.a;
        }
        throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
    }
}
