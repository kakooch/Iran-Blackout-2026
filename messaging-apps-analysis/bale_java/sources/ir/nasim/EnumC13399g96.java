package ir.nasim;

import com.google.protobuf.B;

/* renamed from: ir.nasim.g96, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public enum EnumC13399g96 implements B.c {
    OrderType_UNKNOWN(0),
    OrderType_CHARGE_TOPUP(1),
    OrderType_CHARGE_WOW(2),
    OrderType_CHARGE_VOUCHER(3),
    OrderType_INTERNET_BUNDLE(4),
    UNRECOGNIZED(-1);

    private static final B.d h = new B.d() { // from class: ir.nasim.g96.a
        @Override // com.google.protobuf.B.d
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public EnumC13399g96 a(int i2) {
            return EnumC13399g96.j(i2);
        }
    };
    private final int a;

    EnumC13399g96(int i2) {
        this.a = i2;
    }

    public static EnumC13399g96 j(int i2) {
        if (i2 == 0) {
            return OrderType_UNKNOWN;
        }
        if (i2 == 1) {
            return OrderType_CHARGE_TOPUP;
        }
        if (i2 == 2) {
            return OrderType_CHARGE_WOW;
        }
        if (i2 == 3) {
            return OrderType_CHARGE_VOUCHER;
        }
        if (i2 != 4) {
            return null;
        }
        return OrderType_INTERNET_BUNDLE;
    }

    @Override // com.google.protobuf.B.c
    public final int getNumber() {
        if (this != UNRECOGNIZED) {
            return this.a;
        }
        throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
    }
}
