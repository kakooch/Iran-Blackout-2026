package androidx.sharetarget;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ResolveInfo;
import android.content.res.XmlResourceParser;
import android.os.Bundle;
import android.util.Log;
import androidx.sharetarget.a;
import ir.nasim.core.modules.market.model.SearchSuggestion;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.xmlpull.v1.XmlPullParserException;

/* loaded from: classes2.dex */
abstract class b {
    private static volatile ArrayList a;
    private static final Object b = new Object();

    private static String a(XmlResourceParser xmlResourceParser, String str) {
        String attributeValue = xmlResourceParser.getAttributeValue("http://schemas.android.com/apk/res/android", str);
        return attributeValue == null ? xmlResourceParser.getAttributeValue(null, str) : attributeValue;
    }

    static ArrayList b(Context context) {
        if (a == null) {
            synchronized (b) {
                try {
                    if (a == null) {
                        a = e(context);
                    }
                } finally {
                }
            }
        }
        return a;
    }

    private static XmlResourceParser c(Context context, ActivityInfo activityInfo) {
        XmlResourceParser xmlResourceParserLoadXmlMetaData = activityInfo.loadXmlMetaData(context.getPackageManager(), "android.app.shortcuts");
        if (xmlResourceParserLoadXmlMetaData != null) {
            return xmlResourceParserLoadXmlMetaData;
        }
        throw new IllegalArgumentException("Failed to open android.app.shortcuts meta-data resource of " + activityInfo.name);
    }

    private static a d(XmlResourceParser xmlResourceParser) throws XmlPullParserException, IOException {
        String strA = a(xmlResourceParser, "targetClass");
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        while (true) {
            int next = xmlResourceParser.next();
            if (next != 1) {
                if (next != 2) {
                    if (next == 3 && xmlResourceParser.getName().equals("share-target")) {
                        break;
                    }
                } else {
                    String name = xmlResourceParser.getName();
                    name.hashCode();
                    if (name.equals("data")) {
                        arrayList.add(g(xmlResourceParser));
                    } else if (name.equals(SearchSuggestion.CATEGORY_ICON)) {
                        arrayList2.add(a(xmlResourceParser, "name"));
                    }
                }
            } else {
                break;
            }
        }
        if (arrayList.isEmpty() || strA == null || arrayList2.isEmpty()) {
            return null;
        }
        return new a((a.C0124a[]) arrayList.toArray(new a.C0124a[arrayList.size()]), strA, (String[]) arrayList2.toArray(new String[arrayList2.size()]));
    }

    private static ArrayList e(Context context) {
        ArrayList arrayList = new ArrayList();
        Intent intent = new Intent("android.intent.action.MAIN");
        intent.addCategory("android.intent.category.LAUNCHER");
        intent.setPackage(context.getPackageName());
        List<ResolveInfo> listQueryIntentActivities = context.getPackageManager().queryIntentActivities(intent, 128);
        if (listQueryIntentActivities == null) {
            return arrayList;
        }
        Iterator<ResolveInfo> it = listQueryIntentActivities.iterator();
        while (it.hasNext()) {
            ActivityInfo activityInfo = it.next().activityInfo;
            Bundle bundle = activityInfo.metaData;
            if (bundle != null && bundle.containsKey("android.app.shortcuts")) {
                arrayList.addAll(f(context, activityInfo));
            }
        }
        return arrayList;
    }

    private static ArrayList f(Context context, ActivityInfo activityInfo) throws XmlPullParserException, IOException {
        a aVarD;
        ArrayList arrayList = new ArrayList();
        XmlResourceParser xmlResourceParserC = c(context, activityInfo);
        while (true) {
            try {
                int next = xmlResourceParserC.next();
                if (next == 1) {
                    break;
                }
                if (next == 2 && xmlResourceParserC.getName().equals("share-target") && (aVarD = d(xmlResourceParserC)) != null) {
                    arrayList.add(aVarD);
                }
            } catch (Exception e) {
                Log.e("ShareTargetXmlParser", "Failed to parse the Xml resource: ", e);
            }
        }
        xmlResourceParserC.close();
        return arrayList;
    }

    private static a.C0124a g(XmlResourceParser xmlResourceParser) {
        return new a.C0124a(a(xmlResourceParser, "scheme"), a(xmlResourceParser, "host"), a(xmlResourceParser, "port"), a(xmlResourceParser, "path"), a(xmlResourceParser, "pathPattern"), a(xmlResourceParser, "pathPrefix"), a(xmlResourceParser, "mimeType"));
    }
}
