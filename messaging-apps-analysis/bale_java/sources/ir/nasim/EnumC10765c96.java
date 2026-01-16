package ir.nasim;

import com.google.protobuf.B;

/* renamed from: ir.nasim.c96, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public enum EnumC10765c96 implements B.c {
    OperatorChargeType_UNKNOWN(0),
    OperatorChargeType_TOPUP(1),
    OperatorChargeType_WOW(2),
    OperatorChargeType_VOUCHER(3),
    UNRECOGNIZED(-1);

    private static final B.d g = new B.d() { // from class: ir.nasim.c96.a
        @Override // com.google.protobuf.B.d
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public EnumC10765c96 a(int i) {
            return EnumC10765c96.j(i);
        }
    };
    private final int a;

    EnumC10765c96(int i) {
        this.a = i;
    }

    public static EnumC10765c96 j(int i) {
        if (i == 0) {
            return OperatorChargeType_UNKNOWN;
        }
        if (i == 1) {
            return OperatorChargeType_TOPUP;
        }
        if (i == 2) {
            return OperatorChargeType_WOW;
        }
        if (i != 3) {
            return null;
        }
        return OperatorChargeType_VOUCHER;
    }

    @Override // com.google.protobuf.B.c
    public final int getNumber() {
        if (this != UNRECOGNIZED) {
            return this.a;
        }
        throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
    }
}
