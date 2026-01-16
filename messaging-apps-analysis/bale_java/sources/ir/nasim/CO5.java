package ir.nasim;

import android.gov.nist.core.Separators;

/* loaded from: classes8.dex */
public enum CO5 {
    PLAIN { // from class: ir.nasim.CO5.b
        @Override // ir.nasim.CO5
        public String a(String str) {
            AbstractC13042fc3.i(str, "string");
            return str;
        }
    },
    HTML { // from class: ir.nasim.CO5.a
        @Override // ir.nasim.CO5
        public String a(String str) {
            AbstractC13042fc3.i(str, "string");
            return AbstractC20153rZ6.M(AbstractC20153rZ6.M(str, Separators.LESS_THAN, "&lt;", false, 4, null), Separators.GREATER_THAN, "&gt;", false, 4, null);
        }
    };

    /* synthetic */ CO5(ED1 ed1) {
        this();
    }

    /* renamed from: values, reason: to resolve conflict with enum method */
    public static CO5[] valuesCustom() {
        CO5[] co5ArrValuesCustom = values();
        CO5[] co5Arr = new CO5[co5ArrValuesCustom.length];
        System.arraycopy(co5ArrValuesCustom, 0, co5Arr, 0, co5ArrValuesCustom.length);
        return co5Arr;
    }

    public abstract String a(String str);
}
