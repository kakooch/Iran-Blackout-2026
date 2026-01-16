package io.grpc;

import com.google.common.base.Preconditions;
import io.grpc.ServiceProviders;
import io.grpc.okhttp.OkHttpChannelProvider;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/* loaded from: classes3.dex */
public final class ManagedChannelRegistry {
    private static ManagedChannelRegistry instance;
    private static final Logger logger = Logger.getLogger(ManagedChannelRegistry.class.getName());
    private final LinkedHashSet<ManagedChannelProvider> allProviders = new LinkedHashSet<>();
    private List<ManagedChannelProvider> effectiveProviders = Collections.emptyList();

    private synchronized void addProvider(ManagedChannelProvider managedChannelProvider) {
        Preconditions.checkArgument(managedChannelProvider.isAvailable(), "isAvailable() returned false");
        this.allProviders.add(managedChannelProvider);
    }

    private synchronized void refreshProviders() {
        ArrayList arrayList = new ArrayList(this.allProviders);
        Collections.sort(arrayList, Collections.reverseOrder(new Comparator<ManagedChannelProvider>(this) { // from class: io.grpc.ManagedChannelRegistry.1
            @Override // java.util.Comparator
            public int compare(ManagedChannelProvider managedChannelProvider, ManagedChannelProvider managedChannelProvider2) {
                return managedChannelProvider.priority() - managedChannelProvider2.priority();
            }
        }));
        this.effectiveProviders = Collections.unmodifiableList(arrayList);
    }

    public static synchronized ManagedChannelRegistry getDefaultRegistry() {
        if (instance == null) {
            List<ManagedChannelProvider> listLoadAll = ServiceProviders.loadAll(ManagedChannelProvider.class, getHardCodedClasses(), ManagedChannelProvider.class.getClassLoader(), new ManagedChannelPriorityAccessor());
            instance = new ManagedChannelRegistry();
            for (ManagedChannelProvider managedChannelProvider : listLoadAll) {
                logger.fine("Service loader found " + managedChannelProvider);
                if (managedChannelProvider.isAvailable()) {
                    instance.addProvider(managedChannelProvider);
                }
            }
            instance.refreshProviders();
        }
        return instance;
    }

    synchronized List<ManagedChannelProvider> providers() {
        return this.effectiveProviders;
    }

    ManagedChannelProvider provider() {
        List<ManagedChannelProvider> listProviders = providers();
        if (listProviders.isEmpty()) {
            return null;
        }
        return listProviders.get(0);
    }

    static List<Class<?>> getHardCodedClasses() {
        ArrayList arrayList = new ArrayList();
        try {
            arrayList.add(OkHttpChannelProvider.class);
        } catch (ClassNotFoundException e) {
            logger.log(Level.FINE, "Unable to find OkHttpChannelProvider", (Throwable) e);
        }
        try {
            arrayList.add(Class.forName("io.grpc.netty.NettyChannelProvider"));
        } catch (ClassNotFoundException e2) {
            logger.log(Level.FINE, "Unable to find NettyChannelProvider", (Throwable) e2);
        }
        return Collections.unmodifiableList(arrayList);
    }

    private static final class ManagedChannelPriorityAccessor implements ServiceProviders.PriorityAccessor<ManagedChannelProvider> {
        private ManagedChannelPriorityAccessor() {
        }

        @Override // io.grpc.ServiceProviders.PriorityAccessor
        public boolean isAvailable(ManagedChannelProvider managedChannelProvider) {
            return managedChannelProvider.isAvailable();
        }

        @Override // io.grpc.ServiceProviders.PriorityAccessor
        public int getPriority(ManagedChannelProvider managedChannelProvider) {
            return managedChannelProvider.priority();
        }
    }
}
