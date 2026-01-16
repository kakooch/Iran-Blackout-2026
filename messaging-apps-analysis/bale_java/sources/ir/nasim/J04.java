package ir.nasim;

import com.google.protobuf.B;

/* loaded from: classes9.dex */
public enum J04 implements B.c {
    CallClient_UNKOWN(0),
    CallClient_WEB(1),
    CallClient_ANDROID(2),
    CallClient_IOS(3),
    CallClient_IOS_WEB(4),
    UNRECOGNIZED(-1);

    private static final B.d h = new B.d() { // from class: ir.nasim.J04.a
        @Override // com.google.protobuf.B.d
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public J04 a(int i2) {
            return J04.j(i2);
        }
    };
    private final int a;

    J04(int i2) {
        this.a = i2;
    }

    public static J04 j(int i2) {
        if (i2 == 0) {
            return CallClient_UNKOWN;
        }
        if (i2 == 1) {
            return CallClient_WEB;
        }
        if (i2 == 2) {
            return CallClient_ANDROID;
        }
        if (i2 == 3) {
            return CallClient_IOS;
        }
        if (i2 != 4) {
            return null;
        }
        return CallClient_IOS_WEB;
    }

    @Override // com.google.protobuf.B.c
    public final int getNumber() {
        if (this != UNRECOGNIZED) {
            return this.a;
        }
        throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
    }
}
