package ir.nasim;

/* loaded from: classes.dex */
public interface ZQ7 {
    boolean a();

    long b(AbstractC8151Ut abstractC8151Ut, AbstractC8151Ut abstractC8151Ut2, AbstractC8151Ut abstractC8151Ut3);

    AbstractC8151Ut c(long j, AbstractC8151Ut abstractC8151Ut, AbstractC8151Ut abstractC8151Ut2, AbstractC8151Ut abstractC8151Ut3);

    AbstractC8151Ut f(long j, AbstractC8151Ut abstractC8151Ut, AbstractC8151Ut abstractC8151Ut2, AbstractC8151Ut abstractC8151Ut3);

    default AbstractC8151Ut g(AbstractC8151Ut abstractC8151Ut, AbstractC8151Ut abstractC8151Ut2, AbstractC8151Ut abstractC8151Ut3) {
        return f(b(abstractC8151Ut, abstractC8151Ut2, abstractC8151Ut3), abstractC8151Ut, abstractC8151Ut2, abstractC8151Ut3);
    }
}
