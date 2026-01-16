package ir.nasim;

import com.google.protobuf.B;

/* renamed from: ir.nasim.Gf2, reason: case insensitive filesystem */
/* loaded from: classes9.dex */
public enum EnumC4707Gf2 implements B.c {
    LinkStatus_APPROVED(0),
    LinkStatus_BLOCKED(1),
    LinkStatus_UNKNOWN(2),
    UNRECOGNIZED(-1);

    private static final B.d f = new B.d() { // from class: ir.nasim.Gf2.a
        @Override // com.google.protobuf.B.d
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public EnumC4707Gf2 a(int i) {
            return EnumC4707Gf2.j(i);
        }
    };
    private final int a;

    EnumC4707Gf2(int i) {
        this.a = i;
    }

    public static EnumC4707Gf2 j(int i) {
        if (i == 0) {
            return LinkStatus_APPROVED;
        }
        if (i == 1) {
            return LinkStatus_BLOCKED;
        }
        if (i != 2) {
            return null;
        }
        return LinkStatus_UNKNOWN;
    }

    @Override // com.google.protobuf.B.c
    public final int getNumber() {
        if (this != UNRECOGNIZED) {
            return this.a;
        }
        throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
    }
}
