package ir.nasim;

import ai.bale.proto.CollectionsStruct$BooleanValue;
import ai.bale.proto.CollectionsStruct$Int64Value;
import ai.bale.proto.CollectionsStruct$StringValue;
import ai.bale.proto.MeetOuterClass$RequestAcceptCall;
import ai.bale.proto.MeetOuterClass$RequestDiscardCall;
import ai.bale.proto.MeetOuterClass$RequestGetCallLogs;
import ai.bale.proto.MeetOuterClass$RequestGetGroupCall;
import ai.bale.proto.MeetOuterClass$RequestJoinGroupCall;
import ai.bale.proto.MeetOuterClass$RequestLeaveGroupCall;
import ai.bale.proto.MeetOuterClass$RequestReceiveCall;
import ai.bale.proto.MeetOuterClass$RequestSendReaction;
import ai.bale.proto.MeetOuterClass$RequestStartCall;
import ai.bale.proto.MeetOuterClass$RequestStartGroupCall;
import ai.bale.proto.MeetOuterClass$RequestStartLiveKitCall;
import ai.bale.proto.MeetOuterClass$RequestSubmitCallFeedback;
import ai.bale.proto.MeetOuterClass$ResponseCall;
import ai.bale.proto.MeetOuterClass$ResponseGetCallLogs;
import ai.bale.proto.MeetOuterClass$ResponseGetGroupCall;
import ai.bale.proto.MeetOuterClass$ResponseJoinGroupCall;
import ai.bale.proto.MeetOuterClass$ResponseLeaveGroupCall;
import ai.bale.proto.MeetOuterClass$ResponseStartGroupCall;
import ai.bale.proto.MeetStruct$Call;
import ai.bale.proto.MeetStruct$GroupCall;
import ai.bale.proto.MeetStruct$PeerState;
import ai.bale.proto.Misc$ResponseVoid;
import ai.bale.proto.PeersStruct$OutExPeer;
import ai.bale.proto.PeersStruct$OutPeer;
import ai.bale.proto.PeersStruct$Peer;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.AbstractC12895fM2;
import ir.nasim.AbstractC21761u53;
import ir.nasim.AbstractC7031Pz0;
import ir.nasim.C22902w08;
import ir.nasim.InterfaceC9449Zz0;
import ir.nasim.core.modules.profile.entity.ExPeer;
import ir.nasim.core.modules.profile.entity.ExPeerType;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import livekit.org.webrtc.MediaStreamTrack;

