package ir.nasim;

import com.google.protobuf.B;

/* renamed from: ir.nasim.Jh, reason: case insensitive filesystem */
/* loaded from: classes9.dex */
public enum EnumC5424Jh implements B.c {
    UserDataRejectionReason_UNKNOWN(0),
    UserDataRejectionReason_INVALIDADDRESS(1),
    UserDataRejectionReason_INVALIDPOSTALCODE(2),
    UserDataRejectionReason_INVALIDBANKNUMBER(3),
    UNRECOGNIZED(-1);

    private static final B.d g = new B.d() { // from class: ir.nasim.Jh.a
        @Override // com.google.protobuf.B.d
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public EnumC5424Jh a(int i) {
            return EnumC5424Jh.j(i);
        }
    };
    private final int a;

    EnumC5424Jh(int i) {
        this.a = i;
    }

    public static EnumC5424Jh j(int i) {
        if (i == 0) {
            return UserDataRejectionReason_UNKNOWN;
        }
        if (i == 1) {
            return UserDataRejectionReason_INVALIDADDRESS;
        }
        if (i == 2) {
            return UserDataRejectionReason_INVALIDPOSTALCODE;
        }
        if (i != 3) {
            return null;
        }
        return UserDataRejectionReason_INVALIDBANKNUMBER;
    }

    @Override // com.google.protobuf.B.c
    public final int getNumber() {
        if (this != UNRECOGNIZED) {
            return this.a;
        }
        throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
    }
}
