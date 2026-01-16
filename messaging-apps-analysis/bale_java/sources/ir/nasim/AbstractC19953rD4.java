package ir.nasim;

import android.gov.nist.javax.sip.header.ParameterNames;
import android.os.Bundle;
import androidx.core.graphics.drawable.IconCompat;
import ir.nasim.AbstractC16407lD4;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;

/* renamed from: ir.nasim.rD4, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
abstract class AbstractC19953rD4 {
    private static final Object a = new Object();
    private static final Object b = new Object();

    static Bundle a(AbstractC16407lD4.a aVar) {
        Bundle bundle = new Bundle();
        IconCompat iconCompatD = aVar.d();
        bundle.putInt(ParameterNames.ICON, iconCompatD != null ? iconCompatD.o() : 0);
        bundle.putCharSequence("title", aVar.h());
        bundle.putParcelable("actionIntent", aVar.a());
        Bundle bundle2 = aVar.c() != null ? new Bundle(aVar.c()) : new Bundle();
        bundle2.putBoolean("android.support.allowGeneratedReplies", aVar.b());
        bundle.putBundle("extras", bundle2);
        bundle.putParcelableArray("remoteInputs", c(aVar.e()));
        bundle.putBoolean("showsUserInterface", aVar.g());
        bundle.putInt("semanticAction", aVar.f());
        return bundle;
    }

    private static Bundle b(C18862pN5 c18862pN5) {
        Bundle bundle = new Bundle();
        bundle.putString("resultKey", c18862pN5.i());
        bundle.putCharSequence("label", c18862pN5.h());
        bundle.putCharSequenceArray("choices", c18862pN5.e());
        bundle.putBoolean("allowFreeFormInput", c18862pN5.c());
        bundle.putBundle("extras", c18862pN5.g());
        Set setD = c18862pN5.d();
        if (setD != null && !setD.isEmpty()) {
            ArrayList<String> arrayList = new ArrayList<>(setD.size());
            Iterator it = setD.iterator();
            while (it.hasNext()) {
                arrayList.add((String) it.next());
            }
            bundle.putStringArrayList("allowedDataTypes", arrayList);
        }
        return bundle;
    }

    private static Bundle[] c(C18862pN5[] c18862pN5Arr) {
        if (c18862pN5Arr == null) {
            return null;
        }
        Bundle[] bundleArr = new Bundle[c18862pN5Arr.length];
        for (int i = 0; i < c18862pN5Arr.length; i++) {
            bundleArr[i] = b(c18862pN5Arr[i]);
        }
        return bundleArr;
    }
}
