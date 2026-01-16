package ir.nasim;

import ir.nasim.C10732c63;
import ir.nasim.C24776zB3;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* loaded from: classes8.dex */
public class HW1 implements NW4 {
    private static final Set p = new LinkedHashSet(Arrays.asList(UU2.class, AbstractC24186yB3.class, C10116b63.class));
    private static final Map q;
    private CharSequence a;
    private boolean d;
    private boolean h;
    private final List i;
    private final InterfaceC10752c83 j;
    private final List k;
    private final C23193wW1 l;
    private int b = 0;
    private int c = 0;
    private int e = 0;
    private int f = 0;
    private int g = 0;
    private final Map m = new LinkedHashMap();
    private List n = new ArrayList();
    private Set o = new LinkedHashSet();

    private static class a implements PU3 {
        private final InterfaceC15498jh0 a;

        public a(InterfaceC15498jh0 interfaceC15498jh0) {
            this.a = interfaceC15498jh0;
        }

        @Override // ir.nasim.PU3
        public CharSequence a() {
            InterfaceC15498jh0 interfaceC15498jh0 = this.a;
            if (!(interfaceC15498jh0 instanceof C14807iW4)) {
                return null;
            }
            CharSequence charSequenceI = ((C14807iW4) interfaceC15498jh0).i();
            if (charSequenceI.length() == 0) {
                return null;
            }
            return charSequenceI;
        }

        @Override // ir.nasim.PU3
        public InterfaceC15498jh0 b() {
            return this.a;
        }
    }

    static {
        HashMap map = new HashMap();
        map.put(UU2.class, new VU2());
        map.put(AbstractC24186yB3.class, new C24776zB3.a());
        map.put(C10116b63.class, new C10732c63.a());
        q = Collections.unmodifiableMap(map);
    }

    public HW1(List list, InterfaceC10752c83 interfaceC10752c83, List list2) {
        this.i = list;
        this.j = interfaceC10752c83;
        this.k = list2;
        C23193wW1 c23193wW1 = new C23193wW1();
        this.l = c23193wW1;
        g(c23193wW1);
    }

    private void g(InterfaceC15498jh0 interfaceC15498jh0) {
        this.n.add(interfaceC15498jh0);
        this.o.add(interfaceC15498jh0);
    }

    private InterfaceC15498jh0 h(InterfaceC15498jh0 interfaceC15498jh0) {
        while (!f().a(interfaceC15498jh0.f())) {
            n(f());
        }
        f().f().b(interfaceC15498jh0.f());
        g(interfaceC15498jh0);
        return interfaceC15498jh0;
    }

    private void i(C14807iW4 c14807iW4) {
        for (C22401vA3 c22401vA3 : c14807iW4.j()) {
            c14807iW4.f().i(c22401vA3);
            String strN = c22401vA3.n();
            if (!this.m.containsKey(strN)) {
                this.m.put(strN, c22401vA3);
            }
        }
    }

    private void j() {
        CharSequence charSequenceSubSequence;
        if (this.d) {
            int i = this.b + 1;
            CharSequence charSequence = this.a;
            CharSequence charSequenceSubSequence2 = charSequence.subSequence(i, charSequence.length());
            int iA = OW4.a(this.c);
            StringBuilder sb = new StringBuilder(charSequenceSubSequence2.length() + iA);
            for (int i2 = 0; i2 < iA; i2++) {
                sb.append(' ');
            }
            sb.append(charSequenceSubSequence2);
            charSequenceSubSequence = sb.toString();
        } else {
            CharSequence charSequence2 = this.a;
            charSequenceSubSequence = charSequence2.subSequence(this.b, charSequence2.length());
        }
        f().g(charSequenceSubSequence);
    }

    private void k() {
        if (this.a.charAt(this.b) != '\t') {
            this.b++;
            this.c++;
        } else {
            this.b++;
            int i = this.c;
            this.c = i + OW4.a(i);
        }
    }

    public static List l(List list, Set set) {
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(list);
        Iterator it = set.iterator();
        while (it.hasNext()) {
            arrayList.add((InterfaceC16089kh0) q.get((Class) it.next()));
        }
        return arrayList;
    }

    private void m() {
        this.n.remove(r0.size() - 1);
    }

    private void n(InterfaceC15498jh0 interfaceC15498jh0) {
        if (f() == interfaceC15498jh0) {
            m();
        }
        if (interfaceC15498jh0 instanceof C14807iW4) {
            i((C14807iW4) interfaceC15498jh0);
        }
        interfaceC15498jh0.h();
    }

