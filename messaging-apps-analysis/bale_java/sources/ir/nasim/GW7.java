package ir.nasim;

import android.view.View;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.airbnb.lottie.LottieAnimationView;
import ir.nasim.designsystem.avatar.AvatarViewGlide;
import ir.nasim.story.ui.widget.PlusImage;

/* loaded from: classes7.dex */
public final class GW7 implements InterfaceC9764aW7 {
    private final ConstraintLayout a;
    public final PlusImage b;
    public final View c;
    public final ConstraintLayout d;
    public final AvatarViewGlide e;
    public final AppCompatImageView f;
    public final AppCompatImageView g;
    public final AppCompatTextView h;
    public final AppCompatImageView i;
    public final AppCompatImageView j;
    public final LottieAnimationView k;
    public final AppCompatImageView l;

    private GW7(ConstraintLayout constraintLayout, PlusImage plusImage, View view, ConstraintLayout constraintLayout2, AvatarViewGlide avatarViewGlide, AppCompatImageView appCompatImageView, AppCompatImageView appCompatImageView2, AppCompatTextView appCompatTextView, AppCompatImageView appCompatImageView3, AppCompatImageView appCompatImageView4, LottieAnimationView lottieAnimationView, AppCompatImageView appCompatImageView5) {
        this.a = constraintLayout;
        this.b = plusImage;
        this.c = view;
        this.d = constraintLayout2;
        this.e = avatarViewGlide;
        this.f = appCompatImageView;
        this.g = appCompatImageView2;
        this.h = appCompatTextView;
        this.i = appCompatImageView3;
        this.j = appCompatImageView4;
        this.k = lottieAnimationView;
        this.l = appCompatImageView5;
    }

    public static GW7 a(View view) {
        View viewA;
        int i = AbstractC18172oC5.addStory;
        PlusImage plusImage = (PlusImage) AbstractC11738dW7.a(view, i);
        if (plusImage != null && (viewA = AbstractC11738dW7.a(view, (i = AbstractC18172oC5.layoutClickable))) != null) {
            ConstraintLayout constraintLayout = (ConstraintLayout) view;
            i = AbstractC18172oC5.profile_avatar;
            AvatarViewGlide avatarViewGlide = (AvatarViewGlide) AbstractC11738dW7.a(view, i);
            if (avatarViewGlide != null) {
                i = AbstractC18172oC5.storyBadge;
                AppCompatImageView appCompatImageView = (AppCompatImageView) AbstractC11738dW7.a(view, i);
                if (appCompatImageView != null) {
                    i = AbstractC18172oC5.story_ring;
                    AppCompatImageView appCompatImageView2 = (AppCompatImageView) AbstractC11738dW7.a(view, i);
                    if (appCompatImageView2 != null) {
                        i = AbstractC18172oC5.storyTitle;
                        AppCompatTextView appCompatTextView = (AppCompatTextView) AbstractC11738dW7.a(view, i);
                        if (appCompatTextView != null) {
                            i = AbstractC18172oC5.text_story_badge;
                            AppCompatImageView appCompatImageView3 = (AppCompatImageView) AbstractC11738dW7.a(view, i);
                            if (appCompatImageView3 != null) {
                                i = AbstractC18172oC5.text_story_badge_background;
                                AppCompatImageView appCompatImageView4 = (AppCompatImageView) AbstractC11738dW7.a(view, i);
                                if (appCompatImageView4 != null) {
                                    i = AbstractC18172oC5.uploading_animation;
                                    LottieAnimationView lottieAnimationView = (LottieAnimationView) AbstractC11738dW7.a(view, i);
                                    if (lottieAnimationView != null) {
                                        i = AbstractC18172oC5.verified;
                                        AppCompatImageView appCompatImageView5 = (AppCompatImageView) AbstractC11738dW7.a(view, i);
                                        if (appCompatImageView5 != null) {
                                            return new GW7(constraintLayout, plusImage, viewA, constraintLayout, avatarViewGlide, appCompatImageView, appCompatImageView2, appCompatTextView, appCompatImageView3, appCompatImageView4, lottieAnimationView, appCompatImageView5);
                                        }
                                    }
                                }
                            }
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
