package ir.nasim;

import com.google.protobuf.B;

/* loaded from: classes9.dex */
public enum C75 implements B.c {
    PfmTransactionType_UNKNOWN(0),
    PfmTransactionType_TOPUP(1),
    PfmTransactionType_WITHDRAW(2),
    UNRECOGNIZED(-1);

    private static final B.d f = new B.d() { // from class: ir.nasim.C75.a
        @Override // com.google.protobuf.B.d
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public C75 a(int i) {
            return C75.j(i);
        }
    };
    private final int a;

    C75(int i) {
        this.a = i;
    }

    public static C75 j(int i) {
        if (i == 0) {
            return PfmTransactionType_UNKNOWN;
        }
        if (i == 1) {
            return PfmTransactionType_TOPUP;
        }
        if (i != 2) {
            return null;
        }
        return PfmTransactionType_WITHDRAW;
    }

    @Override // com.google.protobuf.B.c
    public final int getNumber() {
        if (this != UNRECOGNIZED) {
            return this.a;
        }
        throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
    }
}
