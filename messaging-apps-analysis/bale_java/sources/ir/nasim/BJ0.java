package ir.nasim;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.google.android.material.button.MaterialButton;
import ir.nasim.designsystem.DividerView;
import ir.nasim.designsystem.avatar.AvatarViewGlide;

/* loaded from: classes6.dex */
public final class BJ0 implements InterfaceC9764aW7 {
    private final LinearLayout a;
    public final AvatarViewGlide b;
    public final DividerView c;
    public final MaterialButton d;
    public final TextView e;
    public final TextView f;
    public final TextView g;
    public final TextView h;

    private BJ0(LinearLayout linearLayout, AvatarViewGlide avatarViewGlide, DividerView dividerView, MaterialButton materialButton, TextView textView, TextView textView2, TextView textView3, TextView textView4) {
        this.a = linearLayout;
        this.b = avatarViewGlide;
        this.c = dividerView;
        this.d = materialButton;
        this.e = textView;
        this.f = textView2;
        this.g = textView3;
        this.h = textView4;
    }

    public static BJ0 a(View view) {
        int i = AbstractC12808fC5.avatar;
        AvatarViewGlide avatarViewGlide = (AvatarViewGlide) AbstractC11738dW7.a(view, i);
        if (avatarViewGlide != null) {
            i = AbstractC12808fC5.divider;
            DividerView dividerView = (DividerView) AbstractC11738dW7.a(view, i);
            if (dividerView != null) {
                i = AbstractC12808fC5.join_container;
                MaterialButton materialButton = (MaterialButton) AbstractC11738dW7.a(view, i);
                if (materialButton != null) {
                    i = AbstractC12808fC5.member_count;
                    TextView textView = (TextView) AbstractC11738dW7.a(view, i);
                    if (textView != null) {
                        i = AbstractC12808fC5.nick;
                        TextView textView2 = (TextView) AbstractC11738dW7.a(view, i);
                        if (textView2 != null) {
                            i = AbstractC12808fC5.title;
                            TextView textView3 = (TextView) AbstractC11738dW7.a(view, i);
                            if (textView3 != null) {
                                i = AbstractC12808fC5.title_tv;
                                TextView textView4 = (TextView) AbstractC11738dW7.a(view, i);
                                if (textView4 != null) {
                                    return new BJ0((LinearLayout) view, avatarViewGlide, dividerView, materialButton, textView, textView2, textView3, textView4);
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static BJ0 c(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(HC5.channel_item_holder, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // ir.nasim.InterfaceC9764aW7
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public LinearLayout getRoot() {
        return this.a;
    }
}
