package ir.nasim;

import android.view.View;
import android.widget.LinearLayout;
import androidx.appcompat.widget.AppCompatTextView;

/* renamed from: ir.nasim.zy2, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C25241zy2 implements InterfaceC9764aW7 {
    private final LinearLayout a;
    public final LinearLayout b;
    public final AppCompatTextView c;

    private C25241zy2(LinearLayout linearLayout, LinearLayout linearLayout2, AppCompatTextView appCompatTextView) {
        this.a = linearLayout;
        this.b = linearLayout2;
        this.c = appCompatTextView;
    }

    public static C25241zy2 a(View view) {
        LinearLayout linearLayout = (LinearLayout) view;
        int i = BC5.skipBtn;
        AppCompatTextView appCompatTextView = (AppCompatTextView) AbstractC11738dW7.a(view, i);
        if (appCompatTextView != null) {
            return new C25241zy2(linearLayout, linearLayout, appCompatTextView);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    @Override // ir.nasim.InterfaceC9764aW7
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public LinearLayout getRoot() {
        return this.a;
    }
}
