package org.xbill.DNS.config;

import com.sun.jna.Memory;
import com.sun.jna.Pointer;
import com.sun.jna.platform.win32.Win32Exception;
import com.sun.jna.ptr.IntByReference;
import ir.nasim.OI3;
import ir.nasim.RI3;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.UnknownHostException;
import java.util.List;
import lombok.Generated;
import org.xbill.DNS.Name;
import org.xbill.DNS.config.IPHlpAPI;

/* loaded from: classes8.dex */
public class WindowsResolverConfigProvider implements ResolverConfigProvider {

    @Generated
    private static final OI3 log = RI3.i(WindowsResolverConfigProvider.class);
    private InnerWindowsResolverConfigProvider inner;

    private static final class InnerWindowsResolverConfigProvider extends BaseResolverConfigProvider {

        @Generated
        private static final OI3 log;

        static {
            OI3 oi3I = RI3.i(InnerWindowsResolverConfigProvider.class);
            log = oi3I;
            oi3I.c("Checking for JNA classes: {} and {}", Memory.class.getName(), Win32Exception.class.getName());
        }

        private InnerWindowsResolverConfigProvider() {
        }

        @Override // org.xbill.DNS.config.ResolverConfigProvider
        public void initialize() throws InitializationException {
            reset();
            Memory memory = new Memory(15360L);
            IntByReference intByReference = new IntByReference(0);
            IPHlpAPI iPHlpAPI = IPHlpAPI.INSTANCE;
            if (iPHlpAPI.GetAdaptersAddresses(0, 39, Pointer.NULL, memory, intByReference) == 111) {
                memory = new Memory(intByReference.getValue());
                int iGetAdaptersAddresses = iPHlpAPI.GetAdaptersAddresses(0, 39, Pointer.NULL, memory, intByReference);
                if (iGetAdaptersAddresses != 0) {
                    throw new InitializationException((Exception) new Win32Exception(iGetAdaptersAddresses));
                }
            }
            IPHlpAPI.IP_ADAPTER_ADDRESSES_LH ip_adapter_addresses_lh = new IPHlpAPI.IP_ADAPTER_ADDRESSES_LH(memory);
            do {
                if (ip_adapter_addresses_lh.OperStatus == 1) {
                    for (IPHlpAPI.IP_ADAPTER_DNS_SERVER_ADDRESS_XP.ByReference byReference = ip_adapter_addresses_lh.FirstDnsServerAddress; byReference != null; byReference = byReference.Next) {
                        try {
                            InetAddress address = byReference.Address.toAddress();
                            if ((address instanceof Inet4Address) || !address.isSiteLocalAddress()) {
                                addNameserver(new InetSocketAddress(address, 53));
                            } else {
                                log.c("Skipped site-local IPv6 server address {} on adapter index {}", address, Integer.valueOf(ip_adapter_addresses_lh.IfIndex));
                            }
                        } catch (UnknownHostException e) {
                            log.g("Invalid nameserver address on adapter index {}", Integer.valueOf(ip_adapter_addresses_lh.IfIndex), e);
                        }
                    }
                    addSearchPath(ip_adapter_addresses_lh.DnsSuffix.toString());
                    for (IPHlpAPI.IP_ADAPTER_DNS_SUFFIX.ByReference byReference2 = ip_adapter_addresses_lh.FirstDnsSuffix; byReference2 != null; byReference2 = byReference2.Next) {
                        addSearchPath(String.valueOf(byReference2._String));
                    }
                }
                ip_adapter_addresses_lh = ip_adapter_addresses_lh.Next;
            } while (ip_adapter_addresses_lh != null);
        }
    }

    public WindowsResolverConfigProvider() {
        if (System.getProperty("os.name").contains("Windows")) {
            try {
                this.inner = new InnerWindowsResolverConfigProvider();
            } catch (NoClassDefFoundError unused) {
                log.b("JNA not available");
            }
        }
    }

    @Override // org.xbill.DNS.config.ResolverConfigProvider
    public void initialize() throws InitializationException {
        this.inner.initialize();
    }

    @Override // org.xbill.DNS.config.ResolverConfigProvider
    public boolean isEnabled() {
        return this.inner != null;
    }

    @Override // org.xbill.DNS.config.ResolverConfigProvider
    public List<Name> searchPaths() {
        return this.inner.searchPaths();
    }

    @Override // org.xbill.DNS.config.ResolverConfigProvider
    public List<InetSocketAddress> servers() {
        return this.inner.servers();
    }
}
