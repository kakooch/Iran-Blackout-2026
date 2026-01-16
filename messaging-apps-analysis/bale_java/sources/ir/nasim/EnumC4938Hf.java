package ir.nasim;

import com.google.protobuf.B;

/* renamed from: ir.nasim.Hf, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public enum EnumC4938Hf implements B.c {
    AdSpot_UNKNOWN(0),
    AdSpot_VITRINE(1),
    AdSpot_SEARCHBAR(2),
    AdSpot_CHANNEL(3),
    AdSpot_DIALOG(4),
    AdSpot_BOT(5),
    AdSpot_MYBANK(6),
    AdSpot_MARKET(7),
    AdSpot_ONBOARDING(8),
    AdSpot_SPONSORED_MESSAGE(9),
    AdSpot_UNDER_PEER(10),
    UNRECOGNIZED(-1);

    private static final B.d n = new B.d() { // from class: ir.nasim.Hf.a
        @Override // com.google.protobuf.B.d
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public EnumC4938Hf a(int i) {
            return EnumC4938Hf.j(i);
        }
    };
    private final int a;

    EnumC4938Hf(int i) {
        this.a = i;
    }

    public static EnumC4938Hf j(int i) {
        switch (i) {
            case 0:
                return AdSpot_UNKNOWN;
            case 1:
                return AdSpot_VITRINE;
            case 2:
                return AdSpot_SEARCHBAR;
            case 3:
                return AdSpot_CHANNEL;
            case 4:
                return AdSpot_DIALOG;
            case 5:
                return AdSpot_BOT;
            case 6:
                return AdSpot_MYBANK;
            case 7:
                return AdSpot_MARKET;
            case 8:
                return AdSpot_ONBOARDING;
            case 9:
                return AdSpot_SPONSORED_MESSAGE;
            case 10:
                return AdSpot_UNDER_PEER;
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
