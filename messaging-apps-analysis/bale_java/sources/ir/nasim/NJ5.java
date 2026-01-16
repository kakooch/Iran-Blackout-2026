package ir.nasim;

import com.google.protobuf.B;

/* loaded from: classes9.dex */
public enum NJ5 implements B.c {
    RecommendationSource_UNKNOWN(0),
    RecommendationSource_VITRIN(1),
    RecommendationSource_DIALOGS(2),
    RecommendationSource_SEARCH(3),
    UNRECOGNIZED(-1);

    private static final B.d g = new B.d() { // from class: ir.nasim.NJ5.a
        @Override // com.google.protobuf.B.d
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public NJ5 a(int i) {
            return NJ5.j(i);
        }
    };
    private final int a;

    NJ5(int i) {
        this.a = i;
    }

    public static NJ5 j(int i) {
        if (i == 0) {
            return RecommendationSource_UNKNOWN;
        }
        if (i == 1) {
            return RecommendationSource_VITRIN;
        }
        if (i == 2) {
            return RecommendationSource_DIALOGS;
        }
        if (i != 3) {
            return null;
        }
        return RecommendationSource_SEARCH;
    }

    @Override // com.google.protobuf.B.c
    public final int getNumber() {
        if (this != UNRECOGNIZED) {
            return this.a;
        }
        throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
    }
}
