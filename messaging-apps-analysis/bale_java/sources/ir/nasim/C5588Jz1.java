package ir.nasim;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import ir.nasim.AbstractC13215fr;
import ir.nasim.database.ApplicationDatabase;
import ir.nasim.database.dailogLists.DialogDatabase;
import java.io.File;
import java.util.List;

/* renamed from: ir.nasim.Jz1, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C5588Jz1 {
    private final List a;
    private final List b;

    /* renamed from: ir.nasim.Jz1$a */
    static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ Context d;

        /* renamed from: ir.nasim.Jz1$a$a, reason: collision with other inner class name */
        static final class C0454a extends AbstractC19859r37 implements InterfaceC14603iB2 {
            int b;
            final /* synthetic */ C5588Jz1 c;
            final /* synthetic */ Context d;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C0454a(C5588Jz1 c5588Jz1, Context context, InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
                this.c = c5588Jz1;
                this.d = context;
            }

            @Override // ir.nasim.E90
            public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                return new C0454a(this.c, this.d, interfaceC20295rm1);
            }

            @Override // ir.nasim.E90
            public final Object invokeSuspend(Object obj) {
                AbstractC14862ic3.e();
                if (this.b != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
                for (D26 d26 : this.c.a) {
                    this.c.g(this.d, d26.o().getDatabaseName(), d26);
                }
                for (SQLiteDatabase sQLiteDatabase : this.c.b) {
                    this.c.h(this.d, sQLiteDatabase.getPath(), sQLiteDatabase);
                }
                return C19938rB7.a;
            }

            @Override // ir.nasim.InterfaceC14603iB2
            /* renamed from: n, reason: merged with bridge method [inline-methods] */
            public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
                return ((C0454a) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(Context context, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = context;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C5588Jz1.this.new a(this.d, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                AbstractC13778go1 abstractC13778go1A = C12366eV1.a();
                C0454a c0454a = new C0454a(C5588Jz1.this, this.d, null);
                this.b = 1;
                if (AbstractC9323Zl0.g(abstractC13778go1A, c0454a, this) == objE) {
                    return objE;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
            }
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((a) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    public C5588Jz1(DialogDatabase dialogDatabase, ApplicationDatabase applicationDatabase) {
        AbstractC13042fc3.i(dialogDatabase, "dialogDatabase");
        AbstractC13042fc3.i(applicationDatabase, "applicationDatabase");
        this.a = AbstractC10360bX0.p(applicationDatabase, dialogDatabase);
        AbstractC13215fr.a aVar = AbstractC13215fr.b;
        this.b = AbstractC10360bX0.p(aVar.c(), aVar.b());
    }

    private final boolean e(Context context, String str) {
        File databasePath = context.getDatabasePath(str);
        if (databasePath.exists()) {
            return databasePath.delete();
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void g(Context context, String str, D26 d26) {
        if (!d26.B()) {
            d26 = null;
        }
        if (d26 != null) {
            d26.f();
        }
        if (context.deleteDatabase(str)) {
            return;
        }
        e(context, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void h(Context context, String str, SQLiteDatabase sQLiteDatabase) {
        if (!sQLiteDatabase.isOpen()) {
            sQLiteDatabase = null;
        }
        if (sQLiteDatabase != null) {
            sQLiteDatabase.close();
        }
        if (context.deleteDatabase(str)) {
            return;
        }
        e(context, str);
    }

    public final void f(Context context) {
        AbstractC13042fc3.i(context, "context");
        AbstractC9913am0.b(null, new a(context, null), 1, null);
    }
}
