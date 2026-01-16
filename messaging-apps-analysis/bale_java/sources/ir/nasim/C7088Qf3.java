package ir.nasim;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.google.android.material.textview.MaterialTextView;
import ir.nasim.designsystem.avatar.AvatarViewGlide;

/* renamed from: ir.nasim.Qf3, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C7088Qf3 implements InterfaceC9764aW7 {
    private final ConstraintLayout a;
    public final AvatarViewGlide b;
    public final ImageView c;
    public final MaterialTextView d;
    public final MaterialTextView e;
    public final C6587Od3 f;

    private C7088Qf3(ConstraintLayout constraintLayout, AvatarViewGlide avatarViewGlide, ImageView imageView, MaterialTextView materialTextView, MaterialTextView materialTextView2, C6587Od3 c6587Od3) {
        this.a = constraintLayout;
        this.b = avatarViewGlide;
        this.c = imageView;
        this.d = materialTextView;
        this.e = materialTextView2;
        this.f = c6587Od3;
    }

    public static C7088Qf3 a(View view) {
        View viewA;
        int i = BC5.contact_image;
        AvatarViewGlide avatarViewGlide = (AvatarViewGlide) AbstractC11738dW7.a(view, i);
        if (avatarViewGlide != null) {
            i = BC5.contactMxpIcon;
            ImageView imageView = (ImageView) AbstractC11738dW7.a(view, i);
            if (imageView != null) {
                i = BC5.contact_name;
                MaterialTextView materialTextView = (MaterialTextView) AbstractC11738dW7.a(view, i);
                if (materialTextView != null) {
                    i = BC5.contact_phone_number;
                    MaterialTextView materialTextView2 = (MaterialTextView) AbstractC11738dW7.a(view, i);
                    if (materialTextView2 != null && (viewA = AbstractC11738dW7.a(view, (i = BC5.invite_button))) != null) {
                        return new C7088Qf3((ConstraintLayout) view, avatarViewGlide, imageView, materialTextView, materialTextView2, C6587Od3.a(viewA));
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static C7088Qf3 c(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(AbstractC12208eD5.item_phone_contact, viewGroup, false);
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
