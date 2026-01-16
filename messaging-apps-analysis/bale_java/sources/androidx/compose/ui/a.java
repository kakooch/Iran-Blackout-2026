package androidx.compose.ui;

import androidx.compose.ui.e;
import ir.nasim.AbstractC13042fc3;
import ir.nasim.AbstractC8614Ws3;
import ir.nasim.InterfaceC14603iB2;
import ir.nasim.UA2;

/* loaded from: classes2.dex */
public final class a implements e {
    private final e b;
    private final e c;

    /* renamed from: androidx.compose.ui.a$a, reason: collision with other inner class name */
    static final class C0061a extends AbstractC8614Ws3 implements InterfaceC14603iB2 {
        public static final C0061a e = new C0061a();

        C0061a() {
            super(2);
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final String invoke(String str, e.b bVar) {
            if (str.length() == 0) {
                return bVar.toString();
            }
            return str + ", " + bVar;
        }
    }

    public a(e eVar, e eVar2) {
        this.b = eVar;
        this.c = eVar2;
    }

    @Override // androidx.compose.ui.e
    public Object a(Object obj, InterfaceC14603iB2 interfaceC14603iB2) {
        return this.c.a(this.b.a(obj, interfaceC14603iB2), interfaceC14603iB2);
    }

    @Override // androidx.compose.ui.e
    public boolean c(UA2 ua2) {
        return this.b.c(ua2) && this.c.c(ua2);
    }

    @Override // androidx.compose.ui.e
    public boolean d(UA2 ua2) {
        return this.b.d(ua2) || this.c.d(ua2);
    }

    public boolean equals(Object obj) {
        if (obj instanceof a) {
            a aVar = (a) obj;
            if (AbstractC13042fc3.d(this.b, aVar.b) && AbstractC13042fc3.d(this.c, aVar.c)) {
                return true;
            }
        }
        return false;
    }

    public final e f() {
        return this.c;
    }

    public int hashCode() {
        return this.b.hashCode() + (this.c.hashCode() * 31);
    }

    public final e k() {
        return this.b;
    }

    public String toString() {
        return '[' + ((String) a("", C0061a.e)) + ']';
    }
}
