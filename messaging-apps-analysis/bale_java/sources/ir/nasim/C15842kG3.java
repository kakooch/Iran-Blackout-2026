package ir.nasim;

import androidx.recyclerview.widget.RecyclerView;
import java.util.HashSet;

/* renamed from: ir.nasim.kG3, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public final class C15842kG3 {
    private final C3558Bj2 a;
    private final HashSet b;
    private final InterfaceC9336Zm4 c;

    /* renamed from: ir.nasim.kG3$a */
    static final class a extends AbstractC22163um1 {
        Object a;
        /* synthetic */ Object b;
        int d;

        a(InterfaceC20295rm1 interfaceC20295rm1) {
            super(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            this.b = obj;
            this.d |= RecyclerView.UNDEFINED_DURATION;
            return C15842kG3.this.c(0, null, this);
        }
    }

    /* renamed from: ir.nasim.kG3$b */
    static final class b extends AbstractC22163um1 {
        Object a;
        Object b;
        Object c;
        Object d;
        Object e;
        int f;
        /* synthetic */ Object g;
        int i;

        b(InterfaceC20295rm1 interfaceC20295rm1) {
            super(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            this.g = obj;
            this.i |= RecyclerView.UNDEFINED_DURATION;
            return C15842kG3.this.e(0, null, this);
        }
    }

    public C15842kG3(C3558Bj2 c3558Bj2) {
        AbstractC13042fc3.i(c3558Bj2, "feedRepository");
        this.a = c3558Bj2;
        this.b = new HashSet();
        this.c = AbstractC12281eL6.a(AbstractC20051rO3.k());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object c(int r9, ir.nasim.C8755Xe4 r10, ir.nasim.InterfaceC20295rm1 r11) {
        /*
            r8 = this;
            boolean r0 = r11 instanceof ir.nasim.C15842kG3.a
            if (r0 == 0) goto L14
            r0 = r11
            ir.nasim.kG3$a r0 = (ir.nasim.C15842kG3.a) r0
            int r1 = r0.d
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L14
            int r1 = r1 - r2
            r0.d = r1
        L12:
            r7 = r0
            goto L1a
        L14:
            ir.nasim.kG3$a r0 = new ir.nasim.kG3$a
            r0.<init>(r11)
            goto L12
        L1a:
            java.lang.Object r11 = r7.b
            java.lang.Object r0 = ir.nasim.AbstractC13660gc3.e()
            int r1 = r7.d
            r2 = 1
            if (r1 == 0) goto L38
            if (r1 != r2) goto L30
            java.lang.Object r9 = r7.a
            r10 = r9
            ir.nasim.Xe4 r10 = (ir.nasim.C8755Xe4) r10
            ir.nasim.AbstractC10685c16.b(r11)
            goto L56
        L30:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r10 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r10)
            throw r9
        L38:
            ir.nasim.AbstractC10685c16.b(r11)
            java.util.HashSet r11 = r8.b
            r11.add(r10)
            ir.nasim.Bj2 r1 = r8.a
            long r3 = r10.i()
            long r5 = r10.h()
            r7.a = r10
            r7.d = r2
            r2 = r9
            java.lang.Object r11 = r1.n(r2, r3, r5, r7)
            if (r11 != r0) goto L56
            return r0
        L56:
            java.util.List r11 = (java.util.List) r11
            ir.nasim.XV4 r9 = ir.nasim.AbstractC4616Fw7.a(r10, r11)
            java.util.Map r9 = ir.nasim.AbstractC18278oO3.g(r9)
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C15842kG3.c(int, ir.nasim.Xe4, ir.nasim.rm1):java.lang.Object");
    }

    public final void b() {
        Object value;
        this.b.clear();
        InterfaceC9336Zm4 interfaceC9336Zm4 = this.c;
        do {
            value = interfaceC9336Zm4.getValue();
        } while (!interfaceC9336Zm4.f(value, AbstractC20051rO3.k()));
    }

    public final InterfaceC9336Zm4 d() {
        return this.c;
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0072 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0073  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0083  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0086  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:22:0x0073 -> B:23:0x0077). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object e(int r9, ir.nasim.C8755Xe4 r10, ir.nasim.InterfaceC20295rm1 r11) {
        /*
            r8 = this;
            boolean r0 = r11 instanceof ir.nasim.C15842kG3.b
            if (r0 == 0) goto L13
            r0 = r11
            ir.nasim.kG3$b r0 = (ir.nasim.C15842kG3.b) r0
            int r1 = r0.i
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.i = r1
            goto L18
        L13:
            ir.nasim.kG3$b r0 = new ir.nasim.kG3$b
            r0.<init>(r11)
        L18:
            java.lang.Object r11 = r0.g
            java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
            int r2 = r0.i
            r3 = 1
            if (r2 == 0) goto L45
            if (r2 != r3) goto L3d
            int r9 = r0.f
            java.lang.Object r10 = r0.e
            java.util.Map r10 = (java.util.Map) r10
            java.lang.Object r2 = r0.d
            java.lang.Object r4 = r0.c
            ir.nasim.Zm4 r4 = (ir.nasim.InterfaceC9336Zm4) r4
            java.lang.Object r5 = r0.b
            ir.nasim.Xe4 r5 = (ir.nasim.C8755Xe4) r5
            java.lang.Object r6 = r0.a
            ir.nasim.kG3 r6 = (ir.nasim.C15842kG3) r6
            ir.nasim.AbstractC10685c16.b(r11)
            goto L77
        L3d:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r10 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r10)
            throw r9
        L45:
            ir.nasim.AbstractC10685c16.b(r11)
            java.util.HashSet r11 = r8.b
            boolean r11 = r11.contains(r10)
            if (r11 == 0) goto L53
            ir.nasim.rB7 r9 = ir.nasim.C19938rB7.a
            return r9
        L53:
            ir.nasim.Zm4 r11 = r8.c
            r6 = r8
            r4 = r11
        L57:
            java.lang.Object r2 = r4.getValue()
            r11 = r2
            java.util.Map r11 = (java.util.Map) r11
            r0.a = r6
            r0.b = r10
            r0.c = r4
            r0.d = r2
            r0.e = r11
            r0.f = r9
            r0.i = r3
            java.lang.Object r5 = r6.c(r9, r10, r0)
            if (r5 != r1) goto L73
            return r1
        L73:
            r7 = r5
            r5 = r10
            r10 = r11
            r11 = r7
        L77:
            java.util.Map r11 = (java.util.Map) r11
            java.util.Map r10 = ir.nasim.AbstractC18278oO3.t(r10, r11)
            boolean r10 = r4.f(r2, r10)
            if (r10 == 0) goto L86
            ir.nasim.rB7 r9 = ir.nasim.C19938rB7.a
            return r9
        L86:
            r10 = r5
            goto L57
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C15842kG3.e(int, ir.nasim.Xe4, ir.nasim.rm1):java.lang.Object");
    }
}
