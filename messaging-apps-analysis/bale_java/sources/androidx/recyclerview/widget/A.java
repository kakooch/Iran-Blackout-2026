package androidx.recyclerview.widget;

import ai.bale.proto.SetRpcStruct$ComposedRpc;
import android.view.View;

/* loaded from: classes2.dex */
class A {
    final b a;
    a b = new a();

    static class a {
        int a = 0;
        int b;
        int c;
        int d;
        int e;

        a() {
        }

        void a(int i) {
            this.a = i | this.a;
        }

        boolean b() {
            int i = this.a;
            if ((i & 7) != 0 && (i & c(this.d, this.b)) == 0) {
                return false;
            }
            int i2 = this.a;
            if ((i2 & SetRpcStruct$ComposedRpc.SEARCH_CONTACTS_FIELD_NUMBER) != 0 && (i2 & (c(this.d, this.c) << 4)) == 0) {
                return false;
            }
            int i3 = this.a;
            if ((i3 & 1792) != 0 && (i3 & (c(this.e, this.b) << 8)) == 0) {
                return false;
            }
            int i4 = this.a;
            return (i4 & 28672) == 0 || (i4 & (c(this.e, this.c) << 12)) != 0;
        }

        int c(int i, int i2) {
            if (i > i2) {
                return 1;
            }
            return i == i2 ? 2 : 4;
        }

        void d() {
            this.a = 0;
        }

        void e(int i, int i2, int i3, int i4) {
            this.b = i;
            this.c = i2;
            this.d = i3;
            this.e = i4;
        }
    }

    interface b {
        View a(int i);

        int b(View view);

        int c();

        int d();

        int e(View view);
    }

    A(b bVar) {
        this.a = bVar;
    }

    View a(int i, int i2, int i3, int i4) {
        int iC = this.a.c();
        int iD = this.a.d();
        int i5 = i2 > i ? 1 : -1;
        View view = null;
        while (i != i2) {
            View viewA = this.a.a(i);
            this.b.e(iC, iD, this.a.b(viewA), this.a.e(viewA));
            if (i3 != 0) {
                this.b.d();
                this.b.a(i3);
                if (this.b.b()) {
                    return viewA;
                }
            }
            if (i4 != 0) {
                this.b.d();
                this.b.a(i4);
                if (this.b.b()) {
                    view = viewA;
                }
            }
            i += i5;
        }
        return view;
    }

    boolean b(View view, int i) {
        this.b.e(this.a.c(), this.a.d(), this.a.b(view), this.a.e(view));
        if (i == 0) {
            return false;
        }
        this.b.d();
        this.b.a(i);
        return this.b.b();
    }
}
