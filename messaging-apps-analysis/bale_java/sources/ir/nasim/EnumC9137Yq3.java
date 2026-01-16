package ir.nasim;

import com.google.protobuf.B;

/* renamed from: ir.nasim.Yq3, reason: case insensitive filesystem */
/* loaded from: classes9.dex */
public enum EnumC9137Yq3 implements B.c {
    PocketType_NONE(0),
    PocketType_BALE_USER(2200),
    PocketType_BALE_ORG(3300),
    PocketType_IRDR(6680),
    UNRECOGNIZED(-1);

    private static final B.d g = new B.d() { // from class: ir.nasim.Yq3.a
        @Override // com.google.protobuf.B.d
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public EnumC9137Yq3 a(int i) {
            return EnumC9137Yq3.j(i);
        }
    };
    private final int a;

    EnumC9137Yq3(int i) {
        this.a = i;
    }

    public static EnumC9137Yq3 j(int i) {
        if (i == 0) {
            return PocketType_NONE;
        }
        if (i == 2200) {
            return PocketType_BALE_USER;
        }
        if (i == 3300) {
            return PocketType_BALE_ORG;
        }
        if (i != 6680) {
            return null;
        }
        return PocketType_IRDR;
    }

    @Override // com.google.protobuf.B.c
    public final int getNumber() {
        if (this != UNRECOGNIZED) {
            return this.a;
        }
        throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
    }
}
