package ir.nasim;

import ir.nasim.InterfaceC11938do1;

/* renamed from: ir.nasim.po1, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public final class C19115po1 extends L0 {
    public static final a c = new a(null);
    private final String b;

    /* renamed from: ir.nasim.po1$a */
    public static final class a implements InterfaceC11938do1.c {
        private a() {
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    public C19115po1(String str) {
        super(c);
        this.b = str;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof C19115po1) && AbstractC13042fc3.d(this.b, ((C19115po1) obj).b);
    }

    public int hashCode() {
        return this.b.hashCode();
    }

    public String toString() {
        return "CoroutineName(" + this.b + ')';
    }

    public final String x0() {
        return this.b;
    }
}
