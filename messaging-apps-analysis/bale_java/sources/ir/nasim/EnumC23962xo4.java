package ir.nasim;

import com.google.protobuf.B;

/* renamed from: ir.nasim.xo4, reason: case insensitive filesystem */
/* loaded from: classes9.dex */
public enum EnumC23962xo4 implements B.c {
    NewMyBankBadgeType_UNKNOWN(0),
    NewMyBankBadgeType_NEW(1),
    NewMyBankBadgeType_RECOMMENDED(2),
    UNRECOGNIZED(-1);

    private static final B.d f = new B.d() { // from class: ir.nasim.xo4.a
        @Override // com.google.protobuf.B.d
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public EnumC23962xo4 a(int i) {
            return EnumC23962xo4.j(i);
        }
    };
    private final int a;

    EnumC23962xo4(int i) {
        this.a = i;
    }

    public static EnumC23962xo4 j(int i) {
        if (i == 0) {
            return NewMyBankBadgeType_UNKNOWN;
        }
        if (i == 1) {
            return NewMyBankBadgeType_NEW;
        }
        if (i != 2) {
            return null;
        }
        return NewMyBankBadgeType_RECOMMENDED;
    }

    @Override // com.google.protobuf.B.c
    public final int getNumber() {
        if (this != UNRECOGNIZED) {
            return this.a;
        }
        throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
    }
}
