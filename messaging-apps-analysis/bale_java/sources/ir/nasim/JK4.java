package ir.nasim;

import android.gov.nist.core.Separators;
import ir.nasim.AbstractC5914Lj3;
import ir.nasim.features.onboarding.data.model.OnboardingData;
import ir.nasim.features.onboarding.data.model.OnboardingPeer;
import ir.nasim.features.onboarding.data.model.OnboardingSpot;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;

/* loaded from: classes6.dex */
public final class JK4 {
    private final a a;
    private final b b;
    private final OnboardingSpot c;

    public static abstract class a {

        /* renamed from: ir.nasim.JK4$a$a, reason: collision with other inner class name */
        public static final class C0443a extends a {
            public static final C0443a a = new C0443a();

            private C0443a() {
                super(null);
            }

            public boolean equals(Object obj) {
                return this == obj || (obj instanceof C0443a);
            }

            public int hashCode() {
                return 1508488468;
            }

            public String toString() {
                return "Loaded";
            }
        }

        public static final class b extends a {
            public static final b a = new b();

            private b() {
                super(null);
            }

            public boolean equals(Object obj) {
                return this == obj || (obj instanceof b);
            }

            public int hashCode() {
                return -481493491;
            }

            public String toString() {
                return "Loading";
            }
        }

        private a() {
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    public static abstract class b {

        /* renamed from: ir.nasim.JK4$b$b, reason: collision with other inner class name */
        public static final class C0444b extends b {
            public static final C0444b a = new C0444b();

            private C0444b() {
                super(null);
            }

            public boolean equals(Object obj) {
                return this == obj || (obj instanceof C0444b);
            }

            public int hashCode() {
                return -1610923767;
            }

            public String toString() {
                return "None";
            }
        }

        public static final class c extends b {
            private final List a;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public c(List list) {
                super(null);
                AbstractC13042fc3.i(list, "peerList");
                this.a = list;
            }

            public final c c(List list) {
                AbstractC13042fc3.i(list, "peerList");
                return new c(list);
            }

            public final List d() {
                return this.a;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return (obj instanceof c) && AbstractC13042fc3.d(this.a, ((c) obj).a);
            }

            public int hashCode() {
                return this.a.hashCode();
            }

            public String toString() {
                return "SuggestedPeers(peerList=" + this.a + Separators.RPAREN;
            }
        }

        public static final class e extends b {
            private final List a;
            private final String b;
            private final String c;

            public /* synthetic */ e(List list, String str, String str2, int i, ED1 ed1) {
                this(list, (i & 2) != 0 ? null : str, (i & 4) != 0 ? null : str2);
            }

            public static /* synthetic */ e d(e eVar, List list, String str, String str2, int i, Object obj) {
                if ((i & 1) != 0) {
                    list = eVar.a;
                }
                if ((i & 2) != 0) {
                    str = eVar.b;
                }
                if ((i & 4) != 0) {
                    str2 = eVar.c;
                }
                return eVar.c(list, str, str2);
            }

            public final e c(List list, String str, String str2) {
                AbstractC13042fc3.i(list, "peerList");
                return new e(list, str, str2);
            }

            public final String e() {
                return this.c;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof e)) {
                    return false;
                }
                e eVar = (e) obj;
                return AbstractC13042fc3.d(this.a, eVar.a) && AbstractC13042fc3.d(this.b, eVar.b) && AbstractC13042fc3.d(this.c, eVar.c);
            }

            public final String f() {
                return this.b;
            }

            public final List g() {
                return this.a;
            }

            public int hashCode() {
                int iHashCode = this.a.hashCode() * 31;
                String str = this.b;
                int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
                String str2 = this.c;
                return iHashCode2 + (str2 != null ? str2.hashCode() : 0);
            }

            public String toString() {
                return "SuggestedServicePeers(peerList=" + this.a + ", innerBannerUrl=" + this.b + ", innerBannerTitle=" + this.c + Separators.RPAREN;
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public e(List list, String str, String str2) {
                super(null);
                AbstractC13042fc3.i(list, "peerList");
                this.a = list;
                this.b = str;
                this.c = str2;
            }
        }

        public static final class f implements Comparator {
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                return AbstractC18050o01.d(((OnboardingPeer.EmptyStateSuggestedPeer) obj).getPeerData().getIsJoined(), ((OnboardingPeer.EmptyStateSuggestedPeer) obj2).getPeerData().getIsJoined());
            }
        }

        private b() {
        }

