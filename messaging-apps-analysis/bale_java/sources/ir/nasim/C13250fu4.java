package ir.nasim;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewpager.widget.ViewPager;

/* renamed from: ir.nasim.fu4, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C13250fu4 implements InterfaceC9764aW7 {
    private final ConstraintLayout a;
    public final C12614eu4 b;
    public final FrameLayout c;
    public final TextView d;
    public final ViewPager e;

    private C13250fu4(ConstraintLayout constraintLayout, C12614eu4 c12614eu4, FrameLayout frameLayout, TextView textView, ViewPager viewPager) {
        this.a = constraintLayout;
        this.b = c12614eu4;
        this.c = frameLayout;
        this.d = textView;
        this.e = viewPager;
    }

    public static C13250fu4 a(View view) {
        int i = BC5.includeFrame;
        View viewA = AbstractC11738dW7.a(view, i);
        if (viewA != null) {
            C12614eu4 c12614eu4A = C12614eu4.a(viewA);
            i = BC5.navigation_frame;
            FrameLayout frameLayout = (FrameLayout) AbstractC11738dW7.a(view, i);
            if (frameLayout != null) {
                i = BC5.text_btn_skip;
                TextView textView = (TextView) AbstractC11738dW7.a(view, i);
                if (textView != null) {
                    i = BC5.viewPagerBullet;
                    ViewPager viewPager = (ViewPager) AbstractC11738dW7.a(view, i);
                    if (viewPager != null) {
                        return new C13250fu4((ConstraintLayout) view, c12614eu4A, frameLayout, textView, viewPager);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static C13250fu4 c(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(AbstractC12208eD5.new_intro_layout, viewGroup, false);
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
