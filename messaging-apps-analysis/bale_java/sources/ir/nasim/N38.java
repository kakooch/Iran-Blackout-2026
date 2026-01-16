package ir.nasim;

import com.google.protobuf.B;

/* loaded from: classes.dex */
public enum N38 implements B.c {
    Currency_RIAL(0),
    Currency_SCORE(1),
    UNRECOGNIZED(-1);

    private static final B.d e = new B.d() { // from class: ir.nasim.N38.a
        @Override // com.google.protobuf.B.d
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public N38 a(int i) {
            return N38.j(i);
        }
    };
    private final int a;

    N38(int i) {
        this.a = i;
    }

    public static N38 j(int i) {
        if (i == 0) {
            return Currency_RIAL;
        }
        if (i != 1) {
            return null;
        }
        return Currency_SCORE;
    }

    @Override // com.google.protobuf.B.c
    public final int getNumber() {
        if (this != UNRECOGNIZED) {
            return this.a;
        }
        throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
    }
}
