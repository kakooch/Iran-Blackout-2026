package ir.nasim;

import android.view.View;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.google.android.material.button.MaterialButton;

/* renamed from: ir.nasim.lz2, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C16859lz2 implements InterfaceC9764aW7 {
    private final LinearLayout a;
    public final ImageView b;
    public final TextView c;
    public final TextView d;
    public final MaterialButton e;
    public final TextView f;
    public final ConstraintLayout g;
    public final TextView h;
    public final ImageView i;
    public final O50 j;
    public final WebView k;

    private C16859lz2(LinearLayout linearLayout, ImageView imageView, TextView textView, TextView textView2, MaterialButton materialButton, TextView textView3, ConstraintLayout constraintLayout, TextView textView4, ImageView imageView2, O50 o50, WebView webView) {
        this.a = linearLayout;
        this.b = imageView;
        this.c = textView;
        this.d = textView2;
        this.e = materialButton;
        this.f = textView3;
        this.g = constraintLayout;
        this.h = textView4;
        this.i = imageView2;
        this.j = o50;
        this.k = webView;
    }

    public static C16859lz2 a(View view) {
        View viewA;
        int i = BC5.back_img;
        ImageView imageView = (ImageView) AbstractC11738dW7.a(view, i);
        if (imageView != null) {
            i = BC5.card_number_title_txt;
            TextView textView = (TextView) AbstractC11738dW7.a(view, i);
            if (textView != null) {
                i = BC5.card_number_txt;
                TextView textView2 = (TextView) AbstractC11738dW7.a(view, i);
                if (textView2 != null) {
                    i = BC5.exitButton;
                    MaterialButton materialButton = (MaterialButton) AbstractC11738dW7.a(view, i);
                    if (materialButton != null) {
                        i = BC5.loadingDescription;
                        TextView textView3 = (TextView) AbstractC11738dW7.a(view, i);
                        if (textView3 != null) {
                            i = BC5.loadingLayout;
                            ConstraintLayout constraintLayout = (ConstraintLayout) AbstractC11738dW7.a(view, i);
                            if (constraintLayout != null) {
                                i = BC5.loadingTitle;
                                TextView textView4 = (TextView) AbstractC11738dW7.a(view, i);
                                if (textView4 != null) {
                                    i = BC5.lock_img;
                                    ImageView imageView2 = (ImageView) AbstractC11738dW7.a(view, i);
                                    if (imageView2 != null && (viewA = AbstractC11738dW7.a(view, (i = BC5.progress_bar_view))) != null) {
                                        O50 o50A = O50.a(viewA);
                                        i = BC5.webView_shaparak;
                                        WebView webView = (WebView) AbstractC11738dW7.a(view, i);
                                        if (webView != null) {
                                            return new C16859lz2((LinearLayout) view, imageView, textView, textView2, materialButton, textView3, constraintLayout, textView4, imageView2, o50A, webView);
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    @Override // ir.nasim.InterfaceC9764aW7
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public LinearLayout getRoot() {
        return this.a;
    }
}
