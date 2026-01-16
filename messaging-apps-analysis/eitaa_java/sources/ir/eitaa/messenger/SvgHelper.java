package ir.eitaa.messenger;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.ComposeShader;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.SystemClock;
import ir.eitaa.messenger.SvgHelper;
import ir.eitaa.ui.ActionBar.Theme;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringReader;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.Attributes;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.DefaultHandler;

/* loaded from: classes.dex */
public class SvgHelper {
    private static final double[] pow10 = new double[128];

    private static void drawArc(Path p, float lastX, float lastY, float x, float y, float rx, float ry, float theta, int largeArc, int sweepArc) {
    }

    private static class Line {
        float x1;
        float x2;
        float y1;
        float y2;

        public Line(float x1, float y1, float x2, float y2) {
            this.x1 = x1;
            this.y1 = y1;
            this.x2 = x2;
            this.y2 = y2;
        }
    }

    private static class Circle {
        float rad;
        float x1;
        float y1;

        public Circle(float x1, float y1, float rad) {
            this.x1 = x1;
            this.y1 = y1;
            this.rad = rad;
        }
    }

    private static class Oval {
        RectF rect;

        public Oval(RectF rect) {
            this.rect = rect;
        }
    }

    private static class RoundRect {
        RectF rect;
        float rx;

        public RoundRect(RectF rect, float rx) {
            this.rect = rect;
            this.rx = rx;
        }
    }

    public static class SvgDrawable extends Drawable {
        private static float gradientWidth;
        private static long lastUpdateTime;
        private static int[] parentPosition = new int[2];
        private static WeakReference<Drawable> shiftDrawable;
        private static Runnable shiftRunnable;
        private static float totalTranslation;
        private Bitmap backgroundBitmap;
        private Canvas backgroundCanvas;
        private float colorAlpha;
        private int currentColor;
        private String currentColorKey;
        protected int height;
        private ImageReceiver parentImageReceiver;
        private LinearGradient placeholderGradient;
        private Matrix placeholderMatrix;
        protected int width;
        protected ArrayList<Object> commands = new ArrayList<>();
        protected HashMap<Object, Paint> paints = new HashMap<>();
        private float crossfadeAlpha = 1.0f;
        private boolean aspectFill = true;

        @Override // android.graphics.drawable.Drawable
        public int getOpacity() {
            return -2;
        }

        @Override // android.graphics.drawable.Drawable
        public void setColorFilter(ColorFilter colorFilter) {
        }

        @Override // android.graphics.drawable.Drawable
        public int getIntrinsicHeight() {
            return this.width;
        }

        @Override // android.graphics.drawable.Drawable
        public int getIntrinsicWidth() {
            return this.height;
        }

        public void setAspectFill(boolean value) {
            this.aspectFill = value;
        }

        public void overrideWidthAndHeight(int w, int h) {
            this.width = w;
            this.height = h;
        }

        @Override // android.graphics.drawable.Drawable
        public void draw(Canvas canvas) {
            String str = this.currentColorKey;
            if (str != null) {
                setupGradient(str, this.colorAlpha);
            }
            Rect bounds = getBounds();
            float fWidth = bounds.width() / this.width;
            float fHeight = bounds.height() / this.height;
            float fMax = this.aspectFill ? Math.max(fWidth, fHeight) : Math.min(fWidth, fHeight);
            canvas.save();
            canvas.translate(bounds.left, bounds.top);
            if (!this.aspectFill) {
                canvas.translate((bounds.width() - (this.width * fMax)) / 2.0f, (bounds.height() - (this.height * fMax)) / 2.0f);
            }
            canvas.scale(fMax, fMax);
            int size = this.commands.size();
            for (int i = 0; i < size; i++) {
                Object obj = this.commands.get(i);
                if (obj instanceof Matrix) {
                    canvas.save();
                    canvas.concat((Matrix) obj);
                } else if (obj == null) {
                    canvas.restore();
                } else {
                    Paint paint = this.paints.get(obj);
                    int alpha = paint.getAlpha();
                    paint.setAlpha((int) (this.crossfadeAlpha * alpha));
                    if (obj instanceof Path) {
                        canvas.drawPath((Path) obj, paint);
                    } else if (obj instanceof Rect) {
                        canvas.drawRect((Rect) obj, paint);
                    } else if (obj instanceof RectF) {
                        canvas.drawRect((RectF) obj, paint);
                    } else if (obj instanceof Line) {
                        Line line = (Line) obj;
                        canvas.drawLine(line.x1, line.y1, line.x2, line.y2, paint);
                    } else if (obj instanceof Circle) {
                        Circle circle = (Circle) obj;
                        canvas.drawCircle(circle.x1, circle.y1, circle.rad, paint);
                    } else if (obj instanceof Oval) {
                        canvas.drawOval(((Oval) obj).rect, paint);
                    } else if (obj instanceof RoundRect) {
                        RoundRect roundRect = (RoundRect) obj;
                        RectF rectF = roundRect.rect;
                        float f = roundRect.rx;
                        canvas.drawRoundRect(rectF, f, f, paint);
                    }
                    paint.setAlpha(alpha);
                }
            }
            canvas.restore();
            if (this.placeholderGradient != null) {
                if (shiftRunnable == null || shiftDrawable.get() == this) {
                    long jElapsedRealtime = SystemClock.elapsedRealtime();
                    long jAbs = Math.abs(lastUpdateTime - jElapsedRealtime);
                    if (jAbs > 17) {
                        jAbs = 16;
                    }
                    lastUpdateTime = jElapsedRealtime;
                    totalTranslation += (jAbs * gradientWidth) / 1800.0f;
                    while (true) {
                        float f2 = totalTranslation;
                        float f3 = gradientWidth;
                        if (f2 < f3 / 2.0f) {
                            break;
                        } else {
                            totalTranslation = f2 - f3;
                        }
                    }
                    shiftDrawable = new WeakReference<>(this);
                    Runnable runnable = shiftRunnable;
                    if (runnable != null) {
                        AndroidUtilities.cancelRunOnUIThread(runnable);
                    }
                    $$Lambda$SvgHelper$SvgDrawable$cQfHQszYYf5bfZZEnuEh_LcjLg __lambda_svghelper_svgdrawable_cqfhqszyyf5bfzzenueh_lcjlg = new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$SvgHelper$SvgDrawable$cQfHQszYYf5bfZZEnuEh_Lcj-Lg
                        @Override // java.lang.Runnable
                        public final void run() {
                            SvgHelper.SvgDrawable.shiftRunnable = null;
                        }
                    };
                    shiftRunnable = __lambda_svghelper_svgdrawable_cqfhqszyyf5bfzzenueh_lcjlg;
                    AndroidUtilities.runOnUIThread(__lambda_svghelper_svgdrawable_cqfhqszyyf5bfzzenueh_lcjlg, ((int) (1000.0f / AndroidUtilities.screenRefreshRate)) - 1);
                }
                ImageReceiver imageReceiver = this.parentImageReceiver;
                if (imageReceiver != null) {
                    imageReceiver.getParentPosition(parentPosition);
                }
                this.placeholderMatrix.reset();
                this.placeholderMatrix.postTranslate(((-parentPosition[0]) + totalTranslation) - bounds.left, 0.0f);
                float f4 = 1.0f / fMax;
                this.placeholderMatrix.postScale(f4, f4);
                this.placeholderGradient.setLocalMatrix(this.placeholderMatrix);
                ImageReceiver imageReceiver2 = this.parentImageReceiver;
                if (imageReceiver2 != null) {
                    imageReceiver2.invalidate();
                }
            }
        }

