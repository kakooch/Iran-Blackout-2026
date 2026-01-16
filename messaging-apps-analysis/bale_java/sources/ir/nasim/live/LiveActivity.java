package ir.nasim.live;

import ai.bale.proto.SetRpcStruct$ComposedRpc;
import android.app.PendingIntent;
import android.app.PictureInPictureParams;
import android.app.RemoteAction;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.gov.nist.core.Separators;
import android.graphics.Bitmap;
import android.graphics.drawable.Icon;
import android.os.Build;
import android.os.Bundle;
import android.util.Rational;
import android.view.View;
import android.webkit.JavascriptInterface;
import android.webkit.WebSettings;
import android.webkit.WebView;
import androidx.activity.ComponentActivity;
import androidx.compose.foundation.layout.t;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.F;
import androidx.lifecycle.G;
import androidx.lifecycle.j;
import ir.nasim.AbstractC10360bX0;
import ir.nasim.AbstractC10533bm0;
import ir.nasim.AbstractC10685c16;
import ir.nasim.AbstractC10882cM5;
import ir.nasim.AbstractC11456d23;
import ir.nasim.AbstractC12888fL4;
import ir.nasim.AbstractC12990fW7;
import ir.nasim.AbstractC13042fc3;
import ir.nasim.AbstractC13269fw3;
import ir.nasim.AbstractC13472gH6;
import ir.nasim.AbstractC13837gu0;
import ir.nasim.AbstractC14862ic3;
import ir.nasim.AbstractC16751lo1;
import ir.nasim.AbstractC18583ou0;
import ir.nasim.AbstractC18754pB5;
import ir.nasim.AbstractC19174pu0;
import ir.nasim.AbstractC19224pz3;
import ir.nasim.AbstractC19242q11;
import ir.nasim.AbstractC19329q98;
import ir.nasim.AbstractC19859r37;
import ir.nasim.AbstractC20375ru1;
import ir.nasim.AbstractC22231ut;
import ir.nasim.AbstractC22957w63;
import ir.nasim.AbstractC24188yB5;
import ir.nasim.AbstractC24494yi6;
import ir.nasim.AbstractC4616Fw7;
import ir.nasim.AbstractC5999Lt;
import ir.nasim.AbstractC6392Nk0;
import ir.nasim.AbstractC6797Pa1;
import ir.nasim.AbstractC8614Ws3;
import ir.nasim.C11637dL5;
import ir.nasim.C14819iX7;
import ir.nasim.C17784nZ1;
import ir.nasim.C18391oa8;
import ir.nasim.C19406qI3;
import ir.nasim.C19938rB7;
import ir.nasim.C20494s63;
import ir.nasim.C21097t63;
import ir.nasim.C3976Dd6;
import ir.nasim.C4081Dp3;
import ir.nasim.C5652Kg2;
import ir.nasim.C5942Lm4;
import ir.nasim.DG7;
import ir.nasim.EB2;
import ir.nasim.ED1;
import ir.nasim.EnumC4870Gx3;
import ir.nasim.F92;
import ir.nasim.FV4;
import ir.nasim.G10;
import ir.nasim.G46;
import ir.nasim.G92;
import ir.nasim.InterfaceC10970cW3;
import ir.nasim.InterfaceC11819dc1;
import ir.nasim.InterfaceC12529em;
import ir.nasim.InterfaceC14603iB2;
import ir.nasim.InterfaceC15247jG;
import ir.nasim.InterfaceC15796kB2;
import ir.nasim.InterfaceC16030kb1;
import ir.nasim.InterfaceC20208rd6;
import ir.nasim.InterfaceC20295rm1;
import ir.nasim.InterfaceC20315ro1;
import ir.nasim.InterfaceC22053ub1;
import ir.nasim.InterfaceC22474vI4;
import ir.nasim.InterfaceC22821vt;
import ir.nasim.InterfaceC5239Im3;
import ir.nasim.InterfaceC9102Ym4;
import ir.nasim.InterfaceC9173Yu3;
import ir.nasim.InterfaceC9664aL6;
import ir.nasim.L93;
import ir.nasim.O98;
import ir.nasim.QJ5;
import ir.nasim.RD3;
import ir.nasim.SA2;
import ir.nasim.UA2;
import ir.nasim.XV4;
import ir.nasim.ZS7;
import ir.nasim.core.network.sslpinning.SecureWebView;
import ir.nasim.features.bank.mybank.webview.WebViewInterface;
import ir.nasim.live.LiveActivity;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;

