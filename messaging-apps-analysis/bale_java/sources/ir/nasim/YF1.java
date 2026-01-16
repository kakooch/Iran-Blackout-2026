package ir.nasim;

import android.content.Context;
import android.graphics.Point;
import android.media.AudioFormat;
import android.media.AudioManager;
import android.media.Spatializer;
import android.media.Spatializer$OnSpatializerStateChangedListener;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Pair;
import android.util.SparseArray;
import android.util.SparseBooleanArray;
import com.google.android.exoplayer2.InterfaceC2029g;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.source.TrackGroup;
import com.google.android.exoplayer2.source.TrackGroupArray;
import io.appmetrica.analytics.AppMetricaDefaultValues;
import ir.nasim.AbstractC12710f43;
import ir.nasim.AbstractC15323jO3;
import ir.nasim.C24733z7;
import ir.nasim.C6740Ot7;
import ir.nasim.InterfaceC13679ge2;
import ir.nasim.YF1;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.RandomAccess;
import livekit.org.webrtc.MediaStreamTrack;
import okhttp3.internal.ws.WebSocketProtocol;

/* loaded from: classes2.dex */
public class YF1 extends AbstractC15323jO3 {
    private static final UL4 k = UL4.a(new Comparator() { // from class: ir.nasim.PF1
        @Override // java.util.Comparator
        public final int compare(Object obj, Object obj2) {
            return YF1.P((Integer) obj, (Integer) obj2);
        }
    });
    private static final UL4 l = UL4.a(new Comparator() { // from class: ir.nasim.QF1
        @Override // java.util.Comparator
        public final int compare(Object obj, Object obj2) {
            return YF1.Q((Integer) obj, (Integer) obj2);
        }
    });
    private final Object d;
    public final Context e;
    private final InterfaceC13679ge2.b f;
    private final boolean g;
    private d h;
    private f i;
    private com.google.android.exoplayer2.audio.a j;

    /* JADX INFO: Access modifiers changed from: private */
    static final class b extends h implements Comparable {
        private final int e;
        private final boolean f;
        private final String g;
        private final d h;
        private final boolean i;
        private final int j;
        private final int k;
        private final int l;
        private final boolean m;
        private final int n;
        private final int o;
        private final boolean p;
        private final int q;
        private final int r;
        private final int s;
        private final int t;
        private final boolean u;
        private final boolean v;

        public b(int i, TrackGroup trackGroup, int i2, d dVar, int i3, boolean z, InterfaceC11281ck5 interfaceC11281ck5) {
            int i4;
            int iD;
            int iD2;
            super(i, trackGroup, i2);
            this.h = dVar;
            this.g = YF1.T(this.d.c);
            this.i = YF1.L(i3, false);
            int i5 = 0;
            while (true) {
                i4 = Integer.MAX_VALUE;
                if (i5 >= dVar.n.size()) {
                    iD = 0;
                    i5 = Integer.MAX_VALUE;
                    break;
                } else {
                    iD = YF1.D(this.d, (String) dVar.n.get(i5), false);
                    if (iD > 0) {
                        break;
                    } else {
                        i5++;
                    }
                }
            }
            this.k = i5;
            this.j = iD;
            this.l = YF1.H(this.d.e, dVar.o);
            com.google.android.exoplayer2.X x = this.d;
            int i6 = x.e;
            this.m = i6 == 0 || (i6 & 1) != 0;
            this.p = (x.d & 1) != 0;
            int i7 = x.y;
            this.q = i7;
            this.r = x.z;
            int i8 = x.h;
            this.s = i8;
            this.f = (i8 == -1 || i8 <= dVar.q) && (i7 == -1 || i7 <= dVar.p) && interfaceC11281ck5.apply(x);
            String[] strArrG0 = AbstractC9683aN7.g0();
            int i9 = 0;
            while (true) {
                if (i9 >= strArrG0.length) {
                    iD2 = 0;
                    i9 = Integer.MAX_VALUE;
                    break;
                } else {
                    iD2 = YF1.D(this.d, strArrG0[i9], false);
                    if (iD2 > 0) {
                        break;
                    } else {
                        i9++;
                    }
                }
            }
            this.n = i9;
            this.o = iD2;
            int i10 = 0;
            while (true) {
                if (i10 < dVar.r.size()) {
                    String str = this.d.l;
                    if (str != null && str.equals(dVar.r.get(i10))) {
                        i4 = i10;
                        break;
                    }
                    i10++;
                } else {
                    break;
                }
            }
            this.t = i4;
            this.u = InterfaceC24899zO5.k(i3) == 128;
            this.v = InterfaceC24899zO5.v(i3) == 64;
            this.e = p(i3, z);
        }

        public static int i(List list, List list2) {
            return ((b) Collections.max(list)).compareTo((b) Collections.max(list2));
        }

        public static AbstractC12710f43 o(int i, TrackGroup trackGroup, d dVar, int[] iArr, boolean z, InterfaceC11281ck5 interfaceC11281ck5) {
            AbstractC12710f43.a aVarL = AbstractC12710f43.L();
            for (int i2 = 0; i2 < trackGroup.a; i2++) {
                aVarL.a(new b(i, trackGroup, i2, dVar, iArr[i2], z, interfaceC11281ck5));
            }
            return aVarL.h();
        }

        private int p(int i, boolean z) {
            if (!YF1.L(i, this.h.e1)) {
                return 0;
            }
            if (!this.f && !this.h.Y0) {
                return 0;
            }
            if (YF1.L(i, false) && this.f && this.d.h != -1) {
                d dVar = this.h;
                if (!dVar.x && !dVar.w && (dVar.g1 || !z)) {
                    return 2;
                }
            }
            return 1;
        }

        @Override // ir.nasim.YF1.h
        public int a() {
            return this.e;
        }

        @Override // java.lang.Comparable
        /* renamed from: j, reason: merged with bridge method [inline-methods] */
        public int compareTo(b bVar) {
            UL4 ul4D = (this.f && this.i) ? YF1.k : YF1.k.d();
            AbstractC16277l01 abstractC16277l01F = AbstractC16277l01.j().g(this.i, bVar.i).f(Integer.valueOf(this.k), Integer.valueOf(bVar.k), UL4.b().d()).d(this.j, bVar.j).d(this.l, bVar.l).g(this.p, bVar.p).g(this.m, bVar.m).f(Integer.valueOf(this.n), Integer.valueOf(bVar.n), UL4.b().d()).d(this.o, bVar.o).g(this.f, bVar.f).f(Integer.valueOf(this.t), Integer.valueOf(bVar.t), UL4.b().d()).f(Integer.valueOf(this.s), Integer.valueOf(bVar.s), this.h.w ? YF1.k.d() : YF1.l).g(this.u, bVar.u).g(this.v, bVar.v).f(Integer.valueOf(this.q), Integer.valueOf(bVar.q), ul4D).f(Integer.valueOf(this.r), Integer.valueOf(bVar.r), ul4D);
            Integer numValueOf = Integer.valueOf(this.s);
            Integer numValueOf2 = Integer.valueOf(bVar.s);
            if (!AbstractC9683aN7.c(this.g, bVar.g)) {
                ul4D = YF1.l;
            }
            return abstractC16277l01F.f(numValueOf, numValueOf2, ul4D).i();
        }

