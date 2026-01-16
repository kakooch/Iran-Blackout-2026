package ir.nasim;

import android.content.res.AssetManager;
import java.io.File;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* renamed from: ir.nasim.ji8, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C15516ji8 {
    private final Ug8 a;
    private XmlPullParser b;

    public C15516ji8(Ug8 ug8) {
        this.a = ug8;
    }

    public final long a() throws XmlPullParserException, IOException, NumberFormatException {
        if (this.b == null) {
            throw new XmlPullParserException("Manifest file needs to be loaded before parsing.");
        }
        while (true) {
            int next = this.b.next();
            if (next != 2) {
                if (next == 1) {
                    break;
                }
            } else if (this.b.getName().equals("manifest")) {
                String attributeValue = this.b.getAttributeValue("http://schemas.android.com/apk/res/android", "versionCode");
                String attributeValue2 = this.b.getAttributeValue("http://schemas.android.com/apk/res/android", "versionCodeMajor");
                if (attributeValue == null) {
                    throw new XmlPullParserException("Manifest entry doesn't contain 'versionCode' attribute.");
                }
                try {
                    int i = Integer.parseInt(attributeValue);
                    if (attributeValue2 == null) {
                        return i;
                    }
                    try {
                        return (Integer.parseInt(attributeValue2) << 32) | (i & 4294967295L);
                    } catch (NumberFormatException e) {
                        throw new XmlPullParserException(String.format("Couldn't parse versionCodeMajor to int: %s", e.getMessage()));
                    }
                } catch (NumberFormatException e2) {
                    throw new XmlPullParserException(String.format("Couldn't parse versionCode to int: %s", e2.getMessage()));
                }
            }
        }
        throw new XmlPullParserException("Couldn't find manifest entry at top-level.");
    }

    public final void b(AssetManager assetManager, File file) {
        this.b = assetManager.openXmlResourceParser(Ug8.b(assetManager, file), "AndroidManifest.xml");
    }
}
