package ir.nasim.database.dailogLists;

import android.content.Context;
import android.gov.nist.javax.sip.parser.TokenNames;
import ir.nasim.AbstractC13042fc3;
import ir.nasim.AbstractC17048mJ0;
import ir.nasim.C26;
import ir.nasim.D26;
import ir.nasim.ED1;
import ir.nasim.HM1;
import ir.nasim.InterfaceC16512lP1;
import ir.nasim.JS;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b'\u0018\u0000 \r2\u00020\u0001:\u0002\u000e\u000fB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H&¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\b\u001a\u00020\u0007H&¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH&¢\u0006\u0004\b\u000b\u0010\f¨\u0006\u0010"}, d2 = {"Lir/nasim/database/dailogLists/DialogDatabase;", "Lir/nasim/D26;", "<init>", "()V", "Lir/nasim/HM1;", "H", "()Lir/nasim/HM1;", "Lir/nasim/database/dailogLists/c;", TokenNames.I, "()Lir/nasim/database/dailogLists/c;", "Lir/nasim/lP1;", "J", "()Lir/nasim/lP1;", "p", "a", "b", "database_release"}, k = 1, mv = {2, 0, 0})
/* loaded from: classes5.dex */
public abstract class DialogDatabase extends D26 {

    /* renamed from: p, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: ir.nasim.database.dailogLists.DialogDatabase$a, reason: from kotlin metadata */
    public static final class Companion {
        private Companion() {
        }

        public final DialogDatabase a(Context context, String str) {
            AbstractC13042fc3.i(context, "context");
            AbstractC13042fc3.i(str, "databaseName");
            Context applicationContext = context.getApplicationContext();
            AbstractC13042fc3.h(applicationContext, "getApplicationContext(...)");
            return (DialogDatabase) C26.a(applicationContext, DialogDatabase.class, str).b(AbstractC17048mJ0.a(), AbstractC17048mJ0.b()).e();
        }

        public /* synthetic */ Companion(ED1 ed1) {
            this();
        }
    }

    public static final class b implements JS {
    }

    public abstract HM1 H();

    public abstract c I();

    public abstract InterfaceC16512lP1 J();
}
