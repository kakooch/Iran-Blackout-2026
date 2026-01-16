package ir.nasim;

import android.view.View;
import com.facebook.shimmer.ShimmerFrameLayout;

/* renamed from: ir.nasim.wz6, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C23480wz6 implements InterfaceC9764aW7 {
    private final ShimmerFrameLayout a;

    private C23480wz6(ShimmerFrameLayout shimmerFrameLayout) {
        this.a = shimmerFrameLayout;
    }

    public static C23480wz6 a(View view) {
        if (view != null) {
            return new C23480wz6((ShimmerFrameLayout) view);
        }
        throw new NullPointerException("rootView");
    }

    @Override // ir.nasim.InterfaceC9764aW7
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public ShimmerFrameLayout getRoot() {
        return this.a;
    }
}
