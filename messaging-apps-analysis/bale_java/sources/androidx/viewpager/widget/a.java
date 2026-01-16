package androidx.viewpager.widget;

import android.database.DataSetObservable;
import android.database.DataSetObserver;
import android.os.Parcelable;
import android.view.View;
import android.view.ViewGroup;

/* loaded from: classes2.dex */
public abstract class a {
    private final DataSetObservable a = new DataSetObservable();
    private DataSetObserver b;

    public abstract void a(ViewGroup viewGroup, int i, Object obj);

    public void b(View view) {
    }

    public void c(ViewGroup viewGroup) {
        b(viewGroup);
    }

    public abstract int d();

    public abstract int e(Object obj);

    public CharSequence f(int i) {
        return null;
    }

    public float g(int i) {
        return 1.0f;
    }

    public abstract Object h(ViewGroup viewGroup, int i);

    public abstract boolean i(View view, Object obj);

    public void j() {
        synchronized (this) {
            try {
                DataSetObserver dataSetObserver = this.b;
                if (dataSetObserver != null) {
                    dataSetObserver.onChanged();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        this.a.notifyChanged();
    }

    public void k(DataSetObserver dataSetObserver) {
        this.a.registerObserver(dataSetObserver);
    }

    public abstract void l(Parcelable parcelable, ClassLoader classLoader);

    public abstract Parcelable m();

    public void n(View view, int i, Object obj) {
    }

    public void o(ViewGroup viewGroup, int i, Object obj) {
        n(viewGroup, i, obj);
    }

    void p(DataSetObserver dataSetObserver) {
        synchronized (this) {
            this.b = dataSetObserver;
        }
    }

    public void q(View view) {
    }

    public void r(ViewGroup viewGroup) {
        q(viewGroup);
    }

    public void s(DataSetObserver dataSetObserver) {
        this.a.unregisterObserver(dataSetObserver);
    }
}
