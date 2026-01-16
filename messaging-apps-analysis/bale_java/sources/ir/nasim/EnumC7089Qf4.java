package ir.nasim;

import com.google.protobuf.B;

/* renamed from: ir.nasim.Qf4, reason: case insensitive filesystem */
/* loaded from: classes9.dex */
public enum EnumC7089Qf4 implements B.c {
    PrivacyBarMode_UNKNOWN(0),
    PrivacyBarMode_NONE(1),
    PrivacyBarMode_SPAM(2),
    UNRECOGNIZED(-1);

    private static final B.d f = new B.d() { // from class: ir.nasim.Qf4.a
        @Override // com.google.protobuf.B.d
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public EnumC7089Qf4 a(int i) {
            return EnumC7089Qf4.j(i);
        }
    };
    private final int a;

    EnumC7089Qf4(int i) {
        this.a = i;
    }

    public static EnumC7089Qf4 j(int i) {
        if (i == 0) {
            return PrivacyBarMode_UNKNOWN;
        }
        if (i == 1) {
            return PrivacyBarMode_NONE;
        }
        if (i != 2) {
            return null;
        }
        return PrivacyBarMode_SPAM;
    }

    @Override // com.google.protobuf.B.c
    public final int getNumber() {
        if (this != UNRECOGNIZED) {
            return this.a;
        }
        throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
    }
}
