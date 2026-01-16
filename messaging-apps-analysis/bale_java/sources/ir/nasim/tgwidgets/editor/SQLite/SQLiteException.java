package ir.nasim.tgwidgets.editor.SQLite;

/* loaded from: classes7.dex */
public class SQLiteException extends Exception {
    public final int a;

    public SQLiteException(int i, String str) {
        super(str);
        this.a = i;
    }

    public SQLiteException(String str) {
        this(0, str);
    }

    public SQLiteException() {
        this.a = 0;
    }
}
