package com.jakewharton.rxbinding2.widget;

import android.widget.TextView;
import com.jakewharton.rxbinding2.InitialValueObservable;
import com.jakewharton.rxbinding2.internal.Preconditions;

/* loaded from: classes3.dex */
public final class RxTextView {
    public static InitialValueObservable<CharSequence> textChanges(TextView textView) {
        Preconditions.checkNotNull(textView, "view == null");
        return new TextViewTextObservable(textView);
    }
}
