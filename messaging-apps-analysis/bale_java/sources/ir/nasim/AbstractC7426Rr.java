package ir.nasim;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.Resources;
import android.gov.nist.javax.sip.stack.SIPTransactionStack;
import android.graphics.Point;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.os.VibrationEffect;
import android.os.Vibrator;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.View;
import android.view.Window;
import android.view.WindowInsets;
import android.webkit.MimeTypeMap;
import android.webkit.URLUtil;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.core.content.FileProvider;
import androidx.recyclerview.widget.RecyclerView;
import ir.nasim.AbstractC7426Rr;
import ir.nasim.database.dailogLists.DialogEntity;
import java.io.File;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import org.xbill.DNS.SimpleResolver;

/* renamed from: ir.nasim.Rr, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public abstract class AbstractC7426Rr {
    public static final a a;
    private static Integer b;
    private static final InterfaceC9173Yu3 c;
    private static boolean d;
    private static boolean e;
    private static String f;
    private static int g;
    private static Point h;
    private static DisplayMetrics i;
    private static volatile boolean j;
    private static volatile boolean k;
    private static volatile boolean l;
    private static boolean m;
    private static Toast n;
    private static final int o;
    private static String p;

    /* renamed from: ir.nasim.Rr$a */
    public static final class a {

        /* renamed from: ir.nasim.Rr$a$a, reason: collision with other inner class name */
        public static final class C0602a extends AbstractC9160Yt {
            final /* synthetic */ View a;
            final /* synthetic */ int b;
            final /* synthetic */ float c;

            C0602a(View view, int i, float f) {
                this.a = view;
                this.b = i;
                this.c = f;
            }

            @Override // ir.nasim.AbstractC9160Yt, android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                AbstractC13042fc3.i(animator, "animation");
                a aVar = AbstractC7426Rr.a;
                View view = this.a;
                int i = this.b;
                aVar.S(view, i == 5 ? 0.0f : -this.c, i + 1);
            }
        }

        private a() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void I(Vibrator vibrator, int i) {
            AbstractC13042fc3.i(vibrator, "$v");
            if (Build.VERSION.SDK_INT >= 26) {
                vibrator.vibrate(VibrationEffect.createOneShot(i, 80));
            } else {
                vibrator.vibrate(i);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void V(Context context, String str) {
            Toast.makeText(context, str, 0).show();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void W(int i) {
            if (AbstractC7426Rr.n == null) {
                AbstractC7426Rr.n = Toast.makeText(new ContextThemeWrapper(C5721Ko.a.d(), AbstractC23035wE5.Theme_Bale_Base), i, 0);
            }
            Toast toast = AbstractC7426Rr.n;
            if (toast != null) {
                toast.setText(i);
            }
            Toast toast2 = AbstractC7426Rr.n;
            if (toast2 != null) {
                toast2.show();
            }
        }

        private final void X(Activity activity, File file, String str, Intent intent) {
            intent.setDataAndType(FileProvider.h(activity, activity.getApplicationContext().getPackageName() + ".provider", file), str == null ? "text/plain" : str);
            if (str == null) {
                activity.startActivityForResult(intent, SIPTransactionStack.BASE_TIMER_INTERVAL);
                return;
            }
            try {
                activity.startActivityForResult(intent, SIPTransactionStack.BASE_TIMER_INTERVAL);
            } catch (Exception unused) {
                intent.setDataAndType(FileProvider.h(activity, activity.getApplicationContext().getPackageName() + ".provider", file), "text/plain");
                activity.startActivityForResult(intent, SIPTransactionStack.BASE_TIMER_INTERVAL);
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:24:0x0060 A[Catch: Exception -> 0x0037, TryCatch #1 {Exception -> 0x0037, blocks: (B:3:0x000c, B:5:0x0012, B:7:0x002c, B:25:0x0075, B:28:0x0086, B:30:0x0090, B:31:0x009b, B:13:0x0039, B:18:0x0051, B:22:0x005c, B:21:0x0058, B:17:0x0047, B:24:0x0060, B:14:0x003b), top: B:37:0x000c, inners: #0 }] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final void A(android.content.Context r5, android.net.Uri r6) {
            /*
                r4 = this;
                java.lang.String r0 = "NON_FATAL_EXCEPTION"
                java.lang.String r1 = "context"
                ir.nasim.AbstractC13042fc3.i(r5, r1)
                java.lang.String r1 = "uri"
                ir.nasim.AbstractC13042fc3.i(r6, r1)
                java.lang.String r1 = r6.getScheme()     // Catch: java.lang.Exception -> L37
                if (r1 == 0) goto L60
                java.util.Locale r2 = java.util.Locale.getDefault()     // Catch: java.lang.Exception -> L37
                java.lang.String r3 = "getDefault(...)"
                ir.nasim.AbstractC13042fc3.h(r2, r3)     // Catch: java.lang.Exception -> L37
                java.lang.String r1 = r1.toLowerCase(r2)     // Catch: java.lang.Exception -> L37
                java.lang.String r2 = "toLowerCase(...)"
                ir.nasim.AbstractC13042fc3.h(r1, r2)     // Catch: java.lang.Exception -> L37
                java.lang.String r2 = "http"
                boolean r2 = ir.nasim.AbstractC13042fc3.d(r1, r2)     // Catch: java.lang.Exception -> L37
                if (r2 != 0) goto L39
                java.lang.String r2 = "https"
                boolean r1 = ir.nasim.AbstractC13042fc3.d(r1, r2)     // Catch: java.lang.Exception -> L37
                if (r1 == 0) goto L35
                goto L39
            L35:
                r1 = r6
                goto L5e
            L37:
                r5 = move-exception
                goto La3
            L39:
                ir.nasim.Rr$a r1 = ir.nasim.AbstractC7426Rr.a     // Catch: java.lang.Exception -> L37
                ir.nasim.a16$a r1 = ir.nasim.C9475a16.b     // Catch: java.lang.Throwable -> L46
                android.net.Uri r1 = r6.normalizeScheme()     // Catch: java.lang.Throwable -> L46
                java.lang.Object r1 = ir.nasim.C9475a16.b(r1)     // Catch: java.lang.Throwable -> L46
                goto L51
            L46:
                r1 = move-exception
                ir.nasim.a16$a r2 = ir.nasim.C9475a16.b     // Catch: java.lang.Exception -> L37
                java.lang.Object r1 = ir.nasim.AbstractC10685c16.a(r1)     // Catch: java.lang.Exception -> L37
                java.lang.Object r1 = ir.nasim.C9475a16.b(r1)     // Catch: java.lang.Exception -> L37
            L51:
                java.lang.Throwable r2 = ir.nasim.C9475a16.e(r1)     // Catch: java.lang.Exception -> L37
                if (r2 != 0) goto L58
                goto L5c
            L58:
                ir.nasim.C19406qI3.d(r0, r2)     // Catch: java.lang.Exception -> L37
                r1 = r6
            L5c:
                android.net.Uri r1 = (android.net.Uri) r1     // Catch: java.lang.Exception -> L37
            L5e:
                if (r1 != 0) goto L75
            L60:
                java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> L37
                r1.<init>()     // Catch: java.lang.Exception -> L37
                java.lang.String r2 = "http://"
                r1.append(r2)     // Catch: java.lang.Exception -> L37
                r1.append(r6)     // Catch: java.lang.Exception -> L37
                java.lang.String r6 = r1.toString()     // Catch: java.lang.Exception -> L37
                android.net.Uri r1 = android.net.Uri.parse(r6)     // Catch: java.lang.Exception -> L37
            L75:
                java.lang.String r6 = r1.toString()     // Catch: java.lang.Exception -> L37
                java.lang.String r2 = "toString(...)"
                ir.nasim.AbstractC13042fc3.h(r6, r2)     // Catch: java.lang.Exception -> L37
                r2 = 0
                boolean r6 = ir.nasim.C18987pb3.e1(r5, r6, r2)     // Catch: java.lang.Exception -> L37
                if (r6 == 0) goto L86
                return
            L86:
                java.util.ArrayList r6 = r4.i(r5, r1)     // Catch: java.lang.Exception -> L37
                boolean r6 = r6.isEmpty()     // Catch: java.lang.Exception -> L37
                if (r6 == 0) goto L9b
                android.content.Intent r6 = new android.content.Intent     // Catch: java.lang.Exception -> L37
                java.lang.String r2 = "android.intent.action.VIEW"
                r6.<init>(r2, r1)     // Catch: java.lang.Exception -> L37
                r5.startActivity(r6)     // Catch: java.lang.Exception -> L37
                goto Lc0
            L9b:
                ir.nasim.Cx1 r6 = ir.nasim.AbstractC5730Kp.a()     // Catch: java.lang.Exception -> L37
                r6.a(r5, r1)     // Catch: java.lang.Exception -> L37
                goto Lc0
            La3:
                java.lang.Exception r6 = new java.lang.Exception
                java.lang.String r5 = r5.getMessage()
                java.lang.StringBuilder r1 = new java.lang.StringBuilder
                r1.<init>()
                java.lang.String r2 = "openUrl: "
                r1.append(r2)
                r1.append(r5)
                java.lang.String r5 = r1.toString()
                r6.<init>(r5)
                ir.nasim.C19406qI3.d(r0, r6)
            Lc0:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: ir.nasim.AbstractC7426Rr.a.A(android.content.Context, android.net.Uri):void");
        }

        /* JADX WARN: Removed duplicated region for block: B:24:0x005b A[Catch: Exception -> 0x0032, TryCatch #1 {Exception -> 0x0032, blocks: (B:3:0x0007, B:5:0x000d, B:7:0x0027, B:25:0x0070, B:28:0x008c, B:13:0x0034, B:18:0x004c, B:22:0x0057, B:21:0x0053, B:17:0x0042, B:24:0x005b, B:14:0x0036), top: B:34:0x0007, inners: #0 }] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final void B(android.net.Uri r7) {
            /*
                r6 = this;
                java.lang.String r0 = "NON_FATAL_EXCEPTION"
                java.lang.String r1 = "uri"
                ir.nasim.AbstractC13042fc3.i(r7, r1)
                java.lang.String r1 = r7.getScheme()     // Catch: java.lang.Exception -> L32
                if (r1 == 0) goto L5b
                java.util.Locale r2 = java.util.Locale.getDefault()     // Catch: java.lang.Exception -> L32
                java.lang.String r3 = "getDefault(...)"
                ir.nasim.AbstractC13042fc3.h(r2, r3)     // Catch: java.lang.Exception -> L32
                java.lang.String r1 = r1.toLowerCase(r2)     // Catch: java.lang.Exception -> L32
                java.lang.String r2 = "toLowerCase(...)"
                ir.nasim.AbstractC13042fc3.h(r1, r2)     // Catch: java.lang.Exception -> L32
                java.lang.String r2 = "http"
                boolean r2 = ir.nasim.AbstractC13042fc3.d(r1, r2)     // Catch: java.lang.Exception -> L32
                if (r2 != 0) goto L34
                java.lang.String r2 = "https"
                boolean r1 = ir.nasim.AbstractC13042fc3.d(r1, r2)     // Catch: java.lang.Exception -> L32
                if (r1 == 0) goto L30
                goto L34
            L30:
                r1 = r7
                goto L59
            L32:
                r7 = move-exception
                goto La1
            L34:
                ir.nasim.Rr$a r1 = ir.nasim.AbstractC7426Rr.a     // Catch: java.lang.Exception -> L32
                ir.nasim.a16$a r1 = ir.nasim.C9475a16.b     // Catch: java.lang.Throwable -> L41
                android.net.Uri r1 = r7.normalizeScheme()     // Catch: java.lang.Throwable -> L41
                java.lang.Object r1 = ir.nasim.C9475a16.b(r1)     // Catch: java.lang.Throwable -> L41
                goto L4c
            L41:
                r1 = move-exception
                ir.nasim.a16$a r2 = ir.nasim.C9475a16.b     // Catch: java.lang.Exception -> L32
                java.lang.Object r1 = ir.nasim.AbstractC10685c16.a(r1)     // Catch: java.lang.Exception -> L32
                java.lang.Object r1 = ir.nasim.C9475a16.b(r1)     // Catch: java.lang.Exception -> L32
            L4c:
                java.lang.Throwable r2 = ir.nasim.C9475a16.e(r1)     // Catch: java.lang.Exception -> L32
                if (r2 != 0) goto L53
                goto L57
            L53:
                ir.nasim.C19406qI3.d(r0, r2)     // Catch: java.lang.Exception -> L32
                r1 = r7
            L57:
                android.net.Uri r1 = (android.net.Uri) r1     // Catch: java.lang.Exception -> L32
            L59:
                if (r1 != 0) goto L70
            L5b:
                java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> L32
                r1.<init>()     // Catch: java.lang.Exception -> L32
                java.lang.String r2 = "http://"
                r1.append(r2)     // Catch: java.lang.Exception -> L32
                r1.append(r7)     // Catch: java.lang.Exception -> L32
                java.lang.String r7 = r1.toString()     // Catch: java.lang.Exception -> L32
                android.net.Uri r1 = android.net.Uri.parse(r7)     // Catch: java.lang.Exception -> L32
            L70:
                ir.nasim.Ko r7 = ir.nasim.C5721Ko.a     // Catch: java.lang.Exception -> L32
                android.content.Context r2 = r7.d()     // Catch: java.lang.Exception -> L32
                java.lang.String r3 = r1.toString()     // Catch: java.lang.Exception -> L32
                java.lang.String r4 = "toString(...)"
                ir.nasim.AbstractC13042fc3.h(r3, r4)     // Catch: java.lang.Exception -> L32
                r4 = 268435456(0x10000000, float:2.524355E-29)
                java.lang.Integer r5 = java.lang.Integer.valueOf(r4)     // Catch: java.lang.Exception -> L32
                boolean r2 = ir.nasim.C18987pb3.e1(r2, r3, r5)     // Catch: java.lang.Exception -> L32
                if (r2 == 0) goto L8c
                return
            L8c:
                android.content.Intent r2 = new android.content.Intent     // Catch: java.lang.Exception -> L32
                java.lang.String r3 = "android.intent.action.VIEW"
                r2.<init>(r3)     // Catch: java.lang.Exception -> L32
                r2.setData(r1)     // Catch: java.lang.Exception -> L32
                r2.setFlags(r4)     // Catch: java.lang.Exception -> L32
                android.content.Context r7 = r7.d()     // Catch: java.lang.Exception -> L32
                r7.startActivity(r2)     // Catch: java.lang.Exception -> L32
                goto Lbe
            La1:
                java.lang.Exception r1 = new java.lang.Exception
                java.lang.String r7 = r7.getMessage()
                java.lang.StringBuilder r2 = new java.lang.StringBuilder
                r2.<init>()
                java.lang.String r3 = "openUrl: "
                r2.append(r3)
                r2.append(r7)
                java.lang.String r7 = r2.toString()
                r1.<init>(r7)
                ir.nasim.C19406qI3.d(r0, r1)
            Lbe:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: ir.nasim.AbstractC7426Rr.a.B(android.net.Uri):void");
        }

        public final void C(Context context, Uri uri) {
            AbstractC13042fc3.i(context, "context");
            AbstractC13042fc3.i(uri, "uri");
            try {
                String string = uri.toString();
                AbstractC13042fc3.h(string, "toString(...)");
                if (C18987pb3.e1(context, string, null)) {
                    return;
                }
                Intent intent = new Intent("android.intent.action.VIEW");
                intent.setData(uri);
                context.startActivity(intent);
            } catch (Exception e) {
                C19406qI3.d("NON_FATAL_EXCEPTION", new Exception("openUrl" + e.getMessage()));
            }
        }

        public final int D(int i) {
            if (k() == 0.0f) {
                return 0;
            }
            return (int) Math.ceil(i / k());
        }

        public final void E(Context context, Uri uri) {
            AbstractC13042fc3.i(context, "context");
            AbstractC13042fc3.i(uri, "uri");
            if (!URLUtil.isValidUrl(uri.toString())) {
                if (!URLUtil.isValidUrl("http://" + uri)) {
                    A(context, uri);
                    return;
                }
            }
            Uri uri2 = Uri.parse(AbstractC5969Lp4.e().S().E4());
            Set<String> queryParameterNames = uri2.getQueryParameterNames();
            AbstractC13042fc3.h(queryParameterNames, "getQueryParameterNames(...)");
            String str = (String) AbstractC15401jX0.r0(queryParameterNames);
            if (str == null) {
                A(context, uri);
                return;
            }
            Uri uriBuild = uri2.buildUpon().clearQuery().appendQueryParameter(str, uri.toString()).build();
            AbstractC13042fc3.f(uriBuild);
            A(context, uriBuild);
        }

        public final void F(Runnable runnable) {
            G(runnable, 0L);
        }

        public final void G(Runnable runnable, long j) {
            if (j == 0) {
                AbstractC20507s76.z(runnable);
            } else {
                AbstractC20507s76.D(runnable, j);
            }
        }

        public final void H(Context context, final int i, int i2) {
            AbstractC13042fc3.i(context, "context");
            Handler handler = new Handler();
            Object systemService = context.getSystemService("vibrator");
            AbstractC13042fc3.g(systemService, "null cannot be cast to non-null type android.os.Vibrator");
            final Vibrator vibrator = (Vibrator) systemService;
            handler.postDelayed(new Runnable() { // from class: ir.nasim.Pr
                @Override // java.lang.Runnable
                public final void run() {
                    AbstractC7426Rr.a.I(vibrator, i);
                }
            }, i2);
        }

        public final void J(boolean z) {
            AbstractC7426Rr.m = z;
        }

        public final void K(boolean z) {
            AbstractC7426Rr.e = z;
        }

        public final void L(boolean z) {
            AbstractC7426Rr.k = z;
        }

        public final void M(boolean z) {
            AbstractC7426Rr.l = z;
        }

        public final void N(Integer num) {
            AbstractC7426Rr.b = num;
        }

        public final void O(boolean z) {
            AbstractC7426Rr.j = z;
        }

        public final void P(Activity activity, Drawable drawable) {
            AbstractC13042fc3.i(activity, "activity");
            Window window = activity.getWindow();
            window.addFlags(RecyclerView.UNDEFINED_DURATION);
            window.setBackgroundDrawable(drawable);
        }

        public final void Q(Activity activity, int i) {
            AbstractC13042fc3.i(activity, "activity");
            Window window = activity.getWindow();
            window.addFlags(RecyclerView.UNDEFINED_DURATION);
            window.setStatusBarColor(i);
        }

        public final void R(int i) {
            AbstractC7426Rr.g = i;
        }

        public final void S(View view, float f, int i) {
            if (view == null) {
                return;
            }
            if (i == 6) {
                view.setTranslationX(0.0f);
                return;
            }
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.playTogether(ObjectAnimator.ofFloat(view, "translationX", f(f)));
            animatorSet.setDuration(50L);
            animatorSet.addListener(new C0602a(view, i, f));
            Context context = view.getContext();
            AbstractC13042fc3.h(context, "getContext(...)");
            H(context, 8, 0);
            Context context2 = view.getContext();
            AbstractC13042fc3.h(context2, "getContext(...)");
            H(context2, 20, 150);
            animatorSet.start();
        }

        public final void T(final int i) {
            F(new Runnable() { // from class: ir.nasim.Or
                @Override // java.lang.Runnable
                public final void run() {
                    AbstractC7426Rr.a.W(i);
                }
            });
        }

        public final void U(final Context context, final String str) {
            F(new Runnable() { // from class: ir.nasim.Qr
                @Override // java.lang.Runnable
                public final void run() {
                    AbstractC7426Rr.a.V(context, str);
                }
            });
        }

        public final void d(Runnable runnable) {
            AbstractC20507s76.c(runnable);
        }

        public final void e(EditText editText) throws IllegalAccessException, NoSuchFieldException, SecurityException, IllegalArgumentException {
            if (editText == null) {
                return;
            }
            try {
                Field declaredField = TextView.class.getDeclaredField("mCursorDrawableRes");
                declaredField.setAccessible(true);
                declaredField.setInt(editText, 0);
            } catch (Exception e) {
                C19406qI3.d("baleMessages", e);
            }
        }

        public final int f(float f) {
            if (f == 0.0f) {
                return 0;
            }
            return (int) Math.ceil(k() * f);
        }

        public final float g(float f) {
            if (f == 0.0f) {
                return 0.0f;
            }
            return k() * f;
        }

        public final int h(Context context, int i) {
            AbstractC13042fc3.i(context, "context");
            try {
                TypedValue typedValue = new TypedValue();
                if (context.getTheme().resolveAttribute(i, typedValue, true)) {
                    return D(TypedValue.complexToDimensionPixelSize(typedValue.data, context.getResources().getDisplayMetrics()));
                }
                return 0;
            } catch (Exception e) {
                C19406qI3.b("AndroidUtilities", "getAttributeSizeInDp:" + e.getMessage());
                return 0;
            }
        }

        public final ArrayList i(Context context, Uri uri) {
            AbstractC13042fc3.i(context, "context");
            PackageManager packageManager = context.getPackageManager();
            Intent data = new Intent().setAction("android.intent.action.VIEW").addCategory("android.intent.category.BROWSABLE").setData(uri);
            AbstractC13042fc3.h(data, "setData(...)");
            List<ResolveInfo> listQueryIntentActivities = packageManager.queryIntentActivities(data, 0);
            AbstractC13042fc3.h(listQueryIntentActivities, "queryIntentActivities(...)");
            ArrayList arrayList = new ArrayList();
            for (ResolveInfo resolveInfo : listQueryIntentActivities) {
                Intent intent = new Intent();
                intent.setAction("android.support.customtabs.action.CustomTabsService");
                intent.setPackage(resolveInfo.activityInfo.packageName);
                if (packageManager.resolveService(intent, 0) != null) {
                    arrayList.add(resolveInfo);
                }
            }
            return arrayList;
        }

        public final String j() {
            return AbstractC7426Rr.f;
        }

        public final float k() {
            return ((Number) AbstractC7426Rr.c.getValue()).floatValue();
        }

        public final DisplayMetrics l() {
            return AbstractC7426Rr.i;
        }

        public final Point m() {
            if (AbstractC7426Rr.h.y == 0) {
                AbstractC7426Rr.h.y = C5721Ko.a.d().getResources().getDisplayMetrics().heightPixels;
            }
            if (AbstractC7426Rr.h.x == 0) {
                AbstractC7426Rr.h.x = C5721Ko.a.d().getResources().getDisplayMetrics().widthPixels;
            }
            return AbstractC7426Rr.h;
        }

        public final String n() {
            if (AbstractC7426Rr.p != null) {
                String str = AbstractC7426Rr.p;
                AbstractC13042fc3.g(str, "null cannot be cast to non-null type kotlin.String");
                return str;
            }
            File externalFilesDir = C5721Ko.a.d().getExternalFilesDir(null);
            AbstractC13042fc3.f(externalFilesDir);
            AbstractC7426Rr.p = externalFilesDir.getAbsolutePath();
            return AbstractC7426Rr.p;
        }

        public final String o(float f) {
            String str;
            if (f >= 1024.0f) {
                DY6 dy6 = DY6.a;
                String str2 = String.format("%.1f", Arrays.copyOf(new Object[]{Float.valueOf(f / 1024)}, 1));
                AbstractC13042fc3.h(str2, "format(...)");
                str = str2 + " MB";
            } else {
                DY6 dy62 = DY6.a;
                String str3 = String.format("%.0f", Arrays.copyOf(new Object[]{Float.valueOf(f)}, 1));
                AbstractC13042fc3.h(str3, "format(...)");
                str = str3 + " KB";
            }
            return JF5.g() ? XY6.e(str) : str;
        }

        public final boolean p() {
            return AbstractC7426Rr.e;
        }

        public final boolean q() {
            return AbstractC7426Rr.k;
        }

        public final int r() {
            if (s() == null) {
                N(Integer.valueOf(SimpleResolver.DEFAULT_EDNS_PAYLOADSIZE));
            }
            Integer numS = s();
            AbstractC13042fc3.g(numS, "null cannot be cast to non-null type kotlin.Int");
            return numS.intValue();
        }

        public final Integer s() {
            return AbstractC7426Rr.b;
        }

        public final int t() {
            return AbstractC7426Rr.g;
        }

        public final boolean u() {
            return AbstractC7426Rr.d;
        }

        public final int v(View view) {
            WindowInsets rootWindowInsets;
            if (view == null || view.getHeight() == m().y || view.getHeight() == m().y - t() || (rootWindowInsets = view.getRootWindowInsets()) == null) {
                return 0;
            }
            return rootWindowInsets.getStableInsetBottom();
        }

        public final boolean w() {
            return AbstractC7426Rr.m;
        }

        public final boolean x(boolean z) {
            boolean zC = AbstractC5969Lp4.d().i2().C(z);
            if (z) {
                AbstractC5969Lp4.d().i2().K();
            }
            return C23073wI7.n && zC && (C23073wI7.i || !(C23073wI7.k == 0 || C23073wI7.i || C23073wI7.k + ((long) 60000) > new Date().getTime()));
        }

        public final void y(C11507d74 c11507d74, Activity activity) {
            File file;
            AbstractC13042fc3.i(c11507d74, DialogEntity.COLUMN_MESSAGE);
            AbstractC13042fc3.i(activity, "activity");
            String fileName = c11507d74.getFileName();
            String str = c11507d74.y;
            String str2 = null;
            File file2 = (str == null || str.length() == 0) ? null : new File(c11507d74.y);
            if (file2 == null || !file2.exists()) {
                String strQ = C4044Dl2.q(c11507d74);
                if (strQ == null) {
                    strQ = "";
                }
                file = new File(strQ);
            } else {
                file = file2;
            }
            if (file.exists()) {
                Intent intent = new Intent("android.intent.action.VIEW");
                intent.setFlags(1);
                MimeTypeMap singleton = MimeTypeMap.getSingleton();
                AbstractC13042fc3.f(fileName);
                int iQ0 = AbstractC20762sZ6.q0(fileName, '.', 0, false, 6, null);
                if (iQ0 != -1) {
                    String strSubstring = fileName.substring(iQ0 + 1);
                    AbstractC13042fc3.h(strSubstring, "substring(...)");
                    Locale locale = Locale.getDefault();
                    AbstractC13042fc3.h(locale, "getDefault(...)");
                    String lowerCase = strSubstring.toLowerCase(locale);
                    AbstractC13042fc3.h(lowerCase, "toLowerCase(...)");
                    String mimeTypeFromExtension = singleton.getMimeTypeFromExtension(lowerCase);
                    if (mimeTypeFromExtension == null) {
                        String strS0 = c11507d74.s0();
                        if (strS0 != null && strS0.length() != 0) {
                            str2 = strS0;
                        }
                    } else {
                        str2 = mimeTypeFromExtension;
                    }
                }
                X(activity, file, str2, intent);
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:20:0x0061  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final void z(java.lang.String r7, java.lang.String r8, android.app.Activity r9) {
            /*
                r6 = this;
                java.lang.String r0 = "activity"
                ir.nasim.AbstractC13042fc3.i(r9, r0)
                if (r7 == 0) goto L6e
                int r0 = r7.length()
                r1 = 0
                if (r0 <= 0) goto L10
                r0 = r7
                goto L11
            L10:
                r0 = r1
            L11:
                if (r0 == 0) goto L6e
                java.io.File r2 = new java.io.File
                r2.<init>(r0)
                boolean r0 = r2.exists()
                if (r0 != 0) goto L1f
                return
            L1f:
                r0 = 47
                r3 = 2
                java.lang.String r7 = ir.nasim.AbstractC14836iZ6.c1(r7, r0, r1, r3, r1)
                android.content.Intent r0 = new android.content.Intent
                java.lang.String r3 = "android.intent.action.VIEW"
                r0.<init>(r3)
                r3 = 1
                r0.setFlags(r3)
                r3 = 46
                java.lang.String r4 = ""
                java.lang.String r7 = ir.nasim.AbstractC14836iZ6.a1(r7, r3, r4)
                int r3 = r7.length()
                if (r3 <= 0) goto L40
                goto L41
            L40:
                r7 = r1
            L41:
                if (r7 == 0) goto L61
                android.webkit.MimeTypeMap r3 = android.webkit.MimeTypeMap.getSingleton()
                java.util.Locale r4 = java.util.Locale.getDefault()
                java.lang.String r5 = "getDefault(...)"
                ir.nasim.AbstractC13042fc3.h(r4, r5)
                java.lang.String r7 = r7.toLowerCase(r4)
                java.lang.String r4 = "toLowerCase(...)"
                ir.nasim.AbstractC13042fc3.h(r7, r4)
                java.lang.String r7 = r3.getMimeTypeFromExtension(r7)
                if (r7 == 0) goto L61
                r8 = r7
                goto L6b
            L61:
                if (r8 == 0) goto L6a
                int r7 = r8.length()
                if (r7 <= 0) goto L6a
                goto L6b
            L6a:
                r8 = r1
            L6b:
                r6.X(r9, r2, r8, r0)
            L6e:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: ir.nasim.AbstractC7426Rr.a.z(java.lang.String, java.lang.String, android.app.Activity):void");
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    static {
        a aVar = new a(null);
        a = aVar;
        c = AbstractC13269fw3.a(new SA2() { // from class: ir.nasim.Dr
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return Float.valueOf(AbstractC7426Rr.y());
            }
        });
        f = "yyyyMMdd_HHmmss";
        h = new Point();
        i = new DisplayMetrics();
        k = true;
        l = true;
        o = aVar.f(16.0f);
    }

    public static final float A(float f2) {
        return a.g(f2);
    }

    public static final float B() {
        return a.k();
    }

    public static final Point C() {
        return a.m();
    }

    public static final String D() {
        return a.n();
    }

    public static final String E(float f2) {
        return a.o(f2);
    }

    public static final boolean F() {
        return a.p();
    }

    public static final int G() {
        return a.r();
    }

    public static final int H() {
        return a.t();
    }

    public static final boolean I() {
        return a.u();
    }

    public static final int J(View view) {
        return a.v(view);
    }

    public static final boolean K() {
        return a.w();
    }

    public static final boolean L(boolean z) {
        return a.x(z);
    }

    public static final void M(C11507d74 c11507d74, Activity activity) {
        a.y(c11507d74, activity);
    }

    public static final void N(Context context, Uri uri) {
        a.A(context, uri);
    }

    public static final void O(Context context, Uri uri) {
        a.C(context, uri);
    }

    public static final void P(Runnable runnable) {
        a.F(runnable);
    }

    public static final void Q(Runnable runnable, long j2) {
        a.G(runnable, j2);
    }

    public static final void R(boolean z) {
        a.O(z);
    }

    public static final void S(Activity activity, int i2) {
        a.Q(activity, i2);
    }

    public static final void T(View view, float f2, int i2) {
        a.S(view, f2, i2);
    }

    public static final void w(Runnable runnable) {
        a.d(runnable);
    }

    public static final void x(EditText editText) throws IllegalAccessException, NoSuchFieldException, SecurityException, IllegalArgumentException {
        a.e(editText);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float y() {
        DisplayMetrics displayMetrics;
        Resources resources = C5721Ko.a.d().getResources();
        if (resources == null || (displayMetrics = resources.getDisplayMetrics()) == null) {
            return 1.0f;
        }
        return displayMetrics.density;
    }

    public static final int z(float f2) {
        return a.f(f2);
    }
}
