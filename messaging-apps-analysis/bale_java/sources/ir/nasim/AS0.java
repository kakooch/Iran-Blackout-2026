package ir.nasim;

import ir.nasim.AbstractC20693sS0;
import java.util.Collection;

/* loaded from: classes8.dex */
public final class AS0 {
    private final C6432No4 a;
    private final C20644sM5 b;
    private final Collection c;
    private final UA2 d;
    private final InterfaceC15947kS0[] e;

    static final class a extends AbstractC8614Ws3 implements UA2 {
        public static final a e = new a();

        a() {
            super(1);
        }

        @Override // ir.nasim.UA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Void invoke(AB2 ab2) {
            AbstractC13042fc3.i(ab2, "<this>");
            return null;
        }
    }

    static final class b extends AbstractC8614Ws3 implements UA2 {
        public static final b e = new b();

        b() {
            super(1);
        }

        @Override // ir.nasim.UA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Void invoke(AB2 ab2) {
            AbstractC13042fc3.i(ab2, "<this>");
            return null;
        }
    }

    static final class c extends AbstractC8614Ws3 implements UA2 {
        public static final c e = new c();

        c() {
            super(1);
        }

        @Override // ir.nasim.UA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Void invoke(AB2 ab2) {
            AbstractC13042fc3.i(ab2, "<this>");
            return null;
        }
    }

    private AS0(C6432No4 c6432No4, C20644sM5 c20644sM5, Collection collection, UA2 ua2, InterfaceC15947kS0... interfaceC15947kS0Arr) {
        this.a = c6432No4;
        this.b = c20644sM5;
        this.c = collection;
        this.d = ua2;
        this.e = interfaceC15947kS0Arr;
    }

    public final AbstractC20693sS0 a(AB2 ab2) {
        AbstractC13042fc3.i(ab2, "functionDescriptor");
        InterfaceC15947kS0[] interfaceC15947kS0Arr = this.e;
        int length = interfaceC15947kS0Arr.length;
        int i = 0;
        while (i < length) {
            InterfaceC15947kS0 interfaceC15947kS0 = interfaceC15947kS0Arr[i];
            i++;
            String strB = interfaceC15947kS0.b(ab2);
            if (strB != null) {
                return new AbstractC20693sS0.b(strB);
            }
        }
        String str = (String) this.d.invoke(ab2);
        return str != null ? new AbstractC20693sS0.b(str) : AbstractC20693sS0.c.b;
    }

    public final boolean b(AB2 ab2) {
        AbstractC13042fc3.i(ab2, "functionDescriptor");
        if (this.a != null && !AbstractC13042fc3.d(ab2.getName(), this.a)) {
            return false;
        }
        if (this.b != null) {
            String strH = ab2.getName().h();
            AbstractC13042fc3.h(strH, "functionDescriptor.name.asString()");
            if (!this.b.g(strH)) {
                return false;
            }
        }
        Collection collection = this.c;
        return collection == null || collection.contains(ab2.getName());
    }

    public /* synthetic */ AS0(C6432No4 c6432No4, InterfaceC15947kS0[] interfaceC15947kS0Arr, UA2 ua2, int i, ED1 ed1) {
        this(c6432No4, interfaceC15947kS0Arr, (i & 4) != 0 ? a.e : ua2);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public AS0(C6432No4 c6432No4, InterfaceC15947kS0[] interfaceC15947kS0Arr, UA2 ua2) {
        AbstractC13042fc3.i(c6432No4, "name");
        AbstractC13042fc3.i(interfaceC15947kS0Arr, "checks");
        AbstractC13042fc3.i(ua2, "additionalChecks");
        InterfaceC15947kS0[] interfaceC15947kS0Arr2 = new InterfaceC15947kS0[interfaceC15947kS0Arr.length];
        System.arraycopy(interfaceC15947kS0Arr, 0, interfaceC15947kS0Arr2, 0, interfaceC15947kS0Arr.length);
        this(c6432No4, (C20644sM5) null, (Collection) null, ua2, interfaceC15947kS0Arr2);
    }

    public /* synthetic */ AS0(C20644sM5 c20644sM5, InterfaceC15947kS0[] interfaceC15947kS0Arr, UA2 ua2, int i, ED1 ed1) {
        this(c20644sM5, interfaceC15947kS0Arr, (i & 4) != 0 ? b.e : ua2);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public AS0(C20644sM5 c20644sM5, InterfaceC15947kS0[] interfaceC15947kS0Arr, UA2 ua2) {
        AbstractC13042fc3.i(c20644sM5, "regex");
        AbstractC13042fc3.i(interfaceC15947kS0Arr, "checks");
        AbstractC13042fc3.i(ua2, "additionalChecks");
        InterfaceC15947kS0[] interfaceC15947kS0Arr2 = new InterfaceC15947kS0[interfaceC15947kS0Arr.length];
        System.arraycopy(interfaceC15947kS0Arr, 0, interfaceC15947kS0Arr2, 0, interfaceC15947kS0Arr.length);
        this((C6432No4) null, c20644sM5, (Collection) null, ua2, interfaceC15947kS0Arr2);
    }

    public /* synthetic */ AS0(Collection collection, InterfaceC15947kS0[] interfaceC15947kS0Arr, UA2 ua2, int i, ED1 ed1) {
        this(collection, interfaceC15947kS0Arr, (i & 4) != 0 ? c.e : ua2);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public AS0(Collection collection, InterfaceC15947kS0[] interfaceC15947kS0Arr, UA2 ua2) {
        AbstractC13042fc3.i(collection, "nameList");
        AbstractC13042fc3.i(interfaceC15947kS0Arr, "checks");
        AbstractC13042fc3.i(ua2, "additionalChecks");
        InterfaceC15947kS0[] interfaceC15947kS0Arr2 = new InterfaceC15947kS0[interfaceC15947kS0Arr.length];
        System.arraycopy(interfaceC15947kS0Arr, 0, interfaceC15947kS0Arr2, 0, interfaceC15947kS0Arr.length);
        this((C6432No4) null, (C20644sM5) null, collection, ua2, interfaceC15947kS0Arr2);
    }
}
