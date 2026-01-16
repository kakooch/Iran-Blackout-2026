package ir.nasim;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.viewpager2.widget.ViewPager2;
import com.airbnb.lottie.LottieAnimationView;
import com.genius.multiprogressbar.MultiProgressBar;
import ir.nasim.features.conversation.messages.content.CircleProgressBar;
import ir.nasim.story.ui.viewfragment.reaction.ReactionHandler;
import ir.nasim.story.ui.viewfragment.views.TopBarStoryView;
import ir.nasim.story.ui.viewfragment.views.footer.FooterStoryView;
import ir.nasim.tgwidgets.editor.ui.stories.bale.views.StoryLinkCustomView;

/* renamed from: ir.nasim.Bz2, reason: case insensitive filesystem */
/* loaded from: classes7.dex */
public final class C3702Bz2 implements InterfaceC9764aW7 {
    private final CoordinatorLayout a;
    public final Guideline b;
    public final ConstraintLayout c;
    public final FooterStoryView d;
    public final CoordinatorLayout e;
    public final Guideline f;
    public final Guideline g;
    public final View h;
    public final View i;
    public final View j;
    public final LottieAnimationView k;
    public final MultiProgressBar l;
    public final CircleProgressBar m;
    public final FrameLayout n;
    public final ReactionHandler o;
    public final View p;
    public final StoryLinkCustomView q;
    public final View r;
    public final View s;
    public final TopBarStoryView t;
    public final ViewPager2 u;

    private C3702Bz2(CoordinatorLayout coordinatorLayout, Guideline guideline, ConstraintLayout constraintLayout, FooterStoryView footerStoryView, CoordinatorLayout coordinatorLayout2, Guideline guideline2, Guideline guideline3, View view, View view2, View view3, LottieAnimationView lottieAnimationView, MultiProgressBar multiProgressBar, CircleProgressBar circleProgressBar, FrameLayout frameLayout, ReactionHandler reactionHandler, View view4, StoryLinkCustomView storyLinkCustomView, View view5, View view6, TopBarStoryView topBarStoryView, ViewPager2 viewPager2) {
        this.a = coordinatorLayout;
        this.b = guideline;
        this.c = constraintLayout;
        this.d = footerStoryView;
        this.e = coordinatorLayout2;
        this.f = guideline2;
        this.g = guideline3;
        this.h = view;
        this.i = view2;
        this.j = view3;
        this.k = lottieAnimationView;
        this.l = multiProgressBar;
        this.m = circleProgressBar;
        this.n = frameLayout;
        this.o = reactionHandler;
        this.p = view4;
        this.q = storyLinkCustomView;
        this.r = view5;
        this.s = view6;
        this.t = topBarStoryView;
        this.u = viewPager2;
    }

    public static C3702Bz2 a(View view) {
        View viewA;
        View viewA2;
        View viewA3;
        View viewA4;
        View viewA5;
        View viewA6;
        int i = AbstractC18172oC5.bottomRoofGuideline;
        Guideline guideline = (Guideline) AbstractC11738dW7.a(view, i);
        if (guideline != null) {
            i = AbstractC18172oC5.clRoot;
            ConstraintLayout constraintLayout = (ConstraintLayout) AbstractC11738dW7.a(view, i);
            if (constraintLayout != null) {
                i = AbstractC18172oC5.footerStoryView;
                FooterStoryView footerStoryView = (FooterStoryView) AbstractC11738dW7.a(view, i);
                if (footerStoryView != null) {
                    CoordinatorLayout coordinatorLayout = (CoordinatorLayout) view;
                    i = AbstractC18172oC5.guideline1;
                    Guideline guideline2 = (Guideline) AbstractC11738dW7.a(view, i);
                    if (guideline2 != null) {
                        i = AbstractC18172oC5.guideline2;
                        Guideline guideline3 = (Guideline) AbstractC11738dW7.a(view, i);
                        if (guideline3 != null && (viewA = AbstractC11738dW7.a(view, (i = AbstractC18172oC5.layoutCenter))) != null && (viewA2 = AbstractC11738dW7.a(view, (i = AbstractC18172oC5.layoutEnd))) != null && (viewA3 = AbstractC11738dW7.a(view, (i = AbstractC18172oC5.layoutStart))) != null) {
                            i = AbstractC18172oC5.lottieLikeReact;
                            LottieAnimationView lottieAnimationView = (LottieAnimationView) AbstractC11738dW7.a(view, i);
                            if (lottieAnimationView != null) {
                                i = AbstractC18172oC5.multi_progress_bar;
                                MultiProgressBar multiProgressBar = (MultiProgressBar) AbstractC11738dW7.a(view, i);
                                if (multiProgressBar != null) {
                                    i = AbstractC18172oC5.progressView;
                                    CircleProgressBar circleProgressBar = (CircleProgressBar) AbstractC11738dW7.a(view, i);
                                    if (circleProgressBar != null) {
                                        i = AbstractC18172oC5.progressViewLayout;
                                        FrameLayout frameLayout = (FrameLayout) AbstractC11738dW7.a(view, i);
                                        if (frameLayout != null) {
                                            i = AbstractC18172oC5.reactionHandlerStory;
                                            ReactionHandler reactionHandler = (ReactionHandler) AbstractC11738dW7.a(view, i);
                                            if (reactionHandler != null && (viewA4 = AbstractC11738dW7.a(view, (i = AbstractC18172oC5.reactionTooltipAnchor))) != null) {
                                                i = AbstractC18172oC5.storyLinkLayout;
                                                StoryLinkCustomView storyLinkCustomView = (StoryLinkCustomView) AbstractC11738dW7.a(view, i);
                                                if (storyLinkCustomView != null && (viewA5 = AbstractC11738dW7.a(view, (i = AbstractC18172oC5.story_view_gradient))) != null && (viewA6 = AbstractC11738dW7.a(view, (i = AbstractC18172oC5.tooltipAnchorView))) != null) {
                                                    i = AbstractC18172oC5.topBarStoryView;
                                                    TopBarStoryView topBarStoryView = (TopBarStoryView) AbstractC11738dW7.a(view, i);
                                                    if (topBarStoryView != null) {
                                                        i = AbstractC18172oC5.viewPager;
                                                        ViewPager2 viewPager2 = (ViewPager2) AbstractC11738dW7.a(view, i);
                                                        if (viewPager2 != null) {
                                                            return new C3702Bz2(coordinatorLayout, guideline, constraintLayout, footerStoryView, coordinatorLayout, guideline2, guideline3, viewA, viewA2, viewA3, lottieAnimationView, multiProgressBar, circleProgressBar, frameLayout, reactionHandler, viewA4, storyLinkCustomView, viewA5, viewA6, topBarStoryView, viewPager2);
                                                        }
                                                    }
                                                }
                                            }
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

    public static C3702Bz2 c(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(RC5.fragment_story_view, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // ir.nasim.InterfaceC9764aW7
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public CoordinatorLayout getRoot() {
        return this.a;
    }
}
