package androidx.fragment.app;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import ir.nasim.C4404Ez2;
import ir.nasim.WE5;

/* loaded from: classes2.dex */
class q implements LayoutInflater.Factory2 {
    final FragmentManager a;

    class a implements View.OnAttachStateChangeListener {
        final /* synthetic */ u a;

        a(u uVar) {
            this.a = uVar;
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
            Fragment fragmentK = this.a.k();
            this.a.m();
            F.u((ViewGroup) fragmentK.B0.getParent(), q.this.a).q();
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
        }
    }

    q(FragmentManager fragmentManager) {
        this.a = fragmentManager;
    }

    @Override // android.view.LayoutInflater.Factory
    public View onCreateView(String str, Context context, AttributeSet attributeSet) {
        return onCreateView(null, str, context, attributeSet);
    }

    @Override // android.view.LayoutInflater.Factory2
    public View onCreateView(View view, String str, Context context, AttributeSet attributeSet) {
        u uVarC;
        if (FragmentContainerView.class.getName().equals(str)) {
            return new FragmentContainerView(context, attributeSet, this.a);
        }
        if (!"fragment".equals(str)) {
            return null;
        }
        String attributeValue = attributeSet.getAttributeValue(null, "class");
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, WE5.Fragment);
        if (attributeValue == null) {
            attributeValue = typedArrayObtainStyledAttributes.getString(WE5.Fragment_android_name);
        }
        int resourceId = typedArrayObtainStyledAttributes.getResourceId(WE5.Fragment_android_id, -1);
        String string = typedArrayObtainStyledAttributes.getString(WE5.Fragment_android_tag);
        typedArrayObtainStyledAttributes.recycle();
        if (attributeValue == null || !o.b(context.getClassLoader(), attributeValue)) {
            return null;
        }
        int id = view != null ? view.getId() : 0;
        if (id == -1 && resourceId == -1 && string == null) {
            throw new IllegalArgumentException(attributeSet.getPositionDescription() + ": Must specify unique android:id, android:tag, or have a parent with an id for " + attributeValue);
        }
        Fragment fragmentO0 = resourceId != -1 ? this.a.o0(resourceId) : null;
        if (fragmentO0 == null && string != null) {
            fragmentO0 = this.a.p0(string);
        }
        if (fragmentO0 == null && id != -1) {
            fragmentO0 = this.a.o0(id);
        }
        if (fragmentO0 == null) {
            fragmentO0 = this.a.B0().a(context.getClassLoader(), attributeValue);
            fragmentO0.p = true;
            fragmentO0.z = resourceId != 0 ? resourceId : id;
            fragmentO0.A = id;
            fragmentO0.B = string;
            fragmentO0.q = true;
            FragmentManager fragmentManager = this.a;
            fragmentO0.v = fragmentManager;
            fragmentO0.w = fragmentManager.D0();
            fragmentO0.Y6(this.a.D0().k(), attributeSet, fragmentO0.b);
            uVarC = this.a.l(fragmentO0);
            if (FragmentManager.Q0(2)) {
                Log.v("FragmentManager", "Fragment " + fragmentO0 + " has been inflated via the <fragment> tag: id=0x" + Integer.toHexString(resourceId));
            }
        } else {
            if (fragmentO0.q) {
                throw new IllegalArgumentException(attributeSet.getPositionDescription() + ": Duplicate id 0x" + Integer.toHexString(resourceId) + ", tag " + string + ", or parent id 0x" + Integer.toHexString(id) + " with another fragment for " + attributeValue);
            }
            fragmentO0.q = true;
            FragmentManager fragmentManager2 = this.a;
            fragmentO0.v = fragmentManager2;
            fragmentO0.w = fragmentManager2.D0();
            fragmentO0.Y6(this.a.D0().k(), attributeSet, fragmentO0.b);
            uVarC = this.a.C(fragmentO0);
            if (FragmentManager.Q0(2)) {
                Log.v("FragmentManager", "Retained Fragment " + fragmentO0 + " has been re-attached via the <fragment> tag: id=0x" + Integer.toHexString(resourceId));
            }
        }
        ViewGroup viewGroup = (ViewGroup) view;
        C4404Ez2.g(fragmentO0, viewGroup);
        fragmentO0.A0 = viewGroup;
        uVarC.m();
        uVarC.j();
        View view2 = fragmentO0.B0;
        if (view2 == null) {
            throw new IllegalStateException("Fragment " + attributeValue + " did not create a view.");
        }
        if (resourceId != 0) {
            view2.setId(resourceId);
        }
        if (fragmentO0.B0.getTag() == null) {
            fragmentO0.B0.setTag(string);
        }
        fragmentO0.B0.addOnAttachStateChangeListener(new a(uVarC));
        return fragmentO0.B0;
    }
}