@Metadata(d1 = {"\u0000Ä\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\n\n\u0002\u0010\u0007\n\u0002\b\u0002\b\u0001\u0018\u0000 j2\u00020\u0001:\u0005klmnoB\t\b\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0005\u0010\u0003J\u000f\u0010\u0006\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0006\u0010\u0003J\u0019\u0010\t\u001a\u00020\u00042\b\b\u0002\u0010\b\u001a\u00020\u0007H\u0003¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u000b\u0010\u0003J\u0013\u0010\r\u001a\u00060\fR\u00020\u0000H\u0002¢\u0006\u0004\b\r\u0010\u000eJ#\u0010\u0012\u001a\u00020\u00042\n\u0010\u000f\u001a\u00060\fR\u00020\u00002\u0006\u0010\u0011\u001a\u00020\u0010H\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\u0013\u0010\u0016\u001a\u00020\u0015*\u00020\u0014H\u0003¢\u0006\u0004\b\u0016\u0010\u0017J\u000f\u0010\u0018\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0018\u0010\u0003J\u000f\u0010\u0019\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0019\u0010\u0003J\u0017\u0010\u001c\u001a\u00020\u00042\u0006\u0010\u001b\u001a\u00020\u001aH\u0002¢\u0006\u0004\b\u001c\u0010\u001dJ\u000f\u0010\u001f\u001a\u00020\u001eH\u0002¢\u0006\u0004\b\u001f\u0010 J;\u0010'\u001a\u00020\u00042\u0006\u0010!\u001a\u00020\u001e2\u0006\u0010\"\u001a\u00020\u001e2\u0006\u0010#\u001a\u00020\u001e2\u0012\u0010&\u001a\u000e\u0012\u0004\u0012\u00020%\u0012\u0004\u0012\u00020%0$H\u0003¢\u0006\u0004\b'\u0010(JC\u0010+\u001a\n **\u0004\u0018\u00010)0)2\u0006\u0010!\u001a\u00020\u001e2\u0006\u0010#\u001a\u00020\u001e2\u0006\u0010\"\u001a\u00020\u001e2\u0012\u0010&\u001a\u000e\u0012\u0004\u0012\u00020%\u0012\u0004\u0012\u00020%0$H\u0003¢\u0006\u0004\b+\u0010,J\u0017\u0010.\u001a\u00020-2\u0006\u0010#\u001a\u00020\u001eH\u0003¢\u0006\u0004\b.\u0010/J\u0017\u00100\u001a\u00020-2\u0006\u0010\"\u001a\u00020\u001eH\u0003¢\u0006\u0004\b0\u0010/J\u0017\u00102\u001a\u0002012\u0006\u0010\u001b\u001a\u00020\u001aH\u0002¢\u0006\u0004\b2\u00103J\u0017\u00106\u001a\u00020\u00042\u0006\u00105\u001a\u000204H\u0015¢\u0006\u0004\b6\u00107J\u0019\u0010:\u001a\u00020\u00042\b\u00109\u001a\u0004\u0018\u000108H\u0014¢\u0006\u0004\b:\u0010;J\u000f\u0010<\u001a\u00020\u0004H\u0016¢\u0006\u0004\b<\u0010\u0003J\u000f\u0010=\u001a\u00020\u0004H\u0015¢\u0006\u0004\b=\u0010\u0003J\u001f\u0010A\u001a\u00020\u00042\u0006\u0010>\u001a\u00020\u001e2\u0006\u0010@\u001a\u00020?H\u0017¢\u0006\u0004\bA\u0010BJ\u000f\u0010C\u001a\u00020\u0004H\u0014¢\u0006\u0004\bC\u0010\u0003R\u001b\u0010I\u001a\u00020D8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bE\u0010F\u001a\u0004\bG\u0010HR\u001b\u0010N\u001a\u00020J8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bK\u0010F\u001a\u0004\bL\u0010MR\u001c\u0010R\u001a\b\u0012\u0004\u0012\u00020\u001e0O8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bP\u0010QR\u001b\u0010W\u001a\u00020S8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bT\u0010F\u001a\u0004\bU\u0010VR\u0014\u0010[\u001a\u00020X8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bY\u0010ZR\u001f\u0010\u000f\u001a\u00060\fR\u00020\u00008BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\\\u0010F\u001a\u0004\b]\u0010\u000eR\"\u0010e\u001a\u00020^8\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\b_\u0010`\u001a\u0004\ba\u0010b\"\u0004\bc\u0010dR\u0018\u0010i\u001a\u0004\u0018\u00010f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bg\u0010h¨\u0006s²\u0006\f\u0010p\u001a\u00020\u001e8\nX\u008a\u0084\u0002²\u0006\f\u0010r\u001a\u00020q8\nX\u008a\u0084\u0002"}, d2 = {"Lir/nasim/live/LiveActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "<init>", "()V", "Lir/nasim/rB7;", "g2", "i2", "Landroidx/compose/ui/e;", "modifier", "x1", "(Landroidx/compose/ui/e;Lir/nasim/ub1;II)V", "k2", "Lir/nasim/live/LiveActivity$e;", "S1", "()Lir/nasim/live/LiveActivity$e;", "webViewInterface", "", "liveUrl", "j2", "(Lir/nasim/live/LiveActivity$e;Ljava/lang/String;)V", "Landroid/webkit/WebView;", "Landroid/webkit/WebSettings;", "l2", "(Landroid/webkit/WebView;)Landroid/webkit/WebSettings;", "L1", "f2", "Lir/nasim/live/LiveActivity$a;", "action", "d2", "(Lir/nasim/live/LiveActivity$a;)V", "", "K1", "()Z", "isEnded", "isPlaying", "isMuted", "Lir/nasim/XV4;", "", "rational", "T1", "(ZZZLir/nasim/XV4;)V", "Landroid/app/PictureInPictureParams;", "kotlin.jvm.PlatformType", "P1", "(ZZZLir/nasim/XV4;)Landroid/app/PictureInPictureParams;", "Landroid/app/RemoteAction;", "O1", "(Z)Landroid/app/RemoteAction;", "Q1", "Landroid/app/PendingIntent;", "N1", "(Lir/nasim/live/LiveActivity$a;)Landroid/app/PendingIntent;", "Landroid/content/Intent;", "intent", "onNewIntent", "(Landroid/content/Intent;)V", "Landroid/os/Bundle;", "savedInstanceState", "onCreate", "(Landroid/os/Bundle;)V", "onBackPressed", "onUserLeaveHint", "isInPictureInPictureMode", "Landroid/content/res/Configuration;", "newConfig", "onPictureInPictureModeChanged", "(ZLandroid/content/res/Configuration;)V", "onDestroy", "Lir/nasim/RD3;", "Z", "Lir/nasim/Yu3;", "Y1", "()Lir/nasim/RD3;", "liveViewModel", "Lir/nasim/Kg2;", "z0", "W1", "()Lir/nasim/Kg2;", "binding", "Lir/nasim/Ym4;", "A0", "Lir/nasim/Ym4;", "isPageLoaded", "Lir/nasim/oa8;", "B0", "b2", "()Lir/nasim/oa8;", "windowInsetsController", "Lir/nasim/Dd6;", "C0", "Lir/nasim/Dd6;", "screenOrientationController", "D0", "a2", "Lir/nasim/core/modules/file/audio/audiofocus/a;", "E0", "Lir/nasim/core/modules/file/audio/audiofocus/a;", "getAudioFocusManager", "()Lir/nasim/core/modules/file/audio/audiofocus/a;", "setAudioFocusManager", "(Lir/nasim/core/modules/file/audio/audiofocus/a;)V", "audioFocusManager", "", "F0", "Ljava/lang/Long;", "currentLiveKey", "G0", "c", "d", "e", "a", "b", "isLoaded", "", "angle", "live_release"}, k = 1, mv = {2, 0, 0})
/* loaded from: classes6.dex */
public final class LiveActivity extends ir.nasim.live.a {

    /* renamed from: G0, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int H0 = 8;

    /* renamed from: A0, reason: from kotlin metadata */
    private InterfaceC9102Ym4 isPageLoaded;

    /* renamed from: B0, reason: from kotlin metadata */
    private final InterfaceC9173Yu3 windowInsetsController;

    /* renamed from: C0, reason: from kotlin metadata */
    private final C3976Dd6 screenOrientationController;

    /* renamed from: D0, reason: from kotlin metadata */
    private final InterfaceC9173Yu3 webViewInterface;

    /* renamed from: E0, reason: from kotlin metadata */
    public ir.nasim.core.modules.file.audio.audiofocus.a audioFocusManager;

    /* renamed from: F0, reason: from kotlin metadata */
    private Long currentLiveKey;

    /* renamed from: Z, reason: from kotlin metadata */
    private final InterfaceC9173Yu3 liveViewModel = new F(AbstractC10882cM5.b(RD3.class), new i(this), new h(this), new j(null, this));

    /* renamed from: z0, reason: from kotlin metadata */
    private final InterfaceC9173Yu3 binding;

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    static final class a {
        public static final a a = new a("PLAY", 0);
        public static final a b = new a("PAUSE", 1);
        public static final a c = new a("MUTE", 2);
        public static final a d = new a("UN_MUTE", 3);
        private static final /* synthetic */ a[] e;
        private static final /* synthetic */ F92 f;

        static {
            a[] aVarArrA = a();
            e = aVarArrA;
            f = G92.a(aVarArrA);
        }

        private a(String str, int i) {
        }

        private static final /* synthetic */ a[] a() {
            return new a[]{a, b, c, d};
        }

        public static F92 j() {
            return f;
        }

        public static a valueOf(String str) {
            return (a) Enum.valueOf(a.class, str);
        }

        public static a[] values() {
            return (a[]) e.clone();
        }
    }

    /* renamed from: ir.nasim.live.LiveActivity$b, reason: from kotlin metadata */
    public static final class Companion {
        private Companion() {
        }

        public final Intent a(Context context, long j, AbstractC12888fL4 abstractC12888fL4) {
            AbstractC13042fc3.i(context, "context");
            AbstractC13042fc3.i(abstractC12888fL4, "openSource");
            Intent intent = new Intent(context, (Class<?>) LiveActivity.class);
            intent.setFlags(536870912);
            intent.putExtra("ARG_LIVE_KEY", j);
            intent.putExtra("ARG_OPEN_SOURCE", abstractC12888fL4.a());
            return intent;
        }

        public final Intent b(Context context, String str, AbstractC12888fL4 abstractC12888fL4) {
            AbstractC13042fc3.i(context, "context");
            AbstractC13042fc3.i(str, "url");
            AbstractC13042fc3.i(abstractC12888fL4, "openSource");
            Intent intent = new Intent(context, (Class<?>) LiveActivity.class);
            intent.setFlags(536870912);
            intent.putExtra("ARG_URL", str);
            intent.putExtra("ARG_OPEN_SOURCE", abstractC12888fL4.a());
            return intent;
        }

        public /* synthetic */ Companion(ED1 ed1) {
            this();
        }
    }

    public final class c extends ZS7 {
        public c() {
            super(LiveActivity.this.W1().c, LiveActivity.this.W1().getRoot());
        }
    }

    public final class d extends AbstractC24494yi6 {
        private final String b;
        final /* synthetic */ LiveActivity c;

        public d(LiveActivity liveActivity, String str) {
            AbstractC13042fc3.i(str, "targetUrl");
            this.c = liveActivity;
            this.b = str;
        }

        @Override // ir.nasim.AbstractC24494yi6, android.webkit.WebViewClient
        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            super.onPageStarted(webView, str, bitmap);
            if (AbstractC13042fc3.d(str, this.b)) {
                this.c.isPageLoaded.setValue(Boolean.FALSE);
            }
        }
    }

    public final class e extends WebViewInterface {
        static final /* synthetic */ InterfaceC5239Im3[] x = {AbstractC10882cM5.f(new C5942Lm4(e.class, "isEnded", "isEnded()Z", 0)), AbstractC10882cM5.f(new C5942Lm4(e.class, "isPlaying", "isPlaying()Z", 0)), AbstractC10882cM5.f(new C5942Lm4(e.class, "isMuted", "isMuted()Z", 0)), AbstractC10882cM5.f(new C5942Lm4(e.class, "rational", "getRational()Lkotlin/Pair;", 0))};
        private final k p;
        private final k q;
        private final k r;
        private final k s;
        private String t;
        private String u;
        private String v;
        final /* synthetic */ LiveActivity w;

        public static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
            int b;
            final /* synthetic */ LiveActivity c;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(InterfaceC20295rm1 interfaceC20295rm1, LiveActivity liveActivity) {
                super(2, interfaceC20295rm1);
                this.c = liveActivity;
            }

            @Override // ir.nasim.E90
            public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                return new a(interfaceC20295rm1, this.c);
            }

            @Override // ir.nasim.E90
            public final Object invokeSuspend(Object obj) {
                AbstractC14862ic3.e();
                if (this.b != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
                this.c.isPageLoaded.setValue(AbstractC6392Nk0.a(true));
                return C19938rB7.a;
            }

            @Override // ir.nasim.InterfaceC14603iB2
            /* renamed from: n, reason: merged with bridge method [inline-methods] */
            public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
                return ((a) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        public static final class b extends AbstractC19859r37 implements InterfaceC14603iB2 {
            int b;
            final /* synthetic */ LiveActivity c;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public b(InterfaceC20295rm1 interfaceC20295rm1, LiveActivity liveActivity) {
                super(2, interfaceC20295rm1);
                this.c = liveActivity;
            }

            @Override // ir.nasim.E90
            public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                return new b(interfaceC20295rm1, this.c);
            }

            @Override // ir.nasim.E90
            public final Object invokeSuspend(Object obj) {
                AbstractC14862ic3.e();
                if (this.b != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
                this.c.onBackPressed();
                return C19938rB7.a;
            }

            @Override // ir.nasim.InterfaceC14603iB2
            /* renamed from: n, reason: merged with bridge method [inline-methods] */
            public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
                return ((b) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        public static final class c extends AbstractC19859r37 implements InterfaceC14603iB2 {
            int b;
            final /* synthetic */ e c;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public c(InterfaceC20295rm1 interfaceC20295rm1, e eVar) {
                super(2, interfaceC20295rm1);
                this.c = eVar;
            }

            @Override // ir.nasim.E90
            public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                return new c(interfaceC20295rm1, this.c);
            }

            @Override // ir.nasim.E90
            public final Object invokeSuspend(Object obj) {
                AbstractC14862ic3.e();
                if (this.b != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
                this.c.O0(true);
                return C19938rB7.a;
            }

            @Override // ir.nasim.InterfaceC14603iB2
            /* renamed from: n, reason: merged with bridge method [inline-methods] */
            public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
                return ((c) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        public static final class d extends AbstractC19859r37 implements InterfaceC14603iB2 {
            int b;
            final /* synthetic */ e c;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public d(InterfaceC20295rm1 interfaceC20295rm1, e eVar) {
                super(2, interfaceC20295rm1);
                this.c = eVar;
            }

            @Override // ir.nasim.E90
            public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                return new d(interfaceC20295rm1, this.c);
            }

            @Override // ir.nasim.E90
            public final Object invokeSuspend(Object obj) {
                AbstractC14862ic3.e();
                if (this.b != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
                this.c.P0(true);
                return C19938rB7.a;
            }

            @Override // ir.nasim.InterfaceC14603iB2
            /* renamed from: n, reason: merged with bridge method [inline-methods] */
            public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
                return ((d) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        /* renamed from: ir.nasim.live.LiveActivity$e$e, reason: collision with other inner class name */
        public static final class C1377e extends AbstractC19859r37 implements InterfaceC14603iB2 {
            int b;
            final /* synthetic */ e c;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C1377e(InterfaceC20295rm1 interfaceC20295rm1, e eVar) {
                super(2, interfaceC20295rm1);
                this.c = eVar;
            }

            @Override // ir.nasim.E90
            public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                return new C1377e(interfaceC20295rm1, this.c);
            }

            @Override // ir.nasim.E90
            public final Object invokeSuspend(Object obj) {
                AbstractC14862ic3.e();
                if (this.b != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
                this.c.Q0(false);
                return C19938rB7.a;
            }

            @Override // ir.nasim.InterfaceC14603iB2
            /* renamed from: n, reason: merged with bridge method [inline-methods] */
            public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
                return ((C1377e) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        public static final class f extends AbstractC19859r37 implements InterfaceC14603iB2 {
            int b;
            final /* synthetic */ e c;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public f(InterfaceC20295rm1 interfaceC20295rm1, e eVar) {
                super(2, interfaceC20295rm1);
                this.c = eVar;
            }

            @Override // ir.nasim.E90
            public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                return new f(interfaceC20295rm1, this.c);
            }

            @Override // ir.nasim.E90
            public final Object invokeSuspend(Object obj) {
                AbstractC14862ic3.e();
                if (this.b != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
                this.c.Q0(true);
                return C19938rB7.a;
            }

            @Override // ir.nasim.InterfaceC14603iB2
            /* renamed from: n, reason: merged with bridge method [inline-methods] */
            public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
                return ((f) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        public static final class g extends AbstractC19859r37 implements InterfaceC14603iB2 {
            int b;
            final /* synthetic */ e c;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public g(InterfaceC20295rm1 interfaceC20295rm1, e eVar) {
                super(2, interfaceC20295rm1);
                this.c = eVar;
            }

            @Override // ir.nasim.E90
            public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                return new g(interfaceC20295rm1, this.c);
            }

            @Override // ir.nasim.E90
            public final Object invokeSuspend(Object obj) {
                AbstractC14862ic3.e();
                if (this.b != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
                this.c.O0(false);
                return C19938rB7.a;
            }

            @Override // ir.nasim.InterfaceC14603iB2
            /* renamed from: n, reason: merged with bridge method [inline-methods] */
            public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
                return ((g) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        public static final class h extends AbstractC19859r37 implements InterfaceC14603iB2 {
            int b;
            final /* synthetic */ e c;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public h(InterfaceC20295rm1 interfaceC20295rm1, e eVar) {
                super(2, interfaceC20295rm1);
                this.c = eVar;
            }

            @Override // ir.nasim.E90
            public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                return new h(interfaceC20295rm1, this.c);
            }

            @Override // ir.nasim.E90
            public final Object invokeSuspend(Object obj) {
                AbstractC14862ic3.e();
                if (this.b != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
                this.c.P0(false);
                return C19938rB7.a;
            }

            @Override // ir.nasim.InterfaceC14603iB2
            /* renamed from: n, reason: merged with bridge method [inline-methods] */
            public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
                return ((h) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        public static final class i extends AbstractC19859r37 implements InterfaceC14603iB2 {
            int b;
            final /* synthetic */ LiveActivity c;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public i(InterfaceC20295rm1 interfaceC20295rm1, LiveActivity liveActivity) {
                super(2, interfaceC20295rm1);
                this.c = liveActivity;
            }

            @Override // ir.nasim.E90
            public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                return new i(interfaceC20295rm1, this.c);
            }

            @Override // ir.nasim.E90
            public final Object invokeSuspend(Object obj) {
                AbstractC14862ic3.e();
                if (this.b != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
                this.c.screenOrientationController.j();
                return C19938rB7.a;
            }

            @Override // ir.nasim.InterfaceC14603iB2
            /* renamed from: n, reason: merged with bridge method [inline-methods] */
            public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
                return ((i) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        public static final class j extends AbstractC19859r37 implements InterfaceC14603iB2 {
            int b;
            final /* synthetic */ LiveActivity c;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public j(InterfaceC20295rm1 interfaceC20295rm1, LiveActivity liveActivity) {
                super(2, interfaceC20295rm1);
                this.c = liveActivity;
            }

            @Override // ir.nasim.E90
            public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                return new j(interfaceC20295rm1, this.c);
            }

            @Override // ir.nasim.E90
            public final Object invokeSuspend(Object obj) {
                AbstractC14862ic3.e();
                if (this.b != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
                this.c.screenOrientationController.l();
                return C19938rB7.a;
            }

            @Override // ir.nasim.InterfaceC14603iB2
            /* renamed from: n, reason: merged with bridge method [inline-methods] */
            public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
                return ((j) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        private final class k {
            private Object a;

            public k(Object obj) {
                this.a = obj;
            }

            public final Object a(e eVar, InterfaceC5239Im3 interfaceC5239Im3) {
                AbstractC13042fc3.i(eVar, "liveWebViewInterface");
                AbstractC13042fc3.i(interfaceC5239Im3, "property");
                return this.a;
            }

            public final void b(e eVar, InterfaceC5239Im3 interfaceC5239Im3, Object obj) {
                AbstractC13042fc3.i(eVar, "liveWebViewInterface");
                AbstractC13042fc3.i(interfaceC5239Im3, "property");
                this.a = obj;
                eVar.C0();
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(LiveActivity liveActivity, WebView webView, Context context, FragmentActivity fragmentActivity) {
            super(webView, context, fragmentActivity, null, null, null, null, SetRpcStruct$ComposedRpc.EDIT_GROUP_DEFAULT_CARD_NUMBER_FIELD_NUMBER, null);
            AbstractC13042fc3.i(webView, "webView");
            AbstractC13042fc3.i(context, "context");
            AbstractC13042fc3.i(fragmentActivity, "activity");
            this.w = liveActivity;
            Boolean bool = Boolean.FALSE;
            this.p = new k(bool);
            this.q = new k(bool);
            this.r = new k(bool);
            this.s = new k(AbstractC4616Fw7.a(16, 9));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void C0() {
            LiveActivity liveActivity = this.w;
            int i2 = Build.VERSION.SDK_INT;
            if (i2 < 26 || !liveActivity.isInPictureInPictureMode() || i2 < 26) {
                return;
            }
            this.w.setPictureInPictureParams(this.w.P1(E0(), F0(), H0(), D0()));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void O0(boolean z) {
            this.p.b(this, x[0], Boolean.valueOf(z));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void P0(boolean z) {
            this.r.b(this, x[2], Boolean.valueOf(z));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void Q0(boolean z) {
            this.q.b(this, x[1], Boolean.valueOf(z));
        }

        public final XV4 D0() {
            return (XV4) this.s.a(this, x[3]);
        }

        public final boolean E0() {
            return ((Boolean) this.p.a(this, x[0])).booleanValue();
        }

        public final boolean F0() {
            return ((Boolean) this.r.a(this, x[2])).booleanValue();
        }

        @Override // ir.nasim.features.bank.mybank.webview.WebViewInterface
        @JavascriptInterface
        public void FINISHED_LOADING_CALLBACK() {
            LiveActivity liveActivity = this.w;
            AbstractC10533bm0.d(AbstractC19224pz3.a(liveActivity), null, null, new a(null, liveActivity), 3, null);
        }

        public final boolean H0() {
            return ((Boolean) this.q.a(this, x[1])).booleanValue();
        }

        public final void I0() {
            String str;
            if (F0() || (str = this.v) == null) {
                return;
            }
            q0(str, "true");
        }

        public final C19938rB7 J0() {
            String str = this.t;
            if (str == null) {
                return null;
            }
            q0(str, "true");
            return C19938rB7.a;
        }

        public final C19938rB7 L0() {
            String str = this.t;
            if (str == null) {
                return null;
            }
            q0(str, "false");
            return C19938rB7.a;
        }

        public final C19938rB7 M0() {
            String str = this.u;
            if (str == null) {
                return null;
            }
            q0(str, "false");
            return C19938rB7.a;
        }

        public final C19938rB7 N0() {
            String str = this.u;
            if (str == null) {
                return null;
            }
            q0(str, "true");
            return C19938rB7.a;
        }

        @JavascriptInterface
        public final void ON_BACK_PRESSED() {
            LiveActivity liveActivity = this.w;
            AbstractC10533bm0.d(AbstractC19224pz3.a(liveActivity), null, null, new b(null, liveActivity), 3, null);
        }

        @JavascriptInterface
        public final void ON_LIVE_ENDED() {
            AbstractC10533bm0.d(AbstractC19224pz3.a(this.w), null, null, new c(null, this), 3, null);
        }

        @JavascriptInterface
        public final void ON_LIVE_MUTED() {
            AbstractC10533bm0.d(AbstractC19224pz3.a(this.w), null, null, new d(null, this), 3, null);
        }

        @JavascriptInterface
        public final void ON_LIVE_PAUSED() {
            AbstractC10533bm0.d(AbstractC19224pz3.a(this.w), null, null, new C1377e(null, this), 3, null);
        }

        @JavascriptInterface
        public final void ON_LIVE_PLAYED() {
            AbstractC10533bm0.d(AbstractC19224pz3.a(this.w), null, null, new f(null, this), 3, null);
        }

        @JavascriptInterface
        public final void ON_LIVE_STARTED() {
            AbstractC10533bm0.d(AbstractC19224pz3.a(this.w), null, null, new g(null, this), 3, null);
        }

        @JavascriptInterface
        public final void ON_LIVE_UN_MUTED() {
            AbstractC10533bm0.d(AbstractC19224pz3.a(this.w), null, null, new h(null, this), 3, null);
        }

        public final void R0() {
            String str;
            if (F0() && (str = this.v) != null) {
                q0(str, "false");
            }
        }

        @JavascriptInterface
        public final void REGISTED_MUTE_UNMUTE_LIVE_CALLBACK(String str) {
            this.v = str;
        }

        @JavascriptInterface
        public final void REGISTED_PIP_LIVE_CALLBACK(String str) {
            this.t = str;
        }

        @JavascriptInterface
        public final void REGISTED_PLAY_PAUSE_LIVE_CALLBACK(String str) {
            this.u = str;
        }

        @JavascriptInterface
        public final void REQUEST_LANDSCAPE() {
            LiveActivity liveActivity = this.w;
            AbstractC10533bm0.d(AbstractC19224pz3.a(liveActivity), null, null, new i(null, liveActivity), 3, null);
        }

        @JavascriptInterface
        public final void REQUEST_PORTRAIT() {
            LiveActivity liveActivity = this.w;
            AbstractC10533bm0.d(AbstractC19224pz3.a(liveActivity), null, null, new j(null, liveActivity), 3, null);
        }
    }

    public /* synthetic */ class f {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[a.values().length];
            try {
                iArr[a.a.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[a.b.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[a.c.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[a.d.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            a = iArr;
        }
    }

    static final class g implements InterfaceC14603iB2 {

        static final class a implements InterfaceC15796kB2 {
            final /* synthetic */ LiveActivity a;

            a(LiveActivity liveActivity) {
                this.a = liveActivity;
            }

            public final void a(InterfaceC22821vt interfaceC22821vt, InterfaceC22053ub1 interfaceC22053ub1, int i) {
                AbstractC13042fc3.i(interfaceC22821vt, "$this$AnimatedVisibility");
                androidx.compose.ui.e eVarD = androidx.compose.foundation.b.d(t.f(androidx.compose.ui.e.a, 0.0f, 1, null), G10.a.b(interfaceC22053ub1, G10.b).a(), null, 2, null);
                InterfaceC12529em interfaceC12529emE = InterfaceC12529em.a.e();
                LiveActivity liveActivity = this.a;
                InterfaceC10970cW3 interfaceC10970cW3G = androidx.compose.foundation.layout.f.g(interfaceC12529emE, false);
                int iA = AbstractC6797Pa1.a(interfaceC22053ub1, 0);
                InterfaceC11819dc1 interfaceC11819dc1Q = interfaceC22053ub1.q();
                androidx.compose.ui.e eVarE = androidx.compose.ui.c.e(interfaceC22053ub1, eVarD);
                InterfaceC16030kb1.a aVar = InterfaceC16030kb1.d0;
                SA2 sa2A = aVar.a();
                if (!(interfaceC22053ub1.l() instanceof InterfaceC15247jG)) {
                    AbstractC6797Pa1.c();
                }
                interfaceC22053ub1.G();
                if (interfaceC22053ub1.h()) {
                    interfaceC22053ub1.g(sa2A);
                } else {
                    interfaceC22053ub1.r();
                }
                InterfaceC22053ub1 interfaceC22053ub1A = DG7.a(interfaceC22053ub1);
                DG7.c(interfaceC22053ub1A, interfaceC10970cW3G, aVar.e());
                DG7.c(interfaceC22053ub1A, interfaceC11819dc1Q, aVar.g());
                InterfaceC14603iB2 interfaceC14603iB2B = aVar.b();
                if (interfaceC22053ub1A.h() || !AbstractC13042fc3.d(interfaceC22053ub1A.B(), Integer.valueOf(iA))) {
                    interfaceC22053ub1A.s(Integer.valueOf(iA));
                    interfaceC22053ub1A.v(Integer.valueOf(iA), interfaceC14603iB2B);
                }
                DG7.c(interfaceC22053ub1A, eVarE, aVar.f());
                androidx.compose.foundation.layout.h hVar = androidx.compose.foundation.layout.h.a;
                liveActivity.x1(null, interfaceC22053ub1, 0, 1);
                interfaceC22053ub1.u();
            }

            @Override // ir.nasim.InterfaceC15796kB2
            public /* bridge */ /* synthetic */ Object q(Object obj, Object obj2, Object obj3) {
                a((InterfaceC22821vt) obj, (InterfaceC22053ub1) obj2, ((Number) obj3).intValue());
                return C19938rB7.a;
            }
        }

        g() {
        }

        private static final boolean b(InterfaceC9102Ym4 interfaceC9102Ym4) {
            return ((Boolean) interfaceC9102Ym4.getValue()).booleanValue();
        }

        public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
            if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                interfaceC22053ub1.L();
                return;
            }
            interfaceC22053ub1.W(538979414);
            LiveActivity liveActivity = LiveActivity.this;
            Object objB = interfaceC22053ub1.B();
            if (objB == InterfaceC22053ub1.a.a()) {
                objB = liveActivity.isPageLoaded;
                interfaceC22053ub1.s(objB);
            }
            interfaceC22053ub1.Q();
            AbstractC22231ut.f(!b((InterfaceC9102Ym4) objB), null, null, null, null, AbstractC19242q11.e(-413321367, true, new a(LiveActivity.this), interfaceC22053ub1, 54), interfaceC22053ub1, 196608, 30);
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
            return C19938rB7.a;
        }
    }

    public static final class h extends AbstractC8614Ws3 implements SA2 {
        final /* synthetic */ ComponentActivity e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public h(ComponentActivity componentActivity) {
            super(0);
            this.e = componentActivity;
        }

        @Override // ir.nasim.SA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final G.c invoke() {
            return this.e.n3();
        }
    }

    public static final class i extends AbstractC8614Ws3 implements SA2 {
        final /* synthetic */ ComponentActivity e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public i(ComponentActivity componentActivity) {
            super(0);
            this.e = componentActivity;
        }

        @Override // ir.nasim.SA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final C14819iX7 invoke() {
            return this.e.d1();
        }
    }

    public static final class j extends AbstractC8614Ws3 implements SA2 {
        final /* synthetic */ SA2 e;
        final /* synthetic */ ComponentActivity f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public j(SA2 sa2, ComponentActivity componentActivity) {
            super(0);
            this.e = sa2;
            this.f = componentActivity;
        }

        @Override // ir.nasim.SA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final AbstractC20375ru1 invoke() {
            AbstractC20375ru1 abstractC20375ru1;
            SA2 sa2 = this.e;
            return (sa2 == null || (abstractC20375ru1 = (AbstractC20375ru1) sa2.invoke()) == null) ? this.f.p3() : abstractC20375ru1;
        }
    }

    /* synthetic */ class k extends EB2 implements SA2 {
        k(Object obj) {
            super(0, obj, LiveActivity.class, "createWebViewInterface", "createWebViewInterface()Lir/nasim/live/LiveActivity$LiveWebViewInterface;", 0);
        }

        @Override // ir.nasim.SA2
        /* renamed from: y, reason: merged with bridge method [inline-methods] */
        public final e invoke() {
            return ((LiveActivity) this.receiver).S1();
        }
    }

    public LiveActivity() {
        EnumC4870Gx3 enumC4870Gx3 = EnumC4870Gx3.c;
        this.binding = AbstractC13269fw3.b(enumC4870Gx3, new SA2() { // from class: ir.nasim.uC3
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return LiveActivity.J1(this.a);
            }
        });
        this.isPageLoaded = AbstractC13472gH6.d(Boolean.FALSE, null, 2, null);
        this.windowInsetsController = AbstractC13269fw3.b(enumC4870Gx3, new SA2() { // from class: ir.nasim.vC3
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return LiveActivity.n2(this.a);
            }
        });
        this.screenOrientationController = new C3976Dd6(this);
        this.webViewInterface = AbstractC13269fw3.b(enumC4870Gx3, new k(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 A1(LiveActivity liveActivity, androidx.compose.ui.e eVar, int i2, int i3, InterfaceC22053ub1 interfaceC22053ub1, int i4) {
        AbstractC13042fc3.i(liveActivity, "$tmp1_rcvr");
        liveActivity.x1(eVar, interfaceC22053ub1, QJ5.a(i2 | 1), i3);
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C5652Kg2 J1(LiveActivity liveActivity) {
        AbstractC13042fc3.i(liveActivity, "this$0");
        return C5652Kg2.c(liveActivity.getLayoutInflater());
    }

    private final boolean K1() {
        return !a2().E0();
    }

    private final void L1() {
        final C5652Kg2 c5652Kg2W1 = W1();
        final C11637dL5 c11637dL5 = new C11637dL5();
        AbstractC12990fW7.E0(getWindow().getDecorView(), new InterfaceC22474vI4() { // from class: ir.nasim.tC3
            @Override // ir.nasim.InterfaceC22474vI4
            public final O98 b(View view, O98 o98) {
                return LiveActivity.M1(c11637dL5, c5652Kg2W1, this, view, o98);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final O98 M1(C11637dL5 c11637dL5, C5652Kg2 c5652Kg2, LiveActivity liveActivity, View view, O98 o98) {
        AbstractC13042fc3.i(c11637dL5, "$capturedStatusBarHeight");
        AbstractC13042fc3.i(c5652Kg2, "$this_with");
        AbstractC13042fc3.i(liveActivity, "this$0");
        AbstractC13042fc3.i(view, "<unused var>");
        AbstractC13042fc3.i(o98, "insets");
        L93 l93F = o98.f(O98.m.i());
        AbstractC13042fc3.h(l93F, "getInsets(...)");
        L93 l93F2 = o98.f(O98.m.d());
        AbstractC13042fc3.h(l93F2, "getInsets(...)");
        int i2 = l93F.b;
        if (i2 > 0) {
            c11637dL5.a = i2;
        }
        int i3 = l93F2.d;
        if (i3 <= 0) {
            i3 = l93F.d;
        }
        CoordinatorLayout coordinatorLayoutB = c5652Kg2.getRoot();
        AbstractC13042fc3.h(coordinatorLayoutB, "getRoot(...)");
        int i4 = Build.VERSION.SDK_INT;
        int i5 = (i4 < 26 || !liveActivity.isInPictureInPictureMode()) ? c11637dL5.a : 0;
        int i6 = (i4 < 26 || !liveActivity.isInPictureInPictureMode()) ? l93F.a : 0;
        int i7 = (i4 < 26 || !liveActivity.isInPictureInPictureMode()) ? l93F.c : 0;
        if (i4 >= 26 && liveActivity.isInPictureInPictureMode()) {
            i3 = 0;
        }
        coordinatorLayoutB.setPadding(i6, i5, i7, i3);
        return O98.b;
    }

    private final PendingIntent N1(a action) {
        PendingIntent broadcast = PendingIntent.getBroadcast(this, action.ordinal(), new Intent(action.name()), 201326592);
        AbstractC13042fc3.h(broadcast, "getBroadcast(...)");
        return broadcast;
    }

    private final RemoteAction O1(boolean isMuted) {
        AbstractC13837gu0.a();
        return AbstractC18583ou0.a(Icon.createWithResource(this, isMuted ? AbstractC18754pB5.ic_unmute : AbstractC18754pB5.ic_mute), isMuted ? "UnMute" : "Mute", "Toggle sound state button", N1(isMuted ? a.d : a.c));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final PictureInPictureParams P1(boolean isEnded, boolean isMuted, boolean isPlaying, XV4 rational) {
        return AbstractC19174pu0.a().setActions(isEnded ? AbstractC10360bX0.m() : AbstractC10360bX0.p(O1(isMuted), Q1(isPlaying))).setAspectRatio(new Rational(((Number) rational.e()).intValue(), ((Number) rational.f()).intValue())).build();
    }

    private final RemoteAction Q1(boolean isPlaying) {
        AbstractC13837gu0.a();
        return AbstractC18583ou0.a(Icon.createWithResource(this, isPlaying ? AbstractC18754pB5.ic_pause : AbstractC18754pB5.ic_play), isPlaying ? "Pause" : "Play", "Toggle play button", N1(isPlaying ? a.b : a.a));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final e S1() {
        SecureWebView secureWebView = W1().c;
        AbstractC13042fc3.h(secureWebView, "liveWebView");
        return new e(this, secureWebView, this, this);
    }

    private final void T1(boolean isEnded, boolean isPlaying, boolean isMuted, XV4 rational) {
        enterPictureInPictureMode(P1(isEnded, isMuted, isPlaying, rational));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final C5652Kg2 W1() {
        return (C5652Kg2) this.binding.getValue();
    }

    private final RD3 Y1() {
        return (RD3) this.liveViewModel.getValue();
    }

    private final e a2() {
        return (e) this.webViewInterface.getValue();
    }

    private final C18391oa8 b2() {
        return (C18391oa8) this.windowInsetsController.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void d2(a action) {
        int i2 = f.a[action.ordinal()];
        if (i2 == 1) {
            a2().N0();
            return;
        }
        if (i2 == 2) {
            a2().M0();
        } else if (i2 == 3) {
            a2().I0();
        } else {
            if (i2 != 4) {
                throw new NoWhenBranchMatchedException();
            }
            a2().R0();
        }
    }

    private final void f2() {
        AbstractC16751lo1.b(this, j.b.STARTED, new LiveActivity$setupActionBroadCastReceiver$1(this, null));
    }

    private final void g2() {
        Bundle extras = getIntent().getExtras();
        Long lValueOf = extras != null ? Long.valueOf(extras.getLong("ARG_LIVE_KEY")) : null;
        if (lValueOf == null || !AbstractC13042fc3.d(this.currentLiveKey, lValueOf)) {
            String strR0 = Y1().R0();
            if (strR0 == null) {
                finish();
                return;
            }
            this.currentLiveKey = lValueOf;
            i2();
            j2(a2(), strR0);
        }
    }

    private final void i2() {
        W1().b.setContent(AbstractC19242q11.c(-1074766527, true, new g()));
    }

    private final void j2(e webViewInterface, String liveUrl) {
        SecureWebView secureWebView = W1().c;
        secureWebView.setWebViewClient(new d(this, liveUrl));
        secureWebView.setWebChromeClient(new c());
        secureWebView.addJavascriptInterface(webViewInterface, "BaleAndroid");
        AbstractC13042fc3.f(secureWebView);
        l2(secureWebView);
        secureWebView.loadUrl(liveUrl);
    }

    private final void k2() {
        AbstractC19329q98.b(getWindow(), false);
        b2().d(2);
    }

    private final WebSettings l2(WebView webView) {
        WebSettings settings = webView.getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setDomStorageEnabled(true);
        settings.setUserAgentString("bale/webview");
        settings.setCacheMode(-1);
        settings.setMediaPlaybackRequiresUserGesture(false);
        settings.setMixedContentMode(0);
        AbstractC13042fc3.h(settings, "apply(...)");
        return settings;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C18391oa8 n2(LiveActivity liveActivity) {
        AbstractC13042fc3.i(liveActivity, "this$0");
        return AbstractC19329q98.a(liveActivity.getWindow(), liveActivity.getWindow().getDecorView());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void x1(final androidx.compose.ui.e eVar, InterfaceC22053ub1 interfaceC22053ub1, final int i2, final int i3) {
        int i4;
        InterfaceC22053ub1 interfaceC22053ub1J = interfaceC22053ub1.j(-437936468);
        int i5 = i3 & 1;
        if (i5 != 0) {
            i4 = i2 | 6;
        } else if ((i2 & 6) == 0) {
            i4 = (interfaceC22053ub1J.V(eVar) ? 4 : 2) | i2;
        } else {
            i4 = i2;
        }
        if ((i4 & 3) == 2 && interfaceC22053ub1J.k()) {
            interfaceC22053ub1J.L();
        } else {
            if (i5 != 0) {
                eVar = androidx.compose.ui.e.a;
            }
            C21097t63 c21097t63C = AbstractC22957w63.c("Loading", interfaceC22053ub1J, 6, 0);
            interfaceC22053ub1J.W(-152782536);
            Object objB = interfaceC22053ub1J.B();
            if (objB == InterfaceC22053ub1.a.a()) {
                objB = new UA2() { // from class: ir.nasim.wC3
                    @Override // ir.nasim.UA2
                    public final Object invoke(Object obj) {
                        return LiveActivity.y1((C4081Dp3.b) obj);
                    }
                };
                interfaceC22053ub1J.s(objB);
            }
            interfaceC22053ub1J.Q();
            AbstractC11456d23.b(FV4.c(AbstractC24188yB5.loading_search, interfaceC22053ub1J, 0), "Loading", G46.a(t.t(eVar, C17784nZ1.q(32)), z1(AbstractC22957w63.a(c21097t63C, 0.0f, 360.0f, AbstractC5999Lt.e(AbstractC5999Lt.f((UA2) objB), null, 0L, 6, null), "Loading", interfaceC22053ub1J, C21097t63.f | 25008 | (C20494s63.d << 9), 0))), null, null, 0.0f, null, interfaceC22053ub1J, 48, SetRpcStruct$ComposedRpc.EDIT_GROUP_DEFAULT_CARD_NUMBER_FIELD_NUMBER);
        }
        InterfaceC20208rd6 interfaceC20208rd6M = interfaceC22053ub1J.m();
        if (interfaceC20208rd6M != null) {
            interfaceC20208rd6M.a(new InterfaceC14603iB2() { // from class: ir.nasim.xC3
                @Override // ir.nasim.InterfaceC14603iB2
                public final Object invoke(Object obj, Object obj2) {
                    return LiveActivity.A1(this.a, eVar, i2, i3, (InterfaceC22053ub1) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 y1(C4081Dp3.b bVar) {
        AbstractC13042fc3.i(bVar, "$this$keyframes");
        bVar.d(800);
        return C19938rB7.a;
    }

    private static final float z1(InterfaceC9664aL6 interfaceC9664aL6) {
        return ((Number) interfaceC9664aL6.getValue()).floatValue();
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        if (!K1() || Build.VERSION.SDK_INT < 26) {
            super.onBackPressed();
            return;
        }
        boolean zH0 = a2().H0();
        XV4 xv4D0 = a2().D0();
        T1(a2().E0(), zH0, a2().F0(), xv4D0);
    }

    @Override // ir.nasim.live.a, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        k2();
        setContentView(W1().getRoot());
        g2();
        L1();
        f2();
    }

    @Override // ir.nasim.live.a, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        W1().c.setWebChromeClient(null);
        super.onDestroy();
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    protected void onNewIntent(Intent intent) {
        AbstractC13042fc3.i(intent, "intent");
        super.onNewIntent(intent);
        setIntent(intent);
        g2();
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onPictureInPictureModeChanged(boolean isInPictureInPictureMode, Configuration newConfig) {
        AbstractC13042fc3.i(newConfig, "newConfig");
        super.onPictureInPictureModeChanged(isInPictureInPictureMode, newConfig);
        C19406qI3.a("LiveActivity", "onPictureInPictureModeChanged(" + isInPictureInPictureMode + ", " + getLifecycle().b().name() + Separators.RPAREN, new Object[0]);
        if (!getLifecycle().b().j(j.b.STARTED)) {
            finish();
        } else if (isInPictureInPictureMode) {
            a2().J0();
        } else {
            a2().L0();
        }
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    protected void onUserLeaveHint() {
        if (!K1() || Build.VERSION.SDK_INT < 26) {
            return;
        }
        boolean zH0 = a2().H0();
        XV4 xv4D0 = a2().D0();
        T1(a2().E0(), zH0, a2().F0(), xv4D0);
    }
}
