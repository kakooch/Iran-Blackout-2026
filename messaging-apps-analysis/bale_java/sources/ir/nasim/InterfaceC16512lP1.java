package ir.nasim;

import androidx.recyclerview.widget.RecyclerView;
import ir.nasim.database.dailogLists.DialogPeerUnreadStateEntity;
import java.util.List;
import java.util.Set;

/* renamed from: ir.nasim.lP1, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public interface InterfaceC16512lP1 {

    /* renamed from: ir.nasim.lP1$a */
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
            return InterfaceC16512lP1.i(InterfaceC16512lP1.this, null, this);
        }
    }

    /* renamed from: ir.nasim.lP1$b */
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
            return InterfaceC16512lP1.e(InterfaceC16512lP1.this, null, this);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00ce  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00fc A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00fd  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x011e  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Type inference failed for: r10v14, types: [java.util.Map] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    static /* synthetic */ java.lang.Object e(ir.nasim.InterfaceC16512lP1 r10, java.util.Set r11, ir.nasim.InterfaceC20295rm1 r12) {
        /*
            Method dump skipped, instructions count: 308
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.InterfaceC16512lP1.e(ir.nasim.lP1, java.util.Set, ir.nasim.rm1):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    static /* synthetic */ java.lang.Object i(ir.nasim.InterfaceC16512lP1 r5, java.util.List r6, ir.nasim.InterfaceC20295rm1 r7) {
        /*
            boolean r0 = r7 instanceof ir.nasim.InterfaceC16512lP1.a
            if (r0 == 0) goto L13
            r0 = r7
            ir.nasim.lP1$a r0 = (ir.nasim.InterfaceC16512lP1.a) r0
            int r1 = r0.e
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.e = r1
            goto L18
        L13:
            ir.nasim.lP1$a r0 = new ir.nasim.lP1$a
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
            ir.nasim.lP1 r6 = (ir.nasim.InterfaceC16512lP1) r6
            ir.nasim.AbstractC10685c16.b(r7)
            goto L57
        L31:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L39:
            ir.nasim.AbstractC10685c16.b(r7)
            r7 = r6
            java.util.Collection r7 = (java.util.Collection) r7
            boolean r7 = r7.isEmpty()
            r7 = r7 ^ r3
            if (r7 == 0) goto L70
            java.lang.Iterable r6 = (java.lang.Iterable) r6
            r7 = 150(0x96, float:2.1E-43)
            java.util.List r6 = ir.nasim.ZW0.h0(r6, r7)
            java.lang.Iterable r6 = (java.lang.Iterable) r6
            java.util.Iterator r6 = r6.iterator()
            r4 = r6
            r6 = r5
            r5 = r4
        L57:
            boolean r7 = r5.hasNext()
            if (r7 == 0) goto L70
            java.lang.Object r7 = r5.next()
            java.util.List r7 = (java.util.List) r7
            r0.a = r6
            r0.b = r5
            r0.e = r3
            java.lang.Object r7 = r6.f(r7, r0)
            if (r7 != r1) goto L57
            return r1
        L70:
            ir.nasim.rB7 r5 = ir.nasim.C19938rB7.a
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.InterfaceC16512lP1.i(ir.nasim.lP1, java.util.List, ir.nasim.rm1):java.lang.Object");
    }

    Object a(InterfaceC20295rm1 interfaceC20295rm1);

    Object b(InterfaceC20295rm1 interfaceC20295rm1);

    Object c(InterfaceC20295rm1 interfaceC20295rm1);

    Object d(DialogPeerUnreadStateEntity dialogPeerUnreadStateEntity, InterfaceC20295rm1 interfaceC20295rm1);

    Object f(List list, InterfaceC20295rm1 interfaceC20295rm1);

    Object g(long j, InterfaceC20295rm1 interfaceC20295rm1);

    default Object h(List list, InterfaceC20295rm1 interfaceC20295rm1) {
        return i(this, list, interfaceC20295rm1);
    }

    InterfaceC4557Fq2 j();

    default Object k(Set set, InterfaceC20295rm1 interfaceC20295rm1) {
        return e(this, set, interfaceC20295rm1);
    }

    Object l(List list, InterfaceC20295rm1 interfaceC20295rm1);
}
