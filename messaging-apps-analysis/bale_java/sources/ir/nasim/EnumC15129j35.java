package ir.nasim;

import com.google.protobuf.B;

/* renamed from: ir.nasim.j35, reason: case insensitive filesystem */
/* loaded from: classes9.dex */
public enum EnumC15129j35 implements B.c {
    PeerIdentity_INFORMAL(0),
    PeerIdentity_VERIFIED(1),
    PeerIdentity_LEGAL(2),
    PeerIdentity_TOP_USER(3),
    UNRECOGNIZED(-1);

    private static final B.d g = new B.d() { // from class: ir.nasim.j35.a
        @Override // com.google.protobuf.B.d
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public EnumC15129j35 a(int i) {
            return EnumC15129j35.j(i);
        }
    };
    private final int a;

    EnumC15129j35(int i) {
        this.a = i;
    }

    public static EnumC15129j35 j(int i) {
        if (i == 0) {
            return PeerIdentity_INFORMAL;
        }
        if (i == 1) {
            return PeerIdentity_VERIFIED;
        }
        if (i == 2) {
            return PeerIdentity_LEGAL;
        }
        if (i != 3) {
            return null;
        }
        return PeerIdentity_TOP_USER;
    }

    @Override // com.google.protobuf.B.c
    public final int getNumber() {
        if (this != UNRECOGNIZED) {
            return this.a;
        }
        throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
    }
}
