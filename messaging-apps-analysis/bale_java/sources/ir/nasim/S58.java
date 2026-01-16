package ir.nasim;

import ai.bale.proto.SetRpcStruct$ComposedRpc;
import android.content.Context;
import android.content.Intent;
import android.gov.nist.core.Separators;
import android.gov.nist.javax.sip.header.ParameterNames;
import android.graphics.Color;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.AndroidRuntimeException;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.CookieManager;
import android.webkit.GeolocationPermissions;
import android.webkit.PermissionRequest;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.widget.Toast;
import androidx.activity.result.ActivityResult;
import androidx.compose.ui.e;
import androidx.compose.ui.platform.ComposeView;
import androidx.compose.ui.platform.v;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.G;
import ir.nasim.AbstractC13801gq4;
import ir.nasim.AbstractC20375ru1;
import ir.nasim.AbstractC5542Ju0;
import ir.nasim.AbstractC7426Rr;
import ir.nasim.C21753u45;
import ir.nasim.C24732z68;
import ir.nasim.C9475a16;
import ir.nasim.InterfaceC12529em;
import ir.nasim.InterfaceC16030kb1;
import ir.nasim.InterfaceC22053ub1;
import ir.nasim.S58;
import ir.nasim.Y48;
import ir.nasim.core.model.webapp.WebAppArguments;
import ir.nasim.core.modules.settings.SettingsModule;
import ir.nasim.features.scanner.SimpleScannerActivity;
import java.lang.ref.WeakReference;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

