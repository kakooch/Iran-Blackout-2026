package ir.nasim;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;

/* renamed from: ir.nasim.Zf3, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C9272Zf3 implements InterfaceC9764aW7 {
    private final LinearLayout a;
    public final AppCompatImageView b;
    public final LinearLayout c;
    public final AppCompatTextView d;

    private C9272Zf3(LinearLayout linearLayout, AppCompatImageView appCompatImageView, LinearLayout linearLayout2, AppCompatTextView appCompatTextView) {
        this.a = linearLayout;
        this.b = appCompatImageView;
        this.c = linearLayout2;
        this.d = appCompatTextView;
    }

    public static C9272Zf3 a(View view) {
        int i = BC5.ivMxp;
        AppCompatImageView appCompatImageView = (AppCompatImageView) AbstractC11738dW7.a(view, i);
        if (appCompatImageView != null) {
            LinearLayout linearLayout = (LinearLayout) view;
            int i2 = BC5.tvMxpName;
            AppCompatTextView appCompatTextView = (AppCompatTextView) AbstractC11738dW7.a(view, i2);
            if (appCompatTextView != null) {
                return new C9272Zf3(linearLayout, appCompatImageView, linearLayout, appCompatTextView);
            }
            i = i2;
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static C9272Zf3 c(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(AbstractC12208eD5.item_select_mxp_contact, viewGroup, false);
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
