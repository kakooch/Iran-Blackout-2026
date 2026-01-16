package kotlin.io;

import ir.nasim.AbstractC13042fc3;
import ir.nasim.AbstractC14861ic2;
import java.io.File;
import java.io.IOException;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000e\b\u0016\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0007\u0010\bR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0019\u0010\u0004\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\r\u0010\n\u001a\u0004\b\u000e\u0010\fR\u0019\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u0013"}, d2 = {"Lkotlin/io/FileSystemException;", "Ljava/io/IOException;", "Ljava/io/File;", "file", "other", "", "reason", "<init>", "(Ljava/io/File;Ljava/io/File;Ljava/lang/String;)V", "a", "Ljava/io/File;", "getFile", "()Ljava/io/File;", "b", "getOther", "c", "Ljava/lang/String;", "getReason", "()Ljava/lang/String;", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0})
/* loaded from: classes8.dex */
public class FileSystemException extends IOException {

    /* renamed from: a, reason: from kotlin metadata */
    private final File file;

    /* renamed from: b, reason: from kotlin metadata */
    private final File other;

    /* renamed from: c, reason: from kotlin metadata */
    private final String reason;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FileSystemException(File file, File file2, String str) {
        super(AbstractC14861ic2.b(file, file2, str));
        AbstractC13042fc3.i(file, "file");
        this.file = file;
        this.other = file2;
        this.reason = str;
    }
}
