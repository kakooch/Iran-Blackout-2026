package ir.nasim;

import android.util.Log;
import java.util.HashMap;
import java.util.Map;
import java.util.NavigableMap;
import java.util.TreeMap;

/* renamed from: ir.nasim.hL3, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C14096hL3 implements LJ {
    private final C17095mO2 a = new C17095mO2();
    private final b b = new b();
    private final Map c = new HashMap();
    private final Map d = new HashMap();
    private final int e;
    private int f;

    /* renamed from: ir.nasim.hL3$a */
    private static final class a implements InterfaceC17877ni5 {
        private final b a;
        int b;
        private Class c;

        a(b bVar) {
            this.a = bVar;
        }

        @Override // ir.nasim.InterfaceC17877ni5
        public void a() {
            this.a.c(this);
        }

        void b(int i, Class cls) {
            this.b = i;
            this.c = cls;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return this.b == aVar.b && this.c == aVar.c;
        }

        public int hashCode() {
            int i = this.b * 31;
            Class cls = this.c;
            return i + (cls != null ? cls.hashCode() : 0);
        }

        public String toString() {
            return "Key{size=" + this.b + "array=" + this.c + '}';
        }
    }

    /* renamed from: ir.nasim.hL3$b */
    private static final class b extends AbstractC23818xa0 {
        b() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // ir.nasim.AbstractC23818xa0
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public a a() {
            return new a(this);
        }

        a e(int i, Class cls) {
            a aVar = (a) b();
            aVar.b(i, cls);
            return aVar;
        }
    }

    public C14096hL3(int i) {
        this.e = i;
    }

    private void f(int i, Class cls) {
        NavigableMap navigableMapM = m(cls);
        Integer num = (Integer) navigableMapM.get(Integer.valueOf(i));
        if (num != null) {
            if (num.intValue() == 1) {
                navigableMapM.remove(Integer.valueOf(i));
                return;
            } else {
                navigableMapM.put(Integer.valueOf(i), Integer.valueOf(num.intValue() - 1));
                return;
            }
        }
        throw new NullPointerException("Tried to decrement empty size, size: " + i + ", this: " + this);
    }

    private void g() {
        h(this.e);
    }

    private void h(int i) {
        while (this.f > i) {
            Object objF = this.a.f();
            AbstractC3322Aj5.d(objF);
            InterfaceC24848zJ interfaceC24848zJI = i(objF);
            this.f -= interfaceC24848zJI.b(objF) * interfaceC24848zJI.a();
            f(interfaceC24848zJI.b(objF), objF.getClass());
            if (Log.isLoggable(interfaceC24848zJI.getTag(), 2)) {
                Log.v(interfaceC24848zJI.getTag(), "evicted: " + interfaceC24848zJI.b(objF));
            }
        }
    }

    private InterfaceC24848zJ i(Object obj) {
        return j(obj.getClass());
    }

    private InterfaceC24848zJ j(Class cls) {
        InterfaceC24848zJ c22772vo0 = (InterfaceC24848zJ) this.d.get(cls);
        if (c22772vo0 == null) {
            if (cls.equals(int[].class)) {
                c22772vo0 = new C6560Oa3();
            } else {
                if (!cls.equals(byte[].class)) {
                    throw new IllegalArgumentException("No array pool found for: " + cls.getSimpleName());
                }
                c22772vo0 = new C22772vo0();
            }
            this.d.put(cls, c22772vo0);
        }
        return c22772vo0;
    }

    private Object k(a aVar) {
        return this.a.a(aVar);
    }

    private Object l(a aVar, Class cls) {
        InterfaceC24848zJ interfaceC24848zJJ = j(cls);
        Object objK = k(aVar);
        if (objK != null) {
            this.f -= interfaceC24848zJJ.b(objK) * interfaceC24848zJJ.a();
            f(interfaceC24848zJJ.b(objK), cls);
        }
        if (objK != null) {
            return objK;
        }
        if (Log.isLoggable(interfaceC24848zJJ.getTag(), 2)) {
            Log.v(interfaceC24848zJJ.getTag(), "Allocated " + aVar.b + " bytes");
        }
        return interfaceC24848zJJ.newArray(aVar.b);
    }

    private NavigableMap m(Class cls) {
        NavigableMap navigableMap = (NavigableMap) this.c.get(cls);
        if (navigableMap != null) {
            return navigableMap;
        }
        TreeMap treeMap = new TreeMap();
        this.c.put(cls, treeMap);
        return treeMap;
    }

    private boolean n() {
        int i = this.f;
        return i == 0 || this.e / i >= 2;
    }

    private boolean o(int i) {
        return i <= this.e / 2;
    }

    private boolean p(int i, Integer num) {
        return num != null && (n() || num.intValue() <= i * 8);
    }

    @Override // ir.nasim.LJ
    public synchronized void a(int i) {
        try {
            if (i >= 40) {
                b();
            } else if (i >= 20 || i == 15) {
                h(this.e / 2);
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // ir.nasim.LJ
    public synchronized void b() {
        h(0);
    }

    @Override // ir.nasim.LJ
    public synchronized Object c(int i, Class cls) {
        Integer num;
        try {
            num = (Integer) m(cls).ceilingKey(Integer.valueOf(i));
        } catch (Throwable th) {
            throw th;
        }
        return l(p(i, num) ? this.b.e(num.intValue(), cls) : this.b.e(i, cls), cls);
    }

    @Override // ir.nasim.LJ
    public synchronized Object d(int i, Class cls) {
        return l(this.b.e(i, cls), cls);
    }

    @Override // ir.nasim.LJ
    public synchronized void e(Object obj) {
        Class<?> cls = obj.getClass();
        InterfaceC24848zJ interfaceC24848zJJ = j(cls);
        int iB = interfaceC24848zJJ.b(obj);
        int iA = interfaceC24848zJJ.a() * iB;
        if (o(iA)) {
            a aVarE = this.b.e(iB, cls);
            this.a.d(aVarE, obj);
            NavigableMap navigableMapM = m(cls);
            Integer num = (Integer) navigableMapM.get(Integer.valueOf(aVarE.b));
            Integer numValueOf = Integer.valueOf(aVarE.b);
            int iIntValue = 1;
            if (num != null) {
                iIntValue = 1 + num.intValue();
            }
            navigableMapM.put(numValueOf, Integer.valueOf(iIntValue));
            this.f += iA;
            g();
        }
    }
}
