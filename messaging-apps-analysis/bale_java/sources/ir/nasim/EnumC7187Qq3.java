package ir.nasim;

import com.google.protobuf.B;

/* renamed from: ir.nasim.Qq3, reason: case insensitive filesystem */
/* loaded from: classes9.dex */
public enum EnumC7187Qq3 implements B.c {
    ChargeKifpoolCallbackType_NULL(0),
    ChargeKifpoolCallbackType_GIFTPACKET(1),
    ChargeKifpoolCallbackType_PUCHASEMESSAGE(2),
    ChargeKifpoolCallbackType_CHARGE(3),
    ChargeKifpoolCallbackType_ADSPOTPUCHASE(4),
    ChargeKifpoolCallbackType_CRYPTO(5),
    ChargeKifpoolCallbackType_PURCHASE(6),
    ChargeKifpoolCallbackType_BOTPAYMENT(7),
    ChargeKifpoolCallbackType_BOTWALLETPAYMENT(8),
    ChargeKifpoolCallbackType_BOTGOLDPAYMENT(9),
    ChargeKifpoolCallbackType_PREMIUMPAYMENT(10),
    UNRECOGNIZED(-1);

    private static final B.d n = new B.d() { // from class: ir.nasim.Qq3.a
        @Override // com.google.protobuf.B.d
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public EnumC7187Qq3 a(int i) {
            return EnumC7187Qq3.j(i);
        }
    };
    private final int a;

    EnumC7187Qq3(int i) {
        this.a = i;
    }

    public static EnumC7187Qq3 j(int i) {
        switch (i) {
            case 0:
                return ChargeKifpoolCallbackType_NULL;
            case 1:
                return ChargeKifpoolCallbackType_GIFTPACKET;
            case 2:
                return ChargeKifpoolCallbackType_PUCHASEMESSAGE;
            case 3:
                return ChargeKifpoolCallbackType_CHARGE;
            case 4:
                return ChargeKifpoolCallbackType_ADSPOTPUCHASE;
            case 5:
                return ChargeKifpoolCallbackType_CRYPTO;
            case 6:
                return ChargeKifpoolCallbackType_PURCHASE;
            case 7:
                return ChargeKifpoolCallbackType_BOTPAYMENT;
            case 8:
                return ChargeKifpoolCallbackType_BOTWALLETPAYMENT;
            case 9:
                return ChargeKifpoolCallbackType_BOTGOLDPAYMENT;
            case 10:
                return ChargeKifpoolCallbackType_PREMIUMPAYMENT;
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
