package ir.nasim;

import android.content.res.Resources;
import android.gov.nist.core.Separators;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.view.View;
import ir.nasim.AbstractC18939pW1;
import ir.nasim.AbstractC4761Gl2;
import ir.nasim.C15225jD4;

/* loaded from: classes6.dex */
public class S23 implements C15225jD4.b {
    private static Paint G0;
    private Rect A;
    private boolean A0;
    private boolean B;
    private a B0;
    private float C0;
    private BitmapShader D;
    private long D0;
    private byte E0;
    private boolean F0;
    private BitmapShader G;
    private RectF H;
    private RectF J;
    private Matrix Y;
    private float Z;
    private View a;
    private Integer b;
    private Integer c;
    private C11507d74 d;
    private b e;
    private AbstractC13360g57 f;
    private String g;
    private String h;
    private String i;
    private String j;
    private String k;
    private String l;
    private AbstractC4761Gl2 m;
    private int n;
    private boolean o;
    private Drawable p;
    private Drawable q;
    private Drawable r;
    private boolean s;
    private boolean t;
    private boolean u;
    private boolean v;
    private int w;
    private int x;
    private int y;
    private int z;
    private int z0;

    public interface a {
        void a(S23 s23, boolean z);
    }

    private class b {
        public AbstractC13360g57 a;
        public String b;
        public String c;
        public Drawable d;
        public AbstractC4761Gl2 e;
        public String f;
        public int g;
        public boolean h;
        public String i;

        private b() {
        }
    }

    public S23() {
        this(null);
    }

    private void I(String str, boolean z) {
        String str2;
        Drawable drawable;
        if (z) {
            str2 = this.h;
            drawable = this.q;
        } else {
            str2 = this.g;
            drawable = this.p;
        }
        if (str2 != null && ((str == null || !str.equals(str2)) && drawable != null)) {
            if (drawable instanceof C8610Ws) {
                ((C8610Ws) drawable).P();
            } else if (drawable instanceof BitmapDrawable) {
                Bitmap bitmap = ((BitmapDrawable) drawable).getBitmap();
                boolean zI = C17481n23.T().I(str2);
                if (!C17481n23.T().Y(str2) && zI) {
                    bitmap.recycle();
                }
            }
        }
        if (z) {
            this.q = null;
            this.h = null;
        } else {
            this.p = null;
            this.g = null;
        }
    }

    private void a(boolean z) {
        if (this.C0 != 1.0f) {
            if (!z) {
                long jCurrentTimeMillis = System.currentTimeMillis() - this.D0;
                if (jCurrentTimeMillis > 18) {
                    jCurrentTimeMillis = 18;
                }
                float f = this.C0 + (jCurrentTimeMillis / 150.0f);
                this.C0 = f;
                if (f > 1.0f) {
                    this.C0 = 1.0f;
                }
            }
            this.D0 = System.currentTimeMillis();
            View view = this.a;
            if (view != null) {
                if (this.v) {
                    view.invalidate();
                    return;
                }
                int i = this.w;
                int i2 = this.x;
                view.invalidate(i, i2, this.y + i, this.z + i2);
            }
        }
    }

