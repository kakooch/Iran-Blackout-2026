package ir.nasim;

import com.google.protobuf.B;

/* renamed from: ir.nasim.mE3, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public enum EnumC17006mE3 implements B.c {
    DEFAULT_MIXING(0),
    DUAL_CHANNEL_AGENT(1),
    DUAL_CHANNEL_ALTERNATE(2),
    UNRECOGNIZED(-1);

    private static final B.d f = new B.d() { // from class: ir.nasim.mE3.a
        @Override // com.google.protobuf.B.d
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public EnumC17006mE3 a(int i) {
            return EnumC17006mE3.j(i);
        }
    };
    private final int a;

    EnumC17006mE3(int i) {
        this.a = i;
    }

    public static EnumC17006mE3 j(int i) {
        if (i == 0) {
            return DEFAULT_MIXING;
        }
        if (i == 1) {
            return DUAL_CHANNEL_AGENT;
        }
        if (i != 2) {
            return null;
        }
        return DUAL_CHANNEL_ALTERNATE;
    }

    @Override // com.google.protobuf.B.c
    public final int getNumber() {
        if (this != UNRECOGNIZED) {
            return this.a;
        }
        throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
    }
}
