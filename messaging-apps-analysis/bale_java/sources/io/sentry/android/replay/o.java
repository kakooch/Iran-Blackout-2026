package io.sentry.android.replay;

import android.os.Handler;
import android.os.Looper;
import android.view.View;
import io.sentry.InterfaceC3102d0;
import io.sentry.android.replay.o;
import io.sentry.util.C3202a;
import ir.nasim.AbstractC13042fc3;
import ir.nasim.AbstractC14155hS;
import ir.nasim.AbstractC8614Ws3;
import ir.nasim.C19938rB7;
import ir.nasim.ED1;
import ir.nasim.UA2;
import java.io.Closeable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes3.dex */
public final class o implements Closeable {
    public static final a e = new a(null);
    public static final int f = 8;
    private final AtomicBoolean a;
    private final C3202a b;
    private final CopyOnWriteArrayList c;
    private final ArrayList d;

    public static final class a {

        /* renamed from: io.sentry.android.replay.o$a$a, reason: collision with other inner class name */
        static final class C0242a extends AbstractC8614Ws3 implements UA2 {
            final /* synthetic */ o e;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C0242a(o oVar) {
                super(1);
                this.e = oVar;
            }

            @Override // ir.nasim.UA2
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public final ArrayList invoke(ArrayList arrayList) throws Exception {
                AbstractC13042fc3.i(arrayList, "mViews");
                InterfaceC3102d0 interfaceC3102d0A = this.e.b.a();
                try {
                    ArrayList arrayList2 = this.e.d;
                    arrayList2.addAll(arrayList);
                    AbstractC14155hS.a(interfaceC3102d0A, null);
                    return arrayList2;
                } finally {
                }
            }
        }

        private a() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void c(o oVar) {
            AbstractC13042fc3.i(oVar, "$this_apply");
            if (oVar.a.get()) {
                return;
            }
            x.a.e(new C0242a(oVar));
        }

        public final o b() {
            final o oVar = new o(null);
            new Handler(Looper.getMainLooper()).postAtFrontOfQueue(new Runnable() { // from class: io.sentry.android.replay.n
                @Override // java.lang.Runnable
                public final void run() {
                    o.a.c(oVar);
                }
            });
            return oVar;
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    public static final class b extends ArrayList {
        b() {
        }

        public /* bridge */ int C(View view) {
            return super.indexOf(view);
        }

        public /* bridge */ int D(View view) {
            return super.lastIndexOf(view);
        }

        @Override // java.util.ArrayList, java.util.AbstractList, java.util.List
        /* renamed from: E, reason: merged with bridge method [inline-methods] */
        public final /* bridge */ View remove(int i) {
            return L(i);
        }

        public /* bridge */ boolean F(View view) {
            return super.remove(view);
        }

        public View L(int i) {
            Object objRemove = super.remove(i);
            AbstractC13042fc3.h(objRemove, "super.removeAt(index)");
            View view = (View) objRemove;
            Iterator it = o.this.d().iterator();
            while (it.hasNext()) {
                ((d) it.next()).a(view, false);
            }
            return view;
        }

        @Override // java.util.ArrayList, java.util.AbstractCollection, java.util.Collection, java.util.List
        public boolean addAll(Collection collection) {
            AbstractC13042fc3.i(collection, "elements");
            for (d dVar : o.this.d()) {
                Iterator it = collection.iterator();
                while (it.hasNext()) {
                    dVar.a((View) it.next(), true);
                }
            }
            return super.addAll(collection);
        }

        @Override // java.util.ArrayList, java.util.AbstractCollection, java.util.Collection, java.util.List
        public final /* bridge */ boolean contains(Object obj) {
            if (obj instanceof View) {
                return r((View) obj);
            }
            return false;
        }

        @Override // java.util.ArrayList, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public boolean add(View view) {
            AbstractC13042fc3.i(view, "element");
            Iterator it = o.this.d().iterator();
            while (it.hasNext()) {
                ((d) it.next()).a(view, true);
            }
            return super.add(view);
        }

        @Override // java.util.ArrayList, java.util.AbstractList, java.util.List
        public final /* bridge */ int indexOf(Object obj) {
            if (obj instanceof View) {
                return C((View) obj);
            }
            return -1;
        }

        @Override // java.util.ArrayList, java.util.AbstractList, java.util.List
        public final /* bridge */ int lastIndexOf(Object obj) {
            if (obj instanceof View) {
                return D((View) obj);
            }
            return -1;
        }

        public /* bridge */ boolean r(View view) {
            return super.contains(view);
        }

        @Override // java.util.ArrayList, java.util.AbstractCollection, java.util.Collection, java.util.List
        public final /* bridge */ int size() {
            return w();
        }

        public /* bridge */ int w() {
            return super.size();
        }

        @Override // java.util.ArrayList, java.util.AbstractCollection, java.util.Collection, java.util.List
        public final /* bridge */ boolean remove(Object obj) {
            if (obj instanceof View) {
                return F((View) obj);
            }
            return false;
        }
    }

    public static final class c extends CopyOnWriteArrayList {
        c() {
        }

        public /* bridge */ int C(d dVar) {
            return super.indexOf(dVar);
        }

        public /* bridge */ int D(d dVar) {
            return super.lastIndexOf(dVar);
        }

        public /* bridge */ boolean E(d dVar) {
            return super.remove(dVar);
        }

        @Override // java.util.concurrent.CopyOnWriteArrayList, java.util.List, java.util.Collection
        public final /* bridge */ boolean contains(Object obj) {
            if (obj == null ? true : obj instanceof d) {
                return r((d) obj);
            }
            return false;
        }

        @Override // java.util.concurrent.CopyOnWriteArrayList, java.util.List, java.util.Collection
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public boolean add(d dVar) throws Exception {
            InterfaceC3102d0 interfaceC3102d0A = o.this.b.a();
            try {
                for (View view : o.this.d) {
                    if (dVar != null) {
                        dVar.a(view, true);
                    }
                }
                C19938rB7 c19938rB7 = C19938rB7.a;
                AbstractC14155hS.a(interfaceC3102d0A, null);
                return super.add(dVar);
            } finally {
            }
        }

        @Override // java.util.concurrent.CopyOnWriteArrayList, java.util.List
        public final /* bridge */ int indexOf(Object obj) {
            if (obj == null ? true : obj instanceof d) {
                return C((d) obj);
            }
            return -1;
        }

        @Override // java.util.concurrent.CopyOnWriteArrayList, java.util.List
        public final /* bridge */ int lastIndexOf(Object obj) {
            if (obj == null ? true : obj instanceof d) {
                return D((d) obj);
            }
            return -1;
        }

        public /* bridge */ boolean r(d dVar) {
            return super.contains(dVar);
        }

        @Override // java.util.concurrent.CopyOnWriteArrayList, java.util.List, java.util.Collection
        public final /* bridge */ boolean remove(Object obj) {
            if (obj == null ? true : obj instanceof d) {
                return E((d) obj);
            }
            return false;
        }

        @Override // java.util.concurrent.CopyOnWriteArrayList, java.util.List, java.util.Collection
        public final /* bridge */ int size() {
            return w();
        }

        public /* bridge */ int w() {
            return super.size();
        }
    }

    public /* synthetic */ o(ED1 ed1) {
        this();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.a.set(true);
        this.c.clear();
    }

    public final CopyOnWriteArrayList d() {
        return this.c;
    }

    private o() {
        this.a = new AtomicBoolean(false);
        this.b = new C3202a();
        this.c = new c();
        this.d = new b();
    }
}
