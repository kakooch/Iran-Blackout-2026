package ir.nasim;

import com.google.protobuf.B;

/* loaded from: classes8.dex */
public enum DE3 implements B.c {
    ICT_NONE(0),
    ICT_TCP(1),
    ICT_TLS(2),
    UNRECOGNIZED(-1);

    private static final B.d f = new B.d() { // from class: ir.nasim.DE3.a
        @Override // com.google.protobuf.B.d
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public DE3 a(int i) {
            return DE3.j(i);
        }
    };
    private final int a;

    DE3(int i) {
        this.a = i;
    }

    public static DE3 j(int i) {
        if (i == 0) {
            return ICT_NONE;
        }
        if (i == 1) {
            return ICT_TCP;
        }
        if (i != 2) {
            return null;
        }
        return ICT_TLS;
    }

    @Override // com.google.protobuf.B.c
    public final int getNumber() {
        if (this != UNRECOGNIZED) {
            return this.a;
        }
        throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
    }
}
