package ir.appp.common.domain.model;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: BaseResponse.kt */
/* loaded from: classes3.dex */
public abstract class BaseResponse<T> {
    public /* synthetic */ BaseResponse(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    private BaseResponse() {
    }

    /* compiled from: BaseResponse.kt */
    public static final class Loading extends BaseResponse {
        public static final Loading INSTANCE = new Loading();

        private Loading() {
            super(null);
        }
    }

    /* compiled from: BaseResponse.kt */
    public static final class Error extends BaseResponse {
        private BaseError error;

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Error) && Intrinsics.areEqual(this.error, ((Error) obj).error);
        }

        public int hashCode() {
            return this.error.hashCode();
        }

        public String toString() {
            return "Error(error=" + this.error + ')';
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Error(BaseError error) {
            super(null);
            Intrinsics.checkNotNullParameter(error, "error");
            this.error = error;
        }

        public final BaseError getError() {
            return this.error;
        }
    }

    /* compiled from: BaseResponse.kt */
    public static final class Success<T> extends BaseResponse<T> {
        private T data;

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Success) && Intrinsics.areEqual(this.data, ((Success) obj).data);
        }

        public int hashCode() {
            T t = this.data;
            if (t == null) {
                return 0;
            }
            return t.hashCode();
        }

        public String toString() {
            return "Success(data=" + this.data + ')';
        }

        public Success(T t) {
            super(null);
            this.data = t;
        }

        public final T getData() {
            return this.data;
        }
    }
}
