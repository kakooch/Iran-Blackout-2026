package ir.nasim;

import com.google.protobuf.B;

/* renamed from: ir.nasim.Ie0, reason: case insensitive filesystem */
/* loaded from: classes9.dex */
public enum EnumC5164Ie0 implements B.c {
    BillTermType_UNKNOWN(0),
    BillTermType_MIDTERM(1),
    BillTermType_ENDTERM(2),
    UNRECOGNIZED(-1);

    private static final B.d f = new B.d() { // from class: ir.nasim.Ie0.a
        @Override // com.google.protobuf.B.d
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public EnumC5164Ie0 a(int i) {
            return EnumC5164Ie0.j(i);
        }
    };
    private final int a;

    EnumC5164Ie0(int i) {
        this.a = i;
    }

    public static EnumC5164Ie0 j(int i) {
        if (i == 0) {
            return BillTermType_UNKNOWN;
        }
        if (i == 1) {
            return BillTermType_MIDTERM;
        }
        if (i != 2) {
            return null;
        }
        return BillTermType_ENDTERM;
    }

    @Override // com.google.protobuf.B.c
    public final int getNumber() {
        if (this != UNRECOGNIZED) {
            return this.a;
        }
        throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
    }
}
