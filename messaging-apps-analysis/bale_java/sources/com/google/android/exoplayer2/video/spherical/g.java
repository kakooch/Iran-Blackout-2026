package com.google.android.exoplayer2.video.spherical;

import android.graphics.SurfaceTexture;
import android.media.MediaFormat;
import android.opengl.GLES20;
import android.opengl.Matrix;
import com.google.android.exoplayer2.X;
import com.google.android.exoplayer2.util.GlUtil;
import ir.nasim.AbstractC18815pI3;
import ir.nasim.AbstractC20011rK;
import ir.nasim.C22209uq7;
import ir.nasim.InterfaceC19509qT7;
import ir.nasim.InterfaceC21161tD0;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes2.dex */
final class g implements InterfaceC19509qT7, InterfaceC21161tD0 {
    private int i;
    private SurfaceTexture j;
    private byte[] m;
    private final AtomicBoolean a = new AtomicBoolean();
    private final AtomicBoolean b = new AtomicBoolean(true);
    private final e c = new e();
    private final a d = new a();
    private final C22209uq7 e = new C22209uq7();
    private final C22209uq7 f = new C22209uq7();
    private final float[] g = new float[16];
    private final float[] h = new float[16];
    private volatile int k = 0;
    private int l = -1;

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void g(SurfaceTexture surfaceTexture) {
        this.a.set(true);
    }

    private void i(byte[] bArr, int i, long j) {
        byte[] bArr2 = this.m;
        int i2 = this.l;
        this.m = bArr;
        if (i == -1) {
            i = this.k;
        }
        this.l = i;
        if (i2 == i && Arrays.equals(bArr2, this.m)) {
            return;
        }
        byte[] bArr3 = this.m;
        c cVarA = bArr3 != null ? d.a(bArr3, this.l) : null;
        if (cVarA == null || !e.c(cVarA)) {
            cVarA = c.b(this.l);
        }
        this.f.a(j, cVarA);
    }

    @Override // ir.nasim.InterfaceC19509qT7
    public void a(long j, long j2, X x, MediaFormat mediaFormat) {
        this.e.a(j2, Long.valueOf(j));
        i(x.v, x.w, j2);
    }

    @Override // ir.nasim.InterfaceC21161tD0
    public void b(long j, float[] fArr) {
        this.d.e(j, fArr);
    }

    @Override // ir.nasim.InterfaceC21161tD0
    public void c() {
        this.e.c();
        this.d.d();
        this.b.set(true);
    }

    public void e(float[] fArr, boolean z) {
        GLES20.glClear(16384);
        try {
            GlUtil.b();
        } catch (GlUtil.GlException e) {
            AbstractC18815pI3.d("SceneRenderer", "Failed to draw a frame", e);
        }
        if (this.a.compareAndSet(true, false)) {
            ((SurfaceTexture) AbstractC20011rK.e(this.j)).updateTexImage();
            try {
                GlUtil.b();
            } catch (GlUtil.GlException e2) {
                AbstractC18815pI3.d("SceneRenderer", "Failed to draw a frame", e2);
            }
            if (this.b.compareAndSet(true, false)) {
                GlUtil.j(this.g);
            }
            long timestamp = this.j.getTimestamp();
            Long l = (Long) this.e.g(timestamp);
            if (l != null) {
                this.d.c(this.g, l.longValue());
            }
            c cVar = (c) this.f.j(timestamp);
            if (cVar != null) {
                this.c.d(cVar);
            }
        }
        Matrix.multiplyMM(this.h, 0, fArr, 0, this.g, 0);
        this.c.a(this.i, this.h, z);
    }

    public SurfaceTexture f() {
        try {
            GLES20.glClearColor(0.5f, 0.5f, 0.5f, 1.0f);
            GlUtil.b();
            this.c.b();
            GlUtil.b();
            this.i = GlUtil.f();
        } catch (GlUtil.GlException e) {
            AbstractC18815pI3.d("SceneRenderer", "Failed to initialize the renderer", e);
        }
        SurfaceTexture surfaceTexture = new SurfaceTexture(this.i);
        this.j = surfaceTexture;
        surfaceTexture.setOnFrameAvailableListener(new SurfaceTexture.OnFrameAvailableListener() { // from class: com.google.android.exoplayer2.video.spherical.f
            @Override // android.graphics.SurfaceTexture.OnFrameAvailableListener
            public final void onFrameAvailable(SurfaceTexture surfaceTexture2) {
                this.a.g(surfaceTexture2);
            }
        });
        return this.j;
    }

    public void h(int i) {
        this.k = i;
    }
}
