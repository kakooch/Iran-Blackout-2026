package ir.nasim;

import android.view.View;
import android.widget.Magnifier;

/* renamed from: ir.nasim.lf5, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C16665lf5 implements InterfaceC16074kf5 {
    public static final C16665lf5 b = new C16665lf5();
    private static final boolean c = false;

    /* renamed from: ir.nasim.lf5$a */
    public static class a implements InterfaceC15483jf5 {
        private final Magnifier a;

        public a(Magnifier magnifier) {
            this.a = magnifier;
        }

        @Override // ir.nasim.InterfaceC15483jf5
        public long a() {
            return C4414Fa3.c((this.a.getHeight() & 4294967295L) | (this.a.getWidth() << 32));
        }

        @Override // ir.nasim.InterfaceC15483jf5
        public void b(long j, long j2, float f) {
            this.a.show(Float.intBitsToFloat((int) (j >> 32)), Float.intBitsToFloat((int) (j & 4294967295L)));
        }

        @Override // ir.nasim.InterfaceC15483jf5
        public void c() {
            this.a.update();
        }

        public final Magnifier d() {
            return this.a;
        }

        @Override // ir.nasim.InterfaceC15483jf5
        public void dismiss() {
            this.a.dismiss();
        }
    }

    private C16665lf5() {
    }

    @Override // ir.nasim.InterfaceC16074kf5
    public boolean b() {
        return c;
    }

    @Override // ir.nasim.InterfaceC16074kf5
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public a a(View view, boolean z, long j, float f, float f2, boolean z2, WH1 wh1, float f3) {
        return new a(new Magnifier(view));
    }
}
