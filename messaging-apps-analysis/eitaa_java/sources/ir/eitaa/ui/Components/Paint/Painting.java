package ir.eitaa.ui.Components.Paint;

import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.opengl.GLES20;
import ir.eitaa.messenger.DispatchQueue;
import ir.eitaa.ui.Components.Size;
import java.io.IOException;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.util.Iterator;
import java.util.Map;
import java.util.UUID;
import java.util.zip.DataFormatException;

/* loaded from: classes3.dex */
public class Painting {
    private Path activePath;
    private RectF activeStrokeBounds;
    private Slice backupSlice;
    private Texture bitmapTexture;
    private Brush brush;
    private Texture brushTexture;
    private ByteBuffer dataBuffer;
    private PaintingDelegate delegate;
    private int paintTexture;
    private boolean paused;
    private float[] projection;
    private float[] renderProjection;
    private RenderView renderView;
    private int reusableFramebuffer;
    private Map<String, Shader> shaders;
    private Size size;
    private int suppressChangesCounter;
    private ByteBuffer textureBuffer;
    private ByteBuffer vertexBuffer;
    private int[] buffers = new int[1];
    private RenderState renderState = new RenderState();

    public interface PaintingDelegate {
        void contentChanged();

        DispatchQueue requestDispatchQueue();

        UndoStore requestUndoStore();
    }

    public static class PaintingData {
        public Bitmap bitmap;
        public ByteBuffer data;

        PaintingData(Bitmap b, ByteBuffer buffer) {
            this.bitmap = b;
            this.data = buffer;
        }
    }

    public Painting(Size sz) {
        this.size = sz;
        this.dataBuffer = ByteBuffer.allocateDirect(((int) sz.width) * ((int) sz.height) * 4);
        Size size = this.size;
        this.projection = GLMatrix.LoadOrtho(0.0f, size.width, 0.0f, size.height, -1.0f, 1.0f);
        if (this.vertexBuffer == null) {
            ByteBuffer byteBufferAllocateDirect = ByteBuffer.allocateDirect(32);
            this.vertexBuffer = byteBufferAllocateDirect;
            byteBufferAllocateDirect.order(ByteOrder.nativeOrder());
        }
        this.vertexBuffer.putFloat(0.0f);
        this.vertexBuffer.putFloat(0.0f);
        this.vertexBuffer.putFloat(this.size.width);
        this.vertexBuffer.putFloat(0.0f);
        this.vertexBuffer.putFloat(0.0f);
        this.vertexBuffer.putFloat(this.size.height);
        this.vertexBuffer.putFloat(this.size.width);
        this.vertexBuffer.putFloat(this.size.height);
        this.vertexBuffer.rewind();
        if (this.textureBuffer == null) {
            ByteBuffer byteBufferAllocateDirect2 = ByteBuffer.allocateDirect(32);
            this.textureBuffer = byteBufferAllocateDirect2;
            byteBufferAllocateDirect2.order(ByteOrder.nativeOrder());
            this.textureBuffer.putFloat(0.0f);
            this.textureBuffer.putFloat(0.0f);
            this.textureBuffer.putFloat(1.0f);
            this.textureBuffer.putFloat(0.0f);
            this.textureBuffer.putFloat(0.0f);
            this.textureBuffer.putFloat(1.0f);
            this.textureBuffer.putFloat(1.0f);
            this.textureBuffer.putFloat(1.0f);
            this.textureBuffer.rewind();
        }
    }

    public void setDelegate(PaintingDelegate paintingDelegate) {
        this.delegate = paintingDelegate;
    }

    public void setRenderView(RenderView view) {
        this.renderView = view;
    }

    public Size getSize() {
        return this.size;
    }

    public RectF getBounds() {
        Size size = this.size;
        return new RectF(0.0f, 0.0f, size.width, size.height);
    }

    private boolean isSuppressingChanges() {
        return this.suppressChangesCounter > 0;
    }

    private void beginSuppressingChanges() {
        this.suppressChangesCounter++;
    }

    private void endSuppressingChanges() {
        this.suppressChangesCounter--;
    }

