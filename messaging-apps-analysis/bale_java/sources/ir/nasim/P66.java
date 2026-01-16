package ir.nasim;

import com.google.protobuf.B;

/* loaded from: classes.dex */
public enum P66 implements B.c {
    Unknown(0),
    Web(1),
    Android(2),
    Ios(3),
    UNRECOGNIZED(-1);

    private static final B.d g = new B.d() { // from class: ir.nasim.P66.a
        @Override // com.google.protobuf.B.d
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public P66 a(int i) {
            return P66.j(i);
        }
    };
    private final int a;

    P66(int i) {
        this.a = i;
    }

    public static P66 j(int i) {
        if (i == 0) {
            return Unknown;
        }
        if (i == 1) {
            return Web;
        }
        if (i == 2) {
            return Android;
        }
        if (i != 3) {
            return null;
        }
        return Ios;
    }

    @Override // com.google.protobuf.B.c
    public final int getNumber() {
        if (this != UNRECOGNIZED) {
            return this.a;
        }
        throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
    }
}
