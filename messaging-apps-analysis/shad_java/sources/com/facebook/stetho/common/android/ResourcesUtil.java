package com.facebook.stetho.common.android;

import android.content.res.Resources;
import com.facebook.stetho.common.LogUtil;
import io.github.inflationx.calligraphy3.BuildConfig;

/* loaded from: classes.dex */
public class ResourcesUtil {
    private static int getResourcePackageId(int i) {
        return (i >>> 24) & 255;
    }

    private ResourcesUtil() {
    }

    public static String getIdStringQuietly(Object obj, Resources resources, int i) {
        try {
            return getIdString(resources, i);
        } catch (Resources.NotFoundException unused) {
            String fallbackIdString = getFallbackIdString(i);
            LogUtil.w("Unknown identifier encountered on " + obj + ": " + fallbackIdString);
            return fallbackIdString;
        }
    }

    public static String getIdString(Resources resources, int i) throws Resources.NotFoundException {
        String str;
        if (resources == null) {
            return getFallbackIdString(i);
        }
        int resourcePackageId = getResourcePackageId(i);
        String resourcePackageName = BuildConfig.FLAVOR;
        if (resourcePackageId != 127) {
            resourcePackageName = resources.getResourcePackageName(i);
            str = ":";
        } else {
            str = BuildConfig.FLAVOR;
        }
        String resourceTypeName = resources.getResourceTypeName(i);
        String resourceEntryName = resources.getResourceEntryName(i);
        StringBuilder sb = new StringBuilder(resourcePackageName.length() + 1 + str.length() + resourceTypeName.length() + 1 + resourceEntryName.length());
        sb.append("@");
        sb.append(resourcePackageName);
        sb.append(str);
        sb.append(resourceTypeName);
        sb.append("/");
        sb.append(resourceEntryName);
        return sb.toString();
    }

    private static String getFallbackIdString(int i) {
        return "#" + Integer.toHexString(i);
    }
}
