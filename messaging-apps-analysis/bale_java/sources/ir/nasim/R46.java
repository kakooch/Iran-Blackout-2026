package ir.nasim;

import android.graphics.PointF;
import ir.nasim.AbstractC24408ya0;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes2.dex */
public class R46 implements InterfaceC23462wx6, AbstractC24408ya0.b {
    private final com.airbnb.lottie.q a;
    private final String b;
    private final AbstractC24408ya0 c;
    private C14465hx6 d;

    public R46(com.airbnb.lottie.q qVar, AbstractC3236Aa0 abstractC3236Aa0, Q46 q46) {
        this.a = qVar;
        this.b = q46.c();
        AbstractC24408ya0 abstractC24408ya0J = q46.b().j();
        this.c = abstractC24408ya0J;
        abstractC3236Aa0.j(abstractC24408ya0J);
        abstractC24408ya0J.a(this);
    }

    private static int c(int i, int i2) {
        int i3 = i / i2;
        return ((i ^ i2) >= 0 || i2 * i3 == i) ? i3 : i3 - 1;
    }

    private static int f(int i, int i2) {
        return i - (c(i, i2) * i2);
    }

    private C14465hx6 j(C14465hx6 c14465hx6) {
        List listA = c14465hx6.a();
        boolean zD = c14465hx6.d();
        int size = listA.size() - 1;
        int i = 0;
        while (size >= 0) {
            C13267fw1 c13267fw1 = (C13267fw1) listA.get(size);
            C13267fw1 c13267fw12 = (C13267fw1) listA.get(f(size - 1, listA.size()));
            PointF pointFC = (size != 0 || zD) ? c13267fw12.c() : c14465hx6.b();
            i = (((size != 0 || zD) ? c13267fw12.b() : pointFC).equals(pointFC) && c13267fw1.a().equals(pointFC) && !(!c14465hx6.d() && (size == 0 || size == listA.size() - 1))) ? i + 2 : i + 1;
            size--;
        }
        C14465hx6 c14465hx62 = this.d;
        if (c14465hx62 == null || c14465hx62.a().size() != i) {
            ArrayList arrayList = new ArrayList(i);
            for (int i2 = 0; i2 < i; i2++) {
                arrayList.add(new C13267fw1());
            }
            this.d = new C14465hx6(new PointF(0.0f, 0.0f), false, arrayList);
        }
        this.d.e(zD);
        return this.d;
    }

    @Override // ir.nasim.AbstractC24408ya0.b
    public void a() {
        this.a.invalidateSelf();
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x009f  */
    @Override // ir.nasim.InterfaceC23462wx6
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public ir.nasim.C14465hx6 d(ir.nasim.C14465hx6 r19) {
        /*
            Method dump skipped, instructions count: 406
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.R46.d(ir.nasim.hx6):ir.nasim.hx6");
    }

    @Override // ir.nasim.InterfaceC23462wx6
    public void e(AbstractC24408ya0.b bVar) {
        this.c.a(bVar);
    }

    public AbstractC24408ya0 h() {
        return this.c;
    }

    @Override // ir.nasim.InterfaceC14939ik1
    public void b(List list, List list2) {
    }
}
