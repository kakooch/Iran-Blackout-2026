package ir.nasim;

import com.google.protobuf.B;

/* loaded from: classes9.dex */
public enum CG implements B.c {
    FULLSCREEN(0),
    FULL_SIZE(1),
    COMPACT(2),
    UNRECOGNIZED(-1);

    private static final B.d f = new B.d() { // from class: ir.nasim.CG.a
        @Override // com.google.protobuf.B.d
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public CG a(int i) {
            return CG.j(i);
        }
    };
    private final int a;

    CG(int i) {
        this.a = i;
    }

    public static CG j(int i) {
        if (i == 0) {
            return FULLSCREEN;
        }
        if (i == 1) {
            return FULL_SIZE;
        }
        if (i != 2) {
            return null;
        }
        return COMPACT;
    }

    @Override // com.google.protobuf.B.c
    public final int getNumber() {
        if (this != UNRECOGNIZED) {
            return this.a;
        }
        throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
    }
}
