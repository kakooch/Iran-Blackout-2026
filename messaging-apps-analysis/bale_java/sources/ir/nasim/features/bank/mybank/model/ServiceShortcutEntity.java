package ir.nasim.features.bank.mybank.model;

import ai.bale.proto.GarsonStruct$GarsonShortcut;
import android.gov.nist.core.Separators;
import android.gov.nist.javax.sip.header.ParameterNames;
import android.gov.nist.javax.sip.parser.TokenNames;
import androidx.annotation.Keep;
import com.google.android.gms.common.annotation.KeepName;
import ir.nasim.AbstractC13042fc3;
import ir.nasim.ED1;
import kotlin.Metadata;

@Keep
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0016\n\u0002\u0010\u000b\n\u0002\b\u000e\b\u0087\b\u0018\u0000 '2\u00020\u0001:\u0001(B?\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0004\u0012\u0006\u0010\b\u001a\u00020\u0004\u0012\u0006\u0010\t\u001a\u00020\u0002\u0012\u0006\u0010\n\u001a\u00020\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\r\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u000f\u001a\u00020\u0004HÆ\u0003¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0011\u001a\u00020\u0004HÆ\u0003¢\u0006\u0004\b\u0011\u0010\u0010J\u0010\u0010\u0012\u001a\u00020\u0004HÆ\u0003¢\u0006\u0004\b\u0012\u0010\u0010J\u0010\u0010\u0013\u001a\u00020\u0004HÆ\u0003¢\u0006\u0004\b\u0013\u0010\u0010J\u0010\u0010\u0014\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0014\u0010\u000eJ\u0010\u0010\u0015\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0015\u0010\u000eJV\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u00042\b\b\u0002\u0010\b\u001a\u00020\u00042\b\b\u0002\u0010\t\u001a\u00020\u00022\b\b\u0002\u0010\n\u001a\u00020\u0002HÇ\u0001¢\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0018\u001a\u00020\u0004H×\u0001¢\u0006\u0004\b\u0018\u0010\u0010J\u0010\u0010\u0019\u001a\u00020\u0002H×\u0001¢\u0006\u0004\b\u0019\u0010\u000eJ\u001a\u0010\u001c\u001a\u00020\u001b2\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001H×\u0003¢\u0006\u0004\b\u001c\u0010\u001dR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u001e\u001a\u0004\b\u001f\u0010\u000eR\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010 \u001a\u0004\b!\u0010\u0010R\u0017\u0010\u0006\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0006\u0010 \u001a\u0004\b\"\u0010\u0010R\u0017\u0010\u0007\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0007\u0010 \u001a\u0004\b#\u0010\u0010R\u0017\u0010\b\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\b\u0010 \u001a\u0004\b$\u0010\u0010R\u0017\u0010\t\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\t\u0010\u001e\u001a\u0004\b%\u0010\u000eR\u0017\u0010\n\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\n\u0010\u001e\u001a\u0004\b&\u0010\u000e¨\u0006)"}, d2 = {"Lir/nasim/features/bank/mybank/model/ServiceShortcutEntity;", "", "", "id", "", "title", ParameterNames.ICON, "bgColorLight", "bgColorDark", "navType", "navCategoryID", "<init>", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;II)V", "component1", "()I", "component2", "()Ljava/lang/String;", "component3", "component4", "component5", "component6", "component7", "copy", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;II)Lir/nasim/features/bank/mybank/model/ServiceShortcutEntity;", "toString", "hashCode", "other", "", "equals", "(Ljava/lang/Object;)Z", TokenNames.I, "getId", "Ljava/lang/String;", "getTitle", "getIcon", "getBgColorLight", "getBgColorDark", "getNavType", "getNavCategoryID", "Companion", "a", "nasim_release"}, k = 1, mv = {2, 0, 0})
@KeepName
/* loaded from: classes5.dex */
public final /* data */ class ServiceShortcutEntity {
    public static final int $stable = 0;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final String bgColorDark;
    private final String bgColorLight;
    private final String icon;
    private final int id;
    private final int navCategoryID;
    private final int navType;
    private final String title;

    /* renamed from: ir.nasim.features.bank.mybank.model.ServiceShortcutEntity$a, reason: from kotlin metadata */
    public static final class Companion {
        private Companion() {
        }

        public final ServiceShortcutEntity a(GarsonStruct$GarsonShortcut garsonStruct$GarsonShortcut) {
            AbstractC13042fc3.i(garsonStruct$GarsonShortcut, "shortcut");
            int shortcutId = garsonStruct$GarsonShortcut.getShortcutId();
            String title = garsonStruct$GarsonShortcut.getTitle();
            AbstractC13042fc3.h(title, "getTitle(...)");
            String icon = garsonStruct$GarsonShortcut.getIcon();
            AbstractC13042fc3.h(icon, "getIcon(...)");
            String bgColor = garsonStruct$GarsonShortcut.getBgColor();
            AbstractC13042fc3.h(bgColor, "getBgColor(...)");
            String darkBgColor = garsonStruct$GarsonShortcut.getDarkBgColor();
            AbstractC13042fc3.h(darkBgColor, "getDarkBgColor(...)");
            return new ServiceShortcutEntity(shortcutId, title, icon, bgColor, darkBgColor, garsonStruct$GarsonShortcut.getNavigation().getType().getNumber(), garsonStruct$GarsonShortcut.getNavigation().getServiceCategoryId());
        }

        public /* synthetic */ Companion(ED1 ed1) {
            this();
        }
    }

    public ServiceShortcutEntity(int i, String str, String str2, String str3, String str4, int i2, int i3) {
        AbstractC13042fc3.i(str, "title");
        AbstractC13042fc3.i(str2, ParameterNames.ICON);
        AbstractC13042fc3.i(str3, "bgColorLight");
        AbstractC13042fc3.i(str4, "bgColorDark");
        this.id = i;
        this.title = str;
        this.icon = str2;
        this.bgColorLight = str3;
        this.bgColorDark = str4;
        this.navType = i2;
        this.navCategoryID = i3;
    }

    public static /* synthetic */ ServiceShortcutEntity copy$default(ServiceShortcutEntity serviceShortcutEntity, int i, String str, String str2, String str3, String str4, int i2, int i3, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            i = serviceShortcutEntity.id;
        }
        if ((i4 & 2) != 0) {
            str = serviceShortcutEntity.title;
        }
        String str5 = str;
        if ((i4 & 4) != 0) {
            str2 = serviceShortcutEntity.icon;
        }
        String str6 = str2;
        if ((i4 & 8) != 0) {
            str3 = serviceShortcutEntity.bgColorLight;
        }
        String str7 = str3;
        if ((i4 & 16) != 0) {
            str4 = serviceShortcutEntity.bgColorDark;
        }
        String str8 = str4;
        if ((i4 & 32) != 0) {
            i2 = serviceShortcutEntity.navType;
        }
        int i5 = i2;
        if ((i4 & 64) != 0) {
            i3 = serviceShortcutEntity.navCategoryID;
        }
        return serviceShortcutEntity.copy(i, str5, str6, str7, str8, i5, i3);
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
    public final String getBgColorLight() {
        return this.bgColorLight;
    }

    /* renamed from: component5, reason: from getter */
    public final String getBgColorDark() {
        return this.bgColorDark;
    }

    /* renamed from: component6, reason: from getter */
    public final int getNavType() {
        return this.navType;
    }

    /* renamed from: component7, reason: from getter */
    public final int getNavCategoryID() {
        return this.navCategoryID;
    }

    public final ServiceShortcutEntity copy(int id, String title, String icon, String bgColorLight, String bgColorDark, int navType, int navCategoryID) {
        AbstractC13042fc3.i(title, "title");
        AbstractC13042fc3.i(icon, ParameterNames.ICON);
        AbstractC13042fc3.i(bgColorLight, "bgColorLight");
        AbstractC13042fc3.i(bgColorDark, "bgColorDark");
        return new ServiceShortcutEntity(id, title, icon, bgColorLight, bgColorDark, navType, navCategoryID);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ServiceShortcutEntity)) {
            return false;
        }
        ServiceShortcutEntity serviceShortcutEntity = (ServiceShortcutEntity) other;
        return this.id == serviceShortcutEntity.id && AbstractC13042fc3.d(this.title, serviceShortcutEntity.title) && AbstractC13042fc3.d(this.icon, serviceShortcutEntity.icon) && AbstractC13042fc3.d(this.bgColorLight, serviceShortcutEntity.bgColorLight) && AbstractC13042fc3.d(this.bgColorDark, serviceShortcutEntity.bgColorDark) && this.navType == serviceShortcutEntity.navType && this.navCategoryID == serviceShortcutEntity.navCategoryID;
    }

    public final String getBgColorDark() {
        return this.bgColorDark;
    }

    public final String getBgColorLight() {
        return this.bgColorLight;
    }

    public final String getIcon() {
        return this.icon;
    }

    public final int getId() {
        return this.id;
    }

    public final int getNavCategoryID() {
        return this.navCategoryID;
    }

    public final int getNavType() {
        return this.navType;
    }

    public final String getTitle() {
        return this.title;
    }

    public int hashCode() {
        return (((((((((((Integer.hashCode(this.id) * 31) + this.title.hashCode()) * 31) + this.icon.hashCode()) * 31) + this.bgColorLight.hashCode()) * 31) + this.bgColorDark.hashCode()) * 31) + Integer.hashCode(this.navType)) * 31) + Integer.hashCode(this.navCategoryID);
    }

    public String toString() {
        return "ServiceShortcutEntity(id=" + this.id + ", title=" + this.title + ", icon=" + this.icon + ", bgColorLight=" + this.bgColorLight + ", bgColorDark=" + this.bgColorDark + ", navType=" + this.navType + ", navCategoryID=" + this.navCategoryID + Separators.RPAREN;
    }
}
