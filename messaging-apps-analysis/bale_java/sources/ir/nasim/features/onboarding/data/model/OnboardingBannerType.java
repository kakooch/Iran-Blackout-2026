package ir.nasim.features.onboarding.data.model;

import android.gov.nist.core.Separators;
import android.gov.nist.javax.sip.parser.TokenNames;
import android.os.Parcel;
import android.os.Parcelable;
import ir.nasim.AbstractC13042fc3;
import ir.nasim.ED1;
import ir.nasim.EnumC12469eg;
import ir.nasim.EnumC13105fg;
import ir.nasim.core.modules.profile.entity.Avatar;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001:\u0004\r\u000e\u000f\u0010B\t\b\u0005¢\u0006\u0004\b\u0002\u0010\u0003J1\u0010\u000b\u001a\u00020\u00002\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u00042\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u000b\u0010\f\u0082\u0001\u0004\u0011\u0012\u0013\u0014¨\u0006\u0015"}, d2 = {"Lir/nasim/features/onboarding/data/model/OnboardingBannerType;", "Landroid/os/Parcelable;", "<init>", "()V", "", "title", "description", "Lir/nasim/fg;", "bannerImagePosition", "Lir/nasim/eg;", "imageCover", "a", "(Ljava/lang/String;Ljava/lang/String;Lir/nasim/fg;Lir/nasim/eg;)Lir/nasim/features/onboarding/data/model/OnboardingBannerType;", "ImageFull", "ImageCard", "ImageWithText", "ActionCardBanner", "Lir/nasim/features/onboarding/data/model/OnboardingBannerType$ActionCardBanner;", "Lir/nasim/features/onboarding/data/model/OnboardingBannerType$ImageCard;", "Lir/nasim/features/onboarding/data/model/OnboardingBannerType$ImageFull;", "Lir/nasim/features/onboarding/data/model/OnboardingBannerType$ImageWithText;", "nasim_release"}, k = 1, mv = {2, 0, 0})
/* loaded from: classes6.dex */
public abstract class OnboardingBannerType implements Parcelable {
    public static final int a = 0;

