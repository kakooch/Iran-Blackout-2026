package ir.nasim;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import ir.nasim.CB1;
import java.io.IOException;
import okio.BufferedSource;

/* renamed from: ir.nasim.y37, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C24111y37 implements CB1 {
    public static final a d = new a(null);
    private final AbstractC10086b33 a;
    private final IL4 b;
    private final boolean c;

    /* renamed from: ir.nasim.y37$a */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    /* renamed from: ir.nasim.y37$c */
    static final class c extends AbstractC8614Ws3 implements SA2 {
        c() {
            super(0);
        }

        @Override // ir.nasim.SA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final C20541sB1 invoke() throws IOException {
            float fH;
            float f;
            int iD;
            int iD2;
            BufferedSource bufferedSourceC = C24111y37.this.a.c();
            try {
                com.caverock.androidsvg.g gVarL = com.caverock.androidsvg.g.l(bufferedSourceC.inputStream());
                YV0.a(bufferedSourceC, null);
                RectF rectFG = gVarL.g();
                if (!C24111y37.this.f() || rectFG == null) {
                    fH = gVarL.h();
                    f = gVarL.f();
                } else {
                    fH = rectFG.width();
                    f = rectFG.height();
                }
                C24111y37 c24111y37 = C24111y37.this;
                XV4 xv4E = c24111y37.e(fH, f, c24111y37.b.n());
                float fFloatValue = ((Number) xv4E.a()).floatValue();
                float fFloatValue2 = ((Number) xv4E.b()).floatValue();
                if (fH <= 0.0f || f <= 0.0f) {
                    iD = AbstractC20723sV3.d(fFloatValue);
                    iD2 = AbstractC20723sV3.d(fFloatValue2);
                } else {
                    float fD = C21144tB1.d(fH, f, fFloatValue, fFloatValue2, C24111y37.this.b.n());
                    iD = (int) (fD * fH);
                    iD2 = (int) (fD * f);
                }
                if (rectFG == null && fH > 0.0f && f > 0.0f) {
                    gVarL.A(0.0f, 0.0f, fH, f);
                }
                gVarL.C("100%");
                gVarL.z("100%");
                Bitmap bitmapCreateBitmap = Bitmap.createBitmap(iD, iD2, AbstractC18047o.d(C24111y37.this.b.f()));
                String strA = F37.a(C24111y37.this.b.l());
                gVarL.s(new Canvas(bitmapCreateBitmap), strA != null ? new com.caverock.androidsvg.f().a(strA) : null);
                return new C20541sB1(new BitmapDrawable(C24111y37.this.b.g().getResources(), bitmapCreateBitmap), true);
            } finally {
            }
        }
    }

    public C24111y37(AbstractC10086b33 abstractC10086b33, IL4 il4, boolean z) {
        this.a = abstractC10086b33;
        this.b = il4;
        this.c = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final XV4 e(float f, float f2, EnumC14254hc6 enumC14254hc6) {
        if (!AbstractC17456n.b(this.b.o())) {
            PD6 pd6O = this.b.o();
            return AbstractC4616Fw7.a(Float.valueOf(AbstractC18047o.c(pd6O.a(), enumC14254hc6)), Float.valueOf(AbstractC18047o.c(pd6O.b(), enumC14254hc6)));
        }
        if (f <= 0.0f) {
            f = 512.0f;
        }
        if (f2 <= 0.0f) {
            f2 = 512.0f;
        }
        return AbstractC4616Fw7.a(Float.valueOf(f), Float.valueOf(f2));
    }

    @Override // ir.nasim.CB1
    public Object a(InterfaceC20295rm1 interfaceC20295rm1) {
        return AbstractC7757Tb3.c(null, new c(), interfaceC20295rm1, 1, null);
    }

    public final boolean f() {
        return this.c;
    }

    /* renamed from: ir.nasim.y37$b */
    public static final class b implements CB1.a {
        private final boolean a;

        public b(boolean z) {
            this.a = z;
        }

        private final boolean b(WH6 wh6) {
            return AbstractC13042fc3.d(wh6.b(), "image/svg+xml") || AbstractC23521x37.a(C21144tB1.a, wh6.c().c());
        }

        @Override // ir.nasim.CB1.a
        public CB1 a(WH6 wh6, IL4 il4, InterfaceC18663p23 interfaceC18663p23) {
            if (b(wh6)) {
                return new C24111y37(wh6.c(), il4, this.a);
            }
            return null;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof b) && this.a == ((b) obj).a;
        }

        public int hashCode() {
            return Boolean.hashCode(this.a);
        }

        public /* synthetic */ b(boolean z, int i, ED1 ed1) {
            this((i & 1) != 0 ? true : z);
        }
    }
}
