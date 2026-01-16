package ir.nasim;

import android.gov.nist.core.Separators;

/* renamed from: ir.nasim.nN, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C17674nN {
    private final Boolean a;
    private final EnumC16492lN b;

    public C17674nN(Boolean bool, EnumC16492lN enumC16492lN) {
        this.a = bool;
        this.b = enumC16492lN;
    }

    public static /* synthetic */ C17674nN b(C17674nN c17674nN, Boolean bool, EnumC16492lN enumC16492lN, int i, Object obj) {
        if ((i & 1) != 0) {
            bool = c17674nN.a;
        }
        if ((i & 2) != 0) {
            enumC16492lN = c17674nN.b;
        }
        return c17674nN.a(bool, enumC16492lN);
    }

    public final C17674nN a(Boolean bool, EnumC16492lN enumC16492lN) {
        return new C17674nN(bool, enumC16492lN);
    }

    public final Boolean c() {
        return this.a;
    }

    public final EnumC16492lN d() {
        return this.b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C17674nN)) {
            return false;
        }
        C17674nN c17674nN = (C17674nN) obj;
        return AbstractC13042fc3.d(this.a, c17674nN.a) && this.b == c17674nN.b;
    }

    public int hashCode() {
        Boolean bool = this.a;
        int iHashCode = (bool == null ? 0 : bool.hashCode()) * 31;
        EnumC16492lN enumC16492lN = this.b;
        return iHashCode + (enumC16492lN != null ? enumC16492lN.hashCode() : 0);
    }

    public String toString() {
        return "AudioDevicePreferences(prefersSpeaker=" + this.a + ", userPreference=" + this.b + Separators.RPAREN;
    }

    public /* synthetic */ C17674nN(Boolean bool, EnumC16492lN enumC16492lN, int i, ED1 ed1) {
        this((i & 1) != 0 ? null : bool, (i & 2) != 0 ? null : enumC16492lN);
    }
}
