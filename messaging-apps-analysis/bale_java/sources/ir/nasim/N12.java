package ir.nasim;

import android.graphics.Matrix;
import android.graphics.Rect;
import android.util.Size;
import androidx.camera.core.ProcessingException;
import ir.nasim.G27;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CancellationException;

/* loaded from: classes.dex */
public class N12 {
    final L27 a;
    final InterfaceC15221jD0 b;
    final InterfaceC15221jD0 c;
    private c d;
    private b e;

    class a implements MB2 {
        final /* synthetic */ C27 a;

        a(C27 c27) {
            this.a = c27;
        }

        @Override // ir.nasim.MB2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onSuccess(G27 g27) {
            AbstractC4980Hj5.g(g27);
            try {
                N12.this.a.b(g27);
            } catch (ProcessingException e) {
                PI3.d("DualSurfaceProcessorNode", "Failed to send SurfaceOutput to SurfaceProcessor.", e);
            }
        }

        @Override // ir.nasim.MB2
        public void onFailure(Throwable th) {
            if (this.a.s() == 2 && (th instanceof CancellationException)) {
                PI3.a("DualSurfaceProcessorNode", "Downstream VideoCapture failed to provide Surface.");
                return;
            }
            PI3.m("DualSurfaceProcessorNode", "Downstream node failed to provide Surface. Target: " + AbstractC3797Cj7.a(this.a.s()), th);
        }
    }

    public static abstract class b {
        public static b d(C27 c27, C27 c272, List list) {
            return new C9729aT(c27, c272, list);
        }

        public abstract List a();

        public abstract C27 b();

        public abstract C27 c();
    }

    public static class c extends HashMap {
    }

    public N12(InterfaceC15221jD0 interfaceC15221jD0, InterfaceC15221jD0 interfaceC15221jD02, L27 l27) {
        this.b = interfaceC15221jD0;
        this.c = interfaceC15221jD02;
        this.a = l27;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public void e(InterfaceC15221jD0 interfaceC15221jD0, InterfaceC15221jD0 interfaceC15221jD02, C27 c27, C27 c272, Map.Entry entry) {
        C27 c273 = (C27) entry.getValue();
        Size sizeE = c27.r().e();
        Rect rectA = ((AbstractC24676z12) entry.getKey()).a().a();
        if (!c27.t()) {
            interfaceC15221jD0 = null;
        }
        G27.a aVarF = G27.a.f(sizeE, rectA, interfaceC15221jD0, ((AbstractC24676z12) entry.getKey()).a().c(), ((AbstractC24676z12) entry.getKey()).a().g());
        Size sizeE2 = c272.r().e();
        Rect rectA2 = ((AbstractC24676z12) entry.getKey()).b().a();
        if (!c272.t()) {
            interfaceC15221jD02 = null;
        }
        WB2.g(c273.j(((AbstractC24676z12) entry.getKey()).a().b(), aVarF, G27.a.f(sizeE2, rectA2, interfaceC15221jD02, ((AbstractC24676z12) entry.getKey()).b().c(), ((AbstractC24676z12) entry.getKey()).b().g())), new a(c273), AbstractC20567sE0.c());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void d() {
        c cVar = this.d;
        if (cVar != null) {
            Iterator it = cVar.values().iterator();
            while (it.hasNext()) {
                ((C27) it.next()).i();
            }
        }
    }

    private void g(final InterfaceC15221jD0 interfaceC15221jD0, final InterfaceC15221jD0 interfaceC15221jD02, final C27 c27, final C27 c272, Map map) {
        for (final Map.Entry entry : map.entrySet()) {
            e(interfaceC15221jD0, interfaceC15221jD02, c27, c272, entry);
            ((C27) entry.getValue()).e(new Runnable() { // from class: ir.nasim.M12
                @Override // java.lang.Runnable
                public final void run() {
                    this.a.e(interfaceC15221jD0, interfaceC15221jD02, c27, c272, entry);
                }
            });
        }
    }

    private void h(InterfaceC15221jD0 interfaceC15221jD0, C27 c27, Map map, boolean z) {
        try {
            this.a.a(c27.l(interfaceC15221jD0, z));
        } catch (ProcessingException e) {
            PI3.d("DualSurfaceProcessorNode", "Failed to send SurfaceRequest to SurfaceProcessor.", e);
        }
    }

    private C27 j(C27 c27, MM4 mm4) {
        Rect rectA = mm4.a();
        int iC = mm4.c();
        boolean zG = mm4.g();
        Matrix matrix = new Matrix();
        AbstractC4980Hj5.a(AbstractC14447hv7.j(AbstractC14447hv7.f(rectA, iC), mm4.d()));
        Rect rectP = AbstractC14447hv7.p(mm4.d());
        return new C27(mm4.e(), mm4.b(), c27.r().g().e(mm4.d()).a(), matrix, false, rectP, c27.p() - iC, -1, c27.v() != zG);
    }

    public void f() {
        this.a.release();
        AbstractC17949np7.d(new Runnable() { // from class: ir.nasim.L12
            @Override // java.lang.Runnable
            public final void run() {
                this.a.d();
            }
        });
    }

    public c i(b bVar) {
        AbstractC17949np7.a();
        this.e = bVar;
        this.d = new c();
        C27 c27B = this.e.b();
        C27 c27C = this.e.c();
        for (AbstractC24676z12 abstractC24676z12 : this.e.a()) {
            this.d.put(abstractC24676z12, j(c27B, abstractC24676z12.a()));
        }
        h(this.b, c27B, this.d, true);
        h(this.c, c27C, this.d, false);
        g(this.b, this.c, c27B, c27C, this.d);
        return this.d;
    }
}
