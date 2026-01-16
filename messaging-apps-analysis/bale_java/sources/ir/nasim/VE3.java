package ir.nasim;

import com.google.protobuf.B;

/* loaded from: classes8.dex */
public enum VE3 implements B.c {
    RR_UNKNOWN(0),
    RR_SIGNAL_DISCONNECTED(1),
    RR_PUBLISHER_FAILED(2),
    RR_SUBSCRIBER_FAILED(3),
    RR_SWITCH_CANDIDATE(4),
    UNRECOGNIZED(-1);

    private static final B.d h = new B.d() { // from class: ir.nasim.VE3.a
        @Override // com.google.protobuf.B.d
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public VE3 a(int i2) {
            return VE3.j(i2);
        }
    };
    private final int a;

    VE3(int i2) {
        this.a = i2;
    }

    public static VE3 j(int i2) {
        if (i2 == 0) {
            return RR_UNKNOWN;
        }
        if (i2 == 1) {
            return RR_SIGNAL_DISCONNECTED;
        }
        if (i2 == 2) {
            return RR_PUBLISHER_FAILED;
        }
        if (i2 == 3) {
            return RR_SUBSCRIBER_FAILED;
        }
        if (i2 != 4) {
            return null;
        }
        return RR_SWITCH_CANDIDATE;
    }

    @Override // com.google.protobuf.B.c
    public final int getNumber() {
        if (this != UNRECOGNIZED) {
            return this.a;
        }
        throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
    }
}
