package ir.appp.common.data.error;

import ir.appp.common.domain.error.ErrorHandler;
import ir.appp.common.domain.model.BaseError;
import java.io.IOException;
import kotlin.jvm.internal.Intrinsics;
import retrofit2.HttpException;

/* compiled from: DefaultErrorHandlerImpl.kt */
/* loaded from: classes3.dex */
public final class DefaultErrorHandlerImpl implements ErrorHandler {
    @Override // ir.appp.common.domain.error.ErrorHandler
    public BaseError getError(Throwable throwable) {
        Intrinsics.checkNotNullParameter(throwable, "throwable");
        if (throwable instanceof IOException) {
            return BaseError.Network.INSTANCE;
        }
        if (throwable instanceof HttpException) {
            int iCode = ((HttpException) throwable).code();
            if (iCode == 403) {
                return BaseError.AccessDenied.INSTANCE;
            }
            if (iCode == 404) {
                return BaseError.NotFound.INSTANCE;
            }
            if (iCode == 503) {
                return BaseError.ServiceUnavailable.INSTANCE;
            }
            return BaseError.Unknown.INSTANCE;
        }
        return BaseError.Unknown.INSTANCE;
    }
}
