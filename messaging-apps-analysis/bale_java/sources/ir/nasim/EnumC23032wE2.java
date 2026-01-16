package ir.nasim;

import com.google.protobuf.B;

/* renamed from: ir.nasim.wE2, reason: case insensitive filesystem */
/* loaded from: classes9.dex */
public enum EnumC23032wE2 implements B.c {
    GarsonSectionType_UNKNOWN(0),
    GarsonSectionType_SHORTCUTS(1),
    GarsonSectionType_CUSTOM_SERVICES(2),
    GarsonSectionType_BANNERS(3),
    GarsonSectionType_BOTS_VITRINE(4),
    GarsonSectionType_EXTRA(5),
    UNRECOGNIZED(-1);

    private static final B.d i = new B.d() { // from class: ir.nasim.wE2.a
        @Override // com.google.protobuf.B.d
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public EnumC23032wE2 a(int i2) {
            return EnumC23032wE2.j(i2);
        }
    };
    private final int a;

    EnumC23032wE2(int i2) {
        this.a = i2;
    }

    public static EnumC23032wE2 j(int i2) {
        if (i2 == 0) {
            return GarsonSectionType_UNKNOWN;
        }
        if (i2 == 1) {
            return GarsonSectionType_SHORTCUTS;
        }
        if (i2 == 2) {
            return GarsonSectionType_CUSTOM_SERVICES;
        }
        if (i2 == 3) {
            return GarsonSectionType_BANNERS;
        }
        if (i2 == 4) {
            return GarsonSectionType_BOTS_VITRINE;
        }
        if (i2 != 5) {
            return null;
        }
        return GarsonSectionType_EXTRA;
    }

    @Override // com.google.protobuf.B.c
    public final int getNumber() {
        if (this != UNRECOGNIZED) {
            return this.a;
        }
        throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
    }
}
