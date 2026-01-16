package ir.nasim;

import android.graphics.BlurMaskFilter;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.os.Build;
import ir.nasim.AbstractC24408ya0;
import ir.nasim.C6970Pt3;
import ir.nasim.EU3;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* renamed from: ir.nasim.Aa0, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public abstract class AbstractC3236Aa0 implements V02, AbstractC24408ya0.b, InterfaceC5257Io3 {
    private Paint A;
    float B;
    BlurMaskFilter C;
    C7430Rr3 D;
    private final Path a = new Path();
    private final Matrix b = new Matrix();
    private final Matrix c = new Matrix();
    private final Paint d = new C7430Rr3(1);
    private final Paint e;
    private final Paint f;
    private final Paint g;
    private final Paint h;
    private final RectF i;
    private final RectF j;
    private final RectF k;
    private final RectF l;
    private final RectF m;
    private final String n;
    protected final Matrix o;
    final com.airbnb.lottie.q p;
    final C6970Pt3 q;
    private FU3 r;
    private C11959dq2 s;
    private AbstractC3236Aa0 t;
    private AbstractC3236Aa0 u;
    private List v;
    private final List w;
    public final C13263fv7 x;
    private boolean y;
    private boolean z;

    /* renamed from: ir.nasim.Aa0$a */
    static /* synthetic */ class a {
        static final /* synthetic */ int[] a;
        static final /* synthetic */ int[] b;

        static {
            int[] iArr = new int[EU3.a.values().length];
            b = iArr;
            try {
                iArr[EU3.a.MASK_MODE_NONE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                b[EU3.a.MASK_MODE_SUBTRACT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                b[EU3.a.MASK_MODE_INTERSECT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                b[EU3.a.MASK_MODE_ADD.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            int[] iArr2 = new int[C6970Pt3.a.values().length];
            a = iArr2;
            try {
                iArr2[C6970Pt3.a.SHAPE.ordinal()] = 1;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                a[C6970Pt3.a.PRE_COMP.ordinal()] = 2;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                a[C6970Pt3.a.SOLID.ordinal()] = 3;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                a[C6970Pt3.a.IMAGE.ordinal()] = 4;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                a[C6970Pt3.a.NULL.ordinal()] = 5;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                a[C6970Pt3.a.TEXT.ordinal()] = 6;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                a[C6970Pt3.a.UNKNOWN.ordinal()] = 7;
            } catch (NoSuchFieldError unused11) {
            }
        }
    }

    AbstractC3236Aa0(com.airbnb.lottie.q qVar, C6970Pt3 c6970Pt3) {
        PorterDuff.Mode mode = PorterDuff.Mode.DST_IN;
        this.e = new C7430Rr3(1, mode);
        PorterDuff.Mode mode2 = PorterDuff.Mode.DST_OUT;
        this.f = new C7430Rr3(1, mode2);
        C7430Rr3 c7430Rr3 = new C7430Rr3(1);
        this.g = c7430Rr3;
        this.h = new C7430Rr3(PorterDuff.Mode.CLEAR);
        this.i = new RectF();
        this.j = new RectF();
        this.k = new RectF();
        this.l = new RectF();
        this.m = new RectF();
        this.o = new Matrix();
        this.w = new ArrayList();
        this.y = true;
        this.B = 0.0f;
        this.p = qVar;
        this.q = c6970Pt3;
        this.n = c6970Pt3.j() + "#draw";
        if (c6970Pt3.i() == C6970Pt3.b.INVERT) {
            c7430Rr3.setXfermode(new PorterDuffXfermode(mode2));
        } else {
            c7430Rr3.setXfermode(new PorterDuffXfermode(mode));
        }
        C13263fv7 c13263fv7B = c6970Pt3.x().b();
        this.x = c13263fv7B;
        c13263fv7B.b(this);
        if (c6970Pt3.h() != null && !c6970Pt3.h().isEmpty()) {
            FU3 fu3 = new FU3(c6970Pt3.h());
            this.r = fu3;
            Iterator it = fu3.a().iterator();
            while (it.hasNext()) {
                ((AbstractC24408ya0) it.next()).a(this);
            }
            for (AbstractC24408ya0 abstractC24408ya0 : this.r.c()) {
                j(abstractC24408ya0);
                abstractC24408ya0.a(this);
            }
        }
        Q();
    }

    private void E(RectF rectF, Matrix matrix) {
        this.k.set(0.0f, 0.0f, 0.0f, 0.0f);
        if (C()) {
            int size = this.r.b().size();
            for (int i = 0; i < size; i++) {
                EU3 eu3 = (EU3) this.r.b().get(i);
                Path path = (Path) ((AbstractC24408ya0) this.r.a().get(i)).h();
                if (path != null) {
                    this.a.set(path);
                    this.a.transform(matrix);
                    int i2 = a.b[eu3.a().ordinal()];
                    if (i2 == 1 || i2 == 2) {
                        return;
                    }
                    if ((i2 == 3 || i2 == 4) && eu3.d()) {
                        return;
                    }
                    this.a.computeBounds(this.m, false);
                    if (i == 0) {
                        this.k.set(this.m);
                    } else {
                        RectF rectF2 = this.k;
                        rectF2.set(Math.min(rectF2.left, this.m.left), Math.min(this.k.top, this.m.top), Math.max(this.k.right, this.m.right), Math.max(this.k.bottom, this.m.bottom));
                    }
                }
            }
            if (rectF.intersect(this.k)) {
                return;
            }
            rectF.set(0.0f, 0.0f, 0.0f, 0.0f);
        }
    }

    private void F(RectF rectF, Matrix matrix) {
        if (D() && this.q.i() != C6970Pt3.b.INVERT) {
            this.l.set(0.0f, 0.0f, 0.0f, 0.0f);
            this.t.g(this.l, matrix, true);
            if (rectF.intersect(this.l)) {
                return;
            }
            rectF.set(0.0f, 0.0f, 0.0f, 0.0f);
        }
    }

    private void G() {
        this.p.invalidateSelf();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void H() {
        P(this.s.r() == 1.0f);
    }

    private void I(float f) {
        this.p.N().n().a(this.q.j(), f);
    }

    private void P(boolean z) {
        if (z != this.y) {
            this.y = z;
            G();
        }
    }

    private void Q() {
        if (this.q.f().isEmpty()) {
            P(true);
            return;
        }
        C11959dq2 c11959dq2 = new C11959dq2(this.q.f());
        this.s = c11959dq2;
        c11959dq2.m();
        this.s.a(new AbstractC24408ya0.b() { // from class: ir.nasim.za0
            @Override // ir.nasim.AbstractC24408ya0.b
            public final void a() {
                this.a.H();
            }
        });
        P(((Float) this.s.h()).floatValue() == 1.0f);
        j(this.s);
    }

    private void k(Canvas canvas, Matrix matrix, AbstractC24408ya0 abstractC24408ya0, AbstractC24408ya0 abstractC24408ya02) {
        this.a.set((Path) abstractC24408ya0.h());
        this.a.transform(matrix);
        this.d.setAlpha((int) (((Integer) abstractC24408ya02.h()).intValue() * 2.55f));
        canvas.drawPath(this.a, this.d);
    }

    private void l(Canvas canvas, Matrix matrix, AbstractC24408ya0 abstractC24408ya0, AbstractC24408ya0 abstractC24408ya02) {
        AbstractC16500lN7.n(canvas, this.i, this.e);
        this.a.set((Path) abstractC24408ya0.h());
        this.a.transform(matrix);
        this.d.setAlpha((int) (((Integer) abstractC24408ya02.h()).intValue() * 2.55f));
        canvas.drawPath(this.a, this.d);
        canvas.restore();
    }

    private void m(Canvas canvas, Matrix matrix, AbstractC24408ya0 abstractC24408ya0, AbstractC24408ya0 abstractC24408ya02) {
        AbstractC16500lN7.n(canvas, this.i, this.d);
        canvas.drawRect(this.i, this.d);
        this.a.set((Path) abstractC24408ya0.h());
        this.a.transform(matrix);
        this.d.setAlpha((int) (((Integer) abstractC24408ya02.h()).intValue() * 2.55f));
        canvas.drawPath(this.a, this.f);
        canvas.restore();
    }

    private void n(Canvas canvas, Matrix matrix, AbstractC24408ya0 abstractC24408ya0, AbstractC24408ya0 abstractC24408ya02) {
        AbstractC16500lN7.n(canvas, this.i, this.e);
        canvas.drawRect(this.i, this.d);
        this.f.setAlpha((int) (((Integer) abstractC24408ya02.h()).intValue() * 2.55f));
        this.a.set((Path) abstractC24408ya0.h());
        this.a.transform(matrix);
        canvas.drawPath(this.a, this.f);
        canvas.restore();
    }

    private void o(Canvas canvas, Matrix matrix, AbstractC24408ya0 abstractC24408ya0, AbstractC24408ya0 abstractC24408ya02) {
        AbstractC16500lN7.n(canvas, this.i, this.f);
        canvas.drawRect(this.i, this.d);
        this.f.setAlpha((int) (((Integer) abstractC24408ya02.h()).intValue() * 2.55f));
        this.a.set((Path) abstractC24408ya0.h());
        this.a.transform(matrix);
        canvas.drawPath(this.a, this.f);
        canvas.restore();
    }

    private void p(Canvas canvas, Matrix matrix) {
        if (AbstractC6219Mr3.h()) {
            AbstractC6219Mr3.b("Layer#saveLayer");
        }
        AbstractC16500lN7.o(canvas, this.i, this.e, 19);
        if (Build.VERSION.SDK_INT < 28) {
            t(canvas);
        }
        if (AbstractC6219Mr3.h()) {
            AbstractC6219Mr3.c("Layer#saveLayer");
        }
        for (int i = 0; i < this.r.b().size(); i++) {
            EU3 eu3 = (EU3) this.r.b().get(i);
            AbstractC24408ya0 abstractC24408ya0 = (AbstractC24408ya0) this.r.a().get(i);
            AbstractC24408ya0 abstractC24408ya02 = (AbstractC24408ya0) this.r.c().get(i);
            int i2 = a.b[eu3.a().ordinal()];
            if (i2 != 1) {
                if (i2 == 2) {
                    if (i == 0) {
                        this.d.setColor(-16777216);
                        this.d.setAlpha(255);
                        canvas.drawRect(this.i, this.d);
                    }
                    if (eu3.d()) {
                        o(canvas, matrix, abstractC24408ya0, abstractC24408ya02);
                    } else {
                        q(canvas, matrix, abstractC24408ya0);
                    }
                } else if (i2 != 3) {
                    if (i2 == 4) {
                        if (eu3.d()) {
                            m(canvas, matrix, abstractC24408ya0, abstractC24408ya02);
                        } else {
                            k(canvas, matrix, abstractC24408ya0, abstractC24408ya02);
                        }
                    }
                } else if (eu3.d()) {
                    n(canvas, matrix, abstractC24408ya0, abstractC24408ya02);
                } else {
                    l(canvas, matrix, abstractC24408ya0, abstractC24408ya02);
                }
            } else if (r()) {
                this.d.setAlpha(255);
                canvas.drawRect(this.i, this.d);
            }
        }
        if (AbstractC6219Mr3.h()) {
            AbstractC6219Mr3.b("Layer#restoreLayer");
        }
        canvas.restore();
        if (AbstractC6219Mr3.h()) {
            AbstractC6219Mr3.c("Layer#restoreLayer");
        }
    }

    private void q(Canvas canvas, Matrix matrix, AbstractC24408ya0 abstractC24408ya0) {
        this.a.set((Path) abstractC24408ya0.h());
        this.a.transform(matrix);
        canvas.drawPath(this.a, this.f);
    }

    private boolean r() {
        if (this.r.a().isEmpty()) {
            return false;
        }
        for (int i = 0; i < this.r.b().size(); i++) {
            if (((EU3) this.r.b().get(i)).a() != EU3.a.MASK_MODE_NONE) {
                return false;
            }
        }
        return true;
    }

    private void s() {
        if (this.v != null) {
            return;
        }
        if (this.u == null) {
            this.v = Collections.emptyList();
            return;
        }
        this.v = new ArrayList();
        for (AbstractC3236Aa0 abstractC3236Aa0 = this.u; abstractC3236Aa0 != null; abstractC3236Aa0 = abstractC3236Aa0.u) {
            this.v.add(abstractC3236Aa0);
        }
    }

    private void t(Canvas canvas) {
        if (AbstractC6219Mr3.h()) {
            AbstractC6219Mr3.b("Layer#clearLayer");
        }
        RectF rectF = this.i;
        canvas.drawRect(rectF.left - 1.0f, rectF.top - 1.0f, rectF.right + 1.0f, rectF.bottom + 1.0f, this.h);
        if (AbstractC6219Mr3.h()) {
            AbstractC6219Mr3.c("Layer#clearLayer");
        }
    }

    static AbstractC3236Aa0 v(C8725Xb1 c8725Xb1, C6970Pt3 c6970Pt3, com.airbnb.lottie.q qVar, C23677xK3 c23677xK3) {
        switch (a.a[c6970Pt3.g().ordinal()]) {
            case 1:
                return new C22872vx6(qVar, c6970Pt3, c8725Xb1, c23677xK3);
            case 2:
                return new C8725Xb1(qVar, c6970Pt3, c23677xK3.o(c6970Pt3.n()), c23677xK3);
            case 3:
                return new DH6(qVar, c6970Pt3);
            case 4:
                return new C12099e23(qVar, c6970Pt3);
            case 5:
                return new C10818cF4(qVar, c6970Pt3);
            case 6:
                return new C9930an7(qVar, c6970Pt3);
            default:
                JI3.c("Unknown layer type " + c6970Pt3.g());
                return null;
        }
    }

    C6970Pt3 B() {
        return this.q;
    }

    boolean C() {
        FU3 fu3 = this.r;
        return (fu3 == null || fu3.a().isEmpty()) ? false : true;
    }

    boolean D() {
        return this.t != null;
    }

    public void J(AbstractC24408ya0 abstractC24408ya0) {
        this.w.remove(abstractC24408ya0);
    }

    void L(AbstractC3236Aa0 abstractC3236Aa0) {
        this.t = abstractC3236Aa0;
    }

    void M(boolean z) {
        if (z && this.A == null) {
            this.A = new C7430Rr3();
        }
        this.z = z;
    }

    void N(AbstractC3236Aa0 abstractC3236Aa0) {
        this.u = abstractC3236Aa0;
    }

    void O(float f) {
        if (AbstractC6219Mr3.h()) {
            AbstractC6219Mr3.b("BaseLayer#setProgress");
            AbstractC6219Mr3.b("BaseLayer#setProgress.transform");
        }
        this.x.j(f);
        if (AbstractC6219Mr3.h()) {
            AbstractC6219Mr3.c("BaseLayer#setProgress.transform");
        }
        if (this.r != null) {
            if (AbstractC6219Mr3.h()) {
                AbstractC6219Mr3.b("BaseLayer#setProgress.mask");
            }
            for (int i = 0; i < this.r.a().size(); i++) {
                ((AbstractC24408ya0) this.r.a().get(i)).n(f);
            }
            if (AbstractC6219Mr3.h()) {
                AbstractC6219Mr3.c("BaseLayer#setProgress.mask");
            }
        }
        if (this.s != null) {
            if (AbstractC6219Mr3.h()) {
                AbstractC6219Mr3.b("BaseLayer#setProgress.inout");
            }
            this.s.n(f);
            if (AbstractC6219Mr3.h()) {
                AbstractC6219Mr3.c("BaseLayer#setProgress.inout");
            }
        }
        if (this.t != null) {
            if (AbstractC6219Mr3.h()) {
                AbstractC6219Mr3.b("BaseLayer#setProgress.matte");
            }
            this.t.O(f);
            if (AbstractC6219Mr3.h()) {
                AbstractC6219Mr3.c("BaseLayer#setProgress.matte");
            }
        }
        if (AbstractC6219Mr3.h()) {
            AbstractC6219Mr3.b("BaseLayer#setProgress.animations." + this.w.size());
        }
        for (int i2 = 0; i2 < this.w.size(); i2++) {
            ((AbstractC24408ya0) this.w.get(i2)).n(f);
        }
        if (AbstractC6219Mr3.h()) {
            AbstractC6219Mr3.c("BaseLayer#setProgress.animations." + this.w.size());
            AbstractC6219Mr3.c("BaseLayer#setProgress");
        }
    }

    @Override // ir.nasim.AbstractC24408ya0.b
    public void a() {
        G();
    }

    @Override // ir.nasim.InterfaceC5257Io3
    public void c(Object obj, C13505gL3 c13505gL3) {
        this.x.c(obj, c13505gL3);
    }

    @Override // ir.nasim.InterfaceC5257Io3
    public void f(C5023Ho3 c5023Ho3, int i, List list, C5023Ho3 c5023Ho32) {
        AbstractC3236Aa0 abstractC3236Aa0 = this.t;
        if (abstractC3236Aa0 != null) {
            C5023Ho3 c5023Ho3A = c5023Ho32.a(abstractC3236Aa0.getName());
            if (c5023Ho3.c(this.t.getName(), i)) {
                list.add(c5023Ho3A.i(this.t));
            }
            if (c5023Ho3.g(this.t.getName(), i) && c5023Ho3.h(getName(), i)) {
                this.t.K(c5023Ho3, c5023Ho3.e(this.t.getName(), i) + i, list, c5023Ho3A);
            }
        }
        if (c5023Ho3.g(getName(), i)) {
            if (!"__container".equals(getName())) {
                c5023Ho32 = c5023Ho32.a(getName());
                if (c5023Ho3.c(getName(), i)) {
                    list.add(c5023Ho32.i(this));
                }
            }
            if (c5023Ho3.h(getName(), i)) {
                K(c5023Ho3, i + c5023Ho3.e(getName(), i), list, c5023Ho32);
            }
        }
    }

    @Override // ir.nasim.V02
    public void g(RectF rectF, Matrix matrix, boolean z) {
        this.i.set(0.0f, 0.0f, 0.0f, 0.0f);
        s();
        this.o.set(matrix);
        if (z) {
            List list = this.v;
            if (list != null) {
                for (int size = list.size() - 1; size >= 0; size--) {
                    this.o.preConcat(((AbstractC3236Aa0) this.v.get(size)).x.f());
                }
            } else {
                AbstractC3236Aa0 abstractC3236Aa0 = this.u;
                if (abstractC3236Aa0 != null) {
                    this.o.preConcat(abstractC3236Aa0.x.f());
                }
            }
        }
        this.o.preConcat(this.x.f());
    }

    @Override // ir.nasim.InterfaceC14939ik1
    public String getName() {
        return this.q.j();
    }

    @Override // ir.nasim.V02
    public void i(Canvas canvas, Matrix matrix, int i, C17470n12 c17470n12) {
        Paint paint;
        Integer num;
        AbstractC6219Mr3.b(this.n);
        if (!this.y || this.q.y()) {
            AbstractC6219Mr3.c(this.n);
            return;
        }
        s();
        if (AbstractC6219Mr3.h()) {
            AbstractC6219Mr3.b("Layer#parentMatrix");
        }
        this.b.reset();
        this.b.set(matrix);
        for (int size = this.v.size() - 1; size >= 0; size--) {
            this.b.preConcat(((AbstractC3236Aa0) this.v.get(size)).x.f());
        }
        if (AbstractC6219Mr3.h()) {
            AbstractC6219Mr3.c("Layer#parentMatrix");
        }
        AbstractC24408ya0 abstractC24408ya0H = this.x.h();
        int iIntValue = (int) ((((i / 255.0f) * ((abstractC24408ya0H == null || (num = (Integer) abstractC24408ya0H.h()) == null) ? 100 : num.intValue())) / 100.0f) * 255.0f);
        if (!D() && !C() && w() == EnumC6469Nr3.NORMAL) {
            this.b.preConcat(this.x.f());
            if (AbstractC6219Mr3.h()) {
                AbstractC6219Mr3.b("Layer#drawLayer");
            }
            u(canvas, this.b, iIntValue, c17470n12);
            if (AbstractC6219Mr3.h()) {
                AbstractC6219Mr3.c("Layer#drawLayer");
            }
            I(AbstractC6219Mr3.c(this.n));
            return;
        }
        if (AbstractC6219Mr3.h()) {
            AbstractC6219Mr3.b("Layer#computeBounds");
        }
        g(this.i, this.b, false);
        F(this.i, matrix);
        this.b.preConcat(this.x.f());
        E(this.i, this.b);
        this.j.set(0.0f, 0.0f, canvas.getWidth(), canvas.getHeight());
        canvas.getMatrix(this.c);
        if (!this.c.isIdentity()) {
            Matrix matrix2 = this.c;
            matrix2.invert(matrix2);
            this.c.mapRect(this.j);
        }
        if (!this.i.intersect(this.j)) {
            this.i.set(0.0f, 0.0f, 0.0f, 0.0f);
        }
        if (AbstractC6219Mr3.h()) {
            AbstractC6219Mr3.c("Layer#computeBounds");
        }
        if (this.i.width() >= 1.0f && this.i.height() >= 1.0f) {
            if (AbstractC6219Mr3.h()) {
                AbstractC6219Mr3.b("Layer#saveLayer");
            }
            this.d.setAlpha(255);
            AbstractC14178hU4.b(this.d, w().j());
            AbstractC16500lN7.n(canvas, this.i, this.d);
            if (AbstractC6219Mr3.h()) {
                AbstractC6219Mr3.c("Layer#saveLayer");
            }
            if (w() != EnumC6469Nr3.MULTIPLY) {
                t(canvas);
            } else {
                if (this.D == null) {
                    C7430Rr3 c7430Rr3 = new C7430Rr3();
                    this.D = c7430Rr3;
                    c7430Rr3.setColor(-1);
                }
                RectF rectF = this.i;
                canvas.drawRect(rectF.left - 1.0f, rectF.top - 1.0f, rectF.right + 1.0f, rectF.bottom + 1.0f, this.D);
            }
            if (AbstractC6219Mr3.h()) {
                AbstractC6219Mr3.b("Layer#drawLayer");
            }
            u(canvas, this.b, iIntValue, c17470n12);
            if (AbstractC6219Mr3.h()) {
                AbstractC6219Mr3.c("Layer#drawLayer");
            }
            if (C()) {
                p(canvas, this.b);
            }
            if (D()) {
                if (AbstractC6219Mr3.h()) {
                    AbstractC6219Mr3.b("Layer#drawMatte");
                    AbstractC6219Mr3.b("Layer#saveLayer");
                }
                AbstractC16500lN7.o(canvas, this.i, this.g, 19);
                if (AbstractC6219Mr3.h()) {
                    AbstractC6219Mr3.c("Layer#saveLayer");
                }
                t(canvas);
                this.t.i(canvas, matrix, i, null);
                if (AbstractC6219Mr3.h()) {
                    AbstractC6219Mr3.b("Layer#restoreLayer");
                }
                canvas.restore();
                if (AbstractC6219Mr3.h()) {
                    AbstractC6219Mr3.c("Layer#restoreLayer");
                    AbstractC6219Mr3.c("Layer#drawMatte");
                }
            }
            if (AbstractC6219Mr3.h()) {
                AbstractC6219Mr3.b("Layer#restoreLayer");
            }
            canvas.restore();
            if (AbstractC6219Mr3.h()) {
                AbstractC6219Mr3.c("Layer#restoreLayer");
            }
        }
        if (this.z && (paint = this.A) != null) {
            paint.setStyle(Paint.Style.STROKE);
            this.A.setColor(-251901);
            this.A.setStrokeWidth(4.0f);
            canvas.drawRect(this.i, this.A);
            this.A.setStyle(Paint.Style.FILL);
            this.A.setColor(1357638635);
            canvas.drawRect(this.i, this.A);
        }
        I(AbstractC6219Mr3.c(this.n));
    }

    public void j(AbstractC24408ya0 abstractC24408ya0) {
        if (abstractC24408ya0 == null) {
            return;
        }
        this.w.add(abstractC24408ya0);
    }

    abstract void u(Canvas canvas, Matrix matrix, int i, C17470n12 c17470n12);

    public EnumC6469Nr3 w() {
        return this.q.a();
    }

    public C4474Fh0 x() {
        return this.q.b();
    }

    public BlurMaskFilter y(float f) {
        if (this.B == f) {
            return this.C;
        }
        BlurMaskFilter blurMaskFilter = new BlurMaskFilter(f / 2.0f, BlurMaskFilter.Blur.NORMAL);
        this.C = blurMaskFilter;
        this.B = f;
        return blurMaskFilter;
    }

    public C18061o12 z() {
        return this.q.d();
    }

    @Override // ir.nasim.InterfaceC14939ik1
    public void b(List list, List list2) {
    }

    void K(C5023Ho3 c5023Ho3, int i, List list, C5023Ho3 c5023Ho32) {
    }
}
