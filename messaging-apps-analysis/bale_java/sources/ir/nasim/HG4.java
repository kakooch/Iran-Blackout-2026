package ir.nasim;

import java.util.concurrent.Executor;

/* loaded from: classes.dex */
public interface HG4 {

    public interface a {
        void a(Throwable th);

        void b(Object obj);
    }

    void a(Executor executor, a aVar);

    void b(a aVar);
}
