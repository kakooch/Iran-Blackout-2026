package ir.nasim;

import android.content.Context;
import android.view.ViewGroup;
import ir.nasim.AT7;
import ir.nasim.AbstractC17757nW1;
import ir.nasim.AbstractC20283rl;
import ir.nasim.C10692c23;
import ir.nasim.C22463vH2;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* renamed from: ir.nasim.ul, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C22151ul extends androidx.recyclerview.widget.q {
    private final boolean f;
    private final InterfaceC11285cl g;
    private final UA2 h;
    private final UA2 i;
    private final EnumC8893Xt7 j;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* renamed from: ir.nasim.ul$a */
    private static final class a {
        public static final C1639a a;
        public static final a b = new c("IMAGE", 0);
        public static final a c = new e("VIDEO", 1);
        public static final a d = new b("GIF", 2);
        public static final a e = new d("UNKNOWN", 3);
        private static final /* synthetic */ a[] f;
        private static final /* synthetic */ F92 g;

        /* renamed from: ir.nasim.ul$a$a, reason: collision with other inner class name */
        public static final class C1639a {
            private C1639a() {
            }

            public final a a(AbstractC17757nW1 abstractC17757nW1) {
                AbstractC13042fc3.i(abstractC17757nW1, "document");
                return abstractC17757nW1 instanceof AbstractC17757nW1.c.b ? a.b : abstractC17757nW1 instanceof AbstractC17757nW1.c.d ? a.c : abstractC17757nW1 instanceof AbstractC17757nW1.c.a ? a.d : a.e;
            }

            public final a b(int i) {
                return a.values()[i];
            }

            public /* synthetic */ C1639a(ED1 ed1) {
                this();
            }
        }

        /* renamed from: ir.nasim.ul$a$b */
        static final class b extends a {
            b(String str, int i) {
                super(str, i, null);
            }

            @Override // ir.nasim.C22151ul.a
            /* renamed from: p, reason: merged with bridge method [inline-methods] */
            public C22463vH2.a j() {
                return new C22463vH2.a();
            }
        }

        /* renamed from: ir.nasim.ul$a$c */
        static final class c extends a {
            c(String str, int i) {
                super(str, i, null);
            }

            @Override // ir.nasim.C22151ul.a
            /* renamed from: p, reason: merged with bridge method [inline-methods] */
            public C10692c23.a j() {
                return new C10692c23.a();
            }
        }

        /* renamed from: ir.nasim.ul$a$d */
        static final class d extends a {
            d(String str, int i) {
                super(str, i, null);
            }

            @Override // ir.nasim.C22151ul.a
            public AbstractC20283rl.a j() {
                throw new IllegalStateException();
            }
        }

        /* renamed from: ir.nasim.ul$a$e */
        static final class e extends a {
            e(String str, int i) {
                super(str, i, null);
            }

            @Override // ir.nasim.C22151ul.a
            /* renamed from: p, reason: merged with bridge method [inline-methods] */
            public AT7.a j() {
                return new AT7.a();
            }
        }

        static {
            a[] aVarArrA = a();
            f = aVarArrA;
            g = G92.a(aVarArrA);
            a = new C1639a(null);
        }

        public /* synthetic */ a(String str, int i, ED1 ed1) {
            this(str, i);
        }

        private static final /* synthetic */ a[] a() {
            return new a[]{b, c, d, e};
        }

        public static a valueOf(String str) {
            return (a) Enum.valueOf(a.class, str);
        }

        public static a[] values() {
            return (a[]) f.clone();
        }

        public abstract AbstractC20283rl.a j();

        private a(String str, int i) {
        }
    }

    /* renamed from: ir.nasim.ul$b */
    public /* synthetic */ class b {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[a.values().length];
            try {
                iArr[a.b.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[a.c.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[a.d.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            a = iArr;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C22151ul(boolean z, InterfaceC11285cl interfaceC11285cl, UA2 ua2, UA2 ua22, EnumC8893Xt7 enumC8893Xt7) {
        super(new C14947il());
        AbstractC13042fc3.i(interfaceC11285cl, "albumClickListener");
        AbstractC13042fc3.i(ua2, "itemSizeProvider");
        AbstractC13042fc3.i(ua22, "itemCornersProvider");
        this.f = z;
        this.g = interfaceC11285cl;
        this.h = ua2;
        this.i = ua22;
        this.j = enumC8893Xt7;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.h
    /* renamed from: E, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(C22741vl c22741vl, int i) {
        AbstractC13042fc3.i(c22741vl, "holder");
        Context context = c22741vl.a.getContext();
        C14339hl c14339hl = (C14339hl) A(i);
        int size = z().size();
        int i2 = b.a[a.a.a(c14339hl.c()).ordinal()];
        String string = i2 != 1 ? i2 != 2 ? i2 != 3 ? "" : context.getString(AbstractC12217eE5.gif_type_content_description) : context.getString(AbstractC12217eE5.video_type_content_description) : context.getString(AbstractC12217eE5.image_type_content_description);
        AbstractC13042fc3.f(string);
        String string2 = context.getString(AbstractC12217eE5.content_description_album_item, string, Integer.valueOf(i + 1), Integer.valueOf(size));
        AbstractC13042fc3.h(string2, "getString(...)");
        XV4 xv4 = (XV4) this.h.invoke(Integer.valueOf(i));
        Object objA = A(i);
        AbstractC13042fc3.h(objA, "getItem(...)");
        c22741vl.C0((C14339hl) objA, xv4, ((Number) this.i.invoke(Integer.valueOf(i))).intValue(), this.j, string2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.h
    /* renamed from: F, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(C22741vl c22741vl, int i, List list) {
        AbstractC13042fc3.i(c22741vl, "holder");
        AbstractC13042fc3.i(list, "payloads");
        ArrayList arrayList = new ArrayList();
        for (Object obj : list) {
            List listM = obj instanceof List ? (List) obj : null;
            if (listM == null) {
                listM = AbstractC10360bX0.m();
            }
            AbstractC13610gX0.D(arrayList, listM);
        }
        if (!(!arrayList.isEmpty())) {
            onBindViewHolder(c22741vl, i);
            return;
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            c22741vl.D0((InterfaceC23337wl) it.next());
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.h
    /* renamed from: G, reason: merged with bridge method [inline-methods] */
    public C22741vl onCreateViewHolder(ViewGroup viewGroup, int i) {
        AbstractC13042fc3.i(viewGroup, "parent");
        return C22741vl.w.a(viewGroup, this.g, a.a.b(i).j(), this.f);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.h
    /* renamed from: H, reason: merged with bridge method [inline-methods] */
    public void onViewRecycled(C22741vl c22741vl) {
        AbstractC13042fc3.i(c22741vl, "holder");
        c22741vl.a();
        super.onViewRecycled(c22741vl);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.h
    public int getItemViewType(int i) {
        return a.a.a(((C14339hl) A(i)).c()).ordinal();
    }
}
