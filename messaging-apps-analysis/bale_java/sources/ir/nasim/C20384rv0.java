package ir.nasim;

import ai.bale.proto.MeetStruct$Call;
import ai.bale.proto.MeetStruct$GroupCall;
import android.content.Intent;
import ir.nasim.AbstractC7031Pz0;
import ir.nasim.InterfaceC18490ok7;
import ir.nasim.core.modules.profile.entity.ExPeer;
import ir.nasim.features.call.service.CallService;
import ir.nasim.features.call.service.VideoCallService;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;

/* renamed from: ir.nasim.rv0, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C20384rv0 implements InterfaceC5110Hy0 {
    public static final C20384rv0 a = new C20384rv0();

    /* renamed from: ir.nasim.rv0$a */
    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[EnumC21689ty0.values().length];
            try {
                iArr[EnumC21689ty0.a.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[EnumC21689ty0.b.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            a = iArr;
        }
    }

    private C20384rv0() {
    }

    private final void C(final int i, final MeetStruct$Call meetStruct$Call, final boolean z) {
        AbstractC20507s76.z(new Runnable() { // from class: ir.nasim.ov0
            @Override // java.lang.Runnable
            public final void run() {
                C20384rv0.D(meetStruct$Call, z, i);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void D(MeetStruct$Call meetStruct$Call, boolean z, int i) {
        boolean z2 = !AD4.e(C5721Ko.a.d()).a();
        boolean z3 = meetStruct$Call != null;
        if (z3 && z2 && (AbstractC7426Rr.a.q() || !C5161Id6.a.i())) {
            C19406qI3.a("CallHelper", "Return from init call, because notifications is disabled!", new Object[0]);
            AbstractC5969Lp4.d().Y().X().T();
            return;
        }
        C20384rv0 c20384rv0 = a;
        Intent intentY = c20384rv0.y(z ? z3 ? "incoming_video" : "start_video_call" : z3 ? "incoming_voice" : "start_voice_call");
        intentY.putExtra("user_id", i);
        intentY.putExtra("notifications_disabled", z2);
        if (meetStruct$Call != null) {
            intentY.putExtra("call_id", meetStruct$Call.getId());
        }
        intentY.putExtra("switch_type", EnumC13941h47.a);
        X(c20384rv0, intentY, z2, false, 4, null);
    }

    private final void E(final int i, final long j, final MeetStruct$GroupCall meetStruct$GroupCall, final boolean z) {
        AbstractC20507s76.z(new Runnable() { // from class: ir.nasim.jv0
            @Override // java.lang.Runnable
            public final void run() {
                C20384rv0.G(meetStruct$GroupCall, z, i, j);
            }
        });
    }

    static /* synthetic */ void F(C20384rv0 c20384rv0, int i, long j, MeetStruct$GroupCall meetStruct$GroupCall, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            j = 0;
        }
        c20384rv0.E(i, j, meetStruct$GroupCall, z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void G(MeetStruct$GroupCall meetStruct$GroupCall, boolean z, int i, long j) {
        boolean z2 = !AD4.e(C5721Ko.a.d()).a();
        boolean z3 = meetStruct$GroupCall != null;
        C20384rv0 c20384rv0 = a;
        Intent intentY = c20384rv0.y(z3 ? "ACTION_INCOMING_GROUP_VOICE_CALL" : "ACTION_START_GROUP_VOICE_CALL");
        intentY.putExtra("CALL_GROUP_ID_INT", i);
        if (!z3) {
            intentY.putExtra("CALL_GROUP_UNIQID_INT", j);
        }
        if (meetStruct$GroupCall != null) {
            intentY.putExtra("call_id", meetStruct$GroupCall.getId());
        }
        intentY.putExtra("notifications_disabled", z2);
        intentY.putExtra("switch_type", EnumC13941h47.a);
        X(c20384rv0, intentY, z2, false, 4, null);
    }

    private final void H(final List list) {
        AbstractC20507s76.z(new Runnable() { // from class: ir.nasim.iv0
            @Override // java.lang.Runnable
            public final void run() {
                C20384rv0.I(list);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void I(List list) {
        AbstractC13042fc3.i(list, "$peerIds");
        boolean z = !AD4.e(C5721Ko.a.d()).a();
        C20384rv0 c20384rv0 = a;
        Intent intentY = c20384rv0.y("ACTION_START_GROUP_VOICE_CALL_WITH_USERS");
        intentY.putExtra("USERS_UNIQ_ID", AbstractC15401jX0.n1(list));
        intentY.putExtra("notifications_disabled", z);
        intentY.putExtra("switch_type", EnumC13941h47.a);
        X(c20384rv0, intentY, z, false, 4, null);
    }

    public static /* synthetic */ void L(C20384rv0 c20384rv0, MeetStruct$GroupCall meetStruct$GroupCall, boolean z, boolean z2, int i, Object obj) {
        if ((i & 4) != 0) {
            z2 = false;
        }
        c20384rv0.K(meetStruct$GroupCall, z, z2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 M(boolean z, boolean z2, MeetStruct$GroupCall meetStruct$GroupCall, boolean z3, boolean z4) {
        AbstractC13042fc3.i(meetStruct$GroupCall, "$protoCall");
        if (!z3) {
            C19406qI3.a("CallHelper", "groupCallStarted => amICreator: " + z + " isUserOnACall: " + z4, new Object[0]);
            if (!z && !z4 && !z2) {
                a.Z(meetStruct$GroupCall.getPeer().getId(), meetStruct$GroupCall, false);
            }
        }
        return C19938rB7.a;
    }

    private final void T(Intent intent) {
        if (!C18039nz0.k() || CallService.INSTANCE.a() == null) {
            return;
        }
        W(intent, !AD4.e(C5721Ko.a.d()).a(), false);
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x0016 A[Catch: all -> 0x0014, TRY_LEAVE, TryCatch #0 {all -> 0x0014, blocks: (B:3:0x0002, B:6:0x000a, B:9:0x0016), top: B:22:0x0002 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final void W(android.content.Intent r3, boolean r4, boolean r5) {
        /*
            r2 = this;
            if (r4 != 0) goto L16
            int r4 = android.os.Build.VERSION.SDK_INT     // Catch: java.lang.Throwable -> L14
            r0 = 26
            if (r4 < r0) goto L16
            if (r5 == 0) goto L16
            ir.nasim.Ko r4 = ir.nasim.C5721Ko.a     // Catch: java.lang.Throwable -> L14
            android.content.Context r4 = r4.d()     // Catch: java.lang.Throwable -> L14
            ir.nasim.TM7.a(r4, r3)     // Catch: java.lang.Throwable -> L14
            goto L70
        L14:
            r4 = move-exception
            goto L20
        L16:
            ir.nasim.Ko r4 = ir.nasim.C5721Ko.a     // Catch: java.lang.Throwable -> L14
            android.content.Context r4 = r4.d()     // Catch: java.lang.Throwable -> L14
            r4.startService(r3)     // Catch: java.lang.Throwable -> L14
            goto L70
        L20:
            java.lang.String r5 = r4.getMessage()
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "Error in startCallService: "
            r0.append(r1)
            r0.append(r5)
            java.lang.String r5 = r0.toString()
            r0 = 0
            java.lang.Object[] r0 = new java.lang.Object[r0]
            java.lang.String r1 = "CallHelper"
            ir.nasim.C19406qI3.a(r1, r5, r0)
            java.lang.String r5 = r3.getAction()
            java.lang.String r0 = "incoming_voice"
            boolean r5 = ir.nasim.AbstractC13042fc3.d(r5, r0)
            if (r5 != 0) goto L55
            java.lang.String r3 = r3.getAction()
            java.lang.String r5 = "incoming_video"
            boolean r3 = ir.nasim.AbstractC13042fc3.d(r3, r5)
            if (r3 == 0) goto L70
        L55:
            int r3 = android.os.Build.VERSION.SDK_INT
            r5 = 31
            if (r3 < r5) goto L70
            boolean r3 = ir.nasim.AbstractC13847gv0.a(r4)
            if (r3 == 0) goto L70
            ir.nasim.cq r3 = ir.nasim.AbstractC5969Lp4.d()
            ir.nasim.Yh4 r3 = r3.Y()
            ir.nasim.A08 r3 = r3.X()
            r3.T()
        L70:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C20384rv0.W(android.content.Intent, boolean, boolean):void");
    }

    static /* synthetic */ void X(C20384rv0 c20384rv0, Intent intent, boolean z, boolean z2, int i, Object obj) {
        if ((i & 4) != 0) {
            z2 = true;
        }
        c20384rv0.W(intent, z, z2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Y(int i, MeetStruct$Call meetStruct$Call, boolean z) {
        AbstractC13042fc3.i(meetStruct$Call, "$protoCall");
        if (InterfaceC18490ok7.a.b(InterfaceC18490ok7.a, C5721Ko.a.d(), true, null, 4, null).b()) {
            a.C(i, meetStruct$Call, z);
        } else {
            a.z(meetStruct$Call.getId());
        }
    }

    private final void Z(final int i, final MeetStruct$GroupCall meetStruct$GroupCall, final boolean z) {
        AbstractC20507s76.z(new Runnable() { // from class: ir.nasim.hv0
            @Override // java.lang.Runnable
            public final void run() {
                C20384rv0.a0(i, meetStruct$GroupCall, z);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a0(int i, MeetStruct$GroupCall meetStruct$GroupCall, boolean z) {
        AbstractC13042fc3.i(meetStruct$GroupCall, "$protoCall");
        if (InterfaceC18490ok7.a.b(InterfaceC18490ok7.a, C5721Ko.a.d(), true, null, 4, null).b()) {
            F(a, i, 0L, meetStruct$GroupCall, z, 2, null);
        }
    }

    public static final void b0(final int i, final boolean z) {
        if (InterfaceC18490ok7.a.b(InterfaceC18490ok7.a, C5721Ko.a.d(), true, null, 4, null).b()) {
            AbstractC5969Lp4.d().h0(i).m0(new InterfaceC24449ye1() { // from class: ir.nasim.kv0
                @Override // ir.nasim.InterfaceC24449ye1
                public final void apply(Object obj) {
                    C20384rv0.d0(i, z, (C21231tK7) obj);
                }
            }).E(new InterfaceC24449ye1() { // from class: ir.nasim.lv0
                @Override // ir.nasim.InterfaceC24449ye1
                public final void apply(Object obj) {
                    C20384rv0.e0((Exception) obj);
                }
            });
        } else {
            C19406qI3.a("CallHelper", "Telephony call in progress, can't start Bale call", new Object[0]);
        }
    }

    public static final void c0(final int i, final boolean z, SA2 sa2, SA2 sa22, UA2 ua2) {
        AbstractC13042fc3.i(sa2, "anotherCallIsInProgressCallback");
        AbstractC13042fc3.i(sa22, "noInternetCallback");
        AbstractC13042fc3.i(ua2, "noPermissionCallback");
        if (C18039nz0.k()) {
            sa2.invoke();
            return;
        }
        C5721Ko c5721Ko = C5721Ko.a;
        if (!C4100Dr4.a(c5721Ko.d())) {
            sa22.invoke();
            return;
        }
        if (z) {
            int iW = a.w();
            if (iW != -1) {
                ua2.invoke(Integer.valueOf(iW));
                return;
            }
        } else {
            int iX = a.x();
            if (iX != -1) {
                ua2.invoke(Integer.valueOf(iX));
                return;
            }
        }
        if (InterfaceC18490ok7.a.b(InterfaceC18490ok7.a, c5721Ko.d(), true, null, 4, null).b()) {
            AbstractC5969Lp4.d().h0(i).m0(new InterfaceC24449ye1() { // from class: ir.nasim.mv0
                @Override // ir.nasim.InterfaceC24449ye1
                public final void apply(Object obj) {
                    C20384rv0.f0(i, z, (C21231tK7) obj);
                }
            }).E(new InterfaceC24449ye1() { // from class: ir.nasim.nv0
                @Override // ir.nasim.InterfaceC24449ye1
                public final void apply(Object obj) {
                    C20384rv0.g0((Exception) obj);
                }
            });
        } else {
            C19406qI3.a("CallHelper", "Telephony call in progress, can't start Bale call", new Object[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d0(int i, boolean z, C21231tK7 c21231tK7) {
        if (((Boolean) c21231tK7.A().b()).booleanValue()) {
            C19406qI3.j("CallHelper", "startOutgoingCall: user is deleted account so return!", new Object[0]);
        } else {
            a.C(i, null, z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e0(Exception exc) {
        C19406qI3.b("CallHelper", "doInitiateCall error on getUser: " + exc.getMessage());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f0(int i, boolean z, C21231tK7 c21231tK7) {
        if (((Boolean) c21231tK7.A().b()).booleanValue()) {
            C19406qI3.j("CallHelper", "new startOutgoingCall: user is deleted account so return!", new Object[0]);
        } else {
            a.C(i, null, z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g0(Exception exc) {
        C19406qI3.b("CallHelper", "doInitiateCall error on getUser: " + exc.getMessage());
    }

    private final int w() {
        if (!C5505Jq.H()) {
            return 1012;
        }
        if (C5505Jq.G()) {
            return !C5505Jq.E() ? 1014 : -1;
        }
        return 1020;
    }

    private final int x() {
        if (C5505Jq.H()) {
            return !C5505Jq.G() ? 1019 : -1;
        }
        return 1011;
    }

    private final Intent y(String str) {
        Intent intent = new Intent(C5721Ko.a.d(), (Class<?>) VideoCallService.class);
        intent.putExtra("switch_type", EnumC13941h47.a);
        intent.setAction(str);
        return intent;
    }

    private final void z(long j) {
        AbstractC5969Lp4.d().Y().X().H(j, K04.CallDiscardReason_BUSY);
    }

    public final void A() {
        if (!AbstractC5969Lp4.d().w0(EnumC4196Ec1.C0)) {
            T(y("decline_from_activity"));
        } else if (((C17448mz0) C18039nz0.a.d().getValue()).m()) {
            T(y("ACTION_DECLINE_GROUP"));
        } else {
            T(y("decline_from_activity"));
        }
    }

    public final void B() {
        C19406qI3.a("CallHelper", "CallHelper disconnectCall", new Object[0]);
        T(y("disconnect_call"));
    }

    public final void J(C11458d25 c11458d25) {
        AbstractC13042fc3.i(c11458d25, "peer");
        AbstractC5969Lp4.d().Y().X().L(c11458d25);
    }

    public final void K(final MeetStruct$GroupCall meetStruct$GroupCall, final boolean z, final boolean z2) {
        AbstractC13042fc3.i(meetStruct$GroupCall, "protoCall");
        C10263bM2 c10263bM2 = C10263bM2.a;
        E84 e84G = AbstractC5969Lp4.d().o2().G();
        AbstractC13042fc3.h(e84G, "getMessagesModule(...)");
        c10263bM2.e(e84G, meetStruct$GroupCall, new InterfaceC14603iB2() { // from class: ir.nasim.qv0
            @Override // ir.nasim.InterfaceC14603iB2
            public final Object invoke(Object obj, Object obj2) {
                return C20384rv0.M(z, z2, meetStruct$GroupCall, ((Boolean) obj).booleanValue(), ((Boolean) obj2).booleanValue());
            }
        });
    }

    public final void N(Intent intent) {
        AbstractC13042fc3.i(intent, "intent");
        String action = intent.getAction();
        if (action != null) {
            C20384rv0 c20384rv0 = a;
            c20384rv0.T(c20384rv0.y(action));
        }
    }

    public final void O(int i, long j, int i2) {
        if (((C17448mz0) C18039nz0.a.d().getValue()).l()) {
            return;
        }
        boolean z = AbstractC5969Lp4.f() == i2;
        Intent intentY = y("ACTION_JOIN_GROUP_CALL");
        intentY.putExtras(AbstractC23348wm0.b(AbstractC4616Fw7.a("switch_type", EnumC13941h47.a), AbstractC4616Fw7.a("CALL_GROUP_ID_INT", Integer.valueOf(i)), AbstractC4616Fw7.a("call_id", Long.valueOf(j)), AbstractC4616Fw7.a("AM_I_INITIATOR_GROUP_CALL", Boolean.valueOf(z))));
        X(this, intentY, true, false, 4, null);
    }

    public final void P(long j) {
        Intent intentY = y("outgoing_accepted");
        intentY.putExtra("call_id", j);
        T(intentY);
    }

    public final void Q(String str) {
        AbstractC13042fc3.i(str, "grantedPermission");
        Intent intentY = y("permission_granted");
        intentY.putExtra("extra_granted_permission", str);
        T(intentY);
    }

    public final void R(ExPeer exPeer, EnumC21689ty0 enumC21689ty0) {
        AbstractC13042fc3.i(exPeer, "sender");
        AbstractC13042fc3.i(enumC21689ty0, "reactionType");
        int i = a.a[enumC21689ty0.ordinal()];
        if (i != 1) {
            if (i != 2) {
                throw new NoWhenBranchMatchedException();
            }
        } else {
            Intent intentY = y("ACTION_HANDLE_RECEIVED_REACTION");
            intentY.putExtra("CALL_REACTION_PEER_ID_INT", exPeer.getPeerId());
            T(intentY);
        }
    }

    public final void S() {
        C19406qI3.a("CallHelper", "retrying previous call", new Object[0]);
        if (AbstractC13042fc3.d(((C17448mz0) C18039nz0.a.d().getValue()).f(), new AbstractC7031Pz0.i(false, 1, null))) {
            Intent intentY = y("retry_video_call");
            intentY.putExtra("switch_type", EnumC13941h47.a);
            T(intentY);
        } else {
            Intent intentY2 = y("retry");
            intentY2.putExtra("switch_type", EnumC13941h47.a);
            T(intentY2);
        }
    }

    public final void U(long j) {
        AbstractC5969Lp4.d().Y().X().V(j);
    }

    public final void V() {
        T(y("ACTION_SEND_LIKE_REACTION"));
    }

    @Override // ir.nasim.InterfaceC5110Hy0
    public void a(boolean z, long j) {
        String str = "accept_video_from_activity";
        String str2 = "accept_voice_from_activity";
        if (!AbstractC5969Lp4.d().w0(EnumC4196Ec1.C0)) {
            if (z) {
                str = AbstractC13042fc3.d(((C17448mz0) C18039nz0.a.d().getValue()).f(), AbstractC7031Pz0.e.b) ? "answer_voice_call" : "answer_video_call";
            } else if (AbstractC13042fc3.d(((C17448mz0) C18039nz0.a.d().getValue()).f(), AbstractC7031Pz0.e.b)) {
                str = "accept_voice_from_activity";
            }
            T(y(str));
            return;
        }
        if (z) {
            AbstractC7031Pz0 abstractC7031Pz0F = ((C17448mz0) C18039nz0.a.d().getValue()).f();
            if (AbstractC13042fc3.d(abstractC7031Pz0F, AbstractC7031Pz0.e.b)) {
                str = "answer_voice_call";
            } else if (AbstractC13042fc3.d(abstractC7031Pz0F, AbstractC7031Pz0.c.b)) {
                str = "answer_video_call";
            } else {
                str2 = "ACTION_JOIN_VOICE_CALL";
                if (!(abstractC7031Pz0F instanceof AbstractC7031Pz0.b) && !(abstractC7031Pz0F instanceof AbstractC7031Pz0.d)) {
                    throw new IllegalStateException("acceptIncomingCall not Support this call type");
                }
                str = str2;
            }
        } else {
            AbstractC7031Pz0 abstractC7031Pz0F2 = ((C17448mz0) C18039nz0.a.d().getValue()).f();
            if (AbstractC13042fc3.d(abstractC7031Pz0F2, AbstractC7031Pz0.e.b)) {
                str = str2;
            } else if (!AbstractC13042fc3.d(abstractC7031Pz0F2, AbstractC7031Pz0.c.b)) {
                str2 = "ACTION_JOIN_VOICE_CALL_FROM_ACTIVITY";
                if (!(abstractC7031Pz0F2 instanceof AbstractC7031Pz0.b) && !(abstractC7031Pz0F2 instanceof AbstractC7031Pz0.d)) {
                    throw new IllegalStateException("acceptIncomingCall not Support this call type");
                }
                str = str2;
            }
        }
        T(y(str));
    }

    @Override // ir.nasim.InterfaceC5110Hy0
    public void b(List list) {
        AbstractC13042fc3.i(list, "list");
        throw new IllegalStateException("this state is not valid");
    }

    @Override // ir.nasim.InterfaceC5110Hy0
    public void d(EnumC12029dv0 enumC12029dv0, int i) {
        Intent intentY = y("call_discarded");
        if (enumC12029dv0 != null) {
            intentY.putExtra("discard_reason", enumC12029dv0);
        }
        intentY.putExtra("call_duration", i);
        T(intentY);
    }

    @Override // ir.nasim.InterfaceC5110Hy0
    public void e() {
        T(y("stop_incoming_ringtone"));
    }

    @Override // ir.nasim.InterfaceC5110Hy0
    public void f() {
        throw new IllegalStateException("this state is not valid");
    }

    @Override // ir.nasim.InterfaceC5110Hy0
    public void g(InterfaceC9449Zz0 interfaceC9449Zz0) {
        AbstractC13042fc3.i(interfaceC9449Zz0, "callUpdate");
        throw new IllegalStateException("this state is not valid");
    }

    @Override // ir.nasim.InterfaceC5110Hy0
    public void h(final int i, final MeetStruct$Call meetStruct$Call, final boolean z) {
        AbstractC13042fc3.i(meetStruct$Call, "protoCall");
        AbstractC20507s76.z(new Runnable() { // from class: ir.nasim.pv0
            @Override // java.lang.Runnable
            public final void run() {
                C20384rv0.Y(i, meetStruct$Call, z);
            }
        });
    }

    public final void h0(int i, long j, boolean z) {
        E(i, j, null, z);
    }

    @Override // ir.nasim.InterfaceC5110Hy0
    public void i(MeetStruct$GroupCall meetStruct$GroupCall) {
        AbstractC13042fc3.i(meetStruct$GroupCall, "call");
        throw new IllegalStateException("this state is not valid");
    }

    public final void i0(List list) {
        AbstractC13042fc3.i(list, "peersId");
        H(list);
    }

    public final void j0() {
        T(y("toggle_microphone"));
    }

    public final void t() {
        T(y("activity_resumed"));
    }

    public final void u() {
        T(y("activity_stop"));
    }

    public final void v() {
        T(y("change_camera"));
    }
}
