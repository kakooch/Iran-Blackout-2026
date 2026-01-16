package ir.nasim;

import ir.nasim.AbstractC16812lu2;
import ir.nasim.C9475a16;
import ir.nasim.FL;
import java.util.List;

/* renamed from: ir.nasim.ku2, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public abstract class AbstractC16221ku2 {
    /* JADX INFO: Access modifiers changed from: private */
    public static final XV4 b(List list, C18046nz7 c18046nz7, FL fl, InterfaceC9848af5 interfaceC9848af5, UA2 ua2) {
        Object objInvoke;
        InterfaceC8154Ut2 interfaceC8154Ut2;
        List list2;
        List list3;
        int i;
        Object objB;
        InterfaceC8154Ut2 interfaceC8154Ut22;
        int size = list.size();
        List listS = null;
        int i2 = 0;
        while (i2 < size) {
            InterfaceC8154Ut2 interfaceC8154Ut23 = (InterfaceC8154Ut2) list.get(i2);
            int iA = interfaceC8154Ut23.a();
            AbstractC16812lu2.a aVar = AbstractC16812lu2.a;
            if (AbstractC16812lu2.e(iA, aVar.b())) {
                synchronized (fl.d) {
                    try {
                        FL.b bVar = new FL.b(interfaceC8154Ut23, interfaceC9848af5.b());
                        FL.a aVar2 = (FL.a) fl.b.d(bVar);
                        if (aVar2 == null) {
                            aVar2 = (FL.a) fl.c.e(bVar);
                        }
                        if (aVar2 != null) {
                            objInvoke = aVar2.g();
                            interfaceC8154Ut2 = interfaceC8154Ut23;
                            list2 = listS;
                        } else {
                            C19938rB7 c19938rB7 = C19938rB7.a;
                            try {
                                objInvoke = interfaceC9848af5.c(interfaceC8154Ut23);
                            } catch (Exception unused) {
                                objInvoke = ua2.invoke(c18046nz7);
                            }
                            interfaceC8154Ut2 = interfaceC8154Ut23;
                            list2 = listS;
                            FL.f(fl, interfaceC8154Ut23, interfaceC9848af5, objInvoke, false, 8, null);
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
                if (objInvoke == null) {
                    objInvoke = ua2.invoke(c18046nz7);
                }
                return AbstractC4616Fw7.a(list2, AbstractC3891Cu2.a(c18046nz7.e(), objInvoke, interfaceC8154Ut2, c18046nz7.f(), c18046nz7.d()));
            }
            if (AbstractC16812lu2.e(iA, aVar.c())) {
                synchronized (fl.d) {
                    try {
                        FL.b bVar2 = new FL.b(interfaceC8154Ut23, interfaceC9848af5.b());
                        FL.a aVar3 = (FL.a) fl.b.d(bVar2);
                        if (aVar3 == null) {
                            aVar3 = (FL.a) fl.c.e(bVar2);
                        }
                        if (aVar3 != null) {
                            objB = aVar3.g();
                            interfaceC8154Ut22 = interfaceC8154Ut23;
                            list3 = listS;
                            i = i2;
                        } else {
                            C19938rB7 c19938rB72 = C19938rB7.a;
                            try {
                                C9475a16.a aVar4 = C9475a16.b;
                                objB = C9475a16.b(interfaceC9848af5.c(interfaceC8154Ut23));
                            } catch (Throwable th2) {
                                C9475a16.a aVar5 = C9475a16.b;
                                objB = C9475a16.b(AbstractC10685c16.a(th2));
                            }
                            if (C9475a16.g(objB)) {
                                objB = null;
                            }
                            interfaceC8154Ut22 = interfaceC8154Ut23;
                            list3 = listS;
                            i = i2;
                            FL.f(fl, interfaceC8154Ut23, interfaceC9848af5, objB, false, 8, null);
                        }
                    } catch (Throwable th3) {
                        throw th3;
                    }
                }
                if (objB != null) {
                    return AbstractC4616Fw7.a(list3, AbstractC3891Cu2.a(c18046nz7.e(), objB, interfaceC8154Ut22, c18046nz7.f(), c18046nz7.d()));
                }
            } else {
                list3 = listS;
                i = i2;
                if (!AbstractC16812lu2.e(iA, aVar.a())) {
                    throw new IllegalStateException("Unknown font type " + interfaceC8154Ut23);
                }
                FL.a aVarD = fl.d(interfaceC8154Ut23, interfaceC9848af5);
                if (aVarD == null) {
                    if (list3 == null) {
                        listS = AbstractC10360bX0.s(interfaceC8154Ut23);
                        i2 = i + 1;
                    } else {
                        list3.add(interfaceC8154Ut23);
                    }
                } else if (!FL.a.e(aVarD.g()) && aVarD.g() != null) {
                    return AbstractC4616Fw7.a(list3, AbstractC3891Cu2.a(c18046nz7.e(), aVarD.g(), interfaceC8154Ut23, c18046nz7.f(), c18046nz7.d()));
                }
            }
            listS = list3;
            i2 = i + 1;
        }
        return AbstractC4616Fw7.a(listS, ua2.invoke(c18046nz7));
    }
}
