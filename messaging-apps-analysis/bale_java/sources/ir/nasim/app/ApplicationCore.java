package ir.nasim.app;

import android.app.ActivityManager;
import android.app.Application;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.database.sqlite.SQLiteDatabase;
import android.gov.nist.javax.sip.parser.TokenNames;
import android.gov.nist.javax.sip.stack.SIPServerTransaction;
import android.os.Build;
import android.os.Process;
import android.os.StrictMode;
import coil.memory.MemoryCache;
import ir.nasim.AbstractC10533bm0;
import ir.nasim.AbstractC10685c16;
import ir.nasim.AbstractC11538dA5;
import ir.nasim.AbstractC12217eE5;
import ir.nasim.AbstractC13042fc3;
import ir.nasim.AbstractC13269fw3;
import ir.nasim.AbstractC14047hG;
import ir.nasim.AbstractC14862ic3;
import ir.nasim.AbstractC15401jX0;
import ir.nasim.AbstractC18497ol4;
import ir.nasim.AbstractC18815pI3;
import ir.nasim.AbstractC19859r37;
import ir.nasim.AbstractC20153rZ6;
import ir.nasim.AbstractC20507s76;
import ir.nasim.AbstractC20762sZ6;
import ir.nasim.AbstractC21784u76;
import ir.nasim.AbstractC23507x23;
import ir.nasim.AbstractC4014Di;
import ir.nasim.AbstractC4363Eu6;
import ir.nasim.AbstractC4597Fu6;
import ir.nasim.AbstractC5730Kp;
import ir.nasim.C10959cV1;
import ir.nasim.C11964dq7;
import ir.nasim.C12366eV1;
import ir.nasim.C13523gN3;
import ir.nasim.C13923h3;
import ir.nasim.C17050mJ2;
import ir.nasim.C17213mb2;
import ir.nasim.C17358mp7;
import ir.nasim.C18864pN7;
import ir.nasim.C19406qI3;
import ir.nasim.C19938rB7;
import ir.nasim.C19997rI3;
import ir.nasim.C20828sg3;
import ir.nasim.C21053t2;
import ir.nasim.C21701tz3;
import ir.nasim.C22078ud6;
import ir.nasim.C24181yA7;
import ir.nasim.C24790zC4;
import ir.nasim.C4077Dp;
import ir.nasim.C5161Id6;
import ir.nasim.C5490Jo2;
import ir.nasim.C5495Jo7;
import ir.nasim.C5721Ko;
import ir.nasim.C5735Kp4;
import ir.nasim.C6011Lu2;
import ir.nasim.C7183Qq;
import ir.nasim.C8386Vt0;
import ir.nasim.C92;
import ir.nasim.C9475a16;
import ir.nasim.C9835ae2;
import ir.nasim.ED1;
import ir.nasim.EnumC16760lp0;
import ir.nasim.EnumC18608ow5;
import ir.nasim.EnumC6540Ny1;
import ir.nasim.H;
import ir.nasim.I;
import ir.nasim.InterfaceC14603iB2;
import ir.nasim.InterfaceC15229jE;
import ir.nasim.InterfaceC18663p23;
import ir.nasim.InterfaceC20295rm1;
import ir.nasim.InterfaceC20315ro1;
import ir.nasim.InterfaceC21332tU1;
import ir.nasim.InterfaceC21731u23;
import ir.nasim.InterfaceC24010xt2;
import ir.nasim.InterfaceC3570Bk5;
import ir.nasim.InterfaceC5620Kc6;
import ir.nasim.InterfaceC9173Yu3;
import ir.nasim.KN6;
import ir.nasim.OI2;
import ir.nasim.PH3;
import ir.nasim.RA1;
import ir.nasim.SA2;
import ir.nasim.UO1;
import ir.nasim.app.ApplicationCore;
import ir.nasim.core.runtime.AccountInfo;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\"\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\r\b'\u0018\u0000 E2\u00020\u00012\u00020\u0002:\u0001:B\t\b\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0006\u0010\u0004J\u0017\u0010\t\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\r\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u001f\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u000fH\u0002¢\u0006\u0004\b\u0012\u0010\u0013J-\u0010\u0018\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u00072\u0006\u0010\u0015\u001a\u00020\u00072\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0016H\u0002¢\u0006\u0004\b\u0018\u0010\u0019J\u0019\u0010\u001b\u001a\u00020\u00052\b\b\u0002\u0010\u001a\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\u001b\u0010\nJ\u0017\u0010\u001d\u001a\u00020\u00052\u0006\u0010\u001c\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\u001d\u0010\u000eJ\u0017\u0010\u001e\u001a\u00020\u00052\u0006\u0010\u001a\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\u001e\u0010\nJ\u000f\u0010\u001f\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u001f\u0010\u0004J\u000f\u0010 \u001a\u00020\u0005H\u0002¢\u0006\u0004\b \u0010\u0004J\u0017\u0010\"\u001a\u00020\u00052\u0006\u0010!\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\"\u0010\u000eJ\u000f\u0010#\u001a\u00020\u0005H\u0002¢\u0006\u0004\b#\u0010\u0004J\u000f\u0010%\u001a\u00020$H\u0002¢\u0006\u0004\b%\u0010&J\u000f\u0010'\u001a\u00020\u0005H\u0002¢\u0006\u0004\b'\u0010\u0004J\u000f\u0010(\u001a\u00020\u0005H\u0002¢\u0006\u0004\b(\u0010\u0004J\u0019\u0010*\u001a\u0004\u0018\u00010\u000f2\u0006\u0010)\u001a\u00020\u0001H\u0002¢\u0006\u0004\b*\u0010+J\u0017\u0010.\u001a\u00020\u00052\u0006\u0010-\u001a\u00020,H\u0016¢\u0006\u0004\b.\u0010/J\u0017\u00102\u001a\u00020\u00052\u0006\u00101\u001a\u000200H\u0014¢\u0006\u0004\b2\u00103J\u000f\u00104\u001a\u00020\u0005H\u0017¢\u0006\u0004\b4\u0010\u0004J\u0017\u00106\u001a\u00020\u00052\u0006\u00105\u001a\u00020\u000bH\u0016¢\u0006\u0004\b6\u0010\u000eJ\r\u00107\u001a\u00020\u0005¢\u0006\u0004\b7\u0010\u0004J\u000f\u00108\u001a\u00020\u0005H\u0016¢\u0006\u0004\b8\u0010\u0004J\u000f\u0010:\u001a\u000209H\u0016¢\u0006\u0004\b:\u0010;R$\u0010?\u001a\u00020$2\u0006\u0010<\u001a\u00020$8\u0004@BX\u0084\u000e¢\u0006\f\n\u0004\b:\u0010=\u001a\u0004\b>\u0010&R!\u0010D\u001a\b\u0012\u0004\u0012\u00020\u000f0\u00168FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b@\u0010A\u001a\u0004\bB\u0010C¨\u0006F"}, d2 = {"Lir/nasim/app/ApplicationCore;", "Landroid/app/Application;", "Lir/nasim/u23;", "<init>", "()V", "Lir/nasim/rB7;", "i", "Lir/nasim/Bk5;", "defPref", "w", "(Lir/nasim/Bk5;)V", "", "myUid", "v", "(I)V", "", "newName", "oldName", TokenNames.E, "(Ljava/lang/String;Ljava/lang/String;)V", "sourcePref", "targetPref", "", "keys", "m", "(Lir/nasim/Bk5;Lir/nasim/Bk5;Ljava/util/Set;)V", "defaultPref", "n", "uid", "j", "l", TokenNames.C, "s", "minLogLevel", "k", TokenNames.F, "", "t", "()Z", "r", "G", SIPServerTransaction.CONTENT_TYPE_APPLICATION, "q", "(Landroid/app/Application;)Ljava/lang/String;", "Landroid/content/res/Configuration;", "newConfig", "onConfigurationChanged", "(Landroid/content/res/Configuration;)V", "Landroid/content/Context;", "base", "attachBaseContext", "(Landroid/content/Context;)V", "onCreate", "level", "onTrimMemory", "A", "onLowMemory", "Lir/nasim/p23;", "a", "()Lir/nasim/p23;", "value", "Z", "u", "isTestMode", "b", "Lir/nasim/Yu3;", "p", "()Ljava/util/Set;", "migrationPreferencesStorageKeyShared", "c", "app_productionMyketRelease"}, k = 1, mv = {2, 0, 0})
/* loaded from: classes.dex */
public abstract class ApplicationCore extends Application implements InterfaceC21731u23 {

