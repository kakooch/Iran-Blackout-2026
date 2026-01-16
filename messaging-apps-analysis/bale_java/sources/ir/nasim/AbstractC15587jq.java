package ir.nasim;

import android.graphics.Paint;
import android.graphics.PorterDuffXfermode;
import android.graphics.Shader;
import android.os.Build;
import ir.nasim.AZ6;
import ir.nasim.AbstractC24405yZ6;

/* renamed from: ir.nasim.jq, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public abstract class AbstractC15587jq {

    /* renamed from: ir.nasim.jq$a */
    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a;
        public static final /* synthetic */ int[] b;
        public static final /* synthetic */ int[] c;

        static {
            int[] iArr = new int[Paint.Style.values().length];
            try {
                iArr[Paint.Style.STROKE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            a = iArr;
            int[] iArr2 = new int[Paint.Cap.values().length];
            try {
                iArr2[Paint.Cap.BUTT.ordinal()] = 1;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr2[Paint.Cap.ROUND.ordinal()] = 2;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr2[Paint.Cap.SQUARE.ordinal()] = 3;
            } catch (NoSuchFieldError unused4) {
            }
            b = iArr2;
            int[] iArr3 = new int[Paint.Join.values().length];
            try {
                iArr3[Paint.Join.MITER.ordinal()] = 1;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr3[Paint.Join.BEVEL.ordinal()] = 2;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr3[Paint.Join.ROUND.ordinal()] = 3;
            } catch (NoSuchFieldError unused7) {
            }
            c = iArr3;
        }
    }

    public static final InterfaceC12969fU4 a() {
        return new C14997iq();
    }

    public static final InterfaceC12969fU4 b(Paint paint) {
        return new C14997iq(paint);
    }

    public static final float c(Paint paint) {
        return paint.getAlpha() / 255.0f;
    }

    public static final long d(Paint paint) {
        return DX0.b(paint.getColor());
    }

    public static final int e(Paint paint) {
        return !paint.isFilterBitmap() ? AbstractC17934no2.a.b() : AbstractC17934no2.a.a();
    }

    public static final int f(Paint paint) {
        Paint.Cap strokeCap = paint.getStrokeCap();
        int i = strokeCap == null ? -1 : a.b[strokeCap.ordinal()];
        return i != 1 ? i != 2 ? i != 3 ? AbstractC24405yZ6.a.a() : AbstractC24405yZ6.a.c() : AbstractC24405yZ6.a.b() : AbstractC24405yZ6.a.a();
    }

    public static final int g(Paint paint) {
        Paint.Join strokeJoin = paint.getStrokeJoin();
        int i = strokeJoin == null ? -1 : a.c[strokeJoin.ordinal()];
        return i != 1 ? i != 2 ? i != 3 ? AZ6.a.b() : AZ6.a.c() : AZ6.a.a() : AZ6.a.b();
    }

    public static final float h(Paint paint) {
        return paint.getStrokeMiter();
    }

    public static final float i(Paint paint) {
        return paint.getStrokeWidth();
    }

    public static final Paint j() {
        return new Paint(7);
    }

    public static final void k(Paint paint, float f) {
        paint.setAlpha((int) Math.rint(f * 255.0f));
    }

    public static final void l(Paint paint, int i) {
        if (Build.VERSION.SDK_INT >= 29) {
            Eb8.a.a(paint, i);
        } else {
            paint.setXfermode(new PorterDuffXfermode(AbstractC7156Qn.b(i)));
        }
    }

    public static final void m(Paint paint, long j) {
        paint.setColor(DX0.k(j));
    }

    public static final void n(Paint paint, AbstractC24975zX0 abstractC24975zX0) {
        paint.setColorFilter(abstractC24975zX0 != null ? AbstractC8831Xn.b(abstractC24975zX0) : null);
    }

    public static final void o(Paint paint, int i) {
        paint.setFilterBitmap(!AbstractC17934no2.d(i, AbstractC17934no2.a.b()));
    }

    public static final void p(Paint paint, InterfaceC13909h15 interfaceC13909h15) {
        AbstractC18350oW3.a(interfaceC13909h15);
        paint.setPathEffect(null);
    }

    public static final void q(Paint paint, Shader shader) {
        paint.setShader(shader);
    }

    public static final void r(Paint paint, int i) {
        AbstractC24405yZ6.a aVar = AbstractC24405yZ6.a;
        paint.setStrokeCap(AbstractC24405yZ6.e(i, aVar.c()) ? Paint.Cap.SQUARE : AbstractC24405yZ6.e(i, aVar.b()) ? Paint.Cap.ROUND : AbstractC24405yZ6.e(i, aVar.a()) ? Paint.Cap.BUTT : Paint.Cap.BUTT);
    }

    public static final void s(Paint paint, int i) {
        AZ6.a aVar = AZ6.a;
        paint.setStrokeJoin(AZ6.e(i, aVar.b()) ? Paint.Join.MITER : AZ6.e(i, aVar.a()) ? Paint.Join.BEVEL : AZ6.e(i, aVar.c()) ? Paint.Join.ROUND : Paint.Join.MITER);
    }

    public static final void t(Paint paint, float f) {
        paint.setStrokeMiter(f);
    }

    public static final void u(Paint paint, float f) {
        paint.setStrokeWidth(f);
    }

    public static final void v(Paint paint, int i) {
        paint.setStyle(VV4.d(i, VV4.a.b()) ? Paint.Style.STROKE : Paint.Style.FILL);
    }
}
