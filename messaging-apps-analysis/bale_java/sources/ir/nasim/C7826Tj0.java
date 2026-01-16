package ir.nasim;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;

/* renamed from: ir.nasim.Tj0, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C7826Tj0 implements InterfaceC9764aW7 {
    private final ConstraintLayout a;
    public final View b;
    public final ImageView c;
    public final TextView d;
    public final TextView e;

    private C7826Tj0(ConstraintLayout constraintLayout, View view, ImageView imageView, TextView textView, TextView textView2) {
        this.a = constraintLayout;
        this.b = view;
        this.c = imageView;
        this.d = textView;
        this.e = textView2;
    }

    public static C7826Tj0 a(View view) {
        int i = BC5.divider_layout;
        View viewA = AbstractC11738dW7.a(view, i);
        if (viewA != null) {
            i = BC5.header_image;
            ImageView imageView = (ImageView) AbstractC11738dW7.a(view, i);
            if (imageView != null) {
                i = BC5.openProfile;
                TextView textView = (TextView) AbstractC11738dW7.a(view, i);
                if (textView != null) {
                    i = BC5.openStory;
                    TextView textView2 = (TextView) AbstractC11738dW7.a(view, i);
                    if (textView2 != null) {
                        return new C7826Tj0((ConstraintLayout) view, viewA, imageView, textView, textView2);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static C7826Tj0 c(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(AbstractC12208eD5.bottom_sheet_avatar_with_story_opening_selection, viewGroup, false);
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
