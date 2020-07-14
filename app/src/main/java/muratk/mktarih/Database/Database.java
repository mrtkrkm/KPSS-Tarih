package gokhandidin.kpss2018.Database;

import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;

import muratk.mktarih.Models.FirstInHistoryModel;
import muratk.mktarih.Models.QuestionModel;

/**
 * Created by landforce on 09.08.2014.
 */
public class Database extends SQLiteOpenHelper {

    //Path to the device folder with databases
    public static String DB_PATH;

    //Database file name
    public static String DB_NAME;
    public SQLiteDatabase database;
    public final Context context;

    public SQLiteDatabase getDb() {
        return database;
    }

    public Database(Context context, String databaseName) {
        super(context, databaseName, null, 1);
        this.context = context;
        //Write a full path to the databases of your application
        String packageName = context.getPackageName();
        DB_PATH = String.format("//data//data//%s//databases//", packageName);
        DB_NAME = databaseName;
        openDataBase();
    }

    public void createDataBase() {
        boolean dbExist = checkDataBase();
        if (!dbExist) {
            this.getReadableDatabase();
            try {
                copyDataBase();
            } catch (IOException e) {
                Log.e(this.getClass().toString(), "Copying error");
                throw new Error("Error copying database!");
            }
        } else {
            Log.i(this.getClass().toString(), "Database already exists");
        }
    }

    //Performing a database existence check
    private boolean checkDataBase() {
        SQLiteDatabase checkDb = null;
        try {
            String path = DB_PATH + DB_NAME;
            checkDb = SQLiteDatabase.openDatabase(path, null,
                    SQLiteDatabase.OPEN_READONLY);
        } catch (SQLException e) {
            Log.e(this.getClass().toString(), "Error while checking db");
        }
        //Android doesn’t like resource leaks, everything should
        // be closed
        if (checkDb != null) {
            checkDb.close();
        }
        return checkDb != null;
    }

    //Method for copying the database
    private void copyDataBase() throws IOException {
        //Open a stream for reading from our ready-made database
        //The stream source is located in the assets
        InputStream externalDbStream = context.getAssets().open(DB_NAME);

        //Path to the created empty database on your Android device
        String outFileName = DB_PATH + DB_NAME;

        //Now create a stream for writing the database byte by byte
        OutputStream localDbStream = new FileOutputStream(outFileName);

        //Copying the database
        byte[] buffer = new byte[1024];
        int bytesRead;
        while ((bytesRead = externalDbStream.read(buffer)) > 0) {
            localDbStream.write(buffer, 0, bytesRead);
        }
        //Don’t forget to close the streams
        localDbStream.close();
        externalDbStream.close();
    }

    public SQLiteDatabase openDataBase() throws SQLException {
        String path = DB_PATH + DB_NAME;
        if (database == null) {
            createDataBase();
            database = SQLiteDatabase.openDatabase(path, null,
                    SQLiteDatabase.OPEN_READWRITE);
        }
        return database;
    }

    @Override
    public synchronized void close() {
        if (database != null) {
            database.close();
        }
        super.close();
    }
    @Override
    public void onCreate(SQLiteDatabase db) {}

    public ArrayList<QuestionModel> GetAllQuestion() {
        SQLiteDatabase db = this.getReadableDatabase();
        String selectQuery = "SELECT * FROM Sorular Where Ders = 1 ORDER BY RANDOM()";
        Cursor cursor = db.rawQuery(selectQuery, null);

        ArrayList<QuestionModel> question = new ArrayList<QuestionModel>();
        if (cursor.moveToFirst()) {
            do {
                QuestionModel obj = new QuestionModel();
                obj.setQuestionId(cursor.getDouble(0));
                obj.setQuestionLesson(cursor.getDouble(1));
                obj.setQuestionTest(cursor.getDouble(2));
                obj.setQuestionQuestion(cursor.getString(3));
                obj.setQuestionAOption(cursor.getString(4));
                obj.setQuestionBOption(cursor.getString(5));
                obj.setQuestionCOption(cursor.getString(6));
                obj.setQuestionDOption(cursor.getString(7));
                obj.setQuestionAnswer(cursor.getString(8));

                question.add(obj);
            } while (cursor.moveToNext());
        }
        db.close();
        return question;
    }

    public ArrayList<FirstInHistoryModel> GetAllHistory(String subject_no) {
        SQLiteDatabase db = this.getReadableDatabase();
        String selectQuery = "SELECT * FROM Ilkler Where Konu = " + subject_no;
        Cursor cursor = db.rawQuery(selectQuery, null);

        ArrayList<FirstInHistoryModel> history = new ArrayList<FirstInHistoryModel>();
        if (cursor.moveToFirst()) {
            do {
                FirstInHistoryModel obj = new FirstInHistoryModel();
                obj.setSubjectContent(cursor.getString(2));

                history.add(obj);
            } while (cursor.moveToNext());
        }
        db.close();
        return history;
    }

    @Override
    public void onUpgrade(SQLiteDatabase arg0, int arg1, int arg2) {
        // TODO Auto-generated method stub
    }
}