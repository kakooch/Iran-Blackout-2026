package ir.eitaa.messenger.video;

import android.media.MediaCodec;
import android.media.MediaFormat;
import com.coremedia.iso.BoxParser;
import com.coremedia.iso.IsoFile;
import com.coremedia.iso.IsoTypeWriter;
import com.coremedia.iso.boxes.Box;
import com.coremedia.iso.boxes.CompositionTimeToSample;
import com.coremedia.iso.boxes.Container;
import com.coremedia.iso.boxes.DataEntryUrlBox;
import com.coremedia.iso.boxes.DataInformationBox;
import com.coremedia.iso.boxes.DataReferenceBox;
import com.coremedia.iso.boxes.FileTypeBox;
import com.coremedia.iso.boxes.HandlerBox;
import com.coremedia.iso.boxes.MediaBox;
import com.coremedia.iso.boxes.MediaHeaderBox;
import com.coremedia.iso.boxes.MediaInformationBox;
import com.coremedia.iso.boxes.MovieBox;
import com.coremedia.iso.boxes.MovieHeaderBox;
import com.coremedia.iso.boxes.SampleSizeBox;
import com.coremedia.iso.boxes.SampleTableBox;
import com.coremedia.iso.boxes.SampleToChunkBox;
import com.coremedia.iso.boxes.StaticChunkOffsetBox;
import com.coremedia.iso.boxes.SyncSampleBox;
import com.coremedia.iso.boxes.TimeToSampleBox;
import com.coremedia.iso.boxes.TrackBox;
import com.coremedia.iso.boxes.TrackHeaderBox;
import com.googlecode.mp4parser.DataSource;
import com.googlecode.mp4parser.util.Matrix;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.WritableByteChannel;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;

/* loaded from: classes.dex */
public class MP4Builder {
    private boolean splitMdat;
    private boolean wasFirstVideoFrame;
    private InterleaveChunkMdat mdat = null;
    private Mp4Movie currentMp4Movie = null;
    private FileOutputStream fos = null;
    private FileChannel fc = null;
    private long dataOffset = 0;
    private long wroteSinceLastMdat = 0;
    private boolean writeNewMdat = true;
    private HashMap<Track, long[]> track2SampleSizes = new HashMap<>();
    private ByteBuffer sizeBuffer = null;

    protected void createSidx(Track track, SampleTableBox stbl) {
    }

    public MP4Builder createMovie(Mp4Movie mp4Movie, boolean split) throws Exception {
        this.currentMp4Movie = mp4Movie;
        FileOutputStream fileOutputStream = new FileOutputStream(mp4Movie.getCacheFile());
        this.fos = fileOutputStream;
        this.fc = fileOutputStream.getChannel();
        FileTypeBox fileTypeBoxCreateFileTypeBox = createFileTypeBox();
        fileTypeBoxCreateFileTypeBox.getBox(this.fc);
        long size = this.dataOffset + fileTypeBoxCreateFileTypeBox.getSize();
        this.dataOffset = size;
        this.wroteSinceLastMdat += size;
        this.splitMdat = split;
        this.mdat = new InterleaveChunkMdat();
        this.sizeBuffer = ByteBuffer.allocateDirect(4);
        return this;
    }

    private void flushCurrentMdat() throws Exception {
        long jPosition = this.fc.position();
        this.fc.position(this.mdat.getOffset());
        this.mdat.getBox(this.fc);
        this.fc.position(jPosition);
        this.mdat.setDataOffset(0L);
        this.mdat.setContentSize(0L);
        this.fos.flush();
        this.fos.getFD().sync();
    }

