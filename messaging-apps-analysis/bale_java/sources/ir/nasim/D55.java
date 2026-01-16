package ir.nasim;

import android.app.Person;
import android.gov.nist.javax.sip.header.ParameterNames;
import android.os.Bundle;
import android.os.PersistableBundle;
import androidx.core.graphics.drawable.IconCompat;
import ir.nasim.database.entity.ContactEntity;
import java.util.Objects;

/* loaded from: classes2.dex */
public class D55 {
    CharSequence a;
    IconCompat b;
    String c;
    String d;
    boolean e;
    boolean f;

    static class a {
        static D55 a(PersistableBundle persistableBundle) {
            return new c().f(persistableBundle.getString("name")).g(persistableBundle.getString("uri")).e(persistableBundle.getString("key")).b(persistableBundle.getBoolean(ContactEntity.COLUMN_IS_BOT)).d(persistableBundle.getBoolean("isImportant")).a();
        }

        static PersistableBundle b(D55 d55) {
            PersistableBundle persistableBundle = new PersistableBundle();
            CharSequence charSequence = d55.a;
            persistableBundle.putString("name", charSequence != null ? charSequence.toString() : null);
            persistableBundle.putString("uri", d55.c);
            persistableBundle.putString("key", d55.d);
            persistableBundle.putBoolean(ContactEntity.COLUMN_IS_BOT, d55.e);
            persistableBundle.putBoolean("isImportant", d55.f);
            return persistableBundle;
        }
    }

    static class b {
        static D55 a(Person person) {
            return new c().f(person.getName()).c(person.getIcon() != null ? IconCompat.d(person.getIcon()) : null).g(person.getUri()).e(person.getKey()).b(person.isBot()).d(person.isImportant()).a();
        }

        static Person b(D55 d55) {
            return new Person.Builder().setName(d55.f()).setIcon(d55.d() != null ? d55.d().w() : null).setUri(d55.g()).setKey(d55.e()).setBot(d55.h()).setImportant(d55.i()).build();
        }
    }

    public static class c {
        CharSequence a;
        IconCompat b;
        String c;
        String d;
        boolean e;
        boolean f;

        public D55 a() {
            return new D55(this);
        }

        public c b(boolean z) {
            this.e = z;
            return this;
        }

        public c c(IconCompat iconCompat) {
            this.b = iconCompat;
            return this;
        }

        public c d(boolean z) {
            this.f = z;
            return this;
        }

        public c e(String str) {
            this.d = str;
            return this;
        }

        public c f(CharSequence charSequence) {
            this.a = charSequence;
            return this;
        }

        public c g(String str) {
            this.c = str;
            return this;
        }
    }

    D55(c cVar) {
        this.a = cVar.a;
        this.b = cVar.b;
        this.c = cVar.c;
        this.d = cVar.d;
        this.e = cVar.e;
        this.f = cVar.f;
    }

    public static D55 a(Person person) {
        return b.a(person);
    }

    public static D55 b(Bundle bundle) {
        Bundle bundle2 = bundle.getBundle(ParameterNames.ICON);
        return new c().f(bundle.getCharSequence("name")).c(bundle2 != null ? IconCompat.a(bundle2) : null).g(bundle.getString("uri")).e(bundle.getString("key")).b(bundle.getBoolean(ContactEntity.COLUMN_IS_BOT)).d(bundle.getBoolean("isImportant")).a();
    }

    public static D55 c(PersistableBundle persistableBundle) {
        return a.a(persistableBundle);
    }

    public IconCompat d() {
        return this.b;
    }

    public String e() {
        return this.d;
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof D55)) {
            return false;
        }
        D55 d55 = (D55) obj;
        String strE = e();
        String strE2 = d55.e();
        return (strE == null && strE2 == null) ? Objects.equals(Objects.toString(f()), Objects.toString(d55.f())) && Objects.equals(g(), d55.g()) && Boolean.valueOf(h()).equals(Boolean.valueOf(d55.h())) && Boolean.valueOf(i()).equals(Boolean.valueOf(d55.i())) : Objects.equals(strE, strE2);
    }

    public CharSequence f() {
        return this.a;
    }

    public String g() {
        return this.c;
    }

    public boolean h() {
        return this.e;
    }

    public int hashCode() {
        String strE = e();
        return strE != null ? strE.hashCode() : Objects.hash(f(), g(), Boolean.valueOf(h()), Boolean.valueOf(i()));
    }

    public boolean i() {
        return this.f;
    }

    public String j() {
        String str = this.c;
        if (str != null) {
            return str;
        }
        if (this.a == null) {
            return "";
        }
        return "name:" + ((Object) this.a);
    }

    public Person k() {
        return b.b(this);
    }

    public Bundle l() {
        Bundle bundle = new Bundle();
        bundle.putCharSequence("name", this.a);
        IconCompat iconCompat = this.b;
        bundle.putBundle(ParameterNames.ICON, iconCompat != null ? iconCompat.v() : null);
        bundle.putString("uri", this.c);
        bundle.putString("key", this.d);
        bundle.putBoolean(ContactEntity.COLUMN_IS_BOT, this.e);
        bundle.putBoolean("isImportant", this.f);
        return bundle;
    }

    public PersistableBundle m() {
        return a.b(this);
    }
}
