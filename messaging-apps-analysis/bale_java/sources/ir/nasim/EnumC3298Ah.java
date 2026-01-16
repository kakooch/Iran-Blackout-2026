package ir.nasim;

import com.google.protobuf.B;

/* renamed from: ir.nasim.Ah, reason: case insensitive filesystem */
/* loaded from: classes9.dex */
public enum EnumC3298Ah implements B.c {
    PayType_UNKNOWN(0),
    PayType_GIFTPACKET(1),
    PayType_CREDIT(2),
    PayType_KIFPOOL(3),
    UNRECOGNIZED(-1);

    private static final B.d g = new B.d() { // from class: ir.nasim.Ah.a
        @Override // com.google.protobuf.B.d
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public EnumC3298Ah a(int i) {
            return EnumC3298Ah.j(i);
        }
    };
    private final int a;

    EnumC3298Ah(int i) {
        this.a = i;
    }

    public static EnumC3298Ah j(int i) {
        if (i == 0) {
            return PayType_UNKNOWN;
        }
        if (i == 1) {
            return PayType_GIFTPACKET;
        }
        if (i == 2) {
            return PayType_CREDIT;
        }
        if (i != 3) {
            return null;
        }
        return PayType_KIFPOOL;
    }

    @Override // com.google.protobuf.B.c
    public final int getNumber() {
        if (this != UNRECOGNIZED) {
            return this.a;
        }
        throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
    }
}
