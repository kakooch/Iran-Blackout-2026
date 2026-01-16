package ir.nasim.features.onboarding.data.model;

import android.gov.nist.core.Separators;
import android.gov.nist.javax.sip.parser.TokenNames;
import android.os.Parcel;
import android.os.Parcelable;
import ir.nasim.AbstractC13042fc3;
import ir.nasim.ED1;
import ir.nasim.features.onboarding.data.model.OnboardingPeer;
import ir.nasim.features.onboarding.data.model.OnboardingSpot;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import livekit.org.webrtc.PeerConnectionFactory;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u0000*\n\b\u0000\u0010\u0002 \u0001*\u00020\u00012\u00020\u0003:\u0002\u000b\fB\u0011\b\u0004\u0012\u0006\u0010\u0004\u001a\u00028\u0000¢\u0006\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0004\u001a\u00028\u00008\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\n\u0082\u0001\u0002\r\u000e¨\u0006\u000f"}, d2 = {"Lir/nasim/features/onboarding/data/model/OnboardingData;", "Lir/nasim/features/onboarding/data/model/OnboardingSpot;", TokenNames.S, "Landroid/os/Parcelable;", "onboardingSpot", "<init>", "(Lir/nasim/features/onboarding/data/model/OnboardingSpot;)V", "a", "Lir/nasim/features/onboarding/data/model/OnboardingSpot;", "getOnboardingSpot", "()Lir/nasim/features/onboarding/data/model/OnboardingSpot;", "Disabled", PeerConnectionFactory.TRIAL_ENABLED, "Lir/nasim/features/onboarding/data/model/OnboardingData$Disabled;", "Lir/nasim/features/onboarding/data/model/OnboardingData$Enabled;", "nasim_release"}, k = 1, mv = {2, 0, 0})
/* loaded from: classes6.dex */
public abstract class OnboardingData<S extends OnboardingSpot> implements Parcelable {

    /* renamed from: a, reason: from kotlin metadata */
    private final OnboardingSpot onboardingSpot;

