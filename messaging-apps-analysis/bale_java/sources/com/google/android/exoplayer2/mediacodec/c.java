package com.google.android.exoplayer2.mediacodec;

import android.media.MediaCodec;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import ir.nasim.AbstractC16775lq5;
import ir.nasim.AbstractC20011rK;
import ir.nasim.AbstractC9683aN7;
import ir.nasim.C3962Dc1;
import ir.nasim.C8171Uv1;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes2.dex */
class c {
    private static final ArrayDeque g = new ArrayDeque();
    private static final Object h = new Object();
    private final MediaCodec a;
    private final HandlerThread b;
    private Handler c;
    private final AtomicReference d;
    private final C3962Dc1 e;
    private boolean f;

    class a extends Handler {
        a(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) throws MediaCodec.CryptoException {
            c.this.f(message);
        }
    }

    private static class b {
        public int a;
        public int b;
        public int c;
        public final MediaCodec.CryptoInfo d = new MediaCodec.CryptoInfo();
        public long e;
        public int f;

        b() {
        }

        public void a(int i, int i2, int i3, long j, int i4) {
            this.a = i;
            this.b = i2;
            this.c = i3;
            this.e = j;
            this.f = i4;
        }
    }

    public c(MediaCodec mediaCodec, HandlerThread handlerThread) {
        this(mediaCodec, handlerThread, new C3962Dc1());
    }

    private void b() {
        this.e.d();
        ((Handler) AbstractC20011rK.e(this.c)).obtainMessage(2).sendToTarget();
        this.e.a();
    }

    private static void c(C8171Uv1 c8171Uv1, MediaCodec.CryptoInfo cryptoInfo) {
        cryptoInfo.numSubSamples = c8171Uv1.f;
        cryptoInfo.numBytesOfClearData = e(c8171Uv1.d, cryptoInfo.numBytesOfClearData);
        cryptoInfo.numBytesOfEncryptedData = e(c8171Uv1.e, cryptoInfo.numBytesOfEncryptedData);
        cryptoInfo.key = (byte[]) AbstractC20011rK.e(d(c8171Uv1.b, cryptoInfo.key));
        cryptoInfo.iv = (byte[]) AbstractC20011rK.e(d(c8171Uv1.a, cryptoInfo.iv));
        cryptoInfo.mode = c8171Uv1.c;
        if (AbstractC9683aN7.a >= 24) {
            cryptoInfo.setPattern(new MediaCodec.CryptoInfo.Pattern(c8171Uv1.g, c8171Uv1.h));
        }
    }

    private static byte[] d(byte[] bArr, byte[] bArr2) {
        if (bArr == null) {
            return bArr2;
        }
        if (bArr2 == null || bArr2.length < bArr.length) {
            return Arrays.copyOf(bArr, bArr.length);
        }
        System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
        return bArr2;
    }

    private static int[] e(int[] iArr, int[] iArr2) {
        if (iArr == null) {
            return iArr2;
        }
        if (iArr2 == null || iArr2.length < iArr.length) {
            return Arrays.copyOf(iArr, iArr.length);
        }
        System.arraycopy(iArr, 0, iArr2, 0, iArr.length);
        return iArr2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(Message message) throws MediaCodec.CryptoException {
        b bVar;
        int i = message.what;
        if (i == 0) {
            bVar = (b) message.obj;
            g(bVar.a, bVar.b, bVar.c, bVar.e, bVar.f);
        } else if (i != 1) {
            bVar = null;
            if (i != 2) {
                AbstractC16775lq5.a(this.d, null, new IllegalStateException(String.valueOf(message.what)));
            } else {
                this.e.f();
            }
        } else {
            bVar = (b) message.obj;
            h(bVar.a, bVar.b, bVar.d, bVar.e, bVar.f);
        }
        if (bVar != null) {
            o(bVar);
        }
    }

    private void g(int i, int i2, int i3, long j, int i4) throws MediaCodec.CryptoException {
        try {
            this.a.queueInputBuffer(i, i2, i3, j, i4);
        } catch (RuntimeException e) {
            AbstractC16775lq5.a(this.d, null, e);
        }
    }

    private void h(int i, int i2, MediaCodec.CryptoInfo cryptoInfo, long j, int i3) {
        try {
            synchronized (h) {
                this.a.queueSecureInputBuffer(i, i2, cryptoInfo, j, i3);
            }
        } catch (RuntimeException e) {
            AbstractC16775lq5.a(this.d, null, e);
        }
    }

    private void j() {
        ((Handler) AbstractC20011rK.e(this.c)).removeCallbacksAndMessages(null);
        b();
    }

    private static b k() {
        ArrayDeque arrayDeque = g;
        synchronized (arrayDeque) {
            try {
                if (arrayDeque.isEmpty()) {
                    return new b();
                }
                return (b) arrayDeque.removeFirst();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private void l() {
        RuntimeException runtimeException = (RuntimeException) this.d.getAndSet(null);
        if (runtimeException != null) {
            throw runtimeException;
        }
    }

    private static void o(b bVar) {
        ArrayDeque arrayDeque = g;
        synchronized (arrayDeque) {
            arrayDeque.add(bVar);
        }
    }

    public void i() {
        if (this.f) {
            try {
                j();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                throw new IllegalStateException(e);
            }
        }
    }

    public void m(int i, int i2, int i3, long j, int i4) {
        l();
        b bVarK = k();
        bVarK.a(i, i2, i3, j, i4);
        ((Handler) AbstractC9683aN7.j(this.c)).obtainMessage(0, bVarK).sendToTarget();
    }

    public void n(int i, int i2, C8171Uv1 c8171Uv1, long j, int i3) {
        l();
        b bVarK = k();
        bVarK.a(i, i2, 0, j, i3);
        c(c8171Uv1, bVarK.d);
        ((Handler) AbstractC9683aN7.j(this.c)).obtainMessage(1, bVarK).sendToTarget();
    }

    public void p() {
        if (this.f) {
            i();
            this.b.quit();
        }
        this.f = false;
    }

    public void q() {
        if (this.f) {
            return;
        }
        this.b.start();
        this.c = new a(this.b.getLooper());
        this.f = true;
    }

    public void r() {
        b();
    }

    c(MediaCodec mediaCodec, HandlerThread handlerThread, C3962Dc1 c3962Dc1) {
        this.a = mediaCodec;
        this.b = handlerThread;
        this.e = c3962Dc1;
        this.d = new AtomicReference();
    }
}
