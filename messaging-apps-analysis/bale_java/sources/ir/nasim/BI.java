package ir.nasim;

import com.google.protobuf.B;

/* loaded from: classes9.dex */
public enum BI implements B.c {
    ArbaeenReason_UNKNOWN(0),
    ArbaeenReason_AIR_TRAVEL(1),
    UNRECOGNIZED(-1);

    private static final B.d e = new B.d() { // from class: ir.nasim.BI.a
        @Override // com.google.protobuf.B.d
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public BI a(int i) {
            return BI.j(i);
        }
    };
    private final int a;

    BI(int i) {
        this.a = i;
    }

    public static BI j(int i) {
        if (i == 0) {
            return ArbaeenReason_UNKNOWN;
        }
        if (i != 1) {
            return null;
        }
        return ArbaeenReason_AIR_TRAVEL;
    }

    @Override // com.google.protobuf.B.c
    public final int getNumber() {
        if (this != UNRECOGNIZED) {
            return this.a;
        }
        throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
    }
}
