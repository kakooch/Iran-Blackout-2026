package kotlinx.serialization.internal;

import android.gov.nist.core.Separators;
import ir.nasim.AbstractC10360bX0;
import ir.nasim.AbstractC13042fc3;
import ir.nasim.AbstractC13269fw3;
import ir.nasim.AbstractC15401jX0;
import ir.nasim.AbstractC19630qg5;
import ir.nasim.AbstractC19731qq6;
import ir.nasim.AbstractC20051rO3;
import ir.nasim.AbstractC20237rg5;
import ir.nasim.AbstractC23053wG5;
import ir.nasim.AbstractC4227Ef5;
import ir.nasim.AbstractC8614Ws3;
import ir.nasim.ED1;
import ir.nasim.EnumC4870Gx3;
import ir.nasim.IZ6;
import ir.nasim.InterfaceC8886Xt0;
import ir.nasim.InterfaceC9173Yu3;
import ir.nasim.NE2;
import ir.nasim.SA2;
import ir.nasim.UA2;
import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.descriptors.SerialDescriptor;

/* loaded from: classes8.dex */
public class PluginGeneratedSerialDescriptor implements SerialDescriptor, InterfaceC8886Xt0 {
    private final String a;
    private final NE2 b;
    private final int c;
    private int d;
    private final String[] e;
    private final List[] f;
    private List g;
    private final boolean[] h;
    private Map i;
    private final InterfaceC9173Yu3 j;
    private final InterfaceC9173Yu3 k;
    private final InterfaceC9173Yu3 l;

    static final class a extends AbstractC8614Ws3 implements SA2 {
        a() {
            super(0);
        }

