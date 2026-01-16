package ir.nasim.core.network.sslpinning;

import android.R;
import android.content.Context;
import android.gov.nist.core.Separators;
import android.net.Uri;
import android.os.Build;
import android.util.AttributeSet;
import android.webkit.WebSettings;
import android.webkit.WebViewClient;
import ir.nasim.AbstractC10533bm0;
import ir.nasim.AbstractC10685c16;
import ir.nasim.AbstractC13042fc3;
import ir.nasim.AbstractC13269fw3;
import ir.nasim.AbstractC13778go1;
import ir.nasim.AbstractC14862ic3;
import ir.nasim.AbstractC19859r37;
import ir.nasim.AbstractC20762sZ6;
import ir.nasim.C19406qI3;
import ir.nasim.C19938rB7;
import ir.nasim.C9475a16;
import ir.nasim.EB2;
import ir.nasim.ED1;
import ir.nasim.HG1;
import ir.nasim.InterfaceC14603iB2;
import ir.nasim.InterfaceC20295rm1;
import ir.nasim.InterfaceC20315ro1;
import ir.nasim.InterfaceC7720Sx5;
import ir.nasim.InterfaceC9173Yu3;
import ir.nasim.SA2;
import ir.nasim.core.network.sslpinning.SecureWebView;
import java.io.IOException;
import java.net.ConnectException;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ConcurrentHashMap;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.SSLPeerUnverifiedException;
import kotlin.Metadata;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

