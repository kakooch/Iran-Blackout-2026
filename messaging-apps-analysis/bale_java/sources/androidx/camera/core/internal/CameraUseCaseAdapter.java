package androidx.camera.core.internal;

import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.SurfaceTexture;
import android.util.Log;
import android.util.Pair;
import android.util.Size;
import android.view.Surface;
import androidx.camera.core.impl.AbstractC1920a;
import androidx.camera.core.impl.C;
import androidx.camera.core.impl.CameraControlInternal;
import androidx.camera.core.impl.D;
import androidx.camera.core.impl.f;
import androidx.camera.core.impl.j;
import androidx.camera.core.impl.m;
import androidx.camera.core.impl.q;
import androidx.camera.core.impl.s;
import androidx.camera.core.impl.v;
import androidx.camera.core.impl.w;
import androidx.camera.core.internal.CameraUseCaseAdapter;
import ir.nasim.AbstractC14447hv7;
import ir.nasim.AbstractC15273jI7;
import ir.nasim.AbstractC18350oW3;
import ir.nasim.AbstractC20567sE0;
import ir.nasim.AbstractC22612vX7;
import ir.nasim.AbstractC4980Hj5;
import ir.nasim.C12398eY6;
import ir.nasim.C15116j22;
import ir.nasim.C16303l27;
import ir.nasim.C22022uX7;
import ir.nasim.C24677z13;
import ir.nasim.C6012Lu3;
import ir.nasim.C8112Uo5;
import ir.nasim.HB0;
import ir.nasim.I03;
import ir.nasim.InterfaceC14021hD0;
import ir.nasim.InterfaceC14623iD0;
import ir.nasim.InterfaceC15221jD0;
import ir.nasim.InterfaceC24505yj7;
import ir.nasim.InterfaceC25043ze1;
import ir.nasim.MC0;
import ir.nasim.PI3;
import ir.nasim.R06;
import ir.nasim.S06;
import ir.nasim.XC0;
import ir.nasim.Z27;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.ExecutionException;

/* loaded from: classes.dex */
public final class CameraUseCaseAdapter implements HB0 {
    private final InterfaceC15221jD0 a;
    private final InterfaceC15221jD0 b;
    private final XC0 c;
    private final D d;
    private final a e;
    private final MC0 h;
    private C22022uX7 i;
    private final f k;
    private AbstractC15273jI7 o;
    private C12398eY6 p;
    private final R06 q;
    private final S06 r;
    private final S06 s;
    private final C6012Lu3 t;
    private final C6012Lu3 u;
    private final List f = new ArrayList();
    private final List g = new ArrayList();
    private List j = Collections.emptyList();
    private final Object l = new Object();
    private boolean m = true;
    private j n = null;

    public static final class CameraException extends Exception {
        public CameraException() {
        }

        public CameraException(Throwable th) {
            super(th);
        }
    }

    public static abstract class a {
        public static a a(String str, I03 i03) {
            return new androidx.camera.core.internal.a(str, i03);
        }

        public abstract I03 b();

        public abstract String c();
    }

    private static class b {
        C a;
        C b;

        b(C c, C c2) {
            this.a = c;
            this.b = c2;
        }
    }

    public CameraUseCaseAdapter(InterfaceC15221jD0 interfaceC15221jD0, InterfaceC15221jD0 interfaceC15221jD02, S06 s06, S06 s062, C6012Lu3 c6012Lu3, C6012Lu3 c6012Lu32, MC0 mc0, XC0 xc0, D d) {
        this.a = interfaceC15221jD0;
        this.b = interfaceC15221jD02;
        this.t = c6012Lu3;
        this.u = c6012Lu32;
        this.h = mc0;
        this.c = xc0;
        this.d = d;
        f fVarL = s06.l();
        this.k = fVarL;
        fVarL.E(null);
        this.q = new R06(interfaceC15221jD0.b(), null);
        this.r = s06;
        this.s = s062;
        this.e = A(s06, s062);
    }

