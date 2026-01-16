package ir.nasim;

import com.google.protobuf.B;

/* renamed from: ir.nasim.vg, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public enum EnumC22691vg implements B.c {
    CampaignAdType_VIEW_BASED(0),
    CampaignAdType_CLICK_BASED(1),
    UNRECOGNIZED(-1);

    private static final B.d e = new B.d() { // from class: ir.nasim.vg.a
        @Override // com.google.protobuf.B.d
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public EnumC22691vg a(int i) {
            return EnumC22691vg.j(i);
        }
    };
    private final int a;

    EnumC22691vg(int i) {
        this.a = i;
    }

    public static EnumC22691vg j(int i) {
        if (i == 0) {
            return CampaignAdType_VIEW_BASED;
        }
        if (i != 1) {
            return null;
        }
        return CampaignAdType_CLICK_BASED;
    }

    @Override // com.google.protobuf.B.c
    public final int getNumber() {
        if (this != UNRECOGNIZED) {
            return this.a;
        }
        throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
    }
}
