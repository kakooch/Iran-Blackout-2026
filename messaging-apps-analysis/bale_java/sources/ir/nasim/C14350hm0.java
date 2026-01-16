package ir.nasim;

import ir.nasim.InterfaceC12269eK3;
import ir.nasim.InterfaceC6450Np2;
import ir.nasim.LG3;
import ir.nasim.VI1;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;

/* renamed from: ir.nasim.hm0, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public final class C14350hm0 implements InterfaceC13757gm0 {
    private final C16730lm0 b = new C16730lm0();

    /* renamed from: ir.nasim.hm0$a */
    /* synthetic */ class a extends DB2 implements UA2 {
        a(C16730lm0 c16730lm0) {
            super(1, c16730lm0);
        }

        @Override // ir.nasim.AbstractC15785kA0, ir.nasim.InterfaceC9916am3
        public final String getName() {
            return "loadResource";
        }

        @Override // ir.nasim.AbstractC15785kA0
        public final InterfaceC15551jm3 getOwner() {
            return AbstractC10882cM5.b(C16730lm0.class);
        }

        @Override // ir.nasim.AbstractC15785kA0
        public final String getSignature() {
            return "loadResource(Ljava/lang/String;)Ljava/io/InputStream;";
        }

        @Override // ir.nasim.UA2
        /* renamed from: y, reason: merged with bridge method [inline-methods] */
        public final InputStream invoke(String str) {
            AbstractC13042fc3.i(str, "p0");
            return ((C16730lm0) this.receiver).a(str);
        }
    }

    @Override // ir.nasim.InterfaceC13757gm0
    public AS4 a(ON6 on6, InterfaceC8507Wg4 interfaceC8507Wg4, Iterable iterable, InterfaceC8256Ve5 interfaceC8256Ve5, InterfaceC15427ja interfaceC15427ja, boolean z) {
        AbstractC13042fc3.i(on6, "storageManager");
        AbstractC13042fc3.i(interfaceC8507Wg4, "builtInsModule");
        AbstractC13042fc3.i(iterable, "classDescriptorFactories");
        AbstractC13042fc3.i(interfaceC8256Ve5, "platformDependentDeclarationFilter");
        AbstractC13042fc3.i(interfaceC15427ja, "additionalClassPartsProvider");
        return b(on6, interfaceC8507Wg4, PJ6.r, iterable, interfaceC8256Ve5, interfaceC15427ja, z, new a(this.b));
    }

    public final AS4 b(ON6 on6, InterfaceC8507Wg4 interfaceC8507Wg4, Set set, Iterable iterable, InterfaceC8256Ve5 interfaceC8256Ve5, InterfaceC15427ja interfaceC15427ja, boolean z, UA2 ua2) {
        AbstractC13042fc3.i(on6, "storageManager");
        AbstractC13042fc3.i(interfaceC8507Wg4, "module");
        AbstractC13042fc3.i(set, "packageFqNames");
        AbstractC13042fc3.i(iterable, "classDescriptorFactories");
        AbstractC13042fc3.i(interfaceC8256Ve5, "platformDependentDeclarationFilter");
        AbstractC13042fc3.i(interfaceC15427ja, "additionalClassPartsProvider");
        AbstractC13042fc3.i(ua2, "loadResource");
        Set<C9424Zw2> set2 = set;
        ArrayList arrayList = new ArrayList(AbstractC10976cX0.x(set2, 10));
        for (C9424Zw2 c9424Zw2 : set2) {
            String strN = C12530em0.n.n(c9424Zw2);
            InputStream inputStream = (InputStream) ua2.invoke(strN);
            if (inputStream == null) {
                throw new IllegalStateException(AbstractC13042fc3.q("Resource not found in classpath: ", strN));
            }
            arrayList.add(C15548jm0.n.a(c9424Zw2, on6, interfaceC8507Wg4, inputStream, z));
        }
        BS4 bs4 = new BS4(arrayList);
        C21830uC4 c21830uC4 = new C21830uC4(on6, interfaceC8507Wg4);
        VI1.a aVar = VI1.a.a;
        C10235bJ1 c10235bJ1 = new C10235bJ1(bs4);
        C12530em0 c12530em0 = C12530em0.n;
        C18582ou c18582ou = new C18582ou(interfaceC8507Wg4, c21830uC4, c12530em0);
        LG3.a aVar2 = LG3.a.a;
        InterfaceC11005ca2 interfaceC11005ca2 = InterfaceC11005ca2.a;
        AbstractC13042fc3.h(interfaceC11005ca2, "DO_NOTHING");
        TI1 ti1 = new TI1(on6, interfaceC8507Wg4, aVar, c10235bJ1, c18582ou, bs4, aVar2, interfaceC11005ca2, InterfaceC12269eK3.a.a, InterfaceC6450Np2.a.a, iterable, c21830uC4, InterfaceC24529ym1.a.a(), interfaceC15427ja, interfaceC8256Ve5, c12530em0.e(), null, new C11009ca6(on6, AbstractC10360bX0.m()), null, 327680, null);
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ((C15548jm0) it.next()).K0(ti1);
        }
        return bs4;
    }
}