    private C19530qW1 o() {
        p(this.n);
        w();
        return this.l.f();
    }

    private void p(List list) {
        for (int size = list.size() - 1; size >= 0; size--) {
            n((InterfaceC15498jh0) list.get(size));
        }
    }

    private C17862nh0 q(InterfaceC15498jh0 interfaceC15498jh0) {
        a aVar = new a(interfaceC15498jh0);
        Iterator it = this.i.iterator();
        while (it.hasNext()) {
            AbstractC17271mh0 abstractC17271mh0A = ((InterfaceC16089kh0) it.next()).a(this, aVar);
            if (abstractC17271mh0A instanceof C17862nh0) {
                return (C17862nh0) abstractC17271mh0A;
            }
        }
        return null;
    }

    private void r() {
        int i = this.b;
        int i2 = this.c;
        this.h = true;
        int length = this.a.length();
        while (true) {
            if (i >= length) {
                break;
            }
            char cCharAt = this.a.charAt(i);
            if (cCharAt == '\t') {
                i++;
                i2 += 4 - (i2 % 4);
            } else if (cCharAt != ' ') {
                this.h = false;
                break;
            } else {
                i++;
                i2++;
            }
        }
        this.e = i;
        this.f = i2;
        this.g = i2 - this.c;
    }

    public static Set s() {
        return p;
    }

    /* JADX WARN: Code restructure failed: missing block: B:50:0x00f7, code lost:
    
        y(r10.e);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void t(java.lang.CharSequence r11) {
        /*
            Method dump skipped, instructions count: 307
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.HW1.t(java.lang.CharSequence):void");
    }

    private void v() {
        InterfaceC15498jh0 interfaceC15498jh0F = f();
        m();
        this.o.remove(interfaceC15498jh0F);
        if (interfaceC15498jh0F instanceof C14807iW4) {
            i((C14807iW4) interfaceC15498jh0F);
        }
        interfaceC15498jh0F.f().l();
    }

    private void w() {
        Z73 z73A = this.j.a(new C10136b83(this.k, this.m));
        Iterator it = this.o.iterator();
        while (it.hasNext()) {
            ((InterfaceC15498jh0) it.next()).c(z73A);
        }
    }

    private void x(int i) {
        int i2;
        int i3 = this.f;
        if (i >= i3) {
            this.b = this.e;
            this.c = i3;
        }
        int length = this.a.length();
        while (true) {
            i2 = this.c;
            if (i2 >= i || this.b == length) {
                break;
            } else {
                k();
            }
        }
        if (i2 <= i) {
            this.d = false;
            return;
        }
        this.b--;
        this.c = i;
        this.d = true;
    }

    private void y(int i) {
        int i2 = this.e;
        if (i >= i2) {
            this.b = i2;
            this.c = this.f;
        }
        int length = this.a.length();
        while (true) {
            int i3 = this.b;
            if (i3 >= i || i3 == length) {
                break;
            } else {
                k();
            }
        }
        this.d = false;
    }

    @Override // ir.nasim.NW4
    public int a() {
        return this.g;
    }

    @Override // ir.nasim.NW4
    public int b() {
        return this.c;
    }

    @Override // ir.nasim.NW4
    public boolean c() {
        return this.h;
    }

    @Override // ir.nasim.NW4
    public CharSequence d() {
        return this.a;
    }

    @Override // ir.nasim.NW4
    public int e() {
        return this.e;
    }

    @Override // ir.nasim.NW4
    public InterfaceC15498jh0 f() {
        return (InterfaceC15498jh0) this.n.get(r0.size() - 1);
    }

    @Override // ir.nasim.NW4
    public int getIndex() {
        return this.b;
    }

    public C19530qW1 u(String str) {
        int i = 0;
        while (true) {
            int iB = OW4.b(str, i);
            if (iB == -1) {
                break;
            }
            String strA = GW1.a(str.substring(i, iB));
            if (strA.isEmpty()) {
                t(strA + "\u200c");
            } else {
                t(strA);
            }
            i = iB + 1;
            if (i < str.length() && str.charAt(iB) == '\r' && str.charAt(i) == '\n') {
                i = iB + 2;
            }
        }
        if (!str.isEmpty() && (i == 0 || i < str.length())) {
            t(str.substring(i));
        }
        return o();
    }
}
