package ir.nasim;

import java.util.concurrent.CopyOnWriteArrayList;

/* renamed from: ir.nasim.gQ7, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public abstract class AbstractC13554gQ7 {
    private final CopyOnWriteArrayList a = new CopyOnWriteArrayList();

    public abstract Object b();

    protected void d(final Object obj) {
        AbstractC20507s76.z(new Runnable() { // from class: ir.nasim.fQ7
            @Override // java.lang.Runnable
            public final void run() {
                this.a.c(obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public void c(Object obj) {
        CopyOnWriteArrayList copyOnWriteArrayList = this.a;
        for (InterfaceC14756iQ7 interfaceC14756iQ7 : (InterfaceC14756iQ7[]) copyOnWriteArrayList.toArray(new InterfaceC14756iQ7[copyOnWriteArrayList.size()])) {
            interfaceC14756iQ7.b(obj, this);
        }
    }

    public void f(InterfaceC14756iQ7 interfaceC14756iQ7) {
        g(interfaceC14756iQ7, true);
    }

    public void g(InterfaceC14756iQ7 interfaceC14756iQ7, boolean z) {
        synchronized (this.a) {
            try {
                if (this.a.contains(interfaceC14756iQ7)) {
                    return;
                }
                this.a.add(interfaceC14756iQ7);
                if (z) {
                    interfaceC14756iQ7.b(b(), this);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void h(InterfaceC14756iQ7 interfaceC14756iQ7) {
        synchronized (this.a) {
            this.a.remove(interfaceC14756iQ7);
        }
    }
}
