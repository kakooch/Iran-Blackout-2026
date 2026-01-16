package ir.nasim;

import com.google.protobuf.B;

/* loaded from: classes.dex */
public enum LZ7 implements B.c {
    MyBankItemAction_UNKNOWN(0),
    MyBankItemAction_URL(1),
    MyBankItemAction_PEER(2),
    MyBankItemAction_CARD2CARD(3),
    MyBankItemAction_CARD_BALANCE(4),
    MyBankItemAction_BILL(5),
    MyBankItemAction_CHARGE(6),
    MyBankItemAction_PFM(7),
    MyBankItemAction_USSD(8),
    MyBankItemAction_INVOICE(9),
    MyBankItemAction_INTENT_URL(10),
    UNRECOGNIZED(-1);

    private static final B.d n = new B.d() { // from class: ir.nasim.LZ7.a
        @Override // com.google.protobuf.B.d
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public LZ7 a(int i) {
            return LZ7.j(i);
        }
    };
    private final int a;

    LZ7(int i) {
        this.a = i;
    }

    public static LZ7 j(int i) {
        switch (i) {
            case 0:
                return MyBankItemAction_UNKNOWN;
            case 1:
                return MyBankItemAction_URL;
            case 2:
                return MyBankItemAction_PEER;
            case 3:
                return MyBankItemAction_CARD2CARD;
            case 4:
                return MyBankItemAction_CARD_BALANCE;
            case 5:
                return MyBankItemAction_BILL;
            case 6:
                return MyBankItemAction_CHARGE;
            case 7:
                return MyBankItemAction_PFM;
            case 8:
                return MyBankItemAction_USSD;
            case 9:
                return MyBankItemAction_INVOICE;
            case 10:
                return MyBankItemAction_INTENT_URL;
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
