package ir.nasim;

import com.google.protobuf.B;

/* loaded from: classes.dex */
public enum DM7 implements B.c {
    PrivacyStatus_EVERYONE(0),
    PrivacyStatus_CONTACTS(1),
    PrivacyStatus_NOBODY(2),
    UNRECOGNIZED(-1);

    private static final B.d f = new B.d() { // from class: ir.nasim.DM7.a
        @Override // com.google.protobuf.B.d
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public DM7 a(int i) {
            return DM7.j(i);
        }
    };
    private final int a;

    DM7(int i) {
        this.a = i;
    }

    public static DM7 j(int i) {
        if (i == 0) {
            return PrivacyStatus_EVERYONE;
        }
        if (i == 1) {
            return PrivacyStatus_CONTACTS;
        }
        if (i != 2) {
            return null;
        }
        return PrivacyStatus_NOBODY;
    }

    @Override // com.google.protobuf.B.c
    public final int getNumber() {
        if (this != UNRECOGNIZED) {
            return this.a;
        }
        throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
    }
}
