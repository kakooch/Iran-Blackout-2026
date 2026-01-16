package ir.nasim;

import com.google.protobuf.B;

/* renamed from: ir.nasim.nI4, reason: case insensitive filesystem */
/* loaded from: classes9.dex */
public enum EnumC17634nI4 implements B.c {
    CurrencyType_UNKNOWN(0),
    CurrencyType_US_DOLLAR(1),
    UNRECOGNIZED(-1);

    private static final B.d e = new B.d() { // from class: ir.nasim.nI4.a
        @Override // com.google.protobuf.B.d
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public EnumC17634nI4 a(int i) {
            return EnumC17634nI4.j(i);
        }
    };
    private final int a;

    EnumC17634nI4(int i) {
        this.a = i;
    }

    public static EnumC17634nI4 j(int i) {
        if (i == 0) {
            return CurrencyType_UNKNOWN;
        }
        if (i != 1) {
            return null;
        }
        return CurrencyType_US_DOLLAR;
    }

    @Override // com.google.protobuf.B.c
    public final int getNumber() {
        if (this != UNRECOGNIZED) {
            return this.a;
        }
        throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
    }
}
