package ir.nasim;

import com.google.protobuf.B;

/* renamed from: ir.nasim.mF6, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public enum EnumC17018mF6 implements B.c {
    Unknown(0),
    Pending(1),
    InProgress(2),
    Successful(3),
    Failure(4),
    UNRECOGNIZED(-1);

    private static final B.d h = new B.d() { // from class: ir.nasim.mF6.a
        @Override // com.google.protobuf.B.d
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public EnumC17018mF6 a(int i2) {
            return EnumC17018mF6.j(i2);
        }
    };
    private final int a;

    EnumC17018mF6(int i2) {
        this.a = i2;
    }

    public static EnumC17018mF6 j(int i2) {
        if (i2 == 0) {
            return Unknown;
        }
        if (i2 == 1) {
            return Pending;
        }
        if (i2 == 2) {
            return InProgress;
        }
        if (i2 == 3) {
            return Successful;
        }
        if (i2 != 4) {
            return null;
        }
        return Failure;
    }

    @Override // com.google.protobuf.B.c
    public final int getNumber() {
        if (this != UNRECOGNIZED) {
            return this.a;
        }
        throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
    }
}
