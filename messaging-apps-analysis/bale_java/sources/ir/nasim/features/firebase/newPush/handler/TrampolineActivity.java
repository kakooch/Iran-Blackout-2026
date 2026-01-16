package ir.nasim.features.firebase.newPush.handler;

import android.app.ActivityManager;
import android.content.Intent;
import android.os.Bundle;
import android.os.Process;
import androidx.appcompat.app.AppCompatActivity;
import ir.nasim.AbstractC10533bm0;
import ir.nasim.AbstractC10685c16;
import ir.nasim.AbstractC13042fc3;
import ir.nasim.AbstractC14862ic3;
import ir.nasim.AbstractC19859r37;
import ir.nasim.C13923h3;
import ir.nasim.C17050mJ2;
import ir.nasim.C19938rB7;
import ir.nasim.C5721Ko;
import ir.nasim.HG1;
import ir.nasim.InterfaceC14603iB2;
import ir.nasim.InterfaceC20295rm1;
import ir.nasim.InterfaceC20315ro1;
import ir.nasim.features.MainActivity;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\t\b\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0005\u0010\u0003J\u000f\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0019\u0010\u000b\u001a\u00020\u00042\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0014¢\u0006\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"Lir/nasim/features/firebase/newPush/handler/TrampolineActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "<init>", "()V", "Lir/nasim/rB7;", "n1", "", "l1", "()I", "Landroid/os/Bundle;", "savedInstanceState", "onCreate", "(Landroid/os/Bundle;)V", "nasim_release"}, k = 1, mv = {2, 0, 0})
/* loaded from: classes5.dex */
public final class TrampolineActivity extends AppCompatActivity {

    static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;

        a(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return new a(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                this.b = 1;
                if (HG1.b(100L, this) == objE) {
                    return objE;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
            }
            Process.killProcess(Process.myPid());
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((a) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    private final int l1() {
        String packageName = getApplication().getPackageName();
        Object systemService = getApplication().getSystemService("activity");
        ActivityManager activityManager = systemService instanceof ActivityManager ? (ActivityManager) systemService : null;
        int i = 0;
        if (activityManager != null && activityManager.getRunningAppProcesses() != null) {
            for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : activityManager.getRunningAppProcesses()) {
                if (AbstractC13042fc3.d(packageName, runningAppProcessInfo.processName)) {
                    i = runningAppProcessInfo.pid;
                }
            }
        }
        return i;
    }

    private final void n1() {
        Intent intent = new Intent(C5721Ko.a.d(), (Class<?>) MainActivity.class);
        intent.addFlags(268435456);
        intent.addFlags(536870912);
        intent.putExtras(getIntent());
        intent.setAction("OPEN_APP");
        startActivity(intent);
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            int i = extras.getInt("PEER_ID");
            C13923h3 c13923h3 = C13923h3.a;
            if (c13923h3.m() == i) {
                n1();
                finish();
                return;
            }
            c13923h3.f(i);
            Process.killProcess(l1());
            n1();
            AbstractC10533bm0.d(C17050mJ2.a, null, null, new a(null), 3, null);
            finish();
        }
    }
}
