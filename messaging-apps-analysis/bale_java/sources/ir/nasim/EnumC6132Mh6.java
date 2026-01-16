package ir.nasim;

import com.google.protobuf.B;

/* renamed from: ir.nasim.Mh6, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public enum EnumC6132Mh6 implements B.c {
    SearchContentTab_CONTENT(0),
    SearchContentTab_PHOTO(1),
    UNRECOGNIZED(-1);

    private static final B.d e = new B.d() { // from class: ir.nasim.Mh6.a
        @Override // com.google.protobuf.B.d
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public EnumC6132Mh6 a(int i) {
            return EnumC6132Mh6.j(i);
        }
    };
    private final int a;

    EnumC6132Mh6(int i) {
        this.a = i;
    }

    public static EnumC6132Mh6 j(int i) {
        if (i == 0) {
            return SearchContentTab_CONTENT;
        }
        if (i != 1) {
            return null;
        }
        return SearchContentTab_PHOTO;
    }

    @Override // com.google.protobuf.B.c
    public final int getNumber() {
        if (this != UNRECOGNIZED) {
            return this.a;
        }
        throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
    }
}