        @Override // android.graphics.drawable.Drawable
        public void setAlpha(int alpha) {
            this.crossfadeAlpha = alpha / 255.0f;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addCommand(Object command, Paint paint) {
            this.commands.add(command);
            this.paints.put(command, new Paint(paint));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addCommand(Object command) {
            this.commands.add(command);
        }

        public void setParent(ImageReceiver imageReceiver) {
            this.parentImageReceiver = imageReceiver;
        }

        public void setupGradient(String colorKey, float alpha) {
            Shader bitmapShader;
            int color = Theme.getColor(colorKey);
            if (this.currentColor != color) {
                this.colorAlpha = alpha;
                this.currentColorKey = colorKey;
                this.currentColor = color;
                gradientWidth = AndroidUtilities.displaySize.x * 2;
                float fDp = AndroidUtilities.dp(180.0f) / gradientWidth;
                int iArgb = Color.argb((int) ((Color.alpha(color) / 2) * this.colorAlpha), Color.red(color), Color.green(color), Color.blue(color));
                float f = (1.0f - fDp) / 2.0f;
                float f2 = fDp / 2.0f;
                this.placeholderGradient = new LinearGradient(0.0f, 0.0f, gradientWidth, 0.0f, new int[]{0, 0, iArgb, 0, 0}, new float[]{0.0f, f - f2, f, f + f2, 1.0f}, Shader.TileMode.REPEAT);
                if (Build.VERSION.SDK_INT >= 28) {
                    bitmapShader = new LinearGradient(0.0f, 0.0f, gradientWidth, 0.0f, new int[]{iArgb, iArgb}, (float[]) null, Shader.TileMode.REPEAT);
                } else {
                    if (this.backgroundBitmap == null) {
                        this.backgroundBitmap = Bitmap.createBitmap(1, 1, Bitmap.Config.ARGB_8888);
                        this.backgroundCanvas = new Canvas(this.backgroundBitmap);
                    }
                    this.backgroundCanvas.drawColor(iArgb);
                    Bitmap bitmap = this.backgroundBitmap;
                    Shader.TileMode tileMode = Shader.TileMode.REPEAT;
                    bitmapShader = new BitmapShader(bitmap, tileMode, tileMode);
                }
                Matrix matrix = new Matrix();
                this.placeholderMatrix = matrix;
                this.placeholderGradient.setLocalMatrix(matrix);
                for (Paint paint : this.paints.values()) {
                    if (Build.VERSION.SDK_INT <= 22) {
                        paint.setShader(bitmapShader);
                    } else {
                        paint.setShader(new ComposeShader(this.placeholderGradient, bitmapShader, PorterDuff.Mode.ADD));
                    }
                }
            }
        }
    }

    public static Bitmap getBitmap(int res, int width, int height, int color) throws Resources.NotFoundException, IOException {
        try {
            InputStream inputStreamOpenRawResource = ApplicationLoader.applicationContext.getResources().openRawResource(res);
            try {
                XMLReader xMLReader = SAXParserFactory.newInstance().newSAXParser().getXMLReader();
                SVGHandler sVGHandler = new SVGHandler(width, height, Integer.valueOf(color), false);
                xMLReader.setContentHandler(sVGHandler);
                xMLReader.parse(new InputSource(inputStreamOpenRawResource));
                Bitmap bitmap = sVGHandler.getBitmap();
                if (inputStreamOpenRawResource != null) {
                    inputStreamOpenRawResource.close();
                }
                return bitmap;
            } catch (Throwable th) {
                if (inputStreamOpenRawResource != null) {
                    try {
                        inputStreamOpenRawResource.close();
                    } catch (Throwable unused) {
                    }
                }
                throw th;
            }
        } catch (Exception e) {
            FileLog.e(e);
            return null;
        }
    }

    public static Bitmap getBitmap(File file, int width, int height, boolean white) {
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            try {
                XMLReader xMLReader = SAXParserFactory.newInstance().newSAXParser().getXMLReader();
                SVGHandler sVGHandler = new SVGHandler(width, height, white ? -1 : null, false);
                xMLReader.setContentHandler(sVGHandler);
                xMLReader.parse(new InputSource(fileInputStream));
                Bitmap bitmap = sVGHandler.getBitmap();
                fileInputStream.close();
                return bitmap;
            } catch (Throwable th) {
                try {
                    fileInputStream.close();
                } catch (Throwable unused) {
                }
                throw th;
            }
        } catch (Exception e) {
            FileLog.e(e);
            return null;
        }
    }

    public static Bitmap getBitmap(String xml, int width, int height, boolean white) throws SAXException, IOException {
        try {
            XMLReader xMLReader = SAXParserFactory.newInstance().newSAXParser().getXMLReader();
            SVGHandler sVGHandler = new SVGHandler(width, height, white ? -1 : null, false);
            xMLReader.setContentHandler(sVGHandler);
            xMLReader.parse(new InputSource(new StringReader(xml)));
            return sVGHandler.getBitmap();
        } catch (Exception e) {
            FileLog.e(e);
            return null;
        }
    }

    public static SvgDrawable getDrawable(String xml) throws SAXException, IOException {
        try {
            XMLReader xMLReader = SAXParserFactory.newInstance().newSAXParser().getXMLReader();
            SVGHandler sVGHandler = new SVGHandler(0, 0, null, true);
            xMLReader.setContentHandler(sVGHandler);
            xMLReader.parse(new InputSource(new StringReader(xml)));
            return sVGHandler.getDrawable();
        } catch (Exception e) {
            FileLog.e(e);
            return null;
        }
    }

    public static SvgDrawable getDrawable(int resId, int color) throws SAXException, IOException {
        try {
            XMLReader xMLReader = SAXParserFactory.newInstance().newSAXParser().getXMLReader();
            SVGHandler sVGHandler = new SVGHandler(0, 0, Integer.valueOf(color), true);
            xMLReader.setContentHandler(sVGHandler);
            xMLReader.parse(new InputSource(ApplicationLoader.applicationContext.getResources().openRawResource(resId)));
            return sVGHandler.getDrawable();
        } catch (Exception e) {
            FileLog.e(e);
            return null;
        }
    }

