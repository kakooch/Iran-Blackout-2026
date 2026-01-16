package ir.nasim;

import android.gov.nist.core.Separators;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes4.dex */
public final class UF3 {
    private final List a;
    private final List b;
    private final List c;
    private final List d;
    private final List e;

    public UF3(List list, List list2, List list3, List list4, List list5) {
        AbstractC13042fc3.i(list, "history");
        AbstractC13042fc3.i(list2, "users");
        AbstractC13042fc3.i(list3, "userPeers");
        AbstractC13042fc3.i(list4, "groups");
        AbstractC13042fc3.i(list5, "groupPeers");
        this.a = list;
        this.b = list2;
        this.c = list3;
        this.d = list4;
        this.e = list5;
    }

    public final List a() {
        return this.e;
    }

    public final List b() {
        return this.d;
    }

    public final List c() {
        return this.a;
    }

    public final List d() {
        return this.c;
    }

    public final List e() {
        return this.b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof UF3)) {
            return false;
        }
        UF3 uf3 = (UF3) obj;
        return AbstractC13042fc3.d(this.a, uf3.a) && AbstractC13042fc3.d(this.b, uf3.b) && AbstractC13042fc3.d(this.c, uf3.c) && AbstractC13042fc3.d(this.d, uf3.d) && AbstractC13042fc3.d(this.e, uf3.e);
    }

    public int hashCode() {
        return (((((((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31) + this.d.hashCode()) * 31) + this.e.hashCode();
    }

    public String toString() {
        return "LoadHistory(history=" + this.a + ", users=" + this.b + ", userPeers=" + this.c + ", groups=" + this.d + ", groupPeers=" + this.e + Separators.RPAREN;
    }

    public UF3(VZ5 vz5) {
        AbstractC13042fc3.i(vz5, "rpcResponse");
        List listY = vz5.y();
        AbstractC13042fc3.h(listY, "getHistory(...)");
        List<C25247zz> list = listY;
        ArrayList arrayList = new ArrayList(AbstractC10976cX0.x(list, 10));
        for (C25247zz c25247zz : list) {
            AbstractC13042fc3.f(c25247zz);
            arrayList.add(C18732p92.M(c25247zz));
        }
        List listC = vz5.C();
        AbstractC13042fc3.h(listC, "getUsers(...)");
        List listZ = vz5.z();
        AbstractC13042fc3.h(listZ, "getUserPeers(...)");
        List listW = vz5.w();
        AbstractC13042fc3.h(listW, "getGroups(...)");
        List listU = vz5.u();
        AbstractC13042fc3.h(listU, "getGroupPeers(...)");
        this(arrayList, listC, listZ, listW, listU);
    }
}