    public long writeSampleData(int trackIndex, ByteBuffer byteBuf, MediaCodec.BufferInfo bufferInfo, boolean writeLength) throws Exception {
        if (this.writeNewMdat) {
            this.mdat.setContentSize(0L);
            this.mdat.getBox(this.fc);
            this.mdat.setDataOffset(this.dataOffset);
            this.dataOffset += 16;
            this.wroteSinceLastMdat += 16;
            this.writeNewMdat = false;
        }
        InterleaveChunkMdat interleaveChunkMdat = this.mdat;
        interleaveChunkMdat.setContentSize(interleaveChunkMdat.getContentSize() + bufferInfo.size);
        long j = this.wroteSinceLastMdat + bufferInfo.size;
        this.wroteSinceLastMdat = j;
        boolean z = true;
        if (j >= 32768) {
            if (this.splitMdat) {
                flushCurrentMdat();
                this.writeNewMdat = true;
            }
            this.wroteSinceLastMdat = 0L;
        } else {
            z = false;
        }
        this.currentMp4Movie.addSample(trackIndex, this.dataOffset, bufferInfo);
        if (writeLength) {
            this.sizeBuffer.position(0);
            this.sizeBuffer.putInt(bufferInfo.size - 4);
            this.sizeBuffer.position(0);
            this.fc.write(this.sizeBuffer);
            byteBuf.position(bufferInfo.offset + 4);
        } else {
            byteBuf.position(bufferInfo.offset);
        }
        byteBuf.limit(bufferInfo.offset + bufferInfo.size);
        this.fc.write(byteBuf);
        this.dataOffset += bufferInfo.size;
        if (!z) {
            return 0L;
        }
        this.fos.flush();
        this.fos.getFD().sync();
        return this.fc.position();
    }

    public long getLastFrameTimestamp(int trackIndex) {
        return this.currentMp4Movie.getLastFrameTimestamp(trackIndex);
    }

    public int addTrack(MediaFormat mediaFormat, boolean isAudio) {
        return this.currentMp4Movie.addTrack(mediaFormat, isAudio);
    }

    public void finishMovie() throws Exception {
        if (this.mdat.getContentSize() != 0) {
            flushCurrentMdat();
        }
        Iterator<Track> it = this.currentMp4Movie.getTracks().iterator();
        while (it.hasNext()) {
            Track next = it.next();
            ArrayList<Sample> samples = next.getSamples();
            int size = samples.size();
            long[] jArr = new long[size];
            for (int i = 0; i < size; i++) {
                jArr[i] = samples.get(i).getSize();
            }
            this.track2SampleSizes.put(next, jArr);
        }
        createMovieBox(this.currentMp4Movie).getBox(this.fc);
        this.fos.flush();
        this.fos.getFD().sync();
        this.fc.close();
        this.fos.close();
    }

    protected FileTypeBox createFileTypeBox() {
        LinkedList linkedList = new LinkedList();
        linkedList.add("isom");
        linkedList.add("iso2");
        linkedList.add("avc1");
        linkedList.add("mp41");
        return new FileTypeBox("isom", 512L, linkedList);
    }

    private static class InterleaveChunkMdat implements Box {
        private long contentSize;
        private long dataOffset;
        private Container parent;

        private boolean isSmallBox(long contentSize) {
            return contentSize + 8 < 4294967296L;
        }

        public String getType() {
            return "mdat";
        }

        public void parse(DataSource dataSource, ByteBuffer header, long contentSize, BoxParser boxParser) {
        }

        private InterleaveChunkMdat() {
            this.contentSize = 1073741824L;
            this.dataOffset = 0L;
        }

        public Container getParent() {
            return this.parent;
        }

        public long getOffset() {
            return this.dataOffset;
        }

        public void setDataOffset(long offset) {
            this.dataOffset = offset;
        }

        @Override // com.coremedia.iso.boxes.Box
        public void setParent(Container parent) {
            this.parent = parent;
        }

        public void setContentSize(long contentSize) {
            this.contentSize = contentSize;
        }

        public long getContentSize() {
            return this.contentSize;
        }

        @Override // com.coremedia.iso.boxes.Box
        public long getSize() {
            return this.contentSize + 16;
        }

        @Override // com.coremedia.iso.boxes.Box
        public void getBox(WritableByteChannel writableByteChannel) throws IOException {
            ByteBuffer byteBufferAllocate = ByteBuffer.allocate(16);
            long size = getSize();
            if (isSmallBox(size)) {
                IsoTypeWriter.writeUInt32(byteBufferAllocate, size);
            } else {
                IsoTypeWriter.writeUInt32(byteBufferAllocate, 1L);
            }
            byteBufferAllocate.put(IsoFile.fourCCtoBytes("mdat"));
            if (isSmallBox(size)) {
                byteBufferAllocate.put(new byte[8]);
            } else {
                IsoTypeWriter.writeUInt64(byteBufferAllocate, size);
            }
            byteBufferAllocate.rewind();
            writableByteChannel.write(byteBufferAllocate);
        }
    }

