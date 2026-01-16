package com.google.android.material.navigation;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.appcompat.view.menu.e;
import androidx.appcompat.view.menu.g;
import androidx.appcompat.view.menu.j;
import androidx.appcompat.view.menu.m;
import com.google.android.material.badge.b;
import com.google.android.material.internal.ParcelableSparseArray;

/* loaded from: classes3.dex */
public class NavigationBarPresenter implements j {
    private e a;
    private NavigationBarMenuView b;
    private boolean c = false;
    private int d;

    static class SavedState implements Parcelable {
        public static final Parcelable.Creator<SavedState> CREATOR = new a();
        int a;
        ParcelableSparseArray b;

        class a implements Parcelable.Creator {
            a() {
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        }

        SavedState() {
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(this.a);
            parcel.writeParcelable(this.b, 0);
        }

        SavedState(Parcel parcel) {
            this.a = parcel.readInt();
            this.b = (ParcelableSparseArray) parcel.readParcelable(getClass().getClassLoader());
        }
    }

    public void a(int i) {
        this.d = i;
    }

    public void b(NavigationBarMenuView navigationBarMenuView) {
        this.b = navigationBarMenuView;
    }

    @Override // androidx.appcompat.view.menu.j
    public void c(e eVar, boolean z) {
    }

    @Override // androidx.appcompat.view.menu.j
    public boolean d(e eVar, g gVar) {
        return false;
    }

    @Override // androidx.appcompat.view.menu.j
    public void f(Parcelable parcelable) {
        if (parcelable instanceof SavedState) {
            SavedState savedState = (SavedState) parcelable;
            this.b.l(savedState.a);
            this.b.k(b.b(this.b.getContext(), savedState.b));
        }
    }

    @Override // androidx.appcompat.view.menu.j
    public boolean g(m mVar) {
        return false;
    }

    @Override // androidx.appcompat.view.menu.j
    public int getId() {
        return this.d;
    }

    @Override // androidx.appcompat.view.menu.j
    public Parcelable h() {
        SavedState savedState = new SavedState();
        savedState.a = this.b.getSelectedItemId();
        savedState.b = b.c(this.b.getBadgeDrawables());
        return savedState;
    }

    @Override // androidx.appcompat.view.menu.j
    public void i(boolean z) {
        if (this.c) {
            return;
        }
        if (z) {
            this.b.d();
        } else {
            this.b.m();
        }
    }

    @Override // androidx.appcompat.view.menu.j
    public boolean j() {
        return false;
    }

    @Override // androidx.appcompat.view.menu.j
    public boolean k(e eVar, g gVar) {
        return false;
    }

    @Override // androidx.appcompat.view.menu.j
    public void l(Context context, e eVar) {
        this.a = eVar;
        this.b.a(eVar);
    }

    public void m(boolean z) {
        this.c = z;
    }
}
