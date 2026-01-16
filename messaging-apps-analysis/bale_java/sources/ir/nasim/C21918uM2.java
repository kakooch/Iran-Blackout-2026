package ir.nasim;

import ai.bale.proto.GroupsOuterClass$RequestLeaveGroup;
import ai.bale.proto.Misc$ResponseSeqDate;
import ai.bale.proto.PeersStruct$GroupOutPeer;
import com.google.protobuf.BoolValue;
import java.io.IOException;
import java.util.Iterator;

/* renamed from: ir.nasim.uM2, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public class C21918uM2 extends AbstractC6360Ng4 {
    private final C9057Yh4 m;
    private InterfaceC8344Vo3 n;
    private C19806qy3 o;
    private final String p;

    /* renamed from: ir.nasim.uM2$a */
    public static class a implements InterfaceC15283jK {
        private C11458d25 a;

        public a(C11458d25 c11458d25) {
            this.a = c11458d25;
        }

        public C11458d25 a() {
            return this.a;
        }
    }

    public C21918uM2(C9057Yh4 c9057Yh4) {
        super(c9057Yh4);
        this.p = "/bale.groups.v1.Groups/LeaveGroup";
        this.m = c9057Yh4;
        this.n = c9057Yh4.T().C();
        b0("sequences_synced");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ C6517Nv5 f0(long j, C14697iL2 c14697iL2) {
        return L(new C22871vx5("/bale.groups.v1.Groups/LeaveGroup", GroupsOuterClass$RequestLeaveGroup.newBuilder().B((PeersStruct$GroupOutPeer) PeersStruct$GroupOutPeer.newBuilder().B(c14697iL2.p0()).A(c14697iL2.getAccessHash()).a()).D(j).A(PC.b).C(BoolValue.of(false)).a(), Misc$ResponseSeqDate.getDefaultInstance()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ C6517Nv5 g0(C11458d25 c11458d25, Misc$ResponseSeqDate misc$ResponseSeqDate) {
        if (misc$ResponseSeqDate != null && this.o.r().containsKey(c11458d25)) {
            this.o.r().remove(c11458d25);
            j0();
        }
        return C6517Nv5.l0(C14505i18.a);
    }

    @Override // ir.nasim.AbstractC17647nK
    public C6517Nv5 G(Object obj) {
        return obj instanceof a ? h0(((a) obj).a()) : super.G(obj);
    }

    @Override // ir.nasim.AbstractC6360Ng4
    public void V() {
        Iterator it = this.o.r().keySet().iterator();
        while (it.hasNext()) {
            i0((C11458d25) it.next());
        }
    }

    public C6517Nv5 h0(C11458d25 c11458d25) {
        if (!this.o.r().containsKey(c11458d25)) {
            this.o.r().put(c11458d25, new C19215py3(c11458d25));
        }
        j0();
        return i0(c11458d25);
    }

    public C6517Nv5 i0(final C11458d25 c11458d25) {
        final long jA = AbstractC19981rG5.a();
        return this.m.E().X1().a(c11458d25.getPeerId()).H(new InterfaceC17569nB2() { // from class: ir.nasim.sM2
            @Override // ir.nasim.InterfaceC17569nB2
            public final Object apply(Object obj) {
                return this.a.f0(jA, (C14697iL2) obj);
            }
        }).H(new InterfaceC17569nB2() { // from class: ir.nasim.tM2
            @Override // ir.nasim.InterfaceC17569nB2
            public final Object apply(Object obj) {
                return this.a.g0(c11458d25, (Misc$ResponseSeqDate) obj);
            }
        });
    }

    void j0() {
        this.n.e(new C9863ah0(18L, this.o.toByteArray()));
    }

    @Override // ir.nasim.K6
    public void o() {
        super.o();
        C9863ah0 c9863ah0 = (C9863ah0) this.n.d(18L);
        if (c9863ah0 == null) {
            this.o = new C19806qy3();
            return;
        }
        try {
            this.o = C19806qy3.q(c9863ah0.q());
        } catch (IOException e) {
            C19406qI3.c("GroupLeaveActor", "preStart(loadFromBytes)", e);
            this.o = new C19806qy3();
        }
    }
}
