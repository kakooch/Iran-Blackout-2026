package ir.nasim;

import android.content.Context;
import android.gov.nist.core.Separators;
import android.gov.nist.javax.sip.header.ParameterNames;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.LinearLayout;
import androidx.fragment.app.FragmentActivity;
import com.google.android.material.appbar.AppBarLayout;
import ir.nasim.components.appbar.view.BaleToolbar;
import kotlin.Metadata;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\t\b\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0019\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ+\u0010\u000e\u001a\u00020\r2\u0006\u0010\n\u001a\u00020\t2\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0013\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012¨\u0006\u0014"}, d2 = {"Lir/nasim/DW0;", "Lir/nasim/ua0;", "<init>", "()V", "Landroid/os/Bundle;", "savedInstanceState", "Lir/nasim/rB7;", "M6", "(Landroid/os/Bundle;)V", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/view/View;", "Q6", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "", "c1", "Ljava/lang/String;", ParameterNames.TEXT, "nasim_release"}, k = 1, mv = {2, 0, 0})
/* loaded from: classes6.dex */
public final class DW0 extends C22042ua0 {

    /* renamed from: c1, reason: from kotlin metadata */
    private String text = "";

    @Override // androidx.fragment.app.Fragment
    public void M6(Bundle savedInstanceState) {
        super.M6(savedInstanceState);
        Bundle bundleE5 = E5();
        if (bundleE5 != null) {
            this.text = bundleE5.getString("arg_source_code", "");
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View Q6(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        AbstractC13042fc3.i(inflater, "inflater");
        LinearLayout linearLayout = new LinearLayout(G5());
        linearLayout.setBackgroundColor(C5495Jo7.a.O0());
        linearLayout.setOrientation(1);
        linearLayout.setLayoutParams(C14433hu3.d(-1, -1));
        BaleToolbar.Companion companion = BaleToolbar.INSTANCE;
        FragmentActivity fragmentActivityQ7 = Q7();
        AbstractC13042fc3.h(fragmentActivityQ7, "requireActivity(...)");
        BaleToolbar baleToolbarD = BaleToolbar.Companion.d(companion, fragmentActivityQ7, "Source Code", false, 4, null);
        Context contextS7 = S7();
        AbstractC13042fc3.h(contextS7, "requireContext(...)");
        AppBarLayout appBarLayoutA = companion.a(contextS7);
        appBarLayoutA.addView(baleToolbarD);
        linearLayout.addView(appBarLayoutA);
        WebView webView = new WebView(S7());
        webView.getSettings().setJavaScriptEnabled(true);
        webView.loadDataWithBaseURL("file:///android_asset/", "<html>\n<header>\n<link rel=\"stylesheet\" href=\"highlight-default.min.css\">\n<script src=\"highlight.min.js\"></script>\n<script>hljs.initHighlightingOnLoad();</script>\n</header>\n<body>\n<pre><code>" + AbstractC20153rZ6.M(AbstractC20153rZ6.M(AbstractC20153rZ6.M(AbstractC20153rZ6.M(AbstractC20153rZ6.M(this.text, Separators.AND, "&amp;", false, 4, null), Separators.LESS_THAN, "&lt;", false, 4, null), Separators.GREATER_THAN, "&gt;", false, 4, null), Separators.DOUBLE_QUOTE, "&quot;", false, 4, null), Separators.RETURN, "<br/>", false, 4, null) + "</code></pre></body>\n</html>", "text/html", "utf-8", "");
        linearLayout.addView(webView, new LinearLayout.LayoutParams(-1, -1));
        return linearLayout;
    }
}
