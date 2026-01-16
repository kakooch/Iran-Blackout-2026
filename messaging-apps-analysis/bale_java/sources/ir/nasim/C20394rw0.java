package ir.nasim;

import androidx.recyclerview.widget.RecyclerView;
import ir.nasim.AbstractC20044rN5;

/* renamed from: ir.nasim.rw0, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C20394rw0 extends AbstractC20044rN5 {
    public static final a d = new a(null);
    public static final int e = 8;
    private final A08 a;
    private final InterfaceC13266fw0 b;
    private int c;

    /* renamed from: ir.nasim.rw0$a */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    /* renamed from: ir.nasim.rw0$b */
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
            return C20394rw0.this.b(null, null, this);
        }
    }

    public C20394rw0(A08 a08, InterfaceC13266fw0 interfaceC13266fw0) {
        AbstractC13042fc3.i(a08, "voiceCallModule");
        AbstractC13042fc3.i(interfaceC13266fw0, "callLogDao");
        this.a = a08;
        this.b = interfaceC13266fw0;
        this.c = 1;
    }

    @Override // ir.nasim.AbstractC20044rN5
    public Object a(InterfaceC20295rm1 interfaceC20295rm1) {
        return AbstractC20044rN5.a.LAUNCH_INITIAL_REFRESH;
    }

    /* JADX WARN: Removed duplicated region for block: B:41:0x008e A[Catch: IOException -> 0x0041, TryCatch #0 {IOException -> 0x0041, blocks: (B:15:0x003c, B:66:0x0136, B:67:0x0158, B:22:0x0050, B:50:0x00d3, B:52:0x00de, B:56:0x0106, B:58:0x010a, B:60:0x011c, B:65:0x0134, B:25:0x005f, B:47:0x00c1, B:28:0x006b, B:37:0x0086, B:39:0x008a, B:41:0x008e, B:43:0x0094, B:31:0x0072, B:33:0x0076), top: B:71:0x002a }] */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0094 A[Catch: IOException -> 0x0041, TryCatch #0 {IOException -> 0x0041, blocks: (B:15:0x003c, B:66:0x0136, B:67:0x0158, B:22:0x0050, B:50:0x00d3, B:52:0x00de, B:56:0x0106, B:58:0x010a, B:60:0x011c, B:65:0x0134, B:25:0x005f, B:47:0x00c1, B:28:0x006b, B:37:0x0086, B:39:0x008a, B:41:0x008e, B:43:0x0094, B:31:0x0072, B:33:0x0076), top: B:71:0x002a }] */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00d2 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:52:0x00de A[Catch: IOException -> 0x0041, TryCatch #0 {IOException -> 0x0041, blocks: (B:15:0x003c, B:66:0x0136, B:67:0x0158, B:22:0x0050, B:50:0x00d3, B:52:0x00de, B:56:0x0106, B:58:0x010a, B:60:0x011c, B:65:0x0134, B:25:0x005f, B:47:0x00c1, B:28:0x006b, B:37:0x0086, B:39:0x008a, B:41:0x008e, B:43:0x0094, B:31:0x0072, B:33:0x0076), top: B:71:0x002a }] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // ir.nasim.AbstractC20044rN5
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object b(ir.nasim.EnumC16433lG3 r12, ir.nasim.ZT4 r13, ir.nasim.InterfaceC20295rm1 r14) {
        /*
            Method dump skipped, instructions count: 359
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C20394rw0.b(ir.nasim.lG3, ir.nasim.ZT4, ir.nasim.rm1):java.lang.Object");
    }
}
