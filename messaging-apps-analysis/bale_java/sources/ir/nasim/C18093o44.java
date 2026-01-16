package ir.nasim;

import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

/* renamed from: ir.nasim.o44, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public class C18093o44 {
    private final Runnable a;
    private final CopyOnWriteArrayList b = new CopyOnWriteArrayList();
    private final Map c = new HashMap();

    public C18093o44(Runnable runnable) {
        this.a = runnable;
    }

    public void a(A44 a44) {
        this.b.add(a44);
        this.a.run();
    }

    public void b(Menu menu, MenuInflater menuInflater) {
        Iterator it = this.b.iterator();
        while (it.hasNext()) {
            ((A44) it.next()).d(menu, menuInflater);
        }
    }

    public void c(Menu menu) {
        Iterator it = this.b.iterator();
        while (it.hasNext()) {
            ((A44) it.next()).a(menu);
        }
    }

    public boolean d(MenuItem menuItem) {
        Iterator it = this.b.iterator();
        while (it.hasNext()) {
            if (((A44) it.next()).c(menuItem)) {
                return true;
            }
        }
        return false;
    }

    public void e(Menu menu) {
        Iterator it = this.b.iterator();
        while (it.hasNext()) {
            ((A44) it.next()).b(menu);
        }
    }

    public void f(A44 a44) {
        this.b.remove(a44);
        AbstractC18350oW3.a(this.c.remove(a44));
        this.a.run();
    }
}
