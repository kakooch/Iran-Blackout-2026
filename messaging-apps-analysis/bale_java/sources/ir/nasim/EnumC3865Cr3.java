package ir.nasim;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/* renamed from: ir.nasim.Cr3, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public enum EnumC3865Cr3 {
    CLASS("class", 0 == true ? 1 : 0, 2, null),
    ANNOTATION_CLASS("annotation class", false, 2, null),
    TYPE_PARAMETER("type parameter", false),
    PROPERTY("property", false, 2, null),
    FIELD("field", false, 2, null),
    LOCAL_VARIABLE("local variable", false, 2, null),
    VALUE_PARAMETER("value parameter", false, 2, null),
    CONSTRUCTOR("constructor", false, 2, null),
    FUNCTION("function", false, 2, null),
    PROPERTY_GETTER("getter", false, 2, null),
    PROPERTY_SETTER("setter", false, 2, null),
    TYPE("type usage", false),
    EXPRESSION("expression", false),
    FILE("file", false),
    TYPEALIAS("typealias", false),
    TYPE_PROJECTION("type projection", false),
    STAR_PROJECTION("star projection", false),
    PROPERTY_PARAMETER("property constructor parameter", false),
    CLASS_ONLY("class", false),
    OBJECT("object", false),
    COMPANION_OBJECT("companion object", false),
    INTERFACE("interface", false),
    ENUM_CLASS("enum class", false),
    ENUM_ENTRY("enum entry", false),
    LOCAL_CLASS("local class", false),
    LOCAL_FUNCTION("local function", false),
    MEMBER_FUNCTION("member function", false),
    TOP_LEVEL_FUNCTION("top level function", false),
    MEMBER_PROPERTY("member property", false),
    MEMBER_PROPERTY_WITH_BACKING_FIELD("member property with backing field", false),
    MEMBER_PROPERTY_WITH_DELEGATE("member property with delegate", false),
    MEMBER_PROPERTY_WITHOUT_FIELD_OR_DELEGATE("member property without backing field or delegate", false),
    TOP_LEVEL_PROPERTY("top level property", false),
    TOP_LEVEL_PROPERTY_WITH_BACKING_FIELD("top level property with backing field", false),
    TOP_LEVEL_PROPERTY_WITH_DELEGATE("top level property with delegate", false),
    TOP_LEVEL_PROPERTY_WITHOUT_FIELD_OR_DELEGATE("top level property without backing field or delegate", false),
    INITIALIZER("initializer", false),
    DESTRUCTURING_DECLARATION("destructuring declaration", false),
    LAMBDA_EXPRESSION("lambda expression", false),
    ANONYMOUS_FUNCTION("anonymous function", false),
    OBJECT_LITERAL("object literal", false);

    public static final a c = new a(null);
    private static final HashMap d = new HashMap();
    private static final Set e;
    private static final Set f;
    private static final Map g;
    private final String a;
    private final boolean b;

    /* renamed from: ir.nasim.Cr3$a */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    static {
        EnumC3865Cr3[] enumC3865Cr3ArrValuesCustom = valuesCustom();
        int length = enumC3865Cr3ArrValuesCustom.length;
        int i = 0;
        while (i < length) {
            EnumC3865Cr3 enumC3865Cr3 = enumC3865Cr3ArrValuesCustom[i];
            i++;
            d.put(enumC3865Cr3.name(), enumC3865Cr3);
        }
        EnumC3865Cr3[] enumC3865Cr3ArrValuesCustom2 = valuesCustom();
        ArrayList arrayList = new ArrayList();
        for (EnumC3865Cr3 enumC3865Cr32 : enumC3865Cr3ArrValuesCustom2) {
            if (enumC3865Cr32.a()) {
                arrayList.add(enumC3865Cr32);
            }
        }
        e = AbstractC15401jX0.r1(arrayList);
        f = AbstractC10242bK.s1(valuesCustom());
        EnumC3654Bu enumC3654Bu = EnumC3654Bu.CONSTRUCTOR_PARAMETER;
        EnumC3865Cr3 enumC3865Cr33 = VALUE_PARAMETER;
        XV4 xv4A = AbstractC4616Fw7.a(enumC3654Bu, enumC3865Cr33);
        EnumC3654Bu enumC3654Bu2 = EnumC3654Bu.FIELD;
        EnumC3865Cr3 enumC3865Cr34 = FIELD;
        g = AbstractC20051rO3.n(xv4A, AbstractC4616Fw7.a(enumC3654Bu2, enumC3865Cr34), AbstractC4616Fw7.a(EnumC3654Bu.PROPERTY, PROPERTY), AbstractC4616Fw7.a(EnumC3654Bu.FILE, FILE), AbstractC4616Fw7.a(EnumC3654Bu.PROPERTY_GETTER, PROPERTY_GETTER), AbstractC4616Fw7.a(EnumC3654Bu.PROPERTY_SETTER, PROPERTY_SETTER), AbstractC4616Fw7.a(EnumC3654Bu.RECEIVER, enumC3865Cr33), AbstractC4616Fw7.a(EnumC3654Bu.SETTER_PARAMETER, enumC3865Cr33), AbstractC4616Fw7.a(EnumC3654Bu.PROPERTY_DELEGATE_FIELD, enumC3865Cr34));
    }

    EnumC3865Cr3(String str, boolean z) {
        this.a = str;
        this.b = z;
    }

    /* renamed from: values, reason: to resolve conflict with enum method */
    public static EnumC3865Cr3[] valuesCustom() {
        EnumC3865Cr3[] enumC3865Cr3ArrValuesCustom = values();
        EnumC3865Cr3[] enumC3865Cr3Arr = new EnumC3865Cr3[enumC3865Cr3ArrValuesCustom.length];
        System.arraycopy(enumC3865Cr3ArrValuesCustom, 0, enumC3865Cr3Arr, 0, enumC3865Cr3ArrValuesCustom.length);
        return enumC3865Cr3Arr;
    }

    public final boolean a() {
        return this.b;
    }

    /* synthetic */ EnumC3865Cr3(String str, boolean z, int i, ED1 ed1) {
        this(str, (i & 2) != 0 ? true : z);
    }
}
