package ir.nasim;

import ai.bale.proto.Balebank$RequestOpenGoldGiftPacket;
import ai.bale.proto.Balebank$ResponseOpenGoldGiftPacket;
import ai.bale.proto.Giftpacket$RequestOpenGiftPacket;
import ai.bale.proto.Giftpacket$ResponseOpenGiftPacket;
import ai.bale.proto.MessagingOuterClass$RequestClearChat;
import ai.bale.proto.MessagingStruct$DocumentEx;
import ai.bale.proto.MessagingStruct$DocumentExVoice;
import ai.bale.proto.MessagingStruct$DocumentMessage;
import ai.bale.proto.MessagingStruct$HistoryMessageIdentifier;
import ai.bale.proto.MessagingStruct$MessageId;
import ai.bale.proto.MessagingStruct$TextMessage;
import ai.bale.proto.Misc$ResponseSeq;
import ai.bale.proto.Misc$ResponseVoid;
import ai.bale.proto.PeersStruct$OutExPeer;
import ai.bale.proto.PeersStruct$OutPeer;
import ai.bale.proto.Turing$RequestGetTranscript;
import ai.bale.proto.Turing$RequestSendEvent;
import ai.bale.proto.Turing$ResponseGetTranscript;
import ai.bale.proto.TuringStruct$TranscriptReactionEvent;
import android.util.Pair;
import com.google.protobuf.Int32Value;
import com.google.protobuf.StringValue;
import ir.nasim.C23548x64;
import ir.nasim.C3593Bn1;
import ir.nasim.C6434No6;
import ir.nasim.UO1;
import ir.nasim.YS1;
import ir.nasim.core.modules.profile.entity.ExPeerType;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: classes5.dex */
public class E84 extends AbstractC21707u0 implements InterfaceC3817Cm0 {
    public static String C = "single_comment_list_engine";
    private final Object A;
    private C9057Yh4 B;
    private final DB3 b;
    private DB3 c;
    private DB3 d;
    private DB3 e;
    private DB3 f;
    private C9731aT1 g;
    private C9528a7 h;
    private YS1.b i;
    private C9528a7 j;
    private C9528a7 k;
    private C18839pL0 l;
    private C16342l66 m;
    private final HashMap n;
    private final HashMap o;
    private C3593Bn1 p;
    private C11458d25 q;
    private final VL3 r;
    private final HashMap s;
    private DB3 t;
    C9528a7 u;
    private C16504lO2 v;
    private C23667xJ2 w;
    private C9528a7 x;
    private C7172Qo6 y;
    private final Object z;

