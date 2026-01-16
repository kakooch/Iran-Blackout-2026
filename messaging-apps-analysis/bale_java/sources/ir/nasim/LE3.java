package ir.nasim;

import com.google.protobuf.B;

/* loaded from: classes8.dex */
public enum LE3 implements B.c {
    DEFAULT_AC(0),
    OPUS(1),
    AAC(2),
    UNRECOGNIZED(-1);

    private static final B.d f = new B.d() { // from class: ir.nasim.LE3.a
        @Override // com.google.protobuf.B.d
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public LE3 a(int i) {
            return LE3.j(i);
        }
    };
    private final int a;

    LE3(int i) {
        this.a = i;
    }

    public static LE3 j(int i) {
        if (i == 0) {
            return DEFAULT_AC;
        }
        if (i == 1) {
            return OPUS;
        }
        if (i != 2) {
            return null;
        }
        return AAC;
    }

    @Override // com.google.protobuf.B.c
    public final int getNumber() {
        if (this != UNRECOGNIZED) {
            return this.a;
        }
        throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
    }
}
