package ir.nasim;

import android.os.LocaleList;
import java.util.Locale;

/* loaded from: classes2.dex */
final class NH3 implements MH3 {
    private final LocaleList a;

    NH3(Object obj) {
        this.a = (LocaleList) obj;
    }

    @Override // ir.nasim.MH3
    public String a() {
        return this.a.toLanguageTags();
    }

    @Override // ir.nasim.MH3
    public Object b() {
        return this.a;
    }

    public boolean equals(Object obj) {
        return this.a.equals(((MH3) obj).b());
    }

    @Override // ir.nasim.MH3
    public Locale get(int i) {
        return this.a.get(i);
    }

    public int hashCode() {
        return this.a.hashCode();
    }

    @Override // ir.nasim.MH3
    public boolean isEmpty() {
        return this.a.isEmpty();
    }

    @Override // ir.nasim.MH3
    public int size() {
        return this.a.size();
    }

    public String toString() {
        return this.a.toString();
    }
}
