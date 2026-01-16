package ir.nasim;

import com.google.protobuf.B;

/* renamed from: ir.nasim.wW0, reason: case insensitive filesystem */
/* loaded from: classes9.dex */
public enum EnumC23192wW0 implements B.c {
    WheelPrizeType_EXTRACHANCE(0),
    WheelPrizeType_COUPON(1),
    WheelPrizeType_GIFTPACKET(2),
    WheelPrizeType_POINT(3),
    WheelPrizeType_CUSTOM(4),
    UNRECOGNIZED(-1);

    private static final B.d h = new B.d() { // from class: ir.nasim.wW0.a
        @Override // com.google.protobuf.B.d
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public EnumC23192wW0 a(int i2) {
            return EnumC23192wW0.j(i2);
        }
    };
    private final int a;

    EnumC23192wW0(int i2) {
        this.a = i2;
    }

    public static EnumC23192wW0 j(int i2) {
        if (i2 == 0) {
            return WheelPrizeType_EXTRACHANCE;
        }
        if (i2 == 1) {
            return WheelPrizeType_COUPON;
        }
        if (i2 == 2) {
            return WheelPrizeType_GIFTPACKET;
        }
        if (i2 == 3) {
            return WheelPrizeType_POINT;
        }
        if (i2 != 4) {
            return null;
        }
        return WheelPrizeType_CUSTOM;
    }

    @Override // com.google.protobuf.B.c
    public final int getNumber() {
        if (this != UNRECOGNIZED) {
            return this.a;
        }
        throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
    }
}
