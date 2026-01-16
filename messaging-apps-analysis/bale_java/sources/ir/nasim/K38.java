package ir.nasim;

import com.google.protobuf.B;

/* loaded from: classes.dex */
public enum K38 implements B.c {
    AgreementStatus_ACTIVE(0),
    AgreementStatus_INACTIVE(1),
    UNRECOGNIZED(-1);

    private static final B.d e = new B.d() { // from class: ir.nasim.K38.a
        @Override // com.google.protobuf.B.d
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public K38 a(int i) {
            return K38.j(i);
        }
    };
    private final int a;

    K38(int i) {
        this.a = i;
    }

    public static K38 j(int i) {
        if (i == 0) {
            return AgreementStatus_ACTIVE;
        }
        if (i != 1) {
            return null;
        }
        return AgreementStatus_INACTIVE;
    }

    @Override // com.google.protobuf.B.c
    public final int getNumber() {
        if (this != UNRECOGNIZED) {
            return this.a;
        }
        throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
    }
}
