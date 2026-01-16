package ir.nasim;

import com.google.protobuf.B;

/* loaded from: classes8.dex */
public enum EF3 implements B.c {
    STS_TRANSFER_ONGOING(0),
    STS_TRANSFER_FAILED(1),
    STS_TRANSFER_SUCCESSFUL(2),
    UNRECOGNIZED(-1);

    private static final B.d f = new B.d() { // from class: ir.nasim.EF3.a
        @Override // com.google.protobuf.B.d
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public EF3 a(int i) {
            return EF3.j(i);
        }
    };
    private final int a;

    EF3(int i) {
        this.a = i;
    }

    public static EF3 j(int i) {
        if (i == 0) {
            return STS_TRANSFER_ONGOING;
        }
        if (i == 1) {
            return STS_TRANSFER_FAILED;
        }
        if (i != 2) {
            return null;
        }
        return STS_TRANSFER_SUCCESSFUL;
    }

    @Override // com.google.protobuf.B.c
    public final int getNumber() {
        if (this != UNRECOGNIZED) {
            return this.a;
        }
        throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
    }
}
