package ir.eitaa.messenger;

import android.content.SharedPreferences;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.lang.reflect.Array;

/* loaded from: classes.dex */
public class StatsController extends BaseController {
    private static final int TYPES_COUNT = 7;
    public static final int TYPE_AUDIOS = 3;
    public static final int TYPE_CALLS = 0;
    public static final int TYPE_FILES = 5;
    public static final int TYPE_MESSAGES = 1;
    public static final int TYPE_MOBILE = 0;
    public static final int TYPE_PHOTOS = 4;
    public static final int TYPE_ROAMING = 2;
    public static final int TYPE_TOTAL = 6;
    public static final int TYPE_VIDEOS = 2;
    public static final int TYPE_WIFI = 1;
    private byte[] buffer;
    private int[] callsTotalTime;
    private long lastInternalStatsSaveTime;
    private long[][] receivedBytes;
    private int[][] receivedItems;
    private long[] resetStatsDate;
    private Runnable saveRunnable;
    private long[][] sentBytes;
    private int[][] sentItems;
    private RandomAccessFile statsFile;
    private static DispatchQueue statsSaveQueue = new DispatchQueue("statsSaveQueue");
    private static final ThreadLocal<Long> lastStatsSaveTime = new ThreadLocal<Long>() { // from class: ir.eitaa.messenger.StatsController.1
        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.lang.ThreadLocal
        public Long initialValue() {
            return Long.valueOf(System.currentTimeMillis() - 1000);
        }
    };
    private static volatile StatsController[] Instance = new StatsController[3];

    /* JADX INFO: Access modifiers changed from: private */
    public byte[] intToBytes(int value) {
        byte[] bArr = this.buffer;
        bArr[0] = (byte) (value >>> 24);
        bArr[1] = (byte) (value >>> 16);
        bArr[2] = (byte) (value >>> 8);
        bArr[3] = (byte) value;
        return bArr;
    }

