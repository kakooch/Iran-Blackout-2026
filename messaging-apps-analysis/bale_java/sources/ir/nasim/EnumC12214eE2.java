package ir.nasim;

import com.google.protobuf.B;

/* renamed from: ir.nasim.eE2, reason: case insensitive filesystem */
/* loaded from: classes9.dex */
public enum EnumC12214eE2 implements B.c {
    GarsonItemAction_UNKNOWN(0),
    GarsonItemAction_URL(1),
    GarsonItemAction_PEER(2),
    GarsonItemAction_CARD2CARD(3),
    GarsonItemAction_CARD_BALANCE(4),
    GarsonItemAction_BILL(5),
    GarsonItemAction_CHARGE(6),
    GarsonItemAction_PFM(7),
    GarsonItemAction_USSD(8),
    GarsonItemAction_INVOICE(9),
    GarsonItemAction_INTENT_URL(10),
    GarsonItemAction_MENU(11),
    GarsonItemAction_MONEY_REQUEST(12),
    GarsonItemAction_CROWDFUNDING(13),
    GarsonItemAction_GIFT_PACKET(14),
    UNRECOGNIZED(-1);

    private static final B.d r = new B.d() { // from class: ir.nasim.eE2.a
        @Override // com.google.protobuf.B.d
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public EnumC12214eE2 a(int i) {
            return EnumC12214eE2.j(i);
        }
    };
    private final int a;

    EnumC12214eE2(int i) {
        this.a = i;
    }

    public static EnumC12214eE2 j(int i) {
        switch (i) {
            case 0:
                return GarsonItemAction_UNKNOWN;
            case 1:
                return GarsonItemAction_URL;
            case 2:
                return GarsonItemAction_PEER;
            case 3:
                return GarsonItemAction_CARD2CARD;
            case 4:
                return GarsonItemAction_CARD_BALANCE;
            case 5:
                return GarsonItemAction_BILL;
            case 6:
                return GarsonItemAction_CHARGE;
            case 7:
                return GarsonItemAction_PFM;
            case 8:
                return GarsonItemAction_USSD;
            case 9:
                return GarsonItemAction_INVOICE;
            case 10:
                return GarsonItemAction_INTENT_URL;
            case 11:
                return GarsonItemAction_MENU;
            case 12:
                return GarsonItemAction_MONEY_REQUEST;
            case 13:
                return GarsonItemAction_CROWDFUNDING;
            case 14:
                return GarsonItemAction_GIFT_PACKET;
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
