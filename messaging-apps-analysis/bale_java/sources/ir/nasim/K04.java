package ir.nasim;

import com.google.protobuf.B;

/* loaded from: classes9.dex */
public enum K04 implements B.c {
    CallDiscardReason_UNKNOWN(0),
    CallDiscardReason_MISSED(1),
    CallDiscardReason_DISCONNECT(2),
    CallDiscardReason_HANGUP(3),
    CallDiscardReason_BUSY(4),
    UNRECOGNIZED(-1);

    private static final B.d h = new B.d() { // from class: ir.nasim.K04.a
        @Override // com.google.protobuf.B.d
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public K04 a(int i2) {
            return K04.j(i2);
        }
    };
    private final int a;

    K04(int i2) {
        this.a = i2;
    }

    public static K04 j(int i2) {
        if (i2 == 0) {
            return CallDiscardReason_UNKNOWN;
        }
        if (i2 == 1) {
            return CallDiscardReason_MISSED;
        }
        if (i2 == 2) {
            return CallDiscardReason_DISCONNECT;
        }
        if (i2 == 3) {
            return CallDiscardReason_HANGUP;
        }
        if (i2 != 4) {
            return null;
        }
        return CallDiscardReason_BUSY;
    }

    @Override // com.google.protobuf.B.c
    public final int getNumber() {
        if (this != UNRECOGNIZED) {
            return this.a;
        }
        throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
    }
}
