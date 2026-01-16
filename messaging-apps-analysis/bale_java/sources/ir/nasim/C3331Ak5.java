package ir.nasim;

import androidx.datastore.core.CorruptionException;
import androidx.datastore.preferences.protobuf.AbstractC1950t;
import ir.nasim.AbstractC19670qk5;
import ir.nasim.C23923xk5;
import ir.nasim.C25107zk5;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.NoWhenBranchMatchedException;

/* renamed from: ir.nasim.Ak5, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C3331Ak5 implements InterfaceC25168zq6 {
    public static final C3331Ak5 a = new C3331Ak5();
    private static final String b = "preferences_pb";

    /* renamed from: ir.nasim.Ak5$a */
    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[C25107zk5.b.values().length];
            iArr[C25107zk5.b.BOOLEAN.ordinal()] = 1;
            iArr[C25107zk5.b.FLOAT.ordinal()] = 2;
            iArr[C25107zk5.b.DOUBLE.ordinal()] = 3;
            iArr[C25107zk5.b.INTEGER.ordinal()] = 4;
            iArr[C25107zk5.b.LONG.ordinal()] = 5;
            iArr[C25107zk5.b.STRING.ordinal()] = 6;
            iArr[C25107zk5.b.STRING_SET.ordinal()] = 7;
            iArr[C25107zk5.b.VALUE_NOT_SET.ordinal()] = 8;
            a = iArr;
        }
    }

    private C3331Ak5() {
    }

    private final void d(String str, C25107zk5 c25107zk5, C4772Gm4 c4772Gm4) throws CorruptionException {
        C25107zk5.b bVarT = c25107zk5.T();
        switch (bVarT == null ? -1 : a.a[bVarT.ordinal()]) {
            case -1:
                throw new CorruptionException("Value case is null.", null, 2, null);
            case 0:
            default:
                throw new NoWhenBranchMatchedException();
            case 1:
                c4772Gm4.j(AbstractC21557tk5.a(str), Boolean.valueOf(c25107zk5.K()));
                return;
            case 2:
                c4772Gm4.j(AbstractC21557tk5.c(str), Float.valueOf(c25107zk5.N()));
                return;
            case 3:
                c4772Gm4.j(AbstractC21557tk5.b(str), Double.valueOf(c25107zk5.M()));
                return;
            case 4:
                c4772Gm4.j(AbstractC21557tk5.d(str), Integer.valueOf(c25107zk5.O()));
                return;
            case 5:
                c4772Gm4.j(AbstractC21557tk5.e(str), Long.valueOf(c25107zk5.Q()));
                return;
            case 6:
                AbstractC19670qk5.a aVarF = AbstractC21557tk5.f(str);
                String strR = c25107zk5.R();
                AbstractC13042fc3.h(strR, "value.string");
                c4772Gm4.j(aVarF, strR);
                return;
            case 7:
                AbstractC19670qk5.a aVarG = AbstractC21557tk5.g(str);
                List listH = c25107zk5.S().H();
                AbstractC13042fc3.h(listH, "value.stringSet.stringsList");
                c4772Gm4.j(aVarG, AbstractC15401jX0.r1(listH));
                return;
            case 8:
                throw new CorruptionException("Value not set.", null, 2, null);
        }
    }

    private final C25107zk5 g(Object obj) {
        if (obj instanceof Boolean) {
            AbstractC1950t abstractC1950tI = C25107zk5.U().r(((Boolean) obj).booleanValue()).i();
            AbstractC13042fc3.h(abstractC1950tI, "newBuilder().setBoolean(value).build()");
            return (C25107zk5) abstractC1950tI;
        }
        if (obj instanceof Float) {
            AbstractC1950t abstractC1950tI2 = C25107zk5.U().t(((Number) obj).floatValue()).i();
            AbstractC13042fc3.h(abstractC1950tI2, "newBuilder().setFloat(value).build()");
            return (C25107zk5) abstractC1950tI2;
        }
        if (obj instanceof Double) {
            AbstractC1950t abstractC1950tI3 = C25107zk5.U().s(((Number) obj).doubleValue()).i();
            AbstractC13042fc3.h(abstractC1950tI3, "newBuilder().setDouble(value).build()");
            return (C25107zk5) abstractC1950tI3;
        }
        if (obj instanceof Integer) {
            AbstractC1950t abstractC1950tI4 = C25107zk5.U().u(((Number) obj).intValue()).i();
            AbstractC13042fc3.h(abstractC1950tI4, "newBuilder().setInteger(value).build()");
            return (C25107zk5) abstractC1950tI4;
        }
        if (obj instanceof Long) {
            AbstractC1950t abstractC1950tI5 = C25107zk5.U().v(((Number) obj).longValue()).i();
            AbstractC13042fc3.h(abstractC1950tI5, "newBuilder().setLong(value).build()");
            return (C25107zk5) abstractC1950tI5;
        }
        if (obj instanceof String) {
            AbstractC1950t abstractC1950tI6 = C25107zk5.U().w((String) obj).i();
            AbstractC13042fc3.h(abstractC1950tI6, "newBuilder().setString(value).build()");
            return (C25107zk5) abstractC1950tI6;
        }
        if (!(obj instanceof Set)) {
            throw new IllegalStateException(AbstractC13042fc3.q("PreferencesSerializer does not support type: ", obj.getClass().getName()));
        }
        AbstractC1950t abstractC1950tI7 = C25107zk5.U().x(C24513yk5.I().r((Set) obj)).i();
        AbstractC13042fc3.h(abstractC1950tI7, "newBuilder().setStringSet(\n                    StringSet.newBuilder().addAllStrings(value as Set<String>)\n                ).build()");
        return (C25107zk5) abstractC1950tI7;
    }

    @Override // ir.nasim.InterfaceC25168zq6
    public Object a(InputStream inputStream, InterfaceC20295rm1 interfaceC20295rm1) throws CorruptionException {
        C23923xk5 c23923xk5A = AbstractC22737vk5.a.a(inputStream);
        C4772Gm4 c4772Gm4B = AbstractC20870sk5.b(new AbstractC19670qk5.b[0]);
        Map mapF = c23923xk5A.F();
        AbstractC13042fc3.h(mapF, "preferencesProto.preferencesMap");
        for (Map.Entry entry : mapF.entrySet()) {
            String str = (String) entry.getKey();
            C25107zk5 c25107zk5 = (C25107zk5) entry.getValue();
            C3331Ak5 c3331Ak5 = a;
            AbstractC13042fc3.h(str, "name");
            AbstractC13042fc3.h(c25107zk5, "value");
            c3331Ak5.d(str, c25107zk5, c4772Gm4B);
        }
        return c4772Gm4B.d();
    }

    @Override // ir.nasim.InterfaceC25168zq6
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public AbstractC19670qk5 b() {
        return AbstractC20870sk5.a();
    }

    public final String f() {
        return b;
    }

    @Override // ir.nasim.InterfaceC25168zq6
    /* renamed from: h, reason: merged with bridge method [inline-methods] */
    public Object c(AbstractC19670qk5 abstractC19670qk5, OutputStream outputStream, InterfaceC20295rm1 interfaceC20295rm1) {
        Map mapA = abstractC19670qk5.a();
        C23923xk5.a aVarI = C23923xk5.I();
        for (Map.Entry entry : mapA.entrySet()) {
            aVarI.r(((AbstractC19670qk5.a) entry.getKey()).a(), g(entry.getValue()));
        }
        ((C23923xk5) aVarI.i()).g(outputStream);
        return C19938rB7.a;
    }
}
