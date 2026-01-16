package io.antmedia.android.broadcaster.encoder;

import android.graphics.SurfaceTexture;
import android.opengl.EGLContext;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import io.antmedia.android.broadcaster.encoder.gles.EglCore;
import io.antmedia.android.broadcaster.encoder.gles.FullFrameRect;
import io.antmedia.android.broadcaster.encoder.gles.Texture2dProgram;
import io.antmedia.android.broadcaster.encoder.gles.WindowSurface;
import io.antmedia.android.broadcaster.network.IMediaMuxer;
import java.io.IOException;
import java.lang.ref.WeakReference;

/* loaded from: classes.dex */
public class TextureMovieEncoder implements Runnable {
    private static final String TAG = TextureMovieEncoder.class.getSimpleName();
    private int encoderHeight;
    private int encoderWidth;
    private EglCore mEglCore;
    private EncoderConfig mEncoderConfig;
    private int mFrameNum;
    private FullFrameRect mFullScreen;
    private volatile EncoderHandler mHandler;
    private WindowSurface mInputWindowSurface;
    private Texture2dProgram.ProgramType mProgramType;
    private boolean mReady;
    private long mRecordingStartTime;
    private boolean mRunning;
    private int mTextureId;
    private VideoEncoderCore mVideoEncoder;
    private Object mReadyFence = new Object();
    private long mLastFrameTime = 0;

    public static class EncoderConfig {
        final int mBitRate;
        final EGLContext mEglContext;
        public int mFrameRate;
        final int mHeight;
        final Texture2dProgram.ProgramType mProgramType;
        final int mWidth;
        final IMediaMuxer writerHandler;

        public EncoderConfig(IMediaMuxer handler, int width, int height, int bitRate, int frameRate, EGLContext sharedEglContext, Texture2dProgram.ProgramType programType) {
            this.writerHandler = handler;
            this.mWidth = width;
            this.mHeight = height;
            this.mBitRate = bitRate;
            this.mEglContext = sharedEglContext;
            this.mProgramType = programType;
            this.mFrameRate = frameRate;
        }
    }

    public boolean startRecording(EncoderConfig config, long mRecordingStartTime) {
        String str = TAG;
        Log.d(str, "Encoder: startRecording()");
        synchronized (this.mReadyFence) {
            if (this.mRunning) {
                Log.w(str, "Encoder thread already running");
                return false;
            }
            this.mRecordingStartTime = mRecordingStartTime;
            this.mRunning = true;
            new Thread(this, "TextureMovieEncoder").start();
            while (!this.mReady) {
                try {
                    this.mReadyFence.wait();
                } catch (InterruptedException unused) {
                }
            }
            this.mHandler.sendMessage(this.mHandler.obtainMessage(0, config));
            return true;
        }
    }

    public void releaseRecording() {
        if (this.mHandler != null) {
            this.mHandler.sendMessage(this.mHandler.obtainMessage(6));
            this.mHandler.sendMessage(this.mHandler.obtainMessage(5));
        }
    }

    public void stopRecording() {
        if (this.mHandler != null) {
            this.mHandler.sendMessage(this.mHandler.obtainMessage(1));
            this.mHandler.sendMessage(this.mHandler.obtainMessage(5));
        }
    }

    public boolean isRecording() {
        boolean z;
        synchronized (this.mReadyFence) {
            z = this.mRunning;
        }
        return z;
    }

    public void updateSharedContext(EGLContext sharedContext) {
        this.mHandler.sendMessage(this.mHandler.obtainMessage(4, sharedContext));
    }

    public void frameAvailable(SurfaceTexture st) {
        synchronized (this.mReadyFence) {
            if (this.mReady) {
                if (this.mHandler == null) {
                    return;
                }
                float[] fArr = new float[16];
                st.getTransformMatrix(fArr);
                long jCurrentTimeMillis = System.currentTimeMillis();
                if (this.mHandler == null || this.mVideoEncoder == null || jCurrentTimeMillis - this.mLastFrameTime < getFrameInterval()) {
                    return;
                }
                Log.d(TAG, " get frame interval :" + getFrameInterval());
                long j = (jCurrentTimeMillis - this.mRecordingStartTime) * 1000000;
                this.mLastFrameTime = jCurrentTimeMillis;
                try {
                    this.mHandler.sendMessage(this.mHandler.obtainMessage(2, (int) (j >> 32), (int) j, fArr));
                } catch (Exception unused) {
                }
            }
        }
    }

    private long getFrameInterval() {
        return 1000 / this.mEncoderConfig.mFrameRate;
    }

    public int getFrameRate() {
        EncoderConfig encoderConfig = this.mEncoderConfig;
        if (encoderConfig != null) {
            return encoderConfig.mFrameRate;
        }
        return 0;
    }

    public void setTextureId(int id) {
        synchronized (this.mReadyFence) {
            if (this.mReady) {
                this.mHandler.sendMessage(this.mHandler.obtainMessage(3, id, 0, null));
            }
        }
    }

