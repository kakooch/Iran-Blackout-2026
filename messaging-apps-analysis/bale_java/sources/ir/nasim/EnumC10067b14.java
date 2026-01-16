package ir.nasim;

import com.google.protobuf.B;

/* renamed from: ir.nasim.b14, reason: case insensitive filesystem */
/* loaded from: classes9.dex */
public enum EnumC10067b14 implements B.c {
    MultiPeerCallLogStatus_UNKNOWN(0),
    MultiPeerCallLogStatus_JOINED(1),
    MultiPeerCallLogStatus_MISSED(2),
    UNRECOGNIZED(-1);

    private static final B.d f = new B.d() { // from class: ir.nasim.b14.a
        @Override // com.google.protobuf.B.d
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public EnumC10067b14 a(int i) {
            return EnumC10067b14.j(i);
        }
    };
    private final int a;

    EnumC10067b14(int i) {
        this.a = i;
    }

    public static EnumC10067b14 j(int i) {
        if (i == 0) {
            return MultiPeerCallLogStatus_UNKNOWN;
        }
        if (i == 1) {
            return MultiPeerCallLogStatus_JOINED;
        }
        if (i != 2) {
            return null;
        }
        return MultiPeerCallLogStatus_MISSED;
    }

    @Override // com.google.protobuf.B.c
    public final int getNumber() {
        if (this != UNRECOGNIZED) {
            return this.a;
        }
        throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
    }
}