    public static a A(S06 s06, S06 s062) {
        StringBuilder sb = new StringBuilder();
        sb.append(s06.b());
        sb.append(s062 == null ? "" : s062.b());
        return a.a(sb.toString(), s06.l().Q());
    }

    private static C B(D d, C12398eY6 c12398eY6) {
        C cJ = new C8112Uo5.a().c().j(false, d);
        if (cJ == null) {
            return null;
        }
        q qVarA0 = q.a0(cJ);
        qVarA0.b0(InterfaceC24505yj7.G);
        return c12398eY6.y(qVarA0).b();
    }

    private int D() {
        synchronized (this.l) {
            try {
                return this.h.c() == 2 ? 1 : 0;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private static Map E(Collection collection, D d, D d2) {
        HashMap map = new HashMap();
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            AbstractC15273jI7 abstractC15273jI7 = (AbstractC15273jI7) it.next();
            map.put(abstractC15273jI7, new b(C12398eY6.m0(abstractC15273jI7) ? B(d, (C12398eY6) abstractC15273jI7) : abstractC15273jI7.j(false, d), abstractC15273jI7.j(true, d2)));
        }
        return map;
    }

    private int G(boolean z) {
        int i;
        synchronized (this.l) {
            try {
                Iterator it = this.j.iterator();
                if (it.hasNext()) {
                    AbstractC18350oW3.a(it.next());
                    throw null;
                }
                i = z ? 3 : 0;
            } finally {
            }
        }
        return i;
    }

    private Set H(Collection collection, boolean z) {
        HashSet hashSet = new HashSet();
        int iG = G(z);
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            AbstractC15273jI7 abstractC15273jI7 = (AbstractC15273jI7) it.next();
            AbstractC4980Hj5.b(!C12398eY6.m0(abstractC15273jI7), "Only support one level of sharing for now.");
            if (abstractC15273jI7.A(iG)) {
                hashSet.add(abstractC15273jI7);
            }
        }
        return hashSet;
    }

    private boolean J() {
        synchronized (this.l) {
            this.k.E(null);
        }
        return false;
    }

    private static boolean K(w wVar, v vVar) {
        j jVarD = wVar.d();
        j jVarF = vVar.f();
        if (jVarD.e().size() != vVar.f().e().size()) {
            return true;
        }
        for (j.a aVar : jVarD.e()) {
            if (!jVarF.b(aVar) || !Objects.equals(jVarF.a(aVar), jVarD.a(aVar))) {
                return true;
            }
        }
        return false;
    }

    private static boolean L(Collection collection) {
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            if (S(((AbstractC15273jI7) it.next()).i().F())) {
                return true;
            }
        }
        return false;
    }

    private static boolean M(Collection collection) {
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            AbstractC15273jI7 abstractC15273jI7 = (AbstractC15273jI7) it.next();
            if (R(abstractC15273jI7)) {
                C cI = abstractC15273jI7.i();
                j.a aVar = m.M;
                if (cI.b(aVar) && ((Integer) AbstractC4980Hj5.g((Integer) cI.a(aVar))).intValue() == 1) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean N(Collection collection) {
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            if (V((AbstractC15273jI7) it.next())) {
                return true;
            }
        }
        return false;
    }

    private boolean O() {
        boolean z;
        synchronized (this.l) {
            z = true;
            if (this.k.t() != 1) {
                z = false;
            }
        }
        return z;
    }

    private static boolean P(Collection collection) {
        Iterator it = collection.iterator();
        boolean z = false;
        boolean z2 = false;
        while (it.hasNext()) {
            AbstractC15273jI7 abstractC15273jI7 = (AbstractC15273jI7) it.next();
            if (T(abstractC15273jI7) || C12398eY6.m0(abstractC15273jI7)) {
                z = true;
            } else if (R(abstractC15273jI7)) {
                z2 = true;
            }
        }
        return z && !z2;
    }

    private static boolean Q(Collection collection) {
        Iterator it = collection.iterator();
        boolean z = false;
        boolean z2 = false;
        while (it.hasNext()) {
            AbstractC15273jI7 abstractC15273jI7 = (AbstractC15273jI7) it.next();
            if (T(abstractC15273jI7) || C12398eY6.m0(abstractC15273jI7)) {
                z2 = true;
            } else if (R(abstractC15273jI7)) {
                z = true;
            }
        }
        return z && !z2;
    }

    private static boolean R(AbstractC15273jI7 abstractC15273jI7) {
        return abstractC15273jI7 instanceof C24677z13;
    }

    private static boolean S(C15116j22 c15116j22) {
        return (c15116j22.a() == 10) || (c15116j22.b() != 1 && c15116j22.b() != 0);
    }

    private static boolean T(AbstractC15273jI7 abstractC15273jI7) {
        return abstractC15273jI7 instanceof C8112Uo5;
    }

    static boolean U(Collection collection) {
        int[] iArr = {1, 2, 4};
        HashSet hashSet = new HashSet();
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            AbstractC15273jI7 abstractC15273jI7 = (AbstractC15273jI7) it.next();
            for (int i = 0; i < 3; i++) {
                int i2 = iArr[i];
                if (abstractC15273jI7.A(i2)) {
                    if (hashSet.contains(Integer.valueOf(i2))) {
                        return false;
                    }
                    hashSet.add(Integer.valueOf(i2));
                }
            }
        }
        return true;
    }

