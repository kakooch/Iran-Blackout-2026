package androidx.fragment.app;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import androidx.collection.ArrayMap;
import androidx.core.app.SharedElementCallback;
import androidx.core.os.CancellationSignal;
import androidx.core.util.Preconditions;
import androidx.core.view.OneShotPreDrawListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.ViewGroupCompat;
import androidx.fragment.app.FragmentAnim;
import androidx.fragment.app.SpecialEffectsController;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
class DefaultSpecialEffectsController extends SpecialEffectsController {
    DefaultSpecialEffectsController(ViewGroup viewGroup) {
        super(viewGroup);
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x00ab  */
    @Override // androidx.fragment.app.SpecialEffectsController
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    void executeOperations(java.util.List<androidx.fragment.app.SpecialEffectsController.Operation> r14, boolean r15) throws android.content.res.Resources.NotFoundException {
        /*
            Method dump skipped, instructions count: 262
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.fragment.app.DefaultSpecialEffectsController.executeOperations(java.util.List, boolean):void");
    }

    /* renamed from: androidx.fragment.app.DefaultSpecialEffectsController$10, reason: invalid class name */
    static /* synthetic */ class AnonymousClass10 {
        static final /* synthetic */ int[] $SwitchMap$androidx$fragment$app$SpecialEffectsController$Operation$State;

        static {
            int[] iArr = new int[SpecialEffectsController.Operation.State.values().length];
            $SwitchMap$androidx$fragment$app$SpecialEffectsController$Operation$State = iArr;
            try {
                iArr[SpecialEffectsController.Operation.State.GONE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$androidx$fragment$app$SpecialEffectsController$Operation$State[SpecialEffectsController.Operation.State.INVISIBLE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$androidx$fragment$app$SpecialEffectsController$Operation$State[SpecialEffectsController.Operation.State.REMOVED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$androidx$fragment$app$SpecialEffectsController$Operation$State[SpecialEffectsController.Operation.State.VISIBLE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    private void syncAnimations(List<SpecialEffectsController.Operation> list) {
        Fragment fragment = list.get(list.size() - 1).getFragment();
        for (SpecialEffectsController.Operation operation : list) {
            operation.getFragment().mAnimationInfo.mEnterAnim = fragment.mAnimationInfo.mEnterAnim;
            operation.getFragment().mAnimationInfo.mExitAnim = fragment.mAnimationInfo.mExitAnim;
            operation.getFragment().mAnimationInfo.mPopEnterAnim = fragment.mAnimationInfo.mPopEnterAnim;
            operation.getFragment().mAnimationInfo.mPopExitAnim = fragment.mAnimationInfo.mPopExitAnim;
        }
    }

    private void startAnimations(List<AnimationInfo> list, List<SpecialEffectsController.Operation> list2, boolean z, Map<SpecialEffectsController.Operation, Boolean> map) throws Resources.NotFoundException {
        int i;
        boolean z2;
        final SpecialEffectsController.Operation operation;
        final ViewGroup container = getContainer();
        Context context = container.getContext();
        ArrayList arrayList = new ArrayList();
        Iterator<AnimationInfo> it = list.iterator();
        boolean z3 = false;
        while (true) {
            i = 2;
            if (!it.hasNext()) {
                break;
            }
            final AnimationInfo next = it.next();
            if (next.isVisibilityUnchanged()) {
                next.completeSpecialEffect();
            } else {
                FragmentAnim.AnimationOrAnimator animation = next.getAnimation(context);
                if (animation == null) {
                    next.completeSpecialEffect();
                } else {
                    final Animator animator = animation.animator;
                    if (animator == null) {
                        arrayList.add(next);
                    } else {
                        final SpecialEffectsController.Operation operation2 = next.getOperation();
                        Fragment fragment = operation2.getFragment();
                        if (Boolean.TRUE.equals(map.get(operation2))) {
                            if (FragmentManager.isLoggingEnabled(2)) {
                                Log.v("FragmentManager", "Ignoring Animator set on " + fragment + " as this Fragment was involved in a Transition.");
                            }
                            next.completeSpecialEffect();
                        } else {
                            boolean z4 = operation2.getFinalState() == SpecialEffectsController.Operation.State.GONE;
                            if (z4) {
                                list2.remove(operation2);
                            }
                            final View view = fragment.mView;
                            container.startViewTransition(view);
                            final boolean z5 = z4;
                            animator.addListener(new AnimatorListenerAdapter() { // from class: androidx.fragment.app.DefaultSpecialEffectsController.2
                                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                                public void onAnimationEnd(Animator animator2) {
                                    container.endViewTransition(view);
                                    if (z5) {
                                        operation2.getFinalState().applyState(view);
                                    }
                                    next.completeSpecialEffect();
                                    if (FragmentManager.isLoggingEnabled(2)) {
                                        Log.v("FragmentManager", "Animator from operation " + operation2 + " has ended.");
                                    }
                                }
                            });
                            animator.setTarget(view);
                            animator.start();
                            if (FragmentManager.isLoggingEnabled(2)) {
                                StringBuilder sb = new StringBuilder();
                                sb.append("Animator from operation ");
                                operation = operation2;
                                sb.append(operation);
                                sb.append(" has started.");
                                Log.v("FragmentManager", sb.toString());
                            } else {
                                operation = operation2;
                            }
                            next.getSignal().setOnCancelListener(new CancellationSignal.OnCancelListener() { // from class: androidx.fragment.app.DefaultSpecialEffectsController.3
                                @Override // androidx.core.os.CancellationSignal.OnCancelListener
                                public void onCancel() {
                                    animator.end();
                                    if (FragmentManager.isLoggingEnabled(2)) {
                                        Log.v("FragmentManager", "Animator from operation " + operation + " has been canceled.");
                                    }
                                }
                            });
                            z3 = true;
                        }
                    }
                }
            }
        }
        Iterator it2 = arrayList.iterator();
        while (it2.hasNext()) {
            final AnimationInfo animationInfo = (AnimationInfo) it2.next();
            final SpecialEffectsController.Operation operation3 = animationInfo.getOperation();
            Fragment fragment2 = operation3.getFragment();
            if (z) {
                if (FragmentManager.isLoggingEnabled(i)) {
                    Log.v("FragmentManager", "Ignoring Animation set on " + fragment2 + " as Animations cannot run alongside Transitions.");
                }
                animationInfo.completeSpecialEffect();
            } else if (z3) {
                if (FragmentManager.isLoggingEnabled(i)) {
                    Log.v("FragmentManager", "Ignoring Animation set on " + fragment2 + " as Animations cannot run alongside Animators.");
                }
                animationInfo.completeSpecialEffect();
            } else {
                final View view2 = fragment2.mView;
                Animation animation2 = (Animation) Preconditions.checkNotNull(((FragmentAnim.AnimationOrAnimator) Preconditions.checkNotNull(animationInfo.getAnimation(context))).animation);
                if (operation3.getFinalState() != SpecialEffectsController.Operation.State.REMOVED) {
                    view2.startAnimation(animation2);
                    animationInfo.completeSpecialEffect();
                    z2 = z3;
                } else {
                    container.startViewTransition(view2);
                    FragmentAnim.EndViewTransitionAnimation endViewTransitionAnimation = new FragmentAnim.EndViewTransitionAnimation(animation2, container, view2);
                    z2 = z3;
                    endViewTransitionAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: androidx.fragment.app.DefaultSpecialEffectsController.4
                        @Override // android.view.animation.Animation.AnimationListener
                        public void onAnimationRepeat(Animation animation3) {
                        }

                        @Override // android.view.animation.Animation.AnimationListener
                        public void onAnimationStart(Animation animation3) {
                            if (FragmentManager.isLoggingEnabled(2)) {
                                Log.v("FragmentManager", "Animation from operation " + operation3 + " has reached onAnimationStart.");
                            }
                        }

                        @Override // android.view.animation.Animation.AnimationListener
                        public void onAnimationEnd(Animation animation3) {
                            container.post(new Runnable() { // from class: androidx.fragment.app.DefaultSpecialEffectsController.4.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    AnonymousClass4 anonymousClass4 = AnonymousClass4.this;
                                    container.endViewTransition(view2);
                                    animationInfo.completeSpecialEffect();
                                }
                            });
                            if (FragmentManager.isLoggingEnabled(2)) {
                                Log.v("FragmentManager", "Animation from operation " + operation3 + " has ended.");
                            }
                        }
                    });
                    view2.startAnimation(endViewTransitionAnimation);
                    if (FragmentManager.isLoggingEnabled(2)) {
                        Log.v("FragmentManager", "Animation from operation " + operation3 + " has started.");
                    }
                }
                animationInfo.getSignal().setOnCancelListener(new CancellationSignal.OnCancelListener() { // from class: androidx.fragment.app.DefaultSpecialEffectsController.5
                    @Override // androidx.core.os.CancellationSignal.OnCancelListener
                    public void onCancel() {
                        view2.clearAnimation();
                        container.endViewTransition(view2);
                        animationInfo.completeSpecialEffect();
                        if (FragmentManager.isLoggingEnabled(2)) {
                            Log.v("FragmentManager", "Animation from operation " + operation3 + " has been cancelled.");
                        }
                    }
                });
                i = 2;
                z3 = z2;
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private Map<SpecialEffectsController.Operation, Boolean> startTransitions(List<TransitionInfo> list, List<SpecialEffectsController.Operation> list2, final boolean z, final SpecialEffectsController.Operation operation, final SpecialEffectsController.Operation operation2) {
        String str;
        String str2;
        View view;
        Object objMergeTransitionsTogether;
        ArrayList<View> arrayList;
        Object objMergeTransitionsTogether2;
        ArrayList<View> arrayList2;
        Object obj;
        SpecialEffectsController.Operation operation3;
        View view2;
        ArrayMap arrayMap;
        SpecialEffectsController.Operation operation4;
        SpecialEffectsController.Operation operation5;
        HashMap map;
        ArrayList<View> arrayList3;
        View view3;
        FragmentTransitionImpl fragmentTransitionImpl;
        ArrayList<View> arrayList4;
        final Rect rect;
        SharedElementCallback enterTransitionCallback;
        SharedElementCallback exitTransitionCallback;
        int i;
        View view4;
        final View view5;
        boolean z2 = z;
        SpecialEffectsController.Operation operation6 = operation;
        SpecialEffectsController.Operation operation7 = operation2;
        HashMap map2 = new HashMap();
        final FragmentTransitionImpl fragmentTransitionImpl2 = null;
        for (TransitionInfo transitionInfo : list) {
            if (!transitionInfo.isVisibilityUnchanged()) {
                FragmentTransitionImpl handlingImpl = transitionInfo.getHandlingImpl();
                if (fragmentTransitionImpl2 == null) {
                    fragmentTransitionImpl2 = handlingImpl;
                } else if (handlingImpl != null && fragmentTransitionImpl2 != handlingImpl) {
                    throw new IllegalArgumentException("Mixing framework transitions and AndroidX transitions is not allowed. Fragment " + transitionInfo.getOperation().getFragment() + " returned Transition " + transitionInfo.getTransition() + " which uses a different Transition  type than other Fragments.");
                }
            }
        }
        if (fragmentTransitionImpl2 == null) {
            for (TransitionInfo transitionInfo2 : list) {
                map2.put(transitionInfo2.getOperation(), Boolean.FALSE);
                transitionInfo2.completeSpecialEffect();
            }
            return map2;
        }
        View view6 = new View(getContainer().getContext());
        Rect rect2 = new Rect();
        ArrayList<View> arrayList5 = new ArrayList<>();
        ArrayList<View> arrayList6 = new ArrayList<>();
        ArrayMap arrayMap2 = new ArrayMap();
        Iterator<TransitionInfo> it = list.iterator();
        Object obj2 = null;
        View view7 = null;
        boolean z3 = false;
        while (true) {
            String str3 = "FragmentManager";
            if (it.hasNext()) {
                TransitionInfo next = it.next();
                if (!next.hasSharedElementTransition() || operation6 == null || operation7 == null) {
                    arrayMap = arrayMap2;
                    operation4 = operation6;
                    operation5 = operation7;
                    map = map2;
                    arrayList3 = arrayList5;
                    view3 = view6;
                    fragmentTransitionImpl = fragmentTransitionImpl2;
                    arrayList4 = arrayList6;
                    rect = rect2;
                    view7 = view7;
                } else {
                    Object objWrapTransitionInSet = fragmentTransitionImpl2.wrapTransitionInSet(fragmentTransitionImpl2.cloneTransition(next.getSharedElementTransition()));
                    ArrayList<String> sharedElementSourceNames = operation2.getFragment().getSharedElementSourceNames();
                    ArrayList<String> sharedElementSourceNames2 = operation.getFragment().getSharedElementSourceNames();
                    ArrayList<String> sharedElementTargetNames = operation.getFragment().getSharedElementTargetNames();
                    View view8 = view7;
                    HashMap map3 = map2;
                    int i2 = 0;
                    while (i2 < sharedElementTargetNames.size()) {
                        int iIndexOf = sharedElementSourceNames.indexOf(sharedElementTargetNames.get(i2));
                        ArrayList<String> arrayList7 = sharedElementTargetNames;
                        if (iIndexOf != -1) {
                            sharedElementSourceNames.set(iIndexOf, sharedElementSourceNames2.get(i2));
                        }
                        i2++;
                        sharedElementTargetNames = arrayList7;
                    }
                    ArrayList<String> sharedElementTargetNames2 = operation2.getFragment().getSharedElementTargetNames();
                    if (!z2) {
                        enterTransitionCallback = operation.getFragment().getExitTransitionCallback();
                        exitTransitionCallback = operation2.getFragment().getEnterTransitionCallback();
                    } else {
                        enterTransitionCallback = operation.getFragment().getEnterTransitionCallback();
                        exitTransitionCallback = operation2.getFragment().getExitTransitionCallback();
                    }
                    int size = sharedElementSourceNames.size();
                    View view9 = view6;
                    int i3 = 0;
                    while (i3 < size) {
                        arrayMap2.put(sharedElementSourceNames.get(i3), sharedElementTargetNames2.get(i3));
                        i3++;
                        size = size;
                        rect2 = rect2;
                    }
                    Rect rect3 = rect2;
                    if (FragmentManager.isLoggingEnabled(2)) {
                        Log.v("FragmentManager", ">>> entering view names <<<");
                        for (Iterator<String> it2 = sharedElementTargetNames2.iterator(); it2.hasNext(); it2 = it2) {
                            Log.v("FragmentManager", "Name: " + it2.next());
                        }
                        Log.v("FragmentManager", ">>> exiting view names <<<");
                        for (Iterator<String> it3 = sharedElementSourceNames.iterator(); it3.hasNext(); it3 = it3) {
                            Log.v("FragmentManager", "Name: " + it3.next());
                        }
                    }
                    ArrayMap<String, View> arrayMap3 = new ArrayMap<>();
                    findNamedViews(arrayMap3, operation.getFragment().mView);
                    arrayMap3.retainAll(sharedElementSourceNames);
                    if (enterTransitionCallback != null) {
                        if (FragmentManager.isLoggingEnabled(2)) {
                            Log.v("FragmentManager", "Executing exit callback for operation " + operation6);
                        }
                        throw null;
                    }
                    arrayMap2.retainAll(arrayMap3.keySet());
                    final ArrayMap<String, View> arrayMap4 = new ArrayMap<>();
                    findNamedViews(arrayMap4, operation2.getFragment().mView);
                    arrayMap4.retainAll(sharedElementTargetNames2);
                    arrayMap4.retainAll(arrayMap2.values());
                    if (exitTransitionCallback != null) {
                        if (FragmentManager.isLoggingEnabled(2)) {
                            Log.v("FragmentManager", "Executing enter callback for operation " + operation7);
                        }
                        throw null;
                    }
                    FragmentTransition.retainValues(arrayMap2, arrayMap4);
                    retainMatchingViews(arrayMap3, arrayMap2.keySet());
                    retainMatchingViews(arrayMap4, arrayMap2.values());
                    if (arrayMap2.isEmpty()) {
                        arrayList5.clear();
                        arrayList6.clear();
                        arrayMap = arrayMap2;
                        arrayList4 = arrayList6;
                        operation4 = operation6;
                        operation5 = operation7;
                        arrayList3 = arrayList5;
                        fragmentTransitionImpl = fragmentTransitionImpl2;
                        view7 = view8;
                        view3 = view9;
                        map = map3;
                        rect = rect3;
                        obj2 = null;
                    } else {
                        FragmentTransition.callSharedElementStartEnd(operation2.getFragment(), operation.getFragment(), z2, arrayMap3, true);
                        arrayMap = arrayMap2;
                        ArrayList<View> arrayList8 = arrayList6;
                        OneShotPreDrawListener.add(getContainer(), new Runnable() { // from class: androidx.fragment.app.DefaultSpecialEffectsController.6
                            @Override // java.lang.Runnable
                            public void run() {
                                FragmentTransition.callSharedElementStartEnd(operation2.getFragment(), operation.getFragment(), z, arrayMap4, false);
                            }
                        });
                        arrayList5.addAll(arrayMap3.values());
                        if (sharedElementSourceNames.isEmpty()) {
                            i = 0;
                            view7 = view8;
                        } else {
                            i = 0;
                            View view10 = (View) arrayMap3.get(sharedElementSourceNames.get(0));
                            fragmentTransitionImpl2.setEpicenter(objWrapTransitionInSet, view10);
                            view7 = view10;
                        }
                        arrayList8.addAll(arrayMap4.values());
                        if (sharedElementTargetNames2.isEmpty() || (view5 = (View) arrayMap4.get(sharedElementTargetNames2.get(i))) == null) {
                            rect = rect3;
                            view4 = view9;
                        } else {
                            rect = rect3;
                            OneShotPreDrawListener.add(getContainer(), new Runnable() { // from class: androidx.fragment.app.DefaultSpecialEffectsController.7
                                @Override // java.lang.Runnable
                                public void run() {
                                    fragmentTransitionImpl2.getBoundsOnScreen(view5, rect);
                                }
                            });
                            view4 = view9;
                            z3 = true;
                        }
                        fragmentTransitionImpl2.setSharedElementTargets(objWrapTransitionInSet, view4, arrayList5);
                        arrayList3 = arrayList5;
                        view3 = view4;
                        obj2 = objWrapTransitionInSet;
                        fragmentTransitionImpl = fragmentTransitionImpl2;
                        fragmentTransitionImpl2.scheduleRemoveTargets(objWrapTransitionInSet, null, null, null, null, obj2, arrayList8);
                        Boolean bool = Boolean.TRUE;
                        operation4 = operation;
                        arrayList4 = arrayList8;
                        map = map3;
                        map.put(operation4, bool);
                        operation5 = operation2;
                        map.put(operation5, bool);
                    }
                }
                rect2 = rect;
                arrayList5 = arrayList3;
                view6 = view3;
                arrayList6 = arrayList4;
                fragmentTransitionImpl2 = fragmentTransitionImpl;
                z2 = z;
                operation7 = operation5;
                map2 = map;
                operation6 = operation4;
                arrayMap2 = arrayMap;
            } else {
                View view11 = view7;
                ArrayMap arrayMap5 = arrayMap2;
                SpecialEffectsController.Operation operation8 = operation6;
                SpecialEffectsController.Operation operation9 = operation7;
                HashMap map4 = map2;
                ArrayList<View> arrayList9 = arrayList5;
                View view12 = view6;
                FragmentTransitionImpl fragmentTransitionImpl3 = fragmentTransitionImpl2;
                ArrayList<View> arrayList10 = arrayList6;
                Rect rect4 = rect2;
                ArrayList arrayList11 = new ArrayList();
                Object obj3 = null;
                Object obj4 = null;
                for (TransitionInfo transitionInfo3 : list) {
                    if (transitionInfo3.isVisibilityUnchanged()) {
                        map4.put(transitionInfo3.getOperation(), Boolean.FALSE);
                        transitionInfo3.completeSpecialEffect();
                    } else {
                        Object objCloneTransition = fragmentTransitionImpl3.cloneTransition(transitionInfo3.getTransition());
                        SpecialEffectsController.Operation operation10 = transitionInfo3.getOperation();
                        boolean z4 = obj2 != null && (operation10 == operation8 || operation10 == operation9);
                        if (objCloneTransition == null) {
                            if (!z4) {
                                map4.put(operation10, Boolean.FALSE);
                                transitionInfo3.completeSpecialEffect();
                            }
                            str2 = str3;
                            arrayList = arrayList9;
                            view = view12;
                            arrayList2 = arrayList10;
                            objMergeTransitionsTogether = obj3;
                            view2 = view11;
                        } else {
                            str2 = str3;
                            final ArrayList<View> arrayList12 = new ArrayList<>();
                            Object obj5 = obj3;
                            captureTransitioningViews(arrayList12, operation10.getFragment().mView);
                            if (z4) {
                                if (operation10 == operation8) {
                                    arrayList12.removeAll(arrayList9);
                                } else {
                                    arrayList12.removeAll(arrayList10);
                                }
                            }
                            if (arrayList12.isEmpty()) {
                                fragmentTransitionImpl3.addTarget(objCloneTransition, view12);
                                arrayList = arrayList9;
                                view = view12;
                                arrayList2 = arrayList10;
                                operation3 = operation10;
                                objMergeTransitionsTogether2 = obj4;
                                obj = objCloneTransition;
                                objMergeTransitionsTogether = obj5;
                            } else {
                                fragmentTransitionImpl3.addTargets(objCloneTransition, arrayList12);
                                view = view12;
                                objMergeTransitionsTogether = obj5;
                                arrayList = arrayList9;
                                objMergeTransitionsTogether2 = obj4;
                                arrayList2 = arrayList10;
                                obj = objCloneTransition;
                                fragmentTransitionImpl3.scheduleRemoveTargets(objCloneTransition, objCloneTransition, arrayList12, null, null, null, null);
                                if (operation10.getFinalState() == SpecialEffectsController.Operation.State.GONE) {
                                    operation3 = operation10;
                                    list2.remove(operation3);
                                    ArrayList<View> arrayList13 = new ArrayList<>(arrayList12);
                                    arrayList13.remove(operation3.getFragment().mView);
                                    fragmentTransitionImpl3.scheduleHideFragmentView(obj, operation3.getFragment().mView, arrayList13);
                                    OneShotPreDrawListener.add(getContainer(), new Runnable() { // from class: androidx.fragment.app.DefaultSpecialEffectsController.8
                                        @Override // java.lang.Runnable
                                        public void run() {
                                            FragmentTransition.setViewVisibility(arrayList12, 4);
                                        }
                                    });
                                } else {
                                    operation3 = operation10;
                                }
                            }
                            if (operation3.getFinalState() == SpecialEffectsController.Operation.State.VISIBLE) {
                                arrayList11.addAll(arrayList12);
                                if (z3) {
                                    fragmentTransitionImpl3.setEpicenter(obj, rect4);
                                }
                                view2 = view11;
                            } else {
                                view2 = view11;
                                fragmentTransitionImpl3.setEpicenter(obj, view2);
                            }
                            map4.put(operation3, Boolean.TRUE);
                            if (transitionInfo3.isOverlapAllowed()) {
                                objMergeTransitionsTogether2 = fragmentTransitionImpl3.mergeTransitionsTogether(objMergeTransitionsTogether2, obj, null);
                            } else {
                                objMergeTransitionsTogether = fragmentTransitionImpl3.mergeTransitionsTogether(objMergeTransitionsTogether, obj, null);
                            }
                            obj4 = objMergeTransitionsTogether2;
                        }
                        view11 = view2;
                        obj3 = objMergeTransitionsTogether;
                        str3 = str2;
                        view12 = view;
                        arrayList9 = arrayList;
                        arrayList10 = arrayList2;
                    }
                }
                String str4 = str3;
                ArrayList<View> arrayList14 = arrayList9;
                ArrayList<View> arrayList15 = arrayList10;
                Object objMergeTransitionsInSequence = fragmentTransitionImpl3.mergeTransitionsInSequence(obj4, obj3, obj2);
                if (objMergeTransitionsInSequence == null) {
                    return map4;
                }
                for (final TransitionInfo transitionInfo4 : list) {
                    if (!transitionInfo4.isVisibilityUnchanged()) {
                        Object transition = transitionInfo4.getTransition();
                        final SpecialEffectsController.Operation operation11 = transitionInfo4.getOperation();
                        boolean z5 = obj2 != null && (operation11 == operation8 || operation11 == operation9);
                        if (transition == null && !z5) {
                            str = str4;
                        } else if (!ViewCompat.isLaidOut(getContainer())) {
                            if (FragmentManager.isLoggingEnabled(2)) {
                                str = str4;
                                Log.v(str, "SpecialEffectsController: Container " + getContainer() + " has not been laid out. Completing operation " + operation11);
                            } else {
                                str = str4;
                            }
                            transitionInfo4.completeSpecialEffect();
                        } else {
                            str = str4;
                            fragmentTransitionImpl3.setListenerForTransitionEnd(transitionInfo4.getOperation().getFragment(), objMergeTransitionsInSequence, transitionInfo4.getSignal(), new Runnable() { // from class: androidx.fragment.app.DefaultSpecialEffectsController.9
                                @Override // java.lang.Runnable
                                public void run() {
                                    transitionInfo4.completeSpecialEffect();
                                    if (FragmentManager.isLoggingEnabled(2)) {
                                        Log.v("FragmentManager", "Transition for operation " + operation11 + "has completed");
                                    }
                                }
                            });
                        }
                        str4 = str;
                    }
                }
                String str5 = str4;
                if (!ViewCompat.isLaidOut(getContainer())) {
                    return map4;
                }
                FragmentTransition.setViewVisibility(arrayList11, 4);
                ArrayList<String> arrayListPrepareSetNameOverridesReordered = fragmentTransitionImpl3.prepareSetNameOverridesReordered(arrayList15);
                if (FragmentManager.isLoggingEnabled(2)) {
                    Log.v(str5, ">>>>> Beginning transition <<<<<");
                    Log.v(str5, ">>>>> SharedElementFirstOutViews <<<<<");
                    Iterator<View> it4 = arrayList14.iterator();
                    while (it4.hasNext()) {
                        View next2 = it4.next();
                        Log.v(str5, "View: " + next2 + " Name: " + ViewCompat.getTransitionName(next2));
                    }
                    Log.v(str5, ">>>>> SharedElementLastInViews <<<<<");
                    Iterator<View> it5 = arrayList15.iterator();
                    while (it5.hasNext()) {
                        View next3 = it5.next();
                        Log.v(str5, "View: " + next3 + " Name: " + ViewCompat.getTransitionName(next3));
                    }
                }
                fragmentTransitionImpl3.beginDelayedTransition(getContainer(), objMergeTransitionsInSequence);
                fragmentTransitionImpl3.setNameOverridesReordered(getContainer(), arrayList14, arrayList15, arrayListPrepareSetNameOverridesReordered, arrayMap5);
                FragmentTransition.setViewVisibility(arrayList11, 0);
                fragmentTransitionImpl3.swapSharedElementTargets(obj2, arrayList14, arrayList15);
                return map4;
            }
        }
    }

    void retainMatchingViews(ArrayMap<String, View> arrayMap, Collection<String> collection) {
        Iterator<Map.Entry<String, View>> it = arrayMap.entrySet().iterator();
        while (it.hasNext()) {
            if (!collection.contains(ViewCompat.getTransitionName(it.next().getValue()))) {
                it.remove();
            }
        }
    }

    void captureTransitioningViews(ArrayList<View> arrayList, View view) {
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            if (ViewGroupCompat.isTransitionGroup(viewGroup)) {
                if (arrayList.contains(view)) {
                    return;
                }
                arrayList.add(viewGroup);
                return;
            }
            int childCount = viewGroup.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = viewGroup.getChildAt(i);
                if (childAt.getVisibility() == 0) {
                    captureTransitioningViews(arrayList, childAt);
                }
            }
            return;
        }
        if (arrayList.contains(view)) {
            return;
        }
        arrayList.add(view);
    }

    void findNamedViews(Map<String, View> map, View view) {
        String transitionName = ViewCompat.getTransitionName(view);
        if (transitionName != null) {
            map.put(transitionName, view);
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int childCount = viewGroup.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = viewGroup.getChildAt(i);
                if (childAt.getVisibility() == 0) {
                    findNamedViews(map, childAt);
                }
            }
        }
    }

    void applyContainerChanges(SpecialEffectsController.Operation operation) {
        operation.getFinalState().applyState(operation.getFragment().mView);
    }

    private static class SpecialEffectsInfo {
        private final SpecialEffectsController.Operation mOperation;
        private final CancellationSignal mSignal;

        SpecialEffectsInfo(SpecialEffectsController.Operation operation, CancellationSignal cancellationSignal) {
            this.mOperation = operation;
            this.mSignal = cancellationSignal;
        }

        SpecialEffectsController.Operation getOperation() {
            return this.mOperation;
        }

        CancellationSignal getSignal() {
            return this.mSignal;
        }

        boolean isVisibilityUnchanged() {
            SpecialEffectsController.Operation.State state;
            SpecialEffectsController.Operation.State stateFrom = SpecialEffectsController.Operation.State.from(this.mOperation.getFragment().mView);
            SpecialEffectsController.Operation.State finalState = this.mOperation.getFinalState();
            return stateFrom == finalState || !(stateFrom == (state = SpecialEffectsController.Operation.State.VISIBLE) || finalState == state);
        }

        void completeSpecialEffect() {
            this.mOperation.completeSpecialEffect(this.mSignal);
        }
    }

    private static class AnimationInfo extends SpecialEffectsInfo {
        private FragmentAnim.AnimationOrAnimator mAnimation;
        private boolean mIsPop;
        private boolean mLoadedAnim;

        AnimationInfo(SpecialEffectsController.Operation operation, CancellationSignal cancellationSignal, boolean z) {
            super(operation, cancellationSignal);
            this.mLoadedAnim = false;
            this.mIsPop = z;
        }

        FragmentAnim.AnimationOrAnimator getAnimation(Context context) throws Resources.NotFoundException {
            if (this.mLoadedAnim) {
                return this.mAnimation;
            }
            FragmentAnim.AnimationOrAnimator animationOrAnimatorLoadAnimation = FragmentAnim.loadAnimation(context, getOperation().getFragment(), getOperation().getFinalState() == SpecialEffectsController.Operation.State.VISIBLE, this.mIsPop);
            this.mAnimation = animationOrAnimatorLoadAnimation;
            this.mLoadedAnim = true;
            return animationOrAnimatorLoadAnimation;
        }
    }

    private static class TransitionInfo extends SpecialEffectsInfo {
        private final boolean mOverlapAllowed;
        private final Object mSharedElementTransition;
        private final Object mTransition;

        TransitionInfo(SpecialEffectsController.Operation operation, CancellationSignal cancellationSignal, boolean z, boolean z2) {
            Object exitTransition;
            Object enterTransition;
            boolean allowEnterTransitionOverlap;
            super(operation, cancellationSignal);
            if (operation.getFinalState() == SpecialEffectsController.Operation.State.VISIBLE) {
                if (z) {
                    enterTransition = operation.getFragment().getReenterTransition();
                } else {
                    enterTransition = operation.getFragment().getEnterTransition();
                }
                this.mTransition = enterTransition;
                if (z) {
                    allowEnterTransitionOverlap = operation.getFragment().getAllowReturnTransitionOverlap();
                } else {
                    allowEnterTransitionOverlap = operation.getFragment().getAllowEnterTransitionOverlap();
                }
                this.mOverlapAllowed = allowEnterTransitionOverlap;
            } else {
                if (z) {
                    exitTransition = operation.getFragment().getReturnTransition();
                } else {
                    exitTransition = operation.getFragment().getExitTransition();
                }
                this.mTransition = exitTransition;
                this.mOverlapAllowed = true;
            }
            if (!z2) {
                this.mSharedElementTransition = null;
            } else if (z) {
                this.mSharedElementTransition = operation.getFragment().getSharedElementReturnTransition();
            } else {
                this.mSharedElementTransition = operation.getFragment().getSharedElementEnterTransition();
            }
        }

        Object getTransition() {
            return this.mTransition;
        }

        boolean isOverlapAllowed() {
            return this.mOverlapAllowed;
        }

        public boolean hasSharedElementTransition() {
            return this.mSharedElementTransition != null;
        }

        public Object getSharedElementTransition() {
            return this.mSharedElementTransition;
        }

        FragmentTransitionImpl getHandlingImpl() {
            FragmentTransitionImpl handlingImpl = getHandlingImpl(this.mTransition);
            FragmentTransitionImpl handlingImpl2 = getHandlingImpl(this.mSharedElementTransition);
            if (handlingImpl == null || handlingImpl2 == null || handlingImpl == handlingImpl2) {
                return handlingImpl != null ? handlingImpl : handlingImpl2;
            }
            throw new IllegalArgumentException("Mixing framework transitions and AndroidX transitions is not allowed. Fragment " + getOperation().getFragment() + " returned Transition " + this.mTransition + " which uses a different Transition  type than its shared element transition " + this.mSharedElementTransition);
        }

        private FragmentTransitionImpl getHandlingImpl(Object obj) {
            if (obj == null) {
                return null;
            }
            FragmentTransitionImpl fragmentTransitionImpl = FragmentTransition.PLATFORM_IMPL;
            if (fragmentTransitionImpl != null && fragmentTransitionImpl.canHandle(obj)) {
                return fragmentTransitionImpl;
            }
            FragmentTransitionImpl fragmentTransitionImpl2 = FragmentTransition.SUPPORT_IMPL;
            if (fragmentTransitionImpl2 != null && fragmentTransitionImpl2.canHandle(obj)) {
                return fragmentTransitionImpl2;
            }
            throw new IllegalArgumentException("Transition " + obj + " for fragment " + getOperation().getFragment() + " is not a valid framework Transition or AndroidX Transition");
        }
    }
}
