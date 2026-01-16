package org.linphone.core.tools.compatibility;

import j$.util.Map;
import java.util.Map;

/* loaded from: classes3.dex */
public class DeviceUtils24 {
    public static String getStringOrDefaultFromMap(Map<String, String> map, String str, String str2) {
        return (String) Map.EL.getOrDefault(map, str, str2);
    }
}
