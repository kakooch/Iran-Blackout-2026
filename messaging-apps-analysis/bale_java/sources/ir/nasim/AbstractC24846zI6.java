package ir.nasim;

import android.gov.nist.javax.sip.header.ParameterNames;
import ir.nasim.database.dailogLists.DialogEntity;

/* renamed from: ir.nasim.zI6, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public abstract class AbstractC24846zI6 {
    public static final a a = new a(null);

    /* renamed from: ir.nasim.zI6$a */
    public static final class a {
        private a() {
        }

        public static /* synthetic */ AbstractC24846zI6 b(a aVar, Object obj, String str, b bVar, GI3 gi3, int i, Object obj2) {
            if ((i & 2) != 0) {
                bVar = C8080Ul0.a.a();
            }
            if ((i & 4) != 0) {
                gi3 = C5262Ip.a;
            }
            return aVar.a(obj, str, bVar, gi3);
        }

        public final AbstractC24846zI6 a(Object obj, String str, b bVar, GI3 gi3) {
            AbstractC13042fc3.i(obj, "<this>");
            AbstractC13042fc3.i(str, ParameterNames.TAG);
            AbstractC13042fc3.i(bVar, "verificationMode");
            AbstractC13042fc3.i(gi3, "logger");
            return new DN7(obj, str, bVar, gi3);
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    /* renamed from: ir.nasim.zI6$b */
    public enum b {
        STRICT,
        LOG,
        QUIET
    }

    public abstract Object a();

    protected final String b(Object obj, String str) {
        AbstractC13042fc3.i(obj, "value");
        AbstractC13042fc3.i(str, DialogEntity.COLUMN_MESSAGE);
        return str + " value: " + obj;
    }

    public abstract AbstractC24846zI6 c(String str, UA2 ua2);
}
