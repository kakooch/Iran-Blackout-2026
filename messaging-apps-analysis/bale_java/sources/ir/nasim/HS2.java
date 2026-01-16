package ir.nasim;

import com.google.protobuf.B;

/* loaded from: classes9.dex */
public enum HS2 implements B.c {
    Source_UNKNOWN(0),
    Source_VITRIN(1),
    Source_DIALOGS(2),
    UNRECOGNIZED(-1);

    private static final B.d f = new B.d() { // from class: ir.nasim.HS2.a
        @Override // com.google.protobuf.B.d
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public HS2 a(int i) {
            return HS2.j(i);
        }
    };
    private final int a;

    HS2(int i) {
        this.a = i;
    }

    public static HS2 j(int i) {
        if (i == 0) {
            return Source_UNKNOWN;
        }
        if (i == 1) {
            return Source_VITRIN;
        }
        if (i != 2) {
            return null;
        }
        return Source_DIALOGS;
    }

    @Override // com.google.protobuf.B.c
    public final int getNumber() {
        if (this != UNRECOGNIZED) {
            return this.a;
        }
        throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
    }
}
