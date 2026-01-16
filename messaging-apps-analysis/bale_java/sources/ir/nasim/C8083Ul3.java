package ir.nasim;

import android.gov.nist.core.Separators;
import ir.nasim.AbstractC5031Hp2;
import ir.nasim.AbstractC6165Ml3;
import ir.nasim.AbstractC7849Tl3;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.protobuf.h;

/* renamed from: ir.nasim.Ul3, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public final class C8083Ul3 {
    public static final C8083Ul3 a = new C8083Ul3();
    private static final kotlin.reflect.jvm.internal.impl.protobuf.f b;

    static {
        kotlin.reflect.jvm.internal.impl.protobuf.f fVarD = kotlin.reflect.jvm.internal.impl.protobuf.f.d();
        AbstractC7849Tl3.a(fVarD);
        AbstractC13042fc3.h(fVarD, "newInstance().apply(JvmProtoBuf::registerAllExtensions)");
        b = fVarD;
    }

    private C8083Ul3() {
    }

    public static /* synthetic */ AbstractC6165Ml3.a d(C8083Ul3 c8083Ul3, C9193Yw5 c9193Yw5, InterfaceC6692Oo4 interfaceC6692Oo4, C7029Py7 c7029Py7, boolean z, int i, Object obj) {
        if ((i & 8) != 0) {
            z = true;
        }
        return c8083Ul3.c(c9193Yw5, interfaceC6692Oo4, c7029Py7, z);
    }

    public static final boolean f(C9193Yw5 c9193Yw5) {
        AbstractC13042fc3.i(c9193Yw5, "proto");
        AbstractC5031Hp2.b bVarA = C5464Jl3.a.a();
        Object objS = c9193Yw5.s(AbstractC7849Tl3.e);
        AbstractC13042fc3.h(objS, "proto.getExtension(JvmProtoBuf.flags)");
        Boolean boolD = bVarA.d(((Number) objS).intValue());
        AbstractC13042fc3.h(boolD, "JvmFlags.IS_MOVED_FROM_INTERFACE_COMPANION.get(proto.getExtension(JvmProtoBuf.flags))");
        return boolD.booleanValue();
    }

    private final String g(C10647bx5 c10647bx5, InterfaceC6692Oo4 interfaceC6692Oo4) {
        if (!c10647bx5.q0()) {
            return null;
        }
        CU0 cu0 = CU0.a;
        return CU0.b(interfaceC6692Oo4.b(c10647bx5.a0()));
    }

    public static final XV4 h(byte[] bArr, String[] strArr) {
        AbstractC13042fc3.i(bArr, "bytes");
        AbstractC13042fc3.i(strArr, "strings");
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
        return new XV4(a.k(byteArrayInputStream, strArr), C6526Nw5.X0(byteArrayInputStream, b));
    }

    public static final XV4 i(String[] strArr, String[] strArr2) {
        AbstractC13042fc3.i(strArr, "data");
        AbstractC13042fc3.i(strArr2, "strings");
        byte[] bArrE = AbstractC4456Ff0.e(strArr);
        AbstractC13042fc3.h(bArrE, "decodeBytes(data)");
        return h(bArrE, strArr2);
    }

    public static final XV4 j(String[] strArr, String[] strArr2) {
        AbstractC13042fc3.i(strArr, "data");
        AbstractC13042fc3.i(strArr2, "strings");
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(AbstractC4456Ff0.e(strArr));
        return new XV4(a.k(byteArrayInputStream, strArr2), C7950Tw5.B0(byteArrayInputStream, b));
    }

    private final C6664Ol3 k(InputStream inputStream, String[] strArr) {
        AbstractC7849Tl3.e eVarG = AbstractC7849Tl3.e.G(inputStream, b);
        AbstractC13042fc3.h(eVarG, "parseDelimitedFrom(this, EXTENSION_REGISTRY)");
        return new C6664Ol3(eVarG, strArr);
    }

    public static final XV4 l(byte[] bArr, String[] strArr) {
        AbstractC13042fc3.i(bArr, "bytes");
        AbstractC13042fc3.i(strArr, "strings");
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
        return new XV4(a.k(byteArrayInputStream, strArr), C8652Ww5.i0(byteArrayInputStream, b));
    }

    public static final XV4 m(String[] strArr, String[] strArr2) {
        AbstractC13042fc3.i(strArr, "data");
        AbstractC13042fc3.i(strArr2, "strings");
        byte[] bArrE = AbstractC4456Ff0.e(strArr);
        AbstractC13042fc3.h(bArrE, "decodeBytes(data)");
        return l(bArrE, strArr2);
    }

    public final kotlin.reflect.jvm.internal.impl.protobuf.f a() {
        return b;
    }

    public final AbstractC6165Ml3.b b(C6765Ow5 c6765Ow5, InterfaceC6692Oo4 interfaceC6692Oo4, C7029Py7 c7029Py7) {
        String strA0;
        AbstractC13042fc3.i(c6765Ow5, "proto");
        AbstractC13042fc3.i(interfaceC6692Oo4, "nameResolver");
        AbstractC13042fc3.i(c7029Py7, "typeTable");
        h.f fVar = AbstractC7849Tl3.a;
        AbstractC13042fc3.h(fVar, "constructorSignature");
        AbstractC7849Tl3.c cVar = (AbstractC7849Tl3.c) AbstractC15662jx5.a(c6765Ow5, fVar);
        String string = (cVar == null || !cVar.C()) ? "<init>" : interfaceC6692Oo4.getString(cVar.y());
        if (cVar == null || !cVar.z()) {
            List listQ = c6765Ow5.Q();
            AbstractC13042fc3.h(listQ, "proto.valueParameterList");
            List<C13280fx5> list = listQ;
            ArrayList arrayList = new ArrayList(AbstractC10976cX0.x(list, 10));
            for (C13280fx5 c13280fx5 : list) {
                AbstractC13042fc3.h(c13280fx5, "it");
                String strG = g(AbstractC3921Cx5.m(c13280fx5, c7029Py7), interfaceC6692Oo4);
                if (strG == null) {
                    return null;
                }
                arrayList.add(strG);
            }
            strA0 = AbstractC15401jX0.A0(arrayList, "", Separators.LPAREN, ")V", 0, null, null, 56, null);
        } else {
            strA0 = interfaceC6692Oo4.getString(cVar.w());
        }
        return new AbstractC6165Ml3.b(string, strA0);
    }

    public final AbstractC6165Ml3.a c(C9193Yw5 c9193Yw5, InterfaceC6692Oo4 interfaceC6692Oo4, C7029Py7 c7029Py7, boolean z) {
        String strG;
        AbstractC13042fc3.i(c9193Yw5, "proto");
        AbstractC13042fc3.i(interfaceC6692Oo4, "nameResolver");
        AbstractC13042fc3.i(c7029Py7, "typeTable");
        h.f fVar = AbstractC7849Tl3.d;
        AbstractC13042fc3.h(fVar, "propertySignature");
        AbstractC7849Tl3.d dVar = (AbstractC7849Tl3.d) AbstractC15662jx5.a(c9193Yw5, fVar);
        if (dVar == null) {
            return null;
        }
        AbstractC7849Tl3.b bVarZ = dVar.F() ? dVar.z() : null;
        if (bVarZ == null && z) {
            return null;
        }
        int iY = (bVarZ == null || !bVarZ.C()) ? c9193Yw5.Y() : bVarZ.y();
        if (bVarZ == null || !bVarZ.z()) {
            strG = g(AbstractC3921Cx5.j(c9193Yw5, c7029Py7), interfaceC6692Oo4);
            if (strG == null) {
                return null;
            }
        } else {
            strG = interfaceC6692Oo4.getString(bVarZ.w());
        }
        return new AbstractC6165Ml3.a(interfaceC6692Oo4.getString(iY), strG);
    }

    public final AbstractC6165Ml3.b e(C7950Tw5 c7950Tw5, InterfaceC6692Oo4 interfaceC6692Oo4, C7029Py7 c7029Py7) {
        String strQ;
        AbstractC13042fc3.i(c7950Tw5, "proto");
        AbstractC13042fc3.i(interfaceC6692Oo4, "nameResolver");
        AbstractC13042fc3.i(c7029Py7, "typeTable");
        h.f fVar = AbstractC7849Tl3.b;
        AbstractC13042fc3.h(fVar, "methodSignature");
        AbstractC7849Tl3.c cVar = (AbstractC7849Tl3.c) AbstractC15662jx5.a(c7950Tw5, fVar);
        int iZ = (cVar == null || !cVar.C()) ? c7950Tw5.Z() : cVar.y();
        if (cVar == null || !cVar.z()) {
            List listQ = AbstractC10360bX0.q(AbstractC3921Cx5.g(c7950Tw5, c7029Py7));
            List listM0 = c7950Tw5.m0();
            AbstractC13042fc3.h(listM0, "proto.valueParameterList");
            List<C13280fx5> list = listM0;
            ArrayList arrayList = new ArrayList(AbstractC10976cX0.x(list, 10));
            for (C13280fx5 c13280fx5 : list) {
                AbstractC13042fc3.h(c13280fx5, "it");
                arrayList.add(AbstractC3921Cx5.m(c13280fx5, c7029Py7));
            }
            List listR0 = AbstractC15401jX0.R0(listQ, arrayList);
            ArrayList arrayList2 = new ArrayList(AbstractC10976cX0.x(listR0, 10));
            Iterator it = listR0.iterator();
            while (it.hasNext()) {
                String strG = g((C10647bx5) it.next(), interfaceC6692Oo4);
                if (strG == null) {
                    return null;
                }
                arrayList2.add(strG);
            }
            String strG2 = g(AbstractC3921Cx5.i(c7950Tw5, c7029Py7), interfaceC6692Oo4);
            if (strG2 == null) {
                return null;
            }
            strQ = AbstractC13042fc3.q(AbstractC15401jX0.A0(arrayList2, "", Separators.LPAREN, Separators.RPAREN, 0, null, null, 56, null), strG2);
        } else {
            strQ = interfaceC6692Oo4.getString(cVar.w());
        }
        return new AbstractC6165Ml3.b(interfaceC6692Oo4.getString(iZ), strQ);
    }
}
