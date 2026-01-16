package ir.nasim;

import com.google.protobuf.B;

/* loaded from: classes.dex */
public enum KM7 implements B.c {
    Sex_UNKNOWN(0),
    Sex_MALE(1),
    Sex_FEMALE(2),
    UNRECOGNIZED(-1);

    private static final B.d f = new B.d() { // from class: ir.nasim.KM7.a
        @Override // com.google.protobuf.B.d
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public KM7 a(int i) {
            return KM7.j(i);
        }
    };
    private final int a;

    KM7(int i) {
        this.a = i;
    }

    public static KM7 j(int i) {
        if (i == 0) {
            return Sex_UNKNOWN;
        }
        if (i == 1) {
            return Sex_MALE;
        }
        if (i != 2) {
            return null;
        }
        return Sex_FEMALE;
    }

    @Override // com.google.protobuf.B.c
    public final int getNumber() {
        if (this != UNRECOGNIZED) {
            return this.a;
        }
        throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
    }
}
