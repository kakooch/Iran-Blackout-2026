package ir.nasim;

import com.google.protobuf.B;

/* renamed from: ir.nasim.Nt3, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public enum EnumC6487Nt3 implements B.c {
    LAUNCH_STAGE_UNSPECIFIED(0),
    EARLY_ACCESS(1),
    ALPHA(2),
    BETA(3),
    GA(4),
    DEPRECATED(5),
    UNRECOGNIZED(-1);

    private static final B.d i = new B.d() { // from class: ir.nasim.Nt3.a
        @Override // com.google.protobuf.B.d
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public EnumC6487Nt3 a(int i2) {
            return EnumC6487Nt3.a(i2);
        }
    };
    private final int a;

    EnumC6487Nt3(int i2) {
        this.a = i2;
    }

    public static EnumC6487Nt3 a(int i2) {
        if (i2 == 0) {
            return LAUNCH_STAGE_UNSPECIFIED;
        }
        if (i2 == 1) {
            return EARLY_ACCESS;
        }
        if (i2 == 2) {
            return ALPHA;
        }
        if (i2 == 3) {
            return BETA;
        }
        if (i2 == 4) {
            return GA;
        }
        if (i2 != 5) {
            return null;
        }
        return DEPRECATED;
    }

    @Override // com.google.protobuf.B.c
    public final int getNumber() {
        if (this != UNRECOGNIZED) {
            return this.a;
        }
        throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
    }
}
