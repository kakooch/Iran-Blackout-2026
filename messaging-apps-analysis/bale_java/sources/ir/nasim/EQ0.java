package ir.nasim;

import android.gov.nist.core.Separators;

/* loaded from: classes7.dex */
public final class EQ0 {
    private final boolean a;

    public EQ0(boolean z) {
        this.a = z;
    }

    public final EQ0 a(boolean z) {
        return new EQ0(z);
    }

    public final boolean b() {
        return this.a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof EQ0) && this.a == ((EQ0) obj).a;
    }

    public int hashCode() {
        return Boolean.hashCode(this.a);
    }

    public String toString() {
        return "ChatSettingsUiState(isSendByEnterEnabled=" + this.a + Separators.RPAREN;
    }
}
