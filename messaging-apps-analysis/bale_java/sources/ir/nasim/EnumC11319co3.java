package ir.nasim;

import com.google.protobuf.B;

/* renamed from: ir.nasim.co3, reason: case insensitive filesystem */
/* loaded from: classes9.dex */
public enum EnumC11319co3 implements B.c {
    PaymentType_WALLET(0),
    PaymentType_GATEWAY(1),
    PaymentType_BALE_POCKET_WALLET(2),
    UNRECOGNIZED(-1);

    private static final B.d f = new B.d() { // from class: ir.nasim.co3.a
        @Override // com.google.protobuf.B.d
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public EnumC11319co3 a(int i) {
            return EnumC11319co3.j(i);
        }
    };
    private final int a;

    EnumC11319co3(int i) {
        this.a = i;
    }

    public static EnumC11319co3 j(int i) {
        if (i == 0) {
            return PaymentType_WALLET;
        }
        if (i == 1) {
            return PaymentType_GATEWAY;
        }
        if (i != 2) {
            return null;
        }
        return PaymentType_BALE_POCKET_WALLET;
    }

    @Override // com.google.protobuf.B.c
    public final int getNumber() {
        if (this != UNRECOGNIZED) {
            return this.a;
        }
        throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
    }
}
