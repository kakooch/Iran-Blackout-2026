package ir.nasim;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.google.android.material.textview.MaterialTextView;
import ir.nasim.designsystem.avatar.AvatarViewGlide;

/* renamed from: ir.nasim.Pf3, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C6844Pf3 implements InterfaceC9764aW7 {
    private final ConstraintLayout a;
    public final AvatarViewGlide b;
    public final ImageButton c;
    public final MaterialTextView d;

    private C6844Pf3(ConstraintLayout constraintLayout, AvatarViewGlide avatarViewGlide, ImageButton imageButton, MaterialTextView materialTextView) {
        this.a = constraintLayout;
        this.b = avatarViewGlide;
        this.c = imageButton;
        this.d = materialTextView;
    }

    public static C6844Pf3 a(View view) {
        int i = BC5.puppet_image;
        AvatarViewGlide avatarViewGlide = (AvatarViewGlide) AbstractC11738dW7.a(view, i);
        if (avatarViewGlide != null) {
            i = BC5.puppet_mxp_btn;
            ImageButton imageButton = (ImageButton) AbstractC11738dW7.a(view, i);
            if (imageButton != null) {
                i = BC5.puppet_name;
                MaterialTextView materialTextView = (MaterialTextView) AbstractC11738dW7.a(view, i);
                if (materialTextView != null) {
                    return new C6844Pf3((ConstraintLayout) view, avatarViewGlide, imageButton, materialTextView);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static C6844Pf3 c(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(AbstractC12208eD5.item_mxp_puppet_contact, viewGroup, false);
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