    public static SvgDrawable getDrawableByPath(String pathString, int w, int h) {
        try {
            Path pathDoPath = doPath(pathString);
            SvgDrawable svgDrawable = new SvgDrawable();
            svgDrawable.commands.add(pathDoPath);
            svgDrawable.paints.put(pathDoPath, new Paint(1));
            svgDrawable.width = w;
            svgDrawable.height = h;
            return svgDrawable;
        } catch (Exception e) {
            FileLog.e(e);
            return null;
        }
    }

    public static Bitmap getBitmapByPathOnly(String pathString, int svgWidth, int svgHeight, int width, int height) {
        try {
            Path pathDoPath = doPath(pathString);
            Bitmap bitmapCreateBitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
            Canvas canvas = new Canvas(bitmapCreateBitmap);
            canvas.scale(width / svgWidth, height / svgHeight);
            Paint paint = new Paint();
            paint.setColor(-1);
            canvas.drawPath(pathDoPath, paint);
            return bitmapCreateBitmap;
        } catch (Exception e) {
            FileLog.e(e);
            return null;
        }
    }

    private static NumberParse parseNumbers(String s) {
        int length = s.length();
        ArrayList arrayList = new ArrayList();
        int length2 = 0;
        boolean z = false;
        for (int i = 1; i < length; i++) {
            if (z) {
                z = false;
            } else {
                char cCharAt = s.charAt(i);
                switch (cCharAt) {
                    case '\t':
                    case '\n':
                    case ' ':
                    case R.styleable.AppCompatTheme_buttonStyle /* 44 */:
                    case R.styleable.AppCompatTheme_buttonStyleSmall /* 45 */:
                        if (cCharAt != '-' || s.charAt(i - 1) != 'e') {
                            String strSubstring = s.substring(length2, i);
                            if (strSubstring.trim().length() > 0) {
                                arrayList.add(Float.valueOf(Float.parseFloat(strSubstring)));
                                if (cCharAt == '-') {
                                    length2 = i;
                                    break;
                                } else {
                                    length2 = i + 1;
                                    z = true;
                                    break;
                                }
                            } else {
                                length2++;
                                break;
                            }
                        } else {
                            break;
                        }
                    case R.styleable.AppCompatTheme_buttonBarNeutralButtonStyle /* 41 */:
                    case 'A':
                    case R.styleable.AppCompatTheme_editTextColor /* 67 */:
                    case 'H':
                    case R.styleable.AppCompatTheme_listPreferredItemHeightLarge /* 76 */:
                    case R.styleable.AppCompatTheme_listPreferredItemHeightSmall /* 77 */:
                    case R.styleable.AppCompatTheme_panelMenuListTheme /* 81 */:
                    case R.styleable.AppCompatTheme_popupMenuStyle /* 83 */:
                    case R.styleable.AppCompatTheme_popupWindowStyle /* 84 */:
                    case R.styleable.AppCompatTheme_ratingBarStyle /* 86 */:
                    case R.styleable.AppCompatTheme_seekBarStyle /* 90 */:
                    case R.styleable.AppCompatTheme_textAppearanceListItem /* 97 */:
                    case R.styleable.AppCompatTheme_textAppearanceListItemSmall /* 99 */:
                    case R.styleable.AppCompatTheme_textColorAlertDialogListItem /* 104 */:
                    case R.styleable.AppCompatTheme_tooltipForegroundColor /* 108 */:
                    case R.styleable.AppCompatTheme_tooltipFrameBackground /* 109 */:
                    case R.styleable.AppCompatTheme_windowActionModeOverlay /* 113 */:
                    case R.styleable.AppCompatTheme_windowFixedHeightMinor /* 115 */:
                    case R.styleable.AppCompatTheme_windowFixedWidthMajor /* 116 */:
                    case R.styleable.AppCompatTheme_windowMinWidthMajor /* 118 */:
                    case 'z':
                        String strSubstring2 = s.substring(length2, i);
                        if (strSubstring2.trim().length() > 0) {
                            arrayList.add(Float.valueOf(Float.parseFloat(strSubstring2)));
                        }
                        return new NumberParse(arrayList, i);
                }
            }
        }
        String strSubstring3 = s.substring(length2);
        if (strSubstring3.length() > 0) {
            try {
                arrayList.add(Float.valueOf(Float.parseFloat(strSubstring3)));
            } catch (NumberFormatException unused) {
            }
            length2 = s.length();
        }
        return new NumberParse(arrayList, length2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Matrix parseTransform(String s) {
        float fFloatValue;
        if (s.startsWith("matrix(")) {
            NumberParse numbers = parseNumbers(s.substring(7));
            if (numbers.numbers.size() != 6) {
                return null;
            }
            Matrix matrix = new Matrix();
            matrix.setValues(new float[]{((Float) numbers.numbers.get(0)).floatValue(), ((Float) numbers.numbers.get(2)).floatValue(), ((Float) numbers.numbers.get(4)).floatValue(), ((Float) numbers.numbers.get(1)).floatValue(), ((Float) numbers.numbers.get(3)).floatValue(), ((Float) numbers.numbers.get(5)).floatValue(), 0.0f, 0.0f, 1.0f});
            return matrix;
        }
        if (s.startsWith("translate(")) {
            NumberParse numbers2 = parseNumbers(s.substring(10));
            if (numbers2.numbers.size() <= 0) {
                return null;
            }
            float fFloatValue2 = ((Float) numbers2.numbers.get(0)).floatValue();
            fFloatValue = numbers2.numbers.size() > 1 ? ((Float) numbers2.numbers.get(1)).floatValue() : 0.0f;
            Matrix matrix2 = new Matrix();
            matrix2.postTranslate(fFloatValue2, fFloatValue);
            return matrix2;
        }
        if (s.startsWith("scale(")) {
            NumberParse numbers3 = parseNumbers(s.substring(6));
            if (numbers3.numbers.size() <= 0) {
                return null;
            }
            float fFloatValue3 = ((Float) numbers3.numbers.get(0)).floatValue();
            fFloatValue = numbers3.numbers.size() > 1 ? ((Float) numbers3.numbers.get(1)).floatValue() : 0.0f;
            Matrix matrix3 = new Matrix();
            matrix3.postScale(fFloatValue3, fFloatValue);
            return matrix3;
        }
        if (s.startsWith("skewX(")) {
            NumberParse numbers4 = parseNumbers(s.substring(6));
            if (numbers4.numbers.size() <= 0) {
                return null;
            }
            float fFloatValue4 = ((Float) numbers4.numbers.get(0)).floatValue();
            Matrix matrix4 = new Matrix();
            matrix4.postSkew((float) Math.tan(fFloatValue4), 0.0f);
            return matrix4;
        }
        if (s.startsWith("skewY(")) {
            NumberParse numbers5 = parseNumbers(s.substring(6));
            if (numbers5.numbers.size() <= 0) {
                return null;
            }
            float fFloatValue5 = ((Float) numbers5.numbers.get(0)).floatValue();
            Matrix matrix5 = new Matrix();
            matrix5.postSkew(0.0f, (float) Math.tan(fFloatValue5));
            return matrix5;
        }
        if (!s.startsWith("rotate(")) {
            return null;
        }
        NumberParse numbers6 = parseNumbers(s.substring(7));
        if (numbers6.numbers.size() <= 0) {
            return null;
        }
        float fFloatValue6 = ((Float) numbers6.numbers.get(0)).floatValue();
        if (numbers6.numbers.size() > 2) {
            fFloatValue = ((Float) numbers6.numbers.get(1)).floatValue();
            fFloatValue = ((Float) numbers6.numbers.get(2)).floatValue();
        } else {
            fFloatValue = 0.0f;
        }
        Matrix matrix6 = new Matrix();
        matrix6.postTranslate(fFloatValue, fFloatValue);
        matrix6.postRotate(fFloatValue6);
        matrix6.postTranslate(-fFloatValue, -fFloatValue);
        return matrix6;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:11:0x003b  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0067 A[FALL_THROUGH] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static android.graphics.Path doPath(java.lang.String r23) {
        /*
            Method dump skipped, instructions count: 500
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.messenger.SvgHelper.doPath(java.lang.String):android.graphics.Path");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static NumberParse getNumberParseAttr(String name, Attributes attributes) {
        int length = attributes.getLength();
        for (int i = 0; i < length; i++) {
            if (attributes.getLocalName(i).equals(name)) {
                return parseNumbers(attributes.getValue(i));
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String getStringAttr(String name, Attributes attributes) {
        int length = attributes.getLength();
        for (int i = 0; i < length; i++) {
            if (attributes.getLocalName(i).equals(name)) {
                return attributes.getValue(i);
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Float getFloatAttr(String name, Attributes attributes) {
        return getFloatAttr(name, attributes, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Float getFloatAttr(String name, Attributes attributes, Float defaultValue) {
        String stringAttr = getStringAttr(name, attributes);
        if (stringAttr == null) {
            return defaultValue;
        }
        if (stringAttr.endsWith("px")) {
            stringAttr = stringAttr.substring(0, stringAttr.length() - 2);
        } else if (stringAttr.endsWith("mm")) {
            return null;
        }
        return Float.valueOf(Float.parseFloat(stringAttr));
    }

    private static Integer getHexAttr(String name, Attributes attributes) {
        String stringAttr = getStringAttr(name, attributes);
        if (stringAttr == null) {
            return null;
        }
        try {
            return Integer.valueOf(Integer.parseInt(stringAttr.substring(1), 16));
        } catch (NumberFormatException unused) {
            return getColorByName(stringAttr);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:4:0x000f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.lang.Integer getColorByName(java.lang.String r2) {
        /*
            java.lang.String r2 = r2.toLowerCase()
            r2.hashCode()
            int r0 = r2.hashCode()
            r1 = -1
            switch(r0) {
                case -734239628: goto L6d;
                case 112785: goto L62;
                case 3027034: goto L57;
                case 3068707: goto L4c;
                case 3181155: goto L41;
                case 93818879: goto L36;
                case 98619139: goto L2b;
                case 113101865: goto L1f;
                case 828922025: goto L12;
                default: goto Lf;
            }
        Lf:
            r2 = -1
            goto L78
        L12:
            java.lang.String r0 = "magenta"
            boolean r2 = r2.equals(r0)
            if (r2 != 0) goto L1b
            goto Lf
        L1b:
            r2 = 8
            goto L78
        L1f:
            java.lang.String r0 = "white"
            boolean r2 = r2.equals(r0)
            if (r2 != 0) goto L29
            goto Lf
        L29:
            r2 = 7
            goto L78
        L2b:
            java.lang.String r0 = "green"
            boolean r2 = r2.equals(r0)
            if (r2 != 0) goto L34
            goto Lf
        L34:
            r2 = 6
            goto L78
        L36:
            java.lang.String r0 = "black"
            boolean r2 = r2.equals(r0)
            if (r2 != 0) goto L3f
            goto Lf
        L3f:
            r2 = 5
            goto L78
        L41:
            java.lang.String r0 = "gray"
            boolean r2 = r2.equals(r0)
            if (r2 != 0) goto L4a
            goto Lf
        L4a:
            r2 = 4
            goto L78
        L4c:
            java.lang.String r0 = "cyan"
            boolean r2 = r2.equals(r0)
            if (r2 != 0) goto L55
            goto Lf
        L55:
            r2 = 3
            goto L78
        L57:
            java.lang.String r0 = "blue"
            boolean r2 = r2.equals(r0)
            if (r2 != 0) goto L60
            goto Lf
        L60:
            r2 = 2
            goto L78
        L62:
            java.lang.String r0 = "red"
            boolean r2 = r2.equals(r0)
            if (r2 != 0) goto L6b
            goto Lf
        L6b:
            r2 = 1
            goto L78
        L6d:
            java.lang.String r0 = "yellow"
            boolean r2 = r2.equals(r0)
            if (r2 != 0) goto L77
            goto Lf
        L77:
            r2 = 0
        L78:
            switch(r2) {
                case 0: goto Lb8;
                case 1: goto Lb1;
                case 2: goto La9;
                case 3: goto La1;
                case 4: goto L99;
                case 5: goto L92;
                case 6: goto L8a;
                case 7: goto L85;
                case 8: goto L7d;
                default: goto L7b;
            }
        L7b:
            r2 = 0
            return r2
        L7d:
            r2 = -65281(0xffffffffffff00ff, float:NaN)
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            return r2
        L85:
            java.lang.Integer r2 = java.lang.Integer.valueOf(r1)
            return r2
        L8a:
            r2 = -16711936(0xffffffffff00ff00, float:-1.7146522E38)
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            return r2
        L92:
            r2 = -16777216(0xffffffffff000000, float:-1.7014118E38)
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            return r2
        L99:
            r2 = -7829368(0xffffffffff888888, float:NaN)
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            return r2
        La1:
            r2 = -16711681(0xffffffffff00ffff, float:-1.714704E38)
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            return r2
        La9:
            r2 = -16776961(0xffffffffff0000ff, float:-1.7014636E38)
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            return r2
        Lb1:
            r2 = -65536(0xffffffffffff0000, float:NaN)
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            return r2
        Lb8:
            r2 = -256(0xffffffffffffff00, float:NaN)
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.messenger.SvgHelper.getColorByName(java.lang.String):java.lang.Integer");
    }

    private static class NumberParse {
        private int nextCmd;
        private ArrayList<Float> numbers;

        public NumberParse(ArrayList<Float> numbers, int nextCmd) {
            this.numbers = numbers;
            this.nextCmd = nextCmd;
        }

        public int getNextCmd() {
            return this.nextCmd;
        }

        public float getNumber(int index) {
            return this.numbers.get(index).floatValue();
        }
    }

    private static class StyleSet {
        HashMap<String, String> styleMap;

        private StyleSet(StyleSet styleSet) {
            HashMap<String, String> map = new HashMap<>();
            this.styleMap = map;
            map.putAll(styleSet.styleMap);
        }

        private StyleSet(String string) {
            this.styleMap = new HashMap<>();
            for (String str : string.split(";")) {
                String[] strArrSplit = str.split(":");
                if (strArrSplit.length == 2) {
                    this.styleMap.put(strArrSplit[0].trim(), strArrSplit[1].trim());
                }
            }
        }

        public String getStyle(String name) {
            return this.styleMap.get(name);
        }
    }

    private static class Properties {
        Attributes atts;
        ArrayList<StyleSet> styles;

        private Properties(Attributes atts, HashMap<String, StyleSet> globalStyles) {
            this.atts = atts;
            String stringAttr = SvgHelper.getStringAttr("style", atts);
            if (stringAttr == null) {
                String stringAttr2 = SvgHelper.getStringAttr("class", atts);
                if (stringAttr2 != null) {
                    this.styles = new ArrayList<>();
                    for (String str : stringAttr2.split(" ")) {
                        StyleSet styleSet = globalStyles.get(str.trim());
                        if (styleSet != null) {
                            this.styles.add(styleSet);
                        }
                    }
                    return;
                }
                return;
            }
            ArrayList<StyleSet> arrayList = new ArrayList<>();
            this.styles = arrayList;
            arrayList.add(new StyleSet(stringAttr));
        }

        public String getAttr(String name) {
            ArrayList<StyleSet> arrayList = this.styles;
            String style = null;
            if (arrayList != null && !arrayList.isEmpty()) {
                int size = this.styles.size();
                for (int i = 0; i < size; i++) {
                    style = this.styles.get(i).getStyle(name);
                    if (style != null) {
                        break;
                    }
                }
            }
            return style == null ? SvgHelper.getStringAttr(name, this.atts) : style;
        }

        public String getString(String name) {
            return getAttr(name);
        }

        public Integer getHex(String name) {
            String attr = getAttr(name);
            if (attr == null) {
                return null;
            }
            try {
                return Integer.valueOf(Integer.parseInt(attr.substring(1), 16));
            } catch (NumberFormatException unused) {
                return SvgHelper.getColorByName(attr);
            }
        }

        public Float getFloat(String name, float defaultValue) {
            Float f = getFloat(name);
            return f == null ? Float.valueOf(defaultValue) : f;
        }

        public Float getFloat(String name) {
            String attr = getAttr(name);
            if (attr == null) {
                return null;
            }
            try {
                return Float.valueOf(Float.parseFloat(attr));
            } catch (NumberFormatException unused) {
                return null;
            }
        }
    }

    private static class SVGHandler extends DefaultHandler {
        private Bitmap bitmap;
        private boolean boundsMode;
        private Canvas canvas;
        private int desiredHeight;
        private int desiredWidth;
        private SvgDrawable drawable;
        private HashMap<String, StyleSet> globalStyles;
        private Paint paint;
        private Integer paintColor;
        boolean pushed;
        private RectF rect;
        private RectF rectTmp;
        private float scale;
        private StringBuilder styles;

        @Override // org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
        public void endDocument() {
        }

        @Override // org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
        public void startDocument() {
        }

        private SVGHandler(int dw, int dh, Integer color, boolean asDrawable) {
            this.scale = 1.0f;
            this.paint = new Paint(1);
            this.rect = new RectF();
            this.rectTmp = new RectF();
            this.pushed = false;
            this.globalStyles = new HashMap<>();
            this.desiredWidth = dw;
            this.desiredHeight = dh;
            this.paintColor = color;
            if (asDrawable) {
                this.drawable = new SvgDrawable();
            }
        }

        private boolean doFill(Properties atts) {
            if ("none".equals(atts.getString("display"))) {
                return false;
            }
            String string = atts.getString("fill");
            if (string != null && string.startsWith("url(#")) {
                string.substring(5, string.length() - 1);
                return false;
            }
            Integer hex = atts.getHex("fill");
            if (hex != null) {
                doColor(atts, hex, true);
                this.paint.setStyle(Paint.Style.FILL);
                return true;
            }
            if (atts.getString("fill") != null || atts.getString("stroke") != null) {
                return false;
            }
            this.paint.setStyle(Paint.Style.FILL);
            Integer num = this.paintColor;
            if (num != null) {
                this.paint.setColor(num.intValue());
            } else {
                this.paint.setColor(-16777216);
            }
            return true;
        }

        private boolean doStroke(Properties atts) {
            Integer hex;
            if ("none".equals(atts.getString("display")) || (hex = atts.getHex("stroke")) == null) {
                return false;
            }
            doColor(atts, hex, false);
            Float f = atts.getFloat("stroke-width");
            if (f != null) {
                this.paint.setStrokeWidth(f.floatValue());
            }
            String string = atts.getString("stroke-linecap");
            if ("round".equals(string)) {
                this.paint.setStrokeCap(Paint.Cap.ROUND);
            } else if ("square".equals(string)) {
                this.paint.setStrokeCap(Paint.Cap.SQUARE);
            } else if ("butt".equals(string)) {
                this.paint.setStrokeCap(Paint.Cap.BUTT);
            }
            String string2 = atts.getString("stroke-linejoin");
            if ("miter".equals(string2)) {
                this.paint.setStrokeJoin(Paint.Join.MITER);
            } else if ("round".equals(string2)) {
                this.paint.setStrokeJoin(Paint.Join.ROUND);
            } else if ("bevel".equals(string2)) {
                this.paint.setStrokeJoin(Paint.Join.BEVEL);
            }
            this.paint.setStyle(Paint.Style.STROKE);
            return true;
        }

        private void doColor(Properties atts, Integer color, boolean fillMode) {
            Integer num = this.paintColor;
            if (num != null) {
                this.paint.setColor(num.intValue());
            } else {
                this.paint.setColor((color.intValue() & 16777215) | (-16777216));
            }
            Float f = atts.getFloat("opacity");
            if (f == null) {
                f = atts.getFloat(fillMode ? "fill-opacity" : "stroke-opacity");
            }
            if (f == null) {
                this.paint.setAlpha(255);
            } else {
                this.paint.setAlpha((int) (f.floatValue() * 255.0f));
            }
        }

        private void pushTransform(Attributes atts) {
            String stringAttr = SvgHelper.getStringAttr("transform", atts);
            boolean z = stringAttr != null;
            this.pushed = z;
            if (z) {
                Matrix transform = SvgHelper.parseTransform(stringAttr);
                SvgDrawable svgDrawable = this.drawable;
                if (svgDrawable != null) {
                    svgDrawable.addCommand(transform);
                } else {
                    this.canvas.save();
                    this.canvas.concat(transform);
                }
            }
        }

        private void popTransform() {
            if (this.pushed) {
                SvgDrawable svgDrawable = this.drawable;
                if (svgDrawable != null) {
                    svgDrawable.addCommand(null);
                } else {
                    this.canvas.restore();
                }
            }
        }

        /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
        @Override // org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
        public void startElement(String namespaceURI, String localName, String qName, Attributes atts) {
            String stringAttr;
            int i;
            if (!this.boundsMode || localName.equals("style")) {
                localName.hashCode();
                char c = 65535;
                switch (localName.hashCode()) {
                    case -1656480802:
                        if (localName.equals("ellipse")) {
                            c = 0;
                            break;
                        }
                        break;
                    case -1360216880:
                        if (localName.equals("circle")) {
                            c = 1;
                            break;
                        }
                        break;
                    case -397519558:
                        if (localName.equals("polygon")) {
                            c = 2;
                            break;
                        }
                        break;
                    case R.styleable.AppCompatTheme_textAppearanceSmallPopupMenu /* 103 */:
                        if (localName.equals(ImageLoader.AUTOPLAY_FILTER)) {
                            c = 3;
                            break;
                        }
                        break;
                    case 114276:
                        if (localName.equals("svg")) {
                            c = 4;
                            break;
                        }
                        break;
                    case 3079438:
                        if (localName.equals("defs")) {
                            c = 5;
                            break;
                        }
                        break;
                    case 3321844:
                        if (localName.equals("line")) {
                            c = 6;
                            break;
                        }
                        break;
                    case 3433509:
                        if (localName.equals("path")) {
                            c = 7;
                            break;
                        }
                        break;
                    case 3496420:
                        if (localName.equals("rect")) {
                            c = '\b';
                            break;
                        }
                        break;
                    case 109780401:
                        if (localName.equals("style")) {
                            c = '\t';
                            break;
                        }
                        break;
                    case 561938880:
                        if (localName.equals("polyline")) {
                            c = '\n';
                            break;
                        }
                        break;
                    case 917656469:
                        if (localName.equals("clipPath")) {
                            c = 11;
                            break;
                        }
                        break;
                }
                switch (c) {
                    case 0:
                        Float floatAttr = SvgHelper.getFloatAttr("cx", atts);
                        Float floatAttr2 = SvgHelper.getFloatAttr("cy", atts);
                        Float floatAttr3 = SvgHelper.getFloatAttr("rx", atts);
                        Float floatAttr4 = SvgHelper.getFloatAttr("ry", atts);
                        if (floatAttr != null && floatAttr2 != null && floatAttr3 != null && floatAttr4 != null) {
                            pushTransform(atts);
                            Properties properties = new Properties(atts, this.globalStyles);
                            this.rect.set(floatAttr.floatValue() - floatAttr3.floatValue(), floatAttr2.floatValue() - floatAttr4.floatValue(), floatAttr.floatValue() + floatAttr3.floatValue(), floatAttr2.floatValue() + floatAttr4.floatValue());
                            if (doFill(properties)) {
                                SvgDrawable svgDrawable = this.drawable;
                                if (svgDrawable != null) {
                                    svgDrawable.addCommand(new Oval(this.rect), this.paint);
                                } else {
                                    this.canvas.drawOval(this.rect, this.paint);
                                }
                            }
                            if (doStroke(properties)) {
                                SvgDrawable svgDrawable2 = this.drawable;
                                if (svgDrawable2 != null) {
                                    svgDrawable2.addCommand(new Oval(this.rect), this.paint);
                                } else {
                                    this.canvas.drawOval(this.rect, this.paint);
                                }
                            }
                            popTransform();
                            break;
                        }
                        break;
                    case 1:
                        Float floatAttr5 = SvgHelper.getFloatAttr("cx", atts);
                        Float floatAttr6 = SvgHelper.getFloatAttr("cy", atts);
                        Float floatAttr7 = SvgHelper.getFloatAttr("r", atts);
                        if (floatAttr5 != null && floatAttr6 != null && floatAttr7 != null) {
                            pushTransform(atts);
                            Properties properties2 = new Properties(atts, this.globalStyles);
                            if (doFill(properties2)) {
                                SvgDrawable svgDrawable3 = this.drawable;
                                if (svgDrawable3 != null) {
                                    svgDrawable3.addCommand(new Circle(floatAttr5.floatValue(), floatAttr6.floatValue(), floatAttr7.floatValue()), this.paint);
                                } else {
                                    this.canvas.drawCircle(floatAttr5.floatValue(), floatAttr6.floatValue(), floatAttr7.floatValue(), this.paint);
                                }
                            }
                            if (doStroke(properties2)) {
                                SvgDrawable svgDrawable4 = this.drawable;
                                if (svgDrawable4 != null) {
                                    svgDrawable4.addCommand(new Circle(floatAttr5.floatValue(), floatAttr6.floatValue(), floatAttr7.floatValue()), this.paint);
                                } else {
                                    this.canvas.drawCircle(floatAttr5.floatValue(), floatAttr6.floatValue(), floatAttr7.floatValue(), this.paint);
                                }
                            }
                            popTransform();
                            break;
                        }
                        break;
                    case 2:
                    case '\n':
                        NumberParse numberParseAttr = SvgHelper.getNumberParseAttr("points", atts);
                        if (numberParseAttr != null) {
                            Path path = new Path();
                            ArrayList arrayList = numberParseAttr.numbers;
                            if (arrayList.size() > 1) {
                                pushTransform(atts);
                                Properties properties3 = new Properties(atts, this.globalStyles);
                                path.moveTo(((Float) arrayList.get(0)).floatValue(), ((Float) arrayList.get(1)).floatValue());
                                for (int i2 = 2; i2 < arrayList.size(); i2 += 2) {
                                    path.lineTo(((Float) arrayList.get(i2)).floatValue(), ((Float) arrayList.get(i2 + 1)).floatValue());
                                }
                                if (localName.equals("polygon")) {
                                    path.close();
                                }
                                if (doFill(properties3)) {
                                    SvgDrawable svgDrawable5 = this.drawable;
                                    if (svgDrawable5 != null) {
                                        svgDrawable5.addCommand(path, this.paint);
                                    } else {
                                        this.canvas.drawPath(path, this.paint);
                                    }
                                }
                                if (doStroke(properties3)) {
                                    SvgDrawable svgDrawable6 = this.drawable;
                                    if (svgDrawable6 != null) {
                                        svgDrawable6.addCommand(path, this.paint);
                                    } else {
                                        this.canvas.drawPath(path, this.paint);
                                    }
                                }
                                popTransform();
                                break;
                            }
                        }
                        break;
                    case 3:
                        if ("bounds".equalsIgnoreCase(SvgHelper.getStringAttr("id", atts))) {
                            this.boundsMode = true;
                            break;
                        }
                        break;
                    case 4:
                        Float floatAttr8 = SvgHelper.getFloatAttr("width", atts);
                        Float floatAttr9 = SvgHelper.getFloatAttr("height", atts);
                        if ((floatAttr8 == null || floatAttr9 == null) && (stringAttr = SvgHelper.getStringAttr("viewBox", atts)) != null) {
                            String[] strArrSplit = stringAttr.split(" ");
                            Float fValueOf = Float.valueOf(Float.parseFloat(strArrSplit[2]));
                            floatAttr9 = Float.valueOf(Float.parseFloat(strArrSplit[3]));
                            floatAttr8 = fValueOf;
                        }
                        if (floatAttr8 == null || floatAttr9 == null) {
                            floatAttr8 = Float.valueOf(this.desiredWidth);
                            floatAttr9 = Float.valueOf(this.desiredHeight);
                        }
                        int iCeil = (int) Math.ceil(floatAttr8.floatValue());
                        int iCeil2 = (int) Math.ceil(floatAttr9.floatValue());
                        if (iCeil == 0 || iCeil2 == 0) {
                            iCeil = this.desiredWidth;
                            iCeil2 = this.desiredHeight;
                        } else {
                            int i3 = this.desiredWidth;
                            if (i3 != 0 && (i = this.desiredHeight) != 0) {
                                float f = iCeil;
                                float f2 = iCeil2;
                                float fMin = Math.min(i3 / f, i / f2);
                                this.scale = fMin;
                                iCeil = (int) (f * fMin);
                                iCeil2 = (int) (f2 * fMin);
                            }
                        }
                        SvgDrawable svgDrawable7 = this.drawable;
                        if (svgDrawable7 == null) {
                            Bitmap bitmapCreateBitmap = Bitmap.createBitmap(iCeil, iCeil2, Bitmap.Config.ARGB_8888);
                            this.bitmap = bitmapCreateBitmap;
                            bitmapCreateBitmap.eraseColor(0);
                            Canvas canvas = new Canvas(this.bitmap);
                            this.canvas = canvas;
                            float f3 = this.scale;
                            if (f3 != 0.0f) {
                                canvas.scale(f3, f3);
                                break;
                            }
                        } else {
                            svgDrawable7.width = iCeil;
                            svgDrawable7.height = iCeil2;
                            break;
                        }
                        break;
                    case 5:
                    case 11:
                        this.boundsMode = true;
                        break;
                    case 6:
                        Float floatAttr10 = SvgHelper.getFloatAttr("x1", atts);
                        Float floatAttr11 = SvgHelper.getFloatAttr("x2", atts);
                        Float floatAttr12 = SvgHelper.getFloatAttr("y1", atts);
                        Float floatAttr13 = SvgHelper.getFloatAttr("y2", atts);
                        if (doStroke(new Properties(atts, this.globalStyles))) {
                            pushTransform(atts);
                            SvgDrawable svgDrawable8 = this.drawable;
                            if (svgDrawable8 != null) {
                                svgDrawable8.addCommand(new Line(floatAttr10.floatValue(), floatAttr12.floatValue(), floatAttr11.floatValue(), floatAttr13.floatValue()), this.paint);
                            } else {
                                this.canvas.drawLine(floatAttr10.floatValue(), floatAttr12.floatValue(), floatAttr11.floatValue(), floatAttr13.floatValue(), this.paint);
                            }
                            popTransform();
                            break;
                        }
                        break;
                    case 7:
                        Path pathDoPath = SvgHelper.doPath(SvgHelper.getStringAttr("d", atts));
                        pushTransform(atts);
                        Properties properties4 = new Properties(atts, this.globalStyles);
                        if (doFill(properties4)) {
                            SvgDrawable svgDrawable9 = this.drawable;
                            if (svgDrawable9 != null) {
                                svgDrawable9.addCommand(pathDoPath, this.paint);
                            } else {
                                this.canvas.drawPath(pathDoPath, this.paint);
                            }
                        }
                        if (doStroke(properties4)) {
                            SvgDrawable svgDrawable10 = this.drawable;
                            if (svgDrawable10 != null) {
                                svgDrawable10.addCommand(pathDoPath, this.paint);
                            } else {
                                this.canvas.drawPath(pathDoPath, this.paint);
                            }
                        }
                        popTransform();
                        break;
                    case '\b':
                        Float floatAttr14 = SvgHelper.getFloatAttr("x", atts);
                        if (floatAttr14 == null) {
                            floatAttr14 = Float.valueOf(0.0f);
                        }
                        Float floatAttr15 = SvgHelper.getFloatAttr("y", atts);
                        if (floatAttr15 == null) {
                            floatAttr15 = Float.valueOf(0.0f);
                        }
                        Float floatAttr16 = SvgHelper.getFloatAttr("width", atts);
                        Float floatAttr17 = SvgHelper.getFloatAttr("height", atts);
                        Float floatAttr18 = SvgHelper.getFloatAttr("rx", atts, null);
                        pushTransform(atts);
                        Properties properties5 = new Properties(atts, this.globalStyles);
                        if (doFill(properties5)) {
                            SvgDrawable svgDrawable11 = this.drawable;
                            if (svgDrawable11 != null) {
                                if (floatAttr18 != null) {
                                    svgDrawable11.addCommand(new RoundRect(new RectF(floatAttr14.floatValue(), floatAttr15.floatValue(), floatAttr14.floatValue() + floatAttr16.floatValue(), floatAttr15.floatValue() + floatAttr17.floatValue()), floatAttr18.floatValue()), this.paint);
                                } else {
                                    svgDrawable11.addCommand(new RectF(floatAttr14.floatValue(), floatAttr15.floatValue(), floatAttr14.floatValue() + floatAttr16.floatValue(), floatAttr15.floatValue() + floatAttr17.floatValue()), this.paint);
                                }
                            } else if (floatAttr18 != null) {
                                this.rectTmp.set(floatAttr14.floatValue(), floatAttr15.floatValue(), floatAttr14.floatValue() + floatAttr16.floatValue(), floatAttr15.floatValue() + floatAttr17.floatValue());
                                this.canvas.drawRoundRect(this.rectTmp, floatAttr18.floatValue(), floatAttr18.floatValue(), this.paint);
                            } else {
                                this.canvas.drawRect(floatAttr14.floatValue(), floatAttr15.floatValue(), floatAttr14.floatValue() + floatAttr16.floatValue(), floatAttr15.floatValue() + floatAttr17.floatValue(), this.paint);
                            }
                        }
                        if (doStroke(properties5)) {
                            SvgDrawable svgDrawable12 = this.drawable;
                            if (svgDrawable12 != null) {
                                if (floatAttr18 != null) {
                                    svgDrawable12.addCommand(new RoundRect(new RectF(floatAttr14.floatValue(), floatAttr15.floatValue(), floatAttr14.floatValue() + floatAttr16.floatValue(), floatAttr15.floatValue() + floatAttr17.floatValue()), floatAttr18.floatValue()), this.paint);
                                } else {
                                    svgDrawable12.addCommand(new RectF(floatAttr14.floatValue(), floatAttr15.floatValue(), floatAttr14.floatValue() + floatAttr16.floatValue(), floatAttr15.floatValue() + floatAttr17.floatValue()), this.paint);
                                }
                            } else if (floatAttr18 != null) {
                                this.rectTmp.set(floatAttr14.floatValue(), floatAttr15.floatValue(), floatAttr14.floatValue() + floatAttr16.floatValue(), floatAttr15.floatValue() + floatAttr17.floatValue());
                                this.canvas.drawRoundRect(this.rectTmp, floatAttr18.floatValue(), floatAttr18.floatValue(), this.paint);
                            } else {
                                this.canvas.drawRect(floatAttr14.floatValue(), floatAttr15.floatValue(), floatAttr14.floatValue() + floatAttr16.floatValue(), floatAttr15.floatValue() + floatAttr17.floatValue(), this.paint);
                            }
                        }
                        popTransform();
                        break;
                    case '\t':
                        this.styles = new StringBuilder();
                        break;
                }
            }
        }

        @Override // org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
        public void characters(char[] ch, int start, int length) {
            StringBuilder sb = this.styles;
            if (sb != null) {
                sb.append(ch, start, length);
            }
        }

        @Override // org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
        public void endElement(String namespaceURI, String localName, String qName) {
            int iIndexOf;
            localName.hashCode();
            switch (localName) {
                case "g":
                case "defs":
                case "clipPath":
                    this.boundsMode = false;
                    break;
                case "style":
                    StringBuilder sb = this.styles;
                    if (sb != null) {
                        String[] strArrSplit = sb.toString().split("\\}");
                        int i = 0;
                        while (true) {
                            if (i < strArrSplit.length) {
                                strArrSplit[i] = strArrSplit[i].trim().replace("\t", "").replace("\n", "");
                                if (strArrSplit[i].length() != 0 && strArrSplit[i].charAt(0) == '.' && (iIndexOf = strArrSplit[i].indexOf(123)) >= 0) {
                                    this.globalStyles.put(strArrSplit[i].substring(1, iIndexOf).trim(), new StyleSet(strArrSplit[i].substring(iIndexOf + 1)));
                                }
                                i++;
                            } else {
                                this.styles = null;
                                break;
                            }
                        }
                    }
                    break;
            }
        }

        public Bitmap getBitmap() {
            return this.bitmap;
        }

        public SvgDrawable getDrawable() {
            return this.drawable;
        }
    }

