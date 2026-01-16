package ir.nasim;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;

/* renamed from: ir.nasim.cx6, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class C11411cx6 {
    public static final InterfaceC9342Zn1 m = new JM5(0.5f);
    AbstractC11317co1 a;
    AbstractC11317co1 b;
    AbstractC11317co1 c;
    AbstractC11317co1 d;
    InterfaceC9342Zn1 e;
    InterfaceC9342Zn1 f;
    InterfaceC9342Zn1 g;
    InterfaceC9342Zn1 h;
    C11465d32 i;
    C11465d32 j;
    C11465d32 k;
    C11465d32 l;

    /* renamed from: ir.nasim.cx6$c */
    public interface c {
        InterfaceC9342Zn1 a(InterfaceC9342Zn1 interfaceC9342Zn1);
    }

    public static b a() {
        return new b();
    }

    public static b b(Context context, int i, int i2) {
        return c(context, i, i2, 0);
    }

    private static b c(Context context, int i, int i2, int i3) {
        return d(context, i, i2, new C22893w0(i3));
    }

    private static b d(Context context, int i, int i2, InterfaceC9342Zn1 interfaceC9342Zn1) throws Resources.NotFoundException {
        if (i2 != 0) {
            ContextThemeWrapper contextThemeWrapper = new ContextThemeWrapper(context, i);
            i = i2;
            context = contextThemeWrapper;
        }
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(i, GE5.ShapeAppearance);
        try {
            int i3 = typedArrayObtainStyledAttributes.getInt(GE5.ShapeAppearance_cornerFamily, 0);
            int i4 = typedArrayObtainStyledAttributes.getInt(GE5.ShapeAppearance_cornerFamilyTopLeft, i3);
            int i5 = typedArrayObtainStyledAttributes.getInt(GE5.ShapeAppearance_cornerFamilyTopRight, i3);
            int i6 = typedArrayObtainStyledAttributes.getInt(GE5.ShapeAppearance_cornerFamilyBottomRight, i3);
            int i7 = typedArrayObtainStyledAttributes.getInt(GE5.ShapeAppearance_cornerFamilyBottomLeft, i3);
            InterfaceC9342Zn1 interfaceC9342Zn1M = m(typedArrayObtainStyledAttributes, GE5.ShapeAppearance_cornerSize, interfaceC9342Zn1);
            InterfaceC9342Zn1 interfaceC9342Zn1M2 = m(typedArrayObtainStyledAttributes, GE5.ShapeAppearance_cornerSizeTopLeft, interfaceC9342Zn1M);
            InterfaceC9342Zn1 interfaceC9342Zn1M3 = m(typedArrayObtainStyledAttributes, GE5.ShapeAppearance_cornerSizeTopRight, interfaceC9342Zn1M);
            InterfaceC9342Zn1 interfaceC9342Zn1M4 = m(typedArrayObtainStyledAttributes, GE5.ShapeAppearance_cornerSizeBottomRight, interfaceC9342Zn1M);
            return new b().F(i4, interfaceC9342Zn1M2).K(i5, interfaceC9342Zn1M3).z(i6, interfaceC9342Zn1M4).u(i7, m(typedArrayObtainStyledAttributes, GE5.ShapeAppearance_cornerSizeBottomLeft, interfaceC9342Zn1M));
        } finally {
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    public static b e(Context context, AttributeSet attributeSet, int i, int i2) {
        return f(context, attributeSet, i, i2, 0);
    }

    public static b f(Context context, AttributeSet attributeSet, int i, int i2, int i3) {
        return g(context, attributeSet, i, i2, new C22893w0(i3));
    }

    public static b g(Context context, AttributeSet attributeSet, int i, int i2, InterfaceC9342Zn1 interfaceC9342Zn1) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, GE5.MaterialShape, i, i2);
        int resourceId = typedArrayObtainStyledAttributes.getResourceId(GE5.MaterialShape_shapeAppearance, 0);
        int resourceId2 = typedArrayObtainStyledAttributes.getResourceId(GE5.MaterialShape_shapeAppearanceOverlay, 0);
        typedArrayObtainStyledAttributes.recycle();
        return d(context, resourceId, resourceId2, interfaceC9342Zn1);
    }

    private static InterfaceC9342Zn1 m(TypedArray typedArray, int i, InterfaceC9342Zn1 interfaceC9342Zn1) {
        TypedValue typedValuePeekValue = typedArray.peekValue(i);
        if (typedValuePeekValue == null) {
            return interfaceC9342Zn1;
        }
        int i2 = typedValuePeekValue.type;
        return i2 == 5 ? new C22893w0(TypedValue.complexToDimensionPixelSize(typedValuePeekValue.data, typedArray.getResources().getDisplayMetrics())) : i2 == 6 ? new JM5(typedValuePeekValue.getFraction(1.0f, 1.0f)) : interfaceC9342Zn1;
    }

    public C11465d32 h() {
        return this.k;
    }

    public AbstractC11317co1 i() {
        return this.d;
    }

    public InterfaceC9342Zn1 j() {
        return this.h;
    }

    public AbstractC11317co1 k() {
        return this.c;
    }

    public InterfaceC9342Zn1 l() {
        return this.g;
    }

    public C11465d32 n() {
        return this.l;
    }

    public C11465d32 o() {
        return this.j;
    }

    public C11465d32 p() {
        return this.i;
    }

    public AbstractC11317co1 q() {
        return this.a;
    }

    public InterfaceC9342Zn1 r() {
        return this.e;
    }

    public AbstractC11317co1 s() {
        return this.b;
    }

    public InterfaceC9342Zn1 t() {
        return this.f;
    }

    public boolean u(RectF rectF) {
        boolean z = this.l.getClass().equals(C11465d32.class) && this.j.getClass().equals(C11465d32.class) && this.i.getClass().equals(C11465d32.class) && this.k.getClass().equals(C11465d32.class);
        float fA = this.e.a(rectF);
        return z && ((this.f.a(rectF) > fA ? 1 : (this.f.a(rectF) == fA ? 0 : -1)) == 0 && (this.h.a(rectF) > fA ? 1 : (this.h.a(rectF) == fA ? 0 : -1)) == 0 && (this.g.a(rectF) > fA ? 1 : (this.g.a(rectF) == fA ? 0 : -1)) == 0) && ((this.b instanceof O46) && (this.a instanceof O46) && (this.c instanceof O46) && (this.d instanceof O46));
    }

    public b v() {
        return new b(this);
    }

    public C11411cx6 w(float f) {
        return v().o(f).m();
    }

    public C11411cx6 x(InterfaceC9342Zn1 interfaceC9342Zn1) {
        return v().p(interfaceC9342Zn1).m();
    }

    public C11411cx6 y(c cVar) {
        return v().I(cVar.a(r())).N(cVar.a(t())).x(cVar.a(j())).C(cVar.a(l())).m();
    }

    private C11411cx6(b bVar) {
        this.a = bVar.a;
        this.b = bVar.b;
        this.c = bVar.c;
        this.d = bVar.d;
        this.e = bVar.e;
        this.f = bVar.f;
        this.g = bVar.g;
        this.h = bVar.h;
        this.i = bVar.i;
        this.j = bVar.j;
        this.k = bVar.k;
        this.l = bVar.l;
    }

    /* renamed from: ir.nasim.cx6$b */
    public static final class b {
        private AbstractC11317co1 a;
        private AbstractC11317co1 b;
        private AbstractC11317co1 c;
        private AbstractC11317co1 d;
        private InterfaceC9342Zn1 e;
        private InterfaceC9342Zn1 f;
        private InterfaceC9342Zn1 g;
        private InterfaceC9342Zn1 h;
        private C11465d32 i;
        private C11465d32 j;
        private C11465d32 k;
        private C11465d32 l;

        public b() {
            this.a = AbstractC10961cV3.b();
            this.b = AbstractC10961cV3.b();
            this.c = AbstractC10961cV3.b();
            this.d = AbstractC10961cV3.b();
            this.e = new C22893w0(0.0f);
            this.f = new C22893w0(0.0f);
            this.g = new C22893w0(0.0f);
            this.h = new C22893w0(0.0f);
            this.i = AbstractC10961cV3.c();
            this.j = AbstractC10961cV3.c();
            this.k = AbstractC10961cV3.c();
            this.l = AbstractC10961cV3.c();
        }

        private static float n(AbstractC11317co1 abstractC11317co1) {
            if (abstractC11317co1 instanceof O46) {
                return ((O46) abstractC11317co1).a;
            }
            if (abstractC11317co1 instanceof C6271Mx1) {
                return ((C6271Mx1) abstractC11317co1).a;
            }
            return -1.0f;
        }

        public b A(AbstractC11317co1 abstractC11317co1) {
            this.c = abstractC11317co1;
            float fN = n(abstractC11317co1);
            if (fN != -1.0f) {
                B(fN);
            }
            return this;
        }

        public b B(float f) {
            this.g = new C22893w0(f);
            return this;
        }

        public b C(InterfaceC9342Zn1 interfaceC9342Zn1) {
            this.g = interfaceC9342Zn1;
            return this;
        }

        public b D(C11465d32 c11465d32) {
            this.i = c11465d32;
            return this;
        }

        public b E(int i, float f) {
            return G(AbstractC10961cV3.a(i)).H(f);
        }

        public b F(int i, InterfaceC9342Zn1 interfaceC9342Zn1) {
            return G(AbstractC10961cV3.a(i)).I(interfaceC9342Zn1);
        }

        public b G(AbstractC11317co1 abstractC11317co1) {
            this.a = abstractC11317co1;
            float fN = n(abstractC11317co1);
            if (fN != -1.0f) {
                H(fN);
            }
            return this;
        }

        public b H(float f) {
            this.e = new C22893w0(f);
            return this;
        }

        public b I(InterfaceC9342Zn1 interfaceC9342Zn1) {
            this.e = interfaceC9342Zn1;
            return this;
        }

        public b J(int i, float f) {
            return L(AbstractC10961cV3.a(i)).M(f);
        }

        public b K(int i, InterfaceC9342Zn1 interfaceC9342Zn1) {
            return L(AbstractC10961cV3.a(i)).N(interfaceC9342Zn1);
        }

        public b L(AbstractC11317co1 abstractC11317co1) {
            this.b = abstractC11317co1;
            float fN = n(abstractC11317co1);
            if (fN != -1.0f) {
                M(fN);
            }
            return this;
        }

        public b M(float f) {
            this.f = new C22893w0(f);
            return this;
        }

        public b N(InterfaceC9342Zn1 interfaceC9342Zn1) {
            this.f = interfaceC9342Zn1;
            return this;
        }

        public C11411cx6 m() {
            return new C11411cx6(this);
        }

        public b o(float f) {
            return H(f).M(f).B(f).w(f);
        }

        public b p(InterfaceC9342Zn1 interfaceC9342Zn1) {
            return I(interfaceC9342Zn1).N(interfaceC9342Zn1).C(interfaceC9342Zn1).x(interfaceC9342Zn1);
        }

        public b q(int i, float f) {
            return r(AbstractC10961cV3.a(i)).o(f);
        }

        public b r(AbstractC11317co1 abstractC11317co1) {
            return G(abstractC11317co1).L(abstractC11317co1).A(abstractC11317co1).v(abstractC11317co1);
        }

        public b s(C11465d32 c11465d32) {
            this.k = c11465d32;
            return this;
        }

        public b t(int i, float f) {
            return v(AbstractC10961cV3.a(i)).w(f);
        }

        public b u(int i, InterfaceC9342Zn1 interfaceC9342Zn1) {
            return v(AbstractC10961cV3.a(i)).x(interfaceC9342Zn1);
        }

        public b v(AbstractC11317co1 abstractC11317co1) {
            this.d = abstractC11317co1;
            float fN = n(abstractC11317co1);
            if (fN != -1.0f) {
                w(fN);
            }
            return this;
        }

        public b w(float f) {
            this.h = new C22893w0(f);
            return this;
        }

        public b x(InterfaceC9342Zn1 interfaceC9342Zn1) {
            this.h = interfaceC9342Zn1;
            return this;
        }

        public b y(int i, float f) {
            return A(AbstractC10961cV3.a(i)).B(f);
        }

        public b z(int i, InterfaceC9342Zn1 interfaceC9342Zn1) {
            return A(AbstractC10961cV3.a(i)).C(interfaceC9342Zn1);
        }

        public b(C11411cx6 c11411cx6) {
            this.a = AbstractC10961cV3.b();
            this.b = AbstractC10961cV3.b();
            this.c = AbstractC10961cV3.b();
            this.d = AbstractC10961cV3.b();
            this.e = new C22893w0(0.0f);
            this.f = new C22893w0(0.0f);
            this.g = new C22893w0(0.0f);
            this.h = new C22893w0(0.0f);
            this.i = AbstractC10961cV3.c();
            this.j = AbstractC10961cV3.c();
            this.k = AbstractC10961cV3.c();
            this.l = AbstractC10961cV3.c();
            this.a = c11411cx6.a;
            this.b = c11411cx6.b;
            this.c = c11411cx6.c;
            this.d = c11411cx6.d;
            this.e = c11411cx6.e;
            this.f = c11411cx6.f;
            this.g = c11411cx6.g;
            this.h = c11411cx6.h;
            this.i = c11411cx6.i;
            this.j = c11411cx6.j;
            this.k = c11411cx6.k;
            this.l = c11411cx6.l;
        }
    }

    public C11411cx6() {
        this.a = AbstractC10961cV3.b();
        this.b = AbstractC10961cV3.b();
        this.c = AbstractC10961cV3.b();
        this.d = AbstractC10961cV3.b();
        this.e = new C22893w0(0.0f);
        this.f = new C22893w0(0.0f);
        this.g = new C22893w0(0.0f);
        this.h = new C22893w0(0.0f);
        this.i = AbstractC10961cV3.c();
        this.j = AbstractC10961cV3.c();
        this.k = AbstractC10961cV3.c();
        this.l = AbstractC10961cV3.c();
    }
}
