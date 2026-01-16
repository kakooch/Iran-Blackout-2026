package com.airbnb.android.showkase.ui;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import com.airbnb.android.showkase.exceptions.ShowkaseException;
import ir.nasim.AbstractC13042fc3;
import ir.nasim.AbstractC13472gH6;
import ir.nasim.AbstractC14607iB6;
import ir.nasim.AbstractC18350oW3;
import ir.nasim.AbstractC19242q11;
import ir.nasim.AbstractC23599xB6;
import ir.nasim.AbstractC5138Ib1;
import ir.nasim.AbstractC8614Ws3;
import ir.nasim.BB6;
import ir.nasim.C15800kB6;
import ir.nasim.C16391lB6;
import ir.nasim.C19938rB7;
import ir.nasim.C23009wB6;
import ir.nasim.InterfaceC14603iB2;
import ir.nasim.InterfaceC22053ub1;
import ir.nasim.InterfaceC9102Ym4;
import ir.nasim.R01;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000fB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0019\u0010\f\u001a\u00020\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0014¢\u0006\u0004\b\f\u0010\r¨\u0006\u0010"}, d2 = {"Lcom/airbnb/android/showkase/ui/ShowkaseBrowserActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "<init>", "()V", "", "classKey", "Lir/nasim/wB6;", "n1", "(Ljava/lang/String;)Lir/nasim/wB6;", "Landroid/os/Bundle;", "savedInstanceState", "Lir/nasim/rB7;", "onCreate", "(Landroid/os/Bundle;)V", "G", "a", "showkase_release"}, k = 1, mv = {1, 9, 0})
/* loaded from: classes2.dex */
public final class ShowkaseBrowserActivity extends AppCompatActivity {

    static final class b extends AbstractC8614Ws3 implements InterfaceC14603iB2 {
        final /* synthetic */ String f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(String str) {
            super(2);
            this.f = str;
        }

        public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) throws IllegalAccessException, InstantiationException, IllegalArgumentException, InvocationTargetException {
            if ((i & 11) == 2 && interfaceC22053ub1.k()) {
                interfaceC22053ub1.L();
                return;
            }
            if (AbstractC5138Ib1.I()) {
                AbstractC5138Ib1.Q(-695351285, i, -1, "com.airbnb.android.showkase.ui.ShowkaseBrowserActivity.onCreate.<anonymous> (ShowkaseBrowserActivity.kt:26)");
            }
            C23009wB6 c23009wB6N1 = ShowkaseBrowserActivity.this.n1(this.f);
            List listA = c23009wB6N1.a();
            List listB = c23009wB6N1.b();
            List listC = c23009wB6N1.c();
            interfaceC22053ub1.A(-2042459977);
            Object objB = interfaceC22053ub1.B();
            if (objB == InterfaceC22053ub1.a.a()) {
                objB = AbstractC13472gH6.d(new C16391lB6(null, null, null, null, false, null, 63, null), null, 2, null);
                interfaceC22053ub1.s(objB);
            }
            InterfaceC9102Ym4 interfaceC9102Ym4 = (InterfaceC9102Ym4) objB;
            interfaceC22053ub1.U();
            if ((!listA.isEmpty()) || (!listB.isEmpty()) || (!listC.isEmpty())) {
                interfaceC22053ub1.A(1108487708);
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                for (Object obj : listA) {
                    String strE = ((C15800kB6) obj).e();
                    Object arrayList = linkedHashMap.get(strE);
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                        linkedHashMap.put(strE, arrayList);
                    }
                    ((List) arrayList).add(obj);
                }
                LinkedHashMap linkedHashMap2 = new LinkedHashMap();
                Iterator it = listB.iterator();
                if (it.hasNext()) {
                    AbstractC18350oW3.a(it.next());
                    throw null;
                }
                LinkedHashMap linkedHashMap3 = new LinkedHashMap();
                Iterator it2 = listC.iterator();
                if (it2.hasNext()) {
                    AbstractC18350oW3.a(it2.next());
                    throw null;
                }
                AbstractC14607iB6.g(linkedHashMap, linkedHashMap2, linkedHashMap3, interfaceC9102Ym4, interfaceC22053ub1, 3656);
                interfaceC22053ub1.U();
            } else {
                interfaceC22053ub1.A(1108844146);
                AbstractC23599xB6.a("There were no elements that were annotated with either @ShowkaseComposable, @ShowkaseTypography or @ShowkaseColor. If you think this is a mistake, file an issue at https://github.com/airbnb/Showkase/issues", interfaceC22053ub1, 6);
                interfaceC22053ub1.U();
            }
            if (AbstractC5138Ib1.I()) {
                AbstractC5138Ib1.P();
            }
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) throws IllegalAccessException, InstantiationException, IllegalArgumentException, InvocationTargetException {
            a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
            return C19938rB7.a;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final C23009wB6 n1(String classKey) throws IllegalAccessException, InstantiationException, IllegalArgumentException, InvocationTargetException {
        try {
            Object objNewInstance = Class.forName(classKey + "Codegen").getDeclaredConstructor(null).newInstance(null);
            AbstractC13042fc3.g(objNewInstance, "null cannot be cast to non-null type com.airbnb.android.showkase.models.ShowkaseProvider");
            C23009wB6 c23009wB6A = ((BB6) objNewInstance).a();
            return new C23009wB6(c23009wB6A.e(), c23009wB6A.d(), c23009wB6A.f());
        } catch (ClassNotFoundException unused) {
            return new C23009wB6(null, null, null, 7, null);
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) throws ShowkaseException {
        String string;
        super.onCreate(savedInstanceState);
        Bundle extras = getIntent().getExtras();
        if (extras == null || (string = extras.getString("SHOWKASE_ROOT_MODULE")) == null) {
            throw new ShowkaseException("Missing key in bundle. Please start this activity by using the intent returned by the ShowkaseBrowserActivity.getIntent() method.");
        }
        R01.b(this, null, AbstractC19242q11.c(-695351285, true, new b(string)), 1, null);
    }
}
