package ir.nasim;

import com.google.protobuf.B;

/* renamed from: ir.nasim.mU6, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public enum EnumC17153mU6 implements B.c {
    ConfigSetType_Unknown(0),
    ConfigSetType_Replace(1),
    ConfigSetType_Append(2),
    ConfigSetType_Delete(3),
    UNRECOGNIZED(-1);

    private static final B.d g = new B.d() { // from class: ir.nasim.mU6.a
        @Override // com.google.protobuf.B.d
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public EnumC17153mU6 a(int i) {
            return EnumC17153mU6.j(i);
        }
    };
    private final int a;

    EnumC17153mU6(int i) {
        this.a = i;
    }

    public static EnumC17153mU6 j(int i) {
        if (i == 0) {
            return ConfigSetType_Unknown;
        }
        if (i == 1) {
            return ConfigSetType_Replace;
        }
        if (i == 2) {
            return ConfigSetType_Append;
        }
        if (i != 3) {
            return null;
        }
        return ConfigSetType_Delete;
    }

    @Override // com.google.protobuf.B.c
    public final int getNumber() {
        if (this != UNRECOGNIZED) {
            return this.a;
        }
        throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
    }
}
