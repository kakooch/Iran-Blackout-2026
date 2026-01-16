package ir.nasim;

import com.google.protobuf.B;

/* renamed from: ir.nasim.i20, reason: case insensitive filesystem */
/* loaded from: classes9.dex */
public enum EnumC14507i20 implements B.c {
    Education_Unknown(0),
    Education_UnderDiploma(1),
    Education_Diploma(2),
    Education_Associate(3),
    Education_Bachelor(4),
    Education_Master(5),
    Education_Doctorate(6),
    UNRECOGNIZED(-1);

    private static final B.d j = new B.d() { // from class: ir.nasim.i20.a
        @Override // com.google.protobuf.B.d
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public EnumC14507i20 a(int i) {
            return EnumC14507i20.j(i);
        }
    };
    private final int a;

    EnumC14507i20(int i) {
        this.a = i;
    }

    public static EnumC14507i20 j(int i) {
        switch (i) {
            case 0:
                return Education_Unknown;
            case 1:
                return Education_UnderDiploma;
            case 2:
                return Education_Diploma;
            case 3:
                return Education_Associate;
            case 4:
                return Education_Bachelor;
            case 5:
                return Education_Master;
            case 6:
                return Education_Doctorate;
            default:
                return null;
        }
    }

    @Override // com.google.protobuf.B.c
    public final int getNumber() {
        if (this != UNRECOGNIZED) {
            return this.a;
        }
        throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
    }
}
