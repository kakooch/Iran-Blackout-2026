package com.google.firebase.inappmessaging.internal;

import android.os.Bundle;
import com.google.firebase.analytics.connector.AnalyticsConnector;
import com.google.firebase.inject.Deferred;
import com.google.firebase.inject.Provider;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/* loaded from: classes3.dex */
public class ProxyAnalyticsConnector implements AnalyticsConnector {
    private volatile Object instance;

    @Override // com.google.firebase.analytics.connector.AnalyticsConnector
    public void clearConditionalUserProperty(String str, String str2, Bundle bundle) {
    }

    @Override // com.google.firebase.analytics.connector.AnalyticsConnector
    public int getMaxUserProperties(String str) {
        return 0;
    }

    @Override // com.google.firebase.analytics.connector.AnalyticsConnector
    public void setConditionalUserProperty(AnalyticsConnector.ConditionalUserProperty conditionalUserProperty) {
    }

    public ProxyAnalyticsConnector(Deferred<AnalyticsConnector> deferred) {
        this.instance = deferred;
        deferred.whenAvailable(new Deferred.DeferredHandler() { // from class: com.google.firebase.inappmessaging.internal.ProxyAnalyticsConnector$$ExternalSyntheticLambda0
            @Override // com.google.firebase.inject.Deferred.DeferredHandler
            public final void handle(Provider provider) {
                this.f$0.lambda$new$0(provider);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$0(Provider provider) {
        this.instance = provider.get();
    }

    private AnalyticsConnector safeGet() {
        Object obj = this.instance;
        if (obj instanceof AnalyticsConnector) {
            return (AnalyticsConnector) obj;
        }
        return null;
    }

    @Override // com.google.firebase.analytics.connector.AnalyticsConnector
    public void logEvent(String str, String str2, Bundle bundle) {
        AnalyticsConnector analyticsConnectorSafeGet = safeGet();
        if (analyticsConnectorSafeGet != null) {
            analyticsConnectorSafeGet.logEvent(str, str2, bundle);
        }
    }

    @Override // com.google.firebase.analytics.connector.AnalyticsConnector
    public void setUserProperty(String str, String str2, Object obj) {
        AnalyticsConnector analyticsConnectorSafeGet = safeGet();
        if (analyticsConnectorSafeGet != null) {
            analyticsConnectorSafeGet.setUserProperty(str, str2, obj);
        }
    }

    @Override // com.google.firebase.analytics.connector.AnalyticsConnector
    public AnalyticsConnector.AnalyticsConnectorHandle registerAnalyticsConnectorListener(String str, AnalyticsConnector.AnalyticsConnectorListener analyticsConnectorListener) {
        Object obj = this.instance;
        if (obj instanceof AnalyticsConnector) {
            return ((AnalyticsConnector) obj).registerAnalyticsConnectorListener(str, analyticsConnectorListener);
        }
        return new ProxyAnalyticsConnectorHandle(str, analyticsConnectorListener, (Deferred) obj);
    }

    @Override // com.google.firebase.analytics.connector.AnalyticsConnector
    public List<AnalyticsConnector.ConditionalUserProperty> getConditionalUserProperties(String str, String str2) {
        return Collections.emptyList();
    }

    /* JADX INFO: Access modifiers changed from: private */
    static class ProxyAnalyticsConnectorHandle implements AnalyticsConnector.AnalyticsConnectorHandle {
        private static final Object UNREGISTERED = new Object();
        private Set<String> eventNames;
        private volatile Object instance;

        private ProxyAnalyticsConnectorHandle(final String str, final AnalyticsConnector.AnalyticsConnectorListener analyticsConnectorListener, Deferred<AnalyticsConnector> deferred) {
            this.eventNames = new HashSet();
            deferred.whenAvailable(new Deferred.DeferredHandler() { // from class: com.google.firebase.inappmessaging.internal.ProxyAnalyticsConnector$ProxyAnalyticsConnectorHandle$$ExternalSyntheticLambda0
                @Override // com.google.firebase.inject.Deferred.DeferredHandler
                public final void handle(Provider provider) {
                    this.f$0.lambda$new$0(str, analyticsConnectorListener, provider);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$new$0(String str, AnalyticsConnector.AnalyticsConnectorListener analyticsConnectorListener, Provider provider) {
            if (this.instance == UNREGISTERED) {
                return;
            }
            AnalyticsConnector.AnalyticsConnectorHandle analyticsConnectorHandleRegisterAnalyticsConnectorListener = ((AnalyticsConnector) provider.get()).registerAnalyticsConnectorListener(str, analyticsConnectorListener);
            this.instance = analyticsConnectorHandleRegisterAnalyticsConnectorListener;
            synchronized (this) {
                if (!this.eventNames.isEmpty()) {
                    analyticsConnectorHandleRegisterAnalyticsConnectorListener.registerEventNames(this.eventNames);
                    this.eventNames = new HashSet();
                }
            }
        }

        @Override // com.google.firebase.analytics.connector.AnalyticsConnector.AnalyticsConnectorHandle
        public void registerEventNames(Set<String> set) {
            Object obj = this.instance;
            if (obj == UNREGISTERED) {
                return;
            }
            if (obj != null) {
                ((AnalyticsConnector.AnalyticsConnectorHandle) obj).registerEventNames(set);
            } else {
                synchronized (this) {
                    this.eventNames.addAll(set);
                }
            }
        }
    }
}
