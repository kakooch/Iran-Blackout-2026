package ir.nasim.core.runtime.mtproto;

import android.gov.nist.core.Separators;
import android.gov.nist.javax.sip.address.ParameterNames;
import android.gov.nist.javax.sip.parser.TokenNames;
import androidx.annotation.Keep;
import com.google.android.gms.common.annotation.KeepName;
import ir.nasim.AbstractC13042fc3;
import ir.nasim.AbstractC15401jX0;
import ir.nasim.InterfaceC23984xq6;
import ir.nasim.SA2;
import ir.nasim.core.runtime.mtproto.ConnectionEndpoint;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;

@Keep
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u001a\b\u0017\u0018\u0000 *2\u00020\u0001:\u0001+BK\b\u0004\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0004\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u000e\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\t\u0012\u0010\u0010\f\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0018\u00010\u000b¢\u0006\u0004\b\r\u0010\u000eBE\b\u0016\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\u0006\u001a\u00020\u0004\u0012\u0010\u0010\u000f\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0018\u00010\t\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\r\u0010\u0011J\r\u0010\u0013\u001a\u00020\u0012¢\u0006\u0004\b\u0013\u0010\u0014J\u0011\u0010\u0015\u001a\u0004\u0018\u00010\u0007H\u0007¢\u0006\u0004\b\u0015\u0010\u0016J\u001a\u0010\u0018\u001a\u00020\u00122\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001H\u0096\u0002¢\u0006\u0004\b\u0018\u0010\u0019J\u000f\u0010\u001a\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u001a\u0010\u001bJ\u000f\u0010\u001c\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u001c\u0010\u0016R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u001d\u001a\u0004\b\u001e\u0010\u001fR\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010 \u001a\u0004\b!\u0010\u001bR\u0017\u0010\u0006\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0006\u0010 \u001a\u0004\b\"\u0010\u001bR\u0017\u0010\b\u001a\u00020\u00078\u0006¢\u0006\f\n\u0004\b\b\u0010#\u001a\u0004\b$\u0010\u0016R\u001f\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\t8\u0006¢\u0006\f\n\u0004\b\n\u0010%\u001a\u0004\b&\u0010'R\u001e\u0010\f\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0018\u00010\u000b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u0010(R\u0018\u0010)\u001a\u0004\u0018\u00010\u00078\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b)\u0010#¨\u0006,"}, d2 = {"Lir/nasim/core/runtime/mtproto/ConnectionEndpoint;", "", "", "id", "", "type", "port", "", "host", "", "tlsPublicKeyHashes", "Lkotlin/Function0;", "knownIpProvider", "<init>", "(JIILjava/lang/String;Ljava/util/List;Lir/nasim/SA2;)V", "tlsPublicKeyHash", "knownIp", "(Ljava/lang/String;ILjava/util/List;Ljava/lang/String;IJ)V", "", "hasKnownIp", "()Z", "getKnownIp", "()Ljava/lang/String;", "other", "equals", "(Ljava/lang/Object;)Z", "hashCode", "()I", "toString", "J", "getId", "()J", TokenNames.I, "getType", "getPort", "Ljava/lang/String;", "getHost", "Ljava/util/List;", "getTlsPublicKeyHashes", "()Ljava/util/List;", "Lir/nasim/SA2;", "_knownIp", "Companion", "a", "base_productionRelease"}, k = 1, mv = {2, 0, 0})
@KeepName
/* loaded from: classes5.dex */
public class ConnectionEndpoint {
    public static final int TYPE_TCP = 0;
    public static final int TYPE_TCP_TLS = 1;
    public static final int TYPE_WS = 2;
    public static final int TYPE_WS_TLS = 3;

    @InterfaceC23984xq6("known_ip")
    private String _knownIp;
    private final String host;
    private final long id;
    private final transient SA2 knownIpProvider;
    private final int port;
    private final List<String> tlsPublicKeyHashes;
    private final int type;

    protected ConnectionEndpoint(long j, int i, int i2, String str, List<String> list, SA2 sa2) {
        AbstractC13042fc3.i(str, "host");
        this.id = j;
        this.type = i;
        this.port = i2;
        this.host = str;
        this.tlsPublicKeyHashes = list;
        this.knownIpProvider = sa2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String _init_$lambda$1$lambda$0(String str) {
        AbstractC13042fc3.i(str, "$it");
        return str;
    }

    public boolean equals(Object other) {
        return (other instanceof ConnectionEndpoint) && ((ConnectionEndpoint) other).id == this.id;
    }

    public final String getHost() {
        return this.host;
    }

    public final long getId() {
        return this.id;
    }

    public final String getKnownIp() {
        SA2 sa2 = this.knownIpProvider;
        if (sa2 != null) {
            return (String) sa2.invoke();
        }
        return null;
    }

    public final int getPort() {
        return this.port;
    }

    public final List<String> getTlsPublicKeyHashes() {
        return this.tlsPublicKeyHashes;
    }

    public final int getType() {
        return this.type;
    }

    public final boolean hasKnownIp() {
        return this.knownIpProvider != null;
    }

    public int hashCode() {
        return Objects.hash(Long.valueOf(this.id));
    }

    public String toString() {
        String str;
        int i = this.type;
        String str2 = ParameterNames.TCP;
        if (i != 0) {
            if (i == 1) {
                str2 = ParameterNames.TLS;
            } else if (i == 2) {
                str2 = "ws";
            } else if (i == 3) {
                str2 = "wss";
            }
        }
        List<String> list = this.tlsPublicKeyHashes;
        if (list != null) {
            str = Separators.LPAREN + list + Separators.RPAREN;
        } else {
            str = "";
        }
        String str3 = ((("Endpoint { " + str2 + str + "://") + this.host + ":") + this.port + Separators.POUND) + this.id;
        String str4 = this._knownIp;
        if (str4 != null) {
            str3 = str3 + Separators.AT + str4;
        }
        return str3 + " }";
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ConnectionEndpoint(String str, int i, List<String> list, final String str2, int i2, long j) {
        this(j, i2, i, str, (List<String>) (list != null ? AbstractC15401jX0.n0(list) : null), str2 != null ? new SA2() { // from class: ir.nasim.od1
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return ConnectionEndpoint._init_$lambda$1$lambda$0(str2);
            }
        } : null);
        AbstractC13042fc3.i(str, "host");
        this._knownIp = str2;
    }
}
