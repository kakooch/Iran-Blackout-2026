package ir.nasim;

import com.google.protobuf.B;

/* renamed from: ir.nasim.kg, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public enum EnumC16078kg implements B.c {
    BonusCodeType_UNKNOWN(0),
    BonusCodeType_VIEWFIXED(1),
    BonusCodeType_CLICKFIXED(2),
    BonusCodeType_VIEWPERCENT(3),
    BonusCodeType_CLICKPERCENT(4),
    BonusCodeType_VIEWANDCLICKPERCENT(5),
    BonusCodeType_PRICEDISCOUNT(6),
    UNRECOGNIZED(-1);

    private static final B.d j = new B.d() { // from class: ir.nasim.kg.a
        @Override // com.google.protobuf.B.d
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public EnumC16078kg a(int i) {
            return EnumC16078kg.j(i);
        }
    };
    private final int a;

    EnumC16078kg(int i) {
        this.a = i;
    }

    public static EnumC16078kg j(int i) {
        switch (i) {
            case 0:
                return BonusCodeType_UNKNOWN;
            case 1:
                return BonusCodeType_VIEWFIXED;
            case 2:
                return BonusCodeType_CLICKFIXED;
            case 3:
                return BonusCodeType_VIEWPERCENT;
            case 4:
                return BonusCodeType_CLICKPERCENT;
            case 5:
                return BonusCodeType_VIEWANDCLICKPERCENT;
            case 6:
                return BonusCodeType_PRICEDISCOUNT;
            default:
                return null;
        }
    }

    @Override // com.google.protobuf.B.c
    public final int getNumber() {
        if (this != UNRECOGNIZED) {
            return this.a;
        }
        throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
    }
}
