package ir.nasim;

import androidx.recyclerview.widget.RecyclerView;
import ir.nasim.database.dailogLists.DialogEntity;
import ir.nasim.database.dailogLists.DialogLastMessage;
import java.util.List;

/* loaded from: classes5.dex */
public abstract class HM1 {

    static final class a extends AbstractC22163um1 {
        Object a;
        Object b;
        /* synthetic */ Object c;
        int e;

        a(InterfaceC20295rm1 interfaceC20295rm1) {
            super(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            this.c = obj;
            this.e |= RecyclerView.UNDEFINED_DURATION;
            return HM1.d(HM1.this, null, this);
        }
    }

    static final class b extends AbstractC22163um1 {
        Object a;
        Object b;
        /* synthetic */ Object c;
        int e;

        b(InterfaceC20295rm1 interfaceC20295rm1) {
            super(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            this.c = obj;
            this.e |= RecyclerView.UNDEFINED_DURATION;
            return HM1.c(HM1.this, null, this);
        }
    }

    static final class c extends AbstractC22163um1 {
        Object a;
        Object b;
        Object c;
        /* synthetic */ Object d;
        int f;

        c(InterfaceC20295rm1 interfaceC20295rm1) {
            super(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            this.d = obj;
            this.f |= RecyclerView.UNDEFINED_DURATION;
            return HM1.i(HM1.this, null, this);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x0080  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0017  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    static /* synthetic */ java.lang.Object c(ir.nasim.HM1 r35, ir.nasim.database.dailogLists.DialogEntity r36, ir.nasim.InterfaceC20295rm1 r37) {
        /*
            Method dump skipped, instructions count: 270
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.HM1.c(ir.nasim.HM1, ir.nasim.database.dailogLists.DialogEntity, ir.nasim.rm1):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    static /* synthetic */ java.lang.Object d(ir.nasim.HM1 r5, java.util.List r6, ir.nasim.InterfaceC20295rm1 r7) {
        /*
            boolean r0 = r7 instanceof ir.nasim.HM1.a
            if (r0 == 0) goto L13
            r0 = r7
            ir.nasim.HM1$a r0 = (ir.nasim.HM1.a) r0
            int r1 = r0.e
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.e = r1
            goto L18
        L13:
            ir.nasim.HM1$a r0 = new ir.nasim.HM1$a
            r0.<init>(r7)
        L18:
            java.lang.Object r7 = r0.c
            java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
            int r2 = r0.e
            r3 = 1
            if (r2 == 0) goto L39
            if (r2 != r3) goto L31
            java.lang.Object r5 = r0.b
            java.util.Iterator r5 = (java.util.Iterator) r5
            java.lang.Object r6 = r0.a
            ir.nasim.HM1 r6 = (ir.nasim.HM1) r6
            ir.nasim.AbstractC10685c16.b(r7)
            goto L45
        L31:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L39:
            ir.nasim.AbstractC10685c16.b(r7)
            java.lang.Iterable r6 = (java.lang.Iterable) r6
            java.util.Iterator r6 = r6.iterator()
            r4 = r6
            r6 = r5
            r5 = r4
        L45:
            boolean r7 = r5.hasNext()
            if (r7 == 0) goto L5e
            java.lang.Object r7 = r5.next()
            ir.nasim.database.dailogLists.DialogEntity r7 = (ir.nasim.database.dailogLists.DialogEntity) r7
            r0.a = r6
            r0.b = r5
            r0.e = r3
            java.lang.Object r7 = r6.a(r7, r0)
            if (r7 != r1) goto L45
            return r1
        L5e:
            ir.nasim.rB7 r5 = ir.nasim.C19938rB7.a
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.HM1.d(ir.nasim.HM1, java.util.List, ir.nasim.rm1):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x006c  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0091  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x009f  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:25:0x0081 -> B:12:0x0037). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    static /* synthetic */ java.lang.Object i(ir.nasim.HM1 r6, java.util.List r7, ir.nasim.InterfaceC20295rm1 r8) {
        /*
            boolean r0 = r8 instanceof ir.nasim.HM1.c
            if (r0 == 0) goto L13
            r0 = r8
            ir.nasim.HM1$c r0 = (ir.nasim.HM1.c) r0
            int r1 = r0.f
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f = r1
            goto L18
        L13:
            ir.nasim.HM1$c r0 = new ir.nasim.HM1$c
            r0.<init>(r8)
        L18:
            java.lang.Object r8 = r0.d
            java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
            int r2 = r0.f
            r3 = 1
            if (r2 == 0) goto L41
            if (r2 != r3) goto L39
            java.lang.Object r6 = r0.c
            java.util.Iterator r6 = (java.util.Iterator) r6
            java.lang.Object r7 = r0.b
            java.util.Set r7 = (java.util.Set) r7
            java.lang.Object r2 = r0.a
            ir.nasim.HM1 r2 = (ir.nasim.HM1) r2
            ir.nasim.AbstractC10685c16.b(r8)
            r5 = r0
            r0 = r7
            r7 = r2
        L37:
            r2 = r5
            goto L85
        L39:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L41:
            ir.nasim.AbstractC10685c16.b(r8)
            boolean r8 = r7.isEmpty()
            if (r8 == 0) goto L4f
            java.util.List r6 = ir.nasim.ZW0.m()
            return r6
        L4f:
            java.lang.Iterable r7 = (java.lang.Iterable) r7
            java.util.Set r8 = ir.nasim.ZW0.q1(r7)
            ir.nasim.wp6 r7 = ir.nasim.ZW0.g0(r7)
            r2 = 150(0x96, float:2.1E-43)
            ir.nasim.wp6 r7 = ir.nasim.AbstractC8856Xp6.m(r7, r2)
            java.util.Iterator r7 = r7.iterator()
            r5 = r7
            r7 = r6
            r6 = r5
        L66:
            boolean r2 = r6.hasNext()
            if (r2 == 0) goto L9f
            java.lang.Object r2 = r6.next()
            java.util.List r2 = (java.util.List) r2
            r0.a = r7
            r0.b = r8
            r0.c = r6
            r0.f = r3
            java.lang.Object r2 = r7.k(r2, r0)
            if (r2 != r1) goto L81
            return r1
        L81:
            r5 = r0
            r0 = r8
            r8 = r2
            goto L37
        L85:
            java.util.List r8 = (java.util.List) r8
            r4 = r8
            java.util.Collection r4 = (java.util.Collection) r4
            boolean r4 = r4.isEmpty()
            r4 = r4 ^ r3
            if (r4 == 0) goto L9c
            java.lang.Iterable r8 = (java.lang.Iterable) r8
            java.util.Set r8 = ir.nasim.ZW0.r1(r8)
            java.util.Collection r8 = (java.util.Collection) r8
            r0.removeAll(r8)
        L9c:
            r8 = r0
            r0 = r2
            goto L66
        L9f:
            java.lang.Iterable r8 = (java.lang.Iterable) r8
            java.util.List r6 = ir.nasim.ZW0.m1(r8)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.HM1.i(ir.nasim.HM1, java.util.List, ir.nasim.rm1):java.lang.Object");
    }

    public static /* synthetic */ Object s(HM1 hm1, long j, String str, boolean z, boolean z2, boolean z3, InterfaceC20295rm1 interfaceC20295rm1, int i, Object obj) {
        if (obj == null) {
            return hm1.r(j, str, z, z2, (i & 16) != 0 ? false : z3, interfaceC20295rm1);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: updateDialogDetails");
    }

    public Object a(DialogEntity dialogEntity, InterfaceC20295rm1 interfaceC20295rm1) {
        return c(this, dialogEntity, interfaceC20295rm1);
    }

    public Object b(List list, InterfaceC20295rm1 interfaceC20295rm1) {
        return d(this, list, interfaceC20295rm1);
    }

    public abstract Object e(long j, InterfaceC20295rm1 interfaceC20295rm1);

    public abstract Object f(InterfaceC20295rm1 interfaceC20295rm1);

    public abstract Object g(long j, InterfaceC20295rm1 interfaceC20295rm1);

    public Object h(List list, InterfaceC20295rm1 interfaceC20295rm1) {
        return i(this, list, interfaceC20295rm1);
    }

    public abstract Object j(long j, InterfaceC20295rm1 interfaceC20295rm1);

    public abstract Object k(List list, InterfaceC20295rm1 interfaceC20295rm1);

    public abstract Object l(long j, InterfaceC20295rm1 interfaceC20295rm1);

    public abstract Object m(long j, InterfaceC20295rm1 interfaceC20295rm1);

    public abstract Object n(List list, InterfaceC20295rm1 interfaceC20295rm1);

    public abstract Object o(List list, InterfaceC20295rm1 interfaceC20295rm1);

    public abstract Object p(DialogEntity dialogEntity, InterfaceC20295rm1 interfaceC20295rm1);

    public abstract Object q(List list, InterfaceC20295rm1 interfaceC20295rm1);

    public abstract Object r(long j, String str, boolean z, boolean z2, boolean z3, InterfaceC20295rm1 interfaceC20295rm1);

    public abstract Object t(long j, String str, Long l, InterfaceC20295rm1 interfaceC20295rm1);

    public abstract Object u(long j, long j2, DialogLastMessage dialogLastMessage, InterfaceC20295rm1 interfaceC20295rm1);

    public abstract Object v(long j, int i, InterfaceC20295rm1 interfaceC20295rm1);

    public abstract Object w(long j, List list, InterfaceC20295rm1 interfaceC20295rm1);

    public abstract Object x(long j, List list, InterfaceC20295rm1 interfaceC20295rm1);
}
