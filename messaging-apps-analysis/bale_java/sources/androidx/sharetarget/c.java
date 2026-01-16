package androidx.sharetarget;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.util.Log;
import android.util.Xml;
import ir.nasim.C15791kA6;
import ir.nasim.KJ;
import ir.nasim.PL;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlSerializer;

/* loaded from: classes2.dex */
abstract class c {

    static class a {
        final String a;
        final String b;
        final C15791kA6 c;

        a(C15791kA6 c15791kA6, String str, String str2) {
            this.c = c15791kA6;
            this.a = str;
            this.b = str2;
        }
    }

    private static String a(XmlPullParser xmlPullParser, String str) {
        String attributeValue = xmlPullParser.getAttributeValue("http://schemas.android.com/apk/res/android", str);
        return attributeValue == null ? xmlPullParser.getAttributeValue(null, str) : attributeValue;
    }

    static Map b(File file, Context context) throws IOException {
        FileInputStream fileInputStream;
        a aVarE;
        C15791kA6 c15791kA6;
        KJ kj = new KJ();
        try {
            fileInputStream = new FileInputStream(file);
            try {
            } finally {
            }
        } catch (Exception e) {
            file.delete();
            Log.e("ShortcutInfoCompatSaver", "Failed to load saved values from file " + file.getAbsolutePath() + ". Old state removed, new added", e);
        }
        if (!file.exists()) {
            fileInputStream.close();
            return kj;
        }
        XmlPullParser xmlPullParserNewPullParser = Xml.newPullParser();
        xmlPullParserNewPullParser.setInput(fileInputStream, "UTF_8");
        while (true) {
            int next = xmlPullParserNewPullParser.next();
            if (next == 1) {
                break;
            }
            if (next == 2 && xmlPullParserNewPullParser.getName().equals("target") && (aVarE = e(xmlPullParserNewPullParser, context)) != null && (c15791kA6 = aVarE.c) != null) {
                kj.put(c15791kA6.f(), aVarE);
            }
        }
        fileInputStream.close();
        return kj;
    }

    private static ComponentName c(XmlPullParser xmlPullParser) {
        String strA = a(xmlPullParser, "component");
        if (TextUtils.isEmpty(strA)) {
            return null;
        }
        return ComponentName.unflattenFromString(strA);
    }

    private static Intent d(XmlPullParser xmlPullParser) {
        String strA = a(xmlPullParser, "action");
        String strA2 = a(xmlPullParser, "targetPackage");
        String strA3 = a(xmlPullParser, "targetClass");
        if (strA == null) {
            return null;
        }
        Intent intent = new Intent(strA);
        if (!TextUtils.isEmpty(strA2) && !TextUtils.isEmpty(strA3)) {
            intent.setClassName(strA2, strA3);
        }
        return intent;
    }

    private static a e(XmlPullParser xmlPullParser, Context context) throws XmlPullParserException, NumberFormatException, IOException {
        if (!xmlPullParser.getName().equals("target")) {
            return null;
        }
        String strA = a(xmlPullParser, "id");
        String strA2 = a(xmlPullParser, "short_label");
        if (TextUtils.isEmpty(strA) || TextUtils.isEmpty(strA2)) {
            return null;
        }
        int i = Integer.parseInt(a(xmlPullParser, "rank"));
        String strA3 = a(xmlPullParser, "long_label");
        String strA4 = a(xmlPullParser, "disabled_message");
        ComponentName componentNameC = c(xmlPullParser);
        String strA5 = a(xmlPullParser, "icon_resource_name");
        String strA6 = a(xmlPullParser, "icon_bitmap_path");
        ArrayList arrayList = new ArrayList();
        HashSet hashSet = new HashSet();
        while (true) {
            int next = xmlPullParser.next();
            if (next != 1) {
                if (next != 2) {
                    if (next == 3 && xmlPullParser.getName().equals("target")) {
                        break;
                    }
                } else {
                    String name = xmlPullParser.getName();
                    name.hashCode();
                    if (name.equals("intent")) {
                        Intent intentD = d(xmlPullParser);
                        if (intentD != null) {
                            arrayList.add(intentD);
                        }
                    } else if (name.equals("categories")) {
                        String strA7 = a(xmlPullParser, "name");
                        if (!TextUtils.isEmpty(strA7)) {
                            hashSet.add(strA7);
                        }
                    }
                }
            } else {
                break;
            }
        }
        C15791kA6.b bVarL = new C15791kA6.b(context, strA).m(strA2).l(i);
        if (!TextUtils.isEmpty(strA3)) {
            bVarL.j(strA3);
        }
        if (!TextUtils.isEmpty(strA4)) {
            bVarL.d(strA4);
        }
        if (componentNameC != null) {
            bVarL.b(componentNameC);
        }
        if (!arrayList.isEmpty()) {
            bVarL.g((Intent[]) arrayList.toArray(new Intent[0]));
        }
        if (!hashSet.isEmpty()) {
            bVarL.c(hashSet);
        }
        return new a(bVarL.a(), strA5, strA6);
    }

