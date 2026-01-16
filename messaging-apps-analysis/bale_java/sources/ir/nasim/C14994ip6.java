package ir.nasim;

import ai.bale.proto.Ghasedak$RouteSeqState;
import ai.bale.proto.PeersStruct$GroupOutPeer;
import android.gov.nist.core.Separators;
import com.google.protobuf.GeneratedMessageLite;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/* renamed from: ir.nasim.ip6, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C14994ip6 {
    public static final a d = new a(null);
    public static final int e = 8;
    private final CM2 a;
    private final int b;
    private final byte[] c;

    /* renamed from: ir.nasim.ip6$a */
    public static final class a {
        private a() {
        }

        private final UB c(Ghasedak$RouteSeqState ghasedak$RouteSeqState) {
            return new UB(new C25238zy(ghasedak$RouteSeqState.getGroupPeer().getGroupId(), ghasedak$RouteSeqState.getGroupPeer().getAccessHash()), ghasedak$RouteSeqState.getSeq(), new byte[0]);
        }

        private final Ghasedak$RouteSeqState e(C14994ip6 c14994ip6) {
            GeneratedMessageLite generatedMessageLiteA = Ghasedak$RouteSeqState.newBuilder().B(c14994ip6.d()).A((PeersStruct$GroupOutPeer) PeersStruct$GroupOutPeer.newBuilder().B(c14994ip6.c().b()).a()).a();
            AbstractC13042fc3.h(generatedMessageLiteA, "build(...)");
            return (Ghasedak$RouteSeqState) generatedMessageLiteA;
        }

        public final List a(List list) {
            C14994ip6 c14994ip6;
            AbstractC13042fc3.i(list, "apiSeqStates");
            List<UB> list2 = list;
            ArrayList arrayList = new ArrayList(AbstractC10976cX0.x(list2, 10));
            for (UB ub : list2) {
                C25238zy c25238zyQ = ub.q();
                if (c25238zyQ != null) {
                    int iQ = c25238zyQ.q();
                    C25238zy c25238zyQ2 = ub.q();
                    CM2 cm2 = new CM2(iQ, c25238zyQ2 != null ? c25238zyQ2.getAccessHash() : 0L);
                    int iR = ub.r();
                    byte[] bArrS = ub.s();
                    AbstractC13042fc3.h(bArrS, "getState(...)");
                    c14994ip6 = new C14994ip6(cm2, iR, bArrS);
                } else {
                    c14994ip6 = null;
                }
                arrayList.add(c14994ip6);
            }
            return AbstractC15401jX0.n0(arrayList);
        }

        public final C14994ip6 b(Ghasedak$RouteSeqState ghasedak$RouteSeqState) {
            AbstractC13042fc3.i(ghasedak$RouteSeqState, "apiSeqState");
            return new C14994ip6(new CM2(ghasedak$RouteSeqState.getGroupPeer().getGroupId(), ghasedak$RouteSeqState.getGroupPeer().getAccessHash()), ghasedak$RouteSeqState.getSeq(), new byte[0]);
        }

        public final List d(List list) {
            AbstractC13042fc3.i(list, "apiSeqState");
            List list2 = list;
            ArrayList arrayList = new ArrayList(AbstractC10976cX0.x(list2, 10));
            Iterator it = list2.iterator();
            while (it.hasNext()) {
                arrayList.add(C14994ip6.d.c((Ghasedak$RouteSeqState) it.next()));
            }
            return arrayList;
        }

        public final List f(List list) {
            AbstractC13042fc3.i(list, "apiSeqState");
            List list2 = list;
            ArrayList arrayList = new ArrayList(AbstractC10976cX0.x(list2, 10));
            Iterator it = list2.iterator();
            while (it.hasNext()) {
                arrayList.add(C14994ip6.d.e((C14994ip6) it.next()));
            }
            return arrayList;
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    public C14994ip6(CM2 cm2, int i, byte[] bArr) {
        AbstractC13042fc3.i(cm2, "groupPeer");
        AbstractC13042fc3.i(bArr, "state");
        this.a = cm2;
        this.b = i;
        this.c = bArr;
    }

    public static final List a(List list) {
        return d.a(list);
    }

    public static final C14994ip6 b(Ghasedak$RouteSeqState ghasedak$RouteSeqState) {
        return d.b(ghasedak$RouteSeqState);
    }

    public static final List e(List list) {
        return d.d(list);
    }

    public static final List f(List list) {
        return d.f(list);
    }

    public final CM2 c() {
        return this.a;
    }

    public final int d() {
        return this.b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C14994ip6)) {
            return false;
        }
        C14994ip6 c14994ip6 = (C14994ip6) obj;
        return AbstractC13042fc3.d(this.a, c14994ip6.a) && this.b == c14994ip6.b && AbstractC13042fc3.d(this.c, c14994ip6.c);
    }

    public int hashCode() {
        return (((this.a.hashCode() * 31) + Integer.hashCode(this.b)) * 31) + Arrays.hashCode(this.c);
    }

    public String toString() {
        return "SeqState(groupPeer=" + this.a + ", seq=" + this.b + ", state=" + Arrays.toString(this.c) + Separators.RPAREN;
    }
}
