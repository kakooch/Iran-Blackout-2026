package com.jakewharton.rxbinding2.view;

import android.view.View;
import com.jakewharton.rxbinding2.internal.Preconditions;
import io.reactivex.Observable;

/* loaded from: classes3.dex */
public final class RxView {
    public static Observable<Object> clicks(View view) {
        Preconditions.checkNotNull(view, "view == null");
        return new ViewClickObservable(view);
    }
}
