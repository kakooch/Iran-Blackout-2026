package ir.nasim;

import androidx.recyclerview.widget.RecyclerView;
import com.google.android.exoplayer2.decoder.DecoderException;
import com.google.android.exoplayer2.decoder.DecoderInputBuffer;
import java.util.ArrayDeque;

/* loaded from: classes2.dex */
public abstract class EC6 implements DB1 {
    private final Thread a;
    private final Object b = new Object();
    private final ArrayDeque c = new ArrayDeque();
    private final ArrayDeque d = new ArrayDeque();
    private final DecoderInputBuffer[] e;
    private final KB1[] f;
    private int g;
    private int h;
    private DecoderInputBuffer i;
    private DecoderException j;
    private boolean k;
    private boolean l;
    private int m;

    class a extends Thread {
        a(String str) {
            super(str);
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            EC6.this.t();
        }
    }

    protected EC6(DecoderInputBuffer[] decoderInputBufferArr, KB1[] kb1Arr) {
        this.e = decoderInputBufferArr;
        this.g = decoderInputBufferArr.length;
        for (int i = 0; i < this.g; i++) {
            this.e[i] = g();
        }
        this.f = kb1Arr;
        this.h = kb1Arr.length;
        for (int i2 = 0; i2 < this.h; i2++) {
            this.f[i2] = h();
        }
        a aVar = new a("ExoPlayer:SimpleDecoder");
        this.a = aVar;
        aVar.start();
    }

    private boolean f() {
        return !this.c.isEmpty() && this.h > 0;
    }

    private boolean k() {
        DecoderException decoderExceptionI;
        synchronized (this.b) {
            while (!this.l && !f()) {
                try {
                    this.b.wait();
                } finally {
                }
            }
            if (this.l) {
                return false;
            }
            DecoderInputBuffer decoderInputBuffer = (DecoderInputBuffer) this.c.removeFirst();
            KB1[] kb1Arr = this.f;
            int i = this.h - 1;
            this.h = i;
            KB1 kb1 = kb1Arr[i];
            boolean z = this.k;
            this.k = false;
            if (decoderInputBuffer.u()) {
                kb1.o(4);
            } else {
                if (decoderInputBuffer.t()) {
                    kb1.o(RecyclerView.UNDEFINED_DURATION);
                }
                if (decoderInputBuffer.v()) {
                    kb1.o(134217728);
                }
                try {
                    decoderExceptionI = j(decoderInputBuffer, kb1, z);
                } catch (OutOfMemoryError e) {
                    decoderExceptionI = i(e);
                } catch (RuntimeException e2) {
                    decoderExceptionI = i(e2);
                }
                if (decoderExceptionI != null) {
                    synchronized (this.b) {
                        this.j = decoderExceptionI;
                    }
                    return false;
                }
            }
            synchronized (this.b) {
                try {
                    if (this.k) {
                        kb1.y();
                    } else if (kb1.t()) {
                        this.m++;
                        kb1.y();
                    } else {
                        kb1.c = this.m;
                        this.m = 0;
                        this.d.addLast(kb1);
                    }
                    q(decoderInputBuffer);
                } finally {
                }
            }
            return true;
        }
    }

    private void n() {
        if (f()) {
            this.b.notify();
        }
    }

    private void o() throws DecoderException {
        DecoderException decoderException = this.j;
        if (decoderException != null) {
            throw decoderException;
        }
    }

    private void q(DecoderInputBuffer decoderInputBuffer) {
        decoderInputBuffer.p();
        DecoderInputBuffer[] decoderInputBufferArr = this.e;
        int i = this.g;
        this.g = i + 1;
        decoderInputBufferArr[i] = decoderInputBuffer;
    }

    private void s(KB1 kb1) {
        kb1.p();
        KB1[] kb1Arr = this.f;
        int i = this.h;
        this.h = i + 1;
        kb1Arr[i] = kb1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t() {
        do {
            try {
            } catch (InterruptedException e) {
                throw new IllegalStateException(e);
            }
        } while (k());
    }

    @Override // ir.nasim.DB1
    public final void flush() {
        synchronized (this.b) {
            try {
                this.k = true;
                this.m = 0;
                DecoderInputBuffer decoderInputBuffer = this.i;
                if (decoderInputBuffer != null) {
                    q(decoderInputBuffer);
                    this.i = null;
                }
                while (!this.c.isEmpty()) {
                    q((DecoderInputBuffer) this.c.removeFirst());
                }
                while (!this.d.isEmpty()) {
                    ((KB1) this.d.removeFirst()).y();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    protected abstract DecoderInputBuffer g();

    protected abstract KB1 h();

    protected abstract DecoderException i(Throwable th);

    protected abstract DecoderException j(DecoderInputBuffer decoderInputBuffer, KB1 kb1, boolean z);

    @Override // ir.nasim.DB1
    /* renamed from: l, reason: merged with bridge method [inline-methods] */
    public final DecoderInputBuffer d() {
        DecoderInputBuffer decoderInputBuffer;
        synchronized (this.b) {
            o();
            AbstractC20011rK.g(this.i == null);
            int i = this.g;
            if (i == 0) {
                decoderInputBuffer = null;
            } else {
                DecoderInputBuffer[] decoderInputBufferArr = this.e;
                int i2 = i - 1;
                this.g = i2;
                decoderInputBuffer = decoderInputBufferArr[i2];
            }
            this.i = decoderInputBuffer;
        }
        return decoderInputBuffer;
    }

    @Override // ir.nasim.DB1
    /* renamed from: m, reason: merged with bridge method [inline-methods] */
    public final KB1 b() {
        synchronized (this.b) {
            try {
                o();
                if (this.d.isEmpty()) {
                    return null;
                }
                return (KB1) this.d.removeFirst();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // ir.nasim.DB1
    /* renamed from: p, reason: merged with bridge method [inline-methods] */
    public final void c(DecoderInputBuffer decoderInputBuffer) {
        synchronized (this.b) {
            o();
            AbstractC20011rK.a(decoderInputBuffer == this.i);
            this.c.addLast(decoderInputBuffer);
            n();
            this.i = null;
        }
    }

    protected void r(KB1 kb1) {
        synchronized (this.b) {
            s(kb1);
            n();
        }
    }

    @Override // ir.nasim.DB1
    public void release() throws InterruptedException {
        synchronized (this.b) {
            this.l = true;
            this.b.notify();
        }
        try {
            this.a.join();
        } catch (InterruptedException unused) {
            Thread.currentThread().interrupt();
        }
    }

    protected final void u(int i) {
        AbstractC20011rK.g(this.g == this.e.length);
        for (DecoderInputBuffer decoderInputBuffer : this.e) {
            decoderInputBuffer.z(i);
        }
    }
}
