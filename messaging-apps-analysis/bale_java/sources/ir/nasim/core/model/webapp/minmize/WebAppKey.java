package ir.nasim.core.model.webapp.minmize;

import android.gov.nist.core.Separators;
import android.gov.nist.javax.sip.parser.TokenNames;
import android.os.Parcel;
import android.os.Parcelable;
import ir.nasim.AbstractC13042fc3;
import ir.nasim.core.model.webapp.WebAppType;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\b\u0087\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u001f\u0010\f\u001a\u00020\u000b2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000e\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0011\u001a\u00020\u0010H×\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0013\u001a\u00020\u0002H×\u0001¢\u0006\u0004\b\u0013\u0010\u000fJ\u001a\u0010\u0017\u001a\u00020\u00162\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014H×\u0003¢\u0006\u0004\b\u0017\u0010\u0018R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u000fR\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001f¨\u0006 "}, d2 = {"Lir/nasim/core/model/webapp/minmize/WebAppKey;", "Landroid/os/Parcelable;", "", "botId", "Lir/nasim/core/model/webapp/WebAppType;", "webAppType", "<init>", "(ILir/nasim/core/model/webapp/WebAppType;)V", "Landroid/os/Parcel;", "dest", "flags", "Lir/nasim/rB7;", "writeToParcel", "(Landroid/os/Parcel;I)V", "describeContents", "()I", "", "toString", "()Ljava/lang/String;", "hashCode", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "a", TokenNames.I, "getBotId", "b", "Lir/nasim/core/model/webapp/WebAppType;", "getWebAppType", "()Lir/nasim/core/model/webapp/WebAppType;", "nasim_release"}, k = 1, mv = {2, 0, 0})
/* loaded from: classes4.dex */
public final /* data */ class WebAppKey implements Parcelable {
    public static final Parcelable.Creator<WebAppKey> CREATOR = new a();

    /* renamed from: a, reason: from kotlin metadata and from toString */
    private final int botId;

    /* renamed from: b, reason: from kotlin metadata and from toString */
    private final WebAppType webAppType;

    public static final class a implements Parcelable.Creator {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final WebAppKey createFromParcel(Parcel parcel) {
            AbstractC13042fc3.i(parcel, "parcel");
            return new WebAppKey(parcel.readInt(), (WebAppType) parcel.readParcelable(WebAppKey.class.getClassLoader()));
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public final WebAppKey[] newArray(int i) {
            return new WebAppKey[i];
        }
    }

    public WebAppKey(int i, WebAppType webAppType) {
        AbstractC13042fc3.i(webAppType, "webAppType");
        this.botId = i;
        this.webAppType = webAppType;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof WebAppKey)) {
            return false;
        }
        WebAppKey webAppKey = (WebAppKey) other;
        return this.botId == webAppKey.botId && AbstractC13042fc3.d(this.webAppType, webAppKey.webAppType);
    }

    public int hashCode() {
        return (Integer.hashCode(this.botId) * 31) + this.webAppType.hashCode();
    }

    public String toString() {
        return "WebAppKey(botId=" + this.botId + ", webAppType=" + this.webAppType + Separators.RPAREN;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel dest, int flags) {
        AbstractC13042fc3.i(dest, "dest");
        dest.writeInt(this.botId);
        dest.writeParcelable(this.webAppType, flags);
    }
}
