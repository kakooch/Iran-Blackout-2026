package ir.nasim;

import ir.nasim.GM3;
import ir.nasim.core.modules.profile.entity.ExPeerType;
import ir.nasim.database.dailogLists.DialogEntity;
import java.util.concurrent.TimeUnit;

/* loaded from: classes5.dex */
public final class Q74 {
    private final C14733iO2 a;
    private final UA2 b;
    private final InterfaceC14603iB2 c;
    private final InterfaceC14603iB2 d;
    private final long e;

    public Q74(C14733iO2 c14733iO2, UA2 ua2, InterfaceC14603iB2 interfaceC14603iB2, InterfaceC14603iB2 interfaceC14603iB22, long j) {
        AbstractC13042fc3.i(ua2, "isUpVoted");
        AbstractC13042fc3.i(interfaceC14603iB2, "revokeUpVotePost");
        AbstractC13042fc3.i(interfaceC14603iB22, "setUpVotePost");
        this.a = c14733iO2;
        this.b = ua2;
        this.c = interfaceC14603iB2;
        this.d = interfaceC14603iB22;
        this.e = j;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 d(Q74 q74, long j, long j2) {
        AbstractC13042fc3.i(q74, "this$0");
        q74.c.invoke(Long.valueOf(j), Long.valueOf(j2));
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 e(Q74 q74, long j, long j2) {
        AbstractC13042fc3.i(q74, "this$0");
        q74.d.invoke(Long.valueOf(j), Long.valueOf(j2));
        return C19938rB7.a;
    }

    public final GM3 c(final long j, final long j2, C4602Fv2 c4602Fv2, ExPeerType exPeerType) {
        C19482qQ7 c19482qQ7E;
        AbstractC13042fc3.i(exPeerType, DialogEntity.COLUMN_EX_PEER_TYPE);
        long millis = TimeUnit.HOURS.toMillis(this.e);
        boolean z = false;
        if (!C8386Vt0.M7() ? !C14593iA1.L(j2) : System.currentTimeMillis() - j2 >= millis) {
            z = true;
        }
        if (C8386Vt0.K7() && c4602Fv2 == null && exPeerType == ExPeerType.CHANNEL) {
            C14733iO2 c14733iO2 = this.a;
            if (((c14733iO2 == null || (c19482qQ7E = c14733iO2.E()) == null) ? null : (W06) c19482qQ7E.b()) != W06.PRIVATE && !z) {
                return ((Boolean) this.b.invoke(Long.valueOf(j))).booleanValue() ? new GM3.c(new SA2() { // from class: ir.nasim.O74
                    @Override // ir.nasim.SA2
                    public final Object invoke() {
                        return Q74.d(this.a, j2, j);
                    }
                }) : !((Boolean) this.b.invoke(Long.valueOf(j))).booleanValue() ? new GM3.b(new SA2() { // from class: ir.nasim.P74
                    @Override // ir.nasim.SA2
                    public final Object invoke() {
                        return Q74.e(this.a, j2, j);
                    }
                }) : GM3.a.b;
            }
        }
        return GM3.a.b;
    }
}
