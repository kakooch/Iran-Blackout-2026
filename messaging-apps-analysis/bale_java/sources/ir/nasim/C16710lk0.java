package ir.nasim;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;

/* renamed from: ir.nasim.lk0, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C16710lk0 implements InterfaceC9764aW7 {
    private final ConstraintLayout a;
    public final View b;
    public final ImageView c;
    public final TextView d;
    public final TextView e;

    private C16710lk0(ConstraintLayout constraintLayout, View view, ImageView imageView, TextView textView, TextView textView2) {
        this.a = constraintLayout;
        this.b = view;
        this.c = imageView;
        this.d = textView;
        this.e = textView2;
    }

    public static C16710lk0 a(View view) {
        int i = BC5.divider_layout;
        View viewA = AbstractC11738dW7.a(view, i);
        if (viewA != null) {
            i = BC5.header_image;
            ImageView imageView = (ImageView) AbstractC11738dW7.a(view, i);
            if (imageView != null) {
                i = BC5.photo_capture;
                TextView textView = (TextView) AbstractC11738dW7.a(view, i);
                if (textView != null) {
                    i = BC5.video_capture;
                    TextView textView2 = (TextView) AbstractC11738dW7.a(view, i);
                    if (textView2 != null) {
                        return new C16710lk0((ConstraintLayout) view, viewA, imageView, textView, textView2);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static C16710lk0 c(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(AbstractC12208eD5.bottom_sheet_story_adder, viewGroup, false);
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
