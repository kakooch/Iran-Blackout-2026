package ir.nasim.tgwidgets.editor.messenger;

import ai.bale.proto.SetRpcStruct$ComposedRpc;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.content.res.Configuration;
import android.gov.nist.core.Separators;
import android.gov.nist.javax.sip.stack.SIPTransactionStack;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorMatrix;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.os.Vibrator;
import android.provider.Settings;
import android.text.Selection;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.text.style.URLSpan;
import android.text.util.Linkify;
import android.util.DisplayMetrics;
import android.util.Pair;
import android.view.Display;
import android.view.MotionEvent;
import android.view.TextureView;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.view.Window;
import android.view.WindowInsets;
import android.view.WindowManager;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.inputmethod.InputMethodManager;
import android.view.inspector.WindowInspector;
import android.webkit.MimeTypeMap;
import android.widget.EdgeEffect;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.core.content.FileProvider;
import io.appmetrica.analytics.AppMetricaDefaultValues;
import io.appmetrica.analytics.coreutils.internal.system.ConstantDeviceInfo;
import ir.nasim.AbstractC11908dl0;
import ir.nasim.AbstractC12098e22;
import ir.nasim.AbstractC14047hG;
import ir.nasim.AbstractC18106o57;
import ir.nasim.AbstractC18763pC5;
import ir.nasim.AbstractC21820uB3;
import ir.nasim.AbstractC22000uV3;
import ir.nasim.AbstractC23598xB5;
import ir.nasim.AbstractC3388Ar;
import ir.nasim.AbstractC3627Br;
import ir.nasim.AbstractC4043Dl1;
import ir.nasim.AbstractC6403Nl2;
import ir.nasim.AbstractC8662Wx6;
import ir.nasim.AbstractC8814Xl0;
import ir.nasim.C10743c74;
import ir.nasim.C16463lJ6;
import ir.nasim.C17233md2;
import ir.nasim.C17645nJ6;
import ir.nasim.C19819qz7;
import ir.nasim.C22477vI7;
import ir.nasim.C24365yV2;
import ir.nasim.C4278El2;
import ir.nasim.C5721Ko;
import ir.nasim.C6011Lu2;
import ir.nasim.FH3;
import ir.nasim.InterpolatorC12631ew1;
import ir.nasim.QY0;
import ir.nasim.TD5;
import ir.nasim.tgwidgets.editor.messenger.AbstractC21455b;
import ir.nasim.tgwidgets.editor.messenger.Utilities;
import ir.nasim.tgwidgets.editor.ui.ActionBar.AlertDialog;
import ir.nasim.tgwidgets.editor.ui.ActionBar.m;
import ir.nasim.tgwidgets.editor.ui.Components.URLSpanReplacement;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import okhttp3.internal.ws.RealWebSocket;
import org.xbill.DNS.SimpleResolver;

/* renamed from: ir.nasim.tgwidgets.editor.messenger.b, reason: case insensitive filesystem */
/* loaded from: classes7.dex */
public abstract class AbstractC21455b {
    public static Pattern A;
    public static Pattern B;
    private static int[] C;
    private static int[] D;
    public static final Linkify.MatchFilter E;
    private static boolean F;
    private static SimpleDateFormat G;
    private static HashMap H;
    private static Vibrator I;
    public static Integer b;
    public static boolean f;
    public static int k;
    public static int l;
    public static int m;
    public static boolean n;
    public static int q;
    public static boolean r;
    public static boolean s;
    private static AccessibilityManager v;
    public static Pattern z;
    private static final Hashtable a = new Hashtable();
    private static int c = -10;
    public static int d = 0;
    public static int e = 0;
    public static float g = 1.0f;
    public static Point h = new Point();
    public static float i = 60.0f;
    public static float j = 1000.0f / 60.0f;
    public static Integer o = null;
    public static DisplayMetrics p = new DisplayMetrics();
    public static DecelerateInterpolator t = new DecelerateInterpolator();
    public static AccelerateInterpolator u = new AccelerateInterpolator();
    private static Boolean w = null;
    public static final RectF x = new RectF();
    public static final Rect y = new Rect();

    /* renamed from: ir.nasim.tgwidgets.editor.messenger.b$a */
    class a extends AnimatorListenerAdapter {
        final /* synthetic */ View a;

        a(View view) {
            this.a = view;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            this.a.setTranslationX(0.0f);
        }
    }

    /* renamed from: ir.nasim.tgwidgets.editor.messenger.b$b, reason: collision with other inner class name */
    class C1578b extends AnimatorListenerAdapter {
        final /* synthetic */ Window a;

        C1578b(Window window) {
            this.a = window;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            if (AbstractC21455b.H != null) {
                AbstractC21455b.H.remove(this.a);
            }
        }
    }

    /* renamed from: ir.nasim.tgwidgets.editor.messenger.b$c */
    public interface c {
        void a(int i);
    }

