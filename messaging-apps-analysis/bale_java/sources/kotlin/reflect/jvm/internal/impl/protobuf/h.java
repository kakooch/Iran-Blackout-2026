package kotlin.reflect.jvm.internal.impl.protobuf;

import ir.nasim.V64;
import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.reflect.jvm.internal.impl.protobuf.a;
import kotlin.reflect.jvm.internal.impl.protobuf.g;
import kotlin.reflect.jvm.internal.impl.protobuf.i;
import kotlin.reflect.jvm.internal.impl.protobuf.l;
import kotlin.reflect.jvm.internal.impl.protobuf.p;

/* loaded from: classes8.dex */
public abstract class h extends kotlin.reflect.jvm.internal.impl.protobuf.a implements Serializable {

    static /* synthetic */ class a {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[p.c.values().length];
            a = iArr;
            try {
                iArr[p.c.MESSAGE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[p.c.ENUM.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public static abstract class b extends a.AbstractC1828a {
        private kotlin.reflect.jvm.internal.impl.protobuf.d a = kotlin.reflect.jvm.internal.impl.protobuf.d.a;

        protected b() {
        }

        public final kotlin.reflect.jvm.internal.impl.protobuf.d d() {
            return this.a;
        }

        public abstract b e(h hVar);

        public final b f(kotlin.reflect.jvm.internal.impl.protobuf.d dVar) {
            this.a = dVar;
            return this;
        }
    }

    public static abstract class c extends b implements V64 {
        private g b = g.g();
        private boolean c;

        protected c() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public g i() {
            this.b.q();
            this.c = false;
            return this.b;
        }

        private void k() {
            if (this.c) {
                return;
            }
            this.b = this.b.clone();
            this.c = true;
        }

        protected final void l(d dVar) {
            k();
            this.b.r(dVar.b);
        }
    }

    static final class e implements g.b {
        final i.b a;
        final int b;
        final p.b c;
        final boolean d;
        final boolean e;

        e(i.b bVar, int i, p.b bVar2, boolean z, boolean z2) {
            this.a = bVar;
            this.b = i;
            this.c = bVar2;
            this.d = z;
            this.e = z2;
        }

        @Override // java.lang.Comparable
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compareTo(e eVar) {
            return this.b - eVar.b;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.g.b
        public boolean b() {
            return this.d;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.g.b
        public p.b e() {
            return this.c;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.g.b
        public boolean f() {
            return this.e;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.g.b
        public int getNumber() {
            return this.b;
        }

        public i.b h() {
            return this.a;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.g.b
        public p.c k() {
            return this.c.a();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.g.b
        public l.a m(l.a aVar, l lVar) {
            return ((b) aVar).e((h) lVar);
        }
    }

    public static class f {
        final l a;
        final Object b;
        final l c;
        final e d;
        final Class e;
        final Method f;

        f(l lVar, Object obj, l lVar2, e eVar, Class cls) {
            if (lVar == null) {
                throw new IllegalArgumentException("Null containingTypeDefaultInstance");
            }
            if (eVar.e() == p.b.m && lVar2 == null) {
                throw new IllegalArgumentException("Null messageDefaultInstance");
            }
            this.a = lVar;
            this.b = obj;
            this.c = lVar2;
            this.d = eVar;
            this.e = cls;
            if (i.a.class.isAssignableFrom(cls)) {
                this.f = h.f(cls, "valueOf", Integer.TYPE);
            } else {
                this.f = null;
            }
        }

        Object a(Object obj) {
            if (!this.d.b()) {
                return e(obj);
            }
            if (this.d.k() != p.c.ENUM) {
                return obj;
            }
            ArrayList arrayList = new ArrayList();
            Iterator it = ((List) obj).iterator();
            while (it.hasNext()) {
                arrayList.add(e(it.next()));
            }
            return arrayList;
        }

        public l b() {
            return this.a;
        }

        public l c() {
            return this.c;
        }

        public int d() {
            return this.d.getNumber();
        }

        Object e(Object obj) {
            return this.d.k() == p.c.ENUM ? h.g(this.f, null, (Integer) obj) : obj;
        }

        Object f(Object obj) {
            return this.d.k() == p.c.ENUM ? Integer.valueOf(((i.a) obj).getNumber()) : obj;
        }
    }

    protected h() {
    }

    static Method f(Class cls, String str, Class... clsArr) {
        try {
            return cls.getMethod(str, clsArr);
        } catch (NoSuchMethodException e2) {
            String name = cls.getName();
            String strValueOf = String.valueOf(str);
            StringBuilder sb = new StringBuilder(name.length() + 45 + strValueOf.length());
            sb.append("Generated message class \"");
            sb.append(name);
            sb.append("\" missing method \"");
            sb.append(strValueOf);
            sb.append("\".");
            throw new RuntimeException(sb.toString(), e2);
        }
    }

    static Object g(Method method, Object obj, Object... objArr) {
        try {
            return method.invoke(obj, objArr);
        } catch (IllegalAccessException e2) {
            throw new RuntimeException("Couldn't use Java reflection to implement protocol message reflection.", e2);
        } catch (InvocationTargetException e3) {
            Throwable cause = e3.getCause();
            if (cause instanceof RuntimeException) {
                throw ((RuntimeException) cause);
            }
            if (cause instanceof Error) {
                throw ((Error) cause);
            }
            throw new RuntimeException("Unexpected exception thrown by generated accessor method.", cause);
        }
    }

    public static f k(l lVar, l lVar2, i.b bVar, int i, p.b bVar2, boolean z, Class cls) {
        return new f(lVar, Collections.emptyList(), lVar2, new e(bVar, i, bVar2, true, z), cls);
    }

    public static f l(l lVar, Object obj, l lVar2, i.b bVar, int i, p.b bVar2, Class cls) {
        return new f(lVar, obj, lVar2, new e(bVar, i, bVar2, false, false), cls);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:4:0x0010  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static boolean n(kotlin.reflect.jvm.internal.impl.protobuf.g r5, kotlin.reflect.jvm.internal.impl.protobuf.l r6, kotlin.reflect.jvm.internal.impl.protobuf.e r7, kotlin.reflect.jvm.internal.impl.protobuf.CodedOutputStream r8, kotlin.reflect.jvm.internal.impl.protobuf.f r9, int r10) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 291
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.protobuf.h.n(kotlin.reflect.jvm.internal.impl.protobuf.g, kotlin.reflect.jvm.internal.impl.protobuf.l, kotlin.reflect.jvm.internal.impl.protobuf.e, kotlin.reflect.jvm.internal.impl.protobuf.CodedOutputStream, kotlin.reflect.jvm.internal.impl.protobuf.f, int):boolean");
    }

    protected void j() {
    }

    protected boolean m(kotlin.reflect.jvm.internal.impl.protobuf.e eVar, CodedOutputStream codedOutputStream, kotlin.reflect.jvm.internal.impl.protobuf.f fVar, int i) {
        return eVar.O(i, codedOutputStream);
    }

    public static abstract class d extends h implements V64 {
        private final g b;

        protected class a {
            private final Iterator a;
            private Map.Entry b;
            private final boolean c;

            /* synthetic */ a(d dVar, boolean z, a aVar) {
                this(z);
            }

            public void a(int i, CodedOutputStream codedOutputStream) {
                while (true) {
                    Map.Entry entry = this.b;
                    if (entry == null || ((e) entry.getKey()).getNumber() >= i) {
                        return;
                    }
                    e eVar = (e) this.b.getKey();
                    if (this.c && eVar.k() == p.c.MESSAGE && !eVar.b()) {
                        codedOutputStream.e0(eVar.getNumber(), (l) this.b.getValue());
                    } else {
                        g.z(eVar, this.b.getValue(), codedOutputStream);
                    }
                    if (this.a.hasNext()) {
                        this.b = (Map.Entry) this.a.next();
                    } else {
                        this.b = null;
                    }
                }
            }

            private a(boolean z) {
                Iterator itP = d.this.b.p();
                this.a = itP;
                if (itP.hasNext()) {
                    this.b = (Map.Entry) itP.next();
                }
                this.c = z;
            }
        }

        protected d() {
            this.b = g.t();
        }

        private void C(f fVar) {
            if (fVar.b() != getDefaultInstanceForType()) {
                throw new IllegalArgumentException("This extension is for a different message type.  Please make sure that you are not suppressing any generics type warnings.");
            }
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.h
        protected void j() {
            this.b.q();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.h
        protected boolean m(kotlin.reflect.jvm.internal.impl.protobuf.e eVar, CodedOutputStream codedOutputStream, kotlin.reflect.jvm.internal.impl.protobuf.f fVar, int i) {
            return h.n(this.b, getDefaultInstanceForType(), eVar, codedOutputStream, fVar, i);
        }

        protected boolean q() {
            return this.b.n();
        }

        protected int r() {
            return this.b.k();
        }

        public final Object s(f fVar) {
            C(fVar);
            Object objH = this.b.h(fVar.d);
            return objH == null ? fVar.b : fVar.a(objH);
        }

        public final Object u(f fVar, int i) {
            C(fVar);
            return fVar.e(this.b.i(fVar.d, i));
        }

        public final int w(f fVar) {
            C(fVar);
            return this.b.j(fVar.d);
        }

        public final boolean y(f fVar) {
            C(fVar);
            return this.b.m(fVar.d);
        }

        protected a z() {
            return new a(this, false, null);
        }

        protected d(c cVar) {
            this.b = cVar.i();
        }
    }

    protected h(b bVar) {
    }
}
