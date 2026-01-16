package io.appmetrica.analytics.logger.appmetrica.internal;

import android.gov.nist.javax.sip.header.ParameterNames;
import io.appmetrica.analytics.logger.common.BaseDebugLogger;
import kotlin.Metadata;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001J\u001d\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lio/appmetrica/analytics/logger/appmetrica/internal/DebugLogger;", "Lio/appmetrica/analytics/logger/common/BaseDebugLogger;", "", ParameterNames.TAG, "Lorg/json/JSONObject;", "jsonObject", "Lir/nasim/rB7;", "dumpJson", "(Ljava/lang/String;Lorg/json/JSONObject;)V", "logger_release"}, k = 1, mv = {1, 6, 0})
/* loaded from: classes3.dex */
public final class DebugLogger extends BaseDebugLogger {
    public static final DebugLogger INSTANCE = new DebugLogger();

    private DebugLogger() {
        super("AppMetricaDebug");
    }

    public final void dumpJson(String tag, JSONObject jsonObject) {
        String string;
        try {
            string = jsonObject.toString(2);
        } catch (Throwable unused) {
            string = "Exception during dumping JSONObject";
        }
        info(tag, string, new Object[0]);
    }
}
