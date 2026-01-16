package ir.nasim;

import com.google.protobuf.B;

/* renamed from: ir.nasim.xf, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public enum EnumC23867xf implements B.c {
    AccountState_UNKNOWN(0),
    AccountState_AWAITINGDOCUMENTSUBMISSION(1),
    AccountState_AWAITINGVERIFICATION(2),
    AccountState_ACTION(3),
    AccountState_DOCSREJECTED(4),
    AccountState_SUSPENDED(5),
    AccountState_BANNED(6),
    UNRECOGNIZED(-1);

    private static final B.d j = new B.d() { // from class: ir.nasim.xf.a
        @Override // com.google.protobuf.B.d
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public EnumC23867xf a(int i) {
            return EnumC23867xf.j(i);
        }
    };
    private final int a;

    EnumC23867xf(int i) {
        this.a = i;
    }

    public static EnumC23867xf j(int i) {
        switch (i) {
            case 0:
                return AccountState_UNKNOWN;
            case 1:
                return AccountState_AWAITINGDOCUMENTSUBMISSION;
            case 2:
                return AccountState_AWAITINGVERIFICATION;
            case 3:
                return AccountState_ACTION;
            case 4:
                return AccountState_DOCSREJECTED;
            case 5:
                return AccountState_SUSPENDED;
            case 6:
                return AccountState_BANNED;
            default:
                return null;
        }
    }

    @Override // com.google.protobuf.B.c
    public final int getNumber() {
        if (this != UNRECOGNIZED) {
            return this.a;
        }
        throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
    }
}
