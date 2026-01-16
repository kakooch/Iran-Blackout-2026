package ir.nasim;

import ir.nasim.C10522bl;
import ir.nasim.C12263eJ6;
import ir.nasim.C16103ki4;
import ir.nasim.C16208kt;
import ir.nasim.C17867nh5;
import ir.nasim.C19835r13;
import ir.nasim.C20727sV7;
import ir.nasim.C20882sl7;
import ir.nasim.C21114t80;
import ir.nasim.C21882uI2;
import ir.nasim.C5097Hw5;
import ir.nasim.C5165Ie1;
import ir.nasim.C6977Pu1;
import ir.nasim.C7688Su0;
import ir.nasim.C8541Wk2;
import ir.nasim.C9634aI3;
import ir.nasim.IM6;
import ir.nasim.KC3;
import ir.nasim.MI5;
import ir.nasim.NM;
import ir.nasim.VQ4;

/* renamed from: ir.nasim.vl0, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C22742vl0 {
    private final int a;
    private final XZ b;
    private final AbstractC23538x54 c;
    private final long d;
    private final long e;
    private final boolean f;

    /* renamed from: ir.nasim.vl0$a */
    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[EnumC9782aY7.values().length];
            try {
                iArr[EnumC9782aY7.b.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[EnumC9782aY7.d.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[EnumC9782aY7.s.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[EnumC9782aY7.c.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[EnumC9782aY7.e.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[EnumC9782aY7.f.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr[EnumC9782aY7.g.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr[EnumC9782aY7.h.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                iArr[EnumC9782aY7.i.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                iArr[EnumC9782aY7.j.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                iArr[EnumC9782aY7.l.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                iArr[EnumC9782aY7.m.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                iArr[EnumC9782aY7.n.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                iArr[EnumC9782aY7.y.ordinal()] = 14;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                iArr[EnumC9782aY7.o.ordinal()] = 15;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                iArr[EnumC9782aY7.q.ordinal()] = 16;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                iArr[EnumC9782aY7.r.ordinal()] = 17;
            } catch (NoSuchFieldError unused17) {
            }
            try {
                iArr[EnumC9782aY7.t.ordinal()] = 18;
            } catch (NoSuchFieldError unused18) {
            }
            try {
                iArr[EnumC9782aY7.v.ordinal()] = 19;
            } catch (NoSuchFieldError unused19) {
            }
            try {
                iArr[EnumC9782aY7.w.ordinal()] = 20;
            } catch (NoSuchFieldError unused20) {
            }
            try {
                iArr[EnumC9782aY7.x.ordinal()] = 21;
            } catch (NoSuchFieldError unused21) {
            }
            try {
                iArr[EnumC9782aY7.z.ordinal()] = 22;
            } catch (NoSuchFieldError unused22) {
            }
            a = iArr;
        }
    }

    public C22742vl0(int i, XZ xz, AbstractC23538x54 abstractC23538x54, long j, long j2, boolean z) {
        AbstractC13042fc3.i(xz, "lifecycleOwner");
        AbstractC13042fc3.i(abstractC23538x54, "messageClickListenerAdapter");
        this.a = i;
        this.b = xz;
        this.c = abstractC23538x54;
        this.d = j;
        this.e = j2;
        this.f = z;
    }

    public final InterfaceC22152ul0 a(JW7 jw7) {
        AbstractC13042fc3.i(jw7, "viewHolderType");
        boolean zF = jw7.f();
        switch (a.a[jw7.d().ordinal()]) {
            case 1:
                return this.a == 270066638 ? new VQ4.a(zF, this.c) : new C20882sl7.b(zF, this.c);
            case 2:
                return new C19835r13.b(zF, this.c);
            case 3:
                return new C21114t80.b(zF, this.c);
            case 4:
            case 5:
                return new NM.c(zF, this.d, this.e, this.f, this.b, this.c);
            case 6:
                return new C8541Wk2.b(zF, this.c);
            case 7:
                return new IM6.b(zF, this.c);
            case 8:
                return new C16208kt.a(zF, this.c);
            case 9:
                return new C7688Su0.a(zF, this.c);
            case 10:
                return new C5165Ie1.a(zF, this.c);
            case 11:
                return new C9634aI3.a(zF, this.c);
            case 12:
                return new C16103ki4.b(zF, this.c);
            case 13:
                return new C21882uI2.b(zF, false, this.c);
            case 14:
                return new C21882uI2.b(zF, true, this.c);
            case 15:
                return new C6977Pu1.b(zF, this.c);
            case 16:
                return new C10522bl.b(zF, this.c);
            case 17:
                return new C12263eJ6.a(zF, this.c);
            case 18:
                return new MI5.b(zF, this.c);
            case 19:
                return new C20727sV7.a(zF, this.b, this.c);
            case 20:
                return new KC3.a(zF, this.c);
            case 21:
                return new C5097Hw5.b(zF, this.c);
            case 22:
                return new C17867nh5.c(zF, this.c);
            default:
                throw new IllegalArgumentException();
        }
    }
}
