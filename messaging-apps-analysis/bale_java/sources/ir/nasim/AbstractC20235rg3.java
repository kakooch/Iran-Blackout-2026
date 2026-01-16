package ir.nasim;

import android.gov.nist.javax.sdp.fields.AttributeField;
import ir.nasim.AbstractC6718Or3;
import ir.nasim.OU3;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

/* renamed from: ir.nasim.rg3, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public abstract class AbstractC20235rg3 {
    private static final C20644sM5 a = new C20644sM5("(\\d*) ([\\w\\-.]*)(?:\\s*/(\\d*)(?:\\s*/(\\S*))?)?");
    private static final C20644sM5 b = new C20644sM5("(\\d*) ([\\S| ]*)");
    private static final C20644sM5 c = new C20644sM5("(\\d+)(?:/(\\w+))?(?: (urn:ietf:params:rtp-hdrext:encrypt))? (\\S*)(?: (\\S*))?");

    public static final List a(InterfaceC16586lX3 interfaceC16586lX3) {
        XV4 xv4A;
        AbstractC13042fc3.i(interfaceC16586lX3, "<this>");
        Vector attributes = interfaceC16586lX3.getAttributes(true);
        AbstractC13042fc3.h(attributes, "getAttributes(...)");
        ArrayList arrayList = new ArrayList();
        for (Object obj : attributes) {
            if (obj instanceof AttributeField) {
                arrayList.add(obj);
            }
        }
        ArrayList<AttributeField> arrayList2 = new ArrayList();
        for (Object obj2 : arrayList) {
            if (AbstractC13042fc3.d(((AttributeField) obj2).getAttribute().getName(), "extmap")) {
                arrayList2.add(obj2);
            }
        }
        ArrayList arrayList3 = new ArrayList();
        for (AttributeField attributeField : arrayList2) {
            String value = attributeField.getValue();
            AbstractC13042fc3.h(value, "getValue(...)");
            C24454ye6 c24454ye6G = g(value);
            if (c24454ye6G == null) {
                AbstractC6718Or3.a aVar = AbstractC6718Or3.Companion;
                xv4A = null;
                if (UI3.d.compareTo(AbstractC6718Or3.Companion.a()) >= 0 && AbstractC5270Ip7.j() > 0) {
                    AbstractC5270Ip7.l(null, "could not parse extmap: " + attributeField.encode(), new Object[0]);
                }
            } else {
                xv4A = AbstractC4616Fw7.a(attributeField, c24454ye6G);
            }
            if (xv4A != null) {
                arrayList3.add(xv4A);
            }
        }
        return arrayList3;
    }

    public static final List b(InterfaceC16586lX3 interfaceC16586lX3) {
        XV4 xv4A;
        AbstractC13042fc3.i(interfaceC16586lX3, "<this>");
        Vector attributes = interfaceC16586lX3.getAttributes(true);
        AbstractC13042fc3.h(attributes, "getAttributes(...)");
        ArrayList arrayList = new ArrayList();
        for (Object obj : attributes) {
            if (obj instanceof AttributeField) {
                arrayList.add(obj);
            }
        }
        ArrayList<AttributeField> arrayList2 = new ArrayList();
        for (Object obj2 : arrayList) {
            if (AbstractC13042fc3.d(((AttributeField) obj2).getAttribute().getName(), "fmtp")) {
                arrayList2.add(obj2);
            }
        }
        ArrayList arrayList3 = new ArrayList();
        for (AttributeField attributeField : arrayList2) {
            String value = attributeField.getValue();
            AbstractC13042fc3.h(value, "getValue(...)");
            C3278Ae6 c3278Ae6H = h(value);
            if (c3278Ae6H == null) {
                AbstractC6718Or3.a aVar = AbstractC6718Or3.Companion;
                xv4A = null;
                if (UI3.d.compareTo(AbstractC6718Or3.Companion.a()) >= 0 && AbstractC5270Ip7.j() > 0) {
                    AbstractC5270Ip7.l(null, "could not parse fmtp: " + attributeField.encode(), new Object[0]);
                }
            } else {
                xv4A = AbstractC4616Fw7.a(attributeField, c3278Ae6H);
            }
            if (xv4A != null) {
                arrayList3.add(xv4A);
            }
        }
        return arrayList3;
    }

    public static final C3517Be6 c(InterfaceC16586lX3 interfaceC16586lX3) {
        AbstractC13042fc3.i(interfaceC16586lX3, "<this>");
        String attribute = interfaceC16586lX3.getAttribute("msid");
        if (attribute == null) {
            return null;
        }
        return new C3517Be6(attribute);
    }

    public static final List d(InterfaceC16586lX3 interfaceC16586lX3) {
        XV4 xv4A;
        AbstractC13042fc3.i(interfaceC16586lX3, "<this>");
        Vector attributes = interfaceC16586lX3.getAttributes(true);
        AbstractC13042fc3.h(attributes, "getAttributes(...)");
        ArrayList arrayList = new ArrayList();
        for (Object obj : attributes) {
            if (obj instanceof AttributeField) {
                arrayList.add(obj);
            }
        }
        ArrayList<AttributeField> arrayList2 = new ArrayList();
        for (Object obj2 : arrayList) {
            if (AbstractC13042fc3.d(((AttributeField) obj2).getAttribute().getName(), "rtpmap")) {
                arrayList2.add(obj2);
            }
        }
        ArrayList arrayList3 = new ArrayList();
        for (AttributeField attributeField : arrayList2) {
            String value = attributeField.getValue();
            AbstractC13042fc3.h(value, "getValue(...)");
            C3751Ce6 c3751Ce6I = i(value);
            if (c3751Ce6I == null) {
                AbstractC6718Or3.a aVar = AbstractC6718Or3.Companion;
                xv4A = null;
                if (UI3.d.compareTo(AbstractC6718Or3.Companion.a()) >= 0 && AbstractC5270Ip7.j() > 0) {
                    AbstractC5270Ip7.l(null, "could not parse rtpmap: " + attributeField.encode(), new Object[0]);
                }
            } else {
                xv4A = AbstractC4616Fw7.a(attributeField, c3751Ce6I);
            }
            if (xv4A != null) {
                arrayList3.add(xv4A);
            }
        }
        return arrayList3;
    }

    public static final Long e(String str) {
        AbstractC13042fc3.i(str, "str");
        if (str.length() == 0) {
            return null;
        }
        return Long.valueOf(Long.parseLong(str));
    }

    public static final String f(String str) {
        AbstractC13042fc3.i(str, "str");
        if (str.length() == 0) {
            return null;
        }
        return str;
    }

    public static final C24454ye6 g(String str) {
        AbstractC13042fc3.i(str, "string");
        OU3 ou3F = c.f(str);
        if (ou3F == null) {
            return null;
        }
        OU3.b bVarA = ou3F.a();
        String str2 = (String) bVarA.a().b().get(1);
        String str3 = (String) bVarA.a().b().get(2);
        String str4 = (String) bVarA.a().b().get(3);
        return new C24454ye6(Long.parseLong(str2), f(str3), f(str4), (String) bVarA.a().b().get(4), f((String) bVarA.a().b().get(5)));
    }

    public static final C3278Ae6 h(String str) {
        AbstractC13042fc3.i(str, "string");
        OU3 ou3F = b.f(str);
        if (ou3F == null) {
            return null;
        }
        OU3.b bVarA = ou3F.a();
        String str2 = (String) bVarA.a().b().get(1);
        return new C3278Ae6(Long.parseLong(str2), (String) bVarA.a().b().get(2));
    }

    public static final C3751Ce6 i(String str) {
        AbstractC13042fc3.i(str, "string");
        OU3 ou3F = a.f(str);
        if (ou3F == null) {
            return null;
        }
        OU3.b bVarA = ou3F.a();
        String str2 = (String) bVarA.a().b().get(1);
        return new C3751Ce6(Long.parseLong(str2), (String) bVarA.a().b().get(2), e((String) bVarA.a().b().get(3)), f((String) bVarA.a().b().get(4)));
    }
}
