package ir.nasim;

import com.google.protobuf.B;

/* renamed from: ir.nasim.wi, reason: case insensitive filesystem */
/* loaded from: classes9.dex */
public enum EnumC23307wi implements B.c {
    BonusCodeTypeUnknown(0),
    BonusCodeTypeViewFixed(1),
    BonusCodeTypeClickFixed(2),
    BonusCodeTypeViewPercent(3),
    BonusCodeTypeClickPercent(4),
    UNRECOGNIZED(-1);

    private static final B.d h = new B.d() { // from class: ir.nasim.wi.a
        @Override // com.google.protobuf.B.d
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public EnumC23307wi a(int i2) {
            return EnumC23307wi.j(i2);
        }
    };
    private final int a;

    EnumC23307wi(int i2) {
        this.a = i2;
    }

    public static EnumC23307wi j(int i2) {
        if (i2 == 0) {
            return BonusCodeTypeUnknown;
        }
        if (i2 == 1) {
            return BonusCodeTypeViewFixed;
        }
        if (i2 == 2) {
            return BonusCodeTypeClickFixed;
        }
        if (i2 == 3) {
            return BonusCodeTypeViewPercent;
        }
        if (i2 != 4) {
            return null;
        }
        return BonusCodeTypeClickPercent;
    }

    @Override // com.google.protobuf.B.c
    public final int getNumber() {
        if (this != UNRECOGNIZED) {
            return this.a;
        }
        throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
    }
}
