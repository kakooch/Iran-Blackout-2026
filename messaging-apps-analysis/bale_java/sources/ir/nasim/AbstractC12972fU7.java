package ir.nasim;

import ir.nasim.tgwidgets.editor.messenger.AbstractC21455b;
import ir.nasim.tgwidgets.editor.ui.Components.PhotoViewerWebView;

/* renamed from: ir.nasim.fU7, reason: case insensitive filesystem */
/* loaded from: classes7.dex */
public abstract class AbstractC12972fU7 {
    public int a;
    private boolean b;
    public boolean c;
    private long d;
    private Runnable e;
    private long f;
    private long g;
    private long h;
    private FT7 j;
    private PhotoViewerWebView k;
    private float i = 1.0f;
    private final Runnable l = new a();

    /* renamed from: ir.nasim.fU7$a */
    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (AbstractC12972fU7.this.j == null && AbstractC12972fU7.this.k == null) {
                return;
            }
            long jQ = AbstractC12972fU7.this.q();
            if (jQ == 0 || jQ == -9223372036854775807L) {
                AbstractC12972fU7.this.f = System.currentTimeMillis();
                return;
            }
            long jCurrentTimeMillis = System.currentTimeMillis();
            long j = jCurrentTimeMillis - AbstractC12972fU7.this.f;
            AbstractC12972fU7.this.f = jCurrentTimeMillis;
            AbstractC12972fU7 abstractC12972fU7 = AbstractC12972fU7.this;
            int i = abstractC12972fU7.a;
            long j2 = j * (i == 1 ? 3L : i == 2 ? 6L : 12L);
            if (abstractC12972fU7.b) {
                AbstractC12972fU7.this.h += j2;
            } else {
                AbstractC12972fU7.this.h -= j2;
            }
            if (AbstractC12972fU7.this.h < 0) {
                AbstractC12972fU7.this.h = 0L;
            } else if (AbstractC12972fU7.this.h > jQ) {
                AbstractC12972fU7.this.h = jQ;
            }
            AbstractC12972fU7 abstractC12972fU72 = AbstractC12972fU7.this;
            if (abstractC12972fU72.c && abstractC12972fU72.f - AbstractC12972fU7.this.g > 350) {
                AbstractC12972fU7 abstractC12972fU73 = AbstractC12972fU7.this;
                abstractC12972fU73.g = abstractC12972fU73.f;
                AbstractC12972fU7 abstractC12972fU74 = AbstractC12972fU7.this;
                abstractC12972fU74.w(abstractC12972fU74.h);
            }
            AbstractC12972fU7 abstractC12972fU75 = AbstractC12972fU7.this;
            abstractC12972fU75.A(AbstractC12972fU7.this.h - AbstractC12972fU7.this.d, AbstractC12972fU7.this.h / AbstractC12972fU7.this.q(), abstractC12972fU75.c);
            if (AbstractC12972fU7.this.h == 0 || AbstractC12972fU7.this.h >= jQ) {
                AbstractC12972fU7 abstractC12972fU76 = AbstractC12972fU7.this;
                if (abstractC12972fU76.c) {
                    abstractC12972fU76.g = abstractC12972fU76.f;
                    AbstractC12972fU7 abstractC12972fU77 = AbstractC12972fU7.this;
                    abstractC12972fU77.w(abstractC12972fU77.h);
                }
                AbstractC12972fU7.this.o();
            }
            AbstractC12972fU7 abstractC12972fU78 = AbstractC12972fU7.this;
            if (abstractC12972fU78.a > 0) {
                AbstractC21455b.n1(abstractC12972fU78.l, 16L);
            }
        }
    }

    private long p() {
        if (this.k != null) {
            return r0.getCurrentPosition();
        }
        FT7 ft7 = this.j;
        if (ft7 == null) {
            return 0L;
        }
        return ft7.s1();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public long q() {
        if (this.k != null) {
            return r0.getVideoDuration();
        }
        FT7 ft7 = this.j;
        if (ft7 == null) {
            return 0L;
        }
        return ft7.u1();
    }

    private void r() {
        if (this.j == null && this.k == null) {
            return;
        }
        int i = this.a + 1;
        this.a = i;
        boolean z = false;
        if (i == 1) {
            if (this.b && s()) {
                this.c = false;
            } else {
                this.c = true;
            }
        }
        if (!this.b || this.c) {
            int i2 = this.a;
            if (i2 == 1 || i2 == 2) {
                z = true;
            }
        } else {
            int i3 = this.a;
            if (i3 == 1) {
                x(4.0f);
            } else if (i3 == 2) {
                x(7.0f);
            } else {
                x(13.0f);
            }
            z = true;
        }
        if (this.a == 1) {
            this.h = p();
            long jCurrentTimeMillis = System.currentTimeMillis();
            this.f = jCurrentTimeMillis;
            this.g = jCurrentTimeMillis;
            this.d = p();
            v(this.b);
        }
        AbstractC21455b.t(this.l);
        AbstractC21455b.m1(this.l);
        if (z) {
            Runnable runnable = this.e;
            if (runnable != null) {
                AbstractC21455b.t(runnable);
            }
            Runnable runnable2 = new Runnable() { // from class: ir.nasim.eU7
                @Override // java.lang.Runnable
                public final void run() {
                    this.a.t();
                }
            };
            this.e = runnable2;
            AbstractC21455b.n1(runnable2, 2000L);
        }
    }

    private boolean s() {
        PhotoViewerWebView photoViewerWebView = this.k;
        if (photoViewerWebView != null) {
            return photoViewerWebView.K();
        }
        FT7 ft7 = this.j;
        if (ft7 == null) {
            return false;
        }
        return ft7.A1();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void t() {
        this.e = null;
        r();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w(long j) {
        PhotoViewerWebView photoViewerWebView = this.k;
        if (photoViewerWebView != null) {
            photoViewerWebView.V(j);
            return;
        }
        FT7 ft7 = this.j;
        if (ft7 == null) {
            return;
        }
        ft7.I1(j);
    }

    private void x(float f) {
        PhotoViewerWebView photoViewerWebView = this.k;
        if (photoViewerWebView != null) {
            photoViewerWebView.setPlaybackSpeed(f);
            return;
        }
        FT7 ft7 = this.j;
        if (ft7 == null) {
            return;
        }
        ft7.O1(f);
    }

    protected abstract void A(long j, float f, boolean z);

    public void o() {
        if (this.a != 0) {
            this.a = 0;
            if (this.j != null || this.k != null) {
                if (this.c) {
                    w(this.h);
                } else {
                    w(p());
                }
                x(this.i);
            }
        }
        AbstractC21455b.t(this.l);
        Runnable runnable = this.e;
        if (runnable != null) {
            AbstractC21455b.t(runnable);
            this.e = null;
        }
        u();
    }

    protected abstract void u();

    protected abstract void v(boolean z);

    public void y(FT7 ft7, boolean z, float f) {
        this.j = ft7;
        this.i = f;
        this.b = z;
        o();
        r();
    }

    public void z(PhotoViewerWebView photoViewerWebView, boolean z, float f) {
        this.k = photoViewerWebView;
        this.i = f;
        this.b = z;
        o();
        r();
    }
}
