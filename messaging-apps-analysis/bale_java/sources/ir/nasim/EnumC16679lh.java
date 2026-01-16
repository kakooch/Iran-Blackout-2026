package ir.nasim;

import com.google.protobuf.B;

/* renamed from: ir.nasim.lh, reason: case insensitive filesystem */
/* loaded from: classes9.dex */
public enum EnumC16679lh implements B.c {
    IncomeState_NOTRECEIVED(0),
    IncomeState_AWAITINGREPEIPT(1),
    IncomeState_RECEIVED(2),
    UNRECOGNIZED(-1);

    private static final B.d f = new B.d() { // from class: ir.nasim.lh.a
        @Override // com.google.protobuf.B.d
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public EnumC16679lh a(int i) {
            return EnumC16679lh.j(i);
        }
    };
    private final int a;

    EnumC16679lh(int i) {
        this.a = i;
    }

    public static EnumC16679lh j(int i) {
        if (i == 0) {
            return IncomeState_NOTRECEIVED;
        }
        if (i == 1) {
            return IncomeState_AWAITINGREPEIPT;
        }
        if (i != 2) {
            return null;
        }
        return IncomeState_RECEIVED;
    }

    @Override // com.google.protobuf.B.c
    public final int getNumber() {
        if (this != UNRECOGNIZED) {
            return this.a;
        }
        throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
    }
}
