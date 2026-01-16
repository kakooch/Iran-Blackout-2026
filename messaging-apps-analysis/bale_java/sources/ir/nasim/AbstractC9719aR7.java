package ir.nasim;

/* renamed from: ir.nasim.aR7, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC9719aR7 {
    private static final int[] a = new int[0];
    private static final float[] b = new float[0];
    private static final PI c = new PI(new int[2], new float[2], new float[][]{new float[2], new float[2]});

    /* renamed from: ir.nasim.aR7$a */
    public static final class a implements InterfaceC8619Wt {
        private final C16772lq2[] a;

        a(AbstractC8151Ut abstractC8151Ut, float f, float f2) {
            int iB = abstractC8151Ut.b();
            C16772lq2[] c16772lq2Arr = new C16772lq2[iB];
            for (int i = 0; i < iB; i++) {
                c16772lq2Arr[i] = new C16772lq2(f, f2, abstractC8151Ut.a(i));
            }
            this.a = c16772lq2Arr;
        }

        @Override // ir.nasim.InterfaceC8619Wt
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public C16772lq2 get(int i) {
            return this.a[i];
        }
    }

    /* renamed from: ir.nasim.aR7$b */
    public static final class b implements InterfaceC8619Wt {
        private final C16772lq2 a;

        b(float f, float f2) {
            this.a = new C16772lq2(f, f2, 0.0f, 4, null);
        }

        @Override // ir.nasim.InterfaceC8619Wt
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public C16772lq2 get(int i) {
            return this.a;
        }
    }

    public static final long e(InterfaceC10929cR7 interfaceC10929cR7, long j) {
        long jD = j - interfaceC10929cR7.d();
        long jE = interfaceC10929cR7.e();
        if (jD < 0) {
            jD = 0;
        }
        return jD > jE ? jE : jD;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final InterfaceC8619Wt f(AbstractC8151Ut abstractC8151Ut, float f, float f2) {
        return abstractC8151Ut != null ? new a(abstractC8151Ut, f, f2) : new b(f, f2);
    }

    public static final AbstractC8151Ut g(ZQ7 zq7, long j, AbstractC8151Ut abstractC8151Ut, AbstractC8151Ut abstractC8151Ut2, AbstractC8151Ut abstractC8151Ut3) {
        return zq7.c(j * 1000000, abstractC8151Ut, abstractC8151Ut2, abstractC8151Ut3);
    }
}
