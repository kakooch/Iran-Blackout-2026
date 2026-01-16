package ir.nasim;

import com.google.protobuf.B;

/* renamed from: ir.nasim.aF3, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public enum EnumC9607aF3 implements B.c {
    UNKNOWN(0),
    CAMERA(1),
    MICROPHONE(2),
    SCREEN_SHARE(3),
    SCREEN_SHARE_AUDIO(4),
    UNRECOGNIZED(-1);

    private static final B.d h = new B.d() { // from class: ir.nasim.aF3.a
        @Override // com.google.protobuf.B.d
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public EnumC9607aF3 a(int i2) {
            return EnumC9607aF3.j(i2);
        }
    };
    private final int a;

    EnumC9607aF3(int i2) {
        this.a = i2;
    }

    public static EnumC9607aF3 j(int i2) {
        if (i2 == 0) {
            return UNKNOWN;
        }
        if (i2 == 1) {
            return CAMERA;
        }
        if (i2 == 2) {
            return MICROPHONE;
        }
        if (i2 == 3) {
            return SCREEN_SHARE;
        }
        if (i2 != 4) {
            return null;
        }
        return SCREEN_SHARE_AUDIO;
    }

    @Override // com.google.protobuf.B.c
    public final int getNumber() {
        if (this != UNRECOGNIZED) {
            return this.a;
        }
        throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
    }
}
