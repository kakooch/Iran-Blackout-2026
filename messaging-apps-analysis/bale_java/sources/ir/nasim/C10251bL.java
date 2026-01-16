package ir.nasim;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* renamed from: ir.nasim.bL, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
class C10251bL extends AbstractC17647nK {
    private final YB3 k;
    private final InterfaceC17311ml0 l;

    /* renamed from: ir.nasim.bL$a */
    public static class a {
        private List a;

        public a(List list) {
            this.a = list;
        }

        public List a() {
            return this.a;
        }
    }

    /* renamed from: ir.nasim.bL$b */
    public static class b {
    }

    /* renamed from: ir.nasim.bL$c */
    public static class c {
        private d a;

        public c(d dVar) {
            this.a = dVar;
        }

        public d a() {
            return this.a;
        }
    }

    /* renamed from: ir.nasim.bL$d */
    public interface d {
        void a(List list);
    }

    /* renamed from: ir.nasim.bL$e */
    public static class e {
        private String a;
        private Long b;
        private int c;
        private GB3 d;

        public e(String str, Long l, int i, GB3 gb3) {
            this.a = str;
            this.b = l;
            this.c = i;
            this.d = gb3;
        }

        public GB3 a() {
            return this.d;
        }

        public int b() {
            return this.c;
        }

        public String c() {
            return this.a;
        }

        public Long d() {
            return this.b;
        }
    }

    /* renamed from: ir.nasim.bL$f */
    public static class f {
        private Long a;
        private int b;
        private GB3 c;

        public f(Long l, int i, GB3 gb3) {
            this.a = l;
            this.b = i;
            this.c = gb3;
        }

        public GB3 a() {
            return this.c;
        }

        public Long b() {
            return this.a;
        }

        public int c() {
            return this.b;
        }
    }

    /* renamed from: ir.nasim.bL$g */
    public static class g {
        private i a;

        public g(i iVar) {
            this.a = iVar;
        }

        public i a() {
            return this.a;
        }
    }

    /* renamed from: ir.nasim.bL$h */
    public static class h {
        private String a;
        private i b;

        public h(String str, i iVar) {
            this.a = str;
            this.b = iVar;
        }
    }

    /* renamed from: ir.nasim.bL$i */
    public interface i {
        void a(int i);
    }

    /* renamed from: ir.nasim.bL$j */
    public static class j {
        private String a;
        private Long b;
        private int c;
        private GB3 d;

        public j(String str, Long l, int i, GB3 gb3) {
            this.a = str;
            this.b = l;
            this.c = i;
            this.d = gb3;
        }

        public GB3 a() {
            return this.d;
        }

        public int b() {
            return this.c;
        }

        public String c() {
            return this.a;
        }

        public Long d() {
            return this.b;
        }
    }

    /* renamed from: ir.nasim.bL$k */
    public static class k {
        private o a;

        public k(o oVar) {
            this.a = oVar;
        }

        public o a() {
            return this.a;
        }
    }

    /* renamed from: ir.nasim.bL$l */
    public static class l {
        private long a;
        private o b;

        public l(long j, o oVar) {
            this.a = j;
            this.b = oVar;
        }

        public o a() {
            return this.b;
        }

        public long b() {
            return this.a;
        }
    }

    /* renamed from: ir.nasim.bL$m */
    public static class m {
        private Long a;
        private o b;
        private boolean c;

        public m(Long l, boolean z, o oVar) {
            this.a = l;
            this.b = oVar;
            this.c = z;
        }

        public o a() {
            return this.b;
        }

        public Boolean b() {
            return Boolean.valueOf(this.c);
        }

        public long c() {
            return this.a.longValue();
        }
    }

    /* renamed from: ir.nasim.bL$n */
    public static class n {
        private Long a;
        private Long b;
        private o c;

        public n(Long l, Long l2, o oVar) {
            this.a = l;
            this.b = l2;
            this.c = oVar;
        }

