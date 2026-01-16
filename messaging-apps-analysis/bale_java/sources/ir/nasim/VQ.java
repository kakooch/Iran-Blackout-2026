package ir.nasim;

import com.google.protobuf.B;

/* loaded from: classes9.dex */
public enum VQ implements B.c {
    AuthHolder_THISDEVICE(0),
    AuthHolder_OTHERDEVICE(1),
    UNRECOGNIZED(-1);

    private static final B.d e = new B.d() { // from class: ir.nasim.VQ.a
        @Override // com.google.protobuf.B.d
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public VQ a(int i) {
            return VQ.j(i);
        }
    };
    private final int a;

    VQ(int i) {
        this.a = i;
    }

    public static VQ j(int i) {
        if (i == 0) {
            return AuthHolder_THISDEVICE;
        }
        if (i != 1) {
            return null;
        }
        return AuthHolder_OTHERDEVICE;
    }

    @Override // com.google.protobuf.B.c
    public final int getNumber() {
        if (this != UNRECOGNIZED) {
            return this.a;
        }
        throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
    }
}
