package ir.nasim;

import ir.nasim.database.dailogLists.DialogEntity;
import java.util.List;

/* renamed from: ir.nasim.cD7, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C10803cD7 extends AbstractC20556sC7 {
    private final List a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C10803cD7(List list) {
        super(null);
        AbstractC13042fc3.i(list, DialogEntity.TABLE_NAME);
        this.a = list;
    }

    public final List a() {
        return this.a;
    }
}
