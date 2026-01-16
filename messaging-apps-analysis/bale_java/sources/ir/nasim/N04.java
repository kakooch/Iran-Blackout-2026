package ir.nasim;

import com.google.protobuf.B;

/* loaded from: classes9.dex */
public enum N04 implements B.c {
    CallMode_UKNOWN(0),
    CallMode_PRIVATE(1),
    CallMode_GROUP(2),
    CallMode_MULTIPEER(3),
    CallMode_CHANNEL_LIVE(4),
    UNRECOGNIZED(-1);

    private static final B.d h = new B.d() { // from class: ir.nasim.N04.a
        @Override // com.google.protobuf.B.d
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public N04 a(int i2) {
            return N04.j(i2);
        }
    };
    private final int a;

    N04(int i2) {
        this.a = i2;
    }

    public static N04 j(int i2) {
        if (i2 == 0) {
            return CallMode_UKNOWN;
        }
        if (i2 == 1) {
            return CallMode_PRIVATE;
        }
        if (i2 == 2) {
            return CallMode_GROUP;
        }
        if (i2 == 3) {
            return CallMode_MULTIPEER;
        }
        if (i2 != 4) {
            return null;
        }
        return CallMode_CHANNEL_LIVE;
    }

    @Override // com.google.protobuf.B.c
    public final int getNumber() {
        if (this != UNRECOGNIZED) {
            return this.a;
        }
        throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
    }
}
