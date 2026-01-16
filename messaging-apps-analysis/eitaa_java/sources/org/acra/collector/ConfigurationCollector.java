package org.acra.collector;

import android.content.Context;
import android.content.res.Configuration;
import android.util.SparseArray;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.HashMap;
import java.util.Map;
import org.acra.ACRA;
import org.acra.ReportField;
import org.acra.builder.ReportBuilder;
import org.acra.config.CoreConfiguration;
import org.acra.data.CrashReportData;
import org.acra.plugins.Plugin;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public final class ConfigurationCollector extends BaseReportFieldCollector implements ApplicationStartupCollector {
    private static final String FIELD_MCC = "mcc";
    private static final String FIELD_MNC = "mnc";
    private static final String FIELD_SCREENLAYOUT = "screenLayout";
    private static final String FIELD_UIMODE = "uiMode";
    private static final String PREFIX_HARDKEYBOARDHIDDEN = "HARDKEYBOARDHIDDEN_";
    private static final String PREFIX_KEYBOARD = "KEYBOARD_";
    private static final String PREFIX_KEYBOARDHIDDEN = "KEYBOARDHIDDEN_";
    private static final String PREFIX_NAVIGATION = "NAVIGATION_";
    private static final String PREFIX_NAVIGATIONHIDDEN = "NAVIGATIONHIDDEN_";
    private static final String PREFIX_ORIENTATION = "ORIENTATION_";
    private static final String PREFIX_SCREENLAYOUT = "SCREENLAYOUT_";
    private static final String PREFIX_TOUCHSCREEN = "TOUCHSCREEN_";
    private static final String PREFIX_UI_MODE = "UI_MODE_";
    private static final String SUFFIX_MASK = "_MASK";
    private JSONObject initialConfiguration;

    @Override // org.acra.collector.BaseReportFieldCollector, org.acra.collector.Collector, org.acra.plugins.Plugin
    public /* bridge */ /* synthetic */ boolean enabled(CoreConfiguration coreConfiguration) {
        return Plugin.CC.$default$enabled(this, coreConfiguration);
    }

    public ConfigurationCollector() {
        super(ReportField.INITIAL_CONFIGURATION, ReportField.CRASH_CONFIGURATION);
    }

    /* renamed from: org.acra.collector.ConfigurationCollector$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$org$acra$ReportField;

        static {
            int[] iArr = new int[ReportField.values().length];
            $SwitchMap$org$acra$ReportField = iArr;
            try {
                iArr[ReportField.INITIAL_CONFIGURATION.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$org$acra$ReportField[ReportField.CRASH_CONFIGURATION.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    @Override // org.acra.collector.BaseReportFieldCollector
    void collect(ReportField reportField, Context context, CoreConfiguration coreConfiguration, ReportBuilder reportBuilder, CrashReportData crashReportData) {
        int i = AnonymousClass1.$SwitchMap$org$acra$ReportField[reportField.ordinal()];
        if (i == 1) {
            crashReportData.put(ReportField.INITIAL_CONFIGURATION, this.initialConfiguration);
        } else {
            if (i == 2) {
                crashReportData.put(ReportField.CRASH_CONFIGURATION, collectConfiguration(context));
                return;
            }
            throw new IllegalArgumentException();
        }
    }

    @Override // org.acra.collector.ApplicationStartupCollector
    public void collectApplicationStartUp(Context context, CoreConfiguration coreConfiguration) {
        if (coreConfiguration.reportContent().contains(ReportField.INITIAL_CONFIGURATION)) {
            this.initialConfiguration = collectConfiguration(context);
        }
    }

    private JSONObject configToJson(Configuration configuration) throws IllegalAccessException, JSONException, SecurityException, IllegalArgumentException {
        JSONObject jSONObject = new JSONObject();
        Map<String, SparseArray<String>> valueArrays = getValueArrays();
        for (Field field : configuration.getClass().getFields()) {
            try {
                if (!Modifier.isStatic(field.getModifiers())) {
                    String name = field.getName();
                    try {
                        if (field.getType().equals(Integer.TYPE)) {
                            jSONObject.put(name, getFieldValueName(valueArrays, configuration, field));
                        } else if (field.get(configuration) != null) {
                            jSONObject.put(name, field.get(configuration));
                        }
                    } catch (JSONException e) {
                        ACRA.log.w(ACRA.LOG_TAG, "Could not collect configuration field " + name, e);
                    }
                }
            } catch (IllegalAccessException e2) {
                ACRA.log.e(ACRA.LOG_TAG, "Error while inspecting device configuration: ", e2);
            } catch (IllegalArgumentException e3) {
                ACRA.log.e(ACRA.LOG_TAG, "Error while inspecting device configuration: ", e3);
            }
        }
        return jSONObject;
    }

    private Map<String, SparseArray<String>> getValueArrays() throws IllegalAccessException, SecurityException, IllegalArgumentException {
        Field[] fieldArr;
        int i;
        String str;
        SparseArray sparseArray;
        SparseArray sparseArray2;
        SparseArray sparseArray3;
        String str2 = "Error while inspecting device configuration: ";
        HashMap map = new HashMap();
        SparseArray sparseArray4 = new SparseArray();
        SparseArray sparseArray5 = new SparseArray();
        SparseArray sparseArray6 = new SparseArray();
        SparseArray sparseArray7 = new SparseArray();
        SparseArray sparseArray8 = new SparseArray();
        SparseArray sparseArray9 = new SparseArray();
        SparseArray sparseArray10 = new SparseArray();
        SparseArray sparseArray11 = new SparseArray();
        SparseArray sparseArray12 = new SparseArray();
        Field[] fields = Configuration.class.getFields();
        int length = fields.length;
        int i2 = 0;
        while (true) {
            HashMap map2 = map;
            String str3 = str2;
            SparseArray sparseArray13 = sparseArray12;
            SparseArray sparseArray14 = sparseArray11;
            SparseArray sparseArray15 = sparseArray10;
            if (i2 < length) {
                int i3 = length;
                Field field = fields[i2];
                if (Modifier.isStatic(field.getModifiers()) && Modifier.isFinal(field.getModifiers())) {
                    fieldArr = fields;
                    String name = field.getName();
                    try {
                        i = i2;
                        if (name.startsWith(PREFIX_HARDKEYBOARDHIDDEN)) {
                            try {
                                try {
                                    sparseArray4.put(field.getInt(null), name);
                                } catch (IllegalArgumentException e) {
                                    e = e;
                                    str = str3;
                                    sparseArray = sparseArray13;
                                    sparseArray2 = sparseArray14;
                                    sparseArray3 = sparseArray15;
                                    ACRA.log.w(ACRA.LOG_TAG, str, e);
                                    i2 = i + 1;
                                    sparseArray10 = sparseArray3;
                                    sparseArray11 = sparseArray2;
                                    str2 = str;
                                    sparseArray12 = sparseArray;
                                    map = map2;
                                    length = i3;
                                    fields = fieldArr;
                                }
                            } catch (IllegalAccessException e2) {
                                e = e2;
                                sparseArray = sparseArray13;
                                sparseArray2 = sparseArray14;
                                sparseArray3 = sparseArray15;
                                str = str3;
                                ACRA.log.w(ACRA.LOG_TAG, str, e);
                                i2 = i + 1;
                                sparseArray10 = sparseArray3;
                                sparseArray11 = sparseArray2;
                                str2 = str;
                                sparseArray12 = sparseArray;
                                map = map2;
                                length = i3;
                                fields = fieldArr;
                            }
                        } else {
                            try {
                                if (name.startsWith(PREFIX_KEYBOARD)) {
                                    sparseArray5.put(field.getInt(null), name);
                                } else if (name.startsWith(PREFIX_KEYBOARDHIDDEN)) {
                                    sparseArray6.put(field.getInt(null), name);
                                } else if (name.startsWith(PREFIX_NAVIGATION)) {
                                    sparseArray7.put(field.getInt(null), name);
                                } else if (name.startsWith(PREFIX_NAVIGATIONHIDDEN)) {
                                    sparseArray8.put(field.getInt(null), name);
                                } else if (name.startsWith(PREFIX_ORIENTATION)) {
                                    sparseArray9.put(field.getInt(null), name);
                                } else if (name.startsWith(PREFIX_SCREENLAYOUT)) {
                                    try {
                                        sparseArray3 = sparseArray15;
                                        try {
                                            try {
                                                sparseArray3.put(field.getInt(null), name);
                                                sparseArray = sparseArray13;
                                                sparseArray2 = sparseArray14;
                                                str = str3;
                                            } catch (IllegalArgumentException e3) {
                                                e = e3;
                                                str = str3;
                                                sparseArray = sparseArray13;
                                                sparseArray2 = sparseArray14;
                                                ACRA.log.w(ACRA.LOG_TAG, str, e);
                                                i2 = i + 1;
                                                sparseArray10 = sparseArray3;
                                                sparseArray11 = sparseArray2;
                                                str2 = str;
                                                sparseArray12 = sparseArray;
                                                map = map2;
                                                length = i3;
                                                fields = fieldArr;
                                            }
                                        } catch (IllegalAccessException e4) {
                                            e = e4;
                                            sparseArray = sparseArray13;
                                            sparseArray2 = sparseArray14;
                                            str = str3;
                                            ACRA.log.w(ACRA.LOG_TAG, str, e);
                                            i2 = i + 1;
                                            sparseArray10 = sparseArray3;
                                            sparseArray11 = sparseArray2;
                                            str2 = str;
                                            sparseArray12 = sparseArray;
                                            map = map2;
                                            length = i3;
                                            fields = fieldArr;
                                        }
                                    } catch (IllegalAccessException e5) {
                                        e = e5;
                                        sparseArray3 = sparseArray15;
                                    } catch (IllegalArgumentException e6) {
                                        e = e6;
                                        sparseArray3 = sparseArray15;
                                    }
                                } else {
                                    sparseArray3 = sparseArray15;
                                    try {
                                        if (name.startsWith(PREFIX_TOUCHSCREEN)) {
                                            try {
                                                sparseArray2 = sparseArray14;
                                                try {
                                                    try {
                                                        sparseArray2.put(field.getInt(null), name);
                                                        sparseArray = sparseArray13;
                                                        str = str3;
                                                    } catch (IllegalArgumentException e7) {
                                                        e = e7;
                                                        str = str3;
                                                        sparseArray = sparseArray13;
                                                        ACRA.log.w(ACRA.LOG_TAG, str, e);
                                                        i2 = i + 1;
                                                        sparseArray10 = sparseArray3;
                                                        sparseArray11 = sparseArray2;
                                                        str2 = str;
                                                        sparseArray12 = sparseArray;
                                                        map = map2;
                                                        length = i3;
                                                        fields = fieldArr;
                                                    }
                                                } catch (IllegalAccessException e8) {
                                                    e = e8;
                                                    sparseArray = sparseArray13;
                                                    str = str3;
                                                    ACRA.log.w(ACRA.LOG_TAG, str, e);
                                                    i2 = i + 1;
                                                    sparseArray10 = sparseArray3;
                                                    sparseArray11 = sparseArray2;
                                                    str2 = str;
                                                    sparseArray12 = sparseArray;
                                                    map = map2;
                                                    length = i3;
                                                    fields = fieldArr;
                                                }
                                            } catch (IllegalAccessException e9) {
                                                e = e9;
                                                sparseArray2 = sparseArray14;
                                            } catch (IllegalArgumentException e10) {
                                                e = e10;
                                                sparseArray2 = sparseArray14;
                                            }
                                        } else {
                                            sparseArray2 = sparseArray14;
                                            try {
                                                if (name.startsWith(PREFIX_UI_MODE)) {
                                                    int i4 = field.getInt(null);
                                                    sparseArray = sparseArray13;
                                                    try {
                                                        sparseArray.put(i4, name);
                                                    } catch (IllegalAccessException e11) {
                                                        e = e11;
                                                        str = str3;
                                                        ACRA.log.w(ACRA.LOG_TAG, str, e);
                                                        i2 = i + 1;
                                                        sparseArray10 = sparseArray3;
                                                        sparseArray11 = sparseArray2;
                                                        str2 = str;
                                                        sparseArray12 = sparseArray;
                                                        map = map2;
                                                        length = i3;
                                                        fields = fieldArr;
                                                    } catch (IllegalArgumentException e12) {
                                                        e = e12;
                                                        str = str3;
                                                        ACRA.log.w(ACRA.LOG_TAG, str, e);
                                                        i2 = i + 1;
                                                        sparseArray10 = sparseArray3;
                                                        sparseArray11 = sparseArray2;
                                                        str2 = str;
                                                        sparseArray12 = sparseArray;
                                                        map = map2;
                                                        length = i3;
                                                        fields = fieldArr;
                                                    }
                                                } else {
                                                    sparseArray = sparseArray13;
                                                }
                                                str = str3;
                                            } catch (IllegalArgumentException e13) {
                                                e = e13;
                                                sparseArray = sparseArray13;
                                            }
                                        }
                                    } catch (IllegalArgumentException e14) {
                                        e = e14;
                                        sparseArray = sparseArray13;
                                        sparseArray2 = sparseArray14;
                                    }
                                }
                            } catch (IllegalArgumentException e15) {
                                e = e15;
                                sparseArray = sparseArray13;
                                sparseArray2 = sparseArray14;
                                sparseArray3 = sparseArray15;
                            }
                        }
                        sparseArray = sparseArray13;
                        sparseArray2 = sparseArray14;
                        sparseArray3 = sparseArray15;
                        str = str3;
                    } catch (IllegalAccessException e16) {
                        e = e16;
                        i = i2;
                    } catch (IllegalArgumentException e17) {
                        e = e17;
                        i = i2;
                    }
                } else {
                    fieldArr = fields;
                    i = i2;
                    str = str3;
                    sparseArray = sparseArray13;
                    sparseArray2 = sparseArray14;
                    sparseArray3 = sparseArray15;
                }
                i2 = i + 1;
                sparseArray10 = sparseArray3;
                sparseArray11 = sparseArray2;
                str2 = str;
                sparseArray12 = sparseArray;
                map = map2;
                length = i3;
                fields = fieldArr;
            } else {
                map2.put(PREFIX_HARDKEYBOARDHIDDEN, sparseArray4);
                map2.put(PREFIX_KEYBOARD, sparseArray5);
                map2.put(PREFIX_KEYBOARDHIDDEN, sparseArray6);
                map2.put(PREFIX_NAVIGATION, sparseArray7);
                map2.put(PREFIX_NAVIGATIONHIDDEN, sparseArray8);
                map2.put(PREFIX_ORIENTATION, sparseArray9);
                map2.put(PREFIX_SCREENLAYOUT, sparseArray15);
                map2.put(PREFIX_TOUCHSCREEN, sparseArray14);
                map2.put(PREFIX_UI_MODE, sparseArray13);
                return map2;
            }
        }
    }

    private Object getFieldValueName(Map<String, SparseArray<String>> map, Configuration configuration, Field field) throws IllegalAccessException {
        String name;
        name = field.getName();
        name.hashCode();
        switch (name) {
            case "screenLayout":
                break;
            case "uiMode":
                break;
            case "mcc":
            case "mnc":
                break;
            default:
                SparseArray<String> sparseArray = map.get(name.toUpperCase() + '_');
                if (sparseArray != null) {
                    String str = sparseArray.get(field.getInt(configuration));
                    if (str == null) {
                        break;
                    }
                } else {
                    break;
                }
                break;
        }
        return Integer.valueOf(field.getInt(configuration));
    }

    private String activeFlags(SparseArray<String> sparseArray, int i) {
        int i2;
        StringBuilder sb = new StringBuilder();
        for (int i3 = 0; i3 < sparseArray.size(); i3++) {
            int iKeyAt = sparseArray.keyAt(i3);
            if (sparseArray.get(iKeyAt).endsWith(SUFFIX_MASK) && (i2 = iKeyAt & i) > 0) {
                if (sb.length() > 0) {
                    sb.append('+');
                }
                sb.append(sparseArray.get(i2));
            }
        }
        return sb.toString();
    }

    private JSONObject collectConfiguration(Context context) {
        try {
            return configToJson(context.getResources().getConfiguration());
        } catch (RuntimeException e) {
            ACRA.log.w(ACRA.LOG_TAG, "Couldn't retrieve CrashConfiguration for : " + context.getPackageName(), e);
            return null;
        }
    }
}
