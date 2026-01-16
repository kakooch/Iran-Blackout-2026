package ir.nasim;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import ir.nasim.InterfaceC23757xT2;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes2.dex */
final class N47 implements InterfaceC23757xT2 {
    private static final List b = new ArrayList(50);
    private final Handler a;

    private static final class b implements InterfaceC23757xT2.a {
        private Message a;
        private N47 b;

        private b() {
        }

        private void b() {
            this.a = null;
            this.b = null;
            N47.n(this);
        }

        @Override // ir.nasim.InterfaceC23757xT2.a
        public void a() {
            ((Message) AbstractC20011rK.e(this.a)).sendToTarget();
            b();
        }

        public boolean c(Handler handler) {
            boolean zSendMessageAtFrontOfQueue = handler.sendMessageAtFrontOfQueue((Message) AbstractC20011rK.e(this.a));
            b();
            return zSendMessageAtFrontOfQueue;
        }

        public b d(Message message, N47 n47) {
            this.a = message;
            this.b = n47;
            return this;
        }
    }

    public N47(Handler handler) {
        this.a = handler;
    }

    private static b m() {
        b bVar;
        List list = b;
        synchronized (list) {
            try {
                bVar = list.isEmpty() ? new b() : (b) list.remove(list.size() - 1);
            } catch (Throwable th) {
                throw th;
            }
        }
        return bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void n(b bVar) {
        List list = b;
        synchronized (list) {
            try {
                if (list.size() < 50) {
                    list.add(bVar);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // ir.nasim.InterfaceC23757xT2
    public InterfaceC23757xT2.a a(int i) {
        return m().d(this.a.obtainMessage(i), this);
    }

    @Override // ir.nasim.InterfaceC23757xT2
    public boolean b(InterfaceC23757xT2.a aVar) {
        return ((b) aVar).c(this.a);
    }

    @Override // ir.nasim.InterfaceC23757xT2
    public boolean c(int i) {
        return this.a.hasMessages(i);
    }

    @Override // ir.nasim.InterfaceC23757xT2
    public InterfaceC23757xT2.a d(int i, int i2, int i3, Object obj) {
        return m().d(this.a.obtainMessage(i, i2, i3, obj), this);
    }

    @Override // ir.nasim.InterfaceC23757xT2
    public InterfaceC23757xT2.a e(int i, Object obj) {
        return m().d(this.a.obtainMessage(i, obj), this);
    }

    @Override // ir.nasim.InterfaceC23757xT2
    public void f(Object obj) {
        this.a.removeCallbacksAndMessages(obj);
    }

    @Override // ir.nasim.InterfaceC23757xT2
    public InterfaceC23757xT2.a g(int i, int i2, int i3) {
        return m().d(this.a.obtainMessage(i, i2, i3), this);
    }

    @Override // ir.nasim.InterfaceC23757xT2
    public Looper getLooper() {
        return this.a.getLooper();
    }

    @Override // ir.nasim.InterfaceC23757xT2
    public boolean h(Runnable runnable) {
        return this.a.post(runnable);
    }

    @Override // ir.nasim.InterfaceC23757xT2
    public boolean i(int i) {
        return this.a.sendEmptyMessage(i);
    }

    @Override // ir.nasim.InterfaceC23757xT2
    public boolean j(int i, long j) {
        return this.a.sendEmptyMessageAtTime(i, j);
    }

    @Override // ir.nasim.InterfaceC23757xT2
    public void k(int i) {
        this.a.removeMessages(i);
    }
}
