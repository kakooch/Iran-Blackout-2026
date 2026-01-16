package ir.nasim;

import android.gov.nist.javax.sip.header.ParameterNames;
import androidx.window.core.WindowStrictModeException;
import ir.nasim.AbstractC24846zI6;
import ir.nasim.database.dailogLists.DialogEntity;
import kotlin.NoWhenBranchMatchedException;

/* renamed from: ir.nasim.Af2, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
final class C3283Af2 extends AbstractC24846zI6 {
    private final Object b;
    private final String c;
    private final String d;
    private final GI3 e;
    private final AbstractC24846zI6.b f;
    private final WindowStrictModeException g;

    /* renamed from: ir.nasim.Af2$a */
    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[AbstractC24846zI6.b.values().length];
            iArr[AbstractC24846zI6.b.STRICT.ordinal()] = 1;
            iArr[AbstractC24846zI6.b.LOG.ordinal()] = 2;
            iArr[AbstractC24846zI6.b.QUIET.ordinal()] = 3;
            a = iArr;
        }
    }

    public C3283Af2(Object obj, String str, String str2, GI3 gi3, AbstractC24846zI6.b bVar) {
        AbstractC13042fc3.i(obj, "value");
        AbstractC13042fc3.i(str, ParameterNames.TAG);
        AbstractC13042fc3.i(str2, DialogEntity.COLUMN_MESSAGE);
        AbstractC13042fc3.i(gi3, "logger");
        AbstractC13042fc3.i(bVar, "verificationMode");
        this.b = obj;
        this.c = str;
        this.d = str2;
        this.e = gi3;
        this.f = bVar;
        WindowStrictModeException windowStrictModeException = new WindowStrictModeException(b(obj, str2));
        StackTraceElement[] stackTrace = windowStrictModeException.getStackTrace();
        AbstractC13042fc3.h(stackTrace, "stackTrace");
        Object[] array = AbstractC10242bK.X(stackTrace, 2).toArray(new StackTraceElement[0]);
        if (array == null) {
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        }
        windowStrictModeException.setStackTrace((StackTraceElement[]) array);
        this.g = windowStrictModeException;
    }

    @Override // ir.nasim.AbstractC24846zI6
    public Object a() throws WindowStrictModeException {
        int i = a.a[this.f.ordinal()];
        if (i == 1) {
            throw this.g;
        }
        if (i == 2) {
            this.e.a(this.c, b(this.b, this.d));
            return null;
        }
        if (i == 3) {
            return null;
        }
        throw new NoWhenBranchMatchedException();
    }

    @Override // ir.nasim.AbstractC24846zI6
    public AbstractC24846zI6 c(String str, UA2 ua2) {
        AbstractC13042fc3.i(str, DialogEntity.COLUMN_MESSAGE);
        AbstractC13042fc3.i(ua2, "condition");
        return this;
    }
}