    static void f(List list, File file) throws IllegalStateException, IOException, IllegalArgumentException {
        FileOutputStream fileOutputStreamE;
        PL pl = new PL(file);
        FileOutputStream fileOutputStream = null;
        try {
            fileOutputStreamE = pl.e();
        } catch (Exception e) {
            e = e;
        }
        try {
            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(fileOutputStreamE);
            XmlSerializer xmlSerializerNewSerializer = Xml.newSerializer();
            xmlSerializerNewSerializer.setOutput(bufferedOutputStream, "UTF_8");
            xmlSerializerNewSerializer.startDocument(null, Boolean.TRUE);
            xmlSerializerNewSerializer.startTag(null, "share_targets");
            Iterator it = list.iterator();
            while (it.hasNext()) {
                j(xmlSerializerNewSerializer, (a) it.next());
            }
            xmlSerializerNewSerializer.endTag(null, "share_targets");
            xmlSerializerNewSerializer.endDocument();
            bufferedOutputStream.flush();
            fileOutputStreamE.flush();
            pl.b(fileOutputStreamE);
        } catch (Exception e2) {
            e = e2;
            fileOutputStream = fileOutputStreamE;
            Log.e("ShortcutInfoCompatSaver", "Failed to write to file " + pl.c(), e);
            pl.a(fileOutputStream);
            throw new RuntimeException("Failed to write to file " + pl.c(), e);
        }
    }

    private static void g(XmlSerializer xmlSerializer, String str, String str2) throws IllegalStateException, IOException, IllegalArgumentException {
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        xmlSerializer.attribute(null, str, str2);
    }

    private static void h(XmlSerializer xmlSerializer, String str) throws IllegalStateException, IOException, IllegalArgumentException {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        xmlSerializer.startTag(null, "categories");
        g(xmlSerializer, "name", str);
        xmlSerializer.endTag(null, "categories");
    }

    private static void i(XmlSerializer xmlSerializer, Intent intent) throws IllegalStateException, IOException, IllegalArgumentException {
        xmlSerializer.startTag(null, "intent");
        g(xmlSerializer, "action", intent.getAction());
        if (intent.getComponent() != null) {
            g(xmlSerializer, "targetPackage", intent.getComponent().getPackageName());
            g(xmlSerializer, "targetClass", intent.getComponent().getClassName());
        }
        xmlSerializer.endTag(null, "intent");
    }

    private static void j(XmlSerializer xmlSerializer, a aVar) throws IllegalStateException, IOException, IllegalArgumentException {
        xmlSerializer.startTag(null, "target");
        C15791kA6 c15791kA6 = aVar.c;
        g(xmlSerializer, "id", c15791kA6.f());
        g(xmlSerializer, "short_label", c15791kA6.n().toString());
        g(xmlSerializer, "rank", Integer.toString(c15791kA6.m()));
        if (!TextUtils.isEmpty(c15791kA6.k())) {
            g(xmlSerializer, "long_label", c15791kA6.k().toString());
        }
        if (!TextUtils.isEmpty(c15791kA6.d())) {
            g(xmlSerializer, "disabled_message", c15791kA6.d().toString());
        }
        if (c15791kA6.b() != null) {
            g(xmlSerializer, "component", c15791kA6.b().flattenToString());
        }
        if (!TextUtils.isEmpty(aVar.a)) {
            g(xmlSerializer, "icon_resource_name", aVar.a);
        }
        if (!TextUtils.isEmpty(aVar.b)) {
            g(xmlSerializer, "icon_bitmap_path", aVar.b);
        }
        for (Intent intent : c15791kA6.g()) {
            i(xmlSerializer, intent);
        }
        Iterator it = c15791kA6.c().iterator();
        while (it.hasNext()) {
            h(xmlSerializer, (String) it.next());
        }
        xmlSerializer.endTag(null, "target");
    }
}
