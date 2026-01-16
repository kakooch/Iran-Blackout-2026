package ir.nasim;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

/* renamed from: ir.nasim.Kj1, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C5678Kj1 implements InterfaceC9764aW7 {
    private final LinearLayout a;
    public final ImageView b;
    public final TextView c;

    private C5678Kj1(LinearLayout linearLayout, ImageView imageView, TextView textView) {
        this.a = linearLayout;
        this.b = imageView;
        this.c = textView;
    }

    public static C5678Kj1 a(View view) {
        int i = BC5.icon;
        ImageView imageView = (ImageView) AbstractC11738dW7.a(view, i);
        if (imageView != null) {
            i = BC5.title;
            TextView textView = (TextView) AbstractC11738dW7.a(view, i);
            if (textView != null) {
                return new C5678Kj1((LinearLayout) view, imageView, textView);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static C5678Kj1 c(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(AbstractC12208eD5.contacts_title_item, viewGroup, false);
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
