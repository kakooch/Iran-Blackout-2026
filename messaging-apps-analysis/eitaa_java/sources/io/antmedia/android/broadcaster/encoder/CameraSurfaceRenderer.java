package io.antmedia.android.broadcaster.encoder;

import android.graphics.SurfaceTexture;
import android.opengl.EGL14;
import android.opengl.GLES20;
import android.opengl.GLSurfaceView;
import android.util.Log;
import io.antmedia.android.broadcaster.CameraHandler;
import io.antmedia.android.broadcaster.encoder.TextureMovieEncoder;
import io.antmedia.android.broadcaster.encoder.gles.FullFrameRect;
import io.antmedia.android.broadcaster.encoder.gles.Texture2dProgram;
import io.antmedia.android.broadcaster.network.IMediaMuxer;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

/* loaded from: classes.dex */
public class CameraSurfaceRenderer implements GLSurfaceView.Renderer {
    private static final String TAG = CameraSurfaceRenderer.class.getSimpleName();
    private int bitrate;
    private CameraHandler mCameraHandler;
    private FullFrameRect mFullScreen;
    private long mRecordingStartTime;
    private SurfaceTexture mSurfaceTexture;
    private TextureMovieEncoder mVideoEncoder;
    private IMediaMuxer mWriterHandler;
    private int previewHeight;
    private int previewWidth;
    private final float[] mSTMatrix = new float[16];
    private int frameRate = 25;
    private boolean mute = false;
    private int encoderWidth = 480;
    private Texture2dProgram.ProgramType mEffectType = Texture2dProgram.ProgramType.TEXTURE_EXT;
    private int mTextureId = -1;
    private int mRecordingStatus = -1;
    private boolean mRecordingEnabled = false;
    private int mFrameCount = -1;
    private boolean mIncomingSizeUpdated = false;
    private int mIncomingHeight = -1;
    private int mIncomingWidth = -1;

    public CameraSurfaceRenderer(CameraHandler cameraHandler, TextureMovieEncoder movieEncoder) {
        this.mCameraHandler = cameraHandler;
        this.mVideoEncoder = movieEncoder;
    }

    public void setEffect(Texture2dProgram.ProgramType effectType) {
        this.mEffectType = effectType;
        TextureMovieEncoder textureMovieEncoder = this.mVideoEncoder;
        if (textureMovieEncoder != null) {
            textureMovieEncoder.setEffect(effectType);
        }
    }

    public void setPreviewResolution(int width, int height) {
        this.previewWidth = width;
        this.previewHeight = height;
    }

    public void setMuteVideo(boolean mute) {
        this.mute = mute;
    }

    public void notifyPausing() {
        if (this.mSurfaceTexture != null) {
            Log.d(TAG, "renderer pausing -- releasing SurfaceTexture");
            this.mSurfaceTexture.release();
            this.mSurfaceTexture = null;
        }
        FullFrameRect fullFrameRect = this.mFullScreen;
        if (fullFrameRect != null) {
            fullFrameRect.release(false);
            this.mFullScreen = null;
        }
        this.mIncomingHeight = -1;
        this.mIncomingWidth = -1;
    }

    public void startRecording(long recordingStartTime) {
        this.mRecordingEnabled = true;
        Log.d(TAG, "changeRecordingState: was " + this.mRecordingEnabled + " now " + this.mRecordingEnabled);
        this.mRecordingStartTime = recordingStartTime;
    }

    public void stopRecording() {
        this.mRecordingEnabled = false;
    }

    public void setCameraPreviewSize(int width, int height) {
        Log.d(TAG, "setCameraPreviewSize");
        this.mIncomingWidth = width;
        this.mIncomingHeight = height;
        this.mIncomingSizeUpdated = true;
        int i = this.encoderWidth;
        if (i >= 720) {
            this.bitrate = 850000;
            return;
        }
        if (i >= 480) {
            this.bitrate = 550000;
            return;
        }
        if (i >= 360) {
            this.bitrate = 450000;
            return;
        }
        if (i >= 288) {
            this.bitrate = 350000;
        } else if (i >= 240) {
            this.bitrate = 250000;
        } else {
            this.bitrate = 100000;
        }
    }

    public void setEncoderWidth(int newWidth) {
        if (newWidth >= 720) {
            this.bitrate = 850000;
        } else if (newWidth >= 480) {
            this.bitrate = 550000;
        } else if (newWidth >= 360) {
            this.bitrate = 450000;
        } else if (newWidth >= 288) {
            this.bitrate = 350000;
        } else if (newWidth >= 240) {
            this.bitrate = 250000;
        } else {
            this.bitrate = 100000;
        }
        this.encoderWidth = newWidth;
    }

    public int getBitrate() {
        return this.bitrate;
    }

