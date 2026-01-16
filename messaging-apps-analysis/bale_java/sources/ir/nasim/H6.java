package ir.nasim;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.google.android.material.card.MaterialCardView;

/* loaded from: classes5.dex */
public final class H6 implements InterfaceC9764aW7 {
    private final ConstraintLayout a;
    public final MaterialCardView b;
    public final ImageView c;
    public final HorizontalScrollView d;
    public final View e;
    public final TextView f;
    public final WebView g;

    private H6(ConstraintLayout constraintLayout, MaterialCardView materialCardView, ImageView imageView, HorizontalScrollView horizontalScrollView, View view, TextView textView, WebView webView) {
        this.a = constraintLayout;
        this.b = materialCardView;
        this.c = imageView;
        this.d = horizontalScrollView;
        this.e = view;
        this.f = textView;
        this.g = webView;
    }

    public static H6 a(View view) {
        View viewA;
        int i = BC5.cardUrl;
        MaterialCardView materialCardView = (MaterialCardView) AbstractC11738dW7.a(view, i);
        if (materialCardView != null) {
            i = BC5.closeImg;
            ImageView imageView = (ImageView) AbstractC11738dW7.a(view, i);
            if (imageView != null) {
                i = BC5.scrollview;
                HorizontalScrollView horizontalScrollView = (HorizontalScrollView) AbstractC11738dW7.a(view, i);
                if (horizontalScrollView != null && (viewA = AbstractC11738dW7.a(view, (i = BC5.statusBar_background))) != null) {
                    i = BC5.urlTv;
                    TextView textView = (TextView) AbstractC11738dW7.a(view, i);
                    if (textView != null) {
                        i = BC5.webView;
                        WebView webView = (WebView) AbstractC11738dW7.a(view, i);
                        if (webView != null) {
                            return new H6((ConstraintLayout) view, materialCardView, imageView, horizontalScrollView, viewA, textView, webView);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static H6 c(LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    public static H6 d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(AbstractC12208eD5.activity_web_view_payment, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // ir.nasim.InterfaceC9764aW7
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public ConstraintLayout getRoot() {
        return this.a;
    }
}
