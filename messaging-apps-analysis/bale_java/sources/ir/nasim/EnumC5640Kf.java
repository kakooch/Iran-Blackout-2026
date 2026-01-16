package ir.nasim;

import com.google.protobuf.B;

/* renamed from: ir.nasim.Kf, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public enum EnumC5640Kf implements B.c {
    AdState_UNKNOWN(0),
    AdState_AWAITINGCONTENTAPPROVAL(1),
    AdState_AWAITINGPAYMENT(2),
    AdState_AWAITINGTOSHOW(3),
    AdState_ACTIVE(4),
    AdState_FINISHED(5),
    AdState_REJECTED(6),
    AdState_CANCELED(7),
    UNRECOGNIZED(-1);

    private static final B.d k = new B.d() { // from class: ir.nasim.Kf.a
        @Override // com.google.protobuf.B.d
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public EnumC5640Kf a(int i) {
            return EnumC5640Kf.j(i);
        }
    };
    private final int a;

    EnumC5640Kf(int i) {
        this.a = i;
    }

    public static EnumC5640Kf j(int i) {
        switch (i) {
            case 0:
                return AdState_UNKNOWN;
            case 1:
                return AdState_AWAITINGCONTENTAPPROVAL;
            case 2:
                return AdState_AWAITINGPAYMENT;
            case 3:
                return AdState_AWAITINGTOSHOW;
            case 4:
                return AdState_ACTIVE;
            case 5:
                return AdState_FINISHED;
            case 6:
                return AdState_REJECTED;
            case 7:
                return AdState_CANCELED;
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
