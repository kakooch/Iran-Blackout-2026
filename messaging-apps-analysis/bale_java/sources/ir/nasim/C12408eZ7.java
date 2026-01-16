package ir.nasim;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import com.google.android.material.button.MaterialButton;
import ir.nasim.designsystem.avatar.AvatarViewGlide;

/* renamed from: ir.nasim.eZ7, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public final class C12408eZ7 implements InterfaceC9764aW7 {
    private final CardView a;
    public final AvatarViewGlide b;
    public final MaterialButton c;
    public final TextView d;
    public final TextView e;

    private C12408eZ7(CardView cardView, AvatarViewGlide avatarViewGlide, MaterialButton materialButton, TextView textView, TextView textView2) {
        this.a = cardView;
        this.b = avatarViewGlide;
        this.c = materialButton;
        this.d = textView;
        this.e = textView2;
    }

    public static C12408eZ7 a(View view) {
        int i = AbstractC12808fC5.vitrine_item_avatar;
        AvatarViewGlide avatarViewGlide = (AvatarViewGlide) AbstractC11738dW7.a(view, i);
        if (avatarViewGlide != null) {
            i = AbstractC12808fC5.vitrine_item_mb;
            MaterialButton materialButton = (MaterialButton) AbstractC11738dW7.a(view, i);
            if (materialButton != null) {
                i = AbstractC12808fC5.vitrine_item_member_tv;
                TextView textView = (TextView) AbstractC11738dW7.a(view, i);
                if (textView != null) {
                    i = AbstractC12808fC5.vitrine_item_title_tv;
                    TextView textView2 = (TextView) AbstractC11738dW7.a(view, i);
                    if (textView2 != null) {
                        return new C12408eZ7((CardView) view, avatarViewGlide, materialButton, textView, textView2);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static C12408eZ7 c(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(HC5.vitrin_item_holder, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // ir.nasim.InterfaceC9764aW7
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public CardView getRoot() {
        return this.a;
    }
}
