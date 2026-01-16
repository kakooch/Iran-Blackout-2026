package ir.nasim;

import com.google.protobuf.B;

/* renamed from: ir.nasim.Fb4, reason: case insensitive filesystem */
/* loaded from: classes9.dex */
public enum EnumC4424Fb4 implements B.c {
    GiftGivingType_SAME(0),
    GiftGivingType_RANDOM(1),
    UNRECOGNIZED(-1);

    private static final B.d e = new B.d() { // from class: ir.nasim.Fb4.a
        @Override // com.google.protobuf.B.d
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public EnumC4424Fb4 a(int i) {
            return EnumC4424Fb4.j(i);
        }
    };
    private final int a;

    EnumC4424Fb4(int i) {
        this.a = i;
    }

    public static EnumC4424Fb4 j(int i) {
        if (i == 0) {
            return GiftGivingType_SAME;
        }
        if (i != 1) {
            return null;
        }
        return GiftGivingType_RANDOM;
    }

    @Override // com.google.protobuf.B.c
    public final int getNumber() {
        if (this != UNRECOGNIZED) {
            return this.a;
        }
        throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
    }
}
