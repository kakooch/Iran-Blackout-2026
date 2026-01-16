package ir.nasim;

import android.content.Context;
import android.content.Intent;
import ir.nasim.D26;
import ir.nasim.InterfaceC13330g27;
import java.io.File;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;

/* renamed from: ir.nasim.Kz1, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public class C5822Kz1 {
    public final Context a;
    public final String b;
    public final InterfaceC13330g27.c c;
    public final D26.e d;
    public final List e;
    public final boolean f;
    public final D26.d g;
    public final Executor h;
    public final Executor i;
    public final Intent j;
    public final boolean k;
    public final boolean l;
    private final Set m;
    public final String n;
    public final File o;
    public final Callable p;
    public final List q;
    public final List r;
    public final boolean s;

    public C5822Kz1(Context context, String str, InterfaceC13330g27.c cVar, D26.e eVar, List list, boolean z, D26.d dVar, Executor executor, Executor executor2, Intent intent, boolean z2, boolean z3, Set set, String str2, File file, Callable callable, D26.f fVar, List list2, List list3) {
        AbstractC13042fc3.i(context, "context");
        AbstractC13042fc3.i(cVar, "sqliteOpenHelperFactory");
        AbstractC13042fc3.i(eVar, "migrationContainer");
        AbstractC13042fc3.i(dVar, "journalMode");
        AbstractC13042fc3.i(executor, "queryExecutor");
        AbstractC13042fc3.i(executor2, "transactionExecutor");
        AbstractC13042fc3.i(list2, "typeConverters");
        AbstractC13042fc3.i(list3, "autoMigrationSpecs");
        this.a = context;
        this.b = str;
        this.c = cVar;
        this.d = eVar;
        this.e = list;
        this.f = z;
        this.g = dVar;
        this.h = executor;
        this.i = executor2;
        this.j = intent;
        this.k = z2;
        this.l = z3;
        this.m = set;
        this.n = str2;
        this.o = file;
        this.p = callable;
        this.q = list2;
        this.r = list3;
        this.s = intent != null;
    }

    public boolean a(int i, int i2) {
        if ((i > i2 && this.l) || !this.k) {
            return false;
        }
        Set set = this.m;
        return set == null || !set.contains(Integer.valueOf(i));
    }
}
