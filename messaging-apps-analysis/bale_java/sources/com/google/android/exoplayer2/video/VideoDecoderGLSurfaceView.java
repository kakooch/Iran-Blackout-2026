package com.google.android.exoplayer2.video;

import android.content.Context;
import android.opengl.GLES20;
import android.opengl.GLSurfaceView;
import android.util.AttributeSet;
import android.util.Log;
import com.google.android.exoplayer2.util.GlUtil;
import com.google.android.exoplayer2.util.b;
import ir.nasim.AbstractC18350oW3;
import ir.nasim.QS7;
import ir.nasim.RS7;
import java.nio.Buffer;
import java.nio.FloatBuffer;
import java.util.concurrent.atomic.AtomicReference;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

/* loaded from: classes2.dex */
public final class VideoDecoderGLSurfaceView extends GLSurfaceView implements RS7 {
    public static final /* synthetic */ int b = 0;
    private final a a;

    private static final class a implements GLSurfaceView.Renderer {
        private static final float[] j = {1.164f, 1.164f, 1.164f, 0.0f, -0.392f, 2.017f, 1.596f, -0.813f, 0.0f};
        private static final float[] k = {1.164f, 1.164f, 1.164f, 0.0f, -0.213f, 2.112f, 1.793f, -0.533f, 0.0f};
        private static final float[] l = {1.168f, 1.168f, 1.168f, 0.0f, -0.188f, 2.148f, 1.683f, -0.652f, 0.0f};
        private static final String[] m = {"y_tex", "u_tex", "v_tex"};
        private static final FloatBuffer n = GlUtil.e(new float[]{-1.0f, 1.0f, -1.0f, -1.0f, 1.0f, 1.0f, 1.0f, -1.0f});
        private final GLSurfaceView a;
        private final int[] b = new int[3];
        private final int[] c = new int[3];
        private final int[] d = new int[3];
        private final int[] e = new int[3];
        private final AtomicReference f = new AtomicReference();
        private final FloatBuffer[] g = new FloatBuffer[3];
        private b h;
        private int i;

        public a(GLSurfaceView gLSurfaceView) {
            this.a = gLSurfaceView;
            for (int i = 0; i < 3; i++) {
                int[] iArr = this.d;
                this.e[i] = -1;
                iArr[i] = -1;
            }
        }

        private void b() {
            try {
                GLES20.glGenTextures(3, this.b, 0);
                for (int i = 0; i < 3; i++) {
                    GLES20.glUniform1i(this.h.j(m[i]), i);
                    GLES20.glActiveTexture(33984 + i);
                    GlUtil.a(3553, this.b[i]);
                }
                GlUtil.b();
            } catch (GlUtil.GlException e) {
                Log.e("VideoDecoderGLSV", "Failed to set up the textures", e);
            }
        }

        public void a(QS7 qs7) {
            AbstractC18350oW3.a(this.f.getAndSet(qs7));
            this.a.requestRender();
        }

        @Override // android.opengl.GLSurfaceView.Renderer
        public void onDrawFrame(GL10 gl10) {
            AbstractC18350oW3.a(this.f.getAndSet(null));
        }

        @Override // android.opengl.GLSurfaceView.Renderer
        public void onSurfaceChanged(GL10 gl10, int i, int i2) {
            GLES20.glViewport(0, 0, i, i2);
        }

        @Override // android.opengl.GLSurfaceView.Renderer
        public void onSurfaceCreated(GL10 gl10, EGLConfig eGLConfig) {
            try {
                b bVar = new b("varying vec2 interp_tc_y;\nvarying vec2 interp_tc_u;\nvarying vec2 interp_tc_v;\nattribute vec4 in_pos;\nattribute vec2 in_tc_y;\nattribute vec2 in_tc_u;\nattribute vec2 in_tc_v;\nvoid main() {\n  gl_Position = in_pos;\n  interp_tc_y = in_tc_y;\n  interp_tc_u = in_tc_u;\n  interp_tc_v = in_tc_v;\n}\n", "precision mediump float;\nvarying vec2 interp_tc_y;\nvarying vec2 interp_tc_u;\nvarying vec2 interp_tc_v;\nuniform sampler2D y_tex;\nuniform sampler2D u_tex;\nuniform sampler2D v_tex;\nuniform mat3 mColorConversion;\nvoid main() {\n  vec3 yuv;\n  yuv.x = texture2D(y_tex, interp_tc_y).r - 0.0625;\n  yuv.y = texture2D(u_tex, interp_tc_u).r - 0.5;\n  yuv.z = texture2D(v_tex, interp_tc_v).r - 0.5;\n  gl_FragColor = vec4(mColorConversion * yuv, 1.0);\n}\n");
                this.h = bVar;
                GLES20.glVertexAttribPointer(bVar.e("in_pos"), 2, 5126, false, 0, (Buffer) n);
                this.c[0] = this.h.e("in_tc_y");
                this.c[1] = this.h.e("in_tc_u");
                this.c[2] = this.h.e("in_tc_v");
                this.i = this.h.j("mColorConversion");
                GlUtil.b();
                b();
                GlUtil.b();
            } catch (GlUtil.GlException e) {
                Log.e("VideoDecoderGLSV", "Failed to set up the textures and program", e);
            }
        }
    }

    public VideoDecoderGLSurfaceView(Context context) {
        this(context, null);
    }

    public void setOutputBuffer(QS7 qs7) {
        this.a.a(qs7);
    }

    public VideoDecoderGLSurfaceView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a aVar = new a(this);
        this.a = aVar;
        setPreserveEGLContextOnPause(true);
        setEGLContextClientVersion(2);
        setRenderer(aVar);
        setRenderMode(0);
    }

    @Deprecated
    public RS7 getVideoDecoderOutputBufferRenderer() {
        return this;
    }
}
