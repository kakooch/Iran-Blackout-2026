package ir.nasim;

import android.graphics.SurfaceTexture;
import android.util.Size;
import android.view.Surface;
import androidx.camera.core.impl.D;
import androidx.camera.core.impl.DeferrableSurface;
import androidx.camera.core.impl.v;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.UUID;

/* renamed from: ir.nasim.Ie4, reason: case insensitive filesystem */
/* loaded from: classes.dex */
class C5168Ie4 {
    private DeferrableSurface a;
    private androidx.camera.core.impl.v b;
    private final Size d;
    private final c f;
    private final C17485n27 e = new C17485n27();
    private v.c g = null;
    private final b c = new b();

    /* renamed from: ir.nasim.Ie4$a */
    class a implements MB2 {
        final /* synthetic */ Surface a;
        final /* synthetic */ SurfaceTexture b;

        a(Surface surface, SurfaceTexture surfaceTexture) {
            this.a = surface;
            this.b = surfaceTexture;
        }

        @Override // ir.nasim.MB2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onSuccess(Void r1) {
            this.a.release();
            this.b.release();
        }

        @Override // ir.nasim.MB2
        public void onFailure(Throwable th) {
            throw new IllegalStateException("Future should never fail. Did it get completed by GC?", th);
        }
    }

    /* renamed from: ir.nasim.Ie4$b */
    private static class b implements androidx.camera.core.impl.C {
        private final androidx.camera.core.impl.j H;

        b() {
            androidx.camera.core.impl.q qVarZ = androidx.camera.core.impl.q.Z();
            qVarZ.p(androidx.camera.core.impl.C.v, new FB0());
            qVarZ.p(androidx.camera.core.impl.n.h, 34);
            V(qVarZ);
            this.H = qVarZ;
        }

        private void V(androidx.camera.core.impl.q qVar) {
            qVar.p(InterfaceC24505yj7.G, C5168Ie4.class);
            qVar.p(InterfaceC24505yj7.F, C5168Ie4.class.getCanonicalName() + "-" + UUID.randomUUID());
        }

        @Override // androidx.camera.core.impl.C
        public D.b N() {
            return D.b.METERING_REPEATING;
        }

        @Override // androidx.camera.core.impl.u
        public androidx.camera.core.impl.j getConfig() {
            return this.H;
        }
    }

    /* renamed from: ir.nasim.Ie4$c */
    interface c {
        void a();
    }

    C5168Ie4(C19349qC0 c19349qC0, C21341tV1 c21341tV1, c cVar) {
        this.f = cVar;
        Size sizeG = g(c19349qC0, c21341tV1);
        this.d = sizeG;
        PI3.a("MeteringRepeating", "MeteringSession SurfaceTexture size: " + sizeG);
        this.b = d();
    }

    private Size g(C19349qC0 c19349qC0, C21341tV1 c21341tV1) {
        Size[] sizeArrC = c19349qC0.b().c(34);
        if (sizeArrC == null) {
            PI3.c("MeteringRepeating", "Can not get output size list.");
            return new Size(0, 0);
        }
        Size[] sizeArrA = this.e.a(sizeArrC);
        List listAsList = Arrays.asList(sizeArrA);
        Collections.sort(listAsList, new Comparator() { // from class: ir.nasim.He4
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                return C5168Ie4.k((Size) obj, (Size) obj2);
            }
        });
        Size sizeF = c21341tV1.f();
        long jMin = Math.min(sizeF.getWidth() * sizeF.getHeight(), 307200L);
        int length = sizeArrA.length;
        Size size = null;
        int i = 0;
        while (true) {
            if (i >= length) {
                break;
            }
            Size size2 = sizeArrA[i];
            long width = size2.getWidth() * size2.getHeight();
            if (width == jMin) {
                return size2;
            }
            if (width <= jMin) {
                i++;
                size = size2;
            } else if (size != null) {
                return size;
            }
        }
        return (Size) listAsList.get(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void j(androidx.camera.core.impl.v vVar, v.g gVar) {
        this.b = d();
        c cVar = this.f;
        if (cVar != null) {
            cVar.a();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ int k(Size size, Size size2) {
        return Long.signum((size.getWidth() * size.getHeight()) - (size2.getWidth() * size2.getHeight()));
    }

    void c() {
        PI3.a("MeteringRepeating", "MeteringRepeating clear!");
        DeferrableSurface deferrableSurface = this.a;
        if (deferrableSurface != null) {
            deferrableSurface.d();
        }
        this.a = null;
    }

    androidx.camera.core.impl.v d() {
        SurfaceTexture surfaceTexture = new SurfaceTexture(0);
        surfaceTexture.setDefaultBufferSize(this.d.getWidth(), this.d.getHeight());
        Surface surface = new Surface(surfaceTexture);
        v.b bVarP = v.b.p(this.c, this.d);
        bVarP.w(1);
        W33 w33 = new W33(surface);
        this.a = w33;
        WB2.g(w33.k(), new a(surface, surfaceTexture), AbstractC20567sE0.a());
        bVarP.l(this.a);
        v.c cVar = this.g;
        if (cVar != null) {
            cVar.b();
        }
        v.c cVar2 = new v.c(new v.d() { // from class: ir.nasim.Ge4
            @Override // androidx.camera.core.impl.v.d
            public final void a(androidx.camera.core.impl.v vVar, v.g gVar) {
                this.a.j(vVar, gVar);
            }
        });
        this.g = cVar2;
        bVarP.q(cVar2);
        return bVarP.o();
    }

    Size e() {
        return this.d;
    }

    String f() {
        return "MeteringRepeating";
    }

    androidx.camera.core.impl.v h() {
        return this.b;
    }

    androidx.camera.core.impl.C i() {
        return this.c;
    }
}
