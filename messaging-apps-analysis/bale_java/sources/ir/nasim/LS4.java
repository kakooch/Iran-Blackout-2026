package ir.nasim;

import ir.nasim.C21625tr3;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes8.dex */
public final class LS4 {
    private final C12867fJ1 a;
    private final XL5 b;
    private final ConcurrentHashMap c;

    public LS4(C12867fJ1 c12867fJ1, XL5 xl5) {
        AbstractC13042fc3.i(c12867fJ1, "resolver");
        AbstractC13042fc3.i(xl5, "kotlinClassFinder");
        this.a = c12867fJ1;
        this.b = xl5;
        this.c = new ConcurrentHashMap();
    }

    public final W24 a(WL5 wl5) {
        Collection collectionE;
        AbstractC13042fc3.i(wl5, "fileClass");
        ConcurrentHashMap concurrentHashMap = this.c;
        C24948zU0 c24948zU0F = wl5.f();
        Object obj = concurrentHashMap.get(c24948zU0F);
        if (obj == null) {
            C9424Zw2 c9424Zw2H = wl5.f().h();
            AbstractC13042fc3.h(c9424Zw2H, "fileClass.classId.packageFqName");
            if (wl5.c().c() == C21625tr3.a.MULTIFILE_CLASS) {
                List listF = wl5.c().f();
                collectionE = new ArrayList();
                Iterator it = listF.iterator();
                while (it.hasNext()) {
                    C24948zU0 c24948zU0M = C24948zU0.m(C4996Hl3.d((String) it.next()).e());
                    AbstractC13042fc3.h(c24948zU0M, "topLevel(JvmClassName.byInternalName(partName).fqNameForTopLevelClassMaybeWithDollars)");
                    InterfaceC22805vr3 interfaceC22805vr3A = AbstractC20938sr3.a(this.b, c24948zU0M);
                    if (interfaceC22805vr3A != null) {
                        collectionE.add(interfaceC22805vr3A);
                    }
                }
            } else {
                collectionE = AbstractC9766aX0.e(wl5);
            }
            A72 a72 = new A72(this.a.f().p(), c9424Zw2H);
            ArrayList arrayList = new ArrayList();
            Iterator it2 = collectionE.iterator();
            while (it2.hasNext()) {
                W24 w24D = this.a.d(a72, (InterfaceC22805vr3) it2.next());
                if (w24D != null) {
                    arrayList.add(w24D);
                }
            }
            List listM1 = AbstractC15401jX0.m1(arrayList);
            W24 w24A = C15266jI0.d.a("package " + c9424Zw2H + " (" + wl5 + ')', listM1);
            Object objPutIfAbsent = concurrentHashMap.putIfAbsent(c24948zU0F, w24A);
            obj = objPutIfAbsent != null ? objPutIfAbsent : w24A;
        }
        AbstractC13042fc3.h(obj, "cache.getOrPut(fileClass.classId) {\n        val fqName = fileClass.classId.packageFqName\n\n        val parts =\n            if (fileClass.classHeader.kind == KotlinClassHeader.Kind.MULTIFILE_CLASS)\n                fileClass.classHeader.multifilePartNames.mapNotNull { partName ->\n                    val classId = ClassId.topLevel(JvmClassName.byInternalName(partName).fqNameForTopLevelClassMaybeWithDollars)\n                    kotlinClassFinder.findKotlinClass(classId)\n                }\n            else listOf(fileClass)\n\n        val packageFragment = EmptyPackageFragmentDescriptor(resolver.components.moduleDescriptor, fqName)\n\n        val scopes = parts.mapNotNull { part ->\n            resolver.createKotlinPackagePartScope(packageFragment, part)\n        }.toList()\n\n        ChainedMemberScope.create(\"package $fqName ($fileClass)\", scopes)\n    }");
        return (W24) obj;
    }
}