        @Override // ir.nasim.YF1.h
        /* renamed from: q, reason: merged with bridge method [inline-methods] */
        public boolean h(b bVar) {
            int i;
            String str;
            int i2;
            d dVar = this.h;
            if ((dVar.b1 || ((i2 = this.d.y) != -1 && i2 == bVar.d.y)) && (dVar.Z0 || ((str = this.d.l) != null && TextUtils.equals(str, bVar.d.l)))) {
                d dVar2 = this.h;
                if ((dVar2.a1 || ((i = this.d.z) != -1 && i == bVar.d.z)) && (dVar2.c1 || (this.u == bVar.u && this.v == bVar.v))) {
                    return true;
                }
            }
            return false;
        }
    }

    private static final class c implements Comparable {
        private final boolean a;
        private final boolean b;

        public c(com.google.android.exoplayer2.X x, int i) {
            this.a = (x.d & 1) != 0;
            this.b = YF1.L(i, false);
        }

        @Override // java.lang.Comparable
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compareTo(c cVar) {
            return AbstractC16277l01.j().g(this.b, cVar.b).g(this.a, cVar.a).i();
        }
    }

    public static final class d extends C6740Ot7 implements InterfaceC2029g {
        private static final String A1;
        private static final String B1;
        public static final InterfaceC2029g.a C1;
        public static final d j1;
        public static final d k1;
        private static final String l1;
        private static final String m1;
        private static final String n1;
        private static final String o1;
        private static final String p1;
        private static final String q1;
        private static final String r1;
        private static final String s1;
        private static final String t1;
        private static final String u1;
        private static final String v1;
        private static final String w1;
        private static final String x1;
        private static final String y1;
        private static final String z1;
        public final boolean U0;
        public final boolean V0;
        public final boolean W0;
        public final boolean X0;
        public final boolean Y0;
        public final boolean Z0;
        public final boolean a1;
        public final boolean b1;
        public final boolean c1;
        public final boolean d1;
        public final boolean e1;
        public final boolean f1;
        public final boolean g1;
        private final SparseArray h1;
        private final SparseBooleanArray i1;

        static {
            d dVarA = new a().A();
            j1 = dVarA;
            k1 = dVarA;
            l1 = AbstractC9683aN7.r0(AppMetricaDefaultValues.DEFAULT_MAX_REPORTS_IN_DATABASE_COUNT);
            m1 = AbstractC9683aN7.r0(WebSocketProtocol.CLOSE_CLIENT_GOING_AWAY);
            n1 = AbstractC9683aN7.r0(1002);
            o1 = AbstractC9683aN7.r0(1003);
            p1 = AbstractC9683aN7.r0(1004);
            q1 = AbstractC9683aN7.r0(WebSocketProtocol.CLOSE_NO_STATUS_CODE);
            r1 = AbstractC9683aN7.r0(1006);
            s1 = AbstractC9683aN7.r0(1007);
            t1 = AbstractC9683aN7.r0(1008);
            u1 = AbstractC9683aN7.r0(1009);
            v1 = AbstractC9683aN7.r0(1010);
            w1 = AbstractC9683aN7.r0(1011);
            x1 = AbstractC9683aN7.r0(1012);
            y1 = AbstractC9683aN7.r0(1013);
            z1 = AbstractC9683aN7.r0(1014);
            A1 = AbstractC9683aN7.r0(1015);
            B1 = AbstractC9683aN7.r0(1016);
            C1 = new InterfaceC2029g.a() { // from class: ir.nasim.ZF1
                @Override // com.google.android.exoplayer2.InterfaceC2029g.a
                public final InterfaceC2029g a(Bundle bundle) {
                    return YF1.d.P(bundle);
                }
            };
        }

        private static boolean G(SparseBooleanArray sparseBooleanArray, SparseBooleanArray sparseBooleanArray2) {
            int size = sparseBooleanArray.size();
            if (sparseBooleanArray2.size() != size) {
                return false;
            }
            for (int i = 0; i < size; i++) {
                if (sparseBooleanArray2.indexOfKey(sparseBooleanArray.keyAt(i)) < 0) {
                    return false;
                }
            }
            return true;
        }

        private static boolean H(SparseArray sparseArray, SparseArray sparseArray2) {
            int size = sparseArray.size();
            if (sparseArray2.size() != size) {
                return false;
            }
            for (int i = 0; i < size; i++) {
                int iIndexOfKey = sparseArray2.indexOfKey(sparseArray.keyAt(i));
                if (iIndexOfKey < 0 || !I((Map) sparseArray.valueAt(i), (Map) sparseArray2.valueAt(iIndexOfKey))) {
                    return false;
                }
            }
            return true;
        }

        private static boolean I(Map map, Map map2) {
            if (map2.size() != map.size()) {
                return false;
            }
            for (Map.Entry entry : map.entrySet()) {
                TrackGroupArray trackGroupArray = (TrackGroupArray) entry.getKey();
                if (!map2.containsKey(trackGroupArray) || !AbstractC9683aN7.c(entry.getValue(), map2.get(trackGroupArray))) {
                    return false;
                }
            }
            return true;
        }

        public static d K(Context context) {
            return new a(context).A();
        }

        private static int[] L(SparseBooleanArray sparseBooleanArray) {
            int[] iArr = new int[sparseBooleanArray.size()];
            for (int i = 0; i < sparseBooleanArray.size(); i++) {
                iArr[i] = sparseBooleanArray.keyAt(i);
            }
            return iArr;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ d P(Bundle bundle) {
            return new a(bundle).A();
        }

        private static void Q(Bundle bundle, SparseArray sparseArray) {
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            SparseArray sparseArray2 = new SparseArray();
            for (int i = 0; i < sparseArray.size(); i++) {
                int iKeyAt = sparseArray.keyAt(i);
                for (Map.Entry entry : ((Map) sparseArray.valueAt(i)).entrySet()) {
                    e eVar = (e) entry.getValue();
                    if (eVar != null) {
                        sparseArray2.put(arrayList2.size(), eVar);
                    }
                    arrayList2.add((TrackGroupArray) entry.getKey());
                    arrayList.add(Integer.valueOf(iKeyAt));
                }
                bundle.putIntArray(v1, AbstractC8236Vc3.l(arrayList));
                bundle.putParcelableArrayList(w1, AbstractC3344Am0.d(arrayList2));
                bundle.putSparseParcelableArray(x1, AbstractC3344Am0.e(sparseArray2));
            }
        }

        @Override // ir.nasim.C6740Ot7
        /* renamed from: J, reason: merged with bridge method [inline-methods] */
        public a B() {
            return new a();
        }

        public boolean M(int i) {
            return this.i1.get(i);
        }

        public e N(int i, TrackGroupArray trackGroupArray) {
            Map map = (Map) this.h1.get(i);
            if (map != null) {
                return (e) map.get(trackGroupArray);
            }
            return null;
        }

        public boolean O(int i, TrackGroupArray trackGroupArray) {
            Map map = (Map) this.h1.get(i);
            return map != null && map.containsKey(trackGroupArray);
        }

        @Override // ir.nasim.C6740Ot7, com.google.android.exoplayer2.InterfaceC2029g
        public Bundle a() {
            Bundle bundleA = super.a();
            bundleA.putBoolean(l1, this.U0);
            bundleA.putBoolean(m1, this.V0);
            bundleA.putBoolean(n1, this.W0);
            bundleA.putBoolean(z1, this.X0);
            bundleA.putBoolean(o1, this.Y0);
            bundleA.putBoolean(p1, this.Z0);
            bundleA.putBoolean(q1, this.a1);
            bundleA.putBoolean(r1, this.b1);
            bundleA.putBoolean(A1, this.c1);
            bundleA.putBoolean(B1, this.d1);
            bundleA.putBoolean(s1, this.e1);
            bundleA.putBoolean(t1, this.f1);
            bundleA.putBoolean(u1, this.g1);
            Q(bundleA, this.h1);
            bundleA.putIntArray(y1, L(this.i1));
            return bundleA;
        }

        @Override // ir.nasim.C6740Ot7
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || d.class != obj.getClass()) {
                return false;
            }
            d dVar = (d) obj;
            return super.equals(dVar) && this.U0 == dVar.U0 && this.V0 == dVar.V0 && this.W0 == dVar.W0 && this.X0 == dVar.X0 && this.Y0 == dVar.Y0 && this.Z0 == dVar.Z0 && this.a1 == dVar.a1 && this.b1 == dVar.b1 && this.c1 == dVar.c1 && this.d1 == dVar.d1 && this.e1 == dVar.e1 && this.f1 == dVar.f1 && this.g1 == dVar.g1 && G(this.i1, dVar.i1) && H(this.h1, dVar.h1);
        }

