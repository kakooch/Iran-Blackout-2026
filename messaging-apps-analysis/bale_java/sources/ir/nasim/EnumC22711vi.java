package ir.nasim;

import com.google.protobuf.B;

/* renamed from: ir.nasim.vi, reason: case insensitive filesystem */
/* loaded from: classes9.dex */
public enum EnumC22711vi implements B.c {
    BonusCodeStateUnknown(0),
    BonusCodeStateAvailable(1),
    BonusCodeStateReserved(2),
    BonusCodeStateUsed(3),
    BonusCodeStateExpired(4),
    BonusCodeStateVoided(5),
    UNRECOGNIZED(-1);

    private static final B.d i = new B.d() { // from class: ir.nasim.vi.a
        @Override // com.google.protobuf.B.d
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public EnumC22711vi a(int i2) {
            return EnumC22711vi.j(i2);
        }
    };
    private final int a;

    EnumC22711vi(int i2) {
        this.a = i2;
    }

    public static EnumC22711vi j(int i2) {
        if (i2 == 0) {
            return BonusCodeStateUnknown;
        }
        if (i2 == 1) {
            return BonusCodeStateAvailable;
        }
        if (i2 == 2) {
            return BonusCodeStateReserved;
        }
        if (i2 == 3) {
            return BonusCodeStateUsed;
        }
        if (i2 == 4) {
            return BonusCodeStateExpired;
        }
        if (i2 != 5) {
            return null;
        }
        return BonusCodeStateVoided;
    }

    @Override // com.google.protobuf.B.c
    public final int getNumber() {
        if (this != UNRECOGNIZED) {
            return this.a;
        }
        throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
    }
}
