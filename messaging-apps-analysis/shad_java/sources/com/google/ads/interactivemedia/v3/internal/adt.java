package com.google.ads.interactivemedia.v3.internal;

import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
public final class adt<T> {
    private final CopyOnWriteArraySet<ads<T>> a = new CopyOnWriteArraySet<>();
    private final ArrayDeque<Runnable> b = new ArrayDeque<>();
    private final ArrayDeque<Runnable> c = new ArrayDeque<>();
    private boolean d;

    public final void a(T t) {
        if (this.d) {
            return;
        }
        ary.t(t);
        this.a.add(new ads<>(t));
    }

    public final void b(T t) {
        Iterator<ads<T>> it = this.a.iterator();
        while (it.hasNext()) {
            ads<T> next = it.next();
            if (next.a.equals(t)) {
                next.a();
                this.a.remove(next);
            }
        }
    }

    public final void c(final adr<T> adrVar) {
        final CopyOnWriteArraySet copyOnWriteArraySet = new CopyOnWriteArraySet(this.a);
        this.c.add(new Runnable(copyOnWriteArraySet, adrVar) { // from class: com.google.ads.interactivemedia.v3.internal.adq
            private final CopyOnWriteArraySet a;
            private final adr b;

            {
                this.a = copyOnWriteArraySet;
                this.b = adrVar;
            }

            @Override // java.lang.Runnable
            public final void run() {
                CopyOnWriteArraySet copyOnWriteArraySet2 = this.a;
                adr adrVar2 = this.b;
                Iterator it = copyOnWriteArraySet2.iterator();
                while (it.hasNext()) {
                    ((ads) it.next()).b(adrVar2);
                }
            }
        });
    }

    public final void d() {
        boolean zIsEmpty = this.b.isEmpty();
        this.b.addAll(this.c);
        this.c.clear();
        if (!zIsEmpty) {
            return;
        }
        while (!this.b.isEmpty()) {
            this.b.peekFirst().run();
            this.b.removeFirst();
        }
    }

    public final void e(adr<T> adrVar) {
        c(adrVar);
        d();
    }

    public final void f() {
        Iterator<ads<T>> it = this.a.iterator();
        while (it.hasNext()) {
            it.next().a();
        }
        this.a.clear();
        this.d = true;
    }
}
