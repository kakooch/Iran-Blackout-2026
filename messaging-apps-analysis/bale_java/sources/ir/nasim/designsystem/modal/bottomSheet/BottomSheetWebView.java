package ir.nasim.designsystem.modal.bottomSheet;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.gov.nist.core.Separators;
import android.gov.nist.javax.sip.parser.TokenNames;
import android.net.Uri;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import androidx.appcompat.app.AppCompatActivity;
import ir.nasim.AbstractC12208eD5;
import ir.nasim.AbstractC12217eE5;
import ir.nasim.AbstractC13042fc3;
import ir.nasim.AbstractC20153rZ6;
import ir.nasim.AbstractC5969Lp4;
import ir.nasim.AbstractC7426Rr;
import ir.nasim.BC5;
import ir.nasim.C14486i0;
import ir.nasim.C19406qI3;
import ir.nasim.C19938rB7;
import ir.nasim.C21753u45;
import ir.nasim.C23572x88;
import ir.nasim.C24162y88;
import ir.nasim.C5505Jq;
import ir.nasim.ED1;
import ir.nasim.F35;
import ir.nasim.InterfaceC16866m0;
import ir.nasim.InterfaceC22386v88;
import ir.nasim.InterfaceC5417Jg1;
import ir.nasim.InterfaceC9644aJ4;
import ir.nasim.J44;
import ir.nasim.SA2;
import ir.nasim.U5;
import ir.nasim.designsystem.base.activity.BaseActivity;
import ir.nasim.designsystem.modal.bottomSheet.BottomSheetWebView;
import ir.nasim.features.bank.mybank.webview.WebViewInterface;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000½\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\u0015\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\b\u0004*\u0001d\b\u0007\u0018\u0000 &2\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u0005:\u0001-B\u0011\b\u0016\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tBE\b\u0017\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\u0006\u0010\r\u001a\u00020\f\u0012\u0006\u0010\u000f\u001a\u00020\u000e\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010\u0012\u0010\b\u0002\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u0012¢\u0006\u0004\b\b\u0010\u0015B\u0019\b\u0016\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\u0017\u001a\u00020\u0016¢\u0006\u0004\b\b\u0010\u0018B!\b\u0016\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\u0017\u001a\u00020\u0016\u0012\u0006\u0010\u001a\u001a\u00020\u0019¢\u0006\u0004\b\b\u0010\u001bJ'\u0010\u001c\u001a\u00020\u00132\u0006\u0010\u0007\u001a\u00020\u00062\u000e\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u0012H\u0002¢\u0006\u0004\b\u001c\u0010\u001dJ\u0017\u0010 \u001a\u00020\u00132\u0006\u0010\u001f\u001a\u00020\u001eH\u0002¢\u0006\u0004\b \u0010!J\u000f\u0010\"\u001a\u00020\u0013H\u0002¢\u0006\u0004\b\"\u0010#J\u0019\u0010&\u001a\u00020\u00132\b\u0010%\u001a\u0004\u0018\u00010$H\u0002¢\u0006\u0004\b&\u0010'J\u0019\u0010*\u001a\u0004\u0018\u00010\f2\u0006\u0010)\u001a\u00020(H\u0002¢\u0006\u0004\b*\u0010+J\u000f\u0010-\u001a\u00020,H\u0016¢\u0006\u0004\b-\u0010.J\u0019\u0010/\u001a\u00020\u00132\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0016¢\u0006\u0004\b/\u00100J\u000f\u00101\u001a\u00020\u0013H\u0016¢\u0006\u0004\b1\u0010#J\u000f\u00102\u001a\u00020\u0013H\u0016¢\u0006\u0004\b2\u0010#J\u0017\u00105\u001a\u00020\u00132\u0006\u00104\u001a\u000203H\u0016¢\u0006\u0004\b5\u00106J-\u0010<\u001a\u00020\u00132\u0006\u00107\u001a\u00020\u00192\f\u00109\u001a\b\u0012\u0004\u0012\u00020\f082\u0006\u0010;\u001a\u00020:H\u0016¢\u0006\u0004\b<\u0010=J)\u0010?\u001a\u00020\u00132\u0006\u00107\u001a\u00020\u00192\u0006\u0010>\u001a\u00020\u00192\b\u0010)\u001a\u0004\u0018\u00010(H\u0016¢\u0006\u0004\b?\u0010@R\u0018\u0010\u000f\u001a\u0004\u0018\u00010\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b-\u0010AR\u0016\u0010\u000b\u001a\u00020\n8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\bB\u0010CR\u0016\u0010\r\u001a\u00020\f8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b?\u0010DR\u0018\u0010G\u001a\u0004\u0018\u00010E8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b<\u0010FR\u0016\u0010J\u001a\u00020H8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b5\u0010IR\u0018\u0010N\u001a\u0004\u0018\u00010K8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bL\u0010MR\u0018\u0010P\u001a\u0004\u0018\u00010E8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bO\u0010FR\u0018\u0010\u0011\u001a\u0004\u0018\u00010\u00108\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bQ\u0010RR\u0018\u0010V\u001a\u0004\u0018\u00010S8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bT\u0010UR\u0018\u0010Y\u001a\u0004\u0018\u0001038\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bW\u0010XR\u0018\u0010[\u001a\u0004\u0018\u00010\f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bZ\u0010DR$\u0010`\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020]08\u0018\u00010\\8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b^\u0010_R\u0014\u0010c\u001a\u00020\u00198\u0002X\u0082D¢\u0006\u0006\n\u0004\ba\u0010bR\u0016\u0010f\u001a\u00020d8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b \u0010e¨\u0006g"}, d2 = {"Lir/nasim/designsystem/modal/bottomSheet/BottomSheetWebView;", "Landroid/widget/RelativeLayout;", "Lir/nasim/m0;", "Lir/nasim/v88;", "Lir/nasim/Jg1;", "Lir/nasim/U5;", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Lir/nasim/designsystem/base/activity/BaseActivity;", "parent", "", "url", "Lir/nasim/i0;", "abol", "Lir/nasim/J44;", "msg", "Lkotlin/Function0;", "Lir/nasim/rB7;", "onFinishBottomSheet", "(Landroid/content/Context;Lir/nasim/designsystem/base/activity/BaseActivity;Ljava/lang/String;Lir/nasim/i0;Lir/nasim/J44;Lir/nasim/SA2;)V", "Landroid/util/AttributeSet;", "attrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "s", "(Landroid/content/Context;Lir/nasim/SA2;)V", "Landroid/webkit/WebView;", "webView", "n", "(Landroid/webkit/WebView;)V", "p", "()V", "Landroidx/appcompat/app/AppCompatActivity;", "parentActivity", "o", "(Landroidx/appcompat/app/AppCompatActivity;)V", "Landroid/content/Intent;", "data", "r", "(Landroid/content/Intent;)Ljava/lang/String;", "", "a", "()Z", "setAbolInstance", "(Lir/nasim/i0;)V", TokenNames.K, "X3", "Lir/nasim/aJ4;", "listener", "e", "(Lir/nasim/aJ4;)V", "requestCode", "", "permissions", "", "grantResults", "d", "(I[Ljava/lang/String;[I)V", "resultCode", "c", "(IILandroid/content/Intent;)V", "Lir/nasim/i0;", "b", "Lir/nasim/designsystem/base/activity/BaseActivity;", "Ljava/lang/String;", "Landroid/view/View;", "Landroid/view/View;", "view", "Landroid/view/LayoutInflater;", "Landroid/view/LayoutInflater;", "inflater", "Landroid/widget/FrameLayout;", "f", "Landroid/widget/FrameLayout;", "frameLayout", "g", "fragmentView", "h", "Lir/nasim/J44;", "Lir/nasim/y88;", "i", "Lir/nasim/y88;", "loadWebView", "j", "Lir/nasim/aJ4;", "contactPickListener", "k", "fileAddress", "Landroid/webkit/ValueCallback;", "Landroid/net/Uri;", "l", "Landroid/webkit/ValueCallback;", "selectFilePathCallback", "m", TokenNames.I, "FILE_CHOOSER_REQUEST_CODE", "ir/nasim/designsystem/modal/bottomSheet/BottomSheetWebView$c", "Lir/nasim/designsystem/modal/bottomSheet/BottomSheetWebView$c;", "nonCacheWebviewClient", "nasim_release"}, k = 1, mv = {2, 0, 0})
/* loaded from: classes5.dex */
public final class BottomSheetWebView extends RelativeLayout implements InterfaceC16866m0, InterfaceC22386v88, InterfaceC5417Jg1, U5 {
    public static final int p = 8;

    /* renamed from: a, reason: from kotlin metadata */
    private C14486i0 abol;

    /* renamed from: b, reason: from kotlin metadata */
    private BaseActivity parent;

    /* renamed from: c, reason: from kotlin metadata */
    private String url;

    /* renamed from: d, reason: from kotlin metadata */
    private View view;

    /* renamed from: e, reason: from kotlin metadata */
    private LayoutInflater inflater;

    /* renamed from: f, reason: from kotlin metadata */
    private FrameLayout frameLayout;

    /* renamed from: g, reason: from kotlin metadata */
    private View fragmentView;

    /* renamed from: h, reason: from kotlin metadata */
    private J44 msg;

    /* renamed from: i, reason: from kotlin metadata */
    private C24162y88 loadWebView;

    /* renamed from: j, reason: from kotlin metadata */
    private InterfaceC9644aJ4 contactPickListener;

    /* renamed from: k, reason: from kotlin metadata */
    private String fileAddress;

    /* renamed from: l, reason: from kotlin metadata */
    private ValueCallback selectFilePathCallback;

    /* renamed from: m, reason: from kotlin metadata */
    private final int FILE_CHOOSER_REQUEST_CODE;

    /* renamed from: n, reason: from kotlin metadata */
    private c nonCacheWebviewClient;

    public static final class b extends WebChromeClient {
        b() {
        }

        @Override // android.webkit.WebChromeClient
        public boolean onShowFileChooser(WebView webView, ValueCallback valueCallback, WebChromeClient.FileChooserParams fileChooserParams) {
            BaseActivity baseActivity = null;
            if (BottomSheetWebView.this.selectFilePathCallback != null) {
                ValueCallback valueCallback2 = BottomSheetWebView.this.selectFilePathCallback;
                AbstractC13042fc3.f(valueCallback2);
                valueCallback2.onReceiveValue(null);
            }
            BottomSheetWebView.this.selectFilePathCallback = valueCallback;
            Intent intent = new Intent("android.intent.action.GET_CONTENT");
            intent.addCategory("android.intent.category.OPENABLE");
            intent.setType("image/*");
            BaseActivity baseActivity2 = BottomSheetWebView.this.parent;
            if (baseActivity2 == null) {
                AbstractC13042fc3.y("parent");
                baseActivity2 = null;
            }
            intent.putExtra("android.intent.extra.TITLE", baseActivity2.getString(AbstractC12217eE5.picker_file_activity_title));
            BaseActivity baseActivity3 = BottomSheetWebView.this.parent;
            if (baseActivity3 == null) {
                AbstractC13042fc3.y("parent");
                baseActivity3 = null;
            }
            baseActivity3.T1(BottomSheetWebView.this);
            BaseActivity baseActivity4 = BottomSheetWebView.this.parent;
            if (baseActivity4 == null) {
                AbstractC13042fc3.y("parent");
            } else {
                baseActivity = baseActivity4;
            }
            baseActivity.startActivityForResult(intent, BottomSheetWebView.this.FILE_CHOOSER_REQUEST_CODE);
            return true;
        }
    }

    public static final class c extends WebViewClient {
        c() {
        }

        @Override // android.webkit.WebViewClient
        public void onPageFinished(WebView webView, String str) {
            AbstractC13042fc3.i(webView, "view");
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public BottomSheetWebView(Context context, BaseActivity baseActivity, String str, C14486i0 c14486i0, J44 j44) {
        this(context, baseActivity, str, c14486i0, j44, null, 32, null);
        AbstractC13042fc3.i(context, "context");
        AbstractC13042fc3.i(baseActivity, "parent");
        AbstractC13042fc3.i(str, "url");
        AbstractC13042fc3.i(c14486i0, "abol");
    }

    private final void n(WebView webView) {
        webView.setWebChromeClient(new b());
    }

    private final void o(AppCompatActivity parentActivity) {
        BaseActivity baseActivity;
        if (parentActivity == null) {
            return;
        }
        try {
            int iC = F35.c(parentActivity, "android.permission.READ_CONTACTS");
            int iC2 = F35.c(parentActivity, "android.permission.WRITE_CONTACTS");
            BaseActivity baseActivity2 = null;
            if (iC == 0 && iC2 == 0) {
                Intent intent = new Intent("android.intent.action.PICK");
                intent.setDataAndType(Uri.parse("content://contacts"), "vnd.android.cursor.dir/phone_v2");
                BaseActivity baseActivity3 = this.parent;
                if (baseActivity3 == null) {
                    AbstractC13042fc3.y("parent");
                } else {
                    baseActivity2 = baseActivity3;
                }
                baseActivity2.startActivityForResult(intent, 6564);
                return;
            }
            C5505Jq.I("android.permission.READ_CONTACTS_fragment");
            C21753u45 c21753u45 = C21753u45.a;
            BaseActivity baseActivity4 = this.parent;
            if (baseActivity4 == null) {
                AbstractC13042fc3.y("parent");
                baseActivity = null;
            } else {
                baseActivity = baseActivity4;
            }
            C21753u45.O0(c21753u45, baseActivity, 1088, null, new C21753u45.d[]{C21753u45.d.h, C21753u45.d.i}, 4, null);
        } catch (Exception e) {
            C19406qI3.d("NON_FATAL_EXCEPTION", e);
        }
    }

    private final void p() {
        AbstractC7426Rr.a.F(new Runnable() { // from class: ir.nasim.rk0
            @Override // java.lang.Runnable
            public final void run() {
                BottomSheetWebView.q(this.a);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void q(BottomSheetWebView bottomSheetWebView) {
        View viewFindViewById;
        View viewFindViewById2;
        View viewFindViewById3;
        View viewFindViewById4;
        AbstractC13042fc3.i(bottomSheetWebView, "this$0");
        View view = bottomSheetWebView.view;
        if (view != null && (viewFindViewById4 = view.findViewById(BC5.progress_bar_view)) != null) {
            viewFindViewById4.setVisibility(8);
        }
        View view2 = bottomSheetWebView.view;
        if (view2 != null && (viewFindViewById3 = view2.findViewById(BC5.loading_shadow)) != null) {
            viewFindViewById3.setVisibility(8);
        }
        View view3 = bottomSheetWebView.fragmentView;
        if (view3 != null && (viewFindViewById2 = view3.findViewById(BC5.progress_bar_view)) != null) {
            viewFindViewById2.setVisibility(8);
        }
        View view4 = bottomSheetWebView.fragmentView;
        if (view4 == null || (viewFindViewById = view4.findViewById(BC5.loading_shadow)) == null) {
            return;
        }
        viewFindViewById.setVisibility(8);
    }

    private final String r(Intent data) {
        String strM;
        Uri data2 = data.getData();
        if (data2 == null) {
            return "";
        }
        String[] strArr = {"data1"};
        BaseActivity baseActivity = this.parent;
        String strM2 = null;
        if (baseActivity == null) {
            AbstractC13042fc3.y("parent");
            baseActivity = null;
        }
        Cursor cursorQuery = baseActivity.getContentResolver().query(data2, strArr, null, null, null);
        if (cursorQuery != null) {
            cursorQuery.moveToFirst();
        }
        Integer numValueOf = cursorQuery != null ? Integer.valueOf(cursorQuery.getColumnIndex("data1")) : null;
        if (cursorQuery != null) {
            AbstractC13042fc3.f(numValueOf);
            String string = cursorQuery.getString(numValueOf.intValue());
            if (string != null && (strM = AbstractC20153rZ6.M(string, Separators.SP, "", false, 4, null)) != null) {
                strM2 = AbstractC20153rZ6.M(strM, "-", "", false, 4, null);
            }
        }
        if (cursorQuery == null) {
            return strM2;
        }
        cursorQuery.close();
        return strM2;
    }

    private final void s(Context context, final SA2 onFinishBottomSheet) {
        String str;
        BaseActivity baseActivity;
        WebView webViewA;
        WebView webViewA2;
        WebViewInterface webViewInterfaceB;
        Object systemService = context.getSystemService("layout_inflater");
        AbstractC13042fc3.g(systemService, "null cannot be cast to non-null type android.view.LayoutInflater");
        LayoutInflater layoutInflater = (LayoutInflater) systemService;
        this.inflater = layoutInflater;
        if (layoutInflater == null) {
            AbstractC13042fc3.y("inflater");
            layoutInflater = null;
        }
        View viewInflate = layoutInflater.inflate(AbstractC12208eD5.fragment_my_bank_web_view_cache, this);
        this.view = viewInflate;
        AbstractC13042fc3.f(viewInflate);
        this.frameLayout = (FrameLayout) viewInflate.findViewById(BC5.webviewLayout);
        C23572x88 c23572x88Z = AbstractC5969Lp4.d().o2().Z();
        String str2 = this.url;
        if (str2 == null) {
            AbstractC13042fc3.y("url");
            str = null;
        } else {
            str = str2;
        }
        BaseActivity baseActivity2 = this.parent;
        if (baseActivity2 == null) {
            AbstractC13042fc3.y("parent");
            baseActivity = null;
        } else {
            baseActivity = baseActivity2;
        }
        C24162y88 c24162y88D = c23572x88Z.D(str, context, baseActivity, this.abol, this.msg, (128 & 32) != 0 ? null : this, new SA2() { // from class: ir.nasim.pk0
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return BottomSheetWebView.t();
            }
        }, (128 & 128) != 0 ? null : null);
        this.loadWebView = c24162y88D;
        if (c24162y88D != null && (webViewInterfaceB = c24162y88D.b()) != null) {
            webViewInterfaceB.u0(this);
        }
        C24162y88 c24162y88 = this.loadWebView;
        if (c24162y88 != null && (webViewA2 = c24162y88.a()) != null) {
            n(webViewA2);
        }
        FrameLayout frameLayout = this.frameLayout;
        if (frameLayout != null) {
            C24162y88 c24162y882 = this.loadWebView;
            frameLayout.addView(c24162y882 != null ? c24162y882.a() : null);
        }
        C24162y88 c24162y883 = this.loadWebView;
        if (c24162y883 != null && (webViewA = c24162y883.a()) != null) {
            webViewA.setWebViewClient(this.nonCacheWebviewClient);
        }
        C14486i0 c14486i0 = this.abol;
        if (c14486i0 != null) {
            c14486i0.l(new C14486i0.b() { // from class: ir.nasim.qk0
                @Override // ir.nasim.C14486i0.b
                public final void onDismiss() {
                    BottomSheetWebView.u(this.a, onFinishBottomSheet);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 t() {
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void u(BottomSheetWebView bottomSheetWebView, SA2 sa2) {
        AbstractC13042fc3.i(bottomSheetWebView, "this$0");
        BaseActivity baseActivity = bottomSheetWebView.parent;
        if (baseActivity == null) {
            AbstractC13042fc3.y("parent");
            baseActivity = null;
        }
        baseActivity.T1(null);
        if (sa2 != null) {
            sa2.invoke();
        }
    }

    @Override // ir.nasim.InterfaceC22386v88
    public void K() {
        p();
    }

    @Override // ir.nasim.InterfaceC22386v88
    public void X3() {
        p();
    }

    @Override // ir.nasim.InterfaceC16866m0
    public boolean a() {
        WebView webViewA;
        WebView webViewA2;
        C24162y88 c24162y88 = this.loadWebView;
        if (c24162y88 == null || (webViewA = c24162y88.a()) == null || !webViewA.canGoBack()) {
            return super.a();
        }
        C24162y88 c24162y882 = this.loadWebView;
        if (c24162y882 == null || (webViewA2 = c24162y882.a()) == null) {
            return true;
        }
        webViewA2.goBack();
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x0052  */
    @Override // ir.nasim.U5
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void c(int r5, int r6, android.content.Intent r7) {
        /*
            r4 = this;
            r0 = 6564(0x19a4, float:9.198E-42)
            r1 = 0
            if (r5 != r0) goto L26
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            if (r7 == 0) goto L1d
            java.lang.String r2 = r4.r(r7)
            if (r2 == 0) goto L1d
            long r2 = java.lang.Long.parseLong(r2)
            java.lang.Long r2 = java.lang.Long.valueOf(r2)
            r0.add(r2)
        L1d:
            ir.nasim.aJ4 r2 = r4.contactPickListener
            if (r2 == 0) goto L24
            r2.a(r0)
        L24:
            r4.contactPickListener = r1
        L26:
            r0 = -1
            if (r6 != r0) goto L52
            int r6 = r4.FILE_CHOOSER_REQUEST_CODE
            if (r5 != r6) goto L52
            android.webkit.ValueCallback r5 = r4.selectFilePathCallback
            if (r5 != 0) goto L32
            return
        L32:
            r5 = 0
            r6 = 1
            if (r7 != 0) goto L43
            java.lang.String r7 = r4.fileAddress
            if (r7 == 0) goto L52
            android.net.Uri[] r6 = new android.net.Uri[r6]
            android.net.Uri r7 = android.net.Uri.parse(r7)
            r6[r5] = r7
            goto L53
        L43:
            java.lang.String r7 = r7.getDataString()
            if (r7 == 0) goto L52
            android.net.Uri[] r6 = new android.net.Uri[r6]
            android.net.Uri r7 = android.net.Uri.parse(r7)
            r6[r5] = r7
            goto L53
        L52:
            r6 = r1
        L53:
            android.webkit.ValueCallback r5 = r4.selectFilePathCallback
            if (r5 == 0) goto L5a
            r5.onReceiveValue(r6)
        L5a:
            r4.selectFilePathCallback = r1
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.designsystem.modal.bottomSheet.BottomSheetWebView.c(int, int, android.content.Intent):void");
    }

    @Override // ir.nasim.U5
    public void d(int requestCode, String[] permissions, int[] grantResults) {
        AbstractC13042fc3.i(permissions, "permissions");
        AbstractC13042fc3.i(grantResults, "grantResults");
        if (requestCode == 1088) {
            if (!(grantResults.length == 0)) {
                if (grantResults[0] == 0) {
                    InterfaceC9644aJ4 interfaceC9644aJ4 = this.contactPickListener;
                    if (interfaceC9644aJ4 != null) {
                        e(interfaceC9644aJ4);
                        return;
                    }
                    return;
                }
                BaseActivity baseActivity = this.parent;
                if (baseActivity == null) {
                    AbstractC13042fc3.y("parent");
                    baseActivity = null;
                }
                if (baseActivity.shouldShowRequestPermissionRationale("android.permission.READ_CONTACTS")) {
                    return;
                }
                C5505Jq.M("android.permission.READ_CONTACTS", false);
                C5505Jq.M("android.permission.READ_CONTACTS_fragment", false);
            }
        }
    }

    @Override // ir.nasim.InterfaceC5417Jg1
    public void e(InterfaceC9644aJ4 listener) {
        AbstractC13042fc3.i(listener, "listener");
        this.contactPickListener = listener;
        BaseActivity baseActivity = this.parent;
        BaseActivity baseActivity2 = null;
        if (baseActivity == null) {
            AbstractC13042fc3.y("parent");
            baseActivity = null;
        }
        baseActivity.T1(this);
        BaseActivity baseActivity3 = this.parent;
        if (baseActivity3 == null) {
            AbstractC13042fc3.y("parent");
        } else {
            baseActivity2 = baseActivity3;
        }
        o(baseActivity2);
    }

    public void setAbolInstance(C14486i0 abol) {
        this.abol = abol;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BottomSheetWebView(Context context) {
        super(context);
        AbstractC13042fc3.i(context, "context");
        this.FILE_CHOOSER_REQUEST_CODE = 1056;
        this.nonCacheWebviewClient = new c();
        s(context, null);
    }

    public /* synthetic */ BottomSheetWebView(Context context, BaseActivity baseActivity, String str, C14486i0 c14486i0, J44 j44, SA2 sa2, int i, ED1 ed1) {
        this(context, baseActivity, str, c14486i0, j44, (i & 32) != 0 ? null : sa2);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BottomSheetWebView(Context context, BaseActivity baseActivity, String str, C14486i0 c14486i0, J44 j44, SA2 sa2) {
        super(context);
        AbstractC13042fc3.i(context, "context");
        AbstractC13042fc3.i(baseActivity, "parent");
        AbstractC13042fc3.i(str, "url");
        AbstractC13042fc3.i(c14486i0, "abol");
        this.FILE_CHOOSER_REQUEST_CODE = 1056;
        this.nonCacheWebviewClient = new c();
        this.parent = baseActivity;
        this.url = str;
        this.abol = c14486i0;
        this.msg = j44;
        s(context, sa2);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BottomSheetWebView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AbstractC13042fc3.i(context, "context");
        AbstractC13042fc3.i(attributeSet, "attrs");
        this.FILE_CHOOSER_REQUEST_CODE = 1056;
        this.nonCacheWebviewClient = new c();
        s(context, null);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BottomSheetWebView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AbstractC13042fc3.i(context, "context");
        AbstractC13042fc3.i(attributeSet, "attrs");
        this.FILE_CHOOSER_REQUEST_CODE = 1056;
        this.nonCacheWebviewClient = new c();
        s(context, null);
    }
}
