package androidx.navigation;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import androidx.navigation.p;
import ir.nasim.AbstractC13042fc3;
import ir.nasim.AbstractC23053wG5;
import ir.nasim.AbstractC8614Ws3;
import ir.nasim.AbstractC9962aq6;
import ir.nasim.UA2;
import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0017\u0018\u0000 \u001e2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u001f B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\n\u0010\u000bJ7\u0010\u0014\u001a\u0004\u0018\u00010\u00132\u0006\u0010\f\u001a\u00020\u00022\b\u0010\u000e\u001a\u0004\u0018\u00010\r2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0016¢\u0006\u0004\b\u0014\u0010\u0015R\u0017\u0010\u0004\u001a\u00020\u00038\u0007¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u0016\u0010\u001d\u001a\u0004\u0018\u00010\u001a8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u001c¨\u0006!"}, d2 = {"Landroidx/navigation/a;", "Landroidx/navigation/p;", "Landroidx/navigation/a$b;", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "l", "()Landroidx/navigation/a$b;", "", "k", "()Z", "destination", "Landroid/os/Bundle;", "args", "Landroidx/navigation/m;", "navOptions", "Landroidx/navigation/p$a;", "navigatorExtras", "Landroidx/navigation/i;", "m", "(Landroidx/navigation/a$b;Landroid/os/Bundle;Landroidx/navigation/m;Landroidx/navigation/p$a;)Landroidx/navigation/i;", "c", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "Landroid/app/Activity;", "d", "Landroid/app/Activity;", "hostActivity", "e", "a", "b", "navigation-runtime_release"}, k = 1, mv = {1, 8, 0})
@p.b("activity")
/* loaded from: classes2.dex */
public class a extends p {

    /* renamed from: c, reason: from kotlin metadata */
    private final Context context;

    /* renamed from: d, reason: from kotlin metadata */
    private final Activity hostActivity;

    public static class b extends i {
        private Intent l;
        private String m;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(p pVar) {
            super(pVar);
            AbstractC13042fc3.i(pVar, "activityNavigator");
        }

        @Override // androidx.navigation.i
        public boolean V() {
            return false;
        }

        public final String W() {
            Intent intent = this.l;
            if (intent != null) {
                return intent.getAction();
            }
            return null;
        }

        public final ComponentName Y() {
            Intent intent = this.l;
            if (intent != null) {
                return intent.getComponent();
            }
            return null;
        }

        public final String Z() {
            return this.m;
        }

        public final Intent a0() {
            return this.l;
        }

