package ir.nasim;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/* renamed from: ir.nasim.jJ1, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public abstract class AbstractC15276jJ1 extends AbstractC14678iJ1 {
    private final AbstractC7310Re0 g;
    private final InterfaceC12258eJ1 h;
    private final C6926Po4 i;
    private final C5799Kw5 j;
    private C8938Xw5 k;
    private W24 l;

    /* renamed from: ir.nasim.jJ1$a */
    static final class a extends AbstractC8614Ws3 implements UA2 {
        a() {
            super(1);
        }

        @Override // ir.nasim.UA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final JH6 invoke(C24948zU0 c24948zU0) {
            AbstractC13042fc3.i(c24948zU0, "it");
            InterfaceC12258eJ1 interfaceC12258eJ1 = AbstractC15276jJ1.this.h;
            if (interfaceC12258eJ1 != null) {
                return interfaceC12258eJ1;
            }
            JH6 jh6 = JH6.a;
            AbstractC13042fc3.h(jh6, "NO_SOURCE");
            return jh6;
        }
    }

    /* renamed from: ir.nasim.jJ1$b */
    static final class b extends AbstractC8614Ws3 implements SA2 {
        b() {
            super(0);
        }

        @Override // ir.nasim.SA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Collection invoke() {
            Collection collectionB = AbstractC15276jJ1.this.I0().b();
            ArrayList arrayList = new ArrayList();
            for (Object obj : collectionB) {
                C24948zU0 c24948zU0 = (C24948zU0) obj;
                if (!c24948zU0.l() && !C23764xU0.c.a().contains(c24948zU0)) {
                    arrayList.add(obj);
                }
            }
            ArrayList arrayList2 = new ArrayList(AbstractC10976cX0.x(arrayList, 10));
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                arrayList2.add(((C24948zU0) it.next()).j());
            }
            return arrayList2;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AbstractC15276jJ1(C9424Zw2 c9424Zw2, ON6 on6, InterfaceC8507Wg4 interfaceC8507Wg4, C8938Xw5 c8938Xw5, AbstractC7310Re0 abstractC7310Re0, InterfaceC12258eJ1 interfaceC12258eJ1) {
        super(c9424Zw2, on6, interfaceC8507Wg4);
        AbstractC13042fc3.i(c9424Zw2, "fqName");
        AbstractC13042fc3.i(on6, "storageManager");
        AbstractC13042fc3.i(interfaceC8507Wg4, "module");
        AbstractC13042fc3.i(c8938Xw5, "proto");
        AbstractC13042fc3.i(abstractC7310Re0, "metadataVersion");
        this.g = abstractC7310Re0;
        this.h = interfaceC12258eJ1;
        C10030ax5 c10030ax5S = c8938Xw5.S();
        AbstractC13042fc3.h(c10030ax5S, "proto.strings");
        C9427Zw5 c9427Zw5R = c8938Xw5.R();
        AbstractC13042fc3.h(c9427Zw5R, "proto.qualifiedNames");
        C6926Po4 c6926Po4 = new C6926Po4(c10030ax5S, c9427Zw5R);
        this.i = c6926Po4;
        this.j = new C5799Kw5(c8938Xw5, c6926Po4, abstractC7310Re0, new a());
        this.k = c8938Xw5;
    }

    @Override // ir.nasim.AbstractC14678iJ1
    public void K0(TI1 ti1) {
        AbstractC13042fc3.i(ti1, "components");
        C8938Xw5 c8938Xw5 = this.k;
        if (c8938Xw5 == null) {
            throw new IllegalStateException("Repeated call to DeserializedPackageFragmentImpl::initialize".toString());
        }
        this.k = null;
        C8652Ww5 c8652Ww5Q = c8938Xw5.Q();
        AbstractC13042fc3.h(c8652Ww5Q, "proto.`package`");
        this.l = new C15867kJ1(this, c8652Ww5Q, this.i, this.g, this.h, ti1, new b());
    }

    @Override // ir.nasim.AbstractC14678iJ1
    /* renamed from: M0, reason: merged with bridge method [inline-methods] */
    public C5799Kw5 I0() {
        return this.j;
    }

    @Override // ir.nasim.InterfaceC24340yS4
    public W24 o() {
        W24 w24 = this.l;
        if (w24 != null) {
            return w24;
        }
        AbstractC13042fc3.y("_memberScope");
        throw null;
    }
}
