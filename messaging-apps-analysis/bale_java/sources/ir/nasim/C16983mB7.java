package ir.nasim;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/* renamed from: ir.nasim.mB7, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class C16983mB7 {
    private b a;
    private Map b = new HashMap();
    private List c = new ArrayList();

    /* renamed from: ir.nasim.mB7$a */
    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (C16983mB7.this.a != null) {
                C16983mB7.this.a.a();
            }
        }
    }

    /* renamed from: ir.nasim.mB7$b */
    public interface b {
        void a();
    }

    private void c() {
        AbstractC7426Rr.P(new a());
    }

    public boolean b() {
        return !this.c.isEmpty();
    }

    public void d(UUID uuid, Runnable runnable) {
        this.b.put(uuid, runnable);
        this.c.add(uuid);
        c();
    }

    public void e(b bVar) {
        this.a = bVar;
    }

    public void f() {
        if (this.c.size() == 0) {
            return;
        }
        int size = this.c.size() - 1;
        UUID uuid = (UUID) this.c.get(size);
        Runnable runnable = (Runnable) this.b.get(uuid);
        this.b.remove(uuid);
        this.c.remove(size);
        runnable.run();
        c();
    }

    public void g(UUID uuid) {
        this.b.remove(uuid);
        this.c.remove(uuid);
        c();
    }
}
