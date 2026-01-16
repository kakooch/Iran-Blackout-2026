package ir.nasim;

import android.content.Context;
import android.widget.EdgeEffect;

/* renamed from: ir.nasim.yJ2, reason: case insensitive filesystem */
/* loaded from: classes.dex */
final class C24257yJ2 extends EdgeEffect {
    private final float a;
    private float b;

    public C24257yJ2(Context context) {
        super(context);
        this.a = AbstractC6427No.a(context).w1(C17784nZ1.q(1));
    }

    public final void a(float f) {
        float f2 = this.b + f;
        this.b = f2;
        if (Math.abs(f2) > this.a) {
            onRelease();
        }
    }

    @Override // android.widget.EdgeEffect
    public void onAbsorb(int i) {
        this.b = 0.0f;
        super.onAbsorb(i);
    }

    @Override // android.widget.EdgeEffect
    public void onPull(float f, float f2) {
        this.b = 0.0f;
        super.onPull(f, f2);
    }

    @Override // android.widget.EdgeEffect
    public void onRelease() {
        this.b = 0.0f;
        super.onRelease();
    }

    @Override // android.widget.EdgeEffect
    public void onPull(float f) {
        this.b = 0.0f;
        super.onPull(f);
    }
}
