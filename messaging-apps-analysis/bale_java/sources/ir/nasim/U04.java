package ir.nasim;

import com.google.protobuf.B;

/* loaded from: classes9.dex */
public enum U04 implements B.c {
    GroupCallLogStatus_UNKNOWN(0),
    GroupCallLogStatus_JOINED(1),
    GroupCallLogStatus_MISSED(2),
    UNRECOGNIZED(-1);

    private static final B.d f = new B.d() { // from class: ir.nasim.U04.a
        @Override // com.google.protobuf.B.d
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public U04 a(int i) {
            return U04.j(i);
        }
    };
    private final int a;

    U04(int i) {
        this.a = i;
    }

    public static U04 j(int i) {
        if (i == 0) {
            return GroupCallLogStatus_UNKNOWN;
        }
        if (i == 1) {
            return GroupCallLogStatus_JOINED;
        }
        if (i != 2) {
            return null;
        }
        return GroupCallLogStatus_MISSED;
    }

    @Override // com.google.protobuf.B.c
    public final int getNumber() {
        if (this != UNRECOGNIZED) {
            return this.a;
        }
        throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
    }
}
