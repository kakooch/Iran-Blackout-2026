package ir.nasim;

import com.google.protobuf.B;

/* renamed from: ir.nasim.Xq3, reason: case insensitive filesystem */
/* loaded from: classes9.dex */
public enum EnumC8862Xq3 implements B.c {
    KifpoolStatus_INACTIVE(0),
    KifpoolStatus_ACTIVE(1),
    UNRECOGNIZED(-1);

    private static final B.d e = new B.d() { // from class: ir.nasim.Xq3.a
        @Override // com.google.protobuf.B.d
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public EnumC8862Xq3 a(int i) {
            return EnumC8862Xq3.j(i);
        }
    };
    private final int a;

    EnumC8862Xq3(int i) {
        this.a = i;
    }

    public static EnumC8862Xq3 j(int i) {
        if (i == 0) {
            return KifpoolStatus_INACTIVE;
        }
        if (i != 1) {
            return null;
        }
        return KifpoolStatus_ACTIVE;
    }

    @Override // com.google.protobuf.B.c
    public final int getNumber() {
        if (this != UNRECOGNIZED) {
            return this.a;
        }
        throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
    }
}
