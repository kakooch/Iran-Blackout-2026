package ir.nasim;

import android.os.Bundle;
import android.util.SparseArray;
import com.google.android.exoplayer2.InterfaceC2029g;
import ir.nasim.AbstractC12710f43;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/* renamed from: ir.nasim.Am0, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public abstract class AbstractC3344Am0 {
    public static void a(Bundle bundle) {
        if (bundle != null) {
            bundle.setClassLoader((ClassLoader) AbstractC9683aN7.j(AbstractC3344Am0.class.getClassLoader()));
        }
    }

    public static AbstractC12710f43 b(InterfaceC2029g.a aVar, List list) {
        AbstractC12710f43.a aVarL = AbstractC12710f43.L();
        for (int i = 0; i < list.size(); i++) {
            aVarL.a(aVar.a((Bundle) AbstractC20011rK.e((Bundle) list.get(i))));
        }
        return aVarL.h();
    }

    public static SparseArray c(InterfaceC2029g.a aVar, SparseArray sparseArray) {
        SparseArray sparseArray2 = new SparseArray(sparseArray.size());
        for (int i = 0; i < sparseArray.size(); i++) {
            sparseArray2.put(sparseArray.keyAt(i), aVar.a((Bundle) sparseArray.valueAt(i)));
        }
        return sparseArray2;
    }

    public static ArrayList d(Collection collection) {
        ArrayList arrayList = new ArrayList(collection.size());
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            arrayList.add(((InterfaceC2029g) it.next()).a());
        }
        return arrayList;
    }

    public static SparseArray e(SparseArray sparseArray) {
        SparseArray sparseArray2 = new SparseArray(sparseArray.size());
        for (int i = 0; i < sparseArray.size(); i++) {
            sparseArray2.put(sparseArray.keyAt(i), ((InterfaceC2029g) sparseArray.valueAt(i)).a());
        }
        return sparseArray2;
    }
}
