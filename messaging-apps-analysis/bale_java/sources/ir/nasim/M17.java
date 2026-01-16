package ir.nasim;

import java.util.Collection;

/* loaded from: classes8.dex */
public interface M17 {

    public static final class a implements M17 {
        public static final a a = new a();

        private a() {
        }

        @Override // ir.nasim.M17
        public Collection a(InterfaceC13882gy7 interfaceC13882gy7, Collection collection, UA2 ua2, UA2 ua22) {
            AbstractC13042fc3.i(interfaceC13882gy7, "currentTypeConstructor");
            AbstractC13042fc3.i(collection, "superTypes");
            AbstractC13042fc3.i(ua2, "neighbors");
            AbstractC13042fc3.i(ua22, "reportLoop");
            return collection;
        }
    }

    Collection a(InterfaceC13882gy7 interfaceC13882gy7, Collection collection, UA2 ua2, UA2 ua22);
}
