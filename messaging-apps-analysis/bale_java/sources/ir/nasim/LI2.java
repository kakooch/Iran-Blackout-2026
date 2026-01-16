package ir.nasim;

import com.google.protobuf.B;

/* loaded from: classes9.dex */
public enum LI2 implements B.c {
    GiftReceiversOrderType_UNKNOWN(0),
    GiftReceiversOrderType_PRIZE_ASC(1),
    GiftReceiversOrderType_DATE_ASC(2),
    GiftReceiversOrderType_PRIZE_DESC(3),
    GiftReceiversOrderType_DATE_DESC(4),
    UNRECOGNIZED(-1);

    private static final B.d h = new B.d() { // from class: ir.nasim.LI2.a
        @Override // com.google.protobuf.B.d
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public LI2 a(int i2) {
            return LI2.j(i2);
        }
    };
    private final int a;

    LI2(int i2) {
        this.a = i2;
    }

    public static LI2 j(int i2) {
        if (i2 == 0) {
            return GiftReceiversOrderType_UNKNOWN;
        }
        if (i2 == 1) {
            return GiftReceiversOrderType_PRIZE_ASC;
        }
        if (i2 == 2) {
            return GiftReceiversOrderType_DATE_ASC;
        }
        if (i2 == 3) {
            return GiftReceiversOrderType_PRIZE_DESC;
        }
        if (i2 != 4) {
            return null;
        }
        return GiftReceiversOrderType_DATE_DESC;
    }

    @Override // com.google.protobuf.B.c
    public final int getNumber() {
        if (this != UNRECOGNIZED) {
            return this.a;
        }
        throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
    }
}
