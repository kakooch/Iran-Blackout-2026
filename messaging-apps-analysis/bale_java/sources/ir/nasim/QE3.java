package ir.nasim;

import com.google.protobuf.B;

/* loaded from: classes8.dex */
public enum QE3 implements B.c {
    POOR(0),
    GOOD(1),
    EXCELLENT(2),
    LOST(3),
    UNRECOGNIZED(-1);

    private static final B.d g = new B.d() { // from class: ir.nasim.QE3.a
        @Override // com.google.protobuf.B.d
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public QE3 a(int i) {
            return QE3.j(i);
        }
    };
    private final int a;

    QE3(int i) {
        this.a = i;
    }

    public static QE3 j(int i) {
        if (i == 0) {
            return POOR;
        }
        if (i == 1) {
            return GOOD;
        }
        if (i == 2) {
            return EXCELLENT;
        }
        if (i != 3) {
            return null;
        }
        return LOST;
    }

    @Override // com.google.protobuf.B.c
    public final int getNumber() {
        if (this != UNRECOGNIZED) {
            return this.a;
        }
        throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
    }
}
