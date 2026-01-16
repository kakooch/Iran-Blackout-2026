package ir.nasim;

import com.google.protobuf.B;

/* loaded from: classes9.dex */
public enum II2 implements B.c {
    GiftOpeningStatus_ALREADY_RECEIVED(0),
    GiftOpeningStatus_SOLD_OUT(1),
    GiftOpeningStatus_GIFT_CREATOR(2),
    GiftOpeningStatus_SUCCESSFUL(3),
    GiftOpeningStatus_PENDING(4),
    UNRECOGNIZED(-1);

    private static final B.d h = new B.d() { // from class: ir.nasim.II2.a
        @Override // com.google.protobuf.B.d
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public II2 a(int i2) {
            return II2.j(i2);
        }
    };
    private final int a;

    II2(int i2) {
        this.a = i2;
    }

    public static II2 j(int i2) {
        if (i2 == 0) {
            return GiftOpeningStatus_ALREADY_RECEIVED;
        }
        if (i2 == 1) {
            return GiftOpeningStatus_SOLD_OUT;
        }
        if (i2 == 2) {
            return GiftOpeningStatus_GIFT_CREATOR;
        }
        if (i2 == 3) {
            return GiftOpeningStatus_SUCCESSFUL;
        }
        if (i2 != 4) {
            return null;
        }
        return GiftOpeningStatus_PENDING;
    }

    @Override // com.google.protobuf.B.c
    public final int getNumber() {
        if (this != UNRECOGNIZED) {
            return this.a;
        }
        throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
    }
}
