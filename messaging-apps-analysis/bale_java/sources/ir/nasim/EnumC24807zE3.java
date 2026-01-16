package ir.nasim;

import com.google.protobuf.B;

/* renamed from: ir.nasim.zE3, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public enum EnumC24807zE3 implements B.c {
    OPUS_STEREO_96KBPS(0),
    OPUS_MONO_64KBS(1),
    UNRECOGNIZED(-1);

    private static final B.d e = new B.d() { // from class: ir.nasim.zE3.a
        @Override // com.google.protobuf.B.d
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public EnumC24807zE3 a(int i) {
            return EnumC24807zE3.j(i);
        }
    };
    private final int a;

    EnumC24807zE3(int i) {
        this.a = i;
    }

    public static EnumC24807zE3 j(int i) {
        if (i == 0) {
            return OPUS_STEREO_96KBPS;
        }
        if (i != 1) {
            return null;
        }
        return OPUS_MONO_64KBS;
    }

    @Override // com.google.protobuf.B.c
    public final int getNumber() {
        if (this != UNRECOGNIZED) {
            return this.a;
        }
        throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
    }
}