    private static boolean V(AbstractC15273jI7 abstractC15273jI7) {
        if (abstractC15273jI7 != null) {
            if (abstractC15273jI7.i().b(C.B)) {
                return abstractC15273jI7.i().N() == D.b.VIDEO_CAPTURE;
            }
            Log.e("CameraUseCaseAdapter", abstractC15273jI7 + " UseCase does not have capture type.");
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void W(Surface surface, SurfaceTexture surfaceTexture, Z27.g gVar) {
        surface.release();
        surfaceTexture.release();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void X(Z27 z27) throws ExecutionException, InterruptedException {
        final SurfaceTexture surfaceTexture = new SurfaceTexture(0);
        surfaceTexture.setDefaultBufferSize(z27.o().getWidth(), z27.o().getHeight());
        surfaceTexture.detachFromGLContext();
        final Surface surface = new Surface(surfaceTexture);
        z27.B(surface, AbstractC20567sE0.a(), new InterfaceC25043ze1() { // from class: ir.nasim.QD0
            @Override // ir.nasim.InterfaceC25043ze1
            public final void accept(Object obj) {
                CameraUseCaseAdapter.W(surface, surfaceTexture, (Z27.g) obj);
            }
        });
    }

    private void Z() {
        synchronized (this.l) {
            try {
                if (this.n != null) {
                    this.a.b().f(this.n);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private static List b0(List list, Collection collection) {
        ArrayList arrayList = new ArrayList(list);
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            ((AbstractC15273jI7) it.next()).Q(null);
            Iterator it2 = list.iterator();
            if (it2.hasNext()) {
                AbstractC18350oW3.a(it2.next());
                throw null;
            }
        }
        return arrayList;
    }

    static void d0(List list, Collection collection, Collection collection2) {
        List listB0 = b0(list, collection);
        ArrayList arrayList = new ArrayList(collection2);
        arrayList.removeAll(collection);
        List listB02 = b0(listB0, arrayList);
        if (listB02.size() > 0) {
            PI3.l("CameraUseCaseAdapter", "Unused effects: " + listB02);
        }
    }

    private void f0(Map map, Collection collection) {
        synchronized (this.l) {
            try {
                if (this.i != null && !collection.isEmpty()) {
                    Map mapA = AbstractC22612vX7.a(this.a.b().c(), this.a.j().d() == 0, this.i.a(), this.a.j().k(this.i.c()), this.i.d(), this.i.b(), map);
                    Iterator it = collection.iterator();
                    while (it.hasNext()) {
                        AbstractC15273jI7 abstractC15273jI7 = (AbstractC15273jI7) it.next();
                        abstractC15273jI7.S((Rect) AbstractC4980Hj5.g((Rect) mapA.get(abstractC15273jI7)));
                    }
                }
                Iterator it2 = collection.iterator();
                while (it2.hasNext()) {
                    AbstractC15273jI7 abstractC15273jI72 = (AbstractC15273jI7) it2.next();
                    abstractC15273jI72.R(t(this.a.b().c(), ((w) AbstractC4980Hj5.g((w) map.get(abstractC15273jI72))).e()));
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private void m() {
        synchronized (this.l) {
            CameraControlInternal cameraControlInternalB = this.a.b();
            this.n = cameraControlInternalB.e();
            cameraControlInternalB.g();
        }
    }

    static Collection r(Collection collection, AbstractC15273jI7 abstractC15273jI7, C12398eY6 c12398eY6) {
        ArrayList arrayList = new ArrayList(collection);
        if (abstractC15273jI7 != null) {
            arrayList.add(abstractC15273jI7);
        }
        if (c12398eY6 != null) {
            arrayList.add(c12398eY6);
            arrayList.removeAll(c12398eY6.g0());
        }
        return arrayList;
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x0049  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private ir.nasim.AbstractC15273jI7 s(java.util.Collection r3, ir.nasim.C12398eY6 r4) {
        /*
            r2 = this;
            java.lang.Object r0 = r2.l
            monitor-enter(r0)
            java.util.ArrayList r1 = new java.util.ArrayList     // Catch: java.lang.Throwable -> L15
            r1.<init>(r3)     // Catch: java.lang.Throwable -> L15
            if (r4 == 0) goto L17
            r1.add(r4)     // Catch: java.lang.Throwable -> L15
            java.util.Set r3 = r4.g0()     // Catch: java.lang.Throwable -> L15
            r1.removeAll(r3)     // Catch: java.lang.Throwable -> L15
            goto L17
        L15:
            r3 = move-exception
            goto L4c
        L17:
            boolean r3 = r2.O()     // Catch: java.lang.Throwable -> L15
            if (r3 == 0) goto L49
            boolean r3 = Q(r1)     // Catch: java.lang.Throwable -> L15
            if (r3 == 0) goto L33
            ir.nasim.jI7 r3 = r2.o     // Catch: java.lang.Throwable -> L15
            boolean r3 = T(r3)     // Catch: java.lang.Throwable -> L15
            if (r3 == 0) goto L2e
            ir.nasim.jI7 r3 = r2.o     // Catch: java.lang.Throwable -> L15
            goto L4a
        L2e:
            ir.nasim.Uo5 r3 = r2.x()     // Catch: java.lang.Throwable -> L15
            goto L4a
        L33:
            boolean r3 = P(r1)     // Catch: java.lang.Throwable -> L15
            if (r3 == 0) goto L49
            ir.nasim.jI7 r3 = r2.o     // Catch: java.lang.Throwable -> L15
            boolean r3 = R(r3)     // Catch: java.lang.Throwable -> L15
            if (r3 == 0) goto L44
            ir.nasim.jI7 r3 = r2.o     // Catch: java.lang.Throwable -> L15
            goto L4a
        L44:
            ir.nasim.z13 r3 = r2.w()     // Catch: java.lang.Throwable -> L15
            goto L4a
        L49:
            r3 = 0
        L4a:
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L15
            return r3
        L4c:
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L15
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.camera.core.internal.CameraUseCaseAdapter.s(java.util.Collection, ir.nasim.eY6):ir.nasim.jI7");
    }

    private static Matrix t(Rect rect, Size size) {
        AbstractC4980Hj5.b(rect.width() > 0 && rect.height() > 0, "Cannot compute viewport crop rects zero sized sensor rect.");
        RectF rectF = new RectF(rect);
        Matrix matrix = new Matrix();
        matrix.setRectToRect(new RectF(0.0f, 0.0f, size.getWidth(), size.getHeight()), rectF, Matrix.ScaleToFit.CENTER);
        matrix.invert(matrix);
        return matrix;
    }

    private Map u(int i, InterfaceC14623iD0 interfaceC14623iD0, Collection collection, Collection collection2, Map map) {
        Rect rectC;
        boolean z;
        ArrayList arrayList = new ArrayList();
        String strB = interfaceC14623iD0.b();
        HashMap map2 = new HashMap();
        HashMap map3 = new HashMap();
        Iterator it = collection2.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            AbstractC15273jI7 abstractC15273jI7 = (AbstractC15273jI7) it.next();
            AbstractC1920a abstractC1920aA = AbstractC1920a.a(this.c.b(i, strB, abstractC15273jI7.l(), abstractC15273jI7.e()), abstractC15273jI7.l(), abstractC15273jI7.e(), ((w) AbstractC4980Hj5.g(abstractC15273jI7.d())).b(), C12398eY6.e0(abstractC15273jI7), abstractC15273jI7.d().d(), abstractC15273jI7.i().w(null));
            arrayList.add(abstractC1920aA);
            map3.put(abstractC1920aA, abstractC15273jI7);
            map2.put(abstractC15273jI7, abstractC15273jI7.d());
        }
        if (!collection.isEmpty()) {
            HashMap map4 = new HashMap();
            HashMap map5 = new HashMap();
            try {
                rectC = this.a.b().c();
            } catch (NullPointerException unused) {
                rectC = null;
            }
            C16303l27 c16303l27 = new C16303l27(interfaceC14623iD0, rectC != null ? AbstractC14447hv7.m(rectC) : null);
            Iterator it2 = collection.iterator();
            loop1: while (true) {
                z = false;
                while (it2.hasNext()) {
                    AbstractC15273jI7 abstractC15273jI72 = (AbstractC15273jI7) it2.next();
                    b bVar = (b) map.get(abstractC15273jI72);
                    C C = abstractC15273jI72.C(interfaceC14623iD0, bVar.a, bVar.b);
                    map4.put(C, abstractC15273jI72);
                    map5.put(C, c16303l27.m(C));
                    if (abstractC15273jI72.i() instanceof s) {
                        if (((s) abstractC15273jI72.i()).B() == 2) {
                            z = true;
                        }
                    }
                }
            }
            Pair pairA = this.c.a(i, strB, arrayList, map5, z, N(collection));
            for (Map.Entry entry : map4.entrySet()) {
                map2.put((AbstractC15273jI7) entry.getValue(), (w) ((Map) pairA.first).get(entry.getKey()));
            }
            for (Map.Entry entry2 : ((Map) pairA.second).entrySet()) {
                if (map3.containsKey(entry2.getKey())) {
                    map2.put((AbstractC15273jI7) map3.get(entry2.getKey()), (w) entry2.getValue());
                }
            }
        }
        return map2;
    }

    private void v(Collection collection) {
        if (J()) {
            if (L(collection)) {
                throw new IllegalArgumentException("Extensions are only supported for use with standard dynamic range.");
            }
            if (M(collection)) {
                throw new IllegalArgumentException("Extensions are not supported for use with Ultra HDR image capture.");
            }
        }
        synchronized (this.l) {
            try {
                if (!this.j.isEmpty() && M(collection)) {
                    throw new IllegalArgumentException("Ultra HDR image capture does not support for use with CameraEffect.");
                }
            } finally {
            }
        }
    }

    private C24677z13 w() {
        return new C24677z13.b().m("ImageCapture-Extra").c();
    }

    private C8112Uo5 x() {
        C8112Uo5 c8112Uo5C = new C8112Uo5.a().l("Preview-Extra").c();
        c8112Uo5C.h0(new C8112Uo5.c() { // from class: ir.nasim.PD0
            @Override // ir.nasim.C8112Uo5.c
            public final void a(Z27 z27) throws ExecutionException, InterruptedException {
                CameraUseCaseAdapter.X(z27);
            }
        });
        return c8112Uo5C;
    }

    private C12398eY6 y(Collection collection, boolean z) {
        synchronized (this.l) {
            try {
                Set setH = H(collection, z);
                if (setH.size() >= 2 || (J() && N(setH))) {
                    C12398eY6 c12398eY6 = this.p;
                    if (c12398eY6 != null && c12398eY6.g0().equals(setH)) {
                        C12398eY6 c12398eY62 = this.p;
                        Objects.requireNonNull(c12398eY62);
                        return c12398eY62;
                    }
                    if (!U(setH)) {
                        return null;
                    }
                    return new C12398eY6(this.a, this.b, this.t, this.u, setH, this.d);
                }
                return null;
            } finally {
            }
        }
    }

    public a C() {
        return this.e;
    }

    public InterfaceC14021hD0 F() {
        return this.s;
    }

    public List I() {
        ArrayList arrayList;
        synchronized (this.l) {
            arrayList = new ArrayList(this.f);
        }
        return arrayList;
    }

    public void Y(Collection collection) {
        synchronized (this.l) {
            LinkedHashSet linkedHashSet = new LinkedHashSet(this.f);
            linkedHashSet.removeAll(collection);
            InterfaceC15221jD0 interfaceC15221jD0 = this.b;
            e0(linkedHashSet, interfaceC15221jD0 != null, interfaceC15221jD0 != null);
        }
    }

    @Override // ir.nasim.HB0
    public InterfaceC14021hD0 a() {
        return this.r;
    }

    public void a0(List list) {
        synchronized (this.l) {
            this.j = list;
        }
    }

    public void c0(C22022uX7 c22022uX7) {
        synchronized (this.l) {
            this.i = c22022uX7;
        }
    }

    public void e(boolean z) {
        this.a.e(z);
    }

    void e0(Collection collection, boolean z, boolean z2) {
        Map map;
        w wVar;
        j jVarD;
        synchronized (this.l) {
            try {
                v(collection);
                if (!z && J() && N(collection)) {
                    e0(collection, true, z2);
                    return;
                }
                C12398eY6 c12398eY6Y = y(collection, z);
                AbstractC15273jI7 abstractC15273jI7S = s(collection, c12398eY6Y);
                Collection collectionR = r(collection, abstractC15273jI7S, c12398eY6Y);
                ArrayList<AbstractC15273jI7> arrayList = new ArrayList(collectionR);
                arrayList.removeAll(this.g);
                ArrayList<AbstractC15273jI7> arrayList2 = new ArrayList(collectionR);
                arrayList2.retainAll(this.g);
                ArrayList<AbstractC15273jI7> arrayList3 = new ArrayList(this.g);
                arrayList3.removeAll(collectionR);
                Map mapE = E(arrayList, this.k.j(), this.d);
                Map mapEmptyMap = Collections.emptyMap();
                try {
                    Map map2 = mapE;
                    Map mapU = u(D(), this.a.j(), arrayList, arrayList2, map2);
                    if (this.b != null) {
                        int iD = D();
                        InterfaceC15221jD0 interfaceC15221jD0 = this.b;
                        Objects.requireNonNull(interfaceC15221jD0);
                        map = mapU;
                        mapEmptyMap = u(iD, interfaceC15221jD0.j(), arrayList, arrayList2, map2);
                    } else {
                        map = mapU;
                    }
                    Map map3 = mapEmptyMap;
                    f0(map, collectionR);
                    d0(this.j, collectionR, collection);
                    Iterator it = arrayList3.iterator();
                    while (it.hasNext()) {
                        ((AbstractC15273jI7) it.next()).T(this.a);
                    }
                    this.a.i(arrayList3);
                    if (this.b != null) {
                        for (AbstractC15273jI7 abstractC15273jI7 : arrayList3) {
                            InterfaceC15221jD0 interfaceC15221jD02 = this.b;
                            Objects.requireNonNull(interfaceC15221jD02);
                            abstractC15273jI7.T(interfaceC15221jD02);
                        }
                        InterfaceC15221jD0 interfaceC15221jD03 = this.b;
                        Objects.requireNonNull(interfaceC15221jD03);
                        interfaceC15221jD03.i(arrayList3);
                    }
                    if (arrayList3.isEmpty()) {
                        for (AbstractC15273jI7 abstractC15273jI72 : arrayList2) {
                            if (map.containsKey(abstractC15273jI72) && (jVarD = (wVar = (w) map.get(abstractC15273jI72)).d()) != null && K(wVar, abstractC15273jI72.v())) {
                                abstractC15273jI72.W(jVarD);
                                if (this.m) {
                                    this.a.g(abstractC15273jI72);
                                    InterfaceC15221jD0 interfaceC15221jD04 = this.b;
                                    if (interfaceC15221jD04 != null) {
                                        Objects.requireNonNull(interfaceC15221jD04);
                                        interfaceC15221jD04.g(abstractC15273jI72);
                                    }
                                }
                            }
                        }
                    }
                    for (AbstractC15273jI7 abstractC15273jI73 : arrayList) {
                        Map map4 = map2;
                        b bVar = (b) map4.get(abstractC15273jI73);
                        Objects.requireNonNull(bVar);
                        InterfaceC15221jD0 interfaceC15221jD05 = this.b;
                        if (interfaceC15221jD05 != null) {
                            InterfaceC15221jD0 interfaceC15221jD06 = this.a;
                            Objects.requireNonNull(interfaceC15221jD05);
                            abstractC15273jI73.b(interfaceC15221jD06, interfaceC15221jD05, bVar.a, bVar.b);
                            abstractC15273jI73.V((w) AbstractC4980Hj5.g((w) map.get(abstractC15273jI73)), (w) map3.get(abstractC15273jI73));
                        } else {
                            abstractC15273jI73.b(this.a, null, bVar.a, bVar.b);
                            abstractC15273jI73.V((w) AbstractC4980Hj5.g((w) map.get(abstractC15273jI73)), null);
                        }
                        map2 = map4;
                    }
                    if (this.m) {
                        this.a.h(arrayList);
                        InterfaceC15221jD0 interfaceC15221jD07 = this.b;
                        if (interfaceC15221jD07 != null) {
                            Objects.requireNonNull(interfaceC15221jD07);
                            interfaceC15221jD07.h(arrayList);
                        }
                    }
                    Iterator it2 = arrayList.iterator();
                    while (it2.hasNext()) {
                        ((AbstractC15273jI7) it2.next()).G();
                    }
                    this.f.clear();
                    this.f.addAll(collection);
                    this.g.clear();
                    this.g.addAll(collectionR);
                    this.o = abstractC15273jI7S;
                    this.p = c12398eY6Y;
                } catch (IllegalArgumentException e) {
                    if (z || J() || this.h.c() == 2) {
                        throw e;
                    }
                    e0(collection, true, z2);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void g(Collection collection) {
        synchronized (this.l) {
            try {
                this.a.n(this.k);
                InterfaceC15221jD0 interfaceC15221jD0 = this.b;
                if (interfaceC15221jD0 != null) {
                    interfaceC15221jD0.n(this.k);
                }
                LinkedHashSet linkedHashSet = new LinkedHashSet(this.f);
                linkedHashSet.addAll(collection);
                try {
                    InterfaceC15221jD0 interfaceC15221jD02 = this.b;
                    e0(linkedHashSet, interfaceC15221jD02 != null, interfaceC15221jD02 != null);
                } catch (IllegalArgumentException e) {
                    throw new CameraException(e);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void k() {
        synchronized (this.l) {
            try {
                if (!this.m) {
                    if (!this.g.isEmpty()) {
                        this.a.n(this.k);
                        InterfaceC15221jD0 interfaceC15221jD0 = this.b;
                        if (interfaceC15221jD0 != null) {
                            interfaceC15221jD0.n(this.k);
                        }
                    }
                    this.a.h(this.g);
                    InterfaceC15221jD0 interfaceC15221jD02 = this.b;
                    if (interfaceC15221jD02 != null) {
                        interfaceC15221jD02.h(this.g);
                    }
                    Z();
                    Iterator it = this.g.iterator();
                    while (it.hasNext()) {
                        ((AbstractC15273jI7) it.next()).G();
                    }
                    this.m = true;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void z() {
        synchronized (this.l) {
            try {
                if (this.m) {
                    this.a.i(new ArrayList(this.g));
                    InterfaceC15221jD0 interfaceC15221jD0 = this.b;
                    if (interfaceC15221jD0 != null) {
                        interfaceC15221jD0.i(new ArrayList(this.g));
                    }
                    m();
                    this.m = false;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
