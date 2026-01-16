package ir.nasim;

import com.google.protobuf.B;

/* renamed from: ir.nasim.An0, reason: case insensitive filesystem */
/* loaded from: classes9.dex */
public enum EnumC3353An0 implements B.c {
    RequestStatus_UNKNOWN(0),
    RequestStatus_PENDING(1),
    RequestStatus_APPROVED(2),
    RequestStatus_REJECTED(3),
    UNRECOGNIZED(-1);

    private static final B.d g = new B.d() { // from class: ir.nasim.An0.a
        @Override // com.google.protobuf.B.d
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public EnumC3353An0 a(int i) {
            return EnumC3353An0.j(i);
        }
    };
    private final int a;

    EnumC3353An0(int i) {
        this.a = i;
    }

    public static EnumC3353An0 j(int i) {
        if (i == 0) {
            return RequestStatus_UNKNOWN;
        }
        if (i == 1) {
            return RequestStatus_PENDING;
        }
        if (i == 2) {
            return RequestStatus_APPROVED;
        }
        if (i != 3) {
            return null;
        }
        return RequestStatus_REJECTED;
    }

    @Override // com.google.protobuf.B.c
    public final int getNumber() {
        if (this != UNRECOGNIZED) {
            return this.a;
        }
        throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
    }
}
