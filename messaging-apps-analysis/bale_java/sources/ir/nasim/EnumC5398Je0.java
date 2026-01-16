package ir.nasim;

import com.google.protobuf.B;

/* renamed from: ir.nasim.Je0, reason: case insensitive filesystem */
/* loaded from: classes9.dex */
public enum EnumC5398Je0 implements B.c {
    BillType_UNKNOWN(0),
    BillType_WATER(1),
    BillType_POWER(2),
    BillType_GAS(3),
    BillType_PHONE(4),
    BillType_HAMRAHEAVAL(5),
    BillType_RIGHTEL(11),
    BillType_IRANCELL(12),
    BillType_TRAFFICFINE(13),
    UNRECOGNIZED(-1);

    private static final B.d l = new B.d() { // from class: ir.nasim.Je0.a
        @Override // com.google.protobuf.B.d
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public EnumC5398Je0 a(int i) {
            return EnumC5398Je0.j(i);
        }
    };
    private final int a;

    EnumC5398Je0(int i) {
        this.a = i;
    }

    public static EnumC5398Je0 j(int i) {
        if (i == 0) {
            return BillType_UNKNOWN;
        }
        if (i == 1) {
            return BillType_WATER;
        }
        if (i == 2) {
            return BillType_POWER;
        }
        if (i == 3) {
            return BillType_GAS;
        }
        if (i == 4) {
            return BillType_PHONE;
        }
        if (i == 5) {
            return BillType_HAMRAHEAVAL;
        }
        switch (i) {
            case 11:
                return BillType_RIGHTEL;
            case 12:
                return BillType_IRANCELL;
            case 13:
                return BillType_TRAFFICFINE;
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
