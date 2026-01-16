package ir.nasim;

import com.google.protobuf.B;

/* renamed from: ir.nasim.l20, reason: case insensitive filesystem */
/* loaded from: classes9.dex */
public enum EnumC16296l20 implements B.c {
    MarriageStatus_Unknown(0),
    MarriageStatus_Single(1),
    MarriageStatus_Married(2),
    UNRECOGNIZED(-1);

    private static final B.d f = new B.d() { // from class: ir.nasim.l20.a
        @Override // com.google.protobuf.B.d
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public EnumC16296l20 a(int i) {
            return EnumC16296l20.j(i);
        }
    };
    private final int a;

    EnumC16296l20(int i) {
        this.a = i;
    }

    public static EnumC16296l20 j(int i) {
        if (i == 0) {
            return MarriageStatus_Unknown;
        }
        if (i == 1) {
            return MarriageStatus_Single;
        }
        if (i != 2) {
            return null;
        }
        return MarriageStatus_Married;
    }

    @Override // com.google.protobuf.B.c
    public final int getNumber() {
        if (this != UNRECOGNIZED) {
            return this.a;
        }
        throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
    }
}
