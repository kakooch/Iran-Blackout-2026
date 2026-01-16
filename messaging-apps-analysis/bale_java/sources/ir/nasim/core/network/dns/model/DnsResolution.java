package ir.nasim.core.network.dns.model;

import android.gov.nist.core.Separators;
import androidx.annotation.Keep;
import com.google.android.gms.common.annotation.KeepName;
import ir.nasim.AbstractC13042fc3;
import ir.nasim.ED1;
import ir.nasim.InterfaceC23984xq6;
import java.util.List;
import kotlin.Metadata;

@Keep
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0011\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0005HÆ\u0003J\u000f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00030\u0007HÆ\u0003J\t\u0010\u0016\u001a\u00020\tHÆ\u0003J7\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u00072\b\b\u0002\u0010\b\u001a\u00020\tHÆ\u0001J\u0013\u0010\u0018\u001a\u00020\t2\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001J\t\u0010\u001c\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0016\u0010\b\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0012¨\u0006\u001d"}, d2 = {"Lir/nasim/core/network/dns/model/DnsResolution;", "", "host", "", "ttlInMillis", "", "addresses", "", "isVerified", "", "<init>", "(Ljava/lang/String;JLjava/util/List;Z)V", "getHost", "()Ljava/lang/String;", "getTtlInMillis", "()J", "getAddresses", "()Ljava/util/List;", "()Z", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "", "toString", "base_productionRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
@KeepName
/* loaded from: classes5.dex */
public final /* data */ class DnsResolution {
    private final List<String> addresses;
    private final String host;

    @InterfaceC23984xq6("isVerified_v2")
    private final boolean isVerified;
    private final long ttlInMillis;

    public DnsResolution(String str, long j, List<String> list, boolean z) {
        AbstractC13042fc3.i(str, "host");
        AbstractC13042fc3.i(list, "addresses");
        this.host = str;
        this.ttlInMillis = j;
        this.addresses = list;
        this.isVerified = z;
    }

    public static /* synthetic */ DnsResolution copy$default(DnsResolution dnsResolution, String str, long j, List list, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            str = dnsResolution.host;
        }
        if ((i & 2) != 0) {
            j = dnsResolution.ttlInMillis;
        }
        long j2 = j;
        if ((i & 4) != 0) {
            list = dnsResolution.addresses;
        }
        List list2 = list;
        if ((i & 8) != 0) {
            z = dnsResolution.isVerified;
        }
        return dnsResolution.copy(str, j2, list2, z);
    }

    /* renamed from: component1, reason: from getter */
    public final String getHost() {
        return this.host;
    }

    /* renamed from: component2, reason: from getter */
    public final long getTtlInMillis() {
        return this.ttlInMillis;
    }

    public final List<String> component3() {
        return this.addresses;
    }

    /* renamed from: component4, reason: from getter */
    public final boolean getIsVerified() {
        return this.isVerified;
    }

    public final DnsResolution copy(String host, long ttlInMillis, List<String> addresses, boolean isVerified) {
        AbstractC13042fc3.i(host, "host");
        AbstractC13042fc3.i(addresses, "addresses");
        return new DnsResolution(host, ttlInMillis, addresses, isVerified);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof DnsResolution)) {
            return false;
        }
        DnsResolution dnsResolution = (DnsResolution) other;
        return AbstractC13042fc3.d(this.host, dnsResolution.host) && this.ttlInMillis == dnsResolution.ttlInMillis && AbstractC13042fc3.d(this.addresses, dnsResolution.addresses) && this.isVerified == dnsResolution.isVerified;
    }

    public final List<String> getAddresses() {
        return this.addresses;
    }

    public final String getHost() {
        return this.host;
    }

    public final long getTtlInMillis() {
        return this.ttlInMillis;
    }

    public int hashCode() {
        return (((((this.host.hashCode() * 31) + Long.hashCode(this.ttlInMillis)) * 31) + this.addresses.hashCode()) * 31) + Boolean.hashCode(this.isVerified);
    }

    public final boolean isVerified() {
        return this.isVerified;
    }

    public String toString() {
        return "DnsResolution(host=" + this.host + ", ttlInMillis=" + this.ttlInMillis + ", addresses=" + this.addresses + ", isVerified=" + this.isVerified + Separators.RPAREN;
    }

    public /* synthetic */ DnsResolution(String str, long j, List list, boolean z, int i, ED1 ed1) {
        this(str, j, list, (i & 8) != 0 ? false : z);
    }
}
