package ir.nasim;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.Barrier;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Group;
import com.google.android.material.button.MaterialButton;
import ir.nasim.designsystem.avatar.AvatarViewGlide;
import ir.nasim.jaryan.feed.ui.components.FeedEmojiImageView;

/* renamed from: ir.nasim.cj2, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public final class C11268cj2 implements InterfaceC9764aW7 {
    public final AvatarViewGlide A;
    public final AvatarViewGlide B;
    public final AvatarViewGlide C;
    public final View D;
    public final TextView E;
    private final ConstraintLayout a;
    public final FrameLayout b;
    public final AvatarViewGlide c;
    public final TextView d;
    public final TextView e;
    public final ImageView f;
    public final ViewStub g;
    public final TextView h;
    public final Barrier i;
    public final Barrier j;
    public final Group k;
    public final TextView l;
    public final ImageView m;
    public final TextView n;
    public final TextView o;
    public final Barrier p;
    public final MaterialButton q;
    public final ImageView r;
    public final Group s;
    public final TextView t;
    public final FeedEmojiImageView u;
    public final TextView v;
    public final TextView w;
    public final Group x;
    public final Group y;
    public final View z;

    private C11268cj2(ConstraintLayout constraintLayout, FrameLayout frameLayout, AvatarViewGlide avatarViewGlide, TextView textView, TextView textView2, ImageView imageView, ViewStub viewStub, TextView textView3, Barrier barrier, Barrier barrier2, Group group, TextView textView4, ImageView imageView2, TextView textView5, TextView textView6, Barrier barrier3, MaterialButton materialButton, ImageView imageView3, Group group2, TextView textView7, FeedEmojiImageView feedEmojiImageView, TextView textView8, TextView textView9, Group group3, Group group4, View view, AvatarViewGlide avatarViewGlide2, AvatarViewGlide avatarViewGlide3, AvatarViewGlide avatarViewGlide4, View view2, TextView textView10) {
        this.a = constraintLayout;
        this.b = frameLayout;
        this.c = avatarViewGlide;
        this.d = textView;
        this.e = textView2;
        this.f = imageView;
        this.g = viewStub;
        this.h = textView3;
        this.i = barrier;
        this.j = barrier2;
        this.k = group;
        this.l = textView4;
        this.m = imageView2;
        this.n = textView5;
        this.o = textView6;
        this.p = barrier3;
        this.q = materialButton;
        this.r = imageView3;
        this.s = group2;
        this.t = textView7;
        this.u = feedEmojiImageView;
        this.v = textView8;
        this.w = textView9;
        this.x = group3;
        this.y = group4;
        this.z = view;
        this.A = avatarViewGlide2;
        this.B = avatarViewGlide3;
        this.C = avatarViewGlide4;
        this.D = view2;
        this.E = textView10;
    }

    public static C11268cj2 a(View view) {
        View viewA;
        View viewA2;
        int i = AbstractC12808fC5.bs;
        FrameLayout frameLayout = (FrameLayout) AbstractC11738dW7.a(view, i);
        if (frameLayout != null) {
            i = AbstractC12808fC5.feed_avatar;
            AvatarViewGlide avatarViewGlide = (AvatarViewGlide) AbstractC11738dW7.a(view, i);
            if (avatarViewGlide != null) {
                i = AbstractC12808fC5.feed_caption;
                TextView textView = (TextView) AbstractC11738dW7.a(view, i);
                if (textView != null) {
                    i = AbstractC12808fC5.feed_comment_count;
                    TextView textView2 = (TextView) AbstractC11738dW7.a(view, i);
                    if (textView2 != null) {
                        i = AbstractC12808fC5.feed_comment_iv;
                        ImageView imageView = (ImageView) AbstractC11738dW7.a(view, i);
                        if (imageView != null) {
                            i = AbstractC12808fC5.feed_container_vs;
                            ViewStub viewStub = (ViewStub) AbstractC11738dW7.a(view, i);
                            if (viewStub != null) {
                                i = AbstractC12808fC5.feed_date_state_view;
                                TextView textView3 = (TextView) AbstractC11738dW7.a(view, i);
                                if (textView3 != null) {
                                    i = AbstractC12808fC5.feed_footer_barrier;
                                    Barrier barrier = (Barrier) AbstractC11738dW7.a(view, i);
                                    if (barrier != null) {
                                        i = AbstractC12808fC5.feed_footer_barrier_bot;
                                        Barrier barrier2 = (Barrier) AbstractC11738dW7.a(view, i);
                                        if (barrier2 != null) {
                                            i = AbstractC12808fC5.feed_forward;
                                            Group group = (Group) AbstractC11738dW7.a(view, i);
                                            if (group != null) {
                                                i = AbstractC12808fC5.feed_forward_count;
                                                TextView textView4 = (TextView) AbstractC11738dW7.a(view, i);
                                                if (textView4 != null) {
                                                    i = AbstractC12808fC5.feed_forward_iv;
                                                    ImageView imageView2 = (ImageView) AbstractC11738dW7.a(view, i);
                                                    if (imageView2 != null) {
                                                        i = AbstractC12808fC5.feed_group_member;
                                                        TextView textView5 = (TextView) AbstractC11738dW7.a(view, i);
                                                        if (textView5 != null) {
                                                            i = AbstractC12808fC5.feed_group_title;
                                                            TextView textView6 = (TextView) AbstractC11738dW7.a(view, i);
                                                            if (textView6 != null) {
                                                                i = AbstractC12808fC5.feed_header_barrier;
                                                                Barrier barrier3 = (Barrier) AbstractC11738dW7.a(view, i);
                                                                if (barrier3 != null) {
                                                                    i = AbstractC12808fC5.feed_join_button;
                                                                    MaterialButton materialButton = (MaterialButton) AbstractC11738dW7.a(view, i);
                                                                    if (materialButton != null) {
                                                                        i = AbstractC12808fC5.feed_option_menu;
                                                                        ImageView imageView3 = (ImageView) AbstractC11738dW7.a(view, i);
                                                                        if (imageView3 != null) {
                                                                            i = AbstractC12808fC5.feed_reaction;
                                                                            Group group2 = (Group) AbstractC11738dW7.a(view, i);
                                                                            if (group2 != null) {
                                                                                i = AbstractC12808fC5.feed_reaction_count;
                                                                                TextView textView7 = (TextView) AbstractC11738dW7.a(view, i);
                                                                                if (textView7 != null) {
                                                                                    i = AbstractC12808fC5.feed_reaction_iv;
                                                                                    FeedEmojiImageView feedEmojiImageView = (FeedEmojiImageView) AbstractC11738dW7.a(view, i);
                                                                                    if (feedEmojiImageView != null) {
                                                                                        i = AbstractC12808fC5.feed_state_view;
                                                                                        TextView textView8 = (TextView) AbstractC11738dW7.a(view, i);
                                                                                        if (textView8 != null) {
                                                                                            i = AbstractC12808fC5.feed_tag_state_view;
                                                                                            TextView textView9 = (TextView) AbstractC11738dW7.a(view, i);
                                                                                            if (textView9 != null) {
                                                                                                i = AbstractC12808fC5.feed_title;
                                                                                                Group group3 = (Group) AbstractC11738dW7.a(view, i);
                                                                                                if (group3 != null) {
                                                                                                    i = AbstractC12808fC5.feed_up_voters;
                                                                                                    Group group4 = (Group) AbstractC11738dW7.a(view, i);
                                                                                                    if (group4 != null && (viewA = AbstractC11738dW7.a(view, (i = AbstractC12808fC5.footer_divider))) != null) {
                                                                                                        i = AbstractC12808fC5.up_voters_avatar1;
                                                                                                        AvatarViewGlide avatarViewGlide2 = (AvatarViewGlide) AbstractC11738dW7.a(view, i);
                                                                                                        if (avatarViewGlide2 != null) {
                                                                                                            i = AbstractC12808fC5.up_voters_avatar2;
                                                                                                            AvatarViewGlide avatarViewGlide3 = (AvatarViewGlide) AbstractC11738dW7.a(view, i);
                                                                                                            if (avatarViewGlide3 != null) {
                                                                                                                i = AbstractC12808fC5.up_voters_avatar3;
                                                                                                                AvatarViewGlide avatarViewGlide4 = (AvatarViewGlide) AbstractC11738dW7.a(view, i);
                                                                                                                if (avatarViewGlide4 != null && (viewA2 = AbstractC11738dW7.a(view, (i = AbstractC12808fC5.up_voters_divider))) != null) {
                                                                                                                    i = AbstractC12808fC5.up_voters_title;
                                                                                                                    TextView textView10 = (TextView) AbstractC11738dW7.a(view, i);
                                                                                                                    if (textView10 != null) {
                                                                                                                        return new C11268cj2((ConstraintLayout) view, frameLayout, avatarViewGlide, textView, textView2, imageView, viewStub, textView3, barrier, barrier2, group, textView4, imageView2, textView5, textView6, barrier3, materialButton, imageView3, group2, textView7, feedEmojiImageView, textView8, textView9, group3, group4, viewA, avatarViewGlide2, avatarViewGlide3, avatarViewGlide4, viewA2, textView10);
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

    public static C11268cj2 c(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(HC5.feed_holder, viewGroup, false);
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
