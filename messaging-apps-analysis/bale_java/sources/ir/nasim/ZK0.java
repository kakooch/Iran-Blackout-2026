package ir.nasim;

import com.google.protobuf.B;

/* loaded from: classes9.dex */
public enum ZK0 implements B.c {
    SimCardType_UNKOWN(0),
    SimCardType_PRE_PAID(1),
    SimCardType_POST_PAID(2),
    SimCardType_DATA(3),
    SimCardType_ANARESTAN(4),
    UNRECOGNIZED(-1);

    private static final B.d h = new B.d() { // from class: ir.nasim.ZK0.a
        @Override // com.google.protobuf.B.d
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public ZK0 a(int i2) {
            return ZK0.j(i2);
        }
    };
    private final int a;

    ZK0(int i2) {
        this.a = i2;
    }

    public static ZK0 j(int i2) {
        if (i2 == 0) {
            return SimCardType_UNKOWN;
        }
        if (i2 == 1) {
            return SimCardType_PRE_PAID;
        }
        if (i2 == 2) {
            return SimCardType_POST_PAID;
        }
        if (i2 == 3) {
            return SimCardType_DATA;
        }
        if (i2 != 4) {
            return null;
        }
        return SimCardType_ANARESTAN;
    }

    @Override // com.google.protobuf.B.c
    public final int getNumber() {
        if (this != UNRECOGNIZED) {
            return this.a;
        }
        throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
    }
}
