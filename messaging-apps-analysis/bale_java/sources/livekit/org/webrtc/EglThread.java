package livekit.org.webrtc;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.UUID;
import java.util.concurrent.Callable;
import livekit.org.webrtc.EglBase;
import livekit.org.webrtc.EglThread;
import livekit.org.webrtc.RenderSynchronizer;

/* loaded from: classes8.dex */
public class EglThread implements RenderSynchronizer.Listener {
    private final EglBase.EglConnection eglConnection;
    private final HandlerWithExceptionCallbacks handler;
    private final ReleaseMonitor releaseMonitor;
    private final RenderSynchronizer renderSynchronizer;
    private final Map<UUID, RenderUpdate> pendingRenderUpdates = new HashMap();
    private final List<RenderUpdate> pendingRenderUpdatesQueued = new ArrayList();
    private boolean renderWindowOpen = true;

    private static class HandlerWithExceptionCallbacks extends Handler {
        private final Object callbackLock;
        private final List<Runnable> exceptionCallbacks;

        public HandlerWithExceptionCallbacks(Looper looper) {
            super(looper);
            this.callbackLock = new Object();
            this.exceptionCallbacks = new ArrayList();
        }

        public void addExceptionCallback(Runnable runnable) {
            synchronized (this.callbackLock) {
                this.exceptionCallbacks.add(runnable);
            }
        }

        @Override // android.os.Handler
        public void dispatchMessage(Message message) throws Exception {
            try {
                super.dispatchMessage(message);
            } catch (Exception e) {
                Logging.e("EglThread", "Exception on EglThread", e);
                synchronized (this.callbackLock) {
                    try {
                        Iterator<Runnable> it = this.exceptionCallbacks.iterator();
                        while (it.hasNext()) {
                            it.next().run();
                        }
                        throw e;
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            }
        }

        public void removeExceptionCallback(Runnable runnable) {
            synchronized (this.callbackLock) {
                this.exceptionCallbacks.remove(runnable);
            }
        }
    }

    public interface ReleaseMonitor {
        boolean onRelease(EglThread eglThread);
    }

    public interface RenderUpdate {
        void update(boolean z);
    }

    private EglThread(ReleaseMonitor releaseMonitor, HandlerWithExceptionCallbacks handlerWithExceptionCallbacks, EglBase.EglConnection eglConnection, RenderSynchronizer renderSynchronizer) {
        this.releaseMonitor = releaseMonitor;
        this.handler = handlerWithExceptionCallbacks;
        this.eglConnection = eglConnection;
        this.renderSynchronizer = renderSynchronizer;
        if (renderSynchronizer != null) {
            renderSynchronizer.registerListener(this);
        }
    }

    public static EglThread create(ReleaseMonitor releaseMonitor, final EglBase.Context context, final int[] iArr, RenderSynchronizer renderSynchronizer) {
        HandlerThread handlerThread = new HandlerThread("EglThread");
        handlerThread.start();
        HandlerWithExceptionCallbacks handlerWithExceptionCallbacks = new HandlerWithExceptionCallbacks(handlerThread.getLooper());
        EglBase.EglConnection eglConnection = (EglBase.EglConnection) ThreadUtils.invokeAtFrontUninterruptibly(handlerWithExceptionCallbacks, new Callable() { // from class: ir.nasim.w52
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return EglThread.lambda$create$0(context, iArr);
            }
        });
        if (releaseMonitor == null) {
            releaseMonitor = new ReleaseMonitor() { // from class: ir.nasim.x52
                @Override // livekit.org.webrtc.EglThread.ReleaseMonitor
                public final boolean onRelease(EglThread eglThread) {
                    return EglThread.lambda$create$1(eglThread);
                }
            };
        }
        return new EglThread(releaseMonitor, handlerWithExceptionCallbacks, eglConnection, renderSynchronizer);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ EglBase.EglConnection lambda$create$0(EglBase.Context context, int[] iArr) {
        return context == null ? EglBase.EglConnection.createEgl10(iArr) : EglBase.EglConnection.create(context, iArr);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$create$1(EglThread eglThread) {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onRenderWindowClose$3() {
        this.renderWindowOpen = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onRenderWindowOpen$2() {
        this.renderWindowOpen = true;
        Iterator<RenderUpdate> it = this.pendingRenderUpdates.values().iterator();
        while (it.hasNext()) {
            it.next().update(false);
        }
        this.pendingRenderUpdates.clear();
        Iterator<RenderUpdate> it2 = this.pendingRenderUpdatesQueued.iterator();
        while (it2.hasNext()) {
            it2.next().update(false);
        }
        this.pendingRenderUpdatesQueued.clear();
    }

    public void addExceptionCallback(Runnable runnable) {
        this.handler.addExceptionCallback(runnable);
    }

    public EglBase createEglBaseWithSharedConnection() {
        return EglBase.create(this.eglConnection);
    }

    public Handler getHandler() {
        return this.handler;
    }

    @Override // livekit.org.webrtc.RenderSynchronizer.Listener
    public void onRenderWindowClose() {
        this.handler.post(new Runnable() { // from class: ir.nasim.v52
            @Override // java.lang.Runnable
            public final void run() {
                this.a.lambda$onRenderWindowClose$3();
            }
        });
    }

    @Override // livekit.org.webrtc.RenderSynchronizer.Listener
    public void onRenderWindowOpen() {
        this.handler.post(new Runnable() { // from class: ir.nasim.u52
            @Override // java.lang.Runnable
            public final void run() {
                this.a.lambda$onRenderWindowOpen$2();
            }
        });
    }

    public void release() {
        if (this.releaseMonitor.onRelease(this)) {
            RenderSynchronizer renderSynchronizer = this.renderSynchronizer;
            if (renderSynchronizer != null) {
                renderSynchronizer.removeListener(this);
            }
            HandlerWithExceptionCallbacks handlerWithExceptionCallbacks = this.handler;
            final EglBase.EglConnection eglConnection = this.eglConnection;
            Objects.requireNonNull(eglConnection);
            handlerWithExceptionCallbacks.post(new Runnable() { // from class: ir.nasim.t52
                @Override // java.lang.Runnable
                public final void run() {
                    eglConnection.release();
                }
            });
            this.handler.getLooper().quitSafely();
        }
    }

    public void removeExceptionCallback(Runnable runnable) {
        this.handler.removeExceptionCallback(runnable);
    }

    public void scheduleRenderUpdate(UUID uuid, RenderUpdate renderUpdate) {
        if (this.renderWindowOpen) {
            renderUpdate.update(true);
        } else {
            this.pendingRenderUpdates.put(uuid, renderUpdate);
        }
    }

    @Deprecated
    public void scheduleRenderUpdate(RenderUpdate renderUpdate) {
        if (this.renderWindowOpen) {
            renderUpdate.update(true);
        } else {
            this.pendingRenderUpdatesQueued.add(renderUpdate);
        }
    }

    public static EglThread create(ReleaseMonitor releaseMonitor, EglBase.Context context, int[] iArr) {
        return create(releaseMonitor, context, iArr, null);
    }
}
