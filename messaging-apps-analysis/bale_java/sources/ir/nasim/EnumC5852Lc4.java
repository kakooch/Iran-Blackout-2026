package ir.nasim;

import com.google.protobuf.B;

/* renamed from: ir.nasim.Lc4, reason: case insensitive filesystem */
/* loaded from: classes9.dex */
public enum EnumC5852Lc4 implements B.c {
    ReceiptType_PURCHESE(0),
    ReceiptType_BILL(1),
    ReceiptType_CHARGE(2),
    ReceiptType_MONEY_TRANSFER(3),
    UNRECOGNIZED(-1);

    private static final B.d g = new B.d() { // from class: ir.nasim.Lc4.a
        @Override // com.google.protobuf.B.d
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public EnumC5852Lc4 a(int i) {
            return EnumC5852Lc4.j(i);
        }
    };
    private final int a;

    EnumC5852Lc4(int i) {
        this.a = i;
    }

    public static EnumC5852Lc4 j(int i) {
        if (i == 0) {
            return ReceiptType_PURCHESE;
        }
        if (i == 1) {
            return ReceiptType_BILL;
        }
        if (i == 2) {
            return ReceiptType_CHARGE;
        }
        if (i != 3) {
            return null;
        }
        return ReceiptType_MONEY_TRANSFER;
    }

    @Override // com.google.protobuf.B.c
    public final int getNumber() {
        if (this != UNRECOGNIZED) {
            return this.a;
        }
        throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
    }
}
