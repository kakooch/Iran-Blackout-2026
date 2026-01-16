package ir.nasim;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import ir.nasim.designsystem.avatar.AvatarViewGlide;

/* renamed from: ir.nasim.ly6, reason: case insensitive filesystem */
/* loaded from: classes7.dex */
public final class C16854ly6 implements InterfaceC9764aW7 {
    private final LinearLayout a;
    public final AvatarViewGlide b;
    public final LinearLayout c;
    public final TextView d;
    public final TextView e;

    private C16854ly6(LinearLayout linearLayout, AvatarViewGlide avatarViewGlide, LinearLayout linearLayout2, TextView textView, TextView textView2) {
        this.a = linearLayout;
        this.b = avatarViewGlide;
        this.c = linearLayout2;
        this.d = textView;
        this.e = textView2;
    }

    public static C16854ly6 a(View view) {
        int i = AbstractC17581nC5.avatar;
        AvatarViewGlide avatarViewGlide = (AvatarViewGlide) AbstractC11738dW7.a(view, i);
        if (avatarViewGlide != null) {
            i = AbstractC17581nC5.content_container;
            LinearLayout linearLayout = (LinearLayout) AbstractC11738dW7.a(view, i);
            if (linearLayout != null) {
                i = AbstractC17581nC5.name_txt;
                TextView textView = (TextView) AbstractC11738dW7.a(view, i);
                if (textView != null) {
                    i = AbstractC17581nC5.presence_txt;
                    TextView textView2 = (TextView) AbstractC11738dW7.a(view, i);
                    if (textView2 != null) {
                        return new C16854ly6((LinearLayout) view, avatarViewGlide, linearLayout, textView, textView2);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static C16854ly6 c(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(QC5.shared_media_contact_item, viewGroup, false);
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
