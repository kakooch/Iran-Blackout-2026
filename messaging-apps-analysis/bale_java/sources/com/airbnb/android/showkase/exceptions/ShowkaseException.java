package com.airbnb.android.showkase.exceptions;

import ir.nasim.AbstractC13042fc3;
import ir.nasim.database.dailogLists.DialogEntity;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/airbnb/android/showkase/exceptions/ShowkaseException;", "Ljava/lang/Exception;", DialogEntity.COLUMN_MESSAGE, "", "(Ljava/lang/String;)V", "showkase_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class ShowkaseException extends Exception {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ShowkaseException(String str) {
        super(str);
        AbstractC13042fc3.i(str, DialogEntity.COLUMN_MESSAGE);
    }
}
