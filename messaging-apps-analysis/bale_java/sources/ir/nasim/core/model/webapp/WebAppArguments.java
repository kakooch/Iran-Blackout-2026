package ir.nasim.core.model.webapp;

import android.gov.nist.core.Separators;
import android.gov.nist.javax.sip.parser.TokenNames;
import android.os.Parcel;
import android.os.Parcelable;
import ir.nasim.AbstractC13042fc3;
import ir.nasim.ED1;
import ir.nasim.EnumC23552x68;
import ir.nasim.H48;
import ir.nasim.core.model.webapp.minmize.WebAppKey;
import ir.nasim.core.modules.profile.entity.ExPeer;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u001a\b\u0087\b\u0018\u00002\u00020\u0001BS\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\u0002\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000b\u0012\b\b\u0002\u0010\u000e\u001a\u00020\r\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u000f¢\u0006\u0004\b\u0011\u0010\u0012J\r\u0010\u0014\u001a\u00020\u0013¢\u0006\u0004\b\u0014\u0010\u0015J\u001f\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u001a\u0010\u001bJ\u000f\u0010\u001c\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u001c\u0010\u001dJd\u0010\u001e\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\u00022\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000b2\b\b\u0002\u0010\u000e\u001a\u00020\r2\b\b\u0002\u0010\u0010\u001a\u00020\u000fHÇ\u0001¢\u0006\u0004\b\u001e\u0010\u001fJ\u0010\u0010!\u001a\u00020 H×\u0001¢\u0006\u0004\b!\u0010\"J\u0010\u0010#\u001a\u00020\u0002H×\u0001¢\u0006\u0004\b#\u0010\u001dJ\u001a\u0010&\u001a\u00020\u000f2\b\u0010%\u001a\u0004\u0018\u00010$H×\u0003¢\u0006\u0004\b&\u0010'R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u001e\u0010(\u001a\u0004\b)\u0010\u001dR\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b*\u0010+\u001a\u0004\b,\u0010-R\u0017\u0010\u0007\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b)\u0010.\u001a\u0004\b/\u00100R\u0017\u0010\b\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b1\u0010(\u001a\u0004\b2\u0010\u001dR\u0019\u0010\n\u001a\u0004\u0018\u00010\t8\u0006¢\u0006\f\n\u0004\b2\u00103\u001a\u0004\b1\u00104R\u0019\u0010\f\u001a\u0004\u0018\u00010\u000b8\u0006¢\u0006\f\n\u0004\b\u0014\u00105\u001a\u0004\b6\u00107R\u0017\u0010\u000e\u001a\u00020\r8\u0006¢\u0006\f\n\u0004\b/\u00108\u001a\u0004\b9\u0010:R\u0017\u0010\u0010\u001a\u00020\u000f8\u0006¢\u0006\f\n\u0004\b9\u0010;\u001a\u0004\b<\u0010=¨\u0006>"}, d2 = {"Lir/nasim/core/model/webapp/WebAppArguments;", "Landroid/os/Parcelable;", "", "botId", "Lir/nasim/core/model/webapp/WebAppType;", "webAppType", "Lir/nasim/H48;", "openType", "eventRandomId", "Lir/nasim/core/modules/profile/entity/ExPeer;", "chatExPeer", "Lir/nasim/core/model/webapp/WebAppRestoreState;", "webAppRestoreState", "Lir/nasim/x68;", "screenMode", "", "isRestore", "<init>", "(ILir/nasim/core/model/webapp/WebAppType;Lir/nasim/H48;ILir/nasim/core/modules/profile/entity/ExPeer;Lir/nasim/core/model/webapp/WebAppRestoreState;Lir/nasim/x68;Z)V", "Lir/nasim/core/model/webapp/minmize/WebAppKey;", "f", "()Lir/nasim/core/model/webapp/minmize/WebAppKey;", "Landroid/os/Parcel;", "dest", "flags", "Lir/nasim/rB7;", "writeToParcel", "(Landroid/os/Parcel;I)V", "describeContents", "()I", "a", "(ILir/nasim/core/model/webapp/WebAppType;Lir/nasim/H48;ILir/nasim/core/modules/profile/entity/ExPeer;Lir/nasim/core/model/webapp/WebAppRestoreState;Lir/nasim/x68;Z)Lir/nasim/core/model/webapp/WebAppArguments;", "", "toString", "()Ljava/lang/String;", "hashCode", "", "other", "equals", "(Ljava/lang/Object;)Z", TokenNames.I, "c", "b", "Lir/nasim/core/model/webapp/WebAppType;", "j", "()Lir/nasim/core/model/webapp/WebAppType;", "Lir/nasim/H48;", "g", "()Lir/nasim/H48;", "d", "e", "Lir/nasim/core/modules/profile/entity/ExPeer;", "()Lir/nasim/core/modules/profile/entity/ExPeer;", "Lir/nasim/core/model/webapp/WebAppRestoreState;", "i", "()Lir/nasim/core/model/webapp/WebAppRestoreState;", "Lir/nasim/x68;", "h", "()Lir/nasim/x68;", "Z", "k", "()Z", "nasim_release"}, k = 1, mv = {2, 0, 0})
/* loaded from: classes4.dex */
public final /* data */ class WebAppArguments implements Parcelable {
    public static final Parcelable.Creator<WebAppArguments> CREATOR = new a();

    /* renamed from: a, reason: from kotlin metadata and from toString */
    private final int botId;

    /* renamed from: b, reason: from kotlin metadata and from toString */
    private final WebAppType webAppType;

    /* renamed from: c, reason: from kotlin metadata and from toString */
    private final H48 openType;

    /* renamed from: d, reason: from kotlin metadata and from toString */
    private final int eventRandomId;

    /* renamed from: e, reason: from kotlin metadata and from toString */
    private final ExPeer chatExPeer;

    /* renamed from: f, reason: from kotlin metadata and from toString */
    private final WebAppRestoreState webAppRestoreState;

    /* renamed from: g, reason: from kotlin metadata and from toString */
    private final EnumC23552x68 screenMode;

    /* renamed from: h, reason: from kotlin metadata and from toString */
    private final boolean isRestore;

    public static final class a implements Parcelable.Creator {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final WebAppArguments createFromParcel(Parcel parcel) {
            AbstractC13042fc3.i(parcel, "parcel");
            return new WebAppArguments(parcel.readInt(), (WebAppType) parcel.readParcelable(WebAppArguments.class.getClassLoader()), H48.valueOf(parcel.readString()), parcel.readInt(), (ExPeer) parcel.readParcelable(WebAppArguments.class.getClassLoader()), parcel.readInt() == 0 ? null : WebAppRestoreState.CREATOR.createFromParcel(parcel), EnumC23552x68.valueOf(parcel.readString()), parcel.readInt() != 0);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public final WebAppArguments[] newArray(int i) {
            return new WebAppArguments[i];
        }
    }

    public WebAppArguments(int i, WebAppType webAppType, H48 h48, int i2, ExPeer exPeer, WebAppRestoreState webAppRestoreState, EnumC23552x68 enumC23552x68, boolean z) {
        AbstractC13042fc3.i(webAppType, "webAppType");
        AbstractC13042fc3.i(h48, "openType");
        AbstractC13042fc3.i(enumC23552x68, "screenMode");
        this.botId = i;
        this.webAppType = webAppType;
        this.openType = h48;
        this.eventRandomId = i2;
        this.chatExPeer = exPeer;
        this.webAppRestoreState = webAppRestoreState;
        this.screenMode = enumC23552x68;
        this.isRestore = z;
    }

    public final WebAppArguments a(int botId, WebAppType webAppType, H48 openType, int eventRandomId, ExPeer chatExPeer, WebAppRestoreState webAppRestoreState, EnumC23552x68 screenMode, boolean isRestore) {
        AbstractC13042fc3.i(webAppType, "webAppType");
        AbstractC13042fc3.i(openType, "openType");
        AbstractC13042fc3.i(screenMode, "screenMode");
        return new WebAppArguments(botId, webAppType, openType, eventRandomId, chatExPeer, webAppRestoreState, screenMode, isRestore);
    }

    /* renamed from: c, reason: from getter */
    public final int getBotId() {
        return this.botId;
    }

    /* renamed from: d, reason: from getter */
    public final ExPeer getChatExPeer() {
        return this.chatExPeer;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    /* renamed from: e, reason: from getter */
    public final int getEventRandomId() {
        return this.eventRandomId;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof WebAppArguments)) {
            return false;
        }
        WebAppArguments webAppArguments = (WebAppArguments) other;
        return this.botId == webAppArguments.botId && AbstractC13042fc3.d(this.webAppType, webAppArguments.webAppType) && this.openType == webAppArguments.openType && this.eventRandomId == webAppArguments.eventRandomId && AbstractC13042fc3.d(this.chatExPeer, webAppArguments.chatExPeer) && AbstractC13042fc3.d(this.webAppRestoreState, webAppArguments.webAppRestoreState) && this.screenMode == webAppArguments.screenMode && this.isRestore == webAppArguments.isRestore;
    }

    public final WebAppKey f() {
        return new WebAppKey(this.botId, this.webAppType);
    }

    /* renamed from: g, reason: from getter */
    public final H48 getOpenType() {
        return this.openType;
    }

    /* renamed from: h, reason: from getter */
    public final EnumC23552x68 getScreenMode() {
        return this.screenMode;
    }

    public int hashCode() {
        int iHashCode = ((((((Integer.hashCode(this.botId) * 31) + this.webAppType.hashCode()) * 31) + this.openType.hashCode()) * 31) + Integer.hashCode(this.eventRandomId)) * 31;
        ExPeer exPeer = this.chatExPeer;
        int iHashCode2 = (iHashCode + (exPeer == null ? 0 : exPeer.hashCode())) * 31;
        WebAppRestoreState webAppRestoreState = this.webAppRestoreState;
        return ((((iHashCode2 + (webAppRestoreState != null ? webAppRestoreState.hashCode() : 0)) * 31) + this.screenMode.hashCode()) * 31) + Boolean.hashCode(this.isRestore);
    }

    /* renamed from: i, reason: from getter */
    public final WebAppRestoreState getWebAppRestoreState() {
        return this.webAppRestoreState;
    }

    /* renamed from: j, reason: from getter */
    public final WebAppType getWebAppType() {
        return this.webAppType;
    }

    /* renamed from: k, reason: from getter */
    public final boolean getIsRestore() {
        return this.isRestore;
    }

    public String toString() {
        return "WebAppArguments(botId=" + this.botId + ", webAppType=" + this.webAppType + ", openType=" + this.openType + ", eventRandomId=" + this.eventRandomId + ", chatExPeer=" + this.chatExPeer + ", webAppRestoreState=" + this.webAppRestoreState + ", screenMode=" + this.screenMode + ", isRestore=" + this.isRestore + Separators.RPAREN;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel dest, int flags) {
        AbstractC13042fc3.i(dest, "dest");
        dest.writeInt(this.botId);
        dest.writeParcelable(this.webAppType, flags);
        dest.writeString(this.openType.name());
        dest.writeInt(this.eventRandomId);
        dest.writeParcelable(this.chatExPeer, flags);
        WebAppRestoreState webAppRestoreState = this.webAppRestoreState;
        if (webAppRestoreState == null) {
            dest.writeInt(0);
        } else {
            dest.writeInt(1);
            webAppRestoreState.writeToParcel(dest, flags);
        }
        dest.writeString(this.screenMode.name());
        dest.writeInt(this.isRestore ? 1 : 0);
    }

    public /* synthetic */ WebAppArguments(int i, WebAppType webAppType, H48 h48, int i2, ExPeer exPeer, WebAppRestoreState webAppRestoreState, EnumC23552x68 enumC23552x68, boolean z, int i3, ED1 ed1) {
        this(i, webAppType, h48, i2, (i3 & 16) != 0 ? null : exPeer, (i3 & 32) != 0 ? null : webAppRestoreState, (i3 & 64) != 0 ? EnumC23552x68.c : enumC23552x68, (i3 & 128) != 0 ? false : z);
    }
}
