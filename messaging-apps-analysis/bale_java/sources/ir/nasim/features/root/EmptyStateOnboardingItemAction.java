package ir.nasim.features.root;

import android.gov.nist.core.Separators;
import android.gov.nist.javax.sip.parser.TokenNames;
import android.os.Parcel;
import android.os.Parcelable;
import ir.nasim.AbstractC13042fc3;
import ir.nasim.ED1;
import ir.nasim.L72;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001:\u0003\u0015\u0016\u0017B3\b\u0004\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\nR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\u000b\u0010\rR\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u00048\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u000f\u001a\u0004\b\u0012\u0010\u0011R\u001a\u0010\b\u001a\u00020\u00078\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0010\u0010\u0013\u001a\u0004\b\u000e\u0010\u0014\u0082\u0001\u0003\u0018\u0019\u001a¨\u0006\u001b"}, d2 = {"Lir/nasim/features/root/EmptyStateOnboardingItemAction;", "Landroid/os/Parcelable;", "", "code", "", "messageType", "messageInfo", "Lir/nasim/L72;", "emptyStateSpot", "<init>", "(ILjava/lang/String;Ljava/lang/String;Lir/nasim/L72;)V", "a", TokenNames.I, "()I", "b", "Ljava/lang/String;", "d", "()Ljava/lang/String;", "c", "Lir/nasim/L72;", "()Lir/nasim/L72;", "NotOpened", "Opened", "MessageSent", "Lir/nasim/features/root/EmptyStateOnboardingItemAction$MessageSent;", "Lir/nasim/features/root/EmptyStateOnboardingItemAction$NotOpened;", "Lir/nasim/features/root/EmptyStateOnboardingItemAction$Opened;", "nasim_release"}, k = 1, mv = {2, 0, 0})
/* loaded from: classes6.dex */
public abstract class EmptyStateOnboardingItemAction implements Parcelable {

    /* renamed from: a, reason: from kotlin metadata */
    private final int code;

    /* renamed from: b, reason: from kotlin metadata */
    private final String messageType;

    /* renamed from: c, reason: from kotlin metadata */
    private final String messageInfo;

