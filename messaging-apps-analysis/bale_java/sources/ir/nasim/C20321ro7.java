package ir.nasim;

import android.opengl.GLES20;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

/* renamed from: ir.nasim.ro7, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public final class C20321ro7 {
    public static final a k = new a(null);
    private static final float[] l = {0.0f, 1.0f, 1.0f, 1.0f, 0.0f, 0.0f, 1.0f, 0.0f};
    private static final float[] m = {-1.0f, -1.0f, 1.0f, -1.0f, -1.0f, 1.0f, 1.0f, 1.0f};
    private int a;
    private int b;
    private int c;
    private int d;
    private FloatBuffer e;
    private FloatBuffer f;
    private int g;
    private int h;
    private int i;
    private int j;

    /* renamed from: ir.nasim.ro7$a */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    private final void a() {
        float f;
        FloatBuffer floatBufferPut;
        float f2 = (this.g / this.h) / (this.i / this.j);
        float f3 = 1.0f;
        float f4 = -1.0f;
        if (f2 > 1.0f) {
            float f5 = (-1.0f) / f2;
            float f6 = 1.0f / f2;
            f2 = 1.0f;
            f3 = f6;
            f4 = f5;
            f = -1.0f;
        } else {
            f = -f2;
        }
        float[] fArr = {f4, f, f3, f, f4, f2, f3, f2};
        FloatBuffer floatBuffer = this.f;
        if (floatBuffer == null || (floatBufferPut = floatBuffer.put(fArr)) == null) {
            return;
        }
        floatBufferPut.position(0);
    }

    public final void b() {
        FloatBuffer floatBufferPut;
        FloatBuffer floatBufferPut2;
        int iB = ZB2.b("attribute vec4 a_position;\nattribute vec2 a_texcoord;\nvarying vec2 v_texcoord;\nvoid main() {\n  gl_Position = a_position;\n  v_texcoord = a_texcoord;\n}\n", "precision mediump float;\nuniform sampler2D tex_sampler;\nvarying vec2 v_texcoord;\nvoid main() {\n  gl_FragColor = texture2D(tex_sampler, v_texcoord);\n}\n");
        this.a = iB;
        this.b = GLES20.glGetUniformLocation(iB, "tex_sampler");
        this.c = GLES20.glGetAttribLocation(this.a, "a_texcoord");
        this.d = GLES20.glGetAttribLocation(this.a, "a_position");
        float[] fArr = l;
        FloatBuffer floatBufferAsFloatBuffer = ByteBuffer.allocateDirect(fArr.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
        this.e = floatBufferAsFloatBuffer;
        if (floatBufferAsFloatBuffer != null && (floatBufferPut2 = floatBufferAsFloatBuffer.put(fArr)) != null) {
            floatBufferPut2.position(0);
        }
        float[] fArr2 = m;
        FloatBuffer floatBufferAsFloatBuffer2 = ByteBuffer.allocateDirect(fArr2.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
        this.f = floatBufferAsFloatBuffer2;
        if (floatBufferAsFloatBuffer2 == null || (floatBufferPut = floatBufferAsFloatBuffer2.put(fArr2)) == null) {
            return;
        }
        floatBufferPut.position(0);
    }

    public final void c(int i) {
        GLES20.glBindFramebuffer(36160, 0);
        GLES20.glUseProgram(this.a);
        ZB2.a("glUseProgram");
        GLES20.glViewport(0, 0, this.g, this.h);
        ZB2.a("glViewport");
        GLES20.glDisable(3042);
        GLES20.glVertexAttribPointer(this.c, 2, 5126, false, 0, (Buffer) this.e);
        GLES20.glEnableVertexAttribArray(this.c);
        GLES20.glVertexAttribPointer(this.d, 2, 5126, false, 0, (Buffer) this.f);
        GLES20.glEnableVertexAttribArray(this.d);
        ZB2.a("vertex attribute setup");
        GLES20.glActiveTexture(33984);
        ZB2.a("glActiveTexture");
        GLES20.glBindTexture(3553, i);
        ZB2.a("glBindTexture");
        GLES20.glUniform1i(this.b, 0);
        GLES20.glClearColor(0.0f, 0.0f, 0.0f, 1.0f);
        GLES20.glClear(16384);
        GLES20.glDrawArrays(5, 0, 4);
    }

    public final void d(int i, int i2) {
        this.i = i;
        this.j = i2;
        a();
    }

    public final void e(int i, int i2) {
        this.g = i;
        this.h = i2;
        a();
    }
}
