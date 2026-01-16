package ir.nasim.core.runtime.markdown.html;

import ir.nasim.EnumC16603lZ2;

/* loaded from: classes5.dex */
public class HtmlValidationException extends RuntimeException {
    private EnumC16603lZ2 a;
    private String b;

    HtmlValidationException(EnumC16603lZ2 enumC16603lZ2, String str) {
        this.a = enumC16603lZ2;
        this.b = str;
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        return this.a.getValue() + this.b;
    }
}
