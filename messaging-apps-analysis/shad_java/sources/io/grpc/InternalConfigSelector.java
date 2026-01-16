package io.grpc;

import com.google.common.base.Preconditions;
import io.grpc.Attributes;
import io.grpc.LoadBalancer;

/* loaded from: classes3.dex */
public abstract class InternalConfigSelector {
    public static final Attributes.Key<InternalConfigSelector> KEY = Attributes.Key.create("io.grpc.config-selector");

    public abstract Result selectConfig(LoadBalancer.PickSubchannelArgs pickSubchannelArgs);

    public static final class Result {
        private final Object config;
        public ClientInterceptor interceptor;
        private final Status status;

        private Result(Status status, Object obj, ClientInterceptor clientInterceptor) {
            this.status = (Status) Preconditions.checkNotNull(status, "status");
            this.config = obj;
            this.interceptor = clientInterceptor;
        }

        public Status getStatus() {
            return this.status;
        }

        public Object getConfig() {
            return this.config;
        }

        public ClientInterceptor getInterceptor() {
            return this.interceptor;
        }

        public static Builder newBuilder() {
            return new Builder();
        }

        public static final class Builder {
            private Object config;
            private ClientInterceptor interceptor;

            private Builder() {
            }

            public Builder setConfig(Object obj) {
                this.config = Preconditions.checkNotNull(obj, "config");
                return this;
            }

            public Result build() {
                Preconditions.checkState(this.config != null, "config is not set");
                return new Result(Status.OK, this.config, this.interceptor);
            }
        }
    }
}
