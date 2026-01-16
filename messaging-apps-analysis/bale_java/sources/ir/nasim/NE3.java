package ir.nasim;

import com.google.protobuf.B;

/* loaded from: classes8.dex */
public enum NE3 implements B.c {
    PREFER_REGRESSION(0),
    SIMULCAST(1),
    REGRESSION(2),
    UNRECOGNIZED(-1);

    private static final B.d f = new B.d() { // from class: ir.nasim.NE3.a
        @Override // com.google.protobuf.B.d
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public NE3 a(int i) {
            return NE3.j(i);
        }
    };
    private final int a;

    NE3(int i) {
        this.a = i;
    }

    public static NE3 j(int i) {
        if (i == 0) {
            return PREFER_REGRESSION;
        }
        if (i == 1) {
            return SIMULCAST;
        }
        if (i != 2) {
            return null;
        }
        return REGRESSION;
    }

    @Override // com.google.protobuf.B.c
    public final int getNumber() {
        if (this != UNRECOGNIZED) {
            return this.a;
        }
        throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
    }
}
