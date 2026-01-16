package ir.nasim;

import com.google.protobuf.B;

/* renamed from: ir.nasim.d92, reason: case insensitive filesystem */
/* loaded from: classes9.dex */
public enum EnumC11525d92 implements B.c {
    LinkPreviewType_OPENGRAPH(0),
    UNRECOGNIZED(-1);

    private static final B.d d = new B.d() { // from class: ir.nasim.d92.a
        @Override // com.google.protobuf.B.d
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public EnumC11525d92 a(int i) {
            return EnumC11525d92.j(i);
        }
    };
    private final int a;

    EnumC11525d92(int i) {
        this.a = i;
    }

    public static EnumC11525d92 j(int i) {
        if (i != 0) {
            return null;
        }
        return LinkPreviewType_OPENGRAPH;
    }

    @Override // com.google.protobuf.B.c
    public final int getNumber() {
        if (this != UNRECOGNIZED) {
            return this.a;
        }
        throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
    }
}
