package androidx.compose.foundation.gestures;

import androidx.recyclerview.widget.RecyclerView;
import ir.nasim.AbstractC22163um1;
import ir.nasim.C23864xe6;
import ir.nasim.InterfaceC20295rm1;
import ir.nasim.InterfaceC24572yq4;
import ir.nasim.ZG4;

/* loaded from: classes.dex */
final class e implements InterfaceC24572yq4 {
    private final C23864xe6 a;
    private boolean b;

    static final class a extends AbstractC22163um1 {
        long a;
        /* synthetic */ Object b;
        int d;

        a(InterfaceC20295rm1 interfaceC20295rm1) {
            super(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            this.b = obj;
            this.d |= RecyclerView.UNDEFINED_DURATION;
            return e.this.i0(0L, 0L, this);
        }
    }

    public e(C23864xe6 c23864xe6, boolean z) {
        this.a = c23864xe6;
        this.b = z;
    }

    @Override // ir.nasim.InterfaceC24572yq4
    public long H0(long j, long j2, int i) {
        return this.b ? this.a.v(j2) : ZG4.b.c();
    }

    public final void a(boolean z) {
        this.b = z;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // ir.nasim.InterfaceC24572yq4
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object i0(long r4, long r6, ir.nasim.InterfaceC20295rm1 r8) {
        /*
            r3 = this;
            boolean r4 = r8 instanceof androidx.compose.foundation.gestures.e.a
            if (r4 == 0) goto L13
            r4 = r8
            androidx.compose.foundation.gestures.e$a r4 = (androidx.compose.foundation.gestures.e.a) r4
            int r5 = r4.d
            r0 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r5 & r0
            if (r1 == 0) goto L13
            int r5 = r5 - r0
            r4.d = r5
            goto L18
        L13:
            androidx.compose.foundation.gestures.e$a r4 = new androidx.compose.foundation.gestures.e$a
            r4.<init>(r8)
        L18:
            java.lang.Object r5 = r4.b
            java.lang.Object r8 = ir.nasim.AbstractC13660gc3.e()
            int r0 = r4.d
            r1 = 2
            r2 = 1
            if (r0 == 0) goto L3c
            if (r0 == r2) goto L36
            if (r0 != r1) goto L2e
            long r6 = r4.a
            ir.nasim.AbstractC10685c16.b(r5)
            goto L77
        L2e:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L36:
            long r6 = r4.a
            ir.nasim.AbstractC10685c16.b(r5)
            goto L63
        L3c:
            ir.nasim.AbstractC10685c16.b(r5)
            boolean r5 = r3.b
            if (r5 == 0) goto L82
            boolean r5 = ir.nasim.C9225Za1.b
            if (r5 == 0) goto L6a
            ir.nasim.xe6 r5 = r3.a
            boolean r5 = r5.s()
            if (r5 == 0) goto L56
            ir.nasim.nR7$a r4 = ir.nasim.C17718nR7.b
            long r4 = r4.a()
            goto L7d
        L56:
            ir.nasim.xe6 r5 = r3.a
            r4.a = r6
            r4.d = r2
            java.lang.Object r5 = r5.p(r6, r4)
            if (r5 != r8) goto L63
            return r8
        L63:
            ir.nasim.nR7 r5 = (ir.nasim.C17718nR7) r5
            long r4 = r5.o()
            goto L7d
        L6a:
            ir.nasim.xe6 r5 = r3.a
            r4.a = r6
            r4.d = r1
            java.lang.Object r5 = r5.p(r6, r4)
            if (r5 != r8) goto L77
            return r8
        L77:
            ir.nasim.nR7 r5 = (ir.nasim.C17718nR7) r5
            long r4 = r5.o()
        L7d:
            long r4 = ir.nasim.C17718nR7.k(r6, r4)
            goto L88
        L82:
            ir.nasim.nR7$a r4 = ir.nasim.C17718nR7.b
            long r4 = r4.a()
        L88:
            ir.nasim.nR7 r4 = ir.nasim.C17718nR7.b(r4)
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.e.i0(long, long, ir.nasim.rm1):java.lang.Object");
    }
}
