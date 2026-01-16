package ir.nasim.features.eventbar.data.model;

import android.gov.nist.core.Separators;
import android.gov.nist.javax.sip.parser.TokenNames;
import androidx.annotation.Keep;
import ir.nasim.AbstractC13042fc3;
import ir.nasim.ED1;
import ir.nasim.F92;
import ir.nasim.G92;
import ir.nasim.InterfaceC10156bA3;
import kotlin.Metadata;
import livekit.org.webrtc.PeerConnectionFactory;

@Keep
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001:\u0003\u0004\u0005\u0006B\t\b\u0005¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0003\u0007\b\t¨\u0006\n"}, d2 = {"Lir/nasim/features/eventbar/data/model/EventBarData;", "", "<init>", "()V", "Disabled", "Idle", PeerConnectionFactory.TRIAL_ENABLED, "Lir/nasim/features/eventbar/data/model/EventBarData$Disabled;", "Lir/nasim/features/eventbar/data/model/EventBarData$Enabled;", "Lir/nasim/features/eventbar/data/model/EventBarData$Idle;", "nasim_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes5.dex */
public abstract class EventBarData {
    public static final int $stable = 0;

    @Keep
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0003¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H×\u0003J\t\u0010\b\u001a\u00020\tH×\u0001J\t\u0010\n\u001a\u00020\u000bH×\u0001¨\u0006\f"}, d2 = {"Lir/nasim/features/eventbar/data/model/EventBarData$Disabled;", "Lir/nasim/features/eventbar/data/model/EventBarData;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "nasim_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final /* data */ class Disabled extends EventBarData {
        public static final int $stable = 0;
        public static final Disabled INSTANCE = new Disabled();

        private Disabled() {
            super(null);
        }

        public boolean equals(Object other) {
            return this == other || (other instanceof Disabled);
        }

        public int hashCode() {
            return 458365201;
        }

