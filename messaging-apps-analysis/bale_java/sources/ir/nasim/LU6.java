package ir.nasim;

import com.google.protobuf.B;

/* loaded from: classes.dex */
public enum LU6 implements B.c {
    StoryOptimization_Unknown(0),
    StoryOptimization_SpecialStoriesList(1),
    UNRECOGNIZED(-1);

    private static final B.d e = new B.d() { // from class: ir.nasim.LU6.a
        @Override // com.google.protobuf.B.d
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public LU6 a(int i) {
            return LU6.j(i);
        }
    };
    private final int a;

    LU6(int i) {
        this.a = i;
    }

    public static LU6 j(int i) {
        if (i == 0) {
            return StoryOptimization_Unknown;
        }
        if (i != 1) {
            return null;
        }
        return StoryOptimization_SpecialStoriesList;
    }

    @Override // com.google.protobuf.B.c
    public final int getNumber() {
        if (this != UNRECOGNIZED) {
            return this.a;
        }
        throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
    }
}
