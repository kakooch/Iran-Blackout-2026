package ir.nasim;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import ir.nasim.designsystem.avatar.AvatarViewGlide;

/* renamed from: ir.nasim.Yt3, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C9164Yt3 implements InterfaceC9764aW7 {
    private final FrameLayout a;
    public final ImageView b;
    public final AvatarViewGlide c;
    public final View d;
    public final AvatarViewGlide e;
    public final ImageView f;

    private C9164Yt3(FrameLayout frameLayout, ImageView imageView, AvatarViewGlide avatarViewGlide, View view, AvatarViewGlide avatarViewGlide2, ImageView imageView2) {
        this.a = frameLayout;
        this.b = imageView;
        this.c = avatarViewGlide;
        this.d = view;
        this.e = avatarViewGlide2;
        this.f = imageView2;
    }

    public static C9164Yt3 a(View view) {
        View viewA;
        int i = BC5.avatar_badge;
        ImageView imageView = (ImageView) AbstractC11738dW7.a(view, i);
        if (imageView != null) {
            i = BC5.avatarInsideRing;
            AvatarViewGlide avatarViewGlide = (AvatarViewGlide) AbstractC11738dW7.a(view, i);
            if (avatarViewGlide != null && (viewA = AbstractC11738dW7.a(view, (i = BC5.avatar_presence))) != null) {
                i = BC5.originalAvatar;
                AvatarViewGlide avatarViewGlide2 = (AvatarViewGlide) AbstractC11738dW7.a(view, i);
                if (avatarViewGlide2 != null) {
                    i = BC5.ring;
                    ImageView imageView2 = (ImageView) AbstractC11738dW7.a(view, i);
                    if (imageView2 != null) {
                        return new C9164Yt3((FrameLayout) view, imageView, avatarViewGlide, viewA, avatarViewGlide2, imageView2);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static C9164Yt3 c(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(AbstractC12208eD5.layout_avatar_with_story, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // ir.nasim.InterfaceC9764aW7
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public FrameLayout getRoot() {
        return this.a;
    }
}
