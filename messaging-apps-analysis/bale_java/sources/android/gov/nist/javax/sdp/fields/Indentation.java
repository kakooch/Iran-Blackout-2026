package android.gov.nist.javax.sdp.fields;

import java.util.Arrays;

/* loaded from: classes.dex */
class Indentation {
    private int indentation;

    protected Indentation() {
        this.indentation = 0;
    }

    protected void decrement() {
        this.indentation--;
    }

    protected int getCount() {
        return this.indentation;
    }

    protected String getIndentation() {
        char[] cArr = new char[this.indentation];
        Arrays.fill(cArr, ' ');
        return new String(cArr);
    }

    protected void increment() {
        this.indentation++;
    }

    protected void setIndentation(int i) {
        this.indentation = i;
    }

    protected Indentation(int i) {
        this.indentation = i;
    }
}
