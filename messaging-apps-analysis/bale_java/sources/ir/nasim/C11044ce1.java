package ir.nasim;

import ir.nasim.InterfaceC24376yW4;
import java.util.ArrayList;

/* renamed from: ir.nasim.ce1, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C11044ce1 extends AbstractC9252Zd1 {
    private b e;
    private final int f;
    private int g = this.f;
    private final ArrayList h = new ArrayList();

    /* renamed from: ir.nasim.ce1$a */
    private static final class a extends U93 implements InterfaceC24376yW4 {
        private final C7773Td1 c;
        private final UA2 d;

        /* renamed from: ir.nasim.ce1$a$a, reason: collision with other inner class name */
        public static final class C0940a extends AbstractC8614Ws3 implements UA2 {
            final /* synthetic */ C7773Td1 e;
            final /* synthetic */ UA2 f;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C0940a(C7773Td1 c7773Td1, UA2 ua2) {
                super(1);
                this.e = c7773Td1;
                this.f = ua2;
            }

            public final void a(T93 t93) {
                AbstractC13042fc3.i(t93, "$this$null");
                throw null;
            }

            @Override // ir.nasim.UA2
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                AbstractC18350oW3.a(obj);
                a(null);
                return C19938rB7.a;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(C7773Td1 c7773Td1, UA2 ua2) {
            super(Q93.b() ? new C0940a(c7773Td1, ua2) : Q93.a());
            AbstractC13042fc3.i(c7773Td1, "ref");
            AbstractC13042fc3.i(ua2, "constrainBlock");
            this.c = c7773Td1;
            this.d = ua2;
        }

        @Override // androidx.compose.ui.e.b, androidx.compose.ui.e
        public Object a(Object obj, InterfaceC14603iB2 interfaceC14603iB2) {
            return InterfaceC24376yW4.a.c(this, obj, interfaceC14603iB2);
        }

        @Override // androidx.compose.ui.e.b, androidx.compose.ui.e
        public boolean c(UA2 ua2) {
            return InterfaceC24376yW4.a.a(this, ua2);
        }

        @Override // androidx.compose.ui.e.b, androidx.compose.ui.e
        public boolean d(UA2 ua2) {
            return InterfaceC24376yW4.a.b(this, ua2);
        }

        public boolean equals(Object obj) {
            UA2 ua2 = this.d;
            a aVar = obj instanceof a ? (a) obj : null;
            return AbstractC13042fc3.d(ua2, aVar != null ? aVar.d : null);
        }

        @Override // ir.nasim.InterfaceC24376yW4
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public C10454be1 C(WH1 wh1, Object obj) {
            AbstractC13042fc3.i(wh1, "<this>");
            return new C10454be1(this.c, this.d);
        }

        public int hashCode() {
            return this.d.hashCode();
        }

        @Override // androidx.compose.ui.e
        public androidx.compose.ui.e i(androidx.compose.ui.e eVar) {
            return InterfaceC24376yW4.a.d(this, eVar);
        }
    }

    /* renamed from: ir.nasim.ce1$b */
    public final class b {
        final /* synthetic */ C11044ce1 a;

        public b(C11044ce1 c11044ce1) {
            AbstractC13042fc3.i(c11044ce1, "this$0");
            this.a = c11044ce1;
        }

        public final C7773Td1 a() {
            return this.a.j();
        }

        public final C7773Td1 b() {
            return this.a.j();
        }

        public final C7773Td1 c() {
            return this.a.j();
        }

        public final C7773Td1 d() {
            return this.a.j();
        }
    }

    @Override // ir.nasim.AbstractC9252Zd1
    public void g() {
        super.g();
        this.g = this.f;
    }

    public final androidx.compose.ui.e i(androidx.compose.ui.e eVar, C7773Td1 c7773Td1, UA2 ua2) {
        AbstractC13042fc3.i(eVar, "<this>");
        AbstractC13042fc3.i(c7773Td1, "ref");
        AbstractC13042fc3.i(ua2, "constrainBlock");
        return eVar.i(new a(c7773Td1, ua2));
    }

    public final C7773Td1 j() {
        ArrayList arrayList = this.h;
        int i = this.g;
        this.g = i + 1;
        C7773Td1 c7773Td1 = (C7773Td1) AbstractC15401jX0.t0(arrayList, i);
        if (c7773Td1 != null) {
            return c7773Td1;
        }
        C7773Td1 c7773Td12 = new C7773Td1(Integer.valueOf(this.g));
        this.h.add(c7773Td12);
        return c7773Td12;
    }

    public final b k() {
        b bVar = this.e;
        if (bVar != null) {
            return bVar;
        }
        b bVar2 = new b(this);
        this.e = bVar2;
        return bVar2;
    }
}
