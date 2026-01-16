package ir.nasim;

import java.util.Iterator;

/* renamed from: ir.nasim.t12, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C21046t12 implements InterfaceC6873Pi5 {
    private final long a;
    private final WH1 b;
    private final InterfaceC14603iB2 c;

    public /* synthetic */ C21046t12(long j, WH1 wh1, InterfaceC14603iB2 interfaceC14603iB2, ED1 ed1) {
        this(j, wh1, interfaceC14603iB2);
    }

    @Override // ir.nasim.InterfaceC6873Pi5
    public long a(C25005za3 c25005za3, long j, EnumC12613eu3 enumC12613eu3, long j2) {
        InterfaceC23384wp6 interfaceC23384wp6K;
        Object obj;
        Object next;
        int iB0 = this.b.B0(AbstractC23528x44.j());
        int iB02 = this.b.B0(C19557qZ1.e(this.a));
        EnumC12613eu3 enumC12613eu32 = EnumC12613eu3.a;
        int i = iB02 * (enumC12613eu3 == enumC12613eu32 ? 1 : -1);
        int iB03 = this.b.B0(C19557qZ1.f(this.a));
        int iG = c25005za3.g() + i;
        int iH = (c25005za3.h() - C4414Fa3.g(j2)) + i;
        int iG2 = C4414Fa3.g(j) - C4414Fa3.g(j2);
        if (enumC12613eu3 == enumC12613eu32) {
            Integer numValueOf = Integer.valueOf(iG);
            Integer numValueOf2 = Integer.valueOf(iH);
            if (c25005za3.g() < 0) {
                iG2 = 0;
            }
            interfaceC23384wp6K = AbstractC9962aq6.k(numValueOf, numValueOf2, Integer.valueOf(iG2));
        } else {
            Integer numValueOf3 = Integer.valueOf(iH);
            Integer numValueOf4 = Integer.valueOf(iG);
            if (c25005za3.h() <= C4414Fa3.g(j)) {
                iG2 = 0;
            }
            interfaceC23384wp6K = AbstractC9962aq6.k(numValueOf3, numValueOf4, Integer.valueOf(iG2));
        }
        Iterator it = interfaceC23384wp6K.iterator();
        while (true) {
            obj = null;
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            int iIntValue = ((Number) next).intValue();
            if (iIntValue >= 0 && iIntValue + C4414Fa3.g(j2) <= C4414Fa3.g(j)) {
                break;
            }
        }
        Integer num = (Integer) next;
        if (num != null) {
            iH = num.intValue();
        }
        int iMax = Math.max(c25005za3.d() + iB03, iB0);
        int iJ = (c25005za3.j() - C4414Fa3.f(j2)) + iB03;
        Iterator it2 = AbstractC9962aq6.k(Integer.valueOf(iMax), Integer.valueOf(iJ), Integer.valueOf((c25005za3.j() - (C4414Fa3.f(j2) / 2)) + iB03), Integer.valueOf((C4414Fa3.f(j) - C4414Fa3.f(j2)) - iB0)).iterator();
        while (true) {
            if (!it2.hasNext()) {
                break;
            }
            Object next2 = it2.next();
            int iIntValue2 = ((Number) next2).intValue();
            if (iIntValue2 >= iB0 && iIntValue2 + C4414Fa3.f(j2) <= C4414Fa3.f(j) - iB0) {
                obj = next2;
                break;
            }
        }
        Integer num2 = (Integer) obj;
        if (num2 != null) {
            iJ = num2.intValue();
        }
        this.c.invoke(c25005za3, new C25005za3(iH, iJ, C4414Fa3.g(j2) + iH, C4414Fa3.f(j2) + iJ));
        return AbstractC22635va3.a(iH, iJ);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C21046t12)) {
            return false;
        }
        C21046t12 c21046t12 = (C21046t12) obj;
        return C19557qZ1.d(this.a, c21046t12.a) && AbstractC13042fc3.d(this.b, c21046t12.b) && AbstractC13042fc3.d(this.c, c21046t12.c);
    }

    public int hashCode() {
        return (((C19557qZ1.g(this.a) * 31) + this.b.hashCode()) * 31) + this.c.hashCode();
    }

    public String toString() {
        return "DropdownMenuPositionProvider(contentOffset=" + ((Object) C19557qZ1.h(this.a)) + ", density=" + this.b + ", onPositionCalculated=" + this.c + ')';
    }

    private C21046t12(long j, WH1 wh1, InterfaceC14603iB2 interfaceC14603iB2) {
        this.a = j;
        this.b = wh1;
        this.c = interfaceC14603iB2;
    }
}
