package com.google.android.exoplayer2.video;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.view.Surface;
import com.google.android.exoplayer2.util.GlUtil;
import ir.nasim.AbstractC18815pI3;
import ir.nasim.AbstractC20011rK;

/* loaded from: classes2.dex */
public final class PlaceholderSurface extends Surface {
    private static int d;
    private static boolean e;
    public final boolean a;
    private final b b;
    private boolean c;

    private static class b extends HandlerThread implements Handler.Callback {
        private com.google.android.exoplayer2.util.a a;
        private Handler b;
        private Error c;
        private RuntimeException d;
        private PlaceholderSurface e;

        public b() {
            super("ExoPlayer:PlaceholderSurface");
        }

        private void b(int i) throws GlUtil.GlException {
            AbstractC20011rK.e(this.a);
            this.a.h(i);
            this.e = new PlaceholderSurface(this, this.a.g(), i != 0);
        }

        private void d() {
            AbstractC20011rK.e(this.a);
            this.a.i();
        }

        public PlaceholderSurface a(int i) {
            boolean z;
            start();
            this.b = new Handler(getLooper(), this);
            this.a = new com.google.android.exoplayer2.util.a(this.b);
            synchronized (this) {
                z = false;
                this.b.obtainMessage(1, i, 0).sendToTarget();
                while (this.e == null && this.d == null && this.c == null) {
                    try {
                        wait();
                    } catch (InterruptedException unused) {
                        z = true;
                    }
                }
            }
            if (z) {
                Thread.currentThread().interrupt();
            }
            RuntimeException runtimeException = this.d;
            if (runtimeException != null) {
                throw runtimeException;
            }
            Error error = this.c;
            if (error == null) {
                return (PlaceholderSurface) AbstractC20011rK.e(this.e);
            }
            throw error;
        }

        public void c() {
            AbstractC20011rK.e(this.b);
            this.b.sendEmptyMessage(2);
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            int i = message.what;
            try {
                if (i != 1) {
                    if (i != 2) {
                        return true;
                    }
                    try {
                        d();
                    } finally {
                        try {
                            return true;
                        } finally {
                        }
                    }
                    return true;
                }
                try {
                    b(message.arg1);
                    synchronized (this) {
                        notify();
                    }
                } catch (GlUtil.GlException e) {
                    AbstractC18815pI3.d("PlaceholderSurface", "Failed to initialize placeholder surface", e);
                    this.d = new IllegalStateException(e);
                    synchronized (this) {
                        notify();
                    }
                } catch (Error e2) {
                    AbstractC18815pI3.d("PlaceholderSurface", "Failed to initialize placeholder surface", e2);
                    this.c = e2;
                    synchronized (this) {
                        notify();
                    }
                } catch (RuntimeException e3) {
                    AbstractC18815pI3.d("PlaceholderSurface", "Failed to initialize placeholder surface", e3);
                    this.d = e3;
                    synchronized (this) {
                        notify();
                    }
                }
                return true;
            } catch (Throwable th) {
                synchronized (this) {
                    notify();
                    throw th;
                }
            }
        }
    }

    private static int a(Context context) {
        if (GlUtil.h(context)) {
            return GlUtil.i() ? 1 : 2;
        }
        return 0;
    }

    public static synchronized boolean b(Context context) {
        try {
            if (!e) {
                d = a(context);
                e = true;
            }
        } catch (Throwable th) {
            throw th;
        }
        return d != 0;
    }

    public static PlaceholderSurface c(Context context, boolean z) {
        AbstractC20011rK.g(!z || b(context));
        return new b().a(z ? d : 0);
    }

    @Override // android.view.Surface
    public void release() {
        super.release();
        synchronized (this.b) {
            try {
                if (!this.c) {
                    this.b.c();
                    this.c = true;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private PlaceholderSurface(b bVar, SurfaceTexture surfaceTexture, boolean z) {
        super(surfaceTexture);
        this.b = bVar;
        this.a = z;
    }
}
