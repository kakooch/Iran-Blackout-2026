package ir.nasim;

import java.lang.annotation.Annotation;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;

/* loaded from: classes8.dex */
public abstract class Q92 {
    public static final KSerializer a(String str, Enum[] enumArr, String[] strArr, Annotation[][] annotationArr, Annotation[] annotationArr2) {
        AbstractC13042fc3.i(str, "serialName");
        AbstractC13042fc3.i(enumArr, "values");
        AbstractC13042fc3.i(strArr, "names");
        AbstractC13042fc3.i(annotationArr, "entryAnnotations");
        E92 e92 = new E92(str, enumArr.length);
        if (annotationArr2 != null) {
            for (Annotation annotation : annotationArr2) {
                e92.s(annotation);
            }
        }
        int length = enumArr.length;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            Enum r4 = enumArr[i];
            int i3 = i2 + 1;
            String strName = (String) AbstractC10242bK.n0(strArr, i2);
            if (strName == null) {
                strName = r4.name();
            }
            PluginGeneratedSerialDescriptor.m(e92, strName, false, 2, null);
            Annotation[] annotationArr3 = (Annotation[]) AbstractC10242bK.n0(annotationArr, i2);
            if (annotationArr3 != null) {
                for (Annotation annotation2 : annotationArr3) {
                    e92.r(annotation2);
                }
            }
            i++;
            i2 = i3;
        }
        return new L92(str, enumArr, e92);
    }

    public static final KSerializer b(String str, Enum[] enumArr) {
        AbstractC13042fc3.i(str, "serialName");
        AbstractC13042fc3.i(enumArr, "values");
        return new L92(str, enumArr);
    }
}
