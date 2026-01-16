package ir.nasim;

import com.google.protobuf.B;

/* loaded from: classes8.dex */
public enum BE3 implements B.c {
    RTMP_INPUT(0),
    WHIP_INPUT(1),
    URL_INPUT(2),
    UNRECOGNIZED(-1);

    private static final B.d f = new B.d() { // from class: ir.nasim.BE3.a
        @Override // com.google.protobuf.B.d
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public BE3 a(int i) {
            return BE3.j(i);
        }
    };
    private final int a;

    BE3(int i) {
        this.a = i;
    }

    public static BE3 j(int i) {
        if (i == 0) {
            return RTMP_INPUT;
        }
        if (i == 1) {
            return WHIP_INPUT;
        }
        if (i != 2) {
            return null;
        }
        return URL_INPUT;
    }

    @Override // com.google.protobuf.B.c
    public final int getNumber() {
        if (this != UNRECOGNIZED) {
            return this.a;
        }
        throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
    }
}
