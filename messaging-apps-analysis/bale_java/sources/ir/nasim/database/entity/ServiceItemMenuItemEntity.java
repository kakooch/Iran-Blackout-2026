package ir.nasim.database.entity;

import android.gov.nist.core.Separators;
import android.gov.nist.javax.sip.header.ParameterNames;
import androidx.annotation.Keep;
import com.google.android.gms.common.annotation.KeepName;
import ir.nasim.AbstractC13042fc3;
import kotlin.Metadata;

@Keep
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001B1\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0005HÆ\u0003J=\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001b\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001c\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\fR\u0013\u0010\b\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000e¨\u0006\u001d"}, d2 = {"Lir/nasim/database/entity/ServiceItemMenuItemEntity;", "", "id", "", "title", "", ParameterNames.ICON, "action", "url", "<init>", "(ILjava/lang/String;Ljava/lang/String;ILjava/lang/String;)V", "getId", "()I", "getTitle", "()Ljava/lang/String;", "getIcon", "getAction", "getUrl", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "toString", "database_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
@KeepName
/* loaded from: classes5.dex */
public final /* data */ class ServiceItemMenuItemEntity {
    private final int action;
    private final String icon;
    private final int id;
    private final String title;
    private final String url;

    public ServiceItemMenuItemEntity(int i, String str, String str2, int i2, String str3) {
        AbstractC13042fc3.i(str, "title");
        AbstractC13042fc3.i(str2, ParameterNames.ICON);
        this.id = i;
        this.title = str;
        this.icon = str2;
        this.action = i2;
        this.url = str3;
    }

    public static /* synthetic */ ServiceItemMenuItemEntity copy$default(ServiceItemMenuItemEntity serviceItemMenuItemEntity, int i, String str, String str2, int i2, String str3, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = serviceItemMenuItemEntity.id;
        }
        if ((i3 & 2) != 0) {
            str = serviceItemMenuItemEntity.title;
        }
        String str4 = str;
        if ((i3 & 4) != 0) {
            str2 = serviceItemMenuItemEntity.icon;
        }
        String str5 = str2;
        if ((i3 & 8) != 0) {
            i2 = serviceItemMenuItemEntity.action;
        }
        int i4 = i2;
        if ((i3 & 16) != 0) {
            str3 = serviceItemMenuItemEntity.url;
        }
        return serviceItemMenuItemEntity.copy(i, str4, str5, i4, str3);
    }

    /* renamed from: component1, reason: from getter */
    public final int getId() {
        return this.id;
    }

    /* renamed from: component2, reason: from getter */
    public final String getTitle() {
        return this.title;
    }

    /* renamed from: component3, reason: from getter */
    public final String getIcon() {
        return this.icon;
    }

    /* renamed from: component4, reason: from getter */
    public final int getAction() {
        return this.action;
    }

    /* renamed from: component5, reason: from getter */
    public final String getUrl() {
        return this.url;
    }

    public final ServiceItemMenuItemEntity copy(int id, String title, String icon, int action, String url) {
        AbstractC13042fc3.i(title, "title");
        AbstractC13042fc3.i(icon, ParameterNames.ICON);
        return new ServiceItemMenuItemEntity(id, title, icon, action, url);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ServiceItemMenuItemEntity)) {
            return false;
        }
        ServiceItemMenuItemEntity serviceItemMenuItemEntity = (ServiceItemMenuItemEntity) other;
        return this.id == serviceItemMenuItemEntity.id && AbstractC13042fc3.d(this.title, serviceItemMenuItemEntity.title) && AbstractC13042fc3.d(this.icon, serviceItemMenuItemEntity.icon) && this.action == serviceItemMenuItemEntity.action && AbstractC13042fc3.d(this.url, serviceItemMenuItemEntity.url);
    }

    public final int getAction() {
        return this.action;
    }

    public final String getIcon() {
        return this.icon;
    }

    public final int getId() {
        return this.id;
    }

    public final String getTitle() {
        return this.title;
    }

    public final String getUrl() {
        return this.url;
    }

    public int hashCode() {
        int iHashCode = ((((((Integer.hashCode(this.id) * 31) + this.title.hashCode()) * 31) + this.icon.hashCode()) * 31) + Integer.hashCode(this.action)) * 31;
        String str = this.url;
        return iHashCode + (str == null ? 0 : str.hashCode());
    }

    public String toString() {
        return "ServiceItemMenuItemEntity(id=" + this.id + ", title=" + this.title + ", icon=" + this.icon + ", action=" + this.action + ", url=" + this.url + Separators.RPAREN;
    }
}
