package io.appmetrica.analytics.modulesapi.internal.common;

import ir.nasim.database.dailogLists.DialogEntity;
import java.util.Map;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J-\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0014\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0007H&¢\u0006\u0004\b\u0005\u0010\tJ!\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\b\u001a\u0004\u0018\u00010\u0002H&¢\u0006\u0004\b\u0005\u0010\nJ)\u0010\u0005\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\b\u001a\u0004\u0018\u00010\u0002H&¢\u0006\u0004\b\u0005\u0010\rJ#\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u00022\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u000fH&¢\u0006\u0004\b\u0011\u0010\u0012J#\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u00022\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0002H&¢\u0006\u0004\b\u0011\u0010\n¨\u0006\u0014"}, d2 = {"Lio/appmetrica/analytics/modulesapi/internal/common/ModuleSelfReporter;", "", "", "eventName", "Lir/nasim/rB7;", "reportEvent", "(Ljava/lang/String;)V", "", "eventValue", "(Ljava/lang/String;Ljava/util/Map;)V", "(Ljava/lang/String;Ljava/lang/String;)V", "", "type", "(ILjava/lang/String;Ljava/lang/String;)V", DialogEntity.COLUMN_MESSAGE, "", "error", "reportError", "(Ljava/lang/String;Ljava/lang/Throwable;)V", "identifier", "modules-api_release"}, k = 1, mv = {1, 6, 0})
/* loaded from: classes3.dex */
public interface ModuleSelfReporter {

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public static final class DefaultImpls {
        public static /* synthetic */ void reportError$default(ModuleSelfReporter moduleSelfReporter, String str, Throwable th, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: reportError");
            }
            if ((i & 2) != 0) {
                th = null;
            }
            moduleSelfReporter.reportError(str, th);
        }

        public static /* synthetic */ void reportError$default(ModuleSelfReporter moduleSelfReporter, String str, String str2, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: reportError");
            }
            if ((i & 2) != 0) {
                str2 = null;
            }
            moduleSelfReporter.reportError(str, str2);
        }
    }

    void reportError(String identifier, String message);

    void reportError(String message, Throwable error);

    void reportEvent(int type, String eventName, String eventValue);

    void reportEvent(String eventName);

    void reportEvent(String eventName, String eventValue);

    void reportEvent(String eventName, Map<String, ? extends Object> eventValue);
}