        public String toString() {
            return "Disabled";
        }
    }

    @Keep
    @Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0014\n\u0002\u0010\u0000\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\b\b\u0087\b\u0018\u00002\u00020\u0001:\u0001:BG\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\u0006\u0012\u0006\u0010\t\u001a\u00020\u0006\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\u0006\u0010\f\u001a\u00020\u0004\u0012\u0006\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0011\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0013\u001a\u00020\u0004HÆ\u0003¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0015\u001a\u00020\u0006HÆ\u0003¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0017\u001a\u00020\u0006HÆ\u0003¢\u0006\u0004\b\u0017\u0010\u0016J\u0010\u0010\u0018\u001a\u00020\u0006HÆ\u0003¢\u0006\u0004\b\u0018\u0010\u0016J\u0010\u0010\u0019\u001a\u00020\nHÆ\u0003¢\u0006\u0004\b\u0019\u0010\u001aJ\u0010\u0010\u001b\u001a\u00020\u0004HÆ\u0003¢\u0006\u0004\b\u001b\u0010\u0014J\u0010\u0010\u001c\u001a\u00020\rHÆ\u0003¢\u0006\u0004\b\u001c\u0010\u001dJ`\u0010\u001e\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\u00062\b\b\u0002\u0010\t\u001a\u00020\u00062\b\b\u0002\u0010\u000b\u001a\u00020\n2\b\b\u0002\u0010\f\u001a\u00020\u00042\b\b\u0002\u0010\u000e\u001a\u00020\rHÇ\u0001¢\u0006\u0004\b\u001e\u0010\u001fJ\u0010\u0010 \u001a\u00020\u0006H×\u0001¢\u0006\u0004\b \u0010\u0016J\u0010\u0010!\u001a\u00020\nH×\u0001¢\u0006\u0004\b!\u0010\u001aJ\u001a\u0010$\u001a\u00020\r2\b\u0010#\u001a\u0004\u0018\u00010\"H×\u0003¢\u0006\u0004\b$\u0010%R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010&\u001a\u0004\b'\u0010\u0012R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010(\u001a\u0004\b)\u0010\u0014R\u0017\u0010\u0007\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u0007\u0010*\u001a\u0004\b+\u0010\u0016R\u0017\u0010\b\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\b\u0010*\u001a\u0004\b,\u0010\u0016R\u0017\u0010\t\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\t\u0010*\u001a\u0004\b-\u0010\u0016R\u0017\u0010\u000b\u001a\u00020\n8\u0006¢\u0006\f\n\u0004\b\u000b\u0010.\u001a\u0004\b/\u0010\u001aR\u0017\u0010\f\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\f\u0010(\u001a\u0004\b0\u0010\u0014R\u0017\u0010\u000e\u001a\u00020\r8\u0006¢\u0006\f\n\u0004\b\u000e\u00101\u001a\u0004\b2\u0010\u001dR\"\u00104\u001a\u0002038\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\b4\u00105\u001a\u0004\b6\u00107\"\u0004\b8\u00109¨\u0006;"}, d2 = {"Lir/nasim/features/eventbar/data/model/EventBarData$Enabled;", "Lir/nasim/features/eventbar/data/model/EventBarData;", "Lir/nasim/features/eventbar/data/model/EventBarData$Enabled$a;", "eventBarType", "", "eventBarId", "", "titleText", "buttonText", "contentLink", "", "colorsSetNumber", "expireTimeInMills", "", "hasTimer", "<init>", "(Lir/nasim/features/eventbar/data/model/EventBarData$Enabled$a;JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;IJZ)V", "component1", "()Lir/nasim/features/eventbar/data/model/EventBarData$Enabled$a;", "component2", "()J", "component3", "()Ljava/lang/String;", "component4", "component5", "component6", "()I", "component7", "component8", "()Z", "copy", "(Lir/nasim/features/eventbar/data/model/EventBarData$Enabled$a;JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;IJZ)Lir/nasim/features/eventbar/data/model/EventBarData$Enabled;", "toString", "hashCode", "", "other", "equals", "(Ljava/lang/Object;)Z", "Lir/nasim/features/eventbar/data/model/EventBarData$Enabled$a;", "getEventBarType", "J", "getEventBarId", "Ljava/lang/String;", "getTitleText", "getButtonText", "getContentLink", TokenNames.I, "getColorsSetNumber", "getExpireTimeInMills", "Z", "getHasTimer", "Lir/nasim/bA3;", "contentLinkAction", "Lir/nasim/bA3;", "getContentLinkAction", "()Lir/nasim/bA3;", "setContentLinkAction", "(Lir/nasim/bA3;)V", "a", "nasim_release"}, k = 1, mv = {2, 0, 0})
    public static final /* data */ class Enabled extends EventBarData {
        public static final int $stable = 8;
        private final String buttonText;
        private final int colorsSetNumber;
        private final String contentLink;

        @Keep
        public InterfaceC10156bA3 contentLinkAction;
        private final long eventBarId;
        private final a eventBarType;
        private final long expireTimeInMills;
        private final boolean hasTimer;
        private final String titleText;

        /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
        /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
        public static final class a {
            public static final a a = new a("REMOTE", 0);
            public static final a b = new a("UPDATE", 1);
            private static final /* synthetic */ a[] c;
            private static final /* synthetic */ F92 d;

            static {
                a[] aVarArrA = a();
                c = aVarArrA;
                d = G92.a(aVarArrA);
            }

            private a(String str, int i) {
            }

            private static final /* synthetic */ a[] a() {
                return new a[]{a, b};
            }

            public static a valueOf(String str) {
                return (a) Enum.valueOf(a.class, str);
            }

            public static a[] values() {
                return (a[]) c.clone();
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Enabled(a aVar, long j, String str, String str2, String str3, int i, long j2, boolean z) {
            super(null);
            AbstractC13042fc3.i(aVar, "eventBarType");
            AbstractC13042fc3.i(str, "titleText");
            AbstractC13042fc3.i(str2, "buttonText");
            AbstractC13042fc3.i(str3, "contentLink");
            this.eventBarType = aVar;
            this.eventBarId = j;
            this.titleText = str;
            this.buttonText = str2;
            this.contentLink = str3;
            this.colorsSetNumber = i;
            this.expireTimeInMills = j2;
            this.hasTimer = z;
        }

        /* renamed from: component1, reason: from getter */
        public final a getEventBarType() {
            return this.eventBarType;
        }

        /* renamed from: component2, reason: from getter */
        public final long getEventBarId() {
            return this.eventBarId;
        }

        /* renamed from: component3, reason: from getter */
        public final String getTitleText() {
            return this.titleText;
        }

        /* renamed from: component4, reason: from getter */
        public final String getButtonText() {
            return this.buttonText;
        }

        /* renamed from: component5, reason: from getter */
        public final String getContentLink() {
            return this.contentLink;
        }

        /* renamed from: component6, reason: from getter */
        public final int getColorsSetNumber() {
            return this.colorsSetNumber;
        }

        /* renamed from: component7, reason: from getter */
        public final long getExpireTimeInMills() {
            return this.expireTimeInMills;
        }

        /* renamed from: component8, reason: from getter */
        public final boolean getHasTimer() {
            return this.hasTimer;
        }

        public final Enabled copy(a eventBarType, long eventBarId, String titleText, String buttonText, String contentLink, int colorsSetNumber, long expireTimeInMills, boolean hasTimer) {
            AbstractC13042fc3.i(eventBarType, "eventBarType");
            AbstractC13042fc3.i(titleText, "titleText");
            AbstractC13042fc3.i(buttonText, "buttonText");
            AbstractC13042fc3.i(contentLink, "contentLink");
            return new Enabled(eventBarType, eventBarId, titleText, buttonText, contentLink, colorsSetNumber, expireTimeInMills, hasTimer);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Enabled)) {
                return false;
            }
            Enabled enabled = (Enabled) other;
            return this.eventBarType == enabled.eventBarType && this.eventBarId == enabled.eventBarId && AbstractC13042fc3.d(this.titleText, enabled.titleText) && AbstractC13042fc3.d(this.buttonText, enabled.buttonText) && AbstractC13042fc3.d(this.contentLink, enabled.contentLink) && this.colorsSetNumber == enabled.colorsSetNumber && this.expireTimeInMills == enabled.expireTimeInMills && this.hasTimer == enabled.hasTimer;
        }

        public final String getButtonText() {
            return this.buttonText;
        }

        public final int getColorsSetNumber() {
            return this.colorsSetNumber;
        }

        public final String getContentLink() {
            return this.contentLink;
        }

        public final InterfaceC10156bA3 getContentLinkAction() {
            InterfaceC10156bA3 interfaceC10156bA3 = this.contentLinkAction;
            if (interfaceC10156bA3 != null) {
                return interfaceC10156bA3;
            }
            AbstractC13042fc3.y("contentLinkAction");
            return null;
        }

        public final long getEventBarId() {
            return this.eventBarId;
        }

        public final a getEventBarType() {
            return this.eventBarType;
        }

        public final long getExpireTimeInMills() {
            return this.expireTimeInMills;
        }

        public final boolean getHasTimer() {
            return this.hasTimer;
        }

        public final String getTitleText() {
            return this.titleText;
        }

        public int hashCode() {
            return (((((((((((((this.eventBarType.hashCode() * 31) + Long.hashCode(this.eventBarId)) * 31) + this.titleText.hashCode()) * 31) + this.buttonText.hashCode()) * 31) + this.contentLink.hashCode()) * 31) + Integer.hashCode(this.colorsSetNumber)) * 31) + Long.hashCode(this.expireTimeInMills)) * 31) + Boolean.hashCode(this.hasTimer);
        }

        public final void setContentLinkAction(InterfaceC10156bA3 interfaceC10156bA3) {
            AbstractC13042fc3.i(interfaceC10156bA3, "<set-?>");
            this.contentLinkAction = interfaceC10156bA3;
        }

        public String toString() {
            return "Enabled(eventBarType=" + this.eventBarType + ", eventBarId=" + this.eventBarId + ", titleText=" + this.titleText + ", buttonText=" + this.buttonText + ", contentLink=" + this.contentLink + ", colorsSetNumber=" + this.colorsSetNumber + ", expireTimeInMills=" + this.expireTimeInMills + ", hasTimer=" + this.hasTimer + Separators.RPAREN;
        }
    }

    @Keep
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0003¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H×\u0003J\t\u0010\b\u001a\u00020\tH×\u0001J\t\u0010\n\u001a\u00020\u000bH×\u0001¨\u0006\f"}, d2 = {"Lir/nasim/features/eventbar/data/model/EventBarData$Idle;", "Lir/nasim/features/eventbar/data/model/EventBarData;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "nasim_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final /* data */ class Idle extends EventBarData {
        public static final int $stable = 0;
        public static final Idle INSTANCE = new Idle();

        private Idle() {
            super(null);
        }

        public boolean equals(Object other) {
            return this == other || (other instanceof Idle);
        }

        public int hashCode() {
            return 1138077929;
        }

        public String toString() {
            return "Idle";
        }
    }

    private EventBarData() {
    }

    public /* synthetic */ EventBarData(ED1 ed1) {
        this();
    }
}
