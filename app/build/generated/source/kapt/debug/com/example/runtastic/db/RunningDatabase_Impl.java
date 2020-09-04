package com.example.runtastic.db;

import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.RoomOpenHelper;
import androidx.room.RoomOpenHelper.Delegate;
import androidx.room.RoomOpenHelper.ValidationResult;
import androidx.room.util.DBUtil;
import androidx.room.util.TableInfo;
import androidx.room.util.TableInfo.Column;
import androidx.room.util.TableInfo.ForeignKey;
import androidx.room.util.TableInfo.Index;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import androidx.sqlite.db.SupportSQLiteOpenHelper.Callback;
import androidx.sqlite.db.SupportSQLiteOpenHelper.Configuration;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import javax.annotation.Generated;

@Generated("androidx.room.RoomProcessor")
@SuppressWarnings({"unchecked", "deprecation"})
public final class RunningDatabase_Impl extends RunningDatabase {
  private volatile RunDao _runDao;

  @Override
  protected SupportSQLiteOpenHelper createOpenHelper(DatabaseConfiguration configuration) {
    final SupportSQLiteOpenHelper.Callback _openCallback = new RoomOpenHelper(configuration, new RoomOpenHelper.Delegate(1) {
      @Override
      public void createAllTables(SupportSQLiteDatabase _db) {
        _db.execSQL("CREATE TABLE IF NOT EXISTS `running_table` (`id` INTEGER PRIMARY KEY AUTOINCREMENT, `img` BLOB, `timestamp` INTEGER NOT NULL, `averageSpeedInKmh` REAL NOT NULL, `distanceMeters` INTEGER NOT NULL, `timeInMilis` INTEGER NOT NULL, `caloriesBurnt` INTEGER NOT NULL)");
        _db.execSQL("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
        _db.execSQL("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, '5c32a0e5181c3abdbcdeebb871e0397c')");
      }

      @Override
      public void dropAllTables(SupportSQLiteDatabase _db) {
        _db.execSQL("DROP TABLE IF EXISTS `running_table`");
        if (mCallbacks != null) {
          for (int _i = 0, _size = mCallbacks.size(); _i < _size; _i++) {
            mCallbacks.get(_i).onDestructiveMigration(_db);
          }
        }
      }

      @Override
      protected void onCreate(SupportSQLiteDatabase _db) {
        if (mCallbacks != null) {
          for (int _i = 0, _size = mCallbacks.size(); _i < _size; _i++) {
            mCallbacks.get(_i).onCreate(_db);
          }
        }
      }

      @Override
      public void onOpen(SupportSQLiteDatabase _db) {
        mDatabase = _db;
        internalInitInvalidationTracker(_db);
        if (mCallbacks != null) {
          for (int _i = 0, _size = mCallbacks.size(); _i < _size; _i++) {
            mCallbacks.get(_i).onOpen(_db);
          }
        }
      }

      @Override
      public void onPreMigrate(SupportSQLiteDatabase _db) {
        DBUtil.dropFtsSyncTriggers(_db);
      }

      @Override
      public void onPostMigrate(SupportSQLiteDatabase _db) {
      }

      @Override
      protected RoomOpenHelper.ValidationResult onValidateSchema(SupportSQLiteDatabase _db) {
        final HashMap<String, TableInfo.Column> _columnsRunningTable = new HashMap<String, TableInfo.Column>(7);
        _columnsRunningTable.put("id", new TableInfo.Column("id", "INTEGER", false, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsRunningTable.put("img", new TableInfo.Column("img", "BLOB", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsRunningTable.put("timestamp", new TableInfo.Column("timestamp", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsRunningTable.put("averageSpeedInKmh", new TableInfo.Column("averageSpeedInKmh", "REAL", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsRunningTable.put("distanceMeters", new TableInfo.Column("distanceMeters", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsRunningTable.put("timeInMilis", new TableInfo.Column("timeInMilis", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsRunningTable.put("caloriesBurnt", new TableInfo.Column("caloriesBurnt", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysRunningTable = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesRunningTable = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoRunningTable = new TableInfo("running_table", _columnsRunningTable, _foreignKeysRunningTable, _indicesRunningTable);
        final TableInfo _existingRunningTable = TableInfo.read(_db, "running_table");
        if (! _infoRunningTable.equals(_existingRunningTable)) {
          return new RoomOpenHelper.ValidationResult(false, "running_table(com.example.runtastic.db.Run).\n"
                  + " Expected:\n" + _infoRunningTable + "\n"
                  + " Found:\n" + _existingRunningTable);
        }
        return new RoomOpenHelper.ValidationResult(true, null);
      }
    }, "5c32a0e5181c3abdbcdeebb871e0397c", "ed6863312597ca2f072a807cf5391269");
    final SupportSQLiteOpenHelper.Configuration _sqliteConfig = SupportSQLiteOpenHelper.Configuration.builder(configuration.context)
        .name(configuration.name)
        .callback(_openCallback)
        .build();
    final SupportSQLiteOpenHelper _helper = configuration.sqliteOpenHelperFactory.create(_sqliteConfig);
    return _helper;
  }

  @Override
  protected InvalidationTracker createInvalidationTracker() {
    final HashMap<String, String> _shadowTablesMap = new HashMap<String, String>(0);
    HashMap<String, Set<String>> _viewTables = new HashMap<String, Set<String>>(0);
    return new InvalidationTracker(this, _shadowTablesMap, _viewTables, "running_table");
  }

  @Override
  public void clearAllTables() {
    super.assertNotMainThread();
    final SupportSQLiteDatabase _db = super.getOpenHelper().getWritableDatabase();
    try {
      super.beginTransaction();
      _db.execSQL("DELETE FROM `running_table`");
      super.setTransactionSuccessful();
    } finally {
      super.endTransaction();
      _db.query("PRAGMA wal_checkpoint(FULL)").close();
      if (!_db.inTransaction()) {
        _db.execSQL("VACUUM");
      }
    }
  }

  @Override
  public RunDao getRunDao() {
    if (_runDao != null) {
      return _runDao;
    } else {
      synchronized(this) {
        if(_runDao == null) {
          _runDao = new RunDao_Impl(this);
        }
        return _runDao;
      }
    }
  }
}
