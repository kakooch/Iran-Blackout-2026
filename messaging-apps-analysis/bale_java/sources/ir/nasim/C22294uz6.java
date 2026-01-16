package ir.nasim;

import android.view.View;
import com.facebook.shimmer.ShimmerFrameLayout;

/* renamed from: ir.nasim.uz6, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C22294uz6 implements InterfaceC9764aW7 {
    private final ShimmerFrameLayout a;

    private C22294uz6(ShimmerFrameLayout shimmerFrameLayout) {
        this.a = shimmerFrameLayout;
    }

    public static C22294uz6 a(View view) {
        if (view != null) {
            return new C22294uz6((ShimmerFrameLayout) view);
        }
        throw new NullPointerException("rootView");
    }

    @Override // ir.nasim.InterfaceC9764aW7
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public ShimmerFrameLayout getRoot() {
        return this.a;
    }
}
