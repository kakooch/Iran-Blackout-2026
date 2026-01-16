package ir.nasim;

import android.gov.nist.core.Separators;
import java.util.List;

/* renamed from: ir.nasim.yw6, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public interface InterfaceC24633yw6 {
    public static final a a = a.a;

    /* renamed from: ir.nasim.yw6$a */
    public static final class a {
        static final /* synthetic */ a a = new a();

        private a() {
        }

        public final InterfaceC24633yw6 a(Throwable th) {
            AbstractC13042fc3.i(th, "error");
            return new b(th);
        }

        public final InterfaceC24633yw6 b() {
            return c.b;
        }

        public final InterfaceC24633yw6 c(EnumC18609ow6 enumC18609ow6, List list) {
            AbstractC13042fc3.i(enumC18609ow6, "option");
            AbstractC13042fc3.i(list, "items");
            return new d(enumC18609ow6, list);
        }
    }

    /* renamed from: ir.nasim.yw6$b */
    public static final class b implements InterfaceC24633yw6 {
        private final Throwable b;

        public b(Throwable th) {
            AbstractC13042fc3.i(th, "error");
            this.b = th;
        }

        public final Throwable a() {
            return this.b;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof b) && AbstractC13042fc3.d(this.b, ((b) obj).b);
        }

        public int hashCode() {
            return this.b.hashCode();
        }

        public String toString() {
            return "Failure(error=" + this.b + Separators.RPAREN;
        }
    }

    /* renamed from: ir.nasim.yw6$c */
    public static final class c implements InterfaceC24633yw6 {
        public static final c b = new c();

        private c() {
        }
    }

    /* renamed from: ir.nasim.yw6$d */
    public static final class d implements InterfaceC24633yw6 {
        private final EnumC18609ow6 b;
        private final List c;

        public d(EnumC18609ow6 enumC18609ow6, List list) {
            AbstractC13042fc3.i(enumC18609ow6, "option");
            AbstractC13042fc3.i(list, "items");
            this.b = enumC18609ow6;
            this.c = list;
        }

        public final List a() {
            return this.c;
        }

        public final EnumC18609ow6 b() {
            return this.b;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof d)) {
                return false;
            }
            d dVar = (d) obj;
            return this.b == dVar.b && AbstractC13042fc3.d(this.c, dVar.c);
        }

        public int hashCode() {
            return (this.b.hashCode() * 31) + this.c.hashCode();
        }

        public String toString() {
            return "Success(option=" + this.b + ", items=" + this.c + Separators.RPAREN;
        }
    }
}
