package com.google.android.gms.auth.api.signin.internal;

import com.facebook.stetho.server.http.HttpHeaders;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.PendingResults;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.StatusPendingResult;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.logging.Logger;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

/* compiled from: com.google.android.gms:play-services-auth@@19.0.0 */
/* loaded from: classes.dex */
public final class zze implements Runnable {
    private static final Logger zzci = new Logger("RevokeAccessOperation", new String[0]);
    private final String zzcj;
    private final StatusPendingResult zzck = new StatusPendingResult(null);

    private zze(String str) {
        this.zzcj = Preconditions.checkNotEmpty(str);
    }

    @Override // java.lang.Runnable
    public final void run() throws IOException {
        Status status = Status.RESULT_INTERNAL_ERROR;
        try {
            String strValueOf = String.valueOf(this.zzcj);
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(strValueOf.length() != 0 ? "https://accounts.google.com/o/oauth2/revoke?token=".concat(strValueOf) : new String("https://accounts.google.com/o/oauth2/revoke?token=")).openConnection();
            httpURLConnection.setRequestProperty(HttpHeaders.CONTENT_TYPE, "application/x-www-form-urlencoded");
            int responseCode = httpURLConnection.getResponseCode();
            if (responseCode == 200) {
                status = Status.RESULT_SUCCESS;
            } else {
                zzci.e("Unable to revoke access!", new Object[0]);
            }
            Logger logger = zzci;
            StringBuilder sb = new StringBuilder(26);
            sb.append("Response Code: ");
            sb.append(responseCode);
            logger.d(sb.toString(), new Object[0]);
        } catch (IOException e) {
            Logger logger2 = zzci;
            String strValueOf2 = String.valueOf(e.toString());
            logger2.e(strValueOf2.length() != 0 ? "IOException when revoking access: ".concat(strValueOf2) : new String("IOException when revoking access: "), new Object[0]);
        } catch (Exception e2) {
            Logger logger3 = zzci;
            String strValueOf3 = String.valueOf(e2.toString());
            logger3.e(strValueOf3.length() != 0 ? "Exception when revoking access: ".concat(strValueOf3) : new String("Exception when revoking access: "), new Object[0]);
        }
        this.zzck.setResult(status);
    }

    public static PendingResult<Status> zzi(String str) {
        if (str == null) {
            return PendingResults.immediateFailedResult(new Status(4), null);
        }
        zze zzeVar = new zze(str);
        new Thread(zzeVar).start();
        return zzeVar.zzck;
    }
}
