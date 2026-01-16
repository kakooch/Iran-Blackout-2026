package ir.nasim;

import com.google.protobuf.B;

/* renamed from: ir.nasim.pE3, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public enum EnumC18779pE3 implements B.c {
    DEFAULT_FILETYPE(0),
    MP4(1),
    OGG(2),
    UNRECOGNIZED(-1);

    private static final B.d f = new B.d() { // from class: ir.nasim.pE3.a
        @Override // com.google.protobuf.B.d
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public EnumC18779pE3 a(int i) {
            return EnumC18779pE3.j(i);
        }
    };
    private final int a;

    EnumC18779pE3(int i) {
        this.a = i;
    }

    public static EnumC18779pE3 j(int i) {
        if (i == 0) {
            return DEFAULT_FILETYPE;
        }
        if (i == 1) {
            return MP4;
        }
        if (i != 2) {
            return null;
        }
        return OGG;
    }

    @Override // com.google.protobuf.B.c
    public final int getNumber() {
        if (this != UNRECOGNIZED) {
            return this.a;
        }
        throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
    }
}