    static {
        int i = 0;
        while (true) {
            double[] dArr = pow10;
            if (i >= dArr.length) {
                return;
            }
            dArr[i] = Math.pow(10.0d, i);
            i++;
        }
    }

    public static class ParserHelper {
        private char current;
        private int n;
        public int pos;
        private CharSequence s;

        public ParserHelper(CharSequence s, int pos) {
            this.s = s;
            this.pos = pos;
            this.n = s.length();
            this.current = s.charAt(pos);
        }

        private char read() {
            int i = this.pos;
            int i2 = this.n;
            if (i < i2) {
                this.pos = i + 1;
            }
            int i3 = this.pos;
            if (i3 == i2) {
                return (char) 0;
            }
            return this.s.charAt(i3);
        }

        public void skipWhitespace() {
            while (true) {
                int i = this.pos;
                if (i >= this.n || !Character.isWhitespace(this.s.charAt(i))) {
                    return;
                } else {
                    advance();
                }
            }
        }

        public void skipNumberSeparator() {
            while (true) {
                int i = this.pos;
                if (i >= this.n) {
                    return;
                }
                char cCharAt = this.s.charAt(i);
                if (cCharAt != '\t' && cCharAt != '\n' && cCharAt != ' ' && cCharAt != ',') {
                    return;
                } else {
                    advance();
                }
            }
        }

