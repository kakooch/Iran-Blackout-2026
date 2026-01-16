package ir.nasim;

import java.util.List;

/* renamed from: ir.nasim.Xn6, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C8838Xn6 {
    public static final C8838Xn6 a = new C8838Xn6();
    private static final C11322co6 b = AbstractC9939ao6.b("ContentDescription", b.e);
    private static final C11322co6 c = AbstractC9939ao6.a("StateDescription");
    private static final C11322co6 d = AbstractC9939ao6.a("ProgressBarRangeInfo");
    private static final C11322co6 e = AbstractC9939ao6.b("PaneTitle", i.e);
    private static final C11322co6 f = AbstractC9939ao6.a("SelectableGroup");
    private static final C11322co6 g = AbstractC9939ao6.a("CollectionInfo");
    private static final C11322co6 h = AbstractC9939ao6.a("CollectionItemInfo");
    private static final C11322co6 i = AbstractC9939ao6.a("Heading");
    private static final C11322co6 j = AbstractC9939ao6.a("Disabled");
    private static final C11322co6 k = AbstractC9939ao6.a("LiveRegion");
    private static final C11322co6 l = AbstractC9939ao6.a("Focused");
    private static final C11322co6 m = AbstractC9939ao6.a("IsContainer");
    private static final C11322co6 n = new C11322co6("IsTraversalGroup", null, 2, null);
    private static final C11322co6 o = new C11322co6("InvisibleToUser", e.e);
    private static final C11322co6 p = new C11322co6("HideFromAccessibility", d.e);
    private static final C11322co6 q = new C11322co6("ContentType", c.e);
    private static final C11322co6 r = new C11322co6("ContentDataType", a.e);
    private static final C11322co6 s = new C11322co6("TraversalIndex", m.e);
    private static final C11322co6 t = AbstractC9939ao6.a("HorizontalScrollAxisRange");
    private static final C11322co6 u = AbstractC9939ao6.a("VerticalScrollAxisRange");
    private static final C11322co6 v = AbstractC9939ao6.b("IsPopup", g.e);
    private static final C11322co6 w = AbstractC9939ao6.b("IsDialog", f.e);
    private static final C11322co6 x = AbstractC9939ao6.b("Role", j.e);
    private static final C11322co6 y = new C11322co6("TestTag", false, k.e);
    private static final C11322co6 z = new C11322co6("LinkTestMarker", false, h.e);
    private static final C11322co6 A = AbstractC9939ao6.b("Text", l.e);
    private static final C11322co6 B = new C11322co6("TextSubstitution", null, 2, null);
    private static final C11322co6 C = new C11322co6("IsShowingTextSubstitution", null, 2, null);
    private static final C11322co6 D = AbstractC9939ao6.a("InputText");
    private static final C11322co6 E = AbstractC9939ao6.a("EditableText");
    private static final C11322co6 F = AbstractC9939ao6.a("TextSelectionRange");
    private static final C11322co6 G = AbstractC9939ao6.a("ImeAction");
    private static final C11322co6 H = AbstractC9939ao6.a("Selected");
    private static final C11322co6 I = AbstractC9939ao6.a("ToggleableState");
    private static final C11322co6 J = AbstractC9939ao6.a("Password");
    private static final C11322co6 K = AbstractC9939ao6.a("Error");
    private static final C11322co6 L = new C11322co6("IndexForKey", null, 2, null);
    private static final C11322co6 M = new C11322co6("IsEditable", null, 2, null);
    private static final C11322co6 N = new C11322co6("MaxTextLength", null, 2, null);
    public static final int O = 8;

    /* renamed from: ir.nasim.Xn6$b */
    static final class b extends AbstractC8614Ws3 implements InterfaceC14603iB2 {
        public static final b e = new b();

        b() {
            super(2);
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final List invoke(List list, List list2) {
            List listP1;
            if (list == null || (listP1 = AbstractC15401jX0.p1(list)) == null) {
                return list2;
            }
            listP1.addAll(list2);
            return listP1;
        }
    }

    /* renamed from: ir.nasim.Xn6$f */
    static final class f extends AbstractC8614Ws3 implements InterfaceC14603iB2 {
        public static final f e = new f();

        f() {
            super(2);
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final C19938rB7 invoke(C19938rB7 c19938rB7, C19938rB7 c19938rB72) {
            throw new IllegalStateException("merge function called on unmergeable property IsDialog. A dialog should not be a child of a clickable/focusable node.");
        }
    }

    /* renamed from: ir.nasim.Xn6$g */
    static final class g extends AbstractC8614Ws3 implements InterfaceC14603iB2 {
        public static final g e = new g();

        g() {
            super(2);
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final C19938rB7 invoke(C19938rB7 c19938rB7, C19938rB7 c19938rB72) {
            throw new IllegalStateException("merge function called on unmergeable property IsPopup. A popup should not be a child of a clickable/focusable node.");
        }
    }

    /* renamed from: ir.nasim.Xn6$i */
    static final class i extends AbstractC8614Ws3 implements InterfaceC14603iB2 {
        public static final i e = new i();

        i() {
            super(2);
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final String invoke(String str, String str2) {
            throw new IllegalStateException("merge function called on unmergeable property PaneTitle.");
        }
    }

    /* renamed from: ir.nasim.Xn6$l */
    static final class l extends AbstractC8614Ws3 implements InterfaceC14603iB2 {
        public static final l e = new l();

        l() {
            super(2);
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final List invoke(List list, List list2) {
            List listP1;
            if (list == null || (listP1 = AbstractC15401jX0.p1(list)) == null) {
                return list2;
            }
            listP1.addAll(list2);
            return listP1;
        }
    }

    private C8838Xn6() {
    }

    public final C11322co6 A() {
        return J;
    }

    public final C11322co6 B() {
        return d;
    }

    public final C11322co6 C() {
        return x;
    }

    public final C11322co6 D() {
        return f;
    }

    public final C11322co6 E() {
        return H;
    }

    public final C11322co6 F() {
        return c;
    }

    public final C11322co6 G() {
        return y;
    }

    public final C11322co6 H() {
        return A;
    }

    public final C11322co6 I() {
        return F;
    }

    public final C11322co6 J() {
        return B;
    }

    public final C11322co6 K() {
        return I;
    }

    public final C11322co6 L() {
        return s;
    }

    public final C11322co6 M() {
        return u;
    }

    public final C11322co6 a() {
        return g;
    }

    public final C11322co6 b() {
        return h;
    }

    public final C11322co6 c() {
        return r;
    }

    public final C11322co6 d() {
        return b;
    }

    public final C11322co6 e() {
        return q;
    }

    public final C11322co6 f() {
        return j;
    }

    public final C11322co6 g() {
        return E;
    }

    public final C11322co6 h() {
        return K;
    }

    public final C11322co6 i() {
        return l;
    }

    public final C11322co6 j() {
        return i;
    }

    public final C11322co6 k() {
        return p;
    }

    public final C11322co6 l() {
        return t;
    }

    public final C11322co6 m() {
        return G;
    }

    public final C11322co6 n() {
        return L;
    }

    public final C11322co6 o() {
        return D;
    }

    public final C11322co6 p() {
        return o;
    }

    public final C11322co6 q() {
        return m;
    }

    public final C11322co6 r() {
        return w;
    }

    public final C11322co6 s() {
        return M;
    }

    public final C11322co6 t() {
        return v;
    }

    public final C11322co6 u() {
        return C;
    }

    public final C11322co6 v() {
        return n;
    }

    public final C11322co6 w() {
        return z;
    }

    public final C11322co6 x() {
        return k;
    }

    public final C11322co6 y() {
        return N;
    }

    public final C11322co6 z() {
        return e;
    }

    /* renamed from: ir.nasim.Xn6$a */
    static final class a extends AbstractC8614Ws3 implements InterfaceC14603iB2 {
        public static final a e = new a();

        a() {
            super(2);
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final InterfaceC22143uk1 invoke(InterfaceC22143uk1 interfaceC22143uk1, InterfaceC22143uk1 interfaceC22143uk12) {
            return interfaceC22143uk1;
        }
    }

    /* renamed from: ir.nasim.Xn6$c */
    static final class c extends AbstractC8614Ws3 implements InterfaceC14603iB2 {
        public static final c e = new c();

        c() {
            super(2);
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final InterfaceC17903nl1 invoke(InterfaceC17903nl1 interfaceC17903nl1, InterfaceC17903nl1 interfaceC17903nl12) {
            return interfaceC17903nl1;
        }
    }

    /* renamed from: ir.nasim.Xn6$d */
    static final class d extends AbstractC8614Ws3 implements InterfaceC14603iB2 {
        public static final d e = new d();

        d() {
            super(2);
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final C19938rB7 invoke(C19938rB7 c19938rB7, C19938rB7 c19938rB72) {
            return c19938rB7;
        }
    }

    /* renamed from: ir.nasim.Xn6$e */
    static final class e extends AbstractC8614Ws3 implements InterfaceC14603iB2 {
        public static final e e = new e();

        e() {
            super(2);
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final C19938rB7 invoke(C19938rB7 c19938rB7, C19938rB7 c19938rB72) {
            return c19938rB7;
        }
    }

    /* renamed from: ir.nasim.Xn6$h */
    static final class h extends AbstractC8614Ws3 implements InterfaceC14603iB2 {
        public static final h e = new h();

        h() {
            super(2);
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final C19938rB7 invoke(C19938rB7 c19938rB7, C19938rB7 c19938rB72) {
            return c19938rB7;
        }
    }

    /* renamed from: ir.nasim.Xn6$j */
    static final class j extends AbstractC8614Ws3 implements InterfaceC14603iB2 {
        public static final j e = new j();

        j() {
            super(2);
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            return a((B26) obj, ((B26) obj2).p());
        }

        public final B26 a(B26 b26, int i) {
            return b26;
        }
    }

    /* renamed from: ir.nasim.Xn6$k */
    static final class k extends AbstractC8614Ws3 implements InterfaceC14603iB2 {
        public static final k e = new k();

        k() {
            super(2);
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final String invoke(String str, String str2) {
            return str;
        }
    }

    /* renamed from: ir.nasim.Xn6$m */
    static final class m extends AbstractC8614Ws3 implements InterfaceC14603iB2 {
        public static final m e = new m();

        m() {
            super(2);
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            return a((Float) obj, ((Number) obj2).floatValue());
        }

        public final Float a(Float f, float f2) {
            return f;
        }
    }
}
