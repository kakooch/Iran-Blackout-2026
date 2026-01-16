package ir.nasim;

import com.google.protobuf.B;

/* loaded from: classes.dex */
public enum EM7 implements B.c {
    PrivacyType_INVITE(0),
    PrivacyType_PRESENCE(1),
    PrivacyType_MONEY_TRANSFER(2),
    UNRECOGNIZED(-1);

    private static final B.d f = new B.d() { // from class: ir.nasim.EM7.a
        @Override // com.google.protobuf.B.d
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public EM7 a(int i) {
            return EM7.j(i);
        }
    };
    private final int a;

    EM7(int i) {
        this.a = i;
    }

    public static EM7 j(int i) {
        if (i == 0) {
            return PrivacyType_INVITE;
        }
        if (i == 1) {
            return PrivacyType_PRESENCE;
        }
        if (i != 2) {
            return null;
        }
        return PrivacyType_MONEY_TRANSFER;
    }

    @Override // com.google.protobuf.B.c
    public final int getNumber() {
        if (this != UNRECOGNIZED) {
            return this.a;
        }
        throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
    }
}
