package ir.nasim;

import com.google.protobuf.B;

/* loaded from: classes8.dex */
public enum UD3 implements B.c {
    JS_PENDING(0),
    JS_RUNNING(1),
    JS_SUCCESS(2),
    JS_FAILED(3),
    UNRECOGNIZED(-1);

    private static final B.d g = new B.d() { // from class: ir.nasim.UD3.a
        @Override // com.google.protobuf.B.d
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public UD3 a(int i) {
            return UD3.j(i);
        }
    };
    private final int a;

    UD3(int i) {
        this.a = i;
    }

    public static UD3 j(int i) {
        if (i == 0) {
            return JS_PENDING;
        }
        if (i == 1) {
            return JS_RUNNING;
        }
        if (i == 2) {
            return JS_SUCCESS;
        }
        if (i != 3) {
            return null;
        }
        return JS_FAILED;
    }

    @Override // com.google.protobuf.B.c
    public final int getNumber() {
        if (this != UNRECOGNIZED) {
            return this.a;
        }
        throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
    }
}
