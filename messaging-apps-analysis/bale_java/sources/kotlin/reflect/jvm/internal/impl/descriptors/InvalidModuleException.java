package kotlin.reflect.jvm.internal.impl.descriptors;

import ir.nasim.AbstractC13042fc3;
import ir.nasim.database.dailogLists.DialogEntity;

/* loaded from: classes8.dex */
public final class InvalidModuleException extends IllegalStateException {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public InvalidModuleException(String str) {
        super(str);
        AbstractC13042fc3.i(str, DialogEntity.COLUMN_MESSAGE);
    }
}
