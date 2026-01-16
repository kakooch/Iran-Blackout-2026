package androidx.sharetarget;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.util.Log;
import android.util.Xml;
import androidx.collection.ArrayMap;
import androidx.core.content.pm.ShortcutInfoCompat;
import androidx.core.util.AtomicFile;
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
import org.xmlpull.v1.XmlSerializer;

/* loaded from: classes.dex */
class ShortcutsInfoSerialization {

    static class ShortcutContainer {
        final String mBitmapPath;
        final String mResourceName;
        final ShortcutInfoCompat mShortcutInfo;

        ShortcutContainer(ShortcutInfoCompat shortcut, String resourceName, String bitmapPath) {
            this.mShortcutInfo = shortcut;
            this.mResourceName = resourceName;
            this.mBitmapPath = bitmapPath;
        }
    }

    static void saveAsXml(List<ShortcutContainer> shortcutsList, File output) throws IllegalStateException, IOException, IllegalArgumentException {
        FileOutputStream fileOutputStreamStartWrite;
        AtomicFile atomicFile = new AtomicFile(output);
        FileOutputStream fileOutputStream = null;
        try {
            fileOutputStreamStartWrite = atomicFile.startWrite();
        } catch (Exception e) {
            e = e;
        }
        try {
            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(fileOutputStreamStartWrite);
            XmlSerializer xmlSerializerNewSerializer = Xml.newSerializer();
            xmlSerializerNewSerializer.setOutput(bufferedOutputStream, "UTF_8");
            xmlSerializerNewSerializer.startDocument(null, Boolean.TRUE);
            xmlSerializerNewSerializer.startTag(null, "share_targets");
            Iterator<ShortcutContainer> it = shortcutsList.iterator();
            while (it.hasNext()) {
                serializeShortcutContainer(xmlSerializerNewSerializer, it.next());
            }
            xmlSerializerNewSerializer.endTag(null, "share_targets");
            xmlSerializerNewSerializer.endDocument();
            bufferedOutputStream.flush();
            fileOutputStreamStartWrite.flush();
            atomicFile.finishWrite(fileOutputStreamStartWrite);
        } catch (Exception e2) {
            e = e2;
            fileOutputStream = fileOutputStreamStartWrite;
            Log.e("ShortcutInfoCompatSaver", "Failed to write to file " + atomicFile.getBaseFile(), e);
            atomicFile.failWrite(fileOutputStream);
            throw new RuntimeException("Failed to write to file " + atomicFile.getBaseFile(), e);
        }
    }

    static Map<String, ShortcutContainer> loadFromXml(File input, Context context) throws IOException {
        FileInputStream fileInputStream;
        ShortcutContainer shortcutContainer;
        ShortcutInfoCompat shortcutInfoCompat;
        ArrayMap arrayMap = new ArrayMap();
        try {
            fileInputStream = new FileInputStream(input);
            try {
            } finally {
                try {
                    fileInputStream.close();
                } catch (Throwable unused) {
                }
            }
        } catch (Exception e) {
            input.delete();
            Log.e("ShortcutInfoCompatSaver", "Failed to load saved values from file " + input.getAbsolutePath() + ". Old state removed, new added", e);
        }
        if (!input.exists()) {
            return arrayMap;
        }
        XmlPullParser xmlPullParserNewPullParser = Xml.newPullParser();
        xmlPullParserNewPullParser.setInput(fileInputStream, "UTF_8");
        while (true) {
            int next = xmlPullParserNewPullParser.next();
            if (next == 1) {
                break;
            }
            if (next == 2 && xmlPullParserNewPullParser.getName().equals("target") && (shortcutContainer = parseShortcutContainer(xmlPullParserNewPullParser, context)) != null && (shortcutInfoCompat = shortcutContainer.mShortcutInfo) != null) {
                arrayMap.put(shortcutInfoCompat.getId(), shortcutContainer);
            }
        }
        fileInputStream.close();
        return arrayMap;
    }

    private static ShortcutContainer parseShortcutContainer(XmlPullParser parser, Context context) throws Exception {
        if (!parser.getName().equals("target")) {
            return null;
        }
        String attributeValue = getAttributeValue(parser, "id");
        String attributeValue2 = getAttributeValue(parser, "short_label");
        if (TextUtils.isEmpty(attributeValue) || TextUtils.isEmpty(attributeValue2)) {
            return null;
        }
        int i = Integer.parseInt(getAttributeValue(parser, "rank"));
        String attributeValue3 = getAttributeValue(parser, "long_label");
        String attributeValue4 = getAttributeValue(parser, "disabled_message");
        ComponentName componentName = parseComponentName(parser);
        String attributeValue5 = getAttributeValue(parser, "icon_resource_name");
        String attributeValue6 = getAttributeValue(parser, "icon_bitmap_path");
        ArrayList arrayList = new ArrayList();
        HashSet hashSet = new HashSet();
        while (true) {
            int next = parser.next();
            if (next != 1) {
                if (next == 2) {
                    String name = parser.getName();
                    name.hashCode();
                    if (name.equals("intent")) {
                        Intent intent = parseIntent(parser);
                        if (intent != null) {
                            arrayList.add(intent);
                        }
                    } else if (name.equals("categories")) {
                        String attributeValue7 = getAttributeValue(parser, "name");
                        if (!TextUtils.isEmpty(attributeValue7)) {
                            hashSet.add(attributeValue7);
                        }
                    }
                } else if (next == 3 && parser.getName().equals("target")) {
                    break;
                }
            } else {
                break;
            }
        }
        ShortcutInfoCompat.Builder rank = new ShortcutInfoCompat.Builder(context, attributeValue).setShortLabel(attributeValue2).setRank(i);
        if (!TextUtils.isEmpty(attributeValue3)) {
            rank.setLongLabel(attributeValue3);
        }
        if (!TextUtils.isEmpty(attributeValue4)) {
            rank.setDisabledMessage(attributeValue4);
        }
        if (componentName != null) {
            rank.setActivity(componentName);
        }
        if (!arrayList.isEmpty()) {
            rank.setIntents((Intent[]) arrayList.toArray(new Intent[0]));
        }
        if (!hashSet.isEmpty()) {
            rank.setCategories(hashSet);
        }
        return new ShortcutContainer(rank.build(), attributeValue5, attributeValue6);
    }

