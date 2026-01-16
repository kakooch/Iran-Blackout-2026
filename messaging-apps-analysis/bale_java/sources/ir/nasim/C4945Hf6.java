package ir.nasim;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;

/* renamed from: ir.nasim.Hf6, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C4945Hf6 implements InterfaceC9764aW7 {
    private final ConstraintLayout a;
    public final ImageView b;
    public final TextView c;

    private C4945Hf6(ConstraintLayout constraintLayout, ImageView imageView, TextView textView) {
        this.a = constraintLayout;
        this.b = imageView;
        this.c = textView;
    }

    public static C4945Hf6 a(View view) {
        int i = AbstractC14017hC5.category_img;
        ImageView imageView = (ImageView) AbstractC11738dW7.a(view, i);
        if (imageView != null) {
            i = AbstractC14017hC5.title_txt;
            TextView textView = (TextView) AbstractC11738dW7.a(view, i);
            if (textView != null) {
                return new C4945Hf6((ConstraintLayout) view, imageView, textView);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static C4945Hf6 c(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(JC5.search_category_item, viewGroup, false);
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
