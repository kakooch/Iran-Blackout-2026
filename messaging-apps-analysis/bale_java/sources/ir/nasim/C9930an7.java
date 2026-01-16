package ir.nasim;

import android.gov.nist.core.Separators;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.RectF;
import android.graphics.Typeface;
import ir.nasim.AW1;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* renamed from: ir.nasim.an7, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public class C9930an7 extends AbstractC3236Aa0 {
    private final StringBuilder E;
    private final RectF F;
    private final Matrix G;
    private final Paint H;
    private final Paint I;
    private final Map J;
    private final C21892uJ3 K;
    private final List L;
    private final C8830Xm7 M;
    private final com.airbnb.lottie.q N;
    private final C23677xK3 O;
    private EnumC5720Kn7 P;
    private AbstractC24408ya0 Q;
    private AbstractC24408ya0 R;
    private AbstractC24408ya0 S;
    private AbstractC24408ya0 T;
    private AbstractC24408ya0 U;
    private AbstractC24408ya0 V;
    private AbstractC24408ya0 W;
    private AbstractC24408ya0 X;
    private AbstractC24408ya0 Y;
    private AbstractC24408ya0 Z;
    private AbstractC24408ya0 a0;
    private AbstractC24408ya0 b0;
    private AbstractC24408ya0 c0;
    private AbstractC24408ya0 d0;

    /* renamed from: ir.nasim.an7$a */
    class a extends Paint {
        a(int i) {
            super(i);
            setStyle(Paint.Style.FILL);
        }
    }

    /* renamed from: ir.nasim.an7$b */
    class b extends Paint {
        b(int i) {
            super(i);
            setStyle(Paint.Style.STROKE);
        }
    }

    /* renamed from: ir.nasim.an7$c */
    static /* synthetic */ class c {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[AW1.a.values().length];
            a = iArr;
            try {
                iArr[AW1.a.LEFT_ALIGN.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[AW1.a.RIGHT_ALIGN.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[AW1.a.CENTER.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    C9930an7(com.airbnb.lottie.q qVar, C6970Pt3 c6970Pt3) {
        C25181zs c25181zs;
        C25181zs c25181zs2;
        C18562os c18562os;
        C25181zs c25181zs3;
        C18562os c18562os2;
        C25181zs c25181zs4;
        C18562os c18562os3;
        C3397As c3397As;
        C18562os c18562os4;
        C3397As c3397As2;
        C17380ms c17380ms;
        C3397As c3397As3;
        C17380ms c17380ms2;
        C3397As c3397As4;
        C16789ls c16789ls;
        C3397As c3397As5;
        C16789ls c16789ls2;
        super(qVar, c6970Pt3);
        this.E = new StringBuilder(2);
        this.F = new RectF();
        this.G = new Matrix();
        this.H = new a(1);
        this.I = new b(1);
        this.J = new HashMap();
        this.K = new C21892uJ3();
        this.L = new ArrayList();
        this.P = EnumC5720Kn7.INDEX;
        this.N = qVar;
        this.O = c6970Pt3.c();
        C8830Xm7 c8830Xm7J = c6970Pt3.t().j();
        this.M = c8830Xm7J;
        c8830Xm7J.a(this);
        j(c8830Xm7J);
        C23997xs c23997xsU = c6970Pt3.u();
        if (c23997xsU != null && (c3397As5 = c23997xsU.a) != null && (c16789ls2 = c3397As5.a) != null) {
            AbstractC24408ya0 abstractC24408ya0J = c16789ls2.j();
            this.Q = abstractC24408ya0J;
            abstractC24408ya0J.a(this);
            j(this.Q);
        }
        if (c23997xsU != null && (c3397As4 = c23997xsU.a) != null && (c16789ls = c3397As4.b) != null) {
            AbstractC24408ya0 abstractC24408ya0J2 = c16789ls.j();
            this.S = abstractC24408ya0J2;
            abstractC24408ya0J2.a(this);
            j(this.S);
        }
        if (c23997xsU != null && (c3397As3 = c23997xsU.a) != null && (c17380ms2 = c3397As3.c) != null) {
            C11959dq2 c11959dq2J = c17380ms2.j();
            this.U = c11959dq2J;
            c11959dq2J.a(this);
            j(this.U);
        }
        if (c23997xsU != null && (c3397As2 = c23997xsU.a) != null && (c17380ms = c3397As2.d) != null) {
            C11959dq2 c11959dq2J2 = c17380ms.j();
            this.W = c11959dq2J2;
            c11959dq2J2.a(this);
            j(this.W);
        }
        if (c23997xsU != null && (c3397As = c23997xsU.a) != null && (c18562os4 = c3397As.e) != null) {
            AbstractC24408ya0 abstractC24408ya0J3 = c18562os4.j();
            this.Y = abstractC24408ya0J3;
            abstractC24408ya0J3.a(this);
            j(this.Y);
        }
        if (c23997xsU != null && (c25181zs4 = c23997xsU.b) != null && (c18562os3 = c25181zs4.a) != null) {
            AbstractC24408ya0 abstractC24408ya0J4 = c18562os3.j();
            this.b0 = abstractC24408ya0J4;
            abstractC24408ya0J4.a(this);
            j(this.b0);
        }
        if (c23997xsU != null && (c25181zs3 = c23997xsU.b) != null && (c18562os2 = c25181zs3.b) != null) {
            AbstractC24408ya0 abstractC24408ya0J5 = c18562os2.j();
            this.c0 = abstractC24408ya0J5;
            abstractC24408ya0J5.a(this);
            j(this.c0);
        }
        if (c23997xsU != null && (c25181zs2 = c23997xsU.b) != null && (c18562os = c25181zs2.c) != null) {
            AbstractC24408ya0 abstractC24408ya0J6 = c18562os.j();
            this.d0 = abstractC24408ya0J6;
            abstractC24408ya0J6.a(this);
            j(this.d0);
        }
        if (c23997xsU == null || (c25181zs = c23997xsU.b) == null) {
            return;
        }
        this.P = c25181zs.d;
    }

    private String R(String str, int i) {
        int iCodePointAt = str.codePointAt(i);
        int iCharCount = Character.charCount(iCodePointAt) + i;
        while (iCharCount < str.length()) {
            int iCodePointAt2 = str.codePointAt(iCharCount);
            if (!g0(iCodePointAt2)) {
                break;
            }
            iCharCount += Character.charCount(iCodePointAt2);
            iCodePointAt = (iCodePointAt * 31) + iCodePointAt2;
        }
        long j = iCodePointAt;
        if (this.K.e(j)) {
            return (String) this.K.f(j);
        }
        this.E.setLength(0);
        while (i < iCharCount) {
            int iCodePointAt3 = str.codePointAt(i);
            this.E.appendCodePoint(iCodePointAt3);
            i += Character.charCount(iCodePointAt3);
        }
        String string = this.E.toString();
        this.K.l(j, string);
        return string;
    }

    private void S(AW1 aw1, int i, int i2) {
        AbstractC24408ya0 abstractC24408ya0 = this.R;
        if (abstractC24408ya0 != null) {
            this.H.setColor(((Integer) abstractC24408ya0.h()).intValue());
        } else if (this.Q == null || !f0(i2)) {
            this.H.setColor(aw1.h);
        } else {
            this.H.setColor(((Integer) this.Q.h()).intValue());
        }
        AbstractC24408ya0 abstractC24408ya02 = this.T;
        if (abstractC24408ya02 != null) {
            this.I.setColor(((Integer) abstractC24408ya02.h()).intValue());
        } else if (this.S == null || !f0(i2)) {
            this.I.setColor(aw1.i);
        } else {
            this.I.setColor(((Integer) this.S.h()).intValue());
        }
        int iIntValue = 100;
        int iIntValue2 = this.x.h() == null ? 100 : ((Integer) this.x.h().h()).intValue();
        if (this.Y != null && f0(i2)) {
            iIntValue = ((Integer) this.Y.h()).intValue();
        }
        int iRound = Math.round(((((iIntValue2 * 255.0f) / 100.0f) * (iIntValue / 100.0f)) * i) / 255.0f);
        this.H.setAlpha(iRound);
        this.I.setAlpha(iRound);
        AbstractC24408ya0 abstractC24408ya03 = this.V;
        if (abstractC24408ya03 != null) {
            this.I.setStrokeWidth(((Float) abstractC24408ya03.h()).floatValue());
        } else if (this.U == null || !f0(i2)) {
            this.I.setStrokeWidth(aw1.j * AbstractC16500lN7.e());
        } else {
            this.I.setStrokeWidth(((Float) this.U.h()).floatValue());
        }
    }

    private void T(String str, Paint paint, Canvas canvas) {
        if (paint.getColor() == 0) {
            return;
        }
        if (paint.getStyle() == Paint.Style.STROKE && paint.getStrokeWidth() == 0.0f) {
            return;
        }
        canvas.drawText(str, 0, str.length(), 0.0f, 0.0f, paint);
    }

    private void U(C9163Yt2 c9163Yt2, float f, AW1 aw1, Canvas canvas, int i, int i2) {
        S(aw1, i2, i);
        List listC0 = c0(c9163Yt2);
        for (int i3 = 0; i3 < listC0.size(); i3++) {
            Path pathA = ((C4502Fk1) listC0.get(i3)).A();
            pathA.computeBounds(this.F, false);
            this.G.reset();
            this.G.preTranslate(0.0f, (-aw1.g) * AbstractC16500lN7.e());
            this.G.preScale(f, f);
            pathA.transform(this.G);
            if (aw1.k) {
                X(pathA, this.H, canvas);
                X(pathA, this.I, canvas);
            } else {
                X(pathA, this.I, canvas);
                X(pathA, this.H, canvas);
            }
        }
    }

    private void V(String str, AW1 aw1, Canvas canvas, int i, int i2) {
        S(aw1, i2, i);
        if (aw1.k) {
            T(str, this.H, canvas);
            T(str, this.I, canvas);
        } else {
            T(str, this.I, canvas);
            T(str, this.H, canvas);
        }
    }

    private void W(String str, AW1 aw1, Canvas canvas, float f, int i, int i2) {
        int length = 0;
        while (length < str.length()) {
            String strR = R(str, length);
            V(strR, aw1, canvas, i + length, i2);
            canvas.translate(this.H.measureText(strR) + f, 0.0f);
            length += strR.length();
        }
    }

    private void X(Path path, Paint paint, Canvas canvas) {
        if (paint.getColor() == 0) {
            return;
        }
        if (paint.getStyle() == Paint.Style.STROKE && paint.getStrokeWidth() == 0.0f) {
            return;
        }
        canvas.drawPath(path, paint);
    }

    private void Y(String str, AW1 aw1, C8388Vt2 c8388Vt2, Canvas canvas, float f, float f2, float f3, int i) {
        for (int i2 = 0; i2 < str.length(); i2++) {
            C9163Yt2 c9163Yt2 = (C9163Yt2) this.O.c().f(C9163Yt2.c(str.charAt(i2), c8388Vt2.a(), c8388Vt2.c()));
            if (c9163Yt2 != null) {
                U(c9163Yt2, f2, aw1, canvas, i2, i);
                canvas.translate((((float) c9163Yt2.b()) * f2 * AbstractC16500lN7.e()) + f3, 0.0f);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0089  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void Z(ir.nasim.AW1 r21, ir.nasim.C8388Vt2 r22, android.graphics.Canvas r23, int r24) {
        /*
            Method dump skipped, instructions count: 271
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C9930an7.Z(ir.nasim.AW1, ir.nasim.Vt2, android.graphics.Canvas, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0055  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void a0(ir.nasim.AW1 r22, android.graphics.Matrix r23, ir.nasim.C8388Vt2 r24, android.graphics.Canvas r25, int r26) {
        /*
            r21 = this;
            r9 = r21
            r10 = r22
            ir.nasim.ya0 r0 = r9.Z
            if (r0 == 0) goto L13
            java.lang.Object r0 = r0.h()
            java.lang.Float r0 = (java.lang.Float) r0
            float r0 = r0.floatValue()
            goto L15
        L13:
            float r0 = r10.c
        L15:
            r1 = 1120403456(0x42c80000, float:100.0)
            float r11 = r0 / r1
            float r12 = ir.nasim.AbstractC16500lN7.g(r23)
            java.lang.String r0 = r10.a
            java.util.List r13 = r9.d0(r0)
            int r14 = r13.size()
            int r0 = r10.e
            float r0 = (float) r0
            r1 = 1092616192(0x41200000, float:10.0)
            float r0 = r0 / r1
            ir.nasim.ya0 r1 = r9.X
            if (r1 == 0) goto L3e
            java.lang.Object r1 = r1.h()
            java.lang.Float r1 = (java.lang.Float) r1
            float r1 = r1.floatValue()
        L3b:
            float r0 = r0 + r1
        L3c:
            r15 = r0
            goto L4d
        L3e:
            ir.nasim.ya0 r1 = r9.W
            if (r1 == 0) goto L3c
            java.lang.Object r1 = r1.h()
            java.lang.Float r1 = (java.lang.Float) r1
            float r1 = r1.floatValue()
            goto L3b
        L4d:
            r16 = 0
            r0 = -1
            r7 = r0
            r8 = r16
        L53:
            if (r8 >= r14) goto Lc6
            java.lang.Object r0 = r13.get(r8)
            r1 = r0
            java.lang.String r1 = (java.lang.String) r1
            android.graphics.PointF r0 = r10.m
            if (r0 != 0) goto L63
            r0 = 0
        L61:
            r2 = r0
            goto L66
        L63:
            float r0 = r0.x
            goto L61
        L66:
            r6 = 1
            r0 = r21
            r3 = r24
            r4 = r11
            r5 = r15
            java.util.List r6 = r0.i0(r1, r2, r3, r4, r5, r6)
            r5 = r16
        L73:
            int r0 = r6.size()
            if (r5 >= r0) goto Lc1
            java.lang.Object r0 = r6.get(r5)
            ir.nasim.an7$d r0 = (ir.nasim.C9930an7.d) r0
            int r7 = r7 + 1
            r25.save()
            float r1 = ir.nasim.C9930an7.d.a(r0)
            r4 = r25
            boolean r1 = r9.h0(r4, r10, r7, r1)
            if (r1 == 0) goto Lad
            java.lang.String r1 = ir.nasim.C9930an7.d.b(r0)
            r0 = r21
            r2 = r22
            r3 = r24
            r4 = r25
            r17 = r5
            r5 = r12
            r18 = r6
            r6 = r11
            r19 = r7
            r7 = r15
            r20 = r8
            r8 = r26
            r0.Y(r1, r2, r3, r4, r5, r6, r7, r8)
            goto Lb5
        Lad:
            r17 = r5
            r18 = r6
            r19 = r7
            r20 = r8
        Lb5:
            r25.restore()
            int r5 = r17 + 1
            r6 = r18
            r7 = r19
            r8 = r20
            goto L73
        Lc1:
            r20 = r8
            int r8 = r20 + 1
            goto L53
        Lc6:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C9930an7.a0(ir.nasim.AW1, android.graphics.Matrix, ir.nasim.Vt2, android.graphics.Canvas, int):void");
    }

    private d b0(int i) {
        for (int size = this.L.size(); size < i; size++) {
            this.L.add(new d(null));
        }
        return (d) this.L.get(i - 1);
    }

    private List c0(C9163Yt2 c9163Yt2) {
        if (this.J.containsKey(c9163Yt2)) {
            return (List) this.J.get(c9163Yt2);
        }
        List listA = c9163Yt2.a();
        int size = listA.size();
        ArrayList arrayList = new ArrayList(size);
        for (int i = 0; i < size; i++) {
            arrayList.add(new C4502Fk1(this.N, this, (C20409rx6) listA.get(i), this.O));
        }
        this.J.put(c9163Yt2, arrayList);
        return arrayList;
    }

    private List d0(String str) {
        return Arrays.asList(str.replaceAll(Separators.NEWLINE, "\r").replaceAll("\u0003", "\r").replaceAll(Separators.RETURN, "\r").split("\r"));
    }

    private Typeface e0(C8388Vt2 c8388Vt2) {
        Typeface typeface;
        AbstractC24408ya0 abstractC24408ya0 = this.a0;
        if (abstractC24408ya0 != null && (typeface = (Typeface) abstractC24408ya0.h()) != null) {
            return typeface;
        }
        Typeface typefaceF0 = this.N.f0(c8388Vt2);
        return typefaceF0 != null ? typefaceF0 : c8388Vt2.d();
    }

    private boolean f0(int i) {
        int length = ((AW1) this.M.h()).a.length();
        AbstractC24408ya0 abstractC24408ya0 = this.b0;
        if (abstractC24408ya0 == null || this.c0 == null) {
            return true;
        }
        int iMin = Math.min(((Integer) abstractC24408ya0.h()).intValue(), ((Integer) this.c0.h()).intValue());
        int iMax = Math.max(((Integer) this.b0.h()).intValue(), ((Integer) this.c0.h()).intValue());
        AbstractC24408ya0 abstractC24408ya02 = this.d0;
        if (abstractC24408ya02 != null) {
            int iIntValue = ((Integer) abstractC24408ya02.h()).intValue();
            iMin += iIntValue;
            iMax += iIntValue;
        }
        if (this.P == EnumC5720Kn7.INDEX) {
            return i >= iMin && i < iMax;
        }
        float f = (i / length) * 100.0f;
        return f >= ((float) iMin) && f < ((float) iMax);
    }

    private boolean g0(int i) {
        return Character.getType(i) == 16 || Character.getType(i) == 27 || Character.getType(i) == 6 || Character.getType(i) == 28 || Character.getType(i) == 8 || Character.getType(i) == 19;
    }

    private boolean h0(Canvas canvas, AW1 aw1, int i, float f) {
        PointF pointF = aw1.l;
        PointF pointF2 = aw1.m;
        float fE = AbstractC16500lN7.e();
        float f2 = (i * aw1.f * fE) + (pointF == null ? 0.0f : (aw1.f * fE) + pointF.y);
        if (this.N.L() && pointF2 != null && pointF != null && f2 >= pointF.y + pointF2.y + aw1.c) {
            return false;
        }
        float f3 = pointF == null ? 0.0f : pointF.x;
        float f4 = pointF2 != null ? pointF2.x : 0.0f;
        int i2 = c.a[aw1.d.ordinal()];
        if (i2 == 1) {
            canvas.translate(f3, f2);
        } else if (i2 == 2) {
            canvas.translate((f3 + f4) - f, f2);
        } else if (i2 == 3) {
            canvas.translate((f3 + (f4 / 2.0f)) - (f / 2.0f), f2);
        }
        return true;
    }

    private List i0(String str, float f, C8388Vt2 c8388Vt2, float f2, float f3, boolean z) {
        float fMeasureText;
        int i = 0;
        int i2 = 0;
        boolean z2 = false;
        int i3 = 0;
        float f4 = 0.0f;
        float f5 = 0.0f;
        float f6 = 0.0f;
        for (int i4 = 0; i4 < str.length(); i4++) {
            char cCharAt = str.charAt(i4);
            if (z) {
                C9163Yt2 c9163Yt2 = (C9163Yt2) this.O.c().f(C9163Yt2.c(cCharAt, c8388Vt2.a(), c8388Vt2.c()));
                if (c9163Yt2 != null) {
                    fMeasureText = ((float) c9163Yt2.b()) * f2 * AbstractC16500lN7.e();
                }
            } else {
                fMeasureText = this.H.measureText(str.substring(i4, i4 + 1));
            }
            float f7 = fMeasureText + f3;
            if (cCharAt == ' ') {
                z2 = true;
                f6 = f7;
            } else if (z2) {
                z2 = false;
                i3 = i4;
                f5 = f7;
            } else {
                f5 += f7;
            }
            f4 += f7;
            if (f > 0.0f && f4 >= f && cCharAt != ' ') {
                i++;
                d dVarB0 = b0(i);
                if (i3 == i2) {
                    dVarB0.c(str.substring(i2, i4).trim(), (f4 - f7) - ((r9.length() - r7.length()) * f6));
                    i2 = i4;
                    i3 = i2;
                    f4 = f7;
                    f5 = f4;
                } else {
                    dVarB0.c(str.substring(i2, i3 - 1).trim(), ((f4 - f5) - ((r7.length() - r13.length()) * f6)) - f6);
                    f4 = f5;
                    i2 = i3;
                }
            }
        }
        if (f4 > 0.0f) {
            i++;
            b0(i).c(str.substring(i2), f4);
        }
        return this.L.subList(0, i);
    }

    @Override // ir.nasim.AbstractC3236Aa0, ir.nasim.InterfaceC5257Io3
    public void c(Object obj, C13505gL3 c13505gL3) {
        super.c(obj, c13505gL3);
        if (obj == InterfaceC9661aL3.a) {
            AbstractC24408ya0 abstractC24408ya0 = this.R;
            if (abstractC24408ya0 != null) {
                J(abstractC24408ya0);
            }
            if (c13505gL3 == null) {
                this.R = null;
                return;
            }
            C14145hQ7 c14145hQ7 = new C14145hQ7(c13505gL3);
            this.R = c14145hQ7;
            c14145hQ7.a(this);
            j(this.R);
            return;
        }
        if (obj == InterfaceC9661aL3.b) {
            AbstractC24408ya0 abstractC24408ya02 = this.T;
            if (abstractC24408ya02 != null) {
                J(abstractC24408ya02);
            }
            if (c13505gL3 == null) {
                this.T = null;
                return;
            }
            C14145hQ7 c14145hQ72 = new C14145hQ7(c13505gL3);
            this.T = c14145hQ72;
            c14145hQ72.a(this);
            j(this.T);
            return;
        }
        if (obj == InterfaceC9661aL3.s) {
            AbstractC24408ya0 abstractC24408ya03 = this.V;
            if (abstractC24408ya03 != null) {
                J(abstractC24408ya03);
            }
            if (c13505gL3 == null) {
                this.V = null;
                return;
            }
            C14145hQ7 c14145hQ73 = new C14145hQ7(c13505gL3);
            this.V = c14145hQ73;
            c14145hQ73.a(this);
            j(this.V);
            return;
        }
        if (obj == InterfaceC9661aL3.t) {
            AbstractC24408ya0 abstractC24408ya04 = this.X;
            if (abstractC24408ya04 != null) {
                J(abstractC24408ya04);
            }
            if (c13505gL3 == null) {
                this.X = null;
                return;
            }
            C14145hQ7 c14145hQ74 = new C14145hQ7(c13505gL3);
            this.X = c14145hQ74;
            c14145hQ74.a(this);
            j(this.X);
            return;
        }
        if (obj == InterfaceC9661aL3.F) {
            AbstractC24408ya0 abstractC24408ya05 = this.Z;
            if (abstractC24408ya05 != null) {
                J(abstractC24408ya05);
            }
            if (c13505gL3 == null) {
                this.Z = null;
                return;
            }
            C14145hQ7 c14145hQ75 = new C14145hQ7(c13505gL3);
            this.Z = c14145hQ75;
            c14145hQ75.a(this);
            j(this.Z);
            return;
        }
        if (obj != InterfaceC9661aL3.M) {
            if (obj == InterfaceC9661aL3.O) {
                this.M.s(c13505gL3);
                return;
            }
            return;
        }
        AbstractC24408ya0 abstractC24408ya06 = this.a0;
        if (abstractC24408ya06 != null) {
            J(abstractC24408ya06);
        }
        if (c13505gL3 == null) {
            this.a0 = null;
            return;
        }
        C14145hQ7 c14145hQ76 = new C14145hQ7(c13505gL3);
        this.a0 = c14145hQ76;
        c14145hQ76.a(this);
        j(this.a0);
    }

    @Override // ir.nasim.AbstractC3236Aa0, ir.nasim.V02
    public void g(RectF rectF, Matrix matrix, boolean z) {
        super.g(rectF, matrix, z);
        rectF.set(0.0f, 0.0f, this.O.b().width(), this.O.b().height());
    }

    @Override // ir.nasim.AbstractC3236Aa0
    void u(Canvas canvas, Matrix matrix, int i, C17470n12 c17470n12) {
        AW1 aw1 = (AW1) this.M.h();
        C8388Vt2 c8388Vt2 = (C8388Vt2) this.O.g().get(aw1.b);
        if (c8388Vt2 == null) {
            return;
        }
        canvas.save();
        canvas.concat(matrix);
        S(aw1, i, 0);
        if (this.N.t1()) {
            a0(aw1, matrix, c8388Vt2, canvas, i);
        } else {
            Z(aw1, c8388Vt2, canvas, i);
        }
        canvas.restore();
    }

    /* renamed from: ir.nasim.an7$d */
    private static class d {
        private String a;
        private float b;

        private d() {
            this.a = "";
            this.b = 0.0f;
        }

        void c(String str, float f) {
            this.a = str;
            this.b = f;
        }

        /* synthetic */ d(a aVar) {
            this();
        }
    }
}
