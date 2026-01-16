package com.facebook.stetho.common.android;

import android.app.Activity;
import android.view.View;
import java.util.List;

/* loaded from: classes.dex */
public final class FragmentCompatUtil {
    private FragmentCompatUtil() {
    }

    public static boolean isDialogFragment(Object obj) {
        FragmentCompat supportLibInstance = FragmentCompat.getSupportLibInstance();
        if (supportLibInstance != null && supportLibInstance.getDialogFragmentClass().isInstance(obj)) {
            return true;
        }
        FragmentCompat frameworkInstance = FragmentCompat.getFrameworkInstance();
        return frameworkInstance != null && frameworkInstance.getDialogFragmentClass().isInstance(obj);
    }

    public static Object findFragmentForView(View view) {
        Activity activityTryGetActivity = ViewUtil.tryGetActivity(view);
        if (activityTryGetActivity == null) {
            return null;
        }
        return findFragmentForViewInActivity(activityTryGetActivity, view);
    }

    private static Object findFragmentForViewInActivity(Activity activity, View view) {
        Object objFindFragmentForViewInActivity;
        Object objFindFragmentForViewInActivity2;
        FragmentCompat supportLibInstance = FragmentCompat.getSupportLibInstance();
        if (supportLibInstance != null && supportLibInstance.getFragmentActivityClass().isInstance(activity) && (objFindFragmentForViewInActivity2 = findFragmentForViewInActivity(supportLibInstance, activity, view)) != null) {
            return objFindFragmentForViewInActivity2;
        }
        FragmentCompat frameworkInstance = FragmentCompat.getFrameworkInstance();
        if (frameworkInstance == null || (objFindFragmentForViewInActivity = findFragmentForViewInActivity(frameworkInstance, activity, view)) == null) {
            return null;
        }
        return objFindFragmentForViewInActivity;
    }

    private static Object findFragmentForViewInActivity(FragmentCompat fragmentCompat, Activity activity, View view) {
        Object fragmentManager = fragmentCompat.forFragmentActivity().getFragmentManager(activity);
        if (fragmentManager != null) {
            return findFragmentForViewInFragmentManager(fragmentCompat, fragmentManager, view);
        }
        return null;
    }

    private static Object findFragmentForViewInFragmentManager(FragmentCompat fragmentCompat, Object obj, View view) {
        List addedFragments = fragmentCompat.forFragmentManager2().getAddedFragments(obj);
        if (addedFragments == null) {
            return null;
        }
        int size = addedFragments.size();
        for (int i = 0; i < size; i++) {
            Object objFindFragmentForViewInFragment = findFragmentForViewInFragment(fragmentCompat, addedFragments.get(i), view);
            if (objFindFragmentForViewInFragment != null) {
                return objFindFragmentForViewInFragment;
            }
        }
        return null;
    }

    private static Object findFragmentForViewInFragment(FragmentCompat fragmentCompat, Object obj, View view) {
        FragmentAccessor fragmentAccessorForFragment = fragmentCompat.forFragment();
        if (fragmentAccessorForFragment.getView(obj) == view) {
            return obj;
        }
        Object childFragmentManager = fragmentAccessorForFragment.getChildFragmentManager(obj);
        if (childFragmentManager != null) {
            return findFragmentForViewInFragmentManager(fragmentCompat, childFragmentManager, view);
        }
        return null;
    }
}