        public o a() {
            return this.c;
        }

        public Long b() {
            return this.b;
        }

        public long c() {
            return this.a.longValue();
        }
    }

    /* renamed from: ir.nasim.bL$o */
    public interface o {
        void a(AbstractC17902nl0 abstractC17902nl0);
    }

    /* renamed from: ir.nasim.bL$p */
    public static class p {
        private String a;
        private int b;
        private int c;
        private GB3 d;

        public p(String str, int i, int i2, GB3 gb3) {
            this.a = str;
            this.b = i;
            this.c = i2;
            this.d = gb3;
        }

        public GB3 a() {
            return this.d;
        }

        public int b() {
            return this.c;
        }

        public int c() {
            return this.b;
        }

        public String d() {
            return this.a;
        }
    }

    /* renamed from: ir.nasim.bL$q */
    public static class q {
        private String a;
        private Long b;
        private int c;
        private EnumC24659yz5 d;
        private r e;

        public q(String str, Long l, int i, EnumC24659yz5 enumC24659yz5, r rVar) {
            this.a = str;
            this.b = l;
            this.c = i;
            this.d = enumC24659yz5;
            this.e = rVar;
        }

        public r e() {
            return this.e;
        }
    }

    /* renamed from: ir.nasim.bL$r */
    public interface r {
        void a(List list);
    }

    /* renamed from: ir.nasim.bL$s */
    public static class s {
        private o a;

        public s(o oVar) {
            this.a = oVar;
        }

        public o a() {
            return this.a;
        }
    }

    /* renamed from: ir.nasim.bL$t */
    public static class t {
        private long[] a;

        public t(long[] jArr) {
            this.a = jArr;
        }

        public long[] a() {
            return this.a;
        }
    }

    /* renamed from: ir.nasim.bL$u */
    public static class u implements InterfaceC15283jK {
        private final long a;
        private final EnumC24659yz5 b;

        public u(long j, EnumC24659yz5 enumC24659yz5) {
            this.a = j;
            this.b = enumC24659yz5;
        }
    }

    /* renamed from: ir.nasim.bL$v */
    public static class v {
        private List a;

        public v(List list) {
            this.a = list;
        }

        public List a() {
            return this.a;
        }
    }

    public C10251bL(YB3 yb3, InterfaceC17311ml0 interfaceC17311ml0) {
        this.k = yb3;
        this.l = interfaceC17311ml0;
    }

    private void J(GB3 gb3, List list) {
        if (list.size() == 0) {
            gb3.a(list, 0L, 0L);
            return;
        }
        long j2 = ((HB3) ((AbstractC17902nl0) list.get(0))).j();
        Iterator it = list.iterator();
        long j3 = j2;
        long j4 = j3;
        while (it.hasNext()) {
            long j5 = ((HB3) ((AbstractC17902nl0) it.next())).j();
            if (j3 < j5) {
                j3 = j5;
            }
            if (j4 > j5) {
                j4 = j5;
            }
        }
        gb3.a(list, j3, j4);
    }