    public void setEffect(Texture2dProgram.ProgramType programType) {
        synchronized (this.mReadyFence) {
            if (this.mReady) {
                this.mHandler.sendMessage(this.mHandler.obtainMessage(7, 0, 0, programType));
            }
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        Looper.prepare();
        synchronized (this.mReadyFence) {
            this.mHandler = new EncoderHandler(this);
            this.mReady = true;
            this.mReadyFence.notify();
        }
        Looper.loop();
        Log.d(TAG, "Encoder thread exiting");
        synchronized (this.mReadyFence) {
            this.mRunning = false;
            this.mReady = false;
            this.mHandler = null;
        }
    }

    private static class EncoderHandler extends Handler {
        private WeakReference<TextureMovieEncoder> mWeakEncoder;

        public EncoderHandler(TextureMovieEncoder encoder) {
            this.mWeakEncoder = new WeakReference<>(encoder);
        }

        @Override // android.os.Handler
        public void handleMessage(Message inputMessage) throws IllegalStateException {
            int i = inputMessage.what;
            Object obj = inputMessage.obj;
            TextureMovieEncoder textureMovieEncoder = this.mWeakEncoder.get();
            if (textureMovieEncoder == null) {
                Log.w(TextureMovieEncoder.TAG, "EncoderHandler.handleMessage: encoder is null");
                return;
            }
            switch (i) {
                case 0:
                    textureMovieEncoder.handleStartRecording((EncoderConfig) obj);
                    return;
                case 1:
                    textureMovieEncoder.handleStopRecording(true);
                    return;
                case 2:
                    textureMovieEncoder.handleFrameAvailable((float[]) obj, (inputMessage.arg1 << 32) | (inputMessage.arg2 & 4294967295L));
                    return;
                case 3:
                    textureMovieEncoder.handleSetTexture(inputMessage.arg1);
                    return;
                case 4:
                    textureMovieEncoder.handleUpdateSharedContext((EGLContext) inputMessage.obj);
                    return;
                case 5:
                    Looper.myLooper().quit();
                    System.out.println("looper msg quit....");
                    return;
                case 6:
                    textureMovieEncoder.handleStopRecording(false);
                    return;
                case 7:
                    textureMovieEncoder.changeEffect((Texture2dProgram.ProgramType) inputMessage.obj);
                    return;
                default:
                    throw new RuntimeException("Unhandled msg what=" + i);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void changeEffect(Texture2dProgram.ProgramType type) {
        FullFrameRect fullFrameRect = this.mFullScreen;
        if (fullFrameRect != null) {
            fullFrameRect.release(false);
        }
        FullFrameRect fullFrameRect2 = new FullFrameRect(new Texture2dProgram(type));
        this.mFullScreen = fullFrameRect2;
        fullFrameRect2.getProgram().setPreviewResolution(this.encoderWidth, this.encoderHeight);
        this.mProgramType = type;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleStartRecording(EncoderConfig config) throws IllegalStateException {
        Log.d(TAG, "handleStartRecording " + config);
        this.mEncoderConfig = config;
        this.mFrameNum = 0;
        prepareEncoder(config.mEglContext, config.mWidth, config.mHeight, config.mBitRate, config.mFrameRate, config.writerHandler, config.mProgramType);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleFrameAvailable(float[] transform, long timestampNanos) {
        if (this.mFullScreen != null) {
            this.mVideoEncoder.drainEncoder(false);
            this.mFullScreen.drawFrame(this.mTextureId, transform);
            this.mInputWindowSurface.setPresentationTime(timestampNanos);
            this.mInputWindowSurface.swapBuffers();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleStopRecording(boolean stopMuxer) {
        Log.d(TAG, "handleStopRecording");
        this.mVideoEncoder.drainEncoder(true);
        releaseEncoder();
        if (stopMuxer) {
            this.mVideoEncoder.stopMuxer();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleSetTexture(int id) {
        this.mTextureId = id;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleUpdateSharedContext(EGLContext newSharedContext) {
        Log.d(TAG, "handleUpdatedSharedContext " + newSharedContext);
        this.mInputWindowSurface.releaseEglSurface();
        this.mFullScreen.release(false);
        this.mEglCore.release();
        EglCore eglCore = new EglCore(newSharedContext, 1);
        this.mEglCore = eglCore;
        this.mInputWindowSurface.recreate(eglCore);
        this.mInputWindowSurface.makeCurrent();
        FullFrameRect fullFrameRect = new FullFrameRect(new Texture2dProgram(this.mProgramType));
        this.mFullScreen = fullFrameRect;
        fullFrameRect.getProgram().setPreviewResolution(this.encoderWidth, this.encoderHeight);
    }

    private void prepareEncoder(EGLContext sharedContext, int width, int height, int bitRate, int frameRate, IMediaMuxer writerHandle, Texture2dProgram.ProgramType programType) throws IllegalStateException {
        try {
            this.mVideoEncoder = new VideoEncoderCore(width, height, bitRate, frameRate, writerHandle);
            EglCore eglCore = new EglCore(sharedContext, 1);
            this.mEglCore = eglCore;
            WindowSurface windowSurface = new WindowSurface(eglCore, this.mVideoEncoder.getInputSurface(), true);
            this.mInputWindowSurface = windowSurface;
            windowSurface.makeCurrent();
            this.encoderWidth = width;
            this.encoderHeight = height;
            this.mProgramType = programType;
            FullFrameRect fullFrameRect = new FullFrameRect(new Texture2dProgram(programType));
            this.mFullScreen = fullFrameRect;
            fullFrameRect.getProgram().setPreviewResolution(this.encoderWidth, this.encoderHeight);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void releaseEncoder() {
        this.mVideoEncoder.release();
        WindowSurface windowSurface = this.mInputWindowSurface;
        if (windowSurface != null) {
            windowSurface.release();
            this.mInputWindowSurface = null;
        }
        FullFrameRect fullFrameRect = this.mFullScreen;
        if (fullFrameRect != null) {
            fullFrameRect.release(false);
            this.mFullScreen = null;
        }
        EglCore eglCore = this.mEglCore;
        if (eglCore != null) {
            eglCore.release();
            this.mEglCore = null;
        }
    }
}
