package ir.nasim.tgwidgets.editor.ui.Components.Paint;

import android.graphics.Color;
import android.opengl.GLES20;
import ir.nasim.AbstractC6403Nl2;
import ir.nasim.AbstractC8814Xl0;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes7.dex */
public class p {
    private int b;
    protected Map c = new HashMap();
    protected int a = GLES20.glCreateProgram();

    private static class a {
        int a;
        int b;

        a(int i, int i2) {
            this.a = i;
            this.b = i2;
        }
    }

    public p(String str, String str2, String[] strArr, String[] strArr2) {
        a aVarC = c(35633, str);
        if (aVarC.b == 0) {
            if (AbstractC8814Xl0.b) {
                AbstractC6403Nl2.b("Vertex shader compilation failed");
            }
            d(aVarC.a, 0, this.a);
            return;
        }
        a aVarC2 = c(35632, str2);
        if (aVarC2.b == 0) {
            if (AbstractC8814Xl0.b) {
                AbstractC6403Nl2.b("Fragment shader compilation failed");
            }
            d(aVarC.a, aVarC2.a, this.a);
            return;
        }
        GLES20.glAttachShader(this.a, aVarC.a);
        GLES20.glAttachShader(this.a, aVarC2.a);
        for (int i = 0; i < strArr.length; i++) {
            GLES20.glBindAttribLocation(this.a, i, strArr[i]);
        }
        if (f(this.a) == 0) {
            d(aVarC.a, aVarC2.a, this.a);
            return;
        }
        for (String str3 : strArr2) {
            this.c.put(str3, Integer.valueOf(GLES20.glGetUniformLocation(this.a, str3)));
        }
        int i2 = aVarC.a;
        if (i2 != 0) {
            GLES20.glDeleteShader(i2);
        }
        int i3 = aVarC2.a;
        if (i3 != 0) {
            GLES20.glDeleteShader(i3);
        }
    }

    public static void a(int i, int i2) {
        GLES20.glUniform4f(i, Color.red(i2) / 255.0f, Color.green(i2) / 255.0f, Color.blue(i2) / 255.0f, Color.alpha(i2) / 255.0f);
    }

    private a c(int i, String str) {
        int iGlCreateShader = GLES20.glCreateShader(i);
        GLES20.glShaderSource(iGlCreateShader, str);
        GLES20.glCompileShader(iGlCreateShader);
        int[] iArr = new int[1];
        GLES20.glGetShaderiv(iGlCreateShader, 35713, iArr, 0);
        if (iArr[0] == 0 && AbstractC8814Xl0.b) {
            AbstractC6403Nl2.b(GLES20.glGetShaderInfoLog(iGlCreateShader));
        }
        return new a(iGlCreateShader, iArr[0]);
    }

    private void d(int i, int i2, int i3) {
        if (i != 0) {
            GLES20.glDeleteShader(i);
        }
        if (i2 != 0) {
            GLES20.glDeleteShader(i2);
        }
        if (i3 != 0) {
            GLES20.glDeleteProgram(i);
        }
    }

    private int f(int i) {
        GLES20.glLinkProgram(i);
        int[] iArr = new int[1];
        GLES20.glGetProgramiv(i, 35714, iArr, 0);
        if (iArr[0] == 0 && AbstractC8814Xl0.b) {
            AbstractC6403Nl2.b(GLES20.glGetProgramInfoLog(i));
        }
        return iArr[0];
    }

    public void b() {
        if (this.a != 0) {
            GLES20.glDeleteProgram(this.b);
            this.a = 0;
        }
    }

    public int e(String str) {
        return ((Integer) this.c.get(str)).intValue();
    }
}
