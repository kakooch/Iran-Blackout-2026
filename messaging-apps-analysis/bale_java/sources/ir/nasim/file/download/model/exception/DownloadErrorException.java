package ir.nasim.file.download.model.exception;

import ir.nasim.AbstractC13042fc3;
import ir.nasim.EX1;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0000\u0018\u00002\u00060\u0001j\u0002`\u0002B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006R\u0017\u0010\u0004\u001a\u00020\u00038\u0006¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0007\u0010\t¨\u0006\n"}, d2 = {"Lir/nasim/file/download/model/exception/DownloadErrorException;", "Ljava/lang/Exception;", "Lkotlin/Exception;", "Lir/nasim/EX1;", "downloadError", "<init>", "(Lir/nasim/EX1;)V", "a", "Lir/nasim/EX1;", "()Lir/nasim/EX1;", "file_productionRelease"}, k = 1, mv = {2, 0, 0})
/* loaded from: classes6.dex */
public final class DownloadErrorException extends Exception {

    /* renamed from: a, reason: from kotlin metadata */
    private final EX1 downloadError;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DownloadErrorException(EX1 ex1) {
        super(ex1.toString());
        AbstractC13042fc3.i(ex1, "downloadError");
        this.downloadError = ex1;
    }

    /* renamed from: a, reason: from getter */
    public final EX1 getDownloadError() {
        return this.downloadError;
    }
}
