package ir.nasim;

import com.google.protobuf.B;

/* renamed from: ir.nasim.Rc4, reason: case insensitive filesystem */
/* loaded from: classes9.dex */
public enum EnumC7296Rc4 implements B.c {
    ReservedFolderID_ALL(0),
    ReservedFolderID_PRIVATE(1),
    ReservedFolderID_GROUP(2),
    ReservedFolderID_CHANNEL(3),
    ReservedFolderID_BOT(4),
    ReservedFolderID_UNREAD(10),
    ReservedFolderID_ARCHIVED(11),
    UNRECOGNIZED(-1);

    private static final B.d j = new B.d() { // from class: ir.nasim.Rc4.a
        @Override // com.google.protobuf.B.d
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public EnumC7296Rc4 a(int i) {
            return EnumC7296Rc4.j(i);
        }
    };
    private final int a;

    EnumC7296Rc4(int i) {
        this.a = i;
    }

    public static EnumC7296Rc4 j(int i) {
        if (i == 0) {
            return ReservedFolderID_ALL;
        }
        if (i == 1) {
            return ReservedFolderID_PRIVATE;
        }
        if (i == 2) {
            return ReservedFolderID_GROUP;
        }
        if (i == 3) {
            return ReservedFolderID_CHANNEL;
        }
        if (i == 4) {
            return ReservedFolderID_BOT;
        }
        if (i == 10) {
            return ReservedFolderID_UNREAD;
        }
        if (i != 11) {
            return null;
        }
        return ReservedFolderID_ARCHIVED;
    }

    @Override // com.google.protobuf.B.c
    public final int getNumber() {
        if (this != UNRECOGNIZED) {
            return this.a;
        }
        throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
    }
}