        @Override // ir.nasim.C6740Ot7
        public int hashCode() {
            return ((((((((((((((((((((((((((super.hashCode() + 31) * 31) + (this.U0 ? 1 : 0)) * 31) + (this.V0 ? 1 : 0)) * 31) + (this.W0 ? 1 : 0)) * 31) + (this.X0 ? 1 : 0)) * 31) + (this.Y0 ? 1 : 0)) * 31) + (this.Z0 ? 1 : 0)) * 31) + (this.a1 ? 1 : 0)) * 31) + (this.b1 ? 1 : 0)) * 31) + (this.c1 ? 1 : 0)) * 31) + (this.d1 ? 1 : 0)) * 31) + (this.e1 ? 1 : 0)) * 31) + (this.f1 ? 1 : 0)) * 31) + (this.g1 ? 1 : 0);
        }

        public static final class a extends C6740Ot7.a {
            private boolean A;
            private boolean B;
            private boolean C;
            private boolean D;
            private boolean E;
            private boolean F;
            private boolean G;
            private boolean H;
            private boolean I;
            private boolean J;
            private boolean K;
            private boolean L;
            private boolean M;
            private final SparseArray N;
            private final SparseBooleanArray O;

            private static SparseArray d0(SparseArray sparseArray) {
                SparseArray sparseArray2 = new SparseArray();
                for (int i = 0; i < sparseArray.size(); i++) {
                    sparseArray2.put(sparseArray.keyAt(i), new HashMap((Map) sparseArray.valueAt(i)));
                }
                return sparseArray2;
            }

            private void e0() {
                this.A = true;
                this.B = false;
                this.C = true;
                this.D = false;
                this.E = true;
                this.F = false;
                this.G = false;
                this.H = false;
                this.I = false;
                this.J = true;
                this.K = true;
                this.L = false;
                this.M = true;
            }

            private SparseBooleanArray f0(int[] iArr) {
                if (iArr == null) {
                    return new SparseBooleanArray();
                }
                SparseBooleanArray sparseBooleanArray = new SparseBooleanArray(iArr.length);
                for (int i : iArr) {
                    sparseBooleanArray.append(i, true);
                }
                return sparseBooleanArray;
            }

            private void x0(Bundle bundle) {
                int[] intArray = bundle.getIntArray(d.v1);
                ArrayList parcelableArrayList = bundle.getParcelableArrayList(d.w1);
                AbstractC12710f43 abstractC12710f43V = parcelableArrayList == null ? AbstractC12710f43.V() : AbstractC3344Am0.b(TrackGroupArray.f, parcelableArrayList);
                SparseArray sparseParcelableArray = bundle.getSparseParcelableArray(d.x1);
                SparseArray sparseArray = sparseParcelableArray == null ? new SparseArray() : AbstractC3344Am0.c(e.h, sparseParcelableArray);
                if (intArray == null || intArray.length != abstractC12710f43V.size()) {
                    return;
                }
                for (int i = 0; i < intArray.length; i++) {
                    w0(intArray[i], (TrackGroupArray) abstractC12710f43V.get(i), (e) sparseArray.get(i));
                }
            }

            @Override // ir.nasim.C6740Ot7.a
            /* renamed from: A0, reason: merged with bridge method [inline-methods] */
            public a K(int i, int i2, boolean z) {
                super.K(i, i2, z);
                return this;
            }

            @Override // ir.nasim.C6740Ot7.a
            /* renamed from: B0, reason: merged with bridge method [inline-methods] */
            public a L(Context context, boolean z) {
                super.L(context, z);
                return this;
            }

            @Override // ir.nasim.C6740Ot7.a
            /* renamed from: b0, reason: merged with bridge method [inline-methods] */
            public d A() {
                return new d(this);
            }

            @Override // ir.nasim.C6740Ot7.a
            /* renamed from: c0, reason: merged with bridge method [inline-methods] */
            public a B(int i) {
                super.B(i);
                return this;
            }

            protected a g0(C6740Ot7 c6740Ot7) {
                super.E(c6740Ot7);
                return this;
            }

            public a h0(boolean z) {
                this.H = z;
                return this;
            }

            public a i0(boolean z) {
                this.I = z;
                return this;
            }

            public a j0(boolean z) {
                this.F = z;
                return this;
            }

            public a k0(boolean z) {
                this.G = z;
                return this;
            }

            public a l0(boolean z) {
                this.M = z;
                return this;
            }

            public a m0(boolean z) {
                this.D = z;
                return this;
            }

            public a n0(boolean z) {
                this.B = z;
                return this;
            }

            public a o0(boolean z) {
                this.C = z;
                return this;
            }

            public a p0(boolean z) {
                this.J = z;
                return this;
            }

            public a q0(boolean z) {
                this.E = z;
                return this;
            }

            public a r0(boolean z) {
                this.K = z;
                return this;
            }

            public a s0(boolean z) {
                this.A = z;
                return this;
            }

            @Override // ir.nasim.C6740Ot7.a
            /* renamed from: t0, reason: merged with bridge method [inline-methods] */
            public a F(int i) {
                super.F(i);
                return this;
            }

            @Override // ir.nasim.C6740Ot7.a
            /* renamed from: u0, reason: merged with bridge method [inline-methods] */
            public a G(C6241Mt7 c6241Mt7) {
                super.G(c6241Mt7);
                return this;
            }

            @Override // ir.nasim.C6740Ot7.a
            /* renamed from: v0, reason: merged with bridge method [inline-methods] */
            public a H(Context context) {
                super.H(context);
                return this;
            }

            public a w0(int i, TrackGroupArray trackGroupArray, e eVar) {
                Map map = (Map) this.N.get(i);
                if (map == null) {
                    map = new HashMap();
                    this.N.put(i, map);
                }
                if (map.containsKey(trackGroupArray) && AbstractC9683aN7.c(map.get(trackGroupArray), eVar)) {
                    return this;
                }
                map.put(trackGroupArray, eVar);
                return this;
            }