    private void d(Canvas canvas, Drawable drawable, int i, BitmapShader bitmapShader, int i2) {
        int height;
        int width;
        if (!(drawable instanceof BitmapDrawable)) {
            Rect rect = this.A;
            int i3 = this.w;
            int i4 = this.x;
            rect.set(i3, i4, this.y + i3, this.z + i4);
            drawable.setBounds(this.A);
            if (this.B) {
                try {
                    drawable.setAlpha(i);
                    drawable.draw(canvas);
                    return;
                } catch (Exception e) {
                    C19406qI3.d("baleMessages", e);
                    return;
                }
            }
            return;
        }
        BitmapDrawable bitmapDrawable = (BitmapDrawable) drawable;
        Paint paint = bitmapShader != null ? G0 : bitmapDrawable.getPaint();
        if (paint != null && paint.getColorFilter() != null) {
            if (bitmapShader != null) {
                G0.setColorFilter(null);
            } else {
                bitmapDrawable.setColorFilter(null);
            }
        }
        if (bitmapDrawable instanceof C8610Ws) {
            int i5 = i2 % 360;
            if (i5 == 90 || i5 == 270) {
                height = bitmapDrawable.getIntrinsicHeight();
                width = bitmapDrawable.getIntrinsicWidth();
            } else {
                height = bitmapDrawable.getIntrinsicWidth();
                width = bitmapDrawable.getIntrinsicHeight();
            }
        } else {
            int i6 = i2 % 360;
            if (i6 == 90 || i6 == 270) {
                height = bitmapDrawable.getBitmap().getHeight();
                width = bitmapDrawable.getBitmap().getWidth();
            } else {
                height = bitmapDrawable.getBitmap().getWidth();
                width = bitmapDrawable.getBitmap().getHeight();
            }
        }
        float f = height;
        float f2 = f / this.y;
        float f3 = width;
        float f4 = f3 / this.z;
        if (bitmapShader != null) {
            G0.setShader(bitmapShader);
            float fMin = Math.min(f2, f4);
            this.H.set(this.w, this.x, r6 + this.y, r13 + this.z);
            this.Y.reset();
            float f5 = f2 - f4;
            if (Math.abs(f5) > 1.0E-5f) {
                float f6 = f / f4;
                int i7 = this.y;
                if (f6 > i7) {
                    Rect rect2 = this.A;
                    int i8 = this.w;
                    int i9 = (int) f6;
                    int i10 = this.x;
                    rect2.set(i8 - ((i9 - i7) / 2), i10, i8 + ((i9 + i7) / 2), this.z + i10);
                } else {
                    Rect rect3 = this.A;
                    int i11 = this.w;
                    int i12 = this.x;
                    int i13 = (int) (f3 / f2);
                    int i14 = this.z;
                    rect3.set(i11, i12 - ((i13 - i14) / 2), i7 + i11, i12 + ((i13 + i14) / 2));
                }
            } else {
                Rect rect4 = this.A;
                int i15 = this.w;
                int i16 = this.x;
                rect4.set(i15, i16, this.y + i15, this.z + i16);
            }
            if (this.B) {
                if (Math.abs(f5) > 1.0E-5f) {
                    int iFloor = (int) Math.floor(this.y * fMin);
                    int iFloor2 = (int) Math.floor(this.z * fMin);
                    this.J.set((height - iFloor) / 2, (width - iFloor2) / 2, (height + iFloor) / 2, (width + iFloor2) / 2);
                    this.Y.setRectToRect(this.J, this.H, Matrix.ScaleToFit.START);
                } else {
                    this.J.set(0.0f, 0.0f, f, f3);
                    this.Y.setRectToRect(this.J, this.H, Matrix.ScaleToFit.FILL);
                }
                bitmapShader.setLocalMatrix(this.Y);
                G0.setAlpha(i);
                canvas.drawRoundRect(this.H, 0.0f, 0.0f, G0);
                return;
            }
            return;
        }
        if (Math.abs(f2 - f4) <= 1.0E-5f) {
            canvas.save();
            int i17 = i2 % 360;
            if (i17 != 0) {
                if (this.A0) {
                    canvas.rotate(i2, this.y / 2, this.z / 2);
                } else {
                    canvas.rotate(i2, 0.0f, 0.0f);
                }
            }
            Rect rect5 = this.A;
            int i18 = this.w;
            int i19 = this.x;
            rect5.set(i18, i19, this.y + i18, this.z + i19);
            if (i17 == 90 || i17 == 270) {
                Rect rect6 = this.A;
                int i20 = rect6.right;
                int i21 = rect6.left;
                int i22 = (i20 - i21) / 2;
                int i23 = rect6.bottom;
                int i24 = rect6.top;
                int i25 = (i23 - i24) / 2;
                int i26 = (i20 + i21) / 2;
                int i27 = (i24 + i23) / 2;
                bitmapDrawable.setBounds(i26 - i25, i27 - i22, i26 + i25, i27 + i22);
            } else {
                bitmapDrawable.setBounds(this.A);
            }
            if (this.B) {
                try {
                    bitmapDrawable.setAlpha(i);
                    bitmapDrawable.draw(canvas);
                } catch (Exception e2) {
                    if (bitmapDrawable == this.p && this.g != null) {
                        C17481n23.T().c0(this.g);
                        this.g = null;
                    } else if (bitmapDrawable == this.q && this.h != null) {
                        C17481n23.T().c0(this.h);
                        this.h = null;
                    }
                    M(this.f, this.i, this.j, this.q, this.m, this.k, this.n, this.l, this.o);
                    C19406qI3.d("baleMessages", e2);
                }
            }
            canvas.restore();
            return;
        }
        canvas.save();
        int i28 = this.w;
        int i29 = this.x;
        canvas.clipRect(i28, i29, this.y + i28, this.z + i29);
        int i30 = i2 % 360;
        if (i30 != 0) {
            if (this.A0) {
                canvas.rotate(i2, this.y / 2, this.z / 2);
            } else {
                canvas.rotate(i2, 0.0f, 0.0f);
            }
        }
        float f7 = f / f4;
        int i31 = this.y;
        if (f7 > i31) {
            int i32 = (int) f7;
            Rect rect7 = this.A;
            int i33 = this.w;
            int i34 = this.x;
            rect7.set(i33 - ((i32 - i31) / 2), i34, i33 + ((i32 + i31) / 2), this.z + i34);
        } else {
            int i35 = (int) (f3 / f2);
            Rect rect8 = this.A;
            int i36 = this.w;
            int i37 = this.x;
            int i38 = this.z;
            rect8.set(i36, i37 - ((i35 - i38) / 2), i31 + i36, i37 + ((i35 + i38) / 2));
        }
        if (i30 == 90 || i30 == 270) {
            Rect rect9 = this.A;
            int i39 = rect9.right;
            int i40 = rect9.left;
            int i41 = (i39 - i40) / 2;
            int i42 = rect9.bottom;
            int i43 = rect9.top;
            int i44 = (i42 - i43) / 2;
            int i45 = (i39 + i40) / 2;
            int i46 = (i43 + i42) / 2;
            bitmapDrawable.setBounds(i45 - i44, i46 - i41, i45 + i44, i46 + i41);
        } else {
            bitmapDrawable.setBounds(this.A);
        }
        if (this.B) {
            try {
                bitmapDrawable.setAlpha(i);
                bitmapDrawable.draw(canvas);
            } catch (Exception e3) {
                if (bitmapDrawable == this.p && this.g != null) {
                    C17481n23.T().c0(this.g);
                    this.g = null;
                } else if (bitmapDrawable == this.q && this.h != null) {
                    C17481n23.T().c0(this.h);
                    this.h = null;
                }
                M(this.f, this.i, this.j, this.q, this.m, this.k, this.n, this.l, this.o);
                C19406qI3.d("baleMessages", e3);
            }
        }
        canvas.restore();
    }

