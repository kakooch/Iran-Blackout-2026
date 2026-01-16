package androidx.constraintlayout.motion.widget;

import android.content.Context;
import android.util.Log;
import android.util.Xml;
import androidx.constraintlayout.widget.ConstraintLayout;
import ir.nasim.AbstractC19117po3;
import ir.nasim.AbstractC7403Ro3;
import ir.nasim.AbstractC7637So3;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* loaded from: classes2.dex */
public class c {
    static HashMap b;
    private HashMap a = new HashMap();

    static {
        HashMap map = new HashMap();
        b = map;
        try {
            map.put("KeyAttribute", b.class.getConstructor(null));
            b.put("KeyPosition", d.class.getConstructor(null));
            b.put("KeyCycle", AbstractC19117po3.class.getConstructor(null));
            b.put("KeyTimeCycle", AbstractC7403Ro3.class.getConstructor(null));
            b.put("KeyTrigger", AbstractC7637So3.class.getConstructor(null));
        } catch (NoSuchMethodException e) {
            Log.e("KeyFrames", "unable to load", e);
        }
    }

    public c() {
    }

    public void a(g gVar) {
        ArrayList arrayList = (ArrayList) this.a.get(-1);
        if (arrayList != null) {
            gVar.b(arrayList);
        }
    }

    public void b(g gVar) {
        ArrayList arrayList = (ArrayList) this.a.get(Integer.valueOf(gVar.c));
        if (arrayList != null) {
            gVar.b(arrayList);
        }
        ArrayList arrayList2 = (ArrayList) this.a.get(-1);
        if (arrayList2 != null) {
            Iterator it = arrayList2.iterator();
            while (it.hasNext()) {
                a aVar = (a) it.next();
                if (aVar.f(((ConstraintLayout.LayoutParams) gVar.b.getLayoutParams()).b0)) {
                    gVar.a(aVar);
                }
            }
        }
    }

    public void c(a aVar) {
        if (!this.a.containsKey(Integer.valueOf(aVar.b))) {
            this.a.put(Integer.valueOf(aVar.b), new ArrayList());
        }
        ArrayList arrayList = (ArrayList) this.a.get(Integer.valueOf(aVar.b));
        if (arrayList != null) {
            arrayList.add(aVar);
        }
    }

    public ArrayList d(int i) {
        return (ArrayList) this.a.get(Integer.valueOf(i));
    }

    public c(Context context, XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        Exception e;
        a aVar;
        Constructor constructor;
        HashMap map;
        HashMap map2;
        try {
            int eventType = xmlPullParser.getEventType();
            a aVar2 = null;
            while (eventType != 1) {
                if (eventType != 2) {
                    if (eventType == 3 && "KeyFrameSet".equals(xmlPullParser.getName())) {
                        return;
                    }
                } else {
                    String name = xmlPullParser.getName();
                    if (b.containsKey(name)) {
                        try {
                            constructor = (Constructor) b.get(name);
                        } catch (Exception e2) {
                            a aVar3 = aVar2;
                            e = e2;
                            aVar = aVar3;
                        }
                        if (constructor != null) {
                            aVar = (a) constructor.newInstance(null);
                            try {
                                aVar.e(context, Xml.asAttributeSet(xmlPullParser));
                                c(aVar);
                            } catch (Exception e3) {
                                e = e3;
                                Log.e("KeyFrames", "unable to create ", e);
                                aVar2 = aVar;
                                eventType = xmlPullParser.next();
                            }
                            aVar2 = aVar;
                        } else {
                            StringBuilder sb = new StringBuilder(String.valueOf(name).length() + 23);
                            sb.append("Keymaker for ");
                            sb.append(name);
                            sb.append(" not found");
                            throw new NullPointerException(sb.toString());
                        }
                    } else if (name.equalsIgnoreCase("CustomAttribute")) {
                        if (aVar2 != null && (map2 = aVar2.e) != null) {
                            androidx.constraintlayout.widget.a.g(context, xmlPullParser, map2);
                        }
                    } else if (name.equalsIgnoreCase("CustomMethod") && aVar2 != null && (map = aVar2.e) != null) {
                        androidx.constraintlayout.widget.a.g(context, xmlPullParser, map);
                    }
                }
                eventType = xmlPullParser.next();
            }
        } catch (IOException e4) {
            e4.printStackTrace();
        } catch (XmlPullParserException e5) {
            e5.printStackTrace();
        }
    }
}
