package ir.nasim;

import ir.nasim.AbstractC19731qq6;
import ir.nasim.IZ6;
import ir.nasim.LI1;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import kotlinx.serialization.SerializationException;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.json.internal.JsonException;

/* renamed from: ir.nasim.Sk3, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public abstract class AbstractC7601Sk3 {
    private static final LI1.a a = new LI1.a();
    private static final LI1.a b = new LI1.a();

    /* renamed from: ir.nasim.Sk3$a */
    static final class a extends AbstractC8614Ws3 implements SA2 {
        final /* synthetic */ SerialDescriptor e;
        final /* synthetic */ AbstractC11279ck3 f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(SerialDescriptor serialDescriptor, AbstractC11279ck3 abstractC11279ck3) {
            super(0);
            this.e = serialDescriptor;
            this.f = abstractC11279ck3;
        }

        @Override // ir.nasim.SA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Map invoke() {
            return AbstractC7601Sk3.b(this.e, this.f);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Map b(SerialDescriptor serialDescriptor, AbstractC11279ck3 abstractC11279ck3) {
        String lowerCase;
        String[] strArrNames;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        boolean zD = d(abstractC11279ck3, serialDescriptor);
        l(serialDescriptor, abstractC11279ck3);
        int iD = serialDescriptor.d();
        for (int i = 0; i < iD; i++) {
            List listG = serialDescriptor.g(i);
            ArrayList arrayList = new ArrayList();
            for (Object obj : listG) {
                if (obj instanceof InterfaceC7367Rk3) {
                    arrayList.add(obj);
                }
            }
            InterfaceC7367Rk3 interfaceC7367Rk3 = (InterfaceC7367Rk3) AbstractC15401jX0.X0(arrayList);
            if (interfaceC7367Rk3 != null && (strArrNames = interfaceC7367Rk3.names()) != null) {
                for (String lowerCase2 : strArrNames) {
                    if (zD) {
                        lowerCase2 = lowerCase2.toLowerCase(Locale.ROOT);
                        AbstractC13042fc3.h(lowerCase2, "toLowerCase(...)");
                    }
                    c(linkedHashMap, serialDescriptor, lowerCase2, i);
                }
            }
            if (zD) {
                lowerCase = serialDescriptor.e(i).toLowerCase(Locale.ROOT);
                AbstractC13042fc3.h(lowerCase, "toLowerCase(...)");
            } else {
                lowerCase = null;
            }
            if (lowerCase != null) {
                c(linkedHashMap, serialDescriptor, lowerCase, i);
            }
        }
        return linkedHashMap.isEmpty() ? AbstractC20051rO3.k() : linkedHashMap;
    }

    private static final void c(Map map, SerialDescriptor serialDescriptor, String str, int i) {
        String str2 = AbstractC13042fc3.d(serialDescriptor.f(), AbstractC19731qq6.b.a) ? "enum value" : "property";
        if (!map.containsKey(str)) {
            map.put(str, Integer.valueOf(i));
            return;
        }
        throw new JsonException("The suggested name '" + str + "' for " + str2 + ' ' + serialDescriptor.e(i) + " is already one of the names for " + str2 + ' ' + serialDescriptor.e(((Number) AbstractC20051rO3.l(map, str)).intValue()) + " in " + serialDescriptor);
    }

    private static final boolean d(AbstractC11279ck3 abstractC11279ck3, SerialDescriptor serialDescriptor) {
        return abstractC11279ck3.d().g() && AbstractC13042fc3.d(serialDescriptor.f(), AbstractC19731qq6.b.a);
    }

    public static final Map e(AbstractC11279ck3 abstractC11279ck3, SerialDescriptor serialDescriptor) {
        AbstractC13042fc3.i(abstractC11279ck3, "<this>");
        AbstractC13042fc3.i(serialDescriptor, "descriptor");
        return (Map) AbstractC13750gl3.a(abstractC11279ck3).b(serialDescriptor, a, new a(serialDescriptor, abstractC11279ck3));
    }

    public static final LI1.a f() {
        return a;
    }

    public static final String g(SerialDescriptor serialDescriptor, AbstractC11279ck3 abstractC11279ck3, int i) {
        AbstractC13042fc3.i(serialDescriptor, "<this>");
        AbstractC13042fc3.i(abstractC11279ck3, "json");
        l(serialDescriptor, abstractC11279ck3);
        return serialDescriptor.e(i);
    }

    public static final int h(SerialDescriptor serialDescriptor, AbstractC11279ck3 abstractC11279ck3, String str) {
        AbstractC13042fc3.i(serialDescriptor, "<this>");
        AbstractC13042fc3.i(abstractC11279ck3, "json");
        AbstractC13042fc3.i(str, "name");
        if (d(abstractC11279ck3, serialDescriptor)) {
            String lowerCase = str.toLowerCase(Locale.ROOT);
            AbstractC13042fc3.h(lowerCase, "toLowerCase(...)");
            return k(serialDescriptor, abstractC11279ck3, lowerCase);
        }
        l(serialDescriptor, abstractC11279ck3);
        int iC = serialDescriptor.c(str);
        return (iC == -3 && abstractC11279ck3.d().n()) ? k(serialDescriptor, abstractC11279ck3, str) : iC;
    }

    public static final int i(SerialDescriptor serialDescriptor, AbstractC11279ck3 abstractC11279ck3, String str, String str2) {
        AbstractC13042fc3.i(serialDescriptor, "<this>");
        AbstractC13042fc3.i(abstractC11279ck3, "json");
        AbstractC13042fc3.i(str, "name");
        AbstractC13042fc3.i(str2, "suffix");
        int iH = h(serialDescriptor, abstractC11279ck3, str);
        if (iH != -3) {
            return iH;
        }
        throw new SerializationException(serialDescriptor.i() + " does not contain element with name '" + str + '\'' + str2);
    }

    public static /* synthetic */ int j(SerialDescriptor serialDescriptor, AbstractC11279ck3 abstractC11279ck3, String str, String str2, int i, Object obj) {
        if ((i & 4) != 0) {
            str2 = "";
        }
        return i(serialDescriptor, abstractC11279ck3, str, str2);
    }

    private static final int k(SerialDescriptor serialDescriptor, AbstractC11279ck3 abstractC11279ck3, String str) {
        Integer num = (Integer) e(abstractC11279ck3, serialDescriptor).get(str);
        if (num != null) {
            return num.intValue();
        }
        return -3;
    }

    public static final InterfaceC7840Tk3 l(SerialDescriptor serialDescriptor, AbstractC11279ck3 abstractC11279ck3) {
        AbstractC13042fc3.i(serialDescriptor, "<this>");
        AbstractC13042fc3.i(abstractC11279ck3, "json");
        if (!AbstractC13042fc3.d(serialDescriptor.f(), IZ6.a.a)) {
            return null;
        }
        abstractC11279ck3.d().k();
        return null;
    }
}
