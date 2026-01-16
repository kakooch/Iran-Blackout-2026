package ir.nasim;

import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import androidx.camera.core.ProcessingException;
import ir.nasim.G27;
import ir.nasim.Z27;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CancellationException;

/* loaded from: classes.dex */
public class P27 {
    final L27 a;
    final InterfaceC15221jD0 b;
    private c c;
    private b d;

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
                P27.this.a.b(g27);
            } catch (ProcessingException e) {
                PI3.d("SurfaceProcessorNode", "Failed to send SurfaceOutput to SurfaceProcessor.", e);
            }
        }

        @Override // ir.nasim.MB2
        public void onFailure(Throwable th) {
            if (this.a.s() == 2 && (th instanceof CancellationException)) {
                PI3.a("SurfaceProcessorNode", "Downstream VideoCapture failed to provide Surface.");
                return;
            }
            PI3.m("SurfaceProcessorNode", "Downstream node failed to provide Surface. Target: " + AbstractC3797Cj7.a(this.a.s()), th);
        }
    }

    public static abstract class b {
        public static b c(C27 c27, List list) {
            return new GT(c27, list);
        }

        public abstract List a();

        public abstract C27 b();
    }

    public static class c extends HashMap {
    }

    public P27(InterfaceC15221jD0 interfaceC15221jD0, L27 l27) {
        this.b = interfaceC15221jD0;
        this.a = l27;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public void f(C27 c27, Map.Entry entry) {
        C27 c272 = (C27) entry.getValue();
        WB2.g(c272.j(((MM4) entry.getKey()).b(), G27.a.f(c27.r().e(), ((MM4) entry.getKey()).a(), c27.t() ? this.b : null, ((MM4) entry.getKey()).c(), ((MM4) entry.getKey()).g()), null), new a(c272), AbstractC20567sE0.c());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void e() {
        c cVar = this.c;
        if (cVar != null) {
            Iterator it = cVar.values().iterator();
            while (it.hasNext()) {
                ((C27) it.next()).i();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void g(Map map, Z27.h hVar) {
        for (Map.Entry entry : map.entrySet()) {
            int iB = hVar.b() - ((MM4) entry.getKey()).c();
            if (((MM4) entry.getKey()).g()) {
                iB = -iB;
            }
            ((C27) entry.getValue()).C(AbstractC14447hv7.u(iB), -1);
        }
    }

    private void i(final C27 c27, Map map) {
        for (final Map.Entry entry : map.entrySet()) {
            f(c27, entry);
            ((C27) entry.getValue()).e(new Runnable() { // from class: ir.nasim.M27
                @Override // java.lang.Runnable
                public final void run() {
                    this.a.f(c27, entry);
                }
            });
        }
    }

    private void j(C27 c27) {
        try {
            this.a.a(c27.k(this.b));
        } catch (ProcessingException e) {
            PI3.d("SurfaceProcessorNode", "Failed to send SurfaceRequest to SurfaceProcessor.", e);
        }
    }

    private C27 m(C27 c27, MM4 mm4) {
        Rect rectP;
        Rect rectA = mm4.a();
        int iC = mm4.c();
        boolean zG = mm4.g();
        Matrix matrix = new Matrix(c27.q());
        Matrix matrixE = AbstractC14447hv7.e(new RectF(rectA), AbstractC14447hv7.r(mm4.d()), iC, zG);
        matrix.postConcat(matrixE);
        AbstractC4980Hj5.a(AbstractC14447hv7.j(AbstractC14447hv7.f(rectA, iC), mm4.d()));
        if (mm4.j()) {
            AbstractC4980Hj5.b(mm4.a().contains(c27.n()), String.format("Output crop rect %s must contain input crop rect %s", mm4.a(), c27.n()));
            rectP = new Rect();
            RectF rectF = new RectF(c27.n());
            matrixE.mapRect(rectF);
            rectF.round(rectP);
        } else {
            rectP = AbstractC14447hv7.p(mm4.d());
        }
        Rect rect = rectP;
        return new C27(mm4.e(), mm4.b(), c27.r().g().e(mm4.d()).a(), matrix, false, rect, c27.p() - iC, -1, c27.v() != zG);
    }

    public void h() {
        this.a.release();
        AbstractC17949np7.d(new Runnable() { // from class: ir.nasim.O27
            @Override // java.lang.Runnable
            public final void run() {
                this.a.e();
            }
        });
    }

    void k(C27 c27, final Map map) {
        c27.f(new InterfaceC25043ze1() { // from class: ir.nasim.N27
            @Override // ir.nasim.InterfaceC25043ze1
            public final void accept(Object obj) {
                P27.g(map, (Z27.h) obj);
            }
        });
    }

    public c l(b bVar) {
        AbstractC17949np7.a();
        this.d = bVar;
        this.c = new c();
        C27 c27B = bVar.b();
        for (MM4 mm4 : bVar.a()) {
            this.c.put(mm4, m(c27B, mm4));
        }
        j(c27B);
        i(c27B, this.c);
        k(c27B, this.c);
        return this.c;
    }
}
