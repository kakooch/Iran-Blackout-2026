package ir.nasim;

import android.content.Context;
import android.os.Handler;
import android.os.SystemClock;
import androidx.core.os.OperationCanceledException;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;

/* renamed from: ir.nasim.yL, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public abstract class AbstractC24272yL extends AbstractC22455vG3 {
    private final Executor i;
    volatile a j;
    volatile a k;
    long l;
    long m;
    Handler n;

    /* renamed from: ir.nasim.yL$a */
    final class a extends AbstractC16083kg4 implements Runnable {
        private final CountDownLatch k = new CountDownLatch(1);
        boolean l;

        a() {
        }

        @Override // ir.nasim.AbstractC16083kg4
        protected void g(Object obj) {
            try {
                AbstractC24272yL.this.x(this, obj);
            } finally {
                this.k.countDown();
            }
        }

        @Override // ir.nasim.AbstractC16083kg4
        protected void h(Object obj) {
            try {
                AbstractC24272yL.this.y(this, obj);
            } finally {
                this.k.countDown();
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // ir.nasim.AbstractC16083kg4
        /* renamed from: m, reason: merged with bridge method [inline-methods] */
        public Object b(Void... voidArr) {
            try {
                return AbstractC24272yL.this.C();
            } catch (OperationCanceledException e) {
                if (f()) {
                    return null;
                }
                throw e;
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            this.l = false;
            AbstractC24272yL.this.z();
        }
    }

    public AbstractC24272yL(Context context) {
        this(context, AbstractC16083kg4.h);
    }

    public abstract Object A();

    protected Object C() {
        return A();
    }

    @Override // ir.nasim.AbstractC22455vG3
    public void g(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        super.g(str, fileDescriptor, printWriter, strArr);
        if (this.j != null) {
            printWriter.print(str);
            printWriter.print("mTask=");
            printWriter.print(this.j);
            printWriter.print(" waiting=");
            printWriter.println(this.j.l);
        }
        if (this.k != null) {
            printWriter.print(str);
            printWriter.print("mCancellingTask=");
            printWriter.print(this.k);
            printWriter.print(" waiting=");
            printWriter.println(this.k.l);
        }
        if (this.l != 0) {
            printWriter.print(str);
            printWriter.print("mUpdateThrottle=");
            AbstractC18550oq7.c(this.l, printWriter);
            printWriter.print(" mLastLoadCompleteTime=");
            AbstractC18550oq7.b(this.m, SystemClock.uptimeMillis(), printWriter);
            printWriter.println();
        }
    }

    @Override // ir.nasim.AbstractC22455vG3
    protected boolean k() {
        if (this.j == null) {
            return false;
        }
        if (!this.d) {
            this.g = true;
        }
        if (this.k != null) {
            if (this.j.l) {
                this.j.l = false;
                this.n.removeCallbacks(this.j);
            }
            this.j = null;
            return false;
        }
        if (this.j.l) {
            this.j.l = false;
            this.n.removeCallbacks(this.j);
            this.j = null;
            return false;
        }
        boolean zA = this.j.a(false);
        if (zA) {
            this.k = this.j;
            w();
        }
        this.j = null;
        return zA;
    }

    @Override // ir.nasim.AbstractC22455vG3
    protected void m() {
        super.m();
        b();
        this.j = new a();
        z();
    }

    void x(a aVar, Object obj) {
        B(obj);
        if (this.k == aVar) {
            s();
            this.m = SystemClock.uptimeMillis();
            this.k = null;
            e();
            z();
        }
    }

    void y(a aVar, Object obj) {
        if (this.j != aVar) {
            x(aVar, obj);
            return;
        }
        if (i()) {
            B(obj);
            return;
        }
        c();
        this.m = SystemClock.uptimeMillis();
        this.j = null;
        f(obj);
    }

    void z() {
        if (this.k != null || this.j == null) {
            return;
        }
        if (this.j.l) {
            this.j.l = false;
            this.n.removeCallbacks(this.j);
        }
        if (this.l <= 0 || SystemClock.uptimeMillis() >= this.m + this.l) {
            this.j.c(this.i, null);
        } else {
            this.j.l = true;
            this.n.postAtTime(this.j, this.m + this.l);
        }
    }

    private AbstractC24272yL(Context context, Executor executor) {
        super(context);
        this.m = -10000L;
        this.i = executor;
    }

    public void w() {
    }

    public void B(Object obj) {
    }
}
