package ir.nasim;

import com.google.protobuf.B;

/* loaded from: classes9.dex */
public enum R60 implements B.c {
    MoneyRequestDetailResponseType_MINE(0),
    MoneyRequestDetailResponseType_OTHERS(1),
    UNRECOGNIZED(-1);

    private static final B.d e = new B.d() { // from class: ir.nasim.R60.a
        @Override // com.google.protobuf.B.d
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public R60 a(int i) {
            return R60.j(i);
        }
    };
    private final int a;

    R60(int i) {
        this.a = i;
    }

    public static R60 j(int i) {
        if (i == 0) {
            return MoneyRequestDetailResponseType_MINE;
        }
        if (i != 1) {
            return null;
        }
        return MoneyRequestDetailResponseType_OTHERS;
    }

    @Override // com.google.protobuf.B.c
    public final int getNumber() {
        if (this != UNRECOGNIZED) {
            return this.a;
        }
        throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
    }
}
