package ir.nasim.features.bank.mybank.model;

import android.gov.nist.core.Separators;
import android.gov.nist.javax.sip.header.ParameterNames;
import androidx.annotation.Keep;
import ir.nasim.AbstractC13042fc3;
import ir.nasim.InterfaceC23984xq6;
import java.util.List;
import kotlin.Metadata;

@Keep
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0087\b\u0018\u00002\u00020\u0001:\u0002\u0016\u0017B#\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u000f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003HÆ\u0003J)\u0010\u000e\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003HÇ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001H×\u0003J\t\u0010\u0012\u001a\u00020\u0013H×\u0001J\t\u0010\u0014\u001a\u00020\u0015H×\u0001R\u001c\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u001c\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\n¨\u0006\u0018"}, d2 = {"Lir/nasim/features/bank/mybank/model/ServicesData;", "", "sections", "", "Lir/nasim/features/bank/mybank/model/ServicesData$ServiceSection;", ServicesPageSectionEntity.SHORTCUTS_SECTION_TITLE, "Lir/nasim/features/bank/mybank/model/ServicesData$ServiceShortcut;", "<init>", "(Ljava/util/List;Ljava/util/List;)V", "getSections", "()Ljava/util/List;", "getShortcuts", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "ServiceSection", "ServiceShortcut", "nasim_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class ServicesData {
    public static final int $stable = 8;

    @InterfaceC23984xq6("sections")
    private final List<ServiceSection> sections;

    @InterfaceC23984xq6(ServicesPageSectionEntity.SHORTCUTS_SECTION_TITLE)
    private final List<ServiceShortcut> shortcuts;

    @Keep
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0087\b\u0018\u00002\u00020\u0001:\u0001 B7\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b\u0012\u0006\u0010\n\u001a\u00020\u0003¢\u0006\u0004\b\u000b\u0010\fJ\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0005HÆ\u0003J\u000f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\t0\bHÆ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003JC\u0010\u001a\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b2\b\b\u0002\u0010\n\u001a\u00020\u0003HÇ\u0001J\u0013\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0001H×\u0003J\t\u0010\u001e\u001a\u00020\u0005H×\u0001J\t\u0010\u001f\u001a\u00020\u0003H×\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0006\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R\u001c\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0016\u0010\n\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u000e¨\u0006!"}, d2 = {"Lir/nasim/features/bank/mybank/model/ServicesData$ServiceSection;", "", "badge", "", "badgeType", "", "id", "serviceItems", "", "Lir/nasim/features/bank/mybank/model/ServicesData$ServiceSection$ServiceItem;", "title", "<init>", "(Ljava/lang/String;IILjava/util/List;Ljava/lang/String;)V", "getBadge", "()Ljava/lang/String;", "getBadgeType", "()I", "getId", "getServiceItems", "()Ljava/util/List;", "getTitle", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "toString", "ServiceItem", "nasim_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final /* data */ class ServiceSection {
        public static final int $stable = 8;

        @InterfaceC23984xq6("badge")
        private final String badge;

        @InterfaceC23984xq6("badgeType")
        private final int badgeType;

        @InterfaceC23984xq6("id")
        private final int id;

        @InterfaceC23984xq6("items")
        private final List<ServiceItem> serviceItems;

        @InterfaceC23984xq6("title")
        private final String title;

        @Keep
        @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u001a\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0087\b\u0018\u00002\u00020\u0001:\u0001+BY\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\b\u001a\u00020\u0005\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\u0006\u0010\r\u001a\u00020\u0005¢\u0006\u0004\b\u000e\u0010\u000fJ\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010 \u001a\u00020\u0005HÆ\u0003J\u000b\u0010!\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010\"\u001a\u00020\u0003HÆ\u0003J\u000b\u0010#\u001a\u0004\u0018\u00010\fHÆ\u0003J\t\u0010$\u001a\u00020\u0005HÆ\u0003Jm\u0010%\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\b\u001a\u00020\u00052\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\n\u001a\u00020\u00032\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\b\u0002\u0010\r\u001a\u00020\u0005HÇ\u0001J\u0013\u0010&\u001a\u00020'2\b\u0010(\u001a\u0004\u0018\u00010\u0001H×\u0003J\t\u0010)\u001a\u00020\u0003H×\u0001J\t\u0010*\u001a\u00020\u0005H×\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0013R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0013R\u0016\u0010\b\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0013R\u0018\u0010\t\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0013R\u0016\u0010\n\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0011R\u0018\u0010\u000b\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0016\u0010\r\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0013¨\u0006,"}, d2 = {"Lir/nasim/features/bank/mybank/model/ServicesData$ServiceSection$ServiceItem;", "", "action", "", "badge", "", "eventKey", "eventName", ParameterNames.ICON, "customIcon", "id", "payload", "Lir/nasim/features/bank/mybank/model/ServicesData$ServiceSection$ServiceItem$Payload;", "title", "<init>", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILir/nasim/features/bank/mybank/model/ServicesData$ServiceSection$ServiceItem$Payload;Ljava/lang/String;)V", "getAction", "()I", "getBadge", "()Ljava/lang/String;", "getEventKey", "getEventName", "getIcon", "getCustomIcon", "getId", "getPayload", "()Lir/nasim/features/bank/mybank/model/ServicesData$ServiceSection$ServiceItem$Payload;", "getTitle", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "", "other", "hashCode", "toString", "Payload", "nasim_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
        public static final /* data */ class ServiceItem {
            public static final int $stable = 0;

            @InterfaceC23984xq6("action")
            private final int action;

            @InterfaceC23984xq6("badge")
            private final String badge;

            @InterfaceC23984xq6("customIcon")
            private final String customIcon;

            @InterfaceC23984xq6("eventKey")
            private final String eventKey;

            @InterfaceC23984xq6("eventName")
            private final String eventName;

            @InterfaceC23984xq6(ParameterNames.ICON)
            private final String icon;

            @InterfaceC23984xq6("id")
            private final int id;

            @InterfaceC23984xq6("payload")
            private final Payload payload;

            @InterfaceC23984xq6("title")
            private final String title;

            @Keep
            @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\b\u0087\b\u0018\u00002\u00020\u0001:\u0001\u001aB\u001b\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0012\u0010\b\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\b\u0010\tJ\u0012\u0010\n\u001a\u0004\u0018\u00010\u0004HÆ\u0003¢\u0006\u0004\b\n\u0010\u000bJ(\u0010\f\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004HÇ\u0001¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000e\u001a\u00020\u0004H×\u0001¢\u0006\u0004\b\u000e\u0010\u000bJ\u0010\u0010\u0010\u001a\u00020\u000fH×\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u001a\u0010\u0014\u001a\u00020\u00132\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001H×\u0003¢\u0006\u0004\b\u0014\u0010\u0015R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0016\u001a\u0004\b\u0017\u0010\tR\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0005\u0010\u0018\u001a\u0004\b\u0019\u0010\u000b¨\u0006\u001b"}, d2 = {"Lir/nasim/features/bank/mybank/model/ServicesData$ServiceSection$ServiceItem$Payload;", "", "Lir/nasim/features/bank/mybank/model/ServicesData$ServiceSection$ServiceItem$Payload$a;", "peer", "", "url", "<init>", "(Lir/nasim/features/bank/mybank/model/ServicesData$ServiceSection$ServiceItem$Payload$a;Ljava/lang/String;)V", "component1", "()Lir/nasim/features/bank/mybank/model/ServicesData$ServiceSection$ServiceItem$Payload$a;", "component2", "()Ljava/lang/String;", "copy", "(Lir/nasim/features/bank/mybank/model/ServicesData$ServiceSection$ServiceItem$Payload$a;Ljava/lang/String;)Lir/nasim/features/bank/mybank/model/ServicesData$ServiceSection$ServiceItem$Payload;", "toString", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Lir/nasim/features/bank/mybank/model/ServicesData$ServiceSection$ServiceItem$Payload$a;", "getPeer", "Ljava/lang/String;", "getUrl", "a", "nasim_release"}, k = 1, mv = {2, 0, 0})
            public static final /* data */ class Payload {
                public static final int $stable = 0;

                @InterfaceC23984xq6("peer")
                private final a peer;

                @InterfaceC23984xq6("url")
                private final String url;

                public static final class a {
                }

                public Payload(a aVar, String str) {
                    this.url = str;
                }

                public static /* synthetic */ Payload copy$default(Payload payload, a aVar, String str, int i, Object obj) {
                    if ((i & 1) != 0) {
                        payload.getClass();
                        aVar = null;
                    }
                    if ((i & 2) != 0) {
                        str = payload.url;
                    }
                    return payload.copy(aVar, str);
                }

                public final a component1() {
                    return null;
                }

                /* renamed from: component2, reason: from getter */
                public final String getUrl() {
                    return this.url;
                }

                public final Payload copy(a peer, String url) {
                    return new Payload(peer, url);
                }

                public boolean equals(Object other) {
                    if (this == other) {
                        return true;
                    }
                    if (!(other instanceof Payload)) {
                        return false;
                    }
                    Payload payload = (Payload) other;
                    payload.getClass();
                    return AbstractC13042fc3.d(null, null) && AbstractC13042fc3.d(this.url, payload.url);
                }

                public final a getPeer() {
                    return null;
                }

                public final String getUrl() {
                    return this.url;
                }

                public int hashCode() {
                    String str = this.url;
                    if (str == null) {
                        return 0;
                    }
                    return str.hashCode();
                }

                public String toString() {
                    return "Payload(peer=" + ((Object) null) + ", url=" + this.url + Separators.RPAREN;
                }
            }

            public ServiceItem(int i, String str, String str2, String str3, String str4, String str5, int i2, Payload payload, String str6) {
                AbstractC13042fc3.i(str4, ParameterNames.ICON);
                AbstractC13042fc3.i(str6, "title");
                this.action = i;
                this.badge = str;
                this.eventKey = str2;
                this.eventName = str3;
                this.icon = str4;
                this.customIcon = str5;
                this.id = i2;
                this.payload = payload;
                this.title = str6;
            }

            /* renamed from: component1, reason: from getter */
            public final int getAction() {
                return this.action;
            }

            /* renamed from: component2, reason: from getter */
            public final String getBadge() {
                return this.badge;
            }

            /* renamed from: component3, reason: from getter */
            public final String getEventKey() {
                return this.eventKey;
            }

            /* renamed from: component4, reason: from getter */
            public final String getEventName() {
                return this.eventName;
            }

            /* renamed from: component5, reason: from getter */
            public final String getIcon() {
                return this.icon;
            }

            /* renamed from: component6, reason: from getter */
            public final String getCustomIcon() {
                return this.customIcon;
            }

            /* renamed from: component7, reason: from getter */
            public final int getId() {
                return this.id;
            }

            /* renamed from: component8, reason: from getter */
            public final Payload getPayload() {
                return this.payload;
            }

            /* renamed from: component9, reason: from getter */
            public final String getTitle() {
                return this.title;
            }

            public final ServiceItem copy(int action, String badge, String eventKey, String eventName, String icon, String customIcon, int id, Payload payload, String title) {
                AbstractC13042fc3.i(icon, ParameterNames.ICON);
                AbstractC13042fc3.i(title, "title");
                return new ServiceItem(action, badge, eventKey, eventName, icon, customIcon, id, payload, title);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof ServiceItem)) {
                    return false;
                }
                ServiceItem serviceItem = (ServiceItem) other;
                return this.action == serviceItem.action && AbstractC13042fc3.d(this.badge, serviceItem.badge) && AbstractC13042fc3.d(this.eventKey, serviceItem.eventKey) && AbstractC13042fc3.d(this.eventName, serviceItem.eventName) && AbstractC13042fc3.d(this.icon, serviceItem.icon) && AbstractC13042fc3.d(this.customIcon, serviceItem.customIcon) && this.id == serviceItem.id && AbstractC13042fc3.d(this.payload, serviceItem.payload) && AbstractC13042fc3.d(this.title, serviceItem.title);
            }

            public final int getAction() {
                return this.action;
            }

            public final String getBadge() {
                return this.badge;
            }

            public final String getCustomIcon() {
                return this.customIcon;
            }

            public final String getEventKey() {
                return this.eventKey;
            }

            public final String getEventName() {
                return this.eventName;
            }

            public final String getIcon() {
                return this.icon;
            }

            public final int getId() {
                return this.id;
            }

            public final Payload getPayload() {
                return this.payload;
            }

            public final String getTitle() {
                return this.title;
            }

            public int hashCode() {
                int iHashCode = Integer.hashCode(this.action) * 31;
                String str = this.badge;
                int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
                String str2 = this.eventKey;
                int iHashCode3 = (iHashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
                String str3 = this.eventName;
                int iHashCode4 = (((iHashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31) + this.icon.hashCode()) * 31;
                String str4 = this.customIcon;
                int iHashCode5 = (((iHashCode4 + (str4 == null ? 0 : str4.hashCode())) * 31) + Integer.hashCode(this.id)) * 31;
                Payload payload = this.payload;
                return ((iHashCode5 + (payload != null ? payload.hashCode() : 0)) * 31) + this.title.hashCode();
            }

            public String toString() {
                return "ServiceItem(action=" + this.action + ", badge=" + this.badge + ", eventKey=" + this.eventKey + ", eventName=" + this.eventName + ", icon=" + this.icon + ", customIcon=" + this.customIcon + ", id=" + this.id + ", payload=" + this.payload + ", title=" + this.title + Separators.RPAREN;
            }
        }

        public ServiceSection(String str, int i, int i2, List<ServiceItem> list, String str2) {
            AbstractC13042fc3.i(list, "serviceItems");
            AbstractC13042fc3.i(str2, "title");
            this.badge = str;
            this.badgeType = i;
            this.id = i2;
            this.serviceItems = list;
            this.title = str2;
        }

        public static /* synthetic */ ServiceSection copy$default(ServiceSection serviceSection, String str, int i, int i2, List list, String str2, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                str = serviceSection.badge;
            }
            if ((i3 & 2) != 0) {
                i = serviceSection.badgeType;
            }
            int i4 = i;
            if ((i3 & 4) != 0) {
                i2 = serviceSection.id;
            }
            int i5 = i2;
            if ((i3 & 8) != 0) {
                list = serviceSection.serviceItems;
            }
            List list2 = list;
            if ((i3 & 16) != 0) {
                str2 = serviceSection.title;
            }
            return serviceSection.copy(str, i4, i5, list2, str2);
        }

        /* renamed from: component1, reason: from getter */
        public final String getBadge() {
            return this.badge;
        }

        /* renamed from: component2, reason: from getter */
        public final int getBadgeType() {
            return this.badgeType;
        }

        /* renamed from: component3, reason: from getter */
        public final int getId() {
            return this.id;
        }

        public final List<ServiceItem> component4() {
            return this.serviceItems;
        }

        /* renamed from: component5, reason: from getter */
        public final String getTitle() {
            return this.title;
        }

        public final ServiceSection copy(String badge, int badgeType, int id, List<ServiceItem> serviceItems, String title) {
            AbstractC13042fc3.i(serviceItems, "serviceItems");
            AbstractC13042fc3.i(title, "title");
            return new ServiceSection(badge, badgeType, id, serviceItems, title);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ServiceSection)) {
                return false;
            }
            ServiceSection serviceSection = (ServiceSection) other;
            return AbstractC13042fc3.d(this.badge, serviceSection.badge) && this.badgeType == serviceSection.badgeType && this.id == serviceSection.id && AbstractC13042fc3.d(this.serviceItems, serviceSection.serviceItems) && AbstractC13042fc3.d(this.title, serviceSection.title);
        }

        public final String getBadge() {
            return this.badge;
        }

        public final int getBadgeType() {
            return this.badgeType;
        }

        public final int getId() {
            return this.id;
        }

        public final List<ServiceItem> getServiceItems() {
            return this.serviceItems;
        }

        public final String getTitle() {
            return this.title;
        }

        public int hashCode() {
            String str = this.badge;
            return ((((((((str == null ? 0 : str.hashCode()) * 31) + Integer.hashCode(this.badgeType)) * 31) + Integer.hashCode(this.id)) * 31) + this.serviceItems.hashCode()) * 31) + this.title.hashCode();
        }

        public String toString() {
            return "ServiceSection(badge=" + this.badge + ", badgeType=" + this.badgeType + ", id=" + this.id + ", serviceItems=" + this.serviceItems + ", title=" + this.title + Separators.RPAREN;
        }
    }

    @Keep
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0003¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J1\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u0003HÇ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001H×\u0003J\t\u0010\u0018\u001a\u00020\u0006H×\u0001J\t\u0010\u0019\u001a\u00020\u0003H×\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0016\u0010\u0005\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0016\u0010\u0007\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000b¨\u0006\u001a"}, d2 = {"Lir/nasim/features/bank/mybank/model/ServicesData$ServiceShortcut;", "", "bgColor", "", ParameterNames.ICON, "sectionId", "", "title", "<init>", "(Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;)V", "getBgColor", "()Ljava/lang/String;", "getIcon", "getSectionId", "()I", "getTitle", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "toString", "nasim_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final /* data */ class ServiceShortcut {
        public static final int $stable = 0;

        @InterfaceC23984xq6("bgColor")
        private final String bgColor;

        @InterfaceC23984xq6(ParameterNames.ICON)
        private final String icon;

        @InterfaceC23984xq6("sectionId")
        private final int sectionId;

        @InterfaceC23984xq6("title")
        private final String title;

        public ServiceShortcut(String str, String str2, int i, String str3) {
            AbstractC13042fc3.i(str, "bgColor");
            AbstractC13042fc3.i(str2, ParameterNames.ICON);
            AbstractC13042fc3.i(str3, "title");
            this.bgColor = str;
            this.icon = str2;
            this.sectionId = i;
            this.title = str3;
        }

        public static /* synthetic */ ServiceShortcut copy$default(ServiceShortcut serviceShortcut, String str, String str2, int i, String str3, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                str = serviceShortcut.bgColor;
            }
            if ((i2 & 2) != 0) {
                str2 = serviceShortcut.icon;
            }
            if ((i2 & 4) != 0) {
                i = serviceShortcut.sectionId;
            }
            if ((i2 & 8) != 0) {
                str3 = serviceShortcut.title;
            }
            return serviceShortcut.copy(str, str2, i, str3);
        }

        /* renamed from: component1, reason: from getter */
        public final String getBgColor() {
            return this.bgColor;
        }

        /* renamed from: component2, reason: from getter */
        public final String getIcon() {
            return this.icon;
        }

        /* renamed from: component3, reason: from getter */
        public final int getSectionId() {
            return this.sectionId;
        }

        /* renamed from: component4, reason: from getter */
        public final String getTitle() {
            return this.title;
        }

        public final ServiceShortcut copy(String bgColor, String icon, int sectionId, String title) {
            AbstractC13042fc3.i(bgColor, "bgColor");
            AbstractC13042fc3.i(icon, ParameterNames.ICON);
            AbstractC13042fc3.i(title, "title");
            return new ServiceShortcut(bgColor, icon, sectionId, title);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ServiceShortcut)) {
                return false;
            }
            ServiceShortcut serviceShortcut = (ServiceShortcut) other;
            return AbstractC13042fc3.d(this.bgColor, serviceShortcut.bgColor) && AbstractC13042fc3.d(this.icon, serviceShortcut.icon) && this.sectionId == serviceShortcut.sectionId && AbstractC13042fc3.d(this.title, serviceShortcut.title);
        }

        public final String getBgColor() {
            return this.bgColor;
        }

        public final String getIcon() {
            return this.icon;
        }

        public final int getSectionId() {
            return this.sectionId;
        }

        public final String getTitle() {
            return this.title;
        }

        public int hashCode() {
            return (((((this.bgColor.hashCode() * 31) + this.icon.hashCode()) * 31) + Integer.hashCode(this.sectionId)) * 31) + this.title.hashCode();
        }

        public String toString() {
            return "ServiceShortcut(bgColor=" + this.bgColor + ", icon=" + this.icon + ", sectionId=" + this.sectionId + ", title=" + this.title + Separators.RPAREN;
        }
    }

    public ServicesData(List<ServiceSection> list, List<ServiceShortcut> list2) {
        AbstractC13042fc3.i(list, "sections");
        AbstractC13042fc3.i(list2, ServicesPageSectionEntity.SHORTCUTS_SECTION_TITLE);
        this.sections = list;
        this.shortcuts = list2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ServicesData copy$default(ServicesData servicesData, List list, List list2, int i, Object obj) {
        if ((i & 1) != 0) {
            list = servicesData.sections;
        }
        if ((i & 2) != 0) {
            list2 = servicesData.shortcuts;
        }
        return servicesData.copy(list, list2);
    }

    public final List<ServiceSection> component1() {
        return this.sections;
    }

    public final List<ServiceShortcut> component2() {
        return this.shortcuts;
    }

    public final ServicesData copy(List<ServiceSection> sections, List<ServiceShortcut> shortcuts) {
        AbstractC13042fc3.i(sections, "sections");
        AbstractC13042fc3.i(shortcuts, ServicesPageSectionEntity.SHORTCUTS_SECTION_TITLE);
        return new ServicesData(sections, shortcuts);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ServicesData)) {
            return false;
        }
        ServicesData servicesData = (ServicesData) other;
        return AbstractC13042fc3.d(this.sections, servicesData.sections) && AbstractC13042fc3.d(this.shortcuts, servicesData.shortcuts);
    }

    public final List<ServiceSection> getSections() {
        return this.sections;
    }

    public final List<ServiceShortcut> getShortcuts() {
        return this.shortcuts;
    }

    public int hashCode() {
        return (this.sections.hashCode() * 31) + this.shortcuts.hashCode();
    }

    public String toString() {
        return "ServicesData(sections=" + this.sections + ", shortcuts=" + this.shortcuts + Separators.RPAREN;
    }
}
