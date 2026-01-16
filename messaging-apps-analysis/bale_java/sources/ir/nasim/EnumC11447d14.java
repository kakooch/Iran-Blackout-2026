package ir.nasim;

import com.google.protobuf.B;

/* renamed from: ir.nasim.d14, reason: case insensitive filesystem */
/* loaded from: classes9.dex */
public enum EnumC11447d14 implements B.c {
    PeerStateEnum_UNKNOWN(0),
    PeerStateEnum_INVITED(1),
    PeerStateEnum_JOINED(2),
    PeerStateEnum_REJECTED(3),
    PeerStateEnum_LEFT(4),
    PeerStateEnum_NOTINVITED(5),
    PeerStateEnum_TRACKMUTED(6),
    PeerStateEnum_REMOVED(7),
    UNRECOGNIZED(-1);

    private static final B.d k = new B.d() { // from class: ir.nasim.d14.a
        @Override // com.google.protobuf.B.d
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public EnumC11447d14 a(int i) {
            return EnumC11447d14.j(i);
        }
    };
    private final int a;

    EnumC11447d14(int i) {
        this.a = i;
    }

    public static EnumC11447d14 j(int i) {
        switch (i) {
            case 0:
                return PeerStateEnum_UNKNOWN;
            case 1:
                return PeerStateEnum_INVITED;
            case 2:
                return PeerStateEnum_JOINED;
            case 3:
                return PeerStateEnum_REJECTED;
            case 4:
                return PeerStateEnum_LEFT;
            case 5:
                return PeerStateEnum_NOTINVITED;
            case 6:
                return PeerStateEnum_TRACKMUTED;
            case 7:
                return PeerStateEnum_REMOVED;
            default:
                return null;
        }
    }

    @Override // com.google.protobuf.B.c
    public final int getNumber() {
        if (this != UNRECOGNIZED) {
            return this.a;
        }
        throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
    }
}
