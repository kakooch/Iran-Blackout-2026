package ir.nasim.tgwidgets.editor.ui.Components.Paint;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.gov.nist.javax.sdp.fields.SDPKeywords;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.RectF;
import android.opengl.GLES20;
import ir.nasim.AbstractC18273oN7;
import ir.nasim.AbstractC5098Hw6;
import ir.nasim.C13445gE6;
import ir.nasim.C17574nB7;
import ir.nasim.C17939no7;
import ir.nasim.C18871pO5;
import ir.nasim.HU1;
import ir.nasim.InterpolatorC12631ew1;
import ir.nasim.QY0;
import ir.nasim.SD6;
import ir.nasim.X05;
import ir.nasim.XB2;
import ir.nasim.tgwidgets.editor.messenger.Utilities;
import ir.nasim.tgwidgets.editor.ui.Components.Paint.a;
import java.io.IOException;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.UUID;
import java.util.zip.DataFormatException;

/* loaded from: classes7.dex */
public class d {
    private float[] A;
    private float[] B;
    private boolean C;
    private float D;
    private float E;
    private ValueAnimator F;
    private ValueAnimator G;
    private Paint H;
    private InterfaceC1590d a;
    private X05 b;
    private q c;
    private q d;
    private RenderView f;
    private SD6 g;
    private RectF h;
    private ir.nasim.tgwidgets.editor.ui.Components.Paint.a i;
    private C17939no7 k;
    private C17939no7 l;
    private Bitmap m;
    private int n;
    private Bitmap o;
    private ByteBuffer p;
    private ByteBuffer q;
    private int r;
    private int s;
    private int t;
    private Map u;
    private int v;
    private ByteBuffer x;
    private boolean y;
    private C13445gE6 z;
    private HashMap j = new HashMap();
    private int[] w = new int[1];
    private C18871pO5 e = new C18871pO5();

    class a extends AnimatorListenerAdapter {
        a() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void b() {
            if (d.this.a != null) {
                d.this.a.b();
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            d.this.F = null;
            d.this.f.C(new Runnable() { // from class: ir.nasim.tgwidgets.editor.ui.Components.Paint.c
                @Override // java.lang.Runnable
                public final void run() {
                    this.a.b();
                }
            });
        }
    }

    class b extends AnimatorListenerAdapter {
        b() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void b() throws DataFormatException, IOException {
            if (d.this.d == null) {
                d.this.G = null;
                return;
            }
            int currentColor = d.this.f.getCurrentColor();
            d dVar = d.this;
            dVar.q0(dVar.b, false, false);
            d dVar2 = d.this;
            C13445gE6 c13445gE6M = dVar2.M(dVar2.b, currentColor, new RectF(d.this.h));
            d.this.J();
            q qVar = d.this.d;
            d dVar3 = d.this;
            RectF rectF = new RectF();
            dVar3.h = rectF;
            qVar.a(rectF);
            d.this.x0(d.this.O(qVar, currentColor, new RectF(d.this.h)), false);
            d.this.x0(c13445gE6M, false);
            d.this.O(qVar, currentColor, null);
            d.this.d = null;
            d.this.E = 0.0f;
            d.this.G = null;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            d.this.f.C(new Runnable() { // from class: ir.nasim.tgwidgets.editor.ui.Components.Paint.e
                @Override // java.lang.Runnable
                public final void run() throws DataFormatException, IOException {
                    this.a.b();
                }
            });
        }
    }

    public static class c {
        public Bitmap a;
        public ByteBuffer b;

        c(Bitmap bitmap, ByteBuffer byteBuffer) {
            this.a = bitmap;
            this.b = byteBuffer;
        }
    }

    /* renamed from: ir.nasim.tgwidgets.editor.ui.Components.Paint.d$d, reason: collision with other inner class name */
    public interface InterfaceC1590d {
        C17574nB7 a();

        void b();

        HU1 c();
    }

