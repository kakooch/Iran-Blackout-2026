package ir.nasim;

import com.google.protobuf.B;

/* renamed from: ir.nasim.zI, reason: case insensitive filesystem */
/* loaded from: classes9.dex */
public enum EnumC24839zI implements B.c {
    ArbaeenCurrencyType_UNKNOWN(0),
    ArbaeenCurrencyType_US_DOLLAR(1),
    ArbaeenCurrencyType_IRAQ_DINAR(2),
    UNRECOGNIZED(-1);

    private static final B.d f = new B.d() { // from class: ir.nasim.zI.a
        @Override // com.google.protobuf.B.d
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public EnumC24839zI a(int i) {
            return EnumC24839zI.j(i);
        }
    };
    private final int a;

    EnumC24839zI(int i) {
        this.a = i;
    }

    public static EnumC24839zI j(int i) {
        if (i == 0) {
            return ArbaeenCurrencyType_UNKNOWN;
        }
        if (i == 1) {
            return ArbaeenCurrencyType_US_DOLLAR;
        }
        if (i != 2) {
            return null;
        }
        return ArbaeenCurrencyType_IRAQ_DINAR;
    }

    @Override // com.google.protobuf.B.c
    public final int getNumber() {
        if (this != UNRECOGNIZED) {
            return this.a;
        }
        throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
    }
}
