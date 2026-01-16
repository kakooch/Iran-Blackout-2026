package ir.nasim;

import com.google.protobuf.B;

/* renamed from: ir.nasim.zg, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public enum EnumC25061zg implements B.c {
    CampaignState_AWAITINGAPPROVAL(0),
    CampaignState_APPROVED(1),
    CampaignState_ACTIVE(2),
    CampaignState_PAUSED(3),
    CampaignState_FINISHED(4),
    CampaignState_REJECTED(5),
    CampaignState_CANCLED(6),
    UNRECOGNIZED(-1);

    private static final B.d j = new B.d() { // from class: ir.nasim.zg.a
        @Override // com.google.protobuf.B.d
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public EnumC25061zg a(int i) {
            return EnumC25061zg.j(i);
        }
    };
    private final int a;

    EnumC25061zg(int i) {
        this.a = i;
    }

    public static EnumC25061zg j(int i) {
        switch (i) {
            case 0:
                return CampaignState_AWAITINGAPPROVAL;
            case 1:
                return CampaignState_APPROVED;
            case 2:
                return CampaignState_ACTIVE;
            case 3:
                return CampaignState_PAUSED;
            case 4:
                return CampaignState_FINISHED;
            case 5:
                return CampaignState_REJECTED;
            case 6:
                return CampaignState_CANCLED;
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
