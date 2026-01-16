package ir.nasim;

import com.google.protobuf.B;

/* renamed from: ir.nasim.Ib2, reason: case insensitive filesystem */
/* loaded from: classes9.dex */
public enum EnumC5139Ib2 implements B.c {
    EvexCurrencyType_UNKNOWN(0),
    EvexCurrencyType_US_DOLLAR(1),
    EvexCurrencyType_IRAQ_DINAR(2),
    EvexCurrencyType_EURO(3),
    UNRECOGNIZED(-1);

    private static final B.d g = new B.d() { // from class: ir.nasim.Ib2.a
        @Override // com.google.protobuf.B.d
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public EnumC5139Ib2 a(int i) {
            return EnumC5139Ib2.j(i);
        }
    };
    private final int a;

    EnumC5139Ib2(int i) {
        this.a = i;
    }

    public static EnumC5139Ib2 j(int i) {
        if (i == 0) {
            return EvexCurrencyType_UNKNOWN;
        }
        if (i == 1) {
            return EvexCurrencyType_US_DOLLAR;
        }
        if (i == 2) {
            return EvexCurrencyType_IRAQ_DINAR;
        }
        if (i != 3) {
            return null;
        }
        return EvexCurrencyType_EURO;
    }

    @Override // com.google.protobuf.B.c
    public final int getNumber() {
        if (this != UNRECOGNIZED) {
            return this.a;
        }
        throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
    }
}
