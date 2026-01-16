package ir.nasim;

import com.google.protobuf.B;

/* loaded from: classes8.dex */
public enum WD3 implements B.c {
    WS_AVAILABLE(0),
    WS_FULL(1),
    UNRECOGNIZED(-1);

    private static final B.d e = new B.d() { // from class: ir.nasim.WD3.a
        @Override // com.google.protobuf.B.d
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public WD3 a(int i) {
            return WD3.j(i);
        }
    };
    private final int a;

    WD3(int i) {
        this.a = i;
    }

    public static WD3 j(int i) {
        if (i == 0) {
            return WS_AVAILABLE;
        }
        if (i != 1) {
            return null;
        }
        return WS_FULL;
    }

    @Override // com.google.protobuf.B.c
    public final int getNumber() {
        if (this != UNRECOGNIZED) {
            return this.a;
        }
        throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
    }
}