    public static long gcd(long a, long b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    public long getTimescale(Mp4Movie mp4Movie) {
        long timeScale = !mp4Movie.getTracks().isEmpty() ? mp4Movie.getTracks().iterator().next().getTimeScale() : 0L;
        Iterator<Track> it = mp4Movie.getTracks().iterator();
        while (it.hasNext()) {
            timeScale = gcd(it.next().getTimeScale(), timeScale);
        }
        return timeScale;
    }

    protected MovieBox createMovieBox(Mp4Movie movie) {
        MovieBox movieBox = new MovieBox();
        MovieHeaderBox movieHeaderBox = new MovieHeaderBox();
        movieHeaderBox.setCreationTime(new Date());
        movieHeaderBox.setModificationTime(new Date());
        movieHeaderBox.setMatrix(Matrix.ROTATE_0);
        long timescale = getTimescale(movie);
        Iterator<Track> it = movie.getTracks().iterator();
        long j = 0;
        while (it.hasNext()) {
            Track next = it.next();
            next.prepare();
            long duration = (next.getDuration() * timescale) / next.getTimeScale();
            if (duration > j) {
                j = duration;
            }
        }
        movieHeaderBox.setDuration(j);
        movieHeaderBox.setTimescale(timescale);
        movieHeaderBox.setNextTrackId(movie.getTracks().size() + 1);
        movieBox.addBox(movieHeaderBox);
        Iterator<Track> it2 = movie.getTracks().iterator();
        while (it2.hasNext()) {
            movieBox.addBox(createTrackBox(it2.next(), movie));
        }
        return movieBox;
    }

    protected TrackBox createTrackBox(Track track, Mp4Movie movie) {
        TrackBox trackBox = new TrackBox();
        TrackHeaderBox trackHeaderBox = new TrackHeaderBox();
        trackHeaderBox.setEnabled(true);
        trackHeaderBox.setInMovie(true);
        trackHeaderBox.setInPreview(true);
        if (track.isAudio()) {
            trackHeaderBox.setMatrix(Matrix.ROTATE_0);
        } else {
            trackHeaderBox.setMatrix(movie.getMatrix());
        }
        trackHeaderBox.setAlternateGroup(0);
        trackHeaderBox.setCreationTime(track.getCreationTime());
        trackHeaderBox.setDuration((track.getDuration() * getTimescale(movie)) / track.getTimeScale());
        trackHeaderBox.setHeight(track.getHeight());
        trackHeaderBox.setWidth(track.getWidth());
        trackHeaderBox.setLayer(0);
        trackHeaderBox.setModificationTime(new Date());
        trackHeaderBox.setTrackId(track.getTrackId() + 1);
        trackHeaderBox.setVolume(track.getVolume());
        trackBox.addBox(trackHeaderBox);
        MediaBox mediaBox = new MediaBox();
        trackBox.addBox(mediaBox);
        MediaHeaderBox mediaHeaderBox = new MediaHeaderBox();
        mediaHeaderBox.setCreationTime(track.getCreationTime());
        mediaHeaderBox.setDuration(track.getDuration());
        mediaHeaderBox.setTimescale(track.getTimeScale());
        mediaHeaderBox.setLanguage("eng");
        mediaBox.addBox(mediaHeaderBox);
        HandlerBox handlerBox = new HandlerBox();
        handlerBox.setName(track.isAudio() ? "SoundHandle" : "VideoHandle");
        handlerBox.setHandlerType(track.getHandler());
        mediaBox.addBox(handlerBox);
        MediaInformationBox mediaInformationBox = new MediaInformationBox();
        mediaInformationBox.addBox(track.getMediaHeaderBox());
        DataInformationBox dataInformationBox = new DataInformationBox();
        DataReferenceBox dataReferenceBox = new DataReferenceBox();
        dataInformationBox.addBox(dataReferenceBox);
        DataEntryUrlBox dataEntryUrlBox = new DataEntryUrlBox();
        dataEntryUrlBox.setFlags(1);
        dataReferenceBox.addBox(dataEntryUrlBox);
        mediaInformationBox.addBox(dataInformationBox);
        mediaInformationBox.addBox(createStbl(track));
        mediaBox.addBox(mediaInformationBox);
        return trackBox;
    }

    protected Box createStbl(Track track) {
        SampleTableBox sampleTableBox = new SampleTableBox();
        createStsd(track, sampleTableBox);
        createStts(track, sampleTableBox);
        createCtts(track, sampleTableBox);
        createStss(track, sampleTableBox);
        createStsc(track, sampleTableBox);
        createStsz(track, sampleTableBox);
        createStco(track, sampleTableBox);
        return sampleTableBox;
    }

    protected void createStsd(Track track, SampleTableBox stbl) {
        stbl.addBox(track.getSampleDescriptionBox());
    }

    protected void createCtts(Track track, SampleTableBox stbl) {
        int[] sampleCompositions = track.getSampleCompositions();
        if (sampleCompositions == null) {
            return;
        }
        CompositionTimeToSample.Entry entry = null;
        ArrayList arrayList = new ArrayList();
        for (int i : sampleCompositions) {
            if (entry != null && entry.getOffset() == i) {
                entry.setCount(entry.getCount() + 1);
            } else {
                entry = new CompositionTimeToSample.Entry(1, i);
                arrayList.add(entry);
            }
        }
        CompositionTimeToSample compositionTimeToSample = new CompositionTimeToSample();
        compositionTimeToSample.setEntries(arrayList);
        stbl.addBox(compositionTimeToSample);
    }

    protected void createStts(Track track, SampleTableBox stbl) {
        ArrayList arrayList = new ArrayList();
        TimeToSampleBox.Entry entry = null;
        for (long j : track.getSampleDurations()) {
            if (entry != null && entry.getDelta() == j) {
                entry.setCount(entry.getCount() + 1);
            } else {
                entry = new TimeToSampleBox.Entry(1L, j);
                arrayList.add(entry);
            }
        }
        TimeToSampleBox timeToSampleBox = new TimeToSampleBox();
        timeToSampleBox.setEntries(arrayList);
        stbl.addBox(timeToSampleBox);
    }

    protected void createStss(Track track, SampleTableBox stbl) {
        long[] syncSamples = track.getSyncSamples();
        if (syncSamples == null || syncSamples.length <= 0) {
            return;
        }
        SyncSampleBox syncSampleBox = new SyncSampleBox();
        syncSampleBox.setSampleNumber(syncSamples);
        stbl.addBox(syncSampleBox);
    }

    protected void createStsc(Track track, SampleTableBox stbl) {
        SampleToChunkBox sampleToChunkBox = new SampleToChunkBox();
        sampleToChunkBox.setEntries(new LinkedList());
        int size = track.getSamples().size();
        int i = -1;
        int i2 = 0;
        int i3 = 0;
        int i4 = 1;
        while (i2 < size) {
            Sample sample = track.getSamples().get(i2);
            i3++;
            if (i2 == size + (-1) || sample.getOffset() + sample.getSize() != track.getSamples().get(i2 + 1).getOffset()) {
                if (i != i3) {
                    sampleToChunkBox.getEntries().add(new SampleToChunkBox.Entry(i4, i3, 1L));
                    i = i3;
                }
                i4++;
                i3 = 0;
            }
            i2++;
        }
        stbl.addBox(sampleToChunkBox);
    }

    protected void createStsz(Track track, SampleTableBox stbl) {
        SampleSizeBox sampleSizeBox = new SampleSizeBox();
        sampleSizeBox.setSampleSizes(this.track2SampleSizes.get(track));
        stbl.addBox(sampleSizeBox);
    }

    protected void createStco(Track track, SampleTableBox stbl) {
        ArrayList arrayList = new ArrayList();
        Iterator<Sample> it = track.getSamples().iterator();
        long size = -1;
        while (it.hasNext()) {
            Sample next = it.next();
            long offset = next.getOffset();
            if (size != -1 && size != offset) {
                size = -1;
            }
            if (size == -1) {
                arrayList.add(Long.valueOf(offset));
            }
            size = next.getSize() + offset;
        }
        long[] jArr = new long[arrayList.size()];
        for (int i = 0; i < arrayList.size(); i++) {
            jArr[i] = ((Long) arrayList.get(i)).longValue();
        }
        StaticChunkOffsetBox staticChunkOffsetBox = new StaticChunkOffsetBox();
        staticChunkOffsetBox.setChunkOffsets(jArr);
        stbl.addBox(staticChunkOffsetBox);
    }
}
