package ir.nasim.features.bank.mybank.model;

import ai.bale.proto.GarsonStruct$GarsonBanner;
import android.gov.nist.core.Separators;
import android.gov.nist.javax.sip.parser.TokenNames;
import androidx.annotation.Keep;
import com.google.android.gms.common.annotation.KeepName;
import ir.nasim.AbstractC13042fc3;
import ir.nasim.ED1;
import kotlin.Metadata;

@Keep
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0014\n\u0002\u0010\u000b\n\u0002\b\r\b\u0087\b\u0018\u0000 $2\u00020\u0001:\u0001%B7\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\u0006\u0010\b\u001a\u00020\u0002\u0012\u0006\u0010\t\u001a\u00020\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\f\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000e\u001a\u00020\u0004HÆ\u0003¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0010\u001a\u00020\u0004HÆ\u0003¢\u0006\u0004\b\u0010\u0010\u000fJ\u0010\u0010\u0011\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0011\u0010\rJ\u0010\u0010\u0012\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0012\u0010\rJ\u0010\u0010\u0013\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0013\u0010\rJL\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u00022\b\b\u0002\u0010\b\u001a\u00020\u00022\b\b\u0002\u0010\t\u001a\u00020\u0002HÇ\u0001¢\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0016\u001a\u00020\u0004H×\u0001¢\u0006\u0004\b\u0016\u0010\u000fJ\u0010\u0010\u0017\u001a\u00020\u0002H×\u0001¢\u0006\u0004\b\u0017\u0010\rJ\u001a\u0010\u001a\u001a\u00020\u00192\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001H×\u0003¢\u0006\u0004\b\u001a\u0010\u001bR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u001c\u001a\u0004\b\u001d\u0010\rR\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u001e\u001a\u0004\b\u001f\u0010\u000fR\u0017\u0010\u0006\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u001e\u001a\u0004\b \u0010\u000fR\u0017\u0010\u0007\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u001c\u001a\u0004\b!\u0010\rR\u0017\u0010\b\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\b\u0010\u001c\u001a\u0004\b\"\u0010\rR\u0017\u0010\t\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\t\u0010\u001c\u001a\u0004\b#\u0010\r¨\u0006&"}, d2 = {"Lir/nasim/features/bank/mybank/model/ServiceBannerEntity;", "", "", "id", "", "bannerUrl", "payloadUrl", "payloadPeerId", "payloadPeerType", "actionType", "<init>", "(ILjava/lang/String;Ljava/lang/String;III)V", "component1", "()I", "component2", "()Ljava/lang/String;", "component3", "component4", "component5", "component6", "copy", "(ILjava/lang/String;Ljava/lang/String;III)Lir/nasim/features/bank/mybank/model/ServiceBannerEntity;", "toString", "hashCode", "other", "", "equals", "(Ljava/lang/Object;)Z", TokenNames.I, "getId", "Ljava/lang/String;", "getBannerUrl", "getPayloadUrl", "getPayloadPeerId", "getPayloadPeerType", "getActionType", "Companion", "a", "nasim_release"}, k = 1, mv = {2, 0, 0})
@KeepName
/* loaded from: classes5.dex */
public final /* data */ class ServiceBannerEntity {
    public static final int $stable = 0;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final int actionType;
    private final String bannerUrl;
    private final int id;
    private final int payloadPeerId;
    private final int payloadPeerType;
    private final String payloadUrl;

    /* renamed from: ir.nasim.features.bank.mybank.model.ServiceBannerEntity$a, reason: from kotlin metadata */
    public static final class Companion {
        private Companion() {
        }

        public final ServiceBannerEntity a(GarsonStruct$GarsonBanner garsonStruct$GarsonBanner) {
            AbstractC13042fc3.i(garsonStruct$GarsonBanner, "bannerDescriptor");
            int fileIdBanner = garsonStruct$GarsonBanner.getFileIdBanner();
            String url = garsonStruct$GarsonBanner.getUrl();
            AbstractC13042fc3.h(url, "getUrl(...)");
            String url2 = garsonStruct$GarsonBanner.getAction().getPayload().getUrl();
            AbstractC13042fc3.h(url2, "getUrl(...)");
            return new ServiceBannerEntity(fileIdBanner, url, url2, garsonStruct$GarsonBanner.getAction().getPayload().getPeer().getId(), garsonStruct$GarsonBanner.getAction().getPayload().getPeer().getType().getNumber(), garsonStruct$GarsonBanner.getAction().getType().getNumber());
        }

        public /* synthetic */ Companion(ED1 ed1) {
            this();
        }
    }

    public ServiceBannerEntity(int i, String str, String str2, int i2, int i3, int i4) {
        AbstractC13042fc3.i(str, "bannerUrl");
        AbstractC13042fc3.i(str2, "payloadUrl");
        this.id = i;
        this.bannerUrl = str;
        this.payloadUrl = str2;
        this.payloadPeerId = i2;
        this.payloadPeerType = i3;
        this.actionType = i4;
    }

    public static /* synthetic */ ServiceBannerEntity copy$default(ServiceBannerEntity serviceBannerEntity, int i, String str, String str2, int i2, int i3, int i4, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            i = serviceBannerEntity.id;
        }
        if ((i5 & 2) != 0) {
            str = serviceBannerEntity.bannerUrl;
        }
        String str3 = str;
        if ((i5 & 4) != 0) {
            str2 = serviceBannerEntity.payloadUrl;
        }
        String str4 = str2;
        if ((i5 & 8) != 0) {
            i2 = serviceBannerEntity.payloadPeerId;
        }
        int i6 = i2;
        if ((i5 & 16) != 0) {
            i3 = serviceBannerEntity.payloadPeerType;
        }
        int i7 = i3;
        if ((i5 & 32) != 0) {
            i4 = serviceBannerEntity.actionType;
        }
        return serviceBannerEntity.copy(i, str3, str4, i6, i7, i4);
    }

    /* renamed from: component1, reason: from getter */
    public final int getId() {
        return this.id;
    }

    /* renamed from: component2, reason: from getter */
    public final String getBannerUrl() {
        return this.bannerUrl;
    }

    /* renamed from: component3, reason: from getter */
    public final String getPayloadUrl() {
        return this.payloadUrl;
    }

    /* renamed from: component4, reason: from getter */
    public final int getPayloadPeerId() {
        return this.payloadPeerId;
    }

    /* renamed from: component5, reason: from getter */
    public final int getPayloadPeerType() {
        return this.payloadPeerType;
    }

    /* renamed from: component6, reason: from getter */
    public final int getActionType() {
        return this.actionType;
    }

    public final ServiceBannerEntity copy(int id, String bannerUrl, String payloadUrl, int payloadPeerId, int payloadPeerType, int actionType) {
        AbstractC13042fc3.i(bannerUrl, "bannerUrl");
        AbstractC13042fc3.i(payloadUrl, "payloadUrl");
        return new ServiceBannerEntity(id, bannerUrl, payloadUrl, payloadPeerId, payloadPeerType, actionType);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ServiceBannerEntity)) {
            return false;
        }
        ServiceBannerEntity serviceBannerEntity = (ServiceBannerEntity) other;
        return this.id == serviceBannerEntity.id && AbstractC13042fc3.d(this.bannerUrl, serviceBannerEntity.bannerUrl) && AbstractC13042fc3.d(this.payloadUrl, serviceBannerEntity.payloadUrl) && this.payloadPeerId == serviceBannerEntity.payloadPeerId && this.payloadPeerType == serviceBannerEntity.payloadPeerType && this.actionType == serviceBannerEntity.actionType;
    }

    public final int getActionType() {
        return this.actionType;
    }

    public final String getBannerUrl() {
        return this.bannerUrl;
    }

    public final int getId() {
        return this.id;
    }

    public final int getPayloadPeerId() {
        return this.payloadPeerId;
    }

    public final int getPayloadPeerType() {
        return this.payloadPeerType;
    }

    public final String getPayloadUrl() {
        return this.payloadUrl;
    }

    public int hashCode() {
        return (((((((((Integer.hashCode(this.id) * 31) + this.bannerUrl.hashCode()) * 31) + this.payloadUrl.hashCode()) * 31) + Integer.hashCode(this.payloadPeerId)) * 31) + Integer.hashCode(this.payloadPeerType)) * 31) + Integer.hashCode(this.actionType);
    }

    public String toString() {
        return "ServiceBannerEntity(id=" + this.id + ", bannerUrl=" + this.bannerUrl + ", payloadUrl=" + this.payloadUrl + ", payloadPeerId=" + this.payloadPeerId + ", payloadPeerType=" + this.payloadPeerType + ", actionType=" + this.actionType + Separators.RPAREN;
    }
}
