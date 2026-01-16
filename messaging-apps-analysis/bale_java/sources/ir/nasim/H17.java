package ir.nasim;

import android.view.View;
import android.widget.ImageView;
import androidx.cardview.widget.CardView;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textview.MaterialTextView;
import ir.nasim.designsystem.avatar.AvatarViewGlide;

/* loaded from: classes5.dex */
public final class H17 implements InterfaceC9764aW7 {
    private final CardView a;
    public final MaterialButton b;
    public final ImageView c;
    public final AvatarViewGlide d;
    public final MaterialTextView e;
    public final MaterialTextView f;

    private H17(CardView cardView, MaterialButton materialButton, ImageView imageView, AvatarViewGlide avatarViewGlide, MaterialTextView materialTextView, MaterialTextView materialTextView2) {
        this.a = cardView;
        this.b = materialButton;
        this.c = imageView;
        this.d = avatarViewGlide;
        this.e = materialTextView;
        this.f = materialTextView2;
    }

    public static H17 a(View view) {
        int i = BC5.btn_join;
        MaterialButton materialButton = (MaterialButton) AbstractC11738dW7.a(view, i);
        if (materialButton != null) {
            i = BC5.channel_blue_tick;
            ImageView imageView = (ImageView) AbstractC11738dW7.a(view, i);
            if (imageView != null) {
                i = BC5.channel_item_avatar;
                AvatarViewGlide avatarViewGlide = (AvatarViewGlide) AbstractC11738dW7.a(view, i);
                if (avatarViewGlide != null) {
                    i = BC5.channel_item_member_tv;
                    MaterialTextView materialTextView = (MaterialTextView) AbstractC11738dW7.a(view, i);
                    if (materialTextView != null) {
                        i = BC5.channel_item_title_tv;
                        MaterialTextView materialTextView2 = (MaterialTextView) AbstractC11738dW7.a(view, i);
                        if (materialTextView2 != null) {
                            return new H17((CardView) view, materialButton, imageView, avatarViewGlide, materialTextView, materialTextView2);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    @Override // ir.nasim.InterfaceC9764aW7
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public CardView getRoot() {
        return this.a;
    }
}
