package ir.nasim;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.skydoves.balloon.overlay.BalloonAnchorOverlayView;

/* loaded from: classes3.dex */
public final class R20 implements InterfaceC9764aW7 {
    private final BalloonAnchorOverlayView a;
    public final BalloonAnchorOverlayView b;

    private R20(BalloonAnchorOverlayView balloonAnchorOverlayView, BalloonAnchorOverlayView balloonAnchorOverlayView2) {
        this.a = balloonAnchorOverlayView;
        this.b = balloonAnchorOverlayView2;
    }

    public static R20 a(View view) {
        if (view == null) {
            throw new NullPointerException("rootView");
        }
        BalloonAnchorOverlayView balloonAnchorOverlayView = (BalloonAnchorOverlayView) view;
        return new R20(balloonAnchorOverlayView, balloonAnchorOverlayView);
    }

    public static R20 c(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(ZC5.balloon_layout_overlay, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // ir.nasim.InterfaceC9764aW7
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public BalloonAnchorOverlayView getRoot() {
        return this.a;
    }
}