    @Override // android.opengl.GLSurfaceView.Renderer
    public void onSurfaceCreated(GL10 unused, EGLConfig config) {
        Log.d(TAG, "onSurfaceCreated");
        boolean zIsRecording = this.mVideoEncoder.isRecording();
        this.mRecordingEnabled = zIsRecording;
        if (zIsRecording) {
            this.mRecordingStatus = 2;
        } else {
            this.mRecordingStatus = 0;
        }
        this.mFullScreen = new FullFrameRect(new Texture2dProgram(this.mEffectType));
        this.mVideoEncoder.setEffect(this.mEffectType);
        this.mTextureId = this.mFullScreen.createTextureObject();
        this.mSurfaceTexture = new SurfaceTexture(this.mTextureId);
        System.out.println("//Tell the UI thread to enable the camera preview.");
        CameraHandler cameraHandler = this.mCameraHandler;
        cameraHandler.sendMessage(cameraHandler.obtainMessage(0, this.mSurfaceTexture));
    }

    public int getFrameRate() {
        TextureMovieEncoder textureMovieEncoder = this.mVideoEncoder;
        if (textureMovieEncoder != null) {
            return textureMovieEncoder.getFrameRate();
        }
        return 0;
    }

    @Override // android.opengl.GLSurfaceView.Renderer
    public void onSurfaceChanged(GL10 unused, int width, int height) {
        Log.d(TAG, "onSurfaceChanged " + width + "x" + height);
        GLES20.glViewport(0, 0, width, height);
    }

    @Override // android.opengl.GLSurfaceView.Renderer
    public void onDrawFrame(GL10 unused) {
        String str = TAG;
        Log.d(str, "onDrawFrame tex=" + this.mTextureId);
        this.mSurfaceTexture.updateTexImage();
        if (this.mRecordingEnabled) {
            int i = this.mRecordingStatus;
            if (i == 0) {
                Log.d(str, "START recording bitrate: " + this.bitrate);
                int i2 = this.encoderWidth;
                int i3 = (int) ((((float) this.mIncomingHeight) / ((float) this.mIncomingWidth)) * ((float) i2));
                int i4 = i3 + (i3 % 2 == 0 ? 0 : 1);
                Log.v("bytesInQueue", "ww: " + i2 + " hh: " + i4);
                if (this.mVideoEncoder.startRecording(new TextureMovieEncoder.EncoderConfig(this.mWriterHandler, i2, i4, this.bitrate, this.frameRate, EGL14.eglGetCurrentContext(), this.mEffectType), this.mRecordingStartTime)) {
                    this.mRecordingStatus = 1;
                } else {
                    this.mRecordingStatus = 0;
                }
            } else if (i != 1) {
                if (i == 2) {
                    Log.d(str, "RESUME recording");
                    this.mVideoEncoder.updateSharedContext(EGL14.eglGetCurrentContext());
                    this.mRecordingStatus = 1;
                } else if (i == 3) {
                    this.mVideoEncoder.releaseRecording();
                    this.mRecordingStatus = 0;
                } else {
                    throw new RuntimeException("unknown status " + this.mRecordingStatus);
                }
            }
        } else {
            int i5 = this.mRecordingStatus;
            if (i5 != 0) {
                if (i5 == 1 || i5 == 2) {
                    Log.d(str, "STOP recording");
                    this.mVideoEncoder.stopRecording();
                    this.mRecordingStatus = 0;
                } else {
                    throw new RuntimeException("unknown status " + this.mRecordingStatus);
                }
            }
        }
        this.mVideoEncoder.setTextureId(this.mTextureId);
        this.mVideoEncoder.frameAvailable(this.mSurfaceTexture);
        if (this.mIncomingWidth <= 0 || this.mIncomingHeight <= 0) {
            Log.i(str, "Drawing before incoming texture size set; skipping");
            return;
        }
        if (this.mIncomingSizeUpdated) {
            this.mFullScreen.getProgram().setTexSize(this.mIncomingWidth, this.mIncomingHeight);
            this.mIncomingSizeUpdated = false;
        }
        this.mSurfaceTexture.getTransformMatrix(this.mSTMatrix);
        this.mFullScreen.drawFrame(this.mTextureId, this.mSTMatrix);
        if (this.mute) {
            drawBox();
        }
    }

    private void drawBox() {
        int i = this.previewWidth;
        int i2 = this.previewHeight;
        GLES20.glEnable(3089);
        GLES20.glScissor(0, 0, i, i2);
        GLES20.glClearColor(0.0f, 0.0f, 0.0f, 1.0f);
        GLES20.glClear(16384);
        GLES20.glDisable(3089);
    }

    public void setOptions(IMediaMuxer writerHandler) {
        this.mWriterHandler = writerHandler;
    }
}