    public void setBitmap(Bitmap bitmap) {
        if (this.bitmapTexture != null) {
            return;
        }
        this.bitmapTexture = new Texture(bitmap);
    }

    public void paintStroke(final Path path, final boolean clearBuffer, final Runnable action) {
        this.renderView.performInContext(new Runnable() { // from class: ir.eitaa.ui.Components.Paint.-$$Lambda$Painting$mVsFj85THWEXuvxkrcXi-3q1vlQ
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$paintStroke$0$Painting(path, clearBuffer, action);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$paintStroke$0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$paintStroke$0$Painting(Path path, boolean z, Runnable runnable) {
        RectF rectFRenderPath;
        this.activePath = path;
        GLES20.glBindFramebuffer(36160, getReusableFramebuffer());
        GLES20.glFramebufferTexture2D(36160, 36064, 3553, getPaintTexture(), 0);
        Utils.HasGLError();
        if (GLES20.glCheckFramebufferStatus(36160) == 36053) {
            Size size = this.size;
            GLES20.glViewport(0, 0, (int) size.width, (int) size.height);
            if (z) {
                GLES20.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
                GLES20.glClear(16384);
            }
            Map<String, Shader> map = this.shaders;
            if (map == null) {
                return;
            }
            Shader shader = map.get(this.brush.isLightSaber() ? "brushLight" : "brush");
            if (shader == null) {
                return;
            }
            GLES20.glUseProgram(shader.program);
            if (this.brushTexture == null) {
                this.brushTexture = new Texture(this.brush.getStamp());
            }
            GLES20.glActiveTexture(33984);
            GLES20.glBindTexture(3553, this.brushTexture.texture());
            GLES20.glUniformMatrix4fv(shader.getUniform("mvpMatrix"), 1, false, FloatBuffer.wrap(this.projection));
            GLES20.glUniform1i(shader.getUniform("texture"), 0);
            this.renderState.viewportScale = this.renderView.getScaleX();
            rectFRenderPath = Render.RenderPath(path, this.renderState);
        } else {
            rectFRenderPath = null;
        }
        GLES20.glBindFramebuffer(36160, 0);
        PaintingDelegate paintingDelegate = this.delegate;
        if (paintingDelegate != null) {
            paintingDelegate.contentChanged();
        }
        RectF rectF = this.activeStrokeBounds;
        if (rectF != null) {
            rectF.union(rectFRenderPath);
        } else {
            this.activeStrokeBounds = rectFRenderPath;
        }
        if (runnable != null) {
            runnable.run();
        }
    }

    public void commitStroke(final int color) {
        this.renderView.performInContext(new Runnable() { // from class: ir.eitaa.ui.Components.Paint.-$$Lambda$Painting$rsaPvxANSQeFsxM1S7eKQR4ZObY
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$commitStroke$1$Painting(color);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$commitStroke$1, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$commitStroke$1$Painting(int i) {
        PaintingDelegate paintingDelegate;
        registerUndo(this.activeStrokeBounds);
        beginSuppressingChanges();
        GLES20.glBindFramebuffer(36160, getReusableFramebuffer());
        GLES20.glFramebufferTexture2D(36160, 36064, 3553, getTexture(), 0);
        Size size = this.size;
        GLES20.glViewport(0, 0, (int) size.width, (int) size.height);
        Shader shader = this.shaders.get(this.brush.isLightSaber() ? "compositeWithMaskLight" : "compositeWithMask");
        GLES20.glUseProgram(shader.program);
        GLES20.glUniformMatrix4fv(shader.getUniform("mvpMatrix"), 1, false, FloatBuffer.wrap(this.projection));
        GLES20.glUniform1i(shader.getUniform("texture"), 0);
        GLES20.glUniform1i(shader.getUniform("mask"), 1);
        Shader.SetColorUniform(shader.getUniform("color"), i);
        GLES20.glActiveTexture(33984);
        GLES20.glBindTexture(3553, getTexture());
        GLES20.glTexParameteri(3553, 10241, 9728);
        GLES20.glActiveTexture(33985);
        GLES20.glBindTexture(3553, getPaintTexture());
        GLES20.glBlendFunc(1, 0);
        GLES20.glVertexAttribPointer(0, 2, 5126, false, 8, (Buffer) this.vertexBuffer);
        GLES20.glEnableVertexAttribArray(0);
        GLES20.glVertexAttribPointer(1, 2, 5126, false, 8, (Buffer) this.textureBuffer);
        GLES20.glEnableVertexAttribArray(1);
        GLES20.glDrawArrays(5, 0, 4);
        GLES20.glBindTexture(3553, getTexture());
        GLES20.glTexParameteri(3553, 10241, 9729);
        GLES20.glBindFramebuffer(36160, 0);
        if (!isSuppressingChanges() && (paintingDelegate = this.delegate) != null) {
            paintingDelegate.contentChanged();
        }
        endSuppressingChanges();
        this.renderState.reset();
        this.activeStrokeBounds = null;
        this.activePath = null;
    }

    public void clearStroke() {
        this.renderView.performInContext(new Runnable() { // from class: ir.eitaa.ui.Components.Paint.-$$Lambda$Painting$6xKsQqXQn0-aAZIPht3QC5P5ljA
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$clearStroke$2$Painting();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$clearStroke$2, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$clearStroke$2$Painting() {
        GLES20.glBindFramebuffer(36160, getReusableFramebuffer());
        GLES20.glFramebufferTexture2D(36160, 36064, 3553, getPaintTexture(), 0);
        Utils.HasGLError();
        if (GLES20.glCheckFramebufferStatus(36160) == 36053) {
            Size size = this.size;
            GLES20.glViewport(0, 0, (int) size.width, (int) size.height);
            GLES20.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
            GLES20.glClear(16384);
        }
        GLES20.glBindFramebuffer(36160, 0);
        PaintingDelegate paintingDelegate = this.delegate;
        if (paintingDelegate != null) {
            paintingDelegate.contentChanged();
        }
        this.renderState.reset();
        this.activeStrokeBounds = null;
        this.activePath = null;
    }

    private void registerUndo(RectF rect) {
        if (rect != null && rect.setIntersect(rect, getBounds())) {
            final Slice slice = new Slice(getPaintingData(rect, true).data, rect, this.delegate.requestDispatchQueue());
            this.delegate.requestUndoStore().registerUndo(UUID.randomUUID(), new Runnable() { // from class: ir.eitaa.ui.Components.Paint.-$$Lambda$Painting$FzgHDTUN0Yb-_s4zVxbx2q9wE9E
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$registerUndo$3$Painting(slice);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: restoreSlice, reason: merged with bridge method [inline-methods] */
    public void lambda$registerUndo$3$Painting(final Slice slice) {
        this.renderView.performInContext(new Runnable() { // from class: ir.eitaa.ui.Components.Paint.-$$Lambda$Painting$P1JmOkp5Bzu27eDo3-IRpKU1MBk
            @Override // java.lang.Runnable
            public final void run() throws DataFormatException, IOException {
                this.f$0.lambda$restoreSlice$4$Painting(slice);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$restoreSlice$4, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$restoreSlice$4$Painting(Slice slice) throws DataFormatException, IOException {
        PaintingDelegate paintingDelegate;
        ByteBuffer data = slice.getData();
        GLES20.glBindTexture(3553, getTexture());
        GLES20.glTexSubImage2D(3553, 0, slice.getX(), slice.getY(), slice.getWidth(), slice.getHeight(), 6408, 5121, data);
        if (!isSuppressingChanges() && (paintingDelegate = this.delegate) != null) {
            paintingDelegate.contentChanged();
        }
        slice.cleanResources();
    }

    public void setRenderProjection(float[] proj) {
        this.renderProjection = proj;
    }

    public void render() {
        if (this.shaders == null) {
            return;
        }
        if (this.activePath != null) {
            render(getPaintTexture(), this.activePath.getColor());
        } else {
            renderBlit();
        }
    }

    private void render(int mask, int color) {
        Shader shader = this.shaders.get(this.brush.isLightSaber() ? "blitWithMaskLight" : "blitWithMask");
        if (shader == null) {
            return;
        }
        GLES20.glUseProgram(shader.program);
        GLES20.glUniformMatrix4fv(shader.getUniform("mvpMatrix"), 1, false, FloatBuffer.wrap(this.renderProjection));
        GLES20.glUniform1i(shader.getUniform("texture"), 0);
        GLES20.glUniform1i(shader.getUniform("mask"), 1);
        Shader.SetColorUniform(shader.getUniform("color"), color);
        GLES20.glActiveTexture(33984);
        GLES20.glBindTexture(3553, getTexture());
        GLES20.glActiveTexture(33985);
        GLES20.glBindTexture(3553, mask);
        GLES20.glBlendFunc(1, 771);
        GLES20.glVertexAttribPointer(0, 2, 5126, false, 8, (Buffer) this.vertexBuffer);
        GLES20.glEnableVertexAttribArray(0);
        GLES20.glVertexAttribPointer(1, 2, 5126, false, 8, (Buffer) this.textureBuffer);
        GLES20.glEnableVertexAttribArray(1);
        GLES20.glDrawArrays(5, 0, 4);
        Utils.HasGLError();
    }

    private void renderBlit() {
        Shader shader = this.shaders.get("blit");
        if (shader == null) {
            return;
        }
        GLES20.glUseProgram(shader.program);
        GLES20.glUniformMatrix4fv(shader.getUniform("mvpMatrix"), 1, false, FloatBuffer.wrap(this.renderProjection));
        GLES20.glUniform1i(shader.getUniform("texture"), 0);
        GLES20.glActiveTexture(33984);
        GLES20.glBindTexture(3553, getTexture());
        GLES20.glBlendFunc(1, 771);
        GLES20.glVertexAttribPointer(0, 2, 5126, false, 8, (Buffer) this.vertexBuffer);
        GLES20.glEnableVertexAttribArray(0);
        GLES20.glVertexAttribPointer(1, 2, 5126, false, 8, (Buffer) this.textureBuffer);
        GLES20.glEnableVertexAttribArray(1);
        GLES20.glDrawArrays(5, 0, 4);
        Utils.HasGLError();
    }

    public PaintingData getPaintingData(RectF rect, boolean undo) {
        PaintingData paintingData;
        int i = (int) rect.left;
        int i2 = (int) rect.top;
        int iWidth = (int) rect.width();
        int iHeight = (int) rect.height();
        GLES20.glGenFramebuffers(1, this.buffers, 0);
        int i3 = this.buffers[0];
        GLES20.glBindFramebuffer(36160, i3);
        GLES20.glGenTextures(1, this.buffers, 0);
        int i4 = this.buffers[0];
        GLES20.glBindTexture(3553, i4);
        GLES20.glTexParameteri(3553, 10242, 33071);
        GLES20.glTexParameteri(3553, 10243, 33071);
        GLES20.glTexParameteri(3553, 10241, 9729);
        GLES20.glTexParameteri(3553, 10240, 9728);
        GLES20.glTexImage2D(3553, 0, 6408, iWidth, iHeight, 0, 6408, 5121, null);
        GLES20.glFramebufferTexture2D(36160, 36064, 3553, i4, 0);
        Size size = this.size;
        GLES20.glViewport(0, 0, (int) size.width, (int) size.height);
        Map<String, Shader> map = this.shaders;
        if (map == null) {
            return null;
        }
        Shader shader = map.get(undo ? "nonPremultipliedBlit" : "blit");
        if (shader == null) {
            return null;
        }
        GLES20.glUseProgram(shader.program);
        Matrix matrix = new Matrix();
        matrix.preTranslate(-i, -i2);
        GLES20.glUniformMatrix4fv(shader.getUniform("mvpMatrix"), 1, false, FloatBuffer.wrap(GLMatrix.MultiplyMat4f(this.projection, GLMatrix.LoadGraphicsMatrix(matrix))));
        GLES20.glUniform1i(shader.getUniform("texture"), 0);
        GLES20.glActiveTexture(33984);
        GLES20.glBindTexture(3553, getTexture());
        GLES20.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
        GLES20.glClear(16384);
        GLES20.glBlendFunc(1, 0);
        GLES20.glVertexAttribPointer(0, 2, 5126, false, 8, (Buffer) this.vertexBuffer);
        GLES20.glEnableVertexAttribArray(0);
        GLES20.glVertexAttribPointer(1, 2, 5126, false, 8, (Buffer) this.textureBuffer);
        GLES20.glEnableVertexAttribArray(1);
        GLES20.glDrawArrays(5, 0, 4);
        this.dataBuffer.limit(iWidth * iHeight * 4);
        GLES20.glReadPixels(0, 0, iWidth, iHeight, 6408, 5121, this.dataBuffer);
        if (undo) {
            paintingData = new PaintingData(null, this.dataBuffer);
        } else {
            Bitmap bitmapCreateBitmap = Bitmap.createBitmap(iWidth, iHeight, Bitmap.Config.ARGB_8888);
            bitmapCreateBitmap.copyPixelsFromBuffer(this.dataBuffer);
            paintingData = new PaintingData(bitmapCreateBitmap, null);
        }
        int[] iArr = this.buffers;
        iArr[0] = i3;
        GLES20.glDeleteFramebuffers(1, iArr, 0);
        int[] iArr2 = this.buffers;
        iArr2[0] = i4;
        GLES20.glDeleteTextures(1, iArr2, 0);
        return paintingData;
    }

    public void setBrush(Brush value) {
        this.brush = value;
        Texture texture = this.brushTexture;
        if (texture != null) {
            texture.cleanResources(true);
            this.brushTexture = null;
        }
    }

    public boolean isPaused() {
        return this.paused;
    }

    public void onPause(final Runnable completionRunnable) {
        this.renderView.performInContext(new Runnable() { // from class: ir.eitaa.ui.Components.Paint.-$$Lambda$Painting$4G0uuIsQYFPkONIDclybGl0_Pbk
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$onPause$5$Painting(completionRunnable);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$onPause$5, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$onPause$5$Painting(Runnable runnable) {
        this.paused = true;
        this.backupSlice = new Slice(getPaintingData(getBounds(), true).data, getBounds(), this.delegate.requestDispatchQueue());
        cleanResources(false);
        if (runnable != null) {
            runnable.run();
        }
    }

    public void onResume() {
        lambda$registerUndo$3(this.backupSlice);
        this.backupSlice = null;
        this.paused = false;
    }

    public void cleanResources(boolean recycle) {
        int i = this.reusableFramebuffer;
        if (i != 0) {
            int[] iArr = this.buffers;
            iArr[0] = i;
            GLES20.glDeleteFramebuffers(1, iArr, 0);
            this.reusableFramebuffer = 0;
        }
        this.bitmapTexture.cleanResources(recycle);
        int i2 = this.paintTexture;
        if (i2 != 0) {
            int[] iArr2 = this.buffers;
            iArr2[0] = i2;
            GLES20.glDeleteTextures(1, iArr2, 0);
            this.paintTexture = 0;
        }
        Texture texture = this.brushTexture;
        if (texture != null) {
            texture.cleanResources(true);
            this.brushTexture = null;
        }
        Map<String, Shader> map = this.shaders;
        if (map != null) {
            Iterator<Shader> it = map.values().iterator();
            while (it.hasNext()) {
                it.next().cleanResources();
            }
            this.shaders = null;
        }
    }

    private int getReusableFramebuffer() {
        if (this.reusableFramebuffer == 0) {
            int[] iArr = new int[1];
            GLES20.glGenFramebuffers(1, iArr, 0);
            this.reusableFramebuffer = iArr[0];
            Utils.HasGLError();
        }
        return this.reusableFramebuffer;
    }

    private int getTexture() {
        Texture texture = this.bitmapTexture;
        if (texture != null) {
            return texture.texture();
        }
        return 0;
    }

    private int getPaintTexture() {
        if (this.paintTexture == 0) {
            this.paintTexture = Texture.generateTexture(this.size);
        }
        return this.paintTexture;
    }

    public void setupShaders() {
        this.shaders = ShaderSet.setup();
    }
}