    /* renamed from: ir.nasim.tgwidgets.editor.messenger.b$d */
    public static class d extends LinkMovementMethod {
        @Override // android.text.method.LinkMovementMethod, android.text.method.ScrollingMovementMethod, android.text.method.BaseMovementMethod, android.text.method.MovementMethod
        public boolean onTouchEvent(TextView textView, Spannable spannable, MotionEvent motionEvent) {
            try {
                boolean zOnTouchEvent = super.onTouchEvent(textView, spannable, motionEvent);
                if (motionEvent.getAction() == 1 || motionEvent.getAction() == 3) {
                    Selection.removeSelection(spannable);
                }
                return zOnTouchEvent;
            } catch (Exception e) {
                AbstractC6403Nl2.d(e);
                return false;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: ir.nasim.tgwidgets.editor.messenger.b$e */
    static class e {
        String a;
        int b;
        int c;

        private e() {
        }
    }

    static {
        z = null;
        A = null;
        B = null;
        try {
            z = Pattern.compile("[─-◿]");
            B = Pattern.compile("[̀-ͯ\u2066-\u2067]+");
            A = Pattern.compile("[\u2066-\u2067]+");
            Pattern.compile("(([a-zA-Z0-9 -\ud7ff豈-﷏ﷰ-\uffef]([a-zA-Z0-9 -\ud7ff豈-﷏ﷰ-\uffef\\-]{0,61}[a-zA-Z0-9 -\ud7ff豈-﷏ﷰ-\uffef]){0,1}\\.)+[a-zA-Z -\ud7ff豈-﷏ﷰ-\uffef]{2,63}|" + Pattern.compile("((25[0-5]|2[0-4][0-9]|[0-1][0-9]{2}|[1-9][0-9]|[1-9])\\.(25[0-5]|2[0-4][0-9]|[0-1][0-9]{2}|[1-9][0-9]|[1-9]|0)\\.(25[0-5]|2[0-4][0-9]|[0-1][0-9]{2}|[1-9][0-9]|[1-9]|0)\\.(25[0-5]|2[0-4][0-9]|[0-1][0-9]{2}|[1-9][0-9]|[0-9]))") + Separators.RPAREN);
        } catch (Exception e2) {
            AbstractC6403Nl2.d(e2);
        }
        q = F0() ? 80 : 72;
        v(AbstractC14047hG.a, null);
        C = new int[]{AbstractC23598xB5.media_doc_blue, AbstractC23598xB5.media_doc_green, AbstractC23598xB5.media_doc_red, AbstractC23598xB5.media_doc_yellow};
        D = new int[]{AbstractC23598xB5.media_doc_blue_b, AbstractC23598xB5.media_doc_green_b, AbstractC23598xB5.media_doc_red_b, AbstractC23598xB5.media_doc_yellow_b};
        E = new Linkify.MatchFilter() { // from class: ir.nasim.Er
            @Override // android.text.util.Linkify.MatchFilter
            public final boolean acceptMatch(CharSequence charSequence, int i2, int i3) {
                return AbstractC21455b.R0(charSequence, i2, i3);
            }
        };
        F = true;
    }

    private static boolean A(String str) {
        if (str.contains("\u202c") || str.contains("\u202d") || str.contains("\u202e")) {
            return true;
        }
        try {
            return z.matcher(str).find();
        } catch (Throwable unused) {
            return true;
        }
    }

    public static boolean A0(Uri uri) {
        return B0(uri, 0);
    }

    public static boolean A1() {
        int i2 = Build.VERSION.SDK_INT;
        return i2 < 31 && i2 < 32;
    }

    public static boolean B(File file, File file2) {
        if (file.equals(file2)) {
            return true;
        }
        if (!file2.exists()) {
            file2.createNewFile();
        }
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            try {
                FileOutputStream fileOutputStream = new FileOutputStream(file2);
                try {
                    fileOutputStream.getChannel().transferFrom(fileInputStream.getChannel(), 0L, fileInputStream.getChannel().size());
                    fileOutputStream.close();
                    fileInputStream.close();
                    return true;
                } finally {
                }
            } finally {
            }
        } catch (Exception e2) {
            AbstractC6403Nl2.d(e2);
            return false;
        }
    }

    private static boolean B0(Uri uri, int i2) throws IOException {
        String path;
        if (uri == null) {
            path = "";
            int i3 = 0;
            while (path.length() <= 4096) {
                try {
                    String str = Utilities.readlinkFd(i2);
                    if (str != null && !str.equals(path)) {
                        i3++;
                        if (i3 >= 10) {
                            return true;
                        }
                        path = str;
                    }
                } catch (Throwable unused) {
                    return true;
                }
            }
            return true;
        }
        path = uri.getPath();
        if (path == null) {
            return false;
        }
        if (path.matches(Pattern.quote(new File(AbstractC14047hG.a.getCacheDir(), "voip_logs").getAbsolutePath()) + "/\\d+\\.log")) {
            return false;
        }
        int i4 = 0;
        while (path.length() <= 4096) {
            try {
                String str2 = Utilities.readlink(path);
                if (str2 != null && !str2.equals(path)) {
                    i4++;
                    if (i4 >= 10) {
                        return true;
                    }
                    path = str2;
                }
            } catch (Throwable unused2) {
                return true;
            }
        }
        return true;
        try {
            String canonicalPath = new File(path).getCanonicalPath();
            if (canonicalPath != null) {
                path = canonicalPath;
            }
        } catch (Exception unused3) {
            path.replace("/./", Separators.SLASH);
        }
        if (path.endsWith(".attheme")) {
            return false;
        }
        return path.toLowerCase().contains("/data/data/" + AbstractC14047hG.a.getPackageName());
    }

    public static boolean B1(String str) {
        try {
            return w(Uri.parse(str).getHost());
        } catch (Exception e2) {
            AbstractC6403Nl2.d(e2);
            return false;
        }
    }

    public static boolean C(InputStream inputStream, File file) {
        return D(inputStream, new FileOutputStream(file));
    }

    public static boolean C0(Uri uri) {
        return "com.android.providers.media.documents".equals(uri.getAuthority());
    }

    public static boolean C1(View view) {
        if (view == null) {
            return false;
        }
        try {
            return ((InputMethodManager) view.getContext().getSystemService("input_method")).showSoftInput(view, 1);
        } catch (Exception e2) {
            AbstractC6403Nl2.d(e2);
            return false;
        }
    }

    public static boolean D(InputStream inputStream, OutputStream outputStream) throws IOException {
        byte[] bArr = new byte[4096];
        while (true) {
            int i2 = inputStream.read(bArr);
            if (i2 <= 0) {
                outputStream.close();
                return true;
            }
            Thread.yield();
            outputStream.write(bArr, 0, i2);
        }
    }

    public static boolean D0(CharSequence charSequence) {
        if (charSequence != null && charSequence.length() > 0) {
            for (int i2 = 0; i2 < charSequence.length(); i2++) {
                char cCharAt = charSequence.charAt(i2);
                if (cCharAt >= 1424 && cCharAt <= 1791) {
                    return true;
                }
            }
        }
        return false;
    }

    private static void D1(int i2, int i3, int[] iArr, Canvas canvas, View view) {
        if (view instanceof TextureView) {
            TextureView textureView = (TextureView) view;
            textureView.getLocationInWindow(iArr);
            Bitmap bitmap = textureView.getBitmap();
            if (bitmap != null) {
                canvas.save();
                canvas.drawBitmap(bitmap, iArr[0] - i2, iArr[1] - i3, (Paint) null);
                canvas.restore();
                bitmap.recycle();
            }
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            for (int i4 = 0; i4 < viewGroup.getChildCount(); i4++) {
                D1(i2, i3, iArr, canvas, viewGroup.getChildAt(i4));
            }
        }
    }

    public static void E(File file) {
        try {
            if (file.exists()) {
                return;
            }
            FileWriter fileWriter = new FileWriter(file);
            fileWriter.flush();
            fileWriter.close();
        } catch (Throwable th) {
            AbstractC6403Nl2.e(th, false);
        }
    }

    public static boolean E0() {
        Point point = h;
        return ((float) Math.min(point.x, point.y)) / g <= 690.0f;
    }

    public static Bitmap E1(View view) {
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(view.getWidth(), view.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmapCreateBitmap);
        view.draw(canvas);
        int[] iArr = new int[2];
        view.getLocationInWindow(iArr);
        D1(iArr[0], iArr[1], iArr, canvas, view);
        return bitmapCreateBitmap;
    }

    public static int F(float f2) {
        if (f2 == 0.0f) {
            return 0;
        }
        return (int) Math.ceil(g * f2);
    }

    public static boolean F0() {
        return H0() && !AbstractC8662Wx6.F;
    }

    public static void F1(Activity activity) {
        if (activity == null) {
            return;
        }
        try {
            int i2 = c;
            if (i2 != -10) {
                activity.setRequestedOrientation(i2);
                c = -10;
            }
        } catch (Exception e2) {
            AbstractC6403Nl2.d(e2);
        }
    }

    public static int G(float f2) {
        if (f2 == 0.0f) {
            return 0;
        }
        return (int) Math.floor(g * f2);
    }

    public static boolean G0() {
        Context context = AbstractC14047hG.a;
        return false;
    }

    public static void G1(ImageView imageView, int i2) {
        H1(imageView, AbstractC4043Dl1.f(imageView.getContext(), i2));
    }

    public static float H(float f2) {
        if (f2 == 0.0f) {
            return 0.0f;
        }
        return g * f2;
    }

    public static boolean H0() {
        if (w == null) {
            w = Boolean.valueOf(G0());
        }
        return w.booleanValue();
    }

    public static void H1(final ImageView imageView, final Drawable drawable) {
        if (imageView.getDrawable() == drawable) {
            return;
        }
        ValueAnimator duration = ValueAnimator.ofFloat(0.0f, 1.0f).setDuration(150L);
        final AtomicBoolean atomicBoolean = new AtomicBoolean();
        duration.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: ir.nasim.Mr
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                AbstractC21455b.S0(imageView, atomicBoolean, drawable, valueAnimator);
            }
        });
        duration.start();
    }

    public static int I(float f2) {
        if (f2 == 0.0f) {
            return 0;
        }
        return Math.round(g * f2);
    }

    public static boolean I0(char c2) {
        return c2 == '-' || c2 == '~';
    }

    public static void I1(View view, boolean z2, boolean z3, float f2, boolean z4, Runnable runnable) {
        if (view == null) {
            return;
        }
        if (view.getParent() == null) {
            z4 = false;
        }
        view.animate().setListener(null).cancel();
        if (!z4) {
            view.setVisibility(z2 ? 0 : 8);
            view.setTag(z2 ? 1 : null);
            view.setAlpha(1.0f);
            view.setScaleX((!z3 || z2) ? 1.0f : 0.0f);
            if (z3 && !z2) {
                f = 0.0f;
            }
            view.setScaleY(f);
            if (f2 != 0.0f) {
                view.setTranslationY(z2 ? 0.0f : F(-16.0f) * f2);
            }
            if (runnable != null) {
                runnable.run();
                return;
            }
            return;
        }
        if (!z2) {
            ViewPropertyAnimator viewPropertyAnimatorWithEndAction = view.animate().alpha(0.0f).scaleY(z3 ? 0.0f : 1.0f).scaleX(z3 ? 0.0f : 1.0f).setListener(new C24365yV2(view)).setInterpolator(InterpolatorC12631ew1.h).setDuration(340L).withEndAction(runnable);
            if (f2 != 0.0f) {
                viewPropertyAnimatorWithEndAction.translationY(F(-16.0f) * f2);
            }
            viewPropertyAnimatorWithEndAction.start();
            return;
        }
        if (view.getVisibility() != 0) {
            view.setVisibility(0);
            view.setAlpha(0.0f);
            view.setScaleX(z3 ? 0.0f : 1.0f);
            view.setScaleY(z3 ? 0.0f : 1.0f);
            if (f2 != 0.0f) {
                view.setTranslationY(F(-16.0f) * f2);
            }
        }
        ViewPropertyAnimator viewPropertyAnimatorWithEndAction2 = view.animate().alpha(1.0f).scaleY(1.0f).scaleX(1.0f).setInterpolator(InterpolatorC12631ew1.h).setDuration(340L).withEndAction(runnable);
        if (f2 != 0.0f) {
            viewPropertyAnimatorWithEndAction2.translationY(0.0f);
        }
        viewPropertyAnimatorWithEndAction2.start();
    }

    public static void J(Context context) {
        if (context == null || d > 0) {
            return;
        }
        d = k0(context);
        e = d0(context);
    }

    public static void J1(View view, boolean z2, float f2, boolean z3) {
        K1(view, z2, f2, true, z3);
    }

    public static Activity K(Context context) {
        if (context instanceof Activity) {
            return (Activity) context;
        }
        if (context instanceof ContextWrapper) {
            return K(((ContextWrapper) context).getBaseContext());
        }
        return null;
    }

    public static void K1(View view, boolean z2, float f2, boolean z3, boolean z4) {
        if (view == null) {
            return;
        }
        if (view.getParent() == null) {
            z4 = false;
        }
        if (!z4) {
            view.animate().setListener(null).cancel();
            view.setVisibility(z2 ? 0 : z3 ? 8 : 4);
            view.setTag(z2 ? 1 : null);
            view.setAlpha(1.0f);
            view.setScaleX(1.0f);
            view.setScaleY(1.0f);
            return;
        }
        if (!z2 || view.getTag() != null) {
            if (z2 || view.getTag() == null) {
                return;
            }
            view.animate().setListener(null).cancel();
            view.animate().alpha(0.0f).scaleY(f2).scaleX(f2).setListener(new C24365yV2(view, z3)).setDuration(150L).start();
            view.setTag(null);
            return;
        }
        view.animate().setListener(null).cancel();
        if (view.getVisibility() != 0) {
            view.setVisibility(0);
            view.setAlpha(0.0f);
            view.setScaleX(f2);
            view.setScaleY(f2);
        }
        view.animate().alpha(1.0f).scaleY(1.0f).scaleX(1.0f).setDuration(150L).start();
        view.setTag(1);
    }

    public static String L(int i2, boolean z2) {
        int i3 = i2 / 3600;
        int i4 = (i2 / 60) % 60;
        int i5 = i2 % 60;
        return i3 == 0 ? z2 ? String.format(Locale.US, "%02d:%02d", Integer.valueOf(i4), Integer.valueOf(i5)) : String.format(Locale.US, "%d:%02d", Integer.valueOf(i4), Integer.valueOf(i5)) : String.format(Locale.US, "%d:%02d:%02d", Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ int L0(e eVar, e eVar2) {
        int i2;
        int i3;
        int i4 = eVar.b;
        int i5 = eVar2.b;
        if (i4 < i5) {
            return -1;
        }
        if (i4 <= i5 && (i2 = eVar.c) >= (i3 = eVar2.c)) {
            return i2 > i3 ? -1 : 0;
        }
        return 1;
    }

    public static String M(long j2) {
        return N(j2, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void M0(List list) {
        for (int i2 = 0; i2 < list.size(); i2++) {
            Bitmap bitmap = (Bitmap) list.get(i2);
            if (bitmap != null && !bitmap.isRecycled()) {
                try {
                    bitmap.recycle();
                } catch (Exception e2) {
                    AbstractC6403Nl2.d(e2);
                }
            }
        }
    }

    public static String N(long j2, boolean z2) {
        if (j2 == 0) {
            return String.format(FH3.C(TD5.size_kb), 0);
        }
        if (j2 < RealWebSocket.DEFAULT_MINIMUM_DEFLATE_SIZE) {
            return String.format(FH3.C(TD5.size_b), Long.valueOf(j2));
        }
        if (j2 < 1048576) {
            float f2 = j2 / 1024.0f;
            if (z2) {
                int i2 = (int) f2;
                if ((f2 - i2) * 10.0f == 0.0f) {
                    return String.format(FH3.C(TD5.size_kb), Integer.valueOf(i2));
                }
            }
            return String.format(FH3.C(TD5.size_kb_float), Float.valueOf(f2));
        }
        if (j2 < 1048576000) {
            float f3 = (j2 / 1024.0f) / 1024.0f;
            if (z2) {
                int i3 = (int) f3;
                if ((f3 - i3) * 10.0f == 0.0f) {
                    return String.format(FH3.C(TD5.size_mb), Integer.valueOf(i3));
                }
            }
            return String.format(FH3.C(TD5.size_mb_float), Float.valueOf(f3));
        }
        float f4 = ((int) ((j2 / RealWebSocket.DEFAULT_MINIMUM_DEFLATE_SIZE) / RealWebSocket.DEFAULT_MINIMUM_DEFLATE_SIZE)) / 1000.0f;
        if (z2) {
            int i4 = (int) f4;
            if ((f4 - i4) * 10.0f == 0.0f) {
                return String.format(FH3.C(TD5.size_gb), Integer.valueOf(i4));
            }
        }
        return String.format(FH3.C(TD5.size_gb_float), Float.valueOf(f4));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void N0(final List list) {
        Utilities.e.i(new Runnable() { // from class: ir.nasim.Gr
            @Override // java.lang.Runnable
            public final void run() {
                AbstractC21455b.M0(list);
            }
        });
    }

    public static String O(int i2) {
        return L(i2, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void O0(c cVar, Window window, ValueAnimator valueAnimator) {
        int iIntValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
        if (cVar != null) {
            cVar.a(iIntValue);
        }
        try {
            window.setNavigationBarColor(iIntValue);
        } catch (Exception unused) {
        }
    }

    private static void P(ArrayList arrayList, Spannable spannable, Pattern pattern, String[] strArr, Linkify.MatchFilter matchFilter, boolean z2) {
        if (TextUtils.indexOf((CharSequence) spannable, (char) 9472) >= 0) {
            spannable = new SpannableStringBuilder(spannable.toString().replace((char) 9472, ' '));
        }
        if (!TextUtils.isEmpty(spannable) && TextUtils.lastIndexOf(spannable, '_') == spannable.length() - 1) {
            spannable = new SpannableStringBuilder(spannable.toString()).replace(spannable.length() - 1, spannable.length(), (CharSequence) "a");
        }
        Matcher matcher = pattern.matcher(spannable);
        while (matcher.find()) {
            int iStart = matcher.start();
            int iEnd = matcher.end();
            if (matchFilter == null || matchFilter.acceptMatch(spannable, iStart, iEnd)) {
                e eVar = new e();
                String strB1 = b1(matcher.group(0), strArr, matcher);
                if (!z2 || AbstractC11908dl0.b(strB1, true, null)) {
                    eVar.a = strB1;
                    eVar.b = iStart;
                    eVar.c = iEnd;
                    arrayList.add(eVar);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void P0(View view, ValueAnimator valueAnimator) {
        view.setTranslationX((float) (r8 * 4.0f * (1.0f - r8) * Math.sin(((Float) valueAnimator.getAnimatedValue()).floatValue() * 3.141592653589793d * 4.0d) * F(4.0f)));
    }

    public static String Q(int i2, String str) {
        Date date = new Date();
        date.setTime(System.currentTimeMillis() + Utilities.b.nextInt(AppMetricaDefaultValues.DEFAULT_MAX_REPORTS_IN_DATABASE_COUNT) + 1);
        String str2 = new SimpleDateFormat("yyyyMMdd_HHmmss_SSS", Locale.US).format(date);
        if (i2 != 0) {
            return "VID_" + str2 + ".mp4";
        }
        StringBuilder sb = new StringBuilder();
        sb.append("IMG_");
        sb.append(str2);
        sb.append(Separators.DOT);
        if (TextUtils.isEmpty(str)) {
            str = "jpg";
        }
        sb.append(str);
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void Q0(Runnable runnable, View view, float f2, AbstractC12098e22 abstractC12098e22, boolean z2, float f3, float f4) {
        if (runnable != null) {
            runnable.run();
        }
        view.setTranslationX(f2);
        view.setTag(AbstractC18763pC5.spring_tag, null);
        view.setTag(AbstractC18763pC5.spring_was_translation_x_tag, null);
    }

    public static File R(boolean z2, String str) {
        try {
            File fileB = C4278El2.B(100);
            if (!z2 && fileB != null) {
                return new File(fileB, Q(0, str));
            }
            return new File(AbstractC14047hG.a.getExternalFilesDir(Environment.DIRECTORY_PICTURES), Q(0, str));
        } catch (Exception e2) {
            AbstractC6403Nl2.d(e2);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean R0(CharSequence charSequence, int i2, int i3) {
        return i2 == 0 || charSequence.charAt(i2 - 1) != '@';
    }

    public static File S() {
        return T(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void S0(ImageView imageView, AtomicBoolean atomicBoolean, Drawable drawable, ValueAnimator valueAnimator) {
        float fFloatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        float fAbs = Math.abs(fFloatValue - 0.5f) + 0.5f;
        imageView.setScaleX(fAbs);
        imageView.setScaleY(fAbs);
        if (fFloatValue < 0.5f || atomicBoolean.get()) {
            return;
        }
        atomicBoolean.set(true);
        imageView.setImageDrawable(drawable);
    }

    public static File T(boolean z2) {
        try {
            File fileU = U(z2);
            Date date = new Date();
            date.setTime(System.currentTimeMillis() + Utilities.b.nextInt(AppMetricaDefaultValues.DEFAULT_MAX_REPORTS_IN_DATABASE_COUNT) + 1);
            if (G == null) {
                G = new SimpleDateFormat("yyyyMMdd_HHmmss_SSS", Locale.US);
            }
            return new File(fileU, "VID_" + G.format(date) + ".mp4");
        } catch (Exception e2) {
            AbstractC6403Nl2.d(e2);
            return null;
        }
    }

    public static float T0(float f2, float f3, float f4) {
        return f2 + (f4 * (f3 - f2));
    }

    private static File U(boolean z2) {
        if (z2 || !AbstractC8814Xl0.e || AbstractC14047hG.a.checkSelfPermission("android.permission.READ_EXTERNAL_STORAGE") != 0) {
            return C4278El2.B(0);
        }
        if (!"mounted".equals(Environment.getExternalStorageState())) {
            if (!AbstractC8814Xl0.b) {
                return null;
            }
            AbstractC6403Nl2.a("External storage is not mounted READ/WRITE.");
            return null;
        }
        File file = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES), "EditorFiles");
        if (file.mkdirs() || file.exists()) {
            return file;
        }
        if (AbstractC8814Xl0.b) {
            AbstractC6403Nl2.a("failed to create directory");
        }
        return null;
    }

    public static int U0(int i2, int i3, float f2) {
        return (int) (i2 + (f2 * (i3 - i2)));
    }

    public static File V() {
        String externalStorageState;
        String path = null;
        try {
            externalStorageState = Environment.getExternalStorageState();
        } catch (Exception e2) {
            AbstractC6403Nl2.d(e2);
            externalStorageState = null;
        }
        if (externalStorageState == null || externalStorageState.startsWith("mounted")) {
            AbstractC6403Nl2.a("external dir mounted");
            try {
                File[] externalCacheDirs = AbstractC14047hG.a.getExternalCacheDirs();
                int i2 = 0;
                File file = externalCacheDirs[0];
                if (!TextUtils.isEmpty(AbstractC8662Wx6.K)) {
                    while (true) {
                        if (i2 < externalCacheDirs.length) {
                            File file2 = externalCacheDirs[i2];
                            if (file2 != null && file2.getAbsolutePath().startsWith(AbstractC8662Wx6.K)) {
                                file = externalCacheDirs[i2];
                                break;
                            }
                            i2++;
                        } else {
                            break;
                        }
                    }
                }
                StringBuilder sb = new StringBuilder();
                sb.append("check dir ");
                if (file != null) {
                    path = file.getPath();
                }
                sb.append(path);
                sb.append(Separators.SP);
                AbstractC6403Nl2.a(sb.toString());
                if (file != null && ((file.exists() || file.mkdirs()) && file.canWrite())) {
                    return file;
                }
                if (file != null) {
                    AbstractC6403Nl2.a("check dir file exist " + file.exists() + " can write " + file.canWrite());
                }
            } catch (Exception e3) {
                AbstractC6403Nl2.d(e3);
            }
        }
        try {
            File cacheDir = AbstractC14047hG.a.getCacheDir();
            if (cacheDir != null) {
                return cacheDir;
            }
        } catch (Exception e4) {
            AbstractC6403Nl2.d(e4);
        }
        try {
            File filesDir = AbstractC14047hG.a.getFilesDir();
            if (filesDir != null) {
                File file3 = new File(filesDir, "cache/");
                file3.mkdirs();
                if (filesDir.exists() || filesDir.mkdirs()) {
                    if (filesDir.canWrite()) {
                        return file3;
                    }
                }
            }
        } catch (Exception unused) {
        }
        return new File("");
    }

    public static void V0(Rect rect, Rect rect2, float f2, Rect rect3) {
        if (rect3 != null) {
            rect3.set(U0(rect.left, rect2.left, f2), U0(rect.top, rect2.top, f2), U0(rect.right, rect2.right, f2), U0(rect.bottom, rect2.bottom, f2));
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x0039, code lost:
    
        if (r9.startsWith("file://") == false) goto L18;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.lang.String W(android.content.Context r8, android.net.Uri r9, java.lang.String r10, java.lang.String[] r11) {
        /*
            java.lang.String r0 = "_data"
            java.lang.String[] r3 = new java.lang.String[]{r0}
            r7 = 0
            android.content.ContentResolver r1 = r8.getContentResolver()     // Catch: java.lang.Exception -> L54
            r6 = 0
            r2 = r9
            r4 = r10
            r5 = r11
            android.database.Cursor r8 = r1.query(r2, r3, r4, r5, r6)     // Catch: java.lang.Exception -> L54
            if (r8 == 0) goto L4f
            boolean r9 = r8.moveToFirst()     // Catch: java.lang.Throwable -> L3c
            if (r9 == 0) goto L4f
            int r9 = r8.getColumnIndexOrThrow(r0)     // Catch: java.lang.Throwable -> L3c
            java.lang.String r9 = r8.getString(r9)     // Catch: java.lang.Throwable -> L3c
            java.lang.String r10 = "content://"
            boolean r10 = r9.startsWith(r10)     // Catch: java.lang.Throwable -> L3c
            if (r10 != 0) goto L42
            java.lang.String r10 = "/"
            boolean r10 = r9.startsWith(r10)     // Catch: java.lang.Throwable -> L3c
            if (r10 != 0) goto L3e
            java.lang.String r10 = "file://"
            boolean r10 = r9.startsWith(r10)     // Catch: java.lang.Throwable -> L3c
            if (r10 != 0) goto L3e
            goto L42
        L3c:
            r9 = move-exception
            goto L46
        L3e:
            r8.close()     // Catch: java.lang.Exception -> L54
            return r9
        L42:
            r8.close()     // Catch: java.lang.Exception -> L54
            return r7
        L46:
            r8.close()     // Catch: java.lang.Throwable -> L4a
            goto L4e
        L4a:
            r8 = move-exception
            r9.addSuppressed(r8)     // Catch: java.lang.Exception -> L54
        L4e:
            throw r9     // Catch: java.lang.Exception -> L54
        L4f:
            if (r8 == 0) goto L54
            r8.close()     // Catch: java.lang.Exception -> L54
        L54:
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.tgwidgets.editor.messenger.AbstractC21455b.W(android.content.Context, android.net.Uri, java.lang.String, java.lang.String[]):java.lang.String");
    }

    public static void W0(RectF rectF, RectF rectF2, float f2, RectF rectF3) {
        if (rectF3 != null) {
            rectF3.set(T0(rectF.left, rectF2.left, f2), T0(rectF.top, rectF2.top, f2), T0(rectF.right, rectF2.right, f2), T0(rectF.bottom, rectF2.bottom, f2));
        }
    }

    public static ArrayList X() {
        ArrayList arrayList = null;
        File[] externalFilesDirs = AbstractC14047hG.a.getExternalFilesDirs(null);
        if (externalFilesDirs != null) {
            for (int i2 = 0; i2 < externalFilesDirs.length; i2++) {
                File file = externalFilesDirs[i2];
                if (file != null) {
                    file.getAbsolutePath();
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                    }
                    arrayList.add(externalFilesDirs[i2]);
                }
            }
        }
        if (arrayList == null) {
            arrayList = new ArrayList();
        }
        if (arrayList.isEmpty()) {
            arrayList.add(Environment.getExternalStorageDirectory());
        }
        return arrayList;
    }

    public static float X0(float f2, float f3, float f4) {
        return ((f2 + ((((((f3 - f2) + 360.0f) + 180.0f) % 360.0f) - 180.0f) * f4)) + 360.0f) % 360.0f;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public static Pair Y(C17233md2 c17233md2) {
        try {
            int i2 = 1;
            int i3 = 270;
            switch (c17233md2.f("Orientation", 1)) {
                case 2:
                    i3 = 0;
                    break;
                case 3:
                    i3 = SetRpcStruct$ComposedRpc.JOIN_GROUP_FIELD_NUMBER;
                    i2 = 0;
                    break;
                case 4:
                    i3 = 0;
                    i2 = 2;
                    break;
                case 5:
                    i2 = 2;
                    break;
                case 6:
                    i3 = 90;
                    i2 = 0;
                    break;
                case 7:
                    break;
                case 8:
                    i2 = 0;
                    break;
                default:
                    i2 = 0;
                    i3 = 0;
                    break;
            }
            return new Pair(Integer.valueOf(i3), Integer.valueOf(i2));
        } catch (Exception e2) {
            AbstractC6403Nl2.d(e2);
            return new Pair(0, 0);
        }
    }

    public static void Y0(Activity activity, int i2) {
        if (activity == null) {
            return;
        }
        try {
            c = activity.getRequestedOrientation();
            activity.setRequestedOrientation(i2);
        } catch (Exception e2) {
            AbstractC6403Nl2.d(e2);
        }
    }

    public static Pair Z(File file) {
        try {
            return Y(new C17233md2(file));
        } catch (Exception e2) {
            AbstractC6403Nl2.d(e2);
            return new Pair(0, 0);
        }
    }

    public static void Z0(CharSequence charSequence) {
        AccessibilityManager accessibilityManager = (AccessibilityManager) AbstractC14047hG.a.getSystemService("accessibility");
        if (accessibilityManager.isEnabled()) {
            AccessibilityEvent accessibilityEventObtain = AccessibilityEvent.obtain();
            accessibilityEventObtain.setEventType(16384);
            accessibilityEventObtain.getText().add(charSequence);
            accessibilityManager.sendAccessibilityEvent(accessibilityEventObtain);
        }
    }

    public static Pair a0(InputStream inputStream) {
        try {
            return Y(new C17233md2(inputStream));
        } catch (Exception e2) {
            AbstractC6403Nl2.d(e2);
            return new Pair(0, 0);
        }
    }

    public static void a1(final Utilities.b bVar, float f2) throws IllegalAccessException, NoSuchMethodException, ClassNotFoundException, SecurityException, IllegalArgumentException, InvocationTargetException {
        if (bVar == null) {
            return;
        }
        List listS = s();
        if (listS == null) {
            bVar.a(null);
            return;
        }
        try {
            Point point = h;
            int i2 = (int) (point.x / f2);
            int i3 = (int) ((point.y + d) / f2);
            final Bitmap bitmapCreateBitmap = Bitmap.createBitmap(i2, i3, Bitmap.Config.ARGB_8888);
            Canvas canvas = new Canvas(bitmapCreateBitmap);
            float f3 = 1.0f / f2;
            canvas.scale(f3, f3);
            canvas.drawColor(ir.nasim.tgwidgets.editor.ui.ActionBar.m.i0(ir.nasim.tgwidgets.editor.ui.ActionBar.m.N4));
            int[] iArr = new int[2];
            for (int i4 = 0; i4 < listS.size(); i4++) {
                View view = (View) listS.get(i4);
                ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
                if (layoutParams instanceof WindowManager.LayoutParams) {
                    WindowManager.LayoutParams layoutParams2 = (WindowManager.LayoutParams) layoutParams;
                    if ((layoutParams2.flags & 2) != 0) {
                        canvas.drawColor(QY0.k(-16777216, (int) (layoutParams2.dimAmount * 255.0f)));
                    }
                }
                canvas.save();
                view.getLocationOnScreen(iArr);
                canvas.translate(iArr[0] / f2, iArr[1] / f2);
                try {
                    view.draw(canvas);
                } catch (Exception unused) {
                }
                canvas.restore();
            }
            Utilities.stackBlurBitmap(bitmapCreateBitmap, Math.max((int) f2, Math.max(i2, i3) / SetRpcStruct$ComposedRpc.JOIN_GROUP_FIELD_NUMBER));
            m1(new Runnable() { // from class: ir.nasim.Hr
                @Override // java.lang.Runnable
                public final void run() {
                    bVar.a(bitmapCreateBitmap);
                }
            });
        } catch (Exception e2) {
            AbstractC6403Nl2.d(e2);
            m1(new Runnable() { // from class: ir.nasim.Ir
                @Override // java.lang.Runnable
                public final void run() {
                    bVar.a(null);
                }
            });
        }
    }

    public static Pair b0(String str) {
        try {
            return Y(new C17233md2(str));
        } catch (Exception unused) {
            return new Pair(0, 0);
        }
    }

    private static String b1(String str, String[] strArr, Matcher matcher) {
        boolean z2;
        int i2 = 0;
        while (true) {
            if (i2 >= strArr.length) {
                z2 = false;
                break;
            }
            String str2 = strArr[i2];
            if (str.regionMatches(true, 0, str2, 0, str2.length())) {
                String str3 = strArr[i2];
                z2 = true;
                if (!str.regionMatches(false, 0, str3, 0, str3.length())) {
                    str = strArr[i2] + str.substring(strArr[i2].length());
                }
            } else {
                i2++;
            }
        }
        if (z2 || strArr.length <= 0) {
            return str;
        }
        return strArr[0] + str;
    }

    public static int c0() {
        if (!E0()) {
            Point point = h;
            int iMin = Math.min(point.x, point.y);
            int iF = (iMin * 35) / 100;
            if (iF < F(320.0f)) {
                iF = F(320.0f);
            }
            return iMin - iF;
        }
        Point point2 = h;
        int iMin2 = Math.min(point2.x, point2.y);
        Point point3 = h;
        int iMax = Math.max(point3.x, point3.y);
        int iF2 = (iMax * 35) / 100;
        if (iF2 < F(320.0f)) {
            iF2 = F(320.0f);
        }
        return Math.min(iMin2, iMax - iF2);
    }

    public static void c1(C10743c74 c10743c74, Activity activity, ir.nasim.tgwidgets.editor.ui.ActionBar.c cVar) {
        AbstractC18106o57 abstractC18106o57I;
        String mimeTypeFromExtension;
        if (c10743c74 == null || (abstractC18106o57I = c10743c74.I()) == null) {
            return;
        }
        String strU = c10743c74.e.h != null ? C4278El2.u(abstractC18106o57I) : "";
        String str = c10743c74.e.M;
        File file = (str == null || str.length() == 0) ? null : new File(c10743c74.e.M);
        if (file == null || !file.exists()) {
            file = C4278El2.H(C22477vI7.f).R(c10743c74.e);
        }
        if (file == null || !file.exists()) {
            return;
        }
        try {
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setFlags(1);
            MimeTypeMap singleton = MimeTypeMap.getSingleton();
            int iLastIndexOf = strU.lastIndexOf(46);
            if (iLastIndexOf == -1 || ((mimeTypeFromExtension = singleton.getMimeTypeFromExtension(strU.substring(iLastIndexOf + 1).toLowerCase())) == null && ((mimeTypeFromExtension = abstractC18106o57I.i) == null || mimeTypeFromExtension.length() == 0))) {
                mimeTypeFromExtension = null;
            }
            intent.setDataAndType(FileProvider.h(activity, AbstractC14047hG.a() + ".provider", file), mimeTypeFromExtension != null ? mimeTypeFromExtension : "text/plain");
            if (mimeTypeFromExtension == null) {
                activity.startActivityForResult(intent, SIPTransactionStack.BASE_TIMER_INTERVAL);
                return;
            }
            try {
                activity.startActivityForResult(intent, SIPTransactionStack.BASE_TIMER_INTERVAL);
            } catch (Exception unused) {
                intent.setDataAndType(FileProvider.h(activity, AbstractC14047hG.a() + ".provider", file), "text/plain");
                activity.startActivityForResult(intent, SIPTransactionStack.BASE_TIMER_INTERVAL);
            }
        } catch (Exception unused2) {
            if (activity == null) {
                return;
            }
            new AlertDialog.i(activity);
            new HashMap();
            Runnable runnable = ir.nasim.tgwidgets.editor.ui.ActionBar.m.b;
            throw null;
        }
    }

    private static int d0(Context context) {
        int identifier = context.getResources().getIdentifier("navigation_bar_height", "dimen", ConstantDeviceInfo.APP_PLATFORM);
        if (identifier > 0) {
            return context.getResources().getDimensionPixelSize(identifier);
        }
        return 0;
    }

    public static boolean d1(C10743c74 c10743c74, Activity activity, m.h hVar) {
        String str = c10743c74.e.M;
        File file = (str == null || str.length() == 0) ? null : new File(c10743c74.e.M);
        if (file == null || !file.exists()) {
            file = C4278El2.H(c10743c74.N).R(c10743c74.e);
        }
        int i2 = c10743c74.m;
        return e1(file, c10743c74.N(), (i2 == 9 || i2 == 0) ? c10743c74.Z() : null, activity, hVar);
    }

    public static int e0(int i2, int i3, float f2, float f3) {
        int iRed = Color.red(i3);
        int iGreen = Color.green(i3);
        int iBlue = Color.blue(i3);
        int iAlpha = Color.alpha(i3);
        int iRed2 = Color.red(i2);
        int iGreen2 = Color.green(i2);
        int iBlue2 = Color.blue(i2);
        return Color.argb((int) ((Color.alpha(i2) + ((iAlpha - r7) * f2)) * f3), (int) (iRed2 + ((iRed - iRed2) * f2)), (int) (iGreen2 + ((iGreen - iGreen2) * f2)), (int) (iBlue2 + ((iBlue - iBlue2) * f2)));
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0038  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static boolean e1(java.io.File r6, java.lang.String r7, java.lang.String r8, android.app.Activity r9, ir.nasim.tgwidgets.editor.ui.ActionBar.m.h r10) {
        /*
            if (r6 == 0) goto Lac
            boolean r0 = r6.exists()
            if (r0 == 0) goto Lac
            android.content.Intent r0 = new android.content.Intent
            java.lang.String r1 = "android.intent.action.VIEW"
            r0.<init>(r1)
            r1 = 1
            r0.setFlags(r1)
            android.webkit.MimeTypeMap r2 = android.webkit.MimeTypeMap.getSingleton()
            r3 = 46
            int r3 = r7.lastIndexOf(r3)
            r4 = -1
            r5 = 0
            if (r3 == r4) goto L38
            int r3 = r3 + r1
            java.lang.String r7 = r7.substring(r3)
            java.lang.String r7 = r7.toLowerCase()
            java.lang.String r7 = r2.getMimeTypeFromExtension(r7)
            if (r7 != 0) goto L3a
            if (r8 == 0) goto L38
            int r7 = r8.length()
            if (r7 != 0) goto L3b
        L38:
            r8 = r5
            goto L3b
        L3a:
            r8 = r7
        L3b:
            int r7 = android.os.Build.VERSION.SDK_INT
            r2 = 26
            if (r7 < r2) goto L5f
            if (r8 == 0) goto L5f
            java.lang.String r7 = "application/vnd.android.package-archive"
            boolean r7 = r8.equals(r7)
            if (r7 == 0) goto L5f
            android.content.Context r7 = ir.nasim.AbstractC14047hG.a
            android.content.pm.PackageManager r7 = r7.getPackageManager()
            boolean r7 = ir.nasim.AbstractC21398tb3.a(r7)
            if (r7 != 0) goto L5f
            android.app.Dialog r6 = ir.nasim.tgwidgets.editor.ui.Components.AbstractC21462a.c(r9, r10)
            r6.show()
            return r1
        L5f:
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            java.lang.String r10 = ir.nasim.AbstractC14047hG.a()
            r7.append(r10)
            java.lang.String r10 = ".provider"
            r7.append(r10)
            java.lang.String r7 = r7.toString()
            android.net.Uri r7 = androidx.core.content.FileProvider.h(r9, r7, r6)
            java.lang.String r2 = "text/plain"
            if (r8 == 0) goto L7e
            r3 = r8
            goto L7f
        L7e:
            r3 = r2
        L7f:
            r0.setDataAndType(r7, r3)
            r7 = 500(0x1f4, float:7.0E-43)
            if (r8 == 0) goto La8
            r9.startActivityForResult(r0, r7)     // Catch: java.lang.Exception -> L8a
            goto Lab
        L8a:
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            java.lang.String r3 = ir.nasim.AbstractC14047hG.a()
            r8.append(r3)
            r8.append(r10)
            java.lang.String r8 = r8.toString()
            android.net.Uri r6 = androidx.core.content.FileProvider.h(r9, r8, r6)
            r0.setDataAndType(r6, r2)
            r9.startActivityForResult(r0, r7)
            goto Lab
        La8:
            r9.startActivityForResult(r0, r7)
        Lab:
            return r1
        Lac:
            r6 = 0
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.tgwidgets.editor.messenger.AbstractC21455b.e1(java.io.File, java.lang.String, java.lang.String, android.app.Activity, ir.nasim.tgwidgets.editor.ui.ActionBar.m$h):boolean");
    }

    /* JADX WARN: Removed duplicated region for block: B:36:0x00a8  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.lang.String f0(android.net.Uri r7) {
        /*
            r0 = 0
            android.content.Context r1 = ir.nasim.AbstractC14047hG.a     // Catch: java.lang.Exception -> L40
            boolean r1 = android.provider.DocumentsContract.isDocumentUri(r1, r7)     // Catch: java.lang.Exception -> L40
            if (r1 == 0) goto Lc8
            boolean r1 = y0(r7)     // Catch: java.lang.Exception -> L40
            java.lang.String r2 = ":"
            r3 = 0
            r4 = 1
            if (r1 == 0) goto L43
            java.lang.String r7 = android.provider.DocumentsContract.getDocumentId(r7)     // Catch: java.lang.Exception -> L40
            java.lang.String[] r7 = r7.split(r2)     // Catch: java.lang.Exception -> L40
            r1 = r7[r3]     // Catch: java.lang.Exception -> L40
            java.lang.String r2 = "primary"
            boolean r1 = r2.equalsIgnoreCase(r1)     // Catch: java.lang.Exception -> L40
            if (r1 == 0) goto Lef
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> L40
            r1.<init>()     // Catch: java.lang.Exception -> L40
            java.io.File r2 = android.os.Environment.getExternalStorageDirectory()     // Catch: java.lang.Exception -> L40
            r1.append(r2)     // Catch: java.lang.Exception -> L40
            java.lang.String r2 = "/"
            r1.append(r2)     // Catch: java.lang.Exception -> L40
            r7 = r7[r4]     // Catch: java.lang.Exception -> L40
            r1.append(r7)     // Catch: java.lang.Exception -> L40
            java.lang.String r7 = r1.toString()     // Catch: java.lang.Exception -> L40
            return r7
        L40:
            r7 = move-exception
            goto Lec
        L43:
            boolean r1 = x0(r7)     // Catch: java.lang.Exception -> L40
            if (r1 == 0) goto L66
            java.lang.String r7 = android.provider.DocumentsContract.getDocumentId(r7)     // Catch: java.lang.Exception -> L40
            java.lang.String r1 = "content://downloads/public_downloads"
            android.net.Uri r1 = android.net.Uri.parse(r1)     // Catch: java.lang.Exception -> L40
            java.lang.Long r7 = java.lang.Long.valueOf(r7)     // Catch: java.lang.Exception -> L40
            long r2 = r7.longValue()     // Catch: java.lang.Exception -> L40
            android.net.Uri r7 = android.content.ContentUris.withAppendedId(r1, r2)     // Catch: java.lang.Exception -> L40
            android.content.Context r1 = ir.nasim.AbstractC14047hG.a     // Catch: java.lang.Exception -> L40
            java.lang.String r7 = W(r1, r7, r0, r0)     // Catch: java.lang.Exception -> L40
            return r7
        L66:
            boolean r1 = C0(r7)     // Catch: java.lang.Exception -> L40
            if (r1 == 0) goto Lef
            java.lang.String r7 = android.provider.DocumentsContract.getDocumentId(r7)     // Catch: java.lang.Exception -> L40
            java.lang.String[] r7 = r7.split(r2)     // Catch: java.lang.Exception -> L40
            r1 = r7[r3]     // Catch: java.lang.Exception -> L40
            int r2 = r1.hashCode()     // Catch: java.lang.Exception -> L40
            r5 = 93166550(0x58d9bd6, float:1.3316821E-35)
            r6 = 2
            if (r2 == r5) goto L9e
            r5 = 100313435(0x5faa95b, float:2.3572098E-35)
            if (r2 == r5) goto L95
            r3 = 112202875(0x6b0147b, float:6.6233935E-35)
            if (r2 == r3) goto L8b
            goto La8
        L8b:
            java.lang.String r2 = "video"
            boolean r1 = r1.equals(r2)     // Catch: java.lang.Exception -> L40
            if (r1 == 0) goto La8
            r3 = r4
            goto La9
        L95:
            java.lang.String r2 = "image"
            boolean r1 = r1.equals(r2)     // Catch: java.lang.Exception -> L40
            if (r1 == 0) goto La8
            goto La9
        L9e:
            java.lang.String r2 = "audio"
            boolean r1 = r1.equals(r2)     // Catch: java.lang.Exception -> L40
            if (r1 == 0) goto La8
            r3 = r6
            goto La9
        La8:
            r3 = -1
        La9:
            if (r3 == 0) goto Lb7
            if (r3 == r4) goto Lb4
            if (r3 == r6) goto Lb1
            r1 = r0
            goto Lb9
        Lb1:
            android.net.Uri r1 = android.provider.MediaStore.Audio.Media.EXTERNAL_CONTENT_URI     // Catch: java.lang.Exception -> L40
            goto Lb9
        Lb4:
            android.net.Uri r1 = android.provider.MediaStore.Video.Media.EXTERNAL_CONTENT_URI     // Catch: java.lang.Exception -> L40
            goto Lb9
        Lb7:
            android.net.Uri r1 = android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI     // Catch: java.lang.Exception -> L40
        Lb9:
            r7 = r7[r4]     // Catch: java.lang.Exception -> L40
            java.lang.String[] r7 = new java.lang.String[]{r7}     // Catch: java.lang.Exception -> L40
            android.content.Context r2 = ir.nasim.AbstractC14047hG.a     // Catch: java.lang.Exception -> L40
            java.lang.String r3 = "_id=?"
            java.lang.String r7 = W(r2, r1, r3, r7)     // Catch: java.lang.Exception -> L40
            return r7
        Lc8:
            java.lang.String r1 = "content"
            java.lang.String r2 = r7.getScheme()     // Catch: java.lang.Exception -> L40
            boolean r1 = r1.equalsIgnoreCase(r2)     // Catch: java.lang.Exception -> L40
            if (r1 == 0) goto Ldb
            android.content.Context r1 = ir.nasim.AbstractC14047hG.a     // Catch: java.lang.Exception -> L40
            java.lang.String r7 = W(r1, r7, r0, r0)     // Catch: java.lang.Exception -> L40
            return r7
        Ldb:
            java.lang.String r1 = "file"
            java.lang.String r2 = r7.getScheme()     // Catch: java.lang.Exception -> L40
            boolean r1 = r1.equalsIgnoreCase(r2)     // Catch: java.lang.Exception -> L40
            if (r1 == 0) goto Lef
            java.lang.String r7 = r7.getPath()     // Catch: java.lang.Exception -> L40
            return r7
        Lec:
            ir.nasim.AbstractC6403Nl2.d(r7)
        Lef:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.tgwidgets.editor.messenger.AbstractC21455b.f0(android.net.Uri):java.lang.String");
    }

    private static void f1(ArrayList arrayList) {
        int i2;
        Collections.sort(arrayList, new Comparator() { // from class: ir.nasim.tgwidgets.editor.messenger.a
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                return AbstractC21455b.L0((AbstractC21455b.e) obj, (AbstractC21455b.e) obj2);
            }
        });
        int size = arrayList.size();
        int i3 = 0;
        while (i3 < size - 1) {
            e eVar = (e) arrayList.get(i3);
            int i4 = i3 + 1;
            e eVar2 = (e) arrayList.get(i4);
            int i5 = eVar.b;
            int i6 = eVar2.b;
            if (i5 <= i6 && (i2 = eVar.c) > i6) {
                int i7 = eVar2.c;
                int i8 = (i7 > i2 && i2 - i5 <= i7 - i6) ? i2 - i5 < i7 - i6 ? i3 : -1 : i4;
                if (i8 != -1) {
                    arrayList.remove(i8);
                    size--;
                }
            }
            i3 = i4;
        }
    }

    public static int g0() {
        if (o == null) {
            o = Integer.valueOf(SimpleResolver.DEFAULT_EDNS_PAYLOADSIZE);
        }
        return o.intValue();
    }

    public static void g1(Bitmap bitmap) {
        h1(Collections.singletonList(bitmap));
    }

    public static float h0(float f2, boolean z2) {
        return (f2 / 2.54f) * (z2 ? p.xdpi : p.ydpi);
    }

    public static void h1(final List list) {
        if (list == null || list.isEmpty()) {
            return;
        }
        n1(new Runnable() { // from class: ir.nasim.Lr
            @Override // java.lang.Runnable
            public final void run() {
                AbstractC21455b.N0(list);
            }
        }, 36L);
    }

    public static Point i0() {
        Point point = new Point();
        try {
            ((WindowManager) AbstractC14047hG.a.getSystemService("window")).getDefaultDisplay().getRealSize(point);
        } catch (Exception e2) {
            AbstractC6403Nl2.d(e2);
        }
        return point;
    }

    public static void i1(View view) {
        if (view == null || view.getParent() == null) {
            return;
        }
        ((ViewGroup) view.getParent()).removeView(view);
    }

    public static ArrayList j0() {
        File externalStorageDirectory;
        String absolutePath;
        int iIndexOf;
        HashSet hashSet = new HashSet();
        ArrayList arrayList = null;
        File[] externalFilesDirs = AbstractC14047hG.a.getExternalFilesDirs(null);
        if (externalFilesDirs != null) {
            for (File file : externalFilesDirs) {
                if (file != null && (iIndexOf = (absolutePath = file.getAbsolutePath()).indexOf("/Android")) >= 0) {
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                    }
                    File file2 = new File(absolutePath.substring(0, iIndexOf));
                    for (int i2 = 0; i2 < arrayList.size(); i2++) {
                        ((File) arrayList.get(i2)).getPath().equals(file2.getPath());
                    }
                    if (!hashSet.contains(file2.getAbsolutePath())) {
                        hashSet.add(file2.getAbsolutePath());
                        arrayList.add(file2);
                    }
                }
            }
        }
        if (arrayList == null) {
            arrayList = new ArrayList();
        }
        if (arrayList.isEmpty() && (externalStorageDirectory = Environment.getExternalStorageDirectory()) != null && !hashSet.contains(externalStorageDirectory.getAbsolutePath())) {
            arrayList.add(externalStorageDirectory);
        }
        return arrayList;
    }

    public static CharSequence j1(String str, CharSequence charSequence, CharSequence charSequence2) {
        SpannableStringBuilder spannableStringBuilder = charSequence instanceof SpannableStringBuilder ? (SpannableStringBuilder) charSequence : new SpannableStringBuilder(charSequence);
        int iIndexOf = TextUtils.indexOf(charSequence, str);
        if (iIndexOf >= 0) {
            spannableStringBuilder.replace(iIndexOf, str.length() + iIndexOf, charSequence2);
        }
        return spannableStringBuilder;
    }

    public static int k0(Context context) {
        int identifier = context.getResources().getIdentifier("status_bar_height", "dimen", ConstantDeviceInfo.APP_PLATFORM);
        if (identifier > 0) {
            return context.getResources().getDimensionPixelSize(identifier);
        }
        return 0;
    }

    public static SpannableStringBuilder k1(String str) {
        return l1(str, 11, new Object[0]);
    }

    public static boolean l(Spannable spannable, int i2) {
        return m(spannable, i2, false);
    }

    public static byte[] l0(String str) {
        try {
            return str.getBytes("UTF-8");
        } catch (Exception unused) {
            return new byte[0];
        }
    }

    public static SpannableStringBuilder l1(String str, int i2, Object... objArr) {
        try {
            StringBuilder sb = new StringBuilder(str);
            if ((i2 & 1) != 0) {
                while (true) {
                    int iIndexOf = sb.indexOf("<br>");
                    if (iIndexOf == -1) {
                        break;
                    }
                    sb.replace(iIndexOf, iIndexOf + 4, Separators.RETURN);
                }
                while (true) {
                    int iIndexOf2 = sb.indexOf("<br/>");
                    if (iIndexOf2 == -1) {
                        break;
                    }
                    sb.replace(iIndexOf2, iIndexOf2 + 5, Separators.RETURN);
                }
            }
            ArrayList arrayList = new ArrayList();
            if ((i2 & 2) != 0) {
                while (true) {
                    int iIndexOf3 = sb.indexOf("<b>");
                    if (iIndexOf3 == -1) {
                        break;
                    }
                    sb.replace(iIndexOf3, iIndexOf3 + 3, "");
                    int iIndexOf4 = sb.indexOf("</b>");
                    if (iIndexOf4 == -1) {
                        iIndexOf4 = sb.indexOf("<b>");
                    }
                    sb.replace(iIndexOf4, iIndexOf4 + 4, "");
                    arrayList.add(Integer.valueOf(iIndexOf3));
                    arrayList.add(Integer.valueOf(iIndexOf4));
                }
                while (true) {
                    int iIndexOf5 = sb.indexOf("**");
                    if (iIndexOf5 == -1) {
                        break;
                    }
                    sb.replace(iIndexOf5, iIndexOf5 + 2, "");
                    int iIndexOf6 = sb.indexOf("**");
                    if (iIndexOf6 >= 0) {
                        sb.replace(iIndexOf6, iIndexOf6 + 2, "");
                        arrayList.add(Integer.valueOf(iIndexOf5));
                        arrayList.add(Integer.valueOf(iIndexOf6));
                    }
                }
            }
            if ((i2 & 8) != 0) {
                while (true) {
                    int iIndexOf7 = sb.indexOf("**");
                    if (iIndexOf7 == -1) {
                        break;
                    }
                    sb.replace(iIndexOf7, iIndexOf7 + 2, "");
                    int iIndexOf8 = sb.indexOf("**");
                    if (iIndexOf8 >= 0) {
                        sb.replace(iIndexOf8, iIndexOf8 + 2, "");
                        arrayList.add(Integer.valueOf(iIndexOf7));
                        arrayList.add(Integer.valueOf(iIndexOf8));
                    }
                }
            }
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(sb);
            for (int i3 = 0; i3 < arrayList.size() / 2; i3++) {
                int i4 = i3 * 2;
                spannableStringBuilder.setSpan(new C19819qz7(q0("fonts/rmedium.ttf")), ((Integer) arrayList.get(i4)).intValue(), ((Integer) arrayList.get(i4 + 1)).intValue(), 33);
            }
            return spannableStringBuilder;
        } catch (Exception e2) {
            AbstractC6403Nl2.d(e2);
            return new SpannableStringBuilder(str);
        }
    }

    public static boolean m(Spannable spannable, int i2, boolean z2) {
        return n(spannable, i2, z2, true);
    }

    public static String m0(String str) {
        try {
            return (String) Class.forName("android.os.SystemProperties").getMethod("get", String.class).invoke(null, str);
        } catch (Exception unused) {
            return null;
        }
    }

    public static void m1(Runnable runnable) {
        n1(runnable, 0L);
    }

    public static boolean n(Spannable spannable, int i2, boolean z2, boolean z3) {
        if (spannable == null || A(spannable.toString()) || i2 == 0) {
            return false;
        }
        URLSpan[] uRLSpanArr = (URLSpan[]) spannable.getSpans(0, spannable.length(), URLSpan.class);
        for (int length = uRLSpanArr.length - 1; length >= 0; length--) {
            URLSpan uRLSpan = uRLSpanArr[length];
            if (!(uRLSpan instanceof URLSpanReplacement) || z3) {
                spannable.removeSpan(uRLSpan);
            }
        }
        ArrayList arrayList = new ArrayList();
        if (!z2 && (i2 & 4) != 0) {
            Linkify.addLinks(spannable, 4);
        }
        if ((i2 & 1) != 0) {
            P(arrayList, spannable, AbstractC21820uB3.g, new String[]{"http://", "https://", "tg://"}, E, z2);
        }
        f1(arrayList);
        if (arrayList.size() == 0) {
            return false;
        }
        int size = arrayList.size();
        for (int i3 = 0; i3 < size; i3++) {
            e eVar = (e) arrayList.get(i3);
            URLSpan[] uRLSpanArr2 = (URLSpan[]) spannable.getSpans(eVar.b, eVar.c, URLSpan.class);
            if (uRLSpanArr2 != null && uRLSpanArr2.length > 0) {
                for (URLSpan uRLSpan2 : uRLSpanArr2) {
                    spannable.removeSpan(uRLSpan2);
                    if (!(uRLSpan2 instanceof URLSpanReplacement) || z3) {
                        spannable.removeSpan(uRLSpan2);
                    }
                }
            }
            String strReplaceAll = eVar.a;
            if (strReplaceAll != null) {
                strReplaceAll = strReplaceAll.replaceAll("∕|⁄|%E2%81%84|%E2%88%95", Separators.SLASH);
            }
            spannable.setSpan(new URLSpan(strReplaceAll), eVar.b, eVar.c, 33);
        }
        return true;
    }

    public static int n0(String str, String str2, boolean z2) {
        if (str == null || str.length() == 0) {
            return z2 ? D[0] : C[0];
        }
        int iCharAt = (str.contains(".doc") || str.contains(".txt") || str.contains(".psd")) ? 0 : (str.contains(".xls") || str.contains(".csv")) ? 1 : (str.contains(".pdf") || str.contains(".ppt") || str.contains(".key")) ? 2 : (str.contains(".zip") || str.contains(".rar") || str.contains(".ai") || str.contains(".mp3") || str.contains(".mov") || str.contains(".avi")) ? 3 : -1;
        if (iCharAt == -1) {
            int iLastIndexOf = str.lastIndexOf(46);
            String strSubstring = iLastIndexOf == -1 ? "" : str.substring(iLastIndexOf + 1);
            iCharAt = strSubstring.length() != 0 ? strSubstring.charAt(0) % C.length : str.charAt(0) % C.length;
        }
        return z2 ? D[iCharAt] : C[iCharAt];
    }

    public static void n1(Runnable runnable, long j2) {
        if (AbstractC14047hG.b == null) {
            return;
        }
        if (j2 == 0) {
            AbstractC14047hG.b.post(runnable);
        } else {
            AbstractC14047hG.b.postDelayed(runnable, j2);
        }
    }

    public static void o(File file) {
        Uri uriFromFile = Uri.fromFile(file);
        if (uriFromFile == null) {
            return;
        }
        try {
            Intent intent = new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE");
            intent.setData(uriFromFile);
            AbstractC14047hG.a.sendBroadcast(intent);
        } catch (Exception e2) {
            AbstractC6403Nl2.d(e2);
        }
    }

    public static int o0() {
        if (b == null) {
            b = Integer.valueOf(ViewConfiguration.get(C5721Ko.b).getScaledTouchSlop());
        }
        return b.intValue();
    }

    public static void o1(View view, boolean z2) {
        if (view == null || Build.VERSION.SDK_INT < 26) {
            return;
        }
        int systemUiVisibility = view.getSystemUiVisibility();
        if (((systemUiVisibility & 16) > 0) != z2) {
            view.setSystemUiVisibility(z2 ? systemUiVisibility | 16 : systemUiVisibility & (-17));
        }
    }

    public static boolean p(CharSequence charSequence) {
        try {
            ClipboardManager clipboardManager = (ClipboardManager) AbstractC14047hG.a.getSystemService("clipboard");
            if (charSequence instanceof Spanned) {
                clipboardManager.setPrimaryClip(ClipData.newHtmlText("label", charSequence, charSequence.toString()));
                return true;
            }
            clipboardManager.setPrimaryClip(ClipData.newPlainText("label", charSequence));
            return true;
        } catch (Exception e2) {
            AbstractC6403Nl2.d(e2);
            return false;
        }
    }

    public static CharSequence p0(CharSequence charSequence) {
        if (charSequence != null && charSequence.length() != 0) {
            while (charSequence.length() > 0 && (charSequence.charAt(0) == '\n' || charSequence.charAt(0) == ' ')) {
                charSequence = charSequence.subSequence(1, charSequence.length());
            }
            while (charSequence.length() > 0 && (charSequence.charAt(charSequence.length() - 1) == '\n' || charSequence.charAt(charSequence.length() - 1) == ' ')) {
                charSequence = charSequence.subSequence(0, charSequence.length() - 1);
            }
        }
        return charSequence;
    }

    public static void p1(Window window, boolean z2) {
        if (window != null) {
            o1(window.getDecorView(), z2);
        }
    }

    public static void q(ColorMatrix colorMatrix, float f2) {
        if (colorMatrix == null) {
            return;
        }
        float f3 = f2 * 255.0f;
        colorMatrix.postConcat(new ColorMatrix(new float[]{1.0f, 0.0f, 0.0f, 0.0f, f3, 0.0f, 1.0f, 0.0f, 0.0f, f3, 0.0f, 0.0f, 1.0f, 0.0f, f3, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f}));
    }

    public static Typeface q0(String str) {
        Typeface typefaceCreateFromAsset;
        Typeface typeface;
        Hashtable hashtable = a;
        synchronized (hashtable) {
            try {
                if (!hashtable.containsKey(str)) {
                    try {
                        if (str.split(Separators.SLASH)[1].startsWith("r")) {
                            typefaceCreateFromAsset = str.contains("medium") ? C6011Lu2.i() : str.contains("regular") ? C6011Lu2.k() : C6011Lu2.k();
                        } else if (Build.VERSION.SDK_INT >= 26) {
                            AbstractC3627Br.a();
                            Typeface.Builder builderA = AbstractC3388Ar.a(AbstractC14047hG.a.getAssets(), str);
                            if (str.contains("medium")) {
                                builderA.setWeight(700);
                            }
                            if (str.contains("italic")) {
                                builderA.setItalic(true);
                            }
                            typefaceCreateFromAsset = builderA.build();
                        } else {
                            typefaceCreateFromAsset = Typeface.createFromAsset(AbstractC14047hG.a.getAssets(), str);
                        }
                        hashtable.put(str, typefaceCreateFromAsset);
                    } catch (Exception e2) {
                        if (AbstractC8814Xl0.b) {
                            AbstractC6403Nl2.b("Could not get typeface '" + str + "' because " + e2.getMessage());
                        }
                        return null;
                    }
                }
                typeface = (Typeface) hashtable.get(str);
            } catch (Throwable th) {
                throw th;
            }
        }
        return typeface;
    }

    public static void q1(Window window, boolean z2) {
        r1(window, z2, false);
    }

    public static void r(ColorMatrix colorMatrix, float f2) {
        if (colorMatrix == null) {
            return;
        }
        float f3 = f2 + 1.0f;
        float f4 = 1.0f - f3;
        float f5 = 0.3086f * f4;
        float f6 = 0.6094f * f4;
        float f7 = f4 * 0.082f;
        colorMatrix.postConcat(new ColorMatrix(new float[]{f5 + f3, f6, f7, 0.0f, 0.0f, f5, f6 + f3, f7, 0.0f, 0.0f, f5, f6, f3 + f7, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f}));
    }

    public static Vibrator r0() {
        if (I == null) {
            I = (Vibrator) AbstractC14047hG.a.getSystemService("vibrator");
        }
        return I;
    }

    public static void r1(Window window, boolean z2, boolean z3) {
        View decorView = window.getDecorView();
        int systemUiVisibility = decorView.getSystemUiVisibility();
        if (z2) {
            if ((systemUiVisibility & 8192) == 0) {
                decorView.setSystemUiVisibility(systemUiVisibility | 8192);
            }
            if (window.getStatusBarColor() != 0) {
                window.setStatusBarColor(0);
                return;
            }
            return;
        }
        if ((systemUiVisibility & 8192) != 0) {
            decorView.setSystemUiVisibility(systemUiVisibility & (-8193));
        }
        if (window.getStatusBarColor() != 0) {
            window.setStatusBarColor(0);
        }
    }

    public static List s() throws IllegalAccessException, NoSuchMethodException, ClassNotFoundException, SecurityException, IllegalArgumentException, InvocationTargetException {
        try {
            if (Build.VERSION.SDK_INT >= 29) {
                return WindowInspector.getGlobalWindowViews();
            }
            Class<?> cls = Class.forName("android.view.WindowManagerGlobal");
            Object objInvoke = cls.getMethod("getInstance", null).invoke(null, null);
            Method method = cls.getMethod("getViewRootNames", null);
            Method method2 = cls.getMethod("getRootView", String.class);
            String[] strArr = (String[]) method.invoke(objInvoke, null);
            ArrayList arrayList = new ArrayList();
            for (String str : strArr) {
                arrayList.add((View) method2.invoke(objInvoke, str));
            }
            return arrayList;
        } catch (Exception e2) {
            AbstractC6403Nl2.c("allGlobalViews()", e2);
            return null;
        }
    }

    public static int s0(View view) {
        if (view != null && view.getHeight() != h.y && view.getHeight() != h.y - d) {
            try {
                WindowInsets rootWindowInsets = view.getRootWindowInsets();
                if (rootWindowInsets != null) {
                    return rootWindowInsets.getStableInsetBottom();
                }
                return 0;
            } catch (Exception e2) {
                AbstractC6403Nl2.d(e2);
            }
        }
        return 0;
    }

    public static void s1(Window window, int i2) {
        t1(window, i2, true);
    }

    public static void t(Runnable runnable) {
        if (AbstractC14047hG.b == null) {
            return;
        }
        AbstractC14047hG.b.removeCallbacks(runnable);
    }

    public static void t0(View view) {
        if (view == null) {
            return;
        }
        try {
            InputMethodManager inputMethodManager = (InputMethodManager) view.getContext().getSystemService("input_method");
            if (inputMethodManager.isActive()) {
                inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(), 0);
            }
        } catch (Exception e2) {
            AbstractC6403Nl2.d(e2);
        }
    }

    public static void t1(Window window, int i2, boolean z2) {
        u1(window, i2, z2, null);
    }

    public static float u(float f2, float f3, float f4, float f5) {
        float f6 = (1.0f / f4) * f5;
        return AbstractC22000uV3.a((f2 - ((f3 / f4) * (1.0f - f6))) / f6, 0.0f, 1.0f);
    }

    public static boolean u0(int i2, int i3, int i4, int i5) {
        return Math.max(i2, i3) >= Math.min(i4, i5) && Math.max(i4, i5) >= Math.min(i2, i3);
    }

    public static void u1(final Window window, int i2, boolean z2, final c cVar) {
        ValueAnimator valueAnimator;
        if (window == null) {
            return;
        }
        HashMap map = H;
        if (map != null && (valueAnimator = (ValueAnimator) map.get(window)) != null) {
            valueAnimator.cancel();
            H.remove(window);
        }
        if (!z2) {
            if (cVar != null) {
                cVar.a(i2);
            }
            try {
                window.setNavigationBarColor(i2);
                return;
            } catch (Exception unused) {
                return;
            }
        }
        ValueAnimator valueAnimatorOfArgb = ValueAnimator.ofArgb(window.getNavigationBarColor(), i2);
        valueAnimatorOfArgb.addUpdateListener(new ValueAnimator.AnimatorUpdateListener(cVar, window) { // from class: ir.nasim.Jr
            public final /* synthetic */ Window a;

            {
                this.a = window;
            }

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator2) {
                AbstractC21455b.O0(null, this.a, valueAnimator2);
            }
        });
        valueAnimatorOfArgb.addListener(new C1578b(window));
        valueAnimatorOfArgb.setDuration(200L);
        valueAnimatorOfArgb.setInterpolator(InterpolatorC12631ew1.f);
        valueAnimatorOfArgb.start();
        if (H == null) {
            H = new HashMap();
        }
        H.put(window, valueAnimatorOfArgb);
    }

    public static void v(Context context, Configuration configuration) {
        Display defaultDisplay;
        try {
            float f2 = g;
            g = context.getResources().getDisplayMetrics().density;
            if (f && Math.abs(f2 - r2) > 0.001d) {
                ir.nasim.tgwidgets.editor.ui.ActionBar.m.V0(context);
            }
            boolean z2 = true;
            f = true;
            if (configuration == null) {
                configuration = context.getResources().getConfiguration();
            }
            if (configuration.keyboard == 1 || configuration.hardKeyboardHidden != 1) {
                z2 = false;
            }
            r = z2;
            WindowManager windowManager = (WindowManager) context.getSystemService("window");
            if (windowManager != null && (defaultDisplay = windowManager.getDefaultDisplay()) != null) {
                defaultDisplay.getMetrics(p);
                defaultDisplay.getSize(h);
                float refreshRate = defaultDisplay.getRefreshRate();
                i = refreshRate;
                j = 1000.0f / refreshRate;
            }
            if (configuration.screenWidthDp != 0) {
                int iCeil = (int) Math.ceil(r1 * g);
                if (Math.abs(h.x - iCeil) > 3) {
                    h.x = iCeil;
                }
            }
            if (configuration.screenHeightDp != 0) {
                int iCeil2 = (int) Math.ceil(r1 * g);
                if (Math.abs(h.y - iCeil2) > 3) {
                    h.y = iCeil2;
                }
            }
            if (k == 0) {
                if (F0()) {
                    k = (int) (c0() * 0.6f);
                    l = c0() - F(28.0f);
                } else {
                    Point point = h;
                    k = (int) (Math.min(point.x, point.y) * 0.6f);
                    Point point2 = h;
                    l = Math.min(point2.x, point2.y) - F(28.0f);
                }
                m = F(2.0f);
            }
            if (AbstractC8814Xl0.b) {
                if (d == 0) {
                    J(context);
                }
                AbstractC6403Nl2.b("density = " + g + " display size = " + h.x + Separators.SP + h.y + Separators.SP + p.xdpi + "x" + p.ydpi + ", screen layout: " + configuration.screenLayout + ", statusbar height: " + d + ", navbar height: " + e);
            }
            b = Integer.valueOf(ViewConfiguration.get(context).getScaledTouchSlop());
        } catch (Exception e2) {
            AbstractC6403Nl2.d(e2);
        }
    }

    public static boolean v0() {
        return w0();
    }

    public static void v1(Matrix matrix, RectF rectF, RectF rectF2, int i2, int i3, boolean z2) {
        float fHeight;
        float fWidth;
        float fHeight2;
        boolean z3;
        float f2;
        float f3;
        float fHeight3;
        float fHeight4;
        if (i2 == 90 || i2 == 270) {
            fHeight = rectF2.height() / rectF.width();
            fWidth = rectF2.width();
            fHeight2 = rectF.height();
        } else {
            fHeight = rectF2.width() / rectF.width();
            fWidth = rectF2.height();
            fHeight2 = rectF.height();
        }
        float f4 = fWidth / fHeight2;
        if (fHeight < f4) {
            fHeight = f4;
            z3 = true;
        } else {
            z3 = false;
        }
        if (z2) {
            matrix.setTranslate(rectF2.left, rectF2.top);
        }
        if (i2 == 90) {
            matrix.preRotate(90.0f);
            if (i3 == 1) {
                matrix.preScale(-1.0f, 1.0f);
            } else if (i3 == 2) {
                matrix.preScale(1.0f, -1.0f);
            }
            matrix.preTranslate(0.0f, -rectF2.width());
        } else if (i2 == 180) {
            matrix.preRotate(180.0f);
            if (i3 == 1) {
                matrix.preScale(-1.0f, 1.0f);
            } else if (i3 == 2) {
                matrix.preScale(1.0f, -1.0f);
            }
            matrix.preTranslate(-rectF2.width(), -rectF2.height());
        } else if (i2 == 270) {
            matrix.preRotate(270.0f);
            if (i3 == 1) {
                matrix.preScale(-1.0f, 1.0f);
            } else if (i3 == 2) {
                matrix.preScale(1.0f, -1.0f);
            }
            matrix.preTranslate(-rectF2.height(), 0.0f);
        }
        if (z2) {
            f2 = (-rectF.left) * fHeight;
            f3 = (-rectF.top) * fHeight;
        } else {
            f2 = rectF2.left - (rectF.left * fHeight);
            f3 = rectF2.top - (rectF.top * fHeight);
        }
        if (z3) {
            fHeight3 = rectF2.width();
            fHeight4 = rectF.width();
        } else {
            fHeight3 = rectF2.height();
            fHeight4 = rectF.height();
        }
        float f5 = (fHeight3 - (fHeight4 * fHeight)) / 2.0f;
        if (z3) {
            f2 += f5;
        } else {
            f3 += f5;
        }
        matrix.preScale(fHeight, fHeight);
        if (z2) {
            matrix.preTranslate(f2, f3);
        }
    }

    public static boolean w(String str) {
        boolean z2;
        boolean z3;
        if (str == null) {
            return false;
        }
        try {
            int length = str.length();
            z2 = false;
            z3 = false;
            for (int i2 = 0; i2 < length; i2++) {
                try {
                    char cCharAt = str.charAt(i2);
                    if (cCharAt != '.' && cCharAt != '-' && cCharAt != '/' && cCharAt != '+' && (cCharAt < '0' || cCharAt > '9')) {
                        if ((cCharAt < 'a' || cCharAt > 'z') && (cCharAt < 'A' || cCharAt > 'Z')) {
                            z3 = true;
                        } else {
                            z2 = true;
                        }
                        if (z2 && z3) {
                            break;
                        }
                    }
                } catch (Exception e2) {
                    e = e2;
                    AbstractC6403Nl2.d(e);
                    return !z2 ? false : false;
                }
            }
        } catch (Exception e3) {
            e = e3;
            z2 = false;
            z3 = false;
        }
        if (!z2 && z3) {
            return true;
        }
    }

    public static boolean w0() {
        if (v == null) {
            v = (AccessibilityManager) AbstractC14047hG.a.getSystemService("accessibility");
        }
        return v.isEnabled() && v.isTouchExplorationEnabled();
    }

    public static void w1(ScrollView scrollView, int i2) throws NoSuchFieldException, SecurityException {
        if (Build.VERSION.SDK_INT >= 29) {
            scrollView.setTopEdgeEffectColor(i2);
            scrollView.setBottomEdgeEffectColor(i2);
            return;
        }
        try {
            Field declaredField = ScrollView.class.getDeclaredField("mEdgeGlowTop");
            declaredField.setAccessible(true);
            EdgeEffect edgeEffect = (EdgeEffect) declaredField.get(scrollView);
            if (edgeEffect != null) {
                edgeEffect.setColor(i2);
            }
            Field declaredField2 = ScrollView.class.getDeclaredField("mEdgeGlowBottom");
            declaredField2.setAccessible(true);
            EdgeEffect edgeEffect2 = (EdgeEffect) declaredField2.get(scrollView);
            if (edgeEffect2 != null) {
                edgeEffect2.setColor(i2);
            }
        } catch (Exception unused) {
        }
    }

    public static boolean x(Context context) {
        return Settings.canDrawOverlays(context);
    }

    public static boolean x0(Uri uri) {
        return "com.android.providers.downloads.documents".equals(uri.getAuthority());
    }

    public static void x1(final View view) {
        if (view == null) {
            return;
        }
        Object tag = view.getTag(AbstractC18763pC5.shake_animation);
        if (tag instanceof ValueAnimator) {
            ((ValueAnimator) tag).cancel();
        }
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        valueAnimatorOfFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: ir.nasim.Fr
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                AbstractC21455b.P0(view, valueAnimator);
            }
        });
        valueAnimatorOfFloat.addListener(new a(view));
        valueAnimatorOfFloat.setDuration(300L);
        valueAnimatorOfFloat.start();
        view.setTag(AbstractC18763pC5.shake_animation, valueAnimatorOfFloat);
    }

    public static ByteBuffer y(ByteBuffer byteBuffer) {
        ByteBuffer byteBufferAllocate;
        try {
            byteBufferAllocate = ByteBuffer.allocate(byteBuffer.capacity());
        } catch (OutOfMemoryError unused) {
            System.gc();
            byteBufferAllocate = ByteBuffer.allocate(byteBuffer.capacity());
        }
        byteBuffer.rewind();
        byteBufferAllocate.put(byteBuffer);
        byteBuffer.rewind();
        byteBufferAllocate.flip();
        return byteBufferAllocate;
    }

    public static boolean y0(Uri uri) {
        return "com.android.externalstorage.documents".equals(uri.getAuthority());
    }

    public static void y1(View view, float f2) {
        z1(view, f2, null);
    }

    public static float z(int i2) {
        return (((Color.red(i2) * 0.2126f) + (Color.green(i2) * 0.7152f)) + (Color.blue(i2) * 0.0722f)) / 255.0f;
    }

    public static boolean z0(int i2) {
        return B0(null, i2);
    }

    public static void z1(final View view, float f2, final Runnable runnable) {
        int iF = F(f2);
        if (view.getTag(AbstractC18763pC5.spring_tag) != null) {
            ((C16463lJ6) view.getTag(AbstractC18763pC5.spring_tag)).d();
        }
        Float f3 = (Float) view.getTag(AbstractC18763pC5.spring_was_translation_x_tag);
        if (f3 != null) {
            view.setTranslationX(f3.floatValue());
        }
        view.setTag(AbstractC18763pC5.spring_was_translation_x_tag, Float.valueOf(view.getTranslationX()));
        final float translationX = view.getTranslationX();
        C16463lJ6 c16463lJ6 = (C16463lJ6) ((C16463lJ6) new C16463lJ6(view, AbstractC12098e22.m, translationX).A(new C17645nJ6(translationX).f(600.0f)).q((-iF) * 100)).b(new AbstractC12098e22.q() { // from class: ir.nasim.Kr
            @Override // ir.nasim.AbstractC12098e22.q
            public final void a(AbstractC12098e22 abstractC12098e22, boolean z2, float f4, float f5) {
                AbstractC21455b.Q0(runnable, view, translationX, abstractC12098e22, z2, f4, f5);
            }
        });
        view.setTag(AbstractC18763pC5.spring_tag, c16463lJ6);
        c16463lJ6.s();
    }
}
