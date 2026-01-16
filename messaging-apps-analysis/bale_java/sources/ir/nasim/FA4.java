package ir.nasim;

/* loaded from: classes8.dex */
public enum FA4 implements IJ3 {
    FROM_IDE,
    FROM_BACKEND,
    FROM_TEST,
    FROM_BUILTINS,
    WHEN_CHECK_DECLARATION_CONFLICTS,
    WHEN_CHECK_OVERRIDES,
    FOR_SCRIPT,
    FROM_REFLECTION,
    WHEN_RESOLVE_DECLARATION,
    WHEN_GET_DECLARATION_SCOPE,
    WHEN_RESOLVING_DEFAULT_TYPE_ARGUMENTS,
    FOR_ALREADY_TRACKED,
    WHEN_GET_ALL_DESCRIPTORS,
    WHEN_TYPING,
    WHEN_GET_SUPER_MEMBERS,
    FOR_NON_TRACKED_SCOPE,
    FROM_SYNTHETIC_SCOPE,
    FROM_DESERIALIZATION,
    FROM_JAVA_LOADER,
    WHEN_GET_LOCAL_VARIABLE,
    WHEN_FIND_BY_FQNAME,
    WHEN_GET_COMPANION_OBJECT,
    FOR_DEFAULT_IMPORTS;

    /* renamed from: values, reason: to resolve conflict with enum method */
    public static FA4[] valuesCustom() {
        FA4[] fa4ArrValuesCustom = values();
        FA4[] fa4Arr = new FA4[fa4ArrValuesCustom.length];
        System.arraycopy(fa4ArrValuesCustom, 0, fa4Arr, 0, fa4ArrValuesCustom.length);
        return fa4Arr;
    }

    @Override // ir.nasim.IJ3
    public InterfaceC11608dI3 getLocation() {
        return null;
    }
}
