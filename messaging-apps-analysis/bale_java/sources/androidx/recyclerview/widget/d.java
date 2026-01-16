package androidx.recyclerview.widget;

import android.os.Handler;
import android.os.Looper;
import androidx.recyclerview.widget.i;
import ir.nasim.InterfaceC12197eC3;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Executor;

/* loaded from: classes2.dex */
public class d {
    private static final Executor h = new c();
    private final InterfaceC12197eC3 a;
    final C1977c b;
    Executor c;
    private List e;
    int g;
    private final List d = new CopyOnWriteArrayList();
    private List f = Collections.emptyList();

    class a implements Runnable {
        final /* synthetic */ List a;
        final /* synthetic */ List b;
        final /* synthetic */ int c;
        final /* synthetic */ Runnable d;

        /* renamed from: androidx.recyclerview.widget.d$a$a, reason: collision with other inner class name */
        class C0111a extends i.b {
            C0111a() {
            }

            @Override // androidx.recyclerview.widget.i.b
            public boolean a(int i, int i2) {
                Object obj = a.this.a.get(i);
                Object obj2 = a.this.b.get(i2);
                if (obj != null && obj2 != null) {
                    return d.this.b.b().a(obj, obj2);
                }
                if (obj == null && obj2 == null) {
                    return true;
                }
                throw new AssertionError();
            }

            @Override // androidx.recyclerview.widget.i.b
            public boolean b(int i, int i2) {
                Object obj = a.this.a.get(i);
                Object obj2 = a.this.b.get(i2);
                return (obj == null || obj2 == null) ? obj == null && obj2 == null : d.this.b.b().b(obj, obj2);
            }

            @Override // androidx.recyclerview.widget.i.b
            public Object c(int i, int i2) {
                Object obj = a.this.a.get(i);
                Object obj2 = a.this.b.get(i2);
                if (obj == null || obj2 == null) {
                    throw new AssertionError();
                }
                return d.this.b.b().c(obj, obj2);
            }

            @Override // androidx.recyclerview.widget.i.b
            public int d() {
                return a.this.b.size();
            }

            @Override // androidx.recyclerview.widget.i.b
            public int e() {
                return a.this.a.size();
            }
        }

        class b implements Runnable {
            final /* synthetic */ i.e a;

            b(i.e eVar) {
                this.a = eVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                a aVar = a.this;
                d dVar = d.this;
                if (dVar.g == aVar.c) {
                    dVar.c(aVar.b, this.a, aVar.d);
                }
            }
        }

        a(List list, List list2, int i, Runnable runnable) {
            this.a = list;
            this.b = list2;
            this.c = i;
            this.d = runnable;
        }

        @Override // java.lang.Runnable
        public void run() {
            d.this.c.execute(new b(i.b(new C0111a())));
        }
    }

    public interface b {
        void a(List list, List list2);
    }

    private static class c implements Executor {
        final Handler a = new Handler(Looper.getMainLooper());

        c() {
        }

        @Override // java.util.concurrent.Executor
        public void execute(Runnable runnable) {
            this.a.post(runnable);
        }
    }

    public d(InterfaceC12197eC3 interfaceC12197eC3, C1977c c1977c) {
        this.a = interfaceC12197eC3;
        this.b = c1977c;
        if (c1977c.c() != null) {
            this.c = c1977c.c();
        } else {
            this.c = h;
        }
    }

    private void d(List list, Runnable runnable) {
        Iterator it = this.d.iterator();
        while (it.hasNext()) {
            ((b) it.next()).a(list, this.f);
        }
        if (runnable != null) {
            runnable.run();
        }
    }

    public void a(b bVar) {
        this.d.add(bVar);
    }

    public List b() {
        return this.f;
    }

    void c(List list, i.e eVar, Runnable runnable) {
        List list2 = this.f;
        this.e = list;
        this.f = Collections.unmodifiableList(list);
        eVar.c(this.a);
        d(list2, runnable);
    }

    public void e(List list) {
        f(list, null);
    }

    public void f(List list, Runnable runnable) {
        int i = this.g + 1;
        this.g = i;
        List list2 = this.e;
        if (list == list2) {
            if (runnable != null) {
                runnable.run();
                return;
            }
            return;
        }
        List list3 = this.f;
        if (list == null) {
            int size = list2.size();
            this.e = null;
            this.f = Collections.emptyList();
            this.a.b(0, size);
            d(list3, runnable);
            return;
        }
        if (list2 != null) {
            this.b.a().execute(new a(list2, list, i, runnable));
            return;
        }
        this.e = list;
        this.f = Collections.unmodifiableList(list);
        this.a.a(0, list.size());
        d(list3, runnable);
    }
}
