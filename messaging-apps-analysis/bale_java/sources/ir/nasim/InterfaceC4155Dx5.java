package ir.nasim;

/* renamed from: ir.nasim.Dx5, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public @interface InterfaceC4155Dx5 {

    /* renamed from: ir.nasim.Dx5$a */
    public enum a {
        DEFAULT,
        SIGNED,
        FIXED
    }

    a intEncoding() default a.DEFAULT;

    int tag();
}
