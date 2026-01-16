package ir.nasim;

import com.google.protobuf.B;

/* renamed from: ir.nasim.tU6, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public enum EnumC21337tU6 implements B.c {
    ExceptionType_Unknown(0),
    ExceptionType_Exclude(1),
    ExceptionType_Include(2),
    ExceptionType_Contact(3),
    ExceptionType_All(4),
    UNRECOGNIZED(-1);

    private static final B.d h = new B.d() { // from class: ir.nasim.tU6.a
        @Override // com.google.protobuf.B.d
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public EnumC21337tU6 a(int i2) {
            return EnumC21337tU6.j(i2);
        }
    };
    private final int a;

    EnumC21337tU6(int i2) {
        this.a = i2;
    }

    public static EnumC21337tU6 j(int i2) {
        if (i2 == 0) {
            return ExceptionType_Unknown;
        }
        if (i2 == 1) {
            return ExceptionType_Exclude;
        }
        if (i2 == 2) {
            return ExceptionType_Include;
        }
        if (i2 == 3) {
            return ExceptionType_Contact;
        }
        if (i2 != 4) {
            return null;
        }
        return ExceptionType_All;
    }

    @Override // com.google.protobuf.B.c
    public final int getNumber() {
        if (this != UNRECOGNIZED) {
            return this.a;
        }
        throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
    }
}
