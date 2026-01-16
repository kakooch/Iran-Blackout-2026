package ir.nasim;

import com.google.protobuf.B;

/* renamed from: ir.nasim.yf, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public enum EnumC24457yf implements B.c {
    AccountType_UNKNOWN(0),
    AccountType_PERSONAL(1),
    AccountType_ORGANIZATION(2),
    UNRECOGNIZED(-1);

    private static final B.d f = new B.d() { // from class: ir.nasim.yf.a
        @Override // com.google.protobuf.B.d
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public EnumC24457yf a(int i) {
            return EnumC24457yf.j(i);
        }
    };
    private final int a;

    EnumC24457yf(int i) {
        this.a = i;
    }

    public static EnumC24457yf j(int i) {
        if (i == 0) {
            return AccountType_UNKNOWN;
        }
        if (i == 1) {
            return AccountType_PERSONAL;
        }
        if (i != 2) {
            return null;
        }
        return AccountType_ORGANIZATION;
    }

    @Override // com.google.protobuf.B.c
    public final int getNumber() {
        if (this != UNRECOGNIZED) {
            return this.a;
        }
        throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
    }
}
