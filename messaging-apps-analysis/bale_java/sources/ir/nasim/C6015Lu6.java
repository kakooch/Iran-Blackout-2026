package ir.nasim;

import android.gov.nist.core.Separators;

/* renamed from: ir.nasim.Lu6, reason: case insensitive filesystem */
/* loaded from: classes7.dex */
public final class C6015Lu6 {
    private final SA2 a;

    public C6015Lu6(SA2 sa2) {
        AbstractC13042fc3.i(sa2, "navigateToDeveloperMode");
        this.a = sa2;
    }

    public final SA2 a() {
        return this.a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof C6015Lu6) && AbstractC13042fc3.d(this.a, ((C6015Lu6) obj).a);
    }

    public int hashCode() {
        return this.a.hashCode();
    }

    public String toString() {
        return "SettingDeveloperModeCallback(navigateToDeveloperMode=" + this.a + Separators.RPAREN;
    }
}
