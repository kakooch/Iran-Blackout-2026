package ir.nasim;

import ir.nasim.tgwidgets.editor.messenger.AbstractC21455b;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/* renamed from: ir.nasim.nB7, reason: case insensitive filesystem */
/* loaded from: classes7.dex */
public class C17574nB7 {
    private a a;
    private Map b = new HashMap();
    private List c = new ArrayList();

    /* renamed from: ir.nasim.nB7$a */
    public interface a {
        void a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void d() {
        a aVar = this.a;
        if (aVar != null) {
            aVar.a();
        }
    }

    private void e() {
        AbstractC21455b.m1(new Runnable() { // from class: ir.nasim.lB7
            @Override // java.lang.Runnable
            public final void run() {
                this.a.d();
            }
        });
    }

    public boolean b() {
        return !this.c.isEmpty();
    }

    public a c() {
        return this.a;
    }

    public void f(UUID uuid, Runnable runnable) {
        this.b.put(uuid, runnable);
        this.c.add(uuid);
        e();
    }

    public void g() {
        this.c.clear();
        this.b.clear();
        e();
    }

    public void h(a aVar) {
        this.a = aVar;
    }

    public void i() {
        if (this.c.size() == 0) {
            return;
        }
        int size = this.c.size() - 1;
        UUID uuid = (UUID) this.c.get(size);
        Runnable runnable = (Runnable) this.b.get(uuid);
        this.b.remove(uuid);
        this.c.remove(size);
        runnable.run();
        e();
    }

    public void j(UUID uuid) {
        this.b.remove(uuid);
        this.c.remove(uuid);
        e();
    }
}
