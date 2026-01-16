package ir.nasim;

import com.google.protobuf.B;

/* renamed from: ir.nasim.si, reason: case insensitive filesystem */
/* loaded from: classes9.dex */
public enum EnumC20844si implements B.c {
    AdStateUnknown(0),
    AdStateAwaitingContentApproval(1),
    AdStateAwaitingPayment(2),
    AdStateAwaitingToShow(3),
    AdStateActive(4),
    AdStateFinished(5),
    AdStateRejected(6),
    AdStateCanceled(7),
    UNRECOGNIZED(-1);

    private static final B.d k = new B.d() { // from class: ir.nasim.si.a
        @Override // com.google.protobuf.B.d
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public EnumC20844si a(int i) {
            return EnumC20844si.j(i);
        }
    };
    private final int a;

    EnumC20844si(int i) {
        this.a = i;
    }

    public static EnumC20844si j(int i) {
        switch (i) {
            case 0:
                return AdStateUnknown;
            case 1:
                return AdStateAwaitingContentApproval;
            case 2:
                return AdStateAwaitingPayment;
            case 3:
                return AdStateAwaitingToShow;
            case 4:
                return AdStateActive;
            case 5:
                return AdStateFinished;
            case 6:
                return AdStateRejected;
            case 7:
                return AdStateCanceled;
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
