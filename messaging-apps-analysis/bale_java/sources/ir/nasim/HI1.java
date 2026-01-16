package ir.nasim;

import java.util.ArrayList;
import java.util.Set;

/* loaded from: classes8.dex */
public enum HI1 {
    VISIBILITY(true),
    MODALITY(true),
    OVERRIDE(true),
    ANNOTATIONS(false),
    INNER(true),
    MEMBER_KIND(true),
    DATA(true),
    INLINE(true),
    EXPECT(true),
    ACTUAL(true),
    CONST(true),
    LATEINIT(true),
    FUN(true),
    VALUE(true);

    public static final a b = new a(null);
    public static final Set c;
    public static final Set d;
    private final boolean a;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    static {
        HI1[] hi1ArrValuesCustom = valuesCustom();
        ArrayList arrayList = new ArrayList();
        for (HI1 hi1 : hi1ArrValuesCustom) {
            if (hi1.a()) {
                arrayList.add(hi1);
            }
        }
        c = AbstractC15401jX0.r1(arrayList);
        d = AbstractC10242bK.s1(valuesCustom());
    }

    HI1(boolean z) {
        this.a = z;
    }

    /* renamed from: values, reason: to resolve conflict with enum method */
    public static HI1[] valuesCustom() {
        HI1[] hi1ArrValuesCustom = values();
        HI1[] hi1Arr = new HI1[hi1ArrValuesCustom.length];
        System.arraycopy(hi1ArrValuesCustom, 0, hi1Arr, 0, hi1ArrValuesCustom.length);
        return hi1Arr;
    }

    public final boolean a() {
        return this.a;
    }
}