            @Override // ir.nasim.C6740Ot7.a
            /* renamed from: y0, reason: merged with bridge method [inline-methods] */
            public a J(int i, boolean z) {
                super.J(i, z);
                return this;
            }

            public a z0(boolean z) {
                this.L = z;
                return this;
            }

            public a() {
                this.N = new SparseArray();
                this.O = new SparseBooleanArray();
                e0();
            }

            public a(Context context) {
                super(context);
                this.N = new SparseArray();
                this.O = new SparseBooleanArray();
                e0();
            }

            private a(d dVar) {
                super(dVar);
                this.A = dVar.U0;
                this.B = dVar.V0;
                this.C = dVar.W0;
                this.D = dVar.X0;
                this.E = dVar.Y0;
                this.F = dVar.Z0;
                this.G = dVar.a1;
                this.H = dVar.b1;
                this.I = dVar.c1;
                this.J = dVar.d1;
                this.K = dVar.e1;
                this.L = dVar.f1;
                this.M = dVar.g1;
                this.N = d0(dVar.h1);
                this.O = dVar.i1.clone();
            }

            private a(Bundle bundle) {
                super(bundle);
                e0();
                d dVar = d.j1;
                s0(bundle.getBoolean(d.l1, dVar.U0));
                n0(bundle.getBoolean(d.m1, dVar.V0));
                o0(bundle.getBoolean(d.n1, dVar.W0));
                m0(bundle.getBoolean(d.z1, dVar.X0));
                q0(bundle.getBoolean(d.o1, dVar.Y0));
                j0(bundle.getBoolean(d.p1, dVar.Z0));
                k0(bundle.getBoolean(d.q1, dVar.a1));
                h0(bundle.getBoolean(d.r1, dVar.b1));
                i0(bundle.getBoolean(d.A1, dVar.c1));
                p0(bundle.getBoolean(d.B1, dVar.d1));
                r0(bundle.getBoolean(d.s1, dVar.e1));
                z0(bundle.getBoolean(d.t1, dVar.f1));
                l0(bundle.getBoolean(d.u1, dVar.g1));
                this.N = new SparseArray();
                x0(bundle);
                this.O = f0(bundle.getIntArray(d.y1));
            }
        }

