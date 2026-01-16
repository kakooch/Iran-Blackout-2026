package ir.nasim;

import com.google.protobuf.B;

/* renamed from: ir.nasim.gg, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public enum EnumC13696gg implements B.c {
    BonusCodeCondition_NONE(0),
    BonusCodeCondition_FIRSTTIME(1),
    BonusCodeCondition_PRICETHRESHOLD(2),
    BonusCodeCondition_TIMEPERIOD(3),
    UNRECOGNIZED(-1);

    private static final B.d g = new B.d() { // from class: ir.nasim.gg.a
        @Override // com.google.protobuf.B.d
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public EnumC13696gg a(int i) {
            return EnumC13696gg.j(i);
        }
    };
    private final int a;

    EnumC13696gg(int i) {
        this.a = i;
    }

    public static EnumC13696gg j(int i) {
        if (i == 0) {
            return BonusCodeCondition_NONE;
        }
        if (i == 1) {
            return BonusCodeCondition_FIRSTTIME;
        }
        if (i == 2) {
            return BonusCodeCondition_PRICETHRESHOLD;
        }
        if (i != 3) {
            return null;
        }
        return BonusCodeCondition_TIMEPERIOD;
    }

    @Override // com.google.protobuf.B.c
    public final int getNumber() {
        if (this != UNRECOGNIZED) {
            return this.a;
        }
        throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
    }
}