        @Override // ir.nasim.SA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Integer invoke() {
            PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = PluginGeneratedSerialDescriptor.this;
            return Integer.valueOf(AbstractC19630qg5.a(pluginGeneratedSerialDescriptor, pluginGeneratedSerialDescriptor.p()));
        }
    }

    static final class b extends AbstractC8614Ws3 implements SA2 {
        b() {
            super(0);
        }

        @Override // ir.nasim.SA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final KSerializer[] invoke() {
            KSerializer[] kSerializerArrChildSerializers;
            NE2 ne2 = PluginGeneratedSerialDescriptor.this.b;
            return (ne2 == null || (kSerializerArrChildSerializers = ne2.childSerializers()) == null) ? AbstractC20237rg5.a : kSerializerArrChildSerializers;
        }
    }

    static final class c extends AbstractC8614Ws3 implements UA2 {
        c() {
            super(1);
        }

        public final CharSequence a(int i) {
            return PluginGeneratedSerialDescriptor.this.e(i) + ": " + PluginGeneratedSerialDescriptor.this.h(i).i();
        }

        @Override // ir.nasim.UA2
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            return a(((Number) obj).intValue());
        }
    }

    static final class d extends AbstractC8614Ws3 implements SA2 {
        d() {
            super(0);
        }

        @Override // ir.nasim.SA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final SerialDescriptor[] invoke() {
            ArrayList arrayList;
            KSerializer[] kSerializerArrTypeParametersSerializers;
            NE2 ne2 = PluginGeneratedSerialDescriptor.this.b;
            if (ne2 == null || (kSerializerArrTypeParametersSerializers = ne2.typeParametersSerializers()) == null) {
                arrayList = null;
            } else {
                arrayList = new ArrayList(kSerializerArrTypeParametersSerializers.length);
                for (KSerializer kSerializer : kSerializerArrTypeParametersSerializers) {
                    arrayList.add(kSerializer.getDescriptor());
                }
            }
            return AbstractC4227Ef5.b(arrayList);
        }
    }

    public PluginGeneratedSerialDescriptor(String str, NE2 ne2, int i) {
        AbstractC13042fc3.i(str, "serialName");
        this.a = str;
        this.b = ne2;
        this.c = i;
        this.d = -1;
        String[] strArr = new String[i];
        for (int i2 = 0; i2 < i; i2++) {
            strArr[i2] = "[UNINITIALIZED]";
        }
        this.e = strArr;
        int i3 = this.c;
        this.f = new List[i3];
        this.h = new boolean[i3];
        this.i = AbstractC20051rO3.k();
        EnumC4870Gx3 enumC4870Gx3 = EnumC4870Gx3.b;
        this.j = AbstractC13269fw3.b(enumC4870Gx3, new b());
        this.k = AbstractC13269fw3.b(enumC4870Gx3, new d());
        this.l = AbstractC13269fw3.b(enumC4870Gx3, new a());
    }

    public static /* synthetic */ void m(PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor, String str, boolean z, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: addElement");
        }
        if ((i & 2) != 0) {
            z = false;
        }
        pluginGeneratedSerialDescriptor.l(str, z);
    }

    private final Map n() {
        HashMap map = new HashMap();
        int length = this.e.length;
        for (int i = 0; i < length; i++) {
            map.put(this.e[i], Integer.valueOf(i));
        }
        return map;
    }

    private final KSerializer[] o() {
        return (KSerializer[]) this.j.getValue();
    }

    private final int q() {
        return ((Number) this.l.getValue()).intValue();
    }

    @Override // ir.nasim.InterfaceC8886Xt0
    public Set a() {
        return this.i.keySet();
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    public boolean b() {
        return SerialDescriptor.a.c(this);
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    public int c(String str) {
        AbstractC13042fc3.i(str, "name");
        Integer num = (Integer) this.i.get(str);
        if (num != null) {
            return num.intValue();
        }
        return -3;
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    public final int d() {
        return this.c;
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    public String e(int i) {
        return this.e[i];
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof PluginGeneratedSerialDescriptor) {
            SerialDescriptor serialDescriptor = (SerialDescriptor) obj;
            if (AbstractC13042fc3.d(i(), serialDescriptor.i()) && Arrays.equals(p(), ((PluginGeneratedSerialDescriptor) obj).p()) && d() == serialDescriptor.d()) {
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
        return IZ6.a.a;
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    public List g(int i) {
        List list = this.f[i];
        return list == null ? AbstractC10360bX0.m() : list;
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    public List getAnnotations() {
        List list = this.g;
        return list == null ? AbstractC10360bX0.m() : list;
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    public SerialDescriptor h(int i) {
        return o()[i].getDescriptor();
    }

    public int hashCode() {
        return q();
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
        return this.h[i];
    }

    public final void l(String str, boolean z) {
        AbstractC13042fc3.i(str, "name");
        String[] strArr = this.e;
        int i = this.d + 1;
        this.d = i;
        strArr[i] = str;
        this.h[i] = z;
        this.f[i] = null;
        if (i == this.c - 1) {
            this.i = n();
        }
    }

    public final SerialDescriptor[] p() {
        return (SerialDescriptor[]) this.k.getValue();
    }

    public final void r(Annotation annotation) {
        AbstractC13042fc3.i(annotation, "annotation");
        List arrayList = this.f[this.d];
        if (arrayList == null) {
            arrayList = new ArrayList(1);
            this.f[this.d] = arrayList;
        }
        arrayList.add(annotation);
    }

    public final void s(Annotation annotation) {
        AbstractC13042fc3.i(annotation, "a");
        if (this.g == null) {
            this.g = new ArrayList(1);
        }
        List list = this.g;
        AbstractC13042fc3.f(list);
        list.add(annotation);
    }

    public String toString() {
        return AbstractC15401jX0.A0(AbstractC23053wG5.y(0, this.c), ", ", i() + '(', Separators.RPAREN, 0, null, new c(), 24, null);
    }

    public /* synthetic */ PluginGeneratedSerialDescriptor(String str, NE2 ne2, int i, int i2, ED1 ed1) {
        this(str, (i2 & 2) != 0 ? null : ne2, i);
    }
}