    private int bytesToInt(byte[] bytes) {
        return (bytes[3] & 255) | (bytes[0] << 24) | ((bytes[1] & 255) << 16) | ((bytes[2] & 255) << 8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public byte[] longToBytes(long value) {
        byte[] bArr = this.buffer;
        bArr[0] = (byte) (value >>> 56);
        bArr[1] = (byte) (value >>> 48);
        bArr[2] = (byte) (value >>> 40);
        bArr[3] = (byte) (value >>> 32);
        bArr[4] = (byte) (value >>> 24);
        bArr[5] = (byte) (value >>> 16);
        bArr[6] = (byte) (value >>> 8);
        bArr[7] = (byte) value;
        return bArr;
    }

    private long bytesToLong(byte[] bytes) {
        return ((bytes[0] & 255) << 56) | ((bytes[1] & 255) << 48) | ((bytes[2] & 255) << 40) | ((bytes[3] & 255) << 32) | ((bytes[4] & 255) << 24) | ((bytes[5] & 255) << 16) | ((bytes[6] & 255) << 8) | (255 & bytes[7]);
    }

    public static StatsController getInstance(int num) {
        StatsController statsController = Instance[num];
        if (statsController == null) {
            synchronized (StatsController.class) {
                statsController = Instance[num];
                if (statsController == null) {
                    StatsController[] statsControllerArr = Instance;
                    StatsController statsController2 = new StatsController(num);
                    statsControllerArr[num] = statsController2;
                    statsController = statsController2;
                }
            }
        }
        return statsController;
    }

    private StatsController(int account) throws IOException {
        boolean z;
        SharedPreferences sharedPreferences;
        RandomAccessFile randomAccessFile;
        super(account);
        this.buffer = new byte[8];
        this.sentBytes = (long[][]) Array.newInstance((Class<?>) long.class, 3, 7);
        this.receivedBytes = (long[][]) Array.newInstance((Class<?>) long.class, 3, 7);
        this.sentItems = (int[][]) Array.newInstance((Class<?>) int.class, 3, 7);
        this.receivedItems = (int[][]) Array.newInstance((Class<?>) int.class, 3, 7);
        this.resetStatsDate = new long[3];
        this.callsTotalTime = new int[3];
        this.saveRunnable = new Runnable() { // from class: ir.eitaa.messenger.StatsController.2
            @Override // java.lang.Runnable
            public void run() throws IOException {
                long jCurrentTimeMillis = System.currentTimeMillis();
                if (Math.abs(jCurrentTimeMillis - StatsController.this.lastInternalStatsSaveTime) < 2000) {
                    return;
                }
                StatsController.this.lastInternalStatsSaveTime = jCurrentTimeMillis;
                try {
                    StatsController.this.statsFile.seek(0L);
                    for (int i = 0; i < 3; i++) {
                        for (int i2 = 0; i2 < 7; i2++) {
                            RandomAccessFile randomAccessFile2 = StatsController.this.statsFile;
                            StatsController statsController = StatsController.this;
                            randomAccessFile2.write(statsController.longToBytes(statsController.sentBytes[i][i2]), 0, 8);
                            RandomAccessFile randomAccessFile3 = StatsController.this.statsFile;
                            StatsController statsController2 = StatsController.this;
                            randomAccessFile3.write(statsController2.longToBytes(statsController2.receivedBytes[i][i2]), 0, 8);
                            RandomAccessFile randomAccessFile4 = StatsController.this.statsFile;
                            StatsController statsController3 = StatsController.this;
                            randomAccessFile4.write(statsController3.intToBytes(statsController3.sentItems[i][i2]), 0, 4);
                            RandomAccessFile randomAccessFile5 = StatsController.this.statsFile;
                            StatsController statsController4 = StatsController.this;
                            randomAccessFile5.write(statsController4.intToBytes(statsController4.receivedItems[i][i2]), 0, 4);
                        }
                        RandomAccessFile randomAccessFile6 = StatsController.this.statsFile;
                        StatsController statsController5 = StatsController.this;
                        randomAccessFile6.write(statsController5.intToBytes(statsController5.callsTotalTime[i]), 0, 4);
                        RandomAccessFile randomAccessFile7 = StatsController.this.statsFile;
                        StatsController statsController6 = StatsController.this;
                        randomAccessFile7.write(statsController6.longToBytes(statsController6.resetStatsDate[i]), 0, 8);
                    }
                    StatsController.this.statsFile.getFD().sync();
                } catch (Exception unused) {
                }
            }
        };
        File filesDirFixed = ApplicationLoader.getFilesDirFixed();
        if (account != 0) {
            filesDirFixed = new File(ApplicationLoader.getFilesDirFixed(), "account" + account + "/");
            filesDirFixed.mkdirs();
        }
        try {
            randomAccessFile = new RandomAccessFile(new File(filesDirFixed, "stats2.dat"), "rw");
            this.statsFile = randomAccessFile;
        } catch (Exception unused) {
        }
        if (randomAccessFile.length() > 0) {
            boolean z2 = false;
            for (int i = 0; i < 3; i++) {
                for (int i2 = 0; i2 < 7; i2++) {
                    this.statsFile.readFully(this.buffer, 0, 8);
                    this.sentBytes[i][i2] = bytesToLong(this.buffer);
                    this.statsFile.readFully(this.buffer, 0, 8);
                    this.receivedBytes[i][i2] = bytesToLong(this.buffer);
                    this.statsFile.readFully(this.buffer, 0, 4);
                    this.sentItems[i][i2] = bytesToInt(this.buffer);
                    this.statsFile.readFully(this.buffer, 0, 4);
                    this.receivedItems[i][i2] = bytesToInt(this.buffer);
                }
                this.statsFile.readFully(this.buffer, 0, 4);
                this.callsTotalTime[i] = bytesToInt(this.buffer);
                this.statsFile.readFully(this.buffer, 0, 8);
                this.resetStatsDate[i] = bytesToLong(this.buffer);
                long[] jArr = this.resetStatsDate;
                if (jArr[i] == 0) {
                    jArr[i] = System.currentTimeMillis();
                    z2 = true;
                }
            }
            if (z2) {
                saveStats();
            }
            z = false;
        } else {
            z = true;
        }
        if (z) {
            if (account == 0) {
                sharedPreferences = ApplicationLoader.applicationContext.getSharedPreferences("stats", 0);
            } else {
                sharedPreferences = ApplicationLoader.applicationContext.getSharedPreferences("stats" + account, 0);
            }
            boolean z3 = false;
            for (int i3 = 0; i3 < 3; i3++) {
                this.callsTotalTime[i3] = sharedPreferences.getInt("callsTotalTime" + i3, 0);
                this.resetStatsDate[i3] = sharedPreferences.getLong("resetStatsDate" + i3, 0L);
                for (int i4 = 0; i4 < 7; i4++) {
                    this.sentBytes[i3][i4] = sharedPreferences.getLong("sentBytes" + i3 + "_" + i4, 0L);
                    this.receivedBytes[i3][i4] = sharedPreferences.getLong("receivedBytes" + i3 + "_" + i4, 0L);
                    this.sentItems[i3][i4] = sharedPreferences.getInt("sentItems" + i3 + "_" + i4, 0);
                    this.receivedItems[i3][i4] = sharedPreferences.getInt("receivedItems" + i3 + "_" + i4, 0);
                }
                long[] jArr2 = this.resetStatsDate;
                if (jArr2[i3] == 0) {
                    jArr2[i3] = System.currentTimeMillis();
                    z3 = true;
                }
            }
            if (z3) {
                saveStats();
            }
        }
    }

    public void incrementReceivedItemsCount(int networkType, int dataType, int value) {
        int[] iArr = this.receivedItems[networkType];
        iArr[dataType] = iArr[dataType] + value;
        saveStats();
    }

    public void incrementSentItemsCount(int networkType, int dataType, int value) {
        int[] iArr = this.sentItems[networkType];
        iArr[dataType] = iArr[dataType] + value;
        saveStats();
    }

    public void incrementReceivedBytesCount(int networkType, int dataType, long value) {
        long[] jArr = this.receivedBytes[networkType];
        jArr[dataType] = jArr[dataType] + value;
        saveStats();
    }

    public void incrementSentBytesCount(int networkType, int dataType, long value) {
        long[] jArr = this.sentBytes[networkType];
        jArr[dataType] = jArr[dataType] + value;
        saveStats();
    }

    public void incrementTotalCallsTime(int networkType, int value) {
        int[] iArr = this.callsTotalTime;
        iArr[networkType] = iArr[networkType] + value;
        saveStats();
    }

    public int getRecivedItemsCount(int networkType, int dataType) {
        return this.receivedItems[networkType][dataType];
    }

    public int getSentItemsCount(int networkType, int dataType) {
        return this.sentItems[networkType][dataType];
    }

    public long getSentBytesCount(int networkType, int dataType) {
        if (dataType == 1) {
            long[][] jArr = this.sentBytes;
            return (((jArr[networkType][6] - jArr[networkType][5]) - jArr[networkType][3]) - jArr[networkType][2]) - jArr[networkType][4];
        }
        return this.sentBytes[networkType][dataType];
    }

    public long getReceivedBytesCount(int networkType, int dataType) {
        if (dataType == 1) {
            long[][] jArr = this.receivedBytes;
            return (((jArr[networkType][6] - jArr[networkType][5]) - jArr[networkType][3]) - jArr[networkType][2]) - jArr[networkType][4];
        }
        return this.receivedBytes[networkType][dataType];
    }

    public int getCallsTotalTime(int networkType) {
        return this.callsTotalTime[networkType];
    }

    public long getResetStatsDate(int networkType) {
        return this.resetStatsDate[networkType];
    }

    public void resetStats(int networkType) {
        this.resetStatsDate[networkType] = System.currentTimeMillis();
        for (int i = 0; i < 7; i++) {
            this.sentBytes[networkType][i] = 0;
            this.receivedBytes[networkType][i] = 0;
            this.sentItems[networkType][i] = 0;
            this.receivedItems[networkType][i] = 0;
        }
        this.callsTotalTime[networkType] = 0;
        saveStats();
    }

    private void saveStats() {
        long jCurrentTimeMillis = System.currentTimeMillis();
        ThreadLocal<Long> threadLocal = lastStatsSaveTime;
        if (Math.abs(jCurrentTimeMillis - threadLocal.get().longValue()) >= 2000) {
            threadLocal.set(Long.valueOf(jCurrentTimeMillis));
            statsSaveQueue.postRunnable(this.saveRunnable);
        }
    }
}
