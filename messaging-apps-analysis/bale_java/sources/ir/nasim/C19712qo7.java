package ir.nasim;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.graphics.SurfaceTexture;
import android.graphics.Typeface;
import android.opengl.GLES20;
import android.opengl.GLUtils;
import android.text.Editable;
import android.text.SpannableString;
import android.text.Spanned;
import android.util.Pair;
import android.view.View;
import ir.nasim.R62;
import ir.nasim.tgwidgets.editor.messenger.AbstractC21455b;
import ir.nasim.tgwidgets.editor.messenger.H;
import ir.nasim.tgwidgets.editor.ui.Components.AnimatedEmojiSpan;
import ir.nasim.tgwidgets.editor.ui.Components.AnimatedFileDrawable;
import ir.nasim.tgwidgets.editor.ui.Components.EditTextEffects;
import ir.nasim.tgwidgets.editor.ui.Components.Paint.Views.EditTextOutline;
import ir.nasim.tgwidgets.editor.ui.Components.RLottieDrawable;
import ir.nasim.tgwidgets.editor.ui.stories.recorder.l;
import java.io.File;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.util.ArrayList;
import java.util.Iterator;

/* renamed from: ir.nasim.qo7, reason: case insensitive filesystem */
/* loaded from: classes7.dex */
public class C19712qo7 {
    private int A;
    private int[] B;
    private int[] C;
    private int[] D;
    private int[] E;
    private int[] F;
    private int G;
    private int H;
    private int I;
    private int J;
    private int K;
    private int L;
    private int M;
    private int[] N;
    private int[] O;
    private Bitmap P;
    private Canvas Q;
    private float R;
    private boolean S;
    private boolean T;
    Path V;
    Paint W;
    Paint X;
    private int Y;
    private int Z;
    private FloatBuffer a;
    private FloatBuffer b;
    private FloatBuffer c;
    private FloatBuffer d;
    private FloatBuffer e;
    private FloatBuffer f;
    private FloatBuffer[] g;
    private FloatBuffer h;
    private ArrayList i;
    private int[] j;
    private boolean k;
    private ir.nasim.tgwidgets.editor.ui.Components.l m;
    private String n;
    private String o;
    private ArrayList p;
    private int q;
    private int r;
    private int s;
    private int t;
    private int u;
    private int v;
    private int w;
    float[] l = {-1.0f, 1.0f, 1.0f, 1.0f, -1.0f, -1.0f, 1.0f, -1.0f};
    private float[] x = new float[16];
    private float[] y = new float[16];
    private float[] z = new float[16];
    private boolean U = true;

    /* renamed from: ir.nasim.qo7$a */
    class a extends AnimatedEmojiSpan {
        final /* synthetic */ H.b r;
        final /* synthetic */ EditTextOutline s;
        final /* synthetic */ H.a t;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(long j, float f, Paint.FontMetricsInt fontMetricsInt, H.b bVar, EditTextOutline editTextOutline, H.a aVar) {
            super(j, f, fontMetricsInt);
            this.r = bVar;
            this.s = editTextOutline;
            this.t = aVar;
        }

