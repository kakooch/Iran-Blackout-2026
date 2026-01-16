package ir.nasim;

import java.util.ArrayList;

/* renamed from: ir.nasim.j76, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
class C15170j76 {
    public static int h;
    AbstractC15192j98 c;
    AbstractC15192j98 d;
    int f;
    int g;
    public int a = 0;
    public boolean b = false;
    ArrayList e = new ArrayList();

    public C15170j76(AbstractC15192j98 abstractC15192j98, int i) {
        this.c = null;
        this.d = null;
        int i2 = h;
        this.f = i2;
        h = i2 + 1;
        this.c = abstractC15192j98;
        this.d = abstractC15192j98;
        this.g = i;
    }

    private long c(C13476gI1 c13476gI1, long j) {
        AbstractC15192j98 abstractC15192j98 = c13476gI1.d;
        if (abstractC15192j98 instanceof C18340oV2) {
            return j;
        }
        int size = c13476gI1.k.size();
        long jMin = j;
        for (int i = 0; i < size; i++) {
            InterfaceC10842cI1 interfaceC10842cI1 = (InterfaceC10842cI1) c13476gI1.k.get(i);
            if (interfaceC10842cI1 instanceof C13476gI1) {
                C13476gI1 c13476gI12 = (C13476gI1) interfaceC10842cI1;
                if (c13476gI12.d != abstractC15192j98) {
                    jMin = Math.min(jMin, c(c13476gI12, c13476gI12.f + j));
                }
            }
        }
        if (c13476gI1 != abstractC15192j98.i) {
            return jMin;
        }
        long j2 = j - abstractC15192j98.j();
        return Math.min(Math.min(jMin, c(abstractC15192j98.h, j2)), j2 - abstractC15192j98.h.f);
    }

    private long d(C13476gI1 c13476gI1, long j) {
        AbstractC15192j98 abstractC15192j98 = c13476gI1.d;
        if (abstractC15192j98 instanceof C18340oV2) {
            return j;
        }
        int size = c13476gI1.k.size();
        long jMax = j;
        for (int i = 0; i < size; i++) {
            InterfaceC10842cI1 interfaceC10842cI1 = (InterfaceC10842cI1) c13476gI1.k.get(i);
            if (interfaceC10842cI1 instanceof C13476gI1) {
                C13476gI1 c13476gI12 = (C13476gI1) interfaceC10842cI1;
                if (c13476gI12.d != abstractC15192j98) {
                    jMax = Math.max(jMax, d(c13476gI12, c13476gI12.f + j));
                }
            }
        }
        if (c13476gI1 != abstractC15192j98.h) {
            return jMax;
        }
        long j2 = j + abstractC15192j98.j();
        return Math.max(Math.max(jMax, d(abstractC15192j98.i, j2)), j2 - abstractC15192j98.i.f);
    }

    public void a(AbstractC15192j98 abstractC15192j98) {
        this.e.add(abstractC15192j98);
        this.d = abstractC15192j98;
    }

    public long b(C17242me1 c17242me1, int i) {
        long j;
        int i2;
        AbstractC15192j98 abstractC15192j98 = this.c;
        if (abstractC15192j98 instanceof C13475gI0) {
            if (((C13475gI0) abstractC15192j98).f != i) {
                return 0L;
            }
        } else if (i == 0) {
            if (!(abstractC15192j98 instanceof RY2)) {
                return 0L;
            }
        } else if (!(abstractC15192j98 instanceof C17727nS7)) {
            return 0L;
        }
        C13476gI1 c13476gI1 = (i == 0 ? c17242me1.e : c17242me1.f).h;
        C13476gI1 c13476gI12 = (i == 0 ? c17242me1.e : c17242me1.f).i;
        boolean zContains = abstractC15192j98.h.l.contains(c13476gI1);
        boolean zContains2 = this.c.i.l.contains(c13476gI12);
        long j2 = this.c.j();
        if (zContains && zContains2) {
            long jD = d(this.c.h, 0L);
            long jC = c(this.c.i, 0L);
            long j3 = jD - j2;
            AbstractC15192j98 abstractC15192j982 = this.c;
            int i3 = abstractC15192j982.i.f;
            if (j3 >= (-i3)) {
                j3 += i3;
            }
            int i4 = abstractC15192j982.h.f;
            long j4 = ((-jC) - j2) - i4;
            if (j4 >= i4) {
                j4 -= i4;
            }
            float fS = abstractC15192j982.b.s(i);
            float f = fS > 0.0f ? (long) ((j4 / fS) + (j3 / (1.0f - fS))) : 0L;
            long j5 = ((long) ((f * fS) + 0.5f)) + j2 + ((long) ((f * (1.0f - fS)) + 0.5f));
            j = r12.h.f + j5;
            i2 = this.c.i.f;
        } else {
            if (zContains) {
                return Math.max(d(this.c.h, r12.f), this.c.h.f + j2);
            }
            if (zContains2) {
                return Math.max(-c(this.c.i, r12.f), (-this.c.i.f) + j2);
            }
            j = r12.h.f + this.c.j();
            i2 = this.c.i.f;
        }
        return j - i2;
    }
}
