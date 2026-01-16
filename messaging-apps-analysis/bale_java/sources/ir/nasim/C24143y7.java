package ir.nasim;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.google.android.exoplayer2.ui.PlayerView;
import ir.nasim.designsystem.ImageViewCrossFade;

/* renamed from: ir.nasim.y7, reason: case insensitive filesystem */
/* loaded from: classes7.dex */
public final class C24143y7 implements InterfaceC9764aW7 {
    private final ConstraintLayout a;
    public final ConstraintLayout b;
    public final ImageViewCrossFade c;
    public final PlayerView d;

    private C24143y7(ConstraintLayout constraintLayout, ConstraintLayout constraintLayout2, ImageViewCrossFade imageViewCrossFade, PlayerView playerView) {
        this.a = constraintLayout;
        this.b = constraintLayout2;
        this.c = imageViewCrossFade;
        this.d = playerView;
    }

    public static C24143y7 a(View view) {
        ConstraintLayout constraintLayout = (ConstraintLayout) view;
        int i = AbstractC18172oC5.storyImage;
        ImageViewCrossFade imageViewCrossFade = (ImageViewCrossFade) AbstractC11738dW7.a(view, i);
        if (imageViewCrossFade != null) {
            i = AbstractC18172oC5.storyVideo;
            PlayerView playerView = (PlayerView) AbstractC11738dW7.a(view, i);
            if (playerView != null) {
                return new C24143y7(constraintLayout, constraintLayout, imageViewCrossFade, playerView);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static C24143y7 c(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(RC5.adapter_story_view, viewGroup, false);
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
