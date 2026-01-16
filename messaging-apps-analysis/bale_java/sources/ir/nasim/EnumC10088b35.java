package ir.nasim;

import com.google.protobuf.B;

/* renamed from: ir.nasim.b35, reason: case insensitive filesystem */
/* loaded from: classes9.dex */
public enum EnumC10088b35 implements B.c {
    ExPeerType_UNKNOWN(0),
    ExPeerType_PRIVATE(1),
    ExPeerType_GROUP(2),
    ExPeerType_CHANNEL(3),
    ExPeerType_BOT(4),
    ExPeerType_SUPERGROUP(5),
    ExPeerType_THREAD(6),
    UNRECOGNIZED(-1);

    private static final B.d j = new B.d() { // from class: ir.nasim.b35.a
        @Override // com.google.protobuf.B.d
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public EnumC10088b35 a(int i) {
            return EnumC10088b35.j(i);
        }
    };
    private final int a;

    EnumC10088b35(int i) {
        this.a = i;
    }

    public static EnumC10088b35 j(int i) {
        switch (i) {
            case 0:
                return ExPeerType_UNKNOWN;
            case 1:
                return ExPeerType_PRIVATE;
            case 2:
                return ExPeerType_GROUP;
            case 3:
                return ExPeerType_CHANNEL;
            case 4:
                return ExPeerType_BOT;
            case 5:
                return ExPeerType_SUPERGROUP;
            case 6:
                return ExPeerType_THREAD;
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
