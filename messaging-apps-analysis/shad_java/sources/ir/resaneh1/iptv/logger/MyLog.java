package ir.resaneh1.iptv.logger;

import android.util.Log;
import android.widget.Toast;
import io.github.inflationx.calligraphy3.BuildConfig;
import ir.resaneh1.iptv.apiMessanger.ApiServerException;
import ir.resaneh1.iptv.helper.CrashHandelHelper;
import ir.resaneh1.iptv.model.Link;
import ir.resaneh1.iptv.presenter.MainClickHandler;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import org.rbmain.messenger.AndroidUtilities;
import org.rbmain.messenger.ApplicationLoader;

/* loaded from: classes.dex */
public class MyLog {
    public static boolean isDebugAble = false;
    public static boolean throwApiExeption = false;

    public static void d(String str, String str2) {
    }

    public static void e(String str, String str2) {
        if (isDebugAble) {
            if (str2.length() < 2000) {
                Log.e("AAA " + str, str2);
                return;
            }
            int i = 0;
            while (i <= str2.length() / 2000) {
                int i2 = i * 2000;
                i++;
                int length = i * 2000;
                if (length > str2.length()) {
                    length = str2.length();
                }
                Log.e("AAA " + str, str2.substring(i2, length));
            }
        }
    }

    public static void handleException(final Throwable th) {
        if (isDebugAble) {
            if ((!throwApiExeption && (th instanceof ApiServerException)) || (th instanceof UnknownHostException) || (th.getCause() instanceof UnknownHostException) || (th.getCause() instanceof SocketTimeoutException)) {
                return;
            }
            th.printStackTrace();
            for (int i = 0; i < 100; i++) {
                e("DEBUGERRORRRRR", i + "DEBUGERRORRRRR#########################################");
            }
            CrashHandelHelper.handleCrashOnMyLog(th);
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.resaneh1.iptv.logger.MyLog.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        Toast.makeText(ApplicationLoader.applicationContext, th.getMessage() + BuildConfig.FLAVOR, 1).show();
                        Link link = new Link();
                        link.type = Link.LinkTypeEnum.alert;
                        link.alert_data = new Link.AlertData();
                        StringWriter stringWriter = new StringWriter();
                        th.printStackTrace(new PrintWriter(stringWriter));
                        link.alert_data.message = stringWriter.toString();
                        link.alert_data.link = new Link();
                        Link link2 = link.alert_data.link;
                        link2.type = Link.LinkTypeEnum.copy;
                        link2.copy_data = new Link.CopyDataInLink();
                        link.alert_data.link.copy_data.copy_text = th.getMessage() + " " + stringWriter.toString();
                        Link.AlertData alertData = link.alert_data;
                        alertData.link.copy_data.toast_text = "کپی شد";
                        alertData.has_link = true;
                        new MainClickHandler().onLinkClick(link);
                    } catch (Exception unused) {
                    }
                }
            });
        }
    }

    public static void handleExceptionThrowOnDebug(Throwable th) {
        if (isDebugAble) {
            handleException(th);
            th.printStackTrace();
        }
    }
}
