package ir.nasim;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import com.google.android.material.button.MaterialButton;
import ir.nasim.designsystem.avatar.AvatarViewGlide;

/* renamed from: ir.nasim.Qu3, reason: case insensitive filesystem */
/* loaded from: classes7.dex */
public final class C7223Qu3 implements InterfaceC9764aW7 {
    private final View a;
    public final AvatarViewGlide b;
    public final MaterialButton c;
    public final AppCompatImageView d;
    public final AppCompatImageView e;
    public final AppCompatImageView f;
    public final AppCompatImageView g;
    public final AppCompatTextView h;
    public final AppCompatTextView i;

    private C7223Qu3(View view, AvatarViewGlide avatarViewGlide, MaterialButton materialButton, AppCompatImageView appCompatImageView, AppCompatImageView appCompatImageView2, AppCompatImageView appCompatImageView3, AppCompatImageView appCompatImageView4, AppCompatTextView appCompatTextView, AppCompatTextView appCompatTextView2) {
        this.a = view;
        this.b = avatarViewGlide;
        this.c = materialButton;
        this.d = appCompatImageView;
        this.e = appCompatImageView2;
        this.f = appCompatImageView3;
        this.g = appCompatImageView4;
        this.h = appCompatTextView;
        this.i = appCompatTextView2;
    }

    public static C7223Qu3 a(View view) {
        int i = AbstractC18172oC5.avatarProfile;
        AvatarViewGlide avatarViewGlide = (AvatarViewGlide) AbstractC11738dW7.a(view, i);
        if (avatarViewGlide != null) {
            i = AbstractC18172oC5.btnJoin;
            MaterialButton materialButton = (MaterialButton) AbstractC11738dW7.a(view, i);
            if (materialButton != null) {
                i = AbstractC18172oC5.ivBack;
                AppCompatImageView appCompatImageView = (AppCompatImageView) AbstractC11738dW7.a(view, i);
                if (appCompatImageView != null) {
                    i = AbstractC18172oC5.ivBadge;
                    AppCompatImageView appCompatImageView2 = (AppCompatImageView) AbstractC11738dW7.a(view, i);
                    if (appCompatImageView2 != null) {
                        i = AbstractC18172oC5.ivContextMenu;
                        AppCompatImageView appCompatImageView3 = (AppCompatImageView) AbstractC11738dW7.a(view, i);
                        if (appCompatImageView3 != null) {
                            i = AbstractC18172oC5.ivMute;
                            AppCompatImageView appCompatImageView4 = (AppCompatImageView) AbstractC11738dW7.a(view, i);
                            if (appCompatImageView4 != null) {
                                i = AbstractC18172oC5.tvName;
                                AppCompatTextView appCompatTextView = (AppCompatTextView) AbstractC11738dW7.a(view, i);
                                if (appCompatTextView != null) {
                                    i = AbstractC18172oC5.tvTime;
                                    AppCompatTextView appCompatTextView2 = (AppCompatTextView) AbstractC11738dW7.a(view, i);
                                    if (appCompatTextView2 != null) {
                                        return new C7223Qu3(view, avatarViewGlide, materialButton, appCompatImageView, appCompatImageView2, appCompatImageView3, appCompatImageView4, appCompatTextView, appCompatTextView2);
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

    public static C7223Qu3 b(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        if (viewGroup == null) {
            throw new NullPointerException("parent");
        }
        layoutInflater.inflate(RC5.layout_story_top_bar, viewGroup);
        return a(viewGroup);
    }

    @Override // ir.nasim.InterfaceC9764aW7
    public View getRoot() {
        return this.a;
    }
}
