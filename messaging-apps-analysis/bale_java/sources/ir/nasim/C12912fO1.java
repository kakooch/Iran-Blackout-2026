package ir.nasim;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Group;
import ir.nasim.components.text.BoundedSizeTextView;
import ir.nasim.features.story.avatarwithstory.AvatarWithStory;
import ir.nasim.tgwidgets.editor.ui.Components.RLottieImageView;

/* renamed from: ir.nasim.fO1, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C12912fO1 implements InterfaceC9764aW7 {
    public final BoundedSizeTextView A;
    public final ImageView B;
    private final ConstraintLayout a;
    public final ConstraintLayout b;
    public final AvatarWithStory c;
    public final RLottieImageView d;
    public final ImageView e;
    public final BoundedSizeTextView f;
    public final View g;
    public final ConstraintLayout h;
    public final View i;
    public final ImageView j;
    public final ImageView k;
    public final BoundedSizeTextView l;
    public final AppCompatImageView m;
    public final Group n;
    public final View o;
    public final BoundedSizeTextView p;
    public final ConstraintLayout q;
    public final ImageView r;
    public final BoundedSizeTextView s;
    public final AppCompatImageView t;
    public final BoundedSizeTextView u;
    public final AppCompatImageView v;
    public final ViewStub w;
    public final ConstraintLayout x;
    public final BoundedSizeTextView y;
    public final ConstraintLayout z;

    private C12912fO1(ConstraintLayout constraintLayout, ConstraintLayout constraintLayout2, AvatarWithStory avatarWithStory, RLottieImageView rLottieImageView, ImageView imageView, BoundedSizeTextView boundedSizeTextView, View view, ConstraintLayout constraintLayout3, View view2, ImageView imageView2, ImageView imageView3, BoundedSizeTextView boundedSizeTextView2, AppCompatImageView appCompatImageView, Group group, View view3, BoundedSizeTextView boundedSizeTextView3, ConstraintLayout constraintLayout4, ImageView imageView4, BoundedSizeTextView boundedSizeTextView4, AppCompatImageView appCompatImageView2, BoundedSizeTextView boundedSizeTextView5, AppCompatImageView appCompatImageView3, ViewStub viewStub, ConstraintLayout constraintLayout5, BoundedSizeTextView boundedSizeTextView6, ConstraintLayout constraintLayout6, BoundedSizeTextView boundedSizeTextView7, ImageView imageView5) {
        this.a = constraintLayout;
        this.b = constraintLayout2;
        this.c = avatarWithStory;
        this.d = rLottieImageView;
        this.e = imageView;
        this.f = boundedSizeTextView;
        this.g = view;
        this.h = constraintLayout3;
        this.i = view2;
        this.j = imageView2;
        this.k = imageView3;
        this.l = boundedSizeTextView2;
        this.m = appCompatImageView;
        this.n = group;
        this.o = view3;
        this.p = boundedSizeTextView3;
        this.q = constraintLayout4;
        this.r = imageView4;
        this.s = boundedSizeTextView4;
        this.t = appCompatImageView2;
        this.u = boundedSizeTextView5;
        this.v = appCompatImageView3;
        this.w = viewStub;
        this.x = constraintLayout5;
        this.y = boundedSizeTextView6;
        this.z = constraintLayout6;
        this.A = boundedSizeTextView7;
        this.B = imageView5;
    }

    public static C12912fO1 a(View view) {
        View viewA;
        View viewA2;
        int i = AbstractC10792cC5.avatar_box;
        ConstraintLayout constraintLayout = (ConstraintLayout) AbstractC11738dW7.a(view, i);
        if (constraintLayout != null) {
            i = AbstractC10792cC5.avatar_image;
            AvatarWithStory avatarWithStory = (AvatarWithStory) AbstractC11738dW7.a(view, i);
            if (avatarWithStory != null) {
                i = AbstractC10792cC5.badgeIcon;
                RLottieImageView rLottieImageView = (RLottieImageView) AbstractC11738dW7.a(view, i);
                if (rLottieImageView != null) {
                    i = AbstractC10792cC5.blueTick;
                    ImageView imageView = (ImageView) AbstractC11738dW7.a(view, i);
                    if (imageView != null) {
                        i = AbstractC10792cC5.date;
                        BoundedSizeTextView boundedSizeTextView = (BoundedSizeTextView) AbstractC11738dW7.a(view, i);
                        if (boundedSizeTextView != null && (viewA = AbstractC11738dW7.a(view, (i = AbstractC10792cC5.dialog_divider))) != null) {
                            ConstraintLayout constraintLayout2 = (ConstraintLayout) view;
                            i = AbstractC10792cC5.endDivider;
                            View viewA3 = AbstractC11738dW7.a(view, i);
                            if (viewA3 != null) {
                                i = AbstractC10792cC5.forwardIcon;
                                ImageView imageView2 = (ImageView) AbstractC11738dW7.a(view, i);
                                if (imageView2 != null) {
                                    i = AbstractC10792cC5.imgTick;
                                    ImageView imageView3 = (ImageView) AbstractC11738dW7.a(view, i);
                                    if (imageView3 != null) {
                                        i = AbstractC10792cC5.last_message_text;
                                        BoundedSizeTextView boundedSizeTextView2 = (BoundedSizeTextView) AbstractC11738dW7.a(view, i);
                                        if (boundedSizeTextView2 != null) {
                                            i = AbstractC10792cC5.last_reaction_emoji;
                                            AppCompatImageView appCompatImageView = (AppCompatImageView) AbstractC11738dW7.a(view, i);
                                            if (appCompatImageView != null) {
                                                i = AbstractC10792cC5.main_content;
                                                Group group = (Group) AbstractC11738dW7.a(view, i);
                                                if (group != null && (viewA2 = AbstractC11738dW7.a(view, (i = AbstractC10792cC5.mark_as_unread_icon))) != null) {
                                                    i = AbstractC10792cC5.mention_icon;
                                                    BoundedSizeTextView boundedSizeTextView3 = (BoundedSizeTextView) AbstractC11738dW7.a(view, i);
                                                    if (boundedSizeTextView3 != null) {
                                                        i = AbstractC10792cC5.messageContainer;
                                                        ConstraintLayout constraintLayout3 = (ConstraintLayout) AbstractC11738dW7.a(view, i);
                                                        if (constraintLayout3 != null) {
                                                            i = AbstractC10792cC5.mutedIcon;
                                                            ImageView imageView4 = (ImageView) AbstractC11738dW7.a(view, i);
                                                            if (imageView4 != null) {
                                                                i = AbstractC10792cC5.open_web_app_btn;
                                                                BoundedSizeTextView boundedSizeTextView4 = (BoundedSizeTextView) AbstractC11738dW7.a(view, i);
                                                                if (boundedSizeTextView4 != null) {
                                                                    i = AbstractC10792cC5.pin_icon;
                                                                    AppCompatImageView appCompatImageView2 = (AppCompatImageView) AbstractC11738dW7.a(view, i);
                                                                    if (appCompatImageView2 != null) {
                                                                        i = AbstractC10792cC5.senderName;
                                                                        BoundedSizeTextView boundedSizeTextView5 = (BoundedSizeTextView) AbstractC11738dW7.a(view, i);
                                                                        if (boundedSizeTextView5 != null) {
                                                                            i = AbstractC10792cC5.sent_state;
                                                                            AppCompatImageView appCompatImageView3 = (AppCompatImageView) AbstractC11738dW7.a(view, i);
                                                                            if (appCompatImageView3 != null) {
                                                                                i = AbstractC10792cC5.shimmer;
                                                                                ViewStub viewStub = (ViewStub) AbstractC11738dW7.a(view, i);
                                                                                if (viewStub != null) {
                                                                                    i = AbstractC10792cC5.side_bar_container;
                                                                                    ConstraintLayout constraintLayout4 = (ConstraintLayout) AbstractC11738dW7.a(view, i);
                                                                                    if (constraintLayout4 != null) {
                                                                                        i = AbstractC10792cC5.unread_badge_count;
                                                                                        BoundedSizeTextView boundedSizeTextView6 = (BoundedSizeTextView) AbstractC11738dW7.a(view, i);
                                                                                        if (boundedSizeTextView6 != null) {
                                                                                            i = AbstractC10792cC5.userNameContainer;
                                                                                            ConstraintLayout constraintLayout5 = (ConstraintLayout) AbstractC11738dW7.a(view, i);
                                                                                            if (constraintLayout5 != null) {
                                                                                                i = AbstractC10792cC5.userNameText;
                                                                                                BoundedSizeTextView boundedSizeTextView7 = (BoundedSizeTextView) AbstractC11738dW7.a(view, i);
                                                                                                if (boundedSizeTextView7 != null) {
                                                                                                    i = AbstractC10792cC5.userTypeIcon;
                                                                                                    ImageView imageView5 = (ImageView) AbstractC11738dW7.a(view, i);
                                                                                                    if (imageView5 != null) {
                                                                                                        return new C12912fO1(constraintLayout2, constraintLayout, avatarWithStory, rLottieImageView, imageView, boundedSizeTextView, viewA, constraintLayout2, viewA3, imageView2, imageView3, boundedSizeTextView2, appCompatImageView, group, viewA2, boundedSizeTextView3, constraintLayout3, imageView4, boundedSizeTextView4, appCompatImageView2, boundedSizeTextView5, appCompatImageView3, viewStub, constraintLayout4, boundedSizeTextView6, constraintLayout5, boundedSizeTextView7, imageView5);
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

    public static C12912fO1 c(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(AbstractC11565dD5.dialog_list_item, viewGroup, false);
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
