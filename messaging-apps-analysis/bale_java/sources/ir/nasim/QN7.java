package ir.nasim;

import com.google.protobuf.B;

/* loaded from: classes3.dex */
public enum QN7 implements B.c {
    UNKNOWN(0),
    HTTP_HEADER_NAME(1),
    HTTP_HEADER_VALUE(2);

    private static final B.d e = new B.d() { // from class: ir.nasim.QN7.a
        @Override // com.google.protobuf.B.d
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public QN7 a(int i) {
            return QN7.j(i);
        }
    };
    private final int a;

    private static final class b implements B.e {
        static final B.e a = new b();

        private b() {
        }

        @Override // com.google.protobuf.B.e
        public boolean a(int i) {
            return QN7.j(i) != null;
        }
    }

    QN7(int i) {
        this.a = i;
    }

    public static QN7 j(int i) {
        if (i == 0) {
            return UNKNOWN;
        }
        if (i == 1) {
            return HTTP_HEADER_NAME;
        }
        if (i != 2) {
            return null;
        }
        return HTTP_HEADER_VALUE;
    }

    public static B.e p() {
        return b.a;
    }

    @Override // com.google.protobuf.B.c
    public final int getNumber() {
        return this.a;
    }
}