    @Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0087\b\u0018\u0000*\n\b\u0001\u0010\u0002 \u0001*\u00020\u00012\b\u0012\u0004\u0012\u00028\u00010\u0003B\u000f\u0012\u0006\u0010\u0004\u001a\u00028\u0001¢\u0006\u0004\b\u0005\u0010\u0006J\u001f\u0010\f\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0007¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000e\u001a\u00020\tH\u0007¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0011\u001a\u00020\u0010H×\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0013\u001a\u00020\tH×\u0001¢\u0006\u0004\b\u0013\u0010\u000fJ\u001a\u0010\u0017\u001a\u00020\u00162\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014H×\u0003¢\u0006\u0004\b\u0017\u0010\u0018R\u001a\u0010\u0004\u001a\u00028\u00018\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c¨\u0006\u001d"}, d2 = {"Lir/nasim/features/onboarding/data/model/OnboardingData$Disabled;", "Lir/nasim/features/onboarding/data/model/OnboardingSpot;", TokenNames.S, "Lir/nasim/features/onboarding/data/model/OnboardingData;", "onboardingSpot", "<init>", "(Lir/nasim/features/onboarding/data/model/OnboardingSpot;)V", "Landroid/os/Parcel;", "dest", "", "flags", "Lir/nasim/rB7;", "writeToParcel", "(Landroid/os/Parcel;I)V", "describeContents", "()I", "", "toString", "()Ljava/lang/String;", "hashCode", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "b", "Lir/nasim/features/onboarding/data/model/OnboardingSpot;", "getOnboardingSpot", "()Lir/nasim/features/onboarding/data/model/OnboardingSpot;", "nasim_release"}, k = 1, mv = {2, 0, 0})
    public static final /* data */ class Disabled<S extends OnboardingSpot> extends OnboardingData<S> {
        public static final Parcelable.Creator<Disabled<?>> CREATOR = new a();

        /* renamed from: b, reason: from kotlin metadata and from toString */
        private final OnboardingSpot onboardingSpot;

        public static final class a implements Parcelable.Creator {
            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public final Disabled createFromParcel(Parcel parcel) {
                AbstractC13042fc3.i(parcel, "parcel");
                return new Disabled((OnboardingSpot) parcel.readParcelable(Disabled.class.getClassLoader()));
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public final Disabled[] newArray(int i) {
                return new Disabled[i];
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Disabled(OnboardingSpot onboardingSpot) {
            super(onboardingSpot, null);
            AbstractC13042fc3.i(onboardingSpot, "onboardingSpot");
            this.onboardingSpot = onboardingSpot;
        }

        @Override // android.os.Parcelable
        public final int describeContents() {
            return 0;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof Disabled) && AbstractC13042fc3.d(this.onboardingSpot, ((Disabled) other).onboardingSpot);
        }

        public int hashCode() {
            return this.onboardingSpot.hashCode();
        }

        public String toString() {
            return "Disabled(onboardingSpot=" + this.onboardingSpot + Separators.RPAREN;
        }

        @Override // android.os.Parcelable
        public final void writeToParcel(Parcel dest, int flags) {
            AbstractC13042fc3.i(dest, "dest");
            dest.writeParcelable(this.onboardingSpot, flags);
        }
    }

    @Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u0000 \u0019*\n\b\u0001\u0010\u0002 \u0001*\u00020\u00012\b\u0012\u0004\u0012\u00028\u00010\u0003:\u0005\u001a\u001b\u001c\u001d\u0017B)\b\u0004\u0012\u0006\u0010\u0004\u001a\u00028\u0001\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\b\u0010\t\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\r\u001a\u00020\f2\b\b\u0002\u0010\u0004\u001a\u00020\u0001¢\u0006\u0004\b\r\u0010\u000eR\u001a\u0010\u0004\u001a\u00028\u00018\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u000f\u0010\u0011R \u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\r\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u001c\u0010\t\u001a\u0004\u0018\u00010\b8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018\u0082\u0001\u0004\u001e\u001f !¨\u0006\""}, d2 = {"Lir/nasim/features/onboarding/data/model/OnboardingData$Enabled;", "Lir/nasim/features/onboarding/data/model/OnboardingSpot;", TokenNames.S, "Lir/nasim/features/onboarding/data/model/OnboardingData;", "onboardingSpot", "", "Lir/nasim/features/onboarding/data/model/OnboardingPeer;", "peerList", "", "bannerUrl", "<init>", "(Lir/nasim/features/onboarding/data/model/OnboardingSpot;Ljava/util/List;Ljava/lang/String;)V", "", "c", "(Lir/nasim/features/onboarding/data/model/OnboardingSpot;)I", "b", "Lir/nasim/features/onboarding/data/model/OnboardingSpot;", "()Lir/nasim/features/onboarding/data/model/OnboardingSpot;", "Ljava/util/List;", "getPeerList", "()Ljava/util/List;", "d", "Ljava/lang/String;", "a", "()Ljava/lang/String;", "e", "ContactsChannels", "SuggestedPeers", "SuggestedServicePeers", "EmptyStateSuggestedPeers", "Lir/nasim/features/onboarding/data/model/OnboardingData$Enabled$ContactsChannels;", "Lir/nasim/features/onboarding/data/model/OnboardingData$Enabled$EmptyStateSuggestedPeers;", "Lir/nasim/features/onboarding/data/model/OnboardingData$Enabled$SuggestedPeers;", "Lir/nasim/features/onboarding/data/model/OnboardingData$Enabled$SuggestedServicePeers;", "nasim_release"}, k = 1, mv = {2, 0, 0})
    public static abstract class Enabled<S extends OnboardingSpot> extends OnboardingData<S> {
        public static final int f = 8;

        /* renamed from: b, reason: from kotlin metadata */
        private final OnboardingSpot onboardingSpot;

        /* renamed from: c, reason: from kotlin metadata */
        private final List peerList;

        /* renamed from: d, reason: from kotlin metadata */
        private final String bannerUrl;

        @Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000e\b\u0087\b\u0018\u0000*\n\b\u0002\u0010\u0002 \u0001*\u00020\u00012\b\u0012\u0004\u0012\u00028\u00020\u0003B'\u0012\u0006\u0010\u0004\u001a\u00028\u0002\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\b\u0010\t\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\n\u0010\u000bJ\u001f\u0010\u0011\u001a\u00020\u00102\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000eH\u0007¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0013\u001a\u00020\u000eH\u0007¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0015\u001a\u00020\bH×\u0001¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0017\u001a\u00020\u000eH×\u0001¢\u0006\u0004\b\u0017\u0010\u0014J\u001a\u0010\u001b\u001a\u00020\u001a2\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018H×\u0003¢\u0006\u0004\b\u001b\u0010\u001cR\u001a\u0010\u0004\u001a\u00028\u00028\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 R\u001d\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058\u0006¢\u0006\f\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$R\u001c\u0010\t\u001a\u0004\u0018\u00010\b8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b%\u0010&\u001a\u0004\b'\u0010\u0016¨\u0006("}, d2 = {"Lir/nasim/features/onboarding/data/model/OnboardingData$Enabled$ContactsChannels;", "Lir/nasim/features/onboarding/data/model/OnboardingSpot;", TokenNames.S, "Lir/nasim/features/onboarding/data/model/OnboardingData$Enabled;", "onboardingSpot", "", "Lir/nasim/features/onboarding/data/model/OnboardingPeer$ContactsChannel;", "channelList", "", "bannerUrl", "<init>", "(Lir/nasim/features/onboarding/data/model/OnboardingSpot;Ljava/util/List;Ljava/lang/String;)V", "Landroid/os/Parcel;", "dest", "", "flags", "Lir/nasim/rB7;", "writeToParcel", "(Landroid/os/Parcel;I)V", "describeContents", "()I", "toString", "()Ljava/lang/String;", "hashCode", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "g", "Lir/nasim/features/onboarding/data/model/OnboardingSpot;", "b", "()Lir/nasim/features/onboarding/data/model/OnboardingSpot;", "h", "Ljava/util/List;", "e", "()Ljava/util/List;", "i", "Ljava/lang/String;", "a", "nasim_release"}, k = 1, mv = {2, 0, 0})
        public static final /* data */ class ContactsChannels<S extends OnboardingSpot> extends Enabled<S> {
            public static final Parcelable.Creator<ContactsChannels<?>> CREATOR = new a();

            /* renamed from: g, reason: from kotlin metadata and from toString */
            private final OnboardingSpot onboardingSpot;

            /* renamed from: h, reason: from kotlin metadata and from toString */
            private final List channelList;

            /* renamed from: i, reason: from kotlin metadata and from toString */
            private final String bannerUrl;

            public static final class a implements Parcelable.Creator {
                @Override // android.os.Parcelable.Creator
                /* renamed from: a, reason: merged with bridge method [inline-methods] */
                public final ContactsChannels createFromParcel(Parcel parcel) {
                    AbstractC13042fc3.i(parcel, "parcel");
                    OnboardingSpot onboardingSpot = (OnboardingSpot) parcel.readParcelable(ContactsChannels.class.getClassLoader());
                    int i = parcel.readInt();
                    ArrayList arrayList = new ArrayList(i);
                    for (int i2 = 0; i2 != i; i2++) {
                        arrayList.add(OnboardingPeer.ContactsChannel.CREATOR.createFromParcel(parcel));
                    }
                    return new ContactsChannels(onboardingSpot, arrayList, parcel.readString());
                }

                @Override // android.os.Parcelable.Creator
                /* renamed from: b, reason: merged with bridge method [inline-methods] */
                public final ContactsChannels[] newArray(int i) {
                    return new ContactsChannels[i];
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public ContactsChannels(OnboardingSpot onboardingSpot, List list, String str) {
                super(onboardingSpot, list, str, null);
                AbstractC13042fc3.i(onboardingSpot, "onboardingSpot");
                AbstractC13042fc3.i(list, "channelList");
                this.onboardingSpot = onboardingSpot;
                this.channelList = list;
                this.bannerUrl = str;
            }

            @Override // ir.nasim.features.onboarding.data.model.OnboardingData.Enabled
            /* renamed from: a, reason: from getter */
            public String getBannerUrl() {
                return this.bannerUrl;
            }

            @Override // ir.nasim.features.onboarding.data.model.OnboardingData.Enabled
            /* renamed from: b, reason: from getter */
            public OnboardingSpot getOnboardingSpot() {
                return this.onboardingSpot;
            }

            @Override // android.os.Parcelable
            public final int describeContents() {
                return 0;
            }

            /* renamed from: e, reason: from getter */
            public final List getChannelList() {
                return this.channelList;
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof ContactsChannels)) {
                    return false;
                }
                ContactsChannels contactsChannels = (ContactsChannels) other;
                return AbstractC13042fc3.d(this.onboardingSpot, contactsChannels.onboardingSpot) && AbstractC13042fc3.d(this.channelList, contactsChannels.channelList) && AbstractC13042fc3.d(this.bannerUrl, contactsChannels.bannerUrl);
            }

            public int hashCode() {
                int iHashCode = ((this.onboardingSpot.hashCode() * 31) + this.channelList.hashCode()) * 31;
                String str = this.bannerUrl;
                return iHashCode + (str == null ? 0 : str.hashCode());
            }

            public String toString() {
                return "ContactsChannels(onboardingSpot=" + this.onboardingSpot + ", channelList=" + this.channelList + ", bannerUrl=" + this.bannerUrl + Separators.RPAREN;
            }

            @Override // android.os.Parcelable
            public final void writeToParcel(Parcel dest, int flags) {
                AbstractC13042fc3.i(dest, "dest");
                dest.writeParcelable(this.onboardingSpot, flags);
                List list = this.channelList;
                dest.writeInt(list.size());
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    ((OnboardingPeer.ContactsChannel) it.next()).writeToParcel(dest, flags);
                }
                dest.writeString(this.bannerUrl);
            }
        }

        @Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000e\b\u0087\b\u0018\u0000*\n\b\u0002\u0010\u0002 \u0001*\u00020\u00012\b\u0012\u0004\u0012\u00028\u00020\u0003B'\u0012\u0006\u0010\u0004\u001a\u00028\u0002\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\b\u0010\t\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\n\u0010\u000bJ\u001f\u0010\u0011\u001a\u00020\u00102\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000eH\u0007¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0013\u001a\u00020\u000eH\u0007¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0015\u001a\u00020\bH×\u0001¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0017\u001a\u00020\u000eH×\u0001¢\u0006\u0004\b\u0017\u0010\u0014J\u001a\u0010\u001b\u001a\u00020\u001a2\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018H×\u0003¢\u0006\u0004\b\u001b\u0010\u001cR\u001a\u0010\u0004\u001a\u00028\u00028\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 R \u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058\u0016X\u0096\u0004¢\u0006\f\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$R\u001c\u0010\t\u001a\u0004\u0018\u00010\b8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b%\u0010&\u001a\u0004\b'\u0010\u0016¨\u0006("}, d2 = {"Lir/nasim/features/onboarding/data/model/OnboardingData$Enabled$EmptyStateSuggestedPeers;", "Lir/nasim/features/onboarding/data/model/OnboardingSpot;", TokenNames.S, "Lir/nasim/features/onboarding/data/model/OnboardingData$Enabled;", "onboardingSpot", "", "Lir/nasim/features/onboarding/data/model/OnboardingPeer$EmptyStateSuggestedPeer;", "peerList", "", "bannerUrl", "<init>", "(Lir/nasim/features/onboarding/data/model/OnboardingSpot;Ljava/util/List;Ljava/lang/String;)V", "Landroid/os/Parcel;", "dest", "", "flags", "Lir/nasim/rB7;", "writeToParcel", "(Landroid/os/Parcel;I)V", "describeContents", "()I", "toString", "()Ljava/lang/String;", "hashCode", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "g", "Lir/nasim/features/onboarding/data/model/OnboardingSpot;", "b", "()Lir/nasim/features/onboarding/data/model/OnboardingSpot;", "h", "Ljava/util/List;", "e", "()Ljava/util/List;", "i", "Ljava/lang/String;", "a", "nasim_release"}, k = 1, mv = {2, 0, 0})
        public static final /* data */ class EmptyStateSuggestedPeers<S extends OnboardingSpot> extends Enabled<S> {
            public static final Parcelable.Creator<EmptyStateSuggestedPeers<?>> CREATOR = new a();

            /* renamed from: g, reason: from kotlin metadata and from toString */
            private final OnboardingSpot onboardingSpot;

            /* renamed from: h, reason: from kotlin metadata and from toString */
            private final List peerList;

            /* renamed from: i, reason: from kotlin metadata and from toString */
            private final String bannerUrl;

            public static final class a implements Parcelable.Creator {
                @Override // android.os.Parcelable.Creator
                /* renamed from: a, reason: merged with bridge method [inline-methods] */
                public final EmptyStateSuggestedPeers createFromParcel(Parcel parcel) {
                    AbstractC13042fc3.i(parcel, "parcel");
                    OnboardingSpot onboardingSpot = (OnboardingSpot) parcel.readParcelable(EmptyStateSuggestedPeers.class.getClassLoader());
                    int i = parcel.readInt();
                    ArrayList arrayList = new ArrayList(i);
                    for (int i2 = 0; i2 != i; i2++) {
                        arrayList.add(OnboardingPeer.EmptyStateSuggestedPeer.CREATOR.createFromParcel(parcel));
                    }
                    return new EmptyStateSuggestedPeers(onboardingSpot, arrayList, parcel.readString());
                }

                @Override // android.os.Parcelable.Creator
                /* renamed from: b, reason: merged with bridge method [inline-methods] */
                public final EmptyStateSuggestedPeers[] newArray(int i) {
                    return new EmptyStateSuggestedPeers[i];
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public EmptyStateSuggestedPeers(OnboardingSpot onboardingSpot, List list, String str) {
                super(onboardingSpot, list, str, null);
                AbstractC13042fc3.i(onboardingSpot, "onboardingSpot");
                AbstractC13042fc3.i(list, "peerList");
                this.onboardingSpot = onboardingSpot;
                this.peerList = list;
                this.bannerUrl = str;
            }

            @Override // ir.nasim.features.onboarding.data.model.OnboardingData.Enabled
            /* renamed from: a, reason: from getter */
            public String getBannerUrl() {
                return this.bannerUrl;
            }

            @Override // ir.nasim.features.onboarding.data.model.OnboardingData.Enabled
            /* renamed from: b, reason: from getter */
            public OnboardingSpot getOnboardingSpot() {
                return this.onboardingSpot;
            }

            @Override // android.os.Parcelable
            public final int describeContents() {
                return 0;
            }

            /* renamed from: e, reason: from getter */
            public List getPeerList() {
                return this.peerList;
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof EmptyStateSuggestedPeers)) {
                    return false;
                }
                EmptyStateSuggestedPeers emptyStateSuggestedPeers = (EmptyStateSuggestedPeers) other;
                return AbstractC13042fc3.d(this.onboardingSpot, emptyStateSuggestedPeers.onboardingSpot) && AbstractC13042fc3.d(this.peerList, emptyStateSuggestedPeers.peerList) && AbstractC13042fc3.d(this.bannerUrl, emptyStateSuggestedPeers.bannerUrl);
            }

            public int hashCode() {
                int iHashCode = ((this.onboardingSpot.hashCode() * 31) + this.peerList.hashCode()) * 31;
                String str = this.bannerUrl;
                return iHashCode + (str == null ? 0 : str.hashCode());
            }

            public String toString() {
                return "EmptyStateSuggestedPeers(onboardingSpot=" + this.onboardingSpot + ", peerList=" + this.peerList + ", bannerUrl=" + this.bannerUrl + Separators.RPAREN;
            }

            @Override // android.os.Parcelable
            public final void writeToParcel(Parcel dest, int flags) {
                AbstractC13042fc3.i(dest, "dest");
                dest.writeParcelable(this.onboardingSpot, flags);
                List list = this.peerList;
                dest.writeInt(list.size());
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    ((OnboardingPeer.EmptyStateSuggestedPeer) it.next()).writeToParcel(dest, flags);
                }
                dest.writeString(this.bannerUrl);
            }
        }

        @Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000e\b\u0087\b\u0018\u0000*\n\b\u0002\u0010\u0002 \u0001*\u00020\u00012\b\u0012\u0004\u0012\u00028\u00020\u0003B'\u0012\u0006\u0010\u0004\u001a\u00028\u0002\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\b\u0010\t\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\n\u0010\u000bJ\u001f\u0010\u0011\u001a\u00020\u00102\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000eH\u0007¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0013\u001a\u00020\u000eH\u0007¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0015\u001a\u00020\bH×\u0001¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0017\u001a\u00020\u000eH×\u0001¢\u0006\u0004\b\u0017\u0010\u0014J\u001a\u0010\u001b\u001a\u00020\u001a2\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018H×\u0003¢\u0006\u0004\b\u001b\u0010\u001cR\u001a\u0010\u0004\u001a\u00028\u00028\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 R \u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058\u0016X\u0096\u0004¢\u0006\f\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$R\u001c\u0010\t\u001a\u0004\u0018\u00010\b8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b%\u0010&\u001a\u0004\b'\u0010\u0016¨\u0006("}, d2 = {"Lir/nasim/features/onboarding/data/model/OnboardingData$Enabled$SuggestedPeers;", "Lir/nasim/features/onboarding/data/model/OnboardingSpot;", TokenNames.S, "Lir/nasim/features/onboarding/data/model/OnboardingData$Enabled;", "onboardingSpot", "", "Lir/nasim/features/onboarding/data/model/OnboardingPeer$SuggestedPeer;", "peerList", "", "bannerUrl", "<init>", "(Lir/nasim/features/onboarding/data/model/OnboardingSpot;Ljava/util/List;Ljava/lang/String;)V", "Landroid/os/Parcel;", "dest", "", "flags", "Lir/nasim/rB7;", "writeToParcel", "(Landroid/os/Parcel;I)V", "describeContents", "()I", "toString", "()Ljava/lang/String;", "hashCode", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "g", "Lir/nasim/features/onboarding/data/model/OnboardingSpot;", "b", "()Lir/nasim/features/onboarding/data/model/OnboardingSpot;", "h", "Ljava/util/List;", "e", "()Ljava/util/List;", "i", "Ljava/lang/String;", "a", "nasim_release"}, k = 1, mv = {2, 0, 0})
        public static final /* data */ class SuggestedPeers<S extends OnboardingSpot> extends Enabled<S> {
            public static final Parcelable.Creator<SuggestedPeers<?>> CREATOR = new a();

            /* renamed from: g, reason: from kotlin metadata and from toString */
            private final OnboardingSpot onboardingSpot;

            /* renamed from: h, reason: from kotlin metadata and from toString */
            private final List peerList;

            /* renamed from: i, reason: from kotlin metadata and from toString */
            private final String bannerUrl;

            public static final class a implements Parcelable.Creator {
                @Override // android.os.Parcelable.Creator
                /* renamed from: a, reason: merged with bridge method [inline-methods] */
                public final SuggestedPeers createFromParcel(Parcel parcel) {
                    AbstractC13042fc3.i(parcel, "parcel");
                    OnboardingSpot onboardingSpot = (OnboardingSpot) parcel.readParcelable(SuggestedPeers.class.getClassLoader());
                    int i = parcel.readInt();
                    ArrayList arrayList = new ArrayList(i);
                    for (int i2 = 0; i2 != i; i2++) {
                        arrayList.add(OnboardingPeer.SuggestedPeer.CREATOR.createFromParcel(parcel));
                    }
                    return new SuggestedPeers(onboardingSpot, arrayList, parcel.readString());
                }

                @Override // android.os.Parcelable.Creator
                /* renamed from: b, reason: merged with bridge method [inline-methods] */
                public final SuggestedPeers[] newArray(int i) {
                    return new SuggestedPeers[i];
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public SuggestedPeers(OnboardingSpot onboardingSpot, List list, String str) {
                super(onboardingSpot, list, str, null);
                AbstractC13042fc3.i(onboardingSpot, "onboardingSpot");
                AbstractC13042fc3.i(list, "peerList");
                this.onboardingSpot = onboardingSpot;
                this.peerList = list;
                this.bannerUrl = str;
            }

            @Override // ir.nasim.features.onboarding.data.model.OnboardingData.Enabled
            /* renamed from: a, reason: from getter */
            public String getBannerUrl() {
                return this.bannerUrl;
            }

            @Override // ir.nasim.features.onboarding.data.model.OnboardingData.Enabled
            /* renamed from: b, reason: from getter */
            public OnboardingSpot getOnboardingSpot() {
                return this.onboardingSpot;
            }

            @Override // android.os.Parcelable
            public final int describeContents() {
                return 0;
            }

            /* renamed from: e, reason: from getter */
            public List getPeerList() {
                return this.peerList;
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof SuggestedPeers)) {
                    return false;
                }
                SuggestedPeers suggestedPeers = (SuggestedPeers) other;
                return AbstractC13042fc3.d(this.onboardingSpot, suggestedPeers.onboardingSpot) && AbstractC13042fc3.d(this.peerList, suggestedPeers.peerList) && AbstractC13042fc3.d(this.bannerUrl, suggestedPeers.bannerUrl);
            }

            public int hashCode() {
                int iHashCode = ((this.onboardingSpot.hashCode() * 31) + this.peerList.hashCode()) * 31;
                String str = this.bannerUrl;
                return iHashCode + (str == null ? 0 : str.hashCode());
            }

            public String toString() {
                return "SuggestedPeers(onboardingSpot=" + this.onboardingSpot + ", peerList=" + this.peerList + ", bannerUrl=" + this.bannerUrl + Separators.RPAREN;
            }

            @Override // android.os.Parcelable
            public final void writeToParcel(Parcel dest, int flags) {
                AbstractC13042fc3.i(dest, "dest");
                dest.writeParcelable(this.onboardingSpot, flags);
                List list = this.peerList;
                dest.writeInt(list.size());
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    ((OnboardingPeer.SuggestedPeer) it.next()).writeToParcel(dest, flags);
                }
                dest.writeString(this.bannerUrl);
            }
        }

        @Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0014\b\u0087\b\u0018\u0000*\n\b\u0002\u0010\u0002 \u0001*\u00020\u00012\b\u0012\u0004\u0012\u00028\u00020\u0003BC\u0012\u0006\u0010\u0004\u001a\u00028\u0002\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\b\u0010\t\u001a\u0004\u0018\u00010\b\u0012\b\u0010\n\u001a\u0004\u0018\u00010\b\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\b\u0012\u0006\u0010\r\u001a\u00020\f¢\u0006\u0004\b\u000e\u0010\u000fJ\u001f\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u0012H\u0007¢\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u0017\u001a\u00020\u0012H\u0007¢\u0006\u0004\b\u0017\u0010\u0018J\u0010\u0010\u0019\u001a\u00020\bH×\u0001¢\u0006\u0004\b\u0019\u0010\u001aJ\u0010\u0010\u001b\u001a\u00020\u0012H×\u0001¢\u0006\u0004\b\u001b\u0010\u0018J\u001a\u0010\u001f\u001a\u00020\u001e2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001cH×\u0003¢\u0006\u0004\b\u001f\u0010 R\u001a\u0010\u0004\u001a\u00028\u00028\u0016X\u0096\u0004¢\u0006\f\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$R \u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058\u0016X\u0096\u0004¢\u0006\f\n\u0004\b%\u0010&\u001a\u0004\b%\u0010'R\u001c\u0010\t\u001a\u0004\u0018\u00010\b8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b(\u0010)\u001a\u0004\b*\u0010\u001aR\u0019\u0010\n\u001a\u0004\u0018\u00010\b8\u0006¢\u0006\f\n\u0004\b+\u0010)\u001a\u0004\b,\u0010\u001aR\u0019\u0010\u000b\u001a\u0004\u0018\u00010\b8\u0006¢\u0006\f\n\u0004\b-\u0010)\u001a\u0004\b!\u0010\u001aR\u0017\u0010\r\u001a\u00020\f8\u0006¢\u0006\f\n\u0004\b.\u0010/\u001a\u0004\b0\u00101¨\u00062"}, d2 = {"Lir/nasim/features/onboarding/data/model/OnboardingData$Enabled$SuggestedServicePeers;", "Lir/nasim/features/onboarding/data/model/OnboardingSpot;", TokenNames.S, "Lir/nasim/features/onboarding/data/model/OnboardingData$Enabled;", "onboardingSpot", "", "Lir/nasim/features/onboarding/data/model/OnboardingPeer$EmptyStateSuggestedPeer;", "peerList", "", "bannerUrl", "innerBannerUrl", "innerTitle", "Lir/nasim/features/onboarding/data/model/OnboardingBannerType;", "bannerType", "<init>", "(Lir/nasim/features/onboarding/data/model/OnboardingSpot;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lir/nasim/features/onboarding/data/model/OnboardingBannerType;)V", "Landroid/os/Parcel;", "dest", "", "flags", "Lir/nasim/rB7;", "writeToParcel", "(Landroid/os/Parcel;I)V", "describeContents", "()I", "toString", "()Ljava/lang/String;", "hashCode", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "g", "Lir/nasim/features/onboarding/data/model/OnboardingSpot;", "b", "()Lir/nasim/features/onboarding/data/model/OnboardingSpot;", "h", "Ljava/util/List;", "()Ljava/util/List;", "i", "Ljava/lang/String;", "a", "j", "f", "k", "l", "Lir/nasim/features/onboarding/data/model/OnboardingBannerType;", "e", "()Lir/nasim/features/onboarding/data/model/OnboardingBannerType;", "nasim_release"}, k = 1, mv = {2, 0, 0})
        public static final /* data */ class SuggestedServicePeers<S extends OnboardingSpot> extends Enabled<S> {
            public static final Parcelable.Creator<SuggestedServicePeers<?>> CREATOR = new a();

            /* renamed from: g, reason: from kotlin metadata and from toString */
            private final OnboardingSpot onboardingSpot;

            /* renamed from: h, reason: from kotlin metadata and from toString */
            private final List peerList;

            /* renamed from: i, reason: from kotlin metadata and from toString */
            private final String bannerUrl;

            /* renamed from: j, reason: from kotlin metadata and from toString */
            private final String innerBannerUrl;

            /* renamed from: k, reason: from kotlin metadata and from toString */
            private final String innerTitle;

            /* renamed from: l, reason: from kotlin metadata and from toString */
            private final OnboardingBannerType bannerType;

            public static final class a implements Parcelable.Creator {
                @Override // android.os.Parcelable.Creator
                /* renamed from: a, reason: merged with bridge method [inline-methods] */
                public final SuggestedServicePeers createFromParcel(Parcel parcel) {
                    AbstractC13042fc3.i(parcel, "parcel");
                    OnboardingSpot onboardingSpot = (OnboardingSpot) parcel.readParcelable(SuggestedServicePeers.class.getClassLoader());
                    int i = parcel.readInt();
                    ArrayList arrayList = new ArrayList(i);
                    for (int i2 = 0; i2 != i; i2++) {
                        arrayList.add(OnboardingPeer.EmptyStateSuggestedPeer.CREATOR.createFromParcel(parcel));
                    }
                    return new SuggestedServicePeers(onboardingSpot, arrayList, parcel.readString(), parcel.readString(), parcel.readString(), (OnboardingBannerType) parcel.readParcelable(SuggestedServicePeers.class.getClassLoader()));
                }

                @Override // android.os.Parcelable.Creator
                /* renamed from: b, reason: merged with bridge method [inline-methods] */
                public final SuggestedServicePeers[] newArray(int i) {
                    return new SuggestedServicePeers[i];
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public SuggestedServicePeers(OnboardingSpot onboardingSpot, List list, String str, String str2, String str3, OnboardingBannerType onboardingBannerType) {
                super(onboardingSpot, list, str, null);
                AbstractC13042fc3.i(onboardingSpot, "onboardingSpot");
                AbstractC13042fc3.i(list, "peerList");
                AbstractC13042fc3.i(onboardingBannerType, "bannerType");
                this.onboardingSpot = onboardingSpot;
                this.peerList = list;
                this.bannerUrl = str;
                this.innerBannerUrl = str2;
                this.innerTitle = str3;
                this.bannerType = onboardingBannerType;
            }

            @Override // ir.nasim.features.onboarding.data.model.OnboardingData.Enabled
            /* renamed from: a, reason: from getter */
            public String getBannerUrl() {
                return this.bannerUrl;
            }

            @Override // ir.nasim.features.onboarding.data.model.OnboardingData.Enabled
            /* renamed from: b, reason: from getter */
            public OnboardingSpot getOnboardingSpot() {
                return this.onboardingSpot;
            }

            @Override // android.os.Parcelable
            public final int describeContents() {
                return 0;
            }

            /* renamed from: e, reason: from getter */
            public final OnboardingBannerType getBannerType() {
                return this.bannerType;
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof SuggestedServicePeers)) {
                    return false;
                }
                SuggestedServicePeers suggestedServicePeers = (SuggestedServicePeers) other;
                return AbstractC13042fc3.d(this.onboardingSpot, suggestedServicePeers.onboardingSpot) && AbstractC13042fc3.d(this.peerList, suggestedServicePeers.peerList) && AbstractC13042fc3.d(this.bannerUrl, suggestedServicePeers.bannerUrl) && AbstractC13042fc3.d(this.innerBannerUrl, suggestedServicePeers.innerBannerUrl) && AbstractC13042fc3.d(this.innerTitle, suggestedServicePeers.innerTitle) && AbstractC13042fc3.d(this.bannerType, suggestedServicePeers.bannerType);
            }

            /* renamed from: f, reason: from getter */
            public final String getInnerBannerUrl() {
                return this.innerBannerUrl;
            }

            /* renamed from: g, reason: from getter */
            public final String getInnerTitle() {
                return this.innerTitle;
            }

            /* renamed from: h, reason: from getter */
            public List getPeerList() {
                return this.peerList;
            }

            public int hashCode() {
                int iHashCode = ((this.onboardingSpot.hashCode() * 31) + this.peerList.hashCode()) * 31;
                String str = this.bannerUrl;
                int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
                String str2 = this.innerBannerUrl;
                int iHashCode3 = (iHashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
                String str3 = this.innerTitle;
                return ((iHashCode3 + (str3 != null ? str3.hashCode() : 0)) * 31) + this.bannerType.hashCode();
            }

            public String toString() {
                return "SuggestedServicePeers(onboardingSpot=" + this.onboardingSpot + ", peerList=" + this.peerList + ", bannerUrl=" + this.bannerUrl + ", innerBannerUrl=" + this.innerBannerUrl + ", innerTitle=" + this.innerTitle + ", bannerType=" + this.bannerType + Separators.RPAREN;
            }

            @Override // android.os.Parcelable
            public final void writeToParcel(Parcel dest, int flags) {
                AbstractC13042fc3.i(dest, "dest");
                dest.writeParcelable(this.onboardingSpot, flags);
                List list = this.peerList;
                dest.writeInt(list.size());
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    ((OnboardingPeer.EmptyStateSuggestedPeer) it.next()).writeToParcel(dest, flags);
                }
                dest.writeString(this.bannerUrl);
                dest.writeString(this.innerBannerUrl);
                dest.writeString(this.innerTitle);
                dest.writeParcelable(this.bannerType, flags);
            }
        }

        public /* synthetic */ Enabled(OnboardingSpot onboardingSpot, List list, String str, ED1 ed1) {
            this(onboardingSpot, list, str);
        }

        public static /* synthetic */ int d(Enabled enabled, OnboardingSpot onboardingSpot, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getScenarioId");
            }
            if ((i & 1) != 0) {
                onboardingSpot = enabled.getOnboardingSpot();
            }
            return enabled.c(onboardingSpot);
        }

        /* renamed from: a */
        public abstract String getBannerUrl();

        /* renamed from: b */
        public abstract OnboardingSpot getOnboardingSpot();

        public final int c(OnboardingSpot onboardingSpot) {
            AbstractC13042fc3.i(onboardingSpot, "onboardingSpot");
            if (this instanceof ContactsChannels) {
                return 1;
            }
            if (this instanceof SuggestedPeers) {
                if (onboardingSpot instanceof OnboardingSpot.SignUp) {
                    return 10;
                }
                if (onboardingSpot instanceof OnboardingSpot.DialogBanner) {
                    return 2;
                }
                if (!(onboardingSpot instanceof OnboardingSpot.Unknown) && !(onboardingSpot instanceof OnboardingSpot.EmptyState) && !(onboardingSpot instanceof OnboardingSpot.ActionBanner)) {
                    throw new NoWhenBranchMatchedException();
                }
            } else if (!(this instanceof EmptyStateSuggestedPeers)) {
                if (this instanceof SuggestedServicePeers) {
                    return 5;
                }
                throw new NoWhenBranchMatchedException();
            }
            return -1;
        }

        private Enabled(OnboardingSpot onboardingSpot, List list, String str) {
            super(onboardingSpot, null);
            this.onboardingSpot = onboardingSpot;
            this.peerList = list;
            this.bannerUrl = str;
        }
    }

    public /* synthetic */ OnboardingData(OnboardingSpot onboardingSpot, ED1 ed1) {
        this(onboardingSpot);
    }

    private OnboardingData(OnboardingSpot onboardingSpot) {
        this.onboardingSpot = onboardingSpot;
    }
}
