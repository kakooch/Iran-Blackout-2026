package io.antmedia.android.broadcaster.encoder.gles;

import io.antmedia.android.broadcaster.encoder.gles.Drawable2d;

/* loaded from: classes.dex */
public class FullFrameRect {
    private Texture2dProgram mProgram;
    private final Drawable2d mRectDrawable = new Drawable2d(Drawable2d.Prefab.FULL_RECTANGLE);

    public FullFrameRect(Texture2dProgram program) {
        this.mProgram = program;
    }

    public void release(boolean doEglCleanup) {
        Texture2dProgram texture2dProgram = this.mProgram;
        if (texture2dProgram != null) {
            if (doEglCleanup) {
                texture2dProgram.release();
            }
            this.mProgram = null;
        }
    }

    public Texture2dProgram getProgram() {
        return this.mProgram;
    }

    public int createTextureObject() {
        return this.mProgram.createTextureObject();
    }

    public void drawFrame(int textureId, float[] texMatrix) {
        this.mProgram.draw(GlUtil.IDENTITY_MATRIX, this.mRectDrawable.getVertexArray(), 0, this.mRectDrawable.getVertexCount(), this.mRectDrawable.getCoordsPerVertex(), this.mRectDrawable.getVertexStride(), texMatrix, this.mRectDrawable.getTexCoordArray(), textureId, this.mRectDrawable.getTexCoordStride());
    }
}
