package ir.nasim;

import ir.nasim.InterfaceC8507Wg4;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.reflect.jvm.internal.impl.descriptors.InvalidModuleException;

/* renamed from: ir.nasim.Xg4, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public final class C8773Xg4 extends AbstractC13413gB1 implements InterfaceC8507Wg4 {
    private final ON6 c;
    private final AbstractC19738qr3 d;
    private final C6432No4 e;
    private final Map f;
    private InterfaceC8039Ug4 g;
    private AS4 h;
    private boolean i;
    private final I34 j;
    private final InterfaceC9173Yu3 k;

    /* renamed from: ir.nasim.Xg4$a */
    static final class a extends AbstractC8614Ws3 implements SA2 {
        a() {
            super(0);
        }

        @Override // ir.nasim.SA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final C6312Nb1 invoke() {
            InterfaceC8039Ug4 interfaceC8039Ug4 = C8773Xg4.this.g;
            C8773Xg4 c8773Xg4 = C8773Xg4.this;
            if (interfaceC8039Ug4 == null) {
                throw new AssertionError("Dependencies of module " + c8773Xg4.N0() + " were not set before querying module content");
            }
            List listA = interfaceC8039Ug4.a();
            listA.contains(C8773Xg4.this);
            List list = listA;
            Iterator it = list.iterator();
            while (it.hasNext()) {
                ((C8773Xg4) it.next()).R0();
            }
            ArrayList arrayList = new ArrayList(AbstractC10976cX0.x(list, 10));
            Iterator it2 = list.iterator();
            while (it2.hasNext()) {
                AS4 as4 = ((C8773Xg4) it2.next()).h;
                AbstractC13042fc3.f(as4);
                arrayList.add(as4);
            }
            return new C6312Nb1(arrayList);
        }
    }

    /* renamed from: ir.nasim.Xg4$b */
    static final class b extends AbstractC8614Ws3 implements UA2 {
        b() {
            super(1);
        }

        @Override // ir.nasim.UA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final OS4 invoke(C9424Zw2 c9424Zw2) {
            AbstractC13042fc3.i(c9424Zw2, "fqName");
            C8773Xg4 c8773Xg4 = C8773Xg4.this;
            return new C20406rx3(c8773Xg4, c9424Zw2, c8773Xg4.c);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public C8773Xg4(C6432No4 c6432No4, ON6 on6, AbstractC19738qr3 abstractC19738qr3, AbstractC25099zj7 abstractC25099zj7) {
        this(c6432No4, on6, abstractC19738qr3, abstractC25099zj7, null, null, 48, null);
        AbstractC13042fc3.i(c6432No4, "moduleName");
        AbstractC13042fc3.i(on6, "storageManager");
        AbstractC13042fc3.i(abstractC19738qr3, "builtIns");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String N0() {
        String string = getName().toString();
        AbstractC13042fc3.h(string, "name.toString()");
        return string;
    }

    private final C6312Nb1 P0() {
        return (C6312Nb1) this.k.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean R0() {
        return this.h != null;
    }

    public void M0() {
        if (!S0()) {
            throw new InvalidModuleException(AbstractC13042fc3.q("Accessing invalid module descriptor ", this));
        }
    }

    public final AS4 O0() {
        M0();
        return P0();
    }

    public final void Q0(AS4 as4) {
        AbstractC13042fc3.i(as4, "providerForModuleContent");
        R0();
        this.h = as4;
    }

    public boolean S0() {
        return this.i;
    }

    public final void T0(InterfaceC8039Ug4 interfaceC8039Ug4) {
        AbstractC13042fc3.i(interfaceC8039Ug4, "dependencies");
        this.g = interfaceC8039Ug4;
    }

    public final void U0(List list) {
        AbstractC13042fc3.i(list, "descriptors");
        V0(list, AbstractC4597Fu6.d());
    }

    public final void V0(List list, Set set) {
        AbstractC13042fc3.i(list, "descriptors");
        AbstractC13042fc3.i(set, "friends");
        T0(new C8273Vg4(list, set, AbstractC10360bX0.m(), AbstractC4597Fu6.d()));
    }

    public final void W0(C8773Xg4... c8773Xg4Arr) {
        AbstractC13042fc3.i(c8773Xg4Arr, "descriptors");
        U0(AbstractC10242bK.f1(c8773Xg4Arr));
    }

    @Override // ir.nasim.InterfaceC8507Wg4
    public Object a0(C7332Rg4 c7332Rg4) {
        AbstractC13042fc3.i(c7332Rg4, "capability");
        return this.f.get(c7332Rg4);
    }

    @Override // ir.nasim.InterfaceC12795fB1
    public InterfaceC12795fB1 b() {
        return InterfaceC8507Wg4.a.b(this);
    }

    @Override // ir.nasim.InterfaceC8507Wg4
    public Collection l(C9424Zw2 c9424Zw2, UA2 ua2) {
        AbstractC13042fc3.i(c9424Zw2, "fqName");
        AbstractC13042fc3.i(ua2, "nameFilter");
        M0();
        return O0().l(c9424Zw2, ua2);
    }

    @Override // ir.nasim.InterfaceC8507Wg4
    public AbstractC19738qr3 n() {
        return this.d;
    }

    @Override // ir.nasim.InterfaceC12795fB1
    public Object q0(InterfaceC15204jB1 interfaceC15204jB1, Object obj) {
        return InterfaceC8507Wg4.a.a(this, interfaceC15204jB1, obj);
    }

    @Override // ir.nasim.InterfaceC8507Wg4
    public List x0() {
        InterfaceC8039Ug4 interfaceC8039Ug4 = this.g;
        if (interfaceC8039Ug4 != null) {
            return interfaceC8039Ug4.b();
        }
        throw new AssertionError("Dependencies of module " + N0() + " were not set");
    }

    @Override // ir.nasim.InterfaceC8507Wg4
    public boolean z(InterfaceC8507Wg4 interfaceC8507Wg4) {
        AbstractC13042fc3.i(interfaceC8507Wg4, "targetModule");
        if (AbstractC13042fc3.d(this, interfaceC8507Wg4)) {
            return true;
        }
        InterfaceC8039Ug4 interfaceC8039Ug4 = this.g;
        AbstractC13042fc3.f(interfaceC8039Ug4);
        return AbstractC15401jX0.i0(interfaceC8039Ug4.c(), interfaceC8507Wg4) || x0().contains(interfaceC8507Wg4) || interfaceC8507Wg4.x0().contains(this);
    }

    @Override // ir.nasim.InterfaceC8507Wg4
    public OS4 z0(C9424Zw2 c9424Zw2) {
        AbstractC13042fc3.i(c9424Zw2, "fqName");
        M0();
        return (OS4) this.j.invoke(c9424Zw2);
    }

    public /* synthetic */ C8773Xg4(C6432No4 c6432No4, ON6 on6, AbstractC19738qr3 abstractC19738qr3, AbstractC25099zj7 abstractC25099zj7, Map map, C6432No4 c6432No42, int i, ED1 ed1) {
        this(c6432No4, on6, abstractC19738qr3, (i & 8) != 0 ? null : abstractC25099zj7, (i & 16) != 0 ? AbstractC20051rO3.k() : map, (i & 32) != 0 ? null : c6432No42);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C8773Xg4(C6432No4 c6432No4, ON6 on6, AbstractC19738qr3 abstractC19738qr3, AbstractC25099zj7 abstractC25099zj7, Map map, C6432No4 c6432No42) {
        super(InterfaceC4356Eu.W.b(), c6432No4);
        AbstractC13042fc3.i(c6432No4, "moduleName");
        AbstractC13042fc3.i(on6, "storageManager");
        AbstractC13042fc3.i(abstractC19738qr3, "builtIns");
        AbstractC13042fc3.i(map, "capabilities");
        this.c = on6;
        this.d = abstractC19738qr3;
        this.e = c6432No42;
        if (c6432No4.q()) {
            Map mapA = AbstractC20051rO3.A(map);
            this.f = mapA;
            mapA.put(AbstractC5518Jr3.a(), new C13507gL5(null));
            this.i = true;
            this.j = on6.e(new b());
            this.k = AbstractC13269fw3.a(new a());
            return;
        }
        throw new IllegalArgumentException(AbstractC13042fc3.q("Module name must be special: ", c6432No4));
    }
}
