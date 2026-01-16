package ir.nasim;

import ir.nasim.C21625tr3;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* renamed from: ir.nasim.Vv3, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public final class C8407Vv3 extends AbstractC24934zS4 {
    static final /* synthetic */ InterfaceC5239Im3[] m = {AbstractC10882cM5.i(new C25226zw5(AbstractC10882cM5.b(C8407Vv3.class), "binaryClasses", "getBinaryClasses$descriptors_jvm()Ljava/util/Map;")), AbstractC10882cM5.i(new C25226zw5(AbstractC10882cM5.b(C8407Vv3.class), "partToFacade", "getPartToFacade()Ljava/util/HashMap;"))};
    private final InterfaceC22715vi3 f;
    private final C9182Yv3 g;
    private final InterfaceC23016wC4 h;
    private final C7142Ql3 i;
    private final InterfaceC23016wC4 j;
    private final InterfaceC4356Eu k;
    private final InterfaceC23016wC4 l;

    /* renamed from: ir.nasim.Vv3$a */
    static final class a extends AbstractC8614Ws3 implements SA2 {
        a() {
            super(0);
        }

        @Override // ir.nasim.SA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Map invoke() {
            KS4 ks4N = C8407Vv3.this.g.a().n();
            String strB = C8407Vv3.this.e().b();
            AbstractC13042fc3.h(strB, "fqName.asString()");
            List<String> listA = ks4N.a(strB);
            C8407Vv3 c8407Vv3 = C8407Vv3.this;
            ArrayList arrayList = new ArrayList();
            for (String str : listA) {
                C24948zU0 c24948zU0M = C24948zU0.m(C4996Hl3.d(str).e());
                AbstractC13042fc3.h(c24948zU0M, "topLevel(JvmClassName.byInternalName(partName).fqNameForTopLevelClassMaybeWithDollars)");
                InterfaceC22805vr3 interfaceC22805vr3A = AbstractC20938sr3.a(c8407Vv3.g.a().i(), c24948zU0M);
                XV4 xv4A = interfaceC22805vr3A == null ? null : AbstractC4616Fw7.a(str, interfaceC22805vr3A);
                if (xv4A != null) {
                    arrayList.add(xv4A);
                }
            }
            return AbstractC20051rO3.w(arrayList);
        }
    }

    /* renamed from: ir.nasim.Vv3$b */
    static final class b extends AbstractC8614Ws3 implements SA2 {

        /* renamed from: ir.nasim.Vv3$b$a */
        public /* synthetic */ class a {
            public static final /* synthetic */ int[] a;

            static {
                int[] iArr = new int[C21625tr3.a.valuesCustom().length];
                iArr[C21625tr3.a.MULTIFILE_CLASS_PART.ordinal()] = 1;
                iArr[C21625tr3.a.FILE_FACADE.ordinal()] = 2;
                a = iArr;
            }
        }

        b() {
            super(0);
        }

        @Override // ir.nasim.SA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final HashMap invoke() {
            HashMap map = new HashMap();
            for (Map.Entry entry : C8407Vv3.this.L0().entrySet()) {
                String str = (String) entry.getKey();
                InterfaceC22805vr3 interfaceC22805vr3 = (InterfaceC22805vr3) entry.getValue();
                C4996Hl3 c4996Hl3D = C4996Hl3.d(str);
                AbstractC13042fc3.h(c4996Hl3D, "byInternalName(partInternalName)");
                C21625tr3 c21625tr3C = interfaceC22805vr3.c();
                int i = a.a[c21625tr3C.c().ordinal()];
                if (i == 1) {
                    String strE = c21625tr3C.e();
                    if (strE != null) {
                        C4996Hl3 c4996Hl3D2 = C4996Hl3.d(strE);
                        AbstractC13042fc3.h(c4996Hl3D2, "byInternalName(header.multifileClassName ?: continue@kotlinClasses)");
                        map.put(c4996Hl3D, c4996Hl3D2);
                    }
                } else if (i == 2) {
                    map.put(c4996Hl3D, c4996Hl3D);
                }
            }
            return map;
        }
    }

    /* renamed from: ir.nasim.Vv3$c */
    static final class c extends AbstractC8614Ws3 implements SA2 {
        c() {
            super(0);
        }

        @Override // ir.nasim.SA2
        public final List invoke() {
            Collection collectionU = C8407Vv3.this.f.u();
            ArrayList arrayList = new ArrayList(AbstractC10976cX0.x(collectionU, 10));
            Iterator it = collectionU.iterator();
            while (it.hasNext()) {
                arrayList.add(((InterfaceC22715vi3) it.next()).e());
            }
            return arrayList;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C8407Vv3(C9182Yv3 c9182Yv3, InterfaceC22715vi3 interfaceC22715vi3) {
        super(c9182Yv3.d(), interfaceC22715vi3.e());
        AbstractC13042fc3.i(c9182Yv3, "outerContext");
        AbstractC13042fc3.i(interfaceC22715vi3, "jPackage");
        this.f = interfaceC22715vi3;
        C9182Yv3 c9182Yv3D = AbstractC4760Gl1.d(c9182Yv3, this, null, 0, 6, null);
        this.g = c9182Yv3D;
        this.h = c9182Yv3D.e().c(new a());
        this.i = new C7142Ql3(c9182Yv3D, interfaceC22715vi3, this);
        this.j = c9182Yv3D.e().d(new c(), AbstractC10360bX0.m());
        this.k = c9182Yv3D.a().h().a() ? InterfaceC4356Eu.W.b() : AbstractC7700Sv3.a(c9182Yv3D, interfaceC22715vi3);
        this.l = c9182Yv3D.e().c(new b());
    }

    public final InterfaceC21331tU0 K0(InterfaceC7106Qh3 interfaceC7106Qh3) {
        AbstractC13042fc3.i(interfaceC7106Qh3, "jClass");
        return this.i.j().O(interfaceC7106Qh3);
    }

    public final Map L0() {
        return (Map) MN6.a(this.h, this, m[0]);
    }

    @Override // ir.nasim.InterfaceC24340yS4
    /* renamed from: M0, reason: merged with bridge method [inline-methods] */
    public C7142Ql3 o() {
        return this.i;
    }

    public final List N0() {
        return (List) this.j.invoke();
    }

    @Override // ir.nasim.AbstractC11996du, ir.nasim.InterfaceC10612bu
    public InterfaceC4356Eu getAnnotations() {
        return this.k;
    }

    @Override // ir.nasim.AbstractC24934zS4, ir.nasim.AbstractC14602iB1, ir.nasim.InterfaceC16386lB1
    public JH6 i() {
        return new C23401wr3(this);
    }

    @Override // ir.nasim.AbstractC24934zS4, ir.nasim.AbstractC13413gB1
    public String toString() {
        return AbstractC13042fc3.q("Lazy Java package fragment: ", e());
    }
}