    private ArrayList L(List list) {
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            try {
                arrayList.add(AbstractC16720ll0.b((AbstractC17902nl0) this.l.a(), ((IB3) it.next()).a()));
            } catch (Exception e2) {
                C19406qI3.c("AsyncStorageActor", "Error in convertList on parse: " + e2.getMessage(), e2);
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void M(long j2, EnumC24659yz5 enumC24659yz5, C7234Qv5 c7234Qv5) {
        List listQ = this.k.q(j2, enumC24659yz5);
        this.k.i(j2, enumC24659yz5);
        c7234Qv5.b(listQ);
    }

    private void V(long j2, boolean z, o oVar) {
        IB3 ib3M = this.k.m(Long.valueOf(j2), Boolean.valueOf(z));
        if (ib3M == null) {
            oVar.a(null);
            return;
        }
        try {
            oVar.a(AbstractC16720ll0.b((AbstractC17902nl0) this.l.a(), ib3M.a()));
        } catch (IOException e2) {
            C19406qI3.c("AsyncStorageActor", "Error in loadItemBySortKey on parse: " + e2.getMessage(), e2);
            oVar.a(null);
        }
    }

    private void W(long j2, long j3, o oVar) {
        IB3 ib3K = this.k.k(Long.valueOf(j2), Long.valueOf(j3));
        if (ib3K == null) {
            oVar.a(null);
            return;
        }
        try {
            oVar.a(AbstractC16720ll0.b((AbstractC17902nl0) this.l.a(), ib3K.a()));
        } catch (IOException e2) {
            C19406qI3.c("AsyncStorageActor", "Error in loadItemBySortKeyAndRid on parse: " + e2.getMessage(), e2);
            oVar.a(null);
        }
    }

    private void Y(String str, Long l2, int i2, EnumC24659yz5 enumC24659yz5, r rVar) {
        rVar.a(L(this.k.r(str, l2.longValue(), enumC24659yz5, i2, false)));
    }

    @Override // ir.nasim.AbstractC17647nK
    public C6517Nv5 G(Object obj) {
        if (!(obj instanceof u)) {
            return super.G(obj);
        }
        u uVar = (u) obj;
        return b0(uVar.a, uVar.b);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void I(List list) {
        if (list.size() == 1) {
            AbstractC17902nl0 abstractC17902nl0 = (AbstractC17902nl0) list.get(0);
            HB3 hb3 = (HB3) abstractC17902nl0;
            this.k.j(new IB3(hb3.a(), hb3.j(), hb3.p(), abstractC17902nl0.toByteArray()));
        } else if (list.size() > 0) {
            ArrayList arrayList = new ArrayList();
            Iterator it = list.iterator();
            while (it.hasNext()) {
                AbstractC17902nl0 abstractC17902nl02 = (AbstractC17902nl0) it.next();
                HB3 hb32 = (HB3) abstractC17902nl02;
                arrayList.add(new IB3(hb32.a(), hb32.j(), hb32.p(), abstractC17902nl02.toByteArray()));
            }
            this.k.f(arrayList);
        }
    }

    public void K() {
        this.k.clear();
    }

    public void N(d dVar) {
        dVar.a(L(this.k.o()));
    }

    public void O(String str, Long l2, int i2, GB3 gb3) {
        J(gb3, str == null ? L(this.k.a(l2, i2, false)) : L(this.k.p(str, l2, i2)));
    }

    public void P(Long l2, int i2, GB3 gb3) {
        J(gb3, L(this.k.h(l2, i2)));
    }

    public void Q(i iVar) {
        iVar.a(this.k.getCount());
    }

    public void R(String str, i iVar) {
        iVar.a(this.k.l(str));
    }

    public void S(String str, Long l2, int i2, GB3 gb3) {
        J(gb3, str == null ? L(this.k.d(l2, i2)) : L(this.k.n(str, l2, i2)));
    }

    public void T(o oVar) {
        List listD = this.k.d(null, 1);
        if (listD.size() != 1) {
            oVar.a(null);
            return;
        }
        try {
            oVar.a(AbstractC16720ll0.b((AbstractC17902nl0) this.l.a(), ((IB3) listD.get(0)).a()));
        } catch (IOException e2) {
            C19406qI3.c("AsyncStorageActor", "Error in loadHead on parse: " + e2.getMessage(), e2);
            oVar.a(null);
        }
    }

    public void U(long j2, o oVar) {
        IB3 ib3C = this.k.c(j2);
        if (ib3C == null) {
            oVar.a(null);
            return;
        }
        try {
            oVar.a(AbstractC16720ll0.b((AbstractC17902nl0) this.l.a(), ib3C.a()));
        } catch (IOException e2) {
            C19406qI3.c("AsyncStorageActor", "Error in loadItem on parse: " + e2.getMessage(), e2);
            oVar.a(null);
        }
    }

    public void X(String str, int i2, int i3, GB3 gb3) {
        J(gb3, L(this.k.g(str, i2, i3)));
    }

    public void Z(o oVar) {
        List listA = this.k.a(null, 1, false);
        if (listA.size() != 1) {
            oVar.a(null);
            return;
        }
        try {
            oVar.a(AbstractC16720ll0.b((AbstractC17902nl0) this.l.a(), ((IB3) listA.get(0)).a()));
        } catch (IOException e2) {
            C19406qI3.c("AsyncStorageActor", "Error in loadTail on parse: " + e2.getMessage(), e2);
            oVar.a(null);
        }
    }

    public void a0(long[] jArr) {
        if (jArr.length == 1) {
            this.k.b(jArr[0]);
        } else if (jArr.length > 0) {
            this.k.e(jArr);
        }
    }

    public C6517Nv5 b0(final long j2, final EnumC24659yz5 enumC24659yz5) {
        return new C6517Nv5(new InterfaceC6990Pv5() { // from class: ir.nasim.aL
            @Override // ir.nasim.InterfaceC6990Pv5
            public final void a(C7234Qv5 c7234Qv5) {
                this.a.M(j2, enumC24659yz5, c7234Qv5);
            }
        });
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void c0(List list) {
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            AbstractC17902nl0 abstractC17902nl0 = (AbstractC17902nl0) it.next();
            HB3 hb3 = (HB3) abstractC17902nl0;
            arrayList.add(new IB3(hb3.a(), hb3.j(), hb3.p(), abstractC17902nl0.toByteArray()));
        }
        this.k.clear();
        this.k.f(arrayList);
    }

    @Override // ir.nasim.AbstractC17647nK, ir.nasim.K6
    public void m(Object obj) throws Exception {
        if (obj instanceof a) {
            I(((a) obj).a());
            return;
        }
        if (obj instanceof t) {
            a0(((t) obj).a());
            return;
        }
        if (obj instanceof b) {
            K();
            return;
        }
        if (obj instanceof v) {
            c0(((v) obj).a());
            return;
        }
        if (obj instanceof l) {
            l lVar = (l) obj;
            U(lVar.b(), lVar.a());
            return;
        }
        if (obj instanceof g) {
            Q(((g) obj).a());
            return;
        }
        if (obj instanceof h) {
            h hVar = (h) obj;
            R(hVar.a, hVar.b);
            return;
        }
        if (obj instanceof k) {
            T(((k) obj).a());
            return;
        }
        if (obj instanceof s) {
            Z(((s) obj).a());
            return;
        }
        if (obj instanceof j) {
            j jVar = (j) obj;
            S(jVar.c(), jVar.d(), jVar.b(), jVar.a());
            return;
        }
        if (obj instanceof e) {
            e eVar = (e) obj;
            O(eVar.c(), eVar.d(), eVar.b(), eVar.a());
            return;
        }
        if (obj instanceof f) {
            f fVar = (f) obj;
            P(fVar.b(), fVar.c(), fVar.a());
            return;
        }
        if (obj instanceof p) {
            p pVar = (p) obj;
            X(pVar.d(), pVar.c(), pVar.b(), pVar.a());
            return;
        }
        if (obj instanceof c) {
            N(((c) obj).a());
            return;
        }
        if (obj instanceof m) {
            m mVar = (m) obj;
            V(mVar.c(), mVar.b().booleanValue(), mVar.a());
        } else if (obj instanceof n) {
            n nVar = (n) obj;
            W(nVar.c(), nVar.b().longValue(), nVar.a());
        } else if (!(obj instanceof q)) {
            super.m(obj);
        } else {
            q qVar = (q) obj;
            Y(qVar.a, qVar.b, qVar.c, qVar.d, qVar.e());
        }
    }
}
