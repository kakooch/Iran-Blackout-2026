package ir.nasim;

import com.google.protobuf.B;

/* loaded from: classes9.dex */
public enum GS2 implements B.c {
    Restriction_PRIVATE(0),
    Restriction_PUBLIC(1),
    UNRECOGNIZED(-1);

    private static final B.d e = new B.d() { // from class: ir.nasim.GS2.a
        @Override // com.google.protobuf.B.d
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public GS2 a(int i) {
            return GS2.j(i);
        }
    };
    private final int a;

    GS2(int i) {
        this.a = i;
    }

    public static GS2 j(int i) {
        if (i == 0) {
            return Restriction_PRIVATE;
        }
        if (i != 1) {
            return null;
        }
        return Restriction_PUBLIC;
    }

    @Override // com.google.protobuf.B.c
    public final int getNumber() {
        if (this != UNRECOGNIZED) {
            return this.a;
        }
        throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
    }
}
