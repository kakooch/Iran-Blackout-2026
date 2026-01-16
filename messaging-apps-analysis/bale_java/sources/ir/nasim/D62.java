package ir.nasim;

import android.text.InputFilter;
import android.text.method.PasswordTransformationMethod;
import android.text.method.TransformationMethod;
import android.util.SparseArray;
import android.widget.TextView;

/* loaded from: classes2.dex */
public final class D62 {
    private final b a;

    private static class a extends b {
        private final TextView a;
        private final Z52 b;
        private boolean c = true;

        a(TextView textView) {
            this.a = textView;
            this.b = new Z52(textView);
        }

        private InputFilter[] f(InputFilter[] inputFilterArr) {
            int length = inputFilterArr.length;
            for (InputFilter inputFilter : inputFilterArr) {
                if (inputFilter == this.b) {
                    return inputFilterArr;
                }
            }
            InputFilter[] inputFilterArr2 = new InputFilter[inputFilterArr.length + 1];
            System.arraycopy(inputFilterArr, 0, inputFilterArr2, 0, length);
            inputFilterArr2[length] = this.b;
            return inputFilterArr2;
        }

        private SparseArray g(InputFilter[] inputFilterArr) {
            SparseArray sparseArray = new SparseArray(1);
            for (int i = 0; i < inputFilterArr.length; i++) {
                InputFilter inputFilter = inputFilterArr[i];
                if (inputFilter instanceof Z52) {
                    sparseArray.put(i, inputFilter);
                }
            }
            return sparseArray;
        }

        private InputFilter[] h(InputFilter[] inputFilterArr) {
            SparseArray sparseArrayG = g(inputFilterArr);
            if (sparseArrayG.size() == 0) {
                return inputFilterArr;
            }
            int length = inputFilterArr.length;
            InputFilter[] inputFilterArr2 = new InputFilter[inputFilterArr.length - sparseArrayG.size()];
            int i = 0;
            for (int i2 = 0; i2 < length; i2++) {
                if (sparseArrayG.indexOfKey(i2) < 0) {
                    inputFilterArr2[i] = inputFilterArr[i2];
                    i++;
                }
            }
            return inputFilterArr2;
        }

        private TransformationMethod j(TransformationMethod transformationMethod) {
            return transformationMethod instanceof G62 ? ((G62) transformationMethod).a() : transformationMethod;
        }

        private void k() {
            this.a.setFilters(a(this.a.getFilters()));
        }

        private TransformationMethod m(TransformationMethod transformationMethod) {
            return ((transformationMethod instanceof G62) || (transformationMethod instanceof PasswordTransformationMethod)) ? transformationMethod : new G62(transformationMethod);
        }

        @Override // ir.nasim.D62.b
        InputFilter[] a(InputFilter[] inputFilterArr) {
            return !this.c ? h(inputFilterArr) : f(inputFilterArr);
        }

        @Override // ir.nasim.D62.b
        public boolean b() {
            return this.c;
        }

        @Override // ir.nasim.D62.b
        void c(boolean z) {
            if (z) {
                l();
            }
        }

        @Override // ir.nasim.D62.b
        void d(boolean z) {
            this.c = z;
            l();
            k();
        }

        @Override // ir.nasim.D62.b
        TransformationMethod e(TransformationMethod transformationMethod) {
            return this.c ? m(transformationMethod) : j(transformationMethod);
        }

        void i(boolean z) {
            this.c = z;
        }

        void l() {
            this.a.setTransformationMethod(e(this.a.getTransformationMethod()));
        }
    }

    static class b {
        b() {
        }

        abstract InputFilter[] a(InputFilter[] inputFilterArr);

        public abstract boolean b();

        abstract void c(boolean z);

        abstract void d(boolean z);

        abstract TransformationMethod e(TransformationMethod transformationMethod);
    }

    private static class c extends b {
        private final a a;

        c(TextView textView) {
            this.a = new a(textView);
        }

        private boolean f() {
            return !androidx.emoji2.text.e.k();
        }

        @Override // ir.nasim.D62.b
        InputFilter[] a(InputFilter[] inputFilterArr) {
            return f() ? inputFilterArr : this.a.a(inputFilterArr);
        }

        @Override // ir.nasim.D62.b
        public boolean b() {
            return this.a.b();
        }

        @Override // ir.nasim.D62.b
        void c(boolean z) {
            if (f()) {
                return;
            }
            this.a.c(z);
        }

        @Override // ir.nasim.D62.b
        void d(boolean z) {
            if (f()) {
                this.a.i(z);
            } else {
                this.a.d(z);
            }
        }

        @Override // ir.nasim.D62.b
        TransformationMethod e(TransformationMethod transformationMethod) {
            return f() ? transformationMethod : this.a.e(transformationMethod);
        }
    }

    public D62(TextView textView, boolean z) {
        AbstractC4980Hj5.h(textView, "textView cannot be null");
        if (z) {
            this.a = new a(textView);
        } else {
            this.a = new c(textView);
        }
    }

    public InputFilter[] a(InputFilter[] inputFilterArr) {
        return this.a.a(inputFilterArr);
    }

    public boolean b() {
        return this.a.b();
    }

    public void c(boolean z) {
        this.a.c(z);
    }

    public void d(boolean z) {
        this.a.d(z);
    }

    public TransformationMethod e(TransformationMethod transformationMethod) {
        return this.a.e(transformationMethod);
    }
}
