package ir.nasim;

import com.google.protobuf.B;

/* loaded from: classes.dex */
public enum S96 implements B.c {
    MessageType_UNKNOWN(0),
    MessageType_INFORMATION(1),
    MessageType_OTP(2),
    MessageType_SECURE(3),
    MessageType_MULTIMEDIA(4),
    UNRECOGNIZED(-1);

    private static final B.d h = new B.d() { // from class: ir.nasim.S96.a
        @Override // com.google.protobuf.B.d
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public S96 a(int i2) {
            return S96.j(i2);
        }
    };
    private final int a;

    S96(int i2) {
        this.a = i2;
    }

    public static S96 j(int i2) {
        if (i2 == 0) {
            return MessageType_UNKNOWN;
        }
        if (i2 == 1) {
            return MessageType_INFORMATION;
        }
        if (i2 == 2) {
            return MessageType_OTP;
        }
        if (i2 == 3) {
            return MessageType_SECURE;
        }
        if (i2 != 4) {
            return null;
        }
        return MessageType_MULTIMEDIA;
    }

    @Override // com.google.protobuf.B.c
    public final int getNumber() {
        if (this != UNRECOGNIZED) {
            return this.a;
        }
        throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
    }
}
