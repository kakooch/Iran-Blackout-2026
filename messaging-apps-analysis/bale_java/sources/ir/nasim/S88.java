package ir.nasim;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;

/* loaded from: classes5.dex */
public final class S88 implements InterfaceC9764aW7 {
    private final RelativeLayout a;
    public final View b;
    public final TextView c;
    public final O50 d;
    public final ScrollView e;
    public final WebView f;
    public final ConstraintLayout g;
    public final RelativeLayout h;
    public final TextView i;

    private S88(RelativeLayout relativeLayout, View view, TextView textView, O50 o50, ScrollView scrollView, WebView webView, ConstraintLayout constraintLayout, RelativeLayout relativeLayout2, TextView textView2) {
        this.a = relativeLayout;
        this.b = view;
        this.c = textView;
        this.d = o50;
        this.e = scrollView;
        this.f = webView;
        this.g = constraintLayout;
        this.h = relativeLayout2;
        this.i = textView2;
    }

    public static S88 a(View view) {
        View viewA;
        int i = BC5.c6;
        View viewA2 = AbstractC11738dW7.a(view, i);
        if (viewA2 != null) {
            i = BC5.close_webview;
            TextView textView = (TextView) AbstractC11738dW7.a(view, i);
            if (textView != null && (viewA = AbstractC11738dW7.a(view, (i = BC5.progress_bar_view))) != null) {
                O50 o50A = O50.a(viewA);
                i = BC5.scroll_view;
                ScrollView scrollView = (ScrollView) AbstractC11738dW7.a(view, i);
                if (scrollView != null) {
                    i = BC5.wb_webview;
                    WebView webView = (WebView) AbstractC11738dW7.a(view, i);
                    if (webView != null) {
                        i = BC5.webview_header;
                        ConstraintLayout constraintLayout = (ConstraintLayout) AbstractC11738dW7.a(view, i);
                        if (constraintLayout != null) {
                            RelativeLayout relativeLayout = (RelativeLayout) view;
                            i = BC5.webview_tite;
                            TextView textView2 = (TextView) AbstractC11738dW7.a(view, i);
                            if (textView2 != null) {
                                return new S88(relativeLayout, viewA2, textView, o50A, scrollView, webView, constraintLayout, relativeLayout, textView2);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static S88 c(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(AbstractC12208eD5.webview_bottom_sheet, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // ir.nasim.InterfaceC9764aW7
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public RelativeLayout getRoot() {
        return this.a;
    }
}
