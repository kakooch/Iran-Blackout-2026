package ir.nasim.features.onboarding.data.model;

import android.gov.nist.core.Separators;
import android.gov.nist.javax.sip.parser.TokenNames;
import android.os.Parcel;
import android.os.Parcelable;
import ir.nasim.AbstractC13042fc3;
import ir.nasim.AbstractC20655sN7;
import ir.nasim.ED1;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001:\u0003\u0004\u0005\u0006B\t\b\u0005¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0003\u0007\b\t¨\u0006\n"}, d2 = {"Lir/nasim/features/onboarding/data/model/OnboardingPeer;", "Landroid/os/Parcelable;", "<init>", "()V", "SuggestedPeer", "ContactsChannel", "EmptyStateSuggestedPeer", "Lir/nasim/features/onboarding/data/model/OnboardingPeer$ContactsChannel;", "Lir/nasim/features/onboarding/data/model/OnboardingPeer$EmptyStateSuggestedPeer;", "Lir/nasim/features/onboarding/data/model/OnboardingPeer$SuggestedPeer;", "nasim_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes6.dex */
public abstract class OnboardingPeer implements Parcelable {

    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\b\u0087\b\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u001f\u0010\u000e\u001a\u00020\r2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000bH\u0007¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u00020\u000bH\u0007¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0012\u001a\u00020\u0004H×\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0014\u001a\u00020\u000bH×\u0001¢\u0006\u0004\b\u0014\u0010\u0011J\u001a\u0010\u0018\u001a\u00020\u00172\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015H×\u0003¢\u0006\u0004\b\u0018\u0010\u0019R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b\u001e\u0010\u0013R\u0017\u0010\u0006\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u001c\u0010\u001f\u001a\u0004\b\u001a\u0010\u0013¨\u0006 "}, d2 = {"Lir/nasim/features/onboarding/data/model/OnboardingPeer$EmptyStateSuggestedPeer;", "Lir/nasim/features/onboarding/data/model/OnboardingPeer;", "Lir/nasim/features/onboarding/data/model/PeerData;", "peerData", "", "description", "buttonText", "<init>", "(Lir/nasim/features/onboarding/data/model/PeerData;Ljava/lang/String;Ljava/lang/String;)V", "Landroid/os/Parcel;", "dest", "", "flags", "Lir/nasim/rB7;", "writeToParcel", "(Landroid/os/Parcel;I)V", "describeContents", "()I", "toString", "()Ljava/lang/String;", "hashCode", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "a", "Lir/nasim/features/onboarding/data/model/PeerData;", "c", "()Lir/nasim/features/onboarding/data/model/PeerData;", "b", "Ljava/lang/String;", "nasim_release"}, k = 1, mv = {2, 0, 0})
    public static final /* data */ class EmptyStateSuggestedPeer extends OnboardingPeer {
        public static final Parcelable.Creator<EmptyStateSuggestedPeer> CREATOR = new a();
        public static final int d = 0;

        /* renamed from: a, reason: from kotlin metadata and from toString */
        private final PeerData peerData;

        /* renamed from: b, reason: from kotlin metadata and from toString */
        private final String description;

        /* renamed from: c, reason: from kotlin metadata and from toString */
        private final String buttonText;

        public static final class a implements Parcelable.Creator {
            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public final EmptyStateSuggestedPeer createFromParcel(Parcel parcel) {
                AbstractC13042fc3.i(parcel, "parcel");
                return new EmptyStateSuggestedPeer(PeerData.CREATOR.createFromParcel(parcel), parcel.readString(), parcel.readString());
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public final EmptyStateSuggestedPeer[] newArray(int i) {
                return new EmptyStateSuggestedPeer[i];
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public EmptyStateSuggestedPeer(PeerData peerData, String str, String str2) {
            super(null);
            AbstractC13042fc3.i(peerData, "peerData");
            AbstractC13042fc3.i(str2, "buttonText");
            this.peerData = peerData;
            this.description = str;
            this.buttonText = str2;
        }

        /* renamed from: a, reason: from getter */
        public final String getButtonText() {
            return this.buttonText;
        }

        /* renamed from: b, reason: from getter */
        public final String getDescription() {
            return this.description;
        }

        /* renamed from: c, reason: from getter */
        public final PeerData getPeerData() {
            return this.peerData;
        }

        @Override // android.os.Parcelable
        public final int describeContents() {
            return 0;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof EmptyStateSuggestedPeer)) {
                return false;
            }
            EmptyStateSuggestedPeer emptyStateSuggestedPeer = (EmptyStateSuggestedPeer) other;
            return AbstractC13042fc3.d(this.peerData, emptyStateSuggestedPeer.peerData) && AbstractC13042fc3.d(this.description, emptyStateSuggestedPeer.description) && AbstractC13042fc3.d(this.buttonText, emptyStateSuggestedPeer.buttonText);
        }

        public int hashCode() {
            int iHashCode = this.peerData.hashCode() * 31;
            String str = this.description;
            return ((iHashCode + (str == null ? 0 : str.hashCode())) * 31) + this.buttonText.hashCode();
        }

        public String toString() {
            return "EmptyStateSuggestedPeer(peerData=" + this.peerData + ", description=" + this.description + ", buttonText=" + this.buttonText + Separators.RPAREN;
        }

        @Override // android.os.Parcelable
        public final void writeToParcel(Parcel dest, int flags) {
            AbstractC13042fc3.i(dest, "dest");
            this.peerData.writeToParcel(dest, flags);
            dest.writeString(this.description);
            dest.writeString(this.buttonText);
        }
    }

    private OnboardingPeer() {
    }

    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\b\u0087\b\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\u0004¢\u0006\u0004\b\t\u0010\nJ\u001f\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0011\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0013\u001a\u00020\u0006H×\u0001¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0015\u001a\u00020\u0004H×\u0001¢\u0006\u0004\b\u0015\u0010\u0012J\u001a\u0010\u0019\u001a\u00020\u00182\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016H×\u0003¢\u0006\u0004\b\u0019\u0010\u001aR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\u0012R\u0017\u0010\u0007\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b!\u0010\"\u001a\u0004\b\u001f\u0010\u0014R\u0017\u0010\b\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u001d\u0010 \u001a\u0004\b\u001b\u0010\u0012¨\u0006#"}, d2 = {"Lir/nasim/features/onboarding/data/model/OnboardingPeer$ContactsChannel;", "Lir/nasim/features/onboarding/data/model/OnboardingPeer;", "Lir/nasim/features/onboarding/data/model/PeerData;", "peerData", "", "channelMemberCount", "", "channelFormattedMemberCount", "channelCommonContactsCount", "<init>", "(Lir/nasim/features/onboarding/data/model/PeerData;ILjava/lang/String;I)V", "Landroid/os/Parcel;", "dest", "flags", "Lir/nasim/rB7;", "writeToParcel", "(Landroid/os/Parcel;I)V", "describeContents", "()I", "toString", "()Ljava/lang/String;", "hashCode", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "a", "Lir/nasim/features/onboarding/data/model/PeerData;", "d", "()Lir/nasim/features/onboarding/data/model/PeerData;", "b", TokenNames.I, "c", "Ljava/lang/String;", "nasim_release"}, k = 1, mv = {2, 0, 0})
    public static final /* data */ class ContactsChannel extends OnboardingPeer {
        public static final Parcelable.Creator<ContactsChannel> CREATOR = new a();
        public static final int e = 0;

        /* renamed from: a, reason: from kotlin metadata and from toString */
        private final PeerData peerData;

        /* renamed from: b, reason: from kotlin metadata and from toString */
        private final int channelMemberCount;

        /* renamed from: c, reason: from kotlin metadata and from toString */
        private final String channelFormattedMemberCount;

        /* renamed from: d, reason: from kotlin metadata and from toString */
        private final int channelCommonContactsCount;

        public static final class a implements Parcelable.Creator {
            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public final ContactsChannel createFromParcel(Parcel parcel) {
                AbstractC13042fc3.i(parcel, "parcel");
                return new ContactsChannel(PeerData.CREATOR.createFromParcel(parcel), parcel.readInt(), parcel.readString(), parcel.readInt());
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public final ContactsChannel[] newArray(int i) {
                return new ContactsChannel[i];
            }
        }

        public /* synthetic */ ContactsChannel(PeerData peerData, int i, String str, int i2, int i3, ED1 ed1) {
            this(peerData, i, (i3 & 4) != 0 ? AbstractC20655sN7.f(i) : str, i2);
        }

        /* renamed from: a, reason: from getter */
        public final int getChannelCommonContactsCount() {
            return this.channelCommonContactsCount;
        }

        /* renamed from: b, reason: from getter */
        public final String getChannelFormattedMemberCount() {
            return this.channelFormattedMemberCount;
        }

        /* renamed from: c, reason: from getter */
        public final int getChannelMemberCount() {
            return this.channelMemberCount;
        }

        /* renamed from: d, reason: from getter */
        public final PeerData getPeerData() {
            return this.peerData;
        }

        @Override // android.os.Parcelable
        public final int describeContents() {
            return 0;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ContactsChannel)) {
                return false;
            }
            ContactsChannel contactsChannel = (ContactsChannel) other;
            return AbstractC13042fc3.d(this.peerData, contactsChannel.peerData) && this.channelMemberCount == contactsChannel.channelMemberCount && AbstractC13042fc3.d(this.channelFormattedMemberCount, contactsChannel.channelFormattedMemberCount) && this.channelCommonContactsCount == contactsChannel.channelCommonContactsCount;
        }

        public int hashCode() {
            return (((((this.peerData.hashCode() * 31) + Integer.hashCode(this.channelMemberCount)) * 31) + this.channelFormattedMemberCount.hashCode()) * 31) + Integer.hashCode(this.channelCommonContactsCount);
        }

        public String toString() {
            return "ContactsChannel(peerData=" + this.peerData + ", channelMemberCount=" + this.channelMemberCount + ", channelFormattedMemberCount=" + this.channelFormattedMemberCount + ", channelCommonContactsCount=" + this.channelCommonContactsCount + Separators.RPAREN;
        }

        @Override // android.os.Parcelable
        public final void writeToParcel(Parcel dest, int flags) {
            AbstractC13042fc3.i(dest, "dest");
            this.peerData.writeToParcel(dest, flags);
            dest.writeInt(this.channelMemberCount);
            dest.writeString(this.channelFormattedMemberCount);
            dest.writeInt(this.channelCommonContactsCount);
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ContactsChannel(PeerData peerData, int i, String str, int i2) {
            super(null);
            AbstractC13042fc3.i(peerData, "peerData");
            AbstractC13042fc3.i(str, "channelFormattedMemberCount");
            this.peerData = peerData;
            this.channelMemberCount = i;
            this.channelFormattedMemberCount = str;
            this.channelCommonContactsCount = i2;
        }
    }

    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\b\u0087\b\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u001f\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0012\u001a\u00020\u0006H×\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0014\u001a\u00020\u0004H×\u0001¢\u0006\u0004\b\u0014\u0010\u0011J\u001a\u0010\u0018\u001a\u00020\u00172\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015H×\u0003¢\u0006\u0004\b\u0018\u0010\u0019R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b\u001e\u0010\u0011R\u0017\u0010\u0007\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u001c\u0010 \u001a\u0004\b\u001a\u0010\u0013¨\u0006!"}, d2 = {"Lir/nasim/features/onboarding/data/model/OnboardingPeer$SuggestedPeer;", "Lir/nasim/features/onboarding/data/model/OnboardingPeer;", "Lir/nasim/features/onboarding/data/model/PeerData;", "peerData", "", "memberOrUserCount", "", "formattedMemberOrUserCount", "<init>", "(Lir/nasim/features/onboarding/data/model/PeerData;ILjava/lang/String;)V", "Landroid/os/Parcel;", "dest", "flags", "Lir/nasim/rB7;", "writeToParcel", "(Landroid/os/Parcel;I)V", "describeContents", "()I", "toString", "()Ljava/lang/String;", "hashCode", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "a", "Lir/nasim/features/onboarding/data/model/PeerData;", "c", "()Lir/nasim/features/onboarding/data/model/PeerData;", "b", TokenNames.I, "Ljava/lang/String;", "nasim_release"}, k = 1, mv = {2, 0, 0})
    public static final /* data */ class SuggestedPeer extends OnboardingPeer {
        public static final Parcelable.Creator<SuggestedPeer> CREATOR = new a();
        public static final int d = 0;

        /* renamed from: a, reason: from kotlin metadata and from toString */
        private final PeerData peerData;

        /* renamed from: b, reason: from kotlin metadata and from toString */
        private final int memberOrUserCount;

        /* renamed from: c, reason: from kotlin metadata and from toString */
        private final String formattedMemberOrUserCount;

        public static final class a implements Parcelable.Creator {
            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public final SuggestedPeer createFromParcel(Parcel parcel) {
                AbstractC13042fc3.i(parcel, "parcel");
                return new SuggestedPeer(PeerData.CREATOR.createFromParcel(parcel), parcel.readInt(), parcel.readString());
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public final SuggestedPeer[] newArray(int i) {
                return new SuggestedPeer[i];
            }
        }

        public /* synthetic */ SuggestedPeer(PeerData peerData, int i, String str, int i2, ED1 ed1) {
            this(peerData, i, (i2 & 4) != 0 ? AbstractC20655sN7.f(i) : str);
        }

        /* renamed from: a, reason: from getter */
        public final String getFormattedMemberOrUserCount() {
            return this.formattedMemberOrUserCount;
        }

        /* renamed from: b, reason: from getter */
        public final int getMemberOrUserCount() {
            return this.memberOrUserCount;
        }

        /* renamed from: c, reason: from getter */
        public final PeerData getPeerData() {
            return this.peerData;
        }

        @Override // android.os.Parcelable
        public final int describeContents() {
            return 0;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof SuggestedPeer)) {
                return false;
            }
            SuggestedPeer suggestedPeer = (SuggestedPeer) other;
            return AbstractC13042fc3.d(this.peerData, suggestedPeer.peerData) && this.memberOrUserCount == suggestedPeer.memberOrUserCount && AbstractC13042fc3.d(this.formattedMemberOrUserCount, suggestedPeer.formattedMemberOrUserCount);
        }

        public int hashCode() {
            return (((this.peerData.hashCode() * 31) + Integer.hashCode(this.memberOrUserCount)) * 31) + this.formattedMemberOrUserCount.hashCode();
        }

        public String toString() {
            return "SuggestedPeer(peerData=" + this.peerData + ", memberOrUserCount=" + this.memberOrUserCount + ", formattedMemberOrUserCount=" + this.formattedMemberOrUserCount + Separators.RPAREN;
        }

        @Override // android.os.Parcelable
        public final void writeToParcel(Parcel dest, int flags) {
            AbstractC13042fc3.i(dest, "dest");
            this.peerData.writeToParcel(dest, flags);
            dest.writeInt(this.memberOrUserCount);
            dest.writeString(this.formattedMemberOrUserCount);
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public SuggestedPeer(PeerData peerData, int i, String str) {
            super(null);
            AbstractC13042fc3.i(peerData, "peerData");
            AbstractC13042fc3.i(str, "formattedMemberOrUserCount");
            this.peerData = peerData;
            this.memberOrUserCount = i;
            this.formattedMemberOrUserCount = str;
        }
    }

    public /* synthetic */ OnboardingPeer(ED1 ed1) {
        this();
    }
}
