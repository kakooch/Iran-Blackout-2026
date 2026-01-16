package ir.nasim.features.inappmessage.data.model;

import android.gov.nist.core.Separators;
import androidx.annotation.Keep;
import com.google.android.gms.common.annotation.KeepName;
import ir.nasim.AbstractC13042fc3;
import ir.nasim.ED1;
import ir.nasim.InterfaceC10156bA3;
import kotlin.Metadata;
import livekit.org.webrtc.PeerConnectionFactory;

@Keep
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001:\u0003\u0004\u0005\u0006B\t\b\u0005¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0003\u0007\b\t¨\u0006\n"}, d2 = {"Lir/nasim/features/inappmessage/data/model/InAppMessage;", "", "<init>", "()V", "Disabled", "Idle", PeerConnectionFactory.TRIAL_ENABLED, "Lir/nasim/features/inappmessage/data/model/InAppMessage$Disabled;", "Lir/nasim/features/inappmessage/data/model/InAppMessage$Enabled;", "Lir/nasim/features/inappmessage/data/model/InAppMessage$Idle;", "nasim_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
@KeepName
/* loaded from: classes5.dex */
public abstract class InAppMessage {
    public static final int $stable = 0;

    @Keep
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0003¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H×\u0003J\t\u0010\b\u001a\u00020\tH×\u0001J\t\u0010\n\u001a\u00020\u000bH×\u0001¨\u0006\f"}, d2 = {"Lir/nasim/features/inappmessage/data/model/InAppMessage$Disabled;", "Lir/nasim/features/inappmessage/data/model/InAppMessage;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "nasim_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    @KeepName
    public static final /* data */ class Disabled extends InAppMessage {
        public static final int $stable = 0;
        public static final Disabled INSTANCE = new Disabled();

        private Disabled() {
            super(null);
        }

        public boolean equals(Object other) {
            return this == other || (other instanceof Disabled);
        }

        public int hashCode() {
            return -1353820265;
        }

        public String toString() {
            return "Disabled";
        }
    }