    /* renamed from: d, reason: from kotlin metadata */
    private final L72 emptyStateSpot;

    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\f\b\u0087\b\u0018\u00002\u00020\u0001B'\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u001f\u0010\u000e\u001a\u00020\r2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000bH\u0007¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u00020\u000bH\u0007¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0012\u001a\u00020\u0002H×\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0014\u001a\u00020\u000bH×\u0001¢\u0006\u0004\b\u0014\u0010\u0011J\u001a\u0010\u0018\u001a\u00020\u00172\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015H×\u0003¢\u0006\u0004\b\u0018\u0010\u0019R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u0013R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u00028\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u001d\u0010\u001b\u001a\u0004\b\u001e\u0010\u0013R\u001a\u0010\u0006\u001a\u00020\u00058\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"¨\u0006#"}, d2 = {"Lir/nasim/features/root/EmptyStateOnboardingItemAction$MessageSent;", "Lir/nasim/features/root/EmptyStateOnboardingItemAction;", "", "messageType", "messageInfo", "Lir/nasim/L72;", "emptyStateSpot", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lir/nasim/L72;)V", "Landroid/os/Parcel;", "dest", "", "flags", "Lir/nasim/rB7;", "writeToParcel", "(Landroid/os/Parcel;I)V", "describeContents", "()I", "toString", "()Ljava/lang/String;", "hashCode", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "e", "Ljava/lang/String;", "d", "f", "c", "g", "Lir/nasim/L72;", "b", "()Lir/nasim/L72;", "nasim_release"}, k = 1, mv = {2, 0, 0})
    public static final /* data */ class MessageSent extends EmptyStateOnboardingItemAction {
        public static final Parcelable.Creator<MessageSent> CREATOR = new a();

        /* renamed from: e, reason: from kotlin metadata and from toString */
        private final String messageType;

        /* renamed from: f, reason: from kotlin metadata and from toString */
        private final String messageInfo;

        /* renamed from: g, reason: from kotlin metadata and from toString */
        private final L72 emptyStateSpot;

        public static final class a implements Parcelable.Creator {
            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public final MessageSent createFromParcel(Parcel parcel) {
                AbstractC13042fc3.i(parcel, "parcel");
                return new MessageSent(parcel.readString(), parcel.readString(), L72.valueOf(parcel.readString()));
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public final MessageSent[] newArray(int i) {
                return new MessageSent[i];
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public MessageSent(String str, String str2, L72 l72) {
            super(3, str, str2, l72, null);
            AbstractC13042fc3.i(l72, "emptyStateSpot");
            this.messageType = str;
            this.messageInfo = str2;
            this.emptyStateSpot = l72;
        }

        @Override // ir.nasim.features.root.EmptyStateOnboardingItemAction
        /* renamed from: b, reason: from getter */
        public L72 getEmptyStateSpot() {
            return this.emptyStateSpot;
        }

        @Override // ir.nasim.features.root.EmptyStateOnboardingItemAction
        /* renamed from: c, reason: from getter */
        public String getMessageInfo() {
            return this.messageInfo;
        }

        @Override // ir.nasim.features.root.EmptyStateOnboardingItemAction
        /* renamed from: d, reason: from getter */
        public String getMessageType() {
            return this.messageType;
        }

        @Override // android.os.Parcelable
        public final int describeContents() {
            return 0;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof MessageSent)) {
                return false;
            }
            MessageSent messageSent = (MessageSent) other;
            return AbstractC13042fc3.d(this.messageType, messageSent.messageType) && AbstractC13042fc3.d(this.messageInfo, messageSent.messageInfo) && this.emptyStateSpot == messageSent.emptyStateSpot;
        }

        public int hashCode() {
            String str = this.messageType;
            int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
            String str2 = this.messageInfo;
            return ((iHashCode + (str2 != null ? str2.hashCode() : 0)) * 31) + this.emptyStateSpot.hashCode();
        }

        public String toString() {
            return "MessageSent(messageType=" + this.messageType + ", messageInfo=" + this.messageInfo + ", emptyStateSpot=" + this.emptyStateSpot + Separators.RPAREN;
        }

        @Override // android.os.Parcelable
        public final void writeToParcel(Parcel dest, int flags) {
            AbstractC13042fc3.i(dest, "dest");
            dest.writeString(this.messageType);
            dest.writeString(this.messageInfo);
            dest.writeString(this.emptyStateSpot.name());
        }
    }

    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0003¢\u0006\u0004\b\u0002\u0010\u0003J\u001f\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0007¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\u0006H\u0007¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u000e\u001a\u00020\rH×\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0010\u001a\u00020\u0006H×\u0001¢\u0006\u0004\b\u0010\u0010\fJ\u001a\u0010\u0014\u001a\u00020\u00132\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H×\u0003¢\u0006\u0004\b\u0014\u0010\u0015¨\u0006\u0016"}, d2 = {"Lir/nasim/features/root/EmptyStateOnboardingItemAction$NotOpened;", "Lir/nasim/features/root/EmptyStateOnboardingItemAction;", "<init>", "()V", "Landroid/os/Parcel;", "dest", "", "flags", "Lir/nasim/rB7;", "writeToParcel", "(Landroid/os/Parcel;I)V", "describeContents", "()I", "", "toString", "()Ljava/lang/String;", "hashCode", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "nasim_release"}, k = 1, mv = {2, 0, 0})
    public static final /* data */ class NotOpened extends EmptyStateOnboardingItemAction {
        public static final NotOpened e = new NotOpened();
        public static final Parcelable.Creator<NotOpened> CREATOR = new a();

        public static final class a implements Parcelable.Creator {
            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public final NotOpened createFromParcel(Parcel parcel) {
                AbstractC13042fc3.i(parcel, "parcel");
                parcel.readInt();
                return NotOpened.e;
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public final NotOpened[] newArray(int i) {
                return new NotOpened[i];
            }
        }

        private NotOpened() {
            super(0, null, null, null, 14, null);
        }

        @Override // android.os.Parcelable
        public final int describeContents() {
            return 0;
        }

        public boolean equals(Object other) {
            return this == other || (other instanceof NotOpened);
        }

        public int hashCode() {
            return 1733779680;
        }

        public String toString() {
            return "NotOpened";
        }

        @Override // android.os.Parcelable
        public final void writeToParcel(Parcel dest, int flags) {
            AbstractC13042fc3.i(dest, "dest");
            dest.writeInt(1);
        }
    }

    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\f\b\u0087\b\u0018\u00002\u00020\u0001B'\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u001f\u0010\u000e\u001a\u00020\r2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000bH\u0007¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u00020\u000bH\u0007¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0012\u001a\u00020\u0002H×\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0014\u001a\u00020\u000bH×\u0001¢\u0006\u0004\b\u0014\u0010\u0011J\u001a\u0010\u0018\u001a\u00020\u00172\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015H×\u0003¢\u0006\u0004\b\u0018\u0010\u0019R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u0013R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u00028\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u001d\u0010\u001b\u001a\u0004\b\u001e\u0010\u0013R\u001a\u0010\u0006\u001a\u00020\u00058\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"¨\u0006#"}, d2 = {"Lir/nasim/features/root/EmptyStateOnboardingItemAction$Opened;", "Lir/nasim/features/root/EmptyStateOnboardingItemAction;", "", "messageType", "messageInfo", "Lir/nasim/L72;", "emptyStateSpot", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lir/nasim/L72;)V", "Landroid/os/Parcel;", "dest", "", "flags", "Lir/nasim/rB7;", "writeToParcel", "(Landroid/os/Parcel;I)V", "describeContents", "()I", "toString", "()Ljava/lang/String;", "hashCode", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "e", "Ljava/lang/String;", "d", "f", "c", "g", "Lir/nasim/L72;", "b", "()Lir/nasim/L72;", "nasim_release"}, k = 1, mv = {2, 0, 0})
    public static final /* data */ class Opened extends EmptyStateOnboardingItemAction {
        public static final Parcelable.Creator<Opened> CREATOR = new a();

        /* renamed from: e, reason: from kotlin metadata and from toString */
        private final String messageType;

        /* renamed from: f, reason: from kotlin metadata and from toString */
        private final String messageInfo;

        /* renamed from: g, reason: from kotlin metadata and from toString */
        private final L72 emptyStateSpot;

        public static final class a implements Parcelable.Creator {
            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public final Opened createFromParcel(Parcel parcel) {
                AbstractC13042fc3.i(parcel, "parcel");
                return new Opened(parcel.readString(), parcel.readString(), L72.valueOf(parcel.readString()));
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public final Opened[] newArray(int i) {
                return new Opened[i];
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Opened(String str, String str2, L72 l72) {
            super(4, str, str2, l72, null);
            AbstractC13042fc3.i(l72, "emptyStateSpot");
            this.messageType = str;
            this.messageInfo = str2;
            this.emptyStateSpot = l72;
        }

        @Override // ir.nasim.features.root.EmptyStateOnboardingItemAction
        /* renamed from: b, reason: from getter */
        public L72 getEmptyStateSpot() {
            return this.emptyStateSpot;
        }

        @Override // ir.nasim.features.root.EmptyStateOnboardingItemAction
        /* renamed from: c, reason: from getter */
        public String getMessageInfo() {
            return this.messageInfo;
        }

        @Override // ir.nasim.features.root.EmptyStateOnboardingItemAction
        /* renamed from: d, reason: from getter */
        public String getMessageType() {
            return this.messageType;
        }

        @Override // android.os.Parcelable
        public final int describeContents() {
            return 0;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Opened)) {
                return false;
            }
            Opened opened = (Opened) other;
            return AbstractC13042fc3.d(this.messageType, opened.messageType) && AbstractC13042fc3.d(this.messageInfo, opened.messageInfo) && this.emptyStateSpot == opened.emptyStateSpot;
        }

        public int hashCode() {
            String str = this.messageType;
            int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
            String str2 = this.messageInfo;
            return ((iHashCode + (str2 != null ? str2.hashCode() : 0)) * 31) + this.emptyStateSpot.hashCode();
        }

        public String toString() {
            return "Opened(messageType=" + this.messageType + ", messageInfo=" + this.messageInfo + ", emptyStateSpot=" + this.emptyStateSpot + Separators.RPAREN;
        }

        @Override // android.os.Parcelable
        public final void writeToParcel(Parcel dest, int flags) {
            AbstractC13042fc3.i(dest, "dest");
            dest.writeString(this.messageType);
            dest.writeString(this.messageInfo);
            dest.writeString(this.emptyStateSpot.name());
        }
    }

    public /* synthetic */ EmptyStateOnboardingItemAction(int i, String str, String str2, L72 l72, ED1 ed1) {
        this(i, str, str2, l72);
    }

    /* renamed from: a, reason: from getter */
    public final int getCode() {
        return this.code;
    }

    /* renamed from: b, reason: from getter */
    public L72 getEmptyStateSpot() {
        return this.emptyStateSpot;
    }

    /* renamed from: c, reason: from getter */
    public String getMessageInfo() {
        return this.messageInfo;
    }

    /* renamed from: d, reason: from getter */
    public String getMessageType() {
        return this.messageType;
    }

    private EmptyStateOnboardingItemAction(int i, String str, String str2, L72 l72) {
        this.code = i;
        this.messageType = str;
        this.messageInfo = str2;
        this.emptyStateSpot = l72;
    }

    public /* synthetic */ EmptyStateOnboardingItemAction(int i, String str, String str2, L72 l72, int i2, ED1 ed1) {
        this(i, (i2 & 2) != 0 ? null : str, (i2 & 4) != 0 ? null : str2, (i2 & 8) != 0 ? L72.b : l72, null);
    }
}
