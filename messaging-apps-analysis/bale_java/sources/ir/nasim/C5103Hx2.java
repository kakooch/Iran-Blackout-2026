package ir.nasim;

import android.view.View;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import ir.nasim.designsystem.avatar.AvatarViewGlide;

/* renamed from: ir.nasim.Hx2, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C5103Hx2 implements InterfaceC9764aW7 {
    private final ConstraintLayout a;
    public final AvatarViewGlide b;
    public final TextView c;
    public final TextView d;
    public final View e;

    private C5103Hx2(ConstraintLayout constraintLayout, AvatarViewGlide avatarViewGlide, TextView textView, TextView textView2, View view) {
        this.a = constraintLayout;
        this.b = avatarViewGlide;
        this.c = textView;
        this.d = textView2;
        this.e = view;
    }

    public static C5103Hx2 a(View view) {
        View viewA;
        int i = BC5.avatar;
        AvatarViewGlide avatarViewGlide = (AvatarViewGlide) AbstractC11738dW7.a(view, i);
        if (avatarViewGlide != null) {
            i = BC5.command;
            TextView textView = (TextView) AbstractC11738dW7.a(view, i);
            if (textView != null) {
                i = BC5.description;
                TextView textView2 = (TextView) AbstractC11738dW7.a(view, i);
                if (textView2 != null && (viewA = AbstractC11738dW7.a(view, (i = BC5.divider))) != null) {
                    return new C5103Hx2((ConstraintLayout) view, avatarViewGlide, textView, textView2, viewA);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    @Override // ir.nasim.InterfaceC9764aW7
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public ConstraintLayout getRoot() {
        return this.a;
    }
}
