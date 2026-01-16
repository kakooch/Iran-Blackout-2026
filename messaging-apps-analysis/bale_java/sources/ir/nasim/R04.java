package ir.nasim;

import com.google.protobuf.B;

/* loaded from: classes9.dex */
public enum R04 implements B.c {
    CallType_UNKNOWN(0),
    CallType_INTERNAL(1),
    CallType_SIP(2),
    CallType_SIP_AND_INTERNAL(3),
    UNRECOGNIZED(-1);

    private static final B.d g = new B.d() { // from class: ir.nasim.R04.a
        @Override // com.google.protobuf.B.d
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public R04 a(int i) {
            return R04.j(i);
        }
    };
    private final int a;

    R04(int i) {
        this.a = i;
    }

    public static R04 j(int i) {
        if (i == 0) {
            return CallType_UNKNOWN;
        }
        if (i == 1) {
            return CallType_INTERNAL;
        }
        if (i == 2) {
            return CallType_SIP;
        }
        if (i != 3) {
            return null;
        }
        return CallType_SIP_AND_INTERNAL;
    }

    @Override // com.google.protobuf.B.c
    public final int getNumber() {
        if (this != UNRECOGNIZED) {
            return this.a;
        }
        throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
    }
}
