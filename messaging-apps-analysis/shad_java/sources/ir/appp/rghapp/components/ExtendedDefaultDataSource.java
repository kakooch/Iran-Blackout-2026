package ir.appp.rghapp.components;

import android.content.Context;
import android.net.Uri;
import com.google.android.exoplayer2.upstream.AssetDataSource;
import com.google.android.exoplayer2.upstream.ContentDataSource;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.DataSpec;
import com.google.android.exoplayer2.upstream.FileDataSource;
import com.google.android.exoplayer2.upstream.TransferListener;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Util;
import ir.appp.rghapp.rubinoPostSlider.FileLoadOperationStream;
import java.io.IOException;
import java.util.Collections;
import java.util.Map;

/* loaded from: classes3.dex */
public final class ExtendedDefaultDataSource implements DataSource {
    private final DataSource assetDataSource;
    private final DataSource baseDataSource;
    private final DataSource contentDataSource;
    private DataSource dataSource;
    private final DataSource fileDataSource;
    private TransferListener listener;

    @Override // com.google.android.exoplayer2.upstream.DataSource
    public void addTransferListener(TransferListener transferListener) {
    }

    @Override // com.google.android.exoplayer2.upstream.DataSource
    public /* synthetic */ Map getResponseHeaders() {
        return Collections.emptyMap();
    }

    public ExtendedDefaultDataSource(Context context, TransferListener transferListener, DataSource dataSource) {
        this.baseDataSource = (DataSource) Assertions.checkNotNull(dataSource);
        FileDataSource fileDataSource = new FileDataSource();
        this.fileDataSource = fileDataSource;
        fileDataSource.addTransferListener(transferListener);
        AssetDataSource assetDataSource = new AssetDataSource(context);
        this.assetDataSource = assetDataSource;
        assetDataSource.addTransferListener(transferListener);
        ContentDataSource contentDataSource = new ContentDataSource(context);
        this.contentDataSource = contentDataSource;
        contentDataSource.addTransferListener(transferListener);
        this.listener = transferListener;
    }

    @Override // com.google.android.exoplayer2.upstream.DataSource
    public long open(DataSpec dataSpec) throws IOException {
        Assertions.checkState(this.dataSource == null);
        String scheme = dataSpec.uri.getScheme();
        if (Util.isLocalFileUri(dataSpec.uri)) {
            if (dataSpec.uri.getPath().startsWith("/android_asset/")) {
                this.dataSource = this.assetDataSource;
            } else if (!dataSpec.uri.getPath().endsWith(".enc")) {
                this.dataSource = this.fileDataSource;
            }
        } else if (!"tg".equals(scheme)) {
            if ("ru".equals(scheme)) {
                this.dataSource = new FileLoadOperationStream(this.listener);
            } else if ("asset".equals(scheme)) {
                this.dataSource = this.assetDataSource;
            } else if ("content".equals(scheme)) {
                this.dataSource = this.contentDataSource;
            } else {
                this.dataSource = this.baseDataSource;
            }
        }
        return this.dataSource.open(dataSpec);
    }

    @Override // com.google.android.exoplayer2.upstream.DataReader
    public int read(byte[] bArr, int i, int i2) throws IOException {
        return this.dataSource.read(bArr, i, i2);
    }

    @Override // com.google.android.exoplayer2.upstream.DataSource
    public Uri getUri() {
        DataSource dataSource = this.dataSource;
        if (dataSource == null) {
            return null;
        }
        return dataSource.getUri();
    }

    @Override // com.google.android.exoplayer2.upstream.DataSource
    public void close() throws IOException {
        DataSource dataSource = this.dataSource;
        if (dataSource != null) {
            try {
                dataSource.close();
            } finally {
                this.dataSource = null;
            }
        }
    }
}
