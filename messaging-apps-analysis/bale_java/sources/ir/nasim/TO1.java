package ir.nasim;

import ai.bale.proto.SetRpcStruct$ComposedRpc;
import android.content.Context;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import ir.nasim.AbstractC12888fL4;
import ir.nasim.AbstractC23684xL1;
import ir.nasim.GO1;
import ir.nasim.InterfaceC14139hQ1;
import ir.nasim.InterfaceC18834pK4;
import ir.nasim.InterfaceC20625sK4;
import ir.nasim.core.model.webapp.WebAppArguments;
import ir.nasim.core.model.webapp.WebAppType;
import ir.nasim.core.modules.profile.entity.ExPeerType;
import ir.nasim.dialoglist.data.model.DialogDTO;
import ir.nasim.features.audioplayer.ui.AudioPlayBar;
import ir.nasim.features.audioplayer.ui.playlist.PlayListBottomSheet;
import ir.nasim.features.call.ui.CallActivity;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.NoWhenBranchMatchedException;
import livekit.org.webrtc.MediaStreamTrack;

/* loaded from: classes5.dex */
public final class TO1 implements KO1, AudioPlayBar.a {
    private final JN1 a;
    private final C6243Mu0 b;
    private final int c;
    private final GO1 d;
    private final DK4 e;
    private final InterfaceC7565Sg3 f;
    private final InterfaceC24798zD3 g;
    private final InterfaceC16935m68 h;
    private final LD3 i;
    private final C10299bQ2 j;
    private final InterfaceC11677dQ0 k;
    private final WeakReference l;
    private final InterfaceC14603iB2 m;
    private final UA2 n;
    private final InterfaceC14603iB2 o;
    private final UA2 p;
    private final InterfaceC14603iB2 q;
    private final SA2 r;
    private final UA2 s;
    private final UA2 t;
    private final InterfaceC14603iB2 u;
    private final UA2 v;

    public interface a {
        TO1 a(C22042ua0 c22042ua0, JN1 jn1, C6243Mu0 c6243Mu0, int i);
    }

