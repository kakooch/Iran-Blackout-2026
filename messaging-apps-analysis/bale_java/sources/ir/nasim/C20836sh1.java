package ir.nasim;

import android.gov.nist.core.Separators;
import ir.nasim.features.onboarding.data.model.OnboardingPeer;

/* renamed from: ir.nasim.sh1, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public final class C20836sh1 {
    public static final int c = OnboardingPeer.ContactsChannel.e;
    private final AbstractC5914Lj3 a;
    private final OnboardingPeer.ContactsChannel b;

    public C20836sh1(AbstractC5914Lj3 abstractC5914Lj3, OnboardingPeer.ContactsChannel contactsChannel) {
        AbstractC13042fc3.i(abstractC5914Lj3, "joinStatus");
        AbstractC13042fc3.i(contactsChannel, "contactsChannel");
        this.a = abstractC5914Lj3;
        this.b = contactsChannel;
    }

    public static /* synthetic */ C20836sh1 b(C20836sh1 c20836sh1, AbstractC5914Lj3 abstractC5914Lj3, OnboardingPeer.ContactsChannel contactsChannel, int i, Object obj) {
        if ((i & 1) != 0) {
            abstractC5914Lj3 = c20836sh1.a;
        }
        if ((i & 2) != 0) {
            contactsChannel = c20836sh1.b;
        }
        return c20836sh1.a(abstractC5914Lj3, contactsChannel);
    }

    public final C20836sh1 a(AbstractC5914Lj3 abstractC5914Lj3, OnboardingPeer.ContactsChannel contactsChannel) {
        AbstractC13042fc3.i(abstractC5914Lj3, "joinStatus");
        AbstractC13042fc3.i(contactsChannel, "contactsChannel");
        return new C20836sh1(abstractC5914Lj3, contactsChannel);
    }

    public final OnboardingPeer.ContactsChannel c() {
        return this.b;
    }

    public final AbstractC5914Lj3 d() {
        return this.a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C20836sh1)) {
            return false;
        }
        C20836sh1 c20836sh1 = (C20836sh1) obj;
        return AbstractC13042fc3.d(this.a, c20836sh1.a) && AbstractC13042fc3.d(this.b, c20836sh1.b);
    }

    public int hashCode() {
        return (this.a.hashCode() * 31) + this.b.hashCode();
    }

    public String toString() {
        return "ContactsChannelItemUiState(joinStatus=" + this.a + ", contactsChannel=" + this.b + Separators.RPAREN;
    }
}
