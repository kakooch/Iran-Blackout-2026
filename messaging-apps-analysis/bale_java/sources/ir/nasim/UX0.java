package ir.nasim;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;

/* loaded from: classes5.dex */
public final class UX0 implements InterfaceC9764aW7 {
    private final ConstraintLayout a;
    public final ImageView b;
    public final ImageView c;
    public final ImageView d;

    private UX0(ConstraintLayout constraintLayout, ImageView imageView, ImageView imageView2, ImageView imageView3) {
        this.a = constraintLayout;
        this.b = imageView;
        this.c = imageView2;
        this.d = imageView3;
    }

    public static UX0 a(View view) {
        int i = BC5.border;
        ImageView imageView = (ImageView) AbstractC11738dW7.a(view, i);
        if (imageView != null) {
            i = BC5.color_picker_view;
            ImageView imageView2 = (ImageView) AbstractC11738dW7.a(view, i);
            if (imageView2 != null) {
                i = BC5.select_icon;
                ImageView imageView3 = (ImageView) AbstractC11738dW7.a(view, i);
                if (imageView3 != null) {
                    return new UX0((ConstraintLayout) view, imageView, imageView2, imageView3);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static UX0 c(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(AbstractC12208eD5.color_picker_item_list, viewGroup, false);
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