        @Override // androidx.navigation.i
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || !(obj instanceof b)) {
                return false;
            }
            if (super.equals(obj)) {
                Intent intent = this.l;
                if ((intent != null ? intent.filterEquals(((b) obj).l) : ((b) obj).l == null) && AbstractC13042fc3.d(this.m, ((b) obj).m)) {
                    return true;
                }
            }
            return false;
        }

        @Override // androidx.navigation.i
        public int hashCode() {
            int iHashCode = super.hashCode() * 31;
            Intent intent = this.l;
            int iFilterHashCode = (iHashCode + (intent != null ? intent.filterHashCode() : 0)) * 31;
            String str = this.m;
            return iFilterHashCode + (str != null ? str.hashCode() : 0);
        }

        @Override // androidx.navigation.i
        public String toString() {
            ComponentName componentNameY = Y();
            StringBuilder sb = new StringBuilder();
            sb.append(super.toString());
            if (componentNameY != null) {
                sb.append(" class=");
                sb.append(componentNameY.getClassName());
            } else {
                String strW = W();
                if (strW != null) {
                    sb.append(" action=");
                    sb.append(strW);
                }
            }
            String string = sb.toString();
            AbstractC13042fc3.h(string, "sb.toString()");
            return string;
        }
    }

    static final class c extends AbstractC8614Ws3 implements UA2 {
        public static final c e = new c();

        c() {
            super(1);
        }

        @Override // ir.nasim.UA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Context invoke(Context context) {
            AbstractC13042fc3.i(context, "it");
            if (context instanceof ContextWrapper) {
                return ((ContextWrapper) context).getBaseContext();
            }
            return null;
        }
    }

    public a(Context context) {
        Object next;
        AbstractC13042fc3.i(context, "context");
        this.context = context;
        Iterator it = AbstractC9962aq6.j(context, c.e).iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            } else {
                next = it.next();
                if (((Context) next) instanceof Activity) {
                    break;
                }
            }
        }
        this.hostActivity = (Activity) next;
    }

    @Override // androidx.navigation.p
    public boolean k() {
        Activity activity = this.hostActivity;
        if (activity == null) {
            return false;
        }
        activity.finish();
        return true;
    }

    @Override // androidx.navigation.p
    /* renamed from: l, reason: merged with bridge method [inline-methods] */
    public b a() {
        return new b(this);
    }

    @Override // androidx.navigation.p
    /* renamed from: m, reason: merged with bridge method [inline-methods] */
    public i d(b destination, Bundle args, m navOptions, p.a navigatorExtras) {
        Intent intent;
        int intExtra;
        AbstractC13042fc3.i(destination, "destination");
        if (destination.a0() == null) {
            throw new IllegalStateException(("Destination " + destination.A() + " does not have an Intent set.").toString());
        }
        Intent intent2 = new Intent(destination.a0());
        if (args != null) {
            intent2.putExtras(args);
            String strZ = destination.Z();
            if (strZ != null && strZ.length() != 0) {
                StringBuffer stringBuffer = new StringBuffer();
                Matcher matcher = Pattern.compile("\\{(.+?)\\}").matcher(strZ);
                while (matcher.find()) {
                    String strGroup = matcher.group(1);
                    if (!args.containsKey(strGroup)) {
                        throw new IllegalArgumentException("Could not find " + strGroup + " in " + args + " to fill data pattern " + strZ);
                    }
                    matcher.appendReplacement(stringBuffer, "");
                    stringBuffer.append(Uri.encode(String.valueOf(args.get(strGroup))));
                }
                matcher.appendTail(stringBuffer);
                intent2.setData(Uri.parse(stringBuffer.toString()));
            }
        }
        if (this.hostActivity == null) {
            intent2.addFlags(268435456);
        }
        if (navOptions != null && navOptions.h()) {
            intent2.addFlags(536870912);
        }
        Activity activity = this.hostActivity;
        if (activity != null && (intent = activity.getIntent()) != null && (intExtra = intent.getIntExtra("android-support-navigation:ActivityNavigator:current", 0)) != 0) {
            intent2.putExtra("android-support-navigation:ActivityNavigator:source", intExtra);
        }
        intent2.putExtra("android-support-navigation:ActivityNavigator:current", destination.A());
        Resources resources = this.context.getResources();
        if (navOptions != null) {
            int iC = navOptions.c();
            int iD = navOptions.d();
            if ((iC <= 0 || !AbstractC13042fc3.d(resources.getResourceTypeName(iC), "animator")) && (iD <= 0 || !AbstractC13042fc3.d(resources.getResourceTypeName(iD), "animator"))) {
                intent2.putExtra("android-support-navigation:ActivityNavigator:popEnterAnim", iC);
                intent2.putExtra("android-support-navigation:ActivityNavigator:popExitAnim", iD);
            } else {
                Log.w("ActivityNavigator", "Activity destinations do not support Animator resource. Ignoring popEnter resource " + resources.getResourceName(iC) + " and popExit resource " + resources.getResourceName(iD) + " when launching " + destination);
            }
        }
        this.context.startActivity(intent2);
        if (navOptions == null || this.hostActivity == null) {
            return null;
        }
        int iA = navOptions.a();
        int iB = navOptions.b();
        if ((iA <= 0 || !AbstractC13042fc3.d(resources.getResourceTypeName(iA), "animator")) && (iB <= 0 || !AbstractC13042fc3.d(resources.getResourceTypeName(iB), "animator"))) {
            if (iA < 0 && iB < 0) {
                return null;
            }
            this.hostActivity.overridePendingTransition(AbstractC23053wG5.e(iA, 0), AbstractC23053wG5.e(iB, 0));
            return null;
        }
        Log.w("ActivityNavigator", "Activity destinations do not support Animator resource. Ignoring enter resource " + resources.getResourceName(iA) + " and exit resource " + resources.getResourceName(iB) + "when launching " + destination);
        return null;
    }
}
