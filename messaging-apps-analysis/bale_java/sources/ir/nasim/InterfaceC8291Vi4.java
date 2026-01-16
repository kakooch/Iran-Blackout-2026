package ir.nasim;

import android.gov.nist.core.Separators;
import android.gov.nist.javax.sip.header.ParameterNames;
import ir.nasim.database.dailogLists.DialogEntity;

/* renamed from: ir.nasim.Vi4, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public interface InterfaceC8291Vi4 {

    /* renamed from: ir.nasim.Vi4$a */
    public static final class a implements InterfaceC8291Vi4 {
        private final String a;
        private final String b;
        private final Throwable c;

        public a(String str, String str2, Throwable th) {
            AbstractC13042fc3.i(str, ParameterNames.TAG);
            AbstractC13042fc3.i(str2, DialogEntity.COLUMN_MESSAGE);
            this.a = str;
            this.b = str2;
            this.c = th;
        }

        @Override // ir.nasim.InterfaceC8291Vi4
        public EnumC8525Wi4 a() {
            return EnumC8525Wi4.b;
        }

        @Override // ir.nasim.InterfaceC8291Vi4
        public String b() {
            return this.b;
        }

        @Override // ir.nasim.InterfaceC8291Vi4
        public Throwable c() {
            return this.c;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return AbstractC13042fc3.d(this.a, aVar.a) && AbstractC13042fc3.d(this.b, aVar.b) && AbstractC13042fc3.d(this.c, aVar.c);
        }

        @Override // ir.nasim.InterfaceC8291Vi4
        public String getTag() {
            return this.a;
        }

        public int hashCode() {
            int iHashCode = ((this.a.hashCode() * 31) + this.b.hashCode()) * 31;
            Throwable th = this.c;
            return iHashCode + (th == null ? 0 : th.hashCode());
        }

        public String toString() {
            return "Error(tag=" + this.a + ", message=" + this.b + ", throwable=" + this.c + Separators.RPAREN;
        }
    }

    EnumC8525Wi4 a();

    String b();

    Throwable c();

    String getTag();
}
