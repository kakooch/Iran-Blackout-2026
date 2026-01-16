package ir.nasim;

import com.google.protobuf.B;

/* renamed from: ir.nasim.oE3, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public enum EnumC18188oE3 implements B.c {
    EGRESS_STARTING(0),
    EGRESS_ACTIVE(1),
    EGRESS_ENDING(2),
    EGRESS_COMPLETE(3),
    EGRESS_FAILED(4),
    EGRESS_ABORTED(5),
    EGRESS_LIMIT_REACHED(6),
    UNRECOGNIZED(-1);

    private static final B.d j = new B.d() { // from class: ir.nasim.oE3.a
        @Override // com.google.protobuf.B.d
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public EnumC18188oE3 a(int i) {
            return EnumC18188oE3.j(i);
        }
    };
    private final int a;

    EnumC18188oE3(int i) {
        this.a = i;
    }

    public static EnumC18188oE3 j(int i) {
        switch (i) {
            case 0:
                return EGRESS_STARTING;
            case 1:
                return EGRESS_ACTIVE;
            case 2:
                return EGRESS_ENDING;
            case 3:
                return EGRESS_COMPLETE;
            case 4:
                return EGRESS_FAILED;
            case 5:
                return EGRESS_ABORTED;
            case 6:
                return EGRESS_LIMIT_REACHED;
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
