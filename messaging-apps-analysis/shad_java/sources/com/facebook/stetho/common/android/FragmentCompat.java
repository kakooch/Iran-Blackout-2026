package com.facebook.stetho.common.android;

import android.app.Activity;
import com.facebook.stetho.common.ReflectionUtil;
import java.lang.reflect.Field;
import java.util.List;

/* loaded from: classes.dex */
public abstract class FragmentCompat<FRAGMENT, DIALOG_FRAGMENT, FRAGMENT_MANAGER, FRAGMENT_ACTIVITY extends Activity> {
    private static FragmentCompat sFrameworkInstance;
    private static final boolean sHasSupportFragment;
    private static FragmentCompat sSupportInstance;

    public abstract DialogFragmentAccessor<DIALOG_FRAGMENT, FRAGMENT, FRAGMENT_MANAGER> forDialogFragment();

    public abstract FragmentAccessor<FRAGMENT, FRAGMENT_MANAGER> forFragment();

    public abstract FragmentActivityAccessor<FRAGMENT_ACTIVITY, FRAGMENT_MANAGER> forFragmentActivity();

    /* renamed from: forFragmentManager */
    public abstract FragmentManagerAccessor<FRAGMENT_MANAGER, FRAGMENT> forFragmentManager2();

    public abstract Class<DIALOG_FRAGMENT> getDialogFragmentClass();

    public abstract Class<FRAGMENT_ACTIVITY> getFragmentActivityClass();

    public abstract Class<FRAGMENT> getFragmentClass();

    static {
        sHasSupportFragment = ReflectionUtil.tryGetClassForName("androidx.fragment.app.Fragment") != null;
    }

    public static FragmentCompat getFrameworkInstance() {
        if (sFrameworkInstance == null) {
            sFrameworkInstance = new FragmentCompatFramework();
        }
        return sFrameworkInstance;
    }

    public static FragmentCompat getSupportLibInstance() {
        if (sSupportInstance == null && sHasSupportFragment) {
            sSupportInstance = new FragmentCompatSupportLib();
        }
        return sSupportInstance;
    }

    FragmentCompat() {
    }

    static class FragmentManagerAccessorViaReflection<FRAGMENT_MANAGER, FRAGMENT> implements FragmentManagerAccessor<FRAGMENT_MANAGER, FRAGMENT> {
        private Field mFieldMAdded;

        FragmentManagerAccessorViaReflection() {
        }

        @Override // com.facebook.stetho.common.android.FragmentManagerAccessor
        public List<FRAGMENT> getAddedFragments(FRAGMENT_MANAGER fragment_manager) {
            Field fieldTryGetDeclaredField;
            if (this.mFieldMAdded == null && (fieldTryGetDeclaredField = ReflectionUtil.tryGetDeclaredField(fragment_manager.getClass(), "mAdded")) != null) {
                fieldTryGetDeclaredField.setAccessible(true);
                this.mFieldMAdded = fieldTryGetDeclaredField;
            }
            Field field = this.mFieldMAdded;
            if (field != null) {
                return (List) ReflectionUtil.getFieldValue(field, fragment_manager);
            }
            return null;
        }
    }
}
