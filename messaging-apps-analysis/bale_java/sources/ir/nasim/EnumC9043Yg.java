package ir.nasim;

import com.google.protobuf.B;

/* renamed from: ir.nasim.Yg, reason: case insensitive filesystem */
/* loaded from: classes9.dex */
public enum EnumC9043Yg implements B.c {
    CustomIncomeType_UNKNOWN(0),
    CustomIncomeType_SAFIR(1),
    CustomIncomeType_CARD_TO_CARD_BANNER(2),
    CustomIncomeType_ARZ_ARBAEEN_BANNER(3),
    CustomIncomeType_OTHERS(4),
    UNRECOGNIZED(-1);

    private static final B.d h = new B.d() { // from class: ir.nasim.Yg.a
        @Override // com.google.protobuf.B.d
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public EnumC9043Yg a(int i2) {
            return EnumC9043Yg.j(i2);
        }
    };
    private final int a;

    EnumC9043Yg(int i2) {
        this.a = i2;
    }

    public static EnumC9043Yg j(int i2) {
        if (i2 == 0) {
            return CustomIncomeType_UNKNOWN;
        }
        if (i2 == 1) {
            return CustomIncomeType_SAFIR;
        }
        if (i2 == 2) {
            return CustomIncomeType_CARD_TO_CARD_BANNER;
        }
        if (i2 == 3) {
            return CustomIncomeType_ARZ_ARBAEEN_BANNER;
        }
        if (i2 != 4) {
            return null;
        }
        return CustomIncomeType_OTHERS;
    }

    @Override // com.google.protobuf.B.c
    public final int getNumber() {
        if (this != UNRECOGNIZED) {
            return this.a;
        }
        throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
    }
}
