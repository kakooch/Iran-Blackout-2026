package ir.nasim;

import com.google.protobuf.B;

/* renamed from: ir.nasim.tE2, reason: case insensitive filesystem */
/* loaded from: classes9.dex */
public enum EnumC21172tE2 implements B.c {
    GarsonNavigationType_NOWHERE(0),
    GarsonNavigationType_ALL_SERVICES(1),
    GarsonNavigationType_ALL_BOTS(2),
    UNRECOGNIZED(-1);

    private static final B.d f = new B.d() { // from class: ir.nasim.tE2.a
        @Override // com.google.protobuf.B.d
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public EnumC21172tE2 a(int i) {
            return EnumC21172tE2.j(i);
        }
    };
    private final int a;

    EnumC21172tE2(int i) {
        this.a = i;
    }

    public static EnumC21172tE2 j(int i) {
        if (i == 0) {
            return GarsonNavigationType_NOWHERE;
        }
        if (i == 1) {
            return GarsonNavigationType_ALL_SERVICES;
        }
        if (i != 2) {
            return null;
        }
        return GarsonNavigationType_ALL_BOTS;
    }

    @Override // com.google.protobuf.B.c
    public final int getNumber() {
        if (this != UNRECOGNIZED) {
            return this.a;
        }
        throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
    }
}
