package ir.nasim;

import com.google.protobuf.B;

/* renamed from: ir.nasim.dF3, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public enum EnumC11581dF3 implements B.c {
    DEFAULT_VC(0),
    H264_BASELINE(1),
    H264_MAIN(2),
    H264_HIGH(3),
    VP8(4),
    UNRECOGNIZED(-1);

    private static final B.d h = new B.d() { // from class: ir.nasim.dF3.a
        @Override // com.google.protobuf.B.d
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public EnumC11581dF3 a(int i2) {
            return EnumC11581dF3.j(i2);
        }
    };
    private final int a;

    EnumC11581dF3(int i2) {
        this.a = i2;
    }

    public static EnumC11581dF3 j(int i2) {
        if (i2 == 0) {
            return DEFAULT_VC;
        }
        if (i2 == 1) {
            return H264_BASELINE;
        }
        if (i2 == 2) {
            return H264_MAIN;
        }
        if (i2 == 3) {
            return H264_HIGH;
        }
        if (i2 != 4) {
            return null;
        }
        return VP8;
    }

    @Override // com.google.protobuf.B.c
    public final int getNumber() {
        if (this != UNRECOGNIZED) {
            return this.a;
        }
        throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
    }
}