    private static ComponentName parseComponentName(XmlPullParser parser) {
        String attributeValue = getAttributeValue(parser, "component");
        if (TextUtils.isEmpty(attributeValue)) {
            return null;
        }
        return ComponentName.unflattenFromString(attributeValue);
    }

    private static Intent parseIntent(XmlPullParser parser) {
        String attributeValue = getAttributeValue(parser, "action");
        String attributeValue2 = getAttributeValue(parser, "targetPackage");
        String attributeValue3 = getAttributeValue(parser, "targetClass");
        if (attributeValue == null) {
            return null;
        }
        Intent intent = new Intent(attributeValue);
        if (!TextUtils.isEmpty(attributeValue2) && !TextUtils.isEmpty(attributeValue3)) {
            intent.setClassName(attributeValue2, attributeValue3);
        }
        return intent;
    }

    private static String getAttributeValue(XmlPullParser parser, String attribute) {
        String attributeValue = parser.getAttributeValue("http://schemas.android.com/apk/res/android", attribute);
        return attributeValue == null ? parser.getAttributeValue(null, attribute) : attributeValue;
    }

    private static void serializeShortcutContainer(XmlSerializer serializer, ShortcutContainer container) throws IllegalStateException, IOException, IllegalArgumentException {
        serializer.startTag(null, "target");
        ShortcutInfoCompat shortcutInfoCompat = container.mShortcutInfo;
        serializeAttribute(serializer, "id", shortcutInfoCompat.getId());
        serializeAttribute(serializer, "short_label", shortcutInfoCompat.getShortLabel().toString());
        serializeAttribute(serializer, "rank", Integer.toString(shortcutInfoCompat.getRank()));
        if (!TextUtils.isEmpty(shortcutInfoCompat.getLongLabel())) {
            serializeAttribute(serializer, "long_label", shortcutInfoCompat.getLongLabel().toString());
        }
        if (!TextUtils.isEmpty(shortcutInfoCompat.getDisabledMessage())) {
            serializeAttribute(serializer, "disabled_message", shortcutInfoCompat.getDisabledMessage().toString());
        }
        if (shortcutInfoCompat.getActivity() != null) {
            serializeAttribute(serializer, "component", shortcutInfoCompat.getActivity().flattenToString());
        }
        if (!TextUtils.isEmpty(container.mResourceName)) {
            serializeAttribute(serializer, "icon_resource_name", container.mResourceName);
        }
        if (!TextUtils.isEmpty(container.mBitmapPath)) {
            serializeAttribute(serializer, "icon_bitmap_path", container.mBitmapPath);
        }
        for (Intent intent : shortcutInfoCompat.getIntents()) {
            serializeIntent(serializer, intent);
        }
        Iterator<String> it = shortcutInfoCompat.getCategories().iterator();
        while (it.hasNext()) {
            serializeCategory(serializer, it.next());
        }
        serializer.endTag(null, "target");
    }

    private static void serializeIntent(XmlSerializer serializer, Intent intent) throws IllegalStateException, IOException, IllegalArgumentException {
        serializer.startTag(null, "intent");
        serializeAttribute(serializer, "action", intent.getAction());
        if (intent.getComponent() != null) {
            serializeAttribute(serializer, "targetPackage", intent.getComponent().getPackageName());
            serializeAttribute(serializer, "targetClass", intent.getComponent().getClassName());
        }
        serializer.endTag(null, "intent");
    }

    private static void serializeCategory(XmlSerializer serializer, String category) throws IllegalStateException, IOException, IllegalArgumentException {
        if (TextUtils.isEmpty(category)) {
            return;
        }
        serializer.startTag(null, "categories");
        serializeAttribute(serializer, "name", category);
        serializer.endTag(null, "categories");
    }

    private static void serializeAttribute(XmlSerializer serializer, String attribute, String value) throws IllegalStateException, IOException, IllegalArgumentException {
        if (TextUtils.isEmpty(value)) {
            return;
        }
        serializer.attribute(null, attribute, value);
    }
}
