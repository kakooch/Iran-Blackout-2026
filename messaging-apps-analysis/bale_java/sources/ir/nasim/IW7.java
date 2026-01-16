package ir.nasim;

import android.view.View;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import ir.nasim.designsystem.avatar.AvatarViewGlide;
import ir.nasim.story.ui.viewfragment.views.ReactionButton;

/* loaded from: classes7.dex */
public final class IW7 implements InterfaceC9764aW7 {
    private final ConstraintLayout a;
    public final AvatarViewGlide b;
    public final ReactionButton c;
    public final AppCompatTextView d;
    public final ConstraintLayout e;
    public final AppCompatTextView f;

    private IW7(ConstraintLayout constraintLayout, AvatarViewGlide avatarViewGlide, ReactionButton reactionButton, AppCompatTextView appCompatTextView, ConstraintLayout constraintLayout2, AppCompatTextView appCompatTextView2) {
        this.a = constraintLayout;
        this.b = avatarViewGlide;
        this.c = reactionButton;
        this.d = appCompatTextView;
        this.e = constraintLayout2;
        this.f = appCompatTextView2;
    }

    public static IW7 a(View view) {
        int i = AbstractC18172oC5.profile_avatar;
        AvatarViewGlide avatarViewGlide = (AvatarViewGlide) AbstractC11738dW7.a(view, i);
        if (avatarViewGlide != null) {
            i = AbstractC18172oC5.story_like_reaction;
            ReactionButton reactionButton = (ReactionButton) AbstractC11738dW7.a(view, i);
            if (reactionButton != null) {
                i = AbstractC18172oC5.story_viewer_title;
                AppCompatTextView appCompatTextView = (AppCompatTextView) AbstractC11738dW7.a(view, i);
                if (appCompatTextView != null) {
                    ConstraintLayout constraintLayout = (ConstraintLayout) view;
                    i = AbstractC18172oC5.view_time;
                    AppCompatTextView appCompatTextView2 = (AppCompatTextView) AbstractC11738dW7.a(view, i);
                    if (appCompatTextView2 != null) {
                        return new IW7(constraintLayout, avatarViewGlide, reactionButton, appCompatTextView, constraintLayout, appCompatTextView2);
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
