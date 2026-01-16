package org.xbill.DNS.config;

import ir.nasim.OI3;
import ir.nasim.RI3;
import java.net.Inet4Address;
import java.net.InetSocketAddress;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import org.xbill.DNS.Name;
import org.xbill.DNS.TextParseException;
import org.xbill.DNS.config.BaseResolverConfigProvider;

/* loaded from: classes8.dex */
public abstract class BaseResolverConfigProvider implements ResolverConfigProvider {
    protected static final int DEFAULT_PORT = 53;
    private static final boolean IPV4_ONLY = Boolean.getBoolean("java.net.preferIPv4Stack");
    private static final boolean IPV6_FIRST = Boolean.getBoolean("java.net.preferIPv6Addresses");
    private final List<InetSocketAddress> nameservers = new ArrayList(3);
    protected final OI3 log = RI3.i(getClass());
    protected final List<Name> searchlist = new ArrayList(1);

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ int lambda$servers$0(InetSocketAddress inetSocketAddress, InetSocketAddress inetSocketAddress2) {
        return Integer.compare(inetSocketAddress2.getAddress().getAddress().length, inetSocketAddress.getAddress().getAddress().length);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$servers$1(InetSocketAddress inetSocketAddress) {
        return inetSocketAddress.getAddress() instanceof Inet4Address;
    }

    protected void addNameserver(InetSocketAddress inetSocketAddress) {
        if (this.nameservers.contains(inetSocketAddress)) {
            return;
        }
        this.nameservers.add(inetSocketAddress);
        this.log.s("Added {} to nameservers", inetSocketAddress);
    }

    protected void addSearchPath(String str) {
        if (str == null || str.isEmpty()) {
            return;
        }
        try {
            Name nameFromString = Name.fromString(str, Name.root);
            if (this.searchlist.contains(nameFromString)) {
                return;
            }
            this.searchlist.add(nameFromString);
            this.log.s("Added {} to search paths", nameFromString);
        } catch (TextParseException unused) {
            this.log.q("Could not parse search path {} as a dns name, ignoring", str);
        }
    }

    protected int parseNdots(String str) throws NumberFormatException {
        if (str == null || str.isEmpty()) {
            return 1;
        }
        try {
            int i = Integer.parseInt(str);
            if (i < 0) {
                return 1;
            }
            if (i > 15) {
                return 15;
            }
            return i;
        } catch (NumberFormatException unused) {
            return 1;
        }
    }

    protected void parseSearchPathList(String str, String str2) {
        if (str != null) {
            StringTokenizer stringTokenizer = new StringTokenizer(str, str2);
            while (stringTokenizer.hasMoreTokens()) {
                addSearchPath(stringTokenizer.nextToken());
            }
        }
    }

    protected final void reset() {
        this.nameservers.clear();
        this.searchlist.clear();
    }

    @Override // org.xbill.DNS.config.ResolverConfigProvider
    public final List<Name> searchPaths() {
        return Collections.unmodifiableList(this.searchlist);
    }

    @Override // org.xbill.DNS.config.ResolverConfigProvider
    public final List<InetSocketAddress> servers() {
        return IPV6_FIRST ? (List) this.nameservers.stream().sorted(new Comparator() { // from class: ir.nasim.Oa0
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                return BaseResolverConfigProvider.lambda$servers$0((InetSocketAddress) obj, (InetSocketAddress) obj2);
            }
        }).collect(Collectors.toList()) : IPV4_ONLY ? (List) this.nameservers.stream().filter(new Predicate() { // from class: ir.nasim.Pa0
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                return BaseResolverConfigProvider.lambda$servers$1((InetSocketAddress) obj);
            }
        }).collect(Collectors.toList()) : Collections.unmodifiableList(this.nameservers);
    }
}
