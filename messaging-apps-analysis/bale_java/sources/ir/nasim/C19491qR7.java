package ir.nasim;

import io.appmetrica.analytics.AppMetricaDefaultValues;
import kotlin.NoWhenBranchMatchedException;

/* renamed from: ir.nasim.qR7, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C19491qR7 {
    private final boolean a;
    private final a b;
    private final int c;
    private final C17449mz1[] d;
    private int e;
    private final float[] f;
    private final float[] g;
    private final float[] h;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* renamed from: ir.nasim.qR7$a */
    public static final class a {
        public static final a a = new a("Lsq2", 0);
        public static final a b = new a("Impulse", 1);
        private static final /* synthetic */ a[] c;
        private static final /* synthetic */ F92 d;

        static {
            a[] aVarArrA = a();
            c = aVarArrA;
            d = G92.a(aVarArrA);
        }

        private a(String str, int i) {
        }

        private static final /* synthetic */ a[] a() {
            return new a[]{a, b};
        }

        public static a valueOf(String str) {
            return (a) Enum.valueOf(a.class, str);
        }

        public static a[] values() {
            return (a[]) c.clone();
        }
    }

    /* renamed from: ir.nasim.qR7$b */
    public /* synthetic */ class b {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[a.values().length];
            try {
                iArr[a.b.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[a.a.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            a = iArr;
        }
    }

    public C19491qR7(boolean z, a aVar) {
        this.a = z;
        this.b = aVar;
        if (z && aVar.equals(a.a)) {
            throw new IllegalStateException("Lsq2 not (yet) supported for differential axes");
        }
        int i = b.a[aVar.ordinal()];
        int i2 = 2;
        if (i != 1) {
            if (i != 2) {
                throw new NoWhenBranchMatchedException();
            }
            i2 = 3;
        }
        this.c = i2;
        this.d = new C17449mz1[20];
        this.f = new float[20];
        this.g = new float[20];
        this.h = new float[3];
    }

    private final float b(float[] fArr, float[] fArr2, int i) {
        try {
            return AbstractC21968uR7.i(fArr2, fArr, i, 2, this.h)[1];
        } catch (IllegalArgumentException unused) {
            return 0.0f;
        }
    }

    public final void a(long j, float f) {
        int i = (this.e + 1) % 20;
        this.e = i;
        AbstractC21968uR7.j(this.d, i, j, f);
    }

    public final float c() {
        float f;
        float[] fArr = this.f;
        float[] fArr2 = this.g;
        int i = this.e;
        C17449mz1 c17449mz1 = this.d[i];
        if (c17449mz1 == null) {
            return 0.0f;
        }
        int i2 = 0;
        C17449mz1 c17449mz12 = c17449mz1;
        while (true) {
            C17449mz1 c17449mz13 = this.d[i];
            if (c17449mz13 == null) {
                break;
            }
            float fB = c17449mz1.b() - c17449mz13.b();
            float fAbs = Math.abs(c17449mz13.b() - c17449mz12.b());
            C17449mz1 c17449mz14 = (this.b == a.a || this.a) ? c17449mz13 : c17449mz1;
            if (fB > 100.0f || fAbs > 40.0f) {
                break;
            }
            fArr[i2] = c17449mz13.a();
            fArr2[i2] = -fB;
            if (i == 0) {
                i = 20;
            }
            i--;
            i2++;
            if (i2 >= 20) {
                break;
            }
            c17449mz12 = c17449mz14;
        }
        if (i2 < this.c) {
            return 0.0f;
        }
        int i3 = b.a[this.b.ordinal()];
        if (i3 == 1) {
            f = AbstractC21968uR7.f(fArr, fArr2, i2, this.a);
        } else {
            if (i3 != 2) {
                throw new NoWhenBranchMatchedException();
            }
            f = b(fArr, fArr2, i2);
        }
        return f * AppMetricaDefaultValues.DEFAULT_MAX_REPORTS_IN_DATABASE_COUNT;
    }

    public final float d(float f) {
        if (!(f > 0.0f)) {
            M73.b("maximumVelocity should be a positive value. You specified=" + f);
        }
        float fC = c();
        if (fC == 0.0f || Float.isNaN(fC)) {
            return 0.0f;
        }
        return fC > 0.0f ? AbstractC23053wG5.h(fC, f) : AbstractC23053wG5.d(fC, -f);
    }

    public final void e() {
        AbstractC9648aK.y(this.d, null, 0, 0, 6, null);
        this.e = 0;
    }

    public /* synthetic */ C19491qR7(boolean z, a aVar, int i, ED1 ed1) {
        this((i & 1) != 0 ? false : z, (i & 2) != 0 ? a.a : aVar);
    }

    public C19491qR7(boolean z) {
        this(z, a.b);
    }
}
