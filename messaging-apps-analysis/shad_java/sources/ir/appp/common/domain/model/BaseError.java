package ir.appp.common.domain.model;

import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: BaseError.kt */
/* loaded from: classes3.dex */
public abstract class BaseError {
    public /* synthetic */ BaseError(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    private BaseError() {
    }

    /* compiled from: BaseError.kt */
    public static final class Network extends BaseError {
        public static final Network INSTANCE = new Network();

        private Network() {
            super(null);
        }
    }

    /* compiled from: BaseError.kt */
    public static final class NotFound extends BaseError {
        public static final NotFound INSTANCE = new NotFound();

        private NotFound() {
            super(null);
        }
    }

    /* compiled from: BaseError.kt */
    public static final class AccessDenied extends BaseError {
        public static final AccessDenied INSTANCE = new AccessDenied();

        private AccessDenied() {
            super(null);
        }
    }

    /* compiled from: BaseError.kt */
    public static final class ServiceUnavailable extends BaseError {
        public static final ServiceUnavailable INSTANCE = new ServiceUnavailable();

        private ServiceUnavailable() {
            super(null);
        }
    }

    /* compiled from: BaseError.kt */
    public static final class Unknown extends BaseError {
        public static final Unknown INSTANCE = new Unknown();

        private Unknown() {
            super(null);
        }
    }
}
