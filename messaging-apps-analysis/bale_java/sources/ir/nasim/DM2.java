package ir.nasim;

import ai.bale.proto.PeersStruct$GroupOutPeer;

/* loaded from: classes7.dex */
public final class DM2 implements InterfaceC14123hO3 {
    public static final int b = C10299bQ2.j;
    private final C10299bQ2 a;

    public DM2(C10299bQ2 c10299bQ2) {
        AbstractC13042fc3.i(c10299bQ2, "groupsModule");
        this.a = c10299bQ2;
    }

    @Override // ir.nasim.InterfaceC14123hO3
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public C21586tn4 a(PeersStruct$GroupOutPeer peersStruct$GroupOutPeer) {
        AbstractC13042fc3.i(peersStruct$GroupOutPeer, "input");
        C14697iL2 c14697iL2 = (C14697iL2) this.a.X1().d(peersStruct$GroupOutPeer.getGroupId());
        if (c14697iL2 == null) {
            return null;
        }
        int groupId = peersStruct$GroupOutPeer.getGroupId();
        String strG0 = c14697iL2.G0();
        AbstractC13042fc3.h(strG0, "getTitle(...)");
        return new C21586tn4(groupId, strG0, c14697iL2.t0(), 0);
    }
}
