package ir.nasim;

import android.content.Context;
import android.os.Build;
import android.view.accessibility.AccessibilityManager;
import org.xbill.DNS.TTL;

/* renamed from: ir.nasim.bn, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C10542bn implements A2 {
    private static final a b = new a(null);
    public static final int c = 8;
    private final AccessibilityManager a;

    /* renamed from: ir.nasim.bn$a */
    private static final class a {
        private a() {
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    public C10542bn(Context context) {
        Object systemService = context.getSystemService("accessibility");
        AbstractC13042fc3.g(systemService, "null cannot be cast to non-null type android.view.accessibility.AccessibilityManager");
        this.a = (AccessibilityManager) systemService;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // ir.nasim.A2
    public long a(long j, boolean z, boolean z2, boolean z3) {
        int i = z;
        if (j >= TTL.MAX_VALUE) {
            return j;
        }
        if (z2) {
            i = (z ? 1 : 0) | 2;
        }
        if (z3) {
            i = (i == true ? 1 : 0) | 4;
        }
        if (Build.VERSION.SDK_INT >= 29) {
            int iA = C19774qv.a.a(this.a, (int) j, i);
            if (iA != Integer.MAX_VALUE) {
                return iA;
            }
        } else if (!z3 || !this.a.isTouchExplorationEnabled()) {
            return j;
        }
        return Long.MAX_VALUE;
    }
}
