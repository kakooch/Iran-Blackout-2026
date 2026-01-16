package ir.nasim;

import com.google.protobuf.B;

/* renamed from: ir.nasim.h14, reason: case insensitive filesystem */
/* loaded from: classes9.dex */
public enum EnumC13908h14 implements B.c {
    PrivateCallLogStatus_UNKNOWN(0),
    PrivateCallLogStatus_ANSWERED(1),
    PrivateCallLogStatus_MISSED(2),
    PrivateCallLogStatus_REJECTED(3),
    PrivateCallLogStatus_BUSY(4),
    PrivateCallLogStatus_DISCONNECTED(5),
    UNRECOGNIZED(-1);

    private static final B.d i = new B.d() { // from class: ir.nasim.h14.a
        @Override // com.google.protobuf.B.d
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public EnumC13908h14 a(int i2) {
            return EnumC13908h14.j(i2);
        }
    };
    private final int a;

    EnumC13908h14(int i2) {
        this.a = i2;
    }

    public static EnumC13908h14 j(int i2) {
        if (i2 == 0) {
            return PrivateCallLogStatus_UNKNOWN;
        }
        if (i2 == 1) {
            return PrivateCallLogStatus_ANSWERED;
        }
        if (i2 == 2) {
            return PrivateCallLogStatus_MISSED;
        }
        if (i2 == 3) {
            return PrivateCallLogStatus_REJECTED;
        }
        if (i2 == 4) {
            return PrivateCallLogStatus_BUSY;
        }
        if (i2 != 5) {
            return null;
        }
        return PrivateCallLogStatus_DISCONNECTED;
    }

    @Override // com.google.protobuf.B.c
    public final int getNumber() {
        if (this != UNRECOGNIZED) {
            return this.a;
        }
        throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
    }
}