    public AbstractC4761Gl2 A() {
        return this.m;
    }

    public boolean B() {
        return (this.p == null && this.q == null && this.r == null) ? false : true;
    }

    public boolean C() {
        return (this.p == null && this.q == null && this.g == null && this.i == null && this.r == null) ? false : true;
    }

    public boolean D() {
        return false;
    }

    public boolean E() {
        return this.t;
    }

    public boolean F() {
        return this.u;
    }

    public boolean G() {
        b bVar = this.e;
        if (bVar == null) {
            return false;
        }
        AbstractC13360g57 abstractC13360g57 = bVar.a;
        if (abstractC13360g57 == null && bVar.b == null && bVar.e == null && bVar.d == null) {
            return false;
        }
        M(abstractC13360g57, bVar.b, bVar.c, bVar.d, bVar.e, bVar.f, bVar.g, bVar.i, bVar.h);
        return true;
    }

    public void H() {
        if (this.f != null || this.i != null || this.m != null || this.r != null) {
            if (this.e == null) {
                this.e = new b();
            }
            b bVar = this.e;
            bVar.a = this.f;
            bVar.b = this.i;
            bVar.c = this.j;
            bVar.d = this.r;
            bVar.e = this.m;
            bVar.f = this.k;
            bVar.g = this.n;
            bVar.i = this.l;
            bVar.h = this.o;
        }
        b();
    }

