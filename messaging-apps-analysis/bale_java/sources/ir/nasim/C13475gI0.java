package ir.nasim;

import android.gov.nist.core.Separators;
import java.util.ArrayList;
import java.util.Iterator;

/* renamed from: ir.nasim.gI0, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public class C13475gI0 extends AbstractC15192j98 {
    ArrayList k;
    private int l;

    public C13475gI0(C16651le1 c16651le1, int i) {
        super(c16651le1);
        this.k = new ArrayList();
        this.f = i;
        q();
    }

    private void q() {
        C16651le1 c16651le1;
        C16651le1 c16651le12 = this.b;
        C16651le1 c16651le1O = c16651le12.O(this.f);
        while (true) {
            C16651le1 c16651le13 = c16651le1O;
            c16651le1 = c16651le12;
            c16651le12 = c16651le13;
            if (c16651le12 == null) {
                break;
            } else {
                c16651le1O = c16651le12.O(this.f);
            }
        }
        this.b = c16651le1;
        this.k.add(c16651le1.Q(this.f));
        C16651le1 c16651le1M = c16651le1.M(this.f);
        while (c16651le1M != null) {
            this.k.add(c16651le1M.Q(this.f));
            c16651le1M = c16651le1M.M(this.f);
        }
        Iterator it = this.k.iterator();
        while (it.hasNext()) {
            AbstractC15192j98 abstractC15192j98 = (AbstractC15192j98) it.next();
            int i = this.f;
            if (i == 0) {
                abstractC15192j98.b.c = this;
            } else if (i == 1) {
                abstractC15192j98.b.d = this;
            }
        }
        if (this.f == 0 && ((C17242me1) this.b.N()).O1() && this.k.size() > 1) {
            ArrayList arrayList = this.k;
            this.b = ((AbstractC15192j98) arrayList.get(arrayList.size() - 1)).b;
        }
        this.l = this.f == 0 ? this.b.B() : this.b.T();
    }

    private C16651le1 r() {
        for (int i = 0; i < this.k.size(); i++) {
            AbstractC15192j98 abstractC15192j98 = (AbstractC15192j98) this.k.get(i);
            if (abstractC15192j98.b.W() != 8) {
                return abstractC15192j98.b;
            }
        }
        return null;
    }

    private C16651le1 s() {
        for (int size = this.k.size() - 1; size >= 0; size--) {
            AbstractC15192j98 abstractC15192j98 = (AbstractC15192j98) this.k.get(size);
            if (abstractC15192j98.b.W() != 8) {
                return abstractC15192j98.b;
            }
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:62:0x00d7  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x00e9  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x0153  */
    @Override // ir.nasim.AbstractC15192j98, ir.nasim.InterfaceC10842cI1
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void a(ir.nasim.InterfaceC10842cI1 r27) {
        /*
            Method dump skipped, instructions count: 1062
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C13475gI0.a(ir.nasim.cI1):void");
    }

    @Override // ir.nasim.AbstractC15192j98
    void d() {
        Iterator it = this.k.iterator();
        while (it.hasNext()) {
            ((AbstractC15192j98) it.next()).d();
        }
        int size = this.k.size();
        if (size < 1) {
            return;
        }
        C16651le1 c16651le1 = ((AbstractC15192j98) this.k.get(0)).b;
        C16651le1 c16651le12 = ((AbstractC15192j98) this.k.get(size - 1)).b;
        if (this.f == 0) {
            C8243Vd1 c8243Vd1 = c16651le1.Q;
            C8243Vd1 c8243Vd12 = c16651le12.S;
            C13476gI1 c13476gI1I = i(c8243Vd1, 0);
            int iF = c8243Vd1.f();
            C16651le1 c16651le1R = r();
            if (c16651le1R != null) {
                iF = c16651le1R.Q.f();
            }
            if (c13476gI1I != null) {
                b(this.h, c13476gI1I, iF);
            }
            C13476gI1 c13476gI1I2 = i(c8243Vd12, 0);
            int iF2 = c8243Vd12.f();
            C16651le1 c16651le1S = s();
            if (c16651le1S != null) {
                iF2 = c16651le1S.S.f();
            }
            if (c13476gI1I2 != null) {
                b(this.i, c13476gI1I2, -iF2);
            }
        } else {
            C8243Vd1 c8243Vd13 = c16651le1.R;
            C8243Vd1 c8243Vd14 = c16651le12.T;
            C13476gI1 c13476gI1I3 = i(c8243Vd13, 1);
            int iF3 = c8243Vd13.f();
            C16651le1 c16651le1R2 = r();
            if (c16651le1R2 != null) {
                iF3 = c16651le1R2.R.f();
            }
            if (c13476gI1I3 != null) {
                b(this.h, c13476gI1I3, iF3);
            }
            C13476gI1 c13476gI1I4 = i(c8243Vd14, 1);
            int iF4 = c8243Vd14.f();
            C16651le1 c16651le1S2 = s();
            if (c16651le1S2 != null) {
                iF4 = c16651le1S2.T.f();
            }
            if (c13476gI1I4 != null) {
                b(this.i, c13476gI1I4, -iF4);
            }
        }
        this.h.a = this;
        this.i.a = this;
    }

    @Override // ir.nasim.AbstractC15192j98
    public void e() {
        for (int i = 0; i < this.k.size(); i++) {
            ((AbstractC15192j98) this.k.get(i)).e();
        }
    }

    @Override // ir.nasim.AbstractC15192j98
    void f() {
        this.c = null;
        Iterator it = this.k.iterator();
        while (it.hasNext()) {
            ((AbstractC15192j98) it.next()).f();
        }
    }

    @Override // ir.nasim.AbstractC15192j98
    public long j() {
        int size = this.k.size();
        long j = 0;
        for (int i = 0; i < size; i++) {
            j = j + r4.h.f + ((AbstractC15192j98) this.k.get(i)).j() + r4.i.f;
        }
        return j;
    }

    @Override // ir.nasim.AbstractC15192j98
    boolean m() {
        int size = this.k.size();
        for (int i = 0; i < size; i++) {
            if (!((AbstractC15192j98) this.k.get(i)).m()) {
                return false;
            }
        }
        return true;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("ChainRun ");
        sb.append(this.f == 0 ? "horizontal : " : "vertical : ");
        Iterator it = this.k.iterator();
        while (it.hasNext()) {
            AbstractC15192j98 abstractC15192j98 = (AbstractC15192j98) it.next();
            sb.append(Separators.LESS_THAN);
            sb.append(abstractC15192j98);
            sb.append("> ");
        }
        return sb.toString();
    }
}
