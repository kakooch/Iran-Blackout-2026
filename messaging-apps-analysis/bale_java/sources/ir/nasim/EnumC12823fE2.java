package ir.nasim;

import com.google.protobuf.B;

/* renamed from: ir.nasim.fE2, reason: case insensitive filesystem */
/* loaded from: classes9.dex */
public enum EnumC12823fE2 implements B.c {
    GarsonBadgeType_UNKNOWN(0),
    GarsonBadgeType_NEW(1),
    GarsonBadgeType_RECOMMENDED(2),
    GarsonBadgeType_AD(3),
    UNRECOGNIZED(-1);

    private static final B.d g = new B.d() { // from class: ir.nasim.fE2.a
        @Override // com.google.protobuf.B.d
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public EnumC12823fE2 a(int i) {
            return EnumC12823fE2.j(i);
        }
    };
    private final int a;

    EnumC12823fE2(int i) {
        this.a = i;
    }

    public static EnumC12823fE2 j(int i) {
        if (i == 0) {
            return GarsonBadgeType_UNKNOWN;
        }
        if (i == 1) {
            return GarsonBadgeType_NEW;
        }
        if (i == 2) {
            return GarsonBadgeType_RECOMMENDED;
        }
        if (i != 3) {
            return null;
        }
        return GarsonBadgeType_AD;
    }

    @Override // com.google.protobuf.B.c
    public final int getNumber() {
        if (this != UNRECOGNIZED) {
            return this.a;
        }
        throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
    }
}
