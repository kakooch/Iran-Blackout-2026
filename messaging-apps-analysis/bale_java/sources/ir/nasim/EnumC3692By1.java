package ir.nasim;

import com.google.protobuf.B;

/* renamed from: ir.nasim.By1, reason: case insensitive filesystem */
/* loaded from: classes9.dex */
public enum EnumC3692By1 implements B.c {
    CategoryType_UNKNOWN(0),
    CategoryType_ALL(1),
    CategoryType_POLITICS(2),
    CategoryType_ECONOMICS(3),
    CategoryType_SOCIAL(4),
    CategoryType_SPORTS(5),
    CategoryType_CULTURE(6),
    CategoryType_HEALTH(7),
    CategoryType_SCIENCE(8),
    CategoryType_TECHNOLOGY(9),
    CategoryType_ACCIDENTS(10),
    CategoryType_INTERNATIONAL(11),
    CategoryType_HOT(12),
    UNRECOGNIZED(-1);

    private static final B.d p = new B.d() { // from class: ir.nasim.By1.a
        @Override // com.google.protobuf.B.d
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public EnumC3692By1 a(int i) {
            return EnumC3692By1.j(i);
        }
    };
    private final int a;

    EnumC3692By1(int i) {
        this.a = i;
    }

    public static EnumC3692By1 j(int i) {
        switch (i) {
            case 0:
                return CategoryType_UNKNOWN;
            case 1:
                return CategoryType_ALL;
            case 2:
                return CategoryType_POLITICS;
            case 3:
                return CategoryType_ECONOMICS;
            case 4:
                return CategoryType_SOCIAL;
            case 5:
                return CategoryType_SPORTS;
            case 6:
                return CategoryType_CULTURE;
            case 7:
                return CategoryType_HEALTH;
            case 8:
                return CategoryType_SCIENCE;
            case 9:
                return CategoryType_TECHNOLOGY;
            case 10:
                return CategoryType_ACCIDENTS;
            case 11:
                return CategoryType_INTERNATIONAL;
            case 12:
                return CategoryType_HOT;
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
