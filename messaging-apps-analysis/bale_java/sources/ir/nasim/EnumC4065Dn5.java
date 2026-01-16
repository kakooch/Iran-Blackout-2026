package ir.nasim;

import com.google.protobuf.B;

/* renamed from: ir.nasim.Dn5, reason: case insensitive filesystem */
/* loaded from: classes9.dex */
public enum EnumC4065Dn5 implements B.c {
    MediaFormat_UNKNOWN(0),
    MediaFormat_GIF(1),
    MediaFormat_JSON_LOTTIE(2),
    MediaFormat_PNG(3),
    UNRECOGNIZED(-1);

    private static final B.d g = new B.d() { // from class: ir.nasim.Dn5.a
        @Override // com.google.protobuf.B.d
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public EnumC4065Dn5 a(int i) {
            return EnumC4065Dn5.j(i);
        }
    };
    private final int a;

    EnumC4065Dn5(int i) {
        this.a = i;
    }

    public static EnumC4065Dn5 j(int i) {
        if (i == 0) {
            return MediaFormat_UNKNOWN;
        }
        if (i == 1) {
            return MediaFormat_GIF;
        }
        if (i == 2) {
            return MediaFormat_JSON_LOTTIE;
        }
        if (i != 3) {
            return null;
        }
        return MediaFormat_PNG;
    }

    @Override // com.google.protobuf.B.c
    public final int getNumber() {
        if (this != UNRECOGNIZED) {
            return this.a;
        }
        throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
    }
}
