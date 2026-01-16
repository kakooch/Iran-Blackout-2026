package org.xbill.DNS.config;

import java.net.InetSocketAddress;
import java.util.List;
import org.xbill.DNS.Name;

/* loaded from: classes8.dex */
public interface ResolverConfigProvider {
    void initialize();

    default boolean isEnabled() {
        return true;
    }

    default int ndots() {
        return 1;
    }

    List<Name> searchPaths();

    List<InetSocketAddress> servers();
}
