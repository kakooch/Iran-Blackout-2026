package ir.nasim;

import android.view.View;
import com.facebook.shimmer.ShimmerFrameLayout;

/* renamed from: ir.nasim.Ef3, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C4225Ef3 implements InterfaceC9764aW7 {
    private final ShimmerFrameLayout a;

    private C4225Ef3(ShimmerFrameLayout shimmerFrameLayout) {
        this.a = shimmerFrameLayout;
    }

    public static C4225Ef3 a(View view) {
        if (view != null) {
            return new C4225Ef3((ShimmerFrameLayout) view);
        }
        throw new NullPointerException("rootView");
    }

    @Override // ir.nasim.InterfaceC9764aW7
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public ShimmerFrameLayout getRoot() {
        return this.a;
    }
}
