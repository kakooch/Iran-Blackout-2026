package ir.nasim;

import com.google.protobuf.B;

/* renamed from: ir.nasim.Pc2, reason: case insensitive filesystem */
/* loaded from: classes9.dex */
public enum EnumC6816Pc2 implements B.c {
    ExchangingReason_UNKNOWN(0),
    ExchangingReason_AIR_TRAVEL(1),
    UNRECOGNIZED(-1);

    private static final B.d e = new B.d() { // from class: ir.nasim.Pc2.a
        @Override // com.google.protobuf.B.d
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public EnumC6816Pc2 a(int i) {
            return EnumC6816Pc2.j(i);
        }
    };
    private final int a;

    EnumC6816Pc2(int i) {
        this.a = i;
    }

    public static EnumC6816Pc2 j(int i) {
        if (i == 0) {
            return ExchangingReason_UNKNOWN;
        }
        if (i != 1) {
            return null;
        }
        return ExchangingReason_AIR_TRAVEL;
    }

    @Override // com.google.protobuf.B.c
    public final int getNumber() {
        if (this != UNRECOGNIZED) {
            return this.a;
        }
        throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
    }
}
