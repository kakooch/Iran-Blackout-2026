package ir.nasim;

import com.google.protobuf.B;

/* renamed from: ir.nasim.Ch, reason: case insensitive filesystem */
/* loaded from: classes9.dex */
public enum EnumC3771Ch implements B.c {
    Platform_UNKNOWN(0),
    Platform_ANDROID(1),
    Platform_WEB(2),
    Platform_WEBANDANDROID(3),
    UNRECOGNIZED(-1);

    private static final B.d g = new B.d() { // from class: ir.nasim.Ch.a
        @Override // com.google.protobuf.B.d
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public EnumC3771Ch a(int i) {
            return EnumC3771Ch.j(i);
        }
    };
    private final int a;

    EnumC3771Ch(int i) {
        this.a = i;
    }

    public static EnumC3771Ch j(int i) {
        if (i == 0) {
            return Platform_UNKNOWN;
        }
        if (i == 1) {
            return Platform_ANDROID;
        }
        if (i == 2) {
            return Platform_WEB;
        }
        if (i != 3) {
            return null;
        }
        return Platform_WEBANDANDROID;
    }

    @Override // com.google.protobuf.B.c
    public final int getNumber() {
        if (this != UNRECOGNIZED) {
            return this.a;
        }
        throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
    }
}
