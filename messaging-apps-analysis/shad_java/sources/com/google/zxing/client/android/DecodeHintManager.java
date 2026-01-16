package com.google.zxing.client.android;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import com.google.zxing.DecodeHintType;
import java.util.EnumMap;
import java.util.Map;
import java.util.regex.Pattern;

/* loaded from: classes3.dex */
public final class DecodeHintManager {
    private static final String TAG = "DecodeHintManager";

    static {
        Pattern.compile(",");
    }

    public static Map<DecodeHintType, Object> parseDecodeHints(Intent intent) {
        Bundle extras = intent.getExtras();
        if (extras == null || extras.isEmpty()) {
            return null;
        }
        EnumMap enumMap = new EnumMap(DecodeHintType.class);
        for (DecodeHintType decodeHintType : DecodeHintType.values()) {
            if (decodeHintType != DecodeHintType.CHARACTER_SET && decodeHintType != DecodeHintType.NEED_RESULT_POINT_CALLBACK && decodeHintType != DecodeHintType.POSSIBLE_FORMATS) {
                String strName = decodeHintType.name();
                if (extras.containsKey(strName)) {
                    if (decodeHintType.getValueType().equals(Void.class)) {
                        enumMap.put((EnumMap) decodeHintType, (DecodeHintType) Boolean.TRUE);
                    } else {
                        Object obj = extras.get(strName);
                        if (decodeHintType.getValueType().isInstance(obj)) {
                            enumMap.put((EnumMap) decodeHintType, (DecodeHintType) obj);
                        } else {
                            Log.w(TAG, "Ignoring hint " + decodeHintType + " because it is not assignable from " + obj);
                        }
                    }
                }
            }
        }
        Log.i(TAG, "Hints from the Intent: " + enumMap);
        return enumMap;
    }
}
