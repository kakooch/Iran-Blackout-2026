package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.gov.nist.core.Separators;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.util.TypedValue;
import android.util.Xml;
import android.view.View;
import ir.nasim.OA1;
import ir.nasim.SE5;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import org.xmlpull.v1.XmlPullParser;

/* loaded from: classes2.dex */
public class a {
    private boolean a;
    String b;
    private b c;
    private int d;
    private float e;
    private String f;
    boolean g;
    private int h;

    /* renamed from: androidx.constraintlayout.widget.a$a, reason: collision with other inner class name */
    static /* synthetic */ class C0075a {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[b.values().length];
            a = iArr;
            try {
                iArr[b.REFERENCE_TYPE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[b.BOOLEAN_TYPE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[b.STRING_TYPE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[b.COLOR_TYPE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                a[b.COLOR_DRAWABLE_TYPE.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                a[b.INT_TYPE.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                a[b.FLOAT_TYPE.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                a[b.DIMENSION_TYPE.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
        }
    }

    public enum b {
        INT_TYPE,
        FLOAT_TYPE,
        COLOR_TYPE,
        COLOR_DRAWABLE_TYPE,
        STRING_TYPE,
        BOOLEAN_TYPE,
        DIMENSION_TYPE,
        REFERENCE_TYPE
    }

    public a(String str, b bVar, Object obj, boolean z) {
        this.b = str;
        this.c = bVar;
        this.a = z;
        j(obj);
    }

    private static int a(int i) {
        int i2 = (i & (~(i >> 31))) - 255;
        return (i2 & (i2 >> 31)) + 255;
    }

    public static HashMap b(HashMap map, View view) {
        HashMap map2 = new HashMap();
        Class<?> cls = view.getClass();
        for (String str : map.keySet()) {
            a aVar = (a) map.get(str);
            try {
                if (str.equals("BackgroundColor")) {
                    map2.put(str, new a(aVar, Integer.valueOf(((ColorDrawable) view.getBackground()).getColor())));
                } else {
                    map2.put(str, new a(aVar, cls.getMethod(str.length() != 0 ? "getMap".concat(str) : new String("getMap"), null).invoke(view, null)));
                }
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (NoSuchMethodException e2) {
                e2.printStackTrace();
            } catch (InvocationTargetException e3) {
                e3.printStackTrace();
            }
        }
        return map2;
    }

    public static void g(Context context, XmlPullParser xmlPullParser, HashMap map) {
        b bVar;
        Object objValueOf;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(Xml.asAttributeSet(xmlPullParser), SE5.CustomAttribute);
        int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
        String string = null;
        Object objValueOf2 = null;
        b bVar2 = null;
        boolean z = false;
        for (int i = 0; i < indexCount; i++) {
            int index = typedArrayObtainStyledAttributes.getIndex(i);
            if (index == SE5.CustomAttribute_attributeName) {
                string = typedArrayObtainStyledAttributes.getString(index);
                if (string != null && string.length() > 0) {
                    char upperCase = Character.toUpperCase(string.charAt(0));
                    String strSubstring = string.substring(1);
                    StringBuilder sb = new StringBuilder(String.valueOf(strSubstring).length() + 1);
                    sb.append(upperCase);
                    sb.append(strSubstring);
                    string = sb.toString();
                }
            } else if (index == SE5.CustomAttribute_methodName) {
                string = typedArrayObtainStyledAttributes.getString(index);
                z = true;
            } else if (index == SE5.CustomAttribute_customBoolean) {
                objValueOf2 = Boolean.valueOf(typedArrayObtainStyledAttributes.getBoolean(index, false));
                bVar2 = b.BOOLEAN_TYPE;
            } else {
                if (index == SE5.CustomAttribute_customColorValue) {
                    bVar = b.COLOR_TYPE;
                    objValueOf = Integer.valueOf(typedArrayObtainStyledAttributes.getColor(index, 0));
                } else if (index == SE5.CustomAttribute_customColorDrawableValue) {
                    bVar = b.COLOR_DRAWABLE_TYPE;
                    objValueOf = Integer.valueOf(typedArrayObtainStyledAttributes.getColor(index, 0));
                } else if (index == SE5.CustomAttribute_customPixelDimension) {
                    bVar = b.DIMENSION_TYPE;
                    objValueOf = Float.valueOf(TypedValue.applyDimension(1, typedArrayObtainStyledAttributes.getDimension(index, 0.0f), context.getResources().getDisplayMetrics()));
                } else if (index == SE5.CustomAttribute_customDimension) {
                    bVar = b.DIMENSION_TYPE;
                    objValueOf = Float.valueOf(typedArrayObtainStyledAttributes.getDimension(index, 0.0f));
                } else if (index == SE5.CustomAttribute_customFloatValue) {
                    bVar = b.FLOAT_TYPE;
                    objValueOf = Float.valueOf(typedArrayObtainStyledAttributes.getFloat(index, Float.NaN));
                } else if (index == SE5.CustomAttribute_customIntegerValue) {
                    bVar = b.INT_TYPE;
                    objValueOf = Integer.valueOf(typedArrayObtainStyledAttributes.getInteger(index, -1));
                } else if (index == SE5.CustomAttribute_customStringValue) {
                    bVar = b.STRING_TYPE;
                    objValueOf = typedArrayObtainStyledAttributes.getString(index);
                } else if (index == SE5.CustomAttribute_customReference) {
                    bVar = b.REFERENCE_TYPE;
                    int resourceId = typedArrayObtainStyledAttributes.getResourceId(index, -1);
                    if (resourceId == -1) {
                        resourceId = typedArrayObtainStyledAttributes.getInt(index, -1);
                    }
                    objValueOf = Integer.valueOf(resourceId);
                }
                Object obj = objValueOf;
                bVar2 = bVar;
                objValueOf2 = obj;
            }
        }
        if (string != null && objValueOf2 != null) {
            map.put(string, new a(string, bVar2, objValueOf2, z));
        }
        typedArrayObtainStyledAttributes.recycle();
    }

    public static void h(View view, HashMap map) throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        String strConcat;
        Class<?> cls = view.getClass();
        for (String str : map.keySet()) {
            a aVar = (a) map.get(str);
            if (aVar.a) {
                strConcat = str;
            } else {
                String strValueOf = String.valueOf(str);
                strConcat = strValueOf.length() != 0 ? "set".concat(strValueOf) : new String("set");
            }
            try {
                switch (C0075a.a[aVar.c.ordinal()]) {
                    case 1:
                        cls.getMethod(strConcat, Integer.TYPE).invoke(view, Integer.valueOf(aVar.d));
                        break;
                    case 2:
                        cls.getMethod(strConcat, Boolean.TYPE).invoke(view, Boolean.valueOf(aVar.g));
                        break;
                    case 3:
                        cls.getMethod(strConcat, CharSequence.class).invoke(view, aVar.f);
                        break;
                    case 4:
                        cls.getMethod(strConcat, Integer.TYPE).invoke(view, Integer.valueOf(aVar.h));
                        break;
                    case 5:
                        Method method = cls.getMethod(strConcat, Drawable.class);
                        ColorDrawable colorDrawable = new ColorDrawable();
                        colorDrawable.setColor(aVar.h);
                        method.invoke(view, colorDrawable);
                        break;
                    case 6:
                        cls.getMethod(strConcat, Integer.TYPE).invoke(view, Integer.valueOf(aVar.d));
                        break;
                    case 7:
                        cls.getMethod(strConcat, Float.TYPE).invoke(view, Float.valueOf(aVar.e));
                        break;
                    case 8:
                        cls.getMethod(strConcat, Float.TYPE).invoke(view, Float.valueOf(aVar.e));
                        break;
                }
            } catch (IllegalAccessException e) {
                String name = cls.getName();
                StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 34 + name.length());
                sb.append(" Custom Attribute \"");
                sb.append(str);
                sb.append("\" not found on ");
                sb.append(name);
                Log.e("TransitionLayout", sb.toString());
                e.printStackTrace();
            } catch (NoSuchMethodException e2) {
                Log.e("TransitionLayout", e2.getMessage());
                String name2 = cls.getName();
                StringBuilder sb2 = new StringBuilder(String.valueOf(str).length() + 34 + name2.length());
                sb2.append(" Custom Attribute \"");
                sb2.append(str);
                sb2.append("\" not found on ");
                sb2.append(name2);
                Log.e("TransitionLayout", sb2.toString());
                String name3 = cls.getName();
                StringBuilder sb3 = new StringBuilder(name3.length() + 20 + String.valueOf(strConcat).length());
                sb3.append(name3);
                sb3.append(" must have a method ");
                sb3.append(strConcat);
                Log.e("TransitionLayout", sb3.toString());
            } catch (InvocationTargetException e3) {
                String name4 = cls.getName();
                StringBuilder sb4 = new StringBuilder(String.valueOf(str).length() + 34 + name4.length());
                sb4.append(" Custom Attribute \"");
                sb4.append(str);
                sb4.append("\" not found on ");
                sb4.append(name4);
                Log.e("TransitionLayout", sb4.toString());
                e3.printStackTrace();
            }
        }
    }

    public float c() {
        switch (C0075a.a[this.c.ordinal()]) {
            case 2:
                return this.g ? 1.0f : 0.0f;
            case 3:
                throw new RuntimeException("Cannot interpolate String");
            case 4:
            case 5:
                throw new RuntimeException("Color does not have a single color to interpolate");
            case 6:
                return this.d;
            case 7:
                return this.e;
            case 8:
                return this.e;
            default:
                return Float.NaN;
        }
    }

    public void d(float[] fArr) {
        switch (C0075a.a[this.c.ordinal()]) {
            case 2:
                fArr[0] = this.g ? 1.0f : 0.0f;
                return;
            case 3:
                throw new RuntimeException("Color does not have a single color to interpolate");
            case 4:
            case 5:
                int i = (this.h >> 24) & 255;
                float fPow = (float) Math.pow(((r0 >> 16) & 255) / 255.0f, 2.2d);
                float fPow2 = (float) Math.pow(((r0 >> 8) & 255) / 255.0f, 2.2d);
                float fPow3 = (float) Math.pow((r0 & 255) / 255.0f, 2.2d);
                fArr[0] = fPow;
                fArr[1] = fPow2;
                fArr[2] = fPow3;
                fArr[3] = i / 255.0f;
                return;
            case 6:
                fArr[0] = this.d;
                return;
            case 7:
                fArr[0] = this.e;
                return;
            case 8:
                fArr[0] = this.e;
                return;
            default:
                return;
        }
    }

    public boolean e() {
        int i = C0075a.a[this.c.ordinal()];
        return (i == 1 || i == 2 || i == 3) ? false : true;
    }

    public int f() {
        int i = C0075a.a[this.c.ordinal()];
        return (i == 4 || i == 5) ? 4 : 1;
    }

    public void i(View view, float[] fArr) throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        Class<?> cls = view.getClass();
        String strValueOf = String.valueOf(this.b);
        String strConcat = strValueOf.length() != 0 ? "set".concat(strValueOf) : new String("set");
        try {
            boolean z = true;
            switch (C0075a.a[this.c.ordinal()]) {
                case 2:
                    Method method = cls.getMethod(strConcat, Boolean.TYPE);
                    if (fArr[0] <= 0.5f) {
                        z = false;
                    }
                    method.invoke(view, Boolean.valueOf(z));
                    return;
                case 3:
                    String strValueOf2 = String.valueOf(this.b);
                    throw new RuntimeException(strValueOf2.length() != 0 ? "unable to interpolate strings ".concat(strValueOf2) : new String("unable to interpolate strings "));
                case 4:
                    cls.getMethod(strConcat, Integer.TYPE).invoke(view, Integer.valueOf((a((int) (((float) Math.pow(fArr[0], 0.45454545454545453d)) * 255.0f)) << 16) | (a((int) (fArr[3] * 255.0f)) << 24) | (a((int) (((float) Math.pow(fArr[1], 0.45454545454545453d)) * 255.0f)) << 8) | a((int) (((float) Math.pow(fArr[2], 0.45454545454545453d)) * 255.0f))));
                    return;
                case 5:
                    Method method2 = cls.getMethod(strConcat, Drawable.class);
                    int iA = (a((int) (((float) Math.pow(fArr[0], 0.45454545454545453d)) * 255.0f)) << 16) | (a((int) (fArr[3] * 255.0f)) << 24) | (a((int) (((float) Math.pow(fArr[1], 0.45454545454545453d)) * 255.0f)) << 8) | a((int) (((float) Math.pow(fArr[2], 0.45454545454545453d)) * 255.0f));
                    ColorDrawable colorDrawable = new ColorDrawable();
                    colorDrawable.setColor(iA);
                    method2.invoke(view, colorDrawable);
                    return;
                case 6:
                    cls.getMethod(strConcat, Integer.TYPE).invoke(view, Integer.valueOf((int) fArr[0]));
                    return;
                case 7:
                    cls.getMethod(strConcat, Float.TYPE).invoke(view, Float.valueOf(fArr[0]));
                    return;
                case 8:
                    cls.getMethod(strConcat, Float.TYPE).invoke(view, Float.valueOf(fArr[0]));
                    return;
                default:
                    return;
            }
        } catch (IllegalAccessException e) {
            String strD = OA1.d(view);
            StringBuilder sb = new StringBuilder(String.valueOf(strConcat).length() + 32 + String.valueOf(strD).length());
            sb.append("cannot access method ");
            sb.append(strConcat);
            sb.append(" on View \"");
            sb.append(strD);
            sb.append(Separators.DOUBLE_QUOTE);
            Log.e("TransitionLayout", sb.toString());
            e.printStackTrace();
        } catch (NoSuchMethodException e2) {
            String strD2 = OA1.d(view);
            StringBuilder sb2 = new StringBuilder(String.valueOf(strConcat).length() + 21 + String.valueOf(strD2).length());
            sb2.append("no method ");
            sb2.append(strConcat);
            sb2.append(" on View \"");
            sb2.append(strD2);
            sb2.append(Separators.DOUBLE_QUOTE);
            Log.e("TransitionLayout", sb2.toString());
            e2.printStackTrace();
        } catch (InvocationTargetException e3) {
            e3.printStackTrace();
        }
    }

    public void j(Object obj) {
        switch (C0075a.a[this.c.ordinal()]) {
            case 1:
            case 6:
                this.d = ((Integer) obj).intValue();
                break;
            case 2:
                this.g = ((Boolean) obj).booleanValue();
                break;
            case 3:
                this.f = (String) obj;
                break;
            case 4:
            case 5:
                this.h = ((Integer) obj).intValue();
                break;
            case 7:
                this.e = ((Float) obj).floatValue();
                break;
            case 8:
                this.e = ((Float) obj).floatValue();
                break;
        }
    }

    public a(a aVar, Object obj) {
        this.a = false;
        this.b = aVar.b;
        this.c = aVar.c;
        j(obj);
    }
}
