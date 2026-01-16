package ir.nasim;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Group;
import androidx.core.widget.NestedScrollView;
import com.airbnb.lottie.LottieAnimationView;
import com.google.android.exoplayer2.ui.PlayerControlView;
import com.google.android.material.button.MaterialButton;
import ir.nasim.components.appbar.view.BaleToolbar;
import ir.nasim.designsystem.avatar.AvatarViewGlide;
import ir.nasim.jaryan.feed.ui.components.FeedEmojiImageView;

/* renamed from: ir.nasim.ci2, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public final class C11258ci2 implements InterfaceC9764aW7 {
    public final AvatarViewGlide A;
    public final AvatarViewGlide B;
    public final AvatarViewGlide C;
    public final TextView D;
    public final LinearLayout E;
    private final ConstraintLayout a;
    public final View b;
    public final PlayerControlView c;
    public final AvatarViewGlide d;
    public final LinearLayout e;
    public final TextView f;
    public final ImageView g;
    public final TextView h;
    public final ImageView i;
    public final TextView j;
    public final TextView k;
    public final MaterialButton l;
    public final FrameLayout m;
    public final ImageView n;
    public final TextView o;
    public final LottieAnimationView p;
    public final TextView q;
    public final FeedEmojiImageView r;
    public final Group s;
    public final ViewStub t;
    public final TextView u;
    public final NestedScrollView v;
    public final BaleToolbar w;
    public final NestedScrollView x;
    public final ViewStub y;
    public final View z;

    private C11258ci2(ConstraintLayout constraintLayout, View view, PlayerControlView playerControlView, AvatarViewGlide avatarViewGlide, LinearLayout linearLayout, TextView textView, ImageView imageView, TextView textView2, ImageView imageView2, TextView textView3, TextView textView4, MaterialButton materialButton, FrameLayout frameLayout, ImageView imageView3, TextView textView5, LottieAnimationView lottieAnimationView, TextView textView6, FeedEmojiImageView feedEmojiImageView, Group group, ViewStub viewStub, TextView textView7, NestedScrollView nestedScrollView, BaleToolbar baleToolbar, NestedScrollView nestedScrollView2, ViewStub viewStub2, View view2, AvatarViewGlide avatarViewGlide2, AvatarViewGlide avatarViewGlide3, AvatarViewGlide avatarViewGlide4, TextView textView8, LinearLayout linearLayout2) {
        this.a = constraintLayout;
        this.b = view;
        this.c = playerControlView;
        this.d = avatarViewGlide;
        this.e = linearLayout;
        this.f = textView;
        this.g = imageView;
        this.h = textView2;
        this.i = imageView2;
        this.j = textView3;
        this.k = textView4;
        this.l = materialButton;
        this.m = frameLayout;
        this.n = imageView3;
        this.o = textView5;
        this.p = lottieAnimationView;
        this.q = textView6;
        this.r = feedEmojiImageView;
        this.s = group;
        this.t = viewStub;
        this.u = textView7;
        this.v = nestedScrollView;
        this.w = baleToolbar;
        this.x = nestedScrollView2;
        this.y = viewStub2;
        this.z = view2;
        this.A = avatarViewGlide2;
        this.B = avatarViewGlide3;
        this.C = avatarViewGlide4;
        this.D = textView8;
        this.E = linearLayout2;
    }

    public static C11258ci2 a(View view) {
        View viewA;
        int i = AbstractC12808fC5.bottom_gradient;
        View viewA2 = AbstractC11738dW7.a(view, i);
        if (viewA2 != null) {
            i = AbstractC12808fC5.exo_controller;
            PlayerControlView playerControlView = (PlayerControlView) AbstractC11738dW7.a(view, i);
            if (playerControlView != null) {
                i = AbstractC12808fC5.feed_avatar;
                AvatarViewGlide avatarViewGlide = (AvatarViewGlide) AbstractC11738dW7.a(view, i);
                if (avatarViewGlide != null) {
                    i = AbstractC12808fC5.feed_bottom_bar;
                    LinearLayout linearLayout = (LinearLayout) AbstractC11738dW7.a(view, i);
                    if (linearLayout != null) {
                        i = AbstractC12808fC5.feed_comment_count;
                        TextView textView = (TextView) AbstractC11738dW7.a(view, i);
                        if (textView != null) {
                            i = AbstractC12808fC5.feed_comment_iv;
                            ImageView imageView = (ImageView) AbstractC11738dW7.a(view, i);
                            if (imageView != null) {
                                i = AbstractC12808fC5.feed_forward_count;
                                TextView textView2 = (TextView) AbstractC11738dW7.a(view, i);
                                if (textView2 != null) {
                                    i = AbstractC12808fC5.feed_forward_iv;
                                    ImageView imageView2 = (ImageView) AbstractC11738dW7.a(view, i);
                                    if (imageView2 != null) {
                                        i = AbstractC12808fC5.feed_group_member;
                                        TextView textView3 = (TextView) AbstractC11738dW7.a(view, i);
                                        if (textView3 != null) {
                                            i = AbstractC12808fC5.feed_group_title;
                                            TextView textView4 = (TextView) AbstractC11738dW7.a(view, i);
                                            if (textView4 != null) {
                                                i = AbstractC12808fC5.feed_join_button;
                                                MaterialButton materialButton = (MaterialButton) AbstractC11738dW7.a(view, i);
                                                if (materialButton != null) {
                                                    i = AbstractC12808fC5.feed_like_animation_container_photo;
                                                    FrameLayout frameLayout = (FrameLayout) AbstractC11738dW7.a(view, i);
                                                    if (frameLayout != null) {
                                                        i = AbstractC12808fC5.feed_option_menu;
                                                        ImageView imageView3 = (ImageView) AbstractC11738dW7.a(view, i);
                                                        if (imageView3 != null) {
                                                            i = AbstractC12808fC5.feed_photo_text;
                                                            TextView textView5 = (TextView) AbstractC11738dW7.a(view, i);
                                                            if (textView5 != null) {
                                                                i = AbstractC12808fC5.feed_reaction_anim;
                                                                LottieAnimationView lottieAnimationView = (LottieAnimationView) AbstractC11738dW7.a(view, i);
                                                                if (lottieAnimationView != null) {
                                                                    i = AbstractC12808fC5.feed_reaction_count;
                                                                    TextView textView6 = (TextView) AbstractC11738dW7.a(view, i);
                                                                    if (textView6 != null) {
                                                                        i = AbstractC12808fC5.feed_reaction_iv;
                                                                        FeedEmojiImageView feedEmojiImageView = (FeedEmojiImageView) AbstractC11738dW7.a(view, i);
                                                                        if (feedEmojiImageView != null) {
                                                                            i = AbstractC12808fC5.feed_title;
                                                                            Group group = (Group) AbstractC11738dW7.a(view, i);
                                                                            if (group != null) {
                                                                                i = AbstractC12808fC5.full_screen_container;
                                                                                ViewStub viewStub = (ViewStub) AbstractC11738dW7.a(view, i);
                                                                                if (viewStub != null) {
                                                                                    i = AbstractC12808fC5.full_screen_text;
                                                                                    TextView textView7 = (TextView) AbstractC11738dW7.a(view, i);
                                                                                    if (textView7 != null) {
                                                                                        i = AbstractC12808fC5.full_screen_text_parent;
                                                                                        NestedScrollView nestedScrollView = (NestedScrollView) AbstractC11738dW7.a(view, i);
                                                                                        if (nestedScrollView != null) {
                                                                                            i = AbstractC12808fC5.full_screen_toolbar;
                                                                                            BaleToolbar baleToolbar = (BaleToolbar) AbstractC11738dW7.a(view, i);
                                                                                            if (baleToolbar != null) {
                                                                                                i = AbstractC12808fC5.nested_scroll_view;
                                                                                                NestedScrollView nestedScrollView2 = (NestedScrollView) AbstractC11738dW7.a(view, i);
                                                                                                if (nestedScrollView2 != null) {
                                                                                                    i = AbstractC12808fC5.shimmer_overlay;
                                                                                                    ViewStub viewStub2 = (ViewStub) AbstractC11738dW7.a(view, i);
                                                                                                    if (viewStub2 != null && (viewA = AbstractC11738dW7.a(view, (i = AbstractC12808fC5.top_gradient))) != null) {
                                                                                                        i = AbstractC12808fC5.up_voters_avatar1;
                                                                                                        AvatarViewGlide avatarViewGlide2 = (AvatarViewGlide) AbstractC11738dW7.a(view, i);
                                                                                                        if (avatarViewGlide2 != null) {
                                                                                                            i = AbstractC12808fC5.up_voters_avatar2;
                                                                                                            AvatarViewGlide avatarViewGlide3 = (AvatarViewGlide) AbstractC11738dW7.a(view, i);
                                                                                                            if (avatarViewGlide3 != null) {
                                                                                                                i = AbstractC12808fC5.up_voters_avatar3;
                                                                                                                AvatarViewGlide avatarViewGlide4 = (AvatarViewGlide) AbstractC11738dW7.a(view, i);
                                                                                                                if (avatarViewGlide4 != null) {
                                                                                                                    i = AbstractC12808fC5.up_voters_title;
                                                                                                                    TextView textView8 = (TextView) AbstractC11738dW7.a(view, i);
                                                                                                                    if (textView8 != null) {
                                                                                                                        i = AbstractC12808fC5.upvoters_bottom_bar;
                                                                                                                        LinearLayout linearLayout2 = (LinearLayout) AbstractC11738dW7.a(view, i);
                                                                                                                        if (linearLayout2 != null) {
                                                                                                                            return new C11258ci2((ConstraintLayout) view, viewA2, playerControlView, avatarViewGlide, linearLayout, textView, imageView, textView2, imageView2, textView3, textView4, materialButton, frameLayout, imageView3, textView5, lottieAnimationView, textView6, feedEmojiImageView, group, viewStub, textView7, nestedScrollView, baleToolbar, nestedScrollView2, viewStub2, viewA, avatarViewGlide2, avatarViewGlide3, avatarViewGlide4, textView8, linearLayout2);
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
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static C11258ci2 c(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(HC5.feed_full_screen_holder, viewGroup, false);
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
