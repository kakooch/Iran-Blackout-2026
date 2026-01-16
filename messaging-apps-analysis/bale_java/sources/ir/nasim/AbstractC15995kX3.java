package ir.nasim;

import androidx.recyclerview.widget.RecyclerView;

/* renamed from: ir.nasim.kX3, reason: case insensitive filesystem */
/* loaded from: classes7.dex */
public abstract class AbstractC15995kX3 {
    public static final int c = C14970in2.j | C4471Fg6.p;
    private final C4471Fg6 a;
    private final C20614sJ2 b;

    /* renamed from: ir.nasim.kX3$a */
    static final class a extends AbstractC22163um1 {
        Object a;
        Object b;
        Object c;
        /* synthetic */ Object d;
        int f;

        a(InterfaceC20295rm1 interfaceC20295rm1) {
            super(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            this.d = obj;
            this.f |= RecyclerView.UNDEFINED_DURATION;
            return AbstractC15995kX3.this.b(null, null, this);
        }
    }

    /* renamed from: ir.nasim.kX3$b */
    static final class b extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ C11458d25 d;
        final /* synthetic */ Long e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(C11458d25 c11458d25, Long l, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = c11458d25;
            this.e = l;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return AbstractC15995kX3.this.new b(this.d, this.e, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objD;
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                C4471Fg6 c4471Fg6 = AbstractC15995kX3.this.a;
                C11458d25 c11458d25 = this.d;
                Long l = this.e;
                C6517Nv5 c6517Nv5T = c4471Fg6.T(c11458d25, l != null ? l.longValue() : Long.MAX_VALUE, EnumC19631qg6.b, AbstractC15995kX3.this.c());
                this.b = 1;
                objD = AbstractC6756Ov5.d(c6517Nv5T, null, this, 1, null);
                if (objD == objE) {
                    return objE;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
                objD = ((C9475a16) obj).l();
            }
            return C9475a16.a(objD);
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((b) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    public AbstractC15995kX3(C4471Fg6 c4471Fg6, C20614sJ2 c20614sJ2) {
        AbstractC13042fc3.i(c4471Fg6, "searchModule");
        AbstractC13042fc3.i(c20614sJ2, "mediaMapper");
        this.a = c4471Fg6;
        this.b = c20614sJ2;
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x008d  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00b1  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00b5  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:26:0x00aa -> B:28:0x00ad). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object b(java.lang.Long r8, ir.nasim.C11458d25 r9, ir.nasim.InterfaceC20295rm1 r10) {
        /*
            r7 = this;
            boolean r0 = r10 instanceof ir.nasim.AbstractC15995kX3.a
            if (r0 == 0) goto L13
            r0 = r10
            ir.nasim.kX3$a r0 = (ir.nasim.AbstractC15995kX3.a) r0
            int r1 = r0.f
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f = r1
            goto L18
        L13:
            ir.nasim.kX3$a r0 = new ir.nasim.kX3$a
            r0.<init>(r10)
        L18:
            java.lang.Object r10 = r0.d
            java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
            int r2 = r0.f
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L49
            if (r2 == r4) goto L41
            if (r2 != r3) goto L39
            java.lang.Object r8 = r0.c
            java.util.Iterator r8 = (java.util.Iterator) r8
            java.lang.Object r9 = r0.b
            java.util.Collection r9 = (java.util.Collection) r9
            java.lang.Object r2 = r0.a
            ir.nasim.kX3 r2 = (ir.nasim.AbstractC15995kX3) r2
            ir.nasim.AbstractC10685c16.b(r10)
            goto Lad
        L39:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L41:
            java.lang.Object r8 = r0.a
            ir.nasim.kX3 r8 = (ir.nasim.AbstractC15995kX3) r8
            ir.nasim.AbstractC10685c16.b(r10)
            goto L62
        L49:
            ir.nasim.AbstractC10685c16.b(r10)
            ir.nasim.WM3 r10 = ir.nasim.C12366eV1.c()
            ir.nasim.kX3$b r2 = new ir.nasim.kX3$b
            r5 = 0
            r2.<init>(r9, r8, r5)
            r0.a = r7
            r0.f = r4
            java.lang.Object r10 = ir.nasim.AbstractC9323Zl0.g(r10, r2, r0)
            if (r10 != r1) goto L61
            return r1
        L61:
            r8 = r7
        L62:
            ir.nasim.a16 r10 = (ir.nasim.C9475a16) r10
            java.lang.Object r9 = r10.l()
            boolean r10 = ir.nasim.C9475a16.j(r9)
            if (r10 == 0) goto Lb8
            ir.nasim.v74 r9 = (ir.nasim.C22372v74) r9
            java.util.List r9 = r9.a()
            java.lang.String r10 = "getGlobalSearchEntities(...)"
            ir.nasim.AbstractC13042fc3.h(r9, r10)
            java.lang.Iterable r9 = (java.lang.Iterable) r9
            java.util.ArrayList r10 = new java.util.ArrayList
            r10.<init>()
            java.util.Iterator r9 = r9.iterator()
            r2 = r8
            r8 = r9
            r9 = r10
        L87:
            boolean r10 = r8.hasNext()
            if (r10 == 0) goto Lb5
            java.lang.Object r10 = r8.next()
            ir.nasim.pJ2 r10 = (ir.nasim.C18823pJ2) r10
            ir.nasim.sJ2 r4 = r2.b
            ir.nasim.XV4 r5 = new ir.nasim.XV4
            ir.nasim.Rf6 r6 = r2.c()
            r5.<init>(r6, r10)
            r0.a = r2
            r0.b = r9
            r0.c = r8
            r0.f = r3
            java.lang.Object r10 = r4.a(r5, r0)
            if (r10 != r1) goto Lad
            return r1
        Lad:
            ir.nasim.my6 r10 = (ir.nasim.InterfaceC17445my6) r10
            if (r10 == 0) goto L87
            r9.add(r10)
            goto L87
        Lb5:
            java.util.List r9 = (java.util.List) r9
            return r9
        Lb8:
            java.util.List r8 = ir.nasim.ZW0.m()
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.AbstractC15995kX3.b(java.lang.Long, ir.nasim.d25, ir.nasim.rm1):java.lang.Object");
    }

    public abstract EnumC7325Rf6 c();
}
