package ir.nasim;

import com.google.protobuf.B;

/* renamed from: ir.nasim.Gf, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public enum EnumC4704Gf implements B.c {
    AdOwnerType_B2C(0),
    AdOwnerType_B2B(1),
    AdOwnerType_SUPPORTIVE(2),
    AdOwnerType_PR(3),
    AdOwnerType_TEST(4),
    UNRECOGNIZED(-1);

    private static final B.d h = new B.d() { // from class: ir.nasim.Gf.a
        @Override // com.google.protobuf.B.d
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public EnumC4704Gf a(int i2) {
            return EnumC4704Gf.j(i2);
        }
    };
    private final int a;

    EnumC4704Gf(int i2) {
        this.a = i2;
    }

    public static EnumC4704Gf j(int i2) {
        if (i2 == 0) {
            return AdOwnerType_B2C;
        }
        if (i2 == 1) {
            return AdOwnerType_B2B;
        }
        if (i2 == 2) {
            return AdOwnerType_SUPPORTIVE;
        }
        if (i2 == 3) {
            return AdOwnerType_PR;
        }
        if (i2 != 4) {
            return null;
        }
        return AdOwnerType_TEST;
    }

    @Override // com.google.protobuf.B.c
    public final int getNumber() {
        if (this != UNRECOGNIZED) {
            return this.a;
        }
        throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
    }
}
