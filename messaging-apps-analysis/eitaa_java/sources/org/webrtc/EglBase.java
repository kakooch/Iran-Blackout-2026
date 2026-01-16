package org.webrtc;

import android.graphics.SurfaceTexture;
import android.view.Surface;
import java.util.ArrayList;
import org.webrtc.EglBase10;
import org.webrtc.EglBase14;

/* loaded from: classes3.dex */
public interface EglBase {
    public static final int EGL_OPENGL_ES2_BIT = 4;
    public static final int EGL_OPENGL_ES3_BIT = 64;
    public static final int EGL_RECORDABLE_ANDROID = 12610;
    public static final Object lock = new Object();
    public static final int[] CONFIG_PLAIN = CC.configBuilder().createConfigAttributes();
    public static final int[] CONFIG_RGBA = CC.configBuilder().setHasAlphaChannel(true).createConfigAttributes();
    public static final int[] CONFIG_PIXEL_BUFFER = CC.configBuilder().setSupportsPixelBuffer(true).createConfigAttributes();
    public static final int[] CONFIG_PIXEL_RGBA_BUFFER = CC.configBuilder().setHasAlphaChannel(true).setSupportsPixelBuffer(true).createConfigAttributes();
    public static final int[] CONFIG_RECORDABLE = CC.configBuilder().setIsRecordable(true).createConfigAttributes();

    public interface Context {
        public static final long NO_CONTEXT = 0;

        long getNativeEglContext();
    }

    void createBackgroundSurface(SurfaceTexture surface);

    void createDummyPbufferSurface();

    void createPbufferSurface(int width, int height);

    void createSurface(SurfaceTexture surfaceTexture);

    void createSurface(Surface surface);

    void detachCurrent();

    Context getEglBaseContext();

    boolean hasBackgroundSurface();

    boolean hasSurface();

    void makeBackgroundCurrent();

    void makeCurrent();

    void release();

    void releaseSurface(boolean background);

    int surfaceHeight();

    int surfaceWidth();

    void swapBuffers(long presentationTimeStampNs, boolean background);

    void swapBuffers(boolean background);

    /* renamed from: org.webrtc.EglBase$-CC, reason: invalid class name */
    public final /* synthetic */ class CC {
        public static ConfigBuilder configBuilder() {
            return new ConfigBuilder();
        }

        public static int getOpenGlesVersionFromConfig(int[] configAttributes) {
            for (int i = 0; i < configAttributes.length - 1; i++) {
                if (configAttributes[i] == 12352) {
                    int i2 = configAttributes[i + 1];
                    if (i2 != 4) {
                        return i2 != 64 ? 1 : 3;
                    }
                    return 2;
                }
            }
            return 1;
        }

        public static EglBase create(Context sharedContext, int[] configAttributes) {
            if (sharedContext == null) {
                return EglBase14Impl.isEGL14Supported() ? createEgl14(configAttributes) : createEgl10(configAttributes);
            }
            if (sharedContext instanceof EglBase14.Context) {
                return createEgl14((EglBase14.Context) sharedContext, configAttributes);
            }
            if (sharedContext instanceof EglBase10.Context) {
                return createEgl10((EglBase10.Context) sharedContext, configAttributes);
            }
            throw new IllegalArgumentException("Unrecognized Context");
        }

        public static EglBase10 createEgl10(int[] configAttributes) {
            return new EglBase10Impl(null, configAttributes);
        }

        public static EglBase10 createEgl10(EglBase10.Context sharedContext, int[] configAttributes) {
            return new EglBase10Impl(sharedContext == null ? null : sharedContext.getRawContext(), configAttributes);
        }

        public static EglBase14 createEgl14(int[] configAttributes) {
            return new EglBase14Impl(null, configAttributes);
        }

        public static EglBase14 createEgl14(EglBase14.Context sharedContext, int[] configAttributes) {
            return new EglBase14Impl(sharedContext == null ? null : sharedContext.getRawContext(), configAttributes);
        }
    }

    public static class ConfigBuilder {
        private boolean hasAlphaChannel;
        private boolean isRecordable;
        private int openGlesVersion = 2;
        private boolean supportsPixelBuffer;

        public ConfigBuilder setOpenGlesVersion(int version) {
            if (version < 1 || version > 3) {
                throw new IllegalArgumentException("OpenGL ES version " + version + " not supported");
            }
            this.openGlesVersion = version;
            return this;
        }

        public ConfigBuilder setHasAlphaChannel(boolean hasAlphaChannel) {
            this.hasAlphaChannel = hasAlphaChannel;
            return this;
        }

        public ConfigBuilder setSupportsPixelBuffer(boolean supportsPixelBuffer) {
            this.supportsPixelBuffer = supportsPixelBuffer;
            return this;
        }

        public ConfigBuilder setIsRecordable(boolean isRecordable) {
            this.isRecordable = isRecordable;
            return this;
        }

        public int[] createConfigAttributes() {
            ArrayList arrayList = new ArrayList();
            arrayList.add(12324);
            arrayList.add(8);
            arrayList.add(12323);
            arrayList.add(8);
            arrayList.add(12322);
            arrayList.add(8);
            if (this.hasAlphaChannel) {
                arrayList.add(12321);
                arrayList.add(8);
            }
            int i = this.openGlesVersion;
            if (i == 2 || i == 3) {
                arrayList.add(12352);
                arrayList.add(Integer.valueOf(this.openGlesVersion == 3 ? 64 : 4));
            }
            if (this.supportsPixelBuffer) {
                arrayList.add(12339);
                arrayList.add(1);
            }
            if (this.isRecordable) {
                arrayList.add(Integer.valueOf(EglBase.EGL_RECORDABLE_ANDROID));
                arrayList.add(1);
            }
            arrayList.add(12344);
            int[] iArr = new int[arrayList.size()];
            for (int i2 = 0; i2 < arrayList.size(); i2++) {
                iArr[i2] = ((Integer) arrayList.get(i2)).intValue();
            }
            return iArr;
        }
    }
}