        @Override // ir.nasim.tgwidgets.editor.ui.Components.AnimatedEmojiSpan, android.text.style.ReplacementSpan
        public void draw(Canvas canvas, CharSequence charSequence, int i, int i2, float f, int i3, int i4, int i5, Paint paint) {
            super.draw(canvas, charSequence, i, i2, f, i3, i4, i5, paint);
            H.b bVar = this.r;
            float paddingLeft = this.r.c + ((((this.s.getPaddingLeft() + f) + (this.k / 2.0f)) / bVar.n) * bVar.f);
            float f2 = bVar.d;
            H.b bVar2 = this.r;
            float paddingTop = (((this.s.K1 ? r7.getPaddingTop() : 0) + i3) + ((i5 - i3) / 2.0f)) / bVar2.o;
            float f3 = bVar2.g;
            float fSin = f2 + (paddingTop * f3);
            if (bVar2.e != 0.0f) {
                float f4 = bVar2.c + (bVar2.f / 2.0f);
                float f5 = bVar2.d + (f3 / 2.0f);
                float f6 = C19712qo7.this.s / C19712qo7.this.t;
                double d = paddingLeft - f4;
                double d2 = (fSin - f5) / f6;
                float fCos = f4 + ((float) ((Math.cos(-this.r.e) * d) - (Math.sin(-this.r.e) * d2)));
                fSin = (((float) ((d * Math.sin(-this.r.e)) + (d2 * Math.cos(-this.r.e)))) * f6) + f5;
                paddingLeft = fCos;
            }
            H.b bVar3 = this.t.j;
            int i6 = this.k;
            H.b bVar4 = this.r;
            float f7 = (i6 / bVar4.n) * bVar4.f;
            bVar3.f = f7;
            float f8 = (i6 / bVar4.o) * bVar4.g;
            bVar3.g = f8;
            bVar3.c = paddingLeft - (f7 / 2.0f);
            bVar3.d = fSin - (f8 / 2.0f);
            bVar3.e = bVar4.e;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:53:0x0356  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x03c4  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x0450  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public C19712qo7(ir.nasim.tgwidgets.editor.messenger.MediaController.n r29, java.lang.String r30, java.lang.String r31, java.util.ArrayList r32, ir.nasim.tgwidgets.editor.messenger.MediaController.i r33, int r34, int r35, int r36, int r37, int r38, float r39, boolean r40, java.lang.Integer r41, java.lang.Integer r42, ir.nasim.tgwidgets.editor.ui.stories.recorder.l.b r43, java.util.ArrayList r44) {
        /*
            Method dump skipped, instructions count: 1242
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C19712qo7.<init>(ir.nasim.tgwidgets.editor.messenger.MediaController$n, java.lang.String, java.lang.String, java.util.ArrayList, ir.nasim.tgwidgets.editor.messenger.MediaController$i, int, int, int, int, int, float, boolean, java.lang.Integer, java.lang.Integer, ir.nasim.tgwidgets.editor.ui.stories.recorder.l$b, java.util.ArrayList):void");
    }

    private void c(H.b bVar, Bitmap bitmap, int i) {
        if (bitmap == null || bVar == null) {
            return;
        }
        if (bVar.p == 0.0f && i == 0) {
            return;
        }
        if (bVar.E == null) {
            bVar.E = new Canvas(bitmap);
        }
        if (bVar.p != 0.0f) {
            if (this.V == null) {
                this.V = new Path();
            }
            if (this.W == null) {
                Paint paint = new Paint(1);
                this.W = paint;
                paint.setColor(-16777216);
                this.W.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
            }
            float fMin = Math.min(bitmap.getWidth(), bitmap.getHeight()) * bVar.p;
            this.V.rewind();
            this.V.addRoundRect(new RectF(0.0f, 0.0f, bitmap.getWidth(), bitmap.getHeight()), fMin, fMin, Path.Direction.CCW);
            this.V.toggleInverseFillType();
            bVar.E.drawPath(this.V, this.W);
        }
        if (i != 0) {
            if (this.X == null) {
                Paint paint2 = new Paint(1);
                this.X = paint2;
                paint2.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
            }
            this.X.setColor(i);
            bVar.E.drawRect(0.0f, 0.0f, bitmap.getWidth(), bitmap.getHeight(), this.X);
        }
    }

    private int e(String str, String str2, boolean z) {
        int iR;
        int iGlCreateProgram;
        int iR2;
        int iGlCreateProgram2;
        if (z) {
            int iR3 = ir.nasim.tgwidgets.editor.ui.Components.l.r(35633, str);
            if (iR3 == 0 || (iR2 = ir.nasim.tgwidgets.editor.ui.Components.l.r(35632, str2)) == 0 || (iGlCreateProgram2 = GLES20.glCreateProgram()) == 0) {
                return 0;
            }
            GLES20.glAttachShader(iGlCreateProgram2, iR3);
            GLES20.glAttachShader(iGlCreateProgram2, iR2);
            GLES20.glLinkProgram(iGlCreateProgram2);
            int[] iArr = new int[1];
            GLES20.glGetProgramiv(iGlCreateProgram2, 35714, iArr, 0);
            if (iArr[0] == 1) {
                return iGlCreateProgram2;
            }
            GLES20.glDeleteProgram(iGlCreateProgram2);
            return 0;
        }
        int iR4 = ir.nasim.tgwidgets.editor.ui.Components.l.r(35633, str);
        if (iR4 == 0 || (iR = ir.nasim.tgwidgets.editor.ui.Components.l.r(35632, str2)) == 0 || (iGlCreateProgram = GLES20.glCreateProgram()) == 0) {
            return 0;
        }
        GLES20.glAttachShader(iGlCreateProgram, iR4);
        GLES20.glAttachShader(iGlCreateProgram, iR);
        GLES20.glLinkProgram(iGlCreateProgram);
        int[] iArr2 = new int[1];
        GLES20.glGetProgramiv(iGlCreateProgram, 35714, iArr2, 0);
        if (iArr2[0] == 1) {
            return iGlCreateProgram;
        }
        GLES20.glDeleteProgram(iGlCreateProgram);
        return 0;
    }

    private void f(H.b bVar, int i) {
        H.b bVar2;
        long j = bVar.y;
        if (j != 0) {
            int i2 = (int) bVar.z;
            Bitmap bitmap = this.P;
            RLottieDrawable.getFrame(j, i2, bitmap, 512, 512, bitmap.getRowBytes(), true);
            Bitmap bitmap2 = this.P;
            if ((bVar.b & 8) == 0) {
                i = 0;
            }
            c(bVar, bitmap2, i);
            GLES20.glBindTexture(3553, this.O[0]);
            GLUtils.texImage2D(3553, 0, this.P, 0);
            float f = bVar.z + bVar.A;
            bVar.z = f;
            if (f >= bVar.x[0]) {
                bVar.z = 0.0f;
            }
            i(false, this.O[0], bVar.c, bVar.d, bVar.f, bVar.g, bVar.e, (bVar.b & 2) != 0);
            return;
        }
        if (bVar.D == null) {
            if (bVar.B != null) {
                GLES20.glBindTexture(3553, this.O[0]);
                GLUtils.texImage2D(3553, 0, bVar.B, 0);
                i(false, this.O[0], bVar.c, bVar.d, bVar.f, bVar.g, bVar.e, bVar.a == 2 && (bVar.b & 2) != 0);
            }
            ArrayList arrayList = bVar.i;
            if (arrayList == null || arrayList.isEmpty()) {
                return;
            }
            for (int i3 = 0; i3 < bVar.i.size(); i3++) {
                H.a aVar = (H.a) bVar.i.get(i3);
                if (aVar != null && (bVar2 = aVar.j) != null) {
                    f(bVar2, bVar.j);
                }
            }
            return;
        }
        float f2 = bVar.z;
        int i4 = (int) f2;
        float f3 = f2 + bVar.A;
        bVar.z = f3;
        for (int i5 = (int) f3; i4 != i5; i5--) {
            bVar.D.C0();
        }
        Bitmap bitmapV0 = bVar.D.v0();
        if (bitmapV0 != null) {
            if (this.Q == null && this.P != null) {
                this.Q = new Canvas(this.P);
                if (this.P.getHeight() != bitmapV0.getHeight() || this.P.getWidth() != bitmapV0.getWidth()) {
                    this.Q.scale(this.P.getWidth() / bitmapV0.getWidth(), this.P.getHeight() / bitmapV0.getHeight());
                }
            }
            Bitmap bitmap3 = this.P;
            if (bitmap3 != null) {
                bitmap3.eraseColor(0);
                this.Q.drawBitmap(bitmapV0, 0.0f, 0.0f, (Paint) null);
                Bitmap bitmap4 = this.P;
                if ((bVar.b & 8) == 0) {
                    i = 0;
                }
                c(bVar, bitmap4, i);
                GLES20.glBindTexture(3553, this.O[0]);
                GLUtils.texImage2D(3553, 0, this.P, 0);
                i(false, this.O[0], bVar.c, bVar.d, bVar.f, bVar.g, bVar.e, (bVar.b & 2) != 0);
            }
        }
    }

    private void h() {
        int i = this.w;
        if (i < 0) {
            return;
        }
        GLES20.glUseProgram(this.B[i]);
        GLES20.glVertexAttribPointer(this.E[this.w], 2, 5126, false, 8, (Buffer) this.b);
        GLES20.glEnableVertexAttribArray(this.E[this.w]);
        GLES20.glVertexAttribPointer(this.F[this.w], 2, 5126, false, 8, (Buffer) this.c);
        GLES20.glEnableVertexAttribArray(this.F[this.w]);
        GLES20.glUniformMatrix4fv(this.D[this.w], 1, false, this.y, 0);
        GLES20.glUniformMatrix4fv(this.C[this.w], 1, false, this.x, 0);
        GLES20.glUniform4f(this.G, Color.red(this.Y) / 255.0f, Color.green(this.Y) / 255.0f, Color.blue(this.Y) / 255.0f, Color.alpha(this.Y) / 255.0f);
        GLES20.glUniform4f(this.H, Color.red(this.Z) / 255.0f, Color.green(this.Z) / 255.0f, Color.blue(this.Z) / 255.0f, Color.alpha(this.Z) / 255.0f);
        GLES20.glDrawArrays(5, 0, 4);
    }

    private void i(boolean z, int i, float f, float f2, float f3, float f4, float f5, boolean z2) {
        j(z, i, f, f2, f3, f4, f5, z2, false, -1);
    }

    private void j(boolean z, int i, float f, float f2, float f3, float f4, float f5, boolean z2, boolean z3, int i2) {
        float f6 = f5;
        if (!this.S) {
            GLES20.glEnable(3042);
            GLES20.glBlendFunc(1, 771);
            this.S = true;
        }
        if (f <= -10000.0f) {
            float[] fArr = this.l;
            fArr[0] = -1.0f;
            fArr[1] = 1.0f;
            fArr[2] = 1.0f;
            fArr[3] = 1.0f;
            fArr[4] = -1.0f;
            fArr[5] = -1.0f;
            fArr[6] = 1.0f;
            fArr[7] = -1.0f;
        } else {
            float f7 = (f * 2.0f) - 1.0f;
            float f8 = ((1.0f - f2) * 2.0f) - 1.0f;
            float[] fArr2 = this.l;
            fArr2[0] = f7;
            fArr2[1] = f8;
            float f9 = (f3 * 2.0f) + f7;
            fArr2[2] = f9;
            fArr2[3] = f8;
            fArr2[4] = f7;
            float f10 = f8 - (f4 * 2.0f);
            fArr2[5] = f10;
            fArr2[6] = f9;
            fArr2[7] = f10;
        }
        float[] fArr3 = this.l;
        float f11 = fArr3[0];
        float f12 = fArr3[2];
        float f13 = (f11 + f12) / 2.0f;
        if (z2) {
            fArr3[2] = f11;
            fArr3[0] = f12;
            float f14 = fArr3[6];
            fArr3[6] = fArr3[4];
            fArr3[4] = f14;
        }
        if (f6 != 0.0f) {
            float f15 = this.s / this.t;
            float f16 = (fArr3[5] + fArr3[1]) / 2.0f;
            int i3 = 0;
            while (i3 < 4) {
                float[] fArr4 = this.l;
                int i4 = i3 * 2;
                int i5 = i4 + 1;
                double d = fArr4[i4] - f13;
                double d2 = f6;
                double d3 = (fArr4[i5] - f16) / f15;
                fArr4[i4] = ((float) ((Math.cos(d2) * d) - (Math.sin(d2) * d3))) + f13;
                this.l[i5] = (((float) ((d * Math.sin(d2)) + (d3 * Math.cos(d2)))) * f15) + f16;
                i3++;
                f6 = f5;
            }
        }
        this.f.put(this.l).position(0);
        GLES20.glVertexAttribPointer(this.K, 2, 5126, false, 8, (Buffer) (i2 >= 0 ? this.g[i2] : z3 ? this.a : this.f));
        GLES20.glEnableVertexAttribArray(this.L);
        GLES20.glVertexAttribPointer(this.L, 2, 5126, false, 8, (Buffer) (i2 >= 0 ? this.h : z3 ? this.e : this.d));
        if (z) {
            GLES20.glBindTexture(3553, i);
        }
        GLES20.glDrawArrays(5, 0, 4);
    }

    private void l(H.b bVar) {
        byte b = bVar.b;
        if ((b & 1) != 0) {
            int[] iArr = new int[3];
            bVar.x = iArr;
            bVar.y = RLottieDrawable.create(bVar.h, null, 512, 512, iArr, false, null, false, 0);
            bVar.A = bVar.x[1] / this.R;
            return;
        }
        if ((b & 4) != 0) {
            bVar.D = new AnimatedFileDrawable(new File(bVar.h), true, 0L, 0, null, null, null, 0L, C22477vI7.f, true, 512, 512, null);
            bVar.A = r2.y0() / this.R;
            bVar.z = 0.0f;
            bVar.D.C0();
            return;
        }
        BitmapFactory.Options options = new BitmapFactory.Options();
        if (bVar.a == 2) {
            options.inMutable = true;
        }
        Bitmap bitmapDecodeFile = BitmapFactory.decodeFile(bVar.h, options);
        bVar.B = bitmapDecodeFile;
        if (bVar.a != 2 || bitmapDecodeFile == null) {
            if (bitmapDecodeFile != null) {
                float width = bitmapDecodeFile.getWidth() / bVar.B.getHeight();
                if (width > 1.0f) {
                    float f = bVar.g;
                    float f2 = f / width;
                    bVar.d += (f - f2) / 2.0f;
                    bVar.g = f2;
                    return;
                }
                if (width < 1.0f) {
                    float f3 = bVar.f;
                    float f4 = width * f3;
                    bVar.c += (f3 - f4) / 2.0f;
                    bVar.f = f4;
                    return;
                }
                return;
            }
            return;
        }
        bVar.p = AbstractC21455b.F(12.0f) / Math.min(bVar.n, bVar.o);
        Pair pairB0 = AbstractC21455b.b0(bVar.h);
        bVar.e = (float) (bVar.e - Math.toRadians(((Integer) pairB0.first).intValue()));
        if ((((Integer) pairB0.first).intValue() / 90) % 2 == 1) {
            float f5 = bVar.c;
            float f6 = bVar.f;
            float f7 = f5 + (f6 / 2.0f);
            float f8 = bVar.d;
            float f9 = bVar.g;
            float f10 = f8 + (f9 / 2.0f);
            int i = this.s;
            int i2 = this.t;
            float f11 = (f6 * i) / i2;
            float f12 = (f9 * i2) / i;
            bVar.f = f12;
            bVar.g = f11;
            bVar.c = f7 - (f12 / 2.0f);
            bVar.d = f10 - (f11 / 2.0f);
        }
        c(bVar, bVar.B, 0);
    }

    public void d(String str, String str2, boolean z) {
        int i = this.v;
        if (i >= 0 && i < this.B.length) {
            int iE = e(z ? "#version 320 es\nuniform mat4 uMVPMatrix;\nuniform mat4 uSTMatrix;\nin vec4 aPosition;\nin vec4 aTextureCoord;\nout vec2 vTextureCoord;\nvoid main() {\n  gl_Position = uMVPMatrix * aPosition;\n  vTextureCoord = (uSTMatrix * aTextureCoord).xy;\n}\n" : "uniform mat4 uMVPMatrix;\nuniform mat4 uSTMatrix;\nattribute vec4 aPosition;\nattribute vec4 aTextureCoord;\nvarying vec2 vTextureCoord;\nvoid main() {\n  gl_Position = uMVPMatrix * aPosition;\n  vTextureCoord = (uSTMatrix * aTextureCoord).xy;\n}\n", str, z);
            if (iE != 0) {
                GLES20.glDeleteProgram(this.B[this.v]);
                this.B[this.v] = iE;
                this.I = GLES20.glGetUniformLocation(iE, "texSize");
            }
        }
        int i2 = this.u;
        if (i2 < 0 || i2 >= this.B.length) {
            return;
        }
        int iE2 = e(z ? "#version 320 es\nuniform mat4 uMVPMatrix;\nuniform mat4 uSTMatrix;\nin vec4 aPosition;\nin vec4 aTextureCoord;\nout vec2 vTextureCoord;\nvoid main() {\n  gl_Position = uMVPMatrix * aPosition;\n  vTextureCoord = (uSTMatrix * aTextureCoord).xy;\n}\n" : "uniform mat4 uMVPMatrix;\nuniform mat4 uSTMatrix;\nattribute vec4 aPosition;\nattribute vec4 aTextureCoord;\nvarying vec2 vTextureCoord;\nvoid main() {\n  gl_Position = uMVPMatrix * aPosition;\n  vTextureCoord = (uSTMatrix * aTextureCoord).xy;\n}\n", str2, z);
        if (iE2 != 0) {
            GLES20.glDeleteProgram(this.B[this.u]);
            this.B[this.u] = iE2;
        }
    }

    public void g(SurfaceTexture surfaceTexture) {
        int iO;
        int i;
        float[] fArr;
        int i2;
        if (this.T) {
            h();
        } else {
            surfaceTexture.getTransformMatrix(this.y);
            if (AbstractC8814Xl0.b && this.U) {
                StringBuilder sb = new StringBuilder();
                int i3 = 0;
                while (true) {
                    float[] fArr2 = this.y;
                    if (i3 >= fArr2.length) {
                        break;
                    }
                    sb.append(fArr2[i3]);
                    sb.append(", ");
                    i3++;
                }
                AbstractC6403Nl2.a("stMatrix = " + ((Object) sb));
                this.U = false;
            }
            if (this.S) {
                GLES20.glDisable(3042);
                this.S = false;
            }
            ir.nasim.tgwidgets.editor.ui.Components.l lVar = this.m;
            if (lVar != null) {
                lVar.t(this.y);
                GLES20.glViewport(0, 0, this.q, this.r);
                this.m.i();
                this.m.g();
                this.m.h();
                this.m.f();
                boolean zE = this.m.e();
                GLES20.glBindFramebuffer(36160, 0);
                int i4 = this.s;
                if (i4 != this.q || this.t != this.r) {
                    GLES20.glViewport(0, 0, i4, this.t);
                }
                iO = this.m.o(!zE ? 1 : 0);
                i = this.u;
                fArr = this.z;
                i2 = 3553;
            } else {
                iO = this.A;
                i = this.v;
                fArr = this.y;
                i2 = 36197;
            }
            h();
            GLES20.glUseProgram(this.B[i]);
            GLES20.glActiveTexture(33984);
            GLES20.glBindTexture(i2, iO);
            GLES20.glVertexAttribPointer(this.E[i], 2, 5126, false, 8, (Buffer) this.a);
            GLES20.glEnableVertexAttribArray(this.E[i]);
            GLES20.glVertexAttribPointer(this.F[i], 2, 5126, false, 8, (Buffer) this.e);
            GLES20.glEnableVertexAttribArray(this.F[i]);
            int i5 = this.I;
            if (i5 != 0) {
                GLES20.glUniform2f(i5, this.s, this.t);
            }
            GLES20.glUniformMatrix4fv(this.D[i], 1, false, fArr, 0);
            GLES20.glUniformMatrix4fv(this.C[i], 1, false, this.x, 0);
            GLES20.glDrawArrays(5, 0, 4);
        }
        if (this.T || this.N != null || this.O != null || this.j != null) {
            GLES20.glUseProgram(this.J);
            GLES20.glActiveTexture(33984);
            GLES20.glUniform1i(this.M, 0);
            GLES20.glEnableVertexAttribArray(this.L);
            GLES20.glVertexAttribPointer(this.L, 2, 5126, false, 8, (Buffer) this.d);
            GLES20.glEnableVertexAttribArray(this.K);
        }
        int[] iArr = this.N;
        if (iArr != null && this.o != null) {
            j(true, iArr[0], -10000.0f, -10000.0f, -10000.0f, -10000.0f, 0.0f, false, this.k && this.T, -1);
        }
        if (this.j != null) {
            int i6 = 0;
            while (true) {
                int[] iArr2 = this.j;
                if (i6 >= iArr2.length) {
                    break;
                }
                j(true, iArr2[i6], -10000.0f, -10000.0f, -10000.0f, -10000.0f, 0.0f, false, false, i6);
                i6++;
            }
        }
        if (this.N != null) {
            int i7 = this.o != null ? 1 : 0;
            while (true) {
                int[] iArr3 = this.N;
                if (i7 >= iArr3.length) {
                    break;
                }
                j(true, iArr3[i7], -10000.0f, -10000.0f, -10000.0f, -10000.0f, 0.0f, false, this.k && this.T && i7 == 0, -1);
                i7++;
            }
        }
        if (this.O != null) {
            int size = this.p.size();
            for (int i8 = 0; i8 < size; i8++) {
                f((H.b) this.p.get(i8), ((H.b) this.p.get(i8)).j);
            }
        }
        GLES20.glFinish();
    }

    public int k() {
        return this.A;
    }

    public void m() throws InterruptedException {
        ArrayList arrayList = this.p;
        if (arrayList != null) {
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                H.b bVar = (H.b) this.p.get(i);
                long j = bVar.y;
                if (j != 0) {
                    RLottieDrawable.destroy(j);
                }
                AnimatedFileDrawable animatedFileDrawable = bVar.D;
                if (animatedFileDrawable != null) {
                    animatedFileDrawable.O0();
                }
                View view = bVar.C;
                if (view instanceof EditTextEffects) {
                    ((EditTextEffects) view).p();
                }
            }
        }
    }

    public void n(EditTextOutline editTextOutline) {
        editTextOutline.setBreakStrategy(0);
    }

    public void o() {
        String str;
        int iIntValue;
        int iIntValue2;
        char c;
        byte b;
        byte b2;
        int i;
        Typeface typefaceQ;
        byte b3 = 2;
        byte b4 = 1;
        int i2 = 0;
        int i3 = 0;
        while (true) {
            int[] iArr = this.B;
            if (i3 >= iArr.length) {
                break;
            }
            String str2 = i3 == this.v ? "#extension GL_OES_EGL_image_external : require\nprecision highp float;\nvarying vec2 vTextureCoord;\nuniform samplerExternalOES sTexture;\nvoid main() {\n  gl_FragColor = texture2D(sTexture, vTextureCoord);}\n" : i3 == this.u ? "precision highp float;\nvarying vec2 vTextureCoord;\nuniform sampler2D sTexture;\nvoid main() {\n  gl_FragColor = texture2D(sTexture, vTextureCoord);\n}\n" : i3 == this.w ? "precision highp float;\nvarying vec2 vTextureCoord;\nuniform vec4 gradientTopColor;\nuniform vec4 gradientBottomColor;\nfloat interleavedGradientNoise(vec2 n) {\n    return fract(52.9829189 * fract(.06711056 * n.x + .00583715 * n.y));\n}\nvoid main() {\n  gl_FragColor = mix(gradientTopColor, gradientBottomColor, vTextureCoord.y + (.2 * interleavedGradientNoise(gl_FragCoord.xy) - .1));\n}\n" : null;
            if (str2 != null) {
                iArr[i3] = e("uniform mat4 uMVPMatrix;\nuniform mat4 uSTMatrix;\nattribute vec4 aPosition;\nattribute vec4 aTextureCoord;\nvarying vec2 vTextureCoord;\nvoid main() {\n  gl_Position = uMVPMatrix * aPosition;\n  vTextureCoord = (uSTMatrix * aTextureCoord).xy;\n}\n", str2, false);
                this.E[i3] = GLES20.glGetAttribLocation(this.B[i3], "aPosition");
                this.F[i3] = GLES20.glGetAttribLocation(this.B[i3], "aTextureCoord");
                this.C[i3] = GLES20.glGetUniformLocation(this.B[i3], "uMVPMatrix");
                this.D[i3] = GLES20.glGetUniformLocation(this.B[i3], "uSTMatrix");
                if (i3 == this.w) {
                    this.G = GLES20.glGetUniformLocation(this.B[i3], "gradientTopColor");
                    this.H = GLES20.glGetUniformLocation(this.B[i3], "gradientBottomColor");
                }
            }
            i3++;
        }
        int[] iArr2 = new int[1];
        GLES20.glGenTextures(1, iArr2, 0);
        int i4 = iArr2[0];
        this.A = i4;
        GLES20.glBindTexture(36197, i4);
        GLES20.glTexParameteri(36197, 10241, 9729);
        GLES20.glTexParameteri(36197, 10240, 9729);
        GLES20.glTexParameteri(36197, 10242, 33071);
        GLES20.glTexParameteri(36197, 10243, 33071);
        if (this.m != null || this.o != null || this.n != null || this.p != null || this.i != null) {
            int iR = ir.nasim.tgwidgets.editor.ui.Components.l.r(35633, "attribute vec4 position;attribute vec2 inputTexCoord;varying vec2 vTextureCoord;void main() {gl_Position = position;vTextureCoord = inputTexCoord;}");
            int iR2 = ir.nasim.tgwidgets.editor.ui.Components.l.r(35632, "varying highp vec2 vTextureCoord;uniform sampler2D sTexture;void main() {gl_FragColor = texture2D(sTexture, vTextureCoord);}");
            if (iR != 0 && iR2 != 0) {
                int iGlCreateProgram = GLES20.glCreateProgram();
                this.J = iGlCreateProgram;
                GLES20.glAttachShader(iGlCreateProgram, iR);
                GLES20.glAttachShader(this.J, iR2);
                GLES20.glBindAttribLocation(this.J, 0, "position");
                GLES20.glBindAttribLocation(this.J, 1, "inputTexCoord");
                GLES20.glLinkProgram(this.J);
                int[] iArr3 = new int[1];
                GLES20.glGetProgramiv(this.J, 35714, iArr3, 0);
                if (iArr3[0] == 0) {
                    GLES20.glDeleteProgram(this.J);
                    this.J = 0;
                } else {
                    this.K = GLES20.glGetAttribLocation(this.J, "position");
                    this.L = GLES20.glGetAttribLocation(this.J, "inputTexCoord");
                    this.M = GLES20.glGetUniformLocation(this.J, "sourceImage");
                }
            }
        }
        ir.nasim.tgwidgets.editor.ui.Components.l lVar = this.m;
        if (lVar != null) {
            lVar.c();
            this.m.w(null, 0, this.A, this.q, this.r);
        }
        String str3 = this.o;
        int i5 = -16777216;
        if (str3 != null || this.n != null) {
            int[] iArr4 = new int[(str3 != null ? 1 : 0) + (this.n != null ? 1 : 0)];
            this.N = iArr4;
            GLES20.glGenTextures(iArr4.length, iArr4, 0);
            int i6 = 0;
            while (i6 < this.N.length) {
                try {
                    if (i6 != 0 || (str = this.o) == null) {
                        str = this.n;
                        iIntValue = i2;
                        iIntValue2 = iIntValue;
                    } else {
                        Pair pairB0 = AbstractC21455b.b0(str);
                        iIntValue = ((Integer) pairB0.first).intValue();
                        iIntValue2 = ((Integer) pairB0.second).intValue();
                    }
                    Bitmap bitmapDecodeFile = BitmapFactory.decodeFile(str);
                    if (bitmapDecodeFile != null) {
                        if (i6 == 0 && this.o != null && !this.k) {
                            Bitmap bitmapCreateBitmap = Bitmap.createBitmap(this.s, this.t, Bitmap.Config.ARGB_8888);
                            bitmapCreateBitmap.eraseColor(i5);
                            Canvas canvas = new Canvas(bitmapCreateBitmap);
                            float fMax = (iIntValue == 90 || iIntValue == 270) ? Math.max(bitmapDecodeFile.getHeight() / this.s, bitmapDecodeFile.getWidth() / this.t) : Math.max(bitmapDecodeFile.getWidth() / this.s, bitmapDecodeFile.getHeight() / this.t);
                            Matrix matrix = new Matrix();
                            matrix.postTranslate((-bitmapDecodeFile.getWidth()) / 2, (-bitmapDecodeFile.getHeight()) / 2);
                            float f = -1.0f;
                            float f2 = (iIntValue2 == 1 ? -1.0f : 1.0f) / fMax;
                            if (iIntValue2 != 2) {
                                f = 1.0f;
                            }
                            matrix.postScale(f2, f / fMax);
                            matrix.postRotate(iIntValue);
                            matrix.postTranslate(bitmapCreateBitmap.getWidth() / 2, bitmapCreateBitmap.getHeight() / 2);
                            canvas.drawBitmap(bitmapDecodeFile, matrix, new Paint(2));
                            bitmapDecodeFile = bitmapCreateBitmap;
                        }
                        GLES20.glBindTexture(3553, this.N[i6]);
                        GLES20.glTexParameteri(3553, 10241, 9729);
                        GLES20.glTexParameteri(3553, 10240, 9729);
                        GLES20.glTexParameteri(3553, 10242, 33071);
                        GLES20.glTexParameteri(3553, 10243, 33071);
                        GLUtils.texImage2D(3553, 0, bitmapDecodeFile, 0);
                    }
                    i6++;
                    i5 = -16777216;
                    i2 = 0;
                } catch (Throwable th) {
                    AbstractC6403Nl2.d(th);
                }
            }
        }
        ArrayList arrayList = this.i;
        char c2 = 3;
        if (arrayList != null && !arrayList.isEmpty()) {
            this.j = new int[this.i.size()];
            this.g = new FloatBuffer[this.i.size()];
            int[] iArr5 = this.j;
            GLES20.glGenTextures(iArr5.length, iArr5, 0);
            for (int i7 = 0; i7 < this.j.length; i7++) {
                try {
                    l.c cVar = (l.c) this.i.get(i7);
                    String absolutePath = cVar.f.getAbsolutePath();
                    BitmapFactory.Options options = new BitmapFactory.Options();
                    options.inJustDecodeBounds = true;
                    BitmapFactory.decodeFile(absolutePath, options);
                    options.inJustDecodeBounds = false;
                    options.inSampleSize = ir.nasim.tgwidgets.editor.ui.stories.recorder.l.k(options, this.s, this.t);
                    Bitmap bitmapDecodeFile2 = BitmapFactory.decodeFile(absolutePath, options);
                    GLES20.glBindTexture(3553, this.j[i7]);
                    GLES20.glTexParameteri(3553, 10241, 9729);
                    GLES20.glTexParameteri(3553, 10240, 9729);
                    GLES20.glTexParameteri(3553, 10242, 33071);
                    GLES20.glTexParameteri(3553, 10243, 33071);
                    GLUtils.texImage2D(3553, 0, bitmapDecodeFile2, 0);
                    float[] fArr = new float[8];
                    fArr[0] = 0.0f;
                    fArr[1] = 0.0f;
                    int i8 = cVar.b;
                    fArr[2] = i8;
                    fArr[3] = 0.0f;
                    fArr[4] = 0.0f;
                    int i9 = cVar.c;
                    fArr[5] = i9;
                    fArr[6] = i8;
                    fArr[7] = i9;
                    cVar.d.mapPoints(fArr);
                    for (int i10 = 0; i10 < 4; i10++) {
                        int i11 = i10 * 2;
                        fArr[i11] = ((fArr[i11] / this.s) * 2.0f) - 1.0f;
                        int i12 = i11 + 1;
                        fArr[i12] = 1.0f - ((fArr[i12] / this.t) * 2.0f);
                    }
                    this.g[i7] = ByteBuffer.allocateDirect(32).order(ByteOrder.nativeOrder()).asFloatBuffer();
                    this.g[i7].put(fArr).position(0);
                } catch (Throwable th2) {
                    AbstractC6403Nl2.d(th2);
                }
            }
            FloatBuffer floatBufferAsFloatBuffer = ByteBuffer.allocateDirect(32).order(ByteOrder.nativeOrder()).asFloatBuffer();
            this.h = floatBufferAsFloatBuffer;
            floatBufferAsFloatBuffer.put(new float[]{0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f}).position(0);
        }
        if (this.p != null) {
            try {
                this.P = Bitmap.createBitmap(512, 512, Bitmap.Config.ARGB_8888);
                int[] iArr6 = new int[1];
                this.O = iArr6;
                GLES20.glGenTextures(1, iArr6, 0);
                GLES20.glBindTexture(3553, this.O[0]);
                GLES20.glTexParameteri(3553, 10241, 9729);
                GLES20.glTexParameteri(3553, 10240, 9729);
                GLES20.glTexParameteri(3553, 10242, 33071);
                GLES20.glTexParameteri(3553, 10243, 33071);
                int size = this.p.size();
                int i13 = 0;
                while (i13 < size) {
                    H.b bVar = (H.b) this.p.get(i13);
                    byte b5 = bVar.a;
                    if (b5 == 0 || b5 == b3) {
                        c = c2;
                        b = b3;
                        l(bVar);
                    } else if (b5 == b4) {
                        EditTextOutline editTextOutline = new EditTextOutline(AbstractC14047hG.a);
                        editTextOutline.K1 = this.k;
                        editTextOutline.o = false;
                        editTextOutline.setBackgroundColor(0);
                        editTextOutline.setPadding(AbstractC21455b.F(7.0f), AbstractC21455b.F(7.0f), AbstractC21455b.F(7.0f), AbstractC21455b.F(7.0f));
                        LU4 lu4 = bVar.l;
                        if (lu4 != null && (typefaceQ = lu4.q()) != null) {
                            editTextOutline.setTypeface(typefaceQ);
                        }
                        boolean z = false;
                        editTextOutline.setTextSize(0, bVar.k);
                        SpannableString spannableString = new SpannableString(bVar.h);
                        Iterator it = bVar.i.iterator();
                        while (it.hasNext()) {
                            H.a aVar = (H.a) it.next();
                            if (aVar.i != null) {
                                H.b bVar2 = new H.b();
                                aVar.j = bVar2;
                                bVar2.h = aVar.i;
                                bVar2.b = aVar.k;
                                l(bVar2);
                                SpannableString spannableString2 = spannableString;
                                a aVar2 = new a(0L, 1.0f, editTextOutline.getPaint().getFontMetricsInt(), bVar, editTextOutline, aVar);
                                int i14 = aVar.b;
                                spannableString2.setSpan(aVar2, i14, aVar.c + i14, 33);
                                spannableString = spannableString2;
                                z = z;
                                bVar = bVar;
                                editTextOutline = editTextOutline;
                            }
                        }
                        boolean z2 = z;
                        EditTextOutline editTextOutline2 = editTextOutline;
                        H.b bVar3 = bVar;
                        editTextOutline2.setText(R62.S(spannableString, editTextOutline2.getPaint().getFontMetricsInt(), (int) (editTextOutline2.getTextSize() * 0.8f), z2));
                        editTextOutline2.setTextColor(bVar3.j);
                        Editable text = editTextOutline2.getText();
                        if (text instanceof Spanned) {
                            R62.c[] cVarArr = (R62.c[]) text.getSpans(z2 ? 1 : 0, text.length(), R62.c.class);
                            for (int i15 = z2 ? 1 : 0; i15 < cVarArr.length; i15++) {
                            }
                        }
                        int i16 = bVar3.m;
                        editTextOutline2.setGravity(i16 != 1 ? i16 != 2 ? 19 : 21 : 17);
                        int i17 = bVar3.m;
                        if (i17 == 1) {
                            i = 4;
                        } else if (i17 != 2) {
                            i = FH3.D ? 3 : 2;
                        } else if (FH3.D) {
                        }
                        editTextOutline2.setTextAlignment(i);
                        editTextOutline2.setHorizontallyScrolling(z2);
                        editTextOutline2.setImeOptions(268435456);
                        editTextOutline2.setFocusableInTouchMode(true);
                        editTextOutline2.setInputType(editTextOutline2.getInputType() | 16384);
                        n(editTextOutline2);
                        byte b6 = bVar3.b;
                        if (b6 == 0) {
                            editTextOutline2.setFrameColor(bVar3.j);
                            editTextOutline2.setTextColor(AbstractC21455b.z(bVar3.j) >= 0.721f ? -16777216 : -1);
                        } else if (b6 == 1) {
                            editTextOutline2.setFrameColor(AbstractC21455b.z(bVar3.j) >= 0.25f ? -1728053248 : -1711276033);
                            editTextOutline2.setTextColor(bVar3.j);
                        } else {
                            b = 2;
                            if (b6 == 2) {
                                editTextOutline2.setFrameColor(AbstractC21455b.z(bVar3.j) >= 0.25f ? -16777216 : -1);
                                editTextOutline2.setTextColor(bVar3.j);
                                c = 3;
                                editTextOutline2.measure(View.MeasureSpec.makeMeasureSpec(bVar3.n, 1073741824), View.MeasureSpec.makeMeasureSpec(bVar3.o, 1073741824));
                                editTextOutline2.layout(z2 ? 1 : 0, z2 ? 1 : 0, bVar3.n, bVar3.o);
                                bVar3.B = Bitmap.createBitmap(bVar3.n, bVar3.o, Bitmap.Config.ARGB_8888);
                                editTextOutline2.draw(new Canvas(bVar3.B));
                            } else {
                                c = 3;
                                if (b6 == 3) {
                                    editTextOutline2.setFrameColor(z2 ? 1 : 0);
                                    editTextOutline2.setTextColor(bVar3.j);
                                }
                                editTextOutline2.measure(View.MeasureSpec.makeMeasureSpec(bVar3.n, 1073741824), View.MeasureSpec.makeMeasureSpec(bVar3.o, 1073741824));
                                editTextOutline2.layout(z2 ? 1 : 0, z2 ? 1 : 0, bVar3.n, bVar3.o);
                                bVar3.B = Bitmap.createBitmap(bVar3.n, bVar3.o, Bitmap.Config.ARGB_8888);
                                editTextOutline2.draw(new Canvas(bVar3.B));
                            }
                        }
                        b = 2;
                        c = 3;
                        editTextOutline2.measure(View.MeasureSpec.makeMeasureSpec(bVar3.n, 1073741824), View.MeasureSpec.makeMeasureSpec(bVar3.o, 1073741824));
                        editTextOutline2.layout(z2 ? 1 : 0, z2 ? 1 : 0, bVar3.n, bVar3.o);
                        bVar3.B = Bitmap.createBitmap(bVar3.n, bVar3.o, Bitmap.Config.ARGB_8888);
                        editTextOutline2.draw(new Canvas(bVar3.B));
                    } else {
                        c = c2;
                        b = b3;
                        b2 = b4;
                        i13 += b2;
                        b4 = b2;
                        b3 = b;
                        c2 = c;
                    }
                    b2 = 1;
                    i13 += b2;
                    b4 = b2;
                    b3 = b;
                    c2 = c;
                }
            } catch (Throwable th3) {
                AbstractC6403Nl2.d(th3);
            }
        }
    }
}