    public d(SD6 sd6, Bitmap bitmap, int i) {
        this.g = sd6;
        this.m = bitmap;
        this.n = i;
        this.x = ByteBuffer.allocateDirect(((int) sd6.a) * ((int) sd6.b) * 4);
        SD6 sd62 = this.g;
        this.A = XB2.b(0.0f, sd62.a, 0.0f, sd62.b, -1.0f, 1.0f);
        if (this.p == null) {
            ByteBuffer byteBufferAllocateDirect = ByteBuffer.allocateDirect(32);
            this.p = byteBufferAllocateDirect;
            byteBufferAllocateDirect.order(ByteOrder.nativeOrder());
        }
        this.p.putFloat(0.0f);
        this.p.putFloat(0.0f);
        this.p.putFloat(this.g.a);
        this.p.putFloat(0.0f);
        this.p.putFloat(0.0f);
        this.p.putFloat(this.g.b);
        this.p.putFloat(this.g.a);
        this.p.putFloat(this.g.b);
        this.p.rewind();
        if (this.q == null) {
            ByteBuffer byteBufferAllocateDirect2 = ByteBuffer.allocateDirect(32);
            this.q = byteBufferAllocateDirect2;
            byteBufferAllocateDirect2.order(ByteOrder.nativeOrder());
            this.q.putFloat(0.0f);
            this.q.putFloat(0.0f);
            this.q.putFloat(1.0f);
            this.q.putFloat(0.0f);
            this.q.putFloat(0.0f);
            this.q.putFloat(1.0f);
            this.q.putFloat(1.0f);
            this.q.putFloat(1.0f);
            this.q.rewind();
        }
    }

