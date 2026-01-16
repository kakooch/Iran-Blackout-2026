package ir.nasim;

import android.gov.nist.core.Separators;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import org.xbill.DNS.SimpleResolver;

/* renamed from: ir.nasim.sc1, reason: case insensitive filesystem */
/* loaded from: classes7.dex */
public final class C20786sc1 {
    public static final b d = new b(null);
    public static final int e = 8;
    private static final InterfaceC9173Yu3 f = AbstractC13269fw3.a(a.a);
    private final Integer a;
    private final List b;
    private final List c;

    /* renamed from: ir.nasim.sc1$a */
    /* synthetic */ class a extends EB2 implements SA2 {
        public static final a a = new a();

        a() {
            super(0, KS2.class, "<init>", "<init>()V", 0);
        }

        @Override // ir.nasim.SA2
        /* renamed from: y, reason: merged with bridge method [inline-methods] */
        public final KS2 invoke() {
            return new KS2();
        }
    }

    /* renamed from: ir.nasim.sc1$b */
    public static final class b {
        private b() {
        }

        public final C20786sc1 a() {
            return new C20786sc1(null, AbstractC10360bX0.p(Integer.valueOf(SimpleResolver.DEFAULT_EDNS_PAYLOADSIZE), 854, 640), C22102ug0.e.a());
        }

        public /* synthetic */ b(ED1 ed1) {
            this();
        }
    }

    public C20786sc1(Integer num, List list, List list2) {
        AbstractC13042fc3.i(list, "compressionLevels");
        AbstractC13042fc3.i(list2, "bitrateSettings");
        this.a = num;
        this.b = list;
        this.c = list2;
    }

    public static final C20786sc1 c() {
        return d.a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int f(Integer num, Integer num2) {
        int iIntValue = num2.intValue();
        AbstractC13042fc3.f(num);
        return iIntValue - num.intValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int g(InterfaceC14603iB2 interfaceC14603iB2, Object obj, Object obj2) {
        AbstractC13042fc3.i(interfaceC14603iB2, "$tmp0");
        return ((Number) interfaceC14603iB2.invoke(obj, obj2)).intValue();
    }

    public final List d() {
        return this.c;
    }

    public final int e(float f2) {
        List list = this.b;
        final InterfaceC14603iB2 interfaceC14603iB2 = new InterfaceC14603iB2() { // from class: ir.nasim.qc1
            @Override // ir.nasim.InterfaceC14603iB2
            public final Object invoke(Object obj, Object obj2) {
                return Integer.valueOf(C20786sc1.f((Integer) obj, (Integer) obj2));
            }
        };
        List listA1 = AbstractC15401jX0.a1(list, new Comparator() { // from class: ir.nasim.rc1
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                return C20786sc1.g(interfaceC14603iB2, obj, obj2);
            }
        });
        int size = listA1.size();
        Iterator it = listA1.iterator();
        while (it.hasNext()) {
            if (f2 > ((Number) it.next()).intValue()) {
                return size;
            }
            size--;
        }
        return size;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C20786sc1)) {
            return false;
        }
        C20786sc1 c20786sc1 = (C20786sc1) obj;
        return AbstractC13042fc3.d(this.a, c20786sc1.a) && AbstractC13042fc3.d(this.b, c20786sc1.b) && AbstractC13042fc3.d(this.c, c20786sc1.c);
    }

    public final Integer h() {
        return this.a;
    }

    public int hashCode() {
        Integer num = this.a;
        return ((((num == null ? 0 : num.hashCode()) * 31) + this.b.hashCode()) * 31) + this.c.hashCode();
    }

    public String toString() {
        return "CompressionConfig(defaultCompressionLevel=" + this.a + ", compressionLevels=" + this.b + ", bitrateSettings=" + this.c + Separators.RPAREN;
    }
}
