package ir.nasim;

import com.google.protobuf.B;

/* loaded from: classes9.dex */
public enum F75 implements B.c {
    PfmUserTagsType_UNKNOWN(0),
    PfmUserTagsType_WITHNOCHILD(1),
    PfmUserTagsType_WITHCHILD(2),
    UNRECOGNIZED(-1);

    private static final B.d f = new B.d() { // from class: ir.nasim.F75.a
        @Override // com.google.protobuf.B.d
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public F75 a(int i) {
            return F75.j(i);
        }
    };
    private final int a;

    F75(int i) {
        this.a = i;
    }

    public static F75 j(int i) {
        if (i == 0) {
            return PfmUserTagsType_UNKNOWN;
        }
        if (i == 1) {
            return PfmUserTagsType_WITHNOCHILD;
        }
        if (i != 2) {
            return null;
        }
        return PfmUserTagsType_WITHCHILD;
    }

    @Override // com.google.protobuf.B.c
    public final int getNumber() {
        if (this != UNRECOGNIZED) {
            return this.a;
        }
        throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
    }
}