    @Keep
    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0016\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0087\b\u0018\u00002\u00020\u0001BI\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0004\u0012\u0006\u0010\b\u001a\u00020\u0004\u0012\u0006\u0010\t\u001a\u00020\u0002\u0012\u0006\u0010\n\u001a\u00020\u0002\u0012\u0006\u0010\u000b\u001a\u00020\u0002¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000e\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u000e\u0010\u000fJ\u0012\u0010\u0010\u001a\u0004\u0018\u00010\u0004HÆ\u0003¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0012\u001a\u00020\u0004HÆ\u0003¢\u0006\u0004\b\u0012\u0010\u0011J\u0010\u0010\u0013\u001a\u00020\u0004HÆ\u0003¢\u0006\u0004\b\u0013\u0010\u0011J\u0010\u0010\u0014\u001a\u00020\u0004HÆ\u0003¢\u0006\u0004\b\u0014\u0010\u0011J\u0010\u0010\u0015\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0015\u0010\u000fJ\u0010\u0010\u0016\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0016\u0010\u000fJ\u0010\u0010\u0017\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0017\u0010\u000fJb\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u00042\b\b\u0002\u0010\b\u001a\u00020\u00042\b\b\u0002\u0010\t\u001a\u00020\u00022\b\b\u0002\u0010\n\u001a\u00020\u00022\b\b\u0002\u0010\u000b\u001a\u00020\u0002HÇ\u0001¢\u0006\u0004\b\u0018\u0010\u0019J\u0010\u0010\u001a\u001a\u00020\u0004H×\u0001¢\u0006\u0004\b\u001a\u0010\u0011J\u0010\u0010\u001c\u001a\u00020\u001bH×\u0001¢\u0006\u0004\b\u001c\u0010\u001dJ\u001a\u0010!\u001a\u00020 2\b\u0010\u001f\u001a\u0004\u0018\u00010\u001eH×\u0003¢\u0006\u0004\b!\u0010\"R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010#\u001a\u0004\b$\u0010\u000fR\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010%\u001a\u0004\b&\u0010\u0011R\u0017\u0010\u0006\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0006\u0010%\u001a\u0004\b'\u0010\u0011R\u0017\u0010\u0007\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0007\u0010%\u001a\u0004\b(\u0010\u0011R\u0017\u0010\b\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\b\u0010%\u001a\u0004\b)\u0010\u0011R\u0017\u0010\t\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\t\u0010#\u001a\u0004\b*\u0010\u000fR\u0017\u0010\n\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\n\u0010#\u001a\u0004\b+\u0010\u000fR\u0017\u0010\u000b\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u000b\u0010#\u001a\u0004\b,\u0010\u000fR\"\u0010-\u001a\u00020\u00048\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\b-\u0010%\u001a\u0004\b.\u0010\u0011\"\u0004\b/\u00100R\"\u00102\u001a\u0002018\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\b2\u00103\u001a\u0004\b4\u00105\"\u0004\b6\u00107¨\u00068"}, d2 = {"Lir/nasim/features/inappmessage/data/model/InAppMessage$Enabled;", "Lir/nasim/features/inappmessage/data/model/InAppMessage;", "", "inAppMessageId", "", "titleText", "bodyText", "startButtonText", "startButtonLink", "contentMediaFileId", "contentMediaAccessHash", "expireTimeInMills", "<init>", "(JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JJJ)V", "component1", "()J", "component2", "()Ljava/lang/String;", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "(JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JJJ)Lir/nasim/features/inappmessage/data/model/InAppMessage$Enabled;", "toString", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "J", "getInAppMessageId", "Ljava/lang/String;", "getTitleText", "getBodyText", "getStartButtonText", "getStartButtonLink", "getContentMediaFileId", "getContentMediaAccessHash", "getExpireTimeInMills", "contentMediaLink", "getContentMediaLink", "setContentMediaLink", "(Ljava/lang/String;)V", "Lir/nasim/bA3;", "startButtonLinkAction", "Lir/nasim/bA3;", "getStartButtonLinkAction", "()Lir/nasim/bA3;", "setStartButtonLinkAction", "(Lir/nasim/bA3;)V", "nasim_release"}, k = 1, mv = {2, 0, 0})
    @KeepName
    public static final /* data */ class Enabled extends InAppMessage {
        public static final int $stable = 8;
        private final String bodyText;
        private final long contentMediaAccessHash;
        private final long contentMediaFileId;

        @Keep
        @KeepName
        public String contentMediaLink;
        private final long expireTimeInMills;
        private final long inAppMessageId;
        private final String startButtonLink;

        @Keep
        @KeepName
        public InterfaceC10156bA3 startButtonLinkAction;
        private final String startButtonText;
        private final String titleText;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Enabled(long j, String str, String str2, String str3, String str4, long j2, long j3, long j4) {
            super(null);
            AbstractC13042fc3.i(str2, "bodyText");
            AbstractC13042fc3.i(str3, "startButtonText");
            AbstractC13042fc3.i(str4, "startButtonLink");
            this.inAppMessageId = j;
            this.titleText = str;
            this.bodyText = str2;
            this.startButtonText = str3;
            this.startButtonLink = str4;
            this.contentMediaFileId = j2;
            this.contentMediaAccessHash = j3;
            this.expireTimeInMills = j4;
        }

        /* renamed from: component1, reason: from getter */
        public final long getInAppMessageId() {
            return this.inAppMessageId;
        }

        /* renamed from: component2, reason: from getter */
        public final String getTitleText() {
            return this.titleText;
        }

        /* renamed from: component3, reason: from getter */
        public final String getBodyText() {
            return this.bodyText;
        }

        /* renamed from: component4, reason: from getter */
        public final String getStartButtonText() {
            return this.startButtonText;
        }

        /* renamed from: component5, reason: from getter */
        public final String getStartButtonLink() {
            return this.startButtonLink;
        }

        /* renamed from: component6, reason: from getter */
        public final long getContentMediaFileId() {
            return this.contentMediaFileId;
        }

        /* renamed from: component7, reason: from getter */
        public final long getContentMediaAccessHash() {
            return this.contentMediaAccessHash;
        }

        /* renamed from: component8, reason: from getter */
        public final long getExpireTimeInMills() {
            return this.expireTimeInMills;
        }

        public final Enabled copy(long inAppMessageId, String titleText, String bodyText, String startButtonText, String startButtonLink, long contentMediaFileId, long contentMediaAccessHash, long expireTimeInMills) {
            AbstractC13042fc3.i(bodyText, "bodyText");
            AbstractC13042fc3.i(startButtonText, "startButtonText");
            AbstractC13042fc3.i(startButtonLink, "startButtonLink");
            return new Enabled(inAppMessageId, titleText, bodyText, startButtonText, startButtonLink, contentMediaFileId, contentMediaAccessHash, expireTimeInMills);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Enabled)) {
                return false;
            }
            Enabled enabled = (Enabled) other;
            return this.inAppMessageId == enabled.inAppMessageId && AbstractC13042fc3.d(this.titleText, enabled.titleText) && AbstractC13042fc3.d(this.bodyText, enabled.bodyText) && AbstractC13042fc3.d(this.startButtonText, enabled.startButtonText) && AbstractC13042fc3.d(this.startButtonLink, enabled.startButtonLink) && this.contentMediaFileId == enabled.contentMediaFileId && this.contentMediaAccessHash == enabled.contentMediaAccessHash && this.expireTimeInMills == enabled.expireTimeInMills;
        }

        public final String getBodyText() {
            return this.bodyText;
        }

        public final long getContentMediaAccessHash() {
            return this.contentMediaAccessHash;
        }

        public final long getContentMediaFileId() {
            return this.contentMediaFileId;
        }

        public final String getContentMediaLink() {
            String str = this.contentMediaLink;
            if (str != null) {
                return str;
            }
            AbstractC13042fc3.y("contentMediaLink");
            return null;
        }

        public final long getExpireTimeInMills() {
            return this.expireTimeInMills;
        }

        public final long getInAppMessageId() {
            return this.inAppMessageId;
        }

        public final String getStartButtonLink() {
            return this.startButtonLink;
        }

        public final InterfaceC10156bA3 getStartButtonLinkAction() {
            InterfaceC10156bA3 interfaceC10156bA3 = this.startButtonLinkAction;
            if (interfaceC10156bA3 != null) {
                return interfaceC10156bA3;
            }
            AbstractC13042fc3.y("startButtonLinkAction");
            return null;
        }

        public final String getStartButtonText() {
            return this.startButtonText;
        }

        public final String getTitleText() {
            return this.titleText;
        }

        public int hashCode() {
            int iHashCode = Long.hashCode(this.inAppMessageId) * 31;
            String str = this.titleText;
            return ((((((((((((iHashCode + (str == null ? 0 : str.hashCode())) * 31) + this.bodyText.hashCode()) * 31) + this.startButtonText.hashCode()) * 31) + this.startButtonLink.hashCode()) * 31) + Long.hashCode(this.contentMediaFileId)) * 31) + Long.hashCode(this.contentMediaAccessHash)) * 31) + Long.hashCode(this.expireTimeInMills);
        }

        public final void setContentMediaLink(String str) {
            AbstractC13042fc3.i(str, "<set-?>");
            this.contentMediaLink = str;
        }

        public final void setStartButtonLinkAction(InterfaceC10156bA3 interfaceC10156bA3) {
            AbstractC13042fc3.i(interfaceC10156bA3, "<set-?>");
            this.startButtonLinkAction = interfaceC10156bA3;
        }

        public String toString() {
            return "Enabled(inAppMessageId=" + this.inAppMessageId + ", titleText=" + this.titleText + ", bodyText=" + this.bodyText + ", startButtonText=" + this.startButtonText + ", startButtonLink=" + this.startButtonLink + ", contentMediaFileId=" + this.contentMediaFileId + ", contentMediaAccessHash=" + this.contentMediaAccessHash + ", expireTimeInMills=" + this.expireTimeInMills + Separators.RPAREN;
        }
    }

    @Keep
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0003¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H×\u0003J\t\u0010\b\u001a\u00020\tH×\u0001J\t\u0010\n\u001a\u00020\u000bH×\u0001¨\u0006\f"}, d2 = {"Lir/nasim/features/inappmessage/data/model/InAppMessage$Idle;", "Lir/nasim/features/inappmessage/data/model/InAppMessage;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "nasim_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    @KeepName
    public static final /* data */ class Idle extends InAppMessage {
        public static final int $stable = 0;
        public static final Idle INSTANCE = new Idle();

        private Idle() {
            super(null);
        }

        public boolean equals(Object other) {
            return this == other || (other instanceof Idle);
        }

        public int hashCode() {
            return 370287215;
        }

        public String toString() {
            return "Idle";
        }
    }

    private InAppMessage() {
    }

    public /* synthetic */ InAppMessage(ED1 ed1) {
        this();
    }
}
