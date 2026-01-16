package ir.nasim;

import ir.nasim.RY1;
import ir.nasim.core.modules.profile.entity.AvatarImage;

/* renamed from: ir.nasim.uF2, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C21855uF2 {
    private final InterfaceC12532em2 a;
    private final AbstractC13778go1 b;

    /* renamed from: ir.nasim.uF2$a */
    static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
        Object b;
        int c;
        final /* synthetic */ AvatarImage d;
        final /* synthetic */ C21855uF2 e;

        /* renamed from: ir.nasim.uF2$a$a, reason: collision with other inner class name */
        static final class C1629a extends AbstractC19859r37 implements InterfaceC14603iB2 {
            int b;
            /* synthetic */ Object c;

            C1629a(InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
            }

            @Override // ir.nasim.E90
            public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                C1629a c1629a = new C1629a(interfaceC20295rm1);
                c1629a.c = obj;
                return c1629a;
            }

            @Override // ir.nasim.E90
            public final Object invokeSuspend(Object obj) {
                AbstractC14862ic3.e();
                if (this.b != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
                RY1 ry1 = (RY1) this.c;
                return AbstractC6392Nk0.a((ry1 instanceof RY1.a) || (ry1 instanceof RY1.c));
            }

            @Override // ir.nasim.InterfaceC14603iB2
            /* renamed from: n, reason: merged with bridge method [inline-methods] */
            public final Object invoke(RY1 ry1, InterfaceC20295rm1 interfaceC20295rm1) {
                return ((C1629a) create(ry1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(AvatarImage avatarImage, C21855uF2 c21855uF2, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = avatarImage;
            this.e = c21855uF2;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return new a(this.d, this.e, interfaceC20295rm1);
        }

        /* JADX WARN: Removed duplicated region for block: B:18:0x0069  */
        /* JADX WARN: Removed duplicated region for block: B:19:0x006c  */
        /* JADX WARN: Removed duplicated region for block: B:21:0x006f  */
        /* JADX WARN: Removed duplicated region for block: B:23:? A[RETURN, SYNTHETIC] */
        @Override // ir.nasim.E90
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r13) {
            /*
                r12 = this;
                java.lang.Object r0 = ir.nasim.AbstractC13660gc3.e()
                int r1 = r12.c
                r2 = 1
                r3 = 2
                r4 = 0
                if (r1 == 0) goto L23
                if (r1 == r2) goto L1b
                if (r1 != r3) goto L13
                ir.nasim.AbstractC10685c16.b(r13)
                goto L63
            L13:
                java.lang.IllegalStateException r13 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r13.<init>(r0)
                throw r13
            L1b:
                java.lang.Object r1 = r12.b
                ir.nasim.core.modules.file.entity.FileReference r1 = (ir.nasim.core.modules.file.entity.FileReference) r1
                ir.nasim.AbstractC10685c16.b(r13)
                goto L48
            L23:
                ir.nasim.AbstractC10685c16.b(r13)
                ir.nasim.core.modules.profile.entity.AvatarImage r13 = r12.d
                ir.nasim.core.modules.file.entity.FileReference r1 = r13.getFileReference()
                java.lang.String r13 = "getFileReference(...)"
                ir.nasim.AbstractC13042fc3.h(r1, r13)
                ir.nasim.uF2 r13 = r12.e
                ir.nasim.em2 r5 = ir.nasim.C21855uF2.a(r13)
                r12.b = r1
                r12.c = r2
                r7 = 0
                r8 = 0
                r10 = 4
                r11 = 0
                r6 = r1
                r9 = r12
                java.lang.Object r13 = ir.nasim.InterfaceC12532em2.a(r5, r6, r7, r8, r9, r10, r11)
                if (r13 != r0) goto L48
                return r0
            L48:
                ir.nasim.uF2 r13 = r12.e
                ir.nasim.em2 r13 = ir.nasim.C21855uF2.a(r13)
                r2 = 0
                ir.nasim.Fq2 r13 = ir.nasim.InterfaceC12532em2.i(r13, r1, r2, r3, r4)
                ir.nasim.uF2$a$a r1 = new ir.nasim.uF2$a$a
                r1.<init>(r4)
                r12.b = r4
                r12.c = r3
                java.lang.Object r13 = ir.nasim.AbstractC6459Nq2.J(r13, r1, r12)
                if (r13 != r0) goto L63
                return r0
            L63:
                ir.nasim.RY1 r13 = (ir.nasim.RY1) r13
                boolean r0 = r13 instanceof ir.nasim.RY1.a
                if (r0 == 0) goto L6c
                ir.nasim.RY1$a r13 = (ir.nasim.RY1.a) r13
                goto L6d
            L6c:
                r13 = r4
            L6d:
                if (r13 == 0) goto L73
                ir.nasim.Am2 r4 = r13.a()
            L73:
                return r4
            */
            throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C21855uF2.a.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((a) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    public C21855uF2(InterfaceC12532em2 interfaceC12532em2, AbstractC13778go1 abstractC13778go1) {
        AbstractC13042fc3.i(interfaceC12532em2, "fileRepository");
        AbstractC13042fc3.i(abstractC13778go1, "ioDispatcher");
        this.a = interfaceC12532em2;
        this.b = abstractC13778go1;
    }

    public final Object b(AvatarImage avatarImage, InterfaceC20295rm1 interfaceC20295rm1) {
        return AbstractC9323Zl0.g(this.b, new a(avatarImage, this, null), interfaceC20295rm1);
    }
}
