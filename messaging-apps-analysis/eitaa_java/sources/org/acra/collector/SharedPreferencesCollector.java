package org.acra.collector;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;
import org.acra.ACRA;
import org.acra.ReportField;
import org.acra.builder.ReportBuilder;
import org.acra.config.CoreConfiguration;
import org.acra.data.CrashReportData;
import org.acra.plugins.Plugin;
import org.acra.prefs.SharedPreferencesFactory;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public final class SharedPreferencesCollector extends BaseReportFieldCollector {
    @Override // org.acra.collector.BaseReportFieldCollector, org.acra.collector.Collector, org.acra.plugins.Plugin
    public /* bridge */ /* synthetic */ boolean enabled(CoreConfiguration coreConfiguration) {
        return Plugin.CC.$default$enabled(this, coreConfiguration);
    }

    public SharedPreferencesCollector() {
        super(ReportField.USER_EMAIL, ReportField.SHARED_PREFERENCES);
    }

    /* renamed from: org.acra.collector.SharedPreferencesCollector$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$org$acra$ReportField;

        static {
            int[] iArr = new int[ReportField.values().length];
            $SwitchMap$org$acra$ReportField = iArr;
            try {
                iArr[ReportField.USER_EMAIL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$org$acra$ReportField[ReportField.SHARED_PREFERENCES.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    @Override // org.acra.collector.BaseReportFieldCollector
    void collect(ReportField reportField, Context context, CoreConfiguration coreConfiguration, ReportBuilder reportBuilder, CrashReportData crashReportData) throws Exception {
        int i = AnonymousClass1.$SwitchMap$org$acra$ReportField[reportField.ordinal()];
        if (i == 1) {
            crashReportData.put(ReportField.USER_EMAIL, new SharedPreferencesFactory(context, coreConfiguration).create().getString(ACRA.PREF_USER_EMAIL_ADDRESS, null));
        } else {
            if (i == 2) {
                crashReportData.put(ReportField.SHARED_PREFERENCES, collect(context, coreConfiguration));
                return;
            }
            throw new IllegalArgumentException();
        }
    }

    private JSONObject collect(Context context, CoreConfiguration coreConfiguration) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        TreeMap treeMap = new TreeMap();
        treeMap.put("default", PreferenceManager.getDefaultSharedPreferences(context));
        Iterator<String> it = coreConfiguration.additionalSharedPreferences().iterator();
        while (it.hasNext()) {
            String next = it.next();
            treeMap.put(next, context.getSharedPreferences(next, 0));
        }
        for (Map.Entry entry : treeMap.entrySet()) {
            String str = (String) entry.getKey();
            Map<String, ?> all = ((SharedPreferences) entry.getValue()).getAll();
            if (all.isEmpty()) {
                jSONObject.put(str, "empty");
            } else {
                Iterator<String> it2 = all.keySet().iterator();
                while (it2.hasNext()) {
                    if (filteredKey(coreConfiguration, it2.next())) {
                        it2.remove();
                    }
                }
                jSONObject.put(str, new JSONObject(all));
            }
        }
        return jSONObject;
    }

    private boolean filteredKey(CoreConfiguration coreConfiguration, String str) {
        Iterator<String> it = coreConfiguration.excludeMatchingSharedPreferencesKeys().iterator();
        while (it.hasNext()) {
            if (str.matches(it.next())) {
                return true;
            }
        }
        return false;
    }
}
