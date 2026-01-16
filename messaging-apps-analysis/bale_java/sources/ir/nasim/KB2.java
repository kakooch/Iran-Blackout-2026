package ir.nasim;

import android.os.Looper;
import com.google.android.gms.location.LocationCallback;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.tasks.Task;

/* loaded from: classes3.dex */
public interface KB2 {
    Task b(LocationRequest locationRequest, LocationCallback locationCallback, Looper looper);

    Task d(LocationCallback locationCallback);

    Task g();
}
