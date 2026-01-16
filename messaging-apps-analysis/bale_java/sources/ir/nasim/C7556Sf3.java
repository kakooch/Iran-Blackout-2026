package ir.nasim;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import ir.nasim.designsystem.avatar.AvatarViewGlide;

/* renamed from: ir.nasim.Sf3, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C7556Sf3 implements InterfaceC9764aW7 {
    private final ConstraintLayout a;
    public final AvatarViewGlide b;
    public final TextView c;
    public final ConstraintLayout d;
    public final TextView e;
    public final ImageView f;
    public final LinearLayout g;

    private C7556Sf3(ConstraintLayout constraintLayout, AvatarViewGlide avatarViewGlide, TextView textView, ConstraintLayout constraintLayout2, TextView textView2, ImageView imageView, LinearLayout linearLayout) {
        this.a = constraintLayout;
        this.b = avatarViewGlide;
        this.c = textView;
        this.d = constraintLayout2;
        this.e = textView2;
        this.f = imageView;
        this.g = linearLayout;
    }

    public static C7556Sf3 a(View view) {
        int i = AbstractC14017hC5.avatar;
        AvatarViewGlide avatarViewGlide = (AvatarViewGlide) AbstractC11738dW7.a(view, i);
        if (avatarViewGlide != null) {
            i = AbstractC14017hC5.description;
            TextView textView = (TextView) AbstractC11738dW7.a(view, i);
            if (textView != null) {
                ConstraintLayout constraintLayout = (ConstraintLayout) view;
                i = AbstractC14017hC5.title;
                TextView textView2 = (TextView) AbstractC11738dW7.a(view, i);
                if (textView2 != null) {
                    i = AbstractC14017hC5.titleDrawable;
                    ImageView imageView = (ImageView) AbstractC11738dW7.a(view, i);
                    if (imageView != null) {
                        i = AbstractC14017hC5.titleLayout;
                        LinearLayout linearLayout = (LinearLayout) AbstractC11738dW7.a(view, i);
                        if (linearLayout != null) {
                            return new C7556Sf3(constraintLayout, avatarViewGlide, textView, constraintLayout, textView2, imageView, linearLayout);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static C7556Sf3 c(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(JC5.item_search_result_peer, viewGroup, false);
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
