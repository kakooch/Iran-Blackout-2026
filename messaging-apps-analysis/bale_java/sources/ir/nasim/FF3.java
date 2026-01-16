package ir.nasim;

import com.google.protobuf.B;

/* loaded from: classes8.dex */
public enum FF3 implements B.c {
    SIP_TRANSPORT_AUTO(0),
    SIP_TRANSPORT_UDP(1),
    SIP_TRANSPORT_TCP(2),
    SIP_TRANSPORT_TLS(3),
    UNRECOGNIZED(-1);

    private static final B.d g = new B.d() { // from class: ir.nasim.FF3.a
        @Override // com.google.protobuf.B.d
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public FF3 a(int i) {
            return FF3.j(i);
        }
    };
    private final int a;

    FF3(int i) {
        this.a = i;
    }

    public static FF3 j(int i) {
        if (i == 0) {
            return SIP_TRANSPORT_AUTO;
        }
        if (i == 1) {
            return SIP_TRANSPORT_UDP;
        }
        if (i == 2) {
            return SIP_TRANSPORT_TCP;
        }
        if (i != 3) {
            return null;
        }
        return SIP_TRANSPORT_TLS;
    }

    @Override // com.google.protobuf.B.c
    public final int getNumber() {
        if (this != UNRECOGNIZED) {
            return this.a;
        }
        throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
    }
}
