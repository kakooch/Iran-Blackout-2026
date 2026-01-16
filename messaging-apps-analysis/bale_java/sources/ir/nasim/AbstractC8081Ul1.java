package ir.nasim;

import android.graphics.drawable.Drawable;
import ir.nasim.AbstractC22943w5;
import ir.nasim.F5;
import java.util.ArrayList;
import java.util.List;

/* renamed from: ir.nasim.Ul1, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public abstract class AbstractC8081Ul1 {

    /* renamed from: ir.nasim.Ul1$a */
    public static final class a extends AbstractC8081Ul1 {
        private final ArrayList a;

        public a() {
            super(null);
            this.a = new ArrayList();
        }

        @Override // ir.nasim.AbstractC8081Ul1
        public boolean b() {
            return this.a.isEmpty();
        }

        public final a c(String str, String str2, Drawable drawable, String str3, SA2 sa2) {
            AbstractC13042fc3.i(str, "title");
            AbstractC13042fc3.i(str2, "iconPath");
            AbstractC13042fc3.i(sa2, "action");
            this.a.add(new F5.a(str, str2, drawable, str3, sa2));
            return this;
        }

        @Override // ir.nasim.AbstractC8081Ul1
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public ArrayList a() {
            return this.a;
        }
    }

    /* renamed from: ir.nasim.Ul1$b */
    public static final class b extends AbstractC8081Ul1 {
        private final ArrayList a;

        public b() {
            super(null);
            this.a = new ArrayList();
        }

        public static /* synthetic */ b d(b bVar, int i, int i2, String str, SA2 sa2, int i3, Object obj) {
            if ((i3 & 4) != 0) {
                str = null;
            }
            return bVar.c(i, i2, str, sa2);
        }

        public static /* synthetic */ b f(b bVar, int i, int i2, String str, SA2 sa2, int i3, Object obj) {
            if ((i3 & 4) != 0) {
                str = null;
            }
            return bVar.e(i, i2, str, sa2);
        }

        public static /* synthetic */ b k(b bVar, int i, int i2, String str, SA2 sa2, int i3, Object obj) {
            if ((i3 & 4) != 0) {
                str = null;
            }
            return bVar.j(i, i2, str, sa2);
        }

        @Override // ir.nasim.AbstractC8081Ul1
        public boolean b() {
            return this.a.isEmpty();
        }

        public final b c(int i, int i2, String str, SA2 sa2) {
            AbstractC13042fc3.i(sa2, "action");
            this.a.add(new F5.c.a(i, i2, str, sa2));
            return this;
        }

        public final b e(int i, int i2, String str, SA2 sa2) {
            AbstractC13042fc3.i(sa2, "action");
            this.a.add(new F5.c.b(i, i2, str, sa2));
            return this;
        }

        public final b g(String str, int i, String str2, InterfaceC10258bL6 interfaceC10258bL6, SA2 sa2) {
            AbstractC13042fc3.i(str, "title");
            AbstractC13042fc3.i(sa2, "action");
            this.a.add(new F5.b(str, i, interfaceC10258bL6, str2, sa2));
            return this;
        }

        public final b i(int i, int i2, SA2 sa2) {
            AbstractC13042fc3.i(sa2, "action");
            return k(this, i, i2, null, sa2, 4, null);
        }

        public final b j(int i, int i2, String str, SA2 sa2) {
            AbstractC13042fc3.i(sa2, "action");
            this.a.add(new F5.c.C0355c(i, i2, str, sa2));
            return this;
        }

        public final b l(InterfaceC10258bL6 interfaceC10258bL6, int i, String str, InterfaceC10258bL6 interfaceC10258bL62, SA2 sa2) {
            AbstractC13042fc3.i(interfaceC10258bL6, "count");
            AbstractC13042fc3.i(sa2, "action");
            this.a.add(new F5.d(interfaceC10258bL6, i, interfaceC10258bL62, str, sa2));
            return this;
        }

        @Override // ir.nasim.AbstractC8081Ul1
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public ArrayList a() {
            return this.a;
        }

        public boolean o(int i) {
            if (this.a.size() == 1) {
                F5 f5 = (F5) AbstractC15401jX0.s0(this.a);
                AbstractC22943w5 title = f5 != null ? f5.getTitle() : null;
                AbstractC22943w5.b bVar = title instanceof AbstractC22943w5.b ? (AbstractC22943w5.b) title : null;
                if (bVar != null && bVar.a() == i) {
                    return true;
                }
            }
            return false;
        }
    }

    private AbstractC8081Ul1() {
    }

    public abstract List a();

    public abstract boolean b();

    public /* synthetic */ AbstractC8081Ul1(ED1 ed1) {
        this();
    }
}
