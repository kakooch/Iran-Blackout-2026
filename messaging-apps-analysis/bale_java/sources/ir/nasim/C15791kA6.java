package ir.nasim;

import android.app.Person;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ShortcutInfo;
import android.gov.nist.core.Separators;
import android.net.Uri;
import android.os.Build;
import android.os.PersistableBundle;
import android.os.UserHandle;
import android.text.TextUtils;
import androidx.core.graphics.drawable.IconCompat;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* renamed from: ir.nasim.kA6, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public class C15791kA6 {
    int A;
    Context a;
    String b;
    String c;
    Intent[] d;
    ComponentName e;
    CharSequence f;
    CharSequence g;
    CharSequence h;
    IconCompat i;
    boolean j;
    D55[] k;
    Set l;
    C18224oI3 m;
    boolean n;
    int o;
    PersistableBundle p;
    long q;
    UserHandle r;
    boolean s;
    boolean t;
    boolean u;
    boolean v;
    boolean w;
    boolean x = true;
    boolean y;
    int z;

    /* renamed from: ir.nasim.kA6$a */
    private static class a {
        static void a(ShortcutInfo.Builder builder, int i) {
            builder.setExcludedFromSurfaces(i);
        }
    }

    C15791kA6() {
    }

    private PersistableBundle a() {
        if (this.p == null) {
            this.p = new PersistableBundle();
        }
        D55[] d55Arr = this.k;
        if (d55Arr != null && d55Arr.length > 0) {
            this.p.putInt("extraPersonCount", d55Arr.length);
            int i = 0;
            while (i < this.k.length) {
                PersistableBundle persistableBundle = this.p;
                StringBuilder sb = new StringBuilder();
                sb.append("extraPerson_");
                int i2 = i + 1;
                sb.append(i2);
                persistableBundle.putPersistableBundle(sb.toString(), this.k[i].m());
                i = i2;
            }
        }
        C18224oI3 c18224oI3 = this.m;
        if (c18224oI3 != null) {
            this.p.putString("extraLocusId", c18224oI3.a());
        }
        this.p.putBoolean("extraLongLived", this.n);
        return this.p;
    }

    static C18224oI3 i(ShortcutInfo shortcutInfo) {
        if (Build.VERSION.SDK_INT < 29) {
            return j(shortcutInfo.getExtras());
        }
        if (shortcutInfo.getLocusId() == null) {
            return null;
        }
        return C18224oI3.d(shortcutInfo.getLocusId());
    }

    private static C18224oI3 j(PersistableBundle persistableBundle) {
        String string;
        if (persistableBundle == null || (string = persistableBundle.getString("extraLocusId")) == null) {
            return null;
        }
        return new C18224oI3(string);
    }

    static D55[] l(PersistableBundle persistableBundle) {
        if (persistableBundle == null || !persistableBundle.containsKey("extraPersonCount")) {
            return null;
        }
        int i = persistableBundle.getInt("extraPersonCount");
        D55[] d55Arr = new D55[i];
        int i2 = 0;
        while (i2 < i) {
            StringBuilder sb = new StringBuilder();
            sb.append("extraPerson_");
            int i3 = i2 + 1;
            sb.append(i3);
            d55Arr[i2] = D55.c(persistableBundle.getPersistableBundle(sb.toString()));
            i2 = i3;
        }
        return d55Arr;
    }

    public ComponentName b() {
        return this.e;
    }

    public Set c() {
        return this.l;
    }

    public CharSequence d() {
        return this.h;
    }

    public IconCompat e() {
        return this.i;
    }

    public String f() {
        return this.b;
    }

    public Intent[] g() {
        Intent[] intentArr = this.d;
        return (Intent[]) Arrays.copyOf(intentArr, intentArr.length);
    }

    public C18224oI3 h() {
        return this.m;
    }

    public CharSequence k() {
        return this.g;
    }

    public int m() {
        return this.o;
    }

    public CharSequence n() {
        return this.f;
    }

    public boolean o(int i) {
        return (i & this.A) != 0;
    }

    public ShortcutInfo p() {
        AbstractC10159bA6.a();
        ShortcutInfo.Builder intents = AbstractC7978Tz6.a(this.a, this.b).setShortLabel(this.f).setIntents(this.d);
        IconCompat iconCompat = this.i;
        if (iconCompat != null) {
            intents.setIcon(iconCompat.x(this.a));
        }
        if (!TextUtils.isEmpty(this.g)) {
            intents.setLongLabel(this.g);
        }
        if (!TextUtils.isEmpty(this.h)) {
            intents.setDisabledMessage(this.h);
        }
        ComponentName componentName = this.e;
        if (componentName != null) {
            intents.setActivity(componentName);
        }
        Set set = this.l;
        if (set != null) {
            intents.setCategories(set);
        }
        intents.setRank(this.o);
        PersistableBundle persistableBundle = this.p;
        if (persistableBundle != null) {
            intents.setExtras(persistableBundle);
        }
        if (Build.VERSION.SDK_INT >= 29) {
            D55[] d55Arr = this.k;
            if (d55Arr != null && d55Arr.length > 0) {
                int length = d55Arr.length;
                Person[] personArr = new Person[length];
                for (int i = 0; i < length; i++) {
                    personArr[i] = this.k[i].k();
                }
                intents.setPersons(personArr);
            }
            C18224oI3 c18224oI3 = this.m;
            if (c18224oI3 != null) {
                intents.setLocusId(c18224oI3.c());
            }
            intents.setLongLived(this.n);
        } else {
            intents.setExtras(a());
        }
        if (Build.VERSION.SDK_INT >= 33) {
            a.a(intents, this.A);
        }
        return intents.build();
    }

    /* renamed from: ir.nasim.kA6$b */
    public static class b {
        private final C15791kA6 a;
        private boolean b;
        private Set c;
        private Map d;
        private Uri e;

        public b(Context context, String str) {
            C15791kA6 c15791kA6 = new C15791kA6();
            this.a = c15791kA6;
            c15791kA6.a = context;
            c15791kA6.b = str;
        }

        public C15791kA6 a() {
            if (TextUtils.isEmpty(this.a.f)) {
                throw new IllegalArgumentException("Shortcut must have a non-empty label");
            }
            C15791kA6 c15791kA6 = this.a;
            Intent[] intentArr = c15791kA6.d;
            if (intentArr == null || intentArr.length == 0) {
                throw new IllegalArgumentException("Shortcut must have an intent");
            }
            if (this.b) {
                if (c15791kA6.m == null) {
                    c15791kA6.m = new C18224oI3(c15791kA6.b);
                }
                this.a.n = true;
            }
            if (this.c != null) {
                C15791kA6 c15791kA62 = this.a;
                if (c15791kA62.l == null) {
                    c15791kA62.l = new HashSet();
                }
                this.a.l.addAll(this.c);
            }
            if (this.d != null) {
                C15791kA6 c15791kA63 = this.a;
                if (c15791kA63.p == null) {
                    c15791kA63.p = new PersistableBundle();
                }
                for (String str : this.d.keySet()) {
                    Map map = (Map) this.d.get(str);
                    this.a.p.putStringArray(str, (String[]) map.keySet().toArray(new String[0]));
                    for (String str2 : map.keySet()) {
                        List list = (List) map.get(str2);
                        this.a.p.putStringArray(str + Separators.SLASH + str2, list == null ? new String[0] : (String[]) list.toArray(new String[0]));
                    }
                }
            }
            if (this.e != null) {
                C15791kA6 c15791kA64 = this.a;
                if (c15791kA64.p == null) {
                    c15791kA64.p = new PersistableBundle();
                }
                this.a.p.putString("extraSliceUri", ZH7.a(this.e));
            }
            return this.a;
        }

        public b b(ComponentName componentName) {
            this.a.e = componentName;
            return this;
        }

        public b c(Set set) {
            PJ pj = new PJ();
            pj.addAll(set);
            this.a.l = pj;
            return this;
        }

        public b d(CharSequence charSequence) {
            this.a.h = charSequence;
            return this;
        }

        public b e(IconCompat iconCompat) {
            this.a.i = iconCompat;
            return this;
        }

        public b f(Intent intent) {
            return g(new Intent[]{intent});
        }

        public b g(Intent[] intentArr) {
            this.a.d = intentArr;
            return this;
        }

        public b h() {
            this.b = true;
            return this;
        }

        public b i(C18224oI3 c18224oI3) {
            this.a.m = c18224oI3;
            return this;
        }

        public b j(CharSequence charSequence) {
            this.a.g = charSequence;
            return this;
        }

        public b k(boolean z) {
            this.a.n = z;
            return this;
        }

        public b l(int i) {
            this.a.o = i;
            return this;
        }

        public b m(CharSequence charSequence) {
            this.a.f = charSequence;
            return this;
        }

        public b(C15791kA6 c15791kA6) {
            C15791kA6 c15791kA62 = new C15791kA6();
            this.a = c15791kA62;
            c15791kA62.a = c15791kA6.a;
            c15791kA62.b = c15791kA6.b;
            c15791kA62.c = c15791kA6.c;
            Intent[] intentArr = c15791kA6.d;
            c15791kA62.d = (Intent[]) Arrays.copyOf(intentArr, intentArr.length);
            c15791kA62.e = c15791kA6.e;
            c15791kA62.f = c15791kA6.f;
            c15791kA62.g = c15791kA6.g;
            c15791kA62.h = c15791kA6.h;
            c15791kA62.z = c15791kA6.z;
            c15791kA62.i = c15791kA6.i;
            c15791kA62.j = c15791kA6.j;
            c15791kA62.r = c15791kA6.r;
            c15791kA62.q = c15791kA6.q;
            c15791kA62.s = c15791kA6.s;
            c15791kA62.t = c15791kA6.t;
            c15791kA62.u = c15791kA6.u;
            c15791kA62.v = c15791kA6.v;
            c15791kA62.w = c15791kA6.w;
            c15791kA62.x = c15791kA6.x;
            c15791kA62.m = c15791kA6.m;
            c15791kA62.n = c15791kA6.n;
            c15791kA62.y = c15791kA6.y;
            c15791kA62.o = c15791kA6.o;
            D55[] d55Arr = c15791kA6.k;
            if (d55Arr != null) {
                c15791kA62.k = (D55[]) Arrays.copyOf(d55Arr, d55Arr.length);
            }
            if (c15791kA6.l != null) {
                c15791kA62.l = new HashSet(c15791kA6.l);
            }
            PersistableBundle persistableBundle = c15791kA6.p;
            if (persistableBundle != null) {
                c15791kA62.p = persistableBundle;
            }
            c15791kA62.A = c15791kA6.A;
        }

        public b(Context context, ShortcutInfo shortcutInfo) {
            C15791kA6 c15791kA6 = new C15791kA6();
            this.a = c15791kA6;
            c15791kA6.a = context;
            c15791kA6.b = shortcutInfo.getId();
            c15791kA6.c = shortcutInfo.getPackage();
            Intent[] intents = shortcutInfo.getIntents();
            c15791kA6.d = (Intent[]) Arrays.copyOf(intents, intents.length);
            c15791kA6.e = shortcutInfo.getActivity();
            c15791kA6.f = shortcutInfo.getShortLabel();
            c15791kA6.g = shortcutInfo.getLongLabel();
            c15791kA6.h = shortcutInfo.getDisabledMessage();
            int i = Build.VERSION.SDK_INT;
            if (i >= 28) {
                c15791kA6.z = shortcutInfo.getDisabledReason();
            } else {
                c15791kA6.z = shortcutInfo.isEnabled() ? 0 : 3;
            }
            c15791kA6.l = shortcutInfo.getCategories();
            c15791kA6.k = C15791kA6.l(shortcutInfo.getExtras());
            c15791kA6.r = shortcutInfo.getUserHandle();
            c15791kA6.q = shortcutInfo.getLastChangedTimestamp();
            if (i >= 30) {
                c15791kA6.s = shortcutInfo.isCached();
            }
            c15791kA6.t = shortcutInfo.isDynamic();
            c15791kA6.u = shortcutInfo.isPinned();
            c15791kA6.v = shortcutInfo.isDeclaredInManifest();
            c15791kA6.w = shortcutInfo.isImmutable();
            c15791kA6.x = shortcutInfo.isEnabled();
            c15791kA6.y = shortcutInfo.hasKeyFieldsOnly();
            c15791kA6.m = C15791kA6.i(shortcutInfo);
            c15791kA6.o = shortcutInfo.getRank();
            c15791kA6.p = shortcutInfo.getExtras();
        }
    }
}
