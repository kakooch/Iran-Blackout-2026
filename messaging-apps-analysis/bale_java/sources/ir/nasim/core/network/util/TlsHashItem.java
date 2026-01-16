package ir.nasim.core.network.util;

import android.gov.nist.core.Separators;
import androidx.annotation.Keep;
import com.google.android.gms.common.annotation.KeepName;
import ir.nasim.AbstractC13042fc3;
import ir.nasim.ED1;
import ir.nasim.InterfaceC23984xq6;
import java.util.List;
import kotlin.Metadata;

@Keep
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B)\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0004HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0004HÆ\u0003J/\u0010\u0011\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00042\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0004HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0004HÖ\u0001R\u001c\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0016\u0010\u0005\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\f¨\u0006\u0018"}, d2 = {"Lir/nasim/core/network/util/TlsHashItem;", "", "hashes", "", "", "host", "knownIp", "<init>", "(Ljava/util/List;Ljava/lang/String;Ljava/lang/String;)V", "getHashes", "()Ljava/util/List;", "getHost", "()Ljava/lang/String;", "getKnownIp", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "base_productionRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
@KeepName
/* loaded from: classes5.dex */
public final /* data */ class TlsHashItem {

    @InterfaceC23984xq6("hashes")
    private final List<String> hashes;

    @InterfaceC23984xq6("host")
    private final String host;

    @InterfaceC23984xq6("known_ip")
    private final String knownIp;

    public TlsHashItem(List<String> list, String str, String str2) {
        AbstractC13042fc3.i(list, "hashes");
        AbstractC13042fc3.i(str, "host");
        this.hashes = list;
        this.host = str;
        this.knownIp = str2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ TlsHashItem copy$default(TlsHashItem tlsHashItem, List list, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            list = tlsHashItem.hashes;
        }
        if ((i & 2) != 0) {
            str = tlsHashItem.host;
        }
        if ((i & 4) != 0) {
            str2 = tlsHashItem.knownIp;
        }
        return tlsHashItem.copy(list, str, str2);
    }

    public final List<String> component1() {
        return this.hashes;
    }

    /* renamed from: component2, reason: from getter */
    public final String getHost() {
        return this.host;
    }

    /* renamed from: component3, reason: from getter */
    public final String getKnownIp() {
        return this.knownIp;
    }

    public final TlsHashItem copy(List<String> hashes, String host, String knownIp) {
        AbstractC13042fc3.i(hashes, "hashes");
        AbstractC13042fc3.i(host, "host");
        return new TlsHashItem(hashes, host, knownIp);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TlsHashItem)) {
            return false;
        }
        TlsHashItem tlsHashItem = (TlsHashItem) other;
        return AbstractC13042fc3.d(this.hashes, tlsHashItem.hashes) && AbstractC13042fc3.d(this.host, tlsHashItem.host) && AbstractC13042fc3.d(this.knownIp, tlsHashItem.knownIp);
    }

    public final List<String> getHashes() {
        return this.hashes;
    }

    public final String getHost() {
        return this.host;
    }

    public final String getKnownIp() {
        return this.knownIp;
    }

    public int hashCode() {
        int iHashCode = ((this.hashes.hashCode() * 31) + this.host.hashCode()) * 31;
        String str = this.knownIp;
        return iHashCode + (str == null ? 0 : str.hashCode());
    }

    public String toString() {
        return "TlsHashItem(hashes=" + this.hashes + ", host=" + this.host + ", knownIp=" + this.knownIp + Separators.RPAREN;
    }

    public /* synthetic */ TlsHashItem(List list, String str, String str2, int i, ED1 ed1) {
        this(list, str, (i & 4) != 0 ? null : str2);
    }
}
