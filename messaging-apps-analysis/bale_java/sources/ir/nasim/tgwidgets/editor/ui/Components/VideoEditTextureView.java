package ir.nasim.tgwidgets.editor.ui.Components;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.view.Surface;
import android.view.TextureView;
import ir.nasim.DK5;
import ir.nasim.FT7;
import ir.nasim.tgwidgets.editor.ui.Components.k;
import ir.nasim.tgwidgets.editor.ui.stories.recorder.l;

/* loaded from: classes7.dex */
public class VideoEditTextureView extends TextureView implements TextureView.SurfaceTextureListener {
    private FT7 a;
    private k b;
    private DK5 c;
    private int d;
    private int e;
    public l.b f;
    private a g;

    public interface a {
        void a(k kVar);
    }

    public VideoEditTextureView(Context context, FT7 ft7) {
        super(context);
        this.c = new DK5();
        this.a = ft7;
        setSurfaceTextureListener(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void d(SurfaceTexture surfaceTexture) {
        if (this.a == null) {
            return;
        }
        this.a.Q1(new Surface(surfaceTexture));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void e() {
        k kVar = this.b;
        if (kVar != null) {
            kVar.m0(false, true, false);
        }
    }

    public boolean c(float f, float f2) {
        DK5 dk5 = this.c;
        float f3 = dk5.a;
        if (f >= f3 && f <= f3 + dk5.c) {
            float f4 = dk5.b;
            if (f2 >= f4 && f2 <= f4 + dk5.d) {
                return true;
            }
        }
        return false;
    }

    public void f() {
        k kVar = this.b;
        if (kVar != null) {
            kVar.r0();
        }
        this.a = null;
    }

    public int getVideoHeight() {
        return this.e;
    }

    public int getVideoWidth() {
        return this.d;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
        int i3;
        if (this.b != null || surfaceTexture == null || this.a == null) {
            return;
        }
        k kVar = new k(surfaceTexture, new k.b() { // from class: ir.nasim.YS7
            @Override // ir.nasim.tgwidgets.editor.ui.Components.k.b
            public final void a(SurfaceTexture surfaceTexture2) {
                this.a.d(surfaceTexture2);
            }
        }, this.f);
        this.b = kVar;
        int i4 = this.d;
        if (i4 != 0 && (i3 = this.e) != 0) {
            kVar.q0(i4, i3);
        }
        this.b.p0(i, i2);
        this.b.m0(true, true, false);
        a aVar = this.g;
        if (aVar != null) {
            aVar.a(this.b);
        }
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        k kVar = this.b;
        if (kVar == null) {
            return true;
        }
        kVar.r0();
        this.b = null;
        return true;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
        k kVar = this.b;
        if (kVar != null) {
            kVar.p0(i, i2);
            this.b.m0(false, true, false);
            this.b.i(new Runnable() { // from class: ir.nasim.XS7
                @Override // java.lang.Runnable
                public final void run() {
                    this.a.e();
                }
            });
        }
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
    }

    public void setDelegate(a aVar) {
        this.g = aVar;
        k kVar = this.b;
        if (kVar != null) {
            if (aVar == null) {
                kVar.n0(null);
            } else {
                aVar.a(kVar);
            }
        }
    }

    public void setHDRInfo(l.b bVar) {
        this.f = bVar;
        k kVar = this.b;
        if (kVar != null) {
            kVar.s0(bVar);
        }
    }

    public void setVideoSize(int i, int i2) {
        this.d = i;
        this.e = i2;
        k kVar = this.b;
        if (kVar == null) {
            return;
        }
        kVar.q0(i, i2);
    }

    public void setViewRect(float f, float f2, float f3, float f4) {
        DK5 dk5 = this.c;
        dk5.a = f;
        dk5.b = f2;
        dk5.c = f3;
        dk5.d = f4;
    }
}
