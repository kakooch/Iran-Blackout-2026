package ir.nasim;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import ir.nasim.designsystem.avatar.AvatarViewGlide;

/* renamed from: ir.nasim.xz2, reason: case insensitive filesystem */
/* loaded from: classes7.dex */
public final class C24066xz2 implements InterfaceC9764aW7 {
    private final ConstraintLayout a;
    public final TextView b;
    public final AvatarViewGlide c;
    public final ImageView d;
    public final ImageView e;
    public final AppCompatImageView f;
    public final TextView g;
    public final TextView h;

    private C24066xz2(ConstraintLayout constraintLayout, TextView textView, AvatarViewGlide avatarViewGlide, ImageView imageView, ImageView imageView2, AppCompatImageView appCompatImageView, TextView textView2, TextView textView3) {
        this.a = constraintLayout;
        this.b = textView;
        this.c = avatarViewGlide;
        this.d = imageView;
        this.e = imageView2;
        this.f = appCompatImageView;
        this.g = textView2;
        this.h = textView3;
    }

    public static C24066xz2 a(View view) {
        int i = AbstractC18172oC5.add_story_text;
        TextView textView = (TextView) AbstractC11738dW7.a(view, i);
        if (textView != null) {
            i = AbstractC18172oC5.profile_avatar;
            AvatarViewGlide avatarViewGlide = (AvatarViewGlide) AbstractC11738dW7.a(view, i);
            if (avatarViewGlide != null) {
                i = AbstractC18172oC5.story_alarm;
                ImageView imageView = (ImageView) AbstractC11738dW7.a(view, i);
                if (imageView != null) {
                    i = AbstractC18172oC5.story_badge;
                    ImageView imageView2 = (ImageView) AbstractC11738dW7.a(view, i);
                    if (imageView2 != null) {
                        i = AbstractC18172oC5.story_ring;
                        AppCompatImageView appCompatImageView = (AppCompatImageView) AbstractC11738dW7.a(view, i);
                        if (appCompatImageView != null) {
                            i = AbstractC18172oC5.story_time;
                            TextView textView2 = (TextView) AbstractC11738dW7.a(view, i);
                            if (textView2 != null) {
                                i = AbstractC18172oC5.story_title;
                                TextView textView3 = (TextView) AbstractC11738dW7.a(view, i);
                                if (textView3 != null) {
                                    return new C24066xz2((ConstraintLayout) view, textView, avatarViewGlide, imageView, imageView2, appCompatImageView, textView2, textView3);
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static C24066xz2 c(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(RC5.fragment_story_owner, viewGroup, false);
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
