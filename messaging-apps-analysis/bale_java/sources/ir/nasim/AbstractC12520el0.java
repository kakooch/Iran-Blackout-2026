package ir.nasim;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* renamed from: ir.nasim.el0, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public abstract class AbstractC12520el0 {
    public static final a b = new a(null);
    private final long a;

    /* renamed from: ir.nasim.el0$a */
    public static final class a {
        private a() {
        }

        public static /* synthetic */ AbstractC12520el0 b(a aVar, List list, float f, float f2, int i, int i2, Object obj) {
            if ((i2 & 2) != 0) {
                f = 0.0f;
            }
            if ((i2 & 4) != 0) {
                f2 = Float.POSITIVE_INFINITY;
            }
            if ((i2 & 8) != 0) {
                i = AbstractC4553Fp7.a.a();
            }
            return aVar.a(list, f, f2, i);
        }

        public static /* synthetic */ AbstractC12520el0 e(a aVar, List list, long j, long j2, int i, int i2, Object obj) {
            if ((i2 & 2) != 0) {
                j = ZG4.b.c();
            }
            long j3 = j;
            if ((i2 & 4) != 0) {
                j2 = ZG4.b.a();
            }
            long j4 = j2;
            if ((i2 & 8) != 0) {
                i = AbstractC4553Fp7.a.a();
            }
            return aVar.c(list, j3, j4, i);
        }

        public static /* synthetic */ AbstractC12520el0 g(a aVar, List list, long j, float f, int i, int i2, Object obj) {
            if ((i2 & 2) != 0) {
                j = ZG4.b.b();
            }
            long j2 = j;
            if ((i2 & 4) != 0) {
                f = Float.POSITIVE_INFINITY;
            }
            float f2 = f;
            if ((i2 & 8) != 0) {
                i = AbstractC4553Fp7.a.a();
            }
            return aVar.f(list, j2, f2, i);
        }

        public static /* synthetic */ AbstractC12520el0 j(a aVar, List list, float f, float f2, int i, int i2, Object obj) {
            if ((i2 & 2) != 0) {
                f = 0.0f;
            }
            if ((i2 & 4) != 0) {
                f2 = Float.POSITIVE_INFINITY;
            }
            if ((i2 & 8) != 0) {
                i = AbstractC4553Fp7.a.a();
            }
            return aVar.h(list, f, f2, i);
        }

        public static /* synthetic */ AbstractC12520el0 k(a aVar, XV4[] xv4Arr, float f, float f2, int i, int i2, Object obj) {
            if ((i2 & 2) != 0) {
                f = 0.0f;
            }
            if ((i2 & 4) != 0) {
                f2 = Float.POSITIVE_INFINITY;
            }
            if ((i2 & 8) != 0) {
                i = AbstractC4553Fp7.a.a();
            }
            return aVar.i(xv4Arr, f, f2, i);
        }

        public final AbstractC12520el0 a(List list, float f, float f2, int i) {
            return c(list, ZG4.e((Float.floatToRawIntBits(f) << 32) | (Float.floatToRawIntBits(0.0f) & 4294967295L)), ZG4.e((Float.floatToRawIntBits(f2) << 32) | (Float.floatToRawIntBits(0.0f) & 4294967295L)), i);
        }

        public final AbstractC12520el0 c(List list, long j, long j2, int i) {
            return new C6291Mz3(list, null, j, j2, i, null);
        }

        public final AbstractC12520el0 d(XV4[] xv4Arr, long j, long j2, int i) {
            ArrayList arrayList = new ArrayList(xv4Arr.length);
            for (XV4 xv4 : xv4Arr) {
                arrayList.add(C24381yX0.k(((C24381yX0) xv4.f()).y()));
            }
            ArrayList arrayList2 = new ArrayList(xv4Arr.length);
            for (XV4 xv42 : xv4Arr) {
                arrayList2.add(Float.valueOf(((Number) xv42.e()).floatValue()));
            }
            return new C6291Mz3(arrayList, arrayList2, j, j2, i, null);
        }

        public final AbstractC12520el0 f(List list, long j, float f, int i) {
            return new KF5(list, null, j, f, i, null);
        }

        public final AbstractC12520el0 h(List list, float f, float f2, int i) {
            return c(list, ZG4.e((Float.floatToRawIntBits(0.0f) << 32) | (Float.floatToRawIntBits(f) & 4294967295L)), ZG4.e((Float.floatToRawIntBits(0.0f) << 32) | (Float.floatToRawIntBits(f2) & 4294967295L)), i);
        }

        public final AbstractC12520el0 i(XV4[] xv4Arr, float f, float f2, int i) {
            return d((XV4[]) Arrays.copyOf(xv4Arr, xv4Arr.length), ZG4.e((Float.floatToRawIntBits(0.0f) << 32) | (Float.floatToRawIntBits(f) & 4294967295L)), ZG4.e((Float.floatToRawIntBits(0.0f) << 32) | (Float.floatToRawIntBits(f2) & 4294967295L)), i);
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    public /* synthetic */ AbstractC12520el0(ED1 ed1) {
        this();
    }

    public abstract void a(long j, InterfaceC12969fU4 interfaceC12969fU4, float f);

    private AbstractC12520el0() {
        this.a = OD6.b.a();
    }
}
