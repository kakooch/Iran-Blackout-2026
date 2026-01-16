package ir.nasim;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcelable;
import android.util.SparseArray;
import ir.nasim.C3444Ax1;
import java.util.ArrayList;

/* renamed from: ir.nasim.Cx1, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C3917Cx1 {
    public final Intent a;
    public final Bundle b;

    /* renamed from: ir.nasim.Cx1$a */
    public static final class a {
        private ArrayList c;
        private Bundle d;
        private ArrayList e;
        private SparseArray f;
        private Bundle g;
        private final Intent a = new Intent("android.intent.action.VIEW");
        private final C3444Ax1.a b = new C3444Ax1.a();
        private int h = 0;
        private boolean i = true;

        private void e(IBinder iBinder, PendingIntent pendingIntent) {
            Bundle bundle = new Bundle();
            AbstractC22752vm0.b(bundle, "android.support.customtabs.extra.SESSION", iBinder);
            if (pendingIntent != null) {
                bundle.putParcelable("android.support.customtabs.extra.SESSION_ID", pendingIntent);
            }
            this.a.putExtras(bundle);
        }

        public C3917Cx1 a() {
            if (!this.a.hasExtra("android.support.customtabs.extra.SESSION")) {
                e(null, null);
            }
            ArrayList<? extends Parcelable> arrayList = this.c;
            if (arrayList != null) {
                this.a.putParcelableArrayListExtra("android.support.customtabs.extra.MENU_ITEMS", arrayList);
            }
            ArrayList<? extends Parcelable> arrayList2 = this.e;
            if (arrayList2 != null) {
                this.a.putParcelableArrayListExtra("android.support.customtabs.extra.TOOLBAR_ITEMS", arrayList2);
            }
            this.a.putExtra("android.support.customtabs.extra.EXTRA_ENABLE_INSTANT_APPS", this.i);
            this.a.putExtras(this.b.a().a());
            Bundle bundle = this.g;
            if (bundle != null) {
                this.a.putExtras(bundle);
            }
            if (this.f != null) {
                Bundle bundle2 = new Bundle();
                bundle2.putSparseParcelableArray("androidx.browser.customtabs.extra.COLOR_SCHEME_PARAMS", this.f);
                this.a.putExtras(bundle2);
            }
            this.a.putExtra("androidx.browser.customtabs.extra.SHARE_STATE", this.h);
            return new C3917Cx1(this.a, this.d);
        }

        public a b(Bitmap bitmap, String str, PendingIntent pendingIntent) {
            return c(bitmap, str, pendingIntent, false);
        }

        public a c(Bitmap bitmap, String str, PendingIntent pendingIntent, boolean z) {
            Bundle bundle = new Bundle();
            bundle.putInt("android.support.customtabs.customaction.ID", 0);
            bundle.putParcelable("android.support.customtabs.customaction.ICON", bitmap);
            bundle.putString("android.support.customtabs.customaction.DESCRIPTION", str);
            bundle.putParcelable("android.support.customtabs.customaction.PENDING_INTENT", pendingIntent);
            this.a.putExtra("android.support.customtabs.extra.ACTION_BUTTON_BUNDLE", bundle);
            this.a.putExtra("android.support.customtabs.extra.TINT_ACTION_BUTTON", z);
            return this;
        }

        public a d(Bitmap bitmap) {
            this.a.putExtra("android.support.customtabs.extra.CLOSE_BUTTON_ICON", bitmap);
            return this;
        }

        public a f(int i) {
            this.b.b(i);
            return this;
        }
    }

    C3917Cx1(Intent intent, Bundle bundle) {
        this.a = intent;
        this.b = bundle;
    }

    public void a(Context context, Uri uri) {
        this.a.setData(uri);
        AbstractC4043Dl1.o(context, this.a, this.b);
    }
}
