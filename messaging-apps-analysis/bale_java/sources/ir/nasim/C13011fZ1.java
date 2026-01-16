package ir.nasim;

import androidx.recyclerview.widget.RecyclerView;
import ir.nasim.C9475a16;
import ir.nasim.story.data.DownloadCancelCancellationException;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Semaphore;

/* renamed from: ir.nasim.fZ1, reason: case insensitive filesystem */
/* loaded from: classes7.dex */
public final class C13011fZ1 {
    public static final a g = new a(null);
    public static final int h = 8;
    private final InterfaceC12532em2 a;
    private final int b;
    private final Semaphore c;
    private final InterfaceC24075y01 d;
    private final InterfaceC20315ro1 e;
    private final ConcurrentHashMap f;

    /* renamed from: ir.nasim.fZ1$a */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    /* renamed from: ir.nasim.fZ1$b */
    static final class b implements InterfaceC4806Gq2 {
        final /* synthetic */ C12402eZ1 a;
        final /* synthetic */ C11637dL5 b;
        final /* synthetic */ C13011fZ1 c;

        /* renamed from: ir.nasim.fZ1$b$a */
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
                return b.this.a(null, this);
            }
        }

        b(C12402eZ1 c12402eZ1, C11637dL5 c11637dL5, C13011fZ1 c13011fZ1) {
            this.a = c12402eZ1;
            this.b = c11637dL5;
            this.c = c13011fZ1;
        }

        /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
        @Override // ir.nasim.InterfaceC4806Gq2
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object a(ir.nasim.RY1 r9, ir.nasim.InterfaceC20295rm1 r10) {
            /*
                Method dump skipped, instructions count: 366
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C13011fZ1.b.a(ir.nasim.RY1, ir.nasim.rm1):java.lang.Object");
        }
    }

    /* renamed from: ir.nasim.fZ1$c */
    static final class c extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ C12402eZ1 d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(C12402eZ1 c12402eZ1, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = c12402eZ1;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C13011fZ1.this.new c(this.d, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) throws InterruptedException {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            try {
                if (i == 0) {
                    AbstractC10685c16.b(obj);
                    C13011fZ1.this.c.acquire();
                    C13011fZ1 c13011fZ1 = C13011fZ1.this;
                    C12402eZ1 c12402eZ1 = this.d;
                    this.b = 1;
                    if (c13011fZ1.f(c12402eZ1, this) == objE) {
                        return objE;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    AbstractC10685c16.b(obj);
                }
                C13011fZ1.this.c.release();
                return C19938rB7.a;
            } catch (Throwable th) {
                C13011fZ1.this.c.release();
                throw th;
            }
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((c) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    public C13011fZ1(InterfaceC20315ro1 interfaceC20315ro1, AbstractC13778go1 abstractC13778go1, InterfaceC12532em2 interfaceC12532em2, int i, int i2) {
        AbstractC13042fc3.i(interfaceC20315ro1, "coroutineScope");
        AbstractC13042fc3.i(abstractC13778go1, "dispatcher");
        AbstractC13042fc3.i(interfaceC12532em2, "fileRepository");
        this.a = interfaceC12532em2;
        this.b = i2;
        this.c = new Semaphore(i);
        InterfaceC24075y01 interfaceC24075y01B = P17.b(null, 1, null);
        this.d = interfaceC24075y01B;
        this.e = AbstractC20906so1.a(interfaceC20315ro1.getCoroutineContext().X(abstractC13778go1).X(interfaceC24075y01B));
        this.f = new ConcurrentHashMap();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object f(C12402eZ1 c12402eZ1, InterfaceC20295rm1 interfaceC20295rm1) {
        Object objB = this.a.g(c12402eZ1.b(), c12402eZ1.d()).b(new b(c12402eZ1, new C11637dL5(), this), interfaceC20295rm1);
        return objB == AbstractC14862ic3.e() ? objB : C19938rB7.a;
    }

    private final ConcurrentHashMap g(int i) {
        Object objB;
        ConcurrentHashMap concurrentHashMap;
        try {
            C9475a16.a aVar = C9475a16.b;
            if (this.f.contains(Integer.valueOf(i))) {
                Object obj = this.f.get(Integer.valueOf(i));
                AbstractC13042fc3.g(obj, "null cannot be cast to non-null type java.util.concurrent.ConcurrentHashMap<ir.nasim.core.modules.file.entity.FileReference, kotlinx.coroutines.Job>");
                concurrentHashMap = (ConcurrentHashMap) obj;
            } else {
                concurrentHashMap = new ConcurrentHashMap();
            }
            objB = C9475a16.b(concurrentHashMap);
        } catch (Throwable th) {
            C9475a16.a aVar2 = C9475a16.b;
            objB = C9475a16.b(AbstractC10685c16.a(th));
        }
        ConcurrentHashMap concurrentHashMap2 = new ConcurrentHashMap();
        if (C9475a16.g(objB)) {
            objB = concurrentHashMap2;
        }
        return (ConcurrentHashMap) objB;
    }

    public static /* synthetic */ void i(C13011fZ1 c13011fZ1, List list, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = -1;
        }
        c13011fZ1.h(list, i);
    }

    public final void e() {
        AbstractC19067pj3.i(this.d, new DownloadCancelCancellationException());
        C19406qI3.i("DownloaderQueue", "cancelAllDownloads", new Object[0]);
    }

    public final void h(List list, int i) {
        AbstractC13042fc3.i(list, "data");
        Iterator it = list.iterator();
        while (it.hasNext()) {
            C12402eZ1 c12402eZ1 = (C12402eZ1) it.next();
            g(i).put(c12402eZ1.b(), AbstractC10533bm0.d(this.e, null, null, new c(c12402eZ1, null), 3, null));
        }
    }
}
