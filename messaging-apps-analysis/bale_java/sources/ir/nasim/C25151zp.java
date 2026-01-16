package ir.nasim;

import android.graphics.RectF;
import android.text.Layout;
import android.text.SegmentFinder;

/* renamed from: ir.nasim.zp, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C25151zp {
    public static final C25151zp a = new C25151zp();

    private C25151zp() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean b(InterfaceC14603iB2 interfaceC14603iB2, RectF rectF, RectF rectF2) {
        return ((Boolean) interfaceC14603iB2.invoke(rectF, rectF2)).booleanValue();
    }

    public final int[] c(C10550bn7 c10550bn7, RectF rectF, int i, final InterfaceC14603iB2 interfaceC14603iB2) {
        SegmentFinder segmentFinderA;
        if (i == 1) {
            segmentFinderA = C22847vv.a.a(new Ka8(c10550bn7.G(), c10550bn7.I()));
        } else {
            AbstractC22781vp.a();
            segmentFinderA = AbstractC23377wp.a(AbstractC22191up.a(c10550bn7.G(), c10550bn7.H()));
        }
        return c10550bn7.i().getRangeForRect(rectF, segmentFinderA, new Layout.TextInclusionStrategy() { // from class: ir.nasim.yp
            @Override // android.text.Layout.TextInclusionStrategy
            public final boolean isSegmentInside(RectF rectF2, RectF rectF3) {
                return C25151zp.b(interfaceC14603iB2, rectF2, rectF3);
            }
        });
    }
}
