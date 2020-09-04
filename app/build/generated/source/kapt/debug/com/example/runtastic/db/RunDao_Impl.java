package com.example.runtastic.db;

import android.database.Cursor;
import android.graphics.Bitmap;
import androidx.lifecycle.LiveData;
import androidx.room.CoroutinesRoom;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import java.lang.Exception;
import java.lang.Float;
import java.lang.Integer;
import java.lang.Long;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import javax.annotation.Generated;
import kotlin.Unit;
import kotlin.coroutines.Continuation;

@Generated("androidx.room.RoomProcessor")
@SuppressWarnings({"unchecked", "deprecation"})
public final class RunDao_Impl implements RunDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<Run> __insertionAdapterOfRun;

  private final Converters __converters = new Converters();

  private final EntityDeletionOrUpdateAdapter<Run> __deletionAdapterOfRun;

  public RunDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfRun = new EntityInsertionAdapter<Run>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR REPLACE INTO `running_table` (`id`,`img`,`timestamp`,`averageSpeedInKmh`,`distanceMeters`,`timeInMilis`,`caloriesBurnt`) VALUES (?,?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Run value) {
        if (value.getId() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindLong(1, value.getId());
        }
        final byte[] _tmp;
        _tmp = __converters.fromBitmap(value.getImg());
        if (_tmp == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindBlob(2, _tmp);
        }
        stmt.bindLong(3, value.getTimestamp());
        stmt.bindDouble(4, value.getAverageSpeedInKmh());
        stmt.bindLong(5, value.getDistanceMeters());
        stmt.bindLong(6, value.getTimeInMilis());
        stmt.bindLong(7, value.getCaloriesBurnt());
      }
    };
    this.__deletionAdapterOfRun = new EntityDeletionOrUpdateAdapter<Run>(__db) {
      @Override
      public String createQuery() {
        return "DELETE FROM `running_table` WHERE `id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Run value) {
        if (value.getId() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindLong(1, value.getId());
        }
      }
    };
  }

  @Override
  public Object insertRun(final Run run, final Continuation<? super Unit> p1) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __insertionAdapterOfRun.insert(run);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, p1);
  }

  @Override
  public Object deleteRun(final Run run, final Continuation<? super Unit> p1) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __deletionAdapterOfRun.handle(run);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, p1);
  }

  @Override
  public LiveData<List<Run>> getAllRunsSortedByData() {
    final String _sql = "SELECT * FROM running_table ORDER BY timestamp DESC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return __db.getInvalidationTracker().createLiveData(new String[]{"running_table"}, false, new Callable<List<Run>>() {
      @Override
      public List<Run> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfImg = CursorUtil.getColumnIndexOrThrow(_cursor, "img");
          final int _cursorIndexOfTimestamp = CursorUtil.getColumnIndexOrThrow(_cursor, "timestamp");
          final int _cursorIndexOfAverageSpeedInKmh = CursorUtil.getColumnIndexOrThrow(_cursor, "averageSpeedInKmh");
          final int _cursorIndexOfDistanceMeters = CursorUtil.getColumnIndexOrThrow(_cursor, "distanceMeters");
          final int _cursorIndexOfTimeInMilis = CursorUtil.getColumnIndexOrThrow(_cursor, "timeInMilis");
          final int _cursorIndexOfCaloriesBurnt = CursorUtil.getColumnIndexOrThrow(_cursor, "caloriesBurnt");
          final List<Run> _result = new ArrayList<Run>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final Run _item;
            final Bitmap _tmpImg;
            final byte[] _tmp;
            _tmp = _cursor.getBlob(_cursorIndexOfImg);
            _tmpImg = __converters.toBitmap(_tmp);
            final long _tmpTimestamp;
            _tmpTimestamp = _cursor.getLong(_cursorIndexOfTimestamp);
            final float _tmpAverageSpeedInKmh;
            _tmpAverageSpeedInKmh = _cursor.getFloat(_cursorIndexOfAverageSpeedInKmh);
            final int _tmpDistanceMeters;
            _tmpDistanceMeters = _cursor.getInt(_cursorIndexOfDistanceMeters);
            final long _tmpTimeInMilis;
            _tmpTimeInMilis = _cursor.getLong(_cursorIndexOfTimeInMilis);
            final int _tmpCaloriesBurnt;
            _tmpCaloriesBurnt = _cursor.getInt(_cursorIndexOfCaloriesBurnt);
            _item = new Run(_tmpImg,_tmpTimestamp,_tmpAverageSpeedInKmh,_tmpDistanceMeters,_tmpTimeInMilis,_tmpCaloriesBurnt);
            final Integer _tmpId;
            if (_cursor.isNull(_cursorIndexOfId)) {
              _tmpId = null;
            } else {
              _tmpId = _cursor.getInt(_cursorIndexOfId);
            }
            _item.setId(_tmpId);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  @Override
  public LiveData<List<Run>> getAllRunsSortedByTimeInMili() {
    final String _sql = "SELECT * FROM running_table ORDER BY timeInMilis DESC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return __db.getInvalidationTracker().createLiveData(new String[]{"running_table"}, false, new Callable<List<Run>>() {
      @Override
      public List<Run> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfImg = CursorUtil.getColumnIndexOrThrow(_cursor, "img");
          final int _cursorIndexOfTimestamp = CursorUtil.getColumnIndexOrThrow(_cursor, "timestamp");
          final int _cursorIndexOfAverageSpeedInKmh = CursorUtil.getColumnIndexOrThrow(_cursor, "averageSpeedInKmh");
          final int _cursorIndexOfDistanceMeters = CursorUtil.getColumnIndexOrThrow(_cursor, "distanceMeters");
          final int _cursorIndexOfTimeInMilis = CursorUtil.getColumnIndexOrThrow(_cursor, "timeInMilis");
          final int _cursorIndexOfCaloriesBurnt = CursorUtil.getColumnIndexOrThrow(_cursor, "caloriesBurnt");
          final List<Run> _result = new ArrayList<Run>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final Run _item;
            final Bitmap _tmpImg;
            final byte[] _tmp;
            _tmp = _cursor.getBlob(_cursorIndexOfImg);
            _tmpImg = __converters.toBitmap(_tmp);
            final long _tmpTimestamp;
            _tmpTimestamp = _cursor.getLong(_cursorIndexOfTimestamp);
            final float _tmpAverageSpeedInKmh;
            _tmpAverageSpeedInKmh = _cursor.getFloat(_cursorIndexOfAverageSpeedInKmh);
            final int _tmpDistanceMeters;
            _tmpDistanceMeters = _cursor.getInt(_cursorIndexOfDistanceMeters);
            final long _tmpTimeInMilis;
            _tmpTimeInMilis = _cursor.getLong(_cursorIndexOfTimeInMilis);
            final int _tmpCaloriesBurnt;
            _tmpCaloriesBurnt = _cursor.getInt(_cursorIndexOfCaloriesBurnt);
            _item = new Run(_tmpImg,_tmpTimestamp,_tmpAverageSpeedInKmh,_tmpDistanceMeters,_tmpTimeInMilis,_tmpCaloriesBurnt);
            final Integer _tmpId;
            if (_cursor.isNull(_cursorIndexOfId)) {
              _tmpId = null;
            } else {
              _tmpId = _cursor.getInt(_cursorIndexOfId);
            }
            _item.setId(_tmpId);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  @Override
  public LiveData<List<Run>> getAllRunsSortedByCaloriesBurnt() {
    final String _sql = "SELECT * FROM running_table ORDER BY caloriesBurnt DESC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return __db.getInvalidationTracker().createLiveData(new String[]{"running_table"}, false, new Callable<List<Run>>() {
      @Override
      public List<Run> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfImg = CursorUtil.getColumnIndexOrThrow(_cursor, "img");
          final int _cursorIndexOfTimestamp = CursorUtil.getColumnIndexOrThrow(_cursor, "timestamp");
          final int _cursorIndexOfAverageSpeedInKmh = CursorUtil.getColumnIndexOrThrow(_cursor, "averageSpeedInKmh");
          final int _cursorIndexOfDistanceMeters = CursorUtil.getColumnIndexOrThrow(_cursor, "distanceMeters");
          final int _cursorIndexOfTimeInMilis = CursorUtil.getColumnIndexOrThrow(_cursor, "timeInMilis");
          final int _cursorIndexOfCaloriesBurnt = CursorUtil.getColumnIndexOrThrow(_cursor, "caloriesBurnt");
          final List<Run> _result = new ArrayList<Run>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final Run _item;
            final Bitmap _tmpImg;
            final byte[] _tmp;
            _tmp = _cursor.getBlob(_cursorIndexOfImg);
            _tmpImg = __converters.toBitmap(_tmp);
            final long _tmpTimestamp;
            _tmpTimestamp = _cursor.getLong(_cursorIndexOfTimestamp);
            final float _tmpAverageSpeedInKmh;
            _tmpAverageSpeedInKmh = _cursor.getFloat(_cursorIndexOfAverageSpeedInKmh);
            final int _tmpDistanceMeters;
            _tmpDistanceMeters = _cursor.getInt(_cursorIndexOfDistanceMeters);
            final long _tmpTimeInMilis;
            _tmpTimeInMilis = _cursor.getLong(_cursorIndexOfTimeInMilis);
            final int _tmpCaloriesBurnt;
            _tmpCaloriesBurnt = _cursor.getInt(_cursorIndexOfCaloriesBurnt);
            _item = new Run(_tmpImg,_tmpTimestamp,_tmpAverageSpeedInKmh,_tmpDistanceMeters,_tmpTimeInMilis,_tmpCaloriesBurnt);
            final Integer _tmpId;
            if (_cursor.isNull(_cursorIndexOfId)) {
              _tmpId = null;
            } else {
              _tmpId = _cursor.getInt(_cursorIndexOfId);
            }
            _item.setId(_tmpId);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  @Override
  public LiveData<List<Run>> getAllRunsSortedByAverageSpeed() {
    final String _sql = "SELECT * FROM running_table ORDER BY averageSpeedInKmh DESC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return __db.getInvalidationTracker().createLiveData(new String[]{"running_table"}, false, new Callable<List<Run>>() {
      @Override
      public List<Run> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfImg = CursorUtil.getColumnIndexOrThrow(_cursor, "img");
          final int _cursorIndexOfTimestamp = CursorUtil.getColumnIndexOrThrow(_cursor, "timestamp");
          final int _cursorIndexOfAverageSpeedInKmh = CursorUtil.getColumnIndexOrThrow(_cursor, "averageSpeedInKmh");
          final int _cursorIndexOfDistanceMeters = CursorUtil.getColumnIndexOrThrow(_cursor, "distanceMeters");
          final int _cursorIndexOfTimeInMilis = CursorUtil.getColumnIndexOrThrow(_cursor, "timeInMilis");
          final int _cursorIndexOfCaloriesBurnt = CursorUtil.getColumnIndexOrThrow(_cursor, "caloriesBurnt");
          final List<Run> _result = new ArrayList<Run>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final Run _item;
            final Bitmap _tmpImg;
            final byte[] _tmp;
            _tmp = _cursor.getBlob(_cursorIndexOfImg);
            _tmpImg = __converters.toBitmap(_tmp);
            final long _tmpTimestamp;
            _tmpTimestamp = _cursor.getLong(_cursorIndexOfTimestamp);
            final float _tmpAverageSpeedInKmh;
            _tmpAverageSpeedInKmh = _cursor.getFloat(_cursorIndexOfAverageSpeedInKmh);
            final int _tmpDistanceMeters;
            _tmpDistanceMeters = _cursor.getInt(_cursorIndexOfDistanceMeters);
            final long _tmpTimeInMilis;
            _tmpTimeInMilis = _cursor.getLong(_cursorIndexOfTimeInMilis);
            final int _tmpCaloriesBurnt;
            _tmpCaloriesBurnt = _cursor.getInt(_cursorIndexOfCaloriesBurnt);
            _item = new Run(_tmpImg,_tmpTimestamp,_tmpAverageSpeedInKmh,_tmpDistanceMeters,_tmpTimeInMilis,_tmpCaloriesBurnt);
            final Integer _tmpId;
            if (_cursor.isNull(_cursorIndexOfId)) {
              _tmpId = null;
            } else {
              _tmpId = _cursor.getInt(_cursorIndexOfId);
            }
            _item.setId(_tmpId);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  @Override
  public LiveData<List<Run>> getAllRunsSortedByDistance() {
    final String _sql = "SELECT * FROM running_table ORDER BY distanceMeters DESC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return __db.getInvalidationTracker().createLiveData(new String[]{"running_table"}, false, new Callable<List<Run>>() {
      @Override
      public List<Run> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfImg = CursorUtil.getColumnIndexOrThrow(_cursor, "img");
          final int _cursorIndexOfTimestamp = CursorUtil.getColumnIndexOrThrow(_cursor, "timestamp");
          final int _cursorIndexOfAverageSpeedInKmh = CursorUtil.getColumnIndexOrThrow(_cursor, "averageSpeedInKmh");
          final int _cursorIndexOfDistanceMeters = CursorUtil.getColumnIndexOrThrow(_cursor, "distanceMeters");
          final int _cursorIndexOfTimeInMilis = CursorUtil.getColumnIndexOrThrow(_cursor, "timeInMilis");
          final int _cursorIndexOfCaloriesBurnt = CursorUtil.getColumnIndexOrThrow(_cursor, "caloriesBurnt");
          final List<Run> _result = new ArrayList<Run>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final Run _item;
            final Bitmap _tmpImg;
            final byte[] _tmp;
            _tmp = _cursor.getBlob(_cursorIndexOfImg);
            _tmpImg = __converters.toBitmap(_tmp);
            final long _tmpTimestamp;
            _tmpTimestamp = _cursor.getLong(_cursorIndexOfTimestamp);
            final float _tmpAverageSpeedInKmh;
            _tmpAverageSpeedInKmh = _cursor.getFloat(_cursorIndexOfAverageSpeedInKmh);
            final int _tmpDistanceMeters;
            _tmpDistanceMeters = _cursor.getInt(_cursorIndexOfDistanceMeters);
            final long _tmpTimeInMilis;
            _tmpTimeInMilis = _cursor.getLong(_cursorIndexOfTimeInMilis);
            final int _tmpCaloriesBurnt;
            _tmpCaloriesBurnt = _cursor.getInt(_cursorIndexOfCaloriesBurnt);
            _item = new Run(_tmpImg,_tmpTimestamp,_tmpAverageSpeedInKmh,_tmpDistanceMeters,_tmpTimeInMilis,_tmpCaloriesBurnt);
            final Integer _tmpId;
            if (_cursor.isNull(_cursorIndexOfId)) {
              _tmpId = null;
            } else {
              _tmpId = _cursor.getInt(_cursorIndexOfId);
            }
            _item.setId(_tmpId);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  @Override
  public LiveData<Long> getTotalTimeInMili() {
    final String _sql = "SELECT SUM(timeInMilis) FROM running_table";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return __db.getInvalidationTracker().createLiveData(new String[]{"running_table"}, false, new Callable<Long>() {
      @Override
      public Long call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final Long _result;
          if(_cursor.moveToFirst()) {
            final Long _tmp;
            if (_cursor.isNull(0)) {
              _tmp = null;
            } else {
              _tmp = _cursor.getLong(0);
            }
            _result = _tmp;
          } else {
            _result = null;
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  @Override
  public LiveData<Integer> getTotalCaloriesBurnt() {
    final String _sql = "SELECT SUM(caloriesBurnt) FROM running_table";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return __db.getInvalidationTracker().createLiveData(new String[]{"running_table"}, false, new Callable<Integer>() {
      @Override
      public Integer call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final Integer _result;
          if(_cursor.moveToFirst()) {
            final Integer _tmp;
            if (_cursor.isNull(0)) {
              _tmp = null;
            } else {
              _tmp = _cursor.getInt(0);
            }
            _result = _tmp;
          } else {
            _result = null;
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  @Override
  public LiveData<Integer> getTotalDistanceInMeters() {
    final String _sql = "SELECT SUM(distanceMeters) FROM running_table";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return __db.getInvalidationTracker().createLiveData(new String[]{"running_table"}, false, new Callable<Integer>() {
      @Override
      public Integer call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final Integer _result;
          if(_cursor.moveToFirst()) {
            final Integer _tmp;
            if (_cursor.isNull(0)) {
              _tmp = null;
            } else {
              _tmp = _cursor.getInt(0);
            }
            _result = _tmp;
          } else {
            _result = null;
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  @Override
  public LiveData<Float> getTotalAverageSpeedKmh() {
    final String _sql = "SELECT AVG(averageSpeedInKmh) FROM running_table";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return __db.getInvalidationTracker().createLiveData(new String[]{"running_table"}, false, new Callable<Float>() {
      @Override
      public Float call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final Float _result;
          if(_cursor.moveToFirst()) {
            final Float _tmp;
            if (_cursor.isNull(0)) {
              _tmp = null;
            } else {
              _tmp = _cursor.getFloat(0);
            }
            _result = _tmp;
          } else {
            _result = null;
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }
}