    public void J(float f) {
        this.Z = f;
    }

    public void K(byte b2) {
        this.E0 = b2;
    }

    public void L(a aVar) {
        this.B0 = aVar;
    }

    public void M(AbstractC13360g57 abstractC13360g57, String str, String str2, Drawable drawable, AbstractC4761Gl2 abstractC4761Gl2, String str3, int i, String str4, boolean z) {
        String strA;
        boolean z2;
        String str5;
        AbstractC13360g57 abstractC13360g572 = abstractC13360g57;
        AbstractC4761Gl2 abstractC4761Gl22 = abstractC4761Gl2;
        b bVar = this.e;
        if (bVar != null) {
            bVar.a = null;
            bVar.b = null;
            bVar.e = null;
            bVar.d = null;
        }
        boolean z3 = true;
        if ((abstractC13360g572 == null && str == null && abstractC4761Gl22 == null) || (abstractC13360g572 != null && !(abstractC13360g572 instanceof AbstractC4761Gl2.a) && !(abstractC13360g572 instanceof AbstractC18939pW1.a))) {
            I(null, false);
            I(null, true);
            this.g = null;
            this.l = str4;
            this.h = null;
            this.k = null;
            this.f = null;
            this.i = null;
            this.j = null;
            this.o = false;
            this.r = drawable;
            this.C0 = 1.0f;
            this.m = null;
            this.n = 0;
            this.p = null;
            this.D = null;
            this.G = null;
            C17481n23.T().C(this, 0);
            View view = this.a;
            if (view != null) {
                if (this.v) {
                    view.invalidate();
                } else {
                    int i2 = this.w;
                    int i3 = this.x;
                    view.invalidate(i2, i3, this.y + i2, this.z + i3);
                }
            }
            a aVar = this.B0;
            if (aVar != null) {
                if (this.p == null && this.q == null && this.r == null) {
                    z3 = false;
                }
                aVar.a(this, z3);
                return;
            }
            return;
        }
        if (!(abstractC4761Gl22 instanceof AbstractC4761Gl2.a)) {
            abstractC4761Gl22 = null;
        }
        if (abstractC13360g572 == null) {
            strA = str != null ? AbstractC15318jN7.a(str) : null;
        } else if (abstractC13360g572 instanceof AbstractC4761Gl2) {
            AbstractC4761Gl2 abstractC4761Gl23 = (AbstractC4761Gl2) abstractC13360g572;
            strA = abstractC4761Gl23.b + "_" + abstractC4761Gl23.c;
        } else {
            AbstractC18939pW1 abstractC18939pW1 = (AbstractC18939pW1) abstractC13360g572;
            if (abstractC18939pW1.h == 0) {
                abstractC13360g572 = null;
            } else if (abstractC18939pW1.g == 0) {
                strA = abstractC18939pW1.h + "_" + abstractC18939pW1.a;
            } else {
                strA = abstractC18939pW1.h + "_" + abstractC18939pW1.a + "_" + abstractC18939pW1.g;
            }
        }
        if (strA != null && str2 != null) {
            strA = strA + Separators.AT + str2;
        }
        String str6 = this.g;
        if (str6 != null && strA != null && str6.equals(strA)) {
            a aVar2 = this.B0;
            if (aVar2 != null) {
                if (this.p == null && this.q == null && this.r == null) {
                    z3 = false;
                }
                aVar2.a(this, z3);
                return;
            }
            return;
        }
        if (abstractC4761Gl22 != null) {
            str5 = abstractC4761Gl22.b + "_" + abstractC4761Gl22.c;
            if (str3 != null) {
                str5 = str5 + Separators.AT + str3;
            }
            z2 = false;
        } else {
            z2 = false;
            str5 = null;
        }
        I(strA, z2);
        I(str5, true);
        this.h = str5;
        this.g = strA;
        this.l = str4;
        this.f = abstractC13360g572;
        this.i = str;
        this.j = str2;
        this.k = str3;
        this.n = i;
        this.o = z;
        this.m = abstractC4761Gl22;
        this.r = drawable;
        this.D = null;
        this.G = null;
        this.C0 = 1.0f;
        a aVar3 = this.B0;
        if (aVar3 != null) {
            aVar3.a(this, (this.p == null && this.q == null && drawable == null) ? z2 : true);
        }
        C17481n23.T().a0(this);
        View view2 = this.a;
        if (view2 != null) {
            if (this.v) {
                view2.invalidate();
                return;
            }
            int i4 = this.w;
            int i5 = this.x;
            view2.invalidate(i4, i5, this.y + i4, this.z + i5);
        }
    }

