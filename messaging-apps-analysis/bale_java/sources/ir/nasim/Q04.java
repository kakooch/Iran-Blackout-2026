package ir.nasim;

import com.google.protobuf.B;

/* loaded from: classes9.dex */
public enum Q04 implements B.c {
    CallStatus_UNKNOWN(0),
    CallStatus_HOLD(1),
    CallStatus_RESUME(2),
    UNRECOGNIZED(-1);

    private static final B.d f = new B.d() { // from class: ir.nasim.Q04.a
        @Override // com.google.protobuf.B.d
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public Q04 a(int i) {
            return Q04.j(i);
        }
    };
    private final int a;

    Q04(int i) {
        this.a = i;
    }

    public static Q04 j(int i) {
        if (i == 0) {
            return CallStatus_UNKNOWN;
        }
        if (i == 1) {
            return CallStatus_HOLD;
        }
        if (i != 2) {
            return null;
        }
        return CallStatus_RESUME;
    }

    @Override // com.google.protobuf.B.c
    public final int getNumber() {
        if (this != UNRECOGNIZED) {
            return this.a;
        }
        throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
    }
}