        public static /* synthetic */ b b(b bVar, OnboardingData onboardingData, EnumC3773Ch1 enumC3773Ch1, M72 m72, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: toScreenData");
            }
            if ((i & 1) != 0) {
                enumC3773Ch1 = EnumC3773Ch1.b;
            }
            if ((i & 2) != 0) {
                m72 = M72.b;
            }
            return bVar.a(onboardingData, enumC3773Ch1, m72);
        }

        public final b a(OnboardingData onboardingData, EnumC3773Ch1 enumC3773Ch1, M72 m72) {
            AbstractC13042fc3.i(onboardingData, "<this>");
            AbstractC13042fc3.i(enumC3773Ch1, "contactsChannelsStringsCategory");
            AbstractC13042fc3.i(m72, "emptyStateOnboardingType");
            if (onboardingData instanceof OnboardingData.Enabled.SuggestedPeers) {
                List peerList = ((OnboardingData.Enabled.SuggestedPeers) onboardingData).getPeerList();
                ArrayList arrayList = new ArrayList(AbstractC10976cX0.x(peerList, 10));
                Iterator it = peerList.iterator();
                while (it.hasNext()) {
                    arrayList.add(new Q07(AbstractC5914Lj3.c.a, (OnboardingPeer.SuggestedPeer) it.next()));
                }
                return new c(arrayList);
            }
            if (onboardingData instanceof OnboardingData.Enabled.ContactsChannels) {
                List channelList = ((OnboardingData.Enabled.ContactsChannels) onboardingData).getChannelList();
                ArrayList arrayList2 = new ArrayList(AbstractC10976cX0.x(channelList, 10));
                Iterator it2 = channelList.iterator();
                while (it2.hasNext()) {
                    arrayList2.add(new C20836sh1(AbstractC5914Lj3.c.a, (OnboardingPeer.ContactsChannel) it2.next()));
                }
                return new a(arrayList2, enumC3773Ch1);
            }
            if (onboardingData instanceof OnboardingData.Enabled.EmptyStateSuggestedPeers) {
                List peerList2 = ((OnboardingData.Enabled.EmptyStateSuggestedPeers) onboardingData).getPeerList();
                ArrayList arrayList3 = new ArrayList(AbstractC10976cX0.x(peerList2, 10));
                Iterator it3 = peerList2.iterator();
                while (it3.hasNext()) {
                    arrayList3.add(new P07(AbstractC5914Lj3.c.a, (OnboardingPeer.EmptyStateSuggestedPeer) it3.next()));
                }
                return new d(arrayList3, false, m72, 2, null);
            }
            if (onboardingData instanceof OnboardingData.Disabled) {
                return C0444b.a;
            }
            if (!(onboardingData instanceof OnboardingData.Enabled.SuggestedServicePeers)) {
                throw new NoWhenBranchMatchedException();
            }
            OnboardingData.Enabled.SuggestedServicePeers suggestedServicePeers = (OnboardingData.Enabled.SuggestedServicePeers) onboardingData;
            List<OnboardingPeer.EmptyStateSuggestedPeer> listA1 = AbstractC15401jX0.a1(suggestedServicePeers.getPeerList(), new f());
            ArrayList arrayList4 = new ArrayList(AbstractC10976cX0.x(listA1, 10));
            for (OnboardingPeer.EmptyStateSuggestedPeer emptyStateSuggestedPeer : listA1) {
                arrayList4.add(new P07(AbstractC13042fc3.d(emptyStateSuggestedPeer.getPeerData().getIsJoined(), Boolean.TRUE) ? AbstractC5914Lj3.a.a : AbstractC5914Lj3.c.a, emptyStateSuggestedPeer));
            }
            return new e(arrayList4, suggestedServicePeers.getInnerBannerUrl(), suggestedServicePeers.getInnerTitle());
        }

        public static final class a extends b {
            private final List a;
            private final EnumC3773Ch1 b;

            public /* synthetic */ a(List list, EnumC3773Ch1 enumC3773Ch1, int i, ED1 ed1) {
                this(list, (i & 2) != 0 ? EnumC3773Ch1.b : enumC3773Ch1);
            }

            public static /* synthetic */ a d(a aVar, List list, EnumC3773Ch1 enumC3773Ch1, int i, Object obj) {
                if ((i & 1) != 0) {
                    list = aVar.a;
                }
                if ((i & 2) != 0) {
                    enumC3773Ch1 = aVar.b;
                }
                return aVar.c(list, enumC3773Ch1);
            }

            public final a c(List list, EnumC3773Ch1 enumC3773Ch1) {
                AbstractC13042fc3.i(list, "channelList");
                AbstractC13042fc3.i(enumC3773Ch1, "contactsChannelsStringsCategory");
                return new a(list, enumC3773Ch1);
            }