    public void N(String str, String str2, Drawable drawable, String str3, int i) {
        M(null, str, str2, drawable, null, null, i, str3, true);
    }

    public void O(Bitmap bitmap) {
        P(bitmap != null ? new BitmapDrawable((Resources) null, bitmap) : null);
    }

    public void P(Drawable drawable) {
        C17481n23.T().C(this, 0);
        I(null, false);
        I(null, true);
        this.r = drawable;
        this.m = null;
        this.g = null;
        this.l = null;
        this.h = null;
        this.p = null;
        this.k = null;
        this.f = null;
        this.i = null;
        this.j = null;
        this.n = 0;
        this.o = false;
        this.D = null;
        this.G = null;
        b bVar = this.e;
        if (bVar != null) {
            bVar.a = null;
            bVar.b = null;
            bVar.e = null;
            bVar.d = null;
        }
        this.C0 = 1.0f;
        a aVar = this.B0;
        if (aVar != null) {
            aVar.a(this, (this.q == null && drawable == null) ? false : true);
        }
        View view = this.a;
        if (view != null) {
            if (this.v) {
                view.invalidate();
                return;
            }
            int i = this.w;
            int i2 = this.x;
            view.invalidate(i, i2, this.y + i, this.z + i2);
        }
    }

    public boolean Q(BitmapDrawable bitmapDrawable, String str, boolean z, boolean z2) {
        Drawable drawable;
        View view;
        if (bitmapDrawable == null || str == null) {
            return false;
        }
        if (!z) {
            String str2 = this.g;
            if (str2 == null || !str.equals(str2)) {
                return false;
            }
            boolean z3 = bitmapDrawable instanceof C8610Ws;
            if (!z3) {
                C17481n23.T().X(this.g);
            }
            this.p = bitmapDrawable;
            this.D = null;
            if (z2) {
                this.C0 = 1.0f;
            } else if ((this.q == null && this.r == null) || this.C0 == 1.0f) {
                this.C0 = 0.0f;
                this.D0 = System.currentTimeMillis();
                this.F0 = (this.q == null && this.r == null) ? false : true;
            }
            if (z3) {
                C8610Ws c8610Ws = (C8610Ws) bitmapDrawable;
                c8610Ws.S(this.a);
                if (this.s) {
                    c8610Ws.start();
                }
            }
            View view2 = this.a;
            if (view2 != null) {
                if (this.v) {
                    view2.invalidate();
                } else {
                    int i = this.w;
                    int i2 = this.x;
                    view2.invalidate(i, i2, this.y + i, this.z + i2);
                }
            }
        } else if (this.q == null && ((drawable = this.p) == null || ((drawable instanceof C8610Ws) && !((C8610Ws) drawable).L()))) {
            String str3 = this.h;
            if (str3 == null || !str.equals(str3)) {
                return false;
            }
            C17481n23.T().X(this.h);
            this.q = bitmapDrawable;
            this.G = null;
            if (z2 || this.E0 == 2) {
                this.C0 = 1.0f;
            } else {
                this.C0 = 0.0f;
                this.D0 = System.currentTimeMillis();
                this.F0 = this.r != null && this.g == null;
            }
            if (!(this.r instanceof BitmapDrawable) && (view = this.a) != null) {
                if (this.v) {
                    view.invalidate();
                } else {
                    int i3 = this.w;
                    int i4 = this.x;
                    view.invalidate(i3, i4, this.y + i3, this.z + i4);
                }
            }
        }
        a aVar = this.B0;
        if (aVar != null) {
            aVar.a(this, (this.p == null && this.q == null && this.r == null) ? false : true);
        }
        return true;
    }