    private void E() {
        this.v++;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void J() {
        GLES20.glBindFramebuffer(36160, T());
        GLES20.glFramebufferTexture2D(36160, 36064, 3553, R(), 0);
        AbstractC18273oN7.a();
        if (GLES20.glCheckFramebufferStatus(36160) == 36053) {
            SD6 sd6 = this.g;
            GLES20.glViewport(0, 0, (int) sd6.a, (int) sd6.b);
            GLES20.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
            GLES20.glClear(16384);
        }
        GLES20.glBindFramebuffer(36160, 0);
        InterfaceC1590d interfaceC1590d = this.a;
        if (interfaceC1590d != null) {
            interfaceC1590d.b();
        }
        this.e.f();
        this.h = null;
        this.b = null;
        this.E = 0.0f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public C13445gE6 M(X05 x05, int i, RectF rectF) {
        InterfaceC1590d interfaceC1590d;
        C13445gE6 c13445gE6R0 = r0(rectF);
        E();
        GLES20.glBindFramebuffer(36160, T());
        GLES20.glFramebufferTexture2D(36160, 36064, 3553, V(), 0);
        SD6 sd6 = this.g;
        GLES20.glViewport(0, 0, (int) sd6.a, (int) sd6.b);
        ir.nasim.tgwidgets.editor.ui.Components.Paint.a aVarB = this.i;
        if (x05 != null) {
            aVarB = x05.b();
        }
        p pVar = (p) this.u.get(aVarB.h(1));
        if (pVar == null) {
            return null;
        }
        GLES20.glUseProgram(pVar.a);
        GLES20.glUniformMatrix4fv(pVar.e("mvpMatrix"), 1, false, FloatBuffer.wrap(this.A));
        GLES20.glUniform1i(pVar.e("texture"), 0);
        GLES20.glUniform1i(pVar.e("mask"), 1);
        p.a(pVar.e("color"), QY0.k(i, (int) (Color.alpha(i) * aVarB.e())));
        GLES20.glActiveTexture(33984);
        GLES20.glBindTexture(3553, V());
        GLES20.glTexParameteri(3553, 10241, 9729);
        GLES20.glActiveTexture(33985);
        GLES20.glBindTexture(3553, R());
        if ((aVarB instanceof a.b) && this.l != null) {
            GLES20.glUniform1i(pVar.e("blured"), 2);
            GLES20.glActiveTexture(33986);
            GLES20.glBindTexture(3553, this.l.d());
        }
        GLES20.glBlendFunc(1, 0);
        GLES20.glVertexAttribPointer(0, 2, 5126, false, 8, (Buffer) this.p);
        GLES20.glEnableVertexAttribArray(0);
        GLES20.glVertexAttribPointer(1, 2, 5126, false, 8, (Buffer) this.q);
        GLES20.glEnableVertexAttribArray(1);
        GLES20.glDrawArrays(5, 0, 4);
        GLES20.glBindTexture(3553, V());
        GLES20.glTexParameteri(3553, 10241, 9729);
        GLES20.glBindFramebuffer(36160, 0);
        if (!X() && (interfaceC1590d = this.a) != null) {
            interfaceC1590d.b();
        }
        P();
        this.e.f();
        this.b = null;
        this.c = null;
        return c13445gE6R0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public C13445gE6 O(q qVar, int i, RectF rectF) {
        C13445gE6 c13445gE6R0 = r0(rectF);
        E();
        GLES20.glBindFramebuffer(36160, T());
        GLES20.glFramebufferTexture2D(36160, 36064, 3553, V(), 0);
        SD6 sd6 = this.g;
        GLES20.glViewport(0, 0, (int) sd6.a, (int) sd6.b);
        ir.nasim.tgwidgets.editor.ui.Components.Paint.a aVar = qVar.a;
        if (aVar == null) {
            aVar = this.i;
        }
        p pVar = (p) this.u.get(aVar.h(1));
        if (pVar == null) {
            return null;
        }
        GLES20.glUseProgram(pVar.a);
        GLES20.glUniformMatrix4fv(pVar.e("mvpMatrix"), 1, false, FloatBuffer.wrap(this.A));
        GLES20.glUniform1i(pVar.e("texture"), 0);
        GLES20.glUniform1i(pVar.e("mask"), 1);
        p.a(pVar.e("color"), i);
        GLES20.glActiveTexture(33984);
        GLES20.glBindTexture(3553, V());
        GLES20.glTexParameteri(3553, 10241, 9729);
        GLES20.glActiveTexture(33985);
        GLES20.glBindTexture(3553, R());
        if ((aVar instanceof a.b) && this.l != null) {
            GLES20.glUniform1i(pVar.e("blured"), 2);
            GLES20.glActiveTexture(33986);
            GLES20.glBindTexture(3553, this.l.d());
        }
        if (aVar instanceof a.g) {
            GLES20.glUniform1i(pVar.e("type"), qVar.b());
            int iE = pVar.e("resolution");
            SD6 sd62 = this.g;
            GLES20.glUniform2f(iE, sd62.a, sd62.b);
            GLES20.glUniform2f(pVar.e("center"), qVar.b, qVar.c);
            GLES20.glUniform2f(pVar.e("radius"), qVar.d, qVar.e);
            GLES20.glUniform1f(pVar.e("thickness"), qVar.f);
            GLES20.glUniform1f(pVar.e("rounding"), qVar.g);
            GLES20.glUniform2f(pVar.e("middle"), qVar.i, qVar.j);
            GLES20.glUniform1f(pVar.e("rotation"), qVar.h);
            GLES20.glUniform1i(pVar.e("fill"), qVar.l ? 1 : 0);
            GLES20.glUniform1f(pVar.e("arrowTriangleLength"), qVar.k);
            GLES20.glUniform1i(pVar.e("composite"), 1);
            GLES20.glUniform1i(pVar.e(SDPKeywords.CLEAR), 0);
        }
        GLES20.glBlendFunc(1, 0);
        GLES20.glVertexAttribPointer(0, 2, 5126, false, 8, (Buffer) this.p);
        GLES20.glEnableVertexAttribArray(0);
        GLES20.glVertexAttribPointer(1, 2, 5126, false, 8, (Buffer) this.q);
        GLES20.glEnableVertexAttribArray(1);
        GLES20.glDrawArrays(5, 0, 4);
        GLES20.glBindTexture(3553, V());
        GLES20.glTexParameteri(3553, 10241, 9729);
        GLES20.glBindFramebuffer(36160, 0);
        if (this.a != null && !X()) {
            this.a.b();
        }
        P();
        this.e.f();
        this.E = 0.0f;
        this.C = false;
        this.D = 0.0f;
        this.d = null;
        this.b = null;
        this.c = null;
        return c13445gE6R0;
    }

    private void P() {
        this.v--;
    }

    private int R() {
        if (this.s == 0) {
            this.s = C17939no7.c(this.g);
        }
        return this.s;
    }

    private int T() {
        if (this.r == 0) {
            int[] iArr = new int[1];
            GLES20.glGenFramebuffers(1, iArr, 0);
            this.r = iArr[0];
            AbstractC18273oN7.a();
        }
        return this.r;
    }

    private int V() {
        C17939no7 c17939no7 = this.k;
        if (c17939no7 != null) {
            return c17939no7.d();
        }
        return 0;
    }

    private boolean X() {
        return this.v > 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Y(ValueAnimator valueAnimator) {
        this.E = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        InterfaceC1590d interfaceC1590d = this.a;
        if (interfaceC1590d != null) {
            interfaceC1590d.b();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Z(final ValueAnimator valueAnimator) {
        this.f.C(new Runnable() { // from class: ir.nasim.IV4
            @Override // java.lang.Runnable
            public final void run() {
                this.a.Y(valueAnimator);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a0() {
        this.c = null;
        InterfaceC1590d interfaceC1590d = this.a;
        if (interfaceC1590d != null) {
            interfaceC1590d.b();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b0(Runnable runnable) {
        J();
        if (runnable != null) {
            runnable.run();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void c0(X05 x05, int i, boolean z, Runnable runnable) {
        M(x05, i, z ? this.h : null);
        if (z) {
            this.h = null;
        }
        if (runnable != null) {
            runnable.run();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void d0(q qVar, int i) {
        O(qVar, i, this.h);
        this.h = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void e0(Runnable runnable) {
        this.y = true;
        this.z = new C13445gE6(S(Q(), true).b, Q(), this.a.c());
        F(false);
        if (runnable != null) {
            runnable.run();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void f0(q qVar, Runnable runnable) {
        this.c = qVar;
        if (this.h == null) {
            this.h = new RectF();
        }
        this.c.a(this.h);
        InterfaceC1590d interfaceC1590d = this.a;
        if (interfaceC1590d != null) {
            interfaceC1590d.b();
        }
        if (runnable != null) {
            runnable.run();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void g0(X05 x05, boolean z, boolean z2, Runnable runnable) {
        q0(x05, z, z2);
        if (runnable != null) {
            runnable.run();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void i0(C13445gE6 c13445gE6) throws DataFormatException, IOException {
        x0(c13445gE6, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void j0(ValueAnimator valueAnimator) {
        this.D = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        InterfaceC1590d interfaceC1590d = this.a;
        if (interfaceC1590d != null) {
            interfaceC1590d.b();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void k0(final ValueAnimator valueAnimator) {
        this.f.C(new Runnable() { // from class: ir.nasim.KV4
            @Override // java.lang.Runnable
            public final void run() {
                this.a.j0(valueAnimator);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void l0(q qVar) {
        if (qVar != null && this.t == 0) {
            this.t = C17939no7.c(this.g);
        }
        if (this.C == (qVar != null)) {
            if (qVar != this.d) {
                this.d = qVar;
                InterfaceC1590d interfaceC1590d = this.a;
                if (interfaceC1590d != null) {
                    interfaceC1590d.b();
                    return;
                }
                return;
            }
            return;
        }
        this.C = qVar != null;
        ValueAnimator valueAnimator = this.F;
        if (valueAnimator != null) {
            valueAnimator.cancel();
            this.F = null;
        }
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(this.D, this.C ? 1.0f : 0.0f);
        this.F = valueAnimatorOfFloat;
        valueAnimatorOfFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: ir.nasim.JV4
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator2) {
                this.a.k0(valueAnimator2);
            }
        });
        this.F.addListener(new a());
        this.F.setInterpolator(InterpolatorC12631ew1.h);
        this.F.start();
        this.d = qVar;
        InterfaceC1590d interfaceC1590d2 = this.a;
        if (interfaceC1590d2 != null) {
            interfaceC1590d2.b();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q0(X05 x05, boolean z, boolean z2) {
        RectF rectFD;
        this.b = x05;
        if (x05 == null) {
            return;
        }
        GLES20.glBindFramebuffer(36160, T());
        GLES20.glFramebufferTexture2D(36160, 36064, 3553, R(), 0);
        AbstractC18273oN7.a();
        if (GLES20.glCheckFramebufferStatus(36160) == 36053) {
            SD6 sd6 = this.g;
            GLES20.glViewport(0, 0, (int) sd6.a, (int) sd6.b);
            if (z) {
                GLES20.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
                GLES20.glClear(16384);
            }
            if (this.u == null) {
                return;
            }
            ir.nasim.tgwidgets.editor.ui.Components.Paint.a aVarB = x05.b();
            p pVar = (p) this.u.get(aVarB.h(2));
            if (pVar == null) {
                return;
            }
            GLES20.glUseProgram(pVar.a);
            C17939no7 c17939no7 = (C17939no7) this.j.get(Integer.valueOf(aVarB.l()));
            if (c17939no7 == null) {
                c17939no7 = new C17939no7(aVarB.k());
                this.j.put(Integer.valueOf(aVarB.l()), c17939no7);
            }
            GLES20.glActiveTexture(33984);
            GLES20.glBindTexture(3553, c17939no7.d());
            GLES20.glUniformMatrix4fv(pVar.e("mvpMatrix"), 1, false, FloatBuffer.wrap(this.A));
            GLES20.glUniform1i(pVar.e("texture"), 0);
            if (z2) {
                this.e.f = 1.0f;
            } else {
                this.e.f = this.f.getScaleX();
            }
            rectFD = g.d(x05, this.e, z2);
        } else {
            rectFD = null;
        }
        GLES20.glBindFramebuffer(36160, 0);
        InterfaceC1590d interfaceC1590d = this.a;
        if (interfaceC1590d != null) {
            interfaceC1590d.b();
        }
        RectF rectF = this.h;
        if (rectF != null) {
            rectF.union(rectFD);
        } else {
            this.h = rectFD;
        }
    }

    private C13445gE6 r0(RectF rectF) {
        if (rectF == null || !rectF.setIntersect(rectF, Q())) {
            return null;
        }
        final C13445gE6 c13445gE6 = new C13445gE6(S(rectF, true).b, rectF, this.a.c());
        this.a.a().f(UUID.randomUUID(), new Runnable() { // from class: ir.nasim.NV4
            @Override // java.lang.Runnable
            public final void run() {
                this.a.h0(c13445gE6);
            }
        });
        return c13445gE6;
    }

    private void t0(int i, float f) {
        p pVar = (p) this.u.get("blit");
        if (i == 0 || pVar == null) {
            return;
        }
        GLES20.glUseProgram(pVar.a);
        GLES20.glUniformMatrix4fv(pVar.e("mvpMatrix"), 1, false, FloatBuffer.wrap(this.B));
        GLES20.glUniform1i(pVar.e("texture"), 0);
        GLES20.glUniform1f(pVar.e("alpha"), f);
        GLES20.glActiveTexture(33984);
        GLES20.glBindTexture(3553, i);
        GLES20.glBlendFunc(1, 771);
        GLES20.glVertexAttribPointer(0, 2, 5126, false, 8, (Buffer) this.p);
        GLES20.glEnableVertexAttribArray(0);
        GLES20.glVertexAttribPointer(1, 2, 5126, false, 8, (Buffer) this.q);
        GLES20.glEnableVertexAttribArray(1);
        GLES20.glDrawArrays(5, 0, 4);
        AbstractC18273oN7.a();
    }

    private void u0(int i, X05 x05, float f) {
        if (x05 == null) {
            return;
        }
        ir.nasim.tgwidgets.editor.ui.Components.Paint.a aVarB = x05.b();
        if (aVarB == null) {
            aVarB = this.i;
        }
        p pVar = (p) this.u.get(aVarB.h(0));
        if (pVar == null) {
            return;
        }
        GLES20.glUseProgram(pVar.a);
        GLES20.glUniformMatrix4fv(pVar.e("mvpMatrix"), 1, false, FloatBuffer.wrap(this.B));
        GLES20.glUniform1i(pVar.e("texture"), 0);
        GLES20.glUniform1i(pVar.e("mask"), 1);
        p.a(pVar.e("color"), QY0.k(x05.c(), (int) (Color.alpha(r4) * aVarB.e() * f)));
        GLES20.glActiveTexture(33984);
        GLES20.glBindTexture(3553, V());
        GLES20.glActiveTexture(33985);
        GLES20.glBindTexture(3553, i);
        if ((aVarB instanceof a.b) && this.l != null) {
            GLES20.glUniform1i(pVar.e("blured"), 2);
            GLES20.glActiveTexture(33986);
            GLES20.glBindTexture(3553, this.l.d());
        }
        GLES20.glBlendFunc(1, 771);
        GLES20.glVertexAttribPointer(0, 2, 5126, false, 8, (Buffer) this.p);
        GLES20.glEnableVertexAttribArray(0);
        GLES20.glVertexAttribPointer(1, 2, 5126, false, 8, (Buffer) this.q);
        GLES20.glEnableVertexAttribArray(1);
        GLES20.glDrawArrays(5, 0, 4);
        AbstractC18273oN7.a();
    }

    private void v0(int i, int i2, q qVar, float f) {
        p pVar;
        if (qVar == null) {
            return;
        }
        ir.nasim.tgwidgets.editor.ui.Components.Paint.a aVar = this.i;
        a.g gVar = qVar.a;
        if (gVar != null && i == this.t) {
            aVar = gVar;
        }
        if (aVar == null || this.f == null || (pVar = (p) this.u.get(aVar.h(0))) == null) {
            return;
        }
        GLES20.glUseProgram(pVar.a);
        GLES20.glUniformMatrix4fv(pVar.e("mvpMatrix"), 1, false, FloatBuffer.wrap(this.B));
        GLES20.glUniform1i(pVar.e("texture"), 0);
        GLES20.glUniform1i(pVar.e("mask"), 1);
        p.a(pVar.e("color"), QY0.k(this.f.getCurrentColor(), (int) (Color.alpha(r6) * f)));
        GLES20.glActiveTexture(33984);
        GLES20.glBindTexture(3553, i);
        GLES20.glActiveTexture(33985);
        GLES20.glBindTexture(3553, i2);
        if (aVar instanceof a.g) {
            GLES20.glUniform1i(pVar.e("type"), ((a.g) aVar).p());
            int iE = pVar.e("resolution");
            SD6 sd6 = this.g;
            GLES20.glUniform2f(iE, sd6.a, sd6.b);
            GLES20.glUniform2f(pVar.e("center"), qVar.b, qVar.c);
            GLES20.glUniform2f(pVar.e("radius"), qVar.d, qVar.e);
            GLES20.glUniform1f(pVar.e("thickness"), qVar.f);
            GLES20.glUniform1f(pVar.e("rounding"), qVar.g);
            GLES20.glUniform2f(pVar.e("middle"), qVar.i, qVar.j);
            GLES20.glUniform1f(pVar.e("rotation"), qVar.h);
            GLES20.glUniform1i(pVar.e("fill"), qVar.l ? 1 : 0);
            GLES20.glUniform1f(pVar.e("arrowTriangleLength"), qVar.k);
            GLES20.glUniform1i(pVar.e("composite"), 0);
            GLES20.glUniform1i(pVar.e(SDPKeywords.CLEAR), qVar == this.d ? 1 : 0);
        }
        GLES20.glBlendFunc(1, 771);
        GLES20.glVertexAttribPointer(0, 2, 5126, false, 8, (Buffer) this.p);
        GLES20.glEnableVertexAttribArray(0);
        GLES20.glVertexAttribPointer(1, 2, 5126, false, 8, (Buffer) this.q);
        GLES20.glEnableVertexAttribArray(1);
        GLES20.glDrawArrays(5, 0, 4);
        AbstractC18273oN7.a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: w0, reason: merged with bridge method [inline-methods] */
    public void h0(final C13445gE6 c13445gE6) {
        this.f.C(new Runnable() { // from class: ir.nasim.PV4
            @Override // java.lang.Runnable
            public final void run() throws DataFormatException, IOException {
                this.a.i0(c13445gE6);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void x0(C13445gE6 c13445gE6, boolean z) throws DataFormatException, IOException {
        InterfaceC1590d interfaceC1590d;
        if (c13445gE6 == null) {
            return;
        }
        ByteBuffer byteBufferB = c13445gE6.b();
        GLES20.glBindTexture(3553, V());
        GLES20.glTexSubImage2D(3553, 0, c13445gE6.e(), c13445gE6.f(), c13445gE6.d(), c13445gE6.c(), 6408, 5121, byteBufferB);
        if (!X() && (interfaceC1590d = this.a) != null) {
            interfaceC1590d.b();
        }
        if (z) {
            c13445gE6.a();
        }
    }

    public void A0(InterfaceC1590d interfaceC1590d) {
        this.a = interfaceC1590d;
    }

    public void B0(final q qVar) {
        if (this.G != null) {
            return;
        }
        this.f.C(new Runnable() { // from class: ir.nasim.HV4
            @Override // java.lang.Runnable
            public final void run() {
                this.a.l0(qVar);
            }
        });
    }

    public void C0(float[] fArr) {
        this.B = fArr;
    }

    public boolean D() {
        if (this.d == null || !this.C || this.t == 0) {
            return false;
        }
        ValueAnimator valueAnimator = this.G;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.G = valueAnimatorOfFloat;
        valueAnimatorOfFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: ir.nasim.TV4
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator2) {
                this.a.Z(valueAnimator2);
            }
        });
        this.G.addListener(new b());
        this.G.setInterpolator(InterpolatorC12631ew1.h);
        this.G.setDuration(350L);
        this.G.start();
        return true;
    }

    public void D0(RenderView renderView) {
        this.f = renderView;
    }

    public void E0() {
        this.u = AbstractC5098Hw6.b();
    }

    public void F(boolean z) {
        int i = this.r;
        if (i != 0) {
            int[] iArr = this.w;
            iArr[0] = i;
            GLES20.glDeleteFramebuffers(1, iArr, 0);
            this.r = 0;
        }
        this.k.a(z);
        int i2 = this.s;
        if (i2 != 0) {
            int[] iArr2 = this.w;
            iArr2[0] = i2;
            GLES20.glDeleteTextures(1, iArr2, 0);
            this.s = 0;
        }
        for (C17939no7 c17939no7 : this.j.values()) {
            if (c17939no7 != null) {
                c17939no7.a(true);
            }
        }
        this.j.clear();
        int i3 = this.t;
        if (i3 != 0) {
            int[] iArr3 = this.w;
            iArr3[0] = i3;
            GLES20.glDeleteTextures(1, iArr3, 0);
            this.t = 0;
        }
        C17939no7 c17939no72 = this.l;
        if (c17939no72 != null) {
            c17939no72.a(true);
        }
        Map map = this.u;
        if (map != null) {
            Iterator it = map.values().iterator();
            while (it.hasNext()) {
                ((p) it.next()).b();
            }
            this.u = null;
        }
    }

    public void G() {
        this.f.C(new Runnable() { // from class: ir.nasim.LV4
            @Override // java.lang.Runnable
            public final void run() {
                this.a.a0();
            }
        });
    }

    public void H() {
        I(null);
    }

    public void I(final Runnable runnable) {
        this.f.C(new Runnable() { // from class: ir.nasim.SV4
            @Override // java.lang.Runnable
            public final void run() {
                this.a.b0(runnable);
            }
        });
    }

    public void K(X05 x05, int i) {
        L(x05, i, true, null);
    }

    public void L(final X05 x05, final int i, final boolean z, final Runnable runnable) {
        if (this.u == null || this.i == null) {
            return;
        }
        this.f.C(new Runnable() { // from class: ir.nasim.RV4
            @Override // java.lang.Runnable
            public final void run() {
                this.a.c0(x05, i, z, runnable);
            }
        });
    }

    public void N(final q qVar, final int i) {
        if (qVar == null || this.u == null) {
            return;
        }
        this.f.C(new Runnable() { // from class: ir.nasim.GV4
            @Override // java.lang.Runnable
            public final void run() {
                this.a.d0(qVar, i);
            }
        });
    }

    public RectF Q() {
        SD6 sd6 = this.g;
        return new RectF(0.0f, 0.0f, sd6.a, sd6.b);
    }

    public c S(RectF rectF, boolean z) {
        c cVar;
        int i = (int) rectF.left;
        int i2 = (int) rectF.top;
        int iWidth = (int) rectF.width();
        int iHeight = (int) rectF.height();
        GLES20.glGenFramebuffers(1, this.w, 0);
        int i3 = this.w[0];
        GLES20.glBindFramebuffer(36160, i3);
        GLES20.glGenTextures(1, this.w, 0);
        int i4 = this.w[0];
        GLES20.glBindTexture(3553, i4);
        GLES20.glTexParameteri(3553, 10242, 33071);
        GLES20.glTexParameteri(3553, 10243, 33071);
        GLES20.glTexParameteri(3553, 10241, 9729);
        GLES20.glTexParameteri(3553, 10240, 9728);
        GLES20.glTexImage2D(3553, 0, 6408, iWidth, iHeight, 0, 6408, 5121, null);
        GLES20.glFramebufferTexture2D(36160, 36064, 3553, i4, 0);
        SD6 sd6 = this.g;
        GLES20.glViewport(0, 0, (int) sd6.a, (int) sd6.b);
        Map map = this.u;
        if (map == null) {
            return null;
        }
        p pVar = (p) map.get(z ? "nonPremultipliedBlit" : "blit");
        if (pVar == null) {
            return null;
        }
        GLES20.glUseProgram(pVar.a);
        Matrix matrix = new Matrix();
        matrix.preTranslate(-i, -i2);
        GLES20.glUniformMatrix4fv(pVar.e("mvpMatrix"), 1, false, FloatBuffer.wrap(XB2.c(this.A, XB2.a(matrix))));
        GLES20.glUniform1i(pVar.e("texture"), 0);
        GLES20.glActiveTexture(33984);
        GLES20.glBindTexture(3553, V());
        GLES20.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
        GLES20.glClear(16384);
        GLES20.glBlendFunc(1, 0);
        GLES20.glVertexAttribPointer(0, 2, 5126, false, 8, (Buffer) this.p);
        GLES20.glEnableVertexAttribArray(0);
        GLES20.glVertexAttribPointer(1, 2, 5126, false, 8, (Buffer) this.q);
        GLES20.glEnableVertexAttribArray(1);
        GLES20.glDrawArrays(5, 0, 4);
        this.x.limit(iWidth * iHeight * 4);
        GLES20.glReadPixels(0, 0, iWidth, iHeight, 6408, 5121, this.x);
        if (z) {
            cVar = new c(null, this.x);
        } else {
            Bitmap bitmapCreateBitmap = Bitmap.createBitmap(iWidth, iHeight, Bitmap.Config.ARGB_8888);
            bitmapCreateBitmap.copyPixelsFromBuffer(this.x);
            cVar = new c(bitmapCreateBitmap, null);
        }
        this.x.rewind();
        int[] iArr = this.w;
        iArr[0] = i3;
        GLES20.glDeleteFramebuffers(1, iArr, 0);
        int[] iArr2 = this.w;
        iArr2[0] = i4;
        GLES20.glDeleteTextures(1, iArr2, 0);
        return cVar;
    }

    public SD6 U() {
        return this.g;
    }

    public boolean W() {
        return this.y;
    }

    public void m0(final Runnable runnable) {
        this.f.C(new Runnable() { // from class: ir.nasim.QV4
            @Override // java.lang.Runnable
            public final void run() {
                this.a.e0(runnable);
            }
        });
    }

    public void n0() {
        h0(this.z);
        this.z = null;
        this.y = false;
    }

    public void o0(final q qVar, final Runnable runnable) {
        if (qVar == null) {
            return;
        }
        this.f.C(new Runnable() { // from class: ir.nasim.MV4
            @Override // java.lang.Runnable
            public final void run() {
                this.a.f0(qVar, runnable);
            }
        });
    }

    public void p0(final X05 x05, final boolean z, final boolean z2, final Runnable runnable) {
        if (this.G != null) {
            return;
        }
        this.f.C(new Runnable() { // from class: ir.nasim.OV4
            @Override // java.lang.Runnable
            public final void run() {
                this.a.g0(x05, z, z2, runnable);
            }
        });
    }

    public void s0() {
        if (this.u == null) {
            return;
        }
        if (this.b != null) {
            u0(R(), this.b, (1.0f - (this.D * 0.5f)) - (this.E * 0.5f));
        } else if (this.c != null) {
            v0(V(), R(), this.c, 1.0f);
        } else {
            t0(V(), 1.0f);
        }
        int i = this.t;
        if (i == 0 || this.d == null || this.D <= 0.0f) {
            return;
        }
        v0(i, R(), this.d, (this.D * 0.5f) + (this.E * 0.5f));
    }

    public void y0(Bitmap bitmap) {
        if (this.k != null) {
            return;
        }
        this.k = new C17939no7(bitmap);
    }

    public void z0(ir.nasim.tgwidgets.editor.ui.Components.Paint.a aVar) {
        Bitmap bitmap;
        Bitmap resultBitmap;
        this.i = aVar;
        if (!(aVar instanceof a.b) || (bitmap = this.m) == null) {
            return;
        }
        int width = bitmap.getWidth();
        int height = this.m.getHeight();
        int i = this.n;
        if (i == 90 || i == 270 || i == -90) {
            height = width;
            width = height;
        }
        if (this.o == null) {
            this.o = Bitmap.createBitmap((int) (width / 8.0f), (int) (height / 8.0f), Bitmap.Config.ARGB_8888);
        }
        Canvas canvas = new Canvas(this.o);
        canvas.save();
        canvas.scale(0.125f, 0.125f);
        if (this.H != null) {
            this.H = new Paint(1);
        }
        canvas.save();
        canvas.rotate(this.n);
        int i2 = this.n;
        if (i2 == 90) {
            canvas.translate(0.0f, -width);
        } else if (i2 == 180) {
            canvas.translate(-width, -height);
        } else if (i2 == 270) {
            canvas.translate(-height, 0.0f);
        }
        canvas.drawBitmap(this.m, 0.0f, 0.0f, this.H);
        canvas.restore();
        RenderView renderView = this.f;
        if (renderView != null && (resultBitmap = renderView.getResultBitmap()) != null) {
            canvas.scale(width / resultBitmap.getWidth(), height / resultBitmap.getHeight());
            canvas.drawBitmap(resultBitmap, 0.0f, 0.0f, this.H);
            resultBitmap.recycle();
        }
        Utilities.stackBlurBitmap(this.o, (int) 8.0f);
        C17939no7 c17939no7 = this.l;
        if (c17939no7 != null) {
            c17939no7.a(false);
        }
        this.l = new C17939no7(this.o);
    }
}
