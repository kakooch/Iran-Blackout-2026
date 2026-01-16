package ir.nasim;

import java.util.ArrayList;
import java.util.Map;

/* renamed from: ir.nasim.Qi3, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public final class C7115Qi3 {
    public static final a i = new a(null);
    public static final EnumC23724xP5 j;
    public static final C7115Qi3 k;
    public static final C7115Qi3 l;
    public static final C7115Qi3 m;
    private final EnumC23724xP5 a;
    private final EnumC23724xP5 b;
    private final Map c;
    private final boolean d;
    private final EnumC23724xP5 e;
    private final InterfaceC9173Yu3 f;
    private final boolean g;
    private final boolean h;

    /* renamed from: ir.nasim.Qi3$a */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    /* renamed from: ir.nasim.Qi3$b */
    static final class b extends AbstractC8614Ws3 implements SA2 {
        b() {
            super(0);
        }

        @Override // ir.nasim.SA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final String[] invoke() {
            ArrayList arrayList = new ArrayList();
            arrayList.add(C7115Qi3.this.d().a());
            EnumC23724xP5 enumC23724xP5F = C7115Qi3.this.f();
            if (enumC23724xP5F != null) {
                arrayList.add(AbstractC13042fc3.q("under-migration:", enumC23724xP5F.a()));
            }
            for (Map.Entry entry : C7115Qi3.this.g().entrySet()) {
                arrayList.add('@' + ((String) entry.getKey()) + ':' + ((EnumC23724xP5) entry.getValue()).a());
            }
            Object[] array = arrayList.toArray(new String[0]);
            if (array != null) {
                return (String[]) array;
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
        }
    }

    static {
        EnumC23724xP5 enumC23724xP5 = EnumC23724xP5.WARN;
        j = enumC23724xP5;
        k = new C7115Qi3(enumC23724xP5, null, AbstractC20051rO3.k(), false, null, 24, null);
        EnumC23724xP5 enumC23724xP52 = EnumC23724xP5.IGNORE;
        l = new C7115Qi3(enumC23724xP52, enumC23724xP52, AbstractC20051rO3.k(), false, null, 24, null);
        EnumC23724xP5 enumC23724xP53 = EnumC23724xP5.STRICT;
        m = new C7115Qi3(enumC23724xP53, enumC23724xP53, AbstractC20051rO3.k(), false, null, 24, null);
    }

    public C7115Qi3(EnumC23724xP5 enumC23724xP5, EnumC23724xP5 enumC23724xP52, Map map, boolean z, EnumC23724xP5 enumC23724xP53) {
        AbstractC13042fc3.i(enumC23724xP5, "globalJsr305Level");
        AbstractC13042fc3.i(map, "userDefinedLevelForSpecificJsr305Annotation");
        AbstractC13042fc3.i(enumC23724xP53, "jspecifyReportLevel");
        this.a = enumC23724xP5;
        this.b = enumC23724xP52;
        this.c = map;
        this.d = z;
        this.e = enumC23724xP53;
        this.f = AbstractC13269fw3.a(new b());
        EnumC23724xP5 enumC23724xP54 = EnumC23724xP5.IGNORE;
        boolean z2 = enumC23724xP5 == enumC23724xP54 && enumC23724xP52 == enumC23724xP54 && map.isEmpty();
        this.g = z2;
        this.h = z2 || enumC23724xP53 == enumC23724xP54;
    }

    public final boolean a() {
        return this.h;
    }

    public final boolean b() {
        return this.g;
    }

    public final boolean c() {
        return this.d;
    }

    public final EnumC23724xP5 d() {
        return this.a;
    }

    public final EnumC23724xP5 e() {
        return this.e;
    }

    public final EnumC23724xP5 f() {
        return this.b;
    }

    public final Map g() {
        return this.c;
    }

    public /* synthetic */ C7115Qi3(EnumC23724xP5 enumC23724xP5, EnumC23724xP5 enumC23724xP52, Map map, boolean z, EnumC23724xP5 enumC23724xP53, int i2, ED1 ed1) {
        this(enumC23724xP5, enumC23724xP52, map, (i2 & 8) != 0 ? true : z, (i2 & 16) != 0 ? j : enumC23724xP53);
    }
}
