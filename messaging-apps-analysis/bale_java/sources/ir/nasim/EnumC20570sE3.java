package ir.nasim;

import com.google.protobuf.B;

/* renamed from: ir.nasim.sE3, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public enum EnumC20570sE3 implements B.c {
    IMAGE_SUFFIX_INDEX(0),
    IMAGE_SUFFIX_TIMESTAMP(1),
    IMAGE_SUFFIX_NONE_OVERWRITE(2),
    UNRECOGNIZED(-1);

    private static final B.d f = new B.d() { // from class: ir.nasim.sE3.a
        @Override // com.google.protobuf.B.d
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public EnumC20570sE3 a(int i) {
            return EnumC20570sE3.j(i);
        }
    };
    private final int a;

    EnumC20570sE3(int i) {
        this.a = i;
    }

    public static EnumC20570sE3 j(int i) {
        if (i == 0) {
            return IMAGE_SUFFIX_INDEX;
        }
        if (i == 1) {
            return IMAGE_SUFFIX_TIMESTAMP;
        }
        if (i != 2) {
            return null;
        }
        return IMAGE_SUFFIX_NONE_OVERWRITE;
    }

    @Override // com.google.protobuf.B.c
    public final int getNumber() {
        if (this != UNRECOGNIZED) {
            return this.a;
        }
        throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
    }
}
