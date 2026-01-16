package ir.nasim;

import com.google.protobuf.B;

/* loaded from: classes2.dex */
public enum G55 implements B.c {
    PersonGender_MALE(0),
    PersonGender_FEMALE(1),
    PersonGender_UNKNOWN(2),
    UNRECOGNIZED(-1);

    private static final B.d f = new B.d() { // from class: ir.nasim.G55.a
        @Override // com.google.protobuf.B.d
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public G55 a(int i) {
            return G55.j(i);
        }
    };
    private final int a;

    G55(int i) {
        this.a = i;
    }

    public static G55 j(int i) {
        if (i == 0) {
            return PersonGender_MALE;
        }
        if (i == 1) {
            return PersonGender_FEMALE;
        }
        if (i != 2) {
            return null;
        }
        return PersonGender_UNKNOWN;
    }

    @Override // com.google.protobuf.B.c
    public final int getNumber() {
        if (this != UNRECOGNIZED) {
            return this.a;
        }
        throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
    }
}
