package ir.nasim;

import com.google.protobuf.B;

/* renamed from: ir.nasim.jg, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public enum EnumC15487jg implements B.c {
    BonusCodeState_UNKNOWN(0),
    BonusCodeState_AVAILABLE(1),
    BonusCodeState_RESERVED(2),
    BonusCodeState_USED(3),
    BonusCodeState_EXPIRED(4),
    BonusCodeState_VOIDED(5),
    UNRECOGNIZED(-1);

    private static final B.d i = new B.d() { // from class: ir.nasim.jg.a
        @Override // com.google.protobuf.B.d
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public EnumC15487jg a(int i2) {
            return EnumC15487jg.j(i2);
        }
    };
    private final int a;

    EnumC15487jg(int i2) {
        this.a = i2;
    }

    public static EnumC15487jg j(int i2) {
        if (i2 == 0) {
            return BonusCodeState_UNKNOWN;
        }
        if (i2 == 1) {
            return BonusCodeState_AVAILABLE;
        }
        if (i2 == 2) {
            return BonusCodeState_RESERVED;
        }
        if (i2 == 3) {
            return BonusCodeState_USED;
        }
        if (i2 == 4) {
            return BonusCodeState_EXPIRED;
        }
        if (i2 != 5) {
            return null;
        }
        return BonusCodeState_VOIDED;
    }

    @Override // com.google.protobuf.B.c
    public final int getNumber() {
        if (this != UNRECOGNIZED) {
            return this.a;
        }
        throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
    }
}