    /* renamed from: c, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int d = 8;
    private static final String[] e = {":fcm_process", ":sdk.sadadpaymentmodule"};
    private static final InterfaceC9173Yu3 f = AbstractC13269fw3.a(new SA2() { // from class: ir.nasim.yF
        @Override // ir.nasim.SA2
        public final Object invoke() {
            return ApplicationCore.D();
        }
    });

    /* renamed from: a, reason: from kotlin metadata */
    private boolean isTestMode;

    /* renamed from: b, reason: from kotlin metadata */
    private final InterfaceC9173Yu3 migrationPreferencesStorageKeyShared = AbstractC13269fw3.a(new SA2() { // from class: ir.nasim.AF
        @Override // ir.nasim.SA2
        public final Object invoke() {
            return ApplicationCore.x();
        }
    });

    /* renamed from: ir.nasim.app.ApplicationCore$a, reason: from kotlin metadata */
    public static final class Companion {
        private Companion() {
        }

        public final InterfaceC3570Bk5 a() {
            return (InterfaceC3570Bk5) ApplicationCore.f.getValue();
        }

        public /* synthetic */ Companion(ED1 ed1) {
            this();
        }
    }

    static final class b extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;

        b(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return new b(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            AbstractC14862ic3.e();
            if (this.b != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            AbstractC10685c16.b(obj);
            AbstractC4014Di.b();
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((b) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void B(ApplicationCore applicationCore, C24790zC4 c24790zC4) {
        AbstractC13042fc3.i(applicationCore, "this$0");
        applicationCore.s();
    }

    private final void C() {
        ((InterfaceC15229jE) C92.a(this, InterfaceC15229jE.class)).F().h();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final InterfaceC3570Bk5 D() {
        return C7183Qq.r("properties.ini");
    }

    private final void E(String newName, String oldName) {
        C5721Ko c5721Ko = C5721Ko.a;
        File databasePath = c5721Ko.d().getDatabasePath(oldName);
        File databasePath2 = c5721Ko.d().getDatabasePath(newName);
        if (databasePath2.exists() || !databasePath.exists()) {
            return;
        }
        databasePath.renameTo(databasePath2);
    }

    private final void F() {
        InterfaceC3570Bk5 interfaceC3570Bk5P = C7183Qq.p();
        interfaceC3570Bk5P.g("auth_yes", true);
        interfaceC3570Bk5P.putInt("auth_uid", 0);
        interfaceC3570Bk5P.putString("auth_jwt", "");
        interfaceC3570Bk5P.putLong("auth_access_hash", 0L);
        interfaceC3570Bk5P.putLong("auth_phone", 989123456789L);
        if (AbstractC20762sZ6.X("release", "benchmark", false, 2, null)) {
            C13923h3 c13923h3 = C13923h3.a;
            c13923h3.u();
            c13923h3.w(AccountInfo.INSTANCE.a().getUid());
        }
    }

    private final void G() {
        new I().d(true).c(new I.f() { // from class: ir.nasim.BF
            @Override // ir.nasim.I.f
            public final void a(H h) {
                ApplicationCore.H(h);
            }
        }).start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void H(H h) {
        try {
            C19406qI3.c("ANR", " raised : ", h);
            C17213mb2.a.e(h);
        } catch (Exception e2) {
            C19406qI3.d("ANR", e2);
        }
    }

    private final void i() {
        C13923h3 c13923h3 = C13923h3.a;
        if (c13923h3.j().h("migrated_shared_pref", false)) {
            return;
        }
        if (INSTANCE.a().h("auth_yes", false) || c13923h3.t()) {
            InterfaceC3570Bk5 interfaceC3570Bk5R = C7183Qq.r("0_default_pref.ini");
            if (interfaceC3570Bk5R.getAll().isEmpty()) {
                o(this, null, 1, null);
            } else {
                AbstractC13042fc3.f(interfaceC3570Bk5R);
                w(interfaceC3570Bk5R);
            }
            c13923h3.j().g("migrated_shared_pref", true);
        }
    }

    private final void j(int uid) {
        Object objB;
        Object objB2;
        if (C8386Vt0.u8()) {
            String str = "dialog_old_db_cleaned_for_" + uid;
            InterfaceC3570Bk5 interfaceC3570Bk5O = KN6.o();
            if (interfaceC3570Bk5O.h(str, false)) {
                return;
            }
            String str2 = uid + "_dialog";
            File databasePath = getDatabasePath(str2);
            File parentFile = databasePath.getParentFile();
            if (parentFile == null) {
                return;
            }
            try {
                C9475a16.a aVar = C9475a16.b;
                objB = C9475a16.b(Boolean.valueOf(SQLiteDatabase.deleteDatabase(databasePath)));
            } catch (Throwable th) {
                C9475a16.a aVar2 = C9475a16.b;
                objB = C9475a16.b(AbstractC10685c16.a(th));
            }
            if (C9475a16.e(objB) != null) {
                UO1.c.b(UO1.c.a, "DELETE TEMP db failed!", null, 2, null);
            }
            Set setB = AbstractC4363Eu6.b();
            setB.add(databasePath);
            setB.add(new File(parentFile, str2 + "-wal"));
            setB.add(new File(parentFile, str2 + "-shm"));
            setB.add(new File(parentFile, str2 + "-journal"));
            Set setA = AbstractC4363Eu6.a(setB);
            ArrayList<File> arrayList = new ArrayList();
            for (Object obj : setA) {
                if (((File) obj).exists()) {
                    arrayList.add(obj);
                }
            }
            for (File file : arrayList) {
                try {
                    C9475a16.a aVar3 = C9475a16.b;
                    objB2 = C9475a16.b(Boolean.valueOf(file.delete()));
                } catch (Throwable th2) {
                    C9475a16.a aVar4 = C9475a16.b;
                    objB2 = C9475a16.b(AbstractC10685c16.a(th2));
                }
                if (C9475a16.e(objB2) != null) {
                    UO1.c.b(UO1.c.a, "TEMP-DB: DELETE " + databasePath + " failed!", null, 2, null);
                }
            }
            interfaceC3570Bk5O.g(InterfaceC24010xt2.a.a(uid), false);
            interfaceC3570Bk5O.g("LOAD_PIN_DIALOG", false);
            interfaceC3570Bk5O.g(str, true);
        }
    }

    private final void k(int minLogLevel) {
        AbstractC18815pI3.i(minLogLevel);
        AbstractC18815pI3.j(C9835ae2.b);
    }

    private final void l(InterfaceC3570Bk5 defaultPref) {
        Set setKeySet = defaultPref.getAll().keySet();
        ArrayList arrayList = new ArrayList();
        for (Object obj : setKeySet) {
            if (!p().contains((String) obj)) {
                arrayList.add(obj);
            }
        }
        Set setR1 = AbstractC15401jX0.r1(arrayList);
        InterfaceC3570Bk5 interfaceC3570Bk5P = C7183Qq.p();
        AbstractC13042fc3.h(interfaceC3570Bk5P, "getInstance(...)");
        m(defaultPref, interfaceC3570Bk5P, setR1);
        InterfaceC3570Bk5 interfaceC3570Bk5S = C7183Qq.s();
        AbstractC13042fc3.h(interfaceC3570Bk5S, "getSharedInstance(...)");
        m(defaultPref, interfaceC3570Bk5S, p());
        EnumC18608ow5[] enumC18608ow5ArrValues = EnumC18608ow5.values();
        ArrayList<EnumC18608ow5> arrayList2 = new ArrayList();
        for (EnumC18608ow5 enumC18608ow5 : enumC18608ow5ArrValues) {
            if (enumC18608ow5.q()) {
                arrayList2.add(enumC18608ow5);
            }
        }
        for (EnumC18608ow5 enumC18608ow52 : arrayList2) {
            InterfaceC3570Bk5 interfaceC3570Bk5R = C7183Qq.r(enumC18608ow52.j());
            InterfaceC3570Bk5 interfaceC3570Bk5R2 = C7183Qq.r(enumC18608ow52.getValue());
            AbstractC13042fc3.f(interfaceC3570Bk5R);
            AbstractC13042fc3.f(interfaceC3570Bk5R2);
            m(interfaceC3570Bk5R, interfaceC3570Bk5R2, interfaceC3570Bk5R.getAll().keySet());
        }
    }

    private final void m(InterfaceC3570Bk5 sourcePref, InterfaceC3570Bk5 targetPref, Set keys) {
        Map all = sourcePref.getAll();
        Iterator it = keys.iterator();
        while (it.hasNext()) {
            String str = (String) it.next();
            Object obj = all.get(str);
            if (obj instanceof String) {
                targetPref.putString(str, (String) obj);
            } else if (obj instanceof Integer) {
                targetPref.putInt(str, ((Number) obj).intValue());
            } else if (obj instanceof Boolean) {
                targetPref.g(str, ((Boolean) obj).booleanValue());
            } else if (obj instanceof Float) {
                targetPref.putFloat(str, ((Number) obj).floatValue());
            } else if (obj instanceof Long) {
                targetPref.putLong(str, ((Number) obj).longValue());
            } else if (obj instanceof byte[]) {
                targetPref.f(str, (byte[]) obj);
            }
        }
    }

    private final void n(InterfaceC3570Bk5 defaultPref) {
        int i = defaultPref.getInt("auth_uid", 0);
        AccountInfo accountInfo = new AccountInfo(true, i, defaultPref.getString("auth_jwt", ""), defaultPref.getLong("auth_phone", 0L), defaultPref.getLong("auth_access_hash", 0L), defaultPref.getLong("auth_id", 0L), defaultPref.b("auth_master_key"), defaultPref.b("auth_user"), true);
        C13923h3 c13923h3 = C13923h3.a;
        c13923h3.e(accountInfo);
        c13923h3.f(i);
        l(defaultPref);
        v(i);
        j(i);
    }

    static /* synthetic */ void o(ApplicationCore applicationCore, InterfaceC3570Bk5 interfaceC3570Bk5, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: doMigratePrefAndDB");
        }
        if ((i & 1) != 0) {
            interfaceC3570Bk5 = INSTANCE.a();
        }
        applicationCore.n(interfaceC3570Bk5);
    }

    private final String q(Application application) {
        int iMyPid = Process.myPid();
        String packageName = application.getPackageName();
        Object systemService = application.getSystemService("activity");
        ActivityManager activityManager = systemService instanceof ActivityManager ? (ActivityManager) systemService : null;
        if (activityManager != null && activityManager.getRunningAppProcesses() != null) {
            for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : activityManager.getRunningAppProcesses()) {
                if (iMyPid == runningAppProcessInfo.pid) {
                    packageName = runningAppProcessInfo.processName;
                }
            }
        }
        for (String str : e) {
            AbstractC13042fc3.f(packageName);
            if (AbstractC20153rZ6.C(packageName, str, false, 2, null)) {
                return packageName;
            }
        }
        return null;
    }

    private final void r() {
        if (AbstractC21784u76.d()) {
            return;
        }
        StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder().detectNetwork().detectCustomSlowCalls().detectDiskWrites().detectDiskReads().detectAll().penaltyLog().penaltyFlashScreen().build());
        StrictMode.VmPolicy.Builder builderPenaltyLog = new StrictMode.VmPolicy.Builder().detectLeakedSqlLiteObjects().detectActivityLeaks().detectLeakedRegistrationObjects().penaltyLog();
        AbstractC13042fc3.h(builderPenaltyLog, "penaltyLog(...)");
        if (Build.VERSION.SDK_INT >= 31) {
            builderPenaltyLog.detectUnsafeIntentLaunch();
        }
        StrictMode.setVmPolicy(builderPenaltyLog.build());
    }

    private final void s() {
        ((InterfaceC15229jE) C92.a(this, InterfaceC15229jE.class)).F().f();
    }

    private final boolean t() {
        String processName;
        int iMyPid = Process.myPid();
        String packageName = getPackageName();
        if (Build.VERSION.SDK_INT >= 28) {
            processName = Application.getProcessName();
        } else {
            Object systemService = getSystemService("activity");
            ActivityManager activityManager = systemService instanceof ActivityManager ? (ActivityManager) systemService : null;
            if (activityManager == null || activityManager.getRunningAppProcesses() == null) {
                processName = "";
            } else {
                for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : activityManager.getRunningAppProcesses()) {
                    if (iMyPid == runningAppProcessInfo.pid) {
                        processName = runningAppProcessInfo.processName;
                        break;
                    }
                }
                processName = "";
            }
        }
        return AbstractC13042fc3.d(processName, packageName);
    }

    private final void v(int myUid) {
        for (EnumC6540Ny1 enumC6540Ny1 : EnumC6540Ny1.values()) {
            E(myUid + enumC6540Ny1.getValue(), enumC6540Ny1.j());
        }
    }

    private final void w(InterfaceC3570Bk5 defPref) {
        InterfaceC3570Bk5 interfaceC3570Bk5P = C7183Qq.p();
        AbstractC13042fc3.f(interfaceC3570Bk5P);
        m(defPref, interfaceC3570Bk5P, defPref.getAll().keySet());
        E(C13923h3.a.m() + "_main", "0_main");
        defPref.clear();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Set x() {
        return AbstractC4597Fu6.i("registration_endpoint", "build_serial", "is_camera_permission_asked", "audio_player_shuffle_mode", "audio_player_repeat_mode", "AUDIO_SPEED", "Theme_Pref", "message_text_size", "show_on_lock_screen_last_display", "background_restriction_last_display", "is_using_old_wallpapers", "device_hash");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final MemoryCache y(ApplicationCore applicationCore) {
        AbstractC13042fc3.i(applicationCore, "this$0");
        return new MemoryCache.a(applicationCore).b(0.1d).a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final InterfaceC21332tU1 z(ApplicationCore applicationCore) {
        AbstractC13042fc3.i(applicationCore, "this$0");
        InterfaceC21332tU1.a aVarD = new InterfaceC21332tU1.a().d(0.05d);
        File cacheDir = applicationCore.getCacheDir();
        AbstractC13042fc3.h(cacheDir, "getCacheDir(...)");
        return aVarD.b(cacheDir).a();
    }

    public final void A() throws Resources.NotFoundException, NumberFormatException {
        C5735Kp4.w().p(getResources().getString(AbstractC12217eE5.app_name));
        String string = getResources().getString(AbstractC12217eE5.bale_google_app_id);
        AbstractC13042fc3.h(string, "getString(...)");
        C5735Kp4.w().t(Long.parseLong(string));
        C5735Kp4.w().q(getApplicationContext().getResources().getStringArray(AbstractC11538dA5.najva_endpoints));
    }

    @Override // ir.nasim.InterfaceC21731u23
    public InterfaceC18663p23 a() {
        InterfaceC18663p23.a aVarI = AbstractC23507x23.a(this).c().i(false);
        EnumC16760lp0 enumC16760lp0 = EnumC16760lp0.c;
        return aVarI.h(enumC16760lp0).g(new SA2() { // from class: ir.nasim.CF
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return ApplicationCore.y(this.a);
            }
        }).e(enumC16760lp0).d(new SA2() { // from class: ir.nasim.DF
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return ApplicationCore.z(this.a);
            }
        }).f(new RA1(0, 1, null)).b();
    }

    @Override // android.content.ContextWrapper
    protected void attachBaseContext(Context base) {
        AbstractC13042fc3.i(base, "base");
        C5721Ko.a.k(base);
        super.attachBaseContext(PH3.h(base));
        AbstractC18497ol4.l(this);
    }

    @Override // android.app.Application, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration newConfig) {
        AbstractC13042fc3.i(newConfig, "newConfig");
        C5721Ko.a.k(this);
        C5161Id6.b(this, newConfig);
        super.onConfigurationChanged(newConfig);
        PH3.h(this);
    }

    @Override // android.app.Application
    public void onCreate() throws Resources.NotFoundException, NumberFormatException {
        if (!t()) {
            super.onCreate();
            return;
        }
        this.isTestMode = getSharedPreferences("configs_test", 0).getBoolean("is_testing_mode", false) || AbstractC20762sZ6.X("release", "benchmark", false, 2, null);
        C5721Ko.a.k(this);
        AbstractC21784u76.h(!C18864pN7.a(this));
        AbstractC21784u76.f(AbstractC20762sZ6.X("release", "benchmark", false, 2, null));
        AbstractC21784u76.g(AbstractC20762sZ6.X("productionMyket", "Beta", false, 2, null));
        i();
        C6011Lu2 c6011Lu2 = C6011Lu2.a;
        c6011Lu2.g(this, C7183Qq.q(EnumC18608ow5.d).e("defaultFont"));
        setTheme(c6011Lu2.d());
        r();
        super.onCreate();
        if (this.isTestMode) {
            F();
        } else {
            AbstractC5730Kp.b(this);
            registerActivityLifecycleCallbacks(new C21053t2());
            registerActivityLifecycleCallbacks(new C11964dq7());
        }
        Thread.setDefaultUncaughtExceptionHandler(new C19997rI3(this));
        C5495Jo7.l1(this);
        String strQ = q(this);
        C19406qI3.a("SyncLog", "app_create_start: process= " + strQ, new Object[0]);
        if (!this.isTestMode) {
            C5490Jo2.p(this);
        }
        PH3.h(this);
        AbstractC20507s76.s(new C10959cV1(), new C17358mp7(), new C13523gN3(), new C21701tz3(new C4077Dp()), new C24181yA7());
        if (strQ != null) {
            C19406qI3.a("SyncLog", "Return from create application", new Object[0]);
            return;
        }
        A();
        C();
        C5735Kp4.w().C(new InterfaceC5620Kc6() { // from class: ir.nasim.zF
            @Override // ir.nasim.InterfaceC5620Kc6
            public final void onSuccess(Object obj) {
                ApplicationCore.B(this.a, (C24790zC4) obj);
            }
        });
        G();
        C20828sg3.b.b();
        if (!this.isTestMode) {
            C17213mb2.a.c("8517f14f-5730-4f64-a8ed-7140c6793455", this);
        }
        C22078ud6.a.d(this);
        AbstractC14047hG.g(this);
        k(2);
        AbstractC10533bm0.d(C17050mJ2.a, C12366eV1.b(), null, new b(null), 2, null);
    }

    @Override // android.app.Application, android.content.ComponentCallbacks
    public void onLowMemory() {
        super.onLowMemory();
        OI2.a(this).onLowMemory();
    }

    @Override // android.app.Application, android.content.ComponentCallbacks2
    public void onTrimMemory(int level) {
        super.onTrimMemory(level);
        C19406qI3.a("MEMORY", " onTrimMemory with level : " + level, new Object[0]);
    }

    public final Set p() {
        return (Set) this.migrationPreferencesStorageKeyShared.getValue();
    }

    /* renamed from: u, reason: from getter */
    protected final boolean getIsTestMode() {
        return this.isTestMode;
    }
}
