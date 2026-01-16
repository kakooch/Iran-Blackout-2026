package io.appmetrica.analytics.modulesapi.internal.common;

import kotlin.Metadata;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J!\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002H&¢\u0006\u0004\b\u0006\u0010\u0007J%\u0010\t\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0003\u001a\u00020\u00022\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0002H&¢\u0006\u0004\b\t\u0010\nJ\u001f\u0010\f\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u000bH&¢\u0006\u0004\b\f\u0010\rJ!\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\b\u001a\u00020\u000bH&¢\u0006\u0004\b\u000e\u0010\u000fJ\u001f\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0010H&¢\u0006\u0004\b\u0011\u0010\u0012J!\u0010\u0013\u001a\u00020\u00102\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\b\u001a\u00020\u0010H&¢\u0006\u0004\b\u0013\u0010\u0014J\u001f\u0010\u0016\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0015H&¢\u0006\u0004\b\u0016\u0010\u0017J\u001f\u0010\u0018\u001a\u00020\u00152\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0015H&¢\u0006\u0004\b\u0018\u0010\u0019¨\u0006\u001a"}, d2 = {"Lio/appmetrica/analytics/modulesapi/internal/common/ModulePreferences;", "", "", "key", "value", "Lir/nasim/rB7;", "putString", "(Ljava/lang/String;Ljava/lang/String;)V", "fallback", "getString", "(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;", "", "putLong", "(Ljava/lang/String;J)V", "getLong", "(Ljava/lang/String;J)J", "", "putInt", "(Ljava/lang/String;I)V", "getInt", "(Ljava/lang/String;I)I", "", "putBoolean", "(Ljava/lang/String;Z)V", "getBoolean", "(Ljava/lang/String;Z)Z", "modules-api_release"}, k = 1, mv = {1, 6, 0})
/* loaded from: classes3.dex */
public interface ModulePreferences {

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public static final class DefaultImpls {
        public static /* synthetic */ int getInt$default(ModulePreferences modulePreferences, String str, int i, int i2, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getInt");
            }
            if ((i2 & 2) != 0) {
                i = 0;
            }
            return modulePreferences.getInt(str, i);
        }

        public static /* synthetic */ long getLong$default(ModulePreferences modulePreferences, String str, long j, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getLong");
            }
            if ((i & 2) != 0) {
                j = 0;
            }
            return modulePreferences.getLong(str, j);
        }

        public static /* synthetic */ String getString$default(ModulePreferences modulePreferences, String str, String str2, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getString");
            }
            if ((i & 2) != 0) {
                str2 = null;
            }
            return modulePreferences.getString(str, str2);
        }
    }

    boolean getBoolean(String key, boolean fallback);

    int getInt(String key, int fallback);

    long getLong(String key, long fallback);

    String getString(String key, String fallback);

    void putBoolean(String key, boolean value);

    void putInt(String key, int value);

    void putLong(String key, long value);

    void putString(String key, String value);
}
