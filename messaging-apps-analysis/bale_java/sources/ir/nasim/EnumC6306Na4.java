package ir.nasim;

import com.google.protobuf.B;

/* renamed from: ir.nasim.Na4, reason: case insensitive filesystem */
/* loaded from: classes9.dex */
public enum EnumC6306Na4 implements B.c {
    BanReason_UNKNOWN(0),
    BanReason_SCAM(1),
    BanReason_IMMORAL(2),
    BanReason_SPAM(3),
    BanReason_DISINFORMATION(4),
    UNRECOGNIZED(-1);

    private static final B.d h = new B.d() { // from class: ir.nasim.Na4.a
        @Override // com.google.protobuf.B.d
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public EnumC6306Na4 a(int i2) {
            return EnumC6306Na4.j(i2);
        }
    };
    private final int a;

    EnumC6306Na4(int i2) {
        this.a = i2;
    }

    public static EnumC6306Na4 j(int i2) {
        if (i2 == 0) {
            return BanReason_UNKNOWN;
        }
        if (i2 == 1) {
            return BanReason_SCAM;
        }
        if (i2 == 2) {
            return BanReason_IMMORAL;
        }
        if (i2 == 3) {
            return BanReason_SPAM;
        }
        if (i2 != 4) {
            return null;
        }
        return BanReason_DISINFORMATION;
    }

    @Override // com.google.protobuf.B.c
    public final int getNumber() {
        if (this != UNRECOGNIZED) {
            return this.a;
        }
        throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
    }
}
