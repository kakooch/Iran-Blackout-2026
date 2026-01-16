package ir.nasim;

import ir.nasim.InterfaceC11814db6;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* renamed from: ir.nasim.eb6, reason: case insensitive filesystem */
/* loaded from: classes.dex */
final class C12426eb6 implements InterfaceC11814db6 {
    private final UA2 a;
    private final C7386Rm4 b;
    private C7386Rm4 c;

    /* renamed from: ir.nasim.eb6$a */
    public static final class a implements InterfaceC11814db6.a {
        final /* synthetic */ C7386Rm4 a;
        final /* synthetic */ String b;
        final /* synthetic */ SA2 c;

        a(C7386Rm4 c7386Rm4, String str, SA2 sa2) {
            this.a = c7386Rm4;
            this.b = str;
            this.c = sa2;
        }

        @Override // ir.nasim.InterfaceC11814db6.a
        public void a() {
            List list = (List) this.a.u(this.b);
            if (list != null) {
                list.remove(this.c);
            }
            List list2 = list;
            if (list2 == null || list2.isEmpty()) {
                return;
            }
            this.a.x(this.b, list);
        }
    }

    public C12426eb6(Map map, UA2 ua2) {
        this.a = ua2;
        this.b = (map == null || map.isEmpty()) ? null : AbstractC13035fb6.f(map);
    }

    @Override // ir.nasim.InterfaceC11814db6
    public boolean a(Object obj) {
        return ((Boolean) this.a.invoke(obj)).booleanValue();
    }

    /* JADX WARN: Removed duplicated region for block: B:35:0x0099  */
    @Override // ir.nasim.InterfaceC11814db6
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.util.Map d() {
        /*
            Method dump skipped, instructions count: 381
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C12426eb6.d():java.util.Map");
    }

    @Override // ir.nasim.InterfaceC11814db6
    public Object e(String str) {
        C7386Rm4 c7386Rm4;
        C7386Rm4 c7386Rm42 = this.b;
        List list = c7386Rm42 != null ? (List) c7386Rm42.u(str) : null;
        List list2 = list;
        if (list2 == null || list2.isEmpty()) {
            return null;
        }
        if (list.size() > 1 && (c7386Rm4 = this.b) != null) {
        }
        return list.get(0);
    }

    @Override // ir.nasim.InterfaceC11814db6
    public InterfaceC11814db6.a f(String str, SA2 sa2) {
        if (!(!AbstractC13035fb6.d(str))) {
            throw new IllegalArgumentException("Registered key is empty or blank".toString());
        }
        C7386Rm4 c7386Rm4B = this.c;
        if (c7386Rm4B == null) {
            c7386Rm4B = AbstractC22068uc6.b();
            this.c = c7386Rm4B;
        }
        Object objE = c7386Rm4B.e(str);
        if (objE == null) {
            objE = new ArrayList();
            c7386Rm4B.x(str, objE);
        }
        ((List) objE).add(sa2);
        return new a(c7386Rm4B, str, sa2);
    }
}
