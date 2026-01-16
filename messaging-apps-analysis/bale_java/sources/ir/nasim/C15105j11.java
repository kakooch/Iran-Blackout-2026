package ir.nasim;

import android.util.Log;
import com.google.firebase.components.ComponentRegistrar;
import com.google.firebase.components.InvalidRegistrarException;
import com.google.firebase.components.MissingDependencyException;
import ir.nasim.C15105j11;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicReference;

/* renamed from: ir.nasim.j11, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class C15105j11 extends I0 implements Z01 {
    private static final InterfaceC7959Tx5 h = new InterfaceC7959Tx5() { // from class: ir.nasim.f11
        @Override // ir.nasim.InterfaceC7959Tx5
        public final Object get() {
            return Collections.emptySet();
        }
    };
    private final Map a;
    private final Map b;
    private final Map c;
    private final List d;
    private final C6798Pa2 e;
    private final AtomicReference f;
    private final InterfaceC11444d11 g;

    public static b h(Executor executor) {
        return new b(executor);
    }

    private void i(List list) {
        ArrayList arrayList = new ArrayList();
        synchronized (this) {
            Iterator it = this.d.iterator();
            while (it.hasNext()) {
                try {
                    ComponentRegistrar componentRegistrar = (ComponentRegistrar) ((InterfaceC7959Tx5) it.next()).get();
                    if (componentRegistrar != null) {
                        list.addAll(this.g.a(componentRegistrar));
                        it.remove();
                    }
                } catch (InvalidRegistrarException e) {
                    it.remove();
                    Log.w("ComponentDiscovery", "Invalid component registrar.", e);
                }
            }
            if (this.a.isEmpty()) {
                AbstractC6531Nx1.a(list);
            } else {
                ArrayList arrayList2 = new ArrayList(this.a.keySet());
                arrayList2.addAll(list);
                AbstractC6531Nx1.a(arrayList2);
            }
            Iterator it2 = list.iterator();
            while (it2.hasNext()) {
                final I01 i01 = (I01) it2.next();
                this.a.put(i01, new C9407Zu3(new InterfaceC7959Tx5() { // from class: ir.nasim.g11
                    @Override // ir.nasim.InterfaceC7959Tx5
                    public final Object get() {
                        return this.a.m(i01);
                    }
                }));
            }
            arrayList.addAll(r(list));
            arrayList.addAll(s());
            q();
        }
        Iterator it3 = arrayList.iterator();
        while (it3.hasNext()) {
            ((Runnable) it3.next()).run();
        }
        p();
    }

    private void j(Map map, boolean z) {
        for (Map.Entry entry : map.entrySet()) {
            I01 i01 = (I01) entry.getKey();
            InterfaceC7959Tx5 interfaceC7959Tx5 = (InterfaceC7959Tx5) entry.getValue();
            if (i01.l() || (i01.m() && z)) {
                interfaceC7959Tx5.get();
            }
        }
        this.e.d();
    }

    private static List l(Iterable iterable) {
        ArrayList arrayList = new ArrayList();
        Iterator it = iterable.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next());
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Object m(I01 i01) {
        return i01.f().a(new T06(i01, this));
    }

    private void p() {
        Boolean bool = (Boolean) this.f.get();
        if (bool != null) {
            j(this.a, bool.booleanValue());
        }
    }

    private void q() {
        for (I01 i01 : this.a.keySet()) {
            for (C10226bI1 c10226bI1 : i01.e()) {
                if (c10226bI1.f() && !this.c.containsKey(c10226bI1.b())) {
                    this.c.put(c10226bI1.b(), C24639yx3.b(Collections.emptySet()));
                } else if (this.b.containsKey(c10226bI1.b())) {
                    continue;
                } else {
                    if (c10226bI1.e()) {
                        throw new MissingDependencyException(String.format("Unsatisfied dependency for component %s: %s", i01, c10226bI1.b()));
                    }
                    if (!c10226bI1.f()) {
                        this.b.put(c10226bI1.b(), GL4.c());
                    }
                }
            }
        }
    }

    private List r(List list) {
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            I01 i01 = (I01) it.next();
            if (i01.n()) {
                final InterfaceC7959Tx5 interfaceC7959Tx5 = (InterfaceC7959Tx5) this.a.get(i01);
                for (Class cls : i01.h()) {
                    if (this.b.containsKey(cls)) {
                        final GL4 gl4 = (GL4) ((InterfaceC7959Tx5) this.b.get(cls));
                        arrayList.add(new Runnable() { // from class: ir.nasim.h11
                            @Override // java.lang.Runnable
                            public final void run() {
                                gl4.f(interfaceC7959Tx5);
                            }
                        });
                    } else {
                        this.b.put(cls, interfaceC7959Tx5);
                    }
                }
            }
        }
        return arrayList;
    }

    private List s() {
        ArrayList arrayList = new ArrayList();
        HashMap map = new HashMap();
        for (Map.Entry entry : this.a.entrySet()) {
            I01 i01 = (I01) entry.getKey();
            if (!i01.n()) {
                InterfaceC7959Tx5 interfaceC7959Tx5 = (InterfaceC7959Tx5) entry.getValue();
                for (Class cls : i01.h()) {
                    if (!map.containsKey(cls)) {
                        map.put(cls, new HashSet());
                    }
                    ((Set) map.get(cls)).add(interfaceC7959Tx5);
                }
            }
        }
        for (Map.Entry entry2 : map.entrySet()) {
            if (this.c.containsKey(entry2.getKey())) {
                final C24639yx3 c24639yx3 = (C24639yx3) this.c.get(entry2.getKey());
                for (final InterfaceC7959Tx5 interfaceC7959Tx52 : (Set) entry2.getValue()) {
                    arrayList.add(new Runnable() { // from class: ir.nasim.i11
                        @Override // java.lang.Runnable
                        public final void run() {
                            c24639yx3.a(interfaceC7959Tx52);
                        }
                    });
                }
            } else {
                this.c.put((Class) entry2.getKey(), C24639yx3.b((Collection) entry2.getValue()));
            }
        }
        return arrayList;
    }

    @Override // ir.nasim.I0, ir.nasim.S01
    public /* bridge */ /* synthetic */ Object a(Class cls) {
        return super.a(cls);
    }

    @Override // ir.nasim.S01
    public synchronized InterfaceC7959Tx5 b(Class cls) {
        C24639yx3 c24639yx3 = (C24639yx3) this.c.get(cls);
        if (c24639yx3 != null) {
            return c24639yx3;
        }
        return h;
    }

    @Override // ir.nasim.I0, ir.nasim.S01
    public /* bridge */ /* synthetic */ Set c(Class cls) {
        return super.c(cls);
    }

    @Override // ir.nasim.S01
    public synchronized InterfaceC7959Tx5 d(Class cls) {
        AbstractC4263Ej5.c(cls, "Null interface requested.");
        return (InterfaceC7959Tx5) this.b.get(cls);
    }

    public void k(boolean z) {
        HashMap map;
        if (AbstractC16775lq5.a(this.f, null, Boolean.valueOf(z))) {
            synchronized (this) {
                map = new HashMap(this.a);
            }
            j(map, z);
        }
    }

    private C15105j11(Executor executor, Iterable iterable, Collection collection, InterfaceC11444d11 interfaceC11444d11) {
        this.a = new HashMap();
        this.b = new HashMap();
        this.c = new HashMap();
        this.f = new AtomicReference();
        C6798Pa2 c6798Pa2 = new C6798Pa2(executor);
        this.e = c6798Pa2;
        this.g = interfaceC11444d11;
        ArrayList arrayList = new ArrayList();
        arrayList.add(I01.q(c6798Pa2, C6798Pa2.class, InterfaceC17465n07.class, InterfaceC17444my5.class));
        arrayList.add(I01.q(this, Z01.class, new Class[0]));
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            I01 i01 = (I01) it.next();
            if (i01 != null) {
                arrayList.add(i01);
            }
        }
        this.d = l(iterable);
        i(arrayList);
    }

    /* renamed from: ir.nasim.j11$b */
    public static final class b {
        private final Executor a;
        private final List b = new ArrayList();
        private final List c = new ArrayList();
        private InterfaceC11444d11 d = InterfaceC11444d11.a;

        b(Executor executor) {
            this.a = executor;
        }

        public b b(I01 i01) {
            this.c.add(i01);
            return this;
        }

        public b c(final ComponentRegistrar componentRegistrar) {
            this.b.add(new InterfaceC7959Tx5() { // from class: ir.nasim.k11
                @Override // ir.nasim.InterfaceC7959Tx5
                public final Object get() {
                    return C15105j11.b.f(componentRegistrar);
                }
            });
            return this;
        }

        public b d(Collection collection) {
            this.b.addAll(collection);
            return this;
        }

        public C15105j11 e() {
            return new C15105j11(this.a, this.b, this.c, this.d);
        }

        public b g(InterfaceC11444d11 interfaceC11444d11) {
            this.d = interfaceC11444d11;
            return this;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ ComponentRegistrar f(ComponentRegistrar componentRegistrar) {
            return componentRegistrar;
        }
    }
}