/* renamed from: ir.nasim.v08, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C22306v08 extends AbstractC6360Ng4 {
    public static final a x = new a(null);
    public static final int y = 8;
    private final C9057Yh4 m;
    private MeetStruct$Call n;
    private MeetStruct$Call o;
    private Long p;
    private C11458d25 q;
    private Long r;
    private MeetStruct$GroupCall s;
    private final InterfaceC9173Yu3 t;
    private final InterfaceC9173Yu3 u;
    private final InterfaceC9173Yu3 v;
    private final InterfaceC9173Yu3 w;

    /* renamed from: ir.nasim.v08$a */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    /* renamed from: ir.nasim.v08$b */
    public /* synthetic */ class b {
        public static final /* synthetic */ int[] a;
        public static final /* synthetic */ int[] b;

        static {
            int[] iArr = new int[EnumC13941h47.values().length];
            try {
                iArr[EnumC13941h47.a.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            a = iArr;
            int[] iArr2 = new int[K04.values().length];
            try {
                iArr2[K04.CallDiscardReason_UNKNOWN.ordinal()] = 1;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr2[K04.CallDiscardReason_MISSED.ordinal()] = 2;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr2[K04.CallDiscardReason_DISCONNECT.ordinal()] = 3;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr2[K04.CallDiscardReason_HANGUP.ordinal()] = 4;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr2[K04.CallDiscardReason_BUSY.ordinal()] = 5;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr2[K04.UNRECOGNIZED.ordinal()] = 6;
            } catch (NoSuchFieldError unused7) {
            }
            b = iArr2;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C22306v08(C9057Yh4 c9057Yh4) {
        super(c9057Yh4);
        AbstractC13042fc3.i(c9057Yh4, "context");
        this.m = c9057Yh4;
        this.t = AbstractC13269fw3.a(new SA2() { // from class: ir.nasim.p08
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return C22306v08.K0();
            }
        });
        this.u = AbstractC13269fw3.a(new SA2() { // from class: ir.nasim.q08
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return C22306v08.c1();
            }
        });
        this.v = AbstractC13269fw3.a(new SA2() { // from class: ir.nasim.r08
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return C22306v08.n1();
            }
        });
        this.w = AbstractC13269fw3.a(new SA2() { // from class: ir.nasim.s08
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return C22306v08.m1();
            }
        });
    }

    private final C6517Nv5 A1(long j) {
        GeneratedMessageLite generatedMessageLiteA = MeetOuterClass$RequestSendReaction.newBuilder().A(j).B("❤").a();
        AbstractC13042fc3.h(generatedMessageLiteA, "build(...)");
        Misc$ResponseVoid defaultInstance = Misc$ResponseVoid.getDefaultInstance();
        AbstractC13042fc3.h(defaultInstance, "getDefaultInstance(...)");
        C6517Nv5 c6517Nv5E = L(new C22871vx5("/bale.meet.v1.Meet/SendCallReaction", generatedMessageLiteA, defaultInstance)).H(new InterfaceC17569nB2() { // from class: ir.nasim.a08
            @Override // ir.nasim.InterfaceC17569nB2
            public final Object apply(Object obj) {
                return C22306v08.B1((Misc$ResponseVoid) obj);
            }
        }).E(new InterfaceC24449ye1() { // from class: ir.nasim.b08
            @Override // ir.nasim.InterfaceC24449ye1
            public final void apply(Object obj) {
                C22306v08.C1((Exception) obj);
            }
        });
        AbstractC13042fc3.h(c6517Nv5E, "failure(...)");
        return c6517Nv5E;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C6517Nv5 B1(Misc$ResponseVoid misc$ResponseVoid) {
        C19406qI3.a("VoiceCallActor", "send sendReactionRequest success", new Object[0]);
        return C6517Nv5.l0(misc$ResponseVoid);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void C1(Exception exc) {
        C19406qI3.a("VoiceCallActor", "send sendReactionRequest failed: " + exc.getMessage(), new Object[0]);
    }

    private final boolean D1(MeetStruct$Call meetStruct$Call) {
        MeetStruct$Call meetStruct$Call2 = this.n;
        if (meetStruct$Call2 != null && meetStruct$Call2.getId() != meetStruct$Call.getId()) {
            C19406qI3.a("VoiceCallActor", "Decline incoming call because I'm busy. im in personal call", new Object[0]);
            return true;
        }
        if (!b1()) {
            return false;
        }
        C19406qI3.a("VoiceCallActor", "Decline incoming call because I'm busy. im in group call", new Object[0]);
        return true;
    }

    private final boolean E1(MeetStruct$Call meetStruct$Call) {
        MeetStruct$Call meetStruct$Call2 = this.n;
        if (meetStruct$Call2 != null && meetStruct$Call.getId() == meetStruct$Call2.getId()) {
            C19406qI3.a("VoiceCallActor", "Ignore incoming call because I'm already in this call.", new Object[0]);
            return true;
        }
        if (J0(meetStruct$Call)) {
            C19406qI3.a("VoiceCallActor", "Ignore incoming call because I'm starter.", new Object[0]);
            return true;
        }
        if (AbstractC20507s76.o() - meetStruct$Call.getCreateDate() <= 90000) {
            return false;
        }
        C19406qI3.a("VoiceCallActor", "Ignore incoming call because it is expired.", new Object[0]);
        return true;
    }

    private final C6517Nv5 F1(C11458d25 c11458d25, EnumC13941h47 enumC13941h47, boolean z) {
        C5074Hu0.a.g(z);
        this.o = null;
        this.p = Long.valueOf(AbstractC19981rG5.a());
        this.q = c11458d25;
        C17557nA c17557nAU = this.m.u(c11458d25);
        C18732p92 c18732p92 = C18732p92.a;
        AbstractC13042fc3.f(c17557nAU);
        PeersStruct$OutPeer peersStruct$OutPeerY1 = c18732p92.y1(c17557nAU);
        if (b.a[enumC13941h47.ordinal()] != 1) {
            throw new NoWhenBranchMatchedException();
        }
        MeetOuterClass$RequestStartCall.a aVarNewBuilder = MeetOuterClass$RequestStartCall.newBuilder();
        MeetOuterClass$RequestStartLiveKitCall.a aVarB = MeetOuterClass$RequestStartLiveKitCall.newBuilder().B(peersStruct$OutPeerY1);
        Long l = this.p;
        GeneratedMessageLite generatedMessageLiteA = aVarNewBuilder.A(aVarB.C(l != null ? l.longValue() : 0L).A((CollectionsStruct$BooleanValue) CollectionsStruct$BooleanValue.newBuilder().A(C8386Vt0.a.o7()).a()).D(z)).a();
        AbstractC13042fc3.f(generatedMessageLiteA);
        MeetOuterClass$ResponseCall defaultInstance = MeetOuterClass$ResponseCall.getDefaultInstance();
        AbstractC13042fc3.h(defaultInstance, "getDefaultInstance(...)");
        C6517Nv5 c6517Nv5E = L(new C22871vx5("/bale.meet.v1.Meet/StartCall", generatedMessageLiteA, defaultInstance)).H(new InterfaceC17569nB2() { // from class: ir.nasim.l08
            @Override // ir.nasim.InterfaceC17569nB2
            public final Object apply(Object obj) {
                return C22306v08.G1(this.a, (MeetOuterClass$ResponseCall) obj);
            }
        }).E(new InterfaceC24449ye1() { // from class: ir.nasim.m08
            @Override // ir.nasim.InterfaceC24449ye1
            public final void apply(Object obj) {
                C22306v08.H1((Exception) obj);
            }
        });
        AbstractC13042fc3.h(c6517Nv5E, "failure(...)");
        return c6517Nv5E;
    }

    private final C6517Nv5 G0(long j) {
        this.o = null;
        this.r = Long.valueOf(j);
        GeneratedMessageLite generatedMessageLiteA = MeetOuterClass$RequestAcceptCall.newBuilder().A(j).B((CollectionsStruct$BooleanValue) CollectionsStruct$BooleanValue.newBuilder().A(C8386Vt0.a.o7()).a()).a();
        AbstractC13042fc3.h(generatedMessageLiteA, "build(...)");
        MeetOuterClass$ResponseCall defaultInstance = MeetOuterClass$ResponseCall.getDefaultInstance();
        AbstractC13042fc3.h(defaultInstance, "getDefaultInstance(...)");
        C6517Nv5 c6517Nv5E = L(new C22871vx5("/bale.meet.v1.Meet/AcceptCall", generatedMessageLiteA, defaultInstance)).H(new InterfaceC17569nB2() { // from class: ir.nasim.t08
            @Override // ir.nasim.InterfaceC17569nB2
            public final Object apply(Object obj) {
                return C22306v08.H0(this.a, (MeetOuterClass$ResponseCall) obj);
            }
        }).E(new InterfaceC24449ye1() { // from class: ir.nasim.u08
            @Override // ir.nasim.InterfaceC24449ye1
            public final void apply(Object obj) {
                C22306v08.I0((Exception) obj);
            }
        });
        AbstractC13042fc3.h(c6517Nv5E, "failure(...)");
        return c6517Nv5E;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C6517Nv5 G1(C22306v08 c22306v08, MeetOuterClass$ResponseCall meetOuterClass$ResponseCall) {
        AbstractC13042fc3.i(c22306v08, "this$0");
        c22306v08.n = meetOuterClass$ResponseCall.getCall();
        return C6517Nv5.l0(meetOuterClass$ResponseCall);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C6517Nv5 H0(C22306v08 c22306v08, MeetOuterClass$ResponseCall meetOuterClass$ResponseCall) {
        AbstractC13042fc3.i(c22306v08, "this$0");
        c22306v08.n = meetOuterClass$ResponseCall.getCall();
        return C6517Nv5.l0(meetOuterClass$ResponseCall);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void H1(Exception exc) {
        C19406qI3.a("VoiceCallActor", "Start call failed: " + exc, new Object[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void I0(Exception exc) {
        C19406qI3.c("VoiceCallActor", "Accept Voice Call failed", exc);
    }

    private final C6517Nv5 I1(C11458d25 c11458d25, boolean z) {
        GeneratedMessageLite generatedMessageLiteA = MeetOuterClass$RequestStartGroupCall.newBuilder().C(C18732p92.a.x1(this.m.t(c11458d25))).D(z).a();
        AbstractC13042fc3.h(generatedMessageLiteA, "build(...)");
        MeetOuterClass$ResponseStartGroupCall defaultInstance = MeetOuterClass$ResponseStartGroupCall.getDefaultInstance();
        AbstractC13042fc3.h(defaultInstance, "getDefaultInstance(...)");
        C6517Nv5 c6517Nv5E = L(new C22871vx5("/bale.meet.v1.Meet/StartGroupCall", generatedMessageLiteA, defaultInstance)).H(new InterfaceC17569nB2() { // from class: ir.nasim.j08
            @Override // ir.nasim.InterfaceC17569nB2
            public final Object apply(Object obj) {
                return C22306v08.J1(this.a, (MeetOuterClass$ResponseStartGroupCall) obj);
            }
        }).E(new InterfaceC24449ye1() { // from class: ir.nasim.k08
            @Override // ir.nasim.InterfaceC24449ye1
            public final void apply(Object obj) {
                C22306v08.K1((Exception) obj);
            }
        });
        AbstractC13042fc3.h(c6517Nv5E, "failure(...)");
        return c6517Nv5E;
    }

    private final boolean J0(MeetStruct$Call meetStruct$Call) {
        return meetStruct$Call.getAdminUid() == this.m.i0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C6517Nv5 J1(C22306v08 c22306v08, MeetOuterClass$ResponseStartGroupCall meetOuterClass$ResponseStartGroupCall) {
        AbstractC13042fc3.i(c22306v08, "this$0");
        c22306v08.s = meetOuterClass$ResponseStartGroupCall.getGroupCall();
        C20384rv0 c20384rv0 = C20384rv0.a;
        MeetStruct$GroupCall groupCall = meetOuterClass$ResponseStartGroupCall.getGroupCall();
        AbstractC13042fc3.h(groupCall, "getGroupCall(...)");
        C20384rv0.L(c20384rv0, groupCall, true, false, 4, null);
        return C6517Nv5.l0(meetOuterClass$ResponseStartGroupCall);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final InterfaceC5110Hy0 K0() {
        return ((InterfaceC12620ev0) C92.a(C5721Ko.a.d(), InterfaceC12620ev0.class)).p0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void K1(Exception exc) {
        C19406qI3.a("VoiceCallActor", "Start group call failed: " + exc, new Object[0]);
    }

    private final C6517Nv5 L0(final long j, K04 k04) {
        this.o = null;
        GeneratedMessageLite generatedMessageLiteA = MeetOuterClass$RequestDiscardCall.newBuilder().A(j).B(0).C(k04).a();
        AbstractC13042fc3.h(generatedMessageLiteA, "build(...)");
        MeetOuterClass$ResponseCall defaultInstance = MeetOuterClass$ResponseCall.getDefaultInstance();
        AbstractC13042fc3.h(defaultInstance, "getDefaultInstance(...)");
        L(new C22871vx5("/bale.meet.v1.Meet/DiscardCall", generatedMessageLiteA, defaultInstance)).z(new InterfaceC3273Ae1() { // from class: ir.nasim.UZ7
            @Override // ir.nasim.InterfaceC3273Ae1
            public final void apply(Object obj, Object obj2) {
                C22306v08.M0(this.a, j, (MeetOuterClass$ResponseCall) obj, (Exception) obj2);
            }
        });
        C6517Nv5 c6517Nv5L0 = C6517Nv5.l0(C14505i18.a);
        AbstractC13042fc3.h(c6517Nv5L0, "success(...)");
        return c6517Nv5L0;
    }

    private final C6517Nv5 L1(List list) {
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            PeersStruct$OutExPeer peersStruct$OutExPeerX1 = C18732p92.a.x1(this.m.t((C11458d25) it.next()));
            if (peersStruct$OutExPeerX1 != null) {
                arrayList.add(peersStruct$OutExPeerX1);
            }
        }
        GeneratedMessageLite generatedMessageLiteA = MeetOuterClass$RequestStartGroupCall.newBuilder().D(false).B(N04.CallMode_MULTIPEER).A(arrayList).a();
        AbstractC13042fc3.h(generatedMessageLiteA, "build(...)");
        MeetOuterClass$ResponseStartGroupCall defaultInstance = MeetOuterClass$ResponseStartGroupCall.getDefaultInstance();
        AbstractC13042fc3.h(defaultInstance, "getDefaultInstance(...)");
        C6517Nv5 c6517Nv5E = L(new C22871vx5("/bale.meet.v1.Meet/StartGroupCall", generatedMessageLiteA, defaultInstance)).H(new InterfaceC17569nB2() { // from class: ir.nasim.h08
            @Override // ir.nasim.InterfaceC17569nB2
            public final Object apply(Object obj) {
                return C22306v08.M1(this.a, (MeetOuterClass$ResponseStartGroupCall) obj);
            }
        }).E(new InterfaceC24449ye1() { // from class: ir.nasim.i08
            @Override // ir.nasim.InterfaceC24449ye1
            public final void apply(Object obj) {
                C22306v08.N1((Exception) obj);
            }
        });
        AbstractC13042fc3.h(c6517Nv5E, "failure(...)");
        return c6517Nv5E;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void M0(C22306v08 c22306v08, long j, MeetOuterClass$ResponseCall meetOuterClass$ResponseCall, Exception exc) {
        AbstractC13042fc3.i(c22306v08, "this$0");
        if (c22306v08.d1(j)) {
            c22306v08.v1();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C6517Nv5 M1(C22306v08 c22306v08, MeetOuterClass$ResponseStartGroupCall meetOuterClass$ResponseStartGroupCall) {
        AbstractC13042fc3.i(c22306v08, "this$0");
        c22306v08.s = meetOuterClass$ResponseStartGroupCall.getGroupCall();
        C20384rv0 c20384rv0 = C20384rv0.a;
        MeetStruct$GroupCall groupCall = meetOuterClass$ResponseStartGroupCall.getGroupCall();
        AbstractC13042fc3.h(groupCall, "getGroupCall(...)");
        C20384rv0.L(c20384rv0, groupCall, true, false, 4, null);
        return C6517Nv5.l0(meetOuterClass$ResponseStartGroupCall);
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0049  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final ir.nasim.C6517Nv5 N0(java.util.List r7, boolean r8) {
        /*
            r6 = this;
            ai.bale.proto.MeetOuterClass$RequestDeleteCallLogs$a r0 = ai.bale.proto.MeetOuterClass$RequestDeleteCallLogs.newBuilder()
            r1 = r7
            java.lang.Iterable r1 = (java.lang.Iterable) r1
            java.util.ArrayList r2 = new java.util.ArrayList
            r3 = 10
            int r3 = ir.nasim.ZW0.x(r1, r3)
            r2.<init>(r3)
            java.util.Iterator r1 = r1.iterator()
        L16:
            boolean r3 = r1.hasNext()
            if (r3 == 0) goto L38
            java.lang.Object r3 = r1.next()
            java.lang.Number r3 = (java.lang.Number) r3
            long r3 = r3.longValue()
            ai.bale.proto.CollectionsStruct$Int64Value$a r5 = ai.bale.proto.CollectionsStruct$Int64Value.newBuilder()
            ai.bale.proto.CollectionsStruct$Int64Value$a r3 = r5.A(r3)
            com.google.protobuf.GeneratedMessageLite r3 = r3.a()
            ai.bale.proto.CollectionsStruct$Int64Value r3 = (ai.bale.proto.CollectionsStruct$Int64Value) r3
            r2.add(r3)
            goto L16
        L38:
            ai.bale.proto.MeetOuterClass$RequestDeleteCallLogs$a r0 = r0.A(r2)
            if (r8 == 0) goto L49
            java.util.Collection r7 = (java.util.Collection) r7
            boolean r7 = r7.isEmpty()
            r1 = 1
            r7 = r7 ^ r1
            if (r7 == 0) goto L49
            goto L4a
        L49:
            r1 = 0
        L4a:
            ai.bale.proto.MeetOuterClass$RequestDeleteCallLogs$a r7 = r0.C(r1)
            ai.bale.proto.MeetOuterClass$RequestDeleteCallLogs$a r7 = r7.B(r8)
            com.google.protobuf.GeneratedMessageLite r7 = r7.a()
            java.lang.String r8 = "build(...)"
            ir.nasim.AbstractC13042fc3.h(r7, r8)
            ai.bale.proto.Misc$ResponseVoid r8 = ai.bale.proto.Misc$ResponseVoid.getDefaultInstance()
            java.lang.String r0 = "getDefaultInstance(...)"
            ir.nasim.AbstractC13042fc3.h(r8, r0)
            ir.nasim.vx5 r0 = new ir.nasim.vx5
            java.lang.String r1 = "/bale.meet.v1.Meet/DeleteCallLogs"
            r0.<init>(r1, r7, r8)
            ir.nasim.Nv5 r7 = r6.L(r0)
            ir.nasim.c08 r8 = new ir.nasim.c08
            r8.<init>()
            ir.nasim.Nv5 r7 = r7.H(r8)
            ir.nasim.e08 r8 = new ir.nasim.e08
            r8.<init>()
            ir.nasim.Nv5 r7 = r7.E(r8)
            java.lang.String r8 = "failure(...)"
            ir.nasim.AbstractC13042fc3.h(r7, r8)
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C22306v08.N0(java.util.List, boolean):ir.nasim.Nv5");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void N1(Exception exc) {
        C19406qI3.a("VoiceCallActor", "Start group call failed: " + exc, new Object[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C6517Nv5 O0(Misc$ResponseVoid misc$ResponseVoid) {
        C19406qI3.a("VoiceCallActor", "send RequestDeleteCallLogs success", new Object[0]);
        return C6517Nv5.l0(misc$ResponseVoid);
    }

    private final EnumC12029dv0 O1(K04 k04) {
        switch (k04 == null ? -1 : b.b[k04.ordinal()]) {
            case -1:
                return null;
            case 0:
            default:
                throw new NoWhenBranchMatchedException();
            case 1:
                return EnumC12029dv0.a;
            case 2:
                return EnumC12029dv0.b;
            case 3:
                return EnumC12029dv0.c;
            case 4:
                return EnumC12029dv0.d;
            case 5:
                return EnumC12029dv0.e;
            case 6:
                return EnumC12029dv0.a;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void P0(Exception exc) {
        C19406qI3.a("VoiceCallActor", "send RequestDeleteCallLogs failed: " + exc.getMessage(), new Object[0]);
    }

    private final C6517Nv5 Q0(int i) {
        GeneratedMessageLite generatedMessageLiteA = MeetOuterClass$RequestGetCallLogs.newBuilder().A((CollectionsStruct$Int64Value) CollectionsStruct$Int64Value.newBuilder().A(i).a()).a();
        AbstractC13042fc3.h(generatedMessageLiteA, "build(...)");
        MeetOuterClass$ResponseGetCallLogs defaultInstance = MeetOuterClass$ResponseGetCallLogs.getDefaultInstance();
        AbstractC13042fc3.h(defaultInstance, "getDefaultInstance(...)");
        C6517Nv5 c6517Nv5H = L(new C22871vx5("/bale.meet.v1.Meet/GetCallLogs", generatedMessageLiteA, defaultInstance)).H(new InterfaceC17569nB2() { // from class: ir.nasim.XZ7
            @Override // ir.nasim.InterfaceC17569nB2
            public final Object apply(Object obj) {
                return C22306v08.R0((MeetOuterClass$ResponseGetCallLogs) obj);
            }
        });
        AbstractC13042fc3.h(c6517Nv5H, "flatMap(...)");
        return c6517Nv5H;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C6517Nv5 R0(MeetOuterClass$ResponseGetCallLogs meetOuterClass$ResponseGetCallLogs) {
        return C6517Nv5.l0(meetOuterClass$ResponseGetCallLogs);
    }

    private final InterfaceC5110Hy0 S0() {
        return (InterfaceC5110Hy0) this.t.getValue();
    }

    private final C6517Nv5 T0(C11458d25 c11458d25) {
        GeneratedMessageLite generatedMessageLiteA = MeetOuterClass$RequestGetGroupCall.newBuilder().A(C18732p92.a.x1(this.m.t(c11458d25))).a();
        AbstractC13042fc3.h(generatedMessageLiteA, "build(...)");
        MeetOuterClass$ResponseGetGroupCall defaultInstance = MeetOuterClass$ResponseGetGroupCall.getDefaultInstance();
        AbstractC13042fc3.h(defaultInstance, "getDefaultInstance(...)");
        C6517Nv5 c6517Nv5E = L(new C22871vx5("/bale.meet.v1.Meet/GetGroupCall", generatedMessageLiteA, defaultInstance)).H(new InterfaceC17569nB2() { // from class: ir.nasim.YZ7
            @Override // ir.nasim.InterfaceC17569nB2
            public final Object apply(Object obj) {
                return C22306v08.U0(this.a, (MeetOuterClass$ResponseGetGroupCall) obj);
            }
        }).E(new InterfaceC24449ye1() { // from class: ir.nasim.ZZ7
            @Override // ir.nasim.InterfaceC24449ye1
            public final void apply(Object obj) {
                C22306v08.V0((Exception) obj);
            }
        });
        AbstractC13042fc3.h(c6517Nv5E, "failure(...)");
        return c6517Nv5E;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C6517Nv5 U0(C22306v08 c22306v08, MeetOuterClass$ResponseGetGroupCall meetOuterClass$ResponseGetGroupCall) {
        AbstractC13042fc3.i(c22306v08, "this$0");
        MeetStruct$GroupCall groupCall = meetOuterClass$ResponseGetGroupCall.getGroupCall();
        if (groupCall != null) {
            C20384rv0.a.K(groupCall, groupCall.getInitiatorUserId() == c22306v08.m.i0(), true);
        }
        return C6517Nv5.l0(Boolean.FALSE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void V0(Exception exc) {
        C19406qI3.a("VoiceCallActor", "get Group Call Running Status failed: " + exc, new Object[0]);
    }

    private final E53 W0() {
        return (E53) this.u.getValue();
    }

    private final YN3 X0() {
        return (YN3) this.w.getValue();
    }

    private final ZN3 Y0() {
        return (ZN3) this.v.getValue();
    }

    private final void Z0(MeetStruct$Call meetStruct$Call) {
        this.o = null;
        if (E1(meetStruct$Call)) {
            return;
        }
        if (D1(meetStruct$Call)) {
            r().d(new C22902w08.d(meetStruct$Call.getId(), K04.CallDiscardReason_BUSY));
        } else {
            this.n = meetStruct$Call;
            S0().h(meetStruct$Call.getAdminUid(), meetStruct$Call, meetStruct$Call.getVideo());
        }
    }

    private final void a1(long j, List list) {
        InterfaceC5110Hy0 interfaceC5110Hy0S0 = S0();
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            R25 r25A = S25.a(j, (MeetStruct$PeerState) it.next());
            if (r25A != null) {
                arrayList.add(r25A);
            }
        }
        interfaceC5110Hy0S0.b(arrayList);
    }

    private final boolean b1() {
        return this.s != null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final E53 c1() {
        return ((InterfaceC12620ev0) C92.a(C5721Ko.a.d(), InterfaceC12620ev0.class)).e0();
    }

    private final boolean d1(long j) {
        return ((C17448mz0) C18039nz0.a.h().getValue()).c() == j;
    }

    private final boolean e1(long j) {
        MeetStruct$GroupCall meetStruct$GroupCall = this.s;
        return meetStruct$GroupCall != null && meetStruct$GroupCall.getId() == j;
    }

    private final C6517Nv5 f1(long j, String str) {
        GeneratedMessageLite generatedMessageLiteA = MeetOuterClass$RequestJoinGroupCall.newBuilder().A(j).B((CollectionsStruct$StringValue) CollectionsStruct$StringValue.newBuilder().A(str).a()).a();
        AbstractC13042fc3.h(generatedMessageLiteA, "build(...)");
        MeetOuterClass$ResponseJoinGroupCall defaultInstance = MeetOuterClass$ResponseJoinGroupCall.getDefaultInstance();
        AbstractC13042fc3.h(defaultInstance, "getDefaultInstance(...)");
        C6517Nv5 c6517Nv5E = L(new C22871vx5("/bale.meet.v1.Meet/JoinGroupCall", generatedMessageLiteA, defaultInstance)).H(new InterfaceC17569nB2() { // from class: ir.nasim.VZ7
            @Override // ir.nasim.InterfaceC17569nB2
            public final Object apply(Object obj) {
                return C22306v08.h1(this.a, (MeetOuterClass$ResponseJoinGroupCall) obj);
            }
        }).E(new InterfaceC24449ye1() { // from class: ir.nasim.WZ7
            @Override // ir.nasim.InterfaceC24449ye1
            public final void apply(Object obj) {
                C22306v08.g1((Exception) obj);
            }
        });
        AbstractC13042fc3.h(c6517Nv5E, "failure(...)");
        return c6517Nv5E;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g1(Exception exc) {
        C19406qI3.a("VoiceCallActor", "Join call failed: " + exc, new Object[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C6517Nv5 h1(C22306v08 c22306v08, MeetOuterClass$ResponseJoinGroupCall meetOuterClass$ResponseJoinGroupCall) {
        AbstractC13042fc3.i(c22306v08, "this$0");
        c22306v08.s = meetOuterClass$ResponseJoinGroupCall.getGroupCall();
        return C6517Nv5.l0(meetOuterClass$ResponseJoinGroupCall);
    }

    private final C6517Nv5 i1(long j, boolean z) {
        GeneratedMessageLite generatedMessageLiteA = MeetOuterClass$RequestLeaveGroupCall.newBuilder().A(j).B(z).a();
        AbstractC13042fc3.h(generatedMessageLiteA, "build(...)");
        MeetOuterClass$ResponseLeaveGroupCall defaultInstance = MeetOuterClass$ResponseLeaveGroupCall.getDefaultInstance();
        AbstractC13042fc3.h(defaultInstance, "getDefaultInstance(...)");
        C6517Nv5 c6517Nv5Z = L(new C22871vx5("/bale.meet.v1.Meet/LeaveGroupCall", generatedMessageLiteA, defaultInstance)).H(new InterfaceC17569nB2() { // from class: ir.nasim.SZ7
            @Override // ir.nasim.InterfaceC17569nB2
            public final Object apply(Object obj) {
                return C22306v08.j1((MeetOuterClass$ResponseLeaveGroupCall) obj);
            }
        }).E(new InterfaceC24449ye1() { // from class: ir.nasim.d08
            @Override // ir.nasim.InterfaceC24449ye1
            public final void apply(Object obj) {
                C22306v08.k1((Exception) obj);
            }
        }).z(new InterfaceC3273Ae1() { // from class: ir.nasim.n08
            @Override // ir.nasim.InterfaceC3273Ae1
            public final void apply(Object obj, Object obj2) {
                C22306v08.l1(this.a, (MeetOuterClass$ResponseLeaveGroupCall) obj, (Exception) obj2);
            }
        });
        AbstractC13042fc3.h(c6517Nv5Z, "after(...)");
        return c6517Nv5Z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C6517Nv5 j1(MeetOuterClass$ResponseLeaveGroupCall meetOuterClass$ResponseLeaveGroupCall) {
        return C6517Nv5.l0(meetOuterClass$ResponseLeaveGroupCall);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void k1(Exception exc) {
        C19406qI3.a("VoiceCallActor", "Leave call failed: " + exc, new Object[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void l1(C22306v08 c22306v08, MeetOuterClass$ResponseLeaveGroupCall meetOuterClass$ResponseLeaveGroupCall, Exception exc) {
        AbstractC13042fc3.i(c22306v08, "this$0");
        c22306v08.w1();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final YN3 m1() {
        return ((InterfaceC12620ev0) C92.a(C5721Ko.a.d(), InterfaceC12620ev0.class)).z0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ZN3 n1() {
        return ((InterfaceC12620ev0) C92.a(C5721Ko.a.d(), InterfaceC12620ev0.class)).d1();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void o1(C22306v08 c22306v08, Object obj, C14505i18 c14505i18, Exception exc) {
        AbstractC13042fc3.i(c22306v08, "this$0");
        c22306v08.r1(((C22902w08.p) obj).a());
    }

    private final void p1(MeetStruct$Call meetStruct$Call) {
        InterfaceC5110Hy0 interfaceC5110Hy0S0 = S0();
        K04 discardReason = meetStruct$Call.getDiscardReason();
        interfaceC5110Hy0S0.d(discardReason != null ? O1(discardReason) : null, meetStruct$Call.getDuration() > 0 ? meetStruct$Call.getDuration() : 0);
    }

    private final void q1(MeetStruct$GroupCall meetStruct$GroupCall) {
        S0().i(meetStruct$GroupCall);
    }

    private final C6517Nv5 r1(AbstractC20556sC7 abstractC20556sC7) {
        if (abstractC20556sC7 instanceof QC7) {
            MeetStruct$Call meetStruct$CallA = ((QC7) abstractC20556sC7).a();
            W0().f(new AbstractC21761u53.c(meetStruct$CallA.getId(), meetStruct$CallA.getAdminUid(), meetStruct$CallA.getCreateDate(), meetStruct$CallA.getVideo() ? AbstractC7031Pz0.c.b : AbstractC7031Pz0.e.b));
            C6517Nv5 c6517Nv5L0 = C6517Nv5.l0(C14505i18.a);
            AbstractC13042fc3.h(c6517Nv5L0, "success(...)");
            return c6517Nv5L0;
        }
        if (abstractC20556sC7 instanceof QD7) {
            S0().g(Y0().a(((QD7) abstractC20556sC7).a()));
            C6517Nv5 c6517Nv5L02 = C6517Nv5.l0(C14505i18.a);
            AbstractC13042fc3.h(c6517Nv5L02, "success(...)");
            return c6517Nv5L02;
        }
        if (abstractC20556sC7 instanceof OD7) {
            MeetStruct$GroupCall meetStruct$GroupCallA = ((OD7) abstractC20556sC7).a();
            if (meetStruct$GroupCallA.getMode() == N04.CallMode_MULTIPEER) {
                C19406qI3.a("VoiceCallActor", "update call discarded " + meetStruct$GroupCallA.getId(), new Object[0]);
                S0().g(X0().a(meetStruct$GroupCallA));
            } else {
                C19406qI3.a("VoiceCallActor", "update call discarded " + meetStruct$GroupCallA.getId(), new Object[0]);
                this.o = null;
                q1(meetStruct$GroupCallA);
                if (e1(meetStruct$GroupCallA.getId())) {
                    w1();
                } else {
                    C19406qI3.a("VoiceCallActor", "update call discarded ignored, because no call with id: " + meetStruct$GroupCallA.getId() + " is in progress.", new Object[0]);
                }
            }
            C6517Nv5 c6517Nv5L03 = C6517Nv5.l0(C14505i18.a);
            AbstractC13042fc3.h(c6517Nv5L03, "success(...)");
            return c6517Nv5L03;
        }
        if (abstractC20556sC7 instanceof EC7) {
            MeetStruct$Call meetStruct$CallA2 = ((EC7) abstractC20556sC7).a();
            this.o = null;
            if (!J0(meetStruct$CallA2)) {
                Long l = this.r;
                long id = meetStruct$CallA2.getId();
                if (l == null || l.longValue() != id) {
                    if (d1(meetStruct$CallA2.getId())) {
                        p1(meetStruct$CallA2);
                        v1();
                    }
                    C6517Nv5 c6517Nv5L04 = C6517Nv5.l0(C14505i18.a);
                    AbstractC13042fc3.h(c6517Nv5L04, "success(...)");
                    return c6517Nv5L04;
                }
            }
            this.n = meetStruct$CallA2;
            C20384rv0.a.P(meetStruct$CallA2.getId());
        } else if (abstractC20556sC7 instanceof GC7) {
            MeetStruct$Call meetStruct$CallA3 = ((GC7) abstractC20556sC7).a();
            this.o = null;
            if (d1(meetStruct$CallA3.getId())) {
                p1(meetStruct$CallA3);
                v1();
            } else {
                C19406qI3.a("VoiceCallActor", "update call discarded ignored, because no call with id: " + meetStruct$CallA3.getId() + " is in progress.", new Object[0]);
            }
        } else if (abstractC20556sC7 instanceof MC7) {
            MC7 mc7 = (MC7) abstractC20556sC7;
            if (mc7.b().getExPeerType() == ExPeerType.PRIVATE) {
                if (AbstractC13042fc3.d(mc7.a(), "❤")) {
                    C20384rv0.a.R(mc7.b(), EnumC21689ty0.a);
                } else {
                    C20384rv0.a.R(mc7.b(), EnumC21689ty0.b);
                }
            }
        } else if (abstractC20556sC7 instanceof IC7) {
            IC7 ic7 = (IC7) abstractC20556sC7;
            S0().g(new InterfaceC9449Zz0.a(AbstractC20975sv0.a(ic7.a()), Long.parseLong((String) AbstractC15401jX0.q0(AbstractC20762sZ6.N0(ic7.b(), new String[]{"_"}, false, 0, 6, null))), null));
        } else if (abstractC20556sC7 instanceof C10821cF7) {
            E53 e53W0 = W0();
            C10821cF7 c10821cF7 = (C10821cF7) abstractC20556sC7;
            List listC = c10821cF7.c();
            ArrayList arrayList = new ArrayList(AbstractC10976cX0.x(listC, 10));
            Iterator it = listC.iterator();
            while (it.hasNext()) {
                arrayList.add(new C11458d25(W25.a, ((ExPeer) it.next()).getPeerId()));
            }
            e53W0.f(new AbstractC21761u53.b(arrayList, c10821cF7.a(), (int) c10821cF7.b(), c10821cF7.d(), new AbstractC7031Pz0.d(AbstractC12895fM2.a.a)));
        } else if (abstractC20556sC7 instanceof C13455gF7) {
            C13455gF7 c13455gF7 = (C13455gF7) abstractC20556sC7;
            a1(AbstractC20975sv0.a(c13455gF7.a()), c13455gF7.b());
        } else if (abstractC20556sC7 instanceof SC7) {
            S0().f();
        }
        C6517Nv5 c6517Nv5L05 = C6517Nv5.l0(C14505i18.a);
        AbstractC13042fc3.h(c6517Nv5L05, "success(...)");
        return c6517Nv5L05;
    }

    private final void s1() {
        this.o = this.n;
        v1();
    }

    private final void t1(long j) {
        GeneratedMessageLite generatedMessageLiteA = MeetOuterClass$RequestReceiveCall.newBuilder().A(j).a();
        AbstractC13042fc3.h(generatedMessageLiteA, "build(...)");
        Misc$ResponseVoid defaultInstance = Misc$ResponseVoid.getDefaultInstance();
        AbstractC13042fc3.h(defaultInstance, "getDefaultInstance(...)");
        L(new C22871vx5("/bale.meet.v1.Meet/ReceiveCall", generatedMessageLiteA, defaultInstance)).E(new InterfaceC24449ye1() { // from class: ir.nasim.TZ7
            @Override // ir.nasim.InterfaceC24449ye1
            public final void apply(Object obj) {
                C22306v08.u1((Exception) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void u1(Exception exc) {
        C19406qI3.a("VoiceCallActor", "Request receive call failed: " + exc.getMessage(), new Object[0]);
    }

    private final void v1() {
        this.n = null;
        this.p = null;
        this.q = null;
        this.r = null;
    }

    private final void w1() {
        this.s = null;
    }

    private final C6517Nv5 x1(long j, String str, boolean z, int i, boolean z2) {
        MeetOuterClass$RequestSubmitCallFeedback.a aVarG = MeetOuterClass$RequestSubmitCallFeedback.newBuilder().B(j).F(i).E((CollectionsStruct$BooleanValue) CollectionsStruct$BooleanValue.newBuilder().A(z2).a()).A(AbstractC19460qO3.g(AbstractC4616Fw7.a("is_video", z ? MediaStreamTrack.VIDEO_TRACK_KIND : MediaStreamTrack.AUDIO_TRACK_KIND))).C(J04.CallClient_ANDROID).G((CollectionsStruct$StringValue) CollectionsStruct$StringValue.newBuilder().A(str).a());
        CollectionsStruct$StringValue.a aVarNewBuilder = CollectionsStruct$StringValue.newBuilder();
        String strR = AbstractC20507s76.r();
        AbstractC13042fc3.h(strR, "getVersion(...)");
        GeneratedMessageLite generatedMessageLiteA = aVarG.D((CollectionsStruct$StringValue) aVarNewBuilder.A(AbstractC20762sZ6.g1(AbstractC20762sZ6.Y0(strR, '(', null, 2, null), ')', null, 2, null)).a()).a();
        AbstractC13042fc3.h(generatedMessageLiteA, "build(...)");
        Misc$ResponseVoid defaultInstance = Misc$ResponseVoid.getDefaultInstance();
        AbstractC13042fc3.h(defaultInstance, "getDefaultInstance(...)");
        C6517Nv5 c6517Nv5E = L(new C22871vx5("/bale.meet.v1.Meet/SubmitCallFeedback", generatedMessageLiteA, defaultInstance)).H(new InterfaceC17569nB2() { // from class: ir.nasim.f08
            @Override // ir.nasim.InterfaceC17569nB2
            public final Object apply(Object obj) {
                return C22306v08.y1((Misc$ResponseVoid) obj);
            }
        }).E(new InterfaceC24449ye1() { // from class: ir.nasim.g08
            @Override // ir.nasim.InterfaceC24449ye1
            public final void apply(Object obj) {
                C22306v08.z1((Exception) obj);
            }
        });
        AbstractC13042fc3.h(c6517Nv5E, "failure(...)");
        return c6517Nv5E;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C6517Nv5 y1(Misc$ResponseVoid misc$ResponseVoid) {
        C19406qI3.a("VoiceCallActor", "send sendSubmitFeedbackRequest success", new Object[0]);
        return C6517Nv5.l0(misc$ResponseVoid);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void z1(Exception exc) {
        C19406qI3.a("VoiceCallActor", "send sendSubmitFeedbackRequest failed: " + exc.getMessage(), new Object[0]);
    }

    @Override // ir.nasim.AbstractC17647nK
    public C6517Nv5 G(final Object obj) {
        C6517Nv5 c6517Nv5R1;
        if (obj instanceof C22902w08.m) {
            C22902w08.m mVar = (C22902w08.m) obj;
            return F1(mVar.a(), mVar.b(), mVar.c());
        }
        if (obj instanceof C22902w08.n) {
            C22902w08.n nVar = (C22902w08.n) obj;
            return I1(nVar.a(), nVar.b());
        }
        if (obj instanceof C22902w08.o) {
            return L1(((C22902w08.o) obj).a());
        }
        if (obj instanceof C22902w08.h) {
            C22902w08.h hVar = (C22902w08.h) obj;
            return f1(hVar.a(), hVar.b());
        }
        if (obj instanceof C22902w08.g) {
            return T0(((C22902w08.g) obj).a());
        }
        if (obj instanceof C22902w08.a) {
            return G0(((C22902w08.a) obj).a());
        }
        if (obj instanceof C22902w08.d) {
            C22902w08.d dVar = (C22902w08.d) obj;
            return L0(dVar.a(), dVar.b());
        }
        if (!(obj instanceof C22902w08.p)) {
            if (obj instanceof C22902w08.j) {
                return A1(((C22902w08.j) obj).a());
            }
            if (obj instanceof C22902w08.f) {
                C22902w08.f fVar = (C22902w08.f) obj;
                return x1(fVar.a(), fVar.b(), fVar.e(), fVar.c(), fVar.d());
            }
            if (obj instanceof C22902w08.e) {
                C22902w08.e eVar = (C22902w08.e) obj;
                return N0(eVar.a(), eVar.b());
            }
            if (obj instanceof C22902w08.b) {
                return Q0(((C22902w08.b) obj).a());
            }
            C6517Nv5 c6517Nv5G = super.G(obj);
            AbstractC13042fc3.h(c6517Nv5G, "onAsk(...)");
            return c6517Nv5G;
        }
        C22902w08.p pVar = (C22902w08.p) obj;
        AbstractC20556sC7 abstractC20556sC7A = pVar.a();
        if (abstractC20556sC7A instanceof QC7) {
            MeetStruct$Call meetStruct$CallA = ((QC7) pVar.a()).a();
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            arrayList.add(new C18766pD(meetStruct$CallA.getAdminUid(), 0L));
            PeersStruct$Peer peer = meetStruct$CallA.getPeer();
            if (peer != null) {
                if (peer.getType() == EnumC16311l35.PeerType_PRIVATE) {
                    arrayList.add(new C18766pD(peer.getId(), 0L));
                } else if (peer.getType() == EnumC16311l35.PeerType_GROUP) {
                    arrayList2.add(new C25238zy(peer.getId(), 0L));
                }
            }
            c6517Nv5R1 = this.m.V().t0(arrayList, arrayList2, false).z(new InterfaceC3273Ae1() { // from class: ir.nasim.o08
                @Override // ir.nasim.InterfaceC3273Ae1
                public final void apply(Object obj2, Object obj3) {
                    C22306v08.o1(this.a, obj, (C14505i18) obj2, (Exception) obj3);
                }
            });
        } else {
            c6517Nv5R1 = (!(abstractC20556sC7A instanceof QD7) && (abstractC20556sC7A instanceof OD7)) ? r1(pVar.a()) : r1(pVar.a());
        }
        AbstractC13042fc3.f(c6517Nv5R1);
        return c6517Nv5R1;
    }

    @Override // ir.nasim.AbstractC6360Ng4, ir.nasim.InterfaceC3817Cm0
    /* renamed from: g */
    public void T(AbstractC18385oa2 abstractC18385oa2) {
        MeetStruct$Call meetStruct$Call;
        super.T(abstractC18385oa2);
        if ((abstractC18385oa2 instanceof XE) && ((XE) abstractC18385oa2).a && (meetStruct$Call = this.o) != null) {
            Z0(meetStruct$Call);
        }
    }

    @Override // ir.nasim.AbstractC17647nK, ir.nasim.K6
    public void m(Object obj) throws Exception {
        if (obj instanceof C22902w08.a) {
            G0(((C22902w08.a) obj).a());
            return;
        }
        if (obj instanceof C22902w08.d) {
            C22902w08.d dVar = (C22902w08.d) obj;
            L0(dVar.a(), dVar.b());
            return;
        }
        if (obj instanceof C22902w08.i) {
            C22902w08.i iVar = (C22902w08.i) obj;
            i1(iVar.a(), iVar.b());
        } else if (obj instanceof C22902w08.k) {
            t1(((C22902w08.k) obj).a());
        } else if (obj instanceof C22902w08.l) {
            s1();
        } else {
            super.m(obj);
        }
    }

    @Override // ir.nasim.K6
    public void o() {
        super.o();
        b0("app_visible_changed");
    }
}
