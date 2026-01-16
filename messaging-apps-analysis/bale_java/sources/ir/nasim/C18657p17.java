package ir.nasim;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import ir.nasim.designsystem.avatar.AvatarViewGlide;

/* renamed from: ir.nasim.p17, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public final class C18657p17 implements InterfaceC9764aW7 {
    private final ConstraintLayout a;
    public final AvatarViewGlide b;
    public final ImageView c;
    public final TextView d;

    private C18657p17(ConstraintLayout constraintLayout, AvatarViewGlide avatarViewGlide, ImageView imageView, TextView textView) {
        this.a = constraintLayout;
        this.b = avatarViewGlide;
        this.c = imageView;
        this.d = textView;
    }

    public static C18657p17 a(View view) {
        int i = AbstractC12808fC5.avatar_suggester;
        AvatarViewGlide avatarViewGlide = (AvatarViewGlide) AbstractC11738dW7.a(view, i);
        if (avatarViewGlide != null) {
            i = AbstractC12808fC5.icon_suggester;
            ImageView imageView = (ImageView) AbstractC11738dW7.a(view, i);
            if (imageView != null) {
                i = AbstractC12808fC5.name_suggester;
                TextView textView = (TextView) AbstractC11738dW7.a(view, i);
                if (textView != null) {
                    return new C18657p17((ConstraintLayout) view, avatarViewGlide, imageView, textView);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static C18657p17 c(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(HC5.suggester_holder, viewGroup, false);
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
