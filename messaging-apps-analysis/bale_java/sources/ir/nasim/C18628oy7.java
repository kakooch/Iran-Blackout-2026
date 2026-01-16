package ir.nasim;

import ir.nasim.database.dailogLists.DialogEntity;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/* renamed from: ir.nasim.oy7, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public final class C18628oy7 extends H1 {
    public static final a d = new a(null);
    private final String b;
    private final W24 c;

    /* renamed from: ir.nasim.oy7$a */
    public static final class a {
        private a() {
        }

        public final W24 a(String str, Collection collection) {
            AbstractC13042fc3.i(str, DialogEntity.COLUMN_MESSAGE);
            AbstractC13042fc3.i(collection, "types");
            Collection collection2 = collection;
            ArrayList arrayList = new ArrayList(AbstractC10976cX0.x(collection2, 10));
            Iterator it = collection2.iterator();
            while (it.hasNext()) {
                arrayList.add(((AbstractC4099Dr3) it.next()).o());
            }
            CE6 ce6B = AbstractC20801sd6.b(arrayList);
            W24 w24B = C15266jI0.d.b(str, ce6B);
            return ce6B.size() <= 1 ? w24B : new C18628oy7(str, w24B, null);
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    /* renamed from: ir.nasim.oy7$b */
    static final class b extends AbstractC8614Ws3 implements UA2 {
        public static final b e = new b();

        b() {
            super(1);
        }

        @Override // ir.nasim.UA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final InterfaceC14592iA0 invoke(InterfaceC14592iA0 interfaceC14592iA0) {
            AbstractC13042fc3.i(interfaceC14592iA0, "<this>");
            return interfaceC14592iA0;
        }
    }

    /* renamed from: ir.nasim.oy7$c */
    static final class c extends AbstractC8614Ws3 implements UA2 {
        public static final c e = new c();

        c() {
            super(1);
        }

        @Override // ir.nasim.UA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final InterfaceC14592iA0 invoke(JC6 jc6) {
            AbstractC13042fc3.i(jc6, "<this>");
            return jc6;
        }
    }

    /* renamed from: ir.nasim.oy7$d */
    static final class d extends AbstractC8614Ws3 implements UA2 {
        public static final d e = new d();

        d() {
            super(1);
        }

        @Override // ir.nasim.UA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final InterfaceC14592iA0 invoke(InterfaceC20989sw5 interfaceC20989sw5) {
            AbstractC13042fc3.i(interfaceC20989sw5, "<this>");
            return interfaceC20989sw5;
        }
    }

    public /* synthetic */ C18628oy7(String str, W24 w24, ED1 ed1) {
        this(str, w24);
    }

    public static final W24 j(String str, Collection collection) {
        return d.a(str, collection);
    }

    @Override // ir.nasim.H1, ir.nasim.W24
    public Collection b(C6432No4 c6432No4, IJ3 ij3) {
        AbstractC13042fc3.i(c6432No4, "name");
        AbstractC13042fc3.i(ij3, "location");
        return AbstractC12306eO4.a(super.b(c6432No4, ij3), d.e);
    }

    @Override // ir.nasim.H1, ir.nasim.W24
    public Collection d(C6432No4 c6432No4, IJ3 ij3) {
        AbstractC13042fc3.i(c6432No4, "name");
        AbstractC13042fc3.i(ij3, "location");
        return AbstractC12306eO4.a(super.d(c6432No4, ij3), c.e);
    }

    @Override // ir.nasim.H1, ir.nasim.InterfaceC22011uW5
    public Collection f(C24841zI1 c24841zI1, UA2 ua2) {
        AbstractC13042fc3.i(c24841zI1, "kindFilter");
        AbstractC13042fc3.i(ua2, "nameFilter");
        Collection collectionF = super.f(c24841zI1, ua2);
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (Object obj : collectionF) {
            if (((InterfaceC12795fB1) obj) instanceof InterfaceC14592iA0) {
                arrayList.add(obj);
            } else {
                arrayList2.add(obj);
            }
        }
        XV4 xv4 = new XV4(arrayList, arrayList2);
        List list = (List) xv4.a();
        return AbstractC15401jX0.R0(AbstractC12306eO4.a(list, b.e), (List) xv4.b());
    }

    @Override // ir.nasim.H1
    protected W24 i() {
        return this.c;
    }

    private C18628oy7(String str, W24 w24) {
        this.b = str;
        this.c = w24;
    }
}
