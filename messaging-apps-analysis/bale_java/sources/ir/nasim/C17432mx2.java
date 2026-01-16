package ir.nasim;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.recyclerview.widget.RecyclerView;

/* renamed from: ir.nasim.mx2, reason: case insensitive filesystem */
/* loaded from: classes7.dex */
public final class C17432mx2 implements InterfaceC9764aW7 {
    private final CoordinatorLayout a;
    public final RecyclerView b;
    public final ImageView c;
    public final TextView d;
    public final ImageView e;
    public final ImageView f;
    public final ImageView g;
    public final ImageView h;
    public final SeekBar i;

    private C17432mx2(CoordinatorLayout coordinatorLayout, RecyclerView recyclerView, ImageView imageView, TextView textView, ImageView imageView2, ImageView imageView3, ImageView imageView4, ImageView imageView5, SeekBar seekBar) {
        this.a = coordinatorLayout;
        this.b = recyclerView;
        this.c = imageView;
        this.d = textView;
        this.e = imageView2;
        this.f = imageView3;
        this.g = imageView4;
        this.h = imageView5;
        this.i = seekBar;
    }

    public static C17432mx2 a(View view) {
        int i = AbstractC18172oC5.add_text_color_picker_recycler_view;
        RecyclerView recyclerView = (RecyclerView) AbstractC11738dW7.a(view, i);
        if (recyclerView != null) {
            i = AbstractC18172oC5.circle_icon;
            ImageView imageView = (ImageView) AbstractC11738dW7.a(view, i);
            if (imageView != null) {
                i = AbstractC18172oC5.done;
                TextView textView = (TextView) AbstractC11738dW7.a(view, i);
                if (textView != null) {
                    i = AbstractC18172oC5.draw_icon;
                    ImageView imageView2 = (ImageView) AbstractC11738dW7.a(view, i);
                    if (imageView2 != null) {
                        i = AbstractC18172oC5.erase_icon;
                        ImageView imageView3 = (ImageView) AbstractC11738dW7.a(view, i);
                        if (imageView3 != null) {
                            i = AbstractC18172oC5.line_icon;
                            ImageView imageView4 = (ImageView) AbstractC11738dW7.a(view, i);
                            if (imageView4 != null) {
                                i = AbstractC18172oC5.rectangle_icon;
                                ImageView imageView5 = (ImageView) AbstractC11738dW7.a(view, i);
                                if (imageView5 != null) {
                                    i = AbstractC18172oC5.seekbar;
                                    SeekBar seekBar = (SeekBar) AbstractC11738dW7.a(view, i);
                                    if (seekBar != null) {
                                        return new C17432mx2((CoordinatorLayout) view, recyclerView, imageView, textView, imageView2, imageView3, imageView4, imageView5, seekBar);
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

    public static C17432mx2 c(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(RC5.fragment_add_draw, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // ir.nasim.InterfaceC9764aW7
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public CoordinatorLayout getRoot() {
        return this.a;
    }
}
