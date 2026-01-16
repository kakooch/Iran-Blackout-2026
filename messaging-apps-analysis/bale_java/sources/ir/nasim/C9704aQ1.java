package ir.nasim;

import ir.nasim.UO1;
import ir.nasim.core.modules.profile.entity.ExPeerType;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* renamed from: ir.nasim.aQ1, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public class C9704aQ1 extends AbstractC6360Ng4 {
    private InterfaceC6828Pd5 A;
    private final String m;
    private final C9057Yh4 n;
    private DB3 o;
    private DB3 p;
    private DB3 q;
    private DB3 r;
    private DB3 s;
    private final HashMap t;
    private E84 u;
    private HashMap v;
    private final OK w;
    private HashMap x;
    private InterfaceC20667sP1 y;
    private InterfaceC7663Sr2 z;

    /* renamed from: ir.nasim.aQ1$a */
    static /* synthetic */ class a {
        static final /* synthetic */ int[] a;
        static final /* synthetic */ int[] b;
        static final /* synthetic */ int[] c;

        static {
            int[] iArr = new int[W25.values().length];
            c = iArr;
            try {
                iArr[W25.a.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                c[W25.b.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            int[] iArr2 = new int[OP1.values().length];
            b = iArr2;
            try {
                iArr2[OP1.ALL.ordinal()] = 1;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                b[OP1.PRIVATE.ordinal()] = 2;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                b[OP1.GROUP.ordinal()] = 3;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                b[OP1.CHANNEL.ordinal()] = 4;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                b[OP1.BOT.ordinal()] = 5;
            } catch (NoSuchFieldError unused7) {
            }
            int[] iArr3 = new int[ExPeerType.values().length];
            a = iArr3;
            try {
                iArr3[ExPeerType.PRIVATE.ordinal()] = 1;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                a[ExPeerType.GROUP.ordinal()] = 2;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                a[ExPeerType.CHANNEL.ordinal()] = 3;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                a[ExPeerType.BOT.ordinal()] = 4;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                a[ExPeerType.UNKNOWN.ordinal()] = 5;
            } catch (NoSuchFieldError unused12) {
            }
        }
    }

    public C9704aQ1(C9057Yh4 c9057Yh4, OK ok) {
        super(c9057Yh4);
        this.m = "DialogsActor";
        this.t = new HashMap();
        this.n = c9057Yh4;
        this.w = ok;
    }

    private C6517Nv5 A0(int i, List list) {
        if (C8386Vt0.u8()) {
            this.A.c(list, i);
        }
        return C6517Nv5.l0(C14505i18.a);
    }

    private C6517Nv5 B0(int i, String str, int i2, List list) {
        if (C8386Vt0.u8()) {
            this.z.a(i, str, i2, list);
        }
        return C6517Nv5.l0(C14505i18.a);
    }

    private C6517Nv5 C0(int i) {
        if (C8386Vt0.u8()) {
            this.z.b(i);
        }
        return C6517Nv5.l0(C14505i18.a);
    }

    private C6517Nv5 D0(int i, String str, List list, List list2) {
        if (C8386Vt0.u8()) {
            this.z.d(i, str, list, list2);
        }
        return C6517Nv5.l0(C14505i18.a);
    }

    private C6517Nv5 E0(List list) {
        if (C8386Vt0.u8()) {
            this.z.c(list);
        }
        return C6517Nv5.l0(C14505i18.a);
    }

    private C6517Nv5 F0(C14697iL2 c14697iL2) {
        if (C8386Vt0.u8()) {
            UO1.a.b("onGroupChanged", "PeerId: " + c14697iL2.I0().getPeerId());
            this.y.a(c14697iL2);
        } else {
            C17067mL1 c17067mL1K0 = k0(c14697iL2.I0().u());
            if (c17067mL1K0 != null) {
                e0(c17067mL1K0.C(c14697iL2.G0(), c14697iL2.h0()).z(c14697iL2.x0()));
            }
        }
        V0(c14697iL2);
        return C6517Nv5.l0(C14505i18.a);
    }

    private C6517Nv5 G0(C11458d25 c11458d25, J44 j44, boolean z, List list, ExPeerType exPeerType, int i, long j) {
        D25 d25I0 = i0(c11458d25);
        if (d25I0 == null) {
            C19406qI3.a("DialogsActor", "unknown peer desc", new Object[0]);
            return C6517Nv5.l0(C14505i18.a);
        }
        if (C8386Vt0.u8()) {
            UO1.a.b("onNewMessage", String.format("PeerId: %d \n\t isFromDelete: %b \n\t newUnreadCount: %d, \n\t outReadDate: %d", Integer.valueOf(c11458d25.getPeerId()), Boolean.valueOf(z), Integer.valueOf(i), Long.valueOf(j)));
            this.y.C(c11458d25, j44, z, exPeerType, list, i, j);
        } else {
            h0(c11458d25, j44, z, d25I0, i, exPeerType, list);
        }
        C19406qI3.a("DialogsActor", "onMessage(peerId=" + c11458d25.getPeerId() + ", fromDelete=" + z + ") updating short dialogs!", new Object[0]);
        W0(c11458d25, j44, d25I0, exPeerType, i);
        C19406qI3.a("DialogsActor", "onMessage(peerId=" + c11458d25.getPeerId() + ", fromDelete=" + z + ") ended!", new Object[0]);
        return C6517Nv5.l0(C14505i18.a);
    }

    private C6517Nv5 H0(C11458d25 c11458d25, long j, AbstractC17457n0 abstractC17457n0) {
        if (C8386Vt0.u8()) {
            UO1.a.b("onMessageContentChanged", String.format("PeerId: %d \n\t rid: %d, \n\t content: %s", Integer.valueOf(c11458d25.getPeerId()), Long.valueOf(j), abstractC17457n0.getClass().getSimpleName()));
            this.y.N(c11458d25, j, abstractC17457n0);
        } else {
            C17067mL1 c17067mL1K0 = k0(c11458d25.u());
            if (c17067mL1K0 != null && c17067mL1K0.Q().i() == j) {
                e0(c17067mL1K0.s(c17067mL1K0.Q().u(abstractC17457n0, false)));
            }
        }
        return C6517Nv5.l0(C14505i18.a);
    }

    private C6517Nv5 I0(C11458d25 c11458d25, long j, long j2) {
        if (C8386Vt0.u8()) {
            UO1.a.b("onMessageDeleteMention", String.format("PeerId: %d \n\t date: %d \n\t rid: %d", Integer.valueOf(c11458d25.getPeerId()), Long.valueOf(j2), Long.valueOf(j)));
            this.y.j(c11458d25, j, j2);
        } else {
            C17067mL1 c17067mL1K0 = k0(c11458d25.u());
            if (c17067mL1K0 != null && !c17067mL1K0.a0().isEmpty()) {
                C17067mL1 c17067mL1D = new JL1(c17067mL1K0).e(new Q64(j2, j)).d();
                f0(c17067mL1D, c17067mL1D.getExPeerType());
            }
        }
        return C6517Nv5.l0(C14505i18.a);
    }

    private C6517Nv5 J0(C11458d25 c11458d25, long j, long j2) {
        if (C8386Vt0.u8()) {
            UO1.a.b("onMessageDeleteReaction", String.format("PeerId: %d \n\t date: %d \n\t rid: %d", Integer.valueOf(c11458d25.getPeerId()), Long.valueOf(j2), Long.valueOf(j)));
            this.y.t(c11458d25, j, j2);
        } else {
            C17067mL1 c17067mL1K0 = k0(c11458d25.u());
            if (c17067mL1K0 != null && !c17067mL1K0.b0().isEmpty()) {
                C17067mL1 c17067mL1D = new JL1(c17067mL1K0).g(new Q64(j2, j)).d();
                f0(c17067mL1D, c17067mL1D.getExPeerType());
            }
        }
        return C6517Nv5.l0(C14505i18.a);
    }

    private C6517Nv5 K0(C11458d25 c11458d25, long j, long j2) {
        if (C8386Vt0.u8()) {
            UO1.a.b("onMessageNewReaction", String.format("PeerId: %d \n\t date: %d \n\t rid: %d", Integer.valueOf(c11458d25.getPeerId()), Long.valueOf(j2), Long.valueOf(j)));
            this.y.J(c11458d25, j, j2);
        } else {
            C17067mL1 c17067mL1K0 = k0(c11458d25.u());
            if (c17067mL1K0 != null) {
                e0(new JL1(c17067mL1K0).c(new Q64(j2, j)).d());
            }
        }
        return C6517Nv5.l0(C14505i18.a);
    }

    private C6517Nv5 L0(C11458d25 c11458d25, long j) {
        if (C8386Vt0.u8()) {
            UO1.a.b("onPeerRead", String.format("PeerId: %d \n\t date: %d", Integer.valueOf(c11458d25.getPeerId()), Long.valueOf(j)));
            this.y.i(c11458d25, j);
        } else {
            C17067mL1 c17067mL1K0 = k0(c11458d25.u());
            if (c17067mL1K0 != null) {
                e0(new JL1(c17067mL1K0).y(Long.valueOf(j)).z(Long.valueOf(j)).d());
            }
        }
        return C6517Nv5.l0(C14505i18.a);
    }

    private C6517Nv5 M0(C11458d25 c11458d25, long j) {
        if (C8386Vt0.u8()) {
            UO1.a.b("onPeerReceive", String.format("PeerId: %d \n\t date: %d", Integer.valueOf(c11458d25.getPeerId()), Long.valueOf(j)));
            this.y.K(c11458d25, j);
        } else {
            C17067mL1 c17067mL1K0 = k0(c11458d25.u());
            if (c17067mL1K0 != null) {
                e0(new JL1(c17067mL1K0).z(Long.valueOf(j)).d());
            }
        }
        return C6517Nv5.l0(C14505i18.a);
    }

    private C6517Nv5 N0(int i, List list) {
        if (C8386Vt0.u8()) {
            this.A.e(list, i);
        }
        return C6517Nv5.l0(C14505i18.a);
    }

    private C6517Nv5 O0(C11458d25 c11458d25, long j, String str) {
        if (C8386Vt0.u8()) {
            UO1.a.b("onUpdateDraft", String.format("PeerId: %d \n\t | draftDate: %d \n\t | isDraftEmpty: %b", Integer.valueOf(c11458d25.getPeerId()), Long.valueOf(j), Boolean.valueOf(YP1.a(str))));
            this.y.z(c11458d25, Long.valueOf(j), str);
        } else {
            C17067mL1 c17067mL1K0 = k0(c11458d25.u());
            if (c17067mL1K0 != null) {
                JL1 jl1 = new JL1(c17067mL1K0);
                jl1.k(str).x(Long.valueOf(j));
                e0(jl1.d());
            } else {
                this.t.put(Long.valueOf(c11458d25.u()), str);
            }
        }
        return C6517Nv5.l0(C14505i18.a);
    }

    private C6517Nv5 P0(C17637nI7 c17637nI7) {
        if (C8386Vt0.u8()) {
            UO1.a.b("onUserChanged", "PeerId: " + c17637nI7.u0().getPeerId());
            this.y.B(c17637nI7);
        } else {
            C17067mL1 c17067mL1K0 = k0(c17637nI7.u0().u());
            if (c17067mL1K0 != null) {
                e0(c17067mL1K0.D(c17637nI7.getName(), c17637nI7.S(), c17637nI7.r0()).G(c17637nI7.i0()).z(c17637nI7.e0()));
            }
        }
        X0(c17637nI7);
        return C6517Nv5.l0(C14505i18.a);
    }

    private C6517Nv5 Q0(C17067mL1 c17067mL1) throws IOException {
        C17067mL1 c17067mL1F;
        if (c17067mL1.e0()) {
            c17067mL1F = c17067mL1.F(-1L);
            this.x.remove(Long.valueOf(c17067mL1.R().u()));
        } else {
            long j = W().getLong("LAST_PIN_INDEX", 0L);
            C17067mL1 c17067mL1F2 = c17067mL1.F(j);
            this.x.put(Long.valueOf(c17067mL1.R().u()), Long.valueOf(j));
            W().putLong("LAST_PIN_INDEX", j + 1);
            c17067mL1F = c17067mL1F2;
        }
        T0();
        e0(c17067mL1F);
        return C6517Nv5.l0(C14505i18.a);
    }

    private C6517Nv5 R0(Object obj) {
        if (obj instanceof C19875r53) {
            C19406qI3.a("DialogsActor", "processMessage called with message: InMessage", new Object[0]);
            C19875r53 c19875r53 = (C19875r53) obj;
            return G0(c19875r53.f(), c19875r53.c(), false, c19875r53.b(), c19875r53.a(), c19875r53.d(), c19875r53.e());
        }
        if (obj instanceof C21213tI7) {
            C19406qI3.a("DialogsActor", "processMessage called with message: UserChanged", new Object[0]);
            return P0(((C21213tI7) obj).a());
        }
        if (obj instanceof C16475lL0) {
            C19406qI3.a("DialogsActor", "processMessage called with message: ChatClear", new Object[0]);
            return u0(((C16475lL0) obj).a());
        }
        if (obj instanceof C17066mL0) {
            C19406qI3.a("DialogsActor", "processMessage called with message: ChatDelete", new Object[0]);
            return v0(((C17066mL0) obj).a());
        }
        if (obj instanceof G25) {
            C19406qI3.a("DialogsActor", "processMessage called with message: PeerReadChanged", new Object[0]);
            G25 g25 = (G25) obj;
            return L0(g25.b(), g25.a());
        }
        if (obj instanceof H25) {
            C19406qI3.a("DialogsActor", "processMessage called with message: PeerReceiveChanged", new Object[0]);
            H25 h25 = (H25) obj;
            return M0(h25.b(), h25.a());
        }
        if (obj instanceof C24138y64) {
            C19406qI3.a("DialogsActor", "processMessage called with message: MessageDeleted", new Object[0]);
            C24138y64 c24138y64 = (C24138y64) obj;
            return G0(c24138y64.d(), c24138y64.e(), true, c24138y64.f(), c24138y64.a(), c24138y64.b(), c24138y64.c());
        }
        if (obj instanceof C5993Ls2) {
            return E0(((C5993Ls2) obj).a());
        }
        if (obj instanceof C11979ds2) {
            C11979ds2 c11979ds2 = (C11979ds2) obj;
            return D0(c11979ds2.c(), c11979ds2.d(), c11979ds2.a(), c11979ds2.b());
        }
        if (obj instanceof C10595bs2) {
            return C0(((C10595bs2) obj).a());
        }
        if (obj instanceof C8604Wr2) {
            C8604Wr2 c8604Wr2 = (C8604Wr2) obj;
            return B0(c8604Wr2.a(), c8604Wr2.b(), c8604Wr2.c(), c8604Wr2.d());
        }
        if (obj instanceof C9022Yd5) {
            C19406qI3.a("DialogsActor", "processMessage called with message: PinnedDialogsChanged", new Object[0]);
            C9022Yd5 c9022Yd5 = (C9022Yd5) obj;
            return N0(c9022Yd5.b(), c9022Yd5.a());
        }
        if (obj instanceof C20703sT1) {
            C19406qI3.a("DialogsActor", "processMessage called with message: DialogsUnpinned", new Object[0]);
            C20703sT1 c20703sT1 = (C20703sT1) obj;
            return A0(c20703sT1.a(), c20703sT1.b());
        }
        if (obj instanceof C24728z64) {
            C19406qI3.a("DialogsActor", "processMessage called with message: MessageDeletedMention", new Object[0]);
            C24728z64 c24728z64 = (C24728z64) obj;
            return I0(c24728z64.b(), c24728z64.c(), c24728z64.a());
        }
        if (obj instanceof VO1) {
            C19406qI3.a("DialogsActor", "processMessage called with message: DialogMarkAsRead", new Object[0]);
            return x0(((VO1) obj).a());
        }
        if (obj instanceof WO1) {
            C19406qI3.a("DialogsActor", "processMessage called with message: DialogMarkAsUnRead", new Object[0]);
            return y0(((WO1) obj).a());
        }
        if (obj instanceof A64) {
            C19406qI3.a("DialogsActor", "processMessage called with message: MessageDeletedReaction", new Object[0]);
            A64 a64 = (A64) obj;
            return J0(a64.b(), a64.c(), a64.a());
        }
        if (obj instanceof C9533a74) {
            C19406qI3.a("DialogsActor", "processMessage called with message: MessageNewReaction", new Object[0]);
            C9533a74 c9533a74 = (C9533a74) obj;
            return K0(c9533a74.b(), c9533a74.c(), c9533a74.a());
        }
        if (obj instanceof C17139mT1) {
            C19406qI3.a("DialogsActor", "processMessage called with message: DialogsLoaded", new Object[0]);
            C17139mT1 c17139mT1 = (C17139mT1) obj;
            return z0(c17139mT1.b(), c17139mT1.c(), c17139mT1.a(), c17139mT1.d());
        }
        if (obj instanceof C13513gM2) {
            C19406qI3.a("DialogsActor", "processMessage called with message: GroupChanged", new Object[0]);
            return F0(((C13513gM2) obj).a());
        }
        if (obj instanceof Q54) {
            C19406qI3.a("DialogsActor", "processMessage called with message: MessageContentChanged", new Object[0]);
            Q54 q54 = (Q54) obj;
            return H0(q54.b(), q54.c(), q54.a());
        }
        if (obj instanceof C9117Yo1) {
            C19406qI3.a("DialogsActor", "processMessage called with message: CounterChanged", new Object[0]);
            C9117Yo1 c9117Yo1 = (C9117Yo1) obj;
            return w0(c9117Yo1.b(), c9117Yo1.a());
        }
        if (obj instanceof C21377tZ1) {
            C19406qI3.a("DialogsActor", "processMessage called with message: DraftChange", new Object[0]);
            C21377tZ1 c21377tZ1 = (C21377tZ1) obj;
            return O0(c21377tZ1.c(), c21377tZ1.b(), c21377tZ1.a());
        }
        if (obj instanceof C5578Jy0) {
            C19406qI3.a("DialogsActor", "processMessage called with message: CallRunning", new Object[0]);
            C5578Jy0 c5578Jy0 = (C5578Jy0) obj;
            return j0(c5578Jy0.a(), c5578Jy0.b());
        }
        if (!(obj instanceof KD3)) {
            return null;
        }
        KD3 kd3 = (KD3) obj;
        C19406qI3.a("DialogsActor", "processMessage called with message: liveStreamMessage", new Object[0]);
        return s0(kd3.b(), kd3.a());
    }

    private void S0(C11458d25 c11458d25) {
        long jU = c11458d25.u();
        this.o.b(jU);
        ExPeerType exPeerTypeM1 = this.n.E().M1(c11458d25);
        if (exPeerTypeM1 != null) {
            int i = a.a[exPeerTypeM1.ordinal()];
            if (i != 1) {
                if (i == 2) {
                    this.q.b(jU);
                    return;
                }
                if (i == 3) {
                    this.p.b(jU);
                    return;
                } else if (i == 4) {
                    this.s.b(jU);
                    return;
                } else if (i != 5) {
                    return;
                }
            }
            this.r.b(jU);
        }
    }

    private void T0() throws IOException {
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            new ObjectOutputStream(byteArrayOutputStream).writeObject(this.x);
            this.w.e(new C9863ah0(10L, byteArrayOutputStream.toByteArray()));
        } catch (IOException e) {
            C19406qI3.c("DialogsActor", "savePinnedDialogsHashToBlob", e);
        }
    }

    private void U0(C25254zz6 c25254zz6) {
        this.n.Q().O(Collections.singletonList(c25254zz6));
    }

    private void V0(C14697iL2 c14697iL2) {
        C25254zz6 c25254zz6N0 = n0(c14697iL2.I0());
        if (c25254zz6N0 == null) {
            return;
        }
        U0(new C25254zz6(c14697iL2.I0(), c14697iL2.G0(), c25254zz6N0.r(), c25254zz6N0.h(), c25254zz6N0.getExPeerType(), c25254zz6N0.s(), null));
    }

    private void W0(C11458d25 c11458d25, J44 j44, D25 d25, ExPeerType exPeerType, int i) {
        C25254zz6 c25254zz6N0 = n0(c11458d25);
        if (c25254zz6N0 != null) {
            U0(new C25254zz6(c11458d25, d25.c(), i, j44.h(), exPeerType, c25254zz6N0.s(), null));
        } else {
            U0(new C25254zz6(c11458d25, d25.c(), i, j44.h(), exPeerType, null, null));
        }
    }

    private void X0(C17637nI7 c17637nI7) {
        C25254zz6 c25254zz6N0 = n0(c17637nI7.u0());
        if (c25254zz6N0 == null) {
            return;
        }
        U0(new C25254zz6(c17637nI7.u0(), c17637nI7.getName(), c25254zz6N0.r(), c25254zz6N0.h(), c25254zz6N0.getExPeerType(), c25254zz6N0.s(), null));
    }

    private void e0(C17067mL1 c17067mL1) {
        f0(c17067mL1, c17067mL1.getExPeerType() != null ? c17067mL1.getExPeerType() : this.n.E().M1(c17067mL1.R()));
    }

    private void f0(C17067mL1 c17067mL1, ExPeerType exPeerType) {
        if (c17067mL1.R().u() != 6180860182L) {
            this.o.d(c17067mL1);
        }
        int i = a.a[exPeerType.ordinal()];
        if (i == 1) {
            this.r.d(c17067mL1);
            return;
        }
        if (i == 2) {
            this.q.d(c17067mL1);
            return;
        }
        if (i != 3) {
            if (i != 4) {
                return;
            }
            this.s.d(c17067mL1);
        } else if (c17067mL1.R().u() != 6180860182L) {
            this.p.d(c17067mL1);
        }
    }

    private void g0(List list, OP1 op1, boolean z) {
        for (int i = 0; i < list.size(); i++) {
            C17067mL1 c17067mL1 = (C17067mL1) list.get(i);
            long jU = c17067mL1.R().u();
            if (this.x.containsKey(Long.valueOf(jU))) {
                C19406qI3.a("DialogsActor", "addOrUpdateLoadedDialogs contains pinned dialogs size : " + this.x.size(), new Object[0]);
                JL1 jl1 = new JL1(c17067mL1);
                jl1.q(((Long) this.x.get(Long.valueOf(jU))).longValue());
                list.set(i, jl1.d());
            }
        }
        if (op1 == null) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                e0((C17067mL1) it.next());
            }
            return;
        }
        DB3 db3 = (DB3) this.v.get(op1);
        if (db3 != null) {
            if (z) {
                db3.s(list);
            } else {
                db3.c(list);
            }
        }
    }

    private void h0(C11458d25 c11458d25, J44 j44, boolean z, D25 d25, int i, ExPeerType exPeerType, List list) {
        JL1 jl1O;
        C17067mL1 c17067mL1K0 = k0(c11458d25.u());
        if (c17067mL1K0 == null) {
            C25254zz6 c25254zz6N0 = n0(c11458d25);
            JL1 jl1Y = new JL1(c11458d25, j44, d25.c()).r(d25.b()).j(d25.a()).i(d25.d()).t(j44.W()).u(i).y(c25254zz6N0 != null ? Long.valueOf(c25254zz6N0.h()) : null);
            if (C8386Vt0.w7()) {
                FD3 fd3 = (FD3) ((Map) ((JD3) C92.a(C5721Ko.b, JD3.class)).b().m().getValue()).get(Long.valueOf(c11458d25.u()));
                jl1Y.o(fd3 != null ? Long.valueOf(fd3.a()) : null);
            }
            jl1O = jl1Y;
        } else if (!z && c17067mL1K0.X() > j44.W()) {
            C19406qI3.a("DialogsActor", "too old", new Object[0]);
            return;
        } else {
            boolean zIsEmpty = c17067mL1K0.J().isEmpty();
            jl1O = new JL1(c17067mL1K0.R(), j44, zIsEmpty ? d25.c() : c17067mL1K0.J()).r(d25.b()).j(zIsEmpty ? d25.a() : c17067mL1K0.H()).i(zIsEmpty ? d25.d() : c17067mL1K0.c0()).t(j44.W()).z(c17067mL1K0.O()).y(c17067mL1K0.N()).p(c17067mL1K0.S()).m(c17067mL1K0.M()).u(i).q(c17067mL1K0.T()).k(c17067mL1K0.K()).x(c17067mL1K0.L()).w(c17067mL1K0.b0()).n(c17067mL1K0.d0()).o(c17067mL1K0.P());
        }
        f0(jl1O.v(list).l(exPeerType).d(), exPeerType);
        t0(null, false);
    }

    private D25 i0(C11458d25 c11458d25) {
        C14697iL2 c14697iL2;
        int i = a.c[c11458d25.s().ordinal()];
        D25 d25 = null;
        if (i != 1) {
            if (i == 2 && (c14697iL2 = (C14697iL2) this.n.E().X1().d(c11458d25.getPeerId())) != null) {
                return new D25(c14697iL2.G0(), c14697iL2.h0(), false, null);
            }
            return null;
        }
        C17637nI7 c17637nI7 = (C17637nI7) this.n.W().p0().d(c11458d25.getPeerId());
        if (c17637nI7 != null) {
            d25 = new D25(c17637nI7.r0() ? C15903kN1.d(C5721Ko.b) : c17637nI7.getName(), c17637nI7.S(), c17637nI7.r0(), c17637nI7.i0());
        }
        return d25;
    }

    private C6517Nv5 j0(C11458d25 c11458d25, boolean z) {
        C17067mL1 c17067mL1K0 = k0(c11458d25.u());
        if (c17067mL1K0 != null) {
            e0(new JL1(c17067mL1K0).n(z).d());
        }
        return C6517Nv5.l0(C14505i18.a);
    }

    private C17067mL1 k0(long j) {
        C11458d25 c11458d25R = C11458d25.r(j);
        C17067mL1 c17067mL1 = (C17067mL1) this.o.a(j);
        if (c17067mL1 != null) {
            return c17067mL1;
        }
        ExPeerType exPeerTypeM1 = this.n.E().M1(c11458d25R);
        if (exPeerTypeM1 != null) {
            int i = a.a[exPeerTypeM1.ordinal()];
            if (i == 1) {
                c17067mL1 = (C17067mL1) this.r.a(j);
            } else if (i == 2) {
                c17067mL1 = (C17067mL1) this.q.a(j);
            } else if (i == 3) {
                c17067mL1 = (C17067mL1) this.p.a(j);
            } else if (i == 4) {
                c17067mL1 = (C17067mL1) this.s.a(j);
            }
        }
        if (c17067mL1 == null) {
            C19406qI3.a("DialogsActor", "getDialog: dialogs is null, " + j + ", " + exPeerTypeM1, new Object[0]);
        }
        return c17067mL1;
    }

    private List l0() {
        return o0(this.x);
    }

    private C6517Nv5 m0() {
        return C6517Nv5.l0(l0());
    }

    private C25254zz6 n0(C11458d25 c11458d25) {
        if (c11458d25 == null) {
            return null;
        }
        C16504lO2 c16504lO2N0 = this.u.N0();
        if (c16504lO2N0 == null || c16504lO2N0.q() == null) {
            C19406qI3.b("DialogsActor", "[getShortDialogByPeer] Short Dialog storage is NULL or Empty");
            return null;
        }
        Iterator it = c16504lO2N0.q().iterator();
        while (it.hasNext()) {
            Iterator it2 = ((C15913kO2) it.next()).q().iterator();
            while (it2.hasNext()) {
                C25254zz6 c25254zz6 = (C25254zz6) it2.next();
                if (c25254zz6.w().getPeerId() == c11458d25.getPeerId() && c25254zz6.w().s() == c11458d25.s()) {
                    return c25254zz6;
                }
            }
        }
        return null;
    }

    private List o0(Map map) {
        ArrayList arrayList = new ArrayList(map.entrySet());
        Collections.sort(arrayList, new Comparator() { // from class: ir.nasim.ZP1
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                return C9704aQ1.r0((Map.Entry) obj, (Map.Entry) obj2);
            }
        });
        ArrayList arrayList2 = new ArrayList();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            arrayList2.add((Long) ((Map.Entry) it.next()).getKey());
        }
        return arrayList2;
    }

    private void p0() {
        HashMap map = new HashMap();
        this.v = map;
        map.put(OP1.ALL, this.o);
        this.v.put(OP1.PRIVATE, this.r);
        this.v.put(OP1.CHANNEL, this.p);
        this.v.put(OP1.GROUP, this.q);
        this.v.put(OP1.BOT, this.s);
    }

    private void q0() {
        this.x = new HashMap();
        C9863ah0 c9863ah0 = (C9863ah0) this.w.n(10L);
        if (c9863ah0 == null) {
            return;
        }
        try {
            this.x = (HashMap) new ObjectInputStream(new ByteArrayInputStream(c9863ah0.q())).readObject();
        } catch (IOException | ClassNotFoundException e) {
            C19406qI3.c("DialogsActor", "initPinedDialogs", e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ int r0(Map.Entry entry, Map.Entry entry2) {
        return ((Long) entry.getValue()).compareTo((Long) entry2.getValue());
    }

    private C6517Nv5 s0(C11458d25 c11458d25, Long l) {
        C17067mL1 c17067mL1K0 = k0(c11458d25.u());
        if (c17067mL1K0 != null) {
            e0(new JL1(c17067mL1K0).o(l).d());
        }
        return C6517Nv5.l0(C14505i18.a);
    }

    private void t0(OP1 op1, boolean z) {
        if (op1 != null) {
            int i = a.b[op1.ordinal()];
            if (i == 1) {
                this.n.v().L(OP1.ALL, this.o.isEmpty() ? EnumC12820fE.EMPTY : EnumC12820fE.LOADED);
                return;
            }
            if (i == 2) {
                this.n.v().L(OP1.PRIVATE, this.r.isEmpty() ? EnumC12820fE.EMPTY : EnumC12820fE.LOADED);
                return;
            }
            if (i == 3) {
                this.n.v().L(OP1.GROUP, this.q.isEmpty() ? EnumC12820fE.EMPTY : EnumC12820fE.LOADED);
                return;
            }
            if (i == 4) {
                this.n.v().L(OP1.CHANNEL, this.p.isEmpty() ? EnumC12820fE.EMPTY : EnumC12820fE.LOADED);
            } else if (i != 5) {
                return;
            }
            this.n.v().L(OP1.BOT, this.s.isEmpty() ? EnumC12820fE.EMPTY : EnumC12820fE.LOADED);
            return;
        }
        if (z) {
            this.n.v().L(OP1.ALL, this.o.isEmpty() ? EnumC12820fE.EMPTY : EnumC12820fE.LOADED);
            this.n.v().L(OP1.PRIVATE, this.r.isEmpty() ? EnumC12820fE.EMPTY : EnumC12820fE.LOADED);
            this.n.v().L(OP1.GROUP, this.q.isEmpty() ? EnumC12820fE.EMPTY : EnumC12820fE.LOADED);
            this.n.v().L(OP1.CHANNEL, this.p.isEmpty() ? EnumC12820fE.EMPTY : EnumC12820fE.LOADED);
            this.n.v().L(OP1.BOT, this.s.isEmpty() ? EnumC12820fE.EMPTY : EnumC12820fE.LOADED);
            return;
        }
        if (!this.o.isEmpty()) {
            this.n.v().L(OP1.ALL, EnumC12820fE.LOADED);
        }
        if (!this.r.isEmpty()) {
            this.n.v().L(OP1.PRIVATE, EnumC12820fE.LOADED);
        }
        if (!this.q.isEmpty()) {
            this.n.v().L(OP1.GROUP, EnumC12820fE.LOADED);
        }
        if (!this.p.isEmpty()) {
            this.n.v().L(OP1.CHANNEL, EnumC12820fE.LOADED);
        }
        if (this.s.isEmpty()) {
            return;
        }
        this.n.v().L(OP1.BOT, EnumC12820fE.LOADED);
    }

    private C6517Nv5 u0(C11458d25 c11458d25) {
        if (C8386Vt0.u8()) {
            UO1.a.b("onChatClear", "PeerId: " + c11458d25.getPeerId());
            this.y.d(c11458d25);
        } else {
            C17067mL1 c17067mL1K0 = k0(c11458d25.u());
            if (c17067mL1K0 != null) {
                e0(new JL1(c17067mL1K0.s(new J44(0L, c17067mL1K0.X(), 0L, 0, EnumC23558x74.UNKNOWN, C23345wl7.r(C5721Ko.b.getString(AbstractC12217eE5.dialog_chat_history_cleared))))).u(0).w(new ArrayList()).v(new ArrayList()).d());
            }
        }
        return C6517Nv5.l0(C14505i18.a);
    }

    private C6517Nv5 v0(C11458d25 c11458d25) {
        if (C8386Vt0.u8()) {
            UO1.a.b("onChatDeleted", String.format("PeerId: %d", Integer.valueOf(c11458d25.getPeerId())));
            this.y.n(c11458d25.u());
        } else {
            S0(c11458d25);
            t0(null, true);
        }
        return C6517Nv5.l0(C14505i18.a);
    }

    private C6517Nv5 w0(C11458d25 c11458d25, int i) {
        if (C8386Vt0.u8()) {
            this.y.p(c11458d25, i);
            UO1.a.b("onCounterChanged", String.format("PeerId: %d \n\t count: %d", Integer.valueOf(c11458d25.getPeerId()), Integer.valueOf(i)));
        } else {
            C17067mL1 c17067mL1K0 = k0(c11458d25.u());
            if (c17067mL1K0 != null && c17067mL1K0.Y() != i) {
                e0(new JL1(c17067mL1K0).u(i).d());
            }
        }
        return C6517Nv5.l0(C14505i18.a);
    }

    private C6517Nv5 x0(List list) {
        UO1.a.a("onDialogMarkAsRead");
        this.y.h(list);
        return C6517Nv5.l0(C14505i18.a);
    }

    private C6517Nv5 y0(List list) {
        UO1.a.a("onDialogMarkAsUnRead");
        this.y.G(list);
        return C6517Nv5.l0(C14505i18.a);
    }

    private C6517Nv5 z0(List list, Map map, OP1 op1, boolean z) {
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            C17676nN1 c17676nN1 = (C17676nN1) it.next();
            D25 d25 = (D25) map.get(Long.valueOf(c17676nN1.e().u()));
            if (d25 != null) {
                Iterator it2 = it;
                JL1 jl1R = new JL1(c17676nN1.e(), new J44(c17676nN1.g(), c17676nN1.i(), c17676nN1.b(), c17676nN1.h(), this.n.i0() == c17676nN1.h() ? EnumC23558x74.SENT : EnumC23558x74.UNKNOWN, c17676nN1.a()), d25.c()).j(d25.a()).i(d25.d()).t(c17676nN1.i()).u(c17676nN1.j()).l(c17676nN1.c()).p(c17676nN1.f()).v(c17676nN1.k()).w(c17676nN1.l()).r(d25.b());
                if (C8386Vt0.w7()) {
                    FD3 fd3 = (FD3) ((Map) ((JD3) C92.a(C5721Ko.b, JD3.class)).b().m().getValue()).get(Long.valueOf(c17676nN1.e().u()));
                    jl1R.o(fd3 != null ? Long.valueOf(fd3.a()) : null);
                }
                if (this.t.containsKey(Long.valueOf(c17676nN1.e().u()))) {
                    String str = (String) this.t.get(Long.valueOf(c17676nN1.e().u()));
                    if (str != null && !str.isEmpty()) {
                        jl1R.k(str).x(Long.valueOf(System.currentTimeMillis()));
                    }
                    this.t.remove(Long.valueOf(c17676nN1.e().u()));
                }
                if (c17676nN1.m()) {
                    jl1R.y(Long.valueOf(c17676nN1.b()));
                    jl1R.z(Long.valueOf(c17676nN1.b()));
                } else if (c17676nN1.n()) {
                    jl1R.z(Long.valueOf(c17676nN1.b()));
                }
                arrayList.add(jl1R.d());
                it = it2;
            }
        }
        C19406qI3.a("DialogsActor", "Apply #" + arrayList.size() + " of dialogs of " + op1, new Object[0]);
        g0(arrayList, op1, z);
        t0(op1, false);
        return C6517Nv5.l0(C14505i18.a);
    }

    @Override // ir.nasim.AbstractC17647nK
    public C6517Nv5 G(Object obj) {
        if (obj instanceof C9117Yo1) {
            C19406qI3.a("DialogsActor", "onAsk called with message: CounterChanged", new Object[0]);
            C9117Yo1 c9117Yo1 = (C9117Yo1) obj;
            return w0(c9117Yo1.b(), c9117Yo1.a());
        }
        if (obj instanceof C18418od5) {
            C19406qI3.a("DialogsActor", "onAsk called with message: PinConversation", new Object[0]);
            return Q0(((C18418od5) obj).a());
        }
        if (obj instanceof C17023mG2) {
            C19406qI3.a("DialogsActor", "onAsk called with message: GetPinDialogs", new Object[0]);
            return m0();
        }
        C6517Nv5 c6517Nv5R0 = R0(obj);
        return c6517Nv5R0 != null ? c6517Nv5R0 : super.G(obj);
    }

    @Override // ir.nasim.AbstractC6360Ng4, ir.nasim.InterfaceC3817Cm0
    /* renamed from: g */
    public void T(AbstractC18385oa2 abstractC18385oa2) {
        if (abstractC18385oa2 instanceof C22034uZ1) {
            C22034uZ1 c22034uZ1 = (C22034uZ1) abstractC18385oa2;
            O0(c22034uZ1.d(), c22034uZ1.c(), c22034uZ1.b());
        }
    }

    @Override // ir.nasim.AbstractC17647nK, ir.nasim.K6
    public void m(Object obj) throws Exception {
        if (R0(obj) == null) {
            super.m(obj);
        }
    }

    @Override // ir.nasim.K6
    public void o() {
        super.o();
        this.u = this.n.G();
        this.y = ((HS1) I22.a(C5721Ko.b, HS1.class)).q();
        this.A = ((HS1) I22.a(C5721Ko.b, HS1.class)).t0();
        this.z = ((InterfaceC12592es2) I22.a(C5721Ko.b, InterfaceC12592es2.class)).b0();
        this.o = this.u.J0();
        q0();
        this.p = this.u.D0();
        this.q = this.u.M0();
        this.r = this.u.S0();
        this.s = this.u.C0();
        b0("draft_change");
        p0();
    }
}
