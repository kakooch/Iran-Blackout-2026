package ir.nasim;

import ai.bale.proto.SetRpcStruct$ComposedRpc;

/* loaded from: classes2.dex */
public final class U11 {
    public static final U11 a = new U11();
    public static InterfaceC19933rB2 b = AbstractC19242q11.c(-1534814108, false, a.a);

    static final class a implements InterfaceC19933rB2 {
        public static final a a = new a();

        a() {
        }

        public final void a(C12561ep1 c12561ep1, androidx.navigation.e eVar, String str, UA2 ua2, InterfaceC15796kB2 interfaceC15796kB2, InterfaceC22053ub1 interfaceC22053ub1, int i) {
            AbstractC13042fc3.i(c12561ep1, "countries");
            AbstractC13042fc3.i(eVar, "navController");
            AbstractC13042fc3.i(str, "query");
            AbstractC13042fc3.i(ua2, "onChangeQuery");
            AbstractC13042fc3.i(interfaceC15796kB2, "onChangeCountry");
            AbstractC10940cT0.d(c12561ep1, eVar, str, ua2, interfaceC15796kB2, interfaceC22053ub1, C12561ep1.b | (i & 14) | (i & SetRpcStruct$ComposedRpc.SEARCH_CONTACTS_FIELD_NUMBER) | (i & 896) | (i & 7168) | (i & 57344));
        }

        @Override // ir.nasim.InterfaceC19933rB2
        public /* bridge */ /* synthetic */ Object l(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Object obj7) {
            a((C12561ep1) obj, (androidx.navigation.e) obj2, (String) obj3, (UA2) obj4, (InterfaceC15796kB2) obj5, (InterfaceC22053ub1) obj6, ((Number) obj7).intValue());
            return C19938rB7.a;
        }
    }

    public final InterfaceC19933rB2 a() {
        return b;
    }
}
