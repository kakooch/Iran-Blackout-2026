package ir.nasim;

import com.google.protobuf.B;

/* renamed from: ir.nasim.zo4, reason: case insensitive filesystem */
/* loaded from: classes9.dex */
public enum EnumC25146zo4 implements B.c {
    NewMyBankItemAction_UNKNOWN(0),
    NewMyBankItemAction_URL(1),
    NewMyBankItemAction_PEER(2),
    NewMyBankItemAction_CARD2CARD(3),
    NewMyBankItemAction_CARD_BALANCE(4),
    NewMyBankItemAction_BILL(5),
    NewMyBankItemAction_CHARGE(6),
    NewMyBankItemAction_PFM(7),
    NewMyBankItemAction_USSD(8),
    NewMyBankItemAction_INVOICE(9),
    NewMyBankItemAction_INTENT_URL(10),
    NewMyBankItemAction_MENU(11),
    NewMyBankItemAction_MONEY_REQUEST(12),
    NewMyBankItemAction_CROWDFUNDING(13),
    NewMyBankItemAction_GIFT_PACKET(14),
    UNRECOGNIZED(-1);

    private static final B.d r = new B.d() { // from class: ir.nasim.zo4.a
        @Override // com.google.protobuf.B.d
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public EnumC25146zo4 a(int i) {
            return EnumC25146zo4.j(i);
        }
    };
    private final int a;

    EnumC25146zo4(int i) {
        this.a = i;
    }

    public static EnumC25146zo4 j(int i) {
        switch (i) {
            case 0:
                return NewMyBankItemAction_UNKNOWN;
            case 1:
                return NewMyBankItemAction_URL;
            case 2:
                return NewMyBankItemAction_PEER;
            case 3:
                return NewMyBankItemAction_CARD2CARD;
            case 4:
                return NewMyBankItemAction_CARD_BALANCE;
            case 5:
                return NewMyBankItemAction_BILL;
            case 6:
                return NewMyBankItemAction_CHARGE;
            case 7:
                return NewMyBankItemAction_PFM;
            case 8:
                return NewMyBankItemAction_USSD;
            case 9:
                return NewMyBankItemAction_INVOICE;
            case 10:
                return NewMyBankItemAction_INTENT_URL;
            case 11:
                return NewMyBankItemAction_MENU;
            case 12:
                return NewMyBankItemAction_MONEY_REQUEST;
            case 13:
                return NewMyBankItemAction_CROWDFUNDING;
            case 14:
                return NewMyBankItemAction_GIFT_PACKET;
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
