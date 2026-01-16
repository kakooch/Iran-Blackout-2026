package ir.nasim;

import com.google.protobuf.B;

/* renamed from: ir.nasim.eh, reason: case insensitive filesystem */
/* loaded from: classes9.dex */
public enum EnumC12479eh implements B.c {
    DialogAdOrderStatus_UNKNOWN(0),
    DialogAdOrderStatus_AWAITINGCONTENTAPPROVAL(1),
    DialogAdOrderStatus_AWAITINGPAYMENT(2),
    DialogAdOrderStatus_AWAITINGTOSHOW(3),
    DialogAdOrderStatus_ACTIVE(4),
    DialogAdOrderStatus_FINISHED(5),
    DialogAdOrderStatus_REJECTCONTENT(6),
    UNRECOGNIZED(-1);

    private static final B.d j = new B.d() { // from class: ir.nasim.eh.a
        @Override // com.google.protobuf.B.d
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public EnumC12479eh a(int i) {
            return EnumC12479eh.j(i);
        }
    };
    private final int a;

    EnumC12479eh(int i) {
        this.a = i;
    }

    public static EnumC12479eh j(int i) {
        switch (i) {
            case 0:
                return DialogAdOrderStatus_UNKNOWN;
            case 1:
                return DialogAdOrderStatus_AWAITINGCONTENTAPPROVAL;
            case 2:
                return DialogAdOrderStatus_AWAITINGPAYMENT;
            case 3:
                return DialogAdOrderStatus_AWAITINGTOSHOW;
            case 4:
                return DialogAdOrderStatus_ACTIVE;
            case 5:
                return DialogAdOrderStatus_FINISHED;
            case 6:
                return DialogAdOrderStatus_REJECTCONTENT;
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
