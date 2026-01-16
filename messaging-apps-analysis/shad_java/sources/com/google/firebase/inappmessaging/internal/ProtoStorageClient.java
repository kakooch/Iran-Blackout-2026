package com.google.firebase.inappmessaging.internal;

import android.app.Application;
import com.google.protobuf.AbstractMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Parser;
import io.reactivex.Completable;
import io.reactivex.Maybe;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.concurrent.Callable;

/* loaded from: classes3.dex */
public class ProtoStorageClient {
    private final Application application;
    private final String fileName;

    public ProtoStorageClient(Application application, String str) {
        this.application = application;
        this.fileName = str;
    }

    public Completable write(final AbstractMessageLite abstractMessageLite) {
        return Completable.fromCallable(new Callable() { // from class: com.google.firebase.inappmessaging.internal.ProtoStorageClient$$ExternalSyntheticLambda0
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return this.f$0.lambda$write$0(abstractMessageLite);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Object lambda$write$0(AbstractMessageLite abstractMessageLite) throws Exception {
        synchronized (this) {
            FileOutputStream fileOutputStreamOpenFileOutput = this.application.openFileOutput(this.fileName, 0);
            try {
                fileOutputStreamOpenFileOutput.write(abstractMessageLite.toByteArray());
                fileOutputStreamOpenFileOutput.close();
            } catch (Throwable th) {
                if (fileOutputStreamOpenFileOutput != null) {
                    try {
                        fileOutputStreamOpenFileOutput.close();
                    } catch (Throwable unused) {
                    }
                }
                throw th;
            }
        }
        return abstractMessageLite;
    }

    public <T extends AbstractMessageLite> Maybe<T> read(final Parser<T> parser) {
        return Maybe.fromCallable(new Callable() { // from class: com.google.firebase.inappmessaging.internal.ProtoStorageClient$$ExternalSyntheticLambda1
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return this.f$0.lambda$read$1(parser);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ AbstractMessageLite lambda$read$1(Parser parser) throws Exception {
        synchronized (this) {
            try {
                FileInputStream fileInputStreamOpenFileInput = this.application.openFileInput(this.fileName);
                try {
                    AbstractMessageLite abstractMessageLite = (AbstractMessageLite) parser.parseFrom(fileInputStreamOpenFileInput);
                    if (fileInputStreamOpenFileInput != null) {
                        fileInputStreamOpenFileInput.close();
                    }
                    return abstractMessageLite;
                } catch (Throwable th) {
                    if (fileInputStreamOpenFileInput != null) {
                        try {
                            fileInputStreamOpenFileInput.close();
                        } catch (Throwable unused) {
                        }
                    }
                    throw th;
                }
            } catch (InvalidProtocolBufferException | FileNotFoundException e) {
                Logging.logi("Recoverable exception while reading cache: " + e.getMessage());
                return null;
            }
        }
    }
}
