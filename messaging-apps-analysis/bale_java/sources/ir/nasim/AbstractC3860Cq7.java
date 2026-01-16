package ir.nasim;

import androidx.recyclerview.widget.RecyclerView;
import kotlinx.coroutines.TimeoutCancellationException;

/* renamed from: ir.nasim.Cq7, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public abstract class AbstractC3860Cq7 {

    /* renamed from: ir.nasim.Cq7$a */
    static final class a extends AbstractC22163um1 {
        long a;
        Object b;
        Object c;
        /* synthetic */ Object d;
        int e;

        a(InterfaceC20295rm1 interfaceC20295rm1) {
            super(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            this.d = obj;
            this.e |= RecyclerView.UNDEFINED_DURATION;
            return AbstractC3860Cq7.e(0L, null, this);
        }
    }

    public static final TimeoutCancellationException a(long j, GG1 gg1, InterfaceC13730gj3 interfaceC13730gj3) {
        return new TimeoutCancellationException("Timed out waiting for " + j + " ms", interfaceC13730gj3);
    }

    private static final Object b(RunnableC3387Aq7 runnableC3387Aq7, InterfaceC14603iB2 interfaceC14603iB2) {
        AbstractC19067pj3.m(runnableC3387Aq7, HG1.d(runnableC3387Aq7.d.getContext()).J(runnableC3387Aq7.e, runnableC3387Aq7, runnableC3387Aq7.getContext()));
        return AbstractC13419gB7.c(runnableC3387Aq7, runnableC3387Aq7, interfaceC14603iB2);
    }

    public static final Object c(long j, InterfaceC14603iB2 interfaceC14603iB2, InterfaceC20295rm1 interfaceC20295rm1) {
        if (j <= 0) {
            throw new TimeoutCancellationException("Timed out immediately");
        }
        Object objB = b(new RunnableC3387Aq7(j, interfaceC20295rm1), interfaceC14603iB2);
        if (objB == AbstractC14862ic3.e()) {
            WA1.c(interfaceC20295rm1);
        }
        return objB;
    }

    public static final Object d(long j, InterfaceC14603iB2 interfaceC14603iB2, InterfaceC20295rm1 interfaceC20295rm1) {
        return c(HG1.e(j), interfaceC14603iB2, interfaceC20295rm1);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object e(long r7, ir.nasim.InterfaceC14603iB2 r9, ir.nasim.InterfaceC20295rm1 r10) {
        /*
            boolean r0 = r10 instanceof ir.nasim.AbstractC3860Cq7.a
            if (r0 == 0) goto L13
            r0 = r10
            ir.nasim.Cq7$a r0 = (ir.nasim.AbstractC3860Cq7.a) r0
            int r1 = r0.e
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.e = r1
            goto L18
        L13:
            ir.nasim.Cq7$a r0 = new ir.nasim.Cq7$a
            r0.<init>(r10)
        L18:
            java.lang.Object r10 = r0.d
            java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
            int r2 = r0.e
            r3 = 0
            r4 = 1
            if (r2 == 0) goto L3c
            if (r2 != r4) goto L34
            java.lang.Object r7 = r0.c
            ir.nasim.fL5 r7 = (ir.nasim.C12889fL5) r7
            java.lang.Object r8 = r0.b
            ir.nasim.iB2 r8 = (ir.nasim.InterfaceC14603iB2) r8
            ir.nasim.AbstractC10685c16.b(r10)     // Catch: kotlinx.coroutines.TimeoutCancellationException -> L32
            goto L6f
        L32:
            r8 = move-exception
            goto L70
        L34:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L3c:
            ir.nasim.AbstractC10685c16.b(r10)
            r5 = 0
            int r10 = (r7 > r5 ? 1 : (r7 == r5 ? 0 : -1))
            if (r10 > 0) goto L46
            return r3
        L46:
            ir.nasim.fL5 r10 = new ir.nasim.fL5
            r10.<init>()
            r0.b = r9     // Catch: kotlinx.coroutines.TimeoutCancellationException -> L68
            r0.c = r10     // Catch: kotlinx.coroutines.TimeoutCancellationException -> L68
            r0.a = r7     // Catch: kotlinx.coroutines.TimeoutCancellationException -> L68
            r0.e = r4     // Catch: kotlinx.coroutines.TimeoutCancellationException -> L68
            ir.nasim.Aq7 r2 = new ir.nasim.Aq7     // Catch: kotlinx.coroutines.TimeoutCancellationException -> L68
            r2.<init>(r7, r0)     // Catch: kotlinx.coroutines.TimeoutCancellationException -> L68
            r10.a = r2     // Catch: kotlinx.coroutines.TimeoutCancellationException -> L68
            java.lang.Object r7 = b(r2, r9)     // Catch: kotlinx.coroutines.TimeoutCancellationException -> L68
            java.lang.Object r8 = ir.nasim.AbstractC13660gc3.e()     // Catch: kotlinx.coroutines.TimeoutCancellationException -> L68
            if (r7 != r8) goto L6b
            ir.nasim.WA1.c(r0)     // Catch: kotlinx.coroutines.TimeoutCancellationException -> L68
            goto L6b
        L68:
            r8 = move-exception
            r7 = r10
            goto L70
        L6b:
            if (r7 != r1) goto L6e
            return r1
        L6e:
            r10 = r7
        L6f:
            return r10
        L70:
            ir.nasim.gj3 r9 = r8.coroutine
            java.lang.Object r7 = r7.a
            if (r9 != r7) goto L77
            return r3
        L77:
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.AbstractC3860Cq7.e(long, ir.nasim.iB2, ir.nasim.rm1):java.lang.Object");
    }
}
