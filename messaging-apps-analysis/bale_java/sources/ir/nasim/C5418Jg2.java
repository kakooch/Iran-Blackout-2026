package ir.nasim;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;

/* renamed from: ir.nasim.Jg2, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C5418Jg2 implements InterfaceC9764aW7 {
    private final ConstraintLayout a;
    public final TextView b;
    public final ConstraintLayout c;
    public final ImageView d;
    public final TextView e;

    private C5418Jg2(ConstraintLayout constraintLayout, TextView textView, ConstraintLayout constraintLayout2, ImageView imageView, TextView textView2) {
        this.a = constraintLayout;
        this.b = textView;
        this.c = constraintLayout2;
        this.d = imageView;
        this.e = textView2;
    }

    public static C5418Jg2 a(View view) {
        int i = YB5.call_option_badge_new;
        TextView textView = (TextView) AbstractC11738dW7.a(view, i);
        if (textView != null) {
            ConstraintLayout constraintLayout = (ConstraintLayout) view;
            i = YB5.call_option_icon;
            ImageView imageView = (ImageView) AbstractC11738dW7.a(view, i);
            if (imageView != null) {
                i = YB5.call_option_title;
                TextView textView2 = (TextView) AbstractC11738dW7.a(view, i);
                if (textView2 != null) {
                    return new C5418Jg2(constraintLayout, textView, constraintLayout, imageView, textView2);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static C5418Jg2 c(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(AbstractC9591aD5.features_call_option_item, viewGroup, false);
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
