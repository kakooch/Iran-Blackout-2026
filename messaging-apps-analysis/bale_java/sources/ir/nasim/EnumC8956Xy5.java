package ir.nasim;

import com.google.protobuf.B;

/* renamed from: ir.nasim.Xy5, reason: case insensitive filesystem */
/* loaded from: classes9.dex */
public enum EnumC8956Xy5 implements B.c {
    PeerConfigType_UNKNOWN(0),
    PeerConfigType_CHATMUTED(1),
    UNRECOGNIZED(-1);

    private static final B.d e = new B.d() { // from class: ir.nasim.Xy5.a
        @Override // com.google.protobuf.B.d
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public EnumC8956Xy5 a(int i) {
            return EnumC8956Xy5.j(i);
        }
    };
    private final int a;

    EnumC8956Xy5(int i) {
        this.a = i;
    }

    public static EnumC8956Xy5 j(int i) {
        if (i == 0) {
            return PeerConfigType_UNKNOWN;
        }
        if (i != 1) {
            return null;
        }
        return PeerConfigType_CHATMUTED;
    }

    @Override // com.google.protobuf.B.c
    public final int getNumber() {
        if (this != UNRECOGNIZED) {
            return this.a;
        }
        throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
    }
}