@Metadata(d1 = {"\u0000\u0082\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u0000 ¯\u00012\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004:\u0002°\u0001B\t\b\u0007¢\u0006\u0004\b\u0005\u0010\u0006J!\u0010\f\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\u00072\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0002¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u000eH\u0003¢\u0006\u0004\b\u0010\u0010\u0011J\u001f\u0010\u0016\u001a\u00020\u000b2\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u0014H\u0003¢\u0006\u0004\b\u0016\u0010\u0017J\u0017\u0010\u001a\u001a\u00020\u000b2\u0006\u0010\u0019\u001a\u00020\u0018H\u0003¢\u0006\u0004\b\u001a\u0010\u001bJ\u000f\u0010\u001c\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\u001c\u0010\u0006J\u000f\u0010\u001d\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\u001d\u0010\u0006J!\u0010\"\u001a\u00020\u000b2\u0006\u0010\u001f\u001a\u00020\u001e2\b\u0010!\u001a\u0004\u0018\u00010 H\u0002¢\u0006\u0004\b\"\u0010#J\u0019\u0010&\u001a\u00020\u000b2\b\u0010%\u001a\u0004\u0018\u00010$H\u0016¢\u0006\u0004\b&\u0010'J+\u0010-\u001a\u00020,2\u0006\u0010)\u001a\u00020(2\b\u0010+\u001a\u0004\u0018\u00010*2\b\u0010%\u001a\u0004\u0018\u00010$H\u0016¢\u0006\u0004\b-\u0010.J\u000f\u0010/\u001a\u00020\u000bH\u0016¢\u0006\u0004\b/\u0010\u0006J\u000f\u00100\u001a\u00020\u000bH\u0016¢\u0006\u0004\b0\u0010\u0006J\u000f\u00101\u001a\u00020\u000bH\u0016¢\u0006\u0004\b1\u0010\u0006J\u0017\u00104\u001a\u00020\u000b2\u0006\u00103\u001a\u000202H\u0016¢\u0006\u0004\b4\u00105J#\u00109\u001a\u00020\u000b2\b\u00106\u001a\u0004\u0018\u00010\u00122\b\u00108\u001a\u0004\u0018\u000107H\u0016¢\u0006\u0004\b9\u0010:J/\u0010A\u001a\u00020\u000b2\u0014\u0010>\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020=0<\u0018\u00010;2\b\u0010@\u001a\u0004\u0018\u00010?H\u0016¢\u0006\u0004\bA\u0010BJ\u0017\u0010D\u001a\u00020\u000b2\u0006\u0010C\u001a\u00020\u0007H\u0016¢\u0006\u0004\bD\u0010EJ\u0019\u0010G\u001a\u00020\u000b2\b\u0010F\u001a\u0004\u0018\u00010\u0012H\u0016¢\u0006\u0004\bG\u0010HJ\u0017\u0010J\u001a\u00020\u000b2\u0006\u0010I\u001a\u00020\u0012H\u0016¢\u0006\u0004\bJ\u0010HJ\u000f\u0010K\u001a\u00020\u000bH\u0016¢\u0006\u0004\bK\u0010\u0006J\u000f\u0010L\u001a\u00020\u000bH\u0016¢\u0006\u0004\bL\u0010\u0006J\u000f\u0010M\u001a\u00020\u000bH\u0016¢\u0006\u0004\bM\u0010\u0006J\u0017\u0010P\u001a\u00020\u000b2\u0006\u0010O\u001a\u00020NH\u0016¢\u0006\u0004\bP\u0010QJ\u0017\u0010S\u001a\u00020\u000b2\u0006\u0010R\u001a\u00020NH\u0016¢\u0006\u0004\bS\u0010QJ\u0017\u0010V\u001a\u00020\u000b2\u0006\u0010U\u001a\u00020TH\u0016¢\u0006\u0004\bV\u0010WJ\u000f\u0010X\u001a\u00020\u000bH\u0016¢\u0006\u0004\bX\u0010\u0006J\u0017\u0010Z\u001a\u00020\u000b2\u0006\u0010Y\u001a\u00020NH\u0016¢\u0006\u0004\bZ\u0010QJ\u000f\u0010[\u001a\u00020\u000bH\u0016¢\u0006\u0004\b[\u0010\u0006J\u000f\u0010\\\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\\\u0010\u0006J\u001f\u0010_\u001a\u00020\u000b2\u0006\u0010]\u001a\u00020\u00122\u0006\u0010^\u001a\u00020NH\u0016¢\u0006\u0004\b_\u0010`J'\u0010c\u001a\u00020\u000b2\u0006\u0010a\u001a\u00020\u00122\u0006\u0010I\u001a\u00020\u00122\u0006\u0010b\u001a\u00020\u0012H\u0016¢\u0006\u0004\bc\u0010dJ\u0017\u0010e\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\u0012H\u0016¢\u0006\u0004\be\u0010HJ\u000f\u0010f\u001a\u00020\u000bH\u0016¢\u0006\u0004\bf\u0010\u0006J\u0017\u0010h\u001a\u00020\u000b2\u0006\u0010g\u001a\u00020\u0012H\u0016¢\u0006\u0004\bh\u0010HJ\u0019\u0010j\u001a\u00020\u000b2\b\u0010i\u001a\u0004\u0018\u00010\u0012H\u0016¢\u0006\u0004\bj\u0010HR\u001b\u0010p\u001a\u00020k8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bl\u0010m\u001a\u0004\bn\u0010oR$\u0010>\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020=0<\u0018\u00010;8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bq\u0010rR\"\u0010w\u001a\u0010\u0012\f\u0012\n t*\u0004\u0018\u00010\t0\t0s8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bu\u0010vR\"\u0010\u007f\u001a\u00020x8\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\by\u0010z\u001a\u0004\b{\u0010|\"\u0004\b}\u0010~R*\u0010\u0087\u0001\u001a\u00030\u0080\u00018\u0006@\u0006X\u0087.¢\u0006\u0018\n\u0006\b\u0081\u0001\u0010\u0082\u0001\u001a\u0006\b\u0083\u0001\u0010\u0084\u0001\"\u0006\b\u0085\u0001\u0010\u0086\u0001R*\u0010\u008f\u0001\u001a\u00030\u0088\u00018\u0006@\u0006X\u0087.¢\u0006\u0018\n\u0006\b\u0089\u0001\u0010\u008a\u0001\u001a\u0006\b\u008b\u0001\u0010\u008c\u0001\"\u0006\b\u008d\u0001\u0010\u008e\u0001R \u0010\u000f\u001a\u0004\u0018\u00010\u000e8BX\u0082\u0084\u0002¢\u0006\u000f\n\u0005\b\u0090\u0001\u0010m\u001a\u0006\b\u0091\u0001\u0010\u0092\u0001R \u0010\u0097\u0001\u001a\u00030\u0093\u00018BX\u0082\u0084\u0002¢\u0006\u000f\n\u0005\b\u0094\u0001\u0010m\u001a\u0006\b\u0095\u0001\u0010\u0096\u0001R \u0010\u009c\u0001\u001a\u00030\u0098\u00018BX\u0082\u0084\u0002¢\u0006\u000f\n\u0005\b\u0099\u0001\u0010m\u001a\u0006\b\u009a\u0001\u0010\u009b\u0001R \u0010¡\u0001\u001a\u00030\u009d\u00018BX\u0082\u0084\u0002¢\u0006\u000f\n\u0005\b\u009e\u0001\u0010m\u001a\u0006\b\u009f\u0001\u0010 \u0001R \u0010¦\u0001\u001a\u00030¢\u00018BX\u0082\u0084\u0002¢\u0006\u000f\n\u0005\b£\u0001\u0010m\u001a\u0006\b¤\u0001\u0010¥\u0001R\u0018\u0010ª\u0001\u001a\u00030§\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b¨\u0001\u0010©\u0001R$\u0010¬\u0001\u001a\u0010\u0012\f\u0012\n t*\u0004\u0018\u00010\u00120\u00120s8\u0002X\u0082\u0004¢\u0006\u0007\n\u0005\b«\u0001\u0010vR$\u0010®\u0001\u001a\u0010\u0012\f\u0012\n t*\u0004\u0018\u00010\t0\t0s8\u0002X\u0082\u0004¢\u0006\u0007\n\u0005\b\u00ad\u0001\u0010v¨\u0006³\u0001²\u0006\u000e\u0010²\u0001\u001a\u00030±\u00018\nX\u008a\u0084\u0002"}, d2 = {"Lir/nasim/S58;", "Lir/nasim/ua0;", "Lir/nasim/ND;", "Lir/nasim/V68;", "Lir/nasim/i68;", "<init>", "()V", "", "resultCode", "Landroid/content/Intent;", "data", "Lir/nasim/rB7;", "wb", "(ILandroid/content/Intent;)V", "Landroid/webkit/WebView;", "webView", "lb", "(Landroid/webkit/WebView;)V", "", "botName", "Lir/nasim/Y48;", "dialogState", "Ia", "(Ljava/lang/String;Lir/nasim/Y48;Lir/nasim/ub1;I)V", "Lir/nasim/qG6;", "snackBarState", "Xa", "(Lir/nasim/qG6;Lir/nasim/ub1;I)V", "mb", "xb", "Lir/nasim/b58;", "webAppEventType", "Lorg/json/JSONObject;", "eventData", "yb", "(Lir/nasim/b58;Lorg/json/JSONObject;)V", "Landroid/os/Bundle;", "savedInstanceState", "M6", "(Landroid/os/Bundle;)V", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/view/View;", "Q6", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "T6", "c7", "h7", "Landroid/webkit/PermissionRequest;", "request", "b3", "(Landroid/webkit/PermissionRequest;)V", "origin", "Landroid/webkit/GeolocationPermissions$Callback;", "callback", "W3", "(Ljava/lang/String;Landroid/webkit/GeolocationPermissions$Callback;)V", "Landroid/webkit/ValueCallback;", "", "Landroid/net/Uri;", "filePathCallback", "Landroid/webkit/WebChromeClient$FileChooserParams;", "fileChooserParams", "I2", "(Landroid/webkit/ValueCallback;Landroid/webkit/WebChromeClient$FileChooserParams;)V", "newProgress", "F4", "(I)V", "errorName", "w0", "(Ljava/lang/String;)V", "methodName", "d4", "v0", "v3", "b5", "", "showBackButton", "b4", "(Z)V", "showSettingButton", "T4", "Lir/nasim/Ju0;", "colorType", "e1", "(Lir/nasim/Ju0;)V", "i2", "needConfirmation", "K3", "T1", "Z", "url", "openOnProtectedBrowser", "g4", "(Ljava/lang/String;Z)V", "requestId", "params", "l3", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "e3", "c1", "invoiceParams", "A4", "payload", "t3", "Lir/nasim/c78;", "h1", "Lir/nasim/Yu3;", "qb", "()Lir/nasim/c78;", "viewModel", "i1", "Landroid/webkit/ValueCallback;", "Lir/nasim/v6;", "kotlin.jvm.PlatformType", "j1", "Lir/nasim/v6;", "fileChooserResultLauncher", "Lir/nasim/core/modules/settings/SettingsModule;", "k1", "Lir/nasim/core/modules/settings/SettingsModule;", "pb", "()Lir/nasim/core/modules/settings/SettingsModule;", "setSettingsModule", "(Lir/nasim/core/modules/settings/SettingsModule;)V", "settingsModule", "Lir/nasim/x88;", "l1", "Lir/nasim/x88;", "getWebViewModule", "()Lir/nasim/x88;", "setWebViewModule", "(Lir/nasim/x88;)V", "webViewModule", "Lir/nasim/uE;", "m1", "Lir/nasim/uE;", "ob", "()Lir/nasim/uE;", "setAppRatingNavigator", "(Lir/nasim/uE;)V", "appRatingNavigator", "n1", "vb", "()Landroid/webkit/WebView;", "Lir/nasim/e68;", "o1", "tb", "()Lir/nasim/e68;", "webAppInterface", "Lir/nasim/g20;", "p1", "ub", "()Lir/nasim/g20;", "webAppNavigator", "Lir/nasim/U68;", "q1", "sb", "()Lir/nasim/U68;", "webAppClient", "Lir/nasim/yX;", "r1", "rb", "()Lir/nasim/yX;", "webAppChromeClient", "Lir/nasim/Cr7;", "s1", "Lir/nasim/Cr7;", "toolbarCallBack", "t1", "qrScannerPermissionResultLauncher", "u1", "qrScannerResultLauncher", "v1", "a", "Lir/nasim/R68;", "state", "webapp_release"}, k = 1, mv = {2, 0, 0})
/* loaded from: classes8.dex */
public final class S58 extends AbstractC11751dY2 implements ND, V68, InterfaceC14560i68 {

    /* renamed from: v1, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int w1 = 8;

    /* renamed from: h1, reason: from kotlin metadata */
    private final InterfaceC9173Yu3 viewModel;

    /* renamed from: i1, reason: from kotlin metadata */
    private ValueCallback filePathCallback;

    /* renamed from: j1, reason: from kotlin metadata */
    private final AbstractC22357v6 fileChooserResultLauncher;

    /* renamed from: k1, reason: from kotlin metadata */
    public SettingsModule settingsModule;

    /* renamed from: l1, reason: from kotlin metadata */
    public C23572x88 webViewModule;

    /* renamed from: m1, reason: from kotlin metadata */
    public InterfaceC21843uE appRatingNavigator;

    /* renamed from: n1, reason: from kotlin metadata */
    private final InterfaceC9173Yu3 webView;

    /* renamed from: o1, reason: from kotlin metadata */
    private final InterfaceC9173Yu3 webAppInterface;

    /* renamed from: p1, reason: from kotlin metadata */
    private final InterfaceC9173Yu3 webAppNavigator;

    /* renamed from: q1, reason: from kotlin metadata */
    private final InterfaceC9173Yu3 webAppClient;

    /* renamed from: r1, reason: from kotlin metadata */
    private final InterfaceC9173Yu3 webAppChromeClient;

    /* renamed from: s1, reason: from kotlin metadata */
    private final C3869Cr7 toolbarCallBack;

    /* renamed from: t1, reason: from kotlin metadata */
    private final AbstractC22357v6 qrScannerPermissionResultLauncher;

    /* renamed from: u1, reason: from kotlin metadata */
    private final AbstractC22357v6 qrScannerResultLauncher;

    /* renamed from: ir.nasim.S58$a, reason: from kotlin metadata */
    public static final class Companion {
        private Companion() {
        }

        public final S58 a(WebAppArguments webAppArguments) {
            AbstractC13042fc3.i(webAppArguments, "argument");
            S58 s58 = new S58();
            s58.a8(AbstractC23348wm0.b(AbstractC4616Fw7.a("arg_webapp", webAppArguments)));
            return s58;
        }

        public /* synthetic */ Companion(ED1 ed1) {
            this();
        }
    }

    static final class b implements InterfaceC14603iB2 {
        final /* synthetic */ ComposeView b;

        static final class a implements InterfaceC14603iB2 {
            final /* synthetic */ S58 a;
            final /* synthetic */ ComposeView b;

            /* renamed from: ir.nasim.S58$b$a$a, reason: collision with other inner class name */
            static final class C0615a extends AbstractC19859r37 implements InterfaceC14603iB2 {
                int b;
                final /* synthetic */ InterfaceC9664aL6 c;
                final /* synthetic */ S58 d;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                C0615a(InterfaceC9664aL6 interfaceC9664aL6, S58 s58, InterfaceC20295rm1 interfaceC20295rm1) {
                    super(2, interfaceC20295rm1);
                    this.c = interfaceC9664aL6;
                    this.d = s58;
                }

                @Override // ir.nasim.E90
                public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                    return new C0615a(this.c, this.d, interfaceC20295rm1);
                }

                @Override // ir.nasim.E90
                public final Object invokeSuspend(Object obj) {
                    AbstractC14862ic3.e();
                    if (this.b != 0) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    AbstractC10685c16.b(obj);
                    AbstractC20942sr7 abstractC20942sr7O = a.f(this.c).o();
                    if (abstractC20942sr7O != null) {
                        S58 s58 = this.d;
                        Toast.makeText(s58.S7(), abstractC20942sr7O.a(), 0).show();
                        s58.qb().w2();
                    }
                    return C19938rB7.a;
                }

                @Override // ir.nasim.InterfaceC14603iB2
                /* renamed from: n, reason: merged with bridge method [inline-methods] */
                public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
                    return ((C0615a) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
                }
            }

            /* renamed from: ir.nasim.S58$b$a$b, reason: collision with other inner class name */
            /* synthetic */ class C0616b extends EB2 implements InterfaceC14603iB2 {
                C0616b(Object obj) {
                    super(2, obj, C10747c78.class, "submitBotReview", "submitBotReview(ILjava/lang/String;)V", 0);
                }

                @Override // ir.nasim.InterfaceC14603iB2
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    y(((Number) obj).intValue(), (String) obj2);
                    return C19938rB7.a;
                }

                public final void y(int i, String str) {
                    AbstractC13042fc3.i(str, "p1");
                    ((C10747c78) this.receiver).W2(i, str);
                }
            }

            /* synthetic */ class c extends EB2 implements SA2 {
                c(Object obj) {
                    super(0, obj, C10747c78.class, "skipBotReview", "skipBotReview()V", 0);
                }

                @Override // ir.nasim.SA2
                public /* bridge */ /* synthetic */ Object invoke() {
                    y();
                    return C19938rB7.a;
                }

                public final void y() {
                    ((C10747c78) this.receiver).R2();
                }
            }

            static final class d implements InterfaceC14603iB2 {
                final /* synthetic */ S58 a;
                final /* synthetic */ InterfaceC9664aL6 b;

                d(S58 s58, InterfaceC9664aL6 interfaceC9664aL6) {
                    this.a = s58;
                    this.b = interfaceC9664aL6;
                }

                public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
                    if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                        interfaceC22053ub1.L();
                        return;
                    }
                    WebView webViewVb = this.a.vb();
                    if (webViewVb == null) {
                        return;
                    }
                    S58 s58 = this.a;
                    InterfaceC9664aL6 interfaceC9664aL6 = this.b;
                    X48.w(webViewVb, a.f(interfaceC9664aL6), (!a.f(interfaceC9664aL6).w() || a.f(interfaceC9664aL6).f() || a.f(interfaceC9664aL6).g()) ? false : true, s58.toolbarCallBack, s58.ub(), s58.sb(), s58.rb(), interfaceC22053ub1, C22132uj0.c << 3);
                }

                @Override // ir.nasim.InterfaceC14603iB2
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
                    return C19938rB7.a;
                }
            }

            static final class e extends AbstractC19859r37 implements InterfaceC14603iB2 {
                Object b;
                int c;
                final /* synthetic */ InterfaceC9664aL6 d;
                final /* synthetic */ C19391qG6 e;
                final /* synthetic */ ComposeView f;
                final /* synthetic */ S58 g;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                e(InterfaceC9664aL6 interfaceC9664aL6, C19391qG6 c19391qG6, ComposeView composeView, S58 s58, InterfaceC20295rm1 interfaceC20295rm1) {
                    super(2, interfaceC20295rm1);
                    this.d = interfaceC9664aL6;
                    this.e = c19391qG6;
                    this.f = composeView;
                    this.g = s58;
                }

                @Override // ir.nasim.E90
                public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                    return new e(this.d, this.e, this.f, this.g, interfaceC20295rm1);
                }

                @Override // ir.nasim.E90
                public final Object invokeSuspend(Object obj) {
                    S58 s58;
                    Object objE = AbstractC14862ic3.e();
                    int i = this.c;
                    if (i == 0) {
                        AbstractC10685c16.b(obj);
                        AbstractC10213bG6 abstractC10213bG6N = a.f(this.d).n();
                        if (abstractC10213bG6N != null) {
                            C19391qG6 c19391qG6 = this.e;
                            ComposeView composeView = this.f;
                            S58 s582 = this.g;
                            String string = composeView.getContext().getString(abstractC10213bG6N.a());
                            AbstractC13042fc3.h(string, "getString(...)");
                            this.b = s582;
                            this.c = 1;
                            if (C19391qG6.f(c19391qG6, string, null, false, null, this, 14, null) == objE) {
                                return objE;
                            }
                            s58 = s582;
                        }
                        return C19938rB7.a;
                    }
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    s58 = (S58) this.b;
                    AbstractC10685c16.b(obj);
                    s58.qb().v2();
                    return C19938rB7.a;
                }

                @Override // ir.nasim.InterfaceC14603iB2
                /* renamed from: n, reason: merged with bridge method [inline-methods] */
                public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
                    return ((e) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
                }
            }

            static final class f extends AbstractC19859r37 implements InterfaceC14603iB2 {
                int b;
                final /* synthetic */ S58 c;
                final /* synthetic */ InterfaceC9664aL6 d;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                f(S58 s58, InterfaceC9664aL6 interfaceC9664aL6, InterfaceC20295rm1 interfaceC20295rm1) {
                    super(2, interfaceC20295rm1);
                    this.c = s58;
                    this.d = interfaceC9664aL6;
                }

                @Override // ir.nasim.E90
                public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                    return new f(this.c, this.d, interfaceC20295rm1);
                }

                @Override // ir.nasim.E90
                public final Object invokeSuspend(Object obj) {
                    AbstractC14862ic3.e();
                    if (this.b != 0) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    AbstractC10685c16.b(obj);
                    if ((!AbstractC20762sZ6.n0(a.f(this.d).s())) || a.f(this.d).y()) {
                        this.c.yb(EnumC10111b58.l, null);
                    }
                    return C19938rB7.a;
                }

                @Override // ir.nasim.InterfaceC14603iB2
                /* renamed from: n, reason: merged with bridge method [inline-methods] */
                public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
                    return ((f) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
                }
            }

            static final class g extends AbstractC19859r37 implements InterfaceC14603iB2 {
                int b;
                final /* synthetic */ S58 c;
                final /* synthetic */ InterfaceC9664aL6 d;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                g(S58 s58, InterfaceC9664aL6 interfaceC9664aL6, InterfaceC20295rm1 interfaceC20295rm1) {
                    super(2, interfaceC20295rm1);
                    this.c = s58;
                    this.d = interfaceC9664aL6;
                }

                @Override // ir.nasim.E90
                public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                    return new g(this.c, this.d, interfaceC20295rm1);
                }

                @Override // ir.nasim.E90
                public final Object invokeSuspend(Object obj) {
                    Object objE = AbstractC14862ic3.e();
                    int i = this.b;
                    if (i == 0) {
                        AbstractC10685c16.b(obj);
                        if (a.f(this.d).g()) {
                            this.b = 1;
                            if (HG1.b(50L, this) == objE) {
                                return objE;
                            }
                        }
                        return C19938rB7.a;
                    }
                    if (i != 1) {
                        if (i != 2) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        AbstractC10685c16.b(obj);
                        this.c.qb().C1();
                        return C19938rB7.a;
                    }
                    AbstractC10685c16.b(obj);
                    WebView webViewVb = this.c.vb();
                    if (webViewVb != null) {
                        S58 s58 = this.c;
                        s58.qb().X1(webViewVb, s58.tb());
                        s58.tb().a();
                    }
                    this.b = 2;
                    if (HG1.b(150L, this) == objE) {
                        return objE;
                    }
                    this.c.qb().C1();
                    return C19938rB7.a;
                }

                @Override // ir.nasim.InterfaceC14603iB2
                /* renamed from: n, reason: merged with bridge method [inline-methods] */
                public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
                    return ((g) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
                }
            }

            static final class h extends AbstractC19859r37 implements InterfaceC14603iB2 {
                int b;
                final /* synthetic */ InterfaceC9664aL6 c;
                final /* synthetic */ S58 d;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                h(InterfaceC9664aL6 interfaceC9664aL6, S58 s58, InterfaceC20295rm1 interfaceC20295rm1) {
                    super(2, interfaceC20295rm1);
                    this.c = interfaceC9664aL6;
                    this.d = s58;
                }

                @Override // ir.nasim.E90
                public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                    return new h(this.c, this.d, interfaceC20295rm1);
                }

                @Override // ir.nasim.E90
                public final Object invokeSuspend(Object obj) {
                    AbstractC14862ic3.e();
                    if (this.b != 0) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    AbstractC10685c16.b(obj);
                    AbstractC13801gq4 abstractC13801gq4H = a.f(this.c).h();
                    if (abstractC13801gq4H != null) {
                        S58 s58 = this.d;
                        if (!(abstractC13801gq4H instanceof AbstractC13801gq4.a)) {
                            throw new NoWhenBranchMatchedException();
                        }
                        C22042ua0 c22042ua0A = s58.ob().a(((AbstractC13801gq4.a) abstractC13801gq4H).a());
                        if (c22042ua0A != null) {
                            C22042ua0.w9(s58, c22042ua0A, false, null, 6, null);
                        }
                        s58.qb().u2();
                    }
                    return C19938rB7.a;
                }

                @Override // ir.nasim.InterfaceC14603iB2
                /* renamed from: n, reason: merged with bridge method [inline-methods] */
                public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
                    return ((h) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
                }
            }

            static final class i extends AbstractC19859r37 implements InterfaceC14603iB2 {
                int b;
                final /* synthetic */ S58 c;
                final /* synthetic */ InterfaceC9664aL6 d;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                i(S58 s58, InterfaceC9664aL6 interfaceC9664aL6, InterfaceC20295rm1 interfaceC20295rm1) {
                    super(2, interfaceC20295rm1);
                    this.c = s58;
                    this.d = interfaceC9664aL6;
                }

                @Override // ir.nasim.E90
                public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                    return new i(this.c, this.d, interfaceC20295rm1);
                }

                @Override // ir.nasim.E90
                public final Object invokeSuspend(Object obj) {
                    Object objE = AbstractC14862ic3.e();
                    int i = this.b;
                    if (i == 0) {
                        AbstractC10685c16.b(obj);
                        if (a.f(this.d).f()) {
                            this.c.mb();
                            this.b = 1;
                            if (HG1.b(250L, this) == objE) {
                                return objE;
                            }
                        }
                        return C19938rB7.a;
                    }
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    AbstractC10685c16.b(obj);
                    this.c.qb().C1();
                    return C19938rB7.a;
                }

                @Override // ir.nasim.InterfaceC14603iB2
                /* renamed from: n, reason: merged with bridge method [inline-methods] */
                public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
                    return ((i) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
                }
            }

            static final class j extends AbstractC19859r37 implements InterfaceC14603iB2 {
                int b;
                final /* synthetic */ S58 c;
                final /* synthetic */ InterfaceC9664aL6 d;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                j(S58 s58, InterfaceC9664aL6 interfaceC9664aL6, InterfaceC20295rm1 interfaceC20295rm1) {
                    super(2, interfaceC20295rm1);
                    this.c = s58;
                    this.d = interfaceC9664aL6;
                }

                @Override // ir.nasim.E90
                public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                    return new j(this.c, this.d, interfaceC20295rm1);
                }

                @Override // ir.nasim.E90
                public final Object invokeSuspend(Object obj) {
                    AbstractC14862ic3.e();
                    if (this.b != 0) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    AbstractC10685c16.b(obj);
                    if (a.f(this.d).e()) {
                        S58 s58 = this.c;
                        C22042ua0.m9(s58, s58, false, 2, null);
                    }
                    return C19938rB7.a;
                }

                @Override // ir.nasim.InterfaceC14603iB2
                /* renamed from: n, reason: merged with bridge method [inline-methods] */
                public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
                    return ((j) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
                }
            }

            a(S58 s58, ComposeView composeView) {
                this.a = s58;
                this.b = composeView;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final R68 f(InterfaceC9664aL6 interfaceC9664aL6) {
                return (R68) interfaceC9664aL6.getValue();
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final C19938rB7 h(S58 s58, InterfaceC9664aL6 interfaceC9664aL6) {
                AbstractC13042fc3.i(s58, "this$0");
                AbstractC13042fc3.i(interfaceC9664aL6, "$state$delegate");
                List listC0 = s58.Q7().B0().C0();
                AbstractC13042fc3.h(listC0, "getFragments(...)");
                Fragment fragment = (Fragment) AbstractC15401jX0.C0(listC0);
                if (!(fragment instanceof S58)) {
                    AbstractC13042fc3.f(fragment);
                    C22042ua0.m9(s58, fragment, false, 2, null);
                } else if (f(interfaceC9664aL6).l()) {
                    s58.yb(EnumC10111b58.h, null);
                } else if (C8386Vt0.hc() && f(interfaceC9664aL6).v()) {
                    s58.qb().Z1();
                } else {
                    s58.qb().Y1(Boolean.TRUE);
                }
                return C19938rB7.a;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final C19938rB7 i(S58 s58) {
                AbstractC13042fc3.i(s58, "this$0");
                s58.qb().Y1(Boolean.FALSE);
                return C19938rB7.a;
            }

            public final void d(InterfaceC22053ub1 interfaceC22053ub1, int i2) {
                if ((i2 & 3) == 2 && interfaceC22053ub1.k()) {
                    interfaceC22053ub1.L();
                    return;
                }
                final InterfaceC9664aL6 interfaceC9664aL6C = AbstractC5976Lq2.c(this.a.qb().M1(), null, null, null, interfaceC22053ub1, 0, 7);
                interfaceC22053ub1.W(107514950);
                Object objB = interfaceC22053ub1.B();
                InterfaceC22053ub1.a aVar = InterfaceC22053ub1.a;
                if (objB == aVar.a()) {
                    objB = new C19391qG6();
                    interfaceC22053ub1.s(objB);
                }
                C19391qG6 c19391qG6 = (C19391qG6) objB;
                interfaceC22053ub1.Q();
                AbstractC20942sr7 abstractC20942sr7O = f(interfaceC9664aL6C).o();
                interfaceC22053ub1.W(107517955);
                boolean zV = interfaceC22053ub1.V(interfaceC9664aL6C) | interfaceC22053ub1.D(this.a);
                S58 s58 = this.a;
                Object objB2 = interfaceC22053ub1.B();
                if (zV || objB2 == aVar.a()) {
                    objB2 = new C0615a(interfaceC9664aL6C, s58, null);
                    interfaceC22053ub1.s(objB2);
                }
                interfaceC22053ub1.Q();
                AbstractC10721c52.e(abstractC20942sr7O, (InterfaceC14603iB2) objB2, interfaceC22053ub1, 0);
                AbstractC10213bG6 abstractC10213bG6N = f(interfaceC9664aL6C).n();
                interfaceC22053ub1.W(107527899);
                boolean zV2 = interfaceC22053ub1.V(interfaceC9664aL6C) | interfaceC22053ub1.D(this.b) | interfaceC22053ub1.D(this.a);
                ComposeView composeView = this.b;
                S58 s582 = this.a;
                Object objB3 = interfaceC22053ub1.B();
                if (zV2 || objB3 == aVar.a()) {
                    objB3 = new e(interfaceC9664aL6C, c19391qG6, composeView, s582, null);
                    interfaceC22053ub1.s(objB3);
                }
                interfaceC22053ub1.Q();
                AbstractC10721c52.e(abstractC10213bG6N, (InterfaceC14603iB2) objB3, interfaceC22053ub1, 0);
                Boolean boolValueOf = Boolean.valueOf(f(interfaceC9664aL6C).y());
                String strS = f(interfaceC9664aL6C).s();
                interfaceC22053ub1.W(107538131);
                boolean zV3 = interfaceC22053ub1.V(interfaceC9664aL6C) | interfaceC22053ub1.D(this.a);
                S58 s583 = this.a;
                Object objB4 = interfaceC22053ub1.B();
                if (zV3 || objB4 == aVar.a()) {
                    objB4 = new f(s583, interfaceC9664aL6C, null);
                    interfaceC22053ub1.s(objB4);
                }
                interfaceC22053ub1.Q();
                AbstractC10721c52.f(boolValueOf, strS, (InterfaceC14603iB2) objB4, interfaceC22053ub1, 0);
                Boolean boolValueOf2 = Boolean.valueOf(f(interfaceC9664aL6C).g());
                interfaceC22053ub1.W(107546826);
                boolean zV4 = interfaceC22053ub1.V(interfaceC9664aL6C) | interfaceC22053ub1.D(this.a);
                S58 s584 = this.a;
                Object objB5 = interfaceC22053ub1.B();
                if (zV4 || objB5 == aVar.a()) {
                    objB5 = new g(s584, interfaceC9664aL6C, null);
                    interfaceC22053ub1.s(objB5);
                }
                interfaceC22053ub1.Q();
                AbstractC10721c52.e(boolValueOf2, (InterfaceC14603iB2) objB5, interfaceC22053ub1, 0);
                AbstractC13801gq4 abstractC13801gq4H = f(interfaceC9664aL6C).h();
                interfaceC22053ub1.W(107563277);
                boolean zV5 = interfaceC22053ub1.V(interfaceC9664aL6C) | interfaceC22053ub1.D(this.a);
                S58 s585 = this.a;
                Object objB6 = interfaceC22053ub1.B();
                if (zV5 || objB6 == aVar.a()) {
                    objB6 = new h(interfaceC9664aL6C, s585, null);
                    interfaceC22053ub1.s(objB6);
                }
                interfaceC22053ub1.Q();
                AbstractC10721c52.e(abstractC13801gq4H, (InterfaceC14603iB2) objB6, interfaceC22053ub1, 0);
                Boolean boolValueOf3 = Boolean.valueOf(f(interfaceC9664aL6C).f());
                interfaceC22053ub1.W(107583572);
                boolean zV6 = interfaceC22053ub1.V(interfaceC9664aL6C) | interfaceC22053ub1.D(this.a);
                S58 s586 = this.a;
                Object objB7 = interfaceC22053ub1.B();
                if (zV6 || objB7 == aVar.a()) {
                    objB7 = new i(s586, interfaceC9664aL6C, null);
                    interfaceC22053ub1.s(objB7);
                }
                interfaceC22053ub1.Q();
                AbstractC10721c52.e(boolValueOf3, (InterfaceC14603iB2) objB7, interfaceC22053ub1, 0);
                this.a.Xa(c19391qG6, interfaceC22053ub1, 6);
                Y48 y48Q = f(interfaceC9664aL6C).q();
                interfaceC22053ub1.W(107594002);
                if (y48Q != null) {
                    this.a.Ia(f(interfaceC9664aL6C).c(), y48Q, interfaceC22053ub1, 0);
                    C19938rB7 c19938rB7 = C19938rB7.a;
                }
                interfaceC22053ub1.Q();
                boolean z = (!f(interfaceC9664aL6C).w() || f(interfaceC9664aL6C).f() || f(interfaceC9664aL6C).g()) ? false : true;
                interfaceC22053ub1.W(107601628);
                boolean zD = interfaceC22053ub1.D(this.a) | interfaceC22053ub1.V(interfaceC9664aL6C);
                final S58 s587 = this.a;
                Object objB8 = interfaceC22053ub1.B();
                if (zD || objB8 == aVar.a()) {
                    objB8 = new SA2() { // from class: ir.nasim.T58
                        @Override // ir.nasim.SA2
                        public final Object invoke() {
                            return S58.b.a.h(s587, interfaceC9664aL6C);
                        }
                    };
                    interfaceC22053ub1.s(objB8);
                }
                interfaceC22053ub1.Q();
                UV.a(z, (SA2) objB8, interfaceC22053ub1, 0, 0);
                Boolean boolValueOf4 = Boolean.valueOf(f(interfaceC9664aL6C).e());
                interfaceC22053ub1.W(107625162);
                boolean zV7 = interfaceC22053ub1.V(interfaceC9664aL6C) | interfaceC22053ub1.D(this.a);
                S58 s588 = this.a;
                Object objB9 = interfaceC22053ub1.B();
                if (zV7 || objB9 == aVar.a()) {
                    objB9 = new j(s588, interfaceC9664aL6C, null);
                    interfaceC22053ub1.s(objB9);
                }
                interfaceC22053ub1.Q();
                AbstractC10721c52.e(boolValueOf4, (InterfaceC14603iB2) objB9, interfaceC22053ub1, 0);
                interfaceC22053ub1.W(107631401);
                if (f(interfaceC9664aL6C).d() != null) {
                    androidx.compose.ui.e eVarA = Ac8.a(androidx.compose.ui.e.a, 2.0f);
                    C22132uj0 c22132uj0D = f(interfaceC9664aL6C).d();
                    String strC = f(interfaceC9664aL6C).c();
                    Object objQb = this.a.qb();
                    interfaceC22053ub1.W(107640800);
                    boolean zD2 = interfaceC22053ub1.D(objQb);
                    Object objB10 = interfaceC22053ub1.B();
                    if (zD2 || objB10 == aVar.a()) {
                        objB10 = new C0616b(objQb);
                        interfaceC22053ub1.s(objB10);
                    }
                    InterfaceC16733lm3 interfaceC16733lm3 = (InterfaceC16733lm3) objB10;
                    interfaceC22053ub1.Q();
                    Object objQb2 = this.a.qb();
                    interfaceC22053ub1.W(107643070);
                    boolean zD3 = interfaceC22053ub1.D(objQb2);
                    Object objB11 = interfaceC22053ub1.B();
                    if (zD3 || objB11 == aVar.a()) {
                        objB11 = new c(objQb2);
                        interfaceC22053ub1.s(objB11);
                    }
                    interfaceC22053ub1.Q();
                    AbstractC20855sj0.d(c22132uj0D, strC, (InterfaceC14603iB2) interfaceC16733lm3, (SA2) ((InterfaceC16733lm3) objB11), eVarA, interfaceC22053ub1, C22132uj0.c | 24576, 0);
                }
                interfaceC22053ub1.Q();
                if (!f(interfaceC9664aL6C).x()) {
                    interfaceC22053ub1.W(-957638114);
                    AbstractC11024cc1.a(AbstractC13040fc1.n().d(EnumC12613eu3.a), AbstractC19242q11.e(599230778, true, new d(this.a, interfaceC9664aL6C), interfaceC22053ub1, 54), interfaceC22053ub1, C7252Qx5.i | 48);
                    interfaceC22053ub1.Q();
                    return;
                }
                interfaceC22053ub1.W(-957906202);
                interfaceC22053ub1.W(107649935);
                boolean zD4 = interfaceC22053ub1.D(this.a);
                final S58 s589 = this.a;
                Object objB12 = interfaceC22053ub1.B();
                if (zD4 || objB12 == aVar.a()) {
                    objB12 = new SA2() { // from class: ir.nasim.U58
                        @Override // ir.nasim.SA2
                        public final Object invoke() {
                            return S58.b.a.i(s589);
                        }
                    };
                    interfaceC22053ub1.s(objB12);
                }
                interfaceC22053ub1.Q();
                CG3.g(null, (SA2) objB12, null, interfaceC22053ub1, 0, 5);
                interfaceC22053ub1.Q();
            }

            @Override // ir.nasim.InterfaceC14603iB2
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                d((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
                return C19938rB7.a;
            }
        }

        b(ComposeView composeView) {
            this.b = composeView;
        }

        public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
            if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                interfaceC22053ub1.L();
            } else {
                M10.f(false, AbstractC19242q11.e(-1266192907, true, new a(S58.this, this.b), interfaceC22053ub1, 54), interfaceC22053ub1, 48, 1);
            }
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
            return C19938rB7.a;
        }
    }

    public static final class c extends AbstractC8614Ws3 implements SA2 {
        final /* synthetic */ Fragment e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(Fragment fragment) {
            super(0);
            this.e = fragment;
        }

        @Override // ir.nasim.SA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Fragment invoke() {
            return this.e;
        }
    }

    public static final class d extends AbstractC8614Ws3 implements SA2 {
        final /* synthetic */ SA2 e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(SA2 sa2) {
            super(0);
            this.e = sa2;
        }

        @Override // ir.nasim.SA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final InterfaceC15408jX7 invoke() {
            return (InterfaceC15408jX7) this.e.invoke();
        }
    }

    public static final class e extends AbstractC8614Ws3 implements SA2 {
        final /* synthetic */ InterfaceC9173Yu3 e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(InterfaceC9173Yu3 interfaceC9173Yu3) {
            super(0);
            this.e = interfaceC9173Yu3;
        }

        @Override // ir.nasim.SA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final C14819iX7 invoke() {
            return AbstractC6550Nz2.c(this.e).d1();
        }
    }

    public static final class f extends AbstractC8614Ws3 implements SA2 {
        final /* synthetic */ SA2 e;
        final /* synthetic */ InterfaceC9173Yu3 f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(SA2 sa2, InterfaceC9173Yu3 interfaceC9173Yu3) {
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

    public static final class g extends AbstractC8614Ws3 implements SA2 {
        final /* synthetic */ Fragment e;
        final /* synthetic */ InterfaceC9173Yu3 f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public g(Fragment fragment, InterfaceC9173Yu3 interfaceC9173Yu3) {
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

    public S58() {
        InterfaceC9173Yu3 interfaceC9173Yu3B = AbstractC13269fw3.b(EnumC4870Gx3.c, new d(new c(this)));
        this.viewModel = AbstractC6550Nz2.b(this, AbstractC10882cM5.b(C10747c78.class), new e(interfaceC9173Yu3B), new f(null, interfaceC9173Yu3B), new g(this, interfaceC9173Yu3B));
        AbstractC22357v6 abstractC22357v6N7 = N7(new C20490s6(), new InterfaceC17517n6() { // from class: ir.nasim.J58
            @Override // ir.nasim.InterfaceC17517n6
            public final void a(Object obj) {
                S58.nb(this.a, (ActivityResult) obj);
            }
        });
        AbstractC13042fc3.h(abstractC22357v6N7, "registerForActivityResult(...)");
        this.fileChooserResultLauncher = abstractC22357v6N7;
        this.webView = AbstractC13269fw3.a(new SA2() { // from class: ir.nasim.R58
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return S58.Xb(this.a);
            }
        });
        this.webAppInterface = AbstractC13269fw3.a(new SA2() { // from class: ir.nasim.d58
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return S58.Ub(this.a);
            }
        });
        this.webAppNavigator = AbstractC13269fw3.a(new SA2() { // from class: ir.nasim.e58
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return S58.Vb(this.a);
            }
        });
        this.webAppClient = AbstractC13269fw3.a(new SA2() { // from class: ir.nasim.f58
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return S58.Tb(this.a);
            }
        });
        this.webAppChromeClient = AbstractC13269fw3.a(new SA2() { // from class: ir.nasim.g58
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return S58.Sb(this.a);
            }
        });
        this.toolbarCallBack = new C3869Cr7(new SA2() { // from class: ir.nasim.h58
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return S58.Kb(this.a);
            }
        }, new SA2() { // from class: ir.nasim.i58
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return S58.Lb(this.a);
            }
        }, new SA2() { // from class: ir.nasim.j58
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return S58.Mb(this.a);
            }
        }, new SA2() { // from class: ir.nasim.k58
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return S58.Nb(this.a);
            }
        }, new SA2() { // from class: ir.nasim.M58
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return S58.Pb(this.a);
            }
        }, new SA2() { // from class: ir.nasim.N58
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return S58.Qb(this.a);
            }
        }, new SA2() { // from class: ir.nasim.O58
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return S58.Rb(this.a);
            }
        });
        AbstractC22357v6 abstractC22357v6N72 = N7(new C19881r6(), new InterfaceC17517n6() { // from class: ir.nasim.P58
            @Override // ir.nasim.InterfaceC17517n6
            public final void a(Object obj) {
                S58.Fb(this.a, (Boolean) obj);
            }
        });
        AbstractC13042fc3.h(abstractC22357v6N72, "registerForActivityResult(...)");
        this.qrScannerPermissionResultLauncher = abstractC22357v6N72;
        AbstractC22357v6 abstractC22357v6N73 = N7(new C20490s6(), new InterfaceC17517n6() { // from class: ir.nasim.Q58
            @Override // ir.nasim.InterfaceC17517n6
            public final void a(Object obj) throws JSONException {
                S58.Gb(this.a, (ActivityResult) obj);
            }
        });
        AbstractC13042fc3.h(abstractC22357v6N73, "registerForActivityResult(...)");
        this.qrScannerResultLauncher = abstractC22357v6N73;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Ab(S58 s58, String str) {
        AbstractC13042fc3.i(s58, "this$0");
        AbstractC13042fc3.i(str, "$invoiceParams");
        if (s58.A6() || s58.v6() || !s58.u6()) {
            return;
        }
        C22042ua0.A9(s58, ir.nasim.features.bank.mybank.webview.a.r1.a(s58.pb().e5() + "?bot_id=" + s58.qb().G1().getBotId() + str, false), false, null, 6, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Bb(final S58 s58) {
        AbstractC13042fc3.i(s58, "this$0");
        FragmentActivity fragmentActivityA5 = s58.A5();
        if (fragmentActivityA5 == null) {
            return;
        }
        C21753u45 c21753u45 = C21753u45.a;
        if (c21753u45.R(fragmentActivityA5)) {
            s58.xb();
            return;
        }
        c21753u45.B0(fragmentActivityA5, C21753u45.d.f, (SetRpcStruct$ComposedRpc.SEARCH_CONTACTS_FIELD_NUMBER & 4) != 0 ? null : Integer.valueOf(WD5.cameraBarCodeScanner_permission_desctiption), new SA2() { // from class: ir.nasim.c58
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return S58.Cb(this.a);
            }
        }, (SetRpcStruct$ComposedRpc.SEARCH_CONTACTS_FIELD_NUMBER & 16) != 0 ? new SA2() { // from class: ir.nasim.Y35
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return C21753u45.D0();
            }
        } : new SA2() { // from class: ir.nasim.n58
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return S58.Db(this.a);
            }
        }, (SetRpcStruct$ComposedRpc.SEARCH_CONTACTS_FIELD_NUMBER & 32) != 0 ? new SA2() { // from class: ir.nasim.Z35
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return C21753u45.E0();
            }
        } : new SA2() { // from class: ir.nasim.y58
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return S58.Eb(this.a);
            }
        }, (SetRpcStruct$ComposedRpc.SEARCH_CONTACTS_FIELD_NUMBER & 64) != 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 Cb(S58 s58) {
        AbstractC13042fc3.i(s58, "this$0");
        s58.qrScannerPermissionResultLauncher.a(C21753u45.d.f.q());
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 Db(S58 s58) {
        AbstractC13042fc3.i(s58, "this$0");
        s58.yb(EnumC10111b58.k, null);
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 Eb(S58 s58) {
        AbstractC13042fc3.i(s58, "this$0");
        s58.yb(EnumC10111b58.k, null);
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Fb(S58 s58, Boolean bool) {
        AbstractC13042fc3.i(s58, "this$0");
        AbstractC13042fc3.i(bool, "isGranted");
        if (bool.booleanValue()) {
            s58.xb();
        } else {
            s58.yb(EnumC10111b58.k, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Gb(S58 s58, ActivityResult activityResult) throws JSONException {
        Bundle extras;
        AbstractC13042fc3.i(s58, "this$0");
        AbstractC13042fc3.i(activityResult, "result");
        if (activityResult.getResultCode() != -1) {
            s58.yb(EnumC10111b58.k, null);
            return;
        }
        Intent data = activityResult.getData();
        if (data == null || (extras = data.getExtras()) == null) {
            return;
        }
        String string = extras.getString("scanResult", "");
        if (XY6.m(string)) {
            s58.yb(EnumC10111b58.k, null);
            return;
        }
        JSONObject jSONObject = new JSONObject();
        jSONObject.put(ParameterNames.TEXT, string);
        s58.yb(EnumC10111b58.j, jSONObject);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 Hb(S58 s58, JSONObject jSONObject, String str) throws JSONException {
        Object objB;
        AbstractC13042fc3.i(s58, "this$0");
        AbstractC13042fc3.i(jSONObject, "$jsonObject");
        AbstractC13042fc3.i(str, "resultData");
        try {
            C9475a16.a aVar = C9475a16.b;
            objB = C9475a16.b(new JSONTokener(str).nextValue());
        } catch (Throwable th) {
            C9475a16.a aVar2 = C9475a16.b;
            objB = C9475a16.b(AbstractC10685c16.a(th));
        }
        if (C9475a16.j(objB)) {
            jSONObject.put("result", objB);
        }
        Throwable thE = C9475a16.e(objB);
        if (thE != null) {
            C19406qI3.a("WEBAPP", "The result cannot be converted to jsonToken. error message: " + thE.getMessage(), new Object[0]);
        }
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Ia(final String str, final Y48 y48, InterfaceC22053ub1 interfaceC22053ub1, final int i) {
        int i2;
        InterfaceC22053ub1 interfaceC22053ub1J = interfaceC22053ub1.j(1349160982);
        if ((i & 6) == 0) {
            i2 = (interfaceC22053ub1J.V(str) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= interfaceC22053ub1J.V(y48) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= interfaceC22053ub1J.D(this) ? 256 : 128;
        }
        if ((i2 & 147) == 146 && interfaceC22053ub1J.k()) {
            interfaceC22053ub1J.L();
        } else if (AbstractC13042fc3.d(y48, Y48.e.a)) {
            interfaceC22053ub1J.W(-1687898956);
            interfaceC22053ub1J.W(-608635739);
            boolean zD = interfaceC22053ub1J.D(this);
            Object objB = interfaceC22053ub1J.B();
            if (zD || objB == InterfaceC22053ub1.a.a()) {
                objB = new SA2() { // from class: ir.nasim.s58
                    @Override // ir.nasim.SA2
                    public final Object invoke() {
                        return S58.Ja(this.a);
                    }
                };
                interfaceC22053ub1J.s(objB);
            }
            SA2 sa2 = (SA2) objB;
            interfaceC22053ub1J.Q();
            interfaceC22053ub1J.W(-608631344);
            boolean zD2 = interfaceC22053ub1J.D(this);
            Object objB2 = interfaceC22053ub1J.B();
            if (zD2 || objB2 == InterfaceC22053ub1.a.a()) {
                objB2 = new SA2() { // from class: ir.nasim.x58
                    @Override // ir.nasim.SA2
                    public final Object invoke() {
                        return S58.Ka(this.a);
                    }
                };
                interfaceC22053ub1J.s(objB2);
            }
            SA2 sa22 = (SA2) objB2;
            interfaceC22053ub1J.Q();
            interfaceC22053ub1J.W(-608626475);
            boolean zD3 = interfaceC22053ub1J.D(this);
            Object objB3 = interfaceC22053ub1J.B();
            if (zD3 || objB3 == InterfaceC22053ub1.a.a()) {
                objB3 = new SA2() { // from class: ir.nasim.z58
                    @Override // ir.nasim.SA2
                    public final Object invoke() {
                        return S58.La(this.a);
                    }
                };
                interfaceC22053ub1J.s(objB3);
            }
            interfaceC22053ub1J.Q();
            AbstractC4757Gk7.d(str, sa2, sa22, (SA2) objB3, interfaceC22053ub1J, i2 & 14);
            interfaceC22053ub1J.Q();
        } else if (AbstractC13042fc3.d(y48, Y48.a.a)) {
            interfaceC22053ub1J.W(-1687336895);
            interfaceC22053ub1J.W(-608617081);
            boolean zD4 = interfaceC22053ub1J.D(this);
            Object objB4 = interfaceC22053ub1J.B();
            if (zD4 || objB4 == InterfaceC22053ub1.a.a()) {
                objB4 = new SA2() { // from class: ir.nasim.A58
                    @Override // ir.nasim.SA2
                    public final Object invoke() {
                        return S58.Ma(this.a);
                    }
                };
                interfaceC22053ub1J.s(objB4);
            }
            SA2 sa23 = (SA2) objB4;
            interfaceC22053ub1J.Q();
            interfaceC22053ub1J.W(-608612560);
            boolean zD5 = interfaceC22053ub1J.D(this);
            Object objB5 = interfaceC22053ub1J.B();
            if (zD5 || objB5 == InterfaceC22053ub1.a.a()) {
                objB5 = new SA2() { // from class: ir.nasim.B58
                    @Override // ir.nasim.SA2
                    public final Object invoke() {
                        return S58.Na(this.a);
                    }
                };
                interfaceC22053ub1J.s(objB5);
            }
            interfaceC22053ub1J.Q();
            AbstractC24498yj0.b(str, sa23, (SA2) objB5, interfaceC22053ub1J, i2 & 14);
            interfaceC22053ub1J.Q();
        } else if (AbstractC13042fc3.d(y48, Y48.b.a)) {
            interfaceC22053ub1J.W(-1686922239);
            interfaceC22053ub1J.W(-608604752);
            boolean zD6 = interfaceC22053ub1J.D(this);
            Object objB6 = interfaceC22053ub1J.B();
            if (zD6 || objB6 == InterfaceC22053ub1.a.a()) {
                objB6 = new SA2() { // from class: ir.nasim.C58
                    @Override // ir.nasim.SA2
                    public final Object invoke() {
                        return S58.Oa(this.a);
                    }
                };
                interfaceC22053ub1J.s(objB6);
            }
            SA2 sa24 = (SA2) objB6;
            interfaceC22053ub1J.Q();
            interfaceC22053ub1J.W(-608600238);
            boolean zD7 = interfaceC22053ub1J.D(this);
            Object objB7 = interfaceC22053ub1J.B();
            if (zD7 || objB7 == InterfaceC22053ub1.a.a()) {
                objB7 = new SA2() { // from class: ir.nasim.D58
                    @Override // ir.nasim.SA2
                    public final Object invoke() {
                        return S58.Pa(this.a);
                    }
                };
                interfaceC22053ub1J.s(objB7);
            }
            interfaceC22053ub1J.Q();
            AbstractC13050fd1.b(sa24, (SA2) objB7, interfaceC22053ub1J, 0);
            interfaceC22053ub1J.Q();
        } else if (y48 instanceof Y48.d) {
            interfaceC22053ub1J.W(-1686576527);
            interfaceC22053ub1J.W(-608593702);
            boolean zD8 = ((i2 & SetRpcStruct$ComposedRpc.SEARCH_CONTACTS_FIELD_NUMBER) == 32) | interfaceC22053ub1J.D(this);
            Object objB8 = interfaceC22053ub1J.B();
            if (zD8 || objB8 == InterfaceC22053ub1.a.a()) {
                objB8 = new SA2() { // from class: ir.nasim.E58
                    @Override // ir.nasim.SA2
                    public final Object invoke() {
                        return S58.Qa(this.a, y48);
                    }
                };
                interfaceC22053ub1J.s(objB8);
            }
            SA2 sa25 = (SA2) objB8;
            interfaceC22053ub1J.Q();
            interfaceC22053ub1J.W(-608571819);
            boolean zD9 = interfaceC22053ub1J.D(this);
            Object objB9 = interfaceC22053ub1J.B();
            if (zD9 || objB9 == InterfaceC22053ub1.a.a()) {
                objB9 = new SA2() { // from class: ir.nasim.F58
                    @Override // ir.nasim.SA2
                    public final Object invoke() {
                        return S58.Ra(this.a);
                    }
                };
                interfaceC22053ub1J.s(objB9);
            }
            interfaceC22053ub1J.Q();
            AbstractC19120po6.b(sa25, (SA2) objB9, interfaceC22053ub1J, 0);
            interfaceC22053ub1J.Q();
        } else if (y48 instanceof Y48.c) {
            interfaceC22053ub1J.W(-1685522155);
            Y48.c cVar = (Y48.c) y48;
            final D88 d88A = cVar.a();
            C21753u45.g gVarC = d88A.c();
            String strB = cVar.b();
            interfaceC22053ub1J.W(-608553300);
            boolean zV = interfaceC22053ub1J.V(d88A) | interfaceC22053ub1J.D(this);
            Object objB10 = interfaceC22053ub1J.B();
            if (zV || objB10 == InterfaceC22053ub1.a.a()) {
                objB10 = new SA2() { // from class: ir.nasim.G58
                    @Override // ir.nasim.SA2
                    public final Object invoke() {
                        return S58.Sa(d88A, this);
                    }
                };
                interfaceC22053ub1J.s(objB10);
            }
            SA2 sa26 = (SA2) objB10;
            interfaceC22053ub1J.Q();
            interfaceC22053ub1J.W(-608548148);
            boolean zV2 = interfaceC22053ub1J.V(d88A) | interfaceC22053ub1J.D(this);
            Object objB11 = interfaceC22053ub1J.B();
            if (zV2 || objB11 == InterfaceC22053ub1.a.a()) {
                objB11 = new SA2() { // from class: ir.nasim.t58
                    @Override // ir.nasim.SA2
                    public final Object invoke() {
                        return S58.Ta(d88A, this);
                    }
                };
                interfaceC22053ub1J.s(objB11);
            }
            interfaceC22053ub1J.Q();
            AbstractC21102t68.b(gVarC, strB, sa26, (SA2) objB11, interfaceC22053ub1J, 0);
            interfaceC22053ub1J.Q();
        } else {
            if (!AbstractC13042fc3.d(y48, Y48.f.a)) {
                interfaceC22053ub1J.W(-608636805);
                interfaceC22053ub1J.Q();
                throw new NoWhenBranchMatchedException();
            }
            interfaceC22053ub1J.W(-1684914121);
            interfaceC22053ub1J.W(-608539361);
            boolean zD10 = interfaceC22053ub1J.D(this);
            Object objB12 = interfaceC22053ub1J.B();
            if (zD10 || objB12 == InterfaceC22053ub1.a.a()) {
                objB12 = new SA2() { // from class: ir.nasim.u58
                    @Override // ir.nasim.SA2
                    public final Object invoke() {
                        return S58.Ua(this.a);
                    }
                };
                interfaceC22053ub1J.s(objB12);
            }
            SA2 sa27 = (SA2) objB12;
            interfaceC22053ub1J.Q();
            interfaceC22053ub1J.W(-608535088);
            boolean zD11 = interfaceC22053ub1J.D(this);
            Object objB13 = interfaceC22053ub1J.B();
            if (zD11 || objB13 == InterfaceC22053ub1.a.a()) {
                objB13 = new SA2() { // from class: ir.nasim.v58
                    @Override // ir.nasim.SA2
                    public final Object invoke() {
                        return S58.Va(this.a);
                    }
                };
                interfaceC22053ub1J.s(objB13);
            }
            interfaceC22053ub1J.Q();
            AbstractC10169bB7.b(str, sa27, (SA2) objB13, interfaceC22053ub1J, i2 & 14);
            interfaceC22053ub1J.Q();
        }
        InterfaceC20208rd6 interfaceC20208rd6M = interfaceC22053ub1J.m();
        if (interfaceC20208rd6M != null) {
            interfaceC20208rd6M.a(new InterfaceC14603iB2() { // from class: ir.nasim.w58
                @Override // ir.nasim.InterfaceC14603iB2
                public final Object invoke(Object obj, Object obj2) {
                    return S58.Wa(this.a, str, y48, i, (InterfaceC22053ub1) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 Ib(JSONObject jSONObject, String str) throws JSONException {
        AbstractC13042fc3.i(jSONObject, "$jsonObject");
        AbstractC13042fc3.i(str, "it");
        jSONObject.put("error", str);
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 Ja(S58 s58) {
        AbstractC13042fc3.i(s58, "this$0");
        s58.qb().t2();
        s58.qb().Y2();
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 Jb(S58 s58, JSONObject jSONObject) {
        AbstractC13042fc3.i(s58, "this$0");
        AbstractC13042fc3.i(jSONObject, "$jsonObject");
        s58.yb(EnumC10111b58.i, jSONObject);
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 Ka(S58 s58) {
        AbstractC13042fc3.i(s58, "this$0");
        s58.qb().t2();
        s58.qb().Y1(Boolean.FALSE);
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 Kb(S58 s58) {
        AbstractC13042fc3.i(s58, "this$0");
        s58.qb().G2(EnumC8066Uj4.f);
        s58.yb(EnumC10111b58.c, null);
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 La(S58 s58) {
        AbstractC13042fc3.i(s58, "this$0");
        s58.qb().t2();
        C10747c78 c10747c78Qb = s58.qb();
        Context contextS7 = s58.S7();
        AbstractC13042fc3.h(contextS7, "requireContext(...)");
        c10747c78Qb.s2(contextS7);
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 Lb(S58 s58) {
        AbstractC13042fc3.i(s58, "this$0");
        s58.ub().d();
        s58.qb().g2();
        s58.qb().G2(EnumC8066Uj4.d);
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 Ma(S58 s58) {
        AbstractC13042fc3.i(s58, "this$0");
        s58.qb().t2();
        s58.qb().S2();
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 Mb(S58 s58) {
        AbstractC13042fc3.i(s58, "this$0");
        C10747c78 c10747c78Qb = s58.qb();
        Context contextS7 = s58.S7();
        AbstractC13042fc3.h(contextS7, "requireContext(...)");
        c10747c78Qb.s2(contextS7);
        s58.qb().G2(EnumC8066Uj4.e);
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 Na(S58 s58) {
        AbstractC13042fc3.i(s58, "this$0");
        s58.qb().t2();
        s58.qb().Y1(Boolean.FALSE);
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 Nb(final S58 s58) {
        AbstractC13042fc3.i(s58, "this$0");
        s58.qb().G2(EnumC8066Uj4.b);
        s58.qb().E1(new WeakReference(new UA2() { // from class: ir.nasim.p58
            @Override // ir.nasim.UA2
            public final Object invoke(Object obj) {
                return S58.Ob(this.a, ((Boolean) obj).booleanValue());
            }
        }));
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 Oa(S58 s58) {
        AbstractC13042fc3.i(s58, "this$0");
        s58.qb().t2();
        s58.qb().Y1(Boolean.FALSE);
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 Ob(S58 s58, boolean z) {
        AbstractC13042fc3.i(s58, "this$0");
        if (z) {
            s58.qb().G2(EnumC8066Uj4.c);
        }
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 Pa(S58 s58) {
        AbstractC13042fc3.i(s58, "this$0");
        s58.qb().t2();
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 Pb(S58 s58) {
        AbstractC13042fc3.i(s58, "this$0");
        s58.yb(EnumC10111b58.h, null);
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 Qa(S58 s58, Y48 y48) throws JSONException {
        AbstractC13042fc3.i(s58, "this$0");
        AbstractC13042fc3.i(y48, "$dialogState");
        s58.qb().t2();
        s58.qb().z2();
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("status", "sent");
        Y48.d dVar = (Y48.d) y48;
        if (dVar.a() != null) {
            jSONObject.put("phone_number", dVar.a());
        }
        s58.yb(EnumC10111b58.d, jSONObject);
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 Qb(S58 s58) {
        AbstractC13042fc3.i(s58, "this$0");
        if (C8386Vt0.hc()) {
            s58.qb().Z1();
        }
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 Ra(S58 s58) {
        AbstractC13042fc3.i(s58, "this$0");
        s58.qb().t2();
        s58.yb(EnumC10111b58.d, new JSONObject().put("status", "cancelled"));
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 Rb(S58 s58) {
        AbstractC13042fc3.i(s58, "this$0");
        s58.qb().Y1(Boolean.TRUE);
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 Sa(D88 d88, S58 s58) {
        AbstractC13042fc3.i(d88, "$requestState");
        AbstractC13042fc3.i(s58, "this$0");
        d88.a().invoke();
        s58.qb().t2();
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final MD Sb(S58 s58) {
        AbstractC13042fc3.i(s58, "this$0");
        FragmentActivity fragmentActivityQ7 = s58.Q7();
        AbstractC13042fc3.h(fragmentActivityQ7, "requireActivity(...)");
        return new MD(fragmentActivityQ7, s58);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 Ta(D88 d88, S58 s58) {
        AbstractC13042fc3.i(d88, "$requestState");
        AbstractC13042fc3.i(s58, "this$0");
        d88.b().invoke();
        s58.qb().t2();
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final U68 Tb(S58 s58) {
        AbstractC13042fc3.i(s58, "this$0");
        return new U68(s58);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 Ua(S58 s58) {
        AbstractC13042fc3.i(s58, "this$0");
        s58.qb().t2();
        s58.qb().a3();
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C12144e68 Ub(S58 s58) {
        C12144e68 c12144e68B;
        AbstractC13042fc3.i(s58, "this$0");
        if (!s58.qb().R1()) {
            return new C12144e68(s58);
        }
        C12144e68 c12144e68I1 = s58.qb().I1();
        return (c12144e68I1 == null || (c12144e68B = c12144e68I1.b(s58)) == null) ? new C12144e68(s58) : c12144e68B;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 Va(S58 s58) {
        AbstractC13042fc3.i(s58, "this$0");
        s58.qb().t2();
        s58.qb().Y1(Boolean.FALSE);
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C13323g20 Vb(S58 s58) {
        AbstractC13042fc3.i(s58, "this$0");
        return new C13323g20(AbstractC19224pz3.a(s58));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 Wa(S58 s58, String str, Y48 y48, int i, InterfaceC22053ub1 interfaceC22053ub1, int i2) {
        AbstractC13042fc3.i(s58, "$tmp13_rcvr");
        AbstractC13042fc3.i(str, "$botName");
        AbstractC13042fc3.i(y48, "$dialogState");
        s58.Ia(str, y48, interfaceC22053ub1, QJ5.a(i | 1));
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 Wb(S58 s58, boolean z) {
        AbstractC13042fc3.i(s58, "this$0");
        if (z) {
            s58.yb(EnumC10111b58.e, null);
        } else {
            s58.yb(EnumC10111b58.g, null);
        }
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Xa(final C19391qG6 c19391qG6, InterfaceC22053ub1 interfaceC22053ub1, final int i) {
        int i2;
        InterfaceC22053ub1 interfaceC22053ub1J = interfaceC22053ub1.j(-1110052123);
        if ((i & 6) == 0) {
            i2 = (interfaceC22053ub1J.V(c19391qG6) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i2 & 3) == 2 && interfaceC22053ub1J.k()) {
            interfaceC22053ub1J.L();
        } else {
            e.a aVar = androidx.compose.ui.e.a;
            androidx.compose.ui.e eVarF = androidx.compose.foundation.layout.t.f(aVar, 0.0f, 1, null);
            InterfaceC12529em.a aVar2 = InterfaceC12529em.a;
            InterfaceC10970cW3 interfaceC10970cW3G = androidx.compose.foundation.layout.f.g(aVar2.o(), false);
            int iA = AbstractC6797Pa1.a(interfaceC22053ub1J, 0);
            InterfaceC11819dc1 interfaceC11819dc1Q = interfaceC22053ub1J.q();
            androidx.compose.ui.e eVarE = androidx.compose.ui.c.e(interfaceC22053ub1J, eVarF);
            InterfaceC16030kb1.a aVar3 = InterfaceC16030kb1.d0;
            SA2 sa2A = aVar3.a();
            if (!(interfaceC22053ub1J.l() instanceof InterfaceC15247jG)) {
                AbstractC6797Pa1.c();
            }
            interfaceC22053ub1J.G();
            if (interfaceC22053ub1J.h()) {
                interfaceC22053ub1J.g(sa2A);
            } else {
                interfaceC22053ub1J.r();
            }
            InterfaceC22053ub1 interfaceC22053ub1A = DG7.a(interfaceC22053ub1J);
            DG7.c(interfaceC22053ub1A, interfaceC10970cW3G, aVar3.e());
            DG7.c(interfaceC22053ub1A, interfaceC11819dc1Q, aVar3.g());
            InterfaceC14603iB2 interfaceC14603iB2B = aVar3.b();
            if (interfaceC22053ub1A.h() || !AbstractC13042fc3.d(interfaceC22053ub1A.B(), Integer.valueOf(iA))) {
                interfaceC22053ub1A.s(Integer.valueOf(iA));
                interfaceC22053ub1A.v(Integer.valueOf(iA), interfaceC14603iB2B);
            }
            DG7.c(interfaceC22053ub1A, eVarE, aVar3.f());
            AbstractC18209oG6.b(c19391qG6, androidx.compose.foundation.layout.h.a.h(aVar, aVar2.b()), C6303Na1.a.a(), interfaceC22053ub1J, (i2 & 14) | 384, 0);
            interfaceC22053ub1J.u();
        }
        InterfaceC20208rd6 interfaceC20208rd6M = interfaceC22053ub1J.m();
        if (interfaceC20208rd6M != null) {
            interfaceC20208rd6M.a(new InterfaceC14603iB2() { // from class: ir.nasim.q58
                @Override // ir.nasim.InterfaceC14603iB2
                public final Object invoke(Object obj, Object obj2) {
                    return S58.Ya(this.a, c19391qG6, i, (InterfaceC22053ub1) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final WebView Xb(S58 s58) {
        WebView webView;
        AbstractC13042fc3.i(s58, "this$0");
        try {
            FragmentActivity fragmentActivityQ7 = s58.Q7();
            AbstractC13042fc3.h(fragmentActivityQ7, "requireActivity(...)");
            if (s58.qb().R1()) {
                webView = s58.qb().J1();
                if (webView != null) {
                    s58.lb(webView);
                } else {
                    webView = new WebView(fragmentActivityQ7);
                    s58.lb(webView);
                }
            } else {
                webView = new WebView(fragmentActivityQ7);
                s58.lb(webView);
            }
            return webView;
        } catch (AndroidRuntimeException unused) {
            s58.qb().k2();
            return null;
        } catch (Exception e2) {
            C19406qI3.c("WEBAPP", "WebView init error", e2);
            s58.qb().C1();
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 Ya(S58 s58, C19391qG6 c19391qG6, int i, InterfaceC22053ub1 interfaceC22053ub1, int i2) {
        AbstractC13042fc3.i(s58, "$tmp0_rcvr");
        AbstractC13042fc3.i(c19391qG6, "$snackBarState");
        s58.Xa(c19391qG6, interfaceC22053ub1, QJ5.a(i | 1));
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void kb(S58 s58) throws JSONException {
        AbstractC13042fc3.i(s58, "this$0");
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("status", Build.VERSION.SDK_INT >= 26 ? s58.qb().S1() ? "added" : "missed" : "unsupported");
        s58.yb(EnumC10111b58.f, jSONObject);
    }

    private final void lb(WebView webView) {
        webView.getSettings().setUserAgentString(X48.N());
        webView.getSettings().setJavaScriptEnabled(true);
        webView.getSettings().setDomStorageEnabled(true);
        webView.getSettings().setAllowFileAccess(false);
        webView.getSettings().setAllowContentAccess(false);
        webView.getSettings().setGeolocationEnabled(true);
        webView.getSettings().setSupportMultipleWindows(true);
        webView.addJavascriptInterface(tb(), "BaleWebApp");
        GeolocationPermissions.getInstance().clearAll();
        CookieManager cookieManager = CookieManager.getInstance();
        cookieManager.setAcceptCookie(true);
        cookieManager.setAcceptThirdPartyCookies(webView, true);
        cookieManager.flush();
        WebView.setWebContentsDebuggingEnabled(qb().T1());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void mb() {
        yb(EnumC10111b58.m, null);
        WebView webViewVb = vb();
        if (webViewVb != null) {
            webViewVb.getSettings().setJavaScriptEnabled(false);
            webViewVb.getSettings().setDomStorageEnabled(false);
            webViewVb.getSettings().setAllowContentAccess(false);
            webViewVb.getSettings().setAllowFileAccess(false);
            webViewVb.getSettings().setGeolocationEnabled(false);
        }
        this.filePathCallback = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void nb(S58 s58, ActivityResult activityResult) {
        AbstractC13042fc3.i(s58, "this$0");
        AbstractC13042fc3.i(activityResult, "result");
        s58.wb(activityResult.getResultCode(), activityResult.getData());
        s58.qb().p2();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final C10747c78 qb() {
        return (C10747c78) this.viewModel.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final C24380yX rb() {
        return (C24380yX) this.webAppChromeClient.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final U68 sb() {
        return (U68) this.webAppClient.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final C12144e68 tb() {
        return (C12144e68) this.webAppInterface.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final C13323g20 ub() {
        return (C13323g20) this.webAppNavigator.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final WebView vb() {
        return (WebView) this.webView.getValue();
    }

    private final void wb(int resultCode, Intent data) {
        Uri[] uriArr;
        Uri uri;
        if (resultCode != -1 || data == null) {
            uriArr = null;
        } else {
            String dataString = data.getDataString();
            if (dataString == null || (uri = Uri.parse(dataString)) == null) {
                uri = Uri.EMPTY;
            }
            uriArr = new Uri[]{uri};
        }
        ValueCallback valueCallback = this.filePathCallback;
        if (valueCallback != null) {
            valueCallback.onReceiveValue(uriArr);
        }
    }

    private final void xb() {
        this.qrScannerResultLauncher.a(new Intent(S7(), (Class<?>) SimpleScannerActivity.class));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void yb(EnumC10111b58 webAppEventType, JSONObject eventData) {
        WebView webViewVb = vb();
        if (webViewVb != null) {
            webViewVb.evaluateJavascript("window.Bale.receiveEvent('" + webAppEventType.j() + "', " + eventData + Separators.RPAREN, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 zb() {
        Log.e("WEBAPP", "onWebViewLocationPermissionRequest: ");
        return C19938rB7.a;
    }

    @Override // ir.nasim.InterfaceC14560i68
    public void A4(final String invoiceParams) {
        AbstractC13042fc3.i(invoiceParams, "invoiceParams");
        if (C8386Vt0.jc()) {
            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: ir.nasim.l58
                @Override // java.lang.Runnable
                public final void run() {
                    S58.Ab(this.a, invoiceParams);
                }
            });
        }
    }

    @Override // ir.nasim.ND
    public void F4(int newProgress) {
        qb().o2(newProgress);
    }

    @Override // ir.nasim.ND
    public void I2(ValueCallback filePathCallback, WebChromeClient.FileChooserParams fileChooserParams) {
        Intent intent;
        this.filePathCallback = filePathCallback;
        if (fileChooserParams == null || (intent = fileChooserParams.createIntent()) == null) {
            intent = new Intent("android.intent.action.GET_CONTENT");
            intent.addCategory("android.intent.category.OPENABLE");
            intent.setType("*/*");
        }
        this.fileChooserResultLauncher.a(intent);
    }

    @Override // ir.nasim.InterfaceC14560i68
    public void K3(boolean needConfirmation) {
        qb().M2(needConfirmation);
    }

    @Override // androidx.fragment.app.Fragment
    public void M6(Bundle savedInstanceState) {
        super.M6(savedInstanceState);
        if (!qb().R1()) {
            C10747c78 c10747c78Qb = qb();
            C24732z68.a aVar = C24732z68.p;
            Context contextS7 = S7();
            AbstractC13042fc3.h(contextS7, "requireContext(...)");
            c10747c78Qb.W1(aVar.a(contextS7));
            return;
        }
        qb().E2();
        C10747c78 c10747c78Qb2 = qb();
        C24732z68.a aVar2 = C24732z68.p;
        Context contextS72 = S7();
        AbstractC13042fc3.h(contextS72, "requireContext(...)");
        c10747c78Qb2.y2(aVar2.a(contextS72));
    }

    @Override // androidx.fragment.app.Fragment
    public View Q6(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        AbstractC13042fc3.i(inflater, "inflater");
        Context contextS7 = S7();
        AbstractC13042fc3.h(contextS7, "requireContext(...)");
        ComposeView composeView = new ComposeView(contextS7, null, 0, 6, null);
        composeView.setViewCompositionStrategy(v.d.b);
        composeView.setContent(AbstractC19242q11.c(1784641680, true, new b(composeView)));
        return composeView;
    }

    @Override // ir.nasim.InterfaceC14560i68
    public void T1() {
        if (Build.VERSION.SDK_INT < 26 || !qb().S1()) {
            qb().E1(new WeakReference(new UA2() { // from class: ir.nasim.r58
                @Override // ir.nasim.UA2
                public final Object invoke(Object obj) {
                    return S58.Wb(this.a, ((Boolean) obj).booleanValue());
                }
            }));
        } else {
            yb(EnumC10111b58.e, null);
        }
    }

    @Override // ir.nasim.InterfaceC14560i68
    public void T4(boolean showSettingButton) {
        qb().P2(showSettingButton);
    }

    @Override // ir.nasim.C23278wf0, androidx.fragment.app.Fragment
    public void T6() {
        super.T6();
    }

    @Override // ir.nasim.ND
    public void W3(String origin, GeolocationPermissions.Callback callback) {
        qb().h2(origin, callback, new SA2() { // from class: ir.nasim.H58
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return S58.zb();
            }
        });
    }

    @Override // ir.nasim.InterfaceC14560i68
    public void Z() {
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: ir.nasim.m58
            @Override // java.lang.Runnable
            public final void run() throws JSONException {
                S58.kb(this.a);
            }
        });
    }

    @Override // ir.nasim.ND
    public void b3(PermissionRequest request) {
        AbstractC13042fc3.i(request, "request");
        qb().l2(request);
    }

    @Override // ir.nasim.InterfaceC14560i68
    public void b4(boolean showBackButton) {
        qb().O2(showBackButton);
    }

    @Override // ir.nasim.InterfaceC14560i68
    public void b5() {
        qb().N2(EnumC23552x68.c);
    }

    @Override // ir.nasim.InterfaceC14560i68
    public void c1() {
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: ir.nasim.o58
            @Override // java.lang.Runnable
            public final void run() {
                S58.Bb(this.a);
            }
        });
    }

    @Override // ir.nasim.C23278wf0, androidx.fragment.app.Fragment
    public void c7() {
        yb(EnumC10111b58.m, null);
        super.c7();
        WebView webViewVb = vb();
        if (webViewVb != null) {
            webViewVb.onPause();
        }
        WebView webViewVb2 = vb();
        if (webViewVb2 != null) {
            webViewVb2.pauseTimers();
        }
        qb().a2();
    }

    @Override // ir.nasim.InterfaceC14560i68
    public void d4(String methodName) {
        AbstractC13042fc3.i(methodName, "methodName");
        qb().J2(methodName);
    }

    @Override // ir.nasim.InterfaceC14560i68
    public void e1(AbstractC5542Ju0 colorType) {
        int iA;
        AbstractC13042fc3.i(colorType, "colorType");
        if (colorType instanceof AbstractC5542Ju0.a) {
            C24732z68.a aVar = C24732z68.p;
            Context contextS7 = S7();
            AbstractC13042fc3.h(contextS7, "requireContext(...)");
            iA = Color.parseColor(aVar.b(contextS7, ((AbstractC5542Ju0.a) colorType).a()));
        } else {
            if (!(colorType instanceof AbstractC5542Ju0.b)) {
                throw new NoWhenBranchMatchedException();
            }
            iA = ((AbstractC5542Ju0.b) colorType).a();
        }
        qb().Q2(iA);
    }

    @Override // ir.nasim.InterfaceC14560i68
    public void e3(String data) {
        AbstractC13042fc3.i(data, "data");
        qb().A2(data);
    }

    @Override // ir.nasim.InterfaceC14560i68
    public void g4(String url, boolean openOnProtectedBrowser) {
        Object objB;
        AbstractC13042fc3.i(url, "url");
        try {
            C9475a16.a aVar = C9475a16.b;
            Uri uri = Uri.parse(url);
            if (openOnProtectedBrowser) {
                AbstractC7426Rr.a aVar2 = AbstractC7426Rr.a;
                Context contextS7 = S7();
                AbstractC13042fc3.h(contextS7, "requireContext(...)");
                aVar2.A(contextS7, uri);
            } else {
                AbstractC7426Rr.a.B(uri);
            }
            objB = C9475a16.b(C19938rB7.a);
        } catch (Throwable th) {
            C9475a16.a aVar3 = C9475a16.b;
            objB = C9475a16.b(AbstractC10685c16.a(th));
        }
        Throwable thE = C9475a16.e(objB);
        if (thE != null) {
            C19406qI3.a("WEBAPP", "Cant open this url '" + thE + "' on browser, error is: " + thE.getMessage(), new Object[0]);
        }
    }

    @Override // ir.nasim.C23278wf0, androidx.fragment.app.Fragment
    public void h7() {
        super.h7();
        WebView webViewVb = vb();
        if (webViewVb != null) {
            webViewVb.onResume();
        }
        WebView webViewVb2 = vb();
        if (webViewVb2 != null) {
            webViewVb2.resumeTimers();
        }
        qb().c2();
    }

    @Override // ir.nasim.InterfaceC14560i68
    public void i2() {
        if (C8386Vt0.pc()) {
            qb().e2();
        }
    }

    @Override // ir.nasim.InterfaceC14560i68
    public void l3(String requestId, String methodName, String params) throws JSONException {
        AbstractC13042fc3.i(requestId, "requestId");
        AbstractC13042fc3.i(methodName, "methodName");
        AbstractC13042fc3.i(params, "params");
        final JSONObject jSONObject = new JSONObject();
        jSONObject.put("req_id", requestId);
        qb().C2(methodName, params, new UA2() { // from class: ir.nasim.I58
            @Override // ir.nasim.UA2
            public final Object invoke(Object obj) {
                return S58.Hb(this.a, jSONObject, (String) obj);
            }
        }, new UA2() { // from class: ir.nasim.K58
            @Override // ir.nasim.UA2
            public final Object invoke(Object obj) {
                return S58.Ib(jSONObject, (String) obj);
            }
        }, new SA2() { // from class: ir.nasim.L58
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return S58.Jb(this.a, jSONObject);
            }
        });
    }

    public final InterfaceC21843uE ob() {
        InterfaceC21843uE interfaceC21843uE = this.appRatingNavigator;
        if (interfaceC21843uE != null) {
            return interfaceC21843uE;
        }
        AbstractC13042fc3.y("appRatingNavigator");
        return null;
    }

    public final SettingsModule pb() {
        SettingsModule settingsModule = this.settingsModule;
        if (settingsModule != null) {
            return settingsModule;
        }
        AbstractC13042fc3.y("settingsModule");
        return null;
    }

    @Override // ir.nasim.InterfaceC14560i68
    public void t3(String payload) {
        qb().A1(payload);
    }

    @Override // ir.nasim.InterfaceC14560i68
    public void v0() {
        qb().f2();
    }

    @Override // ir.nasim.InterfaceC14560i68
    public void v3() {
        qb().Y1(Boolean.FALSE);
    }

    @Override // ir.nasim.V68
    public void w0(String errorName) {
        qb().d2(errorName);
    }
}
