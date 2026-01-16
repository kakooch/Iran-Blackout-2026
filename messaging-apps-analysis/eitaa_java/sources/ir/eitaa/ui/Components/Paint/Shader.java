package ir.eitaa.ui.Components.Paint;

import android.graphics.Color;
import android.opengl.GLES20;
import ir.eitaa.messenger.BuildVars;
import ir.eitaa.messenger.FileLog;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes3.dex */
public class Shader {
    private int vertexShader;
    protected Map<String, Integer> uniformsMap = new HashMap();
    protected int program = GLES20.glCreateProgram();

    public Shader(String vertexShader, String fragmentShader, String[] attributes, String[] uniforms) {
        CompilationResult compilationResultCompileShader = compileShader(35633, vertexShader);
        if (compilationResultCompileShader.status == 0) {
            if (BuildVars.LOGS_ENABLED) {
                FileLog.e("Vertex shader compilation failed");
            }
            destroyShader(compilationResultCompileShader.shader, 0, this.program);
            return;
        }
        CompilationResult compilationResultCompileShader2 = compileShader(35632, fragmentShader);
        if (compilationResultCompileShader2.status == 0) {
            if (BuildVars.LOGS_ENABLED) {
                FileLog.e("Fragment shader compilation failed");
            }
            destroyShader(compilationResultCompileShader.shader, compilationResultCompileShader2.shader, this.program);
            return;
        }
        GLES20.glAttachShader(this.program, compilationResultCompileShader.shader);
        GLES20.glAttachShader(this.program, compilationResultCompileShader2.shader);
        for (int i = 0; i < attributes.length; i++) {
            GLES20.glBindAttribLocation(this.program, i, attributes[i]);
        }
        if (linkProgram(this.program) == 0) {
            destroyShader(compilationResultCompileShader.shader, compilationResultCompileShader2.shader, this.program);
            return;
        }
        for (String str : uniforms) {
            this.uniformsMap.put(str, Integer.valueOf(GLES20.glGetUniformLocation(this.program, str)));
        }
        int i2 = compilationResultCompileShader.shader;
        if (i2 != 0) {
            GLES20.glDeleteShader(i2);
        }
        int i3 = compilationResultCompileShader2.shader;
        if (i3 != 0) {
            GLES20.glDeleteShader(i3);
        }
    }

    public void cleanResources() {
        if (this.program != 0) {
            GLES20.glDeleteProgram(this.vertexShader);
            this.program = 0;
        }
    }

    private static class CompilationResult {
        int shader;
        int status;

        CompilationResult(int shader, int status) {
            this.shader = shader;
            this.status = status;
        }
    }

    public int getUniform(String key) {
        return this.uniformsMap.get(key).intValue();
    }

    private CompilationResult compileShader(int type, String shaderCode) {
        int iGlCreateShader = GLES20.glCreateShader(type);
        GLES20.glShaderSource(iGlCreateShader, shaderCode);
        GLES20.glCompileShader(iGlCreateShader);
        int[] iArr = new int[1];
        GLES20.glGetShaderiv(iGlCreateShader, 35713, iArr, 0);
        if (iArr[0] == 0 && BuildVars.LOGS_ENABLED) {
            FileLog.e(GLES20.glGetShaderInfoLog(iGlCreateShader));
        }
        return new CompilationResult(iGlCreateShader, iArr[0]);
    }

    private int linkProgram(int program) {
        GLES20.glLinkProgram(program);
        int[] iArr = new int[1];
        GLES20.glGetProgramiv(program, 35714, iArr, 0);
        if (iArr[0] == 0 && BuildVars.LOGS_ENABLED) {
            FileLog.e(GLES20.glGetProgramInfoLog(program));
        }
        return iArr[0];
    }

    private void destroyShader(int vertexShader, int fragmentShader, int program) {
        if (vertexShader != 0) {
            GLES20.glDeleteShader(vertexShader);
        }
        if (fragmentShader != 0) {
            GLES20.glDeleteShader(fragmentShader);
        }
        if (program != 0) {
            GLES20.glDeleteProgram(vertexShader);
        }
    }

    public static void SetColorUniform(int location, int color) {
        GLES20.glUniform4f(location, Color.red(color) / 255.0f, Color.green(color) / 255.0f, Color.blue(color) / 255.0f, Color.alpha(color) / 255.0f);
    }
}
