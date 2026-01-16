package ir.nasim;

import com.google.protobuf.B;

/* loaded from: classes8.dex */
public enum VD3 implements B.c {
    JT_ROOM(0),
    JT_PUBLISHER(1),
    JT_PARTICIPANT(2),
    UNRECOGNIZED(-1);

    private static final B.d f = new B.d() { // from class: ir.nasim.VD3.a
        @Override // com.google.protobuf.B.d
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public VD3 a(int i) {
            return VD3.j(i);
        }
    };
    private final int a;

    VD3(int i) {
        this.a = i;
    }

    public static VD3 j(int i) {
        if (i == 0) {
            return JT_ROOM;
        }
        if (i == 1) {
            return JT_PUBLISHER;
        }
        if (i != 2) {
            return null;
        }
        return JT_PARTICIPANT;
    }

    @Override // com.google.protobuf.B.c
    public final int getNumber() {
        if (this != UNRECOGNIZED) {
            return this.a;
        }
        throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
    }
}