@Metadata(d1 = {"\u0000\u0098\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010%\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0010\b\u0007\u0018\u0000 02\u00020\u0001:\u0003|E}B1\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006\u0012\b\b\u0002\u0010\b\u001a\u00020\u0006¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u001f\u0010\u0014\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u0012H\u0017¢\u0006\u0004\b\u0014\u0010\u0015J\u0017\u0010\u0016\u001a\u00020\r2\u0006\u0010\u0013\u001a\u00020\u0012H\u0016¢\u0006\u0004\b\u0016\u0010\u0017J\u0017\u0010\u0019\u001a\u00020\r2\b\u0010\u0018\u001a\u0004\u0018\u00010\u0012¢\u0006\u0004\b\u0019\u0010\u0017J\u0017\u0010\u001a\u001a\u00020\r2\u0006\u0010\u0018\u001a\u00020\u0012H\u0016¢\u0006\u0004\b\u001a\u0010\u0017J+\u0010\u001a\u001a\u00020\r2\u0006\u0010\u0018\u001a\u00020\u00122\u0012\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00120\u001bH\u0016¢\u0006\u0004\b\u001a\u0010\u001dJ?\u0010#\u001a\u00020\r2\b\u0010\u001e\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u001f\u001a\u00020\u00122\b\u0010 \u001a\u0004\u0018\u00010\u00122\b\u0010!\u001a\u0004\u0018\u00010\u00122\b\u0010\"\u001a\u0004\u0018\u00010\u0012H\u0016¢\u0006\u0004\b#\u0010$J\u000f\u0010%\u001a\u00020\rH\u0016¢\u0006\u0004\b%\u0010&J\u000f\u0010'\u001a\u00020\rH\u0003¢\u0006\u0004\b'\u0010&J\u000f\u0010(\u001a\u00020\rH\u0002¢\u0006\u0004\b(\u0010&J5\u0010*\u001a\u00020\r2\u0006\u0010\u0018\u001a\u00020\u00122\b\u0010)\u001a\u0004\u0018\u00010\u00122\u0012\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00120\u001bH\u0002¢\u0006\u0004\b*\u0010+J\u0019\u0010,\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0018\u001a\u00020\u0012H\u0002¢\u0006\u0004\b,\u0010-J\u0013\u00100\u001a\u00020/*\u00020.H\u0002¢\u0006\u0004\b0\u00101J\u000f\u00102\u001a\u00020\u0012H\u0002¢\u0006\u0004\b2\u00103J/\u00105\u001a\u00020\r2\u0006\u0010\u0018\u001a\u00020\u00122\u0016\b\u0002\u00104\u001a\u0010\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u001bH\u0002¢\u0006\u0004\b5\u0010\u001dJ\u0017\u00107\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\r06H\u0002¢\u0006\u0004\b7\u00108J\u000f\u0010:\u001a\u000209H\u0002¢\u0006\u0004\b:\u0010;J\u0017\u0010>\u001a\u00020=2\u0006\u0010<\u001a\u000209H\u0002¢\u0006\u0004\b>\u0010?J\u001d\u0010B\u001a\u00020\r2\f\u0010A\u001a\b\u0012\u0004\u0012\u00020\r0@H\u0002¢\u0006\u0004\bB\u0010CR(\u0010L\u001a\u00020D8\u0006@\u0006X\u0087.¢\u0006\u0018\n\u0004\bE\u0010F\u0012\u0004\bK\u0010&\u001a\u0004\bG\u0010H\"\u0004\bI\u0010JR(\u0010U\u001a\u00020M8\u0006@\u0006X\u0087.¢\u0006\u0018\n\u0004\bN\u0010O\u0012\u0004\bT\u0010&\u001a\u0004\bP\u0010Q\"\u0004\bR\u0010SR(\u0010Z\u001a\u00020M8\u0006@\u0006X\u0087.¢\u0006\u0018\n\u0004\bV\u0010O\u0012\u0004\bY\u0010&\u001a\u0004\bW\u0010Q\"\u0004\bX\u0010SR(\u0010c\u001a\b\u0012\u0004\u0012\u00020\\0[8\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\b]\u0010^\u001a\u0004\b_\u0010`\"\u0004\ba\u0010bR\u0018\u0010g\u001a\u0004\u0018\u00010d8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\be\u0010fR\u0018\u0010j\u001a\u0004\u0018\u00010\u00128\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bh\u0010iR\u0018\u0010m\u001a\u0004\u0018\u00010\u000b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bk\u0010lR \u0010q\u001a\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00100n8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bo\u0010pR\u001b\u0010t\u001a\u0002098BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b>\u0010r\u001a\u0004\bs\u0010;R\u001d\u0010x\u001a\n u*\u0004\u0018\u00010\\0\\8Â\u0002X\u0082\u0004¢\u0006\u0006\u001a\u0004\bv\u0010wR\u0017\u0010{\u001a\u0004\u0018\u00010\u000b8Â\u0002X\u0082\u0004¢\u0006\u0006\u001a\u0004\by\u0010z¨\u0006~"}, d2 = {"Lir/nasim/core/network/sslpinning/SecureWebView;", "Landroid/webkit/WebView;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "defStyleRes", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "Landroid/webkit/WebViewClient;", "client", "Lir/nasim/rB7;", "setWebViewClient", "(Landroid/webkit/WebViewClient;)V", "", "any", "", "name", "addJavascriptInterface", "(Ljava/lang/Object;Ljava/lang/String;)V", "removeJavascriptInterface", "(Ljava/lang/String;)V", "url", "v", "loadUrl", "", "additionalHttpHeaders", "(Ljava/lang/String;Ljava/util/Map;)V", "baseUrl", "data", "mimeType", "encoding", "historyUrl", "loadDataWithBaseURL", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "stopLoading", "()V", "q", "p", "host", "t", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;)V", "r", "(Ljava/lang/String;)Ljava/lang/String;", "Ljava/io/IOException;", "Lir/nasim/core/network/sslpinning/SecureWebView$b;", "l", "(Ljava/io/IOException;)Lir/nasim/core/network/sslpinning/SecureWebView$b;", "o", "()Ljava/lang/String;", "headers", "u", "Lir/nasim/a16;", "m", "()Ljava/lang/Object;", "Lir/nasim/core/network/sslpinning/SecureWebView$c;", "n", "()Lir/nasim/core/network/sslpinning/SecureWebView$c;", "securityProfile", "Landroid/webkit/WebSettings;", "k", "(Lir/nasim/core/network/sslpinning/SecureWebView$c;)Landroid/webkit/WebSettings;", "Lkotlin/Function0;", "block", "s", "(Lir/nasim/SA2;)V", "Lir/nasim/ro1;", "c", "Lir/nasim/ro1;", "getScope", "()Lir/nasim/ro1;", "setScope", "(Lir/nasim/ro1;)V", "getScope$annotations", "scope", "Lir/nasim/go1;", "d", "Lir/nasim/go1;", "getIoDispatcher", "()Lir/nasim/go1;", "setIoDispatcher", "(Lir/nasim/go1;)V", "getIoDispatcher$annotations", "ioDispatcher", "e", "getMainDispatcher", "setMainDispatcher", "getMainDispatcher$annotations", "mainDispatcher", "Lir/nasim/Sx5;", "Lokhttp3/OkHttpClient;", "f", "Lir/nasim/Sx5;", "getOkHttpClientProvider", "()Lir/nasim/Sx5;", "setOkHttpClientProvider", "(Lir/nasim/Sx5;)V", "okHttpClientProvider", "Lokhttp3/Call;", "g", "Lokhttp3/Call;", "call", "h", "Ljava/lang/String;", "originalLoadUrlHost", "i", "Landroid/webkit/WebViewClient;", "lowApiWebViewClient", "Ljava/util/concurrent/ConcurrentHashMap;", "j", "Ljava/util/concurrent/ConcurrentHashMap;", "javascriptInterfaces", "Lir/nasim/Yu3;", "getDefaultSecurityProfile", "defaultSecurityProfile", "kotlin.jvm.PlatformType", "getOkHttpClient", "()Lokhttp3/OkHttpClient;", "okHttpClient", "getWebViewClientCompat", "()Landroid/webkit/WebViewClient;", "webViewClientCompat", "b", "a", "base_productionRelease"}, k = 1, mv = {2, 0, 0})
/* loaded from: classes5.dex */
public final class SecureWebView extends Hilt_SecureWebView {
    private static final a l = new a(null);

