package ir.nasim;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.google.android.material.textview.MaterialTextView;
import ir.nasim.designsystem.avatar.AvatarViewGlide;

/* renamed from: ir.nasim.uf3, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C22095uf3 implements InterfaceC9764aW7 {
    private final ConstraintLayout a;
    public final CheckBox b;
    public final AvatarViewGlide c;
    public final MaterialTextView d;
    public final MaterialTextView e;
    public final C4241Eh1 f;

    private C22095uf3(ConstraintLayout constraintLayout, CheckBox checkBox, AvatarViewGlide avatarViewGlide, MaterialTextView materialTextView, MaterialTextView materialTextView2, C4241Eh1 c4241Eh1) {
        this.a = constraintLayout;
        this.b = checkBox;
        this.c = avatarViewGlide;
        this.d = materialTextView;
        this.e = materialTextView2;
        this.f = c4241Eh1;
    }

    public static C22095uf3 a(View view) {
        View viewA;
        int i = BC5.check;
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
                    if (materialTextView2 != null && (viewA = AbstractC11738dW7.a(view, (i = BC5.divider))) != null) {
                        return new C22095uf3((ConstraintLayout) view, checkBox, avatarViewGlide, materialTextView, materialTextView2, C4241Eh1.a(viewA));
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static C22095uf3 c(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(AbstractC12208eD5.item_invite_contact, viewGroup, false);
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
