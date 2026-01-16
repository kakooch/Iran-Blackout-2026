package org.xbill.DNS.config;

import ir.nasim.OI3;
import ir.nasim.RI3;
import java.net.InetSocketAddress;
import java.util.List;
import javax.naming.directory.DirContext;
import lombok.Generated;
import org.xbill.DNS.Name;

/* loaded from: classes8.dex */
public class JndiContextResolverConfigProvider implements ResolverConfigProvider {

    @Generated
    private static final OI3 log = RI3.i(JndiContextResolverConfigProvider.class);
    private InnerJndiContextResolverConfigProvider inner;

    private static final class InnerJndiContextResolverConfigProvider extends BaseResolverConfigProvider {

        @Generated
        private static final OI3 log;

        static {
            OI3 oi3I = RI3.i(InnerJndiContextResolverConfigProvider.class);
            log = oi3I;
            oi3I.s("JNDI class: {}", DirContext.class.getName());
        }

        private InnerJndiContextResolverConfigProvider() {
        }

        /* JADX WARN: Removed duplicated region for block: B:25:0x006c A[ORIG_RETURN, RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:9:0x002e  */
        @Override // org.xbill.DNS.config.ResolverConfigProvider
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public void initialize() {
            /*
                r5 = this;
                r5.reset()
                java.util.Hashtable r0 = new java.util.Hashtable
                r0.<init>()
                java.lang.String r1 = "java.naming.factory.initial"
                java.lang.String r2 = "com.sun.jndi.dns.DnsContextFactory"
                r0.put(r1, r2)
                java.lang.String r1 = "dns://"
                java.lang.String r2 = "java.naming.provider.url"
                r0.put(r2, r1)
                r1 = 0
                javax.naming.directory.InitialDirContext r3 = new javax.naming.directory.InitialDirContext     // Catch: javax.naming.NamingException -> L2b
                r3.<init>(r0)     // Catch: javax.naming.NamingException -> L2b
                java.util.Hashtable r0 = r3.getEnvironment()     // Catch: javax.naming.NamingException -> L2b
                java.lang.Object r0 = r0.get(r2)     // Catch: javax.naming.NamingException -> L2b
                java.lang.String r0 = (java.lang.String) r0     // Catch: javax.naming.NamingException -> L2b
                r3.close()     // Catch: javax.naming.NamingException -> L2a
                goto L2c
            L2a:
                r1 = r0
            L2b:
                r0 = r1
            L2c:
                if (r0 == 0) goto L6c
                java.util.StringTokenizer r1 = new java.util.StringTokenizer
                java.lang.String r2 = " "
                r1.<init>(r0, r2)
            L35:
                boolean r0 = r1.hasMoreTokens()
                if (r0 == 0) goto L6c
                java.lang.String r0 = r1.nextToken()
                java.net.URI r2 = new java.net.URI     // Catch: java.net.URISyntaxException -> L63
                r2.<init>(r0)     // Catch: java.net.URISyntaxException -> L63
                java.lang.String r3 = r2.getHost()     // Catch: java.net.URISyntaxException -> L63
                if (r3 == 0) goto L35
                boolean r4 = r3.isEmpty()     // Catch: java.net.URISyntaxException -> L63
                if (r4 == 0) goto L51
                goto L35
            L51:
                int r2 = r2.getPort()     // Catch: java.net.URISyntaxException -> L63
                r4 = -1
                if (r2 != r4) goto L5a
                r2 = 53
            L5a:
                java.net.InetSocketAddress r4 = new java.net.InetSocketAddress     // Catch: java.net.URISyntaxException -> L63
                r4.<init>(r3, r2)     // Catch: java.net.URISyntaxException -> L63
                r5.addNameserver(r4)     // Catch: java.net.URISyntaxException -> L63
                goto L35
            L63:
                r2 = move-exception
                ir.nasim.OI3 r3 = org.xbill.DNS.config.JndiContextResolverConfigProvider.InnerJndiContextResolverConfigProvider.log
                java.lang.String r4 = "Could not parse {} as a dns server, ignoring"
                r3.c(r4, r0, r2)
                goto L35
            L6c:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: org.xbill.DNS.config.JndiContextResolverConfigProvider.InnerJndiContextResolverConfigProvider.initialize():void");
        }
    }

    public JndiContextResolverConfigProvider() {
        if (System.getProperty("java.vendor").contains("Android")) {
            return;
        }
        try {
            this.inner = new InnerJndiContextResolverConfigProvider();
        } catch (NoClassDefFoundError unused) {
            log.b("JNDI DNS not available");
        }
    }

    @Override // org.xbill.DNS.config.ResolverConfigProvider
    public void initialize() {
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
