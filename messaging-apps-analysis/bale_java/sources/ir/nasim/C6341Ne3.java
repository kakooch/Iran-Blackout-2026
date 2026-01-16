package ir.nasim;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.google.android.material.textview.MaterialTextView;
import ir.nasim.designsystem.avatar.AvatarViewGlide;

/* renamed from: ir.nasim.Ne3, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C6341Ne3 implements InterfaceC9764aW7 {
    private final ConstraintLayout a;
    public final AvatarViewGlide b;
    public final MaterialTextView c;
    public final MaterialTextView d;
    public final ImageButton e;
    public final ImageView f;

    private C6341Ne3(ConstraintLayout constraintLayout, AvatarViewGlide avatarViewGlide, MaterialTextView materialTextView, MaterialTextView materialTextView2, ImageButton imageButton, ImageView imageView) {
        this.a = constraintLayout;
        this.b = avatarViewGlide;
        this.c = materialTextView;
        this.d = materialTextView2;
        this.e = imageButton;
        this.f = imageView;
    }

    public static C6341Ne3 a(View view) {
        int i = BC5.contact_image;
        AvatarViewGlide avatarViewGlide = (AvatarViewGlide) AbstractC11738dW7.a(view, i);
        if (avatarViewGlide != null) {
            i = BC5.contact_last_seen;
            MaterialTextView materialTextView = (MaterialTextView) AbstractC11738dW7.a(view, i);
            if (materialTextView != null) {
                i = BC5.contact_name;
                MaterialTextView materialTextView2 = (MaterialTextView) AbstractC11738dW7.a(view, i);
                if (materialTextView2 != null) {
                    i = BC5.contact_voice_call;
                    ImageButton imageButton = (ImageButton) AbstractC11738dW7.a(view, i);
                    if (imageButton != null) {
                        i = BC5.online_circle;
                        ImageView imageView = (ImageView) AbstractC11738dW7.a(view, i);
                        if (imageView != null) {
                            return new C6341Ne3((ConstraintLayout) view, avatarViewGlide, materialTextView, materialTextView2, imageButton, imageView);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static C6341Ne3 c(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(AbstractC12208eD5.item_bale_contact, viewGroup, false);
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