    /* renamed from: c, reason: from kotlin metadata */
    public InterfaceC20315ro1 scope;

    /* renamed from: d, reason: from kotlin metadata */
    public AbstractC13778go1 ioDispatcher;

    /* renamed from: e, reason: from kotlin metadata */
    public AbstractC13778go1 mainDispatcher;

    /* renamed from: f, reason: from kotlin metadata */
    public InterfaceC7720Sx5 okHttpClientProvider;

    /* renamed from: g, reason: from kotlin metadata */
    private Call call;

    /* renamed from: h, reason: from kotlin metadata */
    private String originalLoadUrlHost;

    /* renamed from: i, reason: from kotlin metadata */
    private WebViewClient lowApiWebViewClient;

    /* renamed from: j, reason: from kotlin metadata */
    private final ConcurrentHashMap javascriptInterfaces;

    /* renamed from: k, reason: from kotlin metadata */
    private final InterfaceC9173Yu3 defaultSecurityProfile;

    private static final class a {
        private a() {
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    /* synthetic */ class d extends EB2 implements SA2 {
        d(Object obj) {
            super(0, obj, SecureWebView.class, "captureSecurityProfile", "captureSecurityProfile()Lir/nasim/core/network/sslpinning/SecureWebView$WebViewSecurityProfile;", 0);
        }

        @Override // ir.nasim.SA2
        /* renamed from: y, reason: merged with bridge method [inline-methods] */
        public final c invoke() {
            return ((SecureWebView) this.receiver).n();
        }
    }

    static final class e extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ SA2 c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        e(SA2 sa2, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.c = sa2;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return new e(this.c, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            AbstractC14862ic3.e();
            if (this.b != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            AbstractC10685c16.b(obj);
            try {
                this.c.invoke();
            } catch (CancellationException e) {
                throw e;
            } catch (Exception e2) {
                C19406qI3.c("SecureWebView", "launchOnMain failed", e2);
            }
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((e) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    public static final class f implements Callback {
        final /* synthetic */ String b;
        final /* synthetic */ String c;
        final /* synthetic */ Map d;

        static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
            int b;
            final /* synthetic */ SecureWebView c;
            final /* synthetic */ String d;
            final /* synthetic */ String e;
            final /* synthetic */ Map f;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(SecureWebView secureWebView, String str, String str2, Map map, InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
                this.c = secureWebView;
                this.d = str;
                this.e = str2;
                this.f = map;
            }

            @Override // ir.nasim.E90
            public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                return new a(this.c, this.d, this.e, this.f, interfaceC20295rm1);
            }

            @Override // ir.nasim.E90
            public final Object invokeSuspend(Object obj) {
                Object objE = AbstractC14862ic3.e();
                int i = this.b;
                if (i == 0) {
                    AbstractC10685c16.b(obj);
                    this.b = 1;
                    if (HG1.b(5000L, this) == objE) {
                        return objE;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    AbstractC10685c16.b(obj);
                }
                this.c.t(this.d, this.e, this.f);
                return C19938rB7.a;
            }

            @Override // ir.nasim.InterfaceC14603iB2
            /* renamed from: n, reason: merged with bridge method [inline-methods] */
            public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
                return ((a) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        f(String str, String str2, Map map) {
            this.b = str;
            this.c = str2;
            this.d = map;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 d(SecureWebView secureWebView) {
            AbstractC13042fc3.i(secureWebView, "this$0");
            secureWebView.getSettings().setAllowFileAccess(true);
            secureWebView.loadDataWithBaseURL("file:///android_asset/", secureWebView.o(), "text/html", "UTF-8", null);
            return C19938rB7.a;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 e(IOException iOException, SecureWebView secureWebView, int i, String str) {
            AbstractC13042fc3.i(iOException, "$e");
            AbstractC13042fc3.i(secureWebView, "this$0");
            AbstractC13042fc3.i(str, "$url");
            String localizedMessage = iOException.getLocalizedMessage();
            if (localizedMessage == null && (localizedMessage = iOException.getMessage()) == null) {
                localizedMessage = iOException.getClass().getSimpleName();
            }
            int i2 = Build.VERSION.SDK_INT;
            WebViewClient webViewClient = i2 >= 26 ? secureWebView.getWebViewClient() : secureWebView.lowApiWebViewClient;
            if (webViewClient != null) {
                webViewClient.onReceivedError(secureWebView, i, localizedMessage, str);
            }
            WebViewClient webViewClient2 = i2 >= 26 ? secureWebView.getWebViewClient() : secureWebView.lowApiWebViewClient;
            if (webViewClient2 != null) {
                webViewClient2.onPageFinished(secureWebView, str);
            }
            return C19938rB7.a;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 f(SecureWebView secureWebView, String str, Map map) {
            AbstractC13042fc3.i(secureWebView, "this$0");
            AbstractC13042fc3.i(str, "$url");
            AbstractC13042fc3.i(map, "$additionalHttpHeaders");
            secureWebView.u(str, map);
            return C19938rB7.a;
        }

        @Override // okhttp3.Callback
        public void onFailure(Call call, final IOException iOException) {
            AbstractC13042fc3.i(call, "call");
            AbstractC13042fc3.i(iOException, "e");
            b bVarL = SecureWebView.this.l(iOException);
            final int iA = bVarL.a();
            boolean zB = bVarL.b();
            C19406qI3.c("SecureWebView", "loadUrl() failed with code(" + iA + ") and canBeRetried(" + zB + ") \n", iOException);
            if (zB) {
                AbstractC10533bm0.d(SecureWebView.this.getScope(), SecureWebView.this.getIoDispatcher(), null, new a(SecureWebView.this, this.b, this.c, this.d, null), 2, null);
                return;
            }
            if (iA == -11) {
                final SecureWebView secureWebView = SecureWebView.this;
                secureWebView.s(new SA2() { // from class: ir.nasim.vi6
                    @Override // ir.nasim.SA2
                    public final Object invoke() {
                        return SecureWebView.f.d(secureWebView);
                    }
                });
            } else {
                final SecureWebView secureWebView2 = SecureWebView.this;
                final String str = this.b;
                secureWebView2.s(new SA2() { // from class: ir.nasim.wi6
                    @Override // ir.nasim.SA2
                    public final Object invoke() {
                        return SecureWebView.f.e(iOException, secureWebView2, iA, str);
                    }
                });
            }
        }

        @Override // okhttp3.Callback
        public void onResponse(Call call, Response response) {
            AbstractC13042fc3.i(call, "call");
            AbstractC13042fc3.i(response, "response");
            final SecureWebView secureWebView = SecureWebView.this;
            final String str = this.b;
            final Map map = this.d;
            secureWebView.s(new SA2() { // from class: ir.nasim.xi6
                @Override // ir.nasim.SA2
                public final Object invoke() {
                    return SecureWebView.f.f(secureWebView, str, map);
                }
            });
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SecureWebView(Context context) {
        this(context, null, 0, 0, 14, null);
        AbstractC13042fc3.i(context, "context");
    }

    private final c getDefaultSecurityProfile() {
        return (c) this.defaultSecurityProfile.getValue();
    }

    public static /* synthetic */ void getIoDispatcher$annotations() {
    }

    public static /* synthetic */ void getMainDispatcher$annotations() {
    }

    private final OkHttpClient getOkHttpClient() {
        return (OkHttpClient) getOkHttpClientProvider().get();
    }

    public static /* synthetic */ void getScope$annotations() {
    }

    private final WebViewClient getWebViewClientCompat() {
        return Build.VERSION.SDK_INT >= 26 ? getWebViewClient() : this.lowApiWebViewClient;
    }

    private final WebSettings k(c securityProfile) {
        WebSettings settings = getSettings();
        settings.setUserAgentString(securityProfile.d());
        settings.setAllowFileAccess(securityProfile.b());
        settings.setAllowContentAccess(securityProfile.a());
        settings.setSupportMultipleWindows(securityProfile.c());
        AbstractC13042fc3.h(settings, "apply(...)");
        return settings;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final b l(IOException iOException) {
        ED1 ed1 = null;
        int i = 2;
        boolean z = false;
        if ((iOException instanceof SSLPeerUnverifiedException) || (iOException instanceof SSLHandshakeException)) {
            return new b(-11, z, i, ed1);
        }
        if (iOException instanceof MalformedURLException) {
            return new b(-12, z, i, ed1);
        }
        int i2 = -7;
        if (!(iOException instanceof ProtocolException)) {
            return iOException instanceof UnknownHostException ? new b(-2, true) : iOException instanceof SocketTimeoutException ? new b(-8, true) : iOException instanceof ConnectException ? new b(-6, true) : new b(i2, z, i, ed1);
        }
        String message = iOException.getMessage();
        return (message == null || !AbstractC20762sZ6.V(message, "redirect", true)) ? new b(i2, z, i, ed1) : new b(-9, z, i, ed1);
    }

    private final Object m() {
        try {
            C9475a16.a aVar = C9475a16.b;
            C19938rB7 c19938rB7 = null;
            this.originalLoadUrlHost = null;
            Call call = this.call;
            if (call != null) {
                if (!call.getCanceled()) {
                    call.cancel();
                }
                this.call = null;
                c19938rB7 = C19938rB7.a;
            }
            return C9475a16.b(c19938rB7);
        } catch (Throwable th) {
            C9475a16.a aVar2 = C9475a16.b;
            return C9475a16.b(AbstractC10685c16.a(th));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final c n() {
        return new c(getSettings().getUserAgentString(), getSettings().getAllowFileAccess(), getSettings().getAllowContentAccess(), getSettings().supportMultipleWindows());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String o() {
        return "<!DOCTYPE html>\n<html lang=\"fa\">\n<head>\n    <meta charset=\"UTF-8\">\n    <title>مشکل در اتصال</title>\n    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n    <style>\n        @font-face {\n            font-family: 'IranSans';\n            src: url('file:///android_res/font/iran_sans.ttf') format('truetype');\n        }\n        body {\n            font-family: 'IranSans', Tahoma, Arial, sans-serif;\n            margin: 0;\n            padding: 30px;\n            display: flex;\n            flex-direction: column;\n            justify-content: center;\n            align-items: center;\n            text-align: center;\n            direction: rtl;\n            height: 100vh;\n            color: #444;\n            background-color: #f9f9f9;\n        }\n        .icon {\n            font-size: 50px;\n            margin-bottom: 15px;\n        }\n        h1 {\n            font-size: 26px;\n            margin-bottom: 10px;\n            font-weight: bold;\n            color: #222;\n        }\n        p {\n            font-size: 18px;\n            line-height: 1.5;\n            color: #555;\n            max-width: 300px;\n        }\n    </style>\n</head>\n<body>\n    <div class=\"icon\">⚠️</div>\n    <h1>اتصال به صفحه ممکن نیست</h1>\n    <p>مشکلی پیش آمده است، لطفا به پشتیبانی گزارش دهید.</p>\n</body>\n</html>\n";
    }

    private final void p() {
        Iterator it = this.javascriptInterfaces.entrySet().iterator();
        while (it.hasNext()) {
            super.removeJavascriptInterface((String) ((Map.Entry) it.next()).getKey());
        }
    }

    private final void q() {
        for (Map.Entry entry : this.javascriptInterfaces.entrySet()) {
            super.addJavascriptInterface(entry.getValue(), (String) entry.getKey());
        }
    }

    private final String r(String url) {
        Uri uri = Uri.parse(url);
        AbstractC13042fc3.h(uri, "parse(this)");
        return uri.getHost();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void s(SA2 block) {
        AbstractC10533bm0.d(getScope(), getMainDispatcher(), null, new e(block, null), 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void t(String url, String host, Map additionalHttpHeaders) {
        if (AbstractC13042fc3.d(host, this.originalLoadUrlHost)) {
            Call callNewCall = ((OkHttpClient) getOkHttpClientProvider().get()).newCall(new Request.Builder().url(url).head().build());
            this.call = callNewCall;
            callNewCall.enqueue(new f(url, host, additionalHttpHeaders));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void u(String url, Map headers) {
        if (headers == null || headers.isEmpty()) {
            super.loadUrl(url);
        } else {
            super.loadUrl(url, headers);
        }
    }

    @Override // android.webkit.WebView
    public void addJavascriptInterface(Object any, String name) {
        AbstractC13042fc3.i(any, "any");
        AbstractC13042fc3.i(name, "name");
        this.javascriptInterfaces.put(name, any);
        super.addJavascriptInterface(any, name);
    }

    public final AbstractC13778go1 getIoDispatcher() {
        AbstractC13778go1 abstractC13778go1 = this.ioDispatcher;
        if (abstractC13778go1 != null) {
            return abstractC13778go1;
        }
        AbstractC13042fc3.y("ioDispatcher");
        return null;
    }

    public final AbstractC13778go1 getMainDispatcher() {
        AbstractC13778go1 abstractC13778go1 = this.mainDispatcher;
        if (abstractC13778go1 != null) {
            return abstractC13778go1;
        }
        AbstractC13042fc3.y("mainDispatcher");
        return null;
    }

    public final InterfaceC7720Sx5 getOkHttpClientProvider() {
        InterfaceC7720Sx5 interfaceC7720Sx5 = this.okHttpClientProvider;
        if (interfaceC7720Sx5 != null) {
            return interfaceC7720Sx5;
        }
        AbstractC13042fc3.y("okHttpClientProvider");
        return null;
    }

    public final InterfaceC20315ro1 getScope() {
        InterfaceC20315ro1 interfaceC20315ro1 = this.scope;
        if (interfaceC20315ro1 != null) {
            return interfaceC20315ro1;
        }
        AbstractC13042fc3.y("scope");
        return null;
    }

    @Override // android.webkit.WebView
    public void loadDataWithBaseURL(String baseUrl, String data, String mimeType, String encoding, String historyUrl) {
        AbstractC13042fc3.i(data, "data");
        m();
        super.loadDataWithBaseURL(baseUrl, data, mimeType, encoding, historyUrl);
    }

    @Override // android.webkit.WebView
    public void loadUrl(String url) {
        AbstractC13042fc3.i(url, "url");
        loadUrl(url, new LinkedHashMap());
    }

    @Override // android.webkit.WebView
    public void removeJavascriptInterface(String name) {
        AbstractC13042fc3.i(name, "name");
        this.javascriptInterfaces.remove(name);
        super.removeJavascriptInterface(name);
    }

    public final void setIoDispatcher(AbstractC13778go1 abstractC13778go1) {
        AbstractC13042fc3.i(abstractC13778go1, "<set-?>");
        this.ioDispatcher = abstractC13778go1;
    }

    public final void setMainDispatcher(AbstractC13778go1 abstractC13778go1) {
        AbstractC13042fc3.i(abstractC13778go1, "<set-?>");
        this.mainDispatcher = abstractC13778go1;
    }

    public final void setOkHttpClientProvider(InterfaceC7720Sx5 interfaceC7720Sx5) {
        AbstractC13042fc3.i(interfaceC7720Sx5, "<set-?>");
        this.okHttpClientProvider = interfaceC7720Sx5;
    }

    public final void setScope(InterfaceC20315ro1 interfaceC20315ro1) {
        AbstractC13042fc3.i(interfaceC20315ro1, "<set-?>");
        this.scope = interfaceC20315ro1;
    }

    @Override // android.webkit.WebView
    public void setWebViewClient(WebViewClient client) {
        AbstractC13042fc3.i(client, "client");
        if (Build.VERSION.SDK_INT < 26) {
            this.lowApiWebViewClient = client;
        }
        super.setWebViewClient(client);
    }

    @Override // android.webkit.WebView
    public void stopLoading() {
        m();
        super.stopLoading();
    }

    public final void v(String url) {
        boolean z = (url == null || !AbstractC13042fc3.d(r(url), this.originalLoadUrlHost) || this.originalLoadUrlHost == null) ? false : true;
        String strR = url != null ? r(url) : null;
        C19406qI3.a("SecureWebView", "updateAccessBasedOnUrl() --> isTheOriginalDomain=" + z + " : url=" + url + ", detectedHost=" + strR + ", originalLoadUrlHost=" + this.originalLoadUrlHost + ", default: " + getDefaultSecurityProfile(), new Object[0]);
        if (z) {
            k(getDefaultSecurityProfile());
            q();
        } else {
            k(new c(null, false, false, false, 15, null));
            p();
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SecureWebView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 0, 12, null);
        AbstractC13042fc3.i(context, "context");
    }

    @Override // android.webkit.WebView
    public void loadUrl(String url, Map additionalHttpHeaders) {
        AbstractC13042fc3.i(url, "url");
        AbstractC13042fc3.i(additionalHttpHeaders, "additionalHttpHeaders");
        C19406qI3.j("SecureWebView", "loadUrl(url=" + url + ", headers=" + additionalHttpHeaders + Separators.RPAREN, new Object[0]);
        m();
        String strR = r(url);
        this.originalLoadUrlHost = strR;
        t(url, strR, additionalHttpHeaders);
    }

    private static final class b {
        private final int a;
        private final boolean b;

        public b(int i, boolean z) {
            this.a = i;
            this.b = z;
        }

        public final int a() {
            return this.a;
        }

        public final boolean b() {
            return this.b;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof b)) {
                return false;
            }
            b bVar = (b) obj;
            return this.a == bVar.a && this.b == bVar.b;
        }

        public int hashCode() {
            return (Integer.hashCode(this.a) * 31) + Boolean.hashCode(this.b);
        }

        public String toString() {
            return "WebViewClientError(code=" + this.a + ", canBeRetried=" + this.b + Separators.RPAREN;
        }

        public /* synthetic */ b(int i, boolean z, int i2, ED1 ed1) {
            this(i, (i2 & 2) != 0 ? false : z);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SecureWebView(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, 0, 8, null);
        AbstractC13042fc3.i(context, "context");
    }

    public /* synthetic */ SecureWebView(Context context, AttributeSet attributeSet, int i, int i2, int i3, ED1 ed1) {
        this(context, (i3 & 2) != 0 ? null : attributeSet, (i3 & 4) != 0 ? R.attr.webViewStyle : i, (i3 & 8) != 0 ? 0 : i2);
    }

    private static final class c {
        public static final a e = new a(null);
        private final String a;
        private final boolean b;
        private final boolean c;
        private final boolean d;

        public static final class a {
            private a() {
            }

            public /* synthetic */ a(ED1 ed1) {
                this();
            }
        }

        public c(String str, boolean z, boolean z2, boolean z3) {
            this.a = str;
            this.b = z;
            this.c = z2;
            this.d = z3;
        }

        public final boolean a() {
            return this.c;
        }

        public final boolean b() {
            return this.b;
        }

        public final boolean c() {
            return this.d;
        }

        public final String d() {
            return this.a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof c)) {
                return false;
            }
            c cVar = (c) obj;
            return AbstractC13042fc3.d(this.a, cVar.a) && this.b == cVar.b && this.c == cVar.c && this.d == cVar.d;
        }

        public int hashCode() {
            String str = this.a;
            return ((((((str == null ? 0 : str.hashCode()) * 31) + Boolean.hashCode(this.b)) * 31) + Boolean.hashCode(this.c)) * 31) + Boolean.hashCode(this.d);
        }

        public String toString() {
            return "WebViewSecurityProfile(userAgentString=" + this.a + ", allowFileAccess=" + this.b + ", allowContentAccess=" + this.c + ", supportMultipleWindows=" + this.d + Separators.RPAREN;
        }

        public /* synthetic */ c(String str, boolean z, boolean z2, boolean z3, int i, ED1 ed1) {
            this((i & 1) != 0 ? null : str, (i & 2) != 0 ? false : z, (i & 4) != 0 ? false : z2, (i & 8) != 0 ? false : z3);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SecureWebView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        AbstractC13042fc3.i(context, "context");
        this.javascriptInterfaces = new ConcurrentHashMap();
        this.defaultSecurityProfile = AbstractC13269fw3.a(new d(this));
    }
}
