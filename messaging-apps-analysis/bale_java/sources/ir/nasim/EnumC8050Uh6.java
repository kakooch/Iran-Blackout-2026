package ir.nasim;

import com.google.protobuf.B;

/* renamed from: ir.nasim.Uh6, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public enum EnumC8050Uh6 implements B.c {
    SearchPeerType_GROUPS(0),
    SearchPeerType_CONTACTS(1),
    SearchPeerType_PUBLIC(2),
    UNRECOGNIZED(-1);

    private static final B.d f = new B.d() { // from class: ir.nasim.Uh6.a
        @Override // com.google.protobuf.B.d
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public EnumC8050Uh6 a(int i) {
            return EnumC8050Uh6.j(i);
        }
    };
    private final int a;

    EnumC8050Uh6(int i) {
        this.a = i;
    }

    public static EnumC8050Uh6 j(int i) {
        if (i == 0) {
            return SearchPeerType_GROUPS;
        }
        if (i == 1) {
            return SearchPeerType_CONTACTS;
        }
        if (i != 2) {
            return null;
        }
        return SearchPeerType_PUBLIC;
    }

    @Override // com.google.protobuf.B.c
    public final int getNumber() {
        if (this != UNRECOGNIZED) {
            return this.a;
        }
        throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
    }
}
