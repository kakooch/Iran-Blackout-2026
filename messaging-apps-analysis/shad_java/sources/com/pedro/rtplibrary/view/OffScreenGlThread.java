package com.pedro.rtplibrary.view;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.view.Surface;
import com.pedro.encoder.input.gl.SurfaceManager;
import com.pedro.encoder.input.gl.render.ManagerRender;
import com.pedro.encoder.input.video.FpsLimiter;
import com.pedro.encoder.utils.gl.GlUtil;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.Semaphore;

/* loaded from: classes3.dex */
public class OffScreenGlThread implements GlInterface, Runnable, SurfaceTexture.OnFrameAvailableListener {
    private final Context context;
    private int encoderHeight;
    private int encoderWidth;
    private int streamRotation;
    private TakePhotoCallback takePhotoCallback;
    private Thread thread = null;
    private boolean frameAvailable = false;
    private boolean running = true;
    private boolean initialized = false;
    private SurfaceManager surfaceManager = null;
    private SurfaceManager surfaceManagerEncoder = null;
    private ManagerRender textureManager = null;
    private final Semaphore semaphore = new Semaphore(0);
    private final BlockingQueue<Filter> filterQueue = new LinkedBlockingQueue();
    private final Object sync = new Object();
    private boolean loadAA = false;
    private boolean AAEnabled = false;
    private FpsLimiter fpsLimiter = new FpsLimiter();

    public OffScreenGlThread(Context context) {
        this.context = context;
    }

    @Override // com.pedro.rtplibrary.view.GlInterface
    public void init() {
        if (!this.initialized) {
            this.textureManager = new ManagerRender();
        }
        this.textureManager.setCameraFlip(false, false);
        this.initialized = true;
    }

    @Override // com.pedro.rtplibrary.view.GlInterface
    public void setEncoderSize(int i, int i2) {
        this.encoderWidth = i;
        this.encoderHeight = i2;
    }

    @Override // com.pedro.rtplibrary.view.GlInterface
    public void setFps(int i) {
        this.fpsLimiter.setFPS(i);
    }

    @Override // com.pedro.rtplibrary.view.GlInterface
    public SurfaceTexture getSurfaceTexture() {
        return this.textureManager.getSurfaceTexture();
    }

    @Override // com.pedro.rtplibrary.view.GlInterface
    public void addMediaCodecSurface(Surface surface) {
        synchronized (this.sync) {
            this.surfaceManagerEncoder = new SurfaceManager(surface, this.surfaceManager);
        }
    }

    @Override // com.pedro.rtplibrary.view.GlInterface
    public void removeMediaCodecSurface() {
        synchronized (this.sync) {
            SurfaceManager surfaceManager = this.surfaceManagerEncoder;
            if (surfaceManager != null) {
                surfaceManager.release();
                this.surfaceManagerEncoder = null;
            }
        }
    }

    @Override // com.pedro.rtplibrary.view.GlInterface
    public void setRotation(int i) {
        this.textureManager.setCameraRotation(i);
    }

    @Override // com.pedro.rtplibrary.view.GlInterface
    public void start() {
        synchronized (this.sync) {
            Thread thread = new Thread(this);
            this.thread = thread;
            this.running = true;
            thread.start();
            this.semaphore.acquireUninterruptibly();
        }
    }

    @Override // com.pedro.rtplibrary.view.GlInterface
    public void stop() {
        synchronized (this.sync) {
            Thread thread = this.thread;
            if (thread != null) {
                thread.interrupt();
                try {
                    this.thread.join(100L);
                } catch (InterruptedException unused) {
                    this.thread.interrupt();
                }
                this.thread = null;
                this.running = false;
            } else {
                this.running = false;
            }
        }
    }

    private void releaseSurfaceManager() {
        SurfaceManager surfaceManager = this.surfaceManager;
        if (surfaceManager != null) {
            surfaceManager.release();
            this.surfaceManager = null;
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        releaseSurfaceManager();
        SurfaceManager surfaceManager = new SurfaceManager();
        this.surfaceManager = surfaceManager;
        surfaceManager.makeCurrent();
        ManagerRender managerRender = this.textureManager;
        Context context = this.context;
        int i = this.encoderWidth;
        int i2 = this.encoderHeight;
        managerRender.initGl(context, i, i2, i, i2);
        this.textureManager.getSurfaceTexture().setOnFrameAvailableListener(this);
        this.semaphore.release();
        while (this.running) {
            try {
                try {
                    if (this.frameAvailable) {
                        this.frameAvailable = false;
                        this.surfaceManager.makeCurrent();
                        this.textureManager.updateFrame();
                        this.textureManager.drawOffScreen();
                        this.textureManager.drawScreen(this.encoderWidth, this.encoderHeight, false, 0, 0, true);
                        this.surfaceManager.swapBuffer();
                        synchronized (this.sync) {
                            if (this.surfaceManagerEncoder != null && !this.fpsLimiter.limitFPS()) {
                                this.surfaceManagerEncoder.makeCurrent();
                                this.textureManager.drawScreen(this.encoderWidth, this.encoderHeight, false, 0, this.streamRotation, false);
                                this.surfaceManagerEncoder.swapBuffer();
                            }
                            TakePhotoCallback takePhotoCallback = this.takePhotoCallback;
                            if (takePhotoCallback != null) {
                                int i3 = this.encoderWidth;
                                int i4 = this.encoderHeight;
                                takePhotoCallback.onTakePhoto(GlUtil.getBitmap(i3, i4, i3, i4));
                                this.takePhotoCallback = null;
                            }
                        }
                        if (!this.filterQueue.isEmpty()) {
                            Filter filterTake = this.filterQueue.take();
                            this.textureManager.setFilter(filterTake.getPosition(), filterTake.getBaseFilterRender());
                        } else if (this.loadAA) {
                            this.textureManager.enableAA(this.AAEnabled);
                            this.loadAA = false;
                        }
                    }
                } catch (InterruptedException unused) {
                    Thread.currentThread().interrupt();
                }
            } finally {
                this.textureManager.release();
                releaseSurfaceManager();
            }
        }
    }

    @Override // android.graphics.SurfaceTexture.OnFrameAvailableListener
    public void onFrameAvailable(SurfaceTexture surfaceTexture) {
        synchronized (this.sync) {
            this.frameAvailable = true;
            this.sync.notifyAll();
        }
    }
}
