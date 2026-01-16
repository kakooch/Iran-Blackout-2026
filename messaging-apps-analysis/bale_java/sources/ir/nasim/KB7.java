package ir.nasim;

import androidx.recyclerview.widget.RecyclerView;
import ir.nasim.AbstractC20044rN5;
import ir.nasim.UO1;

/* loaded from: classes5.dex */
public final class KB7 extends AbstractC20044rN5 {
    private final C17024mG3 a;
    private final int b;
    private final UO1.d.a c;

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[EnumC16433lG3.values().length];
            try {
                iArr[EnumC16433lG3.PREPEND.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[EnumC16433lG3.APPEND.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[EnumC16433lG3.REFRESH.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            a = iArr;
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
            return KB7.this.b(null, null, this);
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
            return KB7.this.d(this);
        }
    }

    public KB7(C17024mG3 c17024mG3) {
        AbstractC13042fc3.i(c17024mG3, "loadUnreadDialogsUseCase");
        this.a = c17024mG3;
        this.b = 10;
        this.c = UO1.d.a.d;
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
            boolean r0 = r5 instanceof ir.nasim.KB7.c
            if (r0 == 0) goto L13
            r0 = r5
            ir.nasim.KB7$c r0 = (ir.nasim.KB7.c) r0
            int r1 = r0.c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.c = r1
            goto L18
        L13:
            ir.nasim.KB7$c r0 = new ir.nasim.KB7$c
            r0.<init>(r5)
        L18:
            java.lang.Object r5 = r0.a
            java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
            int r2 = r0.c
            r3 = 1
            if (r2 == 0) goto L31
            if (r2 != r3) goto L29
            ir.nasim.AbstractC10685c16.b(r5)
            goto L3f
        L29:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r0)
            throw r5
        L31:
            ir.nasim.AbstractC10685c16.b(r5)
            ir.nasim.mG3 r5 = r4.a
            r0.c = r3
            java.lang.Object r5 = r5.d(r0)
            if (r5 != r1) goto L3f
            return r1
        L3f:
            ir.nasim.nG3 r5 = (ir.nasim.C17615nG3) r5
            java.util.Set r0 = r5.b()
            boolean r0 = r0.isEmpty()
            if (r0 == 0) goto L51
            ir.nasim.rN5$b$b r5 = new ir.nasim.rN5$b$b
            r5.<init>(r3)
            goto L6c
        L51:
            ir.nasim.rN5$b$a r0 = new ir.nasim.rN5$b$a
            java.util.Set r5 = r5.b()
            java.lang.Iterable r5 = (java.lang.Iterable) r5
            java.lang.Object r5 = ir.nasim.ZW0.r0(r5)
            java.lang.Throwable r5 = (java.lang.Throwable) r5
            if (r5 != 0) goto L68
            java.lang.Throwable r5 = new java.lang.Throwable
            java.lang.String r1 = "Failed to load unread peers!"
            r5.<init>(r1)
        L68:
            r0.<init>(r5)
            r5 = r0
        L6c:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.KB7.d(ir.nasim.rm1):java.lang.Object");
    }

    @Override // ir.nasim.AbstractC20044rN5
    public Object a(InterfaceC20295rm1 interfaceC20295rm1) {
        return AbstractC20044rN5.a.LAUNCH_INITIAL_REFRESH;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // ir.nasim.AbstractC20044rN5
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object b(ir.nasim.EnumC16433lG3 r9, ir.nasim.ZT4 r10, ir.nasim.InterfaceC20295rm1 r11) {
        /*
            Method dump skipped, instructions count: 321
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.KB7.b(ir.nasim.lG3, ir.nasim.ZT4, ir.nasim.rm1):java.lang.Object");
    }
}
