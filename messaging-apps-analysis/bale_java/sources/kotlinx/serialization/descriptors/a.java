package kotlinx.serialization.descriptors;

import android.gov.nist.core.Separators;
import ir.nasim.AbstractC10242bK;
import ir.nasim.AbstractC10976cX0;
import ir.nasim.AbstractC13042fc3;
import ir.nasim.AbstractC13269fw3;
import ir.nasim.AbstractC15401jX0;
import ir.nasim.AbstractC19630qg5;
import ir.nasim.AbstractC19731qq6;
import ir.nasim.AbstractC20051rO3;
import ir.nasim.AbstractC23053wG5;
import ir.nasim.AbstractC4227Ef5;
import ir.nasim.AbstractC4616Fw7;
import ir.nasim.AbstractC8614Ws3;
import ir.nasim.C14555i63;
import ir.nasim.FU0;
import ir.nasim.InterfaceC8886Xt0;
import ir.nasim.InterfaceC9173Yu3;
import ir.nasim.SA2;
import ir.nasim.UA2;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlinx.serialization.descriptors.SerialDescriptor;

/* loaded from: classes8.dex */
public final class a implements SerialDescriptor, InterfaceC8886Xt0 {
    private final String a;
    private final AbstractC19731qq6 b;
    private final int c;
    private final List d;
    private final Set e;
    private final String[] f;
    private final SerialDescriptor[] g;
    private final List[] h;
    private final boolean[] i;
    private final Map j;
    private final SerialDescriptor[] k;
    private final InterfaceC9173Yu3 l;

    /* renamed from: kotlinx.serialization.descriptors.a$a, reason: collision with other inner class name */
    static final class C1832a extends AbstractC8614Ws3 implements SA2 {
        C1832a() {
            super(0);
        }

        @Override // ir.nasim.SA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Integer invoke() {
            a aVar = a.this;
            return Integer.valueOf(AbstractC19630qg5.a(aVar, aVar.k));
        }
    }

    static final class b extends AbstractC8614Ws3 implements UA2 {
        b() {
            super(1);
        }

        public final CharSequence a(int i) {
            return a.this.e(i) + ": " + a.this.h(i).i();
        }

        @Override // ir.nasim.UA2
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            return a(((Number) obj).intValue());
        }
    }

    public a(String str, AbstractC19731qq6 abstractC19731qq6, int i, List list, FU0 fu0) {
        AbstractC13042fc3.i(str, "serialName");
        AbstractC13042fc3.i(abstractC19731qq6, "kind");
        AbstractC13042fc3.i(list, "typeParameters");
        AbstractC13042fc3.i(fu0, "builder");
        this.a = str;
        this.b = abstractC19731qq6;
        this.c = i;
        this.d = fu0.c();
        this.e = AbstractC15401jX0.k1(fu0.f());
        String[] strArr = (String[]) fu0.f().toArray(new String[0]);
        this.f = strArr;
        this.g = AbstractC4227Ef5.b(fu0.e());
        this.h = (List[]) fu0.d().toArray(new List[0]);
        this.i = AbstractC15401jX0.h1(fu0.g());
        Iterable<C14555i63> iterableT1 = AbstractC10242bK.t1(strArr);
        ArrayList arrayList = new ArrayList(AbstractC10976cX0.x(iterableT1, 10));
        for (C14555i63 c14555i63 : iterableT1) {
            arrayList.add(AbstractC4616Fw7.a(c14555i63.d(), Integer.valueOf(c14555i63.c())));
        }
        this.j = AbstractC20051rO3.w(arrayList);
        this.k = AbstractC4227Ef5.b(list);
        this.l = AbstractC13269fw3.a(new C1832a());
    }

    private final int l() {
        return ((Number) this.l.getValue()).intValue();
    }

    @Override // ir.nasim.InterfaceC8886Xt0
    public Set a() {
        return this.e;
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    public boolean b() {
        return SerialDescriptor.a.c(this);
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    public int c(String str) {
        AbstractC13042fc3.i(str, "name");
        Integer num = (Integer) this.j.get(str);
        if (num != null) {
            return num.intValue();
        }
        return -3;
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    public int d() {
        return this.c;
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    public String e(int i) {
        return this.f[i];
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof a) {
            SerialDescriptor serialDescriptor = (SerialDescriptor) obj;
            if (AbstractC13042fc3.d(i(), serialDescriptor.i()) && Arrays.equals(this.k, ((a) obj).k) && d() == serialDescriptor.d()) {
                int iD = d();
                for (int i = 0; i < iD; i++) {
                    if (AbstractC13042fc3.d(h(i).i(), serialDescriptor.h(i).i()) && AbstractC13042fc3.d(h(i).f(), serialDescriptor.h(i).f())) {
                    }
                }
                return true;
            }
        }
        return false;
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    public AbstractC19731qq6 f() {
        return this.b;
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    public List g(int i) {
        return this.h[i];
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    public List getAnnotations() {
        return this.d;
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    public SerialDescriptor h(int i) {
        return this.g[i];
    }

    public int hashCode() {
        return l();
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    public String i() {
        return this.a;
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    public boolean isInline() {
        return SerialDescriptor.a.b(this);
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    public boolean j(int i) {
        return this.i[i];
    }

    public String toString() {
        return AbstractC15401jX0.A0(AbstractC23053wG5.y(0, d()), ", ", i() + '(', Separators.RPAREN, 0, null, new b(), 24, null);
    }
}
