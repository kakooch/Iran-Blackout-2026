package io.grpc.internal;

import io.grpc.internal.DnsNameResolver;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;
import javax.naming.NamingEnumeration;
import javax.naming.NamingException;
import javax.naming.directory.Attribute;
import javax.naming.directory.DirContext;
import javax.naming.directory.InitialDirContext;

/* loaded from: classes3.dex */
final class JndiResourceResolverFactory implements DnsNameResolver.ResourceResolverFactory {
    private static final Throwable JNDI_UNAVAILABILITY_CAUSE = initJndi();

    interface RecordFetcher {
        List<String> getAllRecords(String str, String str2) throws NamingException;
    }

    private static Throwable initJndi() throws ClassNotFoundException {
        try {
            Class.forName("javax.naming.directory.InitialDirContext");
            Class.forName("com.sun.jndi.dns.DnsContextFactory");
            return null;
        } catch (ClassNotFoundException e) {
            return e;
        } catch (Error e2) {
            return e2;
        } catch (RuntimeException e3) {
            return e3;
        }
    }

    @Override // io.grpc.internal.DnsNameResolver.ResourceResolverFactory
    public DnsNameResolver.ResourceResolver newResourceResolver() {
        if (unavailabilityCause() != null) {
            return null;
        }
        return new JndiResourceResolver(new JndiRecordFetcher());
    }

    @Override // io.grpc.internal.DnsNameResolver.ResourceResolverFactory
    public Throwable unavailabilityCause() {
        return JNDI_UNAVAILABILITY_CAUSE;
    }

    static final class JndiResourceResolver implements DnsNameResolver.ResourceResolver {
        private static final Logger logger = Logger.getLogger(JndiResourceResolver.class.getName());
        private final RecordFetcher recordFetcher;

        static {
            Pattern.compile("\\s+");
        }

        public JndiResourceResolver(RecordFetcher recordFetcher) {
            this.recordFetcher = recordFetcher;
        }

        @Override // io.grpc.internal.DnsNameResolver.ResourceResolver
        public List<String> resolveTxt(String str) throws NamingException {
            Logger logger2 = logger;
            Level level = Level.FINER;
            if (logger2.isLoggable(level)) {
                logger2.log(level, "About to query TXT records for {0}", new Object[]{str});
            }
            List<String> allRecords = this.recordFetcher.getAllRecords("TXT", "dns:///" + str);
            if (logger2.isLoggable(level)) {
                logger2.log(level, "Found {0} TXT records", new Object[]{Integer.valueOf(allRecords.size())});
            }
            ArrayList arrayList = new ArrayList(allRecords.size());
            Iterator<String> it = allRecords.iterator();
            while (it.hasNext()) {
                arrayList.add(unquote(it.next()));
            }
            return Collections.unmodifiableList(arrayList);
        }

        static String unquote(String str) {
            StringBuilder sb = new StringBuilder(str.length());
            int i = 0;
            boolean z = false;
            while (i < str.length()) {
                char cCharAt = str.charAt(i);
                if (z) {
                    if (cCharAt == '\"') {
                        z = false;
                    } else {
                        if (cCharAt == '\\') {
                            i++;
                            cCharAt = str.charAt(i);
                        }
                        sb.append(cCharAt);
                    }
                } else if (cCharAt != ' ') {
                    if (cCharAt == '\"') {
                        z = true;
                    } else {
                        sb.append(cCharAt);
                    }
                }
                i++;
            }
            return sb.toString();
        }
    }

    static final class JndiRecordFetcher implements RecordFetcher {
        JndiRecordFetcher() {
        }

        @Override // io.grpc.internal.JndiResourceResolverFactory.RecordFetcher
        public List<String> getAllRecords(String str, String str2) throws NamingException {
            checkAvailable();
            String[] strArr = {str};
            ArrayList arrayList = new ArrayList();
            Hashtable hashtable = new Hashtable();
            hashtable.put("com.sun.jndi.ldap.connect.timeout", "5000");
            hashtable.put("com.sun.jndi.ldap.read.timeout", "5000");
            InitialDirContext initialDirContext = new InitialDirContext(hashtable);
            try {
                NamingEnumeration all = initialDirContext.getAttributes(str2, strArr).getAll();
                while (all.hasMore()) {
                    try {
                        NamingEnumeration all2 = ((Attribute) all.next()).getAll();
                        while (all2.hasMore()) {
                            try {
                                arrayList.add(String.valueOf(all2.next()));
                            } catch (NamingException e) {
                                closeThenThrow((NamingEnumeration<?>) all2, e);
                            }
                        }
                        all2.close();
                    } catch (NamingException e2) {
                        closeThenThrow((NamingEnumeration<?>) all, e2);
                    }
                }
                all.close();
            } catch (NamingException e3) {
                closeThenThrow((DirContext) initialDirContext, e3);
            }
            initialDirContext.close();
            return arrayList;
        }

        /* JADX INFO: Thrown type has an unknown type hierarchy: javax.naming.NamingException */
        private static void closeThenThrow(NamingEnumeration<?> namingEnumeration, NamingException namingException) throws NamingException {
            try {
                namingEnumeration.close();
                throw namingException;
            } catch (NamingException unused) {
                throw namingException;
            }
        }

        /* JADX INFO: Thrown type has an unknown type hierarchy: javax.naming.NamingException */
        private static void closeThenThrow(DirContext dirContext, NamingException namingException) throws NamingException {
            try {
                dirContext.close();
                throw namingException;
            } catch (NamingException unused) {
                throw namingException;
            }
        }

        private static void checkAvailable() {
            if (JndiResourceResolverFactory.JNDI_UNAVAILABILITY_CAUSE != null) {
                throw new UnsupportedOperationException("JNDI is not currently available", JndiResourceResolverFactory.JNDI_UNAVAILABILITY_CAUSE);
            }
        }
    }
}
