package ir.nasim;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.google.android.material.textview.MaterialTextView;
import ir.nasim.designsystem.avatar.AvatarViewGlide;

/* renamed from: ir.nasim.lw0, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C16830lw0 implements InterfaceC9764aW7 {
    private final ConstraintLayout a;
    public final MaterialTextView b;
    public final ImageView c;
    public final CheckBox d;
    public final AvatarViewGlide e;
    public final C4241Eh1 f;
    public final MaterialTextView g;
    public final ConstraintLayout h;
    public final ImageButton i;

    private C16830lw0(ConstraintLayout constraintLayout, MaterialTextView materialTextView, ImageView imageView, CheckBox checkBox, AvatarViewGlide avatarViewGlide, C4241Eh1 c4241Eh1, MaterialTextView materialTextView2, ConstraintLayout constraintLayout2, ImageButton imageButton) {
        this.a = constraintLayout;
        this.b = materialTextView;
        this.c = imageView;
        this.d = checkBox;
        this.e = avatarViewGlide;
        this.f = c4241Eh1;
        this.g = materialTextView2;
        this.h = constraintLayout2;
        this.i = imageButton;
    }

    public static C16830lw0 a(View view) {
        View viewA;
        int i = YB5.call_log_info;
        MaterialTextView materialTextView = (MaterialTextView) AbstractC11738dW7.a(view, i);
        if (materialTextView != null) {
            i = YB5.call_log_status;
            ImageView imageView = (ImageView) AbstractC11738dW7.a(view, i);
            if (imageView != null) {
                i = YB5.check;
                CheckBox checkBox = (CheckBox) AbstractC11738dW7.a(view, i);
                if (checkBox != null) {
                    i = YB5.image;
                    AvatarViewGlide avatarViewGlide = (AvatarViewGlide) AbstractC11738dW7.a(view, i);
                    if (avatarViewGlide != null && (viewA = AbstractC11738dW7.a(view, (i = YB5.line))) != null) {
                        C4241Eh1 c4241Eh1A = C4241Eh1.a(viewA);
                        i = YB5.name;
                        MaterialTextView materialTextView2 = (MaterialTextView) AbstractC11738dW7.a(view, i);
                        if (materialTextView2 != null) {
                            ConstraintLayout constraintLayout = (ConstraintLayout) view;
                            i = YB5.start_call;
                            ImageButton imageButton = (ImageButton) AbstractC11738dW7.a(view, i);
                            if (imageButton != null) {
                                return new C16830lw0(constraintLayout, materialTextView, imageView, checkBox, avatarViewGlide, c4241Eh1A, materialTextView2, constraintLayout, imageButton);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static C16830lw0 c(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(AbstractC9591aD5.call_log_item, viewGroup, false);
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
