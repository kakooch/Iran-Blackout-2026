package androidx.recyclerview.widget;

import androidx.recyclerview.widget.i;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/* renamed from: androidx.recyclerview.widget.c, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C1977c {
    private final Executor a;
    private final Executor b;
    private final i.f c;

    /* renamed from: androidx.recyclerview.widget.c$a */
    public static final class a {
        private static final Object d = new Object();
        private static Executor e;
        private Executor a;
        private Executor b;
        private final i.f c;

        public a(i.f fVar) {
            this.c = fVar;
        }

        public C1977c a() {
            if (this.b == null) {
                synchronized (d) {
                    try {
                        if (e == null) {
                            e = Executors.newFixedThreadPool(2);
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
                this.b = e;
            }
            return new C1977c(this.a, this.b, this.c);
        }
    }

    C1977c(Executor executor, Executor executor2, i.f fVar) {
        this.a = executor;
        this.b = executor2;
        this.c = fVar;
    }

    public Executor a() {
        return this.b;
    }

    public i.f b() {
        return this.c;
    }

    public Executor c() {
        return this.a;
    }
}