        private d(a aVar) {
            super(aVar);
            this.U0 = aVar.A;
            this.V0 = aVar.B;
            this.W0 = aVar.C;
            this.X0 = aVar.D;
            this.Y0 = aVar.E;
            this.Z0 = aVar.F;
            this.a1 = aVar.G;
            this.b1 = aVar.H;
            this.c1 = aVar.I;
            this.d1 = aVar.J;
            this.e1 = aVar.K;
            this.f1 = aVar.L;
            this.g1 = aVar.M;
            this.h1 = aVar.N;
            this.i1 = aVar.O;
        }
    }

    public static final class e implements InterfaceC2029g {
        private static final String e = AbstractC9683aN7.r0(0);
        private static final String f = AbstractC9683aN7.r0(1);
        private static final String g = AbstractC9683aN7.r0(2);
        public static final InterfaceC2029g.a h = new InterfaceC2029g.a() { // from class: ir.nasim.aG1
            @Override // com.google.android.exoplayer2.InterfaceC2029g.a
            public final InterfaceC2029g a(Bundle bundle) {
                return YF1.e.c(bundle);
            }
        };
        public final int a;
        public final int[] b;
        public final int c;
        public final int d;

        public e(int i, int[] iArr, int i2) {
            this.a = i;
            int[] iArrCopyOf = Arrays.copyOf(iArr, iArr.length);
            this.b = iArrCopyOf;
            this.c = iArr.length;
            this.d = i2;
            Arrays.sort(iArrCopyOf);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ e c(Bundle bundle) {
            int i = bundle.getInt(e, -1);
            int[] intArray = bundle.getIntArray(f);
            int i2 = bundle.getInt(g, -1);
            AbstractC20011rK.a(i >= 0 && i2 >= 0);
            AbstractC20011rK.e(intArray);
            return new e(i, intArray, i2);
        }

        @Override // com.google.android.exoplayer2.InterfaceC2029g
        public Bundle a() {
            Bundle bundle = new Bundle();
            bundle.putInt(e, this.a);
            bundle.putIntArray(f, this.b);
            bundle.putInt(g, this.d);
            return bundle;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || e.class != obj.getClass()) {
                return false;
            }
            e eVar = (e) obj;
            return this.a == eVar.a && Arrays.equals(this.b, eVar.b) && this.d == eVar.d;
        }

        public int hashCode() {
            return (((this.a * 31) + Arrays.hashCode(this.b)) * 31) + this.d;
        }
    }

    private static class f {
        private final Spatializer a;
        private final boolean b;
        private Handler c;
        private Spatializer$OnSpatializerStateChangedListener d;

        class a implements Spatializer$OnSpatializerStateChangedListener {
            final /* synthetic */ YF1 a;

            a(f fVar, YF1 yf1) {
                this.a = yf1;
            }

            public void onSpatializerAvailableChanged(Spatializer spatializer, boolean z) {
                this.a.S();
            }

            public void onSpatializerEnabledChanged(Spatializer spatializer, boolean z) {
                this.a.S();
            }
        }

        private f(Spatializer spatializer) {
            this.a = spatializer;
            this.b = spatializer.getImmersiveAudioLevel() != 0;
        }

        public static f g(Context context) {
            AudioManager audioManager = (AudioManager) context.getSystemService(MediaStreamTrack.AUDIO_TRACK_KIND);
            if (audioManager == null) {
                return null;
            }
            return new f(audioManager.getSpatializer());
        }

        public boolean a(com.google.android.exoplayer2.audio.a aVar, com.google.android.exoplayer2.X x) throws IllegalArgumentException {
            AudioFormat.Builder channelMask = new AudioFormat.Builder().setEncoding(2).setChannelMask(AbstractC9683aN7.E(("audio/eac3-joc".equals(x.l) && x.y == 16) ? 12 : x.y));
            int i = x.z;
            if (i != -1) {
                channelMask.setSampleRate(i);
            }
            return this.a.canBeSpatialized(aVar.c().a, channelMask.build());
        }

        public void b(YF1 yf1, Looper looper) {
            if (this.d == null && this.c == null) {
                this.d = new a(this, yf1);
                Handler handler = new Handler(looper);
                this.c = handler;
                Spatializer spatializer = this.a;
                Objects.requireNonNull(handler);
                spatializer.addOnSpatializerStateChangedListener(new ExecutorC21836uD1(handler), this.d);
            }
        }

        public boolean c() {
            return this.a.isAvailable();
        }

        public boolean d() {
            return this.a.isEnabled();
        }

        public boolean e() {
            return this.b;
        }

        public void f() {
            Spatializer$OnSpatializerStateChangedListener spatializer$OnSpatializerStateChangedListener = this.d;
            if (spatializer$OnSpatializerStateChangedListener == null || this.c == null) {
                return;
            }
            this.a.removeOnSpatializerStateChangedListener(spatializer$OnSpatializerStateChangedListener);
            ((Handler) AbstractC9683aN7.j(this.c)).removeCallbacksAndMessages(null);
            this.c = null;
            this.d = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    static final class g extends h implements Comparable {
        private final int e;
        private final boolean f;
        private final boolean g;
        private final boolean h;
        private final int i;
        private final int j;
        private final int k;
        private final int l;
        private final boolean m;

        public g(int i, TrackGroup trackGroup, int i2, d dVar, int i3, String str) {
            int iD;
            super(i, trackGroup, i2);
            int i4 = 0;
            this.f = YF1.L(i3, false);
            int i5 = this.d.d & (~dVar.u);
            this.g = (i5 & 1) != 0;
            this.h = (i5 & 2) != 0;
            AbstractC12710f43 abstractC12710f43W = dVar.s.isEmpty() ? AbstractC12710f43.W("") : dVar.s;
            int i6 = 0;
            while (true) {
                if (i6 >= abstractC12710f43W.size()) {
                    i6 = Integer.MAX_VALUE;
                    iD = 0;
                    break;
                } else {
                    iD = YF1.D(this.d, (String) abstractC12710f43W.get(i6), dVar.v);
                    if (iD > 0) {
                        break;
                    } else {
                        i6++;
                    }
                }
            }
            this.i = i6;
            this.j = iD;
            int iH = YF1.H(this.d.e, dVar.t);
            this.k = iH;
            this.m = (this.d.e & 1088) != 0;
            int iD2 = YF1.D(this.d, str, YF1.T(str) == null);
            this.l = iD2;
            boolean z = iD > 0 || (dVar.s.isEmpty() && iH > 0) || this.g || (this.h && iD2 > 0);
            if (YF1.L(i3, dVar.e1) && z) {
                i4 = 1;
            }
            this.e = i4;
        }

        public static int i(List list, List list2) {
            return ((g) list.get(0)).compareTo((g) list2.get(0));
        }

        public static AbstractC12710f43 o(int i, TrackGroup trackGroup, d dVar, int[] iArr, String str) {
            AbstractC12710f43.a aVarL = AbstractC12710f43.L();
            for (int i2 = 0; i2 < trackGroup.a; i2++) {
                aVarL.a(new g(i, trackGroup, i2, dVar, iArr[i2], str));
            }
            return aVarL.h();
        }

        @Override // ir.nasim.YF1.h
        public int a() {
            return this.e;
        }

        @Override // java.lang.Comparable
        /* renamed from: j, reason: merged with bridge method [inline-methods] */
        public int compareTo(g gVar) {
            AbstractC16277l01 abstractC16277l01D = AbstractC16277l01.j().g(this.f, gVar.f).f(Integer.valueOf(this.i), Integer.valueOf(gVar.i), UL4.b().d()).d(this.j, gVar.j).d(this.k, gVar.k).g(this.g, gVar.g).f(Boolean.valueOf(this.h), Boolean.valueOf(gVar.h), this.j == 0 ? UL4.b() : UL4.b().d()).d(this.l, gVar.l);
            if (this.k == 0) {
                abstractC16277l01D = abstractC16277l01D.h(this.m, gVar.m);
            }
            return abstractC16277l01D.i();
        }

        @Override // ir.nasim.YF1.h
        /* renamed from: p, reason: merged with bridge method [inline-methods] */
        public boolean h(g gVar) {
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    static abstract class h {
        public final int a;
        public final TrackGroup b;
        public final int c;
        public final com.google.android.exoplayer2.X d;

        public interface a {
            List a(int i, TrackGroup trackGroup, int[] iArr);
        }

        public h(int i, TrackGroup trackGroup, int i2) {
            this.a = i;
            this.b = trackGroup;
            this.c = i2;
            this.d = trackGroup.d(i2);
        }

        public abstract int a();

        public abstract boolean h(h hVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    static final class i extends h {
        private final boolean e;
        private final d f;
        private final boolean g;
        private final boolean h;
        private final int i;
        private final int j;
        private final int k;
        private final int l;
        private final boolean m;
        private final boolean n;
        private final int o;
        private final boolean p;
        private final boolean q;
        private final int r;

        /* JADX WARN: Removed duplicated region for block: B:31:0x004b  */
        /* JADX WARN: Removed duplicated region for block: B:51:0x0079  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public i(int r5, com.google.android.exoplayer2.source.TrackGroup r6, int r7, ir.nasim.YF1.d r8, int r9, int r10, boolean r11) {
            /*
                Method dump skipped, instructions count: 246
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: ir.nasim.YF1.i.<init>(int, com.google.android.exoplayer2.source.TrackGroup, int, ir.nasim.YF1$d, int, int, boolean):void");
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static int o(i iVar, i iVar2) {
            AbstractC16277l01 abstractC16277l01G = AbstractC16277l01.j().g(iVar.h, iVar2.h).d(iVar.l, iVar2.l).g(iVar.m, iVar2.m).g(iVar.e, iVar2.e).g(iVar.g, iVar2.g).f(Integer.valueOf(iVar.k), Integer.valueOf(iVar2.k), UL4.b().d()).g(iVar.p, iVar2.p).g(iVar.q, iVar2.q);
            if (iVar.p && iVar.q) {
                abstractC16277l01G = abstractC16277l01G.d(iVar.r, iVar2.r);
            }
            return abstractC16277l01G.i();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static int p(i iVar, i iVar2) {
            UL4 ul4D = (iVar.e && iVar.h) ? YF1.k : YF1.k.d();
            return AbstractC16277l01.j().f(Integer.valueOf(iVar.i), Integer.valueOf(iVar2.i), iVar.f.w ? YF1.k.d() : YF1.l).f(Integer.valueOf(iVar.j), Integer.valueOf(iVar2.j), ul4D).f(Integer.valueOf(iVar.i), Integer.valueOf(iVar2.i), ul4D).i();
        }

        public static int q(List list, List list2) {
            return AbstractC16277l01.j().f((i) Collections.max(list, new Comparator() { // from class: ir.nasim.iG1
                @Override // java.util.Comparator
                public final int compare(Object obj, Object obj2) {
                    return YF1.i.o((YF1.i) obj, (YF1.i) obj2);
                }
            }), (i) Collections.max(list2, new Comparator() { // from class: ir.nasim.iG1
                @Override // java.util.Comparator
                public final int compare(Object obj, Object obj2) {
                    return YF1.i.o((YF1.i) obj, (YF1.i) obj2);
                }
            }), new Comparator() { // from class: ir.nasim.iG1
                @Override // java.util.Comparator
                public final int compare(Object obj, Object obj2) {
                    return YF1.i.o((YF1.i) obj, (YF1.i) obj2);
                }
            }).d(list.size(), list2.size()).f((i) Collections.max(list, new Comparator() { // from class: ir.nasim.jG1
                @Override // java.util.Comparator
                public final int compare(Object obj, Object obj2) {
                    return YF1.i.p((YF1.i) obj, (YF1.i) obj2);
                }
            }), (i) Collections.max(list2, new Comparator() { // from class: ir.nasim.jG1
                @Override // java.util.Comparator
                public final int compare(Object obj, Object obj2) {
                    return YF1.i.p((YF1.i) obj, (YF1.i) obj2);
                }
            }), new Comparator() { // from class: ir.nasim.jG1
                @Override // java.util.Comparator
                public final int compare(Object obj, Object obj2) {
                    return YF1.i.p((YF1.i) obj, (YF1.i) obj2);
                }
            }).i();
        }

        public static AbstractC12710f43 r(int i, TrackGroup trackGroup, d dVar, int[] iArr, int i2) {
            int iE = YF1.E(trackGroup, dVar.i, dVar.j, dVar.k);
            AbstractC12710f43.a aVarL = AbstractC12710f43.L();
            for (int i3 = 0; i3 < trackGroup.a; i3++) {
                int iG = trackGroup.d(i3).g();
                aVarL.a(new i(i, trackGroup, i3, dVar, iArr[i3], i2, iE == Integer.MAX_VALUE || (iG != -1 && iG <= iE)));
            }
            return aVarL.h();
        }

        private int s(int i, int i2) {
            if ((this.d.e & 16384) != 0 || !YF1.L(i, this.f.e1)) {
                return 0;
            }
            if (!this.e && !this.f.U0) {
                return 0;
            }
            if (YF1.L(i, false) && this.g && this.e && this.d.h != -1) {
                d dVar = this.f;
                if (!dVar.x && !dVar.w && (i & i2) != 0) {
                    return 2;
                }
            }
            return 1;
        }

        @Override // ir.nasim.YF1.h
        public int a() {
            return this.o;
        }

        @Override // ir.nasim.YF1.h
        /* renamed from: t, reason: merged with bridge method [inline-methods] */
        public boolean h(i iVar) {
            return (this.n || AbstractC9683aN7.c(this.d.l, iVar.d.l)) && (this.f.X0 || (this.p == iVar.p && this.q == iVar.q));
        }
    }

    public YF1(Context context) {
        this(context, new C24733z7.b());
    }

    private static void A(AbstractC15323jO3.a aVar, d dVar, InterfaceC13679ge2.a[] aVarArr) {
        int iD = aVar.d();
        for (int i2 = 0; i2 < iD; i2++) {
            TrackGroupArray trackGroupArrayF = aVar.f(i2);
            if (dVar.O(i2, trackGroupArrayF)) {
                e eVarN = dVar.N(i2, trackGroupArrayF);
                aVarArr[i2] = (eVarN == null || eVarN.b.length == 0) ? null : new InterfaceC13679ge2.a(trackGroupArrayF.c(eVarN.a), eVarN.b, eVarN.d);
            }
        }
    }

    private static void B(AbstractC15323jO3.a aVar, C6740Ot7 c6740Ot7, InterfaceC13679ge2.a[] aVarArr) {
        int iD = aVar.d();
        HashMap map = new HashMap();
        for (int i2 = 0; i2 < iD; i2++) {
            C(aVar.f(i2), c6740Ot7, map);
        }
        C(aVar.h(), c6740Ot7, map);
        for (int i3 = 0; i3 < iD; i3++) {
            C6241Mt7 c6241Mt7 = (C6241Mt7) map.get(Integer.valueOf(aVar.e(i3)));
            if (c6241Mt7 != null) {
                aVarArr[i3] = (c6241Mt7.b.isEmpty() || aVar.f(i3).d(c6241Mt7.a) == -1) ? null : new InterfaceC13679ge2.a(c6241Mt7.a, AbstractC8236Vc3.l(c6241Mt7.b));
            }
        }
    }

    private static void C(TrackGroupArray trackGroupArray, C6740Ot7 c6740Ot7, Map map) {
        C6241Mt7 c6241Mt7;
        for (int i2 = 0; i2 < trackGroupArray.a; i2++) {
            C6241Mt7 c6241Mt72 = (C6241Mt7) c6740Ot7.y.get(trackGroupArray.c(i2));
            if (c6241Mt72 != null && ((c6241Mt7 = (C6241Mt7) map.get(Integer.valueOf(c6241Mt72.c()))) == null || (c6241Mt7.b.isEmpty() && !c6241Mt72.b.isEmpty()))) {
                map.put(Integer.valueOf(c6241Mt72.c()), c6241Mt72);
            }
        }
    }

    protected static int D(com.google.android.exoplayer2.X x, String str, boolean z) {
        if (!TextUtils.isEmpty(str) && str.equals(x.c)) {
            return 4;
        }
        String strT = T(str);
        String strT2 = T(x.c);
        if (strT2 == null || strT == null) {
            return (z && strT2 == null) ? 1 : 0;
        }
        if (strT2.startsWith(strT) || strT.startsWith(strT2)) {
            return 3;
        }
        return AbstractC9683aN7.S0(strT2, "-")[0].equals(AbstractC9683aN7.S0(strT, "-")[0]) ? 2 : 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int E(TrackGroup trackGroup, int i2, int i3, boolean z) {
        int i4;
        int i5 = Integer.MAX_VALUE;
        if (i2 != Integer.MAX_VALUE && i3 != Integer.MAX_VALUE) {
            for (int i6 = 0; i6 < trackGroup.a; i6++) {
                com.google.android.exoplayer2.X xD = trackGroup.d(i6);
                int i7 = xD.q;
                if (i7 > 0 && (i4 = xD.r) > 0) {
                    Point pointF = F(z, i2, i3, i7, i4);
                    int i8 = xD.q;
                    int i9 = xD.r;
                    int i10 = i8 * i9;
                    if (i8 >= ((int) (pointF.x * 0.98f)) && i9 >= ((int) (pointF.y * 0.98f)) && i10 < i5) {
                        i5 = i10;
                    }
                }
            }
        }
        return i5;
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x000f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static android.graphics.Point F(boolean r3, int r4, int r5, int r6, int r7) {
        /*
            if (r3 == 0) goto Lf
            r3 = 0
            r0 = 1
            if (r6 <= r7) goto L8
            r1 = r0
            goto L9
        L8:
            r1 = r3
        L9:
            if (r4 <= r5) goto Lc
            r3 = r0
        Lc:
            if (r1 == r3) goto Lf
            goto L12
        Lf:
            r2 = r5
            r5 = r4
            r4 = r2
        L12:
            int r3 = r6 * r4
            int r0 = r7 * r5
            if (r3 < r0) goto L22
            android.graphics.Point r3 = new android.graphics.Point
            int r4 = ir.nasim.AbstractC9683aN7.l(r0, r6)
            r3.<init>(r5, r4)
            return r3
        L22:
            android.graphics.Point r5 = new android.graphics.Point
            int r3 = ir.nasim.AbstractC9683aN7.l(r3, r7)
            r5.<init>(r3, r4)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.YF1.F(boolean, int, int, int, int):android.graphics.Point");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int H(int i2, int i3) {
        if (i2 == 0 || i2 != i3) {
            return Integer.bitCount(i2 & i3);
        }
        return Integer.MAX_VALUE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int I(String str) {
        if (str == null) {
            return 0;
        }
        switch (str) {
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean J(com.google.android.exoplayer2.X x) {
        boolean z;
        f fVar;
        f fVar2;
        synchronized (this.d) {
            try {
                if (this.h.d1 && !this.g && x.y > 2 && (!K(x) || (AbstractC9683aN7.a >= 32 && (fVar2 = this.i) != null && fVar2.e()))) {
                    z = AbstractC9683aN7.a >= 32 && (fVar = this.i) != null && fVar.e() && this.i.c() && this.i.d() && this.i.a(this.j, x);
                }
            } finally {
            }
        }
        return z;
    }

    private static boolean K(com.google.android.exoplayer2.X x) {
        String str = x.l;
        if (str == null) {
            return false;
        }
        str.hashCode();
        switch (str) {
        }
        return false;
    }

    protected static boolean L(int i2, boolean z) {
        int iF = InterfaceC24899zO5.F(i2);
        return iF == 4 || (z && iF == 3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ List M(d dVar, boolean z, int i2, TrackGroup trackGroup, int[] iArr) {
        return b.o(i2, trackGroup, dVar, iArr, z, new InterfaceC11281ck5() { // from class: ir.nasim.XF1
            @Override // ir.nasim.InterfaceC11281ck5
            public final boolean apply(Object obj) {
                return this.a.J((com.google.android.exoplayer2.X) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ List N(d dVar, String str, int i2, TrackGroup trackGroup, int[] iArr) {
        return g.o(i2, trackGroup, dVar, iArr, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ List O(d dVar, int[] iArr, int i2, TrackGroup trackGroup, int[] iArr2) {
        return i.r(i2, trackGroup, dVar, iArr2, iArr[i2]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ int P(Integer num, Integer num2) {
        if (num.intValue() == -1) {
            return num2.intValue() == -1 ? 0 : -1;
        }
        if (num2.intValue() == -1) {
            return 1;
        }
        return num.intValue() - num2.intValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ int Q(Integer num, Integer num2) {
        return 0;
    }

    private static void R(AbstractC15323jO3.a aVar, int[][][] iArr, AO5[] ao5Arr, InterfaceC13679ge2[] interfaceC13679ge2Arr) {
        boolean z;
        boolean z2 = false;
        int i2 = -1;
        int i3 = -1;
        for (int i4 = 0; i4 < aVar.d(); i4++) {
            int iE = aVar.e(i4);
            InterfaceC13679ge2 interfaceC13679ge2 = interfaceC13679ge2Arr[i4];
            if ((iE == 1 || iE == 2) && interfaceC13679ge2 != null && U(iArr[i4], aVar.f(i4), interfaceC13679ge2)) {
                if (iE == 1) {
                    if (i3 != -1) {
                        z = false;
                        break;
                    }
                    i3 = i4;
                } else {
                    if (i2 != -1) {
                        z = false;
                        break;
                    }
                    i2 = i4;
                }
            }
        }
        z = true;
        if (i3 != -1 && i2 != -1) {
            z2 = true;
        }
        if (z && z2) {
            AO5 ao5 = new AO5(true);
            ao5Arr[i3] = ao5;
            ao5Arr[i2] = ao5;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void S() {
        boolean z;
        f fVar;
        synchronized (this.d) {
            try {
                z = this.h.d1 && !this.g && AbstractC9683aN7.a >= 32 && (fVar = this.i) != null && fVar.e();
            } catch (Throwable th) {
                throw th;
            }
        }
        if (z) {
            d();
        }
    }

    protected static String T(String str) {
        if (TextUtils.isEmpty(str) || TextUtils.equals(str, "und")) {
            return null;
        }
        return str;
    }

    private static boolean U(int[][] iArr, TrackGroupArray trackGroupArray, InterfaceC13679ge2 interfaceC13679ge2) {
        if (interfaceC13679ge2 == null) {
            return false;
        }
        int iD = trackGroupArray.d(interfaceC13679ge2.l());
        for (int i2 = 0; i2 < interfaceC13679ge2.length(); i2++) {
            if (InterfaceC24899zO5.o(iArr[iD][interfaceC13679ge2.g(i2)]) != 32) {
                return false;
            }
        }
        return true;
    }

    private Pair Z(int i2, AbstractC15323jO3.a aVar, int[][][] iArr, h.a aVar2, Comparator comparator) {
        int i3;
        RandomAccess randomAccessW;
        AbstractC15323jO3.a aVar3 = aVar;
        ArrayList arrayList = new ArrayList();
        int iD = aVar.d();
        int i4 = 0;
        while (i4 < iD) {
            if (i2 == aVar3.e(i4)) {
                TrackGroupArray trackGroupArrayF = aVar3.f(i4);
                for (int i5 = 0; i5 < trackGroupArrayF.a; i5++) {
                    TrackGroup trackGroupC = trackGroupArrayF.c(i5);
                    List listA = aVar2.a(i4, trackGroupC, iArr[i4][i5]);
                    boolean[] zArr = new boolean[trackGroupC.a];
                    int i6 = 0;
                    while (i6 < trackGroupC.a) {
                        h hVar = (h) listA.get(i6);
                        int iA = hVar.a();
                        if (zArr[i6] || iA == 0) {
                            i3 = iD;
                        } else {
                            if (iA == 1) {
                                randomAccessW = AbstractC12710f43.W(hVar);
                                i3 = iD;
                            } else {
                                ArrayList arrayList2 = new ArrayList();
                                arrayList2.add(hVar);
                                int i7 = i6 + 1;
                                while (i7 < trackGroupC.a) {
                                    h hVar2 = (h) listA.get(i7);
                                    int i8 = iD;
                                    if (hVar2.a() == 2 && hVar.h(hVar2)) {
                                        arrayList2.add(hVar2);
                                        zArr[i7] = true;
                                    }
                                    i7++;
                                    iD = i8;
                                }
                                i3 = iD;
                                randomAccessW = arrayList2;
                            }
                            arrayList.add(randomAccessW);
                        }
                        i6++;
                        iD = i3;
                    }
                }
            }
            i4++;
            aVar3 = aVar;
            iD = iD;
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        List list = (List) Collections.max(arrayList, comparator);
        int[] iArr2 = new int[list.size()];
        for (int i9 = 0; i9 < list.size(); i9++) {
            iArr2[i9] = ((h) list.get(i9)).c;
        }
        h hVar3 = (h) list.get(0);
        return Pair.create(new InterfaceC13679ge2.a(hVar3.b, iArr2), Integer.valueOf(hVar3.a));
    }

    private void b0(d dVar) {
        boolean z;
        AbstractC20011rK.e(dVar);
        synchronized (this.d) {
            z = !this.h.equals(dVar);
            this.h = dVar;
        }
        if (z) {
            if (dVar.d1 && this.e == null) {
                AbstractC18815pI3.k("DefaultTrackSelector", "Audio channel count constraints cannot be applied without reference to Context. Build the track selector instance with one of the non-deprecated constructors that take a Context argument.");
            }
            d();
        }
    }

    @Override // ir.nasim.AbstractC7218Qt7
    /* renamed from: G, reason: merged with bridge method [inline-methods] */
    public d b() {
        d dVar;
        synchronized (this.d) {
            dVar = this.h;
        }
        return dVar;
    }

    protected InterfaceC13679ge2.a[] V(AbstractC15323jO3.a aVar, int[][][] iArr, int[] iArr2, d dVar) {
        String str;
        int iD = aVar.d();
        InterfaceC13679ge2.a[] aVarArr = new InterfaceC13679ge2.a[iD];
        Pair pairA0 = a0(aVar, iArr, iArr2, dVar);
        if (pairA0 != null) {
            aVarArr[((Integer) pairA0.second).intValue()] = (InterfaceC13679ge2.a) pairA0.first;
        }
        Pair pairW = W(aVar, iArr, iArr2, dVar);
        if (pairW != null) {
            aVarArr[((Integer) pairW.second).intValue()] = (InterfaceC13679ge2.a) pairW.first;
        }
        if (pairW == null) {
            str = null;
        } else {
            Object obj = pairW.first;
            str = ((InterfaceC13679ge2.a) obj).a.d(((InterfaceC13679ge2.a) obj).b[0]).c;
        }
        Pair pairY = Y(aVar, iArr, dVar, str);
        if (pairY != null) {
            aVarArr[((Integer) pairY.second).intValue()] = (InterfaceC13679ge2.a) pairY.first;
        }
        for (int i2 = 0; i2 < iD; i2++) {
            int iE = aVar.e(i2);
            if (iE != 2 && iE != 1 && iE != 3) {
                aVarArr[i2] = X(iE, aVar.f(i2), iArr[i2], dVar);
            }
        }
        return aVarArr;
    }

    protected Pair W(AbstractC15323jO3.a aVar, int[][][] iArr, int[] iArr2, final d dVar) {
        final boolean z = false;
        int i2 = 0;
        while (true) {
            if (i2 < aVar.d()) {
                if (2 == aVar.e(i2) && aVar.f(i2).a > 0) {
                    z = true;
                    break;
                }
                i2++;
            } else {
                break;
            }
        }
        return Z(1, aVar, iArr, new h.a() { // from class: ir.nasim.TF1
            @Override // ir.nasim.YF1.h.a
            public final List a(int i3, TrackGroup trackGroup, int[] iArr3) {
                return this.a.M(dVar, z, i3, trackGroup, iArr3);
            }
        }, new Comparator() { // from class: ir.nasim.UF1
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                return YF1.b.i((List) obj, (List) obj2);
            }
        });
    }

    protected InterfaceC13679ge2.a X(int i2, TrackGroupArray trackGroupArray, int[][] iArr, d dVar) {
        TrackGroup trackGroup = null;
        c cVar = null;
        int i3 = 0;
        for (int i4 = 0; i4 < trackGroupArray.a; i4++) {
            TrackGroup trackGroupC = trackGroupArray.c(i4);
            int[] iArr2 = iArr[i4];
            for (int i5 = 0; i5 < trackGroupC.a; i5++) {
                if (L(iArr2[i5], dVar.e1)) {
                    c cVar2 = new c(trackGroupC.d(i5), iArr2[i5]);
                    if (cVar == null || cVar2.compareTo(cVar) > 0) {
                        trackGroup = trackGroupC;
                        i3 = i5;
                        cVar = cVar2;
                    }
                }
            }
        }
        if (trackGroup == null) {
            return null;
        }
        return new InterfaceC13679ge2.a(trackGroup, i3);
    }

    protected Pair Y(AbstractC15323jO3.a aVar, int[][][] iArr, final d dVar, final String str) {
        return Z(3, aVar, iArr, new h.a() { // from class: ir.nasim.VF1
            @Override // ir.nasim.YF1.h.a
            public final List a(int i2, TrackGroup trackGroup, int[] iArr2) {
                return YF1.N(dVar, str, i2, trackGroup, iArr2);
            }
        }, new Comparator() { // from class: ir.nasim.WF1
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                return YF1.g.i((List) obj, (List) obj2);
            }
        });
    }

    protected Pair a0(AbstractC15323jO3.a aVar, int[][][] iArr, final int[] iArr2, final d dVar) {
        return Z(2, aVar, iArr, new h.a() { // from class: ir.nasim.RF1
            @Override // ir.nasim.YF1.h.a
            public final List a(int i2, TrackGroup trackGroup, int[] iArr3) {
                return YF1.O(dVar, iArr2, i2, trackGroup, iArr3);
            }
        }, new Comparator() { // from class: ir.nasim.SF1
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                return YF1.i.q((List) obj, (List) obj2);
            }
        });
    }

    @Override // ir.nasim.AbstractC7218Qt7
    public boolean e() {
        return true;
    }

    @Override // ir.nasim.AbstractC7218Qt7
    public void g() {
        f fVar;
        synchronized (this.d) {
            try {
                if (AbstractC9683aN7.a >= 32 && (fVar = this.i) != null) {
                    fVar.f();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        super.g();
    }

    @Override // ir.nasim.AbstractC7218Qt7
    public void i(com.google.android.exoplayer2.audio.a aVar) {
        boolean z;
        synchronized (this.d) {
            z = !this.j.equals(aVar);
            this.j = aVar;
        }
        if (z) {
            S();
        }
    }

    @Override // ir.nasim.AbstractC7218Qt7
    public void j(C6740Ot7 c6740Ot7) {
        if (c6740Ot7 instanceof d) {
            b0((d) c6740Ot7);
        }
        b0(new d.a().g0(c6740Ot7).A());
    }

    @Override // ir.nasim.AbstractC15323jO3
    protected final Pair n(AbstractC15323jO3.a aVar, int[][][] iArr, int[] iArr2, MediaSource.MediaPeriodId mediaPeriodId, com.google.android.exoplayer2.J0 j0) {
        d dVar;
        f fVar;
        synchronized (this.d) {
            try {
                dVar = this.h;
                if (dVar.d1 && AbstractC9683aN7.a >= 32 && (fVar = this.i) != null) {
                    fVar.b(this, (Looper) AbstractC20011rK.i(Looper.myLooper()));
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        int iD = aVar.d();
        InterfaceC13679ge2.a[] aVarArrV = V(aVar, iArr, iArr2, dVar);
        B(aVar, dVar, aVarArrV);
        A(aVar, dVar, aVarArrV);
        for (int i2 = 0; i2 < iD; i2++) {
            int iE = aVar.e(i2);
            if (dVar.M(i2) || dVar.z.contains(Integer.valueOf(iE))) {
                aVarArrV[i2] = null;
            }
        }
        InterfaceC13679ge2[] interfaceC13679ge2ArrA = this.f.a(aVarArrV, a(), mediaPeriodId, j0);
        AO5[] ao5Arr = new AO5[iD];
        for (int i3 = 0; i3 < iD; i3++) {
            ao5Arr[i3] = (dVar.M(i3) || dVar.z.contains(Integer.valueOf(aVar.e(i3))) || (aVar.e(i3) != -2 && interfaceC13679ge2ArrA[i3] == null)) ? null : AO5.b;
        }
        if (dVar.f1) {
            R(aVar, iArr, ao5Arr, interfaceC13679ge2ArrA);
        }
        return Pair.create(ao5Arr, interfaceC13679ge2ArrA);
    }

    public YF1(Context context, InterfaceC13679ge2.b bVar) {
        this(context, d.K(context), bVar);
    }

    public YF1(Context context, C6740Ot7 c6740Ot7, InterfaceC13679ge2.b bVar) {
        this(c6740Ot7, bVar, context);
    }

    private YF1(C6740Ot7 c6740Ot7, InterfaceC13679ge2.b bVar, Context context) {
        this.d = new Object();
        this.e = context != null ? context.getApplicationContext() : null;
        this.f = bVar;
        if (c6740Ot7 instanceof d) {
            this.h = (d) c6740Ot7;
        } else {
            this.h = (context == null ? d.j1 : d.K(context)).B().g0(c6740Ot7).A();
        }
        this.j = com.google.android.exoplayer2.audio.a.g;
        boolean z = context != null && AbstractC9683aN7.x0(context);
        this.g = z;
        if (!z && context != null && AbstractC9683aN7.a >= 32) {
            this.i = f.g(context);
        }
        if (this.h.d1 && context == null) {
            AbstractC18815pI3.k("DefaultTrackSelector", "Audio channel count constraints cannot be applied without reference to Context. Build the track selector instance with one of the non-deprecated constructors that take a Context argument.");
        }
    }
}
