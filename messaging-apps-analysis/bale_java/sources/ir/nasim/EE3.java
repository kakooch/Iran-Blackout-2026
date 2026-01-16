package ir.nasim;

import com.google.protobuf.B;

/* loaded from: classes8.dex */
public enum EE3 implements B.c {
    STARTING_UP(0),
    SERVING(1),
    SHUTTING_DOWN(2),
    UNRECOGNIZED(-1);

    private static final B.d f = new B.d() { // from class: ir.nasim.EE3.a
        @Override // com.google.protobuf.B.d
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public EE3 a(int i) {
            return EE3.j(i);
        }
    };
    private final int a;

    EE3(int i) {
        this.a = i;
    }

    public static EE3 j(int i) {
        if (i == 0) {
            return STARTING_UP;
        }
        if (i == 1) {
            return SERVING;
        }
        if (i != 2) {
            return null;
        }
        return SHUTTING_DOWN;
    }

    @Override // com.google.protobuf.B.c
    public final int getNumber() {
        if (this != UNRECOGNIZED) {
            return this.a;
        }
        throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
    }
}
