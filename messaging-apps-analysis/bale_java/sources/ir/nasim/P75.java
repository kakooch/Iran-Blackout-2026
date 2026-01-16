package ir.nasim;

import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

/* loaded from: classes4.dex */
public final class P75 implements ir.nasim.contact.data.d {
    private final String b;
    private final C16432lG2 c;
    private List d;

    public interface a {
        P75 a(String str);
    }

    static final class b extends AbstractC22163um1 {
        Object a;
        /* synthetic */ Object b;
        int d;

        b(InterfaceC20295rm1 interfaceC20295rm1) {
            super(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            this.b = obj;
            this.d |= RecyclerView.UNDEFINED_DURATION;
            return P75.this.d(this);
        }
    }

    static final class c extends AbstractC22163um1 {
        /* synthetic */ Object a;
        int c;

        c(InterfaceC20295rm1 interfaceC20295rm1) {
            super(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            this.a = obj;
            this.c |= RecyclerView.UNDEFINED_DURATION;
            return P75.this.e(this);
        }
    }

    static final class d extends AbstractC22163um1 {
        int a;
        int b;
        /* synthetic */ Object c;
        int e;

        d(InterfaceC20295rm1 interfaceC20295rm1) {
            super(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            this.c = obj;
            this.e |= RecyclerView.UNDEFINED_DURATION;
            return P75.this.a(0, 0, this);
        }
    }

    public P75(String str, C16432lG2 c16432lG2) {
        AbstractC13042fc3.i(c16432lG2, "getPhoneContactUseCase");
        this.b = str;
        this.c = c16432lG2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object d(ir.nasim.InterfaceC20295rm1 r5) {
        /*
            r4 = this;
            boolean r0 = r5 instanceof ir.nasim.P75.b
            if (r0 == 0) goto L13
            r0 = r5
            ir.nasim.P75$b r0 = (ir.nasim.P75.b) r0
            int r1 = r0.d
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.d = r1
            goto L18
        L13:
            ir.nasim.P75$b r0 = new ir.nasim.P75$b
            r0.<init>(r5)
        L18:
            java.lang.Object r5 = r0.b
            java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
            int r2 = r0.d
            r3 = 1
            if (r2 == 0) goto L35
            if (r2 != r3) goto L2d
            java.lang.Object r0 = r0.a
            ir.nasim.P75 r0 = (ir.nasim.P75) r0
            ir.nasim.AbstractC10685c16.b(r5)
            goto L48
        L2d:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r0)
            throw r5
        L35:
            ir.nasim.AbstractC10685c16.b(r5)
            java.util.List r5 = r4.d
            if (r5 != 0) goto L4c
            r0.a = r4
            r0.d = r3
            java.lang.Object r5 = r4.e(r0)
            if (r5 != r1) goto L47
            return r1
        L47:
            r0 = r4
        L48:
            java.util.List r5 = (java.util.List) r5
            r0.d = r5
        L4c:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.P75.d(ir.nasim.rm1):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object e(ir.nasim.InterfaceC20295rm1 r7) {
        /*
            r6 = this;
            boolean r0 = r7 instanceof ir.nasim.P75.c
            if (r0 == 0) goto L13
            r0 = r7
            ir.nasim.P75$c r0 = (ir.nasim.P75.c) r0
            int r1 = r0.c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.c = r1
            goto L18
        L13:
            ir.nasim.P75$c r0 = new ir.nasim.P75$c
            r0.<init>(r7)
        L18:
            java.lang.Object r7 = r0.a
            java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
            int r2 = r0.c
            r3 = 1
            if (r2 == 0) goto L31
            if (r2 != r3) goto L29
            ir.nasim.AbstractC10685c16.b(r7)
            goto L41
        L29:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r0)
            throw r7
        L31:
            ir.nasim.AbstractC10685c16.b(r7)
            ir.nasim.lG2 r7 = r6.c
            java.lang.String r2 = r6.b
            r0.c = r3
            java.lang.Object r7 = r7.b(r2, r0)
            if (r7 != r1) goto L41
            return r1
        L41:
            java.lang.Iterable r7 = (java.lang.Iterable) r7
            java.util.ArrayList r0 = new java.util.ArrayList
            r1 = 10
            int r1 = ir.nasim.ZW0.x(r7, r1)
            r0.<init>(r1)
            java.util.Iterator r7 = r7.iterator()
        L52:
            boolean r1 = r7.hasNext()
            if (r1 == 0) goto L73
            java.lang.Object r1 = r7.next()
            ir.nasim.lG2$a r1 = (ir.nasim.C16432lG2.a) r1
            ir.nasim.M75 r2 = new ir.nasim.M75
            long r3 = r1.a()
            java.lang.String r5 = r1.b()
            java.lang.String r1 = r1.c()
            r2.<init>(r3, r5, r1)
            r0.add(r2)
            goto L52
        L73:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.P75.e(ir.nasim.rm1):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // ir.nasim.contact.data.d
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object a(int r5, int r6, ir.nasim.InterfaceC20295rm1 r7) {
        /*
            r4 = this;
            boolean r0 = r7 instanceof ir.nasim.P75.d
            if (r0 == 0) goto L13
            r0 = r7
            ir.nasim.P75$d r0 = (ir.nasim.P75.d) r0
            int r1 = r0.e
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.e = r1
            goto L18
        L13:
            ir.nasim.P75$d r0 = new ir.nasim.P75$d
            r0.<init>(r7)
        L18:
            java.lang.Object r7 = r0.c
            java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
            int r2 = r0.e
            r3 = 1
            if (r2 == 0) goto L35
            if (r2 != r3) goto L2d
            int r6 = r0.b
            int r5 = r0.a
            ir.nasim.AbstractC10685c16.b(r7)
            goto L45
        L2d:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L35:
            ir.nasim.AbstractC10685c16.b(r7)
            r0.a = r5
            r0.b = r6
            r0.e = r3
            java.lang.Object r7 = r4.d(r0)
            if (r7 != r1) goto L45
            return r1
        L45:
            java.util.List r7 = (java.util.List) r7
            boolean r0 = r7.isEmpty()
            if (r0 != 0) goto L62
            int r0 = r7.size()
            if (r5 < r0) goto L54
            goto L62
        L54:
            int r6 = r6 + r5
            int r0 = r7.size()
            int r6 = java.lang.Integer.min(r6, r0)
            java.util.List r5 = r7.subList(r5, r6)
            goto L66
        L62:
            java.util.List r5 = ir.nasim.ZW0.m()
        L66:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.P75.a(int, int, ir.nasim.rm1):java.lang.Object");
    }
}
