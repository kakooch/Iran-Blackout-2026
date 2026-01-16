package ir.nasim;

import com.google.protobuf.B;

/* loaded from: classes9.dex */
public enum L04 implements B.c {
    CallEventType_UNKNOWN(0),
    CallEventType_RECORD_COUNTDOWN(1),
    UNRECOGNIZED(-1);

    private static final B.d e = new B.d() { // from class: ir.nasim.L04.a
        @Override // com.google.protobuf.B.d
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public L04 a(int i) {
            return L04.j(i);
        }
    };
    private final int a;

    L04(int i) {
        this.a = i;
    }

    public static L04 j(int i) {
        if (i == 0) {
            return CallEventType_UNKNOWN;
        }
        if (i != 1) {
            return null;
        }
        return CallEventType_RECORD_COUNTDOWN;
    }

    @Override // com.google.protobuf.B.c
    public final int getNumber() {
        if (this != UNRECOGNIZED) {
            return this.a;
        }
        throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
    }
}
