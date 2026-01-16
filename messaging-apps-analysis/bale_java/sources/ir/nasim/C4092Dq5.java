package ir.nasim;

import ir.nasim.C5032Hp3;
import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/* renamed from: ir.nasim.Dq5, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C4092Dq5 {
    private final ConcurrentMap a;
    private final List b;
    private c c;
    private final Class d;
    private final C7350Ri4 e;
    private final boolean f;

    /* renamed from: ir.nasim.Dq5$b */
    public static class b {
        private final Class a;
        private ConcurrentMap b;
        private final List c;
        private c d;
        private C7350Ri4 e;

        private b c(Object obj, Object obj2, C5032Hp3.c cVar, boolean z) throws GeneralSecurityException {
            if (this.b == null) {
                throw new IllegalStateException("addPrimitive cannot be called after build");
            }
            if (obj == null && obj2 == null) {
                throw new GeneralSecurityException("at least one of the `fullPrimitive` or `primitive` must be set");
            }
            if (cVar.Z() != EnumC6192Mo3.ENABLED) {
                throw new GeneralSecurityException("only ENABLED key is allowed");
            }
            c cVarC = C4092Dq5.c(obj, obj2, cVar);
            C4092Dq5.l(cVarC, this.b, this.c);
            if (z) {
                if (this.d != null) {
                    throw new IllegalStateException("you cannot set two primary primitives");
                }
                this.d = cVarC;
            }
            return this;
        }

        public b a(Object obj, Object obj2, C5032Hp3.c cVar) {
            return c(obj, obj2, cVar, false);
        }

        public b b(Object obj, Object obj2, C5032Hp3.c cVar) {
            return c(obj, obj2, cVar, true);
        }

        public C4092Dq5 d() {
            ConcurrentMap concurrentMap = this.b;
            if (concurrentMap == null) {
                throw new IllegalStateException("build cannot be called twice");
            }
            C4092Dq5 c4092Dq5 = new C4092Dq5(concurrentMap, this.c, this.d, this.e, this.a);
            this.b = null;
            return c4092Dq5;
        }

        public b e(C7350Ri4 c7350Ri4) {
            if (this.b == null) {
                throw new IllegalStateException("setAnnotations cannot be called after build");
            }
            this.e = c7350Ri4;
            return this;
        }

        private b(Class cls) {
            this.b = new ConcurrentHashMap();
            this.c = new ArrayList();
            this.a = cls;
            this.e = C7350Ri4.b;
        }
    }

    /* renamed from: ir.nasim.Dq5$c */
    public static final class c {
        private final Object a;
        private final Object b;
        private final byte[] c;
        private final EnumC6192Mo3 d;
        private final FN4 e;
        private final int f;
        private final String g;
        private final AbstractC14981io3 h;

        c(Object obj, Object obj2, byte[] bArr, EnumC6192Mo3 enumC6192Mo3, FN4 fn4, int i, String str, AbstractC14981io3 abstractC14981io3) {
            this.a = obj;
            this.b = obj2;
            this.c = Arrays.copyOf(bArr, bArr.length);
            this.d = enumC6192Mo3;
            this.e = fn4;
            this.f = i;
            this.g = str;
            this.h = abstractC14981io3;
        }

        public Object a() {
            return this.a;
        }

        public final byte[] b() {
            byte[] bArr = this.c;
            if (bArr == null) {
                return null;
            }
            return Arrays.copyOf(bArr, bArr.length);
        }

        public AbstractC14981io3 c() {
            return this.h;
        }

        public int d() {
            return this.f;
        }

        public String e() {
            return this.g;
        }

        public FN4 f() {
            return this.e;
        }

        public Object g() {
            return this.b;
        }

        public EnumC6192Mo3 h() {
            return this.d;
        }
    }

    /* renamed from: ir.nasim.Dq5$d */
    private static class d implements Comparable {
        private final byte[] a;

        @Override // java.lang.Comparable
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compareTo(d dVar) {
            byte[] bArr = this.a;
            int length = bArr.length;
            byte[] bArr2 = dVar.a;
            if (length != bArr2.length) {
                return bArr.length - bArr2.length;
            }
            int i = 0;
            while (true) {
                byte[] bArr3 = this.a;
                if (i >= bArr3.length) {
                    return 0;
                }
                byte b = bArr3[i];
                byte b2 = dVar.a[i];
                if (b != b2) {
                    return b - b2;
                }
                i++;
            }
        }

        public boolean equals(Object obj) {
            if (obj instanceof d) {
                return Arrays.equals(this.a, ((d) obj).a);
            }
            return false;
        }

        public int hashCode() {
            return Arrays.hashCode(this.a);
        }

        public String toString() {
            return AbstractC21999uV2.b(this.a);
        }

        private d(byte[] bArr) {
            this.a = Arrays.copyOf(bArr, bArr.length);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static c c(Object obj, Object obj2, C5032Hp3.c cVar) {
        Integer numValueOf = Integer.valueOf(cVar.X());
        if (cVar.Y() == FN4.RAW) {
            numValueOf = null;
        }
        return new c(obj, obj2, AbstractC7937Tv1.a(cVar), cVar.Z(), cVar.Y(), cVar.X(), cVar.W().X(), com.google.crypto.tink.internal.b.c().g(C19799qx5.b(cVar.W().X(), cVar.W().Y(), cVar.W().W(), cVar.Y(), numValueOf), J93.a()));
    }

    public static b k(Class cls) {
        return new b(cls);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void l(c cVar, ConcurrentMap concurrentMap, List list) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(cVar);
        d dVar = new d(cVar.b());
        List list2 = (List) concurrentMap.put(dVar, Collections.unmodifiableList(arrayList));
        if (list2 != null) {
            ArrayList arrayList2 = new ArrayList();
            arrayList2.addAll(list2);
            arrayList2.add(cVar);
            concurrentMap.put(dVar, Collections.unmodifiableList(arrayList2));
        }
        list.add(cVar);
    }

    public Collection d() {
        return this.a.values();
    }

    public C7350Ri4 e() {
        return this.e;
    }

    public c f() {
        return this.c;
    }

    public List g(byte[] bArr) {
        List list = (List) this.a.get(new d(bArr));
        return list != null ? list : Collections.emptyList();
    }

    public Class h() {
        return this.d;
    }

    public List i() {
        return g(AbstractC7937Tv1.a);
    }

    public boolean j() {
        return !this.e.b().isEmpty();
    }

    private C4092Dq5(ConcurrentMap concurrentMap, List list, c cVar, C7350Ri4 c7350Ri4, Class cls) {
        this.a = concurrentMap;
        this.b = list;
        this.c = cVar;
        this.d = cls;
        this.e = c7350Ri4;
        this.f = false;
    }
}
