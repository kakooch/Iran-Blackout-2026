package ir.nasim;

import com.google.protobuf.B;

/* loaded from: classes9.dex */
public enum Q60 implements B.c {
    ChargeType_UNKNOWN(0),
    ChargeType_TOPUP(1),
    ChargeType_VOUCHER(2),
    ChargeType_WOW(3),
    UNRECOGNIZED(-1);

    private static final B.d g = new B.d() { // from class: ir.nasim.Q60.a
        @Override // com.google.protobuf.B.d
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public Q60 a(int i) {
            return Q60.j(i);
        }
    };
    private final int a;

    Q60(int i) {
        this.a = i;
    }

    public static Q60 j(int i) {
        if (i == 0) {
            return ChargeType_UNKNOWN;
        }
        if (i == 1) {
            return ChargeType_TOPUP;
        }
        if (i == 2) {
            return ChargeType_VOUCHER;
        }
        if (i != 3) {
            return null;
        }
        return ChargeType_WOW;
    }

    @Override // com.google.protobuf.B.c
    public final int getNumber() {
        if (this != UNRECOGNIZED) {
            return this.a;
        }
        throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
    }
}
