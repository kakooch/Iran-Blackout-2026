package androidx.compose.ui.tooling;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import androidx.activity.ComponentActivity;
import androidx.compose.foundation.layout.f;
import androidx.compose.foundation.layout.h;
import androidx.compose.foundation.layout.q;
import androidx.compose.ui.e;
import ir.nasim.AbstractC10439bc6;
import ir.nasim.AbstractC13042fc3;
import ir.nasim.AbstractC19242q11;
import ir.nasim.AbstractC20762sZ6;
import ir.nasim.AbstractC21614tq2;
import ir.nasim.AbstractC5138Ib1;
import ir.nasim.AbstractC6797Pa1;
import ir.nasim.AbstractC8614Ws3;
import ir.nasim.AbstractC9364Zp5;
import ir.nasim.C10134b81;
import ir.nasim.C17469n11;
import ir.nasim.C19938rB7;
import ir.nasim.DG7;
import ir.nasim.InterfaceC10970cW3;
import ir.nasim.InterfaceC11819dc1;
import ir.nasim.InterfaceC12529em;
import ir.nasim.InterfaceC14603iB2;
import ir.nasim.InterfaceC15247jG;
import ir.nasim.InterfaceC15796kB2;
import ir.nasim.InterfaceC16030kb1;
import ir.nasim.InterfaceC17916nm4;
import ir.nasim.InterfaceC22053ub1;
import ir.nasim.R01;
import ir.nasim.SA2;
import ir.nasim.TS4;
import ir.nasim.UG6;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\bJ'\u0010\f\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\f\u0010\rJ\u0019\u0010\u0010\u001a\u00020\u00062\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0014¢\u0006\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0014\u001a\u00020\u00048\u0002X\u0082D¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013¨\u0006\u0015"}, d2 = {"Landroidx/compose/ui/tooling/PreviewActivity;", "Landroidx/activity/ComponentActivity;", "<init>", "()V", "", "composableFqn", "Lir/nasim/rB7;", "v0", "(Ljava/lang/String;)V", "className", "methodName", "parameterProvider", "w0", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "Landroid/os/Bundle;", "savedInstanceState", "onCreate", "(Landroid/os/Bundle;)V", "w", "Ljava/lang/String;", "TAG", "ui-tooling_release"}, k = 1, mv = {1, 9, 0})
/* loaded from: classes2.dex */
public final class PreviewActivity extends ComponentActivity {

    /* renamed from: w, reason: from kotlin metadata */
    private final String TAG = "PreviewActivity";

    static final class a extends AbstractC8614Ws3 implements InterfaceC14603iB2 {
        final /* synthetic */ String e;
        final /* synthetic */ String f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(String str, String str2) {
            super(2);
            this.e = str;
            this.f = str2;
        }

