package io.grpc;

import com.google.common.base.Preconditions;
import io.grpc.ServiceProviders;
import io.grpc.internal.PickFirstLoadBalancerProvider;
import io.grpc.util.SecretRoundRobinLoadBalancerProvider$Provider;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/* loaded from: classes3.dex */
public final class LoadBalancerRegistry {
    private static LoadBalancerRegistry instance;
    private final LinkedHashSet<LoadBalancerProvider> allProviders = new LinkedHashSet<>();
    private final LinkedHashMap<String, LoadBalancerProvider> effectiveProviders = new LinkedHashMap<>();
    private static final Logger logger = Logger.getLogger(LoadBalancerRegistry.class.getName());
    private static final Iterable<Class<?>> HARDCODED_CLASSES = getHardCodedClasses();

    private synchronized void addProvider(LoadBalancerProvider loadBalancerProvider) {
        Preconditions.checkArgument(loadBalancerProvider.isAvailable(), "isAvailable() returned false");
        this.allProviders.add(loadBalancerProvider);
    }

    private synchronized void refreshProviderMap() {
        this.effectiveProviders.clear();
        Iterator<LoadBalancerProvider> it = this.allProviders.iterator();
        while (it.hasNext()) {
            LoadBalancerProvider next = it.next();
            String policyName = next.getPolicyName();
            LoadBalancerProvider loadBalancerProvider = this.effectiveProviders.get(policyName);
            if (loadBalancerProvider == null || loadBalancerProvider.getPriority() < next.getPriority()) {
                this.effectiveProviders.put(policyName, next);
            }
        }
    }

    public static synchronized LoadBalancerRegistry getDefaultRegistry() {
        if (instance == null) {
            List<LoadBalancerProvider> listLoadAll = ServiceProviders.loadAll(LoadBalancerProvider.class, HARDCODED_CLASSES, LoadBalancerProvider.class.getClassLoader(), new LoadBalancerPriorityAccessor());
            instance = new LoadBalancerRegistry();
            for (LoadBalancerProvider loadBalancerProvider : listLoadAll) {
                logger.fine("Service loader found " + loadBalancerProvider);
                if (loadBalancerProvider.isAvailable()) {
                    instance.addProvider(loadBalancerProvider);
                }
            }
            instance.refreshProviderMap();
        }
        return instance;
    }

    public synchronized LoadBalancerProvider getProvider(String str) {
        return this.effectiveProviders.get(Preconditions.checkNotNull(str, "policy"));
    }

    static List<Class<?>> getHardCodedClasses() {
        ArrayList arrayList = new ArrayList();
        try {
            int i = PickFirstLoadBalancerProvider.$r8$clinit;
            arrayList.add(PickFirstLoadBalancerProvider.class);
        } catch (ClassNotFoundException e) {
            logger.log(Level.WARNING, "Unable to find pick-first LoadBalancer", (Throwable) e);
        }
        try {
            int i2 = SecretRoundRobinLoadBalancerProvider$Provider.$r8$clinit;
            arrayList.add(SecretRoundRobinLoadBalancerProvider$Provider.class);
        } catch (ClassNotFoundException e2) {
            logger.log(Level.FINE, "Unable to find round-robin LoadBalancer", (Throwable) e2);
        }
        return Collections.unmodifiableList(arrayList);
    }

    private static final class LoadBalancerPriorityAccessor implements ServiceProviders.PriorityAccessor<LoadBalancerProvider> {
        LoadBalancerPriorityAccessor() {
        }

        @Override // io.grpc.ServiceProviders.PriorityAccessor
        public boolean isAvailable(LoadBalancerProvider loadBalancerProvider) {
            return loadBalancerProvider.isAvailable();
        }

        @Override // io.grpc.ServiceProviders.PriorityAccessor
        public int getPriority(LoadBalancerProvider loadBalancerProvider) {
            return loadBalancerProvider.getPriority();
        }
    }
}
