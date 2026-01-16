package ir.nasim;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.FIELD, ElementType.METHOD})
@Documented
@Retention(RetentionPolicy.RUNTIME)
/* renamed from: ir.nasim.xq6, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public @interface InterfaceC23984xq6 {
    String[] alternate() default {};

    String value();
}
