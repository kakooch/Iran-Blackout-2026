package ir.nasim;

import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.google.android.material.textview.MaterialTextView;
import ir.nasim.designsystem.avatar.AvatarViewGlide;

/* loaded from: classes5.dex */
public final class HW7 implements InterfaceC9764aW7 {
    private final ConstraintLayout a;
    public final CheckBox b;
    public final AvatarViewGlide c;
    public final MaterialTextView d;
    public final MaterialTextView e;
    public final ImageView f;

    private HW7(ConstraintLayout constraintLayout, CheckBox checkBox, AvatarViewGlide avatarViewGlide, MaterialTextView materialTextView, MaterialTextView materialTextView2, ImageView imageView) {
        this.a = constraintLayout;
        this.b = checkBox;
        this.c = avatarViewGlide;
        this.d = materialTextView;
        this.e = materialTextView2;
        this.f = imageView;
    }

    public static HW7 a(View view) {
        int i = BC5.checkBox;
        CheckBox checkBox = (CheckBox) AbstractC11738dW7.a(view, i);
        if (checkBox != null) {
            i = BC5.contact_image;
            AvatarViewGlide avatarViewGlide = (AvatarViewGlide) AbstractC11738dW7.a(view, i);
            if (avatarViewGlide != null) {
                i = BC5.contact_last_seen;
                MaterialTextView materialTextView = (MaterialTextView) AbstractC11738dW7.a(view, i);
                if (materialTextView != null) {
                    i = BC5.contact_name;
                    MaterialTextView materialTextView2 = (MaterialTextView) AbstractC11738dW7.a(view, i);
                    if (materialTextView2 != null) {
                        i = BC5.online_circle;
                        ImageView imageView = (ImageView) AbstractC11738dW7.a(view, i);
                        if (imageView != null) {
                            return new HW7((ConstraintLayout) view, checkBox, avatarViewGlide, materialTextView, materialTextView2, imageView);
                        }
                    }
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
