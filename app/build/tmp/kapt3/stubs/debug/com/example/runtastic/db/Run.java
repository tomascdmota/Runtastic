package com.example.runtastic.db;

import java.lang.System;

@androidx.room.Entity(tableName = "running_table")
@kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 1, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0002\b%\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001BC\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u000b\u001a\u00020\t\u00a2\u0006\u0002\u0010\fJ\u000b\u0010\'\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\t\u0010(\u001a\u00020\u0005H\u00c6\u0003J\t\u0010)\u001a\u00020\u0007H\u00c6\u0003J\t\u0010*\u001a\u00020\tH\u00c6\u0003J\t\u0010+\u001a\u00020\u0005H\u00c6\u0003J\t\u0010,\u001a\u00020\tH\u00c6\u0003JG\u0010-\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u00052\b\b\u0002\u0010\u000b\u001a\u00020\tH\u00c6\u0001J\u0013\u0010.\u001a\u00020/2\b\u00100\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u00101\u001a\u00020\tH\u00d6\u0001J\t\u00102\u001a\u000203H\u00d6\u0001R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\u000b\u001a\u00020\tX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001a\u0010\b\u001a\u00020\tX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0012\"\u0004\b\u0016\u0010\u0014R\"\u0010\u0017\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0010\n\u0002\u0010\u001c\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u001a\u0010\n\u001a\u00020\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\"\"\u0004\b&\u0010$\u00a8\u00064"}, d2 = {"Lcom/example/runtastic/db/Run;", "", "img", "Landroid/graphics/Bitmap;", "timestamp", "", "averageSpeedInKmh", "", "distanceMeters", "", "timeInMilis", "caloriesBurnt", "(Landroid/graphics/Bitmap;JFIJI)V", "getAverageSpeedInKmh", "()F", "setAverageSpeedInKmh", "(F)V", "getCaloriesBurnt", "()I", "setCaloriesBurnt", "(I)V", "getDistanceMeters", "setDistanceMeters", "id", "getId", "()Ljava/lang/Integer;", "setId", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getImg", "()Landroid/graphics/Bitmap;", "setImg", "(Landroid/graphics/Bitmap;)V", "getTimeInMilis", "()J", "setTimeInMilis", "(J)V", "getTimestamp", "setTimestamp", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "hashCode", "toString", "", "app_debug"})
public final class Run {
    @org.jetbrains.annotations.Nullable()
    @androidx.room.PrimaryKey(autoGenerate = true)
    private java.lang.Integer id;
    @org.jetbrains.annotations.Nullable()
    private android.graphics.Bitmap img;
    private long timestamp;
    private float averageSpeedInKmh;
    private int distanceMeters;
    private long timeInMilis;
    private int caloriesBurnt;
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Integer getId() {
        return null;
    }
    
    public final void setId(@org.jetbrains.annotations.Nullable()
    java.lang.Integer p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final android.graphics.Bitmap getImg() {
        return null;
    }
    
    public final void setImg(@org.jetbrains.annotations.Nullable()
    android.graphics.Bitmap p0) {
    }
    
    public final long getTimestamp() {
        return 0L;
    }
    
    public final void setTimestamp(long p0) {
    }
    
    public final float getAverageSpeedInKmh() {
        return 0.0F;
    }
    
    public final void setAverageSpeedInKmh(float p0) {
    }
    
    public final int getDistanceMeters() {
        return 0;
    }
    
    public final void setDistanceMeters(int p0) {
    }
    
    public final long getTimeInMilis() {
        return 0L;
    }
    
    public final void setTimeInMilis(long p0) {
    }
    
    public final int getCaloriesBurnt() {
        return 0;
    }
    
    public final void setCaloriesBurnt(int p0) {
    }
    
    public Run(@org.jetbrains.annotations.Nullable()
    android.graphics.Bitmap img, long timestamp, float averageSpeedInKmh, int distanceMeters, long timeInMilis, int caloriesBurnt) {
        super();
    }
    
    public Run() {
        super();
    }
    
    @org.jetbrains.annotations.Nullable()
    public final android.graphics.Bitmap component1() {
        return null;
    }
    
    public final long component2() {
        return 0L;
    }
    
    public final float component3() {
        return 0.0F;
    }
    
    public final int component4() {
        return 0;
    }
    
    public final long component5() {
        return 0L;
    }
    
    public final int component6() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.example.runtastic.db.Run copy(@org.jetbrains.annotations.Nullable()
    android.graphics.Bitmap img, long timestamp, float averageSpeedInKmh, int distanceMeters, long timeInMilis, int caloriesBurnt) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public java.lang.String toString() {
        return null;
    }
    
    @java.lang.Override()
    public int hashCode() {
        return 0;
    }
    
    @java.lang.Override()
    public boolean equals(@org.jetbrains.annotations.Nullable()
    java.lang.Object p0) {
        return false;
    }
}