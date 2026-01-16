package ir.nasim;

import android.graphics.Bitmap;

/* renamed from: ir.nasim.mp, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C17350mp implements Y03 {
    private final Bitmap b;

    public C17350mp(Bitmap bitmap) {
        this.b = bitmap;
    }

    @Override // ir.nasim.Y03
    public void a() {
        this.b.prepareToDraw();
    }

    @Override // ir.nasim.Y03
    public int b() {
        Bitmap.Config config = this.b.getConfig();
        AbstractC13042fc3.f(config);
        return AbstractC19123pp.e(config);
    }

    public final Bitmap c() {
        return this.b;
    }

    @Override // ir.nasim.Y03
    public int getHeight() {
        return this.b.getHeight();
    }

    @Override // ir.nasim.Y03
    public int getWidth() {
        return this.b.getWidth();
    }
}