        public void advance() {
            this.current = read();
        }

        /* JADX WARN: Removed duplicated region for block: B:13:0x0028 A[LOOP:0: B:13:0x0028->B:85:?, LOOP_START] */
        /* JADX WARN: Removed duplicated region for block: B:19:0x0038  */
        /* JADX WARN: Removed duplicated region for block: B:28:0x0058  */
        /* JADX WARN: Removed duplicated region for block: B:31:0x0060  */
        /* JADX WARN: Removed duplicated region for block: B:47:0x0099 A[ADDED_TO_REGION] */
        /* JADX WARN: Removed duplicated region for block: B:49:0x009c  */
        /* JADX WARN: Removed duplicated region for block: B:51:0x00a4  */
        /* JADX WARN: Removed duplicated region for block: B:56:0x00ae A[PHI: r3
          0x00ae: PHI (r3v1 boolean) = (r3v0 boolean), (r3v3 boolean) binds: [B:50:0x00a2, B:55:0x00ad] A[DONT_GENERATE, DONT_INLINE]] */
        /* JADX WARN: Removed duplicated region for block: B:58:0x00b7  */
        /* JADX WARN: Removed duplicated region for block: B:60:0x00bb A[PHI: r3
          0x00bb: PHI (r3v2 boolean) = (r3v1 boolean), (r3v0 boolean) binds: [B:57:0x00b4, B:52:0x00a6] A[DONT_GENERATE, DONT_INLINE]] */
        /* JADX WARN: Removed duplicated region for block: B:74:0x00e4  */
        /* JADX WARN: Removed duplicated region for block: B:77:0x00e8  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public float parseFloat() {
            /*
                Method dump skipped, instructions count: 506
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.messenger.SvgHelper.ParserHelper.parseFloat():float");
        }

        private void reportUnexpectedCharacterError(char c) {
            throw new RuntimeException("Unexpected char '" + c + "'.");
        }

        public float buildFloat(int mant, int exp) {
            double d;
            if (exp < -125 || mant == 0) {
                return 0.0f;
            }
            if (exp >= 128) {
                return mant > 0 ? Float.POSITIVE_INFINITY : Float.NEGATIVE_INFINITY;
            }
            if (exp == 0) {
                return mant;
            }
            if (mant >= 67108864) {
                mant++;
            }
            double d2 = mant;
            double[] dArr = SvgHelper.pow10;
            if (exp > 0) {
                double d3 = dArr[exp];
                Double.isNaN(d2);
                d = d2 * d3;
            } else {
                double d4 = dArr[-exp];
                Double.isNaN(d2);
                d = d2 / d4;
            }
            return (float) d;
        }

        public float nextFloat() {
            skipWhitespace();
            float f = parseFloat();
            skipNumberSeparator();
            return f;
        }
    }

    public static String decompress(byte[] encoded) {
        try {
            StringBuilder sb = new StringBuilder(encoded.length * 2);
            sb.append('M');
            for (byte b : encoded) {
                int i = b & 255;
                if (i >= 192) {
                    sb.append("AACAAAAHAAALMAAAQASTAVAAAZaacaaaahaaalmaaaqastava.az0123456789-,".charAt((i - 128) - 64));
                } else {
                    if (i >= 128) {
                        sb.append(',');
                    } else if (i >= 64) {
                        sb.append('-');
                    }
                    sb.append(i & 63);
                }
            }
            sb.append('z');
            return sb.toString();
        } catch (Exception e) {
            FileLog.e(e);
            return "";
        }
    }
}
