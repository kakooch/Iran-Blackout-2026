package ir.nasim;

import ir.nasim.C4751Gk1;
import ir.nasim.C9475a16;
import java.util.concurrent.CancellationException;

/* renamed from: ir.nasim.Rk0, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C7364Rk0 {
    public static final int b = C12544en4.d;
    private final C12544en4 a = new C12544en4(new C4751Gk1.a[16], 0);

    /* renamed from: ir.nasim.Rk0$a */
    static final class a extends AbstractC8614Ws3 implements UA2 {
        final /* synthetic */ C4751Gk1.a f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(C4751Gk1.a aVar) {
            super(1);
            this.f = aVar;
        }

        public final void a(Throwable th) {
            C7364Rk0.this.a.t(this.f);
        }

        @Override // ir.nasim.UA2
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a((Throwable) obj);
            return C19938rB7.a;
        }
    }

    public final void b(Throwable th) {
        C12544en4 c12544en4 = this.a;
        int iO = c12544en4.o();
        HE0[] he0Arr = new HE0[iO];
        for (int i = 0; i < iO; i++) {
            he0Arr[i] = ((C4751Gk1.a) c12544en4.a[i]).a();
        }
        for (int i2 = 0; i2 < iO; i2++) {
            he0Arr[i2].F(th);
        }
        if (this.a.o() == 0) {
            return;
        }
        P73.c("uncancelled requests present");
    }

    public final boolean c(C4751Gk1.a aVar) {
        CK5 ck5 = (CK5) aVar.b().invoke();
        if (ck5 == null) {
            HE0 he0A = aVar.a();
            C9475a16.a aVar2 = C9475a16.b;
            he0A.resumeWith(C9475a16.b(C19938rB7.a));
            return false;
        }
        aVar.a().J(new a(aVar));
        C24411ya3 c24411ya3Y = AbstractC23053wG5.y(0, this.a.o());
        int iO = c24411ya3Y.o();
        int iT = c24411ya3Y.t();
        if (iO <= iT) {
            while (true) {
                CK5 ck52 = (CK5) ((C4751Gk1.a) this.a.a[iT]).b().invoke();
                if (ck52 != null) {
                    CK5 ck5O = ck5.o(ck52);
                    if (AbstractC13042fc3.d(ck5O, ck5)) {
                        this.a.a(iT + 1, aVar);
                        return true;
                    }
                    if (!AbstractC13042fc3.d(ck5O, ck52)) {
                        CancellationException cancellationException = new CancellationException("bringIntoView call interrupted by a newer, non-overlapping call");
                        int iO2 = this.a.o() - 1;
                        if (iO2 <= iT) {
                            while (true) {
                                ((C4751Gk1.a) this.a.a[iT]).a().F(cancellationException);
                                if (iO2 == iT) {
                                    break;
                                }
                                iO2++;
                            }
                        }
                    }
                }
                if (iT == iO) {
                    break;
                }
                iT--;
            }
        }
        this.a.a(0, aVar);
        return true;
    }

    public final void d() {
        C24411ya3 c24411ya3Y = AbstractC23053wG5.y(0, this.a.o());
        int iO = c24411ya3Y.o();
        int iT = c24411ya3Y.t();
        if (iO <= iT) {
            while (true) {
                ((C4751Gk1.a) this.a.a[iO]).a().resumeWith(C9475a16.b(C19938rB7.a));
                if (iO == iT) {
                    break;
                } else {
                    iO++;
                }
            }
        }
        this.a.k();
    }
}
