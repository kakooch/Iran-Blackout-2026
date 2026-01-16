package ir.nasim;

import com.google.protobuf.B;

/* loaded from: classes8.dex */
public enum OE3 implements B.c {
    UNSET(0),
    DISABLED(1),
    ENABLED(2),
    UNRECOGNIZED(-1);

    private static final B.d f = new B.d() { // from class: ir.nasim.OE3.a
        @Override // com.google.protobuf.B.d
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public OE3 a(int i) {
            return OE3.j(i);
        }
    };
    private final int a;

    OE3(int i) {
        this.a = i;
    }

    public static OE3 j(int i) {
        if (i == 0) {
            return UNSET;
        }
        if (i == 1) {
            return DISABLED;
        }
        if (i != 2) {
            return null;
        }
        return ENABLED;
    }

    @Override // com.google.protobuf.B.c
    public final int getNumber() {
        if (this != UNRECOGNIZED) {
            return this.a;
        }
        throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
    }
}
