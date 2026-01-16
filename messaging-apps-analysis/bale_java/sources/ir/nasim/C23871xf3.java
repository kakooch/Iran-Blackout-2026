package ir.nasim;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

/* renamed from: ir.nasim.xf3, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C23871xf3 implements InterfaceC9764aW7 {
    private final LinearLayout a;
    public final TextView b;
    public final TextView c;

    private C23871xf3(LinearLayout linearLayout, TextView textView, TextView textView2) {
        this.a = linearLayout;
        this.b = textView;
        this.c = textView2;
    }

    public static C23871xf3 a(View view) {
        int i = BC5.shop_title_txt;
        TextView textView = (TextView) AbstractC11738dW7.a(view, i);
        if (textView != null) {
            i = BC5.shoper_service_txt;
            TextView textView2 = (TextView) AbstractC11738dW7.a(view, i);
            if (textView2 != null) {
                return new C23871xf3((LinearLayout) view, textView, textView2);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static C23871xf3 c(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(AbstractC12208eD5.item_market_header, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // ir.nasim.InterfaceC9764aW7
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public LinearLayout getRoot() {
        return this.a;
    }
}
