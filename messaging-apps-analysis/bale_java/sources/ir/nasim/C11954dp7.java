package ir.nasim;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

/* renamed from: ir.nasim.dp7, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public class C11954dp7 {
    private static final AtomicIntegerFieldUpdater b = AtomicIntegerFieldUpdater.newUpdater(C11954dp7.class, "_size");
    private volatile int _size;
    private InterfaceC12567ep7[] a;

    private final InterfaceC12567ep7[] f() {
        InterfaceC12567ep7[] interfaceC12567ep7Arr = this.a;
        if (interfaceC12567ep7Arr == null) {
            InterfaceC12567ep7[] interfaceC12567ep7Arr2 = new InterfaceC12567ep7[4];
            this.a = interfaceC12567ep7Arr2;
            return interfaceC12567ep7Arr2;
        }
        if (c() < interfaceC12567ep7Arr.length) {
            return interfaceC12567ep7Arr;
        }
        Object[] objArrCopyOf = Arrays.copyOf(interfaceC12567ep7Arr, c() * 2);
        AbstractC13042fc3.h(objArrCopyOf, "copyOf(this, newSize)");
        InterfaceC12567ep7[] interfaceC12567ep7Arr3 = (InterfaceC12567ep7[]) objArrCopyOf;
        this.a = interfaceC12567ep7Arr3;
        return interfaceC12567ep7Arr3;
    }

    private final void j(int i) {
        b.set(this, i);
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x002b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final void k(int r6) {
        /*
            r5 = this;
        L0:
            int r0 = r6 * 2
            int r1 = r0 + 1
            int r2 = r5.c()
            if (r1 < r2) goto Lb
            return
        Lb:
            ir.nasim.ep7[] r2 = r5.a
            ir.nasim.AbstractC13042fc3.f(r2)
            int r0 = r0 + 2
            int r3 = r5.c()
            if (r0 >= r3) goto L2b
            r3 = r2[r0]
            ir.nasim.AbstractC13042fc3.f(r3)
            java.lang.Comparable r3 = (java.lang.Comparable) r3
            r4 = r2[r1]
            ir.nasim.AbstractC13042fc3.f(r4)
            int r3 = r3.compareTo(r4)
            if (r3 >= 0) goto L2b
            goto L2c
        L2b:
            r0 = r1
        L2c:
            r1 = r2[r6]
            ir.nasim.AbstractC13042fc3.f(r1)
            java.lang.Comparable r1 = (java.lang.Comparable) r1
            r2 = r2[r0]
            ir.nasim.AbstractC13042fc3.f(r2)
            int r1 = r1.compareTo(r2)
            if (r1 > 0) goto L3f
            return
        L3f:
            r5.m(r6, r0)
            r6 = r0
            goto L0
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C11954dp7.k(int):void");
    }

    private final void l(int i) {
        while (i > 0) {
            InterfaceC12567ep7[] interfaceC12567ep7Arr = this.a;
            AbstractC13042fc3.f(interfaceC12567ep7Arr);
            int i2 = (i - 1) / 2;
            InterfaceC12567ep7 interfaceC12567ep7 = interfaceC12567ep7Arr[i2];
            AbstractC13042fc3.f(interfaceC12567ep7);
            InterfaceC12567ep7 interfaceC12567ep72 = interfaceC12567ep7Arr[i];
            AbstractC13042fc3.f(interfaceC12567ep72);
            if (((Comparable) interfaceC12567ep7).compareTo(interfaceC12567ep72) <= 0) {
                return;
            }
            m(i, i2);
            i = i2;
        }
    }

    private final void m(int i, int i2) {
        InterfaceC12567ep7[] interfaceC12567ep7Arr = this.a;
        AbstractC13042fc3.f(interfaceC12567ep7Arr);
        InterfaceC12567ep7 interfaceC12567ep7 = interfaceC12567ep7Arr[i2];
        AbstractC13042fc3.f(interfaceC12567ep7);
        InterfaceC12567ep7 interfaceC12567ep72 = interfaceC12567ep7Arr[i];
        AbstractC13042fc3.f(interfaceC12567ep72);
        interfaceC12567ep7Arr[i] = interfaceC12567ep7;
        interfaceC12567ep7Arr[i2] = interfaceC12567ep72;
        interfaceC12567ep7.setIndex(i);
        interfaceC12567ep72.setIndex(i2);
    }

    public final void a(InterfaceC12567ep7 interfaceC12567ep7) {
        interfaceC12567ep7.i(this);
        InterfaceC12567ep7[] interfaceC12567ep7ArrF = f();
        int iC = c();
        j(iC + 1);
        interfaceC12567ep7ArrF[iC] = interfaceC12567ep7;
        interfaceC12567ep7.setIndex(iC);
        l(iC);
    }

    public final InterfaceC12567ep7 b() {
        InterfaceC12567ep7[] interfaceC12567ep7Arr = this.a;
        if (interfaceC12567ep7Arr != null) {
            return interfaceC12567ep7Arr[0];
        }
        return null;
    }

    public final int c() {
        return b.get(this);
    }

    public final boolean d() {
        return c() == 0;
    }

    public final InterfaceC12567ep7 e() {
        InterfaceC12567ep7 interfaceC12567ep7B;
        synchronized (this) {
            interfaceC12567ep7B = b();
        }
        return interfaceC12567ep7B;
    }

    public final boolean g(InterfaceC12567ep7 interfaceC12567ep7) {
        boolean z;
        synchronized (this) {
            if (interfaceC12567ep7.h() == null) {
                z = false;
            } else {
                h(interfaceC12567ep7.getIndex());
                z = true;
            }
        }
        return z;
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x003a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final ir.nasim.InterfaceC12567ep7 h(int r6) {
        /*
            r5 = this;
            ir.nasim.ep7[] r0 = r5.a
            ir.nasim.AbstractC13042fc3.f(r0)
            int r1 = r5.c()
            r2 = -1
            int r1 = r1 + r2
            r5.j(r1)
            int r1 = r5.c()
            if (r6 >= r1) goto L3d
            int r1 = r5.c()
            r5.m(r6, r1)
            int r1 = r6 + (-1)
            int r1 = r1 / 2
            if (r6 <= 0) goto L3a
            r3 = r0[r6]
            ir.nasim.AbstractC13042fc3.f(r3)
            java.lang.Comparable r3 = (java.lang.Comparable) r3
            r4 = r0[r1]
            ir.nasim.AbstractC13042fc3.f(r4)
            int r3 = r3.compareTo(r4)
            if (r3 >= 0) goto L3a
            r5.m(r6, r1)
            r5.l(r1)
            goto L3d
        L3a:
            r5.k(r6)
        L3d:
            int r6 = r5.c()
            r6 = r0[r6]
            ir.nasim.AbstractC13042fc3.f(r6)
            r1 = 0
            r6.i(r1)
            r6.setIndex(r2)
            int r2 = r5.c()
            r0[r2] = r1
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C11954dp7.h(int):ir.nasim.ep7");
    }

    public final InterfaceC12567ep7 i() {
        InterfaceC12567ep7 interfaceC12567ep7H;
        synchronized (this) {
            interfaceC12567ep7H = c() > 0 ? h(0) : null;
        }
        return interfaceC12567ep7H;
    }
}
