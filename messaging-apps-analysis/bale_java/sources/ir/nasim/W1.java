package ir.nasim;

import ir.nasim.C9475a16;
import java.util.Arrays;

/* loaded from: classes8.dex */
public abstract class W1 {
    private Y1[] a;
    private int b;
    private int c;
    private C18647p07 d;

    public final InterfaceC10258bL6 d() {
        C18647p07 c18647p07;
        synchronized (this) {
            c18647p07 = this.d;
            if (c18647p07 == null) {
                c18647p07 = new C18647p07(this.b);
                this.d = c18647p07;
            }
        }
        return c18647p07;
    }

    protected final Y1 j() {
        Y1 y1L;
        C18647p07 c18647p07;
        synchronized (this) {
            try {
                Y1[] y1ArrM = this.a;
                if (y1ArrM == null) {
                    y1ArrM = m(2);
                    this.a = y1ArrM;
                } else if (this.b >= y1ArrM.length) {
                    Object[] objArrCopyOf = Arrays.copyOf(y1ArrM, y1ArrM.length * 2);
                    AbstractC13042fc3.h(objArrCopyOf, "copyOf(this, newSize)");
                    this.a = (Y1[]) objArrCopyOf;
                    y1ArrM = (Y1[]) objArrCopyOf;
                }
                int i = this.c;
                do {
                    y1L = y1ArrM[i];
                    if (y1L == null) {
                        y1L = l();
                        y1ArrM[i] = y1L;
                    }
                    i++;
                    if (i >= y1ArrM.length) {
                        i = 0;
                    }
                    AbstractC13042fc3.g(y1L, "null cannot be cast to non-null type kotlinx.coroutines.flow.internal.AbstractSharedFlowSlot<kotlin.Any>");
                } while (!y1L.a(this));
                this.c = i;
                this.b++;
                c18647p07 = this.d;
            } catch (Throwable th) {
                throw th;
            }
        }
        if (c18647p07 != null) {
            c18647p07.c0(1);
        }
        return y1L;
    }

    protected abstract Y1 l();

    protected abstract Y1[] m(int i);

    protected final void n(Y1 y1) {
        C18647p07 c18647p07;
        int i;
        InterfaceC20295rm1[] interfaceC20295rm1ArrB;
        synchronized (this) {
            try {
                int i2 = this.b - 1;
                this.b = i2;
                c18647p07 = this.d;
                if (i2 == 0) {
                    this.c = 0;
                }
                AbstractC13042fc3.g(y1, "null cannot be cast to non-null type kotlinx.coroutines.flow.internal.AbstractSharedFlowSlot<kotlin.Any>");
                interfaceC20295rm1ArrB = y1.b(this);
            } catch (Throwable th) {
                throw th;
            }
        }
        for (InterfaceC20295rm1 interfaceC20295rm1 : interfaceC20295rm1ArrB) {
            if (interfaceC20295rm1 != null) {
                C9475a16.a aVar = C9475a16.b;
                interfaceC20295rm1.resumeWith(C9475a16.b(C19938rB7.a));
            }
        }
        if (c18647p07 != null) {
            c18647p07.c0(-1);
        }
    }

    protected final int o() {
        return this.b;
    }

    protected final Y1[] p() {
        return this.a;
    }
}