    @Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0000\n\u0002\b\u0011\b\u0087\b\u0018\u00002\u00020\u0001B9\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0004\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\n\u001a\u00020\t\u0012\u0006\u0010\u000b\u001a\u00020\u0004¢\u0006\u0004\b\f\u0010\rJ\u001f\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0014\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0014\u0010\u0015JN\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u00042\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\u000b\u001a\u00020\u0004HÇ\u0001¢\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0018\u001a\u00020\u0004H×\u0001¢\u0006\u0004\b\u0018\u0010\u0019J\u0010\u0010\u001a\u001a\u00020\u0002H×\u0001¢\u0006\u0004\b\u001a\u0010\u0015J\u001a\u0010\u001d\u001a\u00020\t2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001bH×\u0003¢\u0006\u0004\b\u001d\u0010\u001eR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0016\u0010\u001f\u001a\u0004\b \u0010\u0015R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010\u0019R\u0017\u0010\u0006\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b$\u0010\"\u001a\u0004\b%\u0010\u0019R\u0019\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006¢\u0006\f\n\u0004\b&\u0010'\u001a\u0004\b$\u0010(R\u0017\u0010\n\u001a\u00020\t8\u0006¢\u0006\f\n\u0004\b#\u0010)\u001a\u0004\b*\u0010+R\u0017\u0010\u000b\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b \u0010\"\u001a\u0004\b&\u0010\u0019¨\u0006,"}, d2 = {"Lir/nasim/features/onboarding/data/model/OnboardingBannerType$ActionCardBanner;", "Lir/nasim/features/onboarding/data/model/OnboardingBannerType;", "", "peerId", "", "description", "title", "Lir/nasim/core/modules/profile/entity/Avatar;", "avatar", "", "isBlueTick", "buttonText", "<init>", "(ILjava/lang/String;Ljava/lang/String;Lir/nasim/core/modules/profile/entity/Avatar;ZLjava/lang/String;)V", "Landroid/os/Parcel;", "dest", "flags", "Lir/nasim/rB7;", "writeToParcel", "(Landroid/os/Parcel;I)V", "describeContents", "()I", "b", "(ILjava/lang/String;Ljava/lang/String;Lir/nasim/core/modules/profile/entity/Avatar;ZLjava/lang/String;)Lir/nasim/features/onboarding/data/model/OnboardingBannerType$ActionCardBanner;", "toString", "()Ljava/lang/String;", "hashCode", "", "other", "equals", "(Ljava/lang/Object;)Z", TokenNames.I, "g", "c", "Ljava/lang/String;", "f", "d", "h", "e", "Lir/nasim/core/modules/profile/entity/Avatar;", "()Lir/nasim/core/modules/profile/entity/Avatar;", "Z", "i", "()Z", "nasim_release"}, k = 1, mv = {2, 0, 0})
    public static final /* data */ class ActionCardBanner extends OnboardingBannerType {
        public static final Parcelable.Creator<ActionCardBanner> CREATOR = new a();

        /* renamed from: b, reason: from kotlin metadata and from toString */
        private final int peerId;

        /* renamed from: c, reason: from kotlin metadata and from toString */
        private final String description;

        /* renamed from: d, reason: from kotlin metadata and from toString */
        private final String title;

        /* renamed from: e, reason: from kotlin metadata and from toString */
        private final Avatar avatar;

        /* renamed from: f, reason: from kotlin metadata and from toString */
        private final boolean isBlueTick;

        /* renamed from: g, reason: from kotlin metadata and from toString */
        private final String buttonText;

        public static final class a implements Parcelable.Creator {
            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public final ActionCardBanner createFromParcel(Parcel parcel) {
                AbstractC13042fc3.i(parcel, "parcel");
                return new ActionCardBanner(parcel.readInt(), parcel.readString(), parcel.readString(), (Avatar) parcel.readSerializable(), parcel.readInt() != 0, parcel.readString());
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public final ActionCardBanner[] newArray(int i) {
                return new ActionCardBanner[i];
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ActionCardBanner(int i, String str, String str2, Avatar avatar, boolean z, String str3) {
            super(null);
            AbstractC13042fc3.i(str, "description");
            AbstractC13042fc3.i(str2, "title");
            AbstractC13042fc3.i(str3, "buttonText");
            this.peerId = i;
            this.description = str;
            this.title = str2;
            this.avatar = avatar;
            this.isBlueTick = z;
            this.buttonText = str3;
        }

        public static /* synthetic */ ActionCardBanner c(ActionCardBanner actionCardBanner, int i, String str, String str2, Avatar avatar, boolean z, String str3, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                i = actionCardBanner.peerId;
            }
            if ((i2 & 2) != 0) {
                str = actionCardBanner.description;
            }
            String str4 = str;
            if ((i2 & 4) != 0) {
                str2 = actionCardBanner.title;
            }
            String str5 = str2;
            if ((i2 & 8) != 0) {
                avatar = actionCardBanner.avatar;
            }
            Avatar avatar2 = avatar;
            if ((i2 & 16) != 0) {
                z = actionCardBanner.isBlueTick;
            }
            boolean z2 = z;
            if ((i2 & 32) != 0) {
                str3 = actionCardBanner.buttonText;
            }
            return actionCardBanner.b(i, str4, str5, avatar2, z2, str3);
        }

        public final ActionCardBanner b(int peerId, String description, String title, Avatar avatar, boolean isBlueTick, String buttonText) {
            AbstractC13042fc3.i(description, "description");
            AbstractC13042fc3.i(title, "title");
            AbstractC13042fc3.i(buttonText, "buttonText");
            return new ActionCardBanner(peerId, description, title, avatar, isBlueTick, buttonText);
        }

        /* renamed from: d, reason: from getter */
        public final Avatar getAvatar() {
            return this.avatar;
        }

        @Override // android.os.Parcelable
        public final int describeContents() {
            return 0;
        }

        /* renamed from: e, reason: from getter */
        public final String getButtonText() {
            return this.buttonText;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ActionCardBanner)) {
                return false;
            }
            ActionCardBanner actionCardBanner = (ActionCardBanner) other;
            return this.peerId == actionCardBanner.peerId && AbstractC13042fc3.d(this.description, actionCardBanner.description) && AbstractC13042fc3.d(this.title, actionCardBanner.title) && AbstractC13042fc3.d(this.avatar, actionCardBanner.avatar) && this.isBlueTick == actionCardBanner.isBlueTick && AbstractC13042fc3.d(this.buttonText, actionCardBanner.buttonText);
        }

        /* renamed from: f, reason: from getter */
        public final String getDescription() {
            return this.description;
        }

        /* renamed from: g, reason: from getter */
        public final int getPeerId() {
            return this.peerId;
        }

        /* renamed from: h, reason: from getter */
        public final String getTitle() {
            return this.title;
        }

        public int hashCode() {
            int iHashCode = ((((Integer.hashCode(this.peerId) * 31) + this.description.hashCode()) * 31) + this.title.hashCode()) * 31;
            Avatar avatar = this.avatar;
            return ((((iHashCode + (avatar == null ? 0 : avatar.hashCode())) * 31) + Boolean.hashCode(this.isBlueTick)) * 31) + this.buttonText.hashCode();
        }

        /* renamed from: i, reason: from getter */
        public final boolean getIsBlueTick() {
            return this.isBlueTick;
        }

        public String toString() {
            return "ActionCardBanner(peerId=" + this.peerId + ", description=" + this.description + ", title=" + this.title + ", avatar=" + this.avatar + ", isBlueTick=" + this.isBlueTick + ", buttonText=" + this.buttonText + Separators.RPAREN;
        }

        @Override // android.os.Parcelable
        public final void writeToParcel(Parcel dest, int flags) {
            AbstractC13042fc3.i(dest, "dest");
            dest.writeInt(this.peerId);
            dest.writeString(this.description);
            dest.writeString(this.title);
            dest.writeSerializable(this.avatar);
            dest.writeInt(this.isBlueTick ? 1 : 0);
            dest.writeString(this.buttonText);
        }
    }

    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0003¢\u0006\u0004\b\u0002\u0010\u0003J\u001f\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0007¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\u0006H\u0007¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u000e\u001a\u00020\rH×\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0010\u001a\u00020\u0006H×\u0001¢\u0006\u0004\b\u0010\u0010\fJ\u001a\u0010\u0014\u001a\u00020\u00132\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H×\u0003¢\u0006\u0004\b\u0014\u0010\u0015¨\u0006\u0016"}, d2 = {"Lir/nasim/features/onboarding/data/model/OnboardingBannerType$ImageCard;", "Lir/nasim/features/onboarding/data/model/OnboardingBannerType;", "<init>", "()V", "Landroid/os/Parcel;", "dest", "", "flags", "Lir/nasim/rB7;", "writeToParcel", "(Landroid/os/Parcel;I)V", "describeContents", "()I", "", "toString", "()Ljava/lang/String;", "hashCode", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "nasim_release"}, k = 1, mv = {2, 0, 0})
    public static final /* data */ class ImageCard extends OnboardingBannerType {
        public static final ImageCard b = new ImageCard();
        public static final Parcelable.Creator<ImageCard> CREATOR = new a();

        public static final class a implements Parcelable.Creator {
            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public final ImageCard createFromParcel(Parcel parcel) {
                AbstractC13042fc3.i(parcel, "parcel");
                parcel.readInt();
                return ImageCard.b;
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public final ImageCard[] newArray(int i) {
                return new ImageCard[i];
            }
        }

        private ImageCard() {
            super(null);
        }

        @Override // android.os.Parcelable
        public final int describeContents() {
            return 0;
        }

        public boolean equals(Object other) {
            return this == other || (other instanceof ImageCard);
        }

        public int hashCode() {
            return -1234253290;
        }

        public String toString() {
            return "ImageCard";
        }

        @Override // android.os.Parcelable
        public final void writeToParcel(Parcel dest, int flags) {
            AbstractC13042fc3.i(dest, "dest");
            dest.writeInt(1);
        }
    }

    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0003¢\u0006\u0004\b\u0002\u0010\u0003J\u001f\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0007¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\u0006H\u0007¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u000e\u001a\u00020\rH×\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0010\u001a\u00020\u0006H×\u0001¢\u0006\u0004\b\u0010\u0010\fJ\u001a\u0010\u0014\u001a\u00020\u00132\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H×\u0003¢\u0006\u0004\b\u0014\u0010\u0015¨\u0006\u0016"}, d2 = {"Lir/nasim/features/onboarding/data/model/OnboardingBannerType$ImageFull;", "Lir/nasim/features/onboarding/data/model/OnboardingBannerType;", "<init>", "()V", "Landroid/os/Parcel;", "dest", "", "flags", "Lir/nasim/rB7;", "writeToParcel", "(Landroid/os/Parcel;I)V", "describeContents", "()I", "", "toString", "()Ljava/lang/String;", "hashCode", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "nasim_release"}, k = 1, mv = {2, 0, 0})
    public static final /* data */ class ImageFull extends OnboardingBannerType {
        public static final ImageFull b = new ImageFull();
        public static final Parcelable.Creator<ImageFull> CREATOR = new a();

        public static final class a implements Parcelable.Creator {
            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public final ImageFull createFromParcel(Parcel parcel) {
                AbstractC13042fc3.i(parcel, "parcel");
                parcel.readInt();
                return ImageFull.b;
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public final ImageFull[] newArray(int i) {
                return new ImageFull[i];
            }
        }

        private ImageFull() {
            super(null);
        }

        @Override // android.os.Parcelable
        public final int describeContents() {
            return 0;
        }

        public boolean equals(Object other) {
            return this == other || (other instanceof ImageFull);
        }

        public int hashCode() {
            return -1234144875;
        }

        public String toString() {
            return "ImageFull";
        }

        @Override // android.os.Parcelable
        public final void writeToParcel(Parcel dest, int flags) {
            AbstractC13042fc3.i(dest, "dest");
            dest.writeInt(1);
        }
    }

    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0000\n\u0002\b\u000b\b\u0087\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005¢\u0006\u0004\b\b\u0010\tJ\u001f\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\fH\u0007¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0011\u001a\u00020\fH\u0007¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0013\u001a\u00020\u0002H×\u0001¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0015\u001a\u00020\fH×\u0001¢\u0006\u0004\b\u0015\u0010\u0012J\u001a\u0010\u0018\u001a\u00020\u00052\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016H×\u0003¢\u0006\u0004\b\u0018\u0010\u0019R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u0014R\u0017\u0010\u0004\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u001c\u0010\u001b\u001a\u0004\b\u001a\u0010\u0014R\u0017\u0010\u0006\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 R\u0017\u0010\u0007\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b\u001f\u0010\u001e\u001a\u0004\b\u001d\u0010 ¨\u0006!"}, d2 = {"Lir/nasim/features/onboarding/data/model/OnboardingBannerType$ImageWithText;", "Lir/nasim/features/onboarding/data/model/OnboardingBannerType;", "", "title", "description", "", "isRtl", "isFill", "<init>", "(Ljava/lang/String;Ljava/lang/String;ZZ)V", "Landroid/os/Parcel;", "dest", "", "flags", "Lir/nasim/rB7;", "writeToParcel", "(Landroid/os/Parcel;I)V", "describeContents", "()I", "toString", "()Ljava/lang/String;", "hashCode", "", "other", "equals", "(Ljava/lang/Object;)Z", "b", "Ljava/lang/String;", "c", "d", "Z", "e", "()Z", "nasim_release"}, k = 1, mv = {2, 0, 0})
    public static final /* data */ class ImageWithText extends OnboardingBannerType {
        public static final Parcelable.Creator<ImageWithText> CREATOR = new a();

        /* renamed from: b, reason: from kotlin metadata and from toString */
        private final String title;

        /* renamed from: c, reason: from kotlin metadata and from toString */
        private final String description;

        /* renamed from: d, reason: from kotlin metadata and from toString */
        private final boolean isRtl;

        /* renamed from: e, reason: from kotlin metadata and from toString */
        private final boolean isFill;

        public static final class a implements Parcelable.Creator {
            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public final ImageWithText createFromParcel(Parcel parcel) {
                AbstractC13042fc3.i(parcel, "parcel");
                return new ImageWithText(parcel.readString(), parcel.readString(), parcel.readInt() != 0, parcel.readInt() != 0);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public final ImageWithText[] newArray(int i) {
                return new ImageWithText[i];
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ImageWithText(String str, String str2, boolean z, boolean z2) {
            super(null);
            AbstractC13042fc3.i(str, "title");
            AbstractC13042fc3.i(str2, "description");
            this.title = str;
            this.description = str2;
            this.isRtl = z;
            this.isFill = z2;
        }

        /* renamed from: b, reason: from getter */
        public final String getDescription() {
            return this.description;
        }

        /* renamed from: c, reason: from getter */
        public final String getTitle() {
            return this.title;
        }

        /* renamed from: d, reason: from getter */
        public final boolean getIsFill() {
            return this.isFill;
        }

        @Override // android.os.Parcelable
        public final int describeContents() {
            return 0;
        }

        /* renamed from: e, reason: from getter */
        public final boolean getIsRtl() {
            return this.isRtl;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ImageWithText)) {
                return false;
            }
            ImageWithText imageWithText = (ImageWithText) other;
            return AbstractC13042fc3.d(this.title, imageWithText.title) && AbstractC13042fc3.d(this.description, imageWithText.description) && this.isRtl == imageWithText.isRtl && this.isFill == imageWithText.isFill;
        }

        public int hashCode() {
            return (((((this.title.hashCode() * 31) + this.description.hashCode()) * 31) + Boolean.hashCode(this.isRtl)) * 31) + Boolean.hashCode(this.isFill);
        }

        public String toString() {
            return "ImageWithText(title=" + this.title + ", description=" + this.description + ", isRtl=" + this.isRtl + ", isFill=" + this.isFill + Separators.RPAREN;
        }

        @Override // android.os.Parcelable
        public final void writeToParcel(Parcel dest, int flags) {
            AbstractC13042fc3.i(dest, "dest");
            dest.writeString(this.title);
            dest.writeString(this.description);
            dest.writeInt(this.isRtl ? 1 : 0);
            dest.writeInt(this.isFill ? 1 : 0);
        }
    }

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[EnumC13105fg.values().length];
            try {
                iArr[EnumC13105fg.BannerImagePosition_CENTER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[EnumC13105fg.BannerImagePosition_LEFT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[EnumC13105fg.BannerImagePosition_RIGHT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[EnumC13105fg.UNRECOGNIZED.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            a = iArr;
        }
    }

    private OnboardingBannerType() {
    }

    public final OnboardingBannerType a(String title, String description, EnumC13105fg bannerImagePosition, EnumC12469eg imageCover) {
        AbstractC13042fc3.i(bannerImagePosition, "bannerImagePosition");
        AbstractC13042fc3.i(imageCover, "imageCover");
        int i = a.a[bannerImagePosition.ordinal()];
        if (i == 1) {
            return ImageFull.b;
        }
        if (i != 2 && i != 3) {
            if (i == 4) {
                return ImageFull.b;
            }
            throw new NoWhenBranchMatchedException();
        }
        if (title == null) {
            title = "";
        }
        if (description == null) {
            description = "";
        }
        return new ImageWithText(title, description, bannerImagePosition.getNumber() == 2, imageCover == EnumC12469eg.BannerImageCover_LARGE);
    }

    public /* synthetic */ OnboardingBannerType(ED1 ed1) {
        this();
    }
}
