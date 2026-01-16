package ir.nasim;

import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.List;

/* renamed from: ir.nasim.zL5, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public abstract class AbstractC24872zL5 {
    public static final C22502vL5 a(Annotation[] annotationArr, C9424Zw2 c9424Zw2) {
        Annotation annotation;
        AbstractC13042fc3.i(annotationArr, "<this>");
        AbstractC13042fc3.i(c9424Zw2, "fqName");
        int length = annotationArr.length;
        int i = 0;
        while (true) {
            if (i >= length) {
                annotation = null;
                break;
            }
            annotation = annotationArr[i];
            if (AbstractC13042fc3.d(AbstractC21912uL5.b(AbstractC4762Gl3.b(AbstractC4762Gl3.a(annotation))).b(), c9424Zw2)) {
                break;
            }
            i++;
        }
        if (annotation == null) {
            return null;
        }
        return new C22502vL5(annotation);
    }

    public static final List b(Annotation[] annotationArr) {
        AbstractC13042fc3.i(annotationArr, "<this>");
        ArrayList arrayList = new ArrayList(annotationArr.length);
        for (Annotation annotation : annotationArr) {
            arrayList.add(new C22502vL5(annotation));
        }
        return arrayList;
    }
}
