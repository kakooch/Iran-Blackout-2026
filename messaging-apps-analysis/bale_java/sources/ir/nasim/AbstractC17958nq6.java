package ir.nasim;

import ir.nasim.IZ6;
import kotlinx.serialization.descriptors.SerialDescriptor;

/* renamed from: ir.nasim.nq6, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public abstract class AbstractC17958nq6 {

    /* renamed from: ir.nasim.nq6$a */
    static final class a extends AbstractC8614Ws3 implements UA2 {
        public static final a e = new a();

        a() {
            super(1);
        }

        public final void a(FU0 fu0) {
            AbstractC13042fc3.i(fu0, "$this$null");
        }

        @Override // ir.nasim.UA2
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a((FU0) obj);
            return C19938rB7.a;
        }
    }

    public static final SerialDescriptor a(String str, AbstractC25167zq5 abstractC25167zq5) {
        AbstractC13042fc3.i(str, "serialName");
        AbstractC13042fc3.i(abstractC25167zq5, "kind");
        if (!AbstractC20762sZ6.n0(str)) {
            return AbstractC5745Kq5.a(str, abstractC25167zq5);
        }
        throw new IllegalArgumentException("Blank serial names are prohibited".toString());
    }

    public static final SerialDescriptor b(String str, AbstractC19731qq6 abstractC19731qq6, SerialDescriptor[] serialDescriptorArr, UA2 ua2) {
        AbstractC13042fc3.i(str, "serialName");
        AbstractC13042fc3.i(abstractC19731qq6, "kind");
        AbstractC13042fc3.i(serialDescriptorArr, "typeParameters");
        AbstractC13042fc3.i(ua2, "builder");
        if (!(!AbstractC20762sZ6.n0(str))) {
            throw new IllegalArgumentException("Blank serial names are prohibited".toString());
        }
        if (!(!AbstractC13042fc3.d(abstractC19731qq6, IZ6.a.a))) {
            throw new IllegalArgumentException("For StructureKind.CLASS please use 'buildClassSerialDescriptor' instead".toString());
        }
        FU0 fu0 = new FU0(str);
        ua2.invoke(fu0);
        return new kotlinx.serialization.descriptors.a(str, abstractC19731qq6, fu0.f().size(), AbstractC10242bK.f1(serialDescriptorArr), fu0);
    }

    public static /* synthetic */ SerialDescriptor c(String str, AbstractC19731qq6 abstractC19731qq6, SerialDescriptor[] serialDescriptorArr, UA2 ua2, int i, Object obj) {
        if ((i & 8) != 0) {
            ua2 = a.e;
        }
        return b(str, abstractC19731qq6, serialDescriptorArr, ua2);
    }
}
