package ir.nasim;

import com.google.protobuf.B;

/* renamed from: ir.nasim.Mc2, reason: case insensitive filesystem */
/* loaded from: classes9.dex */
public enum EnumC6083Mc2 implements B.c {
    CurrencyType_UNKNOWN(0),
    CurrencyType_US_DOLLAR(1),
    CurrencyType_IRAQ_DINAR(2),
    CurrencyType_EURO(3),
    UNRECOGNIZED(-1);

    private static final B.d g = new B.d() { // from class: ir.nasim.Mc2.a
        @Override // com.google.protobuf.B.d
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public EnumC6083Mc2 a(int i) {
            return EnumC6083Mc2.j(i);
        }
    };
    private final int a;

    EnumC6083Mc2(int i) {
        this.a = i;
    }

    public static EnumC6083Mc2 j(int i) {
        if (i == 0) {
            return CurrencyType_UNKNOWN;
        }
        if (i == 1) {
            return CurrencyType_US_DOLLAR;
        }
        if (i == 2) {
            return CurrencyType_IRAQ_DINAR;
        }
        if (i != 3) {
            return null;
        }
        return CurrencyType_EURO;
    }

    @Override // com.google.protobuf.B.c
    public final int getNumber() {
        if (this != UNRECOGNIZED) {
            return this.a;
        }
        throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
    }
}
