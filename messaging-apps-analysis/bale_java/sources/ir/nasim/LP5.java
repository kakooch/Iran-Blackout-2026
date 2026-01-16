package ir.nasim;

import com.google.protobuf.B;

/* loaded from: classes.dex */
public enum LP5 implements B.c {
    PeerSource_UNKNOWN(0),
    PeerSource_DIALOGS(1),
    PeerSource_VITRINE(2),
    PeerSource_MARKET(3),
    PeerSource_PRIVACY_BAR(4),
    UNRECOGNIZED(-1);

    private static final B.d h = new B.d() { // from class: ir.nasim.LP5.a
        @Override // com.google.protobuf.B.d
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public LP5 a(int i2) {
            return LP5.j(i2);
        }
    };
    private final int a;

    LP5(int i2) {
        this.a = i2;
    }

    public static LP5 j(int i2) {
        if (i2 == 0) {
            return PeerSource_UNKNOWN;
        }
        if (i2 == 1) {
            return PeerSource_DIALOGS;
        }
        if (i2 == 2) {
            return PeerSource_VITRINE;
        }
        if (i2 == 3) {
            return PeerSource_MARKET;
        }
        if (i2 != 4) {
            return null;
        }
        return PeerSource_PRIVACY_BAR;
    }

    @Override // com.google.protobuf.B.c
    public final int getNumber() {
        if (this != UNRECOGNIZED) {
            return this.a;
        }
        throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
    }
}
