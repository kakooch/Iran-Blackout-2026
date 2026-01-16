package ir.nasim;

import com.google.android.gms.tasks.Task;
import java.util.ArrayDeque;
import java.util.Queue;

/* loaded from: classes3.dex */
final class Cu8 {
    private final Object a = new Object();
    private Queue b;
    private boolean c;

    Cu8() {
    }

    public final void a(InterfaceC22250uu8 interfaceC22250uu8) {
        synchronized (this.a) {
            try {
                if (this.b == null) {
                    this.b = new ArrayDeque();
                }
                this.b.add(interfaceC22250uu8);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void b(Task task) {
        InterfaceC22250uu8 interfaceC22250uu8;
        synchronized (this.a) {
            if (this.b != null && !this.c) {
                this.c = true;
                while (true) {
                    synchronized (this.a) {
                        try {
                            interfaceC22250uu8 = (InterfaceC22250uu8) this.b.poll();
                            if (interfaceC22250uu8 == null) {
                                this.c = false;
                                return;
                            }
                        } finally {
                        }
                    }
                    interfaceC22250uu8.b(task);
                }
            }
        }
    }
}
