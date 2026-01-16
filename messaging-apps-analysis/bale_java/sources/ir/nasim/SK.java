package ir.nasim;

import java.util.List;

/* loaded from: classes5.dex */
public class SK extends AbstractC17647nK {
    private final AbstractC9119Yo3 k;

    public static class a implements InterfaceC15283jK {
        private List a;
        private l b;

        public a(List list, l lVar) {
            this.a = list;
            this.b = lVar;
        }

        public List b() {
            return this.a;
        }
    }

    public static class b implements InterfaceC15283jK {
        private l a;

        public b(l lVar) {
            this.a = lVar;
        }
    }

    public static class c implements InterfaceC15283jK {
        private l a;

        public c(l lVar) {
            this.a = lVar;
        }
    }

    public static class d implements InterfaceC15283jK {
    }

    public static class e implements InterfaceC15283jK {
        private long a;
        i b;

        public e(long j, i iVar) {
            this.a = j;
            this.b = iVar;
        }

        public long a() {
            return this.a;
        }
    }

    public static class f implements InterfaceC15283jK {
        private final long a;

        public f(long j) {
            this.a = j;
        }

        public long a() {
            return this.a;
        }
    }

    public static class g implements InterfaceC15283jK {
        private List a;
        j b;

        public g(List list, j jVar) {
            this.a = list;
            this.b = jVar;
        }

        public List a() {
            return this.a;
        }
    }

    public static class h implements InterfaceC15283jK {
        private final List a;

        public h(List list) {
            this.a = list;
        }

        public List a() {
            return this.a;
        }
    }

    public interface i {
        void a(AbstractC17902nl0 abstractC17902nl0);
    }

    public interface j {
        void a(List list);
    }

    public static class k implements InterfaceC15283jK {
        private final long a;
        private final l b;

        public k(long j, l lVar) {
            this.a = j;
            this.b = lVar;
        }

        public long b() {
            return this.a;
        }
    }

    public interface l {
        void K();
    }

    public SK(AbstractC9119Yo3 abstractC9119Yo3) {
        this.k = abstractC9119Yo3;
    }

    private void K(List list, l lVar) {
        try {
            this.k.a(list);
            lVar.K();
        } catch (Exception unused) {
            lVar.K();
        }
    }

    private C6517Nv5 L(l lVar) {
        try {
            this.k.c();
        } catch (Exception unused) {
        } catch (Throwable th) {
            lVar.K();
            throw th;
        }
        lVar.K();
        return C6517Nv5.l0(C14505i18.a);
    }

    private C6517Nv5 M(l lVar) {
        try {
            this.k.d();
        } catch (Exception unused) {
        } catch (Throwable th) {
            lVar.K();
            throw th;
        }
        lVar.K();
        return C6517Nv5.l0(C14505i18.a);
    }

    private C6517Nv5 N() {
        return new C6517Nv5(new InterfaceC6990Pv5() { // from class: ir.nasim.RK
            @Override // ir.nasim.InterfaceC6990Pv5
            public final void a(C7234Qv5 c7234Qv5) {
                this.a.T(c7234Qv5);
            }
        });
    }

    private AbstractC17902nl0 O(long j2) {
        return this.k.f(j2);
    }

    private void P(long j2, i iVar) {
        try {
            iVar.a(O(j2));
        } catch (Exception e2) {
            C19406qI3.b("AsyncKeyValueStorageActor", "getValue error: " + e2.getMessage());
            iVar.a(null);
        }
    }

    private C6517Nv5 Q(final long j2) {
        return new C6517Nv5(new InterfaceC6990Pv5() { // from class: ir.nasim.PK
            @Override // ir.nasim.InterfaceC6990Pv5
            public final void a(C7234Qv5 c7234Qv5) {
                this.a.U(j2, c7234Qv5);
            }
        });
    }

    private List R(List list) {
        long[] jArr = new long[list.size()];
        for (int i2 = 0; i2 < list.size(); i2++) {
            jArr[i2] = ((Long) list.get(i2)).longValue();
        }
        return this.k.g(jArr);
    }

    private C6517Nv5 S(final List list) {
        return new C6517Nv5(new InterfaceC6990Pv5() { // from class: ir.nasim.QK
            @Override // ir.nasim.InterfaceC6990Pv5
            public final void a(C7234Qv5 c7234Qv5) {
                this.a.V(list, c7234Qv5);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void T(C7234Qv5 c7234Qv5) {
        List listW = W();
        if (listW == null) {
            c7234Qv5.a(new Exception("getAllValues failed, because result of readAllValues is null!"));
        } else {
            c7234Qv5.b(listW);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void U(long j2, C7234Qv5 c7234Qv5) {
        AbstractC20507s76.d();
        try {
            c7234Qv5.b(O(j2));
        } catch (Exception e2) {
            C19406qI3.b("AsyncKeyValueStorageActor", "getValueAsync, error: " + e2.getMessage());
            c7234Qv5.b(null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void V(List list, C7234Qv5 c7234Qv5) {
        AbstractC20507s76.d();
        try {
            c7234Qv5.b(R(list));
        } catch (Exception e2) {
            C19406qI3.b("AsyncKeyValueStorageActor", "getValuesAsync: keys, error: " + e2.getMessage());
            c7234Qv5.b(null);
        }
    }

    private List W() {
        return this.k.e();
    }

    private void X(long j2, l lVar) {
        try {
            this.k.h(j2);
        } catch (Exception unused) {
        } catch (Throwable th) {
            lVar.K();
            throw th;
        }
        lVar.K();
    }

    @Override // ir.nasim.AbstractC17647nK
    public C6517Nv5 G(Object obj) {
        return obj instanceof f ? Q(((f) obj).a()) : obj instanceof h ? S(((h) obj).a()) : obj instanceof d ? N() : super.G(obj);
    }

    @Override // ir.nasim.AbstractC17647nK, ir.nasim.K6
    public void m(Object obj) throws Exception {
        if (obj instanceof a) {
            a aVar = (a) obj;
            K(aVar.b(), aVar.b);
            return;
        }
        if (obj instanceof k) {
            k kVar = (k) obj;
            X(kVar.b(), kVar.b);
            return;
        }
        if (obj instanceof b) {
            L(((b) obj).a);
            return;
        }
        if (obj instanceof c) {
            M(((c) obj).a);
            return;
        }
        if (obj instanceof e) {
            e eVar = (e) obj;
            P(eVar.a(), eVar.b);
        } else if (!(obj instanceof g)) {
            super.m(obj);
        } else {
            g gVar = (g) obj;
            gVar.b.a(R(gVar.a()));
        }
    }
}