    public void R(int i, int i2, int i3, int i4) {
        this.w = i;
        this.x = i2;
        this.y = i3;
        this.z = i4;
    }

    public void S(boolean z) {
        this.v = z;
    }

    public void T(boolean z) {
        this.t = z;
        if (z) {
            C15225jD4.b().a(this, C15225jD4.s);
        } else {
            C15225jD4.b().e(this, C15225jD4.s);
        }
    }

    public void U(int i, boolean z) {
        while (i < 0) {
            i += 360;
        }
        while (i > 360) {
            i -= 360;
        }
        this.z0 = i;
        this.A0 = z;
    }

    public void V(C11507d74 c11507d74) {
        this.d = c11507d74;
    }

    public void W(View view) {
        this.a = view;
        Drawable drawable = this.p;
        if (drawable instanceof C8610Ws) {
            ((C8610Ws) drawable).S(view);
        }
    }

    public void X(boolean z) {
        this.u = z;
    }

    public void Y(Integer num, boolean z) {
        if (z) {
            this.c = num;
        } else {
            this.b = num;
        }
    }

    public void Z(boolean z, boolean z2) {
        View view;
        if (this.B == z) {
            return;
        }
        this.B = z;
        if (!z2 || (view = this.a) == null) {
            return;
        }
        if (this.v) {
            view.invalidate();
            return;
        }
        int i = this.w;
        int i2 = this.x;
        view.invalidate(i, i2, this.y + i, this.z + i2);
    }

