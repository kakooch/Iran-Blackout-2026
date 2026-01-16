package ir.resaneh1.iptv.helper;

import android.text.method.PasswordTransformationMethod;
import android.view.View;

/* loaded from: classes3.dex */
public class AsteriskPasswordTransformationMethod extends PasswordTransformationMethod {
    @Override // android.text.method.PasswordTransformationMethod, android.text.method.TransformationMethod
    public CharSequence getTransformation(CharSequence charSequence, View view) {
        return new PasswordCharSequence(this, charSequence);
    }

    private class PasswordCharSequence implements CharSequence {
        private CharSequence mSource;

        @Override // java.lang.CharSequence
        public char charAt(int i) {
            return '*';
        }

        public PasswordCharSequence(AsteriskPasswordTransformationMethod asteriskPasswordTransformationMethod, CharSequence charSequence) {
            this.mSource = charSequence;
        }

        @Override // java.lang.CharSequence
        public int length() {
            return this.mSource.length();
        }

        @Override // java.lang.CharSequence
        public CharSequence subSequence(int i, int i2) {
            return this.mSource.subSequence(i, i2);
        }
    }
}
