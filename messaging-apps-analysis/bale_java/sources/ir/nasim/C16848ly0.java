package ir.nasim;

import ai.bale.proto.SetRpcStruct$ComposedRpc;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.compose.ui.platform.ComposeView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.G;
import ir.nasim.AbstractC20375ru1;
import ir.nasim.C21753u45;
import ir.nasim.features.call.ui.startOutGoingCall.StartOutGoingCallPeerData;
import java.io.Serializable;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\t\b\u0007\u0018\u0000 G2\u00020\u0001:\u0001HB\t\b\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0019\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0019\u0010\t\u001a\u00020\u00062\b\b\u0002\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\t\u0010\bJ\u0019\u0010\f\u001a\u00020\u00062\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0002¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000e\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u000e\u0010\u0003J\u000f\u0010\u000f\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u000f\u0010\u0003J\u000f\u0010\u0010\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0010\u0010\u0003J\u000f\u0010\u0011\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0011\u0010\u0003J\u000f\u0010\u0012\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0012\u0010\u0003J\u000f\u0010\u0013\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0013\u0010\u0003J\u0017\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0015\u0010\bJ\u000f\u0010\u0017\u001a\u00020\u0016H\u0002¢\u0006\u0004\b\u0017\u0010\u0018J!\u0010\u001c\u001a\u00020\u00062\b\u0010\u001a\u001a\u0004\u0018\u00010\u00192\u0006\u0010\u001b\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u001c\u0010\u001dJ\u0017\u0010 \u001a\u00020\u00062\u0006\u0010\u001f\u001a\u00020\u001eH\u0002¢\u0006\u0004\b \u0010!J\u000f\u0010\"\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\"\u0010#J\u000f\u0010$\u001a\u00020\u0004H\u0002¢\u0006\u0004\b$\u0010#J\u000f\u0010%\u001a\u00020\u0004H\u0002¢\u0006\u0004\b%\u0010#J+\u0010,\u001a\u00020+2\u0006\u0010'\u001a\u00020&2\b\u0010)\u001a\u0004\u0018\u00010(2\b\u0010*\u001a\u0004\u0018\u00010\u001eH\u0016¢\u0006\u0004\b,\u0010-J!\u00100\u001a\u00020\u00062\u0006\u0010/\u001a\u00020.2\b\u0010*\u001a\u0004\u0018\u00010\u001eH\u0016¢\u0006\u0004\b0\u00101J\u000f\u00102\u001a\u00020\u0006H\u0016¢\u0006\u0004\b2\u0010\u0003R\u001b\u00108\u001a\u0002038BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b4\u00105\u001a\u0004\b6\u00107R\u001b\u0010>\u001a\u0002098BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b:\u0010;\u001a\u0004\b<\u0010=R\"\u0010D\u001a\u0010\u0012\f\u0012\n A*\u0004\u0018\u00010@0@0?8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bB\u0010CR\"\u0010F\u001a\u0010\u0012\f\u0012\n A*\u0004\u0018\u00010@0@0?8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bE\u0010C¨\u0006I"}, d2 = {"Lir/nasim/ly0;", "Lir/nasim/ua0;", "<init>", "()V", "", "showSnackBar", "Lir/nasim/rB7;", "Aa", "(Z)V", "ya", "", "callId", "na", "(Ljava/lang/Long;)V", "ua", "ra", "ta", "ga", "oa", "pa", "showFrontCamera", "xa", "Lir/nasim/gj3;", "ea", "()Lir/nasim/gj3;", "Lir/nasim/features/call/ui/startOutGoingCall/StartOutGoingCallPeerData;", "startOutGoingCallPeerData", "isVideoCall", "wa", "(Lir/nasim/features/call/ui/startOutGoingCall/StartOutGoingCallPeerData;Z)V", "Landroid/os/Bundle;", "arguments", "ma", "(Landroid/os/Bundle;)V", "ka", "()Z", "la", "ja", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "savedInstanceState", "Landroidx/compose/ui/platform/ComposeView;", "qa", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroidx/compose/ui/platform/ComposeView;", "Landroid/view/View;", "view", "l7", "(Landroid/view/View;Landroid/os/Bundle;)V", "c7", "Lir/nasim/Cx2;", "h1", "Lir/nasim/bW7;", "ha", "()Lir/nasim/Cx2;", "binding", "Lir/nasim/qy0;", "i1", "Lir/nasim/Yu3;", "ia", "()Lir/nasim/qy0;", "viewModel", "Lir/nasim/v6;", "", "kotlin.jvm.PlatformType", "j1", "Lir/nasim/v6;", "audioPermission", "k1", "videoPermission", "l1", "a", "nasim_release"}, k = 1, mv = {2, 0, 0})
/* renamed from: ir.nasim.ly0, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C16848ly0 extends WV2 {

    /* renamed from: h1, reason: from kotlin metadata */
    private final InterfaceC10358bW7 binding = AbstractC6056Lz2.f(this, new d(), AbstractC20046rN7.c());

    /* renamed from: i1, reason: from kotlin metadata */
    private final InterfaceC9173Yu3 viewModel;

    /* renamed from: j1, reason: from kotlin metadata */
    private final AbstractC22357v6 audioPermission;

    /* renamed from: k1, reason: from kotlin metadata */
    private final AbstractC22357v6 videoPermission;
    static final /* synthetic */ InterfaceC5239Im3[] m1 = {AbstractC10882cM5.i(new C25226zw5(C16848ly0.class, "binding", "getBinding()Lir/nasim/databinding/FragmentCallPreviewBinding;", 0))};

    /* renamed from: l1, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int n1 = 8;

    /* renamed from: ir.nasim.ly0$a, reason: from kotlin metadata */
    public static final class Companion {
        private Companion() {
        }

        public final C16848ly0 a(long j, String str, String str2, int i, Long l, boolean z) {
            C16848ly0 c16848ly0 = new C16848ly0();
            c16848ly0.a8(AbstractC23348wm0.b(AbstractC4616Fw7.a("BUNDLE_PREVIEW_MODE_EXTRA", EnumC18030ny0.a), AbstractC4616Fw7.a("BUNDLE_CALL_ID_EXTRA", Long.valueOf(j)), AbstractC4616Fw7.a("BUNDLE_CALL_TITLE_EXTRA", str), AbstractC4616Fw7.a("BUNDLE_INITIATOR_USER_ID_EXTRA", Integer.valueOf(i)), AbstractC4616Fw7.a("BUNDLE_CALL_LINK_EXTRA", str2), AbstractC4616Fw7.a("BUNDLE_CALL_LINK_START_TIME_EXTRA", l), AbstractC4616Fw7.a("BUNDLE_IS_PRIVATE_CALL_EXTRA", Boolean.valueOf(z))));
            return c16848ly0;
        }

        public final C16848ly0 c(StartOutGoingCallPeerData startOutGoingCallPeerData, String str, boolean z) {
            AbstractC13042fc3.i(startOutGoingCallPeerData, "startOutGoingCallPeerData");
            AbstractC13042fc3.i(str, "peerName");
            C16848ly0 c16848ly0 = new C16848ly0();
            c16848ly0.a8(AbstractC23348wm0.b(AbstractC4616Fw7.a("BUNDLE_PREVIEW_MODE_EXTRA", EnumC18030ny0.b), AbstractC4616Fw7.a("BUNDLE_START_OUT_GOING_CALL_PEER_DATA_EXTRA", startOutGoingCallPeerData), AbstractC4616Fw7.a("BUNDLE_PEER_NAME_EXTRA", str), AbstractC4616Fw7.a("BUNDLE_IS_VIDEO_CALL_EXTRA", Boolean.valueOf(z))));
            return c16848ly0;
        }

        public /* synthetic */ Companion(ED1 ed1) {
            this();
        }
    }

    /* renamed from: ir.nasim.ly0$b */
    public /* synthetic */ class b {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[EnumC18030ny0.values().length];
            try {
                iArr[EnumC18030ny0.a.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[EnumC18030ny0.b.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            a = iArr;
        }
    }

    /* renamed from: ir.nasim.ly0$c */
    static final class c implements InterfaceC14603iB2 {

        /* renamed from: ir.nasim.ly0$c$a */
        static final class a implements InterfaceC14603iB2 {
            final /* synthetic */ C16848ly0 a;

            /* renamed from: ir.nasim.ly0$c$a$a, reason: collision with other inner class name */
            /* synthetic */ class C1391a extends EB2 implements SA2 {
                C1391a(Object obj) {
                    super(0, obj, C16848ly0.class, "closeBottomSheet", "closeBottomSheet()V", 0);
                }

                @Override // ir.nasim.SA2
                public /* bridge */ /* synthetic */ Object invoke() {
                    y();
                    return C19938rB7.a;
                }

                public final void y() {
                    ((C16848ly0) this.receiver).ga();
                }
            }

            /* renamed from: ir.nasim.ly0$c$a$b */
            /* synthetic */ class b extends EB2 implements SA2 {
                b(Object obj) {
                    super(0, obj, C16848ly0.class, "muteVoice", "muteVoice()V", 0);
                }

                @Override // ir.nasim.SA2
                public /* bridge */ /* synthetic */ Object invoke() {
                    y();
                    return C19938rB7.a;
                }

                public final void y() {
                    ((C16848ly0) this.receiver).pa();
                }
            }

            /* renamed from: ir.nasim.ly0$c$a$c, reason: collision with other inner class name */
            /* synthetic */ class C1392c extends C23553x7 implements SA2 {
                C1392c(Object obj) {
                    super(0, obj, C16848ly0.class, "unMuteVoice", "unMuteVoice(Z)V", 0);
                }

                public final void a() {
                    C16848ly0.Ba((C16848ly0) this.a, false, 1, null);
                }

                @Override // ir.nasim.SA2
                public /* bridge */ /* synthetic */ Object invoke() {
                    a();
                    return C19938rB7.a;
                }
            }

            /* renamed from: ir.nasim.ly0$c$a$d */
            /* synthetic */ class d extends EB2 implements SA2 {
                d(Object obj) {
                    super(0, obj, C16848ly0.class, "muteVideo", "muteVideo()V", 0);
                }

                @Override // ir.nasim.SA2
                public /* bridge */ /* synthetic */ Object invoke() {
                    y();
                    return C19938rB7.a;
                }

                public final void y() {
                    ((C16848ly0) this.receiver).oa();
                }
            }

            /* renamed from: ir.nasim.ly0$c$a$e */
            /* synthetic */ class e extends C23553x7 implements SA2 {
                e(Object obj) {
                    super(0, obj, C16848ly0.class, "unMuteVideo", "unMuteVideo(Z)V", 0);
                }

                public final void a() {
                    C16848ly0.za((C16848ly0) this.a, false, 1, null);
                }

                @Override // ir.nasim.SA2
                public /* bridge */ /* synthetic */ Object invoke() {
                    a();
                    return C19938rB7.a;
                }
            }

            /* renamed from: ir.nasim.ly0$c$a$f */
            /* synthetic */ class f extends EB2 implements UA2 {
                f(Object obj) {
                    super(1, obj, C16848ly0.class, "switchCamera", "switchCamera(Z)V", 0);
                }

                @Override // ir.nasim.UA2
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    y(((Boolean) obj).booleanValue());
                    return C19938rB7.a;
                }

                public final void y(boolean z) {
                    ((C16848ly0) this.receiver).xa(z);
                }
            }

            /* renamed from: ir.nasim.ly0$c$a$g */
            /* synthetic */ class g extends EB2 implements UA2 {
                g(Object obj) {
                    super(1, obj, C16848ly0.class, "joinLinkCall", "joinLinkCall(Ljava/lang/Long;)V", 0);
                }

                @Override // ir.nasim.UA2
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    y((Long) obj);
                    return C19938rB7.a;
                }

                public final void y(Long l) {
                    ((C16848ly0) this.receiver).na(l);
                }
            }

            /* renamed from: ir.nasim.ly0$c$a$h */
            /* synthetic */ class h extends C23553x7 implements SA2 {
                h(Object obj) {
                    super(0, obj, C16848ly0.class, "askToJoinCall", "askToJoinCall()Lkotlinx/coroutines/Job;", 8);
                }

                public final void a() {
                    ((C16848ly0) this.a).ea();
                }

                @Override // ir.nasim.SA2
                public /* bridge */ /* synthetic */ Object invoke() {
                    a();
                    return C19938rB7.a;
                }
            }

            /* renamed from: ir.nasim.ly0$c$a$i */
            /* synthetic */ class i extends EB2 implements InterfaceC14603iB2 {
                i(Object obj) {
                    super(2, obj, C16848ly0.class, "startOutGoingCall", "startOutGoingCall(Lir/nasim/features/call/ui/startOutGoingCall/StartOutGoingCallPeerData;Z)V", 0);
                }

                @Override // ir.nasim.InterfaceC14603iB2
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    y((StartOutGoingCallPeerData) obj, ((Boolean) obj2).booleanValue());
                    return C19938rB7.a;
                }

                public final void y(StartOutGoingCallPeerData startOutGoingCallPeerData, boolean z) {
                    ((C16848ly0) this.receiver).wa(startOutGoingCallPeerData, z);
                }
            }

            a(C16848ly0 c16848ly0) {
                this.a = c16848ly0;
            }

            public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i2) {
                if ((i2 & 3) == 2 && interfaceC22053ub1.k()) {
                    interfaceC22053ub1.L();
                    return;
                }
                InterfaceC10258bL6 interfaceC10258bL6A1 = this.a.ia().a1();
                FragmentActivity fragmentActivityQ7 = this.a.Q7();
                AbstractC13042fc3.h(fragmentActivityQ7, "requireActivity(...)");
                C16848ly0 c16848ly0 = this.a;
                interfaceC22053ub1.W(-1333264914);
                boolean zD = interfaceC22053ub1.D(c16848ly0);
                Object objB = interfaceC22053ub1.B();
                if (zD || objB == InterfaceC22053ub1.a.a()) {
                    objB = new C1391a(c16848ly0);
                    interfaceC22053ub1.s(objB);
                }
                interfaceC22053ub1.Q();
                SA2 sa2 = (SA2) ((InterfaceC16733lm3) objB);
                C16848ly0 c16848ly02 = this.a;
                interfaceC22053ub1.W(-1333262969);
                boolean zD2 = interfaceC22053ub1.D(c16848ly02);
                Object objB2 = interfaceC22053ub1.B();
                if (zD2 || objB2 == InterfaceC22053ub1.a.a()) {
                    objB2 = new b(c16848ly02);
                    interfaceC22053ub1.s(objB2);
                }
                interfaceC22053ub1.Q();
                SA2 sa22 = (SA2) ((InterfaceC16733lm3) objB2);
                C16848ly0 c16848ly03 = this.a;
                interfaceC22053ub1.W(-1333261175);
                boolean zD3 = interfaceC22053ub1.D(c16848ly03);
                Object objB3 = interfaceC22053ub1.B();
                if (zD3 || objB3 == InterfaceC22053ub1.a.a()) {
                    objB3 = new C1392c(c16848ly03);
                    interfaceC22053ub1.s(objB3);
                }
                SA2 sa23 = (SA2) objB3;
                interfaceC22053ub1.Q();
                C16848ly0 c16848ly04 = this.a;
                interfaceC22053ub1.W(-1333259385);
                boolean zD4 = interfaceC22053ub1.D(c16848ly04);
                Object objB4 = interfaceC22053ub1.B();
                if (zD4 || objB4 == InterfaceC22053ub1.a.a()) {
                    objB4 = new d(c16848ly04);
                    interfaceC22053ub1.s(objB4);
                }
                interfaceC22053ub1.Q();
                SA2 sa24 = (SA2) ((InterfaceC16733lm3) objB4);
                C16848ly0 c16848ly05 = this.a;
                interfaceC22053ub1.W(-1333257591);
                boolean zD5 = interfaceC22053ub1.D(c16848ly05);
                Object objB5 = interfaceC22053ub1.B();
                if (zD5 || objB5 == InterfaceC22053ub1.a.a()) {
                    objB5 = new e(c16848ly05);
                    interfaceC22053ub1.s(objB5);
                }
                SA2 sa25 = (SA2) objB5;
                interfaceC22053ub1.Q();
                C16848ly0 c16848ly06 = this.a;
                interfaceC22053ub1.W(-1333255702);
                boolean zD6 = interfaceC22053ub1.D(c16848ly06);
                Object objB6 = interfaceC22053ub1.B();
                if (zD6 || objB6 == InterfaceC22053ub1.a.a()) {
                    objB6 = new f(c16848ly06);
                    interfaceC22053ub1.s(objB6);
                }
                interfaceC22053ub1.Q();
                UA2 ua2 = (UA2) ((InterfaceC16733lm3) objB6);
                C16848ly0 c16848ly07 = this.a;
                interfaceC22053ub1.W(-1333253910);
                boolean zD7 = interfaceC22053ub1.D(c16848ly07);
                Object objB7 = interfaceC22053ub1.B();
                if (zD7 || objB7 == InterfaceC22053ub1.a.a()) {
                    objB7 = new g(c16848ly07);
                    interfaceC22053ub1.s(objB7);
                }
                interfaceC22053ub1.Q();
                UA2 ua22 = (UA2) ((InterfaceC16733lm3) objB7);
                C16848ly0 c16848ly08 = this.a;
                interfaceC22053ub1.W(-1333251957);
                boolean zD8 = interfaceC22053ub1.D(c16848ly08);
                Object objB8 = interfaceC22053ub1.B();
                if (zD8 || objB8 == InterfaceC22053ub1.a.a()) {
                    objB8 = new h(c16848ly08);
                    interfaceC22053ub1.s(objB8);
                }
                SA2 sa26 = (SA2) objB8;
                interfaceC22053ub1.Q();
                C16848ly0 c16848ly09 = this.a;
                interfaceC22053ub1.W(-1333249841);
                boolean zD9 = interfaceC22053ub1.D(c16848ly09);
                Object objB9 = interfaceC22053ub1.B();
                if (zD9 || objB9 == InterfaceC22053ub1.a.a()) {
                    objB9 = new i(c16848ly09);
                    interfaceC22053ub1.s(objB9);
                }
                interfaceC22053ub1.Q();
                AbstractC10034ay0.c(interfaceC10258bL6A1, fragmentActivityQ7, sa2, sa22, sa23, sa24, sa25, ua2, ua22, sa26, (InterfaceC14603iB2) ((InterfaceC16733lm3) objB9), interfaceC22053ub1, 0, 0);
            }

            @Override // ir.nasim.InterfaceC14603iB2
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
                return C19938rB7.a;
            }
        }

        c() {
        }

        public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
            if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                interfaceC22053ub1.L();
            } else {
                M10.f(false, AbstractC19242q11.e(-361339250, true, new a(C16848ly0.this), interfaceC22053ub1, 54), interfaceC22053ub1, 48, 1);
            }
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.ly0$d */
    public static final class d extends AbstractC8614Ws3 implements UA2 {
        public d() {
            super(1);
        }

        @Override // ir.nasim.UA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final InterfaceC9764aW7 invoke(Fragment fragment) {
            AbstractC13042fc3.i(fragment, "fragment");
            return C3918Cx2.a(fragment.V7());
        }
    }

    /* renamed from: ir.nasim.ly0$e */
    public static final class e extends AbstractC8614Ws3 implements SA2 {
        final /* synthetic */ Fragment e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(Fragment fragment) {
            super(0);
            this.e = fragment;
        }

        @Override // ir.nasim.SA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Fragment invoke() {
            return this.e;
        }
    }

    /* renamed from: ir.nasim.ly0$f */
    public static final class f extends AbstractC8614Ws3 implements SA2 {
        final /* synthetic */ SA2 e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(SA2 sa2) {
            super(0);
            this.e = sa2;
        }

        @Override // ir.nasim.SA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final InterfaceC15408jX7 invoke() {
            return (InterfaceC15408jX7) this.e.invoke();
        }
    }

    /* renamed from: ir.nasim.ly0$g */
    public static final class g extends AbstractC8614Ws3 implements SA2 {
        final /* synthetic */ InterfaceC9173Yu3 e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public g(InterfaceC9173Yu3 interfaceC9173Yu3) {
            super(0);
            this.e = interfaceC9173Yu3;
        }

        @Override // ir.nasim.SA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final C14819iX7 invoke() {
            return AbstractC6550Nz2.c(this.e).d1();
        }
    }

    /* renamed from: ir.nasim.ly0$h */
    public static final class h extends AbstractC8614Ws3 implements SA2 {
        final /* synthetic */ SA2 e;
        final /* synthetic */ InterfaceC9173Yu3 f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public h(SA2 sa2, InterfaceC9173Yu3 interfaceC9173Yu3) {
            super(0);
            this.e = sa2;
            this.f = interfaceC9173Yu3;
        }

        @Override // ir.nasim.SA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final AbstractC20375ru1 invoke() {
            AbstractC20375ru1 abstractC20375ru1;
            SA2 sa2 = this.e;
            if (sa2 != null && (abstractC20375ru1 = (AbstractC20375ru1) sa2.invoke()) != null) {
                return abstractC20375ru1;
            }
            InterfaceC15408jX7 interfaceC15408jX7C = AbstractC6550Nz2.c(this.f);
            androidx.lifecycle.h hVar = interfaceC15408jX7C instanceof androidx.lifecycle.h ? (androidx.lifecycle.h) interfaceC15408jX7C : null;
            return hVar != null ? hVar.p3() : AbstractC20375ru1.a.b;
        }
    }

    /* renamed from: ir.nasim.ly0$i */
    public static final class i extends AbstractC8614Ws3 implements SA2 {
        final /* synthetic */ Fragment e;
        final /* synthetic */ InterfaceC9173Yu3 f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public i(Fragment fragment, InterfaceC9173Yu3 interfaceC9173Yu3) {
            super(0);
            this.e = fragment;
            this.f = interfaceC9173Yu3;
        }

        @Override // ir.nasim.SA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final G.c invoke() {
            G.c cVarN3;
            InterfaceC15408jX7 interfaceC15408jX7C = AbstractC6550Nz2.c(this.f);
            androidx.lifecycle.h hVar = interfaceC15408jX7C instanceof androidx.lifecycle.h ? (androidx.lifecycle.h) interfaceC15408jX7C : null;
            if (hVar != null && (cVarN3 = hVar.n3()) != null) {
                return cVarN3;
            }
            G.c cVarN32 = this.e.n3();
            AbstractC13042fc3.h(cVarN32, "defaultViewModelProviderFactory");
            return cVarN32;
        }
    }

    public C16848ly0() {
        InterfaceC9173Yu3 interfaceC9173Yu3B = AbstractC13269fw3.b(EnumC4870Gx3.c, new f(new e(this)));
        this.viewModel = AbstractC6550Nz2.b(this, AbstractC10882cM5.b(C19803qy0.class), new g(interfaceC9173Yu3B), new h(null, interfaceC9173Yu3B), new i(this, interfaceC9173Yu3B));
        AbstractC22357v6 abstractC22357v6N7 = N7(new C19881r6(), new InterfaceC17517n6() { // from class: ir.nasim.iy0
            @Override // ir.nasim.InterfaceC17517n6
            public final void a(Object obj) {
                C16848ly0.fa(this.a, (Boolean) obj);
            }
        });
        AbstractC13042fc3.h(abstractC22357v6N7, "registerForActivityResult(...)");
        this.audioPermission = abstractC22357v6N7;
        AbstractC22357v6 abstractC22357v6N72 = N7(new C19881r6(), new InterfaceC17517n6() { // from class: ir.nasim.jy0
            @Override // ir.nasim.InterfaceC17517n6
            public final void a(Object obj) {
                C16848ly0.Ca(this.a, (Boolean) obj);
            }
        });
        AbstractC13042fc3.h(abstractC22357v6N72, "registerForActivityResult(...)");
        this.videoPermission = abstractC22357v6N72;
    }

    private final void Aa(boolean showSnackBar) {
        if (la()) {
            ia().u1(showSnackBar);
        } else {
            ua();
        }
    }

    static /* synthetic */ void Ba(C16848ly0 c16848ly0, boolean z, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            z = true;
        }
        c16848ly0.Aa(z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Ca(C16848ly0 c16848ly0, Boolean bool) {
        AbstractC13042fc3.i(c16848ly0, "this$0");
        AbstractC13042fc3.i(bool, "isGranted");
        if (bool.booleanValue()) {
            za(c16848ly0, false, 1, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final InterfaceC13730gj3 ea() {
        return ia().Y0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void fa(C16848ly0 c16848ly0, Boolean bool) {
        AbstractC13042fc3.i(c16848ly0, "this$0");
        AbstractC13042fc3.i(bool, "isGranted");
        if (bool.booleanValue()) {
            Ba(c16848ly0, false, 1, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void ga() {
        ia().o1();
        C22042ua0.m9(this, this, false, 2, null);
    }

    private final C3918Cx2 ha() {
        return (C3918Cx2) this.binding.a(this, m1[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final C19803qy0 ia() {
        return (C19803qy0) this.viewModel.getValue();
    }

    private final boolean ja() {
        return AbstractC4043Dl1.a(S7(), "android.permission.CAMERA") == 0;
    }

    private final boolean ka() {
        return AbstractC4043Dl1.a(S7(), "android.permission.READ_PHONE_STATE") == 0;
    }

    private final boolean la() {
        return AbstractC4043Dl1.a(S7(), "android.permission.RECORD_AUDIO") == 0;
    }

    private final void ma(Bundle arguments) {
        Serializable serializable = arguments.getSerializable("BUNDLE_PREVIEW_MODE_EXTRA");
        AbstractC13042fc3.g(serializable, "null cannot be cast to non-null type ir.nasim.features.call.ui.preview.CallPreviewMode");
        int i2 = b.a[((EnumC18030ny0) serializable).ordinal()];
        if (i2 == 1) {
            C19803qy0 c19803qy0Ia = ia();
            long j = arguments.getLong("BUNDLE_CALL_ID_EXTRA");
            String string = arguments.getString("BUNDLE_CALL_TITLE_EXTRA");
            if (string == null) {
                string = h6(AbstractC12217eE5.nasim_call_link_share_template_default_title);
                AbstractC13042fc3.h(string, "getString(...)");
            }
            String string2 = arguments.getString("BUNDLE_CALL_LINK_EXTRA");
            int i3 = arguments.getInt("BUNDLE_INITIATOR_USER_ID_EXTRA");
            long j2 = arguments.getLong("BUNDLE_CALL_LINK_START_TIME_EXTRA");
            boolean z = arguments.getBoolean("BUNDLE_IS_PRIVATE_CALL_EXTRA");
            String strH6 = h6(AbstractC12217eE5.nasim_call_preview_info);
            AbstractC13042fc3.h(strH6, "getString(...)");
            c19803qy0Ia.c1(j, string, string2, i3, j2, z, strH6);
            return;
        }
        if (i2 != 2) {
            return;
        }
        StartOutGoingCallPeerData startOutGoingCallPeerData = (StartOutGoingCallPeerData) arguments.getParcelable("BUNDLE_START_OUT_GOING_CALL_PEER_DATA_EXTRA");
        boolean z2 = arguments.getBoolean("BUNDLE_IS_VIDEO_CALL_EXTRA");
        String string3 = arguments.getString("BUNDLE_PEER_NAME_EXTRA");
        C19803qy0 c19803qy0Ia2 = ia();
        String strH62 = h6((startOutGoingCallPeerData != null && startOutGoingCallPeerData.getIsPrivatePeer() && z2) ? AbstractC12217eE5.media_video_call : (startOutGoingCallPeerData == null || !startOutGoingCallPeerData.getIsPrivatePeer()) ? AbstractC12217eE5.nasim_group_call : AbstractC12217eE5.media_voice_call);
        String strI6 = (startOutGoingCallPeerData == null || !startOutGoingCallPeerData.getIsPrivatePeer()) ? i6(AbstractC12217eE5.nasim_preview_start_group_call_info, string3) : i6(AbstractC12217eE5.nasim_preview_start_private_call_info, string3);
        AbstractC13042fc3.f(strI6);
        c19803qy0Ia2.d1(startOutGoingCallPeerData, strH62, strI6);
        if (z2 && ja()) {
            ya(false);
        }
        if (la()) {
            Aa(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void na(Long callId) {
        if (!ka()) {
            ta();
            return;
        }
        ia().o1();
        ia().f1(callId);
        ga();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void oa() {
        ia().j1();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void pa() {
        ia().k1();
    }

    private final void ra() {
        C21753u45 c21753u45 = C21753u45.a;
        FragmentActivity fragmentActivityQ7 = Q7();
        AbstractC13042fc3.h(fragmentActivityQ7, "requireActivity(...)");
        c21753u45.B0(fragmentActivityQ7, C21753u45.d.f, (SetRpcStruct$ComposedRpc.SEARCH_CONTACTS_FIELD_NUMBER & 4) != 0 ? null : Integer.valueOf(AbstractC12217eE5.video_call_permission_desctiption), new SA2() { // from class: ir.nasim.hy0
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return C16848ly0.sa(this.a);
            }
        }, (SetRpcStruct$ComposedRpc.SEARCH_CONTACTS_FIELD_NUMBER & 16) != 0 ? 
        /*  JADX ERROR: Method code generation error
            jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x001e: INVOKE 
              (r0v0 'c21753u45' ir.nasim.u45)
              (r1v0 'fragmentActivityQ7' androidx.fragment.app.FragmentActivity)
              (wrap:ir.nasim.u45$d:0x000b: SGET  A[WRAPPED] (LINE:12) ir.nasim.u45.d.f ir.nasim.u45$d)
              (wrap:java.lang.Integer:?: TERNARY null = ((wrap:int:0x0000: ARITH (wrap:int:SGET  A[WRAPPED] ai.bale.proto.SetRpcStruct$ComposedRpc.SEARCH_CONTACTS_FIELD_NUMBER int) & (4 int) A[WRAPPED] (LINE:1)) != (0 int)) ? (null java.lang.Integer) : (wrap:java.lang.Integer:0x000f: INVOKE (wrap:int:0x000d: SGET  A[WRAPPED] (LINE:14) ir.nasim.eE5.video_call_permission_desctiption int) STATIC call: java.lang.Integer.valueOf(int):java.lang.Integer A[MD:(int):java.lang.Integer (c), WRAPPED] (LINE:16)))
              (wrap:ir.nasim.SA2:0x0015: CONSTRUCTOR (r10v0 'this' ir.nasim.ly0 A[DONT_INLINE, IMMUTABLE_TYPE, THIS]) A[MD:(ir.nasim.ly0):void (m), WRAPPED] (LINE:22) call: ir.nasim.hy0.<init>(ir.nasim.ly0):void type: CONSTRUCTOR)
              (wrap:ir.nasim.SA2:?: TERNARY null = ((wrap:int:0x0008: ARITH (wrap:int:SGET  A[WRAPPED] ai.bale.proto.SetRpcStruct$ComposedRpc.SEARCH_CONTACTS_FIELD_NUMBER int) & (16 int) A[WRAPPED] (LINE:9)) != (0 int)) ? (wrap:??:0x0011: CONSTRUCTOR  A[MD:():void (m), WRAPPED] (LINE:15) call: ir.nasim.Y35.<init>():void type: CONSTRUCTOR) : (null ir.nasim.SA2))
              (wrap:ir.nasim.SA2:?: TERNARY null = ((wrap:int:0x0014: ARITH (wrap:int:SGET  A[WRAPPED] ai.bale.proto.SetRpcStruct$ComposedRpc.SEARCH_CONTACTS_FIELD_NUMBER int) & (32 int) A[WRAPPED] (LINE:21)) != (0 int)) ? (wrap:??:0x001d: CONSTRUCTOR  A[MD:():void (m), WRAPPED] (LINE:27) call: ir.nasim.Z35.<init>():void type: CONSTRUCTOR) : (null ir.nasim.SA2))
              (wrap:boolean:?: TERNARY null = ((wrap:int:0x0020: ARITH (wrap:int:SGET  A[WRAPPED] ai.bale.proto.SetRpcStruct$ComposedRpc.SEARCH_CONTACTS_FIELD_NUMBER int) & (64 int) A[WRAPPED] (LINE:33)) != (0 int)) ? true : false)
             VIRTUAL call: ir.nasim.u45.B0(android.app.Activity, ir.nasim.u45$d, java.lang.Integer, ir.nasim.SA2, ir.nasim.SA2, ir.nasim.SA2, boolean):void A[MD:(android.app.Activity, ir.nasim.u45$d, java.lang.Integer, ir.nasim.SA2, ir.nasim.SA2, ir.nasim.SA2, boolean):void (m)] (LINE:46) in method: ir.nasim.ly0.ra():void, file: classes5.dex
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:310)
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:273)
            	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:94)
            	at jadx.core.dex.nodes.IBlock.generate(IBlock.java:15)
            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
            	at jadx.core.dex.regions.Region.generate(Region.java:35)
            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
            	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:298)
            	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:277)
            	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:410)
            	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:335)
            	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$3(ClassGen.java:301)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:184)
            	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
            	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
            	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:261)
            Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: ir.nasim.Y35, state: NOT_LOADED
            	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:306)
            	at jadx.core.codegen.InsnGen.inlineAnonymousConstructor(InsnGen.java:807)
            	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:730)
            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:418)
            	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:145)
            	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:121)
            	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:108)
            	at jadx.core.codegen.InsnGen.makeTernary(InsnGen.java:1187)
            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:536)
            	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:145)
            	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:121)
            	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:108)
            	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:1143)
            	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:910)
            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:422)
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:303)
            	... 15 more
            */
        /*
            this = this;
            ir.nasim.u45 r0 = ir.nasim.C21753u45.a
            androidx.fragment.app.FragmentActivity r1 = r10.Q7()
            java.lang.String r2 = "requireActivity(...)"
            ir.nasim.AbstractC13042fc3.h(r1, r2)
            ir.nasim.u45$d r2 = ir.nasim.C21753u45.d.f
            int r3 = ir.nasim.AbstractC12217eE5.video_call_permission_desctiption
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
            ir.nasim.hy0 r4 = new ir.nasim.hy0
            r4.<init>()
            r8 = 112(0x70, float:1.57E-43)
            r9 = 0
            r5 = 0
            r6 = 0
            r7 = 0
            ir.nasim.C21753u45.C0(r0, r1, r2, r3, r4, r5, r6, r7, r8, r9)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C16848ly0.ra():void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 sa(C16848ly0 c16848ly0) {
        AbstractC13042fc3.i(c16848ly0, "this$0");
        c16848ly0.videoPermission.a("android.permission.CAMERA");
        return C19938rB7.a;
    }

    private final void ta() {
        C21753u45 c21753u45 = C21753u45.a;
        FragmentActivity fragmentActivityQ7 = Q7();
        AbstractC13042fc3.h(fragmentActivityQ7, "requireActivity(...)");
        C21753u45.i0(c21753u45, fragmentActivityQ7, 1234321, C21753u45.d.u, Integer.valueOf(AbstractC12217eE5.call_phone_state_permission_description), null, null, null, false, SetRpcStruct$ComposedRpc.RESPONSE_STICKERS_REPONSE_FIELD_NUMBER, null);
    }

    private final void ua() {
        C21753u45 c21753u45 = C21753u45.a;
        FragmentActivity fragmentActivityQ7 = Q7();
        AbstractC13042fc3.h(fragmentActivityQ7, "requireActivity(...)");
        c21753u45.B0(fragmentActivityQ7, C21753u45.d.s, (SetRpcStruct$ComposedRpc.SEARCH_CONTACTS_FIELD_NUMBER & 4) != 0 ? null : Integer.valueOf(AbstractC12217eE5.voice_call_permission_desctiption), new SA2() { // from class: ir.nasim.ky0
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return C16848ly0.va(this.a);
            }
        }, (SetRpcStruct$ComposedRpc.SEARCH_CONTACTS_FIELD_NUMBER & 16) != 0 ? 
        /*  JADX ERROR: Method code generation error
            jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x001e: INVOKE 
              (r0v0 'c21753u45' ir.nasim.u45)
              (r1v0 'fragmentActivityQ7' androidx.fragment.app.FragmentActivity)
              (wrap:ir.nasim.u45$d:0x000b: SGET  A[WRAPPED] (LINE:12) ir.nasim.u45.d.s ir.nasim.u45$d)
              (wrap:java.lang.Integer:?: TERNARY null = ((wrap:int:0x0000: ARITH (wrap:int:SGET  A[WRAPPED] ai.bale.proto.SetRpcStruct$ComposedRpc.SEARCH_CONTACTS_FIELD_NUMBER int) & (4 int) A[WRAPPED] (LINE:1)) != (0 int)) ? (null java.lang.Integer) : (wrap:java.lang.Integer:0x000f: INVOKE (wrap:int:0x000d: SGET  A[WRAPPED] (LINE:14) ir.nasim.eE5.voice_call_permission_desctiption int) STATIC call: java.lang.Integer.valueOf(int):java.lang.Integer A[MD:(int):java.lang.Integer (c), WRAPPED] (LINE:16)))
              (wrap:ir.nasim.SA2:0x0015: CONSTRUCTOR (r10v0 'this' ir.nasim.ly0 A[DONT_INLINE, IMMUTABLE_TYPE, THIS]) A[MD:(ir.nasim.ly0):void (m), WRAPPED] (LINE:22) call: ir.nasim.ky0.<init>(ir.nasim.ly0):void type: CONSTRUCTOR)
              (wrap:ir.nasim.SA2:?: TERNARY null = ((wrap:int:0x0008: ARITH (wrap:int:SGET  A[WRAPPED] ai.bale.proto.SetRpcStruct$ComposedRpc.SEARCH_CONTACTS_FIELD_NUMBER int) & (16 int) A[WRAPPED] (LINE:9)) != (0 int)) ? (wrap:??:0x0011: CONSTRUCTOR  A[MD:():void (m), WRAPPED] (LINE:15) call: ir.nasim.Y35.<init>():void type: CONSTRUCTOR) : (null ir.nasim.SA2))
              (wrap:ir.nasim.SA2:?: TERNARY null = ((wrap:int:0x0014: ARITH (wrap:int:SGET  A[WRAPPED] ai.bale.proto.SetRpcStruct$ComposedRpc.SEARCH_CONTACTS_FIELD_NUMBER int) & (32 int) A[WRAPPED] (LINE:21)) != (0 int)) ? (wrap:??:0x001d: CONSTRUCTOR  A[MD:():void (m), WRAPPED] (LINE:27) call: ir.nasim.Z35.<init>():void type: CONSTRUCTOR) : (null ir.nasim.SA2))
              (wrap:boolean:?: TERNARY null = ((wrap:int:0x0020: ARITH (wrap:int:SGET  A[WRAPPED] ai.bale.proto.SetRpcStruct$ComposedRpc.SEARCH_CONTACTS_FIELD_NUMBER int) & (64 int) A[WRAPPED] (LINE:33)) != (0 int)) ? true : false)
             VIRTUAL call: ir.nasim.u45.B0(android.app.Activity, ir.nasim.u45$d, java.lang.Integer, ir.nasim.SA2, ir.nasim.SA2, ir.nasim.SA2, boolean):void A[MD:(android.app.Activity, ir.nasim.u45$d, java.lang.Integer, ir.nasim.SA2, ir.nasim.SA2, ir.nasim.SA2, boolean):void (m)] (LINE:46) in method: ir.nasim.ly0.ua():void, file: classes5.dex
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:310)
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:273)
            	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:94)
            	at jadx.core.dex.nodes.IBlock.generate(IBlock.java:15)
            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
            	at jadx.core.dex.regions.Region.generate(Region.java:35)
            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
            	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:298)
            	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:277)
            	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:410)
            	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:335)
            	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$3(ClassGen.java:301)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:184)
            	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
            	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
            	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:261)
            Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: ir.nasim.Y35, state: NOT_LOADED
            	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:306)
            	at jadx.core.codegen.InsnGen.inlineAnonymousConstructor(InsnGen.java:807)
            	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:730)
            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:418)
            	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:145)
            	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:121)
            	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:108)
            	at jadx.core.codegen.InsnGen.makeTernary(InsnGen.java:1187)
            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:536)
            	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:145)
            	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:121)
            	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:108)
            	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:1143)
            	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:910)
            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:422)
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:303)
            	... 15 more
            */
        /*
            this = this;
            ir.nasim.u45 r0 = ir.nasim.C21753u45.a
            androidx.fragment.app.FragmentActivity r1 = r10.Q7()
            java.lang.String r2 = "requireActivity(...)"
            ir.nasim.AbstractC13042fc3.h(r1, r2)
            ir.nasim.u45$d r2 = ir.nasim.C21753u45.d.s
            int r3 = ir.nasim.AbstractC12217eE5.voice_call_permission_desctiption
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
            ir.nasim.ky0 r4 = new ir.nasim.ky0
            r4.<init>()
            r8 = 112(0x70, float:1.57E-43)
            r9 = 0
            r5 = 0
            r6 = 0
            r7 = 0
            ir.nasim.C21753u45.C0(r0, r1, r2, r3, r4, r5, r6, r7, r8, r9)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C16848ly0.ua():void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 va(C16848ly0 c16848ly0) {
        AbstractC13042fc3.i(c16848ly0, "this$0");
        c16848ly0.audioPermission.a("android.permission.RECORD_AUDIO");
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void wa(StartOutGoingCallPeerData startOutGoingCallPeerData, boolean isVideoCall) {
        if (!ka()) {
            ta();
            return;
        }
        if (!la()) {
            ua();
            return;
        }
        if (isVideoCall) {
            C22042ua0.w9(this, C24270yK6.m1.a(startOutGoingCallPeerData), false, null, 6, null);
        } else {
            C22042ua0.w9(this, C24270yK6.m1.b(startOutGoingCallPeerData), false, null, 6, null);
        }
        ga();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void xa(boolean showFrontCamera) {
        ia().q1(showFrontCamera);
    }

    private final void ya(boolean showSnackBar) {
        if (ja()) {
            ia().t1(showSnackBar);
        } else {
            ra();
        }
    }

    static /* synthetic */ void za(C16848ly0 c16848ly0, boolean z, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            z = true;
        }
        c16848ly0.ya(z);
    }

    @Override // ir.nasim.C23278wf0, androidx.fragment.app.Fragment
    public void c7() {
        ia().o1();
        super.c7();
    }

    @Override // androidx.fragment.app.Fragment
    public void l7(View view, Bundle savedInstanceState) {
        AbstractC13042fc3.i(view, "view");
        ha().b.setContent(AbstractC19242q11.c(-1874227181, true, new c()));
        ia().h1();
        ia().Z0();
        ia().s1();
        Bundle bundleE5 = E5();
        if (bundleE5 != null) {
            ma(bundleE5);
        }
    }

    @Override // androidx.fragment.app.Fragment
    /* renamed from: qa, reason: merged with bridge method [inline-methods] */
    public ComposeView Q6(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        AbstractC13042fc3.i(inflater, "inflater");
        ComposeView root = C3918Cx2.c(inflater, container, false).getRoot();
        AbstractC13042fc3.h(root, "getRoot(...)");
        return root;
    }
}
