package ir.nasim;

import android.gov.nist.core.Separators;

/* renamed from: ir.nasim.on6, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C18519on6 {
    public static final int c = 0;
    private final EnumC25128zm6 a;
    private final SA2 b;

    public C18519on6(EnumC25128zm6 enumC25128zm6, SA2 sa2) {
        AbstractC13042fc3.i(sa2, "onClickAction");
        this.a = enumC25128zm6;
        this.b = sa2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 b() {
        return C19938rB7.a;
    }

    public final EnumC25128zm6 c() {
        return this.a;
    }

    public final SA2 d() {
        return this.b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C18519on6)) {
            return false;
        }
        C18519on6 c18519on6 = (C18519on6) obj;
        return this.a == c18519on6.a && AbstractC13042fc3.d(this.b, c18519on6.b);
    }

    public int hashCode() {
        EnumC25128zm6 enumC25128zm6 = this.a;
        return ((enumC25128zm6 == null ? 0 : enumC25128zm6.hashCode()) * 31) + this.b.hashCode();
    }

    public String toString() {
        return "SelectedSpeakerState(currentSelectedSpeaker=" + this.a + ", onClickAction=" + this.b + Separators.RPAREN;
    }

    public /* synthetic */ C18519on6(EnumC25128zm6 enumC25128zm6, SA2 sa2, int i, ED1 ed1) {
        this((i & 1) != 0 ? null : enumC25128zm6, (i & 2) != 0 ? new SA2() { // from class: ir.nasim.nn6
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return C18519on6.b();
            }
        } : sa2);
    }
}
