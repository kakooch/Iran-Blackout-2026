package ir.nasim;

import android.gov.nist.core.Separators;
import ir.nasim.core.modules.profile.entity.Avatar;

/* renamed from: ir.nasim.Iu0, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public interface InterfaceC5308Iu0 {

    /* renamed from: ir.nasim.Iu0$a */
    public static final class a implements InterfaceC5308Iu0 {
        public static final a a = new a();

        private a() {
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof a);
        }

        public int hashCode() {
            return 1312493509;
        }

        public String toString() {
            return "EmptyAvatar";
        }
    }

    /* renamed from: ir.nasim.Iu0$b */
    public static final class b implements InterfaceC5308Iu0 {
        private final Avatar a;

        public b(Avatar avatar) {
            AbstractC13042fc3.i(avatar, "avatar");
            this.a = avatar;
        }

        public final Avatar a() {
            return this.a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof b) && AbstractC13042fc3.d(this.a, ((b) obj).a);
        }

        public int hashCode() {
            return this.a.hashCode();
        }

        public String toString() {
            return "NormalAvatar(avatar=" + this.a + Separators.RPAREN;
        }
    }
}
