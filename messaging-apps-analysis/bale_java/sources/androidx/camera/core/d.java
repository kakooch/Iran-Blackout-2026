package androidx.camera.core;

import android.media.Image;
import android.media.ImageReader;
import android.view.Surface;
import ir.nasim.AbstractC11653dN3;
import ir.nasim.O23;
import java.util.concurrent.Executor;

/* loaded from: classes.dex */
class d implements O23 {
    private final ImageReader a;
    private final Object b = new Object();
    private boolean c = true;

    d(ImageReader imageReader) {
        this.a = imageReader;
    }

    private boolean i(RuntimeException runtimeException) {
        return "ImageReaderContext is not initialized".equals(runtimeException.getMessage());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void j(O23.a aVar) {
        aVar.a(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void k(Executor executor, final O23.a aVar, ImageReader imageReader) {
        synchronized (this.b) {
            try {
                if (!this.c) {
                    executor.execute(new Runnable() { // from class: androidx.camera.core.c
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.a.j(aVar);
                        }
                    });
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // ir.nasim.O23
    public f b() {
        Image imageAcquireLatestImage;
        synchronized (this.b) {
            try {
                imageAcquireLatestImage = this.a.acquireLatestImage();
            } catch (RuntimeException e) {
                if (!i(e)) {
                    throw e;
                }
                imageAcquireLatestImage = null;
            }
            if (imageAcquireLatestImage == null) {
                return null;
            }
            return new a(imageAcquireLatestImage);
        }
    }

    @Override // ir.nasim.O23
    public int c() {
        int imageFormat;
        synchronized (this.b) {
            imageFormat = this.a.getImageFormat();
        }
        return imageFormat;
    }

    @Override // ir.nasim.O23
    public void close() {
        synchronized (this.b) {
            this.a.close();
        }
    }

    @Override // ir.nasim.O23
    public void d() {
        synchronized (this.b) {
            this.c = true;
            this.a.setOnImageAvailableListener(null, null);
        }
    }

    @Override // ir.nasim.O23
    public int e() {
        int maxImages;
        synchronized (this.b) {
            maxImages = this.a.getMaxImages();
        }
        return maxImages;
    }

    @Override // ir.nasim.O23
    public void f(final O23.a aVar, final Executor executor) {
        synchronized (this.b) {
            this.c = false;
            this.a.setOnImageAvailableListener(new ImageReader.OnImageAvailableListener() { // from class: androidx.camera.core.b
                @Override // android.media.ImageReader.OnImageAvailableListener
                public final void onImageAvailable(ImageReader imageReader) {
                    this.a.k(executor, aVar, imageReader);
                }
            }, AbstractC11653dN3.a());
        }
    }

    @Override // ir.nasim.O23
    public f g() {
        Image imageAcquireNextImage;
        synchronized (this.b) {
            try {
                imageAcquireNextImage = this.a.acquireNextImage();
            } catch (RuntimeException e) {
                if (!i(e)) {
                    throw e;
                }
                imageAcquireNextImage = null;
            }
            if (imageAcquireNextImage == null) {
                return null;
            }
            return new a(imageAcquireNextImage);
        }
    }

    @Override // ir.nasim.O23
    public int getHeight() {
        int height;
        synchronized (this.b) {
            height = this.a.getHeight();
        }
        return height;
    }

    @Override // ir.nasim.O23
    public Surface getSurface() {
        Surface surface;
        synchronized (this.b) {
            surface = this.a.getSurface();
        }
        return surface;
    }

    @Override // ir.nasim.O23
    public int getWidth() {
        int width;
        synchronized (this.b) {
            width = this.a.getWidth();
        }
        return width;
    }
}
