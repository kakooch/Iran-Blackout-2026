package ir.nasim;

import com.google.protobuf.B;

/* renamed from: ir.nasim.Jb2, reason: case insensitive filesystem */
/* loaded from: classes9.dex */
public enum EnumC5373Jb2 implements B.c {
    EvexDeliveryStationType_UNKNOWN(0),
    EvexDeliveryStationType_AIRPORT(1),
    UNRECOGNIZED(-1);

    private static final B.d e = new B.d() { // from class: ir.nasim.Jb2.a
        @Override // com.google.protobuf.B.d
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public EnumC5373Jb2 a(int i) {
            return EnumC5373Jb2.j(i);
        }
    };
    private final int a;

    EnumC5373Jb2(int i) {
        this.a = i;
    }

    public static EnumC5373Jb2 j(int i) {
        if (i == 0) {
            return EvexDeliveryStationType_UNKNOWN;
        }
        if (i != 1) {
            return null;
        }
        return EvexDeliveryStationType_AIRPORT;
    }

    @Override // com.google.protobuf.B.c
    public final int getNumber() {
        if (this != UNRECOGNIZED) {
            return this.a;
        }
        throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
    }
}
