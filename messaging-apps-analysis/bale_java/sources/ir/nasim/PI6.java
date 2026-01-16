package ir.nasim;

import android.app.PendingIntent;
import android.os.Bundle;
import java.util.List;

/* loaded from: classes3.dex */
public abstract class PI6 {
    public static PI6 j(Bundle bundle) {
        return new Wg8(bundle.getInt("session_id"), bundle.getInt("status"), bundle.getInt("error_code"), bundle.getLong("bytes_downloaded"), bundle.getLong("total_bytes_to_download"), bundle.getStringArrayList("module_names"), bundle.getStringArrayList("languages"), (PendingIntent) bundle.getParcelable("user_confirmation_intent"), bundle.getParcelableArrayList("split_file_intents"));
    }

    public abstract long a();

    public abstract int b();

    public abstract PendingIntent c();

    public abstract int d();

    public abstract int e();

    public abstract long f();

    abstract List g();

    abstract List h();

    abstract List i();
}