    public E84(C9057Yh4 c9057Yh4) {
        super(c9057Yh4);
        this.n = new HashMap();
        this.o = new HashMap();
        this.p = null;
        this.q = null;
        this.s = new HashMap();
        this.t = null;
        this.u = null;
        this.z = new Object();
        this.A = new Object();
        this.B = c9057Yh4;
        this.r = KN6.j("chat_states", C5246In1.p, C4778Gn1.v, C4778Gn1.w, true);
        this.b = KN6.l("dialogs_1", C17067mL1.H);
        a1();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ C6517Nv5 A1(long j, long j2, String str, C17557nA c17557nA) {
        return q(new C15979kV5(new C4392Ey(c17557nA, j, j2), str));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ C14505i18 B1(Q06 q06) {
        return C14505i18.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ C6517Nv5 C1(Misc$ResponseVoid misc$ResponseVoid) {
        return C6517Nv5.l0(C14505i18.a);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ C6517Nv5 D1(J44 j44, AbstractC24063xz abstractC24063xz, C17557nA c17557nA) {
        return r(new C10356bW5(c17557nA, j44.i(), abstractC24063xz), 0);
    }

    private String E0(long j) {
        return "chat_" + j;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ C6517Nv5 E1(C11458d25 c11458d25, J44 j44, AbstractC24063xz abstractC24063xz, int i, C23490x06 c23490x06) {
        return this.B.V().S(c23490x06.w(), c23490x06.y(), new DE7(c11458d25, j44.i(), abstractC24063xz, Long.valueOf(j44.h()), this.B.w().p()), i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ C6517Nv5 F1(Turing$ResponseGetTranscript turing$ResponseGetTranscript) {
        return C6517Nv5.l0(new Pair(turing$ResponseGetTranscript.hasDownloadSource() ? turing$ResponseGetTranscript.getDownloadSource().getDocumentMessage() : null, Boolean.valueOf(turing$ResponseGetTranscript.hasMustWait() && turing$ResponseGetTranscript.getMustWait())));
    }

    private void M2(C11458d25 c11458d25, String str) {
        this.B.G().K0().u(c11458d25, AbstractC20507s76.p(), str);
    }

    private C6517Nv5 O1() {
        if (C8386Vt0.w7()) {
            ((JD3) C92.a(C5721Ko.b, JD3.class)).b().k();
        }
        return C6517Nv5.l0(C14505i18.a);
    }

    private void X0() {
        synchronized (this.z) {
            if (this.v == null) {
                C9863ah0 c9863ah0 = (C9863ah0) this.B.T().C().n(15L);
                if (c9863ah0 != null) {
                    try {
                        this.v = new C16504lO2(c9863ah0.q());
                    } catch (IOException e) {
                        C19406qI3.c("MessagesModule", "initActiveDialogStorage", e);
                    }
                }
                if (this.v == null) {
                    this.v = new C16504lO2();
                }
            }
        }
    }

    private void Z0() {
        synchronized (this.A) {
            if (this.w == null) {
                C9863ah0 c9863ah0 = (C9863ah0) this.B.T().C().n(7L);
                if (c9863ah0 != null) {
                    try {
                        this.w = new C23667xJ2(c9863ah0.q());
                    } catch (IOException e) {
                        C19406qI3.c("MessagesModule", "initDialogsCounterStorage", e);
                    }
                }
                if (this.w == null) {
                    this.w = new C23667xJ2();
                }
            }
        }
    }

    private void a1() {
        InterfaceC17311ml0 interfaceC17311ml0 = C17067mL1.H;
        this.c = KN6.l("dialogs_channel_1", interfaceC17311ml0);
        this.e = KN6.l("dialogs_group_1", interfaceC17311ml0);
        this.d = KN6.l("dialogs_private_1", interfaceC17311ml0);
        this.f = KN6.l("dialogs_bot_1", interfaceC17311ml0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b1(C11458d25 c11458d25, C14505i18 c14505i18, Exception exc) {
        this.B.G().r0(c11458d25);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void c1(Exception exc) {
        if (exc != null) {
            C19406qI3.c("MessagesModule", "clearAndDeleteChatLocally", exc);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ C6517Nv5 d1(C11458d25 c11458d25, Misc$ResponseSeq misc$ResponseSeq) {
        return this.B.V().S(misc$ResponseSeq.getSeq(), misc$ResponseSeq.getState().a0(), new YC7(c11458d25), 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ C6517Nv5 e1(PeersStruct$OutPeer peersStruct$OutPeer) {
        return x(new C22871vx5("/bale.messaging.v2.Messaging/ClearChat", MessagingOuterClass$RequestClearChat.newBuilder().A(peersStruct$OutPeer).a(), Misc$ResponseSeq.getDefaultInstance()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void f1(List list) {
        C15225jD4.b().c(C15225jD4.j, list);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ K6 g1(InterfaceC25133zn1 interfaceC25133zn1, C11458d25 c11458d25) {
        return interfaceC25133zn1.a(this.B, c11458d25, F0(), true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ K6 h1(InterfaceC25133zn1 interfaceC25133zn1, C11458d25 c11458d25) {
        C9057Yh4 c9057Yh4 = this.B;
        return interfaceC25133zn1.a(c9057Yh4, c11458d25, c9057Yh4.G().H0(c11458d25), false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ C6517Nv5 i1(C14505i18 c14505i18) {
        return h2();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ C6517Nv5 j1(C14505i18 c14505i18) {
        return O1();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void k1(Exception exc) {
        C19406qI3.b("NewSequenceActor", "failed new handleDialogs : " + exc.getMessage());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ C6517Nv5 l1(C14505i18 c14505i18) {
        return i2();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ C6517Nv5 m1(C14505i18 c14505i18) {
        return O1();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ C6517Nv5 n1(List list, C14505i18 c14505i18) {
        this.h.d(new YS1.f(list));
        return C6517Nv5.l0(C14505i18.a);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ C6517Nv5 o1(final List list) {
        return this.m.l().A(new InterfaceC17569nB2() { // from class: ir.nasim.t84
            @Override // ir.nasim.InterfaceC17569nB2
            public final Object apply(Object obj) {
                return this.a.l1((C14505i18) obj);
            }
        }).A(new InterfaceC17569nB2() { // from class: ir.nasim.v84
            @Override // ir.nasim.InterfaceC17569nB2
            public final Object apply(Object obj) {
                return this.a.m1((C14505i18) obj);
            }
        }).H(new InterfaceC17569nB2() { // from class: ir.nasim.w84
            @Override // ir.nasim.InterfaceC17569nB2
            public final Object apply(Object obj) {
                return this.a.n1(list, (C14505i18) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void p1(Exception exc) {
        C19406qI3.a("NewSequenceActor", "failed handleDialogs : " + exc.getMessage(), new Object[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void q1(OP1 op1) {
        this.h.d(new YS1.d(op1, 20));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ C6517Nv5 s1(final Giftpacket$ResponseOpenGiftPacket giftpacket$ResponseOpenGiftPacket) {
        return !giftpacket$ResponseOpenGiftPacket.getUserOutPeersList().isEmpty() ? this.B.V().s0(C18732p92.J(giftpacket$ResponseOpenGiftPacket.getUserOutPeersList()), new ArrayList()).h0(new InterfaceC17569nB2() { // from class: ir.nasim.j84
            @Override // ir.nasim.InterfaceC17569nB2
            public final Object apply(Object obj) {
                return E84.r1(giftpacket$ResponseOpenGiftPacket, (C14505i18) obj);
            }
        }) : C6517Nv5.l0(giftpacket$ResponseOpenGiftPacket);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ C6517Nv5 t1(Long l, Long l2, EnumC22278uy enumC22278uy, String str, Integer num, C17557nA c17557nA) {
        MessagingStruct$HistoryMessageIdentifier messagingStruct$HistoryMessageIdentifier = (MessagingStruct$HistoryMessageIdentifier) MessagingStruct$HistoryMessageIdentifier.newBuilder().C(C18732p92.a.y1(c17557nA)).D(l.longValue()).A(l2.longValue()).a();
        LI2 li2J = LI2.GiftReceiversOrderType_UNKNOWN;
        if (enumC22278uy != null && enumC22278uy != EnumC22278uy.UNSUPPORTED_VALUE) {
            li2J = LI2.j(enumC22278uy.j());
        }
        Giftpacket$RequestOpenGiftPacket.a aVarA = Giftpacket$RequestOpenGiftPacket.newBuilder().A(messagingStruct$HistoryMessageIdentifier);
        if (str == null) {
            str = "";
        }
        return x(new C22871vx5("/bale.giftpacket.v1.GiftPacket/OpenGiftPacket", (Giftpacket$RequestOpenGiftPacket) aVarA.D(str).C(Int32Value.of(num != null ? num.intValue() : 0)).B(li2J).a(), Giftpacket$ResponseOpenGiftPacket.getDefaultInstance())).H(new InterfaceC17569nB2() { // from class: ir.nasim.s84
            @Override // ir.nasim.InterfaceC17569nB2
            public final Object apply(Object obj) {
                return this.a.s1((Giftpacket$ResponseOpenGiftPacket) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void u1(C7234Qv5 c7234Qv5) {
        UO1.a.a("refreshAllNewDialogsAndRelations");
        if (((HS1) I22.a(C5721Ko.b, HS1.class)).P0().a()) {
            c7234Qv5.b(C14505i18.a);
        } else {
            c7234Qv5.a(new Exception("refreshAllNewDialogsAndRelations failed!"));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ K6 v1() {
        return new YS1(this.B);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ K6 w1() {
        return new C5561Jw1(this.B);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ K6 x1() {
        return new C6434No6(this.B);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ K6 y1() {
        return new C23548x64(this.B);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ K6 z1() {
        return new C18248oL0(this.B);
    }

    public Map A0() {
        return this.n;
    }

    public void A2(C11458d25 c11458d25, String str, ArrayList arrayList, boolean z, C7880To7 c7880To7) {
        B2(c11458d25, str, arrayList, z, null, null, c7880To7);
    }

    public C5246In1 B0(C11458d25 c11458d25) {
        return (C5246In1) this.r.n(c11458d25.u());
    }

    public void B2(C11458d25 c11458d25, String str, ArrayList arrayList, boolean z, Long l, Long l2, C7880To7 c7880To7) {
        this.B.U().C(c11458d25);
        this.x.d(new C6434No6.H(c11458d25, C14225hZ6.a(str), arrayList, z, l, l2, c7880To7));
    }

    public DB3 C0() {
        return this.f;
    }

    public void C2(C11458d25 c11458d25, String str, int i, int i2, C22694vg2 c22694vg2, String str2, String str3, Long l, Long l2, C7880To7 c7880To7) {
        C19406qI3.a("FiSeCoFl", "sendPhoto() message", new Object[0]);
        InterfaceC3346Am2 interfaceC3346Am2R = KN6.r(str2);
        this.x.d(new C6434No6.z(c11458d25, c22694vg2, str2, str, C14225hZ6.a(str3), interfaceC3346Am2R.f(), i, i2, l, l2, c7880To7));
    }

    public DB3 D0() {
        return this.c;
    }

    public void D2(C11458d25 c11458d25, Long l, String str, List list, Boolean bool, EnumC9567aB enumC9567aB, Long l2, Long l3) {
        this.x.d(new C6434No6.A(c11458d25, l, str, list, bool, enumC9567aB, l2, l3));
    }

    public void E2(C11458d25 c11458d25, AbstractC4970Hi4 abstractC4970Hi4, String str, int i, int i2, C22694vg2 c22694vg2, String str2, String str3, AbstractC13130fi4 abstractC13130fi4, String str4) {
        InterfaceC3346Am2 interfaceC3346Am2R = KN6.r(str2);
        this.x.d(new C6434No6.B(c11458d25, abstractC4970Hi4, c22694vg2, str2, str, C14225hZ6.a(str3), interfaceC3346Am2R.f(), i, i2, abstractC13130fi4, str4));
    }

    public DB3 F0() {
        return this.t;
    }

    public void F2(C11458d25 c11458d25, String str, Long l, Long l2, int i, int i2, int i3, C22694vg2 c22694vg2, C7880To7 c7880To7) {
        C19406qI3.a("FiSeCoFl", "sendRemotePhoto() message", new Object[0]);
        this.x.d(new C6434No6.C(c11458d25, C14225hZ6.a(str), i, l, l2, i2, i3, c22694vg2, c7880To7));
    }

    public C3593Bn1 G0(final C11458d25 c11458d25) {
        C3593Bn1 c3593Bn1 = this.p;
        if (c3593Bn1 != null && c11458d25 == this.q) {
            return c3593Bn1;
        }
        final InterfaceC25133zn1 interfaceC25133zn1Z0 = ((W6) C92.a(C5721Ko.b, W6.class)).Z0();
        this.u = C12736f7.n().e("history/comment", new V6() { // from class: ir.nasim.d84
            @Override // ir.nasim.V6
            public final K6 create() {
                return this.a.g1(interfaceC25133zn1Z0, c11458d25);
            }
        }, true);
        C3593Bn1 c3593Bn12 = new C3593Bn1(this.u);
        this.p = c3593Bn12;
        return c3593Bn12;
    }

    public String G1(Long l) {
        return this.B.S().getString("drafts_" + l, "");
    }

    public void G2(C11458d25 c11458d25, C23698xM6 c23698xM6, Long l, Long l2, C7880To7 c7880To7) {
        this.x.d(new C6434No6.D(c11458d25, c23698xM6, l, l2, c7880To7));
    }

    public DB3 H0(C11458d25 c11458d25) {
        DB3 db3;
        synchronized (this.s) {
            try {
                if (!this.s.containsKey(c11458d25)) {
                    this.s.put(c11458d25, KN6.l(E0(c11458d25.u()), J44.x));
                }
                db3 = (DB3) this.s.get(c11458d25);
            } catch (Throwable th) {
                throw th;
            }
        }
        return db3;
    }

    public C6517Nv5 H1(C11458d25 c11458d25, boolean z) {
        return Q0(c11458d25, z).n();
    }

    public void H2(C11458d25 c11458d25, String str, C16526lQ6 c16526lQ6) {
        this.x.d(new C6434No6.E(c11458d25, str, c16526lQ6));
    }

    public VL3 I0() {
        return this.r;
    }

    public C6517Nv5 I1(C11458d25 c11458d25, long j, boolean z) {
        return Q0(c11458d25, z).o(j);
    }

    public void I2(C11458d25 c11458d25, String str, Long l) {
        this.x.d(new C6434No6.F(c11458d25, str, l));
    }

    public DB3 J0() {
        return this.b;
    }

    public C6517Nv5 J1(C11458d25 c11458d25, boolean z) {
        return Q0(c11458d25, z).p();
    }

    public void J2(C11458d25 c11458d25, String str, int i, int i2, int i3, C22694vg2 c22694vg2, String str2, String str3, Long l, Long l2, boolean z, C7880To7 c7880To7) {
        C19406qI3.a("FiSeCoFl", "sendVideo() message", new Object[0]);
        InterfaceC3346Am2 interfaceC3346Am2R = KN6.r(str2);
        this.x.d(new C6434No6.I(c11458d25, str, i, i2, i3, c22694vg2, str2, C14225hZ6.a(str3), interfaceC3346Am2R.f(), l, l2, z, c7880To7));
    }

    public C9731aT1 K0() {
        return this.g;
    }

    public C6517Nv5 K1(C11458d25 c11458d25, J44 j44, boolean z) {
        return Q0(c11458d25, z).q(j44);
    }

    public void K2(C11458d25 c11458d25, String str, int i, String str2, Long l, Long l2, String str3, C7880To7 c7880To7) {
        C19406qI3.a("FiSeCoFl", "sendVoice(duration: " + i + ") message", new Object[0]);
        this.x.d(new C6434No6.J(c11458d25, str2, str, i, l, l2, str3, c7880To7));
    }

    public C23667xJ2 L0() {
        if (this.w == null) {
            Z0();
        }
        return this.w;
    }

    public void L1(final OP1 op1) {
        AbstractC20507s76.k(new Runnable() { // from class: ir.nasim.A84
            @Override // java.lang.Runnable
            public final void run() {
                this.a.q1(op1);
            }
        });
    }

    public C6517Nv5 L2(C11458d25 c11458d25, ExPeerType exPeerType, long j, long j2, int i) {
        return x(new C22871vx5("/bale.turing.v1.AI/SendEvent", (Turing$RequestSendEvent) Turing$RequestSendEvent.newBuilder().A((TuringStruct$TranscriptReactionEvent) TuringStruct$TranscriptReactionEvent.newBuilder().A((PeersStruct$OutExPeer) PeersStruct$OutExPeer.newBuilder().B(c11458d25.getPeerId()).C(exPeerType.toProtoApi()).a()).D(j).C(j2).B(i).a()).a(), Misc$ResponseVoid.getDefaultInstance())).H(new InterfaceC17569nB2() { // from class: ir.nasim.u84
            @Override // ir.nasim.InterfaceC17569nB2
            public final Object apply(Object obj) {
                return E84.C1((Misc$ResponseVoid) obj);
            }
        });
    }

    public DB3 M0() {
        return this.e;
    }

    public C6517Nv5 M1(List list, boolean z) {
        return this.i.j(list, z);
    }

    public C16504lO2 N0() {
        if (this.v == null) {
            X0();
        }
        return this.v;
    }

    public void N1(C11458d25 c11458d25, ArrayList arrayList, Boolean bool) {
        Q0(c11458d25, bool.booleanValue()).r(arrayList);
    }

    public C6517Nv5 N2(final C11458d25 c11458d25, String str, final J44 j44) {
        C6035Lx c6035Lx;
        this.B.U().C(c11458d25);
        AbstractC17457n0 abstractC17457n0F = j44.F();
        String strTrim = str.trim();
        final AbstractC24063xz zc = null;
        if (abstractC17457n0F instanceof C24967zW1) {
            C24967zW1 c24967zW1 = (C24967zW1) abstractC17457n0F;
            if (c24967zW1 instanceof C13388g85) {
                C13388g85 c13388g85 = (C13388g85) c24967zW1;
                C5100Hx c5100Hx = new C5100Hx(c13388g85.E(), c13388g85.D());
                C11920dm2 c11920dm2 = (C11920dm2) c24967zW1.z();
                c6035Lx = new C6035Lx(c11920dm2.b().getFileId(), c11920dm2.b().getAccessHash(), c11920dm2.f(), c11920dm2.a(), c24967zW1.x(), null, c5100Hx, new ZC(strTrim, c24967zW1.t().t(), c24967zW1.t().w(), null), "checksum", "algorithm", c11920dm2.b().getFileStorageVersion(), null, c24967zW1.w());
            } else if (c24967zW1 instanceof GS7) {
                GS7 gs7 = (GS7) c24967zW1;
                C5568Jx c5568Jx = new C5568Jx(gs7.I(), gs7.H(), gs7.G());
                C11920dm2 c11920dm22 = (C11920dm2) c24967zW1.z();
                c6035Lx = new C6035Lx(c11920dm22.b().getFileId(), c11920dm22.b().getAccessHash(), c11920dm22.f(), c11920dm22.a(), c24967zW1.x(), null, c5568Jx, new ZC(strTrim, c24967zW1.t().t(), c24967zW1.t().w(), null), "checksum", "algorithm", c11920dm22.b().getFileStorageVersion(), null, c24967zW1.w());
            } else if (c24967zW1 instanceof XG2) {
                XG2 xg2 = (XG2) c24967zW1;
                C4866Gx c4866Gx = new C4866Gx(xg2.G(), xg2.F(), xg2.E());
                C11920dm2 c11920dm23 = (C11920dm2) c24967zW1.z();
                c6035Lx = new C6035Lx(c11920dm23.b().getFileId(), c11920dm23.b().getAccessHash(), c11920dm23.f(), c11920dm23.a(), c24967zW1.x(), null, c4866Gx, new ZC(strTrim, c24967zW1.t().t(), c24967zW1.t().w(), null), "checksum", "algorithm", c11920dm23.b().getFileStorageVersion(), null, c24967zW1.w());
            } else {
                C11920dm2 c11920dm24 = (C11920dm2) c24967zW1.z();
                c6035Lx = new C6035Lx(c11920dm24.b().getFileId(), c11920dm24.b().getAccessHash(), c11920dm24.f(), c11920dm24.a(), c24967zW1.x(), null, null, new ZC(strTrim, c24967zW1.t().t(), c24967zW1.t().w(), null), "checksum", "algorithm", c11920dm24.b().getFileStorageVersion(), null, c24967zW1.w());
            }
            zc = c6035Lx;
        } else if (abstractC17457n0F instanceof C23345wl7) {
            C23345wl7 c23345wl7 = (C23345wl7) abstractC17457n0F;
            zc = new ZC(strTrim, c23345wl7.t(), c23345wl7.w(), c23345wl7.u());
        }
        final int iV1 = this.B.E().V1(c11458d25.getPeerId());
        return this.B.o(c11458d25).H(new InterfaceC17569nB2() { // from class: ir.nasim.h84
            @Override // ir.nasim.InterfaceC17569nB2
            public final Object apply(Object obj) {
                return this.a.D1(j44, zc, (C17557nA) obj);
            }
        }).H(new InterfaceC17569nB2() { // from class: ir.nasim.i84
            @Override // ir.nasim.InterfaceC17569nB2
            public final Object apply(Object obj) {
                return this.a.E1(c11458d25, j44, zc, iV1, (C23490x06) obj);
            }
        });
    }

    public C9528a7 O0(final C11458d25 c11458d25) {
        C9528a7 c9528a7;
        synchronized (this.n) {
            try {
                if (!this.n.containsKey(c11458d25)) {
                    final InterfaceC25133zn1 interfaceC25133zn1Z0 = ((W6) C92.a(C5721Ko.b, W6.class)).Z0();
                    this.n.put(c11458d25, C12736f7.n().e("history/" + c11458d25, new V6() { // from class: ir.nasim.b84
                        @Override // ir.nasim.V6
                        public final K6 create() {
                            return this.a.h1(interfaceC25133zn1Z0, c11458d25);
                        }
                    }, true));
                }
                c9528a7 = (C9528a7) this.n.get(c11458d25);
            } catch (Throwable th) {
                throw th;
            }
        }
        return c9528a7;
    }

    public C6517Nv5 O2(C11458d25 c11458d25, ExPeerType exPeerType, Long l, Long l2, Long l3, Long l4, J08 j08) {
        return x(new C22871vx5("/bale.turing.v1.AI/GetTranscript", (Turing$RequestGetTranscript) Turing$RequestGetTranscript.newBuilder().B((PeersStruct$OutExPeer) PeersStruct$OutExPeer.newBuilder().B(c11458d25.getPeerId()).C(exPeerType.toProtoApi()).a()).A((MessagingStruct$MessageId) MessagingStruct$MessageId.newBuilder().A(l2.longValue()).B(l.longValue()).a()).C((MessagingStruct$DocumentMessage) MessagingStruct$DocumentMessage.newBuilder().A(l4.longValue()).F(l3.longValue()).G((int) j08.I()).I(j08.x() != null ? j08.x() : "audio/ogg; codecs=opus").B((StringValue) StringValue.newBuilder().A("algorithm").a()).C(j08.l() != null ? (MessagingStruct$TextMessage) MessagingStruct$TextMessage.newBuilder().B(j08.l().v()).A(j08.l().t()).a() : MessagingStruct$TextMessage.getDefaultInstance()).D((StringValue) StringValue.newBuilder().A("checksum").a()).J(j08.y()).E((MessagingStruct$DocumentEx) MessagingStruct$DocumentEx.newBuilder().A((MessagingStruct$DocumentExVoice) MessagingStruct$DocumentExVoice.newBuilder().A(j08.G()).a()).a()).H((Int32Value) Int32Value.newBuilder().A(1).a()).a()).a(), Turing$ResponseGetTranscript.getDefaultInstance())).H(new InterfaceC17569nB2() { // from class: ir.nasim.x84
            @Override // ir.nasim.InterfaceC17569nB2
            public final Object apply(Object obj) {
                return E84.F1((Turing$ResponseGetTranscript) obj);
            }
        });
    }

    public C3593Bn1 P0(C11458d25 c11458d25) {
        C3593Bn1 c3593Bn1;
        synchronized (this.o) {
            try {
                if (!this.o.containsKey(c11458d25)) {
                    this.o.put(c11458d25, new C3593Bn1(O0(c11458d25)));
                }
                c3593Bn1 = (C3593Bn1) this.o.get(c11458d25);
            } catch (Throwable th) {
                throw th;
            }
        }
        return c3593Bn1;
    }

    public void P1(C11458d25 c11458d25) {
        this.m.n(c11458d25);
    }

    public C3593Bn1 Q0(C11458d25 c11458d25, boolean z) {
        return z ? G0(c11458d25) : P0(c11458d25);
    }

    public void Q1(C11458d25 c11458d25) {
        K0().m(c11458d25);
    }

    public C9528a7 R0() {
        return this.j;
    }

    public void R1(C11458d25 c11458d25) {
        K0().n(c11458d25);
    }

    public DB3 S0() {
        return this.d;
    }

    public void S1() {
        this.x.d(new C6434No6.C6442h(null));
    }

    public C16342l66 T0() {
        return this.m;
    }

    public void T1(C11458d25 c11458d25) {
        K0().B(c11458d25);
    }

    public C9528a7 U0() {
        return this.x;
    }

    public void U1(C11458d25 c11458d25, Long l) {
        K0().C(c11458d25, l.longValue());
    }

    public C6517Nv5 V0(C11458d25 c11458d25, long j, int i) {
        return H0(c11458d25).x(EnumC15168j74.f.getValue(), j, EnumC24659yz5.b, i, false);
    }

    public C6517Nv5 V1(C11458d25 c11458d25, long j, boolean z) {
        return Q0(c11458d25, z).s(j);
    }

    public C6517Nv5 W0() {
        return C8386Vt0.u8() ? this.m.l().A(new InterfaceC17569nB2() { // from class: ir.nasim.k84
            @Override // ir.nasim.InterfaceC17569nB2
            public final Object apply(Object obj) {
                return this.a.i1((C14505i18) obj);
            }
        }).A(new InterfaceC17569nB2() { // from class: ir.nasim.l84
            @Override // ir.nasim.InterfaceC17569nB2
            public final Object apply(Object obj) {
                return this.a.j1((C14505i18) obj);
            }
        }).E(new InterfaceC24449ye1() { // from class: ir.nasim.m84
            @Override // ir.nasim.InterfaceC24449ye1
            public final void apply(Object obj) {
                E84.k1((Exception) obj);
            }
        }) : this.g.k().H(new InterfaceC17569nB2() { // from class: ir.nasim.n84
            @Override // ir.nasim.InterfaceC17569nB2
            public final Object apply(Object obj) {
                return this.a.o1((List) obj);
            }
        }).E(new InterfaceC24449ye1() { // from class: ir.nasim.o84
            @Override // ir.nasim.InterfaceC24449ye1
            public final void apply(Object obj) {
                E84.p1((Exception) obj);
            }
        });
    }

    public C6517Nv5 W1(C11458d25 c11458d25, Long l, Long l2, J44 j44, C10508bj5 c10508bj5) {
        return Q0(c11458d25, true).t(l.longValue(), l2.longValue(), j44, c10508bj5);
    }

    public C6517Nv5 X1(final String str, final Integer num, final EnumC22278uy enumC22278uy, C11458d25 c11458d25, final Long l, final Long l2) {
        return this.B.o(c11458d25).H(new InterfaceC17569nB2() { // from class: ir.nasim.p84
            @Override // ir.nasim.InterfaceC17569nB2
            public final Object apply(Object obj) {
                return this.a.t1(l, l2, enumC22278uy, str, num, (C17557nA) obj);
            }
        });
    }

    public void Y0(OP1 op1) {
        this.h.d(new YS1.c(op1));
    }

    public C6517Nv5 Y1(int i) {
        return x(new C22871vx5("/bale.balebank.v1.GoldGiftPacket/OpenGoldGiftPacket", Balebank$RequestOpenGoldGiftPacket.newBuilder().A(i).a(), Balebank$ResponseOpenGoldGiftPacket.getDefaultInstance()));
    }

    public C6517Nv5 Z1(C11458d25 c11458d25, long j, long j2, int i) {
        return P0(c11458d25).w(c11458d25, j, j2, i);
    }

    public C6517Nv5 a2(C11458d25 c11458d25, long j, long j2, InterfaceC21893uJ4 interfaceC21893uJ4, boolean z) {
        return Q0(c11458d25, z).x(c11458d25, j, j2, 0, interfaceC21893uJ4);
    }

    public C6517Nv5 b2(C11458d25 c11458d25, long j, long j2, boolean z) {
        return Q0(c11458d25, z).v(c11458d25, j, j2);
    }

    public C6517Nv5 c2(C11458d25 c11458d25, InterfaceC21893uJ4 interfaceC21893uJ4, boolean z) {
        return Q0(c11458d25, z).y(c11458d25, interfaceC21893uJ4);
    }

    public C6517Nv5 d2(C11458d25 c11458d25, boolean z) {
        return Q0(c11458d25, z).u(c11458d25);
    }

    public void e2(C11458d25 c11458d25, long j, int i) {
        T0().r(c11458d25, j, i);
    }

    public void f0(long j) {
        this.x.d(new C6434No6.C6440f(j));
    }

    public void f2(C11458d25 c11458d25, Q64 q64, ExPeerType exPeerType) {
        T0().C(c11458d25, q64, exPeerType);
    }

    @Override // ir.nasim.InterfaceC3817Cm0
    /* renamed from: g */
    public void T(AbstractC18385oa2 abstractC18385oa2) {
        if (abstractC18385oa2 instanceof C18074o25) {
            O0(((C18074o25) abstractC18385oa2).c());
        }
    }

    public C6517Nv5 g0(C11458d25 c11458d25, long j, long j2, int i, boolean z) {
        return z ? C6517Nv5.l0(C14505i18.a) : P0(c11458d25).j(c11458d25, j, j2, i);
    }

    public void g2(C11458d25 c11458d25, Q64 q64, ExPeerType exPeerType) {
        T0().D(c11458d25, q64, exPeerType);
    }

    public void h0(long j, boolean z) {
        P0(C11458d25.r(270066638L)).k(j, z);
    }

    public C6517Nv5 h2() {
        return new C6517Nv5(new InterfaceC6990Pv5() { // from class: ir.nasim.e84
            @Override // ir.nasim.InterfaceC6990Pv5
            public final void a(C7234Qv5 c7234Qv5) {
                E84.u1(c7234Qv5);
            }
        });
    }

    public void i0(C11458d25 c11458d25, boolean z, boolean z2) {
        C9528a7 c9528a7;
        if (!z2 || (c9528a7 = this.u) == null) {
            O0(c11458d25).d(new C3593Bn1.c(z));
        } else {
            c9528a7.d(new C3593Bn1.c(z));
        }
    }

    public C6517Nv5 i2() {
        return this.i.k();
    }

    public C6517Nv5 j0(final C11458d25 c11458d25) {
        return c11458d25 == null ? C6517Nv5.F(new Exception("Peer is NULL")) : this.B.V().Z().k(new YC7(c11458d25)).z(new InterfaceC3273Ae1() { // from class: ir.nasim.f84
            @Override // ir.nasim.InterfaceC3273Ae1
            public final void apply(Object obj, Object obj2) {
                this.a.b1(c11458d25, (C14505i18) obj, (Exception) obj2);
            }
        }).E(new InterfaceC24449ye1() { // from class: ir.nasim.g84
            @Override // ir.nasim.InterfaceC24449ye1
            public final void apply(Object obj) {
                E84.c1((Exception) obj);
            }
        });
    }

    public void j2(C11458d25 c11458d25) {
        O0(c11458d25).d(new C3593Bn1.j(c11458d25));
    }

    public C6517Nv5 k0(final C11458d25 c11458d25) {
        return this.B.q(c11458d25).H(new InterfaceC17569nB2() { // from class: ir.nasim.y84
            @Override // ir.nasim.InterfaceC17569nB2
            public final Object apply(Object obj) {
                return this.a.e1((PeersStruct$OutPeer) obj);
            }
        }).H(new InterfaceC17569nB2() { // from class: ir.nasim.z84
            @Override // ir.nasim.InterfaceC17569nB2
            public final Object apply(Object obj) {
                return this.a.d1(c11458d25, (Misc$ResponseSeq) obj);
            }
        });
    }

    public void k2() {
        this.m = new C16342l66(this.B);
        this.g = new C9731aT1(this.B);
        C9528a7 c9528a7D = C12736f7.n().d("actor/dialogs/history", new V6() { // from class: ir.nasim.B84
            @Override // ir.nasim.V6
            public final K6 create() {
                return this.a.v1();
            }
        });
        this.h = c9528a7D;
        this.i = new YS1.b(c9528a7D);
        this.j = C12736f7.n().c(C4614Fw5.d(new V6() { // from class: ir.nasim.C84
            @Override // ir.nasim.V6
            public final K6 create() {
                return this.a.w1();
            }
        }).a("D_heavy"), "actor/plain/read");
        C9528a7 c9528a7E = C12736f7.n().e("actor/sender/small", new V6() { // from class: ir.nasim.D84
            @Override // ir.nasim.V6
            public final K6 create() {
                return this.a.x1();
            }
        }, true);
        this.x = c9528a7E;
        this.y = new C7172Qo6(c9528a7E);
        this.k = C12736f7.n().g("actor/deletions", C4614Fw5.d(new V6() { // from class: ir.nasim.Z74
            @Override // ir.nasim.V6
            public final K6 create() {
                return this.a.y1();
            }
        }), true);
        this.l = new C18839pL0(C12736f7.n().c(C4614Fw5.d(new V6() { // from class: ir.nasim.a84
            @Override // ir.nasim.V6
            public final K6 create() {
                return this.a.z1();
            }
        }), "actor/deletionsChat"));
        this.B.a().h(this, "peer_chat_opened");
    }

    public void l0() {
        DB3 db3 = this.t;
        if (db3 != null) {
            db3.l(false);
        }
        C9528a7 c9528a7 = this.u;
        if (c9528a7 != null) {
            c9528a7.d(C12485eh5.a);
        }
        if (this.p == null) {
            return;
        }
        this.t = null;
        this.u = null;
        this.p = null;
    }

    public void l2(C11458d25 c11458d25, String str) {
        String str2 = "drafts_" + c11458d25.u();
        if (this.B.S().getString(str2, "").equals(str)) {
            return;
        }
        this.B.S().f(str2, str);
        M2(c11458d25, str);
    }

    public void m0(C11458d25 c11458d25) {
        P0(c11458d25).l();
    }

    public void m2(Long l, C11458d25 c11458d25, Long l2, Long l3, List list) {
        C19406qI3.a("FiSeCoFl", "sendAlbum() message", new Object[0]);
        this.x.d(new C6434No6.m(l, c11458d25, l2, l3, list));
    }

    public void n0(final List list) {
        C19406qI3.a("SyncLog", "Going to clearMessagesForPeers with count: " + list.size(), new Object[0]);
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            arrayList.add("ls_" + E0(((Long) it.next()).longValue()));
        }
        KN6.a(arrayList);
        Iterator it2 = list.iterator();
        while (it2.hasNext()) {
            o0(C11458d25.r(((Long) it2.next()).longValue()), true);
        }
        AbstractC20507s76.C(new Runnable() { // from class: ir.nasim.c84
            @Override // java.lang.Runnable
            public final void run() {
                E84.f1(list);
            }
        });
    }

    public void n2(C11458d25 c11458d25, J44 j44) {
        this.x.d(new C6434No6.n(c11458d25, j44));
    }

    public void o0(C11458d25 c11458d25, boolean z) {
        O0(c11458d25).d(new C3593Bn1.d(z));
    }

    public void o2(C11458d25 c11458d25, C14419ht c14419ht, Long l, Long l2) {
        this.x.d(new C6434No6.o(c11458d25, c14419ht, l, l2));
    }

    public boolean p0() {
        DB3 db3 = this.t;
        return db3 == null || db3.isEmpty();
    }

    public void p2(C11458d25 c11458d25, String str, String str2, String str3, Long l, Long l2, C7880To7 c7880To7) {
        C19406qI3.a("FiSeCoFl", "sendAudio() message", new Object[0]);
        InterfaceC3346Am2 interfaceC3346Am2R = KN6.r(str);
        this.x.d(new C6434No6.p(c11458d25, str, str2, interfaceC3346Am2R.f(), C14225hZ6.a(str3), l, l2, c7880To7));
    }

    public DB3 q0() {
        DB3 db3 = this.t;
        if (db3 != null) {
            db3.l(true);
        }
        DB3 db3N = KN6.n(C, J44.x);
        this.t = db3N;
        return db3N;
    }

    public void q2(C11458d25 c11458d25, long j, String str, String str2, String str3, Long l, C7880To7 c7880To7) {
        C19406qI3.a("FiSeCoFl", "sendCompressedVideo() message", new Object[0]);
        InterfaceC3346Am2 interfaceC3346Am2R = KN6.r(str2);
        this.x.d(new C6434No6.q(c11458d25, j, str, str2, C14225hZ6.a(str3), l, interfaceC3346Am2R.f(), c7880To7));
    }

    public C6517Nv5 r0(C11458d25 c11458d25) {
        return this.l.j(c11458d25);
    }

    public void r2(C11458d25 c11458d25, String str, ArrayList arrayList, ArrayList arrayList2, String str2, Long l, Long l2, C7880To7 c7880To7) {
        this.x.d(new C6434No6.r(c11458d25, arrayList, arrayList2, str, str2, l, l2, c7880To7));
    }

    public void s0(C11458d25 c11458d25) {
        t0(c11458d25);
        this.g.p(c11458d25);
        I0().o().b(c11458d25.u());
    }

    public void s2(C11458d25 c11458d25, C9625aH3 c9625aH3, String str, String str2, long j, long j2, long j3, String str3) {
        this.x.d(new C6434No6.s(c11458d25, c9625aH3, str, str2, j, j2, j3, str3));
    }

    public void t0(C11458d25 c11458d25) {
        H0(c11458d25).l(false);
        this.x.d(new C6434No6.C6442h(c11458d25));
    }

    public void t2(C11458d25 c11458d25, long j, long j2, C24967zW1 c24967zW1, C7880To7 c7880To7) {
        C19406qI3.a("FiSeCoFl", "sendDocument() message", new Object[0]);
        this.x.d(new C6434No6.u(c11458d25, j, j2, c24967zW1, c7880To7));
    }

    public void u0(C11458d25 c11458d25, List list, List list2, boolean z) {
        this.m.w(c11458d25, list, list2);
        this.k.d(new C23548x64.a(c11458d25, list, list2, z));
    }

    public void u2(C11458d25 c11458d25, String str, String str2, C22694vg2 c22694vg2, String str3, String str4, Long l, Long l2, C7880To7 c7880To7) {
        InterfaceC3346Am2 interfaceC3346Am2R = KN6.r(str3);
        String strA = C14225hZ6.a(str4);
        C19406qI3.a("FiSeCoFl", "sendDocument() called with:fileName = [" + str + "], mimeType = [" + str2 + "], fastThumb = [" + c22694vg2 + "]", new Object[0]);
        this.x.d(new C6434No6.t(c11458d25, str, str2, interfaceC3346Am2R.f(), interfaceC3346Am2R.getDescriptor(), c22694vg2, strA, l, l2, c7880To7));
    }

    public void v0(C11458d25 c11458d25) {
        this.o.remove(c11458d25);
        C9528a7 c9528a7 = (C9528a7) this.n.remove(c11458d25);
        if (c9528a7 != null) {
            c9528a7.d(C12485eh5.a);
        }
    }

    public void v2(C11458d25 c11458d25, String str, int i, int i2, int i3, C22694vg2 c22694vg2, String str2, String str3, Long l, Long l2, String str4, C7880To7 c7880To7) {
        InterfaceC3346Am2 interfaceC3346Am2R = KN6.r(str2);
        this.x.d(new C6434No6.v(c11458d25, str, i, i2, i3, c22694vg2, str2, C14225hZ6.a(str3), interfaceC3346Am2R.f(), l, l2, str4, c7880To7));
    }

    public C6517Nv5 w0(C11458d25 c11458d25, long j, long j2) {
        return P0(c11458d25).m(j, j2);
    }

    public void w2(C11458d25 c11458d25, QG2 qg2, ArrayList arrayList, Long l, Long l2, C7880To7 c7880To7) {
        this.x.d(new C6434No6.w(c11458d25, qg2, arrayList, l, l2, c7880To7));
    }

    public void x0(C11458d25 c11458d25, C11458d25 c11458d252, J44 j44) {
        y0(c11458d25, c11458d252, AbstractC22311v13.a(new Object[]{j44}), null);
    }

    public C6517Nv5 x2(C11458d25 c11458d25, int i, long j, EnumC19802qy enumC19802qy, String str, String str2) {
        return this.y.j(c11458d25, i, j, enumC19802qy, str, str2);
    }

    public void y0(C11458d25 c11458d25, C11458d25 c11458d252, List list, String str) {
        this.B.U().C(c11458d25);
        this.x.d(new C6434No6.C6444j(c11458d25, c11458d252, list, C14225hZ6.a(str)));
    }

    public C6517Nv5 y2(C11458d25 c11458d25, final long j, final long j2, final String str) {
        return this.B.o(c11458d25).H(new InterfaceC17569nB2() { // from class: ir.nasim.q84
            @Override // ir.nasim.InterfaceC17569nB2
            public final Object apply(Object obj) {
                return this.a.A1(j, j2, str, (C17557nA) obj);
            }
        }).h0(new InterfaceC17569nB2() { // from class: ir.nasim.r84
            @Override // ir.nasim.InterfaceC17569nB2
            public final Object apply(Object obj) {
                return E84.B1((Q06) obj);
            }
        });
    }

    public C9528a7 z0(C11458d25 c11458d25) {
        return (C9528a7) this.n.get(c11458d25);
    }

    public void z2(C11458d25 c11458d25, Double d, Double d2, String str, String str2, Long l, Long l2, C7880To7 c7880To7) {
        this.x.d(new C6434No6.y(c11458d25, d, d2, str, str2, l, l2, c7880To7));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Giftpacket$ResponseOpenGiftPacket r1(Giftpacket$ResponseOpenGiftPacket giftpacket$ResponseOpenGiftPacket, C14505i18 c14505i18) {
        return giftpacket$ResponseOpenGiftPacket;
    }
}
