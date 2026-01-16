package ir.nasim;

import com.google.gson.reflect.TypeToken;
import ir.nasim.ID1;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/* loaded from: classes3.dex */
public final class LS2 {
    private C8469Wc2 a = C8469Wc2.g;
    private EnumC19415qJ3 b = EnumC19415qJ3.a;
    private InterfaceC3801Ck2 c = EnumC3567Bk2.a;
    private final Map d = new HashMap();
    private final List e = new ArrayList();
    private final List f = new ArrayList();
    private boolean g = false;
    private String h = KS2.z;
    private int i = 2;
    private int j = 2;
    private boolean k = false;
    private boolean l = false;
    private boolean m = true;
    private boolean n = false;
    private boolean o = false;
    private boolean p = false;
    private boolean q = true;
    private InterfaceC19742qr7 r = KS2.B;
    private InterfaceC19742qr7 s = KS2.C;
    private final LinkedList t = new LinkedList();

    private void a(String str, int i, int i2, List list) {
        InterfaceC6537Nx7 interfaceC6537Nx7B;
        InterfaceC6537Nx7 interfaceC6537Nx7B2;
        boolean z = AbstractC21895uJ6.a;
        InterfaceC6537Nx7 interfaceC6537Nx7A = null;
        if (str != null && !str.trim().isEmpty()) {
            interfaceC6537Nx7B = ID1.b.b.b(str);
            if (z) {
                interfaceC6537Nx7A = AbstractC21895uJ6.c.b(str);
                interfaceC6537Nx7B2 = AbstractC21895uJ6.b.b(str);
            } else {
                interfaceC6537Nx7B2 = null;
            }
        } else {
            if (i == 2 || i2 == 2) {
                return;
            }
            InterfaceC6537Nx7 interfaceC6537Nx7A2 = ID1.b.b.a(i, i2);
            if (z) {
                interfaceC6537Nx7A = AbstractC21895uJ6.c.a(i, i2);
                InterfaceC6537Nx7 interfaceC6537Nx7A3 = AbstractC21895uJ6.b.a(i, i2);
                interfaceC6537Nx7B = interfaceC6537Nx7A2;
                interfaceC6537Nx7B2 = interfaceC6537Nx7A3;
            } else {
                interfaceC6537Nx7B = interfaceC6537Nx7A2;
                interfaceC6537Nx7B2 = null;
            }
        }
        list.add(interfaceC6537Nx7B);
        if (z) {
            list.add(interfaceC6537Nx7A);
            list.add(interfaceC6537Nx7B2);
        }
    }

    public KS2 b() {
        ArrayList arrayList = new ArrayList(this.e.size() + this.f.size() + 3);
        arrayList.addAll(this.e);
        Collections.reverse(arrayList);
        ArrayList arrayList2 = new ArrayList(this.f);
        Collections.reverse(arrayList2);
        arrayList.addAll(arrayList2);
        a(this.h, this.i, this.j, arrayList);
        return new KS2(this.a, this.c, new HashMap(this.d), this.g, this.k, this.o, this.m, this.n, this.p, this.l, this.q, this.b, this.h, this.i, this.j, new ArrayList(this.e), new ArrayList(this.f), arrayList, this.r, this.s, new ArrayList(this.t));
    }

    public LS2 c(Type type, Object obj) {
        Objects.requireNonNull(type);
        AbstractC9457a.a((obj instanceof InterfaceC22145uk3) || (obj instanceof AbstractC6277Mx7));
        if (obj instanceof InterfaceC22145uk3) {
            this.e.add(C10640bw7.g(TypeToken.b(type), obj));
        }
        if (obj instanceof AbstractC6277Mx7) {
            this.e.add(AbstractC7010Px7.a(TypeToken.b(type), (AbstractC6277Mx7) obj));
        }
        return this;
    }
}