    public void b() {
        I(null, false);
        I(null, true);
        if (this.t) {
            C15225jD4.b().e(this, C15225jD4.s);
            C17481n23.T().C(this, 0);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x0032 A[Catch: Exception -> 0x0012, TryCatch #0 {Exception -> 0x0012, blocks: (B:3:0x0001, B:5:0x0008, B:11:0x0016, B:24:0x0032, B:26:0x0038, B:29:0x003e, B:33:0x004b, B:71:0x00bc, B:75:0x00c3, B:32:0x0048, B:35:0x0055, B:38:0x005f, B:51:0x0076, B:41:0x0065, B:44:0x006a, B:46:0x006e, B:52:0x0082, B:54:0x008b, B:60:0x0099, B:59:0x0096, B:56:0x008f, B:61:0x00a0, B:63:0x00a6, B:69:0x00b4, B:68:0x00b1, B:65:0x00aa, B:77:0x00c7, B:79:0x00cb, B:81:0x00d8, B:16:0x0020, B:19:0x0029), top: B:85:0x0001 }] */
    /* JADX WARN: Removed duplicated region for block: B:77:0x00c7 A[Catch: Exception -> 0x0012, TryCatch #0 {Exception -> 0x0012, blocks: (B:3:0x0001, B:5:0x0008, B:11:0x0016, B:24:0x0032, B:26:0x0038, B:29:0x003e, B:33:0x004b, B:71:0x00bc, B:75:0x00c3, B:32:0x0048, B:35:0x0055, B:38:0x005f, B:51:0x0076, B:41:0x0065, B:44:0x006a, B:46:0x006e, B:52:0x0082, B:54:0x008b, B:60:0x0099, B:59:0x0096, B:56:0x008f, B:61:0x00a0, B:63:0x00a6, B:69:0x00b4, B:68:0x00b1, B:65:0x00aa, B:77:0x00c7, B:79:0x00cb, B:81:0x00d8, B:16:0x0020, B:19:0x0029), top: B:85:0x0001 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean c(android.graphics.Canvas r13) {
        /*
            Method dump skipped, instructions count: 226
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.S23.c(android.graphics.Canvas):boolean");
    }

    @Override // ir.nasim.C15225jD4.b
    public void didReceivedNotification(int i, Object... objArr) {
        if (i == C15225jD4.s) {
            String str = (String) objArr[1];
            String str2 = this.h;
            if (str2 == null || !str2.equals(str)) {
                return;
            }
            if (this.q == null) {
                C17481n23.T().X(this.h);
            }
            this.q = (BitmapDrawable) objArr[0];
            this.G = null;
            if (this.r instanceof BitmapDrawable) {
                this.r = null;
            }
            View view = this.a;
            if (view != null) {
                if (this.v) {
                    view.invalidate();
                    return;
                }
                int i2 = this.w;
                int i3 = this.x;
                view.invalidate(i2, i3, this.y + i2, this.z + i3);
            }
        }
    }

    public int e() {
        Drawable drawable = this.p;
        if (drawable instanceof C8610Ws) {
            return ((C8610Ws) drawable).J();
        }
        Drawable drawable2 = this.r;
        if (drawable2 instanceof C8610Ws) {
            return ((C8610Ws) drawable2).J();
        }
        return 0;
    }

    public C8610Ws f() {
        Drawable drawable = this.p;
        if (drawable instanceof C8610Ws) {
            return (C8610Ws) drawable;
        }
        return null;
    }

    public Bitmap g() {
        Drawable drawable = this.p;
        if (drawable instanceof C8610Ws) {
            return ((C8610Ws) drawable).I();
        }
        Drawable drawable2 = this.r;
        if (drawable2 instanceof C8610Ws) {
            return ((C8610Ws) drawable2).I();
        }
        if (drawable instanceof BitmapDrawable) {
            return ((BitmapDrawable) drawable).getBitmap();
        }
        Drawable drawable3 = this.q;
        if (drawable3 instanceof BitmapDrawable) {
            return ((BitmapDrawable) drawable3).getBitmap();
        }
        if (drawable2 instanceof BitmapDrawable) {
            return ((BitmapDrawable) drawable2).getBitmap();
        }
        return null;
    }

    public int h() {
        Drawable drawable = this.p;
        if (drawable instanceof C8610Ws) {
            int i = this.z0;
            return (i % 360 == 0 || i % 360 == 180) ? drawable.getIntrinsicHeight() : drawable.getIntrinsicWidth();
        }
        Drawable drawable2 = this.r;
        if (drawable2 instanceof C8610Ws) {
            int i2 = this.z0;
            return (i2 % 360 == 0 || i2 % 360 == 180) ? drawable2.getIntrinsicHeight() : drawable2.getIntrinsicWidth();
        }
        Bitmap bitmapG = g();
        int i3 = this.z0;
        return (i3 % 360 == 0 || i3 % 360 == 180) ? bitmapG.getHeight() : bitmapG.getWidth();
    }

    public int i() {
        Drawable drawable = this.p;
        if (drawable instanceof C8610Ws) {
            int i = this.z0;
            return (i % 360 == 0 || i % 360 == 180) ? drawable.getIntrinsicWidth() : drawable.getIntrinsicHeight();
        }
        Drawable drawable2 = this.r;
        if (drawable2 instanceof C8610Ws) {
            int i2 = this.z0;
            return (i2 % 360 == 0 || i2 % 360 == 180) ? drawable2.getIntrinsicWidth() : drawable2.getIntrinsicHeight();
        }
        Bitmap bitmapG = g();
        int i3 = this.z0;
        return (i3 % 360 == 0 || i3 % 360 == 180) ? bitmapG.getWidth() : bitmapG.getHeight();
    }

    public boolean j() {
        return this.o;
    }

    public Rect k() {
        return this.A;
    }

    public String l() {
        return this.l;
    }

    public String m() {
        return this.j;
    }

    public String n() {
        return this.i;
    }

    public int o() {
        return this.z;
    }

    public AbstractC13360g57 p() {
        return this.f;
    }

    public int q() {
        return this.y;
    }

    public int r() {
        return this.w;
    }

    public int s() {
        return this.x;
    }

    public String t() {
        return this.g;
    }

    public int u() {
        return this.z0;
    }

    public C11507d74 v() {
        return this.d;
    }

    public int w() {
        return this.n;
    }

    public Integer x(boolean z) {
        return z ? this.c : this.b;
    }

    public String y() {
        return this.k;
    }

    public String z() {
        return this.h;
    }

    public S23(View view) {
        this.s = true;
        this.A = new Rect();
        this.B = true;
        this.H = new RectF();
        this.J = new RectF();
        this.Y = new Matrix();
        this.Z = 1.0f;
        this.E0 = (byte) 1;
        this.a = view;
        if (G0 == null) {
            G0 = new Paint(1);
        }
    }
}
