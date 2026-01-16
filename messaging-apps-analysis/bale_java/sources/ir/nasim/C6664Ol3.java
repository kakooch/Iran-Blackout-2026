package ir.nasim;

import ir.nasim.AbstractC7849Tl3;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* renamed from: ir.nasim.Ol3, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public final class C6664Ol3 implements InterfaceC6692Oo4 {
    public static final a e;
    private static final String f;
    private static final List g;
    private static final Map h;
    private final AbstractC7849Tl3.e a;
    private final String[] b;
    private final Set c;
    private final List d;

    /* renamed from: ir.nasim.Ol3$a */
    public static final class a {
        private a() {
        }

        public final List a() {
            return C6664Ol3.g;
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    /* renamed from: ir.nasim.Ol3$b */
    public /* synthetic */ class b {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[AbstractC7849Tl3.e.c.EnumC0666c.values().length];
            iArr[AbstractC7849Tl3.e.c.EnumC0666c.NONE.ordinal()] = 1;
            iArr[AbstractC7849Tl3.e.c.EnumC0666c.INTERNAL_TO_CLASS_ID.ordinal()] = 2;
            iArr[AbstractC7849Tl3.e.c.EnumC0666c.DESC_TO_CLASS_ID.ordinal()] = 3;
            a = iArr;
        }
    }

    static {
        a aVar = new a(null);
        e = aVar;
        String strA0 = AbstractC15401jX0.A0(AbstractC10360bX0.p('k', 'o', 't', 'l', 'i', 'n'), "", null, null, 0, null, null, 62, null);
        f = strA0;
        g = AbstractC10360bX0.p(AbstractC13042fc3.q(strA0, "/Any"), AbstractC13042fc3.q(strA0, "/Nothing"), AbstractC13042fc3.q(strA0, "/Unit"), AbstractC13042fc3.q(strA0, "/Throwable"), AbstractC13042fc3.q(strA0, "/Number"), AbstractC13042fc3.q(strA0, "/Byte"), AbstractC13042fc3.q(strA0, "/Double"), AbstractC13042fc3.q(strA0, "/Float"), AbstractC13042fc3.q(strA0, "/Int"), AbstractC13042fc3.q(strA0, "/Long"), AbstractC13042fc3.q(strA0, "/Short"), AbstractC13042fc3.q(strA0, "/Boolean"), AbstractC13042fc3.q(strA0, "/Char"), AbstractC13042fc3.q(strA0, "/CharSequence"), AbstractC13042fc3.q(strA0, "/String"), AbstractC13042fc3.q(strA0, "/Comparable"), AbstractC13042fc3.q(strA0, "/Enum"), AbstractC13042fc3.q(strA0, "/Array"), AbstractC13042fc3.q(strA0, "/ByteArray"), AbstractC13042fc3.q(strA0, "/DoubleArray"), AbstractC13042fc3.q(strA0, "/FloatArray"), AbstractC13042fc3.q(strA0, "/IntArray"), AbstractC13042fc3.q(strA0, "/LongArray"), AbstractC13042fc3.q(strA0, "/ShortArray"), AbstractC13042fc3.q(strA0, "/BooleanArray"), AbstractC13042fc3.q(strA0, "/CharArray"), AbstractC13042fc3.q(strA0, "/Cloneable"), AbstractC13042fc3.q(strA0, "/Annotation"), AbstractC13042fc3.q(strA0, "/collections/Iterable"), AbstractC13042fc3.q(strA0, "/collections/MutableIterable"), AbstractC13042fc3.q(strA0, "/collections/Collection"), AbstractC13042fc3.q(strA0, "/collections/MutableCollection"), AbstractC13042fc3.q(strA0, "/collections/List"), AbstractC13042fc3.q(strA0, "/collections/MutableList"), AbstractC13042fc3.q(strA0, "/collections/Set"), AbstractC13042fc3.q(strA0, "/collections/MutableSet"), AbstractC13042fc3.q(strA0, "/collections/Map"), AbstractC13042fc3.q(strA0, "/collections/MutableMap"), AbstractC13042fc3.q(strA0, "/collections/Map.Entry"), AbstractC13042fc3.q(strA0, "/collections/MutableMap.MutableEntry"), AbstractC13042fc3.q(strA0, "/collections/Iterator"), AbstractC13042fc3.q(strA0, "/collections/MutableIterator"), AbstractC13042fc3.q(strA0, "/collections/ListIterator"), AbstractC13042fc3.q(strA0, "/collections/MutableListIterator"));
        Iterable<C14555i63> iterableU1 = AbstractC15401jX0.u1(aVar.a());
        LinkedHashMap linkedHashMap = new LinkedHashMap(AbstractC23053wG5.e(AbstractC19460qO3.f(AbstractC10976cX0.x(iterableU1, 10)), 16));
        for (C14555i63 c14555i63 : iterableU1) {
            linkedHashMap.put((String) c14555i63.d(), Integer.valueOf(c14555i63.c()));
        }
        h = linkedHashMap;
    }

    public C6664Ol3(AbstractC7849Tl3.e eVar, String[] strArr) {
        Set setR1;
        AbstractC13042fc3.i(eVar, "types");
        AbstractC13042fc3.i(strArr, "strings");
        this.a = eVar;
        this.b = strArr;
        List listY = eVar.y();
        if (listY.isEmpty()) {
            setR1 = AbstractC4597Fu6.d();
        } else {
            AbstractC13042fc3.h(listY, "");
            setR1 = AbstractC15401jX0.r1(listY);
        }
        this.c = setR1;
        ArrayList arrayList = new ArrayList();
        List<AbstractC7849Tl3.e.c> listZ = d().z();
        arrayList.ensureCapacity(listZ.size());
        for (AbstractC7849Tl3.e.c cVar : listZ) {
            int iJ = cVar.J();
            for (int i = 0; i < iJ; i++) {
                arrayList.add(cVar);
            }
        }
        arrayList.trimToSize();
        C19938rB7 c19938rB7 = C19938rB7.a;
        this.d = arrayList;
    }

    @Override // ir.nasim.InterfaceC6692Oo4
    public boolean a(int i) {
        return this.c.contains(Integer.valueOf(i));
    }

    @Override // ir.nasim.InterfaceC6692Oo4
    public String b(int i) {
        return getString(i);
    }

    public final AbstractC7849Tl3.e d() {
        return this.a;
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0040  */
    @Override // ir.nasim.InterfaceC6692Oo4
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.String getString(int r18) {
        /*
            Method dump skipped, instructions count: 283
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C6664Ol3.getString(int):java.lang.String");
    }
}
