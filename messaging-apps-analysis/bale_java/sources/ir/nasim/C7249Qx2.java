package ir.nasim;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ListView;
import ir.nasim.components.appbar.view.BaleToolbar;

/* renamed from: ir.nasim.Qx2, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C7249Qx2 implements InterfaceC9764aW7 {
    private final LinearLayout a;
    public final BaleToolbar b;
    public final LinearLayout c;
    public final ListView d;

    private C7249Qx2(LinearLayout linearLayout, BaleToolbar baleToolbar, LinearLayout linearLayout2, ListView listView) {
        this.a = linearLayout;
        this.b = baleToolbar;
        this.c = linearLayout2;
        this.d = listView;
    }

    public static C7249Qx2 a(View view) {
        int i = BC5.choose_country_toolbar;
        BaleToolbar baleToolbar = (BaleToolbar) AbstractC11738dW7.a(view, i);
        if (baleToolbar != null) {
            LinearLayout linearLayout = (LinearLayout) view;
            int i2 = BC5.lv_countries;
            ListView listView = (ListView) AbstractC11738dW7.a(view, i2);
            if (listView != null) {
                return new C7249Qx2(linearLayout, baleToolbar, linearLayout, listView);
            }
            i = i2;
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static C7249Qx2 c(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(AbstractC12208eD5.fragment_country_select, viewGroup, false);
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
