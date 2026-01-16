package ir.nasim;

import ir.nasim.database.dailogLists.DialogEntity;

/* renamed from: ir.nasim.vC4, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public final class C22420vC4 extends Error {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C22420vC4(String str) {
        super(str);
        AbstractC13042fc3.i(str, DialogEntity.COLUMN_MESSAGE);
    }

    public /* synthetic */ C22420vC4(String str, int i, ED1 ed1) {
        this((i & 1) != 0 ? "An operation is not implemented." : str);
    }
}
