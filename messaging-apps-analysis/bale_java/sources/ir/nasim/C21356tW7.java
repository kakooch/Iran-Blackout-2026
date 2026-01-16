package ir.nasim;

import android.graphics.Outline;
import android.graphics.Path;
import android.graphics.RectF;
import android.os.Build;
import android.view.View;
import android.view.ViewOutlineProvider;
import ir.nasim.animation.view.transition.sharedelement.Corners;

/* renamed from: ir.nasim.tW7, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C21356tW7 extends ViewOutlineProvider {
    private final Corners a;
    private final Path b;
    private final RectF c;

    public C21356tW7(Corners corners) {
        AbstractC13042fc3.i(corners, "corners");
        this.a = corners;
        this.b = new Path();
        this.c = new RectF();
    }

    public final Corners a() {
        return this.a;
    }

    @Override // android.view.ViewOutlineProvider
    public void getOutline(View view, Outline outline) {
        AbstractC13042fc3.i(view, "view");
        AbstractC13042fc3.i(outline, "outline");
        this.c.set(0.0f, 0.0f, view.getWidth(), view.getHeight());
        Corners corners = this.a;
        float[] fArr = {corners.getTopLeft(), corners.getTopLeft(), corners.getTopRight(), corners.getTopRight(), corners.getBottomRight(), corners.getBottomRight(), corners.getBottomLeft(), corners.getBottomLeft()};
        this.b.reset();
        this.b.addRoundRect(this.c, fArr, Path.Direction.CW);
        if (Build.VERSION.SDK_INT >= 30) {
            outline.setPath(this.b);
        } else {
            outline.setConvexPath(this.b);
        }
    }

    public /* synthetic */ C21356tW7(Corners corners, int i, ED1 ed1) {
        this((i & 1) != 0 ? new Corners(0.0f, 0.0f, 0.0f, 0.0f, 15, null) : corners);
    }
}
