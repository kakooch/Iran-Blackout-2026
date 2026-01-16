package ir.nasim;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

/* renamed from: ir.nasim.Bp4, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C3614Bp4 implements InterfaceC9764aW7 {
    private final ScrollView a;
    public final TextView b;
    public final TextView c;
    public final LinearLayout d;
    public final TextView e;
    public final TextView f;

    private C3614Bp4(ScrollView scrollView, TextView textView, TextView textView2, LinearLayout linearLayout, TextView textView3, TextView textView4) {
        this.a = scrollView;
        this.b = textView;
        this.c = textView2;
        this.d = linearLayout;
        this.e = textView3;
        this.f = textView4;
    }

    public static C3614Bp4 a(View view) {
        int i = android.R.id.copy;
        TextView textView = (TextView) AbstractC11738dW7.a(view, android.R.id.copy);
        if (textView != null) {
            i = android.R.id.cut;
            TextView textView2 = (TextView) AbstractC11738dW7.a(view, android.R.id.cut);
            if (textView2 != null) {
                i = BC5.itemsContainer;
                LinearLayout linearLayout = (LinearLayout) AbstractC11738dW7.a(view, i);
                if (linearLayout != null) {
                    i = android.R.id.paste;
                    TextView textView3 = (TextView) AbstractC11738dW7.a(view, android.R.id.paste);
                    if (textView3 != null) {
                        i = android.R.id.selectAll;
                        TextView textView4 = (TextView) AbstractC11738dW7.a(view, android.R.id.selectAll);
                        if (textView4 != null) {
                            return new C3614Bp4((ScrollView) view, textView, textView2, linearLayout, textView3, textView4);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static C3614Bp4 c(LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    public static C3614Bp4 d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(AbstractC12208eD5.nasim_horizontal_menu, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // ir.nasim.InterfaceC9764aW7
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public ScrollView getRoot() {
        return this.a;
    }
}
