package io.grpc.util;

import io.grpc.LoadBalancer;
import io.grpc.LoadBalancerProvider;
import io.grpc.NameResolver;
import java.util.Map;

/* loaded from: classes3.dex */
public final class SecretRoundRobinLoadBalancerProvider$Provider extends LoadBalancerProvider {
    public static final /* synthetic */ int $r8$clinit = 0;

    @Override // io.grpc.LoadBalancerProvider
    public String getPolicyName() {
        return "round_robin";
    }

    @Override // io.grpc.LoadBalancerProvider
    public int getPriority() {
        return 5;
    }

    @Override // io.grpc.LoadBalancerProvider
    public boolean isAvailable() {
        return true;
    }

    @Override // io.grpc.LoadBalancer.Factory
    public LoadBalancer newLoadBalancer(LoadBalancer.Helper helper) {
        return new RoundRobinLoadBalancer(helper);
    }

    @Override // io.grpc.LoadBalancerProvider
    public NameResolver.ConfigOrError parseLoadBalancingPolicyConfig(Map<String, ?> map) {
        return NameResolver.ConfigOrError.fromConfig("no service config");
    }
}
