package ir.nasim;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;
import java.util.ArrayList;
import java.util.Iterator;

/* renamed from: ir.nasim.Oj7, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C6650Oj7 implements Iterable {
    private final ArrayList a = new ArrayList();
    private final Context b;

    /* renamed from: ir.nasim.Oj7$a */
    public interface a {
        Intent h();
    }

    private C6650Oj7(Context context) {
        this.b = context;
    }

    public static C6650Oj7 o(Context context) {
        return new C6650Oj7(context);
    }

    public C6650Oj7 f(Intent intent) {
        this.a.add(intent);
        return this;
    }

    public C6650Oj7 h(Intent intent) {
        ComponentName component = intent.getComponent();
        if (component == null) {
            component = intent.resolveActivity(this.b.getPackageManager());
        }
        if (component != null) {
            j(component);
        }
        f(intent);
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public C6650Oj7 i(Activity activity) {
        Intent intentH = activity instanceof a ? ((a) activity).h() : null;
        if (intentH == null) {
            intentH = AbstractC11961dq4.a(activity);
        }
        if (intentH != null) {
            ComponentName component = intentH.getComponent();
            if (component == null) {
                component = intentH.resolveActivity(this.b.getPackageManager());
            }
            j(component);
            f(intentH);
        }
        return this;
    }

    @Override // java.lang.Iterable
    public Iterator iterator() {
        return this.a.iterator();
    }

    public C6650Oj7 j(ComponentName componentName) {
        int size = this.a.size();
        try {
            Intent intentB = AbstractC11961dq4.b(this.b, componentName);
            while (intentB != null) {
                this.a.add(size, intentB);
                intentB = AbstractC11961dq4.b(this.b, intentB.getComponent());
            }
            return this;
        } catch (PackageManager.NameNotFoundException e) {
            Log.e("TaskStackBuilder", "Bad ComponentName while traversing activity parent metadata");
            throw new IllegalArgumentException(e);
        }
    }

    public void r() {
        t(null);
    }

    public void t(Bundle bundle) {
        if (this.a.isEmpty()) {
            throw new IllegalStateException("No intents added to TaskStackBuilder; cannot startActivities");
        }
        Intent[] intentArr = (Intent[]) this.a.toArray(new Intent[0]);
        intentArr[0] = new Intent(intentArr[0]).addFlags(268484608);
        if (AbstractC4043Dl1.n(this.b, intentArr, bundle)) {
            return;
        }
        Intent intent = new Intent(intentArr[intentArr.length - 1]);
        intent.addFlags(268435456);
        this.b.startActivity(intent);
    }
}
