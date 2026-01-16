package ir.nasim;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textview.MaterialTextView;
import ir.nasim.designsystem.avatar.AvatarViewGlide;

/* renamed from: ir.nasim.q76, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C19307q76 implements InterfaceC9764aW7 {
    private final ConstraintLayout a;
    public final MaterialTextView b;
    public final AvatarViewGlide c;
    public final MaterialButton d;
    public final C4241Eh1 e;
    public final MaterialTextView f;
    public final ConstraintLayout g;

    private C19307q76(ConstraintLayout constraintLayout, MaterialTextView materialTextView, AvatarViewGlide avatarViewGlide, MaterialButton materialButton, C4241Eh1 c4241Eh1, MaterialTextView materialTextView2, ConstraintLayout constraintLayout2) {
        this.a = constraintLayout;
        this.b = materialTextView;
        this.c = avatarViewGlide;
        this.d = materialButton;
        this.e = c4241Eh1;
        this.f = materialTextView2;
        this.g = constraintLayout2;
    }

    public static C19307q76 a(View view) {
        View viewA;
        int i = YB5.description;
        MaterialTextView materialTextView = (MaterialTextView) AbstractC11738dW7.a(view, i);
        if (materialTextView != null) {
            i = YB5.image;
            AvatarViewGlide avatarViewGlide = (AvatarViewGlide) AbstractC11738dW7.a(view, i);
            if (avatarViewGlide != null) {
                i = YB5.join_call;
                MaterialButton materialButton = (MaterialButton) AbstractC11738dW7.a(view, i);
                if (materialButton != null && (viewA = AbstractC11738dW7.a(view, (i = YB5.line))) != null) {
                    C4241Eh1 c4241Eh1A = C4241Eh1.a(viewA);
                    i = YB5.name;
                    MaterialTextView materialTextView2 = (MaterialTextView) AbstractC11738dW7.a(view, i);
                    if (materialTextView2 != null) {
                        ConstraintLayout constraintLayout = (ConstraintLayout) view;
                        return new C19307q76(constraintLayout, materialTextView, avatarViewGlide, materialButton, c4241Eh1A, materialTextView2, constraintLayout);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static C19307q76 c(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(AbstractC9591aD5.running_call_item, viewGroup, false);
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