        public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) throws Exception {
            if (!interfaceC22053ub1.o((i & 3) != 2, i & 1)) {
                interfaceC22053ub1.L();
                return;
            }
            if (AbstractC5138Ib1.I()) {
                AbstractC5138Ib1.Q(-840626948, i, -1, "androidx.compose.ui.tooling.PreviewActivity.setComposableContent.<anonymous> (PreviewActivity.android.kt:74)");
            }
            C17469n11.a.g(this.e, this.f, interfaceC22053ub1, new Object[0]);
            if (AbstractC5138Ib1.I()) {
                AbstractC5138Ib1.P();
            }
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) throws Exception {
            a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
            return C19938rB7.a;
        }
    }

    static final class b extends AbstractC8614Ws3 implements InterfaceC14603iB2 {
        final /* synthetic */ Object[] e;
        final /* synthetic */ String f;
        final /* synthetic */ String g;

        static final class a extends AbstractC8614Ws3 implements InterfaceC14603iB2 {
            final /* synthetic */ Object[] e;
            final /* synthetic */ InterfaceC17916nm4 f;

            /* renamed from: androidx.compose.ui.tooling.PreviewActivity$b$a$a, reason: collision with other inner class name */
            static final class C0072a extends AbstractC8614Ws3 implements SA2 {
                final /* synthetic */ InterfaceC17916nm4 e;
                final /* synthetic */ Object[] f;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                C0072a(InterfaceC17916nm4 interfaceC17916nm4, Object[] objArr) {
                    super(0);
                    this.e = interfaceC17916nm4;
                    this.f = objArr;
                }

                public final void a() {
                    InterfaceC17916nm4 interfaceC17916nm4 = this.e;
                    interfaceC17916nm4.h((interfaceC17916nm4.d() + 1) % this.f.length);
                }

                @Override // ir.nasim.SA2
                public /* bridge */ /* synthetic */ Object invoke() {
                    a();
                    return C19938rB7.a;
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(Object[] objArr, InterfaceC17916nm4 interfaceC17916nm4) {
                super(2);
                this.e = objArr;
                this.f = interfaceC17916nm4;
            }

            public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
                if (!interfaceC22053ub1.o((i & 3) != 2, i & 1)) {
                    interfaceC22053ub1.L();
                    return;
                }
                if (AbstractC5138Ib1.I()) {
                    AbstractC5138Ib1.Q(958604965, i, -1, "androidx.compose.ui.tooling.PreviewActivity.setParameterizedContent.<anonymous>.<anonymous> (PreviewActivity.android.kt:117)");
                }
                InterfaceC14603iB2 interfaceC14603iB2A = C10134b81.a.a();
                boolean zD = interfaceC22053ub1.D(this.e);
                InterfaceC17916nm4 interfaceC17916nm4 = this.f;
                Object[] objArr = this.e;
                Object objB = interfaceC22053ub1.B();
                if (zD || objB == InterfaceC22053ub1.a.a()) {
                    objB = new C0072a(interfaceC17916nm4, objArr);
                    interfaceC22053ub1.s(objB);
                }
                AbstractC21614tq2.a(interfaceC14603iB2A, (SA2) objB, null, null, null, null, 0L, 0L, null, interfaceC22053ub1, 6, 508);
                if (AbstractC5138Ib1.I()) {
                    AbstractC5138Ib1.P();
                }
            }

            @Override // ir.nasim.InterfaceC14603iB2
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
                return C19938rB7.a;
            }
        }

        /* renamed from: androidx.compose.ui.tooling.PreviewActivity$b$b, reason: collision with other inner class name */
        static final class C0073b extends AbstractC8614Ws3 implements InterfaceC15796kB2 {
            final /* synthetic */ String e;
            final /* synthetic */ String f;
            final /* synthetic */ Object[] g;
            final /* synthetic */ InterfaceC17916nm4 h;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C0073b(String str, String str2, Object[] objArr, InterfaceC17916nm4 interfaceC17916nm4) {
                super(3);
                this.e = str;
                this.f = str2;
                this.g = objArr;
                this.h = interfaceC17916nm4;
            }

            public final void a(TS4 ts4, InterfaceC22053ub1 interfaceC22053ub1, int i) throws Exception {
                if ((i & 6) == 0) {
                    i |= interfaceC22053ub1.V(ts4) ? 4 : 2;
                }
                if (!interfaceC22053ub1.o((i & 19) != 18, 1 & i)) {
                    interfaceC22053ub1.L();
                    return;
                }
                if (AbstractC5138Ib1.I()) {
                    AbstractC5138Ib1.Q(57310875, i, -1, "androidx.compose.ui.tooling.PreviewActivity.setParameterizedContent.<anonymous>.<anonymous> (PreviewActivity.android.kt:107)");
                }
                e eVarH = q.h(e.a, ts4);
                String str = this.e;
                String str2 = this.f;
                Object[] objArr = this.g;
                InterfaceC17916nm4 interfaceC17916nm4 = this.h;
                InterfaceC10970cW3 interfaceC10970cW3G = f.g(InterfaceC12529em.a.o(), false);
                int iA = AbstractC6797Pa1.a(interfaceC22053ub1, 0);
                InterfaceC11819dc1 interfaceC11819dc1Q = interfaceC22053ub1.q();
                e eVarE = androidx.compose.ui.c.e(interfaceC22053ub1, eVarH);
                InterfaceC16030kb1.a aVar = InterfaceC16030kb1.d0;
                SA2 sa2A = aVar.a();
                if (!(interfaceC22053ub1.l() instanceof InterfaceC15247jG)) {
                    AbstractC6797Pa1.c();
                }
                interfaceC22053ub1.G();
                if (interfaceC22053ub1.h()) {
                    interfaceC22053ub1.g(sa2A);
                } else {
                    interfaceC22053ub1.r();
                }
                InterfaceC22053ub1 interfaceC22053ub1A = DG7.a(interfaceC22053ub1);
                DG7.c(interfaceC22053ub1A, interfaceC10970cW3G, aVar.e());
                DG7.c(interfaceC22053ub1A, interfaceC11819dc1Q, aVar.g());
                InterfaceC14603iB2 interfaceC14603iB2B = aVar.b();
                if (interfaceC22053ub1A.h() || !AbstractC13042fc3.d(interfaceC22053ub1A.B(), Integer.valueOf(iA))) {
                    interfaceC22053ub1A.s(Integer.valueOf(iA));
                    interfaceC22053ub1A.v(Integer.valueOf(iA), interfaceC14603iB2B);
                }
                DG7.c(interfaceC22053ub1A, eVarE, aVar.f());
                h hVar = h.a;
                C17469n11.a.g(str, str2, interfaceC22053ub1, objArr[interfaceC17916nm4.d()]);
                interfaceC22053ub1.u();
                if (AbstractC5138Ib1.I()) {
                    AbstractC5138Ib1.P();
                }
            }

            @Override // ir.nasim.InterfaceC15796kB2
            public /* bridge */ /* synthetic */ Object q(Object obj, Object obj2, Object obj3) throws Exception {
                a((TS4) obj, (InterfaceC22053ub1) obj2, ((Number) obj3).intValue());
                return C19938rB7.a;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(Object[] objArr, String str, String str2) {
            super(2);
            this.e = objArr;
            this.f = str;
            this.g = str2;
        }

        public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
            if (!interfaceC22053ub1.o((i & 3) != 2, i & 1)) {
                interfaceC22053ub1.L();
                return;
            }
            if (AbstractC5138Ib1.I()) {
                AbstractC5138Ib1.Q(-861939235, i, -1, "androidx.compose.ui.tooling.PreviewActivity.setParameterizedContent.<anonymous> (PreviewActivity.android.kt:103)");
            }
            Object objB = interfaceC22053ub1.B();
            if (objB == InterfaceC22053ub1.a.a()) {
                objB = UG6.a(0);
                interfaceC22053ub1.s(objB);
            }
            InterfaceC17916nm4 interfaceC17916nm4 = (InterfaceC17916nm4) objB;
            AbstractC10439bc6.a(null, null, null, null, null, AbstractC19242q11.e(958604965, true, new a(this.e, interfaceC17916nm4), interfaceC22053ub1, 54), 0, false, null, false, null, 0.0f, 0L, 0L, 0L, 0L, 0L, AbstractC19242q11.e(57310875, true, new C0073b(this.f, this.g, this.e, interfaceC17916nm4), interfaceC22053ub1, 54), interfaceC22053ub1, 196608, 12582912, 131039);
            if (AbstractC5138Ib1.I()) {
                AbstractC5138Ib1.P();
            }
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
            return C19938rB7.a;
        }
    }

    static final class c extends AbstractC8614Ws3 implements InterfaceC14603iB2 {
        final /* synthetic */ String e;
        final /* synthetic */ String f;
        final /* synthetic */ Object[] g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(String str, String str2, Object[] objArr) {
            super(2);
            this.e = str;
            this.f = str2;
            this.g = objArr;
        }

        public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) throws Exception {
            if (!interfaceC22053ub1.o((i & 3) != 2, i & 1)) {
                interfaceC22053ub1.L();
                return;
            }
            if (AbstractC5138Ib1.I()) {
                AbstractC5138Ib1.Q(-1901447514, i, -1, "androidx.compose.ui.tooling.PreviewActivity.setParameterizedContent.<anonymous> (PreviewActivity.android.kt:128)");
            }
            C17469n11 c17469n11 = C17469n11.a;
            String str = this.e;
            String str2 = this.f;
            Object[] objArr = this.g;
            c17469n11.g(str, str2, interfaceC22053ub1, Arrays.copyOf(objArr, objArr.length));
            if (AbstractC5138Ib1.I()) {
                AbstractC5138Ib1.P();
            }
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) throws Exception {
            a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
            return C19938rB7.a;
        }
    }

    private final void v0(String composableFqn) throws IllegalAccessException, InstantiationException, SecurityException, IllegalArgumentException, InvocationTargetException {
        Log.d(this.TAG, "PreviewActivity has composable " + composableFqn);
        String strK1 = AbstractC20762sZ6.k1(composableFqn, '.', null, 2, null);
        String strC1 = AbstractC20762sZ6.c1(composableFqn, '.', null, 2, null);
        String stringExtra = getIntent().getStringExtra("parameterProviderClassName");
        if (stringExtra != null) {
            w0(strK1, strC1, stringExtra);
            return;
        }
        Log.d(this.TAG, "Previewing '" + strC1 + "' without a parameter provider.");
        R01.b(this, null, AbstractC19242q11.c(-840626948, true, new a(strK1, strC1)), 1, null);
    }

    private final void w0(String className, String methodName, String parameterProvider) throws IllegalAccessException, InstantiationException, SecurityException, IllegalArgumentException, InvocationTargetException {
        Log.d(this.TAG, "Previewing '" + methodName + "' with parameter provider: '" + parameterProvider + '\'');
        Object[] objArrF = AbstractC9364Zp5.f(AbstractC9364Zp5.a(parameterProvider), getIntent().getIntExtra("parameterProviderIndex", -1));
        if (objArrF.length > 1) {
            R01.b(this, null, AbstractC19242q11.c(-861939235, true, new b(objArrF, className, methodName)), 1, null);
        } else {
            R01.b(this, null, AbstractC19242q11.c(-1901447514, true, new c(className, methodName, objArrF)), 1, null);
        }
    }

    @Override // androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) throws IllegalAccessException, InstantiationException, SecurityException, IllegalArgumentException, InvocationTargetException {
        String stringExtra;
        super.onCreate(savedInstanceState);
        if ((getApplicationInfo().flags & 2) == 0) {
            Log.d(this.TAG, "Application is not debuggable. Compose Preview not allowed.");
            finish();
            return;
        }
        Intent intent = getIntent();
        if (intent == null || (stringExtra = intent.getStringExtra("composable")) == null) {
            return;
        }
        v0(stringExtra);
    }
}