            public final List e() {
                return this.a;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof a)) {
                    return false;
                }
                a aVar = (a) obj;
                return AbstractC13042fc3.d(this.a, aVar.a) && this.b == aVar.b;
            }

            public final EnumC3773Ch1 f() {
                return this.b;
            }

            public int hashCode() {
                return (this.a.hashCode() * 31) + this.b.hashCode();
            }

            public String toString() {
                return "ContactsChannels(channelList=" + this.a + ", contactsChannelsStringsCategory=" + this.b + Separators.RPAREN;
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(List list, EnumC3773Ch1 enumC3773Ch1) {
                super(null);
                AbstractC13042fc3.i(list, "channelList");
                AbstractC13042fc3.i(enumC3773Ch1, "contactsChannelsStringsCategory");
                this.a = list;
                this.b = enumC3773Ch1;
            }
        }

        public static final class d extends b {
            private final List a;
            private final boolean b;
            private final M72 c;

            public /* synthetic */ d(List list, boolean z, M72 m72, int i, ED1 ed1) {
                this(list, (i & 2) != 0 ? true : z, (i & 4) != 0 ? M72.b : m72);
            }

            public static /* synthetic */ d d(d dVar, List list, boolean z, M72 m72, int i, Object obj) {
                if ((i & 1) != 0) {
                    list = dVar.a;
                }
                if ((i & 2) != 0) {
                    z = dVar.b;
                }
                if ((i & 4) != 0) {
                    m72 = dVar.c;
                }
                return dVar.c(list, z, m72);
            }

            public final d c(List list, boolean z, M72 m72) {
                AbstractC13042fc3.i(list, "peerList");
                AbstractC13042fc3.i(m72, "emptyStateOnboardingType");
                return new d(list, z, m72);
            }

            public final M72 e() {
                return this.c;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof d)) {
                    return false;
                }
                d dVar = (d) obj;
                return AbstractC13042fc3.d(this.a, dVar.a) && this.b == dVar.b && this.c == dVar.c;
            }

            public final List f() {
                return this.a;
            }

            public final boolean g() {
                return this.b;
            }

            public int hashCode() {
                return (((this.a.hashCode() * 31) + Boolean.hashCode(this.b)) * 31) + this.c.hashCode();
            }

            public String toString() {
                return "SuggestedPeersEmptyState(peerList=" + this.a + ", isVisible=" + this.b + ", emptyStateOnboardingType=" + this.c + Separators.RPAREN;
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public d(List list, boolean z, M72 m72) {
                super(null);
                AbstractC13042fc3.i(list, "peerList");
                AbstractC13042fc3.i(m72, "emptyStateOnboardingType");
                this.a = list;
                this.b = z;
                this.c = m72;
            }
        }

        public /* synthetic */ b(ED1 ed1) {
            this();
        }
    }

    public JK4(a aVar, b bVar, OnboardingSpot onboardingSpot) {
        AbstractC13042fc3.i(aVar, "loadStatus");
        AbstractC13042fc3.i(bVar, "screenData");
        AbstractC13042fc3.i(onboardingSpot, "onboardingSpot");
        this.a = aVar;
        this.b = bVar;
        this.c = onboardingSpot;
    }

    public static /* synthetic */ JK4 b(JK4 jk4, a aVar, b bVar, OnboardingSpot onboardingSpot, int i, Object obj) {
        if ((i & 1) != 0) {
            aVar = jk4.a;
        }
        if ((i & 2) != 0) {
            bVar = jk4.b;
        }
        if ((i & 4) != 0) {
            onboardingSpot = jk4.c;
        }
        return jk4.a(aVar, bVar, onboardingSpot);
    }

    public final JK4 a(a aVar, b bVar, OnboardingSpot onboardingSpot) {
        AbstractC13042fc3.i(aVar, "loadStatus");
        AbstractC13042fc3.i(bVar, "screenData");
        AbstractC13042fc3.i(onboardingSpot, "onboardingSpot");
        return new JK4(aVar, bVar, onboardingSpot);
    }

    public final a c() {
        return this.a;
    }

    public final OnboardingSpot d() {
        return this.c;
    }

    public final b e() {
        return this.b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof JK4)) {
            return false;
        }
        JK4 jk4 = (JK4) obj;
        return AbstractC13042fc3.d(this.a, jk4.a) && AbstractC13042fc3.d(this.b, jk4.b) && AbstractC13042fc3.d(this.c, jk4.c);
    }

    public int hashCode() {
        return (((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode();
    }

    public String toString() {
        return "OnboardingUiState(loadStatus=" + this.a + ", screenData=" + this.b + ", onboardingSpot=" + this.c + Separators.RPAREN;
    }
}
