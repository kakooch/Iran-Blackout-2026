package ir.nasim;

import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* renamed from: ir.nasim.dG3, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public final class C11590dG3 {
    private final C3558Bj2 a;
    private final HashSet b;
    private final Map c;
    private final InterfaceC9336Zm4 d;

    /* renamed from: ir.nasim.dG3$a */
    static final class a extends AbstractC22163um1 {
        Object a;
        Object b;
        Object c;
        Object d;
        Object e;
        Object f;
        long g;
        /* synthetic */ Object h;
        int j;

        a(InterfaceC20295rm1 interfaceC20295rm1) {
            super(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            this.h = obj;
            this.j |= RecyclerView.UNDEFINED_DURATION;
            return C11590dG3.this.d(null, 0L, null, this);
        }
    }

    public C11590dG3(C3558Bj2 c3558Bj2) {
        AbstractC13042fc3.i(c3558Bj2, "feedRepository");
        this.a = c3558Bj2;
        this.b = new HashSet();
        this.c = new LinkedHashMap();
        this.d = AbstractC12281eL6.a(AbstractC20051rO3.k());
    }

    private final Object e(C11458d25 c11458d25, C8755Xe4 c8755Xe4, long j, InterfaceC20295rm1 interfaceC20295rm1) {
        this.b.add(c8755Xe4);
        return this.a.o(c11458d25, j, c8755Xe4, interfaceC20295rm1);
    }

    public final void a() {
        Object value;
        this.c.clear();
        this.b.clear();
        InterfaceC9336Zm4 interfaceC9336Zm4 = this.d;
        do {
            value = interfaceC9336Zm4.getValue();
        } while (!interfaceC9336Zm4.f(value, AbstractC20051rO3.k()));
    }

    public final void b(C8755Xe4 c8755Xe4, boolean z, List list, String str) {
        Object value;
        AbstractC13042fc3.i(c8755Xe4, "mid");
        AbstractC13042fc3.i(list, "reactions");
        AbstractC13042fc3.i(str, "myReactionCode");
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            C15759k74 c15759k74 = (C15759k74) it.next();
            if (AbstractC13042fc3.d(c15759k74.b(), str)) {
                if (z) {
                    arrayList.add(new C15759k74(c15759k74.b(), c15759k74.a() - 1, false));
                } else {
                    arrayList.add(new C15759k74(c15759k74.b(), c15759k74.a() + 1, true));
                }
            } else if (c15759k74.c()) {
                arrayList.add(new C15759k74(c15759k74.b(), c15759k74.a() - 1, false));
            } else {
                arrayList.add(new C15759k74(c15759k74.b(), c15759k74.a(), false));
            }
        }
        this.c.put(c8755Xe4, arrayList);
        InterfaceC9336Zm4 interfaceC9336Zm4 = this.d;
        do {
            value = interfaceC9336Zm4.getValue();
        } while (!interfaceC9336Zm4.f(value, AbstractC20051rO3.t((Map) value, this.c)));
    }

    public final InterfaceC9336Zm4 c() {
        return this.d;
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x008e A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:22:0x008f  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00a2  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00a5  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0017  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:22:0x008f -> B:23:0x0096). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object d(ir.nasim.C11458d25 r19, long r20, ir.nasim.C8755Xe4 r22, ir.nasim.InterfaceC20295rm1 r23) {
        /*
            r18 = this;
            r0 = r18
            r1 = r23
            boolean r2 = r1 instanceof ir.nasim.C11590dG3.a
            if (r2 == 0) goto L17
            r2 = r1
            ir.nasim.dG3$a r2 = (ir.nasim.C11590dG3.a) r2
            int r3 = r2.j
            r4 = -2147483648(0xffffffff80000000, float:-0.0)
            r5 = r3 & r4
            if (r5 == 0) goto L17
            int r3 = r3 - r4
            r2.j = r3
            goto L1c
        L17:
            ir.nasim.dG3$a r2 = new ir.nasim.dG3$a
            r2.<init>(r1)
        L1c:
            java.lang.Object r1 = r2.h
            java.lang.Object r3 = ir.nasim.AbstractC13660gc3.e()
            int r4 = r2.j
            r5 = 1
            if (r4 == 0) goto L50
            if (r4 != r5) goto L48
            long r6 = r2.g
            java.lang.Object r4 = r2.f
            java.util.Map r4 = (java.util.Map) r4
            java.lang.Object r8 = r2.e
            java.lang.Object r9 = r2.d
            ir.nasim.Zm4 r9 = (ir.nasim.InterfaceC9336Zm4) r9
            java.lang.Object r10 = r2.c
            ir.nasim.Xe4 r10 = (ir.nasim.C8755Xe4) r10
            java.lang.Object r11 = r2.b
            ir.nasim.d25 r11 = (ir.nasim.C11458d25) r11
            java.lang.Object r12 = r2.a
            ir.nasim.dG3 r12 = (ir.nasim.C11590dG3) r12
            ir.nasim.AbstractC10685c16.b(r1)
            r14 = r9
            r15 = r12
            r12 = r6
            goto L96
        L48:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r1.<init>(r2)
            throw r1
        L50:
            ir.nasim.AbstractC10685c16.b(r1)
            java.util.HashSet r1 = r0.b
            r4 = r22
            boolean r1 = r1.contains(r4)
            if (r1 == 0) goto L60
            ir.nasim.rB7 r1 = ir.nasim.C19938rB7.a
            return r1
        L60:
            ir.nasim.Zm4 r1 = r0.d
            r12 = r20
            r15 = r0
            r14 = r1
            r1 = r19
        L68:
            java.lang.Object r11 = r14.getValue()
            r9 = r11
            java.util.Map r9 = (java.util.Map) r9
            r2.a = r15
            r2.b = r1
            r2.c = r4
            r2.d = r14
            r2.e = r11
            r2.f = r9
            r2.g = r12
            r2.j = r5
            r6 = r15
            r7 = r1
            r8 = r4
            r16 = r9
            r9 = r12
            r17 = r11
            r11 = r2
            java.lang.Object r6 = r6.e(r7, r8, r9, r11)
            if (r6 != r3) goto L8f
            return r3
        L8f:
            r11 = r1
            r10 = r4
            r1 = r6
            r4 = r16
            r8 = r17
        L96:
            java.util.Map r1 = (java.util.Map) r1
            java.util.Map r1 = ir.nasim.AbstractC18278oO3.t(r4, r1)
            boolean r1 = r14.f(r8, r1)
            if (r1 == 0) goto La5
            ir.nasim.rB7 r1 = ir.nasim.C19938rB7.a
            return r1
        La5:
            r4 = r10
            r1 = r11
            goto L68
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C11590dG3.d(ir.nasim.d25, long, ir.nasim.Xe4, ir.nasim.rm1):java.lang.Object");
    }
}
