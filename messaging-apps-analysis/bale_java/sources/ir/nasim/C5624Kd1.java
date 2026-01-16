package ir.nasim;

import android.gov.nist.core.Separators;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ListIterator;

/* renamed from: ir.nasim.Kd1, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C5624Kd1 {
    public static final C5624Kd1 a = new C5624Kd1();
    public static final String[] b = {"com.noshufou.android.su", "com.noshufou.android.su.elite", "eu.chainfire.supersu", "com.koushikdutta.superuser", "com.thirdparty.superuser", "com.yellowes.su", "com.topjohnwu.magisk", "com.kingroot.kinguser", "com.kingo.root", "com.smedialink.oneclickroot", "com.zhiqupk.root.global", "com.alephzain.framaroot"};
    public static final String[] c = {"com.koushikdutta.rommanager", "com.koushikdutta.rommanager.license", "com.dimonvideo.luckypatcher", "com.chelpus.lackypatch", "com.ramdroid.appquarantine", "com.ramdroid.appquarantinepro", "com.android.vending.billing.InAppBillingService.COIN", "com.android.vending.billing.InAppBillingService.LUCK", "com.chelpus.luckypatcher", "com.blackmartalpha", "org.blackmart.market", "com.allinone.free", "com.repodroid.app", "org.creeplays.hack", "com.baseappfull.fwd", "com.zmapp", "com.dv.marketmod.installer", "org.mobilism.android", "com.android.wp.net.log", "com.android.camera.update", "cc.madkite.freedom", "com.solohsu.android.edxp.manager", "org.meowcat.edxposed.manager", "com.xmodgame", "com.cih.game_cih", "com.charles.lpoqasert", "catch_.me_.if_.you_.can_"};
    public static final String[] d = {"com.devadvance.rootcloak", "com.devadvance.rootcloakplus", "de.robv.android.xposed.installer", "com.saurik.substrate", "com.zachspong.temprootremovejb", "com.amphoras.hidemyroot", "com.amphoras.hidemyrootadfree", "com.formyhm.hiderootPremium", "com.formyhm.hideroot"};
    private static final String[] e = {"/data/local/", "/data/local/bin/", "/data/local/xbin/", "/sbin/", "/su/bin/", "/system/bin/", "/system/bin/.ext/", "/system/bin/failsafe/", "/system/sd/xbin/", "/system/usr/we-need-root/", "/system/xbin/", "/cache/", "/data/", "/dev/"};
    private static final String[] f = {"/system", "/system/bin", "/system/sbin", "/system/xbin", "/vendor/bin", "/sbin", "/etc"};

    private C5624Kd1() {
    }

    public static final String[] a() {
        List listM;
        String[] strArr = e;
        ArrayList arrayList = new ArrayList(AbstractC10360bX0.p(Arrays.copyOf(strArr, strArr.length)));
        String str = System.getenv("PATH");
        if (str == null) {
            str = null;
        }
        if (str == null || AbstractC13042fc3.d("", str)) {
            return (String[]) arrayList.toArray(new String[0]);
        }
        List listM2 = new C20644sM5(":").m(str, 0);
        if (listM2.isEmpty()) {
            listM = AbstractC10360bX0.m();
        } else {
            ListIterator listIterator = listM2.listIterator(listM2.size());
            while (listIterator.hasPrevious()) {
                if (((String) listIterator.previous()).length() != 0) {
                    listM = AbstractC15401jX0.f1(listM2, listIterator.nextIndex() + 1);
                    break;
                }
            }
            listM = AbstractC10360bX0.m();
        }
        for (String str2 : (String[]) listM.toArray(new String[0])) {
            String str3 = AbstractC20153rZ6.C(str2, Separators.SLASH, false, 2, null) ? str2 : str2 + Separators.SLASH;
            if (!arrayList.contains(str2)) {
                arrayList.add(str3);
            }
        }
        return (String[]) arrayList.toArray(new String[0]);
    }

    public final String[] b() {
        return f;
    }
}