    public /* synthetic */ class b {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[EnumC18228oI7.values().length];
            try {
                iArr[EnumC18228oI7.b.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[EnumC18228oI7.c.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[EnumC18228oI7.d.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[EnumC18228oI7.a.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            a = iArr;
        }
    }

    /* synthetic */ class c extends EB2 implements InterfaceC14603iB2 {
        c(Object obj) {
            super(2, obj, JN1.class, "addToFolder", "addToFolder(Ljava/lang/Integer;Ljava/lang/String;)V", 0);
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            y((Integer) obj, (String) obj2);
            return C19938rB7.a;
        }

        public final void y(Integer num, String str) {
            ((JN1) this.receiver).A0(num, str);
        }
    }

    /* synthetic */ class d extends EB2 implements UA2 {
        d(Object obj) {
            super(1, obj, JN1.class, "toggleAudioPlayerPlayback", "toggleAudioPlayerPlayback(Lir/nasim/components/audiobar/AudioBarPlaybackState;)V", 0);
        }

        @Override // ir.nasim.UA2
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            y((AbstractC20029rM) obj);
            return C19938rB7.a;
        }

        public final void y(AbstractC20029rM abstractC20029rM) {
            AbstractC13042fc3.i(abstractC20029rM, "p0");
            ((JN1) this.receiver).r(abstractC20029rM);
        }
    }

    /* synthetic */ class e extends EB2 implements UA2 {
        e(Object obj) {
            super(1, obj, JN1.class, "toggleAudioPlayerSpeed", "toggleAudioPlayerSpeed(Lir/nasim/components/audiobar/AudioBarSpeed;)V", 0);
        }

        @Override // ir.nasim.UA2
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            y((EnumC21241tM) obj);
            return C19938rB7.a;
        }

        public final void y(EnumC21241tM enumC21241tM) {
            AbstractC13042fc3.i(enumC21241tM, "p0");
            ((JN1) this.receiver).k(enumC21241tM);
        }
    }

    /* synthetic */ class f extends EB2 implements SA2 {
        f(Object obj) {
            super(0, obj, JN1.class, "stopAudioPlayer", "stopAudioPlayer()V", 0);
        }

        @Override // ir.nasim.SA2
        public /* bridge */ /* synthetic */ Object invoke() {
            y();
            return C19938rB7.a;
        }

        public final void y() {
            ((JN1) this.receiver).v0();
        }
    }

    static final class g extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ DialogDTO d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        g(DialogDTO dialogDTO, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = dialogDTO;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return TO1.this.new g(this.d, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objD;
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                C6517Nv5 c6517Nv5K = TO1.this.j.Y1().k(C11458d25.r(this.d.getPeerUniqueId()).getPeerId());
                AbstractC13042fc3.h(c6517Nv5K, "get(...)");
                this.b = 1;
                objD = AbstractC6756Ov5.d(c6517Nv5K, null, this, 1, null);
                if (objD == objE) {
                    return objE;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
                objD = ((C9475a16) obj).l();
            }
            if (C9475a16.g(objD)) {
                objD = null;
            }
            TO1 to1 = TO1.this;
            DialogDTO dialogDTO = this.d;
            C14733iO2 c14733iO2 = (C14733iO2) objD;
            if (c14733iO2 != null) {
                boolean z = (c14733iO2.f() == null || ((Boolean) c14733iO2.f().b()).booleanValue()) && GM2.b(c14733iO2, false, 2, null);
                JN1 jn1 = to1.a;
                C11458d25 c11458d25R = C11458d25.r(dialogDTO.getPeerUniqueId());
                AbstractC13042fc3.h(c11458d25R, "fromUniqueId(...)");
                jn1.G0(new C7960Tx6(c11458d25R, dialogDTO.getUserName(), z, dialogDTO.getExPeerType()));
            }
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((g) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* synthetic */ class h extends EB2 implements InterfaceC14603iB2 {
        h(Object obj) {
            super(2, obj, JN1.class, "updateVisibleItems", "updateVisibleItems(ILjava/util/List;)V", 0);
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            y(((Number) obj).intValue(), (List) obj2);
            return C19938rB7.a;
        }

        public final void y(int i, List list) {
            AbstractC13042fc3.i(list, "p1");
            ((JN1) this.receiver).C0(i, list);
        }
    }

    /* synthetic */ class i extends EB2 implements InterfaceC14603iB2 {
        i(Object obj) {
            super(2, obj, JN1.class, "toggleSelection", "toggleSelection(Lir/nasim/dialoglist/data/model/DialogDTO;I)V", 0);
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            y((DialogDTO) obj, ((Number) obj2).intValue());
            return C19938rB7.a;
        }

        public final void y(DialogDTO dialogDTO, int i) {
            AbstractC13042fc3.i(dialogDTO, "p0");
            ((JN1) this.receiver).j0(dialogDTO, i);
        }
    }

    public TO1(C22042ua0 c22042ua0, JN1 jn1, C6243Mu0 c6243Mu0, int i2, GO1 go1, DK4 dk4, InterfaceC7565Sg3 interfaceC7565Sg3, InterfaceC24798zD3 interfaceC24798zD3, InterfaceC16935m68 interfaceC16935m68, LD3 ld3, C10299bQ2 c10299bQ2, InterfaceC11677dQ0 interfaceC11677dQ0) {
        AbstractC13042fc3.i(c22042ua0, "fragment");
        AbstractC13042fc3.i(jn1, "dialogListActionBridge");
        AbstractC13042fc3.i(c6243Mu0, "callBarViewModel");
        AbstractC13042fc3.i(go1, "dialogListTopSpotStateManager");
        AbstractC13042fc3.i(dk4, "onboardingNavigator");
        AbstractC13042fc3.i(interfaceC7565Sg3, "jaryanNavigator");
        AbstractC13042fc3.i(interfaceC24798zD3, "liveNavigator");
        AbstractC13042fc3.i(interfaceC16935m68, "webAppNavigator");
        AbstractC13042fc3.i(ld3, "liveStreamRepository");
        AbstractC13042fc3.i(c10299bQ2, "groupModule");
        AbstractC13042fc3.i(interfaceC11677dQ0, "chatNavigator");
        this.a = jn1;
        this.b = c6243Mu0;
        this.c = i2;
        this.d = go1;
        this.e = dk4;
        this.f = interfaceC7565Sg3;
        this.g = interfaceC24798zD3;
        this.h = interfaceC16935m68;
        this.i = ld3;
        this.j = c10299bQ2;
        this.k = interfaceC11677dQ0;
        this.l = new WeakReference(c22042ua0);
        this.m = new i(jn1);
        this.n = new UA2() { // from class: ir.nasim.MO1
            @Override // ir.nasim.UA2
            public final Object invoke(Object obj) {
                return TO1.C(this.a, (DialogDTO) obj);
            }
        };
        this.o = new InterfaceC14603iB2() { // from class: ir.nasim.NO1
            @Override // ir.nasim.InterfaceC14603iB2
            public final Object invoke(Object obj, Object obj2) {
                return TO1.B(this.a, (DialogDTO) obj, (EnumC18228oI7) obj2);
            }
        };
        this.p = new UA2() { // from class: ir.nasim.OO1
            @Override // ir.nasim.UA2
            public final Object invoke(Object obj) {
                return TO1.E((EnumC15954kS7) obj);
            }
        };
        this.q = new h(jn1);
        this.r = new SA2() { // from class: ir.nasim.PO1
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return TO1.A(this.a);
            }
        };
        this.s = new UA2() { // from class: ir.nasim.QO1
            @Override // ir.nasim.UA2
            public final Object invoke(Object obj) {
                return TO1.D(this.a, ((Long) obj).longValue());
            }
        };
        this.t = new UA2() { // from class: ir.nasim.RO1
            @Override // ir.nasim.UA2
            public final Object invoke(Object obj) {
                return TO1.z(this.a, (GO1.a) obj);
            }
        };
        this.u = new c(jn1);
        this.v = new UA2() { // from class: ir.nasim.SO1
            @Override // ir.nasim.UA2
            public final Object invoke(Object obj) {
                return TO1.F(this.a, ((Integer) obj).intValue());
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 A(TO1 to1) {
        AbstractC13042fc3.i(to1, "this$0");
        C22042ua0 c22042ua0 = (C22042ua0) to1.l.get();
        if (c22042ua0 != null) {
            Context contextS7 = c22042ua0.S7();
            AbstractC13042fc3.h(contextS7, "requireContext(...)");
            contextS7.startActivity(CallActivity.INSTANCE.a(contextS7));
        }
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 B(TO1 to1, DialogDTO dialogDTO, EnumC18228oI7 enumC18228oI7) {
        Context contextG5;
        AbstractC13042fc3.i(to1, "this$0");
        AbstractC13042fc3.i(dialogDTO, "dialog");
        AbstractC13042fc3.i(enumC18228oI7, "userActivityState");
        if (to1.a.Z().getValue() instanceof InterfaceC14139hQ1.b) {
            to1.a.j0(dialogDTO, to1.c);
            return C19938rB7.a;
        }
        int i2 = b.a[enumC18228oI7.ordinal()];
        if (i2 == -1) {
            to1.h().invoke(dialogDTO);
        } else if (i2 == 1) {
            I(to1, dialogDTO.getPeerUniqueId(), null, 2, null);
        } else if (i2 == 2 || i2 == 3) {
            C22042ua0 c22042ua0 = (C22042ua0) to1.l.get();
            if (c22042ua0 != null) {
                C22042ua0.A9(c22042ua0, to1.f.h(C11458d25.r(dialogDTO.getPeerUniqueId()).getPeerId(), new ArrayList()), false, null, 6, null);
            }
        } else {
            if (i2 != 4) {
                throw new NoWhenBranchMatchedException();
            }
            if (!C8386Vt0.w7()) {
                return C19938rB7.a;
            }
            FD3 fd3 = (FD3) ((Map) to1.i.m().getValue()).get(Long.valueOf(dialogDTO.getPeerUniqueId()));
            if (fd3 == null) {
                return C19938rB7.a;
            }
            C22042ua0 c22042ua02 = (C22042ua0) to1.l.get();
            if (c22042ua02 == null || (contextG5 = c22042ua02.G5()) == null) {
                return C19938rB7.a;
            }
            contextG5.startActivity(to1.g.b(contextG5, fd3.a(), AbstractC12888fL4.d.b));
        }
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 C(TO1 to1, DialogDTO dialogDTO) {
        AbstractC13042fc3.i(to1, "this$0");
        AbstractC13042fc3.i(dialogDTO, "dialog");
        if (to1.a.Z().getValue() instanceof InterfaceC14139hQ1.b) {
            to1.a.j0(dialogDTO, to1.c);
        } else if (!(to1.a.Z().getValue() instanceof InterfaceC14139hQ1.c)) {
            to1.H(dialogDTO.getPeerUniqueId(), dialogDTO.getExPeerType());
        } else if (dialogDTO.getExPeerType() == ExPeerType.PRIVATE || dialogDTO.getExPeerType() == ExPeerType.BOT) {
            JN1 jn1 = to1.a;
            C11458d25 c11458d25R = C11458d25.r(dialogDTO.getPeerUniqueId());
            AbstractC13042fc3.h(c11458d25R, "fromUniqueId(...)");
            jn1.G0(new C7960Tx6(c11458d25R, dialogDTO.getUserName(), true, dialogDTO.getExPeerType()));
        } else {
            AbstractC10533bm0.d(to1.a.z(), null, null, to1.new g(dialogDTO, null), 3, null);
        }
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 D(TO1 to1, long j) {
        AbstractC13042fc3.i(to1, "this$0");
        to1.b.Y0(j);
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 E(EnumC15954kS7 enumC15954kS7) {
        AbstractC13042fc3.i(enumC15954kS7, "it");
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 F(TO1 to1, int i2) {
        AbstractC13042fc3.i(to1, "this$0");
        C22042ua0 c22042ua0 = (C22042ua0) to1.l.get();
        if (c22042ua0 != null) {
            C22042ua0.w9(c22042ua0, to1.h.a(new WebAppArguments(i2, new WebAppType.Main(null), H48.d, AbstractC17026mG5.a.f(), null, null, null, false, SetRpcStruct$ComposedRpc.RESPONSE_STICKERS_REPONSE_FIELD_NUMBER, null)), false, null, 6, null);
        }
        return C19938rB7.a;
    }

    private final void G(VL vl) {
        FragmentActivity fragmentActivityQ7;
        C22042ua0 c22042ua0 = (C22042ua0) this.l.get();
        if (c22042ua0 == null || (fragmentActivityQ7 = c22042ua0.Q7()) == null) {
            return;
        }
        PlayListBottomSheet playListBottomSheet = new PlayListBottomSheet(vl.d().e(), vl.d().d());
        playListBottomSheet.A9(this);
        playListBottomSheet.K8(fragmentActivityQ7.B0(), playListBottomSheet.j6());
    }

    private final void H(long j, ExPeerType exPeerType) {
        C19938rB7 c19938rB7;
        c().invoke(new GO1.a.C0389a(AbstractC23684xL1.b.b));
        if (exPeerType != null) {
            InterfaceC11677dQ0 interfaceC11677dQ0 = this.k;
            C11458d25 c11458d25R = C11458d25.r(j);
            AbstractC13042fc3.h(c11458d25R, "fromUniqueId(...)");
            Fragment fragmentB = InterfaceC11677dQ0.b(interfaceC11677dQ0, c11458d25R, exPeerType, null, null, false, null, null, null, null, 0L, null, null, null, false, null, null, null, null, null, false, null, null, null, null, null, true, null, 100663292, null);
            if (fragmentB != null) {
                C22042ua0 c22042ua0 = (C22042ua0) this.l.get();
                if (c22042ua0 != null) {
                    C22042ua0.A9(c22042ua0, fragmentB, false, null, 6, null);
                    c19938rB7 = C19938rB7.a;
                } else {
                    c19938rB7 = null;
                }
                if (c19938rB7 != null) {
                    return;
                }
            }
        }
        C18987pb3 c18987pb3 = C18987pb3.a;
        C11458d25 c11458d25R2 = C11458d25.r(j);
        AbstractC13042fc3.h(c11458d25R2, "fromUniqueId(...)");
        C18987pb3.x1(c18987pb3, c11458d25R2, null, null, false, null, null, false, null, null, true, null, 1534, null);
    }

    static /* synthetic */ void I(TO1 to1, long j, ExPeerType exPeerType, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            exPeerType = null;
        }
        to1.H(j, exPeerType);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 v(TO1 to1, VL vl) {
        AbstractC13042fc3.i(to1, "this$0");
        AbstractC13042fc3.i(vl, "it");
        AudioPlayBar.a.U3(to1, vl, false, 2, null);
        return C19938rB7.a;
    }

    private final void y(T74 t74) {
        C18987pb3.x1(C18987pb3.a, t74.e(), Long.valueOf(t74.f()), Long.valueOf(t74.d()), true, null, null, false, null, null, false, null, 2032, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 z(TO1 to1, GO1.a aVar) {
        AbstractC13042fc3.i(to1, "this$0");
        AbstractC13042fc3.i(aVar, "action");
        to1.d.c(aVar);
        if (aVar instanceof GO1.a.b) {
            InterfaceC18834pK4 interfaceC18834pK4A = ((GO1.a.b) aVar).a();
            InterfaceC18834pK4.a aVar2 = interfaceC18834pK4A instanceof InterfaceC18834pK4.a ? (InterfaceC18834pK4.a) interfaceC18834pK4A : null;
            InterfaceC20625sK4 interfaceC20625sK4B = ((GO1.b) to1.d.b().getValue()).b();
            InterfaceC20625sK4.b bVar = interfaceC20625sK4B instanceof InterfaceC20625sK4.b ? (InterfaceC20625sK4.b) interfaceC20625sK4B : null;
            if (aVar2 != null && bVar != null) {
                if (bVar.e() == 5) {
                    C22042ua0 c22042ua0 = (C22042ua0) to1.l.get();
                    if (c22042ua0 != null) {
                        C22042ua0.A9(c22042ua0, to1.e.b(bVar.e()), false, null, 6, null);
                    }
                } else {
                    C22042ua0 c22042ua02 = (C22042ua0) to1.l.get();
                    if (c22042ua02 != null) {
                        C22042ua0.A9(c22042ua02, to1.e.f(bVar.e()), false, null, 6, null);
                    }
                }
            }
        }
        return C19938rB7.a;
    }

    @Override // ir.nasim.KO1
    public InterfaceC14603iB2 b() {
        return this.u;
    }

    @Override // ir.nasim.KO1
    public UA2 c() {
        return this.t;
    }

    @Override // ir.nasim.KO1
    public SA2 d() {
        return this.r;
    }

    @Override // ir.nasim.KO1
    public UA2 e() {
        return this.v;
    }

    @Override // ir.nasim.KO1
    public UA2 f() {
        return new d(this.a);
    }

    @Override // ir.nasim.KO1
    public SA2 g() {
        return new f(this.a);
    }

    @Override // ir.nasim.features.audioplayer.ui.AudioPlayBar.a
    public void g2(VL vl, boolean z) {
        AbstractC13042fc3.i(vl, MediaStreamTrack.AUDIO_TRACK_KIND);
        if ((vl instanceof QZ7) || z) {
            y(vl.d());
        } else if (vl instanceof C8552Wl4) {
            G(vl);
        }
    }

    @Override // ir.nasim.KO1
    public UA2 h() {
        return this.n;
    }

    @Override // ir.nasim.KO1
    public UA2 i() {
        return this.s;
    }

    @Override // ir.nasim.KO1
    public UA2 j() {
        return new UA2() { // from class: ir.nasim.LO1
            @Override // ir.nasim.UA2
            public final Object invoke(Object obj) {
                return TO1.v(this.a, (VL) obj);
            }
        };
    }

    @Override // ir.nasim.KO1
    public UA2 k() {
        return new e(this.a);
    }

    @Override // ir.nasim.KO1
    public InterfaceC14603iB2 l() {
        return this.q;
    }

    @Override // ir.nasim.KO1
    public InterfaceC14603iB2 m() {
        return this.m;
    }

    @Override // ir.nasim.KO1
    public InterfaceC14603iB2 n() {
        return this.o;
    }
}
