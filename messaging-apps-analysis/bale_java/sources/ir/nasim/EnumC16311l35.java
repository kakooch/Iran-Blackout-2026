package ir.nasim;

import com.google.protobuf.B;

/* renamed from: ir.nasim.l35, reason: case insensitive filesystem */
/* loaded from: classes9.dex */
public enum EnumC16311l35 implements B.c {
    PeerType_UNKNOWN(0),
    PeerType_PRIVATE(1),
    PeerType_GROUP(2),
    PeerType_ENCRYPTEDPRIVATE(3),
    UNRECOGNIZED(-1);

    private static final B.d g = new B.d() { // from class: ir.nasim.l35.a
        @Override // com.google.protobuf.B.d
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public EnumC16311l35 a(int i) {
            return EnumC16311l35.j(i);
        }
    };
    private final int a;

    EnumC16311l35(int i) {
        this.a = i;
    }

    public static EnumC16311l35 j(int i) {
        if (i == 0) {
            return PeerType_UNKNOWN;
        }
        if (i == 1) {
            return PeerType_PRIVATE;
        }
        if (i == 2) {
            return PeerType_GROUP;
        }
        if (i != 3) {
            return null;
        }
        return PeerType_ENCRYPTEDPRIVATE;
    }

    @Override // com.google.protobuf.B.c
    public final int getNumber() {
        if (this != UNRECOGNIZED) {
            return this.a;
        }
        throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
    }
}
