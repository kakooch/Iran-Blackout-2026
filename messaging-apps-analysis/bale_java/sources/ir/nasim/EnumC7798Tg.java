package ir.nasim;

import com.google.protobuf.B;

/* renamed from: ir.nasim.Tg, reason: case insensitive filesystem */
/* loaded from: classes9.dex */
public enum EnumC7798Tg implements B.c {
    CreditChangeReason_UNKNOWN(0),
    CreditChangeReason_CAMPAIGNCOST(1),
    CreditChangeReason_BUYPACKAGE(2),
    CreditChangeReason_MANUAL(3),
    CreditChangeReason_EXPIRECREDIT(4),
    CreditChangeReason_RESTOREEXPIRECREDIT(5),
    CreditChangeReason_CHANNELINCOME(6),
    UNRECOGNIZED(-1);

    private static final B.d j = new B.d() { // from class: ir.nasim.Tg.a
        @Override // com.google.protobuf.B.d
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public EnumC7798Tg a(int i) {
            return EnumC7798Tg.j(i);
        }
    };
    private final int a;

    EnumC7798Tg(int i) {
        this.a = i;
    }

    public static EnumC7798Tg j(int i) {
        switch (i) {
            case 0:
                return CreditChangeReason_UNKNOWN;
            case 1:
                return CreditChangeReason_CAMPAIGNCOST;
            case 2:
                return CreditChangeReason_BUYPACKAGE;
            case 3:
                return CreditChangeReason_MANUAL;
            case 4:
                return CreditChangeReason_EXPIRECREDIT;
            case 5:
                return CreditChangeReason_RESTOREEXPIRECREDIT;
            case 6:
                return CreditChangeReason_CHANNELINCOME;
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
