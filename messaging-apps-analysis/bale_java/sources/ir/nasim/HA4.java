package ir.nasim;

import android.util.Size;
import android.view.Surface;
import ir.nasim.O23;
import java.util.concurrent.Executor;

/* loaded from: classes.dex */
public class HA4 implements O23 {
    private final O23 a;
    private AbstractC12595es5 b;

    HA4(O23 o23) {
        this.a = o23;
    }

    private androidx.camera.core.f j(androidx.camera.core.f fVar) {
        if (fVar == null) {
            return null;
        }
        return new androidx.camera.core.j(fVar, new Size(fVar.getWidth(), fVar.getHeight()), new RB0(new AY7(C14935ij7.b(), fVar.u1().getTimestamp())));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void k(O23.a aVar, O23 o23) {
        aVar.a(this);
    }

    @Override // ir.nasim.O23
    public androidx.camera.core.f b() {
        return j(this.a.b());
    }

    @Override // ir.nasim.O23
    public int c() {
        return this.a.c();
    }

    @Override // ir.nasim.O23
    public void close() {
        this.a.close();
    }

    @Override // ir.nasim.O23
    public void d() {
        this.a.d();
    }

    @Override // ir.nasim.O23
    public int e() {
        return this.a.e();
    }

    @Override // ir.nasim.O23
    public void f(final O23.a aVar, Executor executor) {
        this.a.f(new O23.a() { // from class: ir.nasim.GA4
            @Override // ir.nasim.O23.a
            public final void a(O23 o23) {
                this.a.k(aVar, o23);
            }
        }, executor);
    }

    @Override // ir.nasim.O23
    public androidx.camera.core.f g() {
        return j(this.a.g());
    }

    @Override // ir.nasim.O23
    public int getHeight() {
        return this.a.getHeight();
    }

    @Override // ir.nasim.O23
    public Surface getSurface() {
        return this.a.getSurface();
    }

    @Override // ir.nasim.O23
    public int getWidth() {
        return this.a.getWidth();
    }

    void h(AbstractC12595es5 abstractC12595es5) {
        AbstractC4980Hj5.j(true, "Pending request should be null");
    }

    void i() {
    }
}
