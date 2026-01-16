package ir.nasim;

import com.google.protobuf.B;

/* loaded from: classes8.dex */
public enum SE3 implements B.c {
    IC_DEFAULT(0),
    IC_JPEG(1),
    UNRECOGNIZED(-1);

    private static final B.d e = new B.d() { // from class: ir.nasim.SE3.a
        @Override // com.google.protobuf.B.d
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public SE3 a(int i) {
            return SE3.j(i);
        }
    };
    private final int a;

    SE3(int i) {
        this.a = i;
    }

    public static SE3 j(int i) {
        if (i == 0) {
            return IC_DEFAULT;
        }
        if (i != 1) {
            return null;
        }
        return IC_JPEG;
    }

    @Override // com.google.protobuf.B.c
    public final int getNumber() {
        if (this != UNRECOGNIZED) {
            return this.a;
        }
        throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
    }
}
