package kotlin.jvm.internal;

import java.io.Serializable;

/* compiled from: Lambda.kt */
/* loaded from: classes.dex */
public abstract class Lambda<R> implements FunctionBase<R>, Serializable {
    private final int arity;

    public Lambda(int i) {
        this.arity = i;
    }

    public String toString() {
        String strRenderLambdaToString = Reflection.renderLambdaToString(this);
        Intrinsics.checkNotNullExpressionValue(strRenderLambdaToString, "renderLambdaToString(this)");
        return strRenderLambdaToString;
    }
}
