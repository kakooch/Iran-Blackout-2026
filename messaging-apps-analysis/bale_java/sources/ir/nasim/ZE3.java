package ir.nasim;

import com.google.protobuf.B;

/* loaded from: classes8.dex */
public enum ZE3 implements B.c {
    SE_UNKNOWN(0),
    SE_CODEC_UNSUPPORTED(1),
    SE_TRACK_NOTFOUND(2),
    UNRECOGNIZED(-1);

    private static final B.d f = new B.d() { // from class: ir.nasim.ZE3.a
        @Override // com.google.protobuf.B.d
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public ZE3 a(int i) {
            return ZE3.j(i);
        }
    };
    private final int a;

    ZE3(int i) {
        this.a = i;
    }

    public static ZE3 j(int i) {
        if (i == 0) {
            return SE_UNKNOWN;
        }
        if (i == 1) {
            return SE_CODEC_UNSUPPORTED;
        }
        if (i != 2) {
            return null;
        }
        return SE_TRACK_NOTFOUND;
    }

    @Override // com.google.protobuf.B.c
    public final int getNumber() {
        if (this != UNRECOGNIZED) {
            return this.a;
        }
        throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
    }
}
