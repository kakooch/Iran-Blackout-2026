package ir.nasim;

import androidx.recyclerview.widget.RecyclerView;
import ir.nasim.core.runtime.AccountInfo;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes5.dex */
public final class AK6 {
    private final C15346jR a;
    private final MQ b;

    static final class a extends AbstractC22163um1 {
        Object a;
        long b;
        /* synthetic */ Object c;
        int e;

        a(InterfaceC20295rm1 interfaceC20295rm1) {
            super(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            this.c = obj;
            this.e |= RecyclerView.UNDEFINED_DURATION;
            Object objA = AK6.this.a(0L, null, null, this);
            return objA == AbstractC14862ic3.e() ? objA : C9475a16.a(objA);
        }
    }

    public AK6(C15346jR c15346jR, MQ mq) {
        AbstractC13042fc3.i(c15346jR, "authModule");
        AbstractC13042fc3.i(mq, "authRepository");
        this.a = c15346jR;
        this.b = mq;
    }

    private final boolean b(long j) throws IOException {
        Object obj;
        C13923h3 c13923h3 = C13923h3.a;
        if (!c13923h3.t()) {
            c13923h3.g();
            return false;
        }
        String strB = BK6.b(j);
        List listN = c13923h3.n();
        ArrayList arrayList = new ArrayList(AbstractC10976cX0.x(listN, 10));
        Iterator it = listN.iterator();
        while (it.hasNext()) {
            arrayList.add(BK6.b(((AccountInfo) it.next()).getPhone()));
        }
        Iterator it2 = arrayList.iterator();
        while (true) {
            obj = null;
            if (!it2.hasNext()) {
                break;
            }
            Object next = it2.next();
            if (AbstractC20762sZ6.X((String) next, strB, false, 2, null)) {
                obj = next;
                break;
            }
        }
        return obj != null;
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object a(long r8, java.util.List r10, ir.nasim.SQ r11, ir.nasim.InterfaceC20295rm1 r12) {
        /*
            r7 = this;
            boolean r0 = r12 instanceof ir.nasim.AK6.a
            if (r0 == 0) goto L14
            r0 = r12
            ir.nasim.AK6$a r0 = (ir.nasim.AK6.a) r0
            int r1 = r0.e
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L14
            int r1 = r1 - r2
            r0.e = r1
        L12:
            r6 = r0
            goto L1a
        L14:
            ir.nasim.AK6$a r0 = new ir.nasim.AK6$a
            r0.<init>(r12)
            goto L12
        L1a:
            java.lang.Object r12 = r6.c
            java.lang.Object r0 = ir.nasim.AbstractC13660gc3.e()
            int r1 = r6.e
            r2 = 1
            if (r1 == 0) goto L3f
            if (r1 != r2) goto L37
            long r8 = r6.b
            java.lang.Object r10 = r6.a
            ir.nasim.AK6 r10 = (ir.nasim.AK6) r10
            ir.nasim.AbstractC10685c16.b(r12)
            ir.nasim.a16 r12 = (ir.nasim.C9475a16) r12
            java.lang.Object r11 = r12.l()
            goto L6b
        L37:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L3f:
            ir.nasim.AbstractC10685c16.b(r12)
            boolean r12 = r7.b(r8)
            if (r12 == 0) goto L58
            ir.nasim.a16$a r8 = ir.nasim.C9475a16.b
            ir.nasim.core.PhoneNumberExistException r8 = new ir.nasim.core.PhoneNumberExistException
            r8.<init>()
            java.lang.Object r8 = ir.nasim.AbstractC10685c16.a(r8)
            java.lang.Object r8 = ir.nasim.C9475a16.b(r8)
            return r8
        L58:
            ir.nasim.MQ r1 = r7.b
            r6.a = r7
            r6.b = r8
            r6.e = r2
            r2 = r8
            r4 = r10
            r5 = r11
            java.lang.Object r11 = r1.e(r2, r4, r5, r6)
            if (r11 != r0) goto L6a
            return r0
        L6a:
            r10 = r7
        L6b:
            boolean r12 = ir.nasim.C9475a16.j(r11)
            if (r12 == 0) goto L79
            r12 = r11
            ir.nasim.TQ r12 = (ir.nasim.TQ) r12
            ir.nasim.jR r10 = r10.a
            r10.q(r8)
        L79:
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.AK6.a(long, java.util.List, ir.nasim.SQ, ir.nasim.rm1):java.lang.Object");
    }
}
