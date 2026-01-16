package ir.nasim;

import android.content.Context;
import android.content.Intent;
import ir.nasim.AbstractC18108o6;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

/* renamed from: ir.nasim.q6, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C19290q6 extends AbstractC18108o6 {
    public static final a a = new a(null);

    /* renamed from: ir.nasim.q6$a */
    public static final class a {
        private a() {
        }

        public final Intent a(String[] strArr) {
            AbstractC13042fc3.i(strArr, "input");
            Intent intentPutExtra = new Intent("androidx.activity.result.contract.action.REQUEST_PERMISSIONS").putExtra("androidx.activity.result.contract.extra.PERMISSIONS", strArr);
            AbstractC13042fc3.h(intentPutExtra, "Intent(ACTION_REQUEST_PE…EXTRA_PERMISSIONS, input)");
            return intentPutExtra;
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    @Override // ir.nasim.AbstractC18108o6
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public Intent a(Context context, String[] strArr) {
        AbstractC13042fc3.i(context, "context");
        AbstractC13042fc3.i(strArr, "input");
        return a.a(strArr);
    }

    @Override // ir.nasim.AbstractC18108o6
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public AbstractC18108o6.a b(Context context, String[] strArr) {
        AbstractC13042fc3.i(context, "context");
        AbstractC13042fc3.i(strArr, "input");
        if (strArr.length == 0) {
            return new AbstractC18108o6.a(AbstractC20051rO3.k());
        }
        for (String str : strArr) {
            if (AbstractC4043Dl1.a(context, str) != 0) {
                return null;
            }
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap(AbstractC23053wG5.e(AbstractC19460qO3.f(strArr.length), 16));
        for (String str2 : strArr) {
            XV4 xv4A = AbstractC4616Fw7.a(str2, Boolean.TRUE);
            linkedHashMap.put(xv4A.e(), xv4A.f());
        }
        return new AbstractC18108o6.a(linkedHashMap);
    }

    @Override // ir.nasim.AbstractC18108o6
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public Map c(int i, Intent intent) {
        if (i == -1 && intent != null) {
            String[] stringArrayExtra = intent.getStringArrayExtra("androidx.activity.result.contract.extra.PERMISSIONS");
            int[] intArrayExtra = intent.getIntArrayExtra("androidx.activity.result.contract.extra.PERMISSION_GRANT_RESULTS");
            if (intArrayExtra == null || stringArrayExtra == null) {
                return AbstractC20051rO3.k();
            }
            ArrayList arrayList = new ArrayList(intArrayExtra.length);
            for (int i2 : intArrayExtra) {
                arrayList.add(Boolean.valueOf(i2 == 0));
            }
            return AbstractC20051rO3.w(AbstractC15401jX0.v1(AbstractC10242bK.Y(stringArrayExtra), arrayList));
        }
        return AbstractC20051rO3.k();
    }
}
