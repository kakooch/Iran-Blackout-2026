package ir.nasim;

import com.google.protobuf.B;

/* renamed from: ir.nasim.La4, reason: case insensitive filesystem */
/* loaded from: classes9.dex */
public enum EnumC5834La4 implements B.c {
    ArchiveFilter_ALL(0),
    ArchiveFilter_TRUE(1),
    ArchiveFilter_FALSE(2),
    UNRECOGNIZED(-1);

    private static final B.d f = new B.d() { // from class: ir.nasim.La4.a
        @Override // com.google.protobuf.B.d
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public EnumC5834La4 a(int i) {
            return EnumC5834La4.j(i);
        }
    };
    private final int a;

    EnumC5834La4(int i) {
        this.a = i;
    }

    public static EnumC5834La4 j(int i) {
        if (i == 0) {
            return ArchiveFilter_ALL;
        }
        if (i == 1) {
            return ArchiveFilter_TRUE;
        }
        if (i != 2) {
            return null;
        }
        return ArchiveFilter_FALSE;
    }

    @Override // com.google.protobuf.B.c
    public final int getNumber() {
        if (this != UNRECOGNIZED) {
            return this.a;
        }
        throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
    }
}
