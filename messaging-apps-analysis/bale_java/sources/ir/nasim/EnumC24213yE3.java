package ir.nasim;

import com.google.protobuf.B;

/* renamed from: ir.nasim.yE3, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public enum EnumC24213yE3 implements B.c {
    DEFAULT_PROTOCOL(0),
    RTMP(1),
    SRT(2),
    UNRECOGNIZED(-1);

    private static final B.d f = new B.d() { // from class: ir.nasim.yE3.a
        @Override // com.google.protobuf.B.d
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public EnumC24213yE3 a(int i) {
            return EnumC24213yE3.j(i);
        }
    };
    private final int a;

    EnumC24213yE3(int i) {
        this.a = i;
    }

    public static EnumC24213yE3 j(int i) {
        if (i == 0) {
            return DEFAULT_PROTOCOL;
        }
        if (i == 1) {
            return RTMP;
        }
        if (i != 2) {
            return null;
        }
        return SRT;
    }

    @Override // com.google.protobuf.B.c
    public final int getNumber() {
        if (this != UNRECOGNIZED) {
            return this.a;
        }
        throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
    }
}
