package ir.nasim;

import com.google.protobuf.B;

/* renamed from: ir.nasim.sn0, reason: case insensitive filesystem */
/* loaded from: classes9.dex */
public enum EnumC20895sn0 implements B.c {
    TransactionType_UNKNOWN(0),
    TransactionType_ALL(1),
    TransactionType_TOPUP(2),
    TransactionType_USEUP(3),
    TransactionType_SAFIR(4),
    TransactionType_SMARTASSISTANT(5),
    UNRECOGNIZED(-1);

    private static final B.d i = new B.d() { // from class: ir.nasim.sn0.a
        @Override // com.google.protobuf.B.d
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public EnumC20895sn0 a(int i2) {
            return EnumC20895sn0.j(i2);
        }
    };
    private final int a;

    EnumC20895sn0(int i2) {
        this.a = i2;
    }

    public static EnumC20895sn0 j(int i2) {
        if (i2 == 0) {
            return TransactionType_UNKNOWN;
        }
        if (i2 == 1) {
            return TransactionType_ALL;
        }
        if (i2 == 2) {
            return TransactionType_TOPUP;
        }
        if (i2 == 3) {
            return TransactionType_USEUP;
        }
        if (i2 == 4) {
            return TransactionType_SAFIR;
        }
        if (i2 != 5) {
            return null;
        }
        return TransactionType_SMARTASSISTANT;
    }

    @Override // com.google.protobuf.B.c
    public final int getNumber() {
        if (this != UNRECOGNIZED) {
            return this.a;
        }
        throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
    }
}
