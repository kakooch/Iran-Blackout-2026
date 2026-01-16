package ir.nasim;

import com.google.protobuf.B;

/* renamed from: ir.nasim.dR, reason: case insensitive filesystem */
/* loaded from: classes9.dex */
public enum EnumC11685dR implements B.c {
    WebClientSource_BALE(0),
    WebClientSource_BAM(1),
    WebClientSource_IVA(2),
    UNRECOGNIZED(-1);

    private static final B.d f = new B.d() { // from class: ir.nasim.dR.a
        @Override // com.google.protobuf.B.d
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public EnumC11685dR a(int i) {
            return EnumC11685dR.j(i);
        }
    };
    private final int a;

    EnumC11685dR(int i) {
        this.a = i;
    }

    public static EnumC11685dR j(int i) {
        if (i == 0) {
            return WebClientSource_BALE;
        }
        if (i == 1) {
            return WebClientSource_BAM;
        }
        if (i != 2) {
            return null;
        }
        return WebClientSource_IVA;
    }

    @Override // com.google.protobuf.B.c
    public final int getNumber() {
        if (this != UNRECOGNIZED) {
            return this.a;
        }
        throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
    }
}
