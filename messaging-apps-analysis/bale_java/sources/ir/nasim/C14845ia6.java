package ir.nasim;

/* renamed from: ir.nasim.ia6, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public final class C14845ia6 {
    public static final C14845ia6 a = new C14845ia6();

    /* renamed from: ir.nasim.ia6$a */
    static final class a implements Runnable {
        final /* synthetic */ byte[] a;
        final /* synthetic */ int b;
        final /* synthetic */ UA2 c;

        /* renamed from: ir.nasim.ia6$a$a, reason: collision with other inner class name */
        static final class RunnableC1300a implements Runnable {
            final /* synthetic */ byte[] b;

            RunnableC1300a(byte[] bArr) {
                this.b = bArr;
            }

            @Override // java.lang.Runnable
            public final void run() {
                a.this.c.invoke(this.b);
            }
        }

        a(byte[] bArr, int i, UA2 ua2) {
            this.a = bArr;
            this.b = i;
            this.c = ua2;
        }

        @Override // java.lang.Runnable
        public final void run() {
            AbstractC15434ja6.b().post(new RunnableC1300a(C14845ia6.a.a(this.a, this.b)));
        }
    }

    private C14845ia6() {
    }

    public final byte[] a(byte[] bArr, int i) {
        AbstractC13042fc3.j(bArr, "data");
        byte[] bArr2 = new byte[i];
        int iMax = (int) Math.max(Math.floor((bArr.length / i) / 10.0d), 1.0d);
        if (i >= bArr.length) {
            return AbstractC15434ja6.d(bArr2, bArr);
        }
        int i2 = 0;
        C23231wa3 c23231wa3V = AbstractC23053wG5.v(new C24411ya3(0, bArr.length), iMax);
        int iO = c23231wa3V.o();
        int iT = c23231wa3V.t();
        int iV = c23231wa3V.v();
        if (iV <= 0 ? iO >= iT : iO <= iT) {
            float fA = 0.0f;
            float f = 0.0f;
            while (true) {
                int length = (int) ((i * iO) / bArr.length);
                if (i2 == length) {
                    f++;
                    fA += AbstractC15434ja6.a(bArr[iO]);
                } else {
                    bArr2[i2] = (byte) (fA / f);
                    fA = 0.0f;
                    f = 0.0f;
                    i2 = length;
                }
                if (iO == iT) {
                    break;
                }
                iO += iV;
            }
        }
        return bArr2;
    }

    public final void b(byte[] bArr, int i, UA2 ua2) {
        AbstractC13042fc3.j(bArr, "data");
        AbstractC13042fc3.j(ua2, "answer");
        AbstractC15434ja6.c().submit(new a(bArr, i, ua2));
    }
}
