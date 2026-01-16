package ir.nasim;

import com.google.protobuf.B;

/* loaded from: classes9.dex */
public enum YK0 implements B.c {
    PhoneChargeType_UNKNOWN(0),
    PhoneChargeType_DIRECT(1),
    PhoneChargeType_EXTRA(2),
    PhoneChargeType_VOUCHER(3),
    UNRECOGNIZED(-1);

    private static final B.d g = new B.d() { // from class: ir.nasim.YK0.a
        @Override // com.google.protobuf.B.d
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public YK0 a(int i) {
            return YK0.j(i);
        }
    };
    private final int a;

    YK0(int i) {
        this.a = i;
    }

    public static YK0 j(int i) {
        if (i == 0) {
            return PhoneChargeType_UNKNOWN;
        }
        if (i == 1) {
            return PhoneChargeType_DIRECT;
        }
        if (i == 2) {
            return PhoneChargeType_EXTRA;
        }
        if (i != 3) {
            return null;
        }
        return PhoneChargeType_VOUCHER;
    }

    @Override // com.google.protobuf.B.c
    public final int getNumber() {
        if (this != UNRECOGNIZED) {
            return this.a;
        }
        throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
    }
}
