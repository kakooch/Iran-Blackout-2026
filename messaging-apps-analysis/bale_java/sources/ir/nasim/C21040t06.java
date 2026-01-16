package ir.nasim;

import androidx.recyclerview.widget.RecyclerView;

/* renamed from: ir.nasim.t06, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public final class C21040t06 implements InterfaceC20468s37 {
    public static final int b = C10299bQ2.j;
    private final C10299bQ2 a;

    /* renamed from: ir.nasim.t06$a */
    static final class a extends AbstractC22163um1 {
        Object a;
        Object b;
        Object c;
        Object d;
        /* synthetic */ Object e;
        int g;

        a(InterfaceC20295rm1 interfaceC20295rm1) {
            super(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            this.e = obj;
            this.g |= RecyclerView.UNDEFINED_DURATION;
            return C21040t06.this.a(null, this);
        }
    }

    public C21040t06(C10299bQ2 c10299bQ2) {
        AbstractC13042fc3.i(c10299bQ2, "groupsModule");
        this.a = c10299bQ2;
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x005f  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x008d  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0093  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:20:0x0084 -> B:22:0x0087). Please report as a decompilation issue!!! */
    @Override // ir.nasim.InterfaceC20468s37
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object a(java.util.List r14, ir.nasim.InterfaceC20295rm1 r15) {
        /*
            r13 = this;
            boolean r0 = r15 instanceof ir.nasim.C21040t06.a
            if (r0 == 0) goto L13
            r0 = r15
            ir.nasim.t06$a r0 = (ir.nasim.C21040t06.a) r0
            int r1 = r0.g
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.g = r1
            goto L18
        L13:
            ir.nasim.t06$a r0 = new ir.nasim.t06$a
            r0.<init>(r15)
        L18:
            java.lang.Object r15 = r0.e
            java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
            int r2 = r0.g
            r3 = 0
            r4 = 1
            if (r2 == 0) goto L48
            if (r2 != r4) goto L40
            java.lang.Object r14 = r0.d
            ai.bale.proto.PeersStruct$GroupOutPeer r14 = (ai.bale.proto.PeersStruct$GroupOutPeer) r14
            java.lang.Object r2 = r0.c
            java.util.Iterator r2 = (java.util.Iterator) r2
            java.lang.Object r5 = r0.b
            java.util.ArrayList r5 = (java.util.ArrayList) r5
            java.lang.Object r6 = r0.a
            ir.nasim.t06 r6 = (ir.nasim.C21040t06) r6
            ir.nasim.AbstractC10685c16.b(r15)
            ir.nasim.a16 r15 = (ir.nasim.C9475a16) r15
            java.lang.Object r15 = r15.l()
            goto L87
        L40:
            java.lang.IllegalStateException r14 = new java.lang.IllegalStateException
            java.lang.String r15 = "call to 'resume' before 'invoke' with coroutine"
            r14.<init>(r15)
            throw r14
        L48:
            ir.nasim.AbstractC10685c16.b(r15)
            java.util.ArrayList r15 = new java.util.ArrayList
            r15.<init>()
            java.lang.Iterable r14 = (java.lang.Iterable) r14
            java.util.Iterator r14 = r14.iterator()
            r6 = r13
            r2 = r14
            r5 = r15
        L59:
            boolean r14 = r2.hasNext()
            if (r14 == 0) goto Ld8
            java.lang.Object r14 = r2.next()
            ai.bale.proto.PeersStruct$GroupOutPeer r14 = (ai.bale.proto.PeersStruct$GroupOutPeer) r14
            ir.nasim.bQ2 r15 = r6.a
            ir.nasim.VL3 r15 = r15.Y1()
            int r7 = r14.getGroupId()
            long r7 = (long) r7
            ir.nasim.Nv5 r15 = r15.k(r7)
            if (r15 == 0) goto L59
            r0.a = r6
            r0.b = r5
            r0.c = r2
            r0.d = r14
            r0.g = r4
            java.lang.Object r15 = ir.nasim.AbstractC6756Ov5.d(r15, r3, r0, r4, r3)
            if (r15 != r1) goto L87
            return r1
        L87:
            boolean r7 = ir.nasim.C9475a16.g(r15)
            if (r7 == 0) goto L8e
            r15 = r3
        L8e:
            r12 = r15
            ir.nasim.iO2 r12 = (ir.nasim.C14733iO2) r12
            if (r12 == 0) goto L59
            ir.nasim.f25 r15 = new ir.nasim.f25
            ir.nasim.bZ6 r7 = r12.v()
            java.lang.Object r7 = r7.b()
            java.lang.String r7 = (java.lang.String) r7
            java.lang.String r8 = ""
            if (r7 != 0) goto La5
            r9 = r8
            goto La6
        La5:
            r9 = r7
        La6:
            ir.nasim.bZ6 r7 = r12.w()
            java.lang.Object r7 = r7.b()
            java.lang.String r7 = (java.lang.String) r7
            if (r7 != 0) goto Lb4
            r10 = r8
            goto Lb5
        Lb4:
            r10 = r7
        Lb5:
            ir.nasim.Na3 r7 = r12.u()
            java.lang.Object r7 = r7.b()
            java.lang.String r8 = "get(...)"
            ir.nasim.AbstractC13042fc3.h(r7, r8)
            java.lang.Number r7 = (java.lang.Number) r7
            int r11 = r7.intValue()
            int r14 = r14.getGroupId()
            r7 = r15
            r8 = r9
            r9 = r10
            r10 = r11
            r11 = r14
            r7.<init>(r8, r9, r10, r11, r12)
            r5.add(r15)
            goto L59
        Ld8:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C21040t06.a(java.util.List, ir.nasim.rm1):java.lang.Object");
    }
}
