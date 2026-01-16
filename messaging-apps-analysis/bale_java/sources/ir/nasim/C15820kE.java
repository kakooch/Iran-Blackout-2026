package ir.nasim;

import androidx.recyclerview.widget.RecyclerView;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.NoWhenBranchMatchedException;

/* renamed from: ir.nasim.kE, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C15820kE {
    private static final a e = new a(null);
    private final AbstractC13778go1 a;
    private final InterfaceC20315ro1 b;
    private final Set c;
    private InterfaceC13730gj3 d;

    /* renamed from: ir.nasim.kE$a */
    private static final class a {
        private a() {
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* renamed from: ir.nasim.kE$b */
    private static final class b {
        public static final b a = new b("IDLE", 0);
        public static final b b = new b("RUNNING", 1);
        public static final b c = new b("COMPLETED", 2);
        private static final /* synthetic */ b[] d;
        private static final /* synthetic */ F92 e;

        static {
            b[] bVarArrA = a();
            d = bVarArrA;
            e = G92.a(bVarArrA);
        }

        private b(String str, int i) {
        }

        private static final /* synthetic */ b[] a() {
            return new b[]{a, b, c};
        }

        public static b valueOf(String str) {
            return (b) Enum.valueOf(b.class, str);
        }

        public static b[] values() {
            return (b[]) d.clone();
        }
    }

    /* renamed from: ir.nasim.kE$c */
    public /* synthetic */ class c {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[b.values().length];
            try {
                iArr[b.a.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[b.b.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[b.c.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            a = iArr;
        }
    }

    /* renamed from: ir.nasim.kE$d */
    public static final class d implements Comparator {
        @Override // java.util.Comparator
        public final int compare(Object obj, Object obj2) {
            return AbstractC18050o01.d(Integer.valueOf(((InterfaceC14631iE) obj2).getPriority().j()), Integer.valueOf(((InterfaceC14631iE) obj).getPriority().j()));
        }
    }

    /* renamed from: ir.nasim.kE$e */
    static final class e extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;

        e(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C15820kE.this.new e(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                C15820kE c15820kE = C15820kE.this;
                this.b = 1;
                if (c15820kE.i(this) == objE) {
                    return objE;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
            }
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((e) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.kE$f */
    static final class f extends AbstractC22163um1 {
        Object a;
        Object b;
        Object c;
        Object d;
        /* synthetic */ Object e;
        int g;

        f(InterfaceC20295rm1 interfaceC20295rm1) {
            super(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            this.e = obj;
            this.g |= RecyclerView.UNDEFINED_DURATION;
            return C15820kE.this.g(null, null, this);
        }
    }

    /* renamed from: ir.nasim.kE$g */
    static final class g extends AbstractC19859r37 implements InterfaceC14603iB2 {
        Object b;
        Object c;
        int d;

        g(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C15820kE.this.new g(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Iterator it;
            HashMap map;
            Object objE = AbstractC14862ic3.e();
            int i = this.d;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                HashMap map2 = new HashMap();
                it = C15820kE.this.e().iterator();
                map = map2;
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                it = (Iterator) this.c;
                map = (HashMap) this.b;
                AbstractC10685c16.b(obj);
            }
            while (it.hasNext()) {
                InterfaceC14631iE interfaceC14631iE = (InterfaceC14631iE) it.next();
                C15820kE c15820kE = C15820kE.this;
                this.b = map;
                this.c = it;
                this.d = 1;
                if (c15820kE.g(interfaceC14631iE, map, this) == objE) {
                    return objE;
                }
            }
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((g) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    public C15820kE(AbstractC13778go1 abstractC13778go1, InterfaceC20315ro1 interfaceC20315ro1, Set set) {
        AbstractC13042fc3.i(abstractC13778go1, "ioDispatcher");
        AbstractC13042fc3.i(interfaceC20315ro1, "coroutineScope");
        AbstractC13042fc3.i(set, "initializers");
        this.a = abstractC13778go1;
        this.b = interfaceC20315ro1;
        this.c = set;
    }

    private final InterfaceC14631iE d(Class cls) {
        Object next;
        Iterator it = this.c.iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            if (AbstractC13042fc3.d(((InterfaceC14631iE) next).getClass(), cls)) {
                break;
            }
        }
        return (InterfaceC14631iE) next;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final List e() {
        return AbstractC15401jX0.a1(this.c, new d());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object g(ir.nasim.InterfaceC14631iE r10, java.util.HashMap r11, ir.nasim.InterfaceC20295rm1 r12) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 309
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C15820kE.g(ir.nasim.iE, java.util.HashMap, ir.nasim.rm1):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object i(InterfaceC20295rm1 interfaceC20295rm1) {
        Object objG = AbstractC9323Zl0.g(this.a, new g(null), interfaceC20295rm1);
        return objG == AbstractC14862ic3.e() ? objG : C19938rB7.a;
    }

    private final void j(HashMap map, InterfaceC14631iE interfaceC14631iE, b bVar) {
        b bVar2 = (b) map.get(interfaceC14631iE.getClass());
        int i = c.a[bVar.ordinal()];
        if (i != 1) {
            if (i != 2) {
                if (i != 3) {
                    throw new NoWhenBranchMatchedException();
                }
                if (bVar2 != b.b) {
                    throw new IllegalStateException(("Expected currentState to be RUNNING before transitioning to COMPLETED, but was " + bVar2).toString());
                }
            } else if (bVar2 != null && bVar2 != b.a) {
                throw new IllegalStateException(("Expected currentState to be null or IDLE before transitioning to RUNNING, but was " + bVar2).toString());
            }
        } else if (bVar2 != null) {
            throw new IllegalStateException(("Expected currentState to be null when transitioning to IDLE, but was " + bVar2).toString());
        }
        map.put(interfaceC14631iE.getClass(), bVar);
    }

    public final InterfaceC13730gj3 f() {
        InterfaceC13730gj3 interfaceC13730gj3 = this.d;
        if (interfaceC13730gj3 == null) {
            InterfaceC13730gj3 interfaceC13730gj3D = AbstractC10533bm0.d(this.b, null, null, new e(null), 3, null);
            this.d = interfaceC13730gj3D;
            return interfaceC13730gj3D;
        }
        if (interfaceC13730gj3 != null) {
            return interfaceC13730gj3;
        }
        AbstractC13042fc3.y("initializerJob");
        return null;
    }

    public final void h() {
        Iterator it = e().iterator();
        while (it.hasNext()) {
            ((InterfaceC14631iE) it.next()).d();
        }
    }
}
