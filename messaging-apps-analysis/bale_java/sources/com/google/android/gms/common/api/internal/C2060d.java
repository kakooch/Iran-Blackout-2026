package com.google.android.gms.common.api.internal;

import android.gov.nist.core.Separators;
import android.os.Looper;
import ir.nasim.AbstractC3795Cj5;
import ir.nasim.ExecutorC21981uT2;
import java.util.concurrent.Executor;

/* renamed from: com.google.android.gms.common.api.internal.d, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C2060d {
    private final Executor a;
    private volatile Object b;
    private volatile a c;

    /* renamed from: com.google.android.gms.common.api.internal.d$a */
    public static final class a {
        private final Object a;
        private final String b;

        a(Object obj, String str) {
            this.a = obj;
            this.b = str;
        }

        public String a() {
            return this.b + Separators.AT + System.identityHashCode(this.a);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return this.a == aVar.a && this.b.equals(aVar.b);
        }

        public int hashCode() {
            return (System.identityHashCode(this.a) * 31) + this.b.hashCode();
        }
    }

    /* renamed from: com.google.android.gms.common.api.internal.d$b */
    public interface b {
        void a(Object obj);

        void b();
    }

    C2060d(Looper looper, Object obj, String str) {
        this.a = new ExecutorC21981uT2(looper);
        this.b = AbstractC3795Cj5.k(obj, "Listener must not be null");
        this.c = new a(obj, AbstractC3795Cj5.f(str));
    }

    public void a() {
        this.b = null;
        this.c = null;
    }

    public a b() {
        return this.c;
    }

    public void c(final b bVar) {
        AbstractC3795Cj5.k(bVar, "Notifier must not be null");
        this.a.execute(new Runnable() { // from class: com.google.android.gms.common.api.internal.w
            @Override // java.lang.Runnable
            public final void run() {
                this.a.d(bVar);
            }
        });
    }

    final void d(b bVar) {
        Object obj = this.b;
        if (obj == null) {
            bVar.b();
            return;
        }
        try {
            bVar.a(obj);
        } catch (RuntimeException e) {
            bVar.b();
            throw e;
        }
    }
}
