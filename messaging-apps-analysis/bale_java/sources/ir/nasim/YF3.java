package ir.nasim;

import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

/* loaded from: classes5.dex */
public final class YF3 {
    private static final a b = new a(null);
    public static final int c = 8;
    private final InterfaceC7720Sx5 a;

    private static final class a {
        private a() {
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
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
            Object objA = YF3.this.a(null, false, this);
            return objA == AbstractC14862ic3.e() ? objA : C9475a16.a(objA);
        }
    }

    public YF3(InterfaceC7720Sx5 interfaceC7720Sx5) {
        AbstractC13042fc3.i(interfaceC7720Sx5, "updatesProvider");
        this.a = interfaceC7720Sx5;
    }

    public static /* synthetic */ Object b(YF3 yf3, List list, boolean z, InterfaceC20295rm1 interfaceC20295rm1, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        return yf3.a(list, z, interfaceC20295rm1);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object a(java.util.List r11, boolean r12, ir.nasim.InterfaceC20295rm1 r13) {
        /*
            r10 = this;
            boolean r0 = r13 instanceof ir.nasim.YF3.b
            if (r0 == 0) goto L13
            r0 = r13
            ir.nasim.YF3$b r0 = (ir.nasim.YF3.b) r0
            int r1 = r0.d
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.d = r1
            goto L18
        L13:
            ir.nasim.YF3$b r0 = new ir.nasim.YF3$b
            r0.<init>(r13)
        L18:
            java.lang.Object r13 = r0.b
            java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
            int r2 = r0.d
            r3 = 1
            if (r2 == 0) goto L3c
            if (r2 != r3) goto L34
            java.lang.Object r11 = r0.a
            java.util.List r11 = (java.util.List) r11
            ir.nasim.AbstractC10685c16.b(r13)
            ir.nasim.a16 r13 = (ir.nasim.C9475a16) r13
            java.lang.Object r12 = r13.l()
            goto Lcd
        L34:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r12 = "call to 'resume' before 'invoke' with coroutine"
            r11.<init>(r12)
            throw r11
        L3c:
            ir.nasim.AbstractC10685c16.b(r13)
            r13 = r11
            java.lang.Iterable r13 = (java.lang.Iterable) r13
            java.util.ArrayList r2 = new java.util.ArrayList
            r2.<init>()
            java.util.Iterator r4 = r13.iterator()
        L4b:
            boolean r5 = r4.hasNext()
            r6 = 0
            r8 = 0
            if (r5 == 0) goto L70
            java.lang.Object r5 = r4.next()
            ir.nasim.d25 r5 = (ir.nasim.C11458d25) r5
            boolean r9 = r5.C()
            if (r9 != 0) goto L61
            goto L6a
        L61:
            ir.nasim.pD r8 = new ir.nasim.pD
            int r5 = r5.getPeerId()
            r8.<init>(r5, r6)
        L6a:
            if (r8 == 0) goto L4b
            r2.add(r8)
            goto L4b
        L70:
            java.util.ArrayList r4 = new java.util.ArrayList
            r4.<init>()
            java.util.Iterator r13 = r13.iterator()
        L79:
            boolean r5 = r13.hasNext()
            if (r5 == 0) goto L9c
            java.lang.Object r5 = r13.next()
            ir.nasim.d25 r5 = (ir.nasim.C11458d25) r5
            boolean r9 = r5.z()
            if (r9 != 0) goto L8d
            r9 = r8
            goto L96
        L8d:
            ir.nasim.zy r9 = new ir.nasim.zy
            int r5 = r5.getPeerId()
            r9.<init>(r5, r6)
        L96:
            if (r9 == 0) goto L79
            r4.add(r9)
            goto L79
        L9c:
            boolean r13 = r2.isEmpty()
            if (r13 == 0) goto Lb1
            boolean r13 = r4.isEmpty()
            if (r13 == 0) goto Lb1
            ir.nasim.a16$a r11 = ir.nasim.C9475a16.b
            ir.nasim.i18 r11 = ir.nasim.C14505i18.a
            java.lang.Object r11 = ir.nasim.C9475a16.b(r11)
            return r11
        Lb1:
            ir.nasim.Sx5 r13 = r10.a
            java.lang.Object r13 = r13.get()
            ir.nasim.UG7 r13 = (ir.nasim.UG7) r13
            ir.nasim.Nv5 r12 = r13.t0(r2, r4, r12)
            java.lang.String r13 = "loadRequiredPeers(...)"
            ir.nasim.AbstractC13042fc3.h(r12, r13)
            r0.a = r11
            r0.d = r3
            java.lang.Object r12 = ir.nasim.AbstractC6756Ov5.d(r12, r8, r0, r3, r8)
            if (r12 != r1) goto Lcd
            return r1
        Lcd:
            java.lang.Throwable r13 = ir.nasim.C9475a16.e(r12)
            if (r13 == 0) goto Lf2
            int r11 = r11.size()
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "Failed to load peers(size: "
            r0.append(r1)
            r0.append(r11)
            java.lang.String r11 = ")!!"
            r0.append(r11)
            java.lang.String r11 = r0.toString()
            java.lang.String r0 = "LoadPeersUseCase"
            ir.nasim.C19406qI3.c(r0, r11, r13)
        Lf2:
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.YF3.a(java.util.List, boolean, ir.nasim.rm1):java.lang.Object");
    }
}
