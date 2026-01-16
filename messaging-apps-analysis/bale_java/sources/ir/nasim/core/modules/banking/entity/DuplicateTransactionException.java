package ir.nasim.core.modules.banking.entity;

/* loaded from: classes5.dex */
public class DuplicateTransactionException extends Exception {
    private int a;

    public DuplicateTransactionException(String str, int i) {
        super(str);
        this.a = i;
    }

    public int a() {
        return this.a;
    }
}
